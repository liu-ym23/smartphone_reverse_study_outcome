package com.obric.autogui.agents.a.b;

import com.obric.autogui.agents.a.a.a.n;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TypeViewTreeTextDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f26284a = null;

    static {
        f26284a = new j();
    }

    private j() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r14, d.c.d<? super com.obric.autogui.agents.a.f.b> r15) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.a.a r16 = r14.a().d();
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r16, n.class) == true) goto L5;
        r16 = null;
    L5:
        n r17 = (n) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin"), n.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L8;
        List<ViewHierarchyDump> r18 = r14.a().c().b();
        com.obric.autogui.agents.a.l.c r19 = r17.d();
        if (r19 != null) goto L12;
        r19 = r14.b();
    L12:
        List<ViewHierarchyDump> r110 = r19.b();
        Integer r0 = com.obric.autogui.agents.a.n.a.f26730a.d(r18);
        Integer r2 = com.obric.autogui.agents.a.n.a.f26730a.d(r110);
        if (r18 == null) goto L15;
        List<VHNode> r3 = com.obric.autogui.agents.a.n.a.f26730a.a(r18);
    L16:
        if (r3 != null) goto L18;
        r3 = p.b();
    L18:
        if (r110 == null) goto L20;
        List<VHNode> r4 = com.obric.autogui.agents.a.n.a.f26730a.a(r110);
    L21:
        if (r4 != null) goto L23;
        r4 = p.b();
    L23:
        if (r18 == null) goto L26;
        if (r110 == null) goto L26;
        String r5 = com.obric.autogui.agents.a.n.a.f26730a.a(r3, r4);
    L27:
        StringBuilder r6 = new StringBuilder().append("before_fingerprint=");
        if (r0 == null) goto L30;
        String r7 = r0.toString();
    L31:
        String r8 = "";
        if (r7 != null) goto L34;
        r7 = "";
    L34:
        StringBuilder r9 = r6.append(r7).append(", after_fingerprint=");
        if (r2 == null) goto L37;
        r1 = r2.toString();
    L37:
        if (r1 == null) goto L40;
        r8 = r1;
    L40:
        StringBuilder r10 = r9.append(r8).append(", before_tree_count=");
        int r11 = 0;
        if (r18 == null) goto L43;
        int r111 = r18.size();
    L44:
        StringBuilder r112 = r10.append(r111).append(", after_tree_count=");
        if (r110 == null) goto L47;
        r11 = r110.size();
    L47:
        String r12 = r112.append(r11).append(", before_node_count=").append(r3.size()).append(", after_node_count=").append(r4.size()).append(", first_text_diff=").append(r5).toString();
        if (r0 == null) goto L57;
        if (r2 == null) goto L57;
        if (o.a(r5, "-1:none") == true) goto L55;
        return d.a(r14, com.obric.autogui.agents.a.f.k.f26442a, "type viewtree text changed", null, r12, 4, null);
    L55:
        return d.a(r14, com.obric.autogui.agents.a.f.k.f26444c, "type viewtree text unchanged", null, r12, 4, null);
    L57:
        return d.a(r14, com.obric.autogui.agents.a.f.k.f, "type viewtree text unavailable", null, r12, 4, null);
    L43:
        r111 = 0;
        goto L44
    L30:
        r7 = null;
    L26:
        r5 = "-1:unavailable";
        goto L27
    L20:
        r4 = null;
        goto L21
    L15:
        r3 = null;
        goto L16
    L8:
        return d.a(r14, com.obric.autogui.agents.a.f.k.f, "type action evidence unavailable", null, null, 12, null);
    }
}
