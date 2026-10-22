package com.android.server.vibrator;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class VibratorManagerService$$ExternalSyntheticLambda2 implements IntFunction {
    public final /* synthetic */ VibrationSettings f$0;

    public /* synthetic */ VibratorManagerService$$ExternalSyntheticLambda2(VibrationSettings r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r2) {
        return this.f$0.getFallbackEffect(r2);
    }
}
