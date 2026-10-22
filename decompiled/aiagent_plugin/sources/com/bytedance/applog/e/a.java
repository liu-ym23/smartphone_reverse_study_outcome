package com.bytedance.applog.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractEventFilter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f5576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final HashMap<String, HashSet<String>> f5577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.bytedance.applog.c f5578c;

    public abstract boolean a(String r1);

    public abstract boolean a(HashSet<String> r1, String r2);

    public a(com.bytedance.applog.c r1, HashSet<String> r2, HashMap<String, HashSet<String>> r3) {
        this.f5578c = r1;
        this.f5576a = r2;
        this.f5577b = r3;
    }

    @Override // com.bytedance.applog.e.e
    public boolean a(com.bytedance.applog.monitor.b r2, String r3, String r4) {
        if (com.bytedance.applog.monitor.b.f5759c.equals(r2) == true) goto L7;
        return false;
    L7:
        return !a(r3, r4);
    }

    boolean a(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        HashSet<String> r0 = this.f5576a;
        if (r0 != null) goto L8;
    L40:
        return true;
    L8:
        if (r0.isEmpty() == true) goto L40;
        if (a(r5) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return true;
    L16:
        HashMap<String, HashSet<String>> r1 = this.f5577b;
        if (r1 == null) goto L40;
        if (r1.isEmpty() == true) goto L40;
        if (this.f5577b.containsKey(r5) == false) goto L40;
        HashSet<String> r7 = (HashSet) ZeusTransformUtils.preCheckCast(this.f5577b.get(r5), HashSet.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L40;
        if (r7.isEmpty() == true) goto L40;
        JSONObject r2 = null;
        r2 = new JSONObject(r6);     // Catch: Throwable -> L41
    L31:
        if (r2 != null) goto L33;
        return true;
    L33:
        Iterator<String> r8 = r2.keys();
    L35:
        if (r8.hasNext() == false) goto L40;
        if (a(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L35;
        r8.remove();     // Catch: Throwable -> L42
        goto L35
    }

    public static a a(com.bytedance.applog.c r13, String r14, JSONObject r15) {
        SharedPreferences.Editor r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r14, 0).edit();     // Catch: Throwable -> L59
        r16.clear().apply();     // Catch: Throwable -> L59
        if (r15 != null) goto L6;
        return null;
    L6:
        if (r15.has("event_list") == false) goto L77;
        JSONObject r17 = r15.optJSONObject("event_list");     // Catch: Throwable -> L59
        if (r17 != null) goto L11;
        return null;
    L11:
        int r2 = r17.optInt("is_block", 0);     // Catch: Throwable -> L59
        r16.putInt("is_block", r2);     // Catch: Throwable -> L59
        HashSet r1 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r5 = r17.optJSONArray("events");     // Catch: Throwable -> L59
        if (r5 == null) goto L23;
        if (r5.length() <= 0) goto L23;
        int r7 = 0;
    L17:
        if (r7 >= r5.length()) goto L23;
        String r8 = r5.optString(r7);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r8) == true) goto L21;
        r1.add(r8);     // Catch: Throwable -> L59
    L21:
        r7 = r7 + 1;     // Catch: Throwable -> L59
    L23:
        if (r1.size() <= 0) goto L25;
        r16.putStringSet("events", r1);     // Catch: Throwable -> L59
    L25:
        HashMap r0 = new HashMap();     // Catch: Throwable -> L59
        JSONObject r18 = r17.optJSONObject("params");     // Catch: Throwable -> L59
        if (r18 == null) goto L48;
        Iterator<String> r6 = r18.keys();     // Catch: Throwable -> L59
    L29:
        if (r6.hasNext() == false) goto L48;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r9) == true) goto L29;
        HashSet r10 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r11 = r18.optJSONArray(r9);     // Catch: Throwable -> L59
        if (r11 == null) goto L45;
        if (r11.length() <= 0) goto L45;
        int r12 = 0;
    L39:
        if (r12 >= r11.length()) goto L45;
        String r19 = r11.optString(r12);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r19) == true) goto L43;
        r10.add(r19);     // Catch: Throwable -> L59
    L43:
        r12 = r12 + 1;     // Catch: Throwable -> L59
    L45:
        if (r10.size() <= 0) goto L29;
        r0.put(r9, r10);     // Catch: Throwable -> L59
    L48:
        if (r0.size() <= 0) goto L53;
        Iterator r110 = r0.entrySet().iterator();     // Catch: Throwable -> L59
    L51:
        if (r110.hasNext() == false) goto L53;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        r16.putStringSet((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r20.getValue(), Set.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L59
    L53:
        r16.commit();     // Catch: Throwable -> L59
        if (r2 <= 0) goto L56;
        a r111 = new c(r13, r1, r0);     // Catch: Throwable -> L59
    L58:
        return r111;
    L56:
        r111 = new b(r13, r1, r0);     // Catch: Throwable -> L59
        goto L58
    L77:
        return null;
    L78:
        return null;
    }

    public static a a(com.bytedance.applog.c r12, String r13) {
        SharedPreferences r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r13, 0);     // Catch: Throwable -> L47
        HashSet r3 = new HashSet();     // Catch: Throwable -> L47
        HashMap r5 = new HashMap();     // Catch: Throwable -> L47
        Map<String, ?> r6 = r14.getAll();     // Catch: Throwable -> L6
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r6.size() <= 0) goto L75;
        Iterator<Map.Entry<String, ?>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L47
        int r8 = 0;
    L13:
        if (r7.hasNext() == false) goto L42;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        if (r9 == null) goto L13;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        if ("is_block".equals(r10) == true) goto L19;
        if ("events".equals(r10) == false) goto L30;
        Set r11 = (Set) ZeusTransformUtils.preCheckCast(r9.getValue(), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L25:
        if (r11 == null) goto L13;
        if (r11.size() <= 0) goto L13;
        r3.addAll(r11);     // Catch: Throwable -> L47
    L24:
        r11 = null;
        goto L25
    L30:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        HashSet r15 = new HashSet();     // Catch: Throwable -> L47
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(r9.getValue(), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
    L35:
        if (r16 == null) goto L40;
        if (r16.size() <= 0) goto L40;
        r15.addAll(r16);     // Catch: Throwable -> L47
    L40:
        if (r15.size() <= 0) goto L13;
        r5.put(r10, r15);     // Catch: Throwable -> L47
    L34:
        r16 = null;
        goto L35
    L19:
        r8 = r14.getInt("is_block", 0);     // Catch: Throwable -> L47
        goto L13
    L42:
        if (r8 <= 0) goto L44;
        a r17 = new c(r12, r3, r5);     // Catch: Throwable -> L47
    L46:
        return r17;
    L44:
        r17 = new b(r12, r3, r5);     // Catch: Throwable -> L47
        goto L46
    L75:
        return null;
    L6:
        r6 = null;
        goto L7
    L76:
        return null;
    }
}
