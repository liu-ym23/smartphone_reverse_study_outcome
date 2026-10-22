package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: WidgetGroup.java */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f34713b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<com.obric.oui.constraintlayout.a.c.e> f34714a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f34716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f34717e;
    ArrayList<a> f;
    private int g;

    /* JADX INFO: compiled from: WidgetGroup.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<com.obric.oui.constraintlayout.a.c.e> f34718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f34719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f34721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f34722e;
        int f;
        int g;

        a(com.obric.oui.constraintlayout.a.c.e r2, com.obric.oui.constraintlayout.a.d r3, int r4) {
            this.f34718a = new WeakReference(r2);
            this.f34719b = r3.b(r2.B);
            this.f34720c = r3.b(r2.C);
            this.f34721d = r3.b(r2.D);
            this.f34722e = r3.b(r2.E);
            this.f = r3.b(r2.F);
            this.g = r4;
        }
    }

    static {
    }

    public o(int r3) {
        this.f34714a = new ArrayList();
        this.f34715c = -1;
        this.f34716d = false;
        this.f34717e = 0;
        this.f = null;
        this.g = -1;
        int r0 = f34713b;
        f34713b = r0 + 1;
        this.f34715c = r0;
        this.f34717e = r3;
    }

    public int a() {
        return this.f34717e;
    }

    public int b() {
        return this.f34715c;
    }

    public boolean a(com.obric.oui.constraintlayout.a.c.e r2) {
        if (this.f34714a.contains(r2) == false) goto L6;
        return false;
    L6:
        this.f34714a.add(r2);
        return true;
    }

    public void a(boolean r1) {
        this.f34716d = r1;
    }

    private String c() {
        int r1 = this.f34717e;
        if (r1 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r1 != 1) goto L11;
        return "Vertical";
    L11:
        if (r1 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    public String toString() {
        String r0 = c() + " [" + this.f34715c + "] <";
        Iterator<com.obric.oui.constraintlayout.a.c.e> r4 = this.f34714a.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + " " + ((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).C();
        goto L4
    L7:
        return r0 + " >";
    }

    public void a(int r5, o r6) {
        Iterator<com.obric.oui.constraintlayout.a.c.e> r0 = this.f34714a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.obric.oui.constraintlayout.a.c.e r1 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r6.a(r1);
        if (r5 == 0) goto L7;
        r1.ay = r6.b();
        goto L4
    L7:
        r1.ax = r6.b();
        goto L4
    L9:
        this.g = r6.f34715c;
    }

    public int a(com.obric.oui.constraintlayout.a.d r2, int r3) {
        if (this.f34714a.size() != 0) goto L7;
        return 0;
    L7:
        return a(r2, this.f34714a, r3);
    }

    private int a(com.obric.oui.constraintlayout.a.d r9, ArrayList<com.obric.oui.constraintlayout.a.c.e> r10, int r11) {
        int r0 = 0;
        com.obric.oui.constraintlayout.a.c.f r1 = (com.obric.oui.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r10.get(0), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).A(), com.obric.oui.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin");
        r9.b();
        r1.a(r9, false);
        int r2 = 0;
    L4:
        if (r2 >= r10.size()) goto L6;
        ((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r10.get(r2), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin")).a(r9, false);
        r2 = r2 + 1;
        goto L4
    L6:
        if (r11 != 0) goto L11;
        if (r1.aH <= 0) goto L11;
        com.obric.oui.constraintlayout.a.c.b.a(r1, r9, r10, 0);
    L11:
        if (r11 == 1) goto L13;
    L28:
        r9.f();     // Catch: Exception -> L17
    L19:
        this.f = new ArrayList();
    L21:
        if (r0 >= r10.size()) goto L23;
        this.f.add(new a((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r10.get(r0), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin"), r9, r11));
        r0 = r0 + 1;
        goto L21
    L23:
        if (r11 != 0) goto L27;
        int r8 = r9.b(r1.B);
        int r12 = r9.b(r1.D);
        r9.b();
    L26:
        return r12 - r8;
    L27:
        r8 = r9.b(r1.C);
        r12 = r9.b(r1.E);
        r9.b();
    L17:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L19
    L13:
        if (r1.aI <= 0) goto L28;
        com.obric.oui.constraintlayout.a.c.b.a(r1, r9, r10, 1);
        goto L28
    }

    public void a(int r1) {
        this.f34717e = r1;
    }

    public void a(ArrayList<o> r6) {
        int r0 = this.f34714a.size();
        if (this.g == (-1)) goto L12;
        if (r0 <= 0) goto L12;
        int r1 = 0;
    L7:
        if (r1 >= r6.size()) goto L12;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r6.get(r1), o.class, "com.obric.aiagent.plugin");
        if (this.g != r2.f34715c) goto L11;
        a(this.f34717e, r2);
    L11:
        r1 = r1 + 1;
    L12:
        if (r0 != 0) goto L18;
        r6.remove(this);
        return;
    }
}
