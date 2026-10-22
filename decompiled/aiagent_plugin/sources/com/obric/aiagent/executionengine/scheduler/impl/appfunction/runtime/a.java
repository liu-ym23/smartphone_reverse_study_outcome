package com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime;

import android.app.PendingIntent;
import android.app.appsearch.GenericDocument;
import android.os.Bundle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.ah;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.ai;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.b;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.f;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.g;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.h;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.i;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.j;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.q;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.s;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.t;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.u;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.v;
import com.obric.aiagent.executionengine.utils.e;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.n;
import d.n.m;
import d.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppFunctionDocumentConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AppFunctionDocumentConverter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18339a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.appfunction.runtime.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppFunctionDocumentConverter.kt */
    public static final class C0380a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AppEntity[] f18342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PendingIntent f18343d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0380a.class) == true) goto L8;
            return false;
        L8:
            C0380a r6 = (C0380a) ZeusTransformUtils.preCheckCast(r5, C0380a.class, "com.obric.aiagent.plugin");
            if (this.f18340a == r6.f18340a) goto L12;
            return false;
        L12:
            if (o.a(this.f18341b, r6.f18341b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18342c, r6.f18342c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f18343d, r6.f18343d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f18340a) * 31;
            String r1 = this.f18341b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            AppEntity[] r5 = this.f18342c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            PendingIntent r8 = this.f18343d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = Arrays.hashCode(r5);
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StandardResult(code=" + this.f18340a + ", message=" + this.f18341b + ", entities=" + Arrays.toString(this.f18342c) + ", pendingIntent=" + this.f18343d + ')';
        }

        public C0380a(int r1, String r2, AppEntity[] r3, PendingIntent r4) {
            this.f18340a = r1;
            this.f18341b = r2;
            this.f18342c = r3;
            this.f18343d = r4;
        }

        public final int a() {
            return this.f18340a;
        }

        public final String b() {
            return this.f18341b;
        }

        public final AppEntity[] c() {
            return this.f18342c;
        }

        public final PendingIntent d() {
            return this.f18343d;
        }
    }

    static {
        f18339a = new a();
    }

    public static /* synthetic */ PendingIntent lambda$_ypyJz0t6pTZ_hGbMRHaPzbWa0w(Bundle r0, a r1, h r2, s r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$lC51yljUptf8Gntjt8V5m-PoB1g, reason: not valid java name */
    public static /* synthetic */ s m185lambda$lC51yljUptf8Gntjt8V5mPoB1g(a r0, h r1, i r2) {
        return a(r0, r1, r2);
    }

    private a() {
    }

    public final boolean a(GenericDocument r1) {
        o.e(r1, "document");
        return o.a(r1.getSchemaType(), "com.obric.appfunctions.schemas.common.AppFunctionResult");
    }

    public final Bundle a(Bundle r4, String r5) {
        o.e(r5, "returnValueKey");
        Object r1 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        r4.setClassLoader(AppEntity.class.getClassLoader());
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Object r6 = n.f(r4.getBundle("property/" + r5));     // Catch: Throwable -> L8
    L10:
        Throwable r7 = n.c(r6);
        if (r7 != null) goto L13;
        r1 = r6;
    L15:
        return (Bundle) ZeusTransformUtils.preCheckCast(r1, Bundle.class, "com.obric.aiagent.plugin");
    L13:
        ILogDepend.Companion.e(TAG, "extract return value extras failed", r7);
    L8:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L10
    }

    public final PendingIntent a(Bundle r4, String r5, i r6, final h r7) {
        o.e(r5, "returnValueKey");
        o.e(r7, "components");
        Object r1 = null;
        if (r4 != null) goto L34;
        return null;
    L34:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L26
        final a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        i r8 = r3.a(r6, r7);     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r8, u.class) == false) goto L12;
        if (o.a(((u) ZeusTransformUtils.preCheckCast(r8, u.class, "com.obric.aiagent.plugin")).a(), PendingIntent.class.getName()) == true) goto L10;
    L9:
        PendingIntent r9 = null;
    L24:
        Object r10 = n.f(r9);     // Catch: Throwable -> L26
    L28:
        Throwable r11 = n.c(r10);
        if (r11 != null) goto L31;
        r1 = r10;
    L33:
        return (PendingIntent) ZeusTransformUtils.preCheckCast(r1, PendingIntent.class, "com.obric.aiagent.plugin");
    L31:
        ILogDepend.Companion.e(TAG, "extract return pendingIntent failed", r11);
        goto L33
    L10:
        r9 = r3.b(r4, "property/" + r5);     // Catch: Throwable -> L26
        goto L24
    L12:
        if (ZeusTransformUtils.instanceOf(r8, s.class) == false) goto L17;
        Bundle r12 = r3.a(r4, r5);     // Catch: Throwable -> L26
        if (r12 == null) goto L9;
        r9 = r3.a(r12, (s) ZeusTransformUtils.preCheckCast(r8, s.class, "com.obric.aiagent.plugin"), r7);     // Catch: Throwable -> L26
        goto L24
    L17:
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L22;
        Bundle r13 = r3.a(r4, r5);     // Catch: Throwable -> L26
        if (r13 == null) goto L9;
        r9 = r3.a(r13, r3.a((b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin"), r7), r7);     // Catch: Throwable -> L26
        goto L24
    L22:
        if (ZeusTransformUtils.instanceOf(r8, t.class) == false) goto L9;
        final Bundle r14 = r3.a(r4, r5);     // Catch: Throwable -> L26
        r9 = (PendingIntent) ZeusTransformUtils.preCheckCast(m.d(m.e(m.e(p.y((Iterable) ZeusTransformUtils.preCheckCast(((t) ZeusTransformUtils.preCheckCast(r8, t.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$a$lC51yljUptf8Gntjt8V5mPoB1g(r3, r7)), new $$Lambda$a$_ypyJz0t6pTZ_hGbMRHaPzbWa0w(r14, r3, r7))), PendingIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a r15 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L28
    }

    private static final s a(a r1, h r2, i r3) {
        o.e(r3, "it");
        i r4 = r1.a(r3, r2);
        if (ZeusTransformUtils.instanceOf(r4, s.class) == true) goto L7;
        return null;
    L7:
        return (s) ZeusTransformUtils.preCheckCast(r4, s.class, "com.obric.aiagent.plugin");
    }

    private static final PendingIntent a(Bundle r1, a r2, h r3, s r4) {
        o.e(r4, "it");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r2.a(r1, r4, r3);
    }

    private final PendingIntent a(Bundle r6, s r7, h r8) {
        Iterator<Map.Entry<String, i>> r9 = r7.a().entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        i r2 = a((i) ZeusTransformUtils.preCheckCast(r0.getValue(), i.class, "com.obric.aiagent.plugin"), r8);
        if (ZeusTransformUtils.instanceOf(r2, u.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r2, s.class) == false) goto L4;
        Bundle r3 = r6.getBundle("property/" + r1);
        if (r3 == null) goto L4;
        PendingIntent r4 = a(r3, (s) ZeusTransformUtils.preCheckCast(r2, s.class, "com.obric.aiagent.plugin"), r8);
        if (r4 == null) goto L4;
        return r4;
    L8:
        if (o.a(((u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.aiagent.plugin")).a(), PendingIntent.class.getName()) == false) goto L4;
        PendingIntent r5 = b(r6, "property/" + r1);
        if (r5 == null) goto L4;
        return r5;
    L19:
        return null;
    }

    private final PendingIntent b(Bundle r1, String r2) {
        r1.setClassLoader(PendingIntent.class.getClassLoader());
        Object r0 = r1.get(r2);
        if (ZeusTransformUtils.instanceOf(r0, PendingIntent.class) == true) goto L7;
        return null;
    L7:
        return (PendingIntent) ZeusTransformUtils.preCheckCast(r0, PendingIntent.class, "com.obric.aiagent.plugin");
    }

    public final C0380a a(GenericDocument r3, Bundle r4) {
        o.e(r3, "document");
        return new C0380a((int) r3.getPropertyLong(MonitorConstants.CODE), r3.getPropertyString("message"), a(r4), b(r4));
    }

    private final AppEntity[] a(Bundle r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        r5.setClassLoader(AppEntity.class.getClassLoader());
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Object r6 = n.f(r5.getParcelableArrayList("property/entities"));     // Catch: Throwable -> L8
    L10:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L14;
        ILogDepend.Companion.e(TAG, "read entities from extras failed", r7);
        r6 = null;
    L14:
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(r6, ArrayList.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L17;
        return null;
    L17:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r3 = r11.next();
        if (ZeusTransformUtils.instanceOf(r3, AppEntity.class) == false) goto L19;
        r10.add(r3);
        goto L19
    L23:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        if (r12.isEmpty() == false) goto L27;
        return null;
    L27:
        return (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        n.a r13 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L10
    }

    private final PendingIntent b(Bundle r5) {
        Object r1 = null;
        if (r5 != null) goto L19;
        return null;
    L19:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r6 = r5.get("property/pendingIntent");     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r6, PendingIntent.class) == false) goto L8;
        PendingIntent r7 = (PendingIntent) ZeusTransformUtils.preCheckCast(r6, PendingIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L9:
        Object r8 = n.f(r7);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = n.c(r8);
        if (r9 != null) goto L16;
        r1 = r8;
    L18:
        return (PendingIntent) ZeusTransformUtils.preCheckCast(r1, PendingIntent.class, "com.obric.aiagent.plugin");
    L16:
        ILogDepend.Companion.e(TAG, "read pendingIntent from extras failed", r9);
        goto L18
    L8:
        r7 = null;
    L11:
        th = move-exception;
        n.a r10 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L13
    }

    public final GenericDocument a(String r9, Map<String, String> r10) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "paramsJson");
        o.e(r5, "obricParameterTypes");
        n.a r11 = n.f38560a;     // Catch: Throwable -> L9
        a r12 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        JsonObject r13 = new JsonObject();     // Catch: Throwable -> L9
    L7:
        Object r14 = n.f(r13);     // Catch: Throwable -> L9
    L12:
        if (n.b(r14) == false) goto L14;
        r14 = null;
    L14:
        JsonObject r15 = (JsonObject) ZeusTransformUtils.preCheckCast(r14, JsonObject.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L18;
        r15 = new JsonObject();
    L18:
        return a(this, r15, null, r5, 2, null);
    L6:
        r13 = (JsonObject) ZeusTransformUtils.preCheckCast(e.a().fromJson(r9, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.a r16 = n.f38560a;
        r14 = n.f(d.o.a(th));
        goto L12
    }

    static /* synthetic */ GenericDocument a(a r1, JsonObject r2, String r3, Map r4, int r5, Object r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = "params";
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = ao.b();
    L9:
        return r1.a(r2, r3, r7);
    }

    private final GenericDocument a(JsonObject r6, String r7, Map<String, String> r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        GenericDocument.Builder<?> r9 = new GenericDocument.Builder("obric_appfunction_params", "params", r7);
        Set<Map.Entry<String, JsonElement>> r10 = r6.entrySet();
        o.c(r10, "entrySet(...)");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r12);
        String r1 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r12.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        a r2 = f18339a;
        o.a(r1);
        o.a(r13);
        r2.a(r9, r1, r13, (String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        GenericDocument r14 = r9.build();
        o.c(r14, "build(...)");
        return r14;
    }

    private final void a(GenericDocument.Builder<?> r9, String r10, JsonElement r11, String r12) {
        if (r11.isJsonPrimitive() == false) goto L6;
        JsonPrimitive r13 = r11.getAsJsonPrimitive();
        o.c(r13, "getAsJsonPrimitive(...)");
        a(r9, r10, r13);
        return;
    L6:
        if (r11.isJsonArray() == false) goto L9;
        JsonArray r14 = r11.getAsJsonArray();
        o.c(r14, "getAsJsonArray(...)");
        a(r9, r10, r14);
        return;
    L9:
        if (r11.isJsonObject() == false) goto L17;
        GenericDocument[] r0 = new GenericDocument[1];
        JsonObject r3 = r11.getAsJsonObject();
        o.c(r3, "getAsJsonObject(...)");
        if (r12 != null) goto L13;
        r12 = "params";
    L13:
        r0[0] = a(this, r3, r12, null, 4, null);
        r9.setPropertyDocument(r10, r0);
        return;
    }

    private final void a(GenericDocument.Builder<?> r10, String r11, JsonArray r12) {
        if (r12.size() != 0) goto L6;
        r10.setPropertyString(r11, new String[0]);
        return;
    L6:
        List r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L9;
    L11:
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        if (((JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.aiagent.plugin")).isJsonObject() == true) goto L13;
        boolean r5 = false;
    L18:
        if (r5 == false) goto L24;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r9.iterator();
    L21:
        if (r14.hasNext() == false) goto L23;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r14.next(), JsonElement.class, "com.obric.aiagent.plugin");
        a r6 = f18339a;
        JsonObject r7 = r1.getAsJsonObject();
        o.c(r7, "getAsJsonObject(...)");
        r13.add(a(r6, r7, null, null, 6, null));
        goto L21
    L23:
        GenericDocument[] r15 = (GenericDocument[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new GenericDocument[0]), GenericDocument[].class, "com.obric.aiagent.plugin");
        r10.setPropertyDocument(r11, (GenericDocument[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r15, r15.length), GenericDocument[].class, "com.obric.aiagent.plugin"));
        return;
    L24:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L27;
    L29:
        Iterator r16 = r8.iterator();
    L31:
        if (r16.hasNext() == false) goto L28;
        if (((JsonElement) ZeusTransformUtils.preCheckCast(r16.next(), JsonElement.class, "com.obric.aiagent.plugin")).isJsonPrimitive() == true) goto L31;
        boolean r17 = false;
    L35:
        if (r17 == false) goto L41;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r18, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r19 = r18.iterator();
    L38:
        if (r19.hasNext() == false) goto L40;
        r2.add(((JsonElement) ZeusTransformUtils.preCheckCast(r19.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonPrimitive());
        goto L38
    L40:
        a(r10, r11, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
        x r20 = x.f38692a;
        return;
    L41:
        r10.setPropertyString(r11, new String[]{r12.toString()});
        return;
    L28:
        r17 = true;
        goto L35
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L29;
    L10:
        r5 = true;
        goto L18
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        goto L10
    }

    private final void a(GenericDocument.Builder<?> r9, String r10, List<JsonPrimitive> r11) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L5;
    L7:
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L6;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r13.next(), JsonPrimitive.class, "com.obric.aiagent.plugin")).isBoolean() == true) goto L9;
        boolean r14 = false;
    L13:
        if (r14 == false) goto L18;
        int r15 = r8.size();
        boolean[] r1 = new boolean[r15];
    L15:
        if (r2 >= r15) goto L17;
        r1[r2] = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r8.get(r2), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsBoolean();
        r2 = r2 + 1;
        goto L15
    L17:
        r9.setPropertyBoolean(r10, r1);
        return;
    L18:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L21;
    L23:
        Iterator r17 = r16.iterator();
    L25:
        if (r17.hasNext() == false) goto L22;
        if (((JsonPrimitive) ZeusTransformUtils.preCheckCast(r17.next(), JsonPrimitive.class, "com.obric.aiagent.plugin")).isNumber() == true) goto L25;
        boolean r18 = false;
    L29:
        if (r18 == false) goto L53;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L33;
    L35:
        Iterator r110 = r19.iterator();
    L37:
        if (r110.hasNext() == false) goto L44;
        if ((((JsonPrimitive) ZeusTransformUtils.preCheckCast(r110.next(), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsNumber().doubleValue() % 1.0d) != 0.0d) goto L41;
        boolean r4 = true;
    L42:
        if (r4 == true) goto L37;
        r3 = false;
        goto L44
    L41:
        r4 = false;
    L44:
        if (r3 == false) goto L49;
        int r111 = r8.size();
        long[] r5 = new long[r111];
    L46:
        if (r2 >= r111) goto L48;
        r5[r2] = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r8.get(r2), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsLong();
        r2 = r2 + 1;
        goto L46
    L48:
        r9.setPropertyLong(r10, r5);
        return;
    L49:
        int r112 = r8.size();
        double[] r6 = new double[r112];
    L50:
        if (r2 >= r112) goto L52;
        r6[r2] = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r8.get(r2), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsNumber().doubleValue();
        r2 = r2 + 1;
        goto L50
    L52:
        r9.setPropertyDouble(r10, r6);
        return;
    L33:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L35;
    L53:
        int r113 = r8.size();
        String[] r7 = new String[r113];
    L54:
        if (r2 >= r113) goto L56;
        r7[r2] = ((JsonPrimitive) ZeusTransformUtils.preCheckCast(r8.get(r2), JsonPrimitive.class, "com.obric.aiagent.plugin")).getAsString();
        r2 = r2 + 1;
        goto L54
    L56:
        r9.setPropertyString(r10, r7);
        return;
    L22:
        r18 = true;
        goto L29
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
    L6:
        r14 = true;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final void a(GenericDocument.Builder<?> r9, String r10, JsonPrimitive r11) {
        if (r11.isBoolean() == false) goto L6;
        r9.setPropertyBoolean(r10, new boolean[]{r11.getAsBoolean()});
        return;
    L6:
        if (r11.isNumber() == false) goto L14;
        double r2 = r11.getAsNumber().doubleValue();
        if ((r2 % 1.0d) != 0.0d) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L13;
        r9.setPropertyLong(r10, new long[]{r11.getAsLong()});
        return;
    L13:
        r9.setPropertyDouble(r10, new double[]{r2});
        return;
    L10:
        r8 = false;
        goto L11
    L14:
        r9.setPropertyString(r10, new String[]{r11.getAsString()});
    }

    public final String a(GenericDocument r2, String r3, i r4, h r5) {
        o.e(r2, "document");
        o.e(r3, "propertyName");
        o.e(r5, "components");
        String r1 = b(r2, r3, r4, r5).toString();
        o.c(r1, "toString(...)");
        return r1;
    }

    static /* synthetic */ JsonObject a(a r1, GenericDocument r2, s r3, h r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = new h(null, 1, null);
    L9:
        return r1.a(r2, r3, r4);
    }

    private final JsonObject a(GenericDocument r7, s r8, h r9) {
        JsonObject r0 = new JsonObject();
        Iterator<String> r1 = r7.getPropertyNames().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        o.a(r2);
        if (r8 == null) goto L10;
        Map<String, i> r3 = r8.a();
        if (r3 == null) goto L10;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r3.get(r2), i.class, "com.obric.aiagent.plugin");
    L11:
        r0.add(r2, b(r7, r2, r4, r9));
    L10:
        r4 = null;
        goto L11
    L12:
        return r0;
    }

    private final JsonElement b(GenericDocument r4, String r5, i r6, h r7) {
        if (r4.getPropertyNames().contains(r5) == true) goto L7;
        JsonNull r3 = JsonNull.INSTANCE;
        o.c(r3, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ai.class) == false) goto L10;
        JsonNull r8 = JsonNull.INSTANCE;
        o.c(r8, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r8, JsonElement.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r6, f.class) == false) goto L13;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(Boolean.valueOf(r4.getPropertyBoolean(r5))), JsonElement.class, "com.obric.aiagent.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r6, g.class) == false) goto L16;
        return a(r4.getPropertyBytes(r5));
    L16:
        if (ZeusTransformUtils.instanceOf(r6, s.class) == false) goto L25;
        GenericDocument r9 = r4.getPropertyDocument(r5);
        if (r9 == null) goto L22;
        JsonObject r10 = f18339a.a(r9, (s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin"), r7);
        if (r10 == null) goto L22;
        JsonElement r11 = (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin");
    L23:
        o.a(r11);
        return r11;
    L22:
        r11 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
        goto L23
    L25:
        if (ZeusTransformUtils.instanceOf(r6, j.class) == false) goto L28;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r4.getPropertyDouble(r5)), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L28:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.o.class) == false) goto L31;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Float.valueOf((float) r4.getPropertyDouble(r5)), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L31:
        if (ZeusTransformUtils.instanceOf(r6, q.class) == false) goto L34;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r4.getPropertyLong(r5)), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L34:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.p.class) == false) goto L37;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf((int) r4.getPropertyLong(r5)), Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L37:
        if (ZeusTransformUtils.instanceOf(r6, ah.class) == false) goto L44;
        String r12 = r4.getPropertyString(r5);
        if (r12 == null) goto L41;
        JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r12), JsonElement.class, "com.obric.aiagent.plugin");
    L42:
        o.a(r13);
        return r13;
    L41:
        r13 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
        goto L42
    L44:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e.class) == false) goto L47;
        return c(r4, r5, ((com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e.class, "com.obric.aiagent.plugin")).a(), r7);
    L47:
        if (ZeusTransformUtils.instanceOf(r6, v.class) == false) goto L55;
        i r0 = a(r6, r7);
        if (r0 == null) goto L88;
        JsonElement r14 = f18339a.b(r4, r5, r0, r7);
        if (r14 == null) goto L88;
        return r14;
    L88:
        return (JsonElement) ZeusTransformUtils.preCheckCast(a(((v) ZeusTransformUtils.preCheckCast(r6, v.class, "com.obric.aiagent.plugin")).a()), JsonElement.class, "com.obric.aiagent.plugin");
    L55:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L64;
        GenericDocument r15 = r4.getPropertyDocument(r5);
        if (r15 == null) goto L61;
        a r16 = f18339a;
        JsonObject r17 = r16.a(r15, r16.a((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin"), r7), r7);
        if (r17 == null) goto L61;
        JsonElement r18 = (JsonElement) ZeusTransformUtils.preCheckCast(r17, JsonElement.class, "com.obric.aiagent.plugin");
    L62:
        o.a(r18);
        return r18;
    L61:
        r18 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
        goto L62
    L64:
        if (ZeusTransformUtils.instanceOf(r6, t.class) == false) goto L73;
        GenericDocument r19 = r4.getPropertyDocument(r5);
        if (r19 == null) goto L70;
        a r20 = f18339a;
        t r21 = (t) ZeusTransformUtils.preCheckCast(r6, t.class, "com.obric.aiagent.plugin");
        String r22 = r19.getSchemaType();
        o.c(r22, "getSchemaType(...)");
        JsonObject r23 = r20.a(r19, r20.a(r21, r22, r7), r7);
        if (r23 == null) goto L70;
        JsonElement r24 = (JsonElement) ZeusTransformUtils.preCheckCast(r23, JsonElement.class, "com.obric.aiagent.plugin");
    L71:
        o.a(r24);
        return r24;
    L70:
        r24 = (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin");
        goto L71
    L73:
        if (ZeusTransformUtils.instanceOf(r6, u.class) == false) goto L76;
        JsonNull r25 = JsonNull.INSTANCE;
        o.c(r25, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r25, JsonElement.class, "com.obric.aiagent.plugin");
    L76:
        return a(r4.getProperty(r5));
    }

    private final JsonElement c(GenericDocument r8, String r9, i r10, h r11) {
        if (ZeusTransformUtils.instanceOf(r10, v.class) == false) goto L10;
        i r0 = a(r10, r11);
        if (r0 != null) goto L9;
        return (JsonElement) ZeusTransformUtils.preCheckCast(a(((v) ZeusTransformUtils.preCheckCast(r10, v.class, "com.obric.aiagent.plugin")).a()), JsonElement.class, "com.obric.aiagent.plugin");
    L9:
        return c(r8, r9, r0, r11);
    L10:
        JsonArray r7 = new JsonArray();
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L18;
        boolean[] r12 = r8.getPropertyBooleanArray(r9);
        if (r12 == null) goto L104;
        int r13 = r12.length;
    L15:
        if (r2 >= r13) goto L104;
        r7.add(Boolean.valueOf(r12[r2]));
        r2 = r2 + 1;
    L104:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin");
    L18:
        if (ZeusTransformUtils.instanceOf(r10, g.class) == false) goto L25;
        byte[][] r14 = r8.getPropertyBytesArray(r9);
        if (r14 == null) goto L104;
        Object[] r15 = (Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.aiagent.plugin");
        int r16 = r15.length;
    L22:
        if (r2 >= r16) goto L104;
        byte[] r17 = (byte[]) ZeusTransformUtils.preCheckCast(r15[r2], byte[].class, "com.obric.aiagent.plugin");
        r7.add(f18339a.a(r17));
        r2 = r2 + 1;
        goto L22
    L25:
        if (ZeusTransformUtils.instanceOf(r10, j.class) == false) goto L32;
        double[] r18 = r8.getPropertyDoubleArray(r9);
        if (r18 == null) goto L104;
        int r19 = r18.length;
    L29:
        if (r2 >= r19) goto L104;
        r7.add((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r18[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L29
    L32:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.o.class) == false) goto L39;
        double[] r20 = r8.getPropertyDoubleArray(r9);
        if (r20 == null) goto L104;
        int r21 = r20.length;
    L36:
        if (r2 >= r21) goto L104;
        r7.add((Number) ZeusTransformUtils.preCheckCast(Float.valueOf((float) r20[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L36
    L39:
        if (ZeusTransformUtils.instanceOf(r10, q.class) == false) goto L46;
        long[] r22 = r8.getPropertyLongArray(r9);
        if (r22 == null) goto L104;
        int r23 = r22.length;
    L43:
        if (r2 >= r23) goto L104;
        r7.add((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r22[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L43
    L46:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.p.class) == false) goto L53;
        long[] r24 = r8.getPropertyLongArray(r9);
        if (r24 == null) goto L104;
        int r25 = r24.length;
    L50:
        if (r2 >= r25) goto L104;
        r7.add((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf((int) r24[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L50
    L53:
        if (ZeusTransformUtils.instanceOf(r10, ah.class) == false) goto L60;
        String[] r26 = r8.getPropertyStringArray(r9);
        if (r26 == null) goto L104;
        int r27 = r26.length;
    L57:
        if (r2 >= r27) goto L104;
        r7.add(r26[r2]);
        r2 = r2 + 1;
        goto L57
    L60:
        if (ZeusTransformUtils.instanceOf(r10, s.class) == false) goto L67;
        GenericDocument[] r28 = r8.getPropertyDocumentArray(r9);
        if (r28 == null) goto L104;
        int r29 = r28.length;
    L64:
        if (r2 >= r29) goto L104;
        GenericDocument r1 = r28[r2];
        a r3 = f18339a;
        o.a(r1);
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r3.a(r1, (s) ZeusTransformUtils.preCheckCast(r10, s.class, "com.obric.aiagent.plugin"), r11), JsonElement.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L64
    L67:
        if (ZeusTransformUtils.instanceOf(r10, v.class) == true) goto L104;
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L76;
        GenericDocument[] r30 = r8.getPropertyDocumentArray(r9);
        if (r30 == null) goto L104;
        int r31 = r30.length;
    L73:
        if (r2 >= r31) goto L104;
        GenericDocument r4 = r30[r2];
        a r5 = f18339a;
        o.a(r4);
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r5.a(r4, r5.a((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin"), r11), r11), JsonElement.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L73
    L76:
        if (ZeusTransformUtils.instanceOf(r10, t.class) == false) goto L83;
        GenericDocument[] r32 = r8.getPropertyDocumentArray(r9);
        if (r32 == null) goto L104;
        int r33 = r32.length;
    L80:
        if (r2 >= r33) goto L104;
        GenericDocument r6 = r32[r2];
        a r34 = f18339a;
        o.a(r6);
        t r35 = (t) ZeusTransformUtils.preCheckCast(r10, t.class, "com.obric.aiagent.plugin");
        String r36 = r6.getSchemaType();
        o.c(r36, "getSchemaType(...)");
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r34.a(r6, r34.a(r35, r36, r11), r11), JsonElement.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L80
    L83:
        if (ZeusTransformUtils.instanceOf(r10, ai.class) == false) goto L85;
    L96:
        JsonElement r37 = f18339a.a(r8.getProperty(r9));
        if (ZeusTransformUtils.instanceOf(r37, JsonArray.class) == false) goto L102;
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L100:
        if (r38.hasNext() == false) goto L104;
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r38.next(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L100
    L102:
        r7.add(r37);
        goto L104
    L85:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.e.class) == true) goto L96;
        if (ZeusTransformUtils.instanceOf(r10, u.class) == true) goto L96;
        JsonElement r39 = f18339a.a(r8.getProperty(r9));
        if (ZeusTransformUtils.instanceOf(r39, JsonArray.class) == false) goto L95;
        Iterator r40 = ((Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L93:
        if (r40.hasNext() == false) goto L104;
        r7.add((JsonElement) ZeusTransformUtils.preCheckCast(r40.next(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L93
    L95:
        r7.add(r39);
        goto L104
    }

    private final JsonElement a(Object r8) {
        if (r8 != null) goto L6;
        JsonNull r7 = JsonNull.INSTANCE;
        o.c(r7, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r8, GenericDocument.class) == true) goto L82;
        int r2 = 0;
        if ((r8 instanceof Object[]) == false) goto L15;
        JsonArray r9 = new JsonArray();
        Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.aiagent.plugin");
        int r1 = r10.length;
    L11:
        if (r2 >= r1) goto L83;
        Object r3 = r10[r2];
        r9.add(f18339a.a(r3));
        r2 = r2 + 1;
        goto L11
    L83:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.aiagent.plugin");
    L15:
        if ((r8 instanceof long[]) == false) goto L21;
        JsonArray r11 = new JsonArray();
        long[] r12 = (long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.aiagent.plugin");
        int r4 = r12.length;
    L17:
        if (r2 >= r4) goto L84;
        r11.add((Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r12[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L17
    L84:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r11, JsonElement.class, "com.obric.aiagent.plugin");
    L21:
        if ((r8 instanceof int[]) == false) goto L27;
        JsonArray r13 = new JsonArray();
        int[] r14 = (int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.aiagent.plugin");
        int r5 = r14.length;
    L23:
        if (r2 >= r5) goto L85;
        r13.add((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r14[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L23
    L85:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin");
    L27:
        if ((r8 instanceof short[]) == false) goto L33;
        JsonArray r15 = new JsonArray();
        short[] r16 = (short[]) ZeusTransformUtils.preCheckCast(r8, short[].class, "com.obric.aiagent.plugin");
        int r6 = r16.length;
    L29:
        if (r2 >= r6) goto L86;
        r15.add((Number) ZeusTransformUtils.preCheckCast(Short.valueOf(r16[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L29
    L86:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r15, JsonElement.class, "com.obric.aiagent.plugin");
    L33:
        if ((r8 instanceof double[]) == false) goto L39;
        JsonArray r17 = new JsonArray();
        double[] r18 = (double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.aiagent.plugin");
        int r19 = r18.length;
    L35:
        if (r2 >= r19) goto L87;
        r17.add((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r18[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L35
    L87:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r17, JsonElement.class, "com.obric.aiagent.plugin");
    L39:
        if ((r8 instanceof float[]) == false) goto L45;
        JsonArray r20 = new JsonArray();
        float[] r21 = (float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.aiagent.plugin");
        int r22 = r21.length;
    L41:
        if (r2 >= r22) goto L88;
        r20.add((Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r21[r2]), Number.class, "com.obric.aiagent.plugin"));
        r2 = r2 + 1;
        goto L41
    L88:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r20, JsonElement.class, "com.obric.aiagent.plugin");
    L45:
        if ((r8 instanceof boolean[]) == false) goto L51;
        JsonArray r23 = new JsonArray();
        boolean[] r24 = (boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.aiagent.plugin");
        int r25 = r24.length;
    L47:
        if (r2 >= r25) goto L89;
        r23.add(Boolean.valueOf(r24[r2]));
        r2 = r2 + 1;
        goto L47
    L89:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r23, JsonElement.class, "com.obric.aiagent.plugin");
    L51:
        if ((r8 instanceof byte[]) == false) goto L54;
        return a((byte[]) ZeusTransformUtils.preCheckCast(r8, byte[].class, "com.obric.aiagent.plugin"));
    L54:
        if ((r8 instanceof char[]) == false) goto L60;
        JsonArray r26 = new JsonArray();
        char[] r27 = (char[]) ZeusTransformUtils.preCheckCast(r8, char[].class, "com.obric.aiagent.plugin");
        int r28 = r27.length;
    L56:
        if (r2 >= r28) goto L91;
        r26.add(Character.valueOf(r27[r2]));
        r2 = r2 + 1;
        goto L56
    L91:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r26, JsonElement.class, "com.obric.aiagent.plugin");
    L60:
        if (ZeusTransformUtils.instanceOf(r8, Number.class) == false) goto L63;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L63:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L66;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L66:
        if (ZeusTransformUtils.instanceOf(r8, Character.class) == false) goto L69;
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((Character) ZeusTransformUtils.preCheckCast(r8, Character.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L69:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L95;
        JsonElement r29 = e.a().toJsonTree(r8);
        o.c(r29, "toJsonTree(...)");
        return r29;
    L95:
        return (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin")), JsonElement.class, "com.obric.aiagent.plugin");
    L82:
        return (JsonElement) ZeusTransformUtils.preCheckCast(a(this, (GenericDocument) ZeusTransformUtils.preCheckCast(r8, GenericDocument.class, "com.obric.aiagent.plugin"), null, null, 6, null), JsonElement.class, "com.obric.aiagent.plugin");
    }

    private final JsonElement a(byte[] r6) {
        if (r6 == null) goto L8;
        JsonArray r0 = new JsonArray();
        int r1 = 0;
        int r2 = r6.length;
    L5:
        if (r1 >= r2) goto L11;
        r0.add((Number) ZeusTransformUtils.preCheckCast(Byte.valueOf(r6[r1]), Number.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        goto L5
    L11:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin");
    L8:
        JsonNull r7 = JsonNull.INSTANCE;
        o.c(r7, "INSTANCE");
        return (JsonElement) ZeusTransformUtils.preCheckCast(r7, JsonElement.class, "com.obric.aiagent.plugin");
    }

    private final s a(b r11, h r12) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r11.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L22;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r13.next(), i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, s.class) == false) goto L9;
        List r3 = p.a(r2);
    L21:
        p.a(r0, (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L12;
        r3 = p.a(f18339a.a((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin"), r12));
        goto L21
    L12:
        if (ZeusTransformUtils.instanceOf(r2, v.class) == false) goto L20;
        a r4 = f18339a;
        i r5 = r4.a(r2, r12);
        if (ZeusTransformUtils.instanceOf(r5, s.class) == false) goto L17;
        r3 = p.a(r5);
        goto L21
    L17:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L19;
        r3 = p.a(r4.a((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin"), r12));
        goto L21
    L19:
        r3 = p.b();
        goto L21
    L20:
        r3 = p.b();
        goto L21
    L22:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        p.a(r1, (Iterable) ZeusTransformUtils.preCheckCast(((s) ZeusTransformUtils.preCheckCast(r16.next(), s.class, "com.obric.aiagent.plugin")).a().entrySet(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L24
    L26:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r17, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.m r8 = d.s.a(r7.getKey(), r7.getValue());
        r6.put(r8.a(), r8.b());
        goto L28
    L30:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        Iterator r111 = r19.iterator();
    L32:
        if (r111.hasNext() == false) goto L35;
        p.a(r110, (Iterable) ZeusTransformUtils.preCheckCast(((s) ZeusTransformUtils.preCheckCast(r111.next(), s.class, "com.obric.aiagent.plugin")).b(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L32
    L35:
        return new s(r6, p.o((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.aiagent.plugin")), r11.b(), r11.c(), null, 16, null);
    }

    private final s a(t r6, String r7, h r8) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r6.a(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r5.iterator();
    L3:
        Object r2 = null;
        if (r10.hasNext() == false) goto L15;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r10.next(), i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, s.class) == false) goto L9;
        r2 = (s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.aiagent.plugin");
    L13:
        if (r2 == null) goto L3;
        r9.add(r2);
        goto L3
    L9:
        if (ZeusTransformUtils.instanceOf(r1, v.class) == false) goto L13;
        i r3 = r8.a().get(((v) ZeusTransformUtils.preCheckCast(r1, v.class, "com.obric.aiagent.plugin")).a());
        if (ZeusTransformUtils.instanceOf(r3, s.class) == false) goto L13;
        r2 = (s) ZeusTransformUtils.preCheckCast(r3, s.class, "com.obric.aiagent.plugin");
        goto L13
    L15:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r12.hasNext() == false) goto L21;
        Object r13 = r12.next();
        if (o.a(((s) ZeusTransformUtils.preCheckCast(r13, s.class, "com.obric.aiagent.plugin")).d(), r7) == false) goto L17;
        r2 = r13;
    L21:
        s r14 = (s) ZeusTransformUtils.preCheckCast(r2, s.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L24;
        return r14;
    L24:
        return (s) ZeusTransformUtils.preCheckCast(p.l(r11), s.class, "com.obric.aiagent.plugin");
    }

    private final i a(i r4, h r5) {
        HashSet r3 = new HashSet();
    L4:
        if (ZeusTransformUtils.instanceOf(r4, v.class) == false) goto L11;
        String r6 = ((v) ZeusTransformUtils.preCheckCast(r4, v.class, "com.obric.aiagent.plugin")).a();
        if (r3.add(r6) == false) goto L7;
        r4 = (i) ZeusTransformUtils.preCheckCast(r5.a().get(r6), i.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L4;
        return null;
    L7:
        return null;
    L11:
        return r4;
    }

    private final JsonObject a(String r3) {
        JsonObject r2 = new JsonObject();
        r2.addProperty("__error__", "Failed to resolve reference: " + r3);
        return r2;
    }
}
