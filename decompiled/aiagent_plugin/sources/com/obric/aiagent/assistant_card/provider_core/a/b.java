package com.obric.aiagent.assistant_card.provider_core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CardLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f16334b;

    static {
        f16333a = new b();
    }

    private b() {
    }

    public final void a(f r2) {
        f r1 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
        o.e(r1, "logger");
        f16334b = r1;
    }

    public final void a(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "msg");
        f r2 = f16334b;
        if (r2 == null) goto L6;
        r2.i("card_" + r3, r4);
        return;
    }

    public final void b(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "msg");
        f r2 = f16334b;
        if (r2 == null) goto L6;
        r2.w("card_" + r3, r4);
        return;
    }

    public final void a(String r3, String r4, Throwable r5) {
        o.e(r3, "tag");
        o.e(r4, "msg");
        o.e(r5, "throwable");
        f r2 = f16334b;
        if (r2 == null) goto L6;
        r2.w("card_" + r3, r4, r5);
        return;
    }
}
