package com.android.server.wm;

import com.android.server.policy.WindowManagerPolicy;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class KeyguardController$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WindowManagerPolicy f$0;

    public /* synthetic */ KeyguardController$$ExternalSyntheticLambda0(WindowManagerPolicy r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.applyKeyguardOcclusionChange();
    }
}
