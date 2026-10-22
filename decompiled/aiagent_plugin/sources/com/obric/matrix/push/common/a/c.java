package com.obric.matrix.push.common.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "MATRIX_PUSH";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f33756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f33757d = null;

    private static final String d(String r0) {
        return TAG;
    }

    private c() {
    }

    static {
        f33754a = new c();
        f33755b = true;
        f33757d = (b) ZeusTransformUtils.preCheckCast(new a(), b.class, "com.obric.aiagent.plugin");
    }

    public static final void a(String r1) {
        o.e(r1, "msg");
        a("", r1);
    }

    public static final void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        String r0 = d(r1);
        String r3 = c(r1, r2);
        if (f33755b == false) goto L5;
        f33757d.a(r0, r3);
    L5:
        b r4 = f33756c;
        if (r4 == null) goto L9;
        r4.a(r0, r3);
        return;
    }

    public static final void b(String r1) {
        o.e(r1, "msg");
        b("", r1);
    }

    public static final void b(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        String r0 = d(r1);
        String r3 = c(r1, r2);
        if (f33755b == false) goto L5;
        f33757d.c(r0, r3);
    L5:
        b r4 = f33756c;
        if (r4 == null) goto L9;
        r4.c(r0, r3);
        return;
    }

    public static final void c(String r3) {
        o.e(r3, "msg");
        a("", r3, null, 4, null);
    }

    public static /* synthetic */ void a(String r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        a(r0, r1, r2);
    }

    public static final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        String r0 = d(r1);
        String r4 = c(r1, r2);
        if (f33755b == false) goto L5;
        f33757d.a(r0, r4, r3);
    L5:
        b r5 = f33756c;
        if (r5 == null) goto L9;
        r5.a(r0, r4, r3);
        return;
    }

    private static final String c(String r2, String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r3;
    L12:
        return r2 + "-->" + r3;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
