package com.android.server.soundtrigger_middleware;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ISoundTriggerHal.GlobalCallback f$0;

    public /* synthetic */ SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda0(ISoundTriggerHal.GlobalCallback r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.onResourcesAvailable();
    }
}
