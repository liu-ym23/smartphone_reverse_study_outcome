package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements et3.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f184873a;

    public d(Function1 r100) {
        this.f184873a = r100;
    }

    @Override // et3.c.d
    public final void fpsCallBack(double r100) {
        this.f184873a.invoke(Double.valueOf(r100));
    }
}
