package com.android.server.location.provider;

import android.location.LocationResult;
import android.location.provider.ProviderProperties;
import android.location.provider.ProviderRequest;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.Bundle;
import com.android.internal.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractLocationProvider {
    private final LocationProviderController mController;
    protected final Executor mExecutor;
    private final AtomicReference<InternalState> mInternalState;

    private class Controller implements LocationProviderController {
        private boolean mStarted;
        final /* synthetic */ AbstractLocationProvider this$0;

        /* JADX INFO: renamed from: $r8$lambda$F9dA1JzrQGUlNPuOmx3DHTxJe-k, reason: not valid java name */
        public static /* synthetic */ void m5386$r8$lambda$F9dA1JzrQGUlNPuOmx3DHTxJek(Controller r0, int r1, int r2, String r3, Bundle r4) {
            r0.lambda$sendExtraCommand$3(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$LeNcBraXlYCSFuemITl6ZhAWq-s, reason: not valid java name */
        public static /* synthetic */ void m5387$r8$lambda$LeNcBraXlYCSFuemITl6ZhAWqs(Controller r0, ProviderRequest r1) {
            r0.lambda$setRequest$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$POFKf6U6XI6kGnKlqRrlOHg84-g, reason: not valid java name */
        public static /* synthetic */ void m5388$r8$lambda$POFKf6U6XI6kGnKlqRrlOHg84g(Controller r0, Runnable r1) {
            r0.lambda$flush$2(r1);
        }

        public static /* synthetic */ InternalState $r8$lambda$ymAsNas0LO3WeFO8o8yVE4_uJQA(Listener r0, InternalState r1) {
            return lambda$setListener$0(r0, r1);
        }

        Controller(AbstractLocationProvider r1) {
            this.this$0 = r1;
            this.mStarted = false;
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public State setListener(final Listener listener) {
            InternalState oldInternalState = (InternalState) AbstractLocationProvider.m5385$$Nest$fgetmInternalState(this.this$0).getAndUpdate(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda5(listener));
            if (listener != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            Preconditions.checkState(r1);
            return oldInternalState.state;
        L5:
            if (oldInternalState.listener == null) goto L8;
            r1 = false;
            goto L9
        }

        private static /* synthetic */ InternalState lambda$setListener$0(Listener listener, InternalState internalState) {
            return internalState.withListener(listener);
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public boolean isStarted() {
            return this.mStarted;
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public void start() {
            Preconditions.checkState(!this.mStarted);
            this.mStarted = true;
            Executor r0 = this.this$0.mExecutor;
            final AbstractLocationProvider r1 = this.this$0;
            r0.execute(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda1(r1));
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public void stop() {
            Preconditions.checkState(this.mStarted);
            this.mStarted = false;
            Executor r0 = this.this$0.mExecutor;
            final AbstractLocationProvider r1 = this.this$0;
            r0.execute(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda3(r1));
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public void setRequest(final ProviderRequest request) {
            Preconditions.checkState(this.mStarted);
            this.this$0.mExecutor.execute(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda2(this, request));
        }

        private /* synthetic */ void lambda$setRequest$1(ProviderRequest request) {
            this.this$0.onSetRequest(request);
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public void flush(final Runnable listener) {
            Preconditions.checkState(this.mStarted);
            this.this$0.mExecutor.execute(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda0(this, listener));
        }

        private /* synthetic */ void lambda$flush$2(Runnable listener) {
            this.this$0.onFlush(listener);
        }

        @Override // com.android.server.location.provider.LocationProviderController
        public void sendExtraCommand(final int uid, final int pid, final String command, final Bundle extras) {
            Preconditions.checkState(this.mStarted);
            this.this$0.mExecutor.execute(new AbstractLocationProvider$Controller$$ExternalSyntheticLambda4(this, uid, pid, command, extras));
        }

        private /* synthetic */ void lambda$sendExtraCommand$3(int uid, int pid, String command, Bundle extras) {
            this.this$0.onExtraCommand(uid, pid, command, extras);
        }
    }

    private static class InternalState {
        public final Listener listener;
        public final State state;

        InternalState(Listener listener, State state) {
            this.listener = listener;
            this.state = state;
        }

        InternalState withListener(Listener listener) {
            if (listener != this.listener) goto L6;
            return this;
        L6:
            return new InternalState(listener, this.state);
        }

        InternalState withState(State state) {
            if (state.equals(this.state) == false) goto L6;
            return this;
        L6:
            return new InternalState(this.listener, state);
        }

        InternalState withState(UnaryOperator<State> operator) {
            return withState((State) operator.apply(this.state));
        }
    }

    public interface Listener {
        void onReportLocation(LocationResult r1);

        void onStateChanged(State r1, State r2);
    }

    public static final class State {
        public static final State EMPTY_STATE = null;
        public final boolean allowed;
        public final Set<String> extraAttributionTags;
        public final CallerIdentity identity;
        public final ProviderProperties properties;

        static {
            EMPTY_STATE = new State(false, null, null, Collections.emptySet());
        }

        private State(boolean allowed, ProviderProperties properties, CallerIdentity identity, Set<String> extraAttributionTags) {
            this.allowed = allowed;
            this.properties = properties;
            this.identity = identity;
            extraAttributionTags.getClass();
            this.extraAttributionTags = extraAttributionTags;
        }

        public State withAllowed(boolean allowed) {
            if (allowed != this.allowed) goto L6;
            return this;
        L6:
            return new State(allowed, this.properties, this.identity, this.extraAttributionTags);
        }

        public State withProperties(ProviderProperties properties) {
            if (Objects.equals(properties, this.properties) == false) goto L6;
            return this;
        L6:
            return new State(this.allowed, properties, this.identity, this.extraAttributionTags);
        }

        public State withIdentity(CallerIdentity identity) {
            if (Objects.equals(identity, this.identity) == false) goto L6;
            return this;
        L6:
            return new State(this.allowed, this.properties, identity, this.extraAttributionTags);
        }

        public State withExtraAttributionTags(Set<String> extraAttributionTags) {
            if (extraAttributionTags.equals(this.extraAttributionTags) == false) goto L6;
            return this;
        L6:
            return new State(this.allowed, this.properties, this.identity, extraAttributionTags);
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof State) == true) goto L8;
            return false;
        L8:
            State state = (State) o;
            if (this.allowed != state.allowed) goto L18;
            if (this.properties != state.properties) goto L18;
            if (Objects.equals(this.identity, state.identity) == false) goto L18;
            if (this.extraAttributionTags.equals(state.extraAttributionTags) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.allowed), this.properties, this.identity, this.extraAttributionTags});
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-8Y2ueq1QRG1OIZJhhuqNfa4F3g, reason: not valid java name */
    public static /* synthetic */ State m5383$r8$lambda$8Y2ueq1QRG1OIZJhhuqNfa4F3g(CallerIdentity r0, State r1) {
        return lambda$setIdentity$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$3fK9Uk1KG1-U2UOsBK3sui0xUQs, reason: not valid java name */
    public static /* synthetic */ State m5384$r8$lambda$3fK9Uk1KG1U2UOsBK3sui0xUQs(Set r0, State r1) {
        return lambda$setExtraAttributionTags$4(r0, r1);
    }

    public static /* synthetic */ InternalState $r8$lambda$CeuvNTBi50NGKIcNe9haAXCHlUo(AtomicReference r0, UnaryOperator r1, InternalState r2) {
        return lambda$setState$0(r0, r1, r2);
    }

    public static /* synthetic */ State $r8$lambda$FB2CxvzMg7jhWqN8Car2RHjBkcQ(ProviderProperties r0, State r1) {
        return lambda$setProperties$2(r0, r1);
    }

    public static /* synthetic */ State $r8$lambda$xmpiQinuk56UCsTwnnQ2qoBXpWE(boolean r0, State r1) {
        return lambda$setAllowed$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInternalState, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicReference m5385$$Nest$fgetmInternalState(AbstractLocationProvider r0) {
        return r0.mInternalState;
    }

    protected abstract void dump(FileDescriptor r1, PrintWriter r2, String[] r3);

    protected abstract void onExtraCommand(int r1, int r2, String r3, Bundle r4);

    protected abstract void onFlush(Runnable r1);

    protected abstract void onSetRequest(ProviderRequest r1);

    protected AbstractLocationProvider(Executor executor, CallerIdentity identity, ProviderProperties properties, Set<String> extraAttributionTags) {
        if (identity != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0);
        executor.getClass();
        this.mExecutor = executor;
        this.mInternalState = new AtomicReference(new InternalState(null, State.EMPTY_STATE.withIdentity(identity).withProperties(properties).withExtraAttributionTags(extraAttributionTags)));
        this.mController = new Controller(this);
        return;
    L5:
        if (identity.getListenerId() == null) goto L8;
        r0 = false;
        goto L9
    }

    LocationProviderController getController() {
        return this.mController;
    }

    protected void setState(final UnaryOperator<State> operator) {
        final AtomicReference<State> oldStateRef = new AtomicReference();
        InternalState newInternalState = this.mInternalState.updateAndGet(new AbstractLocationProvider$$ExternalSyntheticLambda4(oldStateRef, operator));
        State oldState = oldStateRef.get();
        if (oldState.equals(newInternalState.state) == false) goto L6;
        return;
    L6:
        if (newInternalState.listener == null) goto L13;
        long identity = Binder.clearCallingIdentity();
        newInternalState.listener.onStateChanged(oldState, newInternalState.state);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ InternalState lambda$setState$0(AtomicReference oldStateRef, UnaryOperator operator, InternalState internalState) {
        oldStateRef.set(internalState.state);
        return internalState.withState(operator);
    }

    public final State getState() {
        return this.mInternalState.get().state;
    }

    private static /* synthetic */ State lambda$setAllowed$1(boolean allowed, State state) {
        return state.withAllowed(allowed);
    }

    protected void setAllowed(final boolean allowed) {
        setState(new AbstractLocationProvider$$ExternalSyntheticLambda1(allowed));
    }

    private static /* synthetic */ State lambda$setProperties$2(ProviderProperties properties, State state) {
        return state.withProperties(properties);
    }

    protected void setProperties(final ProviderProperties properties) {
        setState(new AbstractLocationProvider$$ExternalSyntheticLambda3(properties));
    }

    protected void setIdentity(final CallerIdentity identity) {
        if (identity != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Preconditions.checkArgument(r0);
        setState(new AbstractLocationProvider$$ExternalSyntheticLambda2(identity));
        return;
    L4:
        if (identity.getListenerId() == null) goto L7;
        r0 = false;
        goto L8
    }

    private static /* synthetic */ State lambda$setIdentity$3(CallerIdentity identity, State state) {
        return state.withIdentity(identity);
    }

    public final Set<String> getExtraAttributionTags() {
        return this.mInternalState.get().state.extraAttributionTags;
    }

    private static /* synthetic */ State lambda$setExtraAttributionTags$4(Set extraAttributionTags, State state) {
        return state.withExtraAttributionTags(extraAttributionTags);
    }

    protected void setExtraAttributionTags(final Set<String> extraAttributionTags) {
        setState(new AbstractLocationProvider$$ExternalSyntheticLambda0(extraAttributionTags));
    }

    protected void reportLocation(LocationResult locationResult) {
        Listener listener = this.mInternalState.get().listener;
        if (listener == null) goto L10;
        long identity = Binder.clearCallingIdentity();
        locationResult.getClass();     // Catch: Throwable -> L7
        listener.onReportLocation(locationResult);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(identity);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    protected void onStart() {
    }

    protected void onStop() {
    }
}
