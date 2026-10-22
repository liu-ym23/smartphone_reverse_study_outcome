package com.obric.autogui.agents.vlm.models.impl;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: StandardModelCallUserStep.kt */
/* JADX INFO: loaded from: classes3.dex */
public class h extends e implements com.obric.autogui.agents.vlm.models.a.b {
    private static final String TAG = "M-Std-Step/CU";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f27918c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27920e;
    private String g;
    private String h;

    /* JADX INFO: compiled from: StandardModelCallUserStep.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StandardModelCallUserStep.kt */
    @d.c.b.a.f(b = "StandardModelCallUserStep.kt", c = {38}, d = "executeStep$suspendImpl", e = "com.obric.autogui.agents.vlm.models.impl.StandardModelCallUserStep")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f27922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27923c;

        b(h r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27922b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27921a = r3;
            this.f27923c |= Integer.MIN_VALUE;
            return h.a(this.f27922b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StandardModelCallUserStep.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.a<Boolean> {
        c(Object r8) {
            super(0, r8, h.class, "onBeforeCallUser", "onBeforeCallUser()Z", 0);
        }

        public final Boolean a() {
            return Boolean.valueOf(((h) ZeusTransformUtils.preCheckCast(this.receiver, h.class, "com.obric.aiagent.plugin")).G());
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    static {
        f27918c = new a(null);
    }

    private static final String H() {
        return "[call-user]";
    }

    public static /* synthetic */ String lambda$64XqfAzeKDrWbITCeXkW9vm3AuI() {
        return H();
    }

    public static /* synthetic */ String lambda$hY7Raofyoly7KSed28tDeU1mBmc(h r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$iN7iSxXYhDdqnMku17XeXVUUYwg(h r0, com.obric.autogui.session.functions.impl.b r1) {
        return a(r0, r1);
    }

    public boolean G() {
        return true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g
    public Object a(com.obric.autogui.session.a r3, d.c.d<? super com.obric.autogui.operator.g> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public h() {
    }

    public final String E() {
        return this.f27919d;
    }

    public final void j(String r1) {
        this.f27919d = r1;
    }

    public final String F() {
        return this.f27920e;
    }

    public final void k(String r1) {
        this.f27920e = r1;
    }

    public final void l(String r1) {
        this.g = r1;
    }

    public final void m(String r1) {
        this.h = r1;
    }

    static /* synthetic */ Object a(final h r7, com.obric.autogui.session.a r8, d.c.d<? super com.obric.autogui.operator.g> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r0.f27923c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27923c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f27921a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f27923c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r11);
    L18:
        return new com.obric.autogui.operator.o((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"), true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        Loog.INSTANCE.ip(TAG, new $$Lambda$h$hY7Raofyoly7KSed28tDeU1mBmc(r7), $$Lambda$h$64XqfAzeKDrWbITCeXkW9vm3AuI.INSTANCE);
        com.obric.autogui.session.functions.c r12 = r8.n();
        d.h.a.b r4 = new $$Lambda$h$iN7iSxXYhDdqnMku17XeXVUUYwg(r7);
        r0.f27923c = 1;
        r11 = r12.a(com.obric.autogui.session.functions.impl.b.class, r4, r0);
        if (r11 != r2) goto L18;
        return r2;
    L7:
        r0 = new b(r7, r10);
        goto L8
    }

    private static final String a(h r2) {
        return "[call-user] - content=" + r2.f27919d + ", action=" + r2.f27920e;
    }

    private static final x a(h r7, com.obric.autogui.session.functions.impl.b r8) {
        d.h.b.o.e(r8, "$this$attachFunction");
        r8.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        r8.a(new CallUserFunctionParams(r7.h(), r7.f27920e, r7.f27919d, r7.g, r7.h));
        return x.f38692a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public com.obric.autogui.agents.vlm.models.a.d.b C() {
        return com.obric.autogui.agents.vlm.models.a.d.b.f27244c;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public boolean h() {
        return !AssistantAbilityHelper.INSTANCE.isChatPageInVD();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.a.b
    public String e() {
        String r0 = this.f27919d;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e, com.obric.autogui.agents.vlm.models.impl.g, com.obric.autogui.agents.vlm.models.a.d
    public Bundle g() {
        String r0 = this.f27920e;
        if (r0 == null) goto L5;
        Bundle r2 = super.g();
        if (r2 != null) goto L9;
        r2 = new Bundle();
    L9:
        r2.putString("action_for_user", r0);
        return r2;
    L5:
        return super.g();
    }
}
