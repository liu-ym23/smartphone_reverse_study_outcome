package com.ss.android.common.applog.a;

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
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashSet<String> f37146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected HashMap<String, HashSet<String>> f37147b;

    public abstract boolean a(String r1);

    public abstract boolean a(HashSet<String> r1, String r2);

    public a(HashSet<String> r1, HashMap<String, HashSet<String>> r2) {
        this.f37146a = r1;
        this.f37147b = r2;
    }

    public final boolean a(String r5, JSONObject r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        HashSet<String> r0 = this.f37146a;
        if (r0 != null) goto L8;
    L33:
        return true;
    L8:
        if (r0.size() <= 0) goto L33;
        if (a(r5) == false) goto L13;
        return false;
    L13:
        if (r6 == null) goto L33;
        HashMap<String, HashSet<String>> r1 = this.f37147b;
        if (r1 == null) goto L33;
        if (r1.size() <= 0) goto L33;
        if (this.f37147b.containsKey(r5) == false) goto L33;
        HashSet<String> r7 = (HashSet) ZeusTransformUtils.preCheckCast(this.f37147b.get(r5), HashSet.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L33;
        if (r7.size() <= 0) goto L33;
        Iterator<String> r8 = r6.keys();
    L28:
        if (r8.hasNext() == false) goto L33;
        if (a(r7, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L28;
        r8.remove();     // Catch: Throwable -> L34
        goto L28
    }

    public static final a a(Context r13, JSONObject r14) {
        SharedPreferences.Editor r15 = ((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("sp_filter_name", 0).edit();     // Catch: Throwable -> L59
        r15.clear().commit();     // Catch: Throwable -> L59
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r14.has("event_list") == false) goto L77;
        JSONObject r16 = r14.optJSONObject("event_list");     // Catch: Throwable -> L59
        if (r16 != null) goto L11;
        return null;
    L11:
        int r2 = r16.optInt("is_block", 0);     // Catch: Throwable -> L59
        r15.putInt("is_block", r2);     // Catch: Throwable -> L59
        HashSet r1 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r5 = r16.optJSONArray("events");     // Catch: Throwable -> L59
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
        r15.putStringSet("events", r1);     // Catch: Throwable -> L59
    L25:
        HashMap r0 = new HashMap();     // Catch: Throwable -> L59
        JSONObject r17 = r16.optJSONObject("params");     // Catch: Throwable -> L59
        if (r17 == null) goto L48;
        Iterator<String> r6 = r17.keys();     // Catch: Throwable -> L59
    L29:
        if (r6.hasNext() == false) goto L48;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r9) == true) goto L29;
        HashSet r10 = new HashSet();     // Catch: Throwable -> L59
        JSONArray r11 = r17.optJSONArray(r9);     // Catch: Throwable -> L59
        if (r11 == null) goto L45;
        if (r11.length() <= 0) goto L45;
        int r12 = 0;
    L39:
        if (r12 >= r11.length()) goto L45;
        String r18 = r11.optString(r12);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r18) == true) goto L43;
        r10.add(r18);     // Catch: Throwable -> L59
    L43:
        r12 = r12 + 1;     // Catch: Throwable -> L59
    L45:
        if (r10.size() <= 0) goto L29;
        r0.put(r9, r10);     // Catch: Throwable -> L59
    L48:
        if (r0.size() <= 0) goto L53;
        Iterator r19 = r0.entrySet().iterator();     // Catch: Throwable -> L59
    L51:
        if (r19.hasNext() == false) goto L53;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        r15.putStringSet((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r20.getValue(), Set.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L59
    L53:
        r15.commit();     // Catch: Throwable -> L59
        if (r2 <= 0) goto L56;
        a r110 = new b(r1, r0);     // Catch: Throwable -> L59
    L58:
        return r110;
    L56:
        r110 = new c(r1, r0);     // Catch: Throwable -> L59
        goto L58
    L77:
        return null;
    L78:
        return null;
    }

    public static final a a(Context r12) {
        SharedPreferences r13 = ((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("sp_filter_name", 0);     // Catch: Throwable -> L47
        HashSet r3 = new HashSet();     // Catch: Throwable -> L47
        HashMap r5 = new HashMap();     // Catch: Throwable -> L47
        Map<String, ?> r6 = r13.getAll();     // Catch: Throwable -> L6
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
        HashSet r14 = new HashSet();     // Catch: Throwable -> L47
        Set r15 = (Set) ZeusTransformUtils.preCheckCast(r9.getValue(), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
    L35:
        if (r15 == null) goto L40;
        if (r15.size() <= 0) goto L40;
        r14.addAll(r15);     // Catch: Throwable -> L47
    L40:
        if (r14.size() <= 0) goto L13;
        r5.put(r10, r14);     // Catch: Throwable -> L47
    L34:
        r15 = null;
        goto L35
    L19:
        r8 = r13.getInt("is_block", 0);     // Catch: Throwable -> L47
        goto L13
    L42:
        if (r8 <= 0) goto L44;
        a r16 = new b(r3, r5);     // Catch: Throwable -> L47
    L46:
        return r16;
    L44:
        r16 = new c(r3, r5);     // Catch: Throwable -> L47
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
