package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionSkillBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final String TAG = "AppFunctionSkillBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f18329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f18330b = null;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin")).d(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).d(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$TJg-1lFJm7oNuVurHmBEF7uIERQ, reason: not valid java name */
    public static /* synthetic */ CharSequence m184lambda$TJg1lFJm7oNuVurHmBEF7uIERQ(byte r0) {
        return a(r0);
    }

    private y() {
    }

    static {
        f18329a = new y();
        f18330b = new GsonBuilder().setPrettyPrinting().create();
    }

    public final com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c a(ad r11) {
        d.h.b.o.e(r11, DBHelper.BATTERY_COL_SOURCE);
        ac r0 = r11.d();
        if (ZeusTransformUtils.instanceOf(r0, ac.a.class) == false) goto L9;
        String r1 = ab.f18205a.a(((ac.a) ZeusTransformUtils.preCheckCast(r0, ac.a.class, "com.obric.aiagent.plugin")).a(), r11.a());
        if (r1 != null) goto L7;
        return null;
    L7:
        String r7 = r1;
        if (ILogDepend.Companion.isDebug() == false) goto L17;
        ILogDepend.Companion.d(TAG, "skillMd=" + r7);
    L17:
        if (r11.b().isEmpty() == false) goto L19;
        return null;
    L19:
        String r2 = a(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r11.b(), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin")));
        String r5 = r11.a();
        String r6 = r11.c();
        String r8 = f18330b.toJson(r2);
        d.h.b.o.c(r8, "toJson(...)");
        return new com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c(r5, r6, r7, r8, b(r7 + r2));
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ac.b.class) == false) goto L22;
        r1 = a(r11.a(), r11.c(), ((ac.b) ZeusTransformUtils.preCheckCast(r0, ac.b.class, "com.obric.aiagent.plugin")).a());
        if (r1 != null) goto L7;
        return null;
    L22:
        throw new d.k();
    }

    private final String a(String r11, String r12, c r13) {
        String r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13.c(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L5;
        String r6 = r0;
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        String r9 = a(r13.a());
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L11;
        return null;
    L11:
        String r7 = ab.f18205a.a(r11);
        if (r7 != null) goto L15;
        return null;
    L15:
        return a(r12, r6, r7, r13.d(), r9);
    L5:
        r6 = null;
        goto L6
    }

    private final String a(String r6, String r7, String r8, String r9, String r10) {
        StringBuilder r5 = new StringBuilder();
        StringBuilder r1 = r5.append("---");
        d.h.b.o.c(r1, "append(...)");
        d.h.b.o.c(r1.append('\n'), "append(...)");
        y r2 = f18329a;
        r2.a(r5, "name", r6);
        r2.a(r5, "description", r7);
        String r11 = f18330b.toJson(r8);
        d.h.b.o.c(r11, "toJson(...)");
        r2.a(r5, "display_name", r11);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L5;
        r2.a(r5, "trigger_examples", r9);
    L5:
        StringBuilder r12 = r5.append("---");
        d.h.b.o.c(r12, "append(...)");
        d.h.b.o.c(r12.append('\n'), "append(...)");
        d.h.b.o.c(r5.append('\n'), "append(...)");
        r5.append(r10);
        String r13 = r5.toString();
        d.h.b.o.c(r13, "toString(...)");
        return r13;
    }

    private final String a(List<m> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Gson r10 = f18330b;
        JsonArray r1 = new JsonArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        m r2 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.aiagent.plugin");
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", "function");
        JsonObject r4 = new JsonObject();
        r4.addProperty("name", r2.e());
        String r6 = r2.f();
        if (r6 == null) goto L8;
        r4.addProperty("description", r6);
    L8:
        JsonObject r5 = r2.g();
        if (r5 != null) goto L11;
        r5 = f18329a.a();
    L11:
        r4.add("parameters", (JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"));
        d.x r7 = d.x.f38692a;
        r3.add("function", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        r1.add((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L12:
        String r12 = r10.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r12, "toJson(...)");
        return r12;
    }

    private final void a(StringBuilder r1, String r2, String r3) {
        r1.append(r2);
        r1.append(": ");
        StringBuilder r0 = r1.append(r3);
        d.h.b.o.c(r0, "append(...)");
        d.h.b.o.c(r0.append('\n'), "append(...)");
    }

    private final String a(String r11) {
        List<String> r10 = d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r3 = r13.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r4 = 0;
        if (r14.hasNext() == true) goto L11;
        Comparable r15 = null;
    L33:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L37;
        r4 = r16.intValue();
    L37:
        if (r4 == 0) goto L39;
        List r5 = d.a.p.a();
        String r6 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r10), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L43;
        r5.add(r6);
    L43:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r17.hasNext() == false) goto L52;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L49;
        String r7 = "";
    L50:
        r5.add(r7);
        goto L45
    L49:
        r7 = d.o.o.c(r1, r4);
        goto L50
    L52:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(r5), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L39:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L11:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r9 = r8.length();
        int r18 = 0;
    L13:
        if (r18 >= r9) goto L18;
        if ((!d.o.a.a(r8.charAt(r18))) == true) goto L19;
        r18 = r18 + 1;
    L19:
        Comparable r19 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(d.l.n.c(r18, 0)), Comparable.class, "com.obric.aiagent.plugin");
    L21:
        if (r14.hasNext() == false) goto L32;
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r21 = r20.length();
        int r22 = 0;
    L23:
        if (r22 >= r21) goto L28;
        if ((!d.o.a.a(r20.charAt(r22))) == true) goto L29;
        r22 = r22 + 1;
    L29:
        Comparable r23 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(d.l.n.c(r22, 0)), Comparable.class, "com.obric.aiagent.plugin");
        if (r19.compareTo(r23) <= 0) goto L21;
        r19 = r23;
        goto L21
    L28:
        r22 = -1;
        goto L29
    L32:
        r15 = r19;
        goto L33
    L18:
        r18 = -1;
        goto L19
    }

    private final JsonObject a() {
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", "object");
        r3.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.aiagent.plugin"));
        return r3;
    }

    private final String b(String r11) {
        MessageDigest r10 = MessageDigest.getInstance("SHA-256");
        Charset r0 = StandardCharsets.UTF_8;
        d.h.b.o.c(r0, "UTF_8");
        byte[] r12 = r11.getBytes(r0);
        d.h.b.o.c(r12, "getBytes(...)");
        byte[] r1 = r10.digest(r12);
        d.h.b.o.c(r1, "digest(...)");
        return d.a.i.a(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$y$TJg1lFJm7oNuVurHmBEF7uIERQ.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        d.h.b.o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
