package com.obric.agent;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SuccessfulEntityDeleteResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f16082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f16083b = null;

    /* JADX INFO: compiled from: SuccessfulEntityDeleteResolver.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f16084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.b<AppEntity, Boolean> f16085b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f16084a, r6.f16084a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f16085b, r6.f16085b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16084a.hashCode() * 31) + this.f16085b.hashCode();
        }

        public String toString() {
            return "DeleteSpec(fieldNames=" + this.f16084a + ", matches=" + this.f16085b + ')';
        }

        public a(Set<String> r3, d.h.a.b<? super AppEntity, Boolean> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            d.h.a.b<AppEntity, Boolean> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "fieldNames");
            d.h.b.o.e(r6, "matches");
            this.f16084a = r5;
            this.f16085b = r6;
        }

        public final Set<String> a() {
            return this.f16084a;
        }

        public final d.h.a.b<AppEntity, Boolean> b() {
            return this.f16085b;
        }
    }

    /* JADX INFO: compiled from: SuccessfulEntityDeleteResolver.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<AppEntity> f16086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f16087b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f16086a, r6.f16086a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f16087b, r6.f16087b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16086a.hashCode() * 31) + this.f16087b.hashCode();
        }

        public String toString() {
            return "ParsedDeleteTargets(entities=" + this.f16086a + ", ecaIds=" + this.f16087b + ')';
        }

        public b(List<AppEntity> r3, Set<String> r4) {
            List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "entities");
            d.h.b.o.e(r6, "ecaIds");
            this.f16086a = r5;
            this.f16087b = r6;
        }

        public /* synthetic */ b(List r2, Set r3, int r4, d.h.b.h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L6:
            if ((r4 & 2) == 0) goto L8;
            r7 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        L8:
            this(r6, r7);
        }

        public final List<AppEntity> a() {
            return this.f16086a;
        }

        public final Set<String> b() {
            return this.f16087b;
        }
    }

    /* JADX INFO: compiled from: SuccessfulEntityDeleteResolver.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<JsonElement, AppEntity> {
        c(Object r8) {
            super(1, r8, x.class, "parseEntity", "parseEntity(Lcom/google/gson/JsonElement;)Lcom/obric/capabilitykit/entity/app/AppEntity;", 0);
        }

        public final AppEntity a(JsonElement r3) {
            d.h.b.o.e(r3, "p0");
            return x.a((x) ZeusTransformUtils.preCheckCast(this.receiver, x.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ AppEntity invoke(JsonElement r3) {
            return a((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ boolean lambda$2OVJho7iC_2QkE3m24yFEoWaKC8(AppEntity r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$7926ZFiZqZsKpq8WoPBHrG6C430(AppEntity r0) {
        return h(r0);
    }

    public static /* synthetic */ boolean lambda$A1yaq6T72sn8SV_55fP6LCd8OwM(AppEntity r0) {
        return d(r0);
    }

    public static /* synthetic */ boolean lambda$GbTPlkBxosHb9S3yjv7U68ClgSE(AppEntity r0) {
        return g(r0);
    }

    public static /* synthetic */ boolean lambda$SH716vOUvOUleJeKicatFec2x6s(AppEntity r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$Y79m_WOMHMMHQ3E6SNtEKYsER44(AppEntity r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$ZxKhFwPkuu5D9jmmIwxZElEffig(AppEntity r0) {
        return c(r0);
    }

    public static /* synthetic */ d.r lambda$v43LqROaLKC9mBcCCITRHlKYDgs(AppEntity r0) {
        return i(r0);
    }

    public static /* synthetic */ boolean lambda$zNQtbiQU61WRMlQDLAVBymU5RZ4(AppEntity r0) {
        return e(r0);
    }

    private x() {
    }

    public static final /* synthetic */ AppEntity a(x r0, JsonElement r1) {
        return r0.a(r1);
    }

    static {
        f16082a = new x();
        f16083b = ao.a(new d.m[]{d.s.a("Clock_DeleteAlarm", new a(ax.a("target"), $$Lambda$x$SH716vOUvOUleJeKicatFec2x6s.INSTANCE)), d.s.a("Clock_DeleteCountdown", new a(ax.a("target"), $$Lambda$x$Y79m_WOMHMMHQ3E6SNtEKYsER44.INSTANCE)), d.s.a("Contacts_Delete", new a(ax.a("targets"), $$Lambda$x$ZxKhFwPkuu5D9jmmIwxZElEffig.INSTANCE)), d.s.a("Phone_Delete", new a(ax.a("targets"), $$Lambda$x$A1yaq6T72sn8SV_55fP6LCd8OwM.INSTANCE)), d.s.a("Messages_Delete", new a(ax.a("targets"), $$Lambda$x$zNQtbiQU61WRMlQDLAVBymU5RZ4.INSTANCE)), d.s.a("Memory_Delete", new a(ax.a("targets"), $$Lambda$x$2OVJho7iC_2QkE3m24yFEoWaKC8.INSTANCE)), d.s.a("Photo_DeletePhoto", new a(ax.a("photo"), $$Lambda$x$GbTPlkBxosHb9S3yjv7U68ClgSE.INSTANCE)), d.s.a("Recorder_Delete", new a(ax.a(new String[]{"targets", "candidates"}), $$Lambda$x$7926ZFiZqZsKpq8WoPBHrG6C430.INSTANCE))});
    }

    private static final boolean a(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, AlarmEntity.class);
    }

    private static final boolean b(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, CountdownEntity.class);
    }

    private static final boolean c(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, ContactEntity.class);
    }

    private static final boolean d(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, CallHistoryEntity.class);
    }

    private static final boolean e(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, MessageEntity.class);
    }

    private static final boolean f(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, MemoryEntity.class);
    }

    private static final boolean g(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, PhotoEntity.class);
    }

    private static final boolean h(AppEntity r1) {
        d.h.b.o.e(r1, "it");
        return ZeusTransformUtils.instanceOf(r1, RecordingEntity.class);
    }

    public final boolean a(String r1) {
        d.h.b.o.e(r1, "intentName");
        return f16083b.containsKey(r1);
    }

    public final List<AppEntity> a(String r7, Object r8, String r9, String r10) {
        d.h.b.o.e(r7, "intentName");
        d.h.b.o.e(r9, "inputParam");
        a r11 = (a) ZeusTransformUtils.preCheckCast(f16083b.get(r7), a.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L5;
        List<AppEntity> r12 = a(com.obric.agent.c.f14250a.a(r8), r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
        return r12;
    L9:
        b r13 = a(r9, r11.a());
        List<AppEntity> r14 = a(r13.a(), r11);
        if (r13.b().isEmpty() == false) goto L12;
        return r14;
    L12:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(a(b(r10), r11), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L23;
        Object r2 = r16.next();
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.aiagent.plugin");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r13.b(), Iterable.class, "com.obric.aiagent.plugin");
        String r5 = r3.getEcaId();
        if (r5 == null) goto L18;
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L20:
        if (d.a.p.a(r4, r6) == false) goto L14;
        r0.add(r2);
        goto L14
    L18:
        r6 = null;
        goto L20
    L23:
        return a(d.a.p.c((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), r11);
    L5:
        return d.a.p.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final b a(String r7, Set<String> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        int r2 = 3;
        List r3 = null;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        Object[] r10 = 0;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        Object[] r14 = 0;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r17 = 0;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L22
        x r18 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        JsonElement r19 = JsonParser.parseString(r7);     // Catch: Throwable -> L22
        if (r19.isJsonObject() == true) goto L10;
        r19 = null;
    L10:
        if (r19 == null) goto L19;
        JsonObject r20 = r19.getAsJsonObject();     // Catch: Throwable -> L22
        if (r20 == null) goto L19;
        b r1 = new b(r15 == true ? 1 : 0, r14 == true ? 1 : 0, r2, r13 == true ? 1 : 0);     // Catch: Throwable -> L22
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L22
    L15:
        if (r21.hasNext() == false) goto L20;
        JsonElement r22 = r20.get((String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        if (r22 == null) goto L15;
        r18.a(r22, r1);     // Catch: Throwable -> L22
    L20:
        Object r23 = d.n.f(r1);     // Catch: Throwable -> L22
    L24:
        b r24 = new b(r12 == true ? 1 : 0, r11 == true ? 1 : 0, r2, r10 == true ? 1 : 0);
        if (d.n.b(r23) == false) goto L28;
        r23 = r24;
    L28:
        return (b) ZeusTransformUtils.preCheckCast(r23, b.class, "com.obric.aiagent.plugin");
    L19:
        r1 = new b(r6 == true ? 1 : 0, r5 == true ? 1 : 0, r2, r4 == true ? 1 : 0);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        d.n.a r25 = d.n.f38560a;
        r23 = d.n.f(d.o.a(th));
        goto L24
    L5:
        return new b(r3, r17 == true ? 1 : 0, r2, r16 == true ? 1 : 0);
    }

    private final void a(JsonElement r6, b r7) {
        if (r6.isJsonArray() == false) goto L9;
        JsonArray r5 = r6.getAsJsonArray();
        d.h.b.o.c(r5, "getAsJsonArray(...)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L55;
        JsonElement r9 = (JsonElement) ZeusTransformUtils.preCheckCast(r8.next(), JsonElement.class, "com.obric.aiagent.plugin");
        x r0 = f16082a;
        d.h.b.o.a(r9);
        r0.a(r9, r7);
        goto L6
    L55:
        return;
    L9:
        if (r6.isJsonObject() == false) goto L21;
        JsonObject r10 = r6.getAsJsonObject();
        if (r10.has(DbHelper.COL_ID) == true) goto L13;
    L17:
        JsonElement r11 = r10.get("value");
        if (r11 == null) goto L48;
        f16082a.a(r11, r7);
        return;
    L48:
        return;
    L13:
        if (r10.has("type") == false) goto L17;
        d.h.b.o.a(r10);
        AppEntity r12 = a((JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L46;
        r7.a().add(r12);
        return;
    L46:
        return;
    L21:
        if (r6.isJsonPrimitive() == true) goto L23;
        return;
    L23:
        if (r6.getAsJsonPrimitive().isString() == false) goto L51;
        String r13 = r6.getAsString();
        d.h.b.o.c(r13, "getAsString(...)");
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Object r4 = null;
        if (d.o.o.b(r14, "$E_", false, 2, null) == false) goto L28;
        r7.b().add(r14);
        return;
    L28:
        if (d.o.o.b(r14, "{", false, 2, null) == false) goto L30;
    L43:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L33
        x r15 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Object r16 = d.n.f(JsonParser.parseString(r14));     // Catch: Throwable -> L33
    L36:
        if (d.n.b(r16) == true) goto L39;
        r4 = r16;
    L39:
        JsonElement r17 = (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L54;
        f16082a.a(r17, r7);
        return;
    L54:
        return;
    L33:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L36
    L30:
        if (d.o.o.b(r14, "[", false, 2, null) == true) goto L43;
        return;
    }

    private final List<AppEntity> b(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L21
        x r4 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        JsonElement r6 = JsonParser.parseString(r5);     // Catch: Throwable -> L21
        if (r6.isJsonArray() == false) goto L16;
        JsonArray r7 = r6.getAsJsonArray();     // Catch: Throwable -> L21
        d.h.b.o.c(r7, "getAsJsonArray(...)");     // Catch: Throwable -> L21
        d.n.j r8 = d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L19:
        Object r9 = d.n.f(d.n.m.g(d.n.m.e(r8, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r4), d.h.a.b.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L21
    L23:
        List r10 = d.a.p.b();
        if (d.n.b(r9) == false) goto L27;
        r9 = r10;
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
    L16:
        if (r6.isJsonObject() == false) goto L18;
        r8 = d.n.m.a(new JsonElement[]{r6});     // Catch: Throwable -> L21
        goto L19
    L18:
        r8 = d.n.m.a();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L23
    L11:
        return d.a.p.b();
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final AppEntity a(JsonElement r3) {
        String r4 = r3.toString();
        d.h.b.o.c(r4, "toString(...)");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        x r2 = (x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = d.n.f(AppEntity.CREATOR.fromJson(r4));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r5) == null) goto L15;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L12
        r5 = d.n.f(AppEntity.CREATOR.fromJsonKeepTimeStamp(r4));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
    L15:
        if (d.n.b(r5) == false) goto L18;
        r5 = null;
    L18:
        return (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L8
    }

    private final List<AppEntity> a(List<? extends AppEntity> r2, a r3) {
        return d.n.m.g(d.n.m.f(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), r3.b()), $$Lambda$x$v43LqROaLKC9mBcCCITRHlKYDgs.INSTANCE));
    }

    private static final d.r i(AppEntity r3) {
        d.h.b.o.e(r3, "entity");
        return new d.r(r3.get_packageName(), Integer.valueOf(r3.getType()), r3.getId());
    }
}
