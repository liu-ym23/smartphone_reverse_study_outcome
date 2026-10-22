package com.android.server.display.config;

import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class HdrBrightnessData$$ExternalSyntheticLambda3 implements Function {
    public /* synthetic */ HdrBrightnessData$$ExternalSyntheticLambda3() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((SdrHdrRatioPoint) r1).getSdrNits();
    }
}
