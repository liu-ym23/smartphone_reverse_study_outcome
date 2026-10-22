package com.bytedance.reparo.core.h;

import android.text.TextUtils;
import com.bytedance.reparo.core.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: DurationMetric.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Long> f9253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f9254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinkedList<String[]> f9257e;
    private LinkedList<long[]> f;

    public b() {
        this.f9253a = new HashMap();
        this.f9254b = new HashMap();
        this.f9257e = new LinkedList();
        this.f = new LinkedList();
    }

    public String[] a() {
        String[] r0 = new String[100];
        this.f9257e.add(r0);
        return r0;
    }

    public long[] b() {
        long[] r0 = new long[100];
        this.f.add(r0);
        return r0;
    }

    public void a(String r3) {
        this.f9255c = System.currentTimeMillis();
        this.f9256d = r3;
    }

    public void b(String r6) {
        if (r6.equals(this.f9256d) == false) goto L11;
        long r0 = System.currentTimeMillis() - this.f9255c;
        if (this.f9253a.containsKey(r6) == true) goto L7;
    L9:
        this.f9253a.put(r6, Long.valueOf(r0));
    L13:
        this.f9256d = null;
        return;
    L7:
        if (r0 >= ((Long) ZeusTransformUtils.preCheckCast(this.f9253a.get(r6), Long.class, "com.obric.aiagent.plugin")).longValue()) goto L9;
        return;
    L11:
        if (this.f9254b.isEmpty() == false) goto L13;
        this.f9254b.put("last", this.f9256d);
        this.f9254b.put("current", r6);
        goto L13
    }

    public com.bytedance.reparo.core.a.a.a a(com.bytedance.reparo.core.a.a.a r8) {
    L3:
        if (this.f9257e.isEmpty() == true) goto L19;
        String[] r0 = (String[]) ZeusTransformUtils.preCheckCast(this.f9257e.pop(), String[].class, "com.obric.aiagent.plugin");
        long[] r1 = (long[]) ZeusTransformUtils.preCheckCast(this.f.pop(), long[].class, "com.obric.aiagent.plugin");
        int r2 = 0;
    L6:
        if (r2 >= r0.length) goto L3;
        if (TextUtils.isEmpty(r0[r2]) == true) goto L3;
        if (r1[r2] < 0) goto L17;
        String r3 = r0[r2];
        int r5 = 1;
    L14:
        if (this.f9253a.containsKey(r3) == false) goto L16;
        r3 = r0[r2] + r5;
        r5 = r5 + 1;
        goto L14
    L16:
        this.f9253a.put(r3, Long.valueOf(r1[r2]));
    L18:
        r2 = r2 + 1;
        goto L6
    L17:
        this.f9254b.put("nativeErr", r0[r2]);
        goto L18
    L19:
        Iterator<Map.Entry<String, Long>> r4 = this.f9253a.entrySet().iterator();
    L21:
        if (r4.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.a((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), r6.getValue());
        goto L21
    L23:
        Iterator<Map.Entry<String, String>> r7 = this.f9254b.entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L27;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.b((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin"), r9.getValue());
        j.c("DurationMetric", "error tag " + ((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin")) + " : " + ((String) ZeusTransformUtils.preCheckCast(r9.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L25
    L27:
        return r8;
    }
}
