package com.obric.matrix.platform.sdk.ones.account.b;

import com.obric.matrix.platform.sdk.ones.account.a.d;
import com.obric.matrix.platform.sdk.ones.internal.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OLog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f33615b;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.account.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OLog.kt */
    public static final class C0907a implements d {
        C0907a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void a(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            b.c(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void c(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            b.e(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void d(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            b.g(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.a.d
        public void b(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            b.i(r1, r2, r3);
        }
    }

    private a() {
    }

    static {
        f33614a = new a();
        f33615b = (d) ZeusTransformUtils.preCheckCast(new C0907a(), d.class, "com.obric.aiagent.plugin");
    }

    public final void a(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        o.e(r1, "<set-?>");
        f33615b = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.d
    public void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33615b.a(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.d
    public void c(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33615b.c(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.d
    public void d(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33615b.d(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.a.d
    public void b(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        f33615b.b(r1, r2, r3);
    }

    public static final void a(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        f33614a.a(r2, r3, null);
    }

    public static final void b(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        f33614a.c(r2, r3, null);
    }

    public static final void c(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        f33614a.d(r2, r3, null);
    }

    public static final void d(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        f33614a.b(r2, r3, null);
    }
}
