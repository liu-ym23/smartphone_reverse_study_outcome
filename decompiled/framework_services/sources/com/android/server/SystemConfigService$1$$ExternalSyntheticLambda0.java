package com.android.server;

import android.content.pm.SignedPackage;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SystemConfigService$1$$ExternalSyntheticLambda0 implements Function {
    public /* synthetic */ SystemConfigService$1$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((SignedPackage) r1).getData();
    }
}
