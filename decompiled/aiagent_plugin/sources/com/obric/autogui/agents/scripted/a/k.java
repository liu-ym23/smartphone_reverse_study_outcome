package com.obric.autogui.agents.scripted.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: SampleScript.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.e[] f26880a;

    public k() {
        com.obric.autogui.operator.e r1 = new com.obric.autogui.operator.e();
        r1.a_("打开应用");
        d.h.b.h r16 = null;
        r1.a((Collection) ZeusTransformUtils.preCheckCast(p.b(new com.obric.autogui.operator.e.C0780e[]{new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29869a, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.a.b(null, null, "抖音", null, null, false, null, 123, r16), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin")), new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29872d, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.g.a(2000), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))}), Collection.class, "com.obric.aiagent.plugin"));
        x r3 = x.f38692a;
        com.obric.autogui.operator.e r2 = new com.obric.autogui.operator.e();
        r2.a_("点击「朋友」");
        com.obric.autogui.operator.b.EnumC0777b r4 = com.obric.autogui.operator.b.EnumC0777b.f29870b;
        com.obric.autogui.operator.a.b.b.a r6 = new com.obric.autogui.operator.a.b.b.a(0, 0, 3, null);
        com.obric.autogui.operator.a.a.e r11 = r6.b();
        com.obric.autogui.operator.a.a.b r12 = new com.obric.autogui.operator.a.a.b();
        r12.a("朋友");
        r11.a(r12);
        x r13 = x.f38692a;
        r2.a((Collection) ZeusTransformUtils.preCheckCast(p.b(new com.obric.autogui.operator.e.C0780e[]{new com.obric.autogui.operator.e.C0780e(r4, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin")), new com.obric.autogui.operator.e.C0780e(com.obric.autogui.operator.b.EnumC0777b.f29872d, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.g.a(2000), com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))}), Collection.class, "com.obric.aiagent.plugin"));
        x r5 = x.f38692a;
        com.obric.autogui.operator.e r7 = new com.obric.autogui.operator.e();
        r7.a_("输入手机号");
        com.obric.autogui.operator.b.EnumC0777b r8 = com.obric.autogui.operator.b.EnumC0777b.f;
        com.obric.autogui.operator.a.b.f.b r9 = new com.obric.autogui.operator.a.b.f.b(false, "36171112", false, 5, r16);
        com.obric.autogui.operator.a.a.e r10 = r9.b();
        com.obric.autogui.operator.a.a.b r14 = new com.obric.autogui.operator.a.a.b();
        r14.b("请输入手机号");
        r10.a(r14);
        x r15 = x.f38692a;
        r7.a((Collection) ZeusTransformUtils.preCheckCast(p.a(new com.obric.autogui.operator.e.C0780e(r8, (com.obric.autogui.operator.b.a) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin"))), Collection.class, "com.obric.aiagent.plugin"));
        x r17 = x.f38692a;
        this.f26880a = new com.obric.autogui.operator.e[]{r1, r2, r7, new com.obric.autogui.operator.a()};
    }

    @Override // com.obric.autogui.agents.scripted.a.d
    public com.obric.autogui.operator.e a(int r2) {
        return (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(d.a.i.b(this.f26880a, r2), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
    }
}
