package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CpuTimeStatInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f11835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LinkedHashMap<Long, Long>> f11836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11839e;
    private double f;

    public c() {
        this.f11835a = new ArrayList();
        this.f11836b = new ArrayList();
        this.f11837c = 0;
        this.f11838d = 0;
        this.f11839e = 0;
        this.f = 0.0d;
    }

    public long a() {
        return this.f11838d;
    }

    public long b() {
        if (this.f11837c != 0) goto L14;
        if (this.f11835a.isEmpty() == true) goto L14;
        Iterator<LinkedHashMap<Long, Long>> r0 = this.f11835a.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator r1 = ((LinkedHashMap) ZeusTransformUtils.preCheckCast(r0.next(), LinkedHashMap.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.f11837c += ((Long) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Long.class, "com.obric.aiagent.plugin")).longValue();
    L14:
        return this.f11837c;
    }

    public List<LinkedHashMap<Long, Long>> c() {
        return this.f11835a;
    }

    public void a(LinkedHashMap<Long, Long> r1) {
        this.f11835a.add(r1);
    }

    public void a(com.bytedance.watson.assist.c.b r7) {
        com.bytedance.watson.assist.c.b r8 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        long r2 = b() - ((c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin")).b();
        this.f11838d = r2;
        if (this.f11839e != 0) goto L9;
        this.f11839e = r2;
        return;
    }

    public void b(com.bytedance.watson.assist.c.b r13) {
        com.bytedance.watson.assist.c.b r14 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L6;
        this.f11836b.addAll(this.f11835a);
        return;
    L6:
        List<LinkedHashMap<Long, Long>> r15 = ((c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.aiagent.plugin")).c();
        if (r15.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f11835a.size() == r15.size()) goto L13;
        com.bytedance.watson.assist.d.b.c("calculate cpu freqTime delta size error");
        return;
    L13:
        this.f11836b.clear();
        int r0 = 0;
    L15:
        if (r0 >= this.f11835a.size()) goto L24;
        LinkedHashMap r2 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.f11835a.get(r0), LinkedHashMap.class, "com.obric.aiagent.plugin");
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
        com.bytedance.watson.assist.d.b.d("calculate cpu freqTime delta not found " + r7);
        goto L18
    L21:
        r4.put(r7, Long.valueOf(r8.longValue() - r9.longValue()));
        goto L18
    L23:
        this.f11836b.add(r4);
        r0 = r0 + 1;
        goto L15
    }

    public void a(long r5) {
        if (this.f11838d >= 0) goto L5;
        return;
    L5:
        if (this.f11837c <= 0) goto L9;
        this.f = 1.0d - (r5 / a());
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("cputime:{").append("deltaTime:").append(a()).append(" usage:").append(this.f).append(" totaltime:").append(b()).append("}");
        return r0.toString();
    }
}
