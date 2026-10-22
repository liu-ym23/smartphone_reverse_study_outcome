package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f141804a = null;

    static {
        f141804a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        i.d("prefetch simple setting failed");
    }
}
