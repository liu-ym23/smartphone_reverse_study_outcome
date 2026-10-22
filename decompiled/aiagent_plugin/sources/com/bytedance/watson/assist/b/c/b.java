package com.bytedance.watson.assist.b.c;

import android.content.Context;
import com.bytedance.watson.assist.c.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CpuInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.watson.assist.b.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.watson.assist.c.e f11834e;
    private e f;
    private Map<Long, com.bytedance.watson.assist.c.e> g;
    private Map<Long, e> h;
    private g i;
    private c j;
    private com.bytedance.watson.assist.c.c k;
    private d l;
    private Map<Long, com.bytedance.watson.assist.c.d> m;
    private Map<Long, f> n;
    private com.bytedance.watson.assist.c.f o;
    private a p;

    private boolean a(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean b(int r1) {
        if (r1 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public b(Context r3, com.bytedance.watson.assist.a.c r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (com.bytedance.watson.assist.a.c) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.watson.assist.a.c.class, "com.obric.aiagent.plugin"));
        this.f11832c = false;
        this.f11833d = 0;
        this.f11834e = new com.bytedance.watson.assist.c.e();
        this.f = new e();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new g();
        this.j = new c();
        this.k = new com.bytedance.watson.assist.c.c();
        this.l = new d();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new com.bytedance.watson.assist.c.f();
        this.p = new a();
    }

    @Override // com.bytedance.watson.assist.b.b
    public void a() {
        if (this.f11832c == true) goto L6;
        this.f11832c = true;
        c();
        return;
    }

    public void a(long r14) {
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.i.a(), c.class, "com.obric.aiagent.plugin");
        d r1 = (d) ZeusTransformUtils.preCheckCast(this.k.a(), d.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L52;
        if (r1 == null) goto L53;
        r0.a(this.j);
        if (this.f11823b.a().h() == false) goto L10;
        r0.b(this.j);
    L10:
        if (this.f11823b.a().f() == false) goto L12;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.o.a(), a.class, "com.obric.aiagent.plugin");
        r3.a(this.p);
        r3.b(this.p);
        com.bytedance.watson.assist.d.b.a("current cpu idle stat : " + r3);
        this.p = r3;
        r0.a(r3.a());
        com.bytedance.watson.assist.d.b.a("current cpu usage stat : " + r0);
    L12:
        long r4 = r0.a();
        long r15 = r14 - this.f11833d;
        r1.a(this.l);
        r1.a(r4);
        r1.b(r15);
        if (this.f11823b.a().e() == false) goto L38;
        ArrayList<Long> r5 = com.bytedance.watson.assist.d.d.a();
        HashSet r6 = new HashSet();
        Iterator<Long> r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L24;
        long r8 = ((Long) ZeusTransformUtils.preCheckCast(r7.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        com.bytedance.watson.assist.c.d r10 = (com.bytedance.watson.assist.c.d) ZeusTransformUtils.preCheckCast(this.m.get(Long.valueOf(r8)), com.bytedance.watson.assist.c.d.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L20;
        r10 = new com.bytedance.watson.assist.c.d(r8);
        this.m.put(Long.valueOf(r8), r10);
    L20:
        f r11 = (f) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.preCheckCast(r10.a(), f.class, "com.obric.aiagent.plugin"), f.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L22;
        r11.a((f) ZeusTransformUtils.preCheckCast(this.n.get(Long.valueOf(r8)), f.class, "com.obric.aiagent.plugin"));
        r11.a(r4);
        r11.b(r15);
        this.n.put(Long.valueOf(r8), r11);
        com.bytedance.watson.assist.d.b.a("current tid stat : " + r11);
        goto L16
    L22:
        r6.add(Long.valueOf(r8));
        com.bytedance.watson.assist.d.b.a("dead tid found from refresh thread usage: " + r8);
        goto L16
    L24:
        Set<Long> r16 = this.m.keySet();
        if (r16 != null) goto L27;
    L34:
        Iterator r17 = r6.iterator();
    L36:
        if (r17.hasNext() == false) goto L38;
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(r17.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        this.m.remove(Long.valueOf(r9));
        this.n.remove(Long.valueOf(r9));
        goto L36
    L27:
        if (r16.isEmpty() == true) goto L34;
        Iterator<Long> r18 = r16.iterator();
    L30:
        if (r18.hasNext() == false) goto L34;
        Long r19 = (Long) ZeusTransformUtils.preCheckCast(r18.next(), Long.class, "com.obric.aiagent.plugin");
        if (r5.contains(r19) == true) goto L30;
        r6.add(r19);
        com.bytedance.watson.assist.d.b.a("dead tid found from compare last thread usage: " + r19);
    L38:
        this.j = r0;
        this.l = r1;
        return;
    L53:
        return;
    }

    public void b() {
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.f11834e.a(), e.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(this.f);
        this.f = r0;
        ArrayList<Long> r1 = com.bytedance.watson.assist.d.d.a();
        HashSet r2 = new HashSet();
        Iterator<Long> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L19;
        long r4 = ((Long) ZeusTransformUtils.preCheckCast(r3.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        com.bytedance.watson.assist.c.e r6 = (com.bytedance.watson.assist.c.e) ZeusTransformUtils.preCheckCast(this.g.get(Long.valueOf(r4)), com.bytedance.watson.assist.c.e.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        r6 = new com.bytedance.watson.assist.c.e((int) r4);
        this.g.put(Long.valueOf(r4), r6);
    L11:
        e r7 = (e) ZeusTransformUtils.preCheckCast((e) ZeusTransformUtils.preCheckCast(r6.a(), e.class, "com.obric.aiagent.plugin"), e.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        r7.a((e) ZeusTransformUtils.preCheckCast(this.h.get(Long.valueOf(r4)), e.class, "com.obric.aiagent.plugin"));
        this.h.put(Long.valueOf(r4), r7);
        if (com.bytedance.watson.assist.d.d.b() != r4) goto L17;
        com.bytedance.watson.assist.d.b.a("not merge main thread, id:" + r4);
    L18:
        com.bytedance.watson.assist.d.b.a("current tid " + r4 + " stat : " + r7);
        com.bytedance.watson.assist.d.b.a("current tid " + r4 + " delta : " + r7.e());
        goto L7
    L17:
        this.f.b(r7);
        goto L18
    L13:
        r2.add(Long.valueOf(r4));
        com.bytedance.watson.assist.d.b.a("dead tid found from refresh cpu freq stat: " + r4);
        goto L7
    L19:
        Set<Long> r5 = this.g.keySet();
        if (r5 != null) goto L22;
    L29:
        Iterator r8 = r2.iterator();
    L31:
        if (r8.hasNext() == false) goto L33;
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(r8.next(), Long.class, "com.obric.aiagent.plugin")).longValue();
        this.g.remove(Long.valueOf(r9));
        this.h.remove(Long.valueOf(r9));
        goto L31
    L33:
        return;
    L22:
        if (r5.isEmpty() == true) goto L29;
        Iterator<Long> r10 = r5.iterator();
    L25:
        if (r10.hasNext() == false) goto L29;
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.aiagent.plugin");
        if (r1.contains(r11) == true) goto L25;
        r2.add(r11);
        com.bytedance.watson.assist.d.b.a("dead tid found from compare last cpu freq stat: " + r11);
        goto L25
    }

    public void c() {
        if (this.f11832c == false) goto L12;
        long r0 = System.currentTimeMillis();
        if (this.f11823b.a().d() == false) goto L8;
        a(r0);
    L8:
        if (this.f11823b.a().g() == false) goto L10;
        b();
    L10:
        this.f11833d = r0;
        return;
    }

    public List<List<Integer>> d() {
        if (this.f11823b.a().g() == true) goto L5;
        return null;
    L5:
        return a(this.f.c(), this.f.f());
    }

    private List<List<Integer>> a(List<LinkedHashMap<Long, Long>> r22, long r23) {
        String r3 = "com.obric.aiagent.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L30;
        long r4 = 0;
        if (r23 <= 0) goto L36;
        ArrayList r6 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L29;
        LinkedHashMap r7 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r5.next(), LinkedHashMap.class, r3);
        ArrayList r8 = new ArrayList();
        int r9 = r7.size() / 4;
        Iterator r10 = r7.entrySet().iterator();
        int r11 = 0;
        long r12 = r4;
        long r14 = r12;
        int r13 = 0;
    L12:
        if (r10.hasNext() == false) goto L28;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, r3);
        Iterator r16 = r5;
        Long r17 = (Long) ZeusTransformUtils.preCheckCast(r15.getKey(), Long.class, r3);
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r15.getValue(), Long.class, r3);
        if (r17 == null) goto L25;
        if (r18 == null) goto L25;
        r14 = r14 + r18.longValue();
        if (r11 >= 3) goto L22;
        if (r13 >= r9) goto L21;
        r12 = r12 + r18.longValue();
        r13 = r13 + 1;
    L27:
        r5 = r16;
        goto L12
    L21:
        String r19 = r3;
        r8.add(Integer.valueOf((int) ((r12 / r23) * 100.0d)));
        r12 = r18.longValue();
        r11 = r11 + 1;
        r13 = 1;
    L26:
        r3 = r19;
        goto L27
    L22:
        r19 = r3;
        if (r11 != 3) goto L26;
        r12 = r12 + r18.longValue();
    L25:
        r19 = r3;
        goto L26
    L28:
        double r20 = r23;
        r8.add(Integer.valueOf((int) ((r12 / r20) * 100.0d)));
        r8.add(Integer.valueOf((int) ((r14 / r20) * 100.0d)));
        r6.add(r8);
        r3 = r3;
        r5 = r5;
        r4 = 0;
        goto L9
    L29:
        return r6;
    L36:
        return null;
    L30:
        return null;
    }

    private com.bytedance.watson.assist.a.c.b a(List<List<Integer>> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L6;
        return null;
    L6:
        boolean r0 = a(r14.size());
        boolean r12 = b(r14.size());
        com.bytedance.watson.assist.a.c.b r2 = new com.bytedance.watson.assist.a.c.b();
        Iterator r15 = r14.iterator();
        int r4 = 0;
    L8:
        if (r15.hasNext() == false) goto L27;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        if (r5.size() < 5) goto L8;
        if (r4 != 0) goto L17;
        r2.f11809a = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.f11810b = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(1), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.f11811c = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(2), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.f11812d = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(3), Integer.class, "com.obric.aiagent.plugin")).intValue();
        float r10 = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(4), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.f11809a = r10;
        r2.f11813e = r10;
    L17:
        if (r4 != 1) goto L20;
        if (r12 == false) goto L20;
        r2.f = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.g = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(1), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.h = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(2), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.i = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(3), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.j = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(4), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L20:
        if (r4 != 1) goto L23;
        if (r0 == false) goto L23;
        r2.f = 0.0f;
        r2.g = 0.0f;
        r2.h = 0.0f;
        r2.i = 0.0f;
        r2.j = 0.0f;
        r2.k = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.l = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(1), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.m = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(2), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.n = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(3), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.o = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(4), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L23:
        if (r4 != 2) goto L26;
        if (r12 == false) goto L26;
        r2.k = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.l = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(1), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.m = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(2), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.n = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(3), Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.o = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(4), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L26:
        r4 = r4 + 1;
        goto L8
    L27:
        return r2;
    }

    public com.bytedance.watson.assist.a.c.b e() {
        if (this.f11823b.a().g() == true) goto L5;
        return null;
    L5:
        return a(d());
    }
}
