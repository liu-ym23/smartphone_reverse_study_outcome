package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = null;
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = null;
    private final Monitor.Guard hasReachedRunning;
    private final Monitor.Guard isStartable;
    private final Monitor.Guard isStoppable;
    private final Monitor.Guard isStopped;
    private final ListenerCallQueue<Service.Listener> listeners;
    private final Monitor monitor;
    private volatile StateSnapshot snapshot;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractService$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State = null;

        static {
            int[] r10 = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = r10;
            r10[Service.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
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

    public final class HasReachedRunningGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        public HasReachedRunningGuard(AbstractService r10) {
            this.this$0 = r10;
            super(AbstractService.access$000(r10));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final class IsStartableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        public IsStartableGuard(AbstractService r10) {
            this.this$0 = r10;
            super(AbstractService.access$000(r10));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state() != Service.State.NEW) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final class IsStoppableGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        public IsStoppableGuard(AbstractService r10) {
            this.this$0 = r10;
            super(AbstractService.access$000(r10));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            if (this.this$0.state().compareTo(Service.State.RUNNING) > 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final class IsStoppedGuard extends Monitor.Guard {
        final /* synthetic */ AbstractService this$0;

        public IsStoppedGuard(AbstractService r10) {
            this.this$0 = r10;
            super(AbstractService.access$000(r10));
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return this.this$0.state().isTerminal();
        }
    }

    public static final class StateSnapshot {

        @NullableDecl
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        public StateSnapshot(Service.State r10) {
            this(r10, false, null);
        }

        public Service.State externalState() {
            if (this.shutdownWhenStartupFinishes == false) goto L9;
            if (this.state != Service.State.STARTING) goto L9;
            return Service.State.STOPPING;
        L9:
            return this.state;
        }

        public Throwable failureCause() {
            Service.State r10 = this.state;
            if (r10 != Service.State.FAILED) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11, "failureCause() is only valid if the service has failed, service is %s", r10);
            return this.failure;
        L5:
            r11 = false;
            goto L6
        }

        public StateSnapshot(Service.State r10, boolean r11, @NullableDecl Throwable r12) {
            boolean r13 = false;
            if (r11 == true) goto L5;
        L8:
            boolean r14 = true;
        L9:
            Preconditions.checkArgument(r14, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", r10);
            if (r12 == null) goto L12;
            boolean r15 = true;
        L14:
            if (r10 != Service.State.FAILED) goto L16;
            r13 = true;
        L16:
            Preconditions.checkArgument(!(r13 ^ r15), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", r10, r12);
            this.state = r10;
            this.shutdownWhenStartupFinishes = r11;
            this.failure = r12;
            return;
        L12:
            r15 = false;
            goto L14
        L5:
            if (r10 == Service.State.STARTING) goto L8;
            r14 = false;
            goto L9
        }
    }

    static {
        STARTING_EVENT = new AnonymousClass1();
        RUNNING_EVENT = new AnonymousClass2();
        Service.State r10 = Service.State.STARTING;
        STOPPING_FROM_STARTING_EVENT = stoppingEvent(r10);
        Service.State r11 = Service.State.RUNNING;
        STOPPING_FROM_RUNNING_EVENT = stoppingEvent(r11);
        TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
        TERMINATED_FROM_STARTING_EVENT = terminatedEvent(r10);
        TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(r11);
        TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    }

    public AbstractService() {
        this.monitor = new Monitor();
        this.isStartable = new IsStartableGuard(this);
        this.isStoppable = new IsStoppableGuard(this);
        this.hasReachedRunning = new HasReachedRunningGuard(this);
        this.isStopped = new IsStoppedGuard(this);
        this.listeners = new ListenerCallQueue();
        this.snapshot = new StateSnapshot(Service.State.NEW);
    }

    public static /* synthetic */ Monitor access$000(AbstractService r10) {
        return r10.monitor;
    }

    @GuardedBy("monitor")
    private void checkCurrentState(Service.State r10) {
        Service.State r11 = state();
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 != Service.State.FAILED) goto L9;
        throw new IllegalStateException("Expected the service " + this + " to be " + r10 + ", but the service has FAILED", failureCause());
    L9:
        throw new IllegalStateException("Expected the service " + this + " to be " + r10 + ", but was " + r11);
    }

    private void dispatchListenerEvents() {
        if (this.monitor.isOccupiedByCurrentThread() == true) goto L6;
        this.listeners.dispatch();
        return;
    }

    private void enqueueFailedEvent(final Service.State r10, final Throwable r11) {
        this.listeners.enqueue(new AnonymousClass5(this, r10, r11));
    }

    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    private void enqueueStoppingEvent(Service.State r10) {
        if (r10 != Service.State.STARTING) goto L6;
        this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        return;
    L6:
        if (r10 != Service.State.RUNNING) goto L10;
        this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
        return;
    L10:
        throw new AssertionError();
    }

    private void enqueueTerminatedEvent(Service.State r10) {
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r10.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L15;
        };
    L7:
        this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
        return;
    L8:
        this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
        return;
    L9:
        this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
        return;
    L10:
        this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
        return;
    L15:
        return;
    L6:
        throw new AssertionError();
    }

    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State r10) {
        return new AnonymousClass4(r10);
    }

    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State r10) {
        return new AnonymousClass3(r10);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r10, Executor r11) {
        this.listeners.addListener(r10, r11);
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

    @ForOverride
    public void doCancelStart() {
    }

    @ForOverride
    public abstract void doStart();

    @ForOverride
    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() != Service.State.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void notifyFailed(Throwable r10) {
        Preconditions.checkNotNull(r10);
        this.monitor.enter();
        Service.State r11 = state();     // Catch: Throwable -> L17
        int r12 = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r11.ordinal()];     // Catch: Throwable -> L17
        if (r12 == 1) goto L20;
        if (r12 != 2) goto L8;
    L14:
        this.snapshot = new StateSnapshot(Service.State.FAILED, false, r10);     // Catch: Throwable -> L17
        enqueueFailedEvent(r11, r10);     // Catch: Throwable -> L17
    L15:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L8:
        if (r12 == 3) goto L14;
        if (r12 == 4) goto L14;
        if (r12 != 5) goto L15;
    L20:
        throw new IllegalStateException("Failed while in state:" + r11, r10);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    public final void notifyStarted() {
        this.monitor.enter();
    L8:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    L4:
        if (this.snapshot.state == Service.State.STARTING) goto L6;
        IllegalStateException r10 = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);     // Catch: Throwable -> L8
        notifyFailed(r10);     // Catch: Throwable -> L8
        throw r10;     // Catch: Throwable -> L8
    L6:
        if (this.snapshot.shutdownWhenStartupFinishes == false) goto L10;
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L8
        doStop();     // Catch: Throwable -> L8
    L11:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L10:
        this.snapshot = new StateSnapshot(Service.State.RUNNING);     // Catch: Throwable -> L8
        enqueueRunningEvent();     // Catch: Throwable -> L8
        goto L11
    }

    public final void notifyStopped() {
        this.monitor.enter();
        Service.State r10 = state();     // Catch: Throwable -> L9
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L12;
            case 6: goto L12;
            default: goto L7;
        };     // Catch: Throwable -> L9
    L6:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L9
        enqueueTerminatedEvent(r10);     // Catch: Throwable -> L9
    L7:
        this.monitor.leave();
        dispatchListenerEvents();
        return;
    L12:
        throw new IllegalStateException("Cannot notifyStopped() when the service is " + r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable) == false) goto L14;
        this.snapshot = new StateSnapshot(Service.State.STARTING);     // Catch: Throwable -> L6
        enqueueStartingEvent();     // Catch: Throwable -> L6
        doStart();     // Catch: Throwable -> L6
    L5:
        this.monitor.leave();
        dispatchListenerEvents();
        return this;
    L6:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    L14:
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.externalState();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable) == true) goto L21;
    L20:
        return this;
    L21:
        Service.State r10 = state();     // Catch: Throwable -> L9
        switch(AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[r10.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L14;
        };     // Catch: Throwable -> L9
    L11:
        this.snapshot = new StateSnapshot(Service.State.STOPPING);     // Catch: Throwable -> L9
        enqueueStoppingEvent(Service.State.RUNNING);     // Catch: Throwable -> L9
        doStop();     // Catch: Throwable -> L9
        goto L14
    L12:
        Service.State r11 = Service.State.STARTING;     // Catch: Throwable -> L9
        this.snapshot = new StateSnapshot(r11, true, null);     // Catch: Throwable -> L9
        enqueueStoppingEvent(r11);     // Catch: Throwable -> L9
        doCancelStart();     // Catch: Throwable -> L9
        goto L14
    L13:
        this.snapshot = new StateSnapshot(Service.State.TERMINATED);     // Catch: Throwable -> L9
        enqueueTerminatedEvent(Service.State.NEW);     // Catch: Throwable -> L9
    L14:
        this.monitor.leave();
        dispatchListenerEvents();
        goto L20
    L8:
        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        notifyFailed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.monitor.leave();
        dispatchListenerEvents();
        throw th;
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r10, TimeUnit r11) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, r10, r11) == false) goto L11;
        checkCurrentState(Service.State.RUNNING);     // Catch: Throwable -> L7
        this.monitor.leave();
        return;
    L7:
        th = move-exception;
        this.monitor.leave();
        throw th;
    L11:
        throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r10, TimeUnit r11) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, r10, r11) == false) goto L11;
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
}
