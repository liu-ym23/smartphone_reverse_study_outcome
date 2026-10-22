package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f141803a = null;

    static {
        f141803a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        i.d("prefetch simple setting success");
    }
}
