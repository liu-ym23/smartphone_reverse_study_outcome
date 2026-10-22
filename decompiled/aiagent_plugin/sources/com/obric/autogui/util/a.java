package com.obric.autogui.util;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;

/* JADX INFO: compiled from: AOCommonHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AOCommonHelpers";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31488a = null;

    /* JADX INFO: renamed from: com.obric.autogui.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOCommonHelpers.kt */
    @d.c.b.a.f(b = "AOCommonHelpers.kt", c = {29, 36}, d = "withRetries", e = "com.obric.autogui.util.AOCommonHelpers")
    static final class C0862a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f31493e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        C0862a(a r3, d.c.d<? super C0862a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.g = r8;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, 0, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31488a = new a();
    }

    private a() {
    }

    public static /* synthetic */ Object a(a r5, String r6, int r7, long r8, d.h.a.b r10, d.c.d r11, int r12, Object r13) {
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        int r2 = 3;
    L7:
        if ((r12 & 4) == 0) goto L9;
        long r3 = 1000;
    L11:
        return r5.a(r6, r2, r3, r0, r1);
    L9:
        r3 = r8;
        goto L11
    L5:
        r2 = r7;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0140 -> B:31:0x0146). Please report as a decompilation issue!!! */
    public final Object a(String r22, int r23, long r24, d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r26, d.c.d<? super x> r27) {
        String r1 = "com.obric.aiagent.plugin";
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C0862a.class) == false) goto L7;
        C0862a r3 = (C0862a) ZeusTransformUtils.preCheckCast(r2, C0862a.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        int r7 = 1;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r8 = r3.f31492d;
        long r9 = r3.f31493e;
        int r10 = r3.f31491c;
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r3.f31490b, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f31489a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        String r16 = "com.obric.aiagent.plugin";
        int r13 = r10;
        char r14 = 2;
        d.h.a.b r15 = r11;
        C0862a r17 = r3;
        Object r18 = r5;
        long r19 = r9;
    L31:
        if (r8 == r13) goto L34;
        int r110 = r8 + 1;
        String r20 = r12;
        r1 = r16;
        r7 = 1;
    L19:
        long r111 = com.obric.autogui.util.e.a.a();
        r17.f31489a = r20;
        r17.f31490b = r15;
        r17.f31491c = r13;
        r17.f31493e = r19;
        r17.f = r111;
        r17.f31492d = r110;
        r17.i = r7;
        Object r112 = r15.invoke(r17);
        if (r112 != r18) goto L22;
        return r18;
    L22:
        String r113 = r20;
        r8 = r110;
        d.h.a.b r114 = r15;
        int r21 = r13;
        r4 = r112;
        d.h.a.b r115 = r114;
        long r116 = r19;
        r3 = r17;
        r5 = r18;
        long r25 = r111;
    L23:
        boolean r28 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, r1)).booleanValue();
        r16 = r1;
        Loog.INSTANCE.d(TAG, " - [" + r8 + '/' + r21 + "] (" + r113 + ") (latency=" + (com.obric.autogui.util.e.a.a() - r25) + "ms)");
        if (r8 >= r21) goto L27;
        if (r28 == false) goto L34;
    L27:
        r3.f31489a = r113;
        r3.f31490b = r115;
        r3.f31491c = r21;
        r3.f31493e = r116;
        r3.f31492d = r8;
        r14 = 2;
        r3.i = 2;
        if (com.obric.autogui.util.d.a.a(r116, r3) != r5) goto L30;
        return r5;
    L30:
        r17 = r3;
        r18 = r5;
        r13 = r21;
        r19 = r116;
        r15 = r115;
        r12 = r113;
    L34:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r3.f31492d;
        r25 = r3.f;
        r116 = r3.f31493e;
        r21 = r3.f31491c;
        r115 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r3.f31490b, d.h.a.b.class, "com.obric.aiagent.plugin");
        r113 = (String) ZeusTransformUtils.preCheckCast(r3.f31489a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        goto L23
    L16:
        o.a(r4);
        r13 = r23;
        if (1 > r13) goto L34;
        r15 = r0;
        r17 = r3;
        r18 = r5;
        r110 = 1;
        r20 = r22;
        r19 = r24;
    L7:
        r3 = new C0862a(this, r2);
        goto L8
    }
}
