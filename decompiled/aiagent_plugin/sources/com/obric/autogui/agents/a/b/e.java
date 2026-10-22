package com.obric.autogui.agents.a.b;

import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.l.n;

/* JADX INFO: compiled from: ImageDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f26278a = null;

    static {
        f26278a = new e();
    }

    private e() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r18, d.c.d<? super com.obric.autogui.agents.a.f.b> r19) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        boolean r3 = com.obric.autogui.agents.a.n.a.f26730a.e(r18.a().c().b());
        boolean r4 = com.obric.autogui.agents.a.n.a.f26730a.e(r18.b().b());
        if (r3 == true) goto L110;
        if (r4 == true) goto L110;
        com.obric.autogui.agents.a.d.c r5 = r18.a().c().c();
        com.obric.autogui.agents.a.d.c r6 = r18.b().c();
        if (r5 == null) goto L99;
        if (r6 == null) goto L99;
        int r7 = Long.bitCount(r5.a() ^ r6.a());
        int r11 = n.c(((r18.a().a().f() * 64) + 999) / 1000, 1);
        if (r7 >= r11) goto L13;
        com.obric.autogui.agents.a.f.j r13 = r18.a().a();
        if (r18.a().j() != com.obric.autogui.agents.a.f.a.f26392a) goto L17;
    L20:
        boolean r14 = true;
    L21:
        com.obric.autogui.agents.a.d.e r8 = null;
        if (r14 == false) goto L29;
        com.obric.autogui.agents.a.a.a.a r9 = r18.a().d();
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.agents.a.a.a.f.class) == true) goto L26;
        r9 = null;
    L26:
        com.obric.autogui.agents.a.a.a.f r10 = (com.obric.autogui.agents.a.a.a.f) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.f) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.a.a.a.f.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.f.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L29;
        r8 = r10.a();
    L29:
        com.obric.autogui.agents.a.d.e r12 = r8;
        if (r13.g() == false) goto L32;
        com.obric.autogui.agents.a.d.b r15 = com.obric.autogui.agents.a.d.a.f26351a.a(r5, r6, r13.h(), r12, r13.k());
        if (r15.c() > 0) goto L36;
    L38:
        boolean r16 = false;
    L39:
        if (r14 == true) goto L41;
    L49:
        boolean r17 = false;
    L51:
        if (r15.c() > 0) goto L53;
    L55:
        boolean r20 = false;
    L57:
        if (r16 == false) goto L59;
        String r110 = "global_pixel";
    L64:
        int r21 = r110.hashCode();
        if (r21 != (-320163094)) goto L67;
        String r22 = r110;
        if (r22.equals("global_pixel") == true) goto L82;
    L81:
        String r23 = "image unchanged";
    L84:
        if (r14 == false) goto L90;
        StringBuilder r111 = new StringBuilder().append("click_target_available=");
        if (r12 == null) goto L88;
        boolean r24 = true;
    L89:
        String r25 = r111.append(r24).append(", click_region_available=").append(r15.f()).append(", click_region_changed_permille=").append(r15.h()).append(", outside_click_region_changed_permille=").append(r15.i()).append(", click_region_changed_threshold=").append(r13.l()).append(", click_region_radius_permille=").append(r13.k()).append(", ").toString();
    L91:
        String r26 = "decision=" + r22 + ", " + r25 + "hamming=" + r15.a() + ", hamming_threshold=" + r11 + ", pixel_compare_enabled=true, pixel_comparison_available=" + r15.b() + ", pixel_delta_threshold=" + r13.h() + ", changed_pixel_count=" + r15.c() + ", changed_pixel_permille=" + r15.d() + ", global_changed_threshold=" + r13.i() + ", max_block_changed_permille=" + r15.e() + ", block_changed_threshold=" + r13.j();
        if (r16 == true) goto L98;
        if (r17 == true) goto L98;
        if (r20 == true) goto L98;
        return d.a(r18, com.obric.autogui.agents.a.f.k.f26444c, r23, null, r26, 4, null);
    L98:
        return a(r18, r23, r26);
    L88:
        r24 = false;
        goto L89
    L90:
        r25 = "";
        goto L91
    L82:
        r23 = "image changed by global pixels";
        goto L84
    L67:
        if (r21 != 664442251) goto L69;
        r22 = r110;
        if (r22.equals("click_region") == false) goto L81;
        r23 = "image changed around click target";
        goto L84
    L69:
        if (r21 == 1743882937) goto L71;
        r22 = r110;
        goto L81
    L71:
        r22 = r110;
        if (r22.equals("local_block") == false) goto L81;
        r23 = "image changed by local block";
        goto L84
    L59:
        if (r17 == false) goto L61;
        r110 = "click_region";
        goto L64
    L61:
        if (r20 == false) goto L63;
        r110 = "local_block";
        goto L64
    L63:
        r110 = OProtocolTextEffectTextView.EffectNameNone;
        goto L64
    L53:
        if (r15.e() < r13.j()) goto L55;
        r20 = true;
        goto L57
    L41:
        if (r15.f() == false) goto L49;
        if (r15.g() <= 0) goto L49;
        if (r15.h() < r13.l()) goto L49;
        if (r15.h() < (r15.i() + r13.i())) goto L49;
        r17 = true;
        goto L51
    L36:
        if (r15.d() < r13.i()) goto L38;
        r16 = true;
        goto L39
    L32:
        return d.a(r18, com.obric.autogui.agents.a.f.k.f26444c, "image unchanged", null, "decision=none, hamming=" + r7 + ", hamming_threshold=" + r11 + ", pixel_compare_enabled=false", 4, null);
    L17:
        if (r18.a().j() == com.obric.autogui.agents.a.f.a.f26393b) goto L20;
        r14 = false;
        goto L21
    L13:
        return a(r18, "image changed by dHash", "decision=dhash, hamming=" + r7 + ", hamming_threshold=" + r11 + ", pixel_compare_enabled=" + r18.a().a().g());
    L99:
        com.obric.autogui.agents.a.f.k r27 = com.obric.autogui.agents.a.f.k.f;
        StringBuilder r0 = new StringBuilder().append("before_available=");
        if (r5 == null) goto L102;
        boolean r28 = true;
    L103:
        StringBuilder r1 = r0.append(r28).append(", after_available=");
        if (r6 == null) goto L106;
        boolean r29 = true;
    L108:
        return d.a(r18, r27, "image fingerprint unavailable", null, r1.append(r29).toString(), 4, null);
    L106:
        r29 = false;
        goto L108
    L102:
        r28 = false;
    L110:
        return d.a(r18, com.obric.autogui.agents.a.f.k.f, "dynamic surface exists; image evidence ignored", null, "before_dynamic=" + r3 + ", after_dynamic=" + r4, 4, null);
    }

    private final com.obric.autogui.agents.a.f.b a(b r8, String r9, String r10) {
        return d.a(r8, com.obric.autogui.agents.a.f.k.f26442a, r9, null, r10 + ", confirmation_required=false, round=" + r8.d() + ", max_detect_count=" + r8.e(), 4, null);
    }
}
