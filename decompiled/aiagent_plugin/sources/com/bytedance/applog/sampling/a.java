package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbsSamplingStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f5964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f5965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<Set<String>>> f5966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, List<Map<String, Object>>> f5967d;

    abstract boolean a(b r1);

    a(int r3, Set<String> r4, Map<String, List<Set<String>>> r5, Map<String, List<Map<String, Object>>> r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Map<String, List<Set<String>>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<String, List<Map<String, Object>>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f5964a = r3;
        this.f5965b = r7;
        this.f5966c = r8;
        this.f5967d = r9;
    }

    final int a() {
        int r1 = this.f5964a;
        if (r1 > 0) goto L7;
        return -1;
    L7:
        if (r1 < 10000) goto L10;
        return 1;
    L10:
        return 0;
    }

    final boolean a(String r3, JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Set<String> r0 = this.f5965b;
        if (r0 != null) goto L8;
    L11:
        if (r4 != null) goto L14;
        return false;
    L14:
        return b(r3, r4);
    L8:
        if (r0.contains(r3) == false) goto L11;
        return true;
    }

    final boolean a(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Set<String> r0 = this.f5965b;
        if (r0 == null) goto L12;
        if (r0.contains(r3) == false) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return false;
    L14:
        Map<String, List<Set<String>>> r1 = this.f5966c;
        if (r1 != null) goto L17;
    L18:
        Map<String, List<Map<String, Object>>> r2 = this.f5967d;
        if (r2 != null) goto L21;
    L24:
        return false;
    L21:
        if (r2.containsKey(r3) == false) goto L24;
    L26:
        return b(r3, new JSONObject(r4));
    L17:
        if (r1.containsKey(r3) == true) goto L26;
        goto L18
    }

    private boolean b(String r8, JSONObject r9) {
        Map<String, List<Set<String>>> r0 = this.f5966c;
        if (r0 != null) goto L5;
    L20:
        Map<String, List<Map<String, Object>>> r1 = this.f5967d;
        if (r1 != null) goto L23;
    L49:
        return false;
    L23:
        if (r1.containsKey(r8) == false) goto L49;
        List r10 = (List) ZeusTransformUtils.preCheckCast(this.f5967d.get(r8), List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L49;
        if (r10.isEmpty() == true) goto L49;
        Iterator r11 = r10.iterator();
    L30:
        if (r11.hasNext() == false) goto L49;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L30;
        if (r2.isEmpty() == true) goto L30;
        if (a(r9, r2.keySet()) == false) goto L30;
        Iterator r3 = r2.entrySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L46;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r6 = r4.getValue();
        if (TextUtils.isEmpty(r5) == true) goto L45;
        if (r6 == null) goto L45;
        if (r6.equals(r9.opt(r5)) == true) goto L39;
    L45:
        boolean r7 = false;
    L47:
        if (r7 == false) goto L30;
        return true;
    L46:
        r7 = true;
        goto L47
    L5:
        if (r0.containsKey(r8) == false) goto L20;
        List r12 = (List) ZeusTransformUtils.preCheckCast(this.f5966c.get(r8), List.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L20;
        if (r12.isEmpty() == true) goto L20;
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L20;
        Set<String> r14 = (Set) ZeusTransformUtils.preCheckCast(r13.next(), Set.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L12;
        if (r14.isEmpty() == true) goto L12;
        if (a(r9, r14) == false) goto L12;
        return true;
    }

    private boolean a(JSONObject r3, Set<String> r4) {
        Iterator r2 = ((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r3.has((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
