package com.obric.autogui.operator.a.b.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n.j;
import java.util.Iterator;

/* JADX INFO: compiled from: BaseAppOpener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.obric.autogui.operator.a.b.a.b.a {

    /* JADX INFO: compiled from: BaseAppOpener.kt */
    @d.c.b.a.f(b = "BaseAppOpener.kt", c = {50}, d = "doOpen", e = "com.obric.autogui.operator.impl.op.openapp.opener.BaseAppOpener")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f29476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29477d;

        a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29476c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29475b = r3;
            this.f29477d |= Integer.MIN_VALUE;
            return this.f29476c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public abstract j<com.obric.autogui.operator.a.b.a.b.b.b> a();

    public boolean a(com.obric.autogui.operator.a.b.a.b.b.b r2) {
        o.e((com.obric.autogui.operator.a.b.a.b.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.operator.a.b.a.b.b.b.class, "com.obric.aiagent.plugin"), "preCheck");
        return true;
    }

    public abstract Object c(Context r1, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r2);

    public b() {
    }

    private final com.obric.autogui.operator.a.b.a.c a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        Iterator<com.obric.autogui.operator.a.b.a.b.b.b> r0 = a().a();
    L4:
        if (r0.hasNext() == false) goto L11;
        com.obric.autogui.operator.a.b.a.b.b.b r2 = (com.obric.autogui.operator.a.b.a.b.b.b) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.autogui.operator.a.b.a.b.b.b.class, "com.obric.aiagent.plugin");
        if (a(r2) == false) goto L7;
        com.obric.autogui.operator.a.b.a.c r3 = r2.a(r8);
        if (r3 == null) goto L4;
        return r3;
    L7:
        Loog.INSTANCE.w("Op-OpenApp/IntentOpener", " - [IntentOpener-PreCheck] suppressed running of PreCheck(" + r2.getClass().getSimpleName() + ')');
        goto L4
    L11:
        return null;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.a
    public final Object a(Context r13, d.c.d<? super com.obric.autogui.operator.a.b.a.c> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r16, a.class, "com.obric.aiagent.plugin");
        if ((r0.f29477d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f29477d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f29475b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f29477d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b this = (b) ZeusTransformUtils.preCheckCast(r0.f29474a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L22:
        return com.obric.autogui.operator.a.b.a.c.a((com.obric.autogui.operator.a.b.a.c) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.operator.a.b.a.c.class, "com.obric.aiagent.plugin"), null, null, null, null, null, false, (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), 63, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        com.obric.autogui.operator.a.b.a.c r18 = a(r15);
        if (r18 != null) goto L17;
        r0.f29474a = this;
        r0.f29477d = 1;
        r17 = c(r15, r0);
        if (r17 != r2) goto L22;
        return r2;
    L17:
        return com.obric.autogui.operator.a.b.a.c.a(r18, null, null, null, null, null, false, (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(this, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), 63, null);
    L7:
        r0 = new a(this, r16);
        goto L8
    }
}
