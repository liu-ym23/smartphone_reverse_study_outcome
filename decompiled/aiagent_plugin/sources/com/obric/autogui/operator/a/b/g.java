package com.obric.autogui.operator.a.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OpWait.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.obric.autogui.operator.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f29697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f29698b;

    /* JADX INFO: compiled from: OpWait.kt */
    public static final class a implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f29699a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (this.f29699a == r8.f29699a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f29699a);
        }

        public String toString() {
            return "Input(waitMillis=" + this.f29699a + ')';
        }

        public a(long r1) {
            this.f29699a = r1;
        }

        public final long a() {
            return this.f29699a;
        }
    }

    /* JADX INFO: compiled from: OpWait.kt */
    @d.c.b.a.f(b = "OpWait.kt", c = {47}, d = "perform", e = "com.obric.autogui.operator.impl.op.OpWait")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f29701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f29703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29704e;

        b(g r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29703d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29702c = r3;
            this.f29704e |= Integer.MIN_VALUE;
            return this.f29703d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public g() {
        this.f29698b = 2000;
    }

    @Override // com.obric.autogui.operator.d
    public boolean b(com.obric.autogui.operator.b.a r3) {
        com.obric.autogui.operator.b.a r4 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "input");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L6;
        this.f29697a = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        return true;
    L6:
        this.f29697a = null;
        return false;
    }

    @Override // com.obric.autogui.operator.b
    public Object a(Context r13, d.c.d<? super com.obric.autogui.operator.c> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, b.class) == false) goto L7;
        b r17 = (b) ZeusTransformUtils.preCheckCast(r16, b.class, "com.obric.aiagent.plugin");
        if ((r17.f29704e & Integer.MIN_VALUE) == 0) goto L7;
        r17.f29704e -= Integer.MIN_VALUE;
    L8:
        Object r18 = r17.f29702c;
        Object r0 = d.c.a.b.a();
        int r2 = r17.f29704e;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        long r3 = r17.f29701b;
        g this = (g) ZeusTransformUtils.preCheckCast(r17.f29700a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Throwable -> L14
    L27:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Wait] waited for " + (AOSystemTools.INSTANCE.nowTimeMillis() - r3) + "ms.");
        return com.obric.autogui.operator.c.f29874a.a();
    L14:
        th = th;
    L39:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [Wait] terminated due to: " + th);     // Catch: Throwable -> L34
        com.obric.autogui.operator.h r19 = new com.obric.autogui.operator.h(ZeusTransformUtils.mapRes(R.string.espe_execute_op_wait_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "espe_execute_op_wait_cancelled"), null, "wait_interrupted", 2, null);     // Catch: Throwable -> L34
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Wait] waited for " + (AOSystemTools.INSTANCE.nowTimeMillis() - r3) + "ms.");
        return r19;
    L34:
        th = move-exception;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Wait] waited for " + (AOSystemTools.INSTANCE.nowTimeMillis() - r3) + "ms.");
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r18);
        a r110 = this.f29697a;
        if (r110 == null) goto L21;
        long r1 = r110.a();
    L22:
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "[Wait] waited started");
        long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
        AOThreadingTools r111 = AOThreadingTools.INSTANCE;     // Catch: Throwable -> L29
        r17.f29700a = this;     // Catch: Throwable -> L29
        r17.f29701b = r6;     // Catch: Throwable -> L29
        r17.f29704e = 1;     // Catch: Throwable -> L29
        if (r111.delayForMillis(r1, r17) != r0) goto L26;
        return r0;
    L26:
        r3 = r6;
    L29:
        th = th;
        r3 = r6;
        goto L39
    L21:
        r1 = this.f29698b;
    L7:
        r17 = new b(this, r16);
        goto L8
    }
}
