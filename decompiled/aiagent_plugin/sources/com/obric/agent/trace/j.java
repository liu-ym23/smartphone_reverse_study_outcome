package com.obric.agent.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentLogSanitizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15501a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f15502b = null;

    private j() {
    }

    static {
        f15501a = new j();
        f15502b = ax.a(new String[]{"soft_blacklist", "whitelist"});
    }

    public final Map<String, Object> a(Map<String, ? extends Object> r6) {
        Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        Object r3 = r7.get("action");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        r0 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 != null) goto L11;
        return r7;
    L11:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L13;
        return r7;
    L13:
        String r5 = a(r0);
        if (d.h.b.o.a(r5, r0) == false) goto L16;
        return r7;
    L16:
        Map<String, Object> r8 = ao.e(r7);
        r8.put("action", r5);
        return r8;
    }

    private final String a(String r6) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return r6;
    L6:
        if (a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), f15502b) == true) goto L28;
        return r6;
    L28:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L20
        j r5 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        JSONObject r2 = new JSONObject(r6);     // Catch: Throwable -> L20
        String r3 = r2.optString("Content");     // Catch: Throwable -> L20
        d.h.b.o.a(r3);     // Catch: Throwable -> L20
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L16;
        String r7 = r5.b(r3);     // Catch: Throwable -> L20
        if (d.h.b.o.a(r7, r3) == true) goto L16;
        r2.put("Content", r7);     // Catch: Throwable -> L20
        String r8 = r2.toString();     // Catch: Throwable -> L20
        d.h.b.o.c(r8, "toString(...)");     // Catch: Throwable -> L20
        String r9 = r8;
    L18:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L20
    L22:
        Object r11 = r6;
        if (d.n.b(r10) == true) goto L27;
        r11 = r10;
    L27:
        return (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
    L16:
        r9 = r6;
        goto L18
    L11:
        r4 = false;
    L20:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L22
    }

    private final String b(String r4) {
        if (a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), f15502b) == true) goto L23;
        return r4;
    L23:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L15
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L15
        JSONArray r2 = r1.optJSONArray("jobs");     // Catch: Throwable -> L15
        if (r2 != null) goto L9;
        String r5 = r4;
    L13:
        Object r6 = d.n.f(r5);     // Catch: Throwable -> L15
    L17:
        Object r7 = r4;
        if (d.n.b(r6) == true) goto L22;
        r7 = r6;
    L22:
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L9:
        if (r3.a(r2) == false) goto L11;
        String r8 = r1.toString();     // Catch: Throwable -> L15
    L12:
        d.h.b.o.a(r8);     // Catch: Throwable -> L15
        r5 = r8;
        goto L13
    L11:
        r8 = r4;
    L15:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L17
    }

    private final boolean a(JSONArray r6) {
        int r0 = r6.length();
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L14;
        JSONObject r3 = r6.optJSONObject(r1);
        if (r3 == null) goto L13;
        JSONArray r4 = r3.optJSONArray("actions");
        if (r4 == null) goto L13;
        if (b(r4) == false) goto L13;
        r2 = true;
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return r2;
    }

    private final boolean b(JSONArray r6) {
        int r0 = r6.length();
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L14;
        JSONObject r3 = r6.optJSONObject(r1);
        if (r3 == null) goto L13;
        JSONObject r4 = r3.optJSONObject("inputParams");
        if (r4 == null) goto L13;
        if (a(r4) == false) goto L13;
        r2 = true;
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return r2;
    }

    private final boolean a(JSONObject r7) {
        JSONObject r8 = r7.optJSONObject("ext");
        if (r8 != null) goto L5;
        return false;
    L5:
        Object r2 = r8.opt("value");
        if (r2 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L21;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return false;
    L16:
        String r6 = c((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(r6, r2) == false) goto L19;
        return false;
    L19:
        r8.put("value", r6);
    L29:
        return true;
    L13:
        r3 = false;
        goto L14
    L21:
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == true) goto L25;
        return false;
    L25:
        if (b(r2) == true) goto L27;
        return false;
    L27:
        r8.put("value", r2);
        goto L29
    }

    private final String c(String r4) {
        if (a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), f15502b) == true) goto L36;
        return r4;
    L36:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L14
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        JSONObject r1 = new JSONObject(r4);     // Catch: Throwable -> L14
        if (r3.a(r1) == false) goto L8;
    L11:
        String r5 = r1.toString();     // Catch: Throwable -> L14
    L12:
        Object r6 = d.n.f(r5);     // Catch: Throwable -> L14
    L17:
        if (d.n.c(r6) != null) goto L38;
    L30:
        Object r7 = r4;
        if (d.n.b(r6) == true) goto L35;
        r7 = r6;
    L35:
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L38:
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L28
        JSONArray r9 = new JSONArray(r4);     // Catch: Throwable -> L28
        j r2 = f15501a;     // Catch: Throwable -> L28
        if (r2.a(r9) == false) goto L22;
    L25:
        String r10 = r9.toString();     // Catch: Throwable -> L28
    L26:
        r6 = d.n.f(r10);     // Catch: Throwable -> L28
        goto L30
    L22:
        if (r2.b(r9) == true) goto L25;
        r10 = r4;
    L28:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L30
    L8:
        if (r3.b(r1) == true) goto L11;
        r5 = r4;
    L14:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L17
    }

    private final boolean a(CharSequence r5, Set<String> r6) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (d.o.o.c(r4, (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final boolean a(Object r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(f15502b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        if (f15501a.a(r5, r2) == false) goto L4;
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    private final boolean b(Object r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(f15502b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        if (f15501a.b(r5, r2) == false) goto L4;
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    private final boolean a(Object r3, String r4) {
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L6;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin"), r4);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L11;
        return false;
    L11:
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.aiagent.plugin"), r4);
    }

    private final boolean a(JSONObject r9, String r10) {
        if (r9.has(r10) == false) goto L6;
        r9.remove(r10);
        return true;
    L6:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{"ext", "value", "inputParams", "params", "data", "payload", "extra"}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        Object r1 = r9.opt((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L8;
        if (f15501a.a(r1, r10) == false) goto L8;
        return true;
    L15:
        return false;
    }

    private final boolean a(JSONArray r5, String r6) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (a(r5.opt(r2), r6) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private final boolean b(Object r7, String r8) {
        int r1 = 0;
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L18;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin")).has(r8) == false) goto L7;
        ((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin")).remove(r8);
        r2 = true;
    L7:
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<String> r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin")).keys();
    L9:
        if (r0.hasNext() == false) goto L11;
        String r4 = r0.next();
        d.h.b.o.c(r4, "next(...)");
        r6.add(r4);
        goto L9
    L11:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r9.hasNext() == false) goto L37;
        if (f15501a.b(((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.aiagent.plugin")).opt((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin")), r8) == false) goto L13;
        r2 = true;
        goto L13
    L37:
        return r2;
    L18:
        if (ZeusTransformUtils.instanceOf(r7, JSONArray.class) == false) goto L36;
        int r3 = ((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.aiagent.plugin")).length();
        boolean r5 = false;
    L20:
        if (r1 >= r3) goto L26;
        if (b(((JSONArray) ZeusTransformUtils.preCheckCast(r7, JSONArray.class, "com.obric.aiagent.plugin")).opt(r1), r8) == false) goto L24;
        r5 = true;
    L24:
        r1 = r1 + 1;
        goto L20
    L26:
        return r5;
    L36:
        return false;
    }
}
