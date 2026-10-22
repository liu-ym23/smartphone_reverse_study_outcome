package com.bytedance.android.annie.bridge.method;

import com.bytedance.pia.core.api.bridge.PiaMethod;

/* JADX INFO: loaded from: classes43.dex */
public final class f1<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f38654a;

    public f1(g1 r100) {
        this.f38654a = r100;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        g1 r101 = this.f38654a;
        r101.finishWithFailure((PiaMethod.Error) r100);
    }
}
