package com.fasterxml.jackson.a.e;

import androidx.core.internal.view.SupportMenu;
import com.fasterxml.jackson.a.d.j;
import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.m;
import com.fasterxml.jackson.a.o;
import com.fasterxml.jackson.a.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: WriterBasedJsonGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends b {
    protected static final char[] s = null;
    protected q A;
    protected char[] B;
    protected final Writer t;
    protected char u;
    protected char[] v;
    protected int w;
    protected int x;
    protected int y;
    protected char[] z;

    static {
        s = com.fasterxml.jackson.a.d.b.d();
    }

    public g(com.fasterxml.jackson.a.d.e r1, int r2, o r3, Writer r4, char r5) {
        super(r1, r2, r3);
        this.t = r4;
        char[] r6 = r1.f();
        this.v = r6;
        this.y = r6.length;
        this.u = r5;
        if (r5 == '\"') goto L6;
        this.n = com.fasterxml.jackson.a.d.b.a(r5);
        return;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(String r3) {
        int r0 = this.i.a(r3);
        if (r0 != 4) goto L5;
        g("Can not write a field name, expecting a value");
    L5:
        boolean r1 = true;
        if (r0 == 1) goto L9;
        r1 = false;
    L9:
        a(r3, r1);
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public void b(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        int r0 = this.i.a(r4.a());
        if (r0 != 4) goto L5;
        g("Can not write a field name, expecting a value");
    L5:
        boolean r1 = true;
        if (r0 == 1) goto L9;
        r1 = false;
    L9:
        a(r4, r1);
    }

    public final void a(String r3, boolean r4) {
        if (this.f12080d == null) goto L7;
        b(r3, r4);
        return;
    L7:
        if ((this.x + 1) < this.y) goto L9;
        q();
    L9:
        if (r4 == false) goto L12;
        char[] r5 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r5[r0] = ',';
    L12:
        if (this.r == false) goto L15;
        l(r3);
        return;
    L15:
        char[] r6 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r6[r1] = this.u;
        l(r3);
        if (this.x < this.y) goto L18;
        q();
    L18:
        char[] r7 = this.v;
        int r8 = this.x;
        this.x = r8 + 1;
        r7[r8] = this.u;
    }

    public final void a(q r4, boolean r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        if (this.f12080d == null) goto L7;
        b(r6, r5);
        return;
    L7:
        if ((this.x + 1) < this.y) goto L9;
        q();
    L9:
        if (r5 == false) goto L12;
        char[] r7 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r7[r0] = ',';
    L12:
        if (this.r == false) goto L15;
        char[] r8 = r6.b();
        b(r8, 0, r8.length);
        return;
    L15:
        char[] r9 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r9[r1] = this.u;
        int r10 = r6.a(r9, r2);
        if (r10 >= 0) goto L19;
        f(r6);
        return;
    L19:
        int r11 = this.x + r10;
        this.x = r11;
        if (r11 < this.y) goto L22;
        q();
    L22:
        char[] r12 = this.v;
        int r13 = this.x;
        this.x = r13 + 1;
        r12[r13] = this.u;
    }

    private final void f(q r3) {
        char[] r4 = ((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin")).b();
        b(r4, 0, r4.length);
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r5 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r5[r0] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void h() {
        h("start an array");
        this.i = this.i.j();
        if (this.f12080d == null) goto L6;
        this.f12080d.e(this);
        return;
    L6:
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = '[';
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(Object r3) {
        h("start an array");
        this.i = this.i.b(r3);
        if (this.f12080d == null) goto L6;
        this.f12080d.e(this);
        return;
    L6:
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r4 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r4[r0] = '[';
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(Object r2, int r3) {
        h("start an array");
        this.i = this.i.b(r2);
        if (this.f12080d == null) goto L6;
        this.f12080d.e(this);
        return;
    L6:
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r4 = this.v;
        int r5 = this.x;
        this.x = r5 + 1;
        r4[r5] = '[';
    }

    @Override // com.fasterxml.jackson.a.h
    public void i() {
        if (this.i.b() == true) goto L6;
        g("Current context not Array but " + this.i.e());
    L6:
        if (this.f12080d == null) goto L9;
        this.f12080d.b(this, this.i.f());
    L12:
        this.i = this.i.m();
        return;
    L9:
        if (this.x < this.y) goto L11;
        q();
    L11:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = ']';
        goto L12
    }

    @Override // com.fasterxml.jackson.a.h
    public void j() {
        h("start an object");
        this.i = this.i.k();
        if (this.f12080d == null) goto L6;
        this.f12080d.b(this);
        return;
    L6:
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = '{';
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public void c(Object r3) {
        h("start an object");
        this.i = this.i.c(r3);
        if (this.f12080d == null) goto L6;
        this.f12080d.b(this);
        return;
    L6:
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r4 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r4[r0] = '{';
    }

    @Override // com.fasterxml.jackson.a.h
    public void k() {
        if (this.i.d() == true) goto L6;
        g("Current context not Object but " + this.i.e());
    L6:
        if (this.f12080d == null) goto L9;
        this.f12080d.a(this, this.i.f());
    L12:
        this.i = this.i.m();
        return;
    L9:
        if (this.x < this.y) goto L11;
        q();
    L11:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = '}';
        goto L12
    }

    public final void b(String r3, boolean r4) {
        if (r4 == false) goto L4;
        this.f12080d.c(this);
    L6:
        if (this.r == false) goto L9;
        l(r3);
        return;
    L9:
        if (this.x < this.y) goto L11;
        q();
    L11:
        char[] r5 = this.v;
        int r0 = this.x;
        this.x = r0 + 1;
        r5[r0] = this.u;
        l(r3);
        if (this.x < this.y) goto L14;
        q();
    L14:
        char[] r6 = this.v;
        int r7 = this.x;
        this.x = r7 + 1;
        r6[r7] = this.u;
        return;
    L4:
        this.f12080d.h(this);
        goto L6
    }

    public final void b(q r4, boolean r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L5;
        this.f12080d.c(this);
    L6:
        char[] r7 = r6.b();
        if (this.r == false) goto L10;
        b(r7, 0, r7.length);
        return;
    L10:
        if (this.x < this.y) goto L12;
        q();
    L12:
        char[] r8 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r8[r1] = this.u;
        b(r7, 0, r7.length);
        if (this.x < this.y) goto L15;
        q();
    L15:
        char[] r9 = this.v;
        int r10 = this.x;
        this.x = r10 + 1;
        r9[r10] = this.u;
        return;
    L5:
        this.f12080d.h(this);
        goto L6
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(String r4) {
        h("write a string");
        if (r4 != null) goto L7;
        r();
        return;
    L7:
        if (this.x < this.y) goto L9;
        q();
    L9:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = this.u;
        l(r4);
        if (this.x < this.y) goto L12;
        q();
    L12:
        char[] r5 = this.v;
        int r2 = this.x;
        this.x = r2 + 1;
        r5[r2] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(char[] r4, int r5, int r6) {
        h("write a string");
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = this.u;
        c(r4, r5, r6);
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r7 = this.v;
        int r8 = this.x;
        this.x = r8 + 1;
        r7[r8] = this.u;
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public void c(q r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        h("write a string");
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r0[r1] = this.u;
        int r3 = r6.a(r0, r2);
        if (r3 >= 0) goto L9;
        g(r6);
        return;
    L9:
        int r7 = this.x + r3;
        this.x = r7;
        if (r7 < this.y) goto L12;
        q();
    L12:
        char[] r8 = this.v;
        int r4 = this.x;
        this.x = r4 + 1;
        r8[r4] = this.u;
    }

    private void g(q r5) {
        char[] r6 = ((q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin")).b();
        int r0 = r6.length;
        if (r0 < 32) goto L5;
        q();
        this.t.write(r6, 0, r0);
    L10:
        if (this.x < this.y) goto L12;
        q();
    L12:
        char[] r7 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r7[r1] = this.u;
        return;
    L5:
        if (r0 <= (this.y - this.x)) goto L7;
        q();
    L7:
        System.arraycopy(r6, 0, this.v, this.x, r0);
        this.x += r0;
        goto L10
    }

    @Override // com.fasterxml.jackson.a.h
    public void c(String r5) {
        int r0 = r5.length();
        int r1 = this.y - this.x;
        if (r1 != 0) goto L5;
        q();
        r1 = this.y - this.x;
    L5:
        if (r1 < r0) goto L7;
        r5.getChars(0, r0, this.v, this.x);
        this.x += r0;
        return;
    L7:
        j(r5);
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        int r0 = r4.b(this.v, this.x);
        if (r0 >= 0) goto L6;
        c(r4.a());
        return;
    L6:
        this.x += r0;
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(char[] r3, int r4, int r5) {
        if (r5 < 32) goto L5;
        q();
        this.t.write(r3, r4, r5);
        return;
    L5:
        if (r5 <= (this.y - this.x)) goto L7;
        q();
    L7:
        System.arraycopy(r3, r4, this.v, this.x, r5);
        this.x += r5;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(char r4) {
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = r4;
    }

    private void j(String r7) {
        int r0 = this.y;
        int r1 = this.x;
        int r2 = r0 - r1;
        r7.getChars(0, r2, this.v, r1);
        this.x += r2;
        q();
        int r3 = r7.length() - r2;
    L3:
        int r4 = this.y;
        if (r3 <= r4) goto L6;
        int r5 = r2 + r4;
        r7.getChars(r2, r5, this.v, 0);
        this.w = 0;
        this.x = r4;
        q();
        r3 = r3 - r4;
        r2 = r5;
        goto L3
    L6:
        r7.getChars(r2, r2 + r3, this.v, 0);
        this.w = 0;
        this.x = r3;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(com.fasterxml.jackson.a.a r4, byte[] r5, int r6, int r7) {
        h("write a binary value");
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = this.u;
        b(r4, r5, r6, r7 + r6);
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r8 = this.v;
        int r9 = this.x;
        this.x = r9 + 1;
        r8[r9] = this.u;
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h
    public int a(com.fasterxml.jackson.a.a r4, InputStream r5, int r6) {
        h("write a binary value");
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = this.u;
        byte[] r2 = this.m.d();
        if (r6 >= 0) goto L8;
        r6 = a(r4, r5, r2);     // Catch: Throwable -> L16
    L11:
        this.m.a(r2);
        if (this.x < this.y) goto L14;
        q();
    L14:
        char[] r7 = this.v;
        int r8 = this.x;
        this.x = r8 + 1;
        r7[r8] = this.u;
        return r6;
    L8:
        int r9 = a(r4, r5, r2, r6);     // Catch: Throwable -> L16
        if (r9 <= 0) goto L11;
        g("Too few bytes available: missing " + r9 + " bytes (out of " + r6 + ")");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.m.a(r2);
        throw th;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(short r3) {
        h("write a number");
        if (this.h == false) goto L7;
        b(r3);
        return;
    L7:
        if ((this.x + 6) < this.y) goto L9;
        q();
    L9:
        this.x = j.a(r3, this.v, this.x);
    }

    private void b(short r5) {
        if ((this.x + 8) < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r0[r1] = this.u;
        int r6 = j.a(r5, r0, r2);
        this.x = r6;
        char[] r3 = this.v;
        this.x = r6 + 1;
        r3[r6] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void d(int r3) {
        h("write a number");
        if (this.h == false) goto L7;
        e(r3);
        return;
    L7:
        if ((this.x + 11) < this.y) goto L9;
        q();
    L9:
        this.x = j.a(r3, this.v, this.x);
    }

    private void e(int r5) {
        if ((this.x + 13) < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r0[r1] = this.u;
        int r6 = j.a(r5, r0, r2);
        this.x = r6;
        char[] r3 = this.v;
        this.x = r6 + 1;
        r3[r6] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void b(long r3) {
        h("write a number");
        if (this.h == false) goto L7;
        c(r3);
        return;
    L7:
        if ((this.x + 21) < this.y) goto L9;
        q();
    L9:
        this.x = j.a(r3, this.v, this.x);
    }

    private void c(long r5) {
        if ((this.x + 23) < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r0[r1] = this.u;
        int r6 = j.a(r5, r0, r2);
        this.x = r6;
        char[] r7 = this.v;
        this.x = r6 + 1;
        r7[r6] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigInteger r2) {
        h("write a number");
        if (r2 != null) goto L6;
        r();
        return;
    L6:
        if (this.h == false) goto L8;
        k(r2.toString());
        return;
    L8:
        c(r2.toString());
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(double r2) {
        if (this.h == false) goto L5;
    L11:
        b(String.valueOf(r2));
        return;
    L5:
        if (j.a(r2) == true) goto L7;
    L9:
        h("write a number");
        c(String.valueOf(r2));
        return;
    L7:
        if (b(h.a.f12086e) == false) goto L9;
        goto L9
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(float r2) {
        if (this.h == false) goto L5;
    L11:
        b(String.valueOf(r2));
        return;
    L5:
        if (j.a(r2) == true) goto L7;
    L9:
        h("write a number");
        c(String.valueOf(r2));
        return;
    L7:
        if (b(h.a.f12086e) == false) goto L9;
        goto L9
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(BigDecimal r2) {
        h("write a number");
        if (r2 != null) goto L6;
        r();
        return;
    L6:
        if (this.h == false) goto L8;
        k(b(r2));
        return;
    L8:
        c(b(r2));
    }

    @Override // com.fasterxml.jackson.a.h
    public void e(String r2) {
        h("write a number");
        if (r2 != null) goto L6;
        r();
        return;
    L6:
        if (this.h == false) goto L8;
        k(r2);
        return;
    L8:
        c(r2);
    }

    private void k(String r4) {
        if (this.x < this.y) goto L5;
        q();
    L5:
        char[] r0 = this.v;
        int r1 = this.x;
        this.x = r1 + 1;
        r0[r1] = this.u;
        c(r4);
        if (this.x < this.y) goto L8;
        q();
    L8:
        char[] r5 = this.v;
        int r2 = this.x;
        this.x = r2 + 1;
        r5[r2] = this.u;
    }

    @Override // com.fasterxml.jackson.a.h
    public void a(boolean r4) {
        h("write a boolean value");
        if ((this.x + 5) < this.y) goto L5;
        q();
    L5:
        int r0 = this.x;
        char[] r1 = this.v;
        if (r4 == false) goto L8;
        r1[r0] = 't';
        int r2 = r0 + 1;
        r1[r2] = 'r';
        int r3 = r2 + 1;
        r1[r3] = 'u';
        int r5 = r3 + 1;
        r1[r5] = 'e';
    L9:
        this.x = r5 + 1;
        return;
    L8:
        r1[r0] = 'f';
        int r6 = r0 + 1;
        r1[r6] = 'a';
        int r7 = r6 + 1;
        r1[r7] = 'l';
        int r8 = r7 + 1;
        r1[r8] = 's';
        r5 = r8 + 1;
        r1[r5] = 'e';
        goto L9
    }

    @Override // com.fasterxml.jackson.a.h
    public void l() {
        h("write a null");
        r();
    }

    @Override // com.fasterxml.jackson.a.a.a
    public final void h(String r4) {
        int r0 = this.i.o();
        if (this.f12080d == null) goto L7;
        a(r4, r0);
        return;
    L7:
        if (r0 != 1) goto L9;
        char r5 = ',';
    L24:
        if (this.x < this.y) goto L26;
        q();
    L26:
        char[] r1 = this.v;
        int r2 = this.x;
        this.x = r2 + 1;
        r1[r2] = r5;
        return;
    L9:
        if (r0 != 2) goto L11;
        r5 = ':';
        goto L24
    L11:
        if (r0 == 3) goto L18;
        if (r0 == 5) goto L15;
        return;
    L15:
        i(r4);
        return;
    L18:
        if (this.q == null) goto L28;
        c(this.q.a());
        return;
    }

    @Override // com.fasterxml.jackson.a.h, java.io.Flushable
    public void flush() {
        q();
        if (this.t != null) goto L5;
        return;
    L5:
        if (b(h.a.f12084c) == false) goto L9;
        this.t.flush();
        return;
    }

    @Override // com.fasterxml.jackson.a.a.a, com.fasterxml.jackson.a.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.v != null) goto L5;
    L12:
        q();
        this.w = 0;
        this.x = 0;
        if (this.t != null) goto L15;
    L23:
        p();
        return;
    L15:
        if (this.m.a() == false) goto L17;
    L22:
        this.t.close();
        goto L23
    L17:
        if (b(h.a.f12082a) == true) goto L22;
        if (b(h.a.f12084c) == false) goto L23;
        this.t.flush();
        goto L23
    L5:
        if (b(h.a.f12083b) == false) goto L12;
    L6:
        m r0 = a();
        if (r0.b() == true) goto L8;
        if (r0.d() == false) goto L12;
        k();
        goto L6
    L8:
        i();
        goto L6
    }

    public void p() {
        char[] r0 = this.v;
        if (r0 == null) goto L5;
        this.v = null;
        this.m.b(r0);
    L5:
        char[] r1 = this.B;
        if (r1 == null) goto L9;
        this.B = null;
        this.m.c(r1);
        return;
    }

    private void l(String r5) {
        int r0 = r5.length();
        int r1 = this.y;
        if (r0 <= r1) goto L7;
        m(r5);
        return;
    L7:
        if ((this.x + r0) <= r1) goto L9;
        q();
    L9:
        r5.getChars(0, r0, this.v, this.x);
        if (this.p == null) goto L13;
        h(r0);
        return;
    L13:
        if (this.o == 0) goto L15;
        d(r0, this.o);
        return;
    L15:
        f(r0);
    }

    private void f(int r7) {
        int r0 = this.x + r7;
        int[] r8 = this.n;
        int r1 = r8.length;
    L4:
        if (this.x >= r0) goto L15;
    L5:
        char[] r2 = this.v;
        int r3 = this.x;
        char r4 = r2[r3];
        if (r4 < r1) goto L8;
    L13:
        int r5 = r3 + 1;
        this.x = r5;
        if (r5 < r0) goto L5;
        return;
    L8:
        if (r8[r4] == 0) goto L13;
        int r6 = this.w;
        int r9 = r3 - r6;
        if (r9 <= 0) goto L12;
        this.t.write(r2, r6, r9);
    L12:
        char[] r10 = this.v;
        int r11 = this.x;
        this.x = r11 + 1;
        char r12 = r10[r11];
        a(r12, r8[r12]);
        goto L4
    }

    private void m(String r7) {
        q();
        int r0 = r7.length();
        int r2 = 0;
    L3:
        int r3 = this.y;
        if ((r2 + r3) <= r0) goto L6;
        r3 = r0 - r2;
    L6:
        int r4 = r2 + r3;
        r7.getChars(r2, r4, this.v, 0);
        if (this.p == null) goto L10;
        i(r3);
    L13:
        if (r4 >= r0) goto L14;
        r2 = r4;
        goto L3
    L14:
        return;
    L10:
        if (this.o == 0) goto L12;
        e(r3, this.o);
        goto L13
    L12:
        g(r3);
        goto L13
    }

    private void g(int r12) {
        int[] r0 = this.n;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r12) goto L17;
    L4:
        char[] r4 = this.v;
        char r9 = r4[r2];
        if (r9 < r1) goto L7;
    L9:
        r2 = r2 + 1;
        if (r2 < r12) goto L4;
    L11:
        int r5 = r2 - r3;
        if (r5 <= 0) goto L16;
        this.t.write(r4, r3, r5);
        if (r2 < r12) goto L16;
        return;
    L16:
        r2 = r2 + 1;
        r3 = a(this.v, r2, r12, r9, r0[r9]);
        goto L3
    L7:
        if (r0[r9] == 0) goto L9;
    }

    private void c(char[] r7, int r8, int r9) {
        if (this.p == null) goto L7;
        d(r7, r8, r9);
        return;
    L7:
        if (this.o == 0) goto L10;
        a(r7, r8, r9, this.o);
        return;
    L10:
        int r10 = r9 + r8;
        int[] r0 = this.n;
        int r1 = r0.length;
    L11:
        if (r8 >= r10) goto L31;
        int r2 = r8;
    L13:
        char r3 = r7[r2];
        if (r3 < r1) goto L16;
    L18:
        r2 = r2 + 1;
        if (r2 < r10) goto L13;
    L20:
        int r4 = r2 - r8;
        if (r4 < 32) goto L23;
        q();
        this.t.write(r7, r8, r4);
    L28:
        if (r2 >= r10) goto L37;
        r8 = r2 + 1;
        char r5 = r7[r2];
        b(r5, r0[r5]);
        goto L11
    L37:
        return;
    L23:
        if ((this.x + r4) <= this.y) goto L25;
        q();
    L25:
        if (r4 <= 0) goto L28;
        System.arraycopy(r7, r8, this.v, this.x, r4);
        this.x += r4;
        goto L28
    L16:
        if (r0[r3] == 0) goto L18;
    }

    private void d(int r9, int r10) {
        int r0 = this.x + r9;
        int[] r11 = this.n;
        int r1 = Math.min(r11.length, r10 + 1);
    L4:
        if (this.x >= r0) goto L18;
    L5:
        char[] r2 = this.v;
        int r3 = this.x;
        char r4 = r2[r3];
        if (r4 >= r1) goto L10;
        int r5 = r11[r4];
        if (r5 != 0) goto L12;
    L16:
        int r6 = r3 + 1;
        this.x = r6;
        if (r6 < r0) goto L5;
        return;
    L12:
        int r7 = this.w;
        int r8 = r3 - r7;
        if (r8 <= 0) goto L15;
        this.t.write(r2, r7, r8);
    L15:
        this.x++;
        a(r4, r5);
        goto L4
    L10:
        if (r4 <= r10) goto L16;
        r5 = -1;
        goto L12
    }

    private void e(int r13, int r14) {
        int[] r0 = this.n;
        int r1 = Math.min(r0.length, r14 + 1);
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r13) goto L19;
    L4:
        char[] r5 = this.v;
        char r10 = r5[r2];
        if (r10 >= r1) goto L9;
        r4 = r0[r10];
        if (r4 != 0) goto L13;
    L11:
        r2 = r2 + 1;
        if (r2 < r13) goto L4;
    L13:
        int r6 = r2 - r3;
        if (r6 <= 0) goto L18;
        this.t.write(r5, r3, r6);
        if (r2 < r13) goto L18;
        return;
    L18:
        r2 = r2 + 1;
        r3 = a(this.v, r2, r13, r10, r4);
        goto L3
    L9:
        if (r10 <= r14) goto L11;
        r4 = -1;
        goto L13
    }

    private void a(char[] r9, int r10, int r11, int r12) {
        int r13 = r11 + r10;
        int[] r0 = this.n;
        int r1 = Math.min(r0.length, r12 + 1);
        int r2 = 0;
    L3:
        if (r10 >= r13) goto L25;
        int r3 = r10;
    L5:
        char r4 = r9[r3];
        if (r4 >= r1) goto L10;
        r2 = r0[r4];
        if (r2 != 0) goto L14;
    L12:
        r3 = r3 + 1;
        if (r3 < r13) goto L5;
    L14:
        int r5 = r3 - r10;
        if (r5 < 32) goto L17;
        q();
        this.t.write(r9, r10, r5);
    L22:
        if (r3 >= r13) goto L32;
        r10 = r3 + 1;
        b(r4, r2);
        goto L3
    L32:
        return;
    L17:
        if ((this.x + r5) <= this.y) goto L19;
        q();
    L19:
        if (r5 <= 0) goto L22;
        System.arraycopy(r9, r10, this.v, this.x, r5);
        this.x += r5;
        goto L22
    L10:
        if (r4 <= r12) goto L12;
        r2 = -1;
        goto L14
    }

    private void h(int r12) {
        int r0 = this.x + r12;
        int[] r13 = this.n;
        if (this.o >= 1) goto L5;
        int r1 = SupportMenu.USER_MASK;
    L6:
        int r3 = Math.min(r13.length, r1 + 1);
        com.fasterxml.jackson.a.d.c r4 = this.p;
    L8:
        if (this.x >= r0) goto L25;
    L9:
        char r5 = this.v[this.x];
        if (r5 >= r3) goto L14;
        int r6 = r13[r5];
        if (r6 != 0) goto L19;
    L23:
        int r7 = this.x + 1;
        this.x = r7;
        if (r7 < r0) goto L9;
        return;
    L19:
        int r8 = this.x;
        int r9 = this.w;
        int r10 = r8 - r9;
        if (r10 <= 0) goto L22;
        this.t.write(this.v, r9, r10);
    L22:
        this.x++;
        a(r5, r6);
        goto L8
    L14:
        if (r5 > r1) goto L15;
        q r11 = r4.a(r5);
        this.A = r11;
        if (r11 == null) goto L23;
        r6 = -2;
        goto L19
    L15:
        r6 = -1;
        goto L19
    L25:
        return;
    L5:
        r1 = this.o;
        goto L6
    }

    private void i(int r15) {
        int[] r0 = this.n;
        if (this.o >= 1) goto L5;
        int r1 = SupportMenu.USER_MASK;
    L6:
        int r2 = Math.min(r0.length, r1 + 1);
        com.fasterxml.jackson.a.d.c r3 = this.p;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L7:
        if (r4 >= r15) goto L26;
    L8:
        char r12 = this.v[r4];
        if (r12 >= r2) goto L13;
        r6 = r0[r12];
        if (r6 != 0) goto L20;
    L18:
        r4 = r4 + 1;
        if (r4 < r15) goto L8;
    L20:
        int r7 = r4 - r5;
        if (r7 <= 0) goto L25;
        this.t.write(this.v, r5, r7);
        if (r4 < r15) goto L25;
        return;
    L25:
        r4 = r4 + 1;
        r5 = a(this.v, r4, r15, r12, r6);
        goto L7
    L13:
        if (r12 > r1) goto L14;
        q r8 = r3.a(r12);
        this.A = r8;
        if (r8 == null) goto L18;
        r6 = -2;
        goto L20
    L14:
        r6 = -1;
        goto L20
    L26:
        return;
    L5:
        r1 = this.o;
        goto L6
    }

    private void d(char[] r11, int r12, int r13) {
        int r14 = r13 + r12;
        int[] r0 = this.n;
        if (this.o >= 1) goto L5;
        int r1 = SupportMenu.USER_MASK;
    L6:
        int r2 = Math.min(r0.length, r1 + 1);
        com.fasterxml.jackson.a.d.c r3 = this.p;
        int r4 = 0;
    L7:
        if (r12 >= r14) goto L32;
        int r5 = r12;
    L9:
        char r6 = r11[r5];
        if (r6 >= r2) goto L14;
        r4 = r0[r6];
        if (r4 != 0) goto L21;
    L19:
        r5 = r5 + 1;
        if (r5 < r14) goto L9;
    L21:
        int r7 = r5 - r12;
        if (r7 < 32) goto L24;
        q();
        this.t.write(r11, r12, r7);
    L29:
        if (r5 >= r14) goto L40;
        r12 = r5 + 1;
        b(r6, r4);
        goto L7
    L40:
        return;
    L24:
        if ((this.x + r7) <= this.y) goto L26;
        q();
    L26:
        if (r7 <= 0) goto L29;
        System.arraycopy(r11, r12, this.v, this.x, r7);
        this.x += r7;
        goto L29
    L14:
        if (r6 > r1) goto L15;
        q r8 = r3.a(r6);
        this.A = r8;
        if (r8 == null) goto L19;
        r4 = -2;
        goto L21
    L15:
        r4 = -1;
        goto L21
    L32:
        return;
    L5:
        r1 = this.o;
        goto L6
    }

    public final void b(com.fasterxml.jackson.a.a r8, byte[] r9, int r10, int r11) {
        int r0 = r11 - 3;
        int r1 = this.y - 6;
        int r2 = r8.f() >> 2;
    L3:
        if (r10 > r0) goto L11;
        if (this.x <= r1) goto L7;
        q();
    L7:
        int r4 = r10 + 1;
        int r5 = r4 + 1;
        int r12 = ((r9[r10] << 8) | (r9[r4] & 255)) << 8;
        int r6 = r5 + 1;
        int r13 = r8.a(r12 | (r9[r5] & 255), this.v, this.x);
        this.x = r13;
        r2 = r2 - 1;
        if (r2 > 0) goto L10;
        char[] r3 = this.v;
        int r7 = r13 + 1;
        this.x = r7;
        r3[r13] = '\\';
        this.x = r7 + 1;
        r3[r7] = 'n';
        r2 = r8.f() >> 2;
    L10:
        r10 = r6;
        goto L3
    L11:
        int r14 = r11 - r10;
        if (r14 > 0) goto L14;
        return;
    L14:
        if (this.x <= r1) goto L16;
        q();
    L16:
        int r15 = r10 + 1;
        int r16 = r9[r10] << 16;
        if (r14 != 2) goto L19;
        r16 = r16 | ((r9[r15] & 255) << 8);
    L19:
        this.x = r8.a(r16, r14, this.v, this.x);
    }

    public final int a(com.fasterxml.jackson.a.a r12, InputStream r13, byte[] r14, int r15) {
        int r0 = this.y - 6;
        int r2 = 2;
        int r1 = r12.f() >> 2;
        int r3 = -3;
        int r8 = 0;
        int r9 = 0;
    L3:
        if (r15 <= 2) goto L15;
        if (r8 <= r3) goto L10;
        r9 = a(r13, r14, r8, r9, r15);
        if (r9 < 3) goto L7;
        r3 = r9 - 3;
        r8 = 0;
        goto L10
    L7:
        r8 = 0;
    L10:
        if (this.x <= r0) goto L12;
        q();
    L12:
        int r5 = r8 + 1;
        int r6 = r14[r8] << 8;
        int r7 = r5 + 1;
        r8 = r7 + 1;
        r15 = r15 - 3;
        int r10 = r12.a((((r14[r5] & 255) | r6) << 8) | (r14[r7] & 255), this.v, this.x);
        this.x = r10;
        r1 = r1 - 1;
        if (r1 > 0) goto L3;
        char[] r4 = this.v;
        int r11 = r10 + 1;
        this.x = r11;
        r4[r10] = '\\';
        this.x = r11 + 1;
        r4[r11] = 'n';
        r1 = r12.f() >> 2;
    L15:
        if (r15 <= 0) goto L33;
        int r16 = a(r13, r14, r8, r9, r15);
        if (r16 > 0) goto L19;
        return r15;
    L19:
        if (this.x <= r0) goto L21;
        q();
    L21:
        int r17 = r14[0] << 16;
        if (1 >= r16) goto L24;
        r17 = r17 | ((r14[1] & 255) << 8);
    L25:
        this.x = r12.a(r17, r2, this.v, this.x);
        return r15 - r2;
    L24:
        r2 = 1;
        goto L25
    L33:
        return r15;
    }

    public final int a(com.fasterxml.jackson.a.a r13, InputStream r14, byte[] r15) {
        int r0 = this.y - 6;
        int r2 = 2;
        int r1 = r13.f() >> 2;
        int r4 = -3;
        int r8 = 0;
        int r9 = 0;
        int r11 = 0;
    L3:
        if (r8 <= r4) goto L18;
        r9 = a(r14, r15, r8, r9, r15.length);
        if (r9 < 3) goto L6;
        r4 = r9 - 3;
        r8 = 0;
        goto L18
    L6:
        if (r9 > 0) goto L8;
        return r11;
    L8:
        if (this.x <= r0) goto L10;
        q();
    L10:
        int r16 = r15[0] << 16;
        if (1 >= r9) goto L13;
        r16 = r16 | ((r15[1] & 255) << 8);
    L14:
        int r12 = r11 + r2;
        this.x = r13.a(r16, r2, this.v, this.x);
        return r12;
    L13:
        r2 = 1;
    L18:
        if (this.x <= r0) goto L20;
        q();
    L20:
        int r5 = r8 + 1;
        int r6 = r15[r8] << 8;
        int r7 = r5 + 1;
        r8 = r7 + 1;
        r11 = r11 + 3;
        int r10 = r13.a((((r15[r5] & 255) | r6) << 8) | (r15[r7] & 255), this.v, this.x);
        this.x = r10;
        r1 = r1 - 1;
        if (r1 > 0) goto L3;
        char[] r3 = this.v;
        int r17 = r10 + 1;
        this.x = r17;
        r3[r10] = '\\';
        this.x = r17 + 1;
        r3[r17] = 'n';
        r1 = r13.f() >> 2;
        goto L3
    }

    private int a(InputStream r3, byte[] r4, int r5, int r6, int r7) {
        int r2 = 0;
    L3:
        if (r5 >= r6) goto L5;
        int r1 = r5 + 1;
        r4[r2] = r4[r5];
        r2 = r2 + 1;
        r5 = r1;
        goto L3
    L5:
        int r8 = Math.min(r7, r4.length);
    L6:
        int r9 = r8 - r2;
        if (r9 == 0) goto L14;
        int r10 = r3.read(r4, r2, r9);
        if (r10 < 0) goto L11;
        r2 = r2 + r10;
        if (r2 < 3) goto L6;
    L11:
        return r2;
    L14:
        return r2;
    }

    private final void r() {
        if ((this.x + 4) < this.y) goto L5;
        q();
    L5:
        int r0 = this.x;
        char[] r1 = this.v;
        r1[r0] = 'n';
        int r2 = r0 + 1;
        r1[r2] = 'u';
        int r3 = r2 + 1;
        r1[r3] = 'l';
        int r4 = r3 + 1;
        r1[r4] = 'l';
        this.x = r4 + 1;
    }

    private void a(char r6, int r7) {
        if (r7 < 0) goto L14;
        int r8 = this.x;
        if (r8 < 2) goto L8;
        int r9 = r8 - 2;
        this.w = r9;
        char[] r5 = this.v;
        r5[r9] = '\\';
        r5[r9 + 1] = (char) r7;
        return;
    L8:
        char[] r10 = this.z;
        if (r10 != null) goto L11;
        r10 = s();
    L11:
        this.w = this.x;
        r10[1] = (char) r7;
        this.t.write(r10, 0, 2);
        return;
    L14:
        if (r7 == (-2)) goto L31;
        int r11 = this.x;
        if (r11 < 6) goto L23;
        char[] r2 = this.v;
        int r12 = r11 - 6;
        this.w = r12;
        r2[r12] = '\\';
        int r13 = r12 + 1;
        r2[r13] = 'u';
        if (r6 <= 255) goto L20;
        int r14 = (r6 >> '\b') & 255;
        int r15 = r13 + 1;
        char[] r0 = s;
        r2[r15] = r0[r14 >> 4];
        int r16 = r15 + 1;
        r2[r16] = r0[r14 & 15];
        r6 = (char) (r6 & 255);
    L21:
        int r17 = r16 + 1;
        char[] r18 = s;
        r2[r17] = r18[r6 >> 4];
        r2[r17 + 1] = r18[r6 & 15];
        return;
    L20:
        int r19 = r13 + 1;
        r2[r19] = '0';
        r16 = r19 + 1;
        r2[r16] = '0';
        goto L21
    L23:
        char[] r20 = this.z;
        if (r20 != null) goto L26;
        r20 = s();
    L26:
        this.w = this.x;
        if (r6 <= 255) goto L29;
        int r1 = (r6 >> '\b') & 255;
        int r21 = r6 & 255;
        char[] r3 = s;
        r20[10] = r3[r1 >> 4];
        r20[11] = r3[r1 & 15];
        r20[12] = r3[r21 >> 4];
        r20[13] = r3[r21 & 15];
        this.t.write(r20, 8, 6);
        return;
    L29:
        char[] r4 = s;
        r20[6] = r4[r6 >> 4];
        r20[7] = r4[r6 & 15];
        this.t.write(r20, 2, 6);
        return;
    L31:
        q r22 = this.A;
        if (r22 != null) goto L34;
        String r23 = this.p.a(r6).a();
    L35:
        int r24 = r23.length();
        int r25 = this.x;
        if (r25 < r24) goto L39;
        int r26 = r25 - r24;
        this.w = r26;
        r23.getChars(0, r24, this.v, r26);
        return;
    L39:
        this.w = r25;
        this.t.write(r23);
        return;
    L34:
        r23 = r22.a();
        this.A = null;
        goto L35
    }

    private int a(char[] r5, int r6, int r7, char r8, int r9) {
        if (r9 < 0) goto L14;
        if (r6 <= 1) goto L8;
        if (r6 >= r7) goto L8;
        int r10 = r6 - 2;
        r5[r10] = '\\';
        r5[r10 + 1] = (char) r9;
        return r10;
    L8:
        char[] r11 = this.z;
        if (r11 != null) goto L11;
        r11 = s();
    L11:
        r11[1] = (char) r9;
        this.t.write(r11, 0, 2);
        return r6;
    L14:
        if (r9 != (-2)) goto L16;
        q r12 = this.A;
        if (r12 != null) goto L34;
        String r13 = this.p.a(r8).a();
    L35:
        int r14 = r13.length();
        if (r6 < r14) goto L39;
        if (r6 >= r7) goto L39;
        int r15 = r6 - r14;
        r13.getChars(0, r14, r5, r15);
        return r15;
    L39:
        this.t.write(r13);
        return r6;
    L34:
        r13 = r12.a();
        this.A = null;
        goto L35
    L16:
        if (r6 <= 5) goto L23;
        if (r6 >= r7) goto L23;
        int r16 = r6 - 6;
        int r4 = r16 + 1;
        r5[r16] = '\\';
        int r17 = r4 + 1;
        r5[r4] = 'u';
        if (r8 <= 255) goto L21;
        int r18 = (r8 >> '\b') & 255;
        int r19 = r17 + 1;
        char[] r20 = s;
        r5[r17] = r20[r18 >> 4];
        int r21 = r19 + 1;
        r5[r19] = r20[r18 & 15];
        r8 = (char) (r8 & 255);
    L22:
        int r22 = r21 + 1;
        char[] r23 = s;
        r5[r21] = r23[r8 >> 4];
        r5[r22] = r23[r8 & 15];
        return r22 - 5;
    L21:
        int r24 = r17 + 1;
        r5[r17] = '0';
        r21 = r24 + 1;
        r5[r24] = '0';
    L23:
        char[] r25 = this.z;
        if (r25 != null) goto L26;
        r25 = s();
    L26:
        this.w = this.x;
        if (r8 <= 255) goto L29;
        int r26 = (r8 >> '\b') & 255;
        int r27 = r8 & 255;
        char[] r1 = s;
        r25[10] = r1[r26 >> 4];
        r25[11] = r1[r26 & 15];
        r25[12] = r1[r27 >> 4];
        r25[13] = r1[r27 & 15];
        this.t.write(r25, 8, 6);
        return r6;
    L29:
        char[] r28 = s;
        r25[6] = r28[r8 >> 4];
        r25[7] = r28[r8 & 15];
        this.t.write(r25, 2, 6);
        return r6;
    }

    private void b(char r6, int r7) {
        if (r7 < 0) goto L10;
        if ((this.x + 2) <= this.y) goto L7;
        q();
    L7:
        char[] r8 = this.v;
        int r1 = this.x;
        int r2 = r1 + 1;
        this.x = r2;
        r8[r1] = '\\';
        this.x = r2 + 1;
        r8[r2] = (char) r7;
        return;
    L10:
        if (r7 != (-2)) goto L12;
        q r9 = this.A;
        if (r9 != null) goto L23;
        String r10 = this.p.a(r6).a();
    L24:
        int r11 = r10.length();
        if ((this.x + r11) <= this.y) goto L30;
        q();
        if (r11 <= this.y) goto L30;
        this.t.write(r10);
        return;
    L30:
        r10.getChars(0, r11, this.v, this.x);
        this.x += r11;
        return;
    L23:
        r10 = r9.a();
        this.A = null;
        goto L24
    L12:
        if ((this.x + 5) < this.y) goto L14;
        q();
    L14:
        int r12 = this.x;
        char[] r3 = this.v;
        int r4 = r12 + 1;
        r3[r12] = '\\';
        int r13 = r4 + 1;
        r3[r4] = 'u';
        if (r6 <= 255) goto L17;
        int r0 = 255 & (r6 >> '\b');
        int r5 = r13 + 1;
        char[] r14 = s;
        r3[r13] = r14[r0 >> 4];
        int r15 = r5 + 1;
        r3[r5] = r14[r0 & 15];
        r6 = (char) (r6 & 255);
    L18:
        int r16 = r15 + 1;
        char[] r17 = s;
        r3[r15] = r17[r6 >> 4];
        r3[r16] = r17[r6 & 15];
        this.x = r16 + 1;
        return;
    L17:
        int r18 = r13 + 1;
        r3[r13] = '0';
        r15 = r18 + 1;
        r3[r18] = '0';
        goto L18
    }

    private char[] s() {
        char[] r0 = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.z = r0;
        return r0;
    }

    public void q() {
        int r0 = this.x;
        int r1 = this.w;
        int r2 = r0 - r1;
        if (r2 <= 0) goto L6;
        this.w = 0;
        this.x = 0;
        this.t.write(this.v, r1, r2);
        return;
    }
}
