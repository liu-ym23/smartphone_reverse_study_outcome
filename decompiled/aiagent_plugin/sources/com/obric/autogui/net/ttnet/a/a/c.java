package com.obric.autogui.net.ttnet.a.a;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNetExceptionWrapperInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    private static final String TAG = "TTN/ExpInfo/Wrap";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f29204b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Throwable f29205c;

    /* JADX INFO: compiled from: TTNetExceptionWrapperInfo.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29204b = new a(null);
    }

    /* JADX INFO: renamed from: lambda$g-ZOGR2Q__hlZShh1ly2mGv_RY4, reason: not valid java name */
    public static /* synthetic */ String m821lambda$gZOGR2Q__hlZShh1ly2mGv_RY4(Object r0) {
        return a(r0);
    }

    public c(com.obric.autogui.tools.api.net.c r8, Throwable r9) {
        o.e(r8, "type");
        o.e(r9, "ttnetException");
        super(r8, r9, null, 4, null);
        this.f29205c = r9;
    }

    @Override // com.obric.autogui.net.ttnet.a.a.b, com.obric.autogui.tools.api.net.b
    public String a() {
        return c();
    }

    private final String c() {
        if (com.obric.autogui.net.ttnet.a.a.a.a(this.f29205c) == false) goto L12;
        int r0 = com.obric.autogui.net.ttnet.a.a.a.c(this.f29205c);
        if (r0 == 0) goto L10;
        if (r0 == (-1)) goto L10;
        return "SC" + r0;
    L10:
        return "EC" + com.obric.autogui.net.ttnet.a.a.a.b(this.f29205c);
    L12:
        return "T/" + getType();
    }

    @Override // com.obric.autogui.net.ttnet.a.a.b, com.obric.autogui.tools.api.net.b
    public void b() {
        super.b();
        Throwable r5 = this.f29205c;
        if (com.obric.autogui.net.ttnet.a.a.a.a(r5) == false) goto L10;
        Loog.INSTANCE.e(TAG, " - [TTNEx] SC=" + com.obric.autogui.net.ttnet.a.a.a.c(r5) + ", EC=" + com.obric.autogui.net.ttnet.a.a.a.b(r5));
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.retrofit2.f.c.class) == false) goto L11;
        final Object r6 = ((com.bytedance.retrofit2.f.c) ZeusTransformUtils.preCheckCast(r5, com.bytedance.retrofit2.f.c.class, "com.obric.aiagent.plugin")).f9549e;
        if (ZeusTransformUtils.instanceOf(r6, com.bytedance.frameworks.baselib.network.http.b.class) == false) goto L12;
        Loog.INSTANCE.e(TAG, " - [TTNEx/Cr] TraceC  ->" + ((com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin")).P);
        Loog.INSTANCE.e(TAG, " - [TTNEx/Cr] ReqLog  ->" + ((com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin")).f8134J);
        Loog.INSTANCE.dp(TAG, new $$Lambda$c$gZOGR2Q__hlZShh1ly2mGv_RY4(r6));
        Loog.INSTANCE.e(TAG, " - [TTNEx/Cr] ResHead ->" + ((com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin")).N);
        Loog.INSTANCE.e(TAG, " - [TTNEx/Cr] Retrofit->" + ((com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin")).K.get("retrofit"));
        return;
    L12:
        return;
    L11:
        return;
    }

    private static final String a(Object r3) {
        return " - [TTNEx/Cr] ReqHead ->" + ((com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin")).M;
    }
}
