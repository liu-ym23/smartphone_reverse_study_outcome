package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f54655a = null;

    static {
        f54655a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = ((Throwable) r100).getMessage();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        yr.c.b("DetailLynxLoadEvent", r101);
    }
}
