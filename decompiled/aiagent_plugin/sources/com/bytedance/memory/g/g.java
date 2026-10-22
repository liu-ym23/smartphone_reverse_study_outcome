package com.bytedance.memory.g;

/* JADX INFO: compiled from: HprofVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f8819a;

    public g(g r2) {
        this.f8819a = null;
        this.f8819a = r2;
    }

    public void a(String r1, int r2, long r3) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public void a(e r7, String r8, int r9, long r10) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r7, r8, r9, r10);
        return;
    }

    public void a(int r9, e r10, int r11, e r12, int r13, long r14) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r9, r10, r11, r12, r13, r14);
        return;
    }

    public void a(e r11, e r12, e r13, e r14, int r15, int r16, int r17, long r18) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    }

    public void a(int r8, int r9, e[] r10, int r11, long r12) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r8, r9, r10, r11, r12);
        return;
    }

    public d a(int r1, int r2, long r3) {
        g r0 = this.f8819a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2, r3);
    }

    public void a(int r7, int r8, long r9, byte[] r11) {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a(r7, r8, r9, r11);
        return;
    }

    public void a() {
        g r0 = this.f8819a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
