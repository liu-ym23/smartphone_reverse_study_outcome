package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OpWaitImeReady.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.obric.autogui.operator.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f29705a;

    /* JADX INFO: compiled from: OpWaitImeReady.kt */
    public static final class a implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f29707b;

        public a() {
            this(0, 0, 3, null);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f29706a == r10.f29706a) goto L12;
            return false;
        L12:
            if (this.f29707b == r10.f29707b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f29706a) * 31) + Long.hashCode(this.f29707b);
        }

        public String toString() {
            return "Input(maxMillis=" + this.f29706a + ", intervalMillis=" + this.f29707b + ')';
        }

        public a(long r1, long r3) {
            this.f29706a = r1;
            this.f29707b = r3;
        }

        public /* synthetic */ a(long r1, long r3, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = 500;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r3 = 50;
        L8:
            this(r1, r3);
        }

        public final long a() {
            return this.f29706a;
        }

        public final long b() {
            return this.f29707b;
        }
    }

    /* JADX INFO: compiled from: OpWaitImeReady.kt */
    @d.c.b.a.f(b = "OpWaitImeReady.kt", c = {52}, d = "perform", e = "com.obric.autogui.operator.impl.op.OpWaitImeReady")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f29709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f29710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f29711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f29712e;
        final /* synthetic */ h f;
        int g;

        b(h r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29712e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public h() {
        this.f29705a = new a(0, 0, 3, null);
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L6;
        this.f29705a = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        return true;
    L6:
        return false;
    }

    @Override // com.obric.autogui.operator.b
    public Object a(Context r14, d.c.d<? super com.obric.autogui.operator.c> r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, b.class) == false) goto L7;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r17, b.class, "com.obric.aiagent.plugin");
        if ((r18.g & Integer.MIN_VALUE) == 0) goto L7;
        r18.g -= Integer.MIN_VALUE;
    L8:
        Object r19 = r18.f29712e;
        Object r0 = d.c.a.b.a();
        int r2 = r18.g;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        long r4 = r18.f29711d;
        long r6 = r18.f29710c;
        long r8 = r18.f29709b;
        h this = (h) ZeusTransformUtils.preCheckCast(r18.f29708a, h.class, "com.obric.aiagent.plugin");
        d.o.a(r19);     // Catch: Throwable -> L28
    L18:
        if (AOPlatformTools.INSTANCE.special().isAutoImeReady() == true) goto L19;
        long r1 = AOSystemTools.INSTANCE.nowTimeMillis() - r4;
        if (r1 >= r8) goto L23;
        AOThreadingTools r110 = AOThreadingTools.INSTANCE;     // Catch: Throwable -> L28
        r18.f29708a = this;     // Catch: Throwable -> L28
        r18.f29709b = r8;     // Catch: Throwable -> L28
        r18.f29710c = r6;     // Catch: Throwable -> L28
        r18.f29711d = r4;     // Catch: Throwable -> L28
        r18.g = 1;     // Catch: Throwable -> L28
        if (r110.delayForMillis(r6, r18) != r0) goto L18;
        return r0;
    L23:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [WaitImeReady] timeout after " + r1 + "ms, proceed to typing fallback");
        return com.obric.autogui.operator.c.f29874a.a();
    L19:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [WaitImeReady] ready");
        return com.obric.autogui.operator.c.f29874a.a();
    L28:
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [WaitImeReady] interrupted");
        return new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.espe_execute_op_wait_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_wait_cancelled"), "ime_ready_wait_interrupted", "ime_wait_interrupted");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r19);
        long r3 = this.f29705a.a();
        long r5 = this.f29705a.b();
        long r7 = AOSystemTools.INSTANCE.nowTimeMillis();
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [WaitImeReady] start, max=" + r3 + ", interval=" + r5);
        r8 = r3;
        r4 = r7;
        r6 = r5;
    L7:
        r18 = new b(this, r17);
        goto L8
    }
}
