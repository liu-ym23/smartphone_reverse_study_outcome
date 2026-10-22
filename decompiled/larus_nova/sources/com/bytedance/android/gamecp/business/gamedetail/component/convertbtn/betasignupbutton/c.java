package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f54096a = null;

    static {
        f54096a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("NewBetaApplySignUpEffect", String.valueOf(((Throwable) r100).getMessage()));
    }
}
