package com.bytedance.android.livesdk.interactivity.utils;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f141366a = null;

    static {
        f141366a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        StringBuilder r102 = new StringBuilder("messageCnt=");
        e r103 = e.f141372f;
        r102.append(e.f141367a);
        r102.append(" danmakuCnt=");
        r102.append(e.f141368b);
        r102.append(' ');
        r103.getClass();
        Function0<String> r104 = e.f141370d;
        String r105 = "";
        if (r104 == null) goto L6;
        String r106 = r104.invoke();
        if (r106 == null) goto L6;
    L7:
        r102.append(r106);
        r102.append(' ');
        Function0<String> r107 = e.f141371e;
        if (r107 == null) goto L13;
        String r108 = r107.invoke();
        if (r108 == null) goto L13;
        r105 = r108;
    L13:
        r102.append(r105);
        o22.b.a(r102.toString());
        e.f141367a = 0;
        e.f141368b = 0;
        return;
    L6:
        r106 = "";
        goto L7
    }
}
