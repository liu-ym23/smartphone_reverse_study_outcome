package com.obric.autogui.agents.vlm.models.omni.upload.b;

import android.os.Bundle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.n;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniUploadViewTreeProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "OmniUploadVTProtocol";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f28630a = null;

    static {
        f28630a = new d();
    }

    private d() {
    }

    public final String a(List<ViewHierarchyDump> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r3 = null;
        if (r1 == false) goto L29;
        return null;
    L29:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L21
        d r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        JsonObject r5 = new JsonObject();     // Catch: Throwable -> L21
        JsonArray r6 = new JsonArray();     // Catch: Throwable -> L21
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L14:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();     // Catch: Throwable -> L21
        int r12 = r2 + 1;     // Catch: Throwable -> L21
        if (r2 >= 0) goto L18;
        p.c();     // Catch: Throwable -> L21
    L18:
        r6.add((JsonElement) ZeusTransformUtils.preCheckCast(r9.a((ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r8, ViewHierarchyDump.class, "com.obric.aiagent.plugin"), r2), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        r2 = r12;
        goto L14
    L19:
        r5.add("windows", (JsonElement) ZeusTransformUtils.preCheckCast(r6, JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        r5.addProperty("window_count", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r11.size()), Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        Object r13 = n.f(r5.toString());     // Catch: Throwable -> L21
    L23:
        Throwable r14 = n.c(r13);
        if (r14 != null) goto L26;
        r3 = r13;
    L28:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L26:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "serialize view tree failed", r14);
    L21:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(o.a(th));
        goto L23
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JsonObject a(ViewHierarchyDump r4, int r5) {
        JsonObject r3 = new JsonObject();
        r3.addProperty("window_index", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getWindowIndex()), Number.class, "com.obric.aiagent.plugin"));
        r3.addProperty("dump_index", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Number.class, "com.obric.aiagent.plugin"));
        r3.addProperty("data_size", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r4.getDataSize()), Number.class, "com.obric.aiagent.plugin"));
        VHNode r6 = r4.getRootNode();
        if (r6 == null) goto L5;
        r3.add("root", (JsonElement) ZeusTransformUtils.preCheckCast(f28630a.a(r6), JsonElement.class, "com.obric.aiagent.plugin"));
    L6:
        return r3;
    L5:
        r3.add("root", null);
        goto L6
    }

    private final JsonObject a(VHNode r6) {
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r6, VHNode.class, "com.obric.aiagent.plugin");
        JsonObject r7 = new JsonObject();
        r7.addProperty("class", r5.getClassName());
        r7.addProperty("view_id", r5.getId());
        CharSequence r1 = r5.getText();
        com.obric.autogui.platforms.tools.internal.viewhierarchy.a r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        r7.addProperty("text", r3);
        CharSequence r4 = r5.getHint();
        if (r4 == null) goto L9;
        String r8 = r4.toString();
    L10:
        r7.addProperty("hint", r8);
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == false) goto L13;
        com.obric.autogui.platforms.tools.internal.viewhierarchy.a r9 = (com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin");
    L14:
        if (r9 == null) goto L20;
        CharSequence r10 = r9.a().getContentDescription();
        if (r10 == null) goto L18;
        String r11 = r10.toString();
    L19:
        r7.addProperty("content_description", r11);
        goto L20
    L18:
        r11 = null;
    L20:
        r7.addProperty("clickable", Boolean.valueOf(r5.isClickable()));
        r7.addProperty("long_clickable", Boolean.valueOf(r5.isLongClickable()));
        r7.addProperty("enabled", Boolean.valueOf(r5.isEnabled()));
        r7.addProperty("focused", Boolean.valueOf(r5.isFocused()));
        r7.addProperty("input_type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getInputType()), Number.class, "com.obric.aiagent.plugin"));
        r7.addProperty("visibility", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getVisibility()), Number.class, "com.obric.aiagent.plugin"));
        JsonObject r12 = new JsonObject();
        r12.addProperty("left", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getLeft()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("top", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getTop()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("screen_left", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getScreenLeft()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("screen_top", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getScreenTop()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("screen_right", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getScreenRight()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("screen_bottom", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getScreenBottom()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("width", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getWidth()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("height", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.getBounds().getHeight()), Number.class, "com.obric.aiagent.plugin"));
        x r13 = x.f38692a;
        r7.add("bounds", (JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r5, ScrollableVTNode.class) == false) goto L26;
        r7.addProperty("scrollable", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable()));
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == false) goto L26;
        JsonObject r14 = new JsonObject();
        r14.addProperty("vertical", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableVertical()));
        r14.addProperty("horizontal", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableHorizontal()));
        r14.addProperty("scrollable_up", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableUp()));
        r14.addProperty("scrollable_down", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableDown()));
        r14.addProperty("scrollable_left", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableLeft()));
        r14.addProperty("scrollable_right", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRight()));
        r14.addProperty("range", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRange()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("offset", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableOffset()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("extent", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r5, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableExtent()), Number.class, "com.obric.aiagent.plugin"));
        x r15 = x.f38692a;
        r7.add("scroll_extras", (JsonElement) ZeusTransformUtils.preCheckCast(r14, JsonElement.class, "com.obric.aiagent.plugin"));
    L26:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == false) goto L28;
        r2 = (com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin");
    L28:
        if (r2 == null) goto L32;
        JsonElement r16 = f28630a.a(r2.a().getExtras());
        if (r16 == null) goto L32;
        r7.add("extras", r16);
    L32:
        JsonArray r17 = new JsonArray();
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        r17.add((JsonElement) ZeusTransformUtils.preCheckCast(f28630a.a((VHNode) ZeusTransformUtils.preCheckCast(r18.next(), VHNode.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L34
    L36:
        r7.add("children", (JsonElement) ZeusTransformUtils.preCheckCast(r17, JsonElement.class, "com.obric.aiagent.plugin"));
        return r7;
    L13:
        r9 = null;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final JsonElement a(Bundle r7) {
        Object r1 = null;
        if (r7 != null) goto L5;
    L33:
        return null;
    L5:
        if (r7.isEmpty() == true) goto L33;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L25
        d r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        JsonObject r8 = new JsonObject();     // Catch: Throwable -> L25
        Iterator<String> r3 = r7.keySet().iterator();     // Catch: Throwable -> L25
    L9:
        if (r3.hasNext() == false) goto L23;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Object r5 = r7.get(r4);     // Catch: Throwable -> L25
        if (r5 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r5, Character.class) == true) goto L21;
        r8.addProperty(r4, r5.toString());     // Catch: Throwable -> L25
        goto L9
    L21:
        r8.addProperty(r4, (Character) ZeusTransformUtils.preCheckCast(r5, Character.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        goto L9
    L18:
        r8.addProperty(r4, (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        goto L9
    L15:
        r8.addProperty(r4, (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        goto L9
    L12:
        r8.add(r4, null);     // Catch: Throwable -> L25
        goto L9
    L23:
        Object r9 = n.f(r8);     // Catch: Throwable -> L25
    L27:
        Throwable r10 = n.c(r9);
        if (r10 != null) goto L30;
        r1 = r9;
    L32:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin");
    L30:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "serialize extras bundle failed", r10);
    L25:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(o.a(th));
        goto L27
    }
}
