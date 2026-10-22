package com.bytedance.apm6.cpu.c.a;

import android.os.Looper;
import android.os.Process;
import com.bytedance.apm6.cpu.c.i;
import com.bytedance.apm6.cpu.c.j;
import com.bytedance.monitor.collector.k;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NormalThreadDetectState.java */
/* JADX INFO: loaded from: classes.dex */
class h extends com.bytedance.apm6.cpu.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Double> f5253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<j> f5254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<j> f5255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm6.util.e.a f5256e;
    private com.bytedance.apm6.cpu.b.c f;
    private long g;
    private boolean h;

    static /* synthetic */ void a(h r0) {
        r0.c();
    }

    public h(com.bytedance.apm6.cpu.c.d r7) {
        super(r7);
        this.g = 0;
        this.f5253b = new CopyOnWriteArrayList();
        this.f5255d = new CopyOnWriteArrayList();
        this.f5254c = new CopyOnWriteArrayList();
        final long r2 = 0;
        final long r4 = 1000;
        this.f5256e = new AnonymousClass1(this, r2, r4);
    }

    private void c() {
        if (com.bytedance.apm6.cpu.c.b.a() == false) goto L6;
        h();
        this.f5233a.c();
        return;
    L6:
        boolean r0 = g();
        if ((System.currentTimeMillis() - this.g) < d()) goto L10;
        f();
        return;
    L10:
        if (r0 == true) goto L13;
        a("not over process threshold");
        this.f5254c.clear();
        return;
    L13:
        e();
    }

    private long d() {
        com.bytedance.apm6.cpu.b.c r4 = this.f;
        if (r4 != null) goto L7;
        return OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
    L7:
        return ((long) r4.l()) * 1000;
    }

    private void e() {
        if (this.f5254c.isEmpty() == false) goto L6;
        i.a(Process.myPid(), this.f5254c);
        a("over process threshold, first collect thread info, list size: " + this.f5254c.size());
        return;
    L6:
        i.a(Process.myPid(), this.f5254c, this.f.f(), this.f.g());
        a("over process threshold, second collect thread info, list size after filter is: " + this.f5254c.size());
        if (this.f5254c.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f5254c.size() <= 10) goto L14;
        this.f5254c.clear();
        return;
    L14:
        if (com.bytedance.apm6.cpu.c.c.a().b() == false) goto L50;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r5 = r0.activeCount();
        int r6 = r5 + (r5 / 2);
        Thread[] r7 = new Thread[r6];
        r0.enumerate(r7);
        StringBuilder r1 = new StringBuilder();
        ListIterator<j> r8 = this.f5254c.listIterator();
    L17:
        if (r8.hasNext() == false) goto L61;
        j r9 = (j) ZeusTransformUtils.preCheckCast(r8.next(), j.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        if (r9.f() == Process.myPid()) goto L24;
        int r10 = 0;
    L27:
        if (r10 >= r6) goto L43;
        Thread r11 = r7[r10];
        if (r11 == null) goto L43;
        if (r9.g().equals(r11.getName()) == true) goto L40;
        if (r11.getName().length() <= 15) goto L38;
        if (r9.g().equals(r11.getName().substring(0, 15)) == true) goto L40;
    L38:
        r10 = r10 + 1;
    L40:
        if (r11 == Thread.currentThread()) goto L42;
        a(r9, r11, r1);
    L42:
        boolean r12 = true;
    L44:
        if (r12 == true) goto L17;
        if (this.f.m() == false) goto L17;
        String r13 = k.a().d(r9.f());
        if (r13 == null) goto L17;
        r9.b(r13);
        r9.a(String.format("%.2f", new Object[]{Double.valueOf(r9.e() / this.f.f())}));
        this.f5255d.add(r9);
    L43:
        r12 = false;
        goto L44
    L24:
        if (this.f.d() == false) goto L17;
        a(r9, Looper.getMainLooper().getThread(), r1);
    L61:
        Collections.sort(this.f5254c, new AnonymousClass2(this));
        LinkedList<com.bytedance.apm6.service.e.a.C0132a> r2 = new LinkedList();
        Iterator<j> r3 = this.f5254c.iterator();
    L63:
        if (r3.hasNext() == false) goto L65;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin");
        r2.add(new com.bytedance.apm6.service.e.a.C0132a(r4.g(), r4.e(), r4.f()));
        goto L63
    L65:
        com.bytedance.apm6.cpu.d.a.a().b(r2);
        this.f5254c.clear();
        return;
    L50:
        ListIterator<j> r14 = this.f5254c.listIterator();
    L52:
        if (r14.hasNext() == false) goto L61;
        j r15 = (j) ZeusTransformUtils.preCheckCast(r14.next(), j.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L52;
        if (r15.f() != Process.myPid()) goto L60;
        if (this.f.d() == false) goto L52;
    L60:
        r15.a(String.format("%.2f", new Object[]{Double.valueOf(r15.e() / this.f.f())}));
        this.f5255d.add(r15);
        goto L52
    }

    private void a(j r9, Thread r10, StringBuilder r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        int r0 = r12.length;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        StackTraceElement r5 = r12[r2];
        r3 = r3 + 1;
        r11.append("\tat ").append(r5.getClassName()).append(".").append(r5.getMethodName()).append("(").append(r5.getFileName()).append(":").append(r5.getLineNumber()).append(")\n");
        if (r3 > 40) goto L9;
        r2 = r2 + 1;
    L9:
        r9.b(r11.toString());
        r9.a(String.format("%.2f", new Object[]{Double.valueOf(r9.e() / this.f.f())}));
        this.f5255d.add(r9);
        r11.setLength(0);
    }

    private void f() {
        if (this.f5253b.isEmpty() == false) goto L5;
    L98:
        a("finish collect, but no exception thread is found");
        h();
        this.f5233a.c();
        return;
    L5:
        if (this.f5255d.isEmpty() == true) goto L98;
        Iterator<Double> r1 = this.f5253b.iterator();
        double r4 = 0.0d;
        double r9 = 0.0d;
    L9:
        if (r1.hasNext() == false) goto L14;
        double r6 = ((Double) ZeusTransformUtils.preCheckCast(r1.next(), Double.class, "com.obric.aiagent.plugin")).doubleValue();
        if (r9 >= r6) goto L13;
        r9 = r6;
    L13:
        r4 = r4 + r6;
        goto L9
    L14:
        a("report exception data, exception thread size is: " + this.f5255d.size());
        double r5 = r4 / ((double) this.f5253b.size());
        LinkedList r2 = new LinkedList();
        String[] r7 = com.bytedance.apm6.cpu.c.b.b().split("#");
        String r12 = null;
        if (this.h == false) goto L38;
        if (this.f.b().isEmpty() == true) goto L59;
        int r11 = r7.length;
        int r14 = 0;
        double r15 = 0.0d;
    L19:
        if (r14 >= r11) goto L33;
        String r13 = r7[r14];
        if (this.f.b().containsKey(r13) == false) goto L32;
        double r3 = ((Double) ZeusTransformUtils.preCheckCast(this.f.b().get(r13), Double.class, "com.obric.aiagent.plugin")).doubleValue();
        if (r3 < 0.0d) goto L32;
        if (r15 >= r3) goto L30;
        r15 = r3;
        r12 = r13;
    L30:
        if (r5 <= r3) goto L32;
        r2.add(r13);
    L32:
        r14 = r14 + 1;
        goto L19
    L33:
        if (r12 == null) goto L59;
        if (r2.contains(r12) == false) goto L59;
        r2.remove(r12);
        r2.add(0, r12);
    L59:
        if (r2.isEmpty() == true) goto L61;
    L68:
        com.bytedance.apm6.cpu.c.c.a().a(System.currentTimeMillis());
        com.bytedance.apm6.cpu.a.c r8 = com.bytedance.apm6.cpu.c.c.a().c();
        if (r8 == null) goto L72;
        r8.a(r5);
    L72:
        if (r2.isEmpty() == true) goto L74;
        String r10 = com.bytedance.apm6.util.f.a(r2.toArray(), "#");
        if (this.h == false) goto L90;
        if (r5 <= this.f.e()) goto L90;
        r10 = r10 + "#apm_max_background";
    L94:
        String r16 = r10;
    L95:
        com.bytedance.apm6.monitor.a.a(new b(r5, r9, this.f5255d, r16, this.h));
    L96:
        h();
        this.f5233a.f();
        return;
    L90:
        if (this.h == true) goto L94;
        if (r5 <= this.f.i()) goto L94;
        r10 = r10 + "#apm_max_foreground";
        goto L94
    L74:
        if (this.h == false) goto L79;
        if (r5 <= this.f.e()) goto L79;
        r16 = "apm_max_background";
    L79:
        if (this.h == false) goto L81;
    L83:
        r10 = "";
        goto L94
    L81:
        if (r5 <= this.f.i()) goto L83;
        r16 = "apm_max_foreground";
        goto L95
    L61:
        if (this.h == false) goto L65;
        if (r5 > this.f.e()) goto L68;
    L65:
        if (this.h == true) goto L96;
        if (r5 <= this.f.i()) goto L96;
    L38:
        if (this.f.c().isEmpty() == true) goto L59;
        int r17 = r7.length;
        int r18 = 0;
        double r19 = 0.0d;
    L40:
        if (r18 >= r17) goto L54;
        String r110 = r7[r18];
        if (this.f.c().containsKey(r110) == true) goto L44;
        int r111 = r17;
    L53:
        r18 = r18 + 1;
        r17 = r111;
        goto L40
    L44:
        r111 = r17;
        double r112 = ((Double) ZeusTransformUtils.preCheckCast(this.f.c().get(r110), Double.class, "com.obric.aiagent.plugin")).doubleValue();
        if (r112 < 0.0d) goto L53;
        if (r19 >= r112) goto L51;
        r12 = r110;
        r19 = r112;
    L51:
        if (r5 <= r112) goto L53;
        r2.add(r110);
        goto L53
    L54:
        if (r12 == null) goto L59;
        if (r2.contains(r12) == false) goto L59;
        r2.remove(r12);
        r2.add(0, r12);
        goto L59
    }

    private boolean g() {
        double r0 = com.bytedance.apm6.cpu.c.e.a();
        this.f5253b.add(Double.valueOf(r0));
        return com.bytedance.apm6.cpu.c.b.a(this.f, r0, this.h);
    }

    private void h() {
        this.f5253b.clear();
        this.f5255d.clear();
        this.f5254c.clear();
        this.g = 0;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).b(this.f5256e);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(com.bytedance.apm6.cpu.b.c r3, boolean r4) {
        super.a(r3, r4);
        this.f = r3;
        this.g = System.currentTimeMillis();
        this.h = r4;
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5476d).a(this.f5256e);
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a() {
        super.a();
        h();
    }

    @Override // com.bytedance.apm6.cpu.c.a, com.bytedance.apm6.cpu.c.g
    public void a(boolean r1) {
        super.a(r1);
        h();
        this.f5233a.b();
    }

    @Override // com.bytedance.apm6.cpu.c.g
    public com.bytedance.apm6.cpu.c.h b() {
        return com.bytedance.apm6.cpu.c.h.f5273c;
    }
}
