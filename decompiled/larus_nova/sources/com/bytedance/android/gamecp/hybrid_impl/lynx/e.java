package com.bytedance.android.gamecp.hybrid_impl.lynx;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jw.b f57601a;

    public e(jw.b r100) {
        this.f57601a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        AnnieXManager.b();
    L5:
        jw.b r101 = this.f57601a;
        if (r101 == null) goto L9;
        r101.a(true, "init success");
        return;
    }
}
