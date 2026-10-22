package com.bytedance.android.gamecp.live_impl.card;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f57887a = null;

    static {
        f57887a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LocalTestManager.a(new Class[]{uv.a.class});
    }
}
