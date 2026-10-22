package com.bytedance.android.livesdk.ktvimpl.chorus;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f143699a = null;

    static {
        f143699a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a.a("ChorusWidget", "closeChorus failed " + ((Throwable) r100).getMessage());
    }
}
