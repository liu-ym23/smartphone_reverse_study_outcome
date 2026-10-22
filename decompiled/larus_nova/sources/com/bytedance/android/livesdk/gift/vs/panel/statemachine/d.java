package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import io.reactivex.functions.Consumer;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f132399a = null;

    static {
        f132399a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        if (r111 == null) goto L8;
        StackTraceElement[] r100 = r111.getStackTrace();
        if (r100 == null) goto L8;
        String r112 = ArraysKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null);
        if (r112 == null) goto L8;
    L9:
        jy0.b.a("login log", r112);
        return;
    L8:
        r112 = "";
        goto L9
    }
}
