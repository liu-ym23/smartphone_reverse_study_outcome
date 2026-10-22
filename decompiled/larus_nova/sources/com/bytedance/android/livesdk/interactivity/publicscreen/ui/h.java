package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f140246a = null;

    static {
        f140246a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("AnchorPublicScreenConfigDialog", "render messages failed", (Throwable) r100);
    }
}
