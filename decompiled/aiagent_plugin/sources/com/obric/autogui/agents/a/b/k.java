package com.obric.autogui.agents.a.b;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ViewTreeDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f26285a = null;

    static {
        f26285a = new k();
    }

    private k() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r12, d.c.d<? super com.obric.autogui.agents.a.f.b> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        List<ViewHierarchyDump> r15 = r12.a().c().b();
        List<ViewHierarchyDump> r0 = r12.b().b();
        Integer r1 = com.obric.autogui.agents.a.n.a.f26730a.c(r15);
        Integer r2 = com.obric.autogui.agents.a.n.a.f26730a.c(r0);
        boolean r3 = true;
        int r4 = 0;
        if (r1 == null) goto L32;
        if (r2 == null) goto L32;
        boolean r5 = true ^ o.a(r1, r2);
        if (r5 == false) goto L26;
        List<VHNode> r7 = null;
        if (r15 == null) goto L11;
        List<VHNode> r8 = com.obric.autogui.agents.a.n.a.f26730a.a(r15);
    L12:
        if (r8 != null) goto L14;
        r8 = p.b();
    L14:
        if (r0 == null) goto L16;
        r7 = com.obric.autogui.agents.a.n.a.f26730a.a(r0);
    L16:
        if (r7 != null) goto L18;
        r7 = p.b();
    L18:
        StringBuilder r6 = new StringBuilder().append("before_fingerprint=").append(r1).append(", after_fingerprint=").append(r2).append(", before_tree_count=");
        if (r15 == null) goto L21;
        int r16 = r15.size();
    L22:
        StringBuilder r17 = r6.append(r16).append(", after_tree_count=");
        if (r0 == null) goto L25;
        r4 = r0.size();
    L25:
        String r11 = r17.append(r4).append(", before_node_count=").append(r8.size()).append(", after_node_count=").append(r7.size()).append(", first_viewtree_diff=").append(a(r8, r7)).toString();
    L27:
        String r9 = r11;
        if (r5 == false) goto L31;
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26442a, "viewtree fingerprint changed", null, r9, 4, null);
    L31:
        return d.a(r12, com.obric.autogui.agents.a.f.k.f26444c, "viewtree unchanged", null, r9, 4, null);
    L21:
        r16 = 0;
        goto L22
    L11:
        r8 = null;
        goto L12
    L26:
        r11 = "before_fingerprint=" + r1 + ", after_fingerprint=" + r2 + ", viewtree_changed=false";
    L32:
        com.obric.autogui.agents.a.f.k r18 = com.obric.autogui.agents.a.f.k.f;
        StringBuilder r10 = new StringBuilder().append("before_available=");
        if (r1 == null) goto L35;
        boolean r19 = true;
    L36:
        StringBuilder r20 = r10.append(r19).append(", after_available=");
        if (r2 != null) goto L41;
        r3 = false;
    L41:
        return d.a(r12, r18, "viewtree unsupported or unavailable", null, r20.append(r3).toString(), 4, null);
    L35:
        r19 = false;
        goto L36
    }

    private final String a(List<? extends VHNode> r8, List<? extends VHNode> r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        int r11 = Math.min(r7.size(), r10.size());
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L58;
        VHNode r2 = (VHNode) ZeusTransformUtils.preCheckCast(r7.get(r1), VHNode.class, "com.obric.aiagent.plugin");
        VHNode r3 = (VHNode) ZeusTransformUtils.preCheckCast(r10.get(r1), VHNode.class, "com.obric.aiagent.plugin");
        if (o.a(r2.getId(), r3.getId()) == true) goto L8;
        String r4 = DbHelper.COL_ID;
    L53:
        if (r4 != null) goto L55;
        r1 = r1 + 1;
        goto L3
    L55:
        return r1 + ':' + r4;
    L8:
        if (o.a(r2.getClassName(), r3.getClassName()) == true) goto L11;
        r4 = "class";
        goto L53
    L11:
        if (o.a(r2.getBounds().toString(), r3.getBounds().toString()) == true) goto L14;
        r4 = "bounds";
        goto L53
    L14:
        if (r2.getVisibility() == r3.getVisibility()) goto L17;
        r4 = "visibility";
        goto L53
    L17:
        if (r2.isClickable() == r3.isClickable()) goto L20;
        r4 = "clickable";
        goto L53
    L20:
        if (r2.isLongClickable() == r3.isLongClickable()) goto L23;
        r4 = "long_clickable";
        goto L53
    L23:
        if (r2.isEnabled() == r3.isEnabled()) goto L25;
        r4 = "enabled";
        goto L53
    L25:
        CharSequence r5 = r2.getText();
        String r6 = null;
        if (r5 == null) goto L28;
        String r12 = r5.toString();
    L29:
        CharSequence r13 = r3.getText();
        if (r13 == null) goto L32;
        String r14 = r13.toString();
    L34:
        if (o.a(r12, r14) == true) goto L36;
        r4 = "text";
        goto L53
    L36:
        CharSequence r15 = r2.getHint();
        if (r15 == null) goto L39;
        String r16 = r15.toString();
    L40:
        CharSequence r17 = r3.getHint();
        if (r17 == null) goto L44;
        r6 = r17.toString();
    L44:
        if (o.a(r16, r6) == true) goto L47;
        r4 = "hint";
        goto L53
    L47:
        if (r2.isFocused() == r3.isFocused()) goto L50;
        r4 = "focused";
        goto L53
    L50:
        if (r2.getInputType() == r3.getInputType()) goto L52;
        r4 = "input_type";
        goto L53
    L52:
        r4 = f26285a.a(r2, r3);
        goto L53
    L39:
        r16 = null;
        goto L40
    L32:
        r14 = null;
        goto L34
    L28:
        r12 = null;
        goto L29
    L58:
        if (r7.size() != r10.size()) goto L64;
        return "-1:none";
    L64:
        return Math.min(r7.size(), r10.size()) + ":node_count";
    }

    private final String a(VHNode r3, VHNode r4) {
        VHNode r2 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r4, VHNode.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ScrollableVTNode.class) == false) goto L5;
        ScrollableVTNode r6 = (ScrollableVTNode) ZeusTransformUtils.preCheckCast(r2, ScrollableVTNode.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ScrollableVTNode.class) == false) goto L9;
        ScrollableVTNode r7 = (ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin");
    L10:
        if (r6 == null) goto L12;
        Boolean r8 = Boolean.valueOf(r6.isScrollable());
    L13:
        if (r7 == null) goto L15;
        Boolean r0 = Boolean.valueOf(r7.isScrollable());
    L17:
        if (o.a(r8, r0) == true) goto L19;
        return "scrollable";
    L19:
        if (r6 == null) goto L51;
        if (r7 != null) goto L23;
        return null;
    L23:
        if (r6.getScrollableVertical() == r7.getScrollableVertical()) goto L26;
        return "scroll_vertical";
    L26:
        if (r6.getScrollableHorizontal() == r7.getScrollableHorizontal()) goto L29;
        return "scroll_horizontal";
    L29:
        if (r6.getScrollableUp() == r7.getScrollableUp()) goto L32;
        return "scroll_up";
    L32:
        if (r6.getScrollableDown() == r7.getScrollableDown()) goto L35;
        return "scroll_down";
    L35:
        if (r6.getScrollableLeft() == r7.getScrollableLeft()) goto L38;
        return "scroll_left";
    L38:
        if (r6.getScrollableRight() == r7.getScrollableRight()) goto L41;
        return "scroll_right";
    L41:
        if (r6.getScrollableRange() == r7.getScrollableRange()) goto L44;
        return "scroll_range";
    L44:
        if (r6.getScrollableOffset() == r7.getScrollableOffset()) goto L47;
        return "scroll_offset";
    L47:
        if (r6.getScrollableExtent() == r7.getScrollableExtent()) goto L60;
        return "scroll_extent";
    L60:
        return null;
    L51:
        return null;
    L15:
        r0 = null;
        goto L17
    L12:
        r8 = null;
        goto L13
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }
}
