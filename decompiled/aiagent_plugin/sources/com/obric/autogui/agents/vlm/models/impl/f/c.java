package com.obric.autogui.agents.vlm.models.impl.f;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.AODeviceSpecificTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewHierarchyProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "VH-Protocol";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f27903a = null;

    static {
        f27903a = new c();
    }

    private c() {
    }

    public final JsonElement a(List<ViewHierarchyDump> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "vhdList");
        JsonArray r6 = new JsonArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L13;
        Object r2 = r7.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        p.c();
    L8:
        ViewHierarchyDump r8 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r2, ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        JsonObject r9 = f27903a.a(r8);
        if (r9 == null) goto L11;
        r6.add((JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.aiagent.plugin"));
    L11:
        r1 = r3;
        goto L4
    L13:
        if (r6.isEmpty() == false) goto L16;
        return null;
    L16:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.aiagent.plugin");
    }

    private final JsonObject a(ViewHierarchyDump r5) {
        m<Integer, Integer> r4 = AODeviceSpecificTools.INSTANCE.getScreenDimensions();
        int r1 = 0;
        if (r4 == null) goto L5;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r4.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        if (r4 == null) goto L8;
        r1 = ((Number) ZeusTransformUtils.preCheckCast(r4.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L8:
        VHNode r6 = r5.getRootNode();
        if (r6 != null) goto L11;
        Loog.INSTANCE.e(TAG, "[VHD-Json] no root node found in VHD: " + r5 + '.');
        return null;
    L11:
        return f27903a.a(r6, r2, r1);
    L5:
        r2 = 0;
        goto L6
    }

    private final JsonObject a(VHNode r7, int r8, int r9) {
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r7, VHNode.class, "com.obric.aiagent.plugin");
        JsonObject r1 = null;
        if (r6.getBounds().getWidth() != 0) goto L5;
    L55:
        return r1;
    L5:
        if (r6.getBounds().getHeight() == 0) goto L55;
        if (r6.getBounds().getScreenLeft() == 0) goto L9;
    L15:
        JsonArray r10 = new JsonArray();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r2.hasNext() == false) goto L21;
        JsonObject r3 = f27903a.a((VHNode) ZeusTransformUtils.preCheckCast(r2.next(), VHNode.class, "com.obric.aiagent.plugin"), r8, r9);
        if (r3 == null) goto L17;
        r10.add((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L17
    L21:
        boolean r4 = false;
        if (r6.isClickable() == false) goto L24;
    L35:
        boolean r5 = true;
    L37:
        if (r10.size() != 0) goto L40;
        if (r5 == true) goto L40;
        return null;
    L40:
        r1 = new JsonObject();
        r1.addProperty("class", r6.getClassName());
        r1.addProperty("view_id", r6.getId());
        r1.addProperty("clickable", Boolean.valueOf(r6.isClickable()));
        r1.addProperty("long_clickable", Boolean.valueOf(r6.isLongClickable()));
        if (ZeusTransformUtils.instanceOf(r6, ScrollableVTNode.class) == true) goto L43;
    L45:
        r1.addProperty("scrollable", Boolean.valueOf(r4));
        r1.addProperty("is_focused", Boolean.valueOf(r6.isFocused()));
        r1.addProperty("input_type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r6.getInputType()), Number.class, "com.obric.aiagent.plugin"));
        JsonObject r11 = new JsonObject();
        float r12 = r8;
        r11.addProperty("width", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getWidth() / r12), Number.class, "com.obric.aiagent.plugin"));
        float r13 = r9;
        r11.addProperty("height", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getHeight() / r13), Number.class, "com.obric.aiagent.plugin"));
        r11.addProperty("left", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getScreenLeft() / r12), Number.class, "com.obric.aiagent.plugin"));
        r11.addProperty("top", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getScreenTop() / r13), Number.class, "com.obric.aiagent.plugin"));
        r11.addProperty("right", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getScreenRight() / r12), Number.class, "com.obric.aiagent.plugin"));
        r11.addProperty("bottom", (Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r6.getBounds().getScreenBottom() / r13), Number.class, "com.obric.aiagent.plugin"));
        x r14 = x.f38692a;
        r1.add("bounds", (JsonElement) ZeusTransformUtils.preCheckCast(r11, JsonElement.class, "com.obric.aiagent.plugin"));
        r6.getText();
        if (ZeusTransformUtils.instanceOf(r6, ScrollableVTNode.class) == true) goto L48;
    L54:
        r1.add("children", (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L55
    L48:
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == false) goto L54;
        JsonObject r15 = new JsonObject();
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableHorizontal() == false) goto L52;
        String r16 = "horizontal";
    L53:
        r15.addProperty("orientation", r16);
        r15.addProperty("offset", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableOffset()), Number.class, "com.obric.aiagent.plugin"));
        r15.addProperty("range", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRange()), Number.class, "com.obric.aiagent.plugin"));
        r15.addProperty("visible_extent", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableExtent()), Number.class, "com.obric.aiagent.plugin"));
        r15.addProperty("scrollable_left", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableLeft()));
        r15.addProperty("scrollable_up", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableUp()));
        r15.addProperty("scrollable_right", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRight()));
        r15.addProperty("scrollable_down", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableDown()));
        x r17 = x.f38692a;
        r1.add("scroll_extras", (JsonElement) ZeusTransformUtils.preCheckCast(r15, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L54
    L52:
        r16 = "vertical";
        goto L53
    L43:
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == false) goto L45;
        r4 = true;
        goto L45
    L24:
        if (r6.isLongClickable() == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r6, ScrollableVTNode.class) == false) goto L30;
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r6, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == true) goto L35;
    L30:
        if (r6.isFocused() == true) goto L35;
        if (r6.getInputType() > 0) goto L35;
        r5 = false;
        goto L37
    L9:
        if (r6.getBounds().getScreenTop() != 0) goto L15;
        if (r6.getBounds().getScreenRight() != 0) goto L15;
        if (r6.getBounds().getScreenBottom() != 0) goto L15;
        goto L15
    }
}
