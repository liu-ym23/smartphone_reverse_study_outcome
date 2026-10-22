package com.bytedance.dataplatform;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ExposureManager.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f7948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f7949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f7950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f7951e;
    private Set<String> f;
    private String g;
    private String h;
    private Map<String, String> i;
    private Map<String, Map<String, String>> j;
    private List<String> k;

    void a(String r4, boolean r5) {
        if (this.i.containsKey(r4) == false) goto L21;
        if (r5 == true) goto L6;
    L8:
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.i.get(r4), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L11;
    L19:
        com.bytedance.dataplatform.a.a.a(r6, this.h);
        return;
    L11:
        if (this.f7949c.contains(r6) == true) goto L19;
        if (this.f7951e.contains(r6) == true) goto L19;
        if (r5 == false) goto L17;
        this.f7951e.add(r6);
        a.a(this.f7947a, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.g, this.f7951e);
    L18:
        a();
        goto L19
    L17:
        this.f7949c.add(r6);
        a.a(this.f7947a, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE", this.f7949c);
        goto L18
    L6:
        if (TextUtils.isEmpty(this.g) == false) goto L8;
        return;
    }

    private void a() {
        if (this.f7949c.isEmpty() == true) goto L5;
    L11:
        String r0 = a(new Set[]{this.f7949c, this.f7951e, this.f7950d, this.f});
    L13:
        if (TextUtils.equals(r0, this.h) == true) goto L18;
        this.h = r0;
        h r3 = this.f7948b;
        if (r3 == null) goto L19;
        r3.a(r0);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (this.f7951e.isEmpty() == false) goto L11;
        if (this.f7950d.isEmpty() == false) goto L11;
        if (this.f.isEmpty() == false) goto L11;
        r0 = null;
        goto L13
    }

    void a(Map<String, String> r3, Map<String, Long> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.i = r5;
        a.a(this.f7947a, "SP_EXPERIMENT_EXPOSURE_CACHE", r5);
        this.f7949c.retainAll(this.i.values());
        a.a(this.f7947a, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE", this.f7949c);
        a();
    }

    <T> void a(String r6, com.bytedance.dataplatform.b.a<T> r7, String r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        String r0 = r7.e();
        if (this.j.containsKey(r0) == true) goto L8;
        this.j.put(r0, new ConcurrentHashMap());
        a.a(this.f7947a, "SP_EXPERIMENT_CACHE", "SP_CLIENT_EXPOSURE_CACHE", this.j.keySet());
    L8:
        if (r7.f() == null) goto L10;
        a(r0, Arrays.asList(r7.f()));
    L11:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r0), Map.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.get(r6), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(r1, r8) == false) goto L14;
    L20:
        com.bytedance.dataplatform.a.a.a(r8, this.h);
        return;
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        this.f7950d.remove(r1);
        r9.remove(r6);
    L17:
        if (TextUtils.isEmpty(r8) == true) goto L19;
        this.f7950d.add(r8);
        r9.put(r6, r8);
    L19:
        a.a(this.f7947a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r0, r6, r8);
        a();
        goto L20
    L10:
        this.k.add(r6);
        goto L11
    }

    private void a(String r8, List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r8), Map.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r10.contains(r3) == true) goto L4;
        this.f7950d.remove(r0.get(r3));     // Catch: Throwable -> L10
        r0.remove(r3);     // Catch: Throwable -> L10
        a.a(this.f7947a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r8, r3);     // Catch: Throwable -> L10
        goto L4
    }

    public String a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.i.get(r5), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0) == false) goto L8;
        Iterator<Map<String, String>> r4 = this.j.values().iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.aiagent.plugin")).get(r5), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L13;
        return r1;
    L17:
        return null;
    L8:
        if (this.f7949c.contains(r0) == false) goto L10;
        return r0;
    L10:
        return null;
    }

    private String a(Set<String>... r9) {
        StringBuilder r8 = new StringBuilder();
        int r0 = r9.length;
        boolean r2 = true;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        Set<String> r4 = r9[r3];
        if (r4 == null) goto L13;
        Iterator<String> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        r8.append((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L11:
        r8.append(',');
    L13:
        r3 = r3 + 1;
        goto L3
    L15:
        return r8.toString();
    }
}
