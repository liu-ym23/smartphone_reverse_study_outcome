package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: TextBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f12120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char[] f12122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12124e;
    private ArrayList<char[]> f;
    private boolean g;
    private int h;
    private char[] i;
    private int j;
    private String k;
    private char[] l;

    static {
        f12120a = new char[0];
    }

    public o(a r1) {
        this.f12121b = r1;
    }

    public o(a r1, char[] r2) {
        this.f12121b = r1;
        this.i = r2;
        this.j = r2.length;
        this.f12123d = -1;
    }

    public static o a(char[] r2) {
        return new o(null, r2);
    }

    public void a() {
        this.f12123d = -1;
        this.j = 0;
        this.f12124e = 0;
        this.f12122c = null;
        this.l = null;
        if (this.g == false) goto L5;
        m();
    L5:
        a r1 = this.f12121b;
        if (r1 == null) goto L11;
        char[] r2 = this.i;
        if (r2 == null) goto L12;
        this.i = null;
        r1.a(2, r2);
        return;
    L12:
        return;
    }

    public void a(char[] r2, int r3, int r4) {
        this.k = null;
        this.l = null;
        this.f12122c = r2;
        this.f12123d = r3;
        this.f12124e = r4;
        if (this.g == false) goto L6;
        m();
        return;
    }

    public void b(char[] r3, int r4, int r5) {
        this.f12122c = null;
        this.f12123d = -1;
        this.f12124e = 0;
        this.k = null;
        this.l = null;
        if (this.g == false) goto L6;
        m();
    L8:
        this.h = 0;
        this.j = 0;
        c(r3, r4, r5);
        return;
    L6:
        if (this.i != null) goto L8;
        this.i = b(r5);
        goto L8
    }

    public void a(String r3) {
        this.f12122c = null;
        this.f12123d = -1;
        this.f12124e = 0;
        this.k = r3;
        this.l = null;
        if (this.g == false) goto L5;
        m();
    L5:
        this.j = 0;
    }

    private char[] b(int r2) {
        a r1 = this.f12121b;
        if (r1 == null) goto L7;
        return r1.b(2, r2);
    L7:
        return new char[Math.max(r2, 500)];
    }

    private void m() {
        this.g = false;
        this.f.clear();
        this.h = 0;
        this.j = 0;
    }

    public int b() {
        if (this.f12123d >= 0) goto L5;
        char[] r0 = this.l;
        if (r0 != null) goto L9;
        String r1 = this.k;
        if (r1 == null) goto L15;
        return r1.length();
    L15:
        return this.h + this.j;
    L9:
        return r0.length;
    L5:
        return this.f12124e;
    }

    public int c() {
        int r0 = this.f12123d;
        if (r0 >= 0) goto L7;
        return 0;
    L7:
        return r0;
    }

    public char[] d() {
        if (this.f12123d >= 0) goto L5;
        char[] r0 = this.l;
        if (r0 == null) goto L9;
        return r0;
    L9:
        String r1 = this.k;
        if (r1 == null) goto L14;
        char[] r2 = r1.toCharArray();
        this.l = r2;
        return r2;
    L14:
        if (this.g == true) goto L20;
        char[] r3 = this.i;
        if (r3 == null) goto L18;
        return r3;
    L18:
        return f12120a;
    L20:
        return f();
    L5:
        return this.f12122c;
    }

    public String e() {
        if (this.k != null) goto L27;
        if (this.l == null) goto L7;
        this.k = new String(this.l);
        goto L27
    L7:
        String r1 = "";
        if (this.f12123d >= 0) goto L10;
        int r0 = this.h;
        int r2 = this.j;
        if (r0 != 0) goto L20;
        if (r2 == 0) goto L19;
        r1 = new String(this.i, 0, r2);
    L19:
        this.k = r1;
        goto L27
    L20:
        StringBuilder r3 = new StringBuilder(r0 + r2);
        ArrayList<char[]> r4 = this.f;
        if (r4 == null) goto L25;
        int r5 = r4.size();
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L25;
        char[] r7 = (char[]) ZeusTransformUtils.preCheckCast(this.f.get(r6), char[].class, "com.obric.aiagent.plugin");
        r3.append(r7, 0, r7.length);
        r6 = r6 + 1;
    L25:
        r3.append(this.i, 0, this.j);
        this.k = r3.toString();
        goto L27
    L10:
        if (this.f12124e >= 1) goto L13;
        this.k = "";
        return "";
    L13:
        this.k = new String(this.f12122c, this.f12123d, this.f12124e);
    L27:
        return this.k;
    }

    public char[] f() {
        char[] r0 = this.l;
        if (r0 != null) goto L6;
        char[] r1 = n();
        this.l = r1;
        return r1;
    L6:
        return r0;
    }

    public BigDecimal g() {
        char[] r0 = this.l;
        if (r0 != null) goto L5;
        int r1 = this.f12123d;
        if (r1 < 0) goto L13;
        char[] r2 = this.f12122c;
        if (r2 == null) goto L13;
        return com.fasterxml.jackson.a.d.i.c(r2, r1, this.f12124e);
    L13:
        if (this.h != 0) goto L19;
        char[] r3 = this.i;
        if (r3 == null) goto L19;
        return com.fasterxml.jackson.a.d.i.c(r3, 0, this.j);
    L19:
        return com.fasterxml.jackson.a.d.i.a(f());
    L5:
        return com.fasterxml.jackson.a.d.i.a(r0);
    }

    public double h() {
        return com.fasterxml.jackson.a.d.i.c(e());
    }

    public int a(boolean r4) {
        int r0 = this.f12123d;
        if (r0 < 0) goto L11;
        char[] r2 = this.f12122c;
        if (r2 == null) goto L11;
        if (r4 == false) goto L10;
        return -com.fasterxml.jackson.a.d.i.a(r2, r0 + 1, this.f12124e - 1);
    L10:
        return com.fasterxml.jackson.a.d.i.a(r2, r0, this.f12124e);
    L11:
        if (r4 == false) goto L15;
        return -com.fasterxml.jackson.a.d.i.a(this.i, 1, this.j - 1);
    L15:
        return com.fasterxml.jackson.a.d.i.a(this.i, 0, this.j);
    }

    public long b(boolean r4) {
        int r0 = this.f12123d;
        if (r0 < 0) goto L11;
        char[] r2 = this.f12122c;
        if (r2 == null) goto L11;
        if (r4 == false) goto L10;
        return -com.fasterxml.jackson.a.d.i.b(r2, r0 + 1, this.f12124e - 1);
    L10:
        return com.fasterxml.jackson.a.d.i.b(r2, r0, this.f12124e);
    L11:
        if (r4 == false) goto L15;
        return -com.fasterxml.jackson.a.d.i.b(this.i, 1, this.j - 1);
    L15:
        return com.fasterxml.jackson.a.d.i.b(this.i, 0, this.j);
    }

    public void a(char r4) {
        if (this.f12123d < 0) goto L5;
        c(16);
    L5:
        this.k = null;
        this.l = null;
        char[] r0 = this.i;
        if (this.j < r0.length) goto L8;
        d(1);
        r0 = this.i;
    L8:
        int r1 = this.j;
        this.j = r1 + 1;
        r0[r1] = r4;
    }

    public void c(char[] r4, int r5, int r6) {
        if (this.f12123d < 0) goto L5;
        c(r6);
    L5:
        this.k = null;
        this.l = null;
        char[] r0 = this.i;
        int r1 = r0.length;
        int r2 = this.j;
        int r3 = r1 - r2;
        if (r3 < r6) goto L9;
        System.arraycopy(r4, r5, r0, r2, r6);
        this.j += r6;
        return;
    L9:
        if (r3 <= 0) goto L11;
        System.arraycopy(r4, r5, r0, r2, r3);
        r5 = r5 + r3;
        r6 = r6 - r3;
    L11:
        d(r6);
        int r7 = Math.min(this.i.length, r6);
        System.arraycopy(r4, r5, this.i, 0, r7);
        this.j += r7;
        r5 = r5 + r7;
        r6 = r6 - r7;
        if (r6 > 0) goto L11;
    }

    public void a(String r5, int r6, int r7) {
        if (this.f12123d < 0) goto L5;
        c(r7);
    L5:
        this.k = null;
        this.l = null;
        char[] r0 = this.i;
        int r1 = r0.length;
        int r2 = this.j;
        int r3 = r1 - r2;
        if (r3 < r7) goto L9;
        r5.getChars(r6, r6 + r7, r0, r2);
        this.j += r7;
        return;
    L9:
        if (r3 <= 0) goto L11;
        int r4 = r6 + r3;
        r5.getChars(r6, r4, r0, r2);
        r7 = r7 - r3;
        r6 = r4;
    L11:
        d(r7);
        int r8 = Math.min(this.i.length, r7);
        int r9 = r6 + r8;
        r5.getChars(r6, r9, this.i, 0);
        this.j += r8;
        r7 = r7 - r8;
        if (r7 <= 0) goto L13;
        r6 = r9;
        goto L11
    }

    public char[] i() {
        if (this.f12123d < 0) goto L5;
        c(1);
    L12:
        return this.i;
    L5:
        char[] r0 = this.i;
        if (r0 != null) goto L9;
        this.i = b(0);
        goto L12
    L9:
        if (this.j < r0.length) goto L12;
        d(1);
        goto L12
    }

    public char[] j() {
        this.f12123d = -1;
        this.j = 0;
        this.f12124e = 0;
        this.f12122c = null;
        this.k = null;
        this.l = null;
        if (this.g == false) goto L5;
        m();
    L5:
        char[] r1 = this.i;
        if (r1 != null) goto L9;
        char[] r2 = b(0);
        this.i = r2;
        return r2;
    L9:
        return r1;
    }

    public int k() {
        return this.j;
    }

    public void a(int r1) {
        this.j = r1;
    }

    public char[] l() {
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        this.g = true;
        this.f.add(this.i);
        int r0 = this.i.length;
        this.h += r0;
        this.j = 0;
        int r1 = r0 + (r0 >> 1);
        if (r1 >= 500) goto L8;
        r1 = 500;
    L10:
        char[] r2 = e(r1);
        this.i = r2;
        return r2;
    L8:
        if (r1 <= 65536) goto L10;
        r1 = 65536;
        goto L10
    }

    public String toString() {
        return e();
    }

    private void c(int r6) {
        int r0 = this.f12124e;
        this.f12124e = 0;
        char[] r2 = this.f12122c;
        this.f12122c = null;
        int r3 = this.f12123d;
        this.f12123d = -1;
        int r7 = r6 + r0;
        char[] r4 = this.i;
        if (r4 != null) goto L5;
    L6:
        this.i = b(r7);
    L7:
        if (r0 <= 0) goto L9;
        System.arraycopy(r2, r3, this.i, 0, r0);
    L9:
        this.h = 0;
        this.j = r0;
        return;
    L5:
        if (r7 <= r4.length) goto L7;
        goto L6
    }

    private void d(int r3) {
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        char[] r4 = this.i;
        this.g = true;
        this.f.add(r4);
        this.h += r4.length;
        this.j = 0;
        int r5 = r4.length;
        int r6 = r5 + (r5 >> 1);
        if (r6 >= 500) goto L8;
        r6 = 500;
    L10:
        this.i = e(r6);
        return;
    L8:
        if (r6 <= 65536) goto L10;
        r6 = 65536;
        goto L10
    }

    private char[] n() {
        String r0 = this.k;
        if (r0 != null) goto L5;
        int r1 = this.f12123d;
        if (r1 < 0) goto L17;
        int r2 = this.f12124e;
        if (r2 < 1) goto L11;
        if (r1 != 0) goto L16;
        return Arrays.copyOf(this.f12122c, r2);
    L16:
        return Arrays.copyOfRange(this.f12122c, r1, r2 + r1);
    L11:
        return f12120a;
    L17:
        int r3 = b();
        if (r3 < 1) goto L20;
        char[] r4 = e(r3);
        ArrayList<char[]> r5 = this.f;
        if (r5 == null) goto L26;
        int r6 = r5.size();
        int r7 = 0;
        int r8 = 0;
    L24:
        if (r7 >= r6) goto L27;
        char[] r9 = (char[]) ZeusTransformUtils.preCheckCast(this.f.get(r7), char[].class, "com.obric.aiagent.plugin");
        int r10 = r9.length;
        System.arraycopy(r9, 0, r4, r8, r10);
        r8 = r8 + r10;
        r7 = r7 + 1;
    L27:
        System.arraycopy(this.i, 0, r4, r8, this.j);
        return r4;
    L26:
        r8 = 0;
        goto L27
    L20:
        return f12120a;
    L5:
        return r0.toCharArray();
    }

    private char[] e(int r1) {
        return new char[r1];
    }
}
