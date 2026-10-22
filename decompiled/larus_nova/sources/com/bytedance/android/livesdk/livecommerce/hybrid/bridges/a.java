package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f147841a = null;

    static {
        f147841a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        dm.a.a("ECAnchorFlashUploadImage").b("request error", null);
    }
}
