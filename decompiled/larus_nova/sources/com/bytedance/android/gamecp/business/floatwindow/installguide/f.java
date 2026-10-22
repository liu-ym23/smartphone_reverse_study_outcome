package com.bytedance.android.gamecp.business.floatwindow.installguide;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f53204a = null;

    static {
        f53204a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("AnchorFloatBallTask", "fetchAnchorFloatBallData error: " + ((Throwable) r100).getMessage());
    }
}
