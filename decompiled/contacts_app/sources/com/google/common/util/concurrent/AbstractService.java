package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Callback<Service.Listener> RUNNING_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> STARTING_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_RUNNING_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_STARTING_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_NEW_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_RUNNING_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_STOPPING_CALLBACK = null;
    private final Monitor.Guard hasReachedRunning;
    private final Monitor.Guard isStartable;
    private final Monitor.Guard isStoppable;
    private final Monitor.Guard isStopped;
    private final List<ListenerCallQueue<Service.Listener>> listeners;
    private final Monitor monitor;
    private volatile StateSnapshot snapshot;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractService$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State = null;

        static {
            int[] r0 = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = r0;
            r0[Service.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STOPPING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final class StateSnapshot {

        @Nullable
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        StateSnapshot(Service.State r3) {
            this(r3, false, null);
        }

        StateSnapshot(Service.State r6, boolean r7, @Nullable Throwable r8) {
            if (r7 == true) goto L5;
        L8:
            boolean r2 = true;
        L9:
            Preconditions.checkArgument(r2, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[]{r6});
            if (r8 == null) goto L12;
            boolean r3 = true;
        L14:
            if (r6 != Service.State.FAILED) goto L16;
            boolean r4 = true;
        L17:
            Preconditions.checkArgument(!(r3 ^ r4), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[]{r6, r8});
            this.state = r6;
            this.shutdownWhenStartupFinishes = r7;
            this.failure = r8;
            return;
        L16:
            r4 = false;
            goto L17
        L12:
            r3 = false;
            goto L14
        L5:
            if (r6 == Service.State.STARTING) goto L8;
            r2 = false;
            goto L9
        }

        Service.State externalState() {
            if (this.shutdownWhenStartupFinishes == false) goto L9;
            if (this.state != Service.State.STARTING) goto L9;
            return Service.State.STOPPING;
        L9:
            return this.state;
        }

        Throwable failureCause() {
            if (this.state != Service.State.FAILED) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "failureCause() is only valid if the service has failed, service is %s", new Object[]{this.state});
            return this.failure;
        L5:
            r0 = false;
            goto L6
        }
    }

    protected abstract void doStart();

    protected abstract void doStop();

    static {
        final String r1 = "starting()";
        STARTING_CALLBACK = new AnonymousClass1(r1);
        final String r2 = "running()";
        RUNNING_CALLBACK = new AnonymousClass2(r2);
        STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service.State.STARTING);
        STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service.State.RUNNING);
        TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service.State.NEW);
        TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service.State.RUNNING);
        TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service.State.STOPPING);
    }

    private static ListenerCallQueue.Callback<Service.Listener> terminatedCallback(final Service.State r3) {
        final String r1 = "terminated({from = " + r3 + "})";
        return new AnonymousClass3(r1, r3);
    }

    private static ListenerCallQueue.Callback<Service.Listener> stoppingCallback(final Service.State r3) {
        final String r1 = "stopping({from = " + r3 + "})";
        return new AnonymousClass4(r1, r3);
    }

    protected AbstractService() {
        final Monitor r0 = new Monitor();
        this.monitor = r0;
        this.isStartable = new AnonymousClass5(this, r0);
        this.isStoppable = new AnonymousClass6(this, r0);
        this.hasReachedRunning = new AnonymousClass7(this, r0);
        this.isStopped = new AnonymousClass8(this, r0);
        this.listeners = Collections.synchronizedList(new ArrayList());
        this.snapshot = new StateSnapshot(Service.State.NEW);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable) == false) goto L14;
        this.snapshot = new StateSnapshot(Service.State.STARTING);     // Catch: Throwable -> L6
        starting();     // Catch: Throwable -> L6
        doStart();     // Catch: Throwable -> L6
    L8:
        this.monitor.leave();
        executeListeners();
        return this;
    L6:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.monitor.leave();
        executeListeners();
        throw th;
    L14:
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable) == true) goto L23;
    L20:
        return this;
    L23:
        Service.State r2 = state();     // Catch: Throwable -> L14
        switch(AnonymousClass10.$SwitchMap$com$google$common$util$concurrent$Service$State[r2.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L13;
        };     // Catch: Throwable -> L14
    L9:
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L14
        stopping(Service.State.RUNNING);     // Catch: Throwable -> L14
        doStop();     // Catch: Throwable -> L14
    L16:
        this.monitor.leave();
        executeListeners();
        goto L20
    L10:
        this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);     // Catch: Throwable -> L14
        stopping(Service.State.STARTING);     // Catch: Throwable -> L14
        goto L16
    L11:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L14
        terminated(Service.State.NEW);     // Catch: Throwable -> L14
        goto L16
    L13:
        throw new AssertionError("Unexpected state: " + r2);     // Catch: Throwable -> L14
    L8:
        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + r2);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.monitor.leave();
        executeListeners();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r3, TimeUnit r5) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, r3, r5) == false) goto L11;
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L11:
        throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state. Current state: " + state());
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L6
        this.monitor.leave();
        return;
    L6:
        th = move-exception;
        this.monitor.leave();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r3, TimeUnit r5) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, r3, r5) == false) goto L11;
        checkCurrentState(Service.State.TERMINATED);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L11:
        throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
    }

    private void checkCurrentState(Service.State r4) {
        Service.State r0 = state();
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 != Service.State.FAILED) goto L9;
        throw new IllegalStateException("Expected the service to be " + r4 + ", but the service has FAILED", failureCause());
    L9:
        throw new IllegalStateException("Expected the service to be " + r4 + ", but was " + r0);
    }

    protected final void notifyStarted() {
        this.monitor.enter();
    L13:
        th = move-exception;
        this.monitor.leave();
        executeListeners();
        throw th;
    L4:
        if (this.snapshot.state == Service.State.STARTING) goto L6;
        IllegalStateException r1 = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);     // Catch: Throwable -> L13
        notifyFailed(r1);     // Catch: Throwable -> L13
        throw r1;     // Catch: Throwable -> L13
    L6:
        if (this.snapshot.shutdownWhenStartupFinishes == false) goto L8;
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L13
        doStop();     // Catch: Throwable -> L13
    L9:
        this.monitor.leave();
        executeListeners();
        return;
    L8:
        this.snapshot = new StateSnapshot(Service.State.RUNNING);     // Catch: Throwable -> L13
        running();     // Catch: Throwable -> L13
        goto L9
    }

    protected final void notifyStopped() {
        this.monitor.enter();
        Service.State r1 = this.snapshot.state;     // Catch: Throwable -> L13
        if (r1 != Service.State.STOPPING) goto L6;
    L10:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L13
        terminated(r1);     // Catch: Throwable -> L13
        this.monitor.leave();
        executeListeners();
        return;
    L6:
        if (r1 == Service.State.RUNNING) goto L10;
        IllegalStateException r2 = new IllegalStateException("Cannot notifyStopped() when the service is " + r1);     // Catch: Throwable -> L13
        notifyFailed(r2);     // Catch: Throwable -> L13
        throw r2;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.monitor.leave();
        executeListeners();
        throw th;
    }

    protected final void notifyFailed(Throwable r6) {
        Preconditions.checkNotNull(r6);
        this.monitor.enter();
        Service.State r2 = state();     // Catch: Throwable -> L13
        switch(AnonymousClass10.$SwitchMap$com$google$common$util$concurrent$Service$State[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L10;
            case 6: goto L7;
            default: goto L12;
        };     // Catch: Throwable -> L13
    L6:
        this.snapshot = new StateSnapshot(Service.State.FAILED, false, r6);     // Catch: Throwable -> L13
        failed(r2, r6);     // Catch: Throwable -> L13
    L7:
        this.monitor.leave();
        executeListeners();
        return;
    L12:
        throw new AssertionError("Unexpected state: " + r2);     // Catch: Throwable -> L13
    L10:
        throw new IllegalStateException("Failed while in state:" + r2, r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.monitor.leave();
        executeListeners();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() != Service.State.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r3, Executor r4) {
        Preconditions.checkNotNull(r3, "listener");
        Preconditions.checkNotNull(r4, "executor");
        this.monitor.enter();
    L8:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L4:
        if (state().isTerminal() == true) goto L6;
        this.listeners.add(new ListenerCallQueue(r3, r4));     // Catch: Throwable -> L8
    L6:
        this.monitor.leave();
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    private void executeListeners() {
        if (this.monitor.isOccupiedByCurrentThread() == true) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.listeners.size()) goto L10;
        this.listeners.get(r0).execute();
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    private void starting() {
        STARTING_CALLBACK.enqueueOn(this.listeners);
    }

    private void running() {
        RUNNING_CALLBACK.enqueueOn(this.listeners);
    }

    private void stopping(Service.State r2) {
        if (r2 != Service.State.STARTING) goto L6;
        STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
        return;
    L6:
        if (r2 != Service.State.RUNNING) goto L10;
        STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
        return;
    L10:
        throw new AssertionError();
    }

    private void terminated(Service.State r2) {
        int r3 = AnonymousClass10.$SwitchMap$com$google$common$util$concurrent$Service$State[r2.ordinal()];
        if (r3 != 1) goto L5;
        TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
        return;
    L5:
        if (r3 != 3) goto L7;
        TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
        return;
    L7:
        if (r3 != 4) goto L10;
        TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
        return;
    L10:
        throw new AssertionError();
    }

    private void failed(final Service.State r4, final Throwable r5) {
        final String r1 = "failed({from = " + r4 + ", cause = " + r5 + "})";
        new AnonymousClass9(this, r1, r4, r5).enqueueOn(this.listeners);
    }
}
