package com.android.server.hdmi;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class HdmiControlService$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ HdmiControlService f$0;

    public /* synthetic */ HdmiControlService$$ExternalSyntheticLambda2(HdmiControlService r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.checkAndUpdateAbsoluteVolumeBehavior();
    }
}
