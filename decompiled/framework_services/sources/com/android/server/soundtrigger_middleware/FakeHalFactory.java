package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger_middleware.IInjectGlobalEvent;
import android.media.soundtrigger_middleware.ISoundTriggerInjection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class FakeHalFactory implements HalFactory {
    private static final String TAG = "FakeHalFactory";
    private final ISoundTriggerInjection mInjection;

    /* JADX INFO: renamed from: com.android.server.soundtrigger_middleware.FakeHalFactory$1, reason: invalid class name */
    class AnonymousClass1 extends SoundTriggerHw3Compat {
        final /* synthetic */ FakeHalFactory this$0;
        final /* synthetic */ IInjectGlobalEvent val$session;

        public static /* synthetic */ void $r8$lambda$7_iW8BR7Y76K69HAMs1qEYCjPpQ(AnonymousClass1 r0, IInjectGlobalEvent r1) {
            r0.lambda$detach$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$XiGXQfklz4wkG4zCK1MCdXt5aQk(AnonymousClass1 r0, IBinder r1, IInjectGlobalEvent r2) {
            r0.lambda$clientAttached$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$hfjQvh69nqGrUyLzy0LXz8onvuU(AnonymousClass1 r0, IBinder r1) {
            r0.lambda$clientDetached$2(r1);
        }

        AnonymousClass1(FakeHalFactory this$0, IBinder binder, Runnable rebootRunnable, IInjectGlobalEvent r4) {
            this.this$0 = this$0;
            this.val$session = r4;
            super(binder, rebootRunnable);
        }

        @Override // com.android.server.soundtrigger_middleware.SoundTriggerHw3Compat, com.android.server.soundtrigger_middleware.ISoundTriggerHal
        public void detach() {
            Executor r0 = FakeSoundTriggerHal.ExecutorHolder.INJECTION_EXECUTOR;
            final IInjectGlobalEvent r1 = this.val$session;
            r0.execute(new FakeHalFactory$1$$ExternalSyntheticLambda2(this, r1));
        }

        private /* synthetic */ void lambda$detach$0(IInjectGlobalEvent session) {
            FakeHalFactory.m8216$$Nest$fgetmInjection(this.this$0).onFrameworkDetached(session);     // Catch: RemoteException -> L4
            return;
        L5:
            Slog.wtf(FakeHalFactory.TAG, "Unexpected RemoteException from same process");
        }

        @Override // com.android.server.soundtrigger_middleware.SoundTriggerHw3Compat, com.android.server.soundtrigger_middleware.ISoundTriggerHal
        public void clientAttached(final IBinder token) {
            Executor r0 = FakeSoundTriggerHal.ExecutorHolder.INJECTION_EXECUTOR;
            final IInjectGlobalEvent r1 = this.val$session;
            r0.execute(new FakeHalFactory$1$$ExternalSyntheticLambda0(this, token, r1));
        }

        private /* synthetic */ void lambda$clientAttached$1(IBinder token, IInjectGlobalEvent session) {
            FakeHalFactory.m8216$$Nest$fgetmInjection(this.this$0).onClientAttached(token, session);     // Catch: RemoteException -> L4
            return;
        L5:
            Slog.wtf(FakeHalFactory.TAG, "Unexpected RemoteException from same process");
        }

        @Override // com.android.server.soundtrigger_middleware.SoundTriggerHw3Compat, com.android.server.soundtrigger_middleware.ISoundTriggerHal
        public void clientDetached(final IBinder token) {
            FakeSoundTriggerHal.ExecutorHolder.INJECTION_EXECUTOR.execute(new FakeHalFactory$1$$ExternalSyntheticLambda1(this, token));
        }

        private /* synthetic */ void lambda$clientDetached$2(IBinder token) {
            FakeHalFactory.m8216$$Nest$fgetmInjection(this.this$0).onClientDetached(token);     // Catch: RemoteException -> L4
            return;
        L5:
            Slog.wtf(FakeHalFactory.TAG, "Unexpected RemoteException from same process");
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$X-Xdaoaiej_7Pde1ToOSh5jHJj8, reason: not valid java name */
    public static /* synthetic */ void m8215$r8$lambda$XXdaoaiej_7Pde1ToOSh5jHJj8(IInjectGlobalEvent r0) {
        lambda$create$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjection, reason: not valid java name */
    static /* bridge */ /* synthetic */ ISoundTriggerInjection m8216$$Nest$fgetmInjection(FakeHalFactory r0) {
        return r0.mInjection;
    }

    FakeHalFactory(ISoundTriggerInjection injection) {
        this.mInjection = injection;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.IBinder, com.android.server.soundtrigger_middleware.FakeSoundTriggerHal] */
    @Override // com.android.server.soundtrigger_middleware.HalFactory
    public ISoundTriggerHal create() {
        ?? r0 = new FakeSoundTriggerHal(this.mInjection);
        final IInjectGlobalEvent session = r0.getGlobalEventInjection();
        ISoundTriggerHal wrapper = new AnonymousClass1(this, r0, new FakeHalFactory$$ExternalSyntheticLambda0(session), session);
        return wrapper;
    }

    private static /* synthetic */ void lambda$create$0(IInjectGlobalEvent session) {
        session.triggerRestart();     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.wtf(TAG, "Unexpected RemoteException from same process");
    }
}
