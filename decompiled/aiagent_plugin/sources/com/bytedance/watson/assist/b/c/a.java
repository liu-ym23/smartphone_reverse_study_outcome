package com.bytedance.watson.assist.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CpuIdleTimeStatInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.watson.assist.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<List<Long>> f11827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<List<Long>> f11828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11831e;

    public a() {
        this.f11827a = new ArrayList();
        this.f11828b = new ArrayList();
        this.f11829c = 0;
        this.f11830d = 0;
        this.f11831e = 0;
    }

    public void a(com.bytedance.watson.assist.c.b r7) {
        com.bytedance.watson.assist.c.b r8 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        long r2 = b() - ((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin")).b();
        this.f11830d = r2;
        if (this.f11831e != 0) goto L9;
        this.f11831e = r2;
        return;
    }

    public void b(com.bytedance.watson.assist.c.b r13) {
        com.bytedance.watson.assist.c.b r14 = (com.bytedance.watson.assist.c.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.watson.assist.c.b.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L6;
        this.f11828b.addAll(this.f11827a);
        return;
    L6:
        List<List<Long>> r15 = ((a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin")).c();
        if (r15.isEmpty() == false) goto L9;
        return;
    L9:
        int r0 = this.f11827a.size();
        if (r0 == r15.size()) goto L13;
        com.bytedance.watson.assist.d.b.c("calculate cpu idle time delta size error1");
        return;
    L13:
        this.f11828b.clear();
        int r3 = 0;
    L14:
        if (r3 >= r0) goto L33;
        List r4 = (List) ZeusTransformUtils.preCheckCast(this.f11827a.get(r3), List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r15.get(r3), List.class, "com.obric.aiagent.plugin");
        ArrayList r6 = new ArrayList();
        if (r4 == null) goto L26;
        if (r5 == null) goto L26;
        if (r4.size() != r5.size()) goto L26;
        int r7 = 0;
    L23:
        if (r7 >= r4.size()) goto L25;
        r6.add(Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r4.get(r7), Long.class, "com.obric.aiagent.plugin")).longValue() - ((Long) ZeusTransformUtils.preCheckCast(r5.get(r7), Long.class, "com.obric.aiagent.plugin")).longValue()));
        r7 = r7 + 1;
        goto L23
    L25:
        this.f11828b.add(r6);
        r3 = r3 + 1;
    L26:
        com.bytedance.watson.assist.d.b.c("calculate cpu idle time delta size error2");
        return;
    }

    public long a() {
        return this.f11830d;
    }

    public long b() {
        if (this.f11829c != 0) goto L14;
        if (this.f11827a.isEmpty() == true) goto L14;
        Iterator<List<Long>> r0 = this.f11827a.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r0.next(), List.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.f11829c += ((Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
    L14:
        return this.f11829c;
    }

    public List<List<Long>> c() {
        return this.f11827a;
    }

    public void a(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.f11827a.add(r4);
        return;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f11827a + ", stateDeltaTimeLists=" + this.f11828b + ", totalCpuIdleTime=" + this.f11829c + ", deltaCpuIdleTime=" + this.f11830d + ", mergedDeltaCpuIdleTime=" + this.f11831e + '}';
    }
}
