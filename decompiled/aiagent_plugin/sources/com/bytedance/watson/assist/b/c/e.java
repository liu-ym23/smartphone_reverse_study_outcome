package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ProcTimeInStateInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f11845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f11846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f11847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Integer> f11849e;
    private long f;
    private long g;
    private long h;

    public e() {
        this.f11845a = new ArrayList();
        this.f11846b = new ArrayList();
        this.f11847c = new ArrayList();
        this.f11848d = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public void a(com.bytedance.watson.assist.c.b r13) {
        com.bytedance.watson.assist.c.b r14 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L6;
        this.f11846b.addAll(this.f11845a);
        return;
    L6:
        List<LinkedHashMap<Long, Long>> r15 = ((e) ZeusTransformUtils.preCheckCast(r14, e.class, "com.obric.aiagent.plugin")).a();
        if (r15.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f11845a.size() == r15.size()) goto L13;
        com.bytedance.watson.assist.d.b.c("calculate proc freqTime delta size error");
        return;
    L13:
        this.f11846b.clear();
        int r0 = 0;
    L15:
        if (r0 >= this.f11845a.size()) goto L24;
        LinkedHashMap r2 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.f11845a.get(r0), LinkedHashMap.class, "com.obric.aiagent.plugin");
        LinkedHashMap r3 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r15.get(r0), LinkedHashMap.class, "com.obric.aiagent.plugin");
        LinkedHashMap<Long, Long> r4 = new LinkedHashMap();
        Iterator r5 = r2.entrySet().iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r6.getKey(), Long.class, "com.obric.aiagent.plugin");
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r6.getValue(), Long.class, "com.obric.aiagent.plugin");
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r3.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L21;
        com.bytedance.watson.assist.d.b.d("calculate proc freqTime delta not found " + r7);
        goto L18
    L21:
        r4.put(r7, Long.valueOf(r8.longValue() - r9.longValue()));
        goto L18
    L23:
        this.f11846b.add(r4);
        r0 = r0 + 1;
        goto L15
    }

    public void b(com.bytedance.watson.assist.c.b r15) {
        com.bytedance.watson.assist.c.b r16 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L5;
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r1 = ((e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.aiagent.plugin")).a();
        List<LinkedHashMap<Long, Long>> r17 = ((e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.aiagent.plugin")).b();
        if (r17.isEmpty() == true) goto L10;
        r1 = r17;
    L10:
        if (this.f11847c.isEmpty() == false) goto L13;
        this.f11847c.addAll(r1);
        return;
    L13:
        int r18 = this.f11847c.size();
        if (r18 == r1.size()) goto L17;
        com.bytedance.watson.assist.d.b.c("merge freqTime size error");
        return;
    L17:
        ArrayList r0 = new ArrayList();
        int r3 = 0;
    L18:
        if (r3 >= r18) goto L27;
        LinkedHashMap r4 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.f11847c.get(r3), LinkedHashMap.class, "com.obric.aiagent.plugin");
        LinkedHashMap r5 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r1.get(r3), LinkedHashMap.class, "com.obric.aiagent.plugin");
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = r4.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L26;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r8.getKey(), Long.class, "com.obric.aiagent.plugin");
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(r8.getValue(), Long.class, "com.obric.aiagent.plugin");
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r5.get(r9), Long.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L24;
        com.bytedance.watson.assist.d.b.c("merge freqTimeDetla freq not found " + r9);
        goto L21
    L24:
        r6.put(r9, Long.valueOf(r10.longValue() + r11.longValue()));
        goto L21
    L26:
        r0.add(r6);
        r3 = r3 + 1;
        goto L18
    L27:
        this.f11847c = r0;
    }

    public void a(LinkedHashMap<Long, Long> r1) {
        if (r1 == null) goto L5;
        this.f11845a.add(r1);
        return;
    }

    public List<LinkedHashMap<Long, Long>> a() {
        return this.f11845a;
    }

    public List<LinkedHashMap<Long, Long>> b() {
        return this.f11846b;
    }

    public List<LinkedHashMap<Long, Long>> c() {
        return this.f11847c;
    }

    private long a(List<LinkedHashMap<Long, Long>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (this.f11848d == true) goto L5;
        this.f11849e = com.bytedance.watson.assist.d.a.e();
        this.f11848d = true;
    L5:
        long r2 = 0;
        if (r9 != null) goto L8;
    L18:
        return r2;
    L8:
        if (r9.isEmpty() == true) goto L18;
        int r0 = r9.size();
        if (r0 != this.f11849e.size()) goto L18;
        int r7 = 0;
    L12:
        if (r7 >= r0) goto L18;
        Iterator r4 = ((LinkedHashMap) ZeusTransformUtils.preCheckCast(r9.get(r7), LinkedHashMap.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        r2 = r2 + ((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Long.class, "com.obric.aiagent.plugin")).longValue();
        goto L15
    L17:
        r7 = r7 + 1;
        goto L12
    }

    public long d() {
        if (this.f != 0) goto L6;
        this.f = a(this.f11845a);
    L6:
        return this.f;
    }

    public long e() {
        if (this.g != 0) goto L6;
        this.g = a(this.f11846b);
    L6:
        return this.g;
    }

    public long f() {
        if (this.h != 0) goto L6;
        this.h = a(this.f11847c);
    L6:
        return this.h;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.f11845a + ", freqDeltaTimeMapList=" + this.f11846b + ", totalCpuTime=" + d() + ", totalDeltaCpuTime=" + e() + ", totalMergeCpuTime=" + f() + '}';
    }
}
