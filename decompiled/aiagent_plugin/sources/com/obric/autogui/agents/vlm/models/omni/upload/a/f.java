package com.obric.autogui.agents.vlm.models.omni.upload.a;

import android.os.Bundle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniUploadReactViewTreeProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "OmniReactViewTreeProto";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f28564a = null;

    /* JADX INFO: compiled from: OmniUploadReactViewTreeProtocol.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f28566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Integer f28568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f28569e;
        private final Integer f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28565a, r6.f28565a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28566b, r6.f28566b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f28567c, r6.f28567c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f28568d, r6.f28568d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f28569e, r6.f28569e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = this.f28565a.hashCode() * 31;
            Integer r1 = this.f28566b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f28567c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.f28568d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.f28569e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.f;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "CaptureMetadata(stepId=" + this.f28565a + ", stepIndex=" + this.f28566b + ", actionType=" + this.f28567c + ", eventId=" + this.f28568d + ", multiStepIndex=" + this.f28569e + ", multiStepCount=" + this.f + ')';
        }

        public a(String r2, Integer r3, String r4, Integer r5, Integer r6, Integer r7) {
            o.e(r2, "stepId");
            this.f28565a = r2;
            this.f28566b = r3;
            this.f28567c = r4;
            this.f28568d = r5;
            this.f28569e = r6;
            this.f = r7;
        }

        public final String a() {
            return this.f28565a;
        }

        public final Integer b() {
            return this.f28566b;
        }

        public final String c() {
            return this.f28567c;
        }

        public final Integer d() {
            return this.f28568d;
        }

        public final Integer e() {
            return this.f28569e;
        }

        public final Integer f() {
            return this.f;
        }
    }

    static {
        f28564a = new f();
    }

    private f() {
    }

    public final String a(String r6, VHNode r7, a r8) {
        VHNode r9 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r7, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r8, "metadata");
        Object r0 = null;
        if (r9 != null) goto L34;
        return null;
    L34:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L26
        f r5 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        JsonObject r3 = new JsonObject();     // Catch: Throwable -> L26
        List<JsonObject> r10 = r5.a(r6);     // Catch: Throwable -> L26
        JsonObject r11 = r5.a(r9, r8);     // Catch: Throwable -> L26
        if (r5.a(r10, r8) == true) goto L8;
        r10.add(r11);     // Catch: Throwable -> L26
    L8:
        JsonObject r12 = (JsonObject) ZeusTransformUtils.preCheckCast(p.l(r10), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r12 == null) goto L19;
        JsonElement r13 = r12.get("node");     // Catch: Throwable -> L26
        if (r13 == null) goto L19;
        if (r13.isJsonObject() == true) goto L17;
        r13 = null;
    L17:
        if (r13 == null) goto L19;
    L20:
        r3.addProperty("schema_version", (Number) ZeusTransformUtils.preCheckCast(2, Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        r3.add("node", r13.deepCopy());     // Catch: Throwable -> L26
        r3.addProperty("capture_count", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r10.size()), Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        JsonArray r14 = new JsonArray();     // Catch: Throwable -> L26
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L26
    L22:
        if (r15.hasNext() == false) goto L24;
        r14.add((JsonElement) ZeusTransformUtils.preCheckCast((JsonObject) ZeusTransformUtils.preCheckCast(r15.next(), JsonObject.class, "com.obric.aiagent.plugin"), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        goto L22
    L24:
        x r16 = x.f38692a;     // Catch: Throwable -> L26
        r3.add("captures", (JsonElement) ZeusTransformUtils.preCheckCast(r14, JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        Object r17 = n.f(r3.toString());     // Catch: Throwable -> L26
    L28:
        Throwable r18 = n.c(r17);
        if (r18 != null) goto L31;
        r0 = r17;
    L33:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L31:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "serialize react_view_tree failed", r18);
    L19:
        r13 = r11.get("node");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a r19 = n.f38560a;
        r17 = n.f(d.o.a(th));
        goto L28
    }

    private final List<JsonObject> a(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L14
        f r4 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r6 = n.f(JsonParser.parseString(r5).getAsJsonObject());     // Catch: Throwable -> L14
    L17:
        if (n.b(r6) == false) goto L19;
        r6 = null;
    L19:
        JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L22;
        List<JsonObject> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        JsonElement r3 = r7.get("captures");
        if (r3 != null) goto L26;
    L39:
        JsonElement r9 = r7.get("node");
        if (r9 != null) goto L42;
    L44:
        return r8;
    L42:
        if (r9.isJsonObject() == false) goto L44;
        JsonObject r10 = new JsonObject();
        r10.add("node", r9.deepCopy());
        r8.add(r10);
        goto L44
    L26:
        if (r3.isJsonArray() == false) goto L39;
        Iterator<JsonElement> r11 = r3.getAsJsonArray().iterator();
        o.c(r11, "iterator(...)");
    L29:
        if (r11.hasNext() == false) goto L38;
        JsonElement r12 = (JsonElement) ZeusTransformUtils.preCheckCast(r11.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r12.isJsonObject() == false) goto L29;
        JsonObject r13 = r12.getAsJsonObject();
        JsonElement r14 = r13.get("node");
        if (r14 == null) goto L29;
        if (r14.isJsonObject() == false) goto L29;
        o.a(r13);
        r8.add(r13);
        goto L29
    L38:
        return r8;
    L22:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L14:
        th = move-exception;
        n.a r15 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L17
    L11:
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean a(List<JsonObject> r8, a r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Integer r10 = r9.d();
        if (r10 == null) goto L45;
        int r11 = r10.intValue();
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L7;
    L9:
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L47;
        JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r13.next(), JsonObject.class, "com.obric.aiagent.plugin");
        JsonElement r4 = r2.get("event_id");
        String r5 = null;
        if (r4 != null) goto L15;
    L20:
        Integer r6 = null;
    L21:
        JsonElement r3 = r2.get("step_id");
        if (r3 != null) goto L24;
    L29:
        if (r6 != null) goto L32;
    L36:
        boolean r14 = false;
    L37:
        if (r14 == false) goto L11;
        return true;
    L32:
        if (r6.intValue() != r11) goto L36;
        if (o.a(r5, r9.a()) == false) goto L36;
        r14 = true;
        goto L37
    L24:
        if ((!r3.isJsonNull()) == true) goto L27;
        r3 = null;
    L27:
        if (r3 == null) goto L29;
        r5 = r3.getAsString();
        goto L29
    L15:
        if ((!r4.isJsonNull()) == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L20;
        r6 = Integer.valueOf(r4.getAsInt());
        goto L21
    L47:
        return false;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        return false;
    L45:
        return false;
    }

    private final JsonObject a(VHNode r5, a r6) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r5, VHNode.class, "com.obric.aiagent.plugin");
        JsonObject r7 = new JsonObject();
        f r1 = f28564a;
        String r2 = r6.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        r1.a(r7, "step_id", r2);
        r1.a(r7, "step_index", (Number) ZeusTransformUtils.preCheckCast(r6.b(), Number.class, "com.obric.aiagent.plugin"));
        r1.a(r7, "multi_step_idx", (Number) ZeusTransformUtils.preCheckCast(r6.e(), Number.class, "com.obric.aiagent.plugin"));
        r1.a(r7, "multi_step_size", (Number) ZeusTransformUtils.preCheckCast(r6.f(), Number.class, "com.obric.aiagent.plugin"));
        r1.a(r7, "action_type", r6.c());
        r1.a(r7, "event_id", (Number) ZeusTransformUtils.preCheckCast(r6.d(), Number.class, "com.obric.aiagent.plugin"));
        r7.add("node", (JsonElement) ZeusTransformUtils.preCheckCast(r1.a(r4), JsonElement.class, "com.obric.aiagent.plugin"));
        return r7;
    }

    private final JsonObject a(VHNode r5) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r5, VHNode.class, "com.obric.aiagent.plugin");
        JsonObject r6 = new JsonObject();
        f28564a.a(r6, r4);
        JsonArray r1 = new JsonArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        VHNode r2 = (VHNode) ZeusTransformUtils.preCheckCast(r7.next(), VHNode.class, "com.obric.aiagent.plugin");
        r1.add((JsonElement) ZeusTransformUtils.preCheckCast(f28564a.a(r2), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        r6.add("children", (JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        return r6;
    }

    private final void a(JsonObject r5, VHNode r6) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r6, VHNode.class, "com.obric.aiagent.plugin");
        r5.addProperty("class", r4.getClassName());
        r5.addProperty("view_id", r4.getId());
        CharSequence r7 = r4.getText();
        com.obric.autogui.platforms.tools.internal.viewhierarchy.a r1 = null;
        if (r7 == null) goto L5;
        String r8 = r7.toString();
    L6:
        r5.addProperty("text", r8);
        CharSequence r9 = r4.getHint();
        if (r9 == null) goto L9;
        String r10 = r9.toString();
    L10:
        r5.addProperty("hint", r10);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == false) goto L13;
        com.obric.autogui.platforms.tools.internal.viewhierarchy.a r11 = (com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin");
    L14:
        if (r11 == null) goto L20;
        CharSequence r12 = r11.a().getContentDescription();
        if (r12 == null) goto L18;
        String r13 = r12.toString();
    L19:
        r5.addProperty("content_description", r13);
        goto L20
    L18:
        r13 = null;
    L20:
        r5.addProperty("clickable", Boolean.valueOf(r4.isClickable()));
        r5.addProperty("long_clickable", Boolean.valueOf(r4.isLongClickable()));
        r5.addProperty("enabled", Boolean.valueOf(r4.isEnabled()));
        r5.addProperty("focused", Boolean.valueOf(r4.isFocused()));
        r5.addProperty("input_type", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getInputType()), Number.class, "com.obric.aiagent.plugin"));
        r5.addProperty("visibility", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getVisibility()), Number.class, "com.obric.aiagent.plugin"));
        JsonObject r14 = new JsonObject();
        r14.addProperty("left", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getLeft()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("top", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getTop()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("screen_left", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getScreenLeft()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("screen_top", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getScreenTop()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("screen_right", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getScreenRight()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("screen_bottom", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getScreenBottom()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("width", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getWidth()), Number.class, "com.obric.aiagent.plugin"));
        r14.addProperty("height", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4.getBounds().getHeight()), Number.class, "com.obric.aiagent.plugin"));
        x r2 = x.f38692a;
        r5.add("bounds", (JsonElement) ZeusTransformUtils.preCheckCast(r14, JsonElement.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r4, ScrollableVTNode.class) == false) goto L26;
        r5.addProperty("scrollable", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable()));
        if (((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).isScrollable() == false) goto L26;
        JsonObject r15 = new JsonObject();
        r15.addProperty("vertical", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableVertical()));
        r15.addProperty("horizontal", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableHorizontal()));
        r15.addProperty("scrollable_up", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableUp()));
        r15.addProperty("scrollable_down", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableDown()));
        r15.addProperty("scrollable_left", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableLeft()));
        r15.addProperty("scrollable_right", Boolean.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRight()));
        r15.addProperty("range", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableRange()), Number.class, "com.obric.aiagent.plugin"));
        r15.addProperty("offset", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableOffset()), Number.class, "com.obric.aiagent.plugin"));
        r15.addProperty("extent", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScrollableVTNode) ZeusTransformUtils.preCheckCast(r4, ScrollableVTNode.class, "com.obric.aiagent.plugin")).getScrollableExtent()), Number.class, "com.obric.aiagent.plugin"));
        x r3 = x.f38692a;
        r5.add("scroll_extras", (JsonElement) ZeusTransformUtils.preCheckCast(r15, JsonElement.class, "com.obric.aiagent.plugin"));
    L26:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class) == false) goto L28;
        r1 = (com.obric.autogui.platforms.tools.internal.viewhierarchy.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.platforms.tools.internal.viewhierarchy.a.class, "com.obric.aiagent.plugin");
    L28:
        if (r1 == null) goto L33;
        JsonElement r16 = f28564a.a(r1.a().getExtras());
        if (r16 == null) goto L34;
        r5.add("extras", r16);
        return;
    L34:
        return;
    L33:
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    private final void a(JsonObject r2, String r3, String r4) {
        if (r4 != null) goto L4;
        r2.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        r2.addProperty(r3, r4);
    }

    private final void a(JsonObject r2, String r3, Number r4) {
        if (r4 != null) goto L4;
        r2.add(r3, (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        r2.addProperty(r3, r4);
    }

    private final JsonElement a(Bundle r7) {
        Object r1 = null;
        if (r7 != null) goto L5;
    L33:
        return null;
    L5:
        if (r7.isEmpty() == true) goto L33;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L25
        f r6 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
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
        r8.add(r4, (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
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
        r9 = n.f(d.o.a(th));
        goto L27
    }
}
