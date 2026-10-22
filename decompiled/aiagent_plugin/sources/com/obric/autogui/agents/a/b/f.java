package com.obric.autogui.agents.a.b;

import com.obric.autogui.agents.a.a.a.n;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InputTextDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f26279a = null;

    static {
        f26279a = new f();
    }

    private f() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r11, d.c.d<? super com.obric.autogui.agents.a.f.b> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.a.a r14 = r11.a().d();
        if (ZeusTransformUtils.instanceOf(r14, n.class) == true) goto L5;
        r14 = null;
    L5:
        n r2 = (n) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin"), n.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        com.obric.autogui.agents.a.a.h r15 = r2.c();
        if (r15 != null) goto L14;
        return d.a(r11, com.obric.autogui.agents.a.f.k.f, "input focus evidence unavailable", null, null, 12, null);
    L14:
        if (r15.a() == false) goto L16;
        com.obric.autogui.agents.a.n.a.e r16 = r15.b();
        if (r16 == null) goto L20;
        String r0 = r2.a();
        if (r0 != null) goto L26;
        return a(this, r11, r2, com.obric.autogui.agents.a.f.k.f26444c, "expected input text missing", null, null, false, 112, null);
    L26:
        if (com.obric.autogui.agents.a.n.a.f26730a.a(r16) == true) goto L28;
        com.obric.autogui.agents.a.l.c r1 = r2.d();
        if (r1 != null) goto L32;
        r1 = r11.b();
    L32:
        com.obric.autogui.agents.a.n.a.C0671a r5 = com.obric.autogui.agents.a.n.a.f26730a.a(r1.b(), r16);
        if (r5 == null) goto L35;
        com.obric.autogui.agents.a.n.a.c r17 = com.obric.autogui.agents.a.n.a.f26730a.a(r16, r5.a(), r0, r2.b());
        if (r17.b() == true) goto L41;
        return a(r11, r2, com.obric.autogui.agents.a.f.k.f, "sensitive input result unavailable", r5, r17.c(), true);
    L41:
        if (r17.a() == false) goto L44;
        return a(this, r11, r2, com.obric.autogui.agents.a.f.k.f26442a, "same input target text changed as expected", r5, r17.c(), false, 64, null);
    L44:
        return a(this, r11, r2, com.obric.autogui.agents.a.f.k.f26444c, "same input target text not changed as expected", r5, r17.c(), false, 64, null);
    L35:
        return a(this, r11, r2, com.obric.autogui.agents.a.f.k.f26444c, "same input target not found yet", null, null, false, 112, null);
    L28:
        return a(this, r11, r2, com.obric.autogui.agents.a.f.k.f, "sensitive input text unavailable", null, com.obric.autogui.agents.a.n.a.d.f26748d, true, 16, null);
    L20:
        return d.a(r11, com.obric.autogui.agents.a.f.k.f26444c, "no focused input node before type", "当前没有可输入焦点，请先定位并点击输入框。", null, 8, null);
    L16:
        return d.a(r11, com.obric.autogui.agents.a.f.k.f, "input focus capability unavailable", null, null, 12, null);
    L8:
        return d.a(r11, com.obric.autogui.agents.a.f.k.f, "type action evidence unavailable", null, null, 12, null);
    }

    static /* synthetic */ com.obric.autogui.agents.a.f.b a(f r10, b r11, n r12, com.obric.autogui.agents.a.f.k r13, String r14, com.obric.autogui.agents.a.n.a.C0671a r15, com.obric.autogui.agents.a.n.a.d r16, boolean r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        com.obric.autogui.agents.a.n.a.C0671a r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        com.obric.autogui.agents.a.n.a.d r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        boolean r9 = false;
    L15:
        return r10.a(r11, r12, r13, r14, r7, r8, r9);
    L13:
        r9 = r17;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    private final com.obric.autogui.agents.a.f.b a(b r8, n r9, com.obric.autogui.agents.a.f.k r10, String r11, com.obric.autogui.agents.a.n.a.C0671a r12, com.obric.autogui.agents.a.n.a.d r13, boolean r14) {
        StringBuilder r7 = new StringBuilder().append("node_match=");
        String r0 = OProtocolTextEffectTextView.EffectNameNone;
        if (r12 == null) goto L8;
        com.obric.autogui.agents.a.n.a.b r15 = r12.b();
        if (r15 == null) goto L8;
        String r16 = r15.a();
        if (r16 == null) goto L8;
    L9:
        StringBuilder r17 = r7.append(r16).append(", text_match=");
        if (r13 == null) goto L16;
        String r18 = r13.a();
        if (r18 == null) goto L16;
        r0 = r18;
    L16:
        return d.a(r8, r10, r11, null, r17.append(r0).append(", replace=").append(r9.b()).append(", sensitive=").append(r14).toString(), 4, null);
    L8:
        r16 = OProtocolTextEffectTextView.EffectNameNone;
        goto L9
    }
}
