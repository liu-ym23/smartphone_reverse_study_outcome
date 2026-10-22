package com.obric.agent.a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.assistant.idl.bean.AppletBlock;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.n;
import d.n.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AlarmWidgetSyncCodec.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14231a = null;

    /* JADX INFO: compiled from: AlarmWidgetSyncCodec.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<AlarmEntity> f14234c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14232a, r6.f14232a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14233b, r6.f14233b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14234c, r6.f14234c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14232a.hashCode() * 31) + this.f14233b.hashCode()) * 31) + this.f14234c.hashCode();
        }

        public String toString() {
            return "ParsedWidget(blockId=" + this.f14232a + ", renderData=" + this.f14233b + ", alarmEntities=" + this.f14234c + ')';
        }

        public a(String r3, String r4, List<AlarmEntity> r5) {
            List<AlarmEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "blockId");
            o.e(r4, "renderData");
            o.e(r6, "alarmEntities");
            this.f14232a = r3;
            this.f14233b = r4;
            this.f14234c = r6;
        }

        public final String a() {
            return this.f14232a;
        }

        public final String b() {
            return this.f14233b;
        }

        public final List<AlarmEntity> c() {
            return this.f14234c;
        }
    }

    /* JADX INFO: compiled from: AlarmWidgetSyncCodec.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonObject f14235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JsonObject f14236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f14237c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14235a, r6.f14235a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14236b, r6.f14236b) == true) goto L15;
            return false;
        L15:
            if (this.f14237c == r6.f14237c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14235a.hashCode() * 31) + this.f14236b.hashCode()) * 31) + Boolean.hashCode(this.f14237c);
        }

        public String toString() {
            return "WidgetDocument(root=" + this.f14235a + ", widgetData=" + this.f14236b + ", widgetDataIsString=" + this.f14237c + ')';
        }

        public b(JsonObject r2, JsonObject r3, boolean r4) {
            o.e(r2, "root");
            o.e(r3, "widgetData");
            this.f14235a = r2;
            this.f14236b = r3;
            this.f14237c = r4;
        }

        public final JsonObject a() {
            return this.f14236b;
        }

        public final String b() {
            if (this.f14237c == false) goto L5;
            this.f14235a.addProperty("widget_data", this.f14236b.toString());
        L6:
            String r5 = this.f14235a.toString();
            o.c(r5, "toString(...)");
            return r5;
        L5:
            this.f14235a.add("widget_data", (JsonElement) ZeusTransformUtils.preCheckCast(this.f14236b, JsonElement.class, "com.obric.aiagent.plugin"));
            goto L6
        }
    }

    static {
        f14231a = new d();
    }

    public static /* synthetic */ boolean lambda$k8aqJoNxpQ3DV_z4VFFVE8g9DtE(Block r0) {
        return a(r0);
    }

    public static /* synthetic */ a lambda$kBBLbCyZzud41xk_akZD6Fasgnw(d r0, Block r1) {
        return a(r0, r1);
    }

    private d() {
    }

    public final a a(List<Block> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        final d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        r4 = p.b();     // Catch: Throwable -> L8
    L6:
        Object r5 = n.f((a) ZeusTransformUtils.preCheckCast(m.d(m.e(m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$d$k8aqJoNxpQ3DV_z4VFFVE8g9DtE.INSTANCE), new $$Lambda$d$kBBLbCyZzud41xk_akZD6Fasgnw(r2))), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L11:
        if (n.b(r5) == false) goto L14;
        r5 = null;
    L14:
        return (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L11
    }

    private static final boolean a(Block r1) {
        o.e(r1, "it");
        if (r1.getBlockType() != 10017) goto L5;
        return true;
    L5:
        return false;
    }

    private static final a a(d r9, Block r10) {
        o.e(r10, "block");
        String r0 = r10.getBlockId();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L50;
        BlockContent r11 = r10.getContent();
        if (r11 == null) goto L45;
        AppletBlock r12 = r11.getAppletBlock();
        if (r12 == null) goto L46;
        String r13 = r12.renderData;
        if (r13 != null) goto L17;
        return null;
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r13 = null;
    L20:
        if (r13 == null) goto L48;
        b r2 = r9.a(r13);
        if (r2 != null) goto L24;
        return null;
    L24:
        Iterable<JsonElement> r3 = r9.a(r2.a().getAsJsonArray("cards"));
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<JsonElement> r5 = r3.iterator();
    L26:
        if (r5.hasNext() == false) goto L34;
        Iterable<JsonElement> r6 = r9.a(((JsonElement) ZeusTransformUtils.preCheckCast(r5.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject().getAsJsonArray("items"));
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<JsonElement> r8 = r6.iterator();
    L29:
        if (r8.hasNext() == false) goto L33;
        JsonObject r14 = ((JsonElement) ZeusTransformUtils.preCheckCast(r8.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();
        o.c(r14, "getAsJsonObject(...)");
        AlarmEntity r15 = r9.a(r14);
        if (r15 == null) goto L29;
        r7.add(r15);
        goto L29
    L33:
        p.a(r4, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        goto L26
    L34:
        a r16 = new a(r0, r13, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16.c(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L37;
        return null;
    L37:
        return r16;
    L48:
        return null;
    L46:
        return null;
    L45:
        return null;
    L50:
        return null;
    }

    public final String a(String r11, Map<String, AlarmEntity> r12, Set<String> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        o.e(r11, "renderData");
        o.e(r14, "alarmEntities");
        o.e(r15, "deletedAlarmIds");
        Object r1 = null;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L32
        d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        b r16 = r10.a(r11);     // Catch: Throwable -> L32
        if (r16 != null) goto L6;
        return null;
    L6:
        Iterator<JsonElement> r4 = r10.a(r16.a().getAsJsonArray("cards")).iterator();     // Catch: Throwable -> L32
    L8:
        if (r4.hasNext() == false) goto L30;
        Iterator<JsonElement> r5 = r10.a(((JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject().getAsJsonArray("items")).iterator();     // Catch: Throwable -> L32
    L11:
        if (r5.hasNext() == false) goto L8;
        JsonObject r6 = ((JsonElement) ZeusTransformUtils.preCheckCast(r5.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();     // Catch: Throwable -> L32
        o.a(r6);     // Catch: Throwable -> L32
        AlarmEntity r7 = r10.a(r6);     // Catch: Throwable -> L32
        if (r7 == null) goto L11;
        String r8 = r7.getId();     // Catch: Throwable -> L32
        if (r8 == null) goto L11;
        AlarmEntity r9 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r14.get(r8), AlarmEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r9 == null) goto L11;
        r6.add("entity", EntityExtKt.a().toJsonTree(r9));     // Catch: Throwable -> L32
        JsonElement r17 = r6.get("state");     // Catch: Throwable -> L32
        if (r17 != null) goto L23;
    L28:
        String r18 = null;
    L29:
        r6.addProperty("state", r10.a(r18, r15.contains(r8)));     // Catch: Throwable -> L32
        goto L11
    L23:
        if (r17.isJsonPrimitive() == true) goto L26;
        r17 = null;
    L26:
        if (r17 == null) goto L28;
        r18 = r17.getAsString();     // Catch: Throwable -> L32
        goto L29
    L30:
        Object r19 = n.f(r16.b());     // Catch: Throwable -> L32
    L35:
        if (n.b(r19) == true) goto L39;
        r1 = r19;
    L39:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L32:
        th = move-exception;
        n.a r110 = n.f38560a;
        r19 = n.f(d.o.a(th));
        goto L35
    }

    private final String a(String r2, boolean r3) {
        if (r3 == false) goto L6;
        return "deleted";
    L6:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(ax.a(new String[]{"deleted", "failed", "resolved"}), Iterable.class, "com.obric.aiagent.plugin"), r2) == false) goto L9;
        if (r2 != null) goto L12;
        return "";
    L12:
        return r2;
    L9:
        return "normal";
    }

    private final AlarmEntity a(JsonObject r4) {
        JsonObject r5 = r4.getAsJsonObject("entity");
        if (r5 != null) goto L18;
        return null;
    L18:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r6 = n.f((AlarmEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"), AlarmEntity.class), AlarmEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
    L10:
        if (n.b(r6) == false) goto L12;
        r6 = null;
    L12:
        AlarmEntity r7 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r6, AlarmEntity.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L15;
        return null;
    L15:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L17;
        return null;
    L17:
        return r7;
    L7:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L10
    }

    private final b a(String r5) {
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L31
        d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        JsonObject r6 = JsonParser.parseString(r5).getAsJsonObject();     // Catch: Throwable -> L31
        JsonElement r7 = r6.get("applet_id");     // Catch: Throwable -> L31
        if (r7 == null) goto L6;
        String r8 = r7.getAsString();     // Catch: Throwable -> L31
    L8:
        if (o.a(r8, "ability.intent.card") == false) goto L30;
        JsonElement r9 = r6.get("widget_id");     // Catch: Throwable -> L31
        if (r9 == null) goto L12;
        String r10 = r9.getAsString();     // Catch: Throwable -> L31
    L14:
        if (o.a(r10, "appintent_alarm") == false) goto L30;
        JsonElement r11 = r6.get("widget_data");     // Catch: Throwable -> L31
        if (r11 != null) goto L20;
        return null;
    L20:
        if (r11.isJsonPrimitive() == true) goto L22;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L27;
        JsonObject r12 = JsonParser.parseString(r11.getAsString()).getAsJsonObject();     // Catch: Throwable -> L31
    L28:
        o.a(r6);     // Catch: Throwable -> L31
        o.a(r12);     // Catch: Throwable -> L31
        Object r13 = n.f(new b(r6, r12, r3));     // Catch: Throwable -> L31
    L34:
        if (n.b(r13) == true) goto L38;
        r1 = r13;
    L38:
        return (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
    L27:
        r12 = r11.getAsJsonObject();     // Catch: Throwable -> L31
        goto L28
    L22:
        if (r11.getAsJsonPrimitive().isString() == false) goto L24;
        r3 = true;
        goto L25
    L12:
        r10 = null;
    L30:
        return null;
    L6:
        r8 = null;
    L31:
        th = move-exception;
        n.a r14 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L34
    }

    private final Iterable<JsonElement> a(JsonArray r2) {
        Object r3 = r2;
        if (r2 != null) goto L7;
        r3 = p.b();
    L7:
        return (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
    }
}
