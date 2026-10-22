package com.android.server.wm;

import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AppCompatReachabilityOverrides$$ExternalSyntheticLambda0 implements Function {
    public /* synthetic */ AppCompatReachabilityOverrides$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((ActivityRecord) r1).getScreenResolvedBounds();
    }
}
