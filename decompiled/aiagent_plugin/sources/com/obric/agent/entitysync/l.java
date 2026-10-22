package com.obric.agent.entitysync;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppEntityWidgetSyncCodec.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14534a = null;

    /* JADX INFO: compiled from: AppEntityWidgetSyncCodec.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<i> f14536b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14535a, r6.f14535a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14536b, r6.f14536b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f14535a.hashCode() * 31) + this.f14536b.hashCode();
        }

        public String toString() {
            return "ParsedRenderData(widgetId=" + this.f14535a + ", entities=" + this.f14536b + ')';
        }

        public a(String r3, List<i> r4) {
            List<i> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "widgetId");
            o.e(r5, "entities");
            this.f14535a = r3;
            this.f14536b = r5;
        }

        public final String a() {
            return this.f14535a;
        }

        public final List<i> b() {
            return this.f14536b;
        }
    }

    /* JADX INFO: compiled from: AppEntityWidgetSyncCodec.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14537a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f14501a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[e.f14502b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[e.f14503c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[e.f14504d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f14537a = r0;
        }
    }

    /* JADX INFO: compiled from: AppEntityWidgetSyncCodec.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonObject f14538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JsonObject f14540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f14541d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14538a, r6.f14538a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14539b, r6.f14539b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14540c, r6.f14540c) == true) goto L18;
            return false;
        L18:
            if (this.f14541d == r6.f14541d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14538a.hashCode() * 31) + this.f14539b.hashCode()) * 31) + this.f14540c.hashCode()) * 31) + Boolean.hashCode(this.f14541d);
        }

        public String toString() {
            return "WidgetDocument(root=" + this.f14538a + ", widgetId=" + this.f14539b + ", widgetData=" + this.f14540c + ", encodedAsString=" + this.f14541d + ')';
        }

        public c(JsonObject r2, String r3, JsonObject r4, boolean r5) {
            o.e(r2, "root");
            o.e(r3, "widgetId");
            o.e(r4, "widgetData");
            this.f14538a = r2;
            this.f14539b = r3;
            this.f14540c = r4;
            this.f14541d = r5;
        }

        public final String a() {
            return this.f14539b;
        }

        public final JsonObject b() {
            return this.f14540c;
        }

        public final List<i> c() {
            Iterable r8 = l.a(l.f14534a, this.f14540c.getAsJsonArray("cards"));
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L25;
            JsonObject r1 = ((JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();
            JsonObject r3 = r1.getAsJsonObject("source_app");
            String r4 = null;
            if (r3 == null) goto L15;
            JsonElement r5 = r3.get("package_name");
            if (r5 == null) goto L15;
            if (r5.isJsonPrimitive() == true) goto L13;
            r5 = null;
        L13:
            if (r5 == null) goto L15;
            r4 = r5.getAsString();
        L15:
            if (r4 != null) goto L17;
            r4 = "";
        L17:
            Iterable r2 = l.a(l.f14534a, r1.getAsJsonArray("items"));
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r7 = r2.iterator();
        L19:
            if (r7.hasNext() == false) goto L23;
            JsonElement r10 = (JsonElement) ZeusTransformUtils.preCheckCast(r7.next(), JsonElement.class, "com.obric.aiagent.plugin");
            l r11 = l.f14534a;
            JsonObject r12 = r10.getAsJsonObject();
            o.c(r12, "getAsJsonObject(...)");
            i r13 = l.a(r11, r12, r4);
            if (r13 == null) goto L19;
            r6.add(r13);
            goto L19
        L23:
            p.a(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
            goto L4
        L25:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }

        public final String d() {
            if (this.f14541d == false) goto L5;
            this.f14538a.addProperty("widget_data", this.f14540c.toString());
        L6:
            String r5 = this.f14538a.toString();
            o.c(r5, "toString(...)");
            return r5;
        L5:
            this.f14538a.add("widget_data", (JsonElement) ZeusTransformUtils.preCheckCast(this.f14540c, JsonElement.class, "com.obric.aiagent.plugin"));
            goto L6
        }
    }

    static {
        f14534a = new l();
    }

    private l() {
    }

    public static final /* synthetic */ i a(l r0, JsonObject r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ Iterable a(l r0, JsonArray r1) {
        return r0.a(r1);
    }

    public final a a(String r4) {
        o.e(r4, "renderData");
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        c r3 = ((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin")).b(r4);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return null;
    L6:
        Object r5 = d.n.f(new a(r3.a(), r3.c()));     // Catch: Throwable -> L8
    L11:
        if (d.n.b(r5) == true) goto L15;
        r1 = r5;
    L15:
        return (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L11
    }

    public final String a(String r11, Map<com.obric.agent.entitysync.c, d> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        o.e(r11, "renderData");
        o.e(r13, "mutations");
        Object r0 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L47
        l r10 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        c r14 = r10.b(r11);     // Catch: Throwable -> L47
        if (r14 != null) goto L6;
        return null;
    L6:
        Iterator<JsonElement> r3 = r10.a(r14.b().getAsJsonArray("cards")).iterator();     // Catch: Throwable -> L47
    L8:
        if (r3.hasNext() == false) goto L45;
        JsonObject r4 = ((JsonElement) ZeusTransformUtils.preCheckCast(r3.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();     // Catch: Throwable -> L47
        JsonObject r5 = r4.getAsJsonObject("source_app");     // Catch: Throwable -> L47
        if (r5 == null) goto L19;
        JsonElement r6 = r5.get("package_name");     // Catch: Throwable -> L47
        if (r6 == null) goto L19;
        if (r6.isJsonPrimitive() == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L19;
        String r7 = r6.getAsString();     // Catch: Throwable -> L47
    L20:
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        Iterator<JsonElement> r8 = r10.a(r4.getAsJsonArray("items")).iterator();     // Catch: Throwable -> L47
    L24:
        if (r8.hasNext() == false) goto L8;
        JsonObject r9 = ((JsonElement) ZeusTransformUtils.preCheckCast(r8.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();     // Catch: Throwable -> L47
        o.a(r9);     // Catch: Throwable -> L47
        i r15 = r10.a(r9, r7);     // Catch: Throwable -> L47
        if (r15 == null) goto L24;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r13.get(r15.a()), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        if (r16 == null) goto L24;
        r9.add("entity", (JsonElement) ZeusTransformUtils.preCheckCast(r16.a().c().deepCopy(), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L47
        int r17 = b.f14537a[r16.b().ordinal()];     // Catch: Throwable -> L47
        if (r17 == 1) goto L24;
        if (r17 != 2) goto L37;
        r9.addProperty("state", "normal");     // Catch: Throwable -> L47
        goto L24
    L37:
        if (r17 != 3) goto L39;
        r9.addProperty("state", "deleted");     // Catch: Throwable -> L47
        goto L24
    L39:
        if (r17 != 4) goto L42;
        r9.addProperty("state", "disabled");     // Catch: Throwable -> L47
        goto L24
    L42:
        throw new d.k();     // Catch: Throwable -> L47
    L19:
        r7 = null;
        goto L20
    L45:
        Object r18 = d.n.f(r14.d());     // Catch: Throwable -> L47
    L50:
        if (d.n.b(r18) == true) goto L54;
        r0 = r18;
    L54:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L47:
        th = move-exception;
        d.n.a r19 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
        goto L50
    }

    public final String a(String r8, String r9, String r10, Set<String> r11) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        o.e(r8, "renderData");
        o.e(r9, "entityId");
        o.e(r10, "state");
        o.e(r12, "allowedWidgetIds");
        Object r3 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L40:
        return null;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L40;
        if (r12.isEmpty() == true) goto L40;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L32
        l r7 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        c r13 = r7.b(r8);     // Catch: Throwable -> L32
        if (r13 != null) goto L13;
        return null;
    L13:
        if (r12.contains(r13.a()) == true) goto L15;
        return null;
    L15:
        boolean r14 = false;
        Iterator<JsonElement> r4 = r7.a(r13.b().getAsJsonArray("cards")).iterator();     // Catch: Throwable -> L32
    L17:
        if (r4.hasNext() == false) goto L27;
        Iterator<JsonElement> r5 = r7.a(((JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject().getAsJsonArray("items")).iterator();     // Catch: Throwable -> L32
    L20:
        if (r5.hasNext() == false) goto L17;
        JsonObject r6 = ((JsonElement) ZeusTransformUtils.preCheckCast(r5.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();     // Catch: Throwable -> L32
        JsonObject r15 = r6.getAsJsonObject("entity");     // Catch: Throwable -> L32
        if (r15 == null) goto L20;
        if (o.a(r7.b(r15), r9) == false) goto L20;
        r6.addProperty("state", r10);     // Catch: Throwable -> L32
        r14 = true;
        goto L20
    L27:
        if (r14 == false) goto L29;
        String r16 = r13.d();     // Catch: Throwable -> L32
    L30:
        Object r17 = d.n.f(r16);     // Catch: Throwable -> L32
    L35:
        if (d.n.b(r17) == true) goto L39;
        r3 = r17;
    L39:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L29:
        r16 = null;
    L32:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r17 = d.n.f(d.o.a(th));
        goto L35
    }

    private final c b(String r5) {
        JsonObject r4 = JsonParser.parseString(r5).getAsJsonObject();
        JsonElement r6 = r4.get("applet_id");
        if (r6 == null) goto L5;
        String r7 = r6.getAsString();
    L7:
        if (o.a(r7, "ability.intent.card") == true) goto L9;
        return null;
    L9:
        JsonElement r8 = r4.get("widget_id");
        if (r8 == null) goto L12;
        String r9 = r8.getAsString();
    L13:
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        boolean r3 = false;
        if (d.o.o.b(r9, "appintent_", false, 2, null) == true) goto L18;
        return null;
    L18:
        JsonElement r1 = r4.get("widget_data");
        if (r1 != null) goto L22;
        return null;
    L22:
        if (r1.isJsonPrimitive() == true) goto L24;
    L26:
        if (r3 == false) goto L28;
        JsonObject r0 = JsonParser.parseString(r1.getAsString()).getAsJsonObject();
    L29:
        o.a(r4);
        o.a(r0);
        return new c(r4, r9, r0, r3);
    L28:
        r0 = r1.getAsJsonObject();
        goto L29
    L24:
        if (r1.getAsJsonPrimitive().isString() == false) goto L26;
        r3 = true;
        goto L26
    L12:
        r9 = null;
        goto L13
    L5:
        r7 = null;
        goto L7
    }

    private final i a(JsonObject r9, String r10) {
        JsonObject r11 = r9.getAsJsonObject("entity");
        Object r1 = null;
        if (r11 != null) goto L15;
        return null;
    L15:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
        l r8 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r12 = d.n.f(i.a.a(i.f14527a, r8.a(r11), r10, null, 4, null));     // Catch: Throwable -> L7
    L10:
        if (d.n.b(r12) == true) goto L14;
        r1 = r12;
    L14:
        return (i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r12 = d.n.f(d.o.a(th));
        goto L10
    }

    private final AppEntity a(JsonObject r3) {
        String r4 = r3.toString();
        o.c(r4, "toString(...)");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        l r2 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = d.n.f(AppEntity.CREATOR.fromJson(r4));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r5) == null) goto L12;
        r5 = AppEntity.CREATOR.fromJsonKeepTimeStamp(r4);
    L12:
        return (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L8
    }

    private final String b(JsonObject r2) {
        JsonElement r1 = r2.get(DbHelper.COL_ID);
        String r3 = null;
        if (r1 != null) goto L5;
    L12:
        if (r3 != null) goto L15;
        return "";
    L15:
        return r3;
    L5:
        if (r1.isJsonPrimitive() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        String r4 = r1.getAsString();
        if (r4 == null) goto L12;
        r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        goto L12
    }

    private final Iterable<JsonElement> a(JsonArray r2) {
        Object r3 = r2;
        if (r2 != null) goto L7;
        r3 = p.b();
    L7:
        return (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
    }
}
