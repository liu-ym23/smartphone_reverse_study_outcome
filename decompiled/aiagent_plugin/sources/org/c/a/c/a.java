package org.c.a.c;

import java.io.Serializable;

/* JADX INFO: compiled from: Mark.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f40379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f40380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f40381e;
    private int f;

    public a(String r1, int r2, int r3, int r4, int[] r5, int r6) {
        this.f40377a = r1;
        this.f40378b = r2;
        this.f40379c = r3;
        this.f40380d = r4;
        this.f40381e = r5;
        this.f = r6;
    }

    private boolean a(int r1) {
        return org.c.a.j.a.f40483b.a(r1);
    }

    public String a(int r9, int r10) {
        float r11 = (r10 / 2.0f) - 1.0f;
        int r0 = this.f;
    L3:
        String r1 = " ... ";
        if (r0 <= 0) goto L10;
        if (a(this.f40381e[r0 - 1]) == true) goto L10;
        r0 = r0 - 1;
        if ((this.f - r0) <= r11) goto L3;
        r0 = r0 + 5;
        String r3 = " ... ";
    L11:
        int r4 = this.f;
    L12:
        int[] r5 = this.f40381e;
        if (r4 >= r5.length) goto L19;
        if (a(r5[r4]) == true) goto L19;
        r4 = r4 + 1;
        if ((r4 - this.f) <= r11) goto L12;
        r4 = r4 - 5;
    L20:
        StringBuilder r12 = new StringBuilder();
        int r2 = 0;
        int r6 = 0;
    L22:
        if (r6 >= r9) goto L24;
        r12.append(" ");
        r6 = r6 + 1;
        goto L22
    L24:
        r12.append(r3);
        int r7 = r0;
    L25:
        if (r7 >= r4) goto L27;
        r12.appendCodePoint(this.f40381e[r7]);
        r7 = r7 + 1;
        goto L25
    L27:
        r12.append(r1);
        r12.append("\n");
    L29:
        if (r2 >= (((this.f + r9) - r0) + r3.length())) goto L31;
        r12.append(" ");
        r2 = r2 + 1;
        goto L29
    L31:
        r12.append("^");
        return r12.toString();
    L19:
        r1 = "";
    L10:
        r3 = "";
        goto L11
    }

    public String a() {
        return a(4, 75);
    }

    public String toString() {
        return " in " + this.f40377a + ", line " + (this.f40379c + 1) + ", column " + (this.f40380d + 1) + ":\n" + a();
    }

    public String b() {
        return this.f40377a;
    }

    public int c() {
        return this.f40379c;
    }

    public int d() {
        return this.f40380d;
    }

    public int e() {
        return this.f40378b;
    }
}
