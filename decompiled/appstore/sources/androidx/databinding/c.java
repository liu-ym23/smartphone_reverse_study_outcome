package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f2906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f2908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f2910e;

    public static abstract class a {
        public a() {
        }

        public abstract void a(Object r10, Object r11, int r12, Object r13);
    }

    public c(a r10) {
        this.f2906a = new ArrayList();
        this.f2907b = 0;
        this.f2910e = r10;
    }

    public synchronized void a(Object r10) {
        monitor-enter(this);
        if (r10 == null) goto L15;
        int r11 = this.f2906a.lastIndexOf(r10);     // Catch: Throwable -> L9
        if (r11 >= 0) goto L7;
    L11:
        this.f2906a.add(r10);     // Catch: Throwable -> L9
    L12:
        monitor-exit(this);
        return;
    L7:
        if (c(r11) == false) goto L12;
    L15:
        throw new IllegalArgumentException("callback cannot be null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized c b() {
        monitor-enter(this);
        c r10 = (c) super.clone();     // Catch: Throwable -> L12 CloneNotSupportedException -> L17
        r10.f2907b = 0;     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
        r10.f2908c = null;     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
        int r11 = 0;
        r10.f2909d = 0;     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
        r10.f2906a = new ArrayList();     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
        int r12 = this.f2906a.size();     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
    L7:
        if (r11 >= r12) goto L20;
        if (c(r11) == true) goto L16;
        r10.f2906a.add(this.f2906a.get(r11));     // Catch: Throwable -> L12 CloneNotSupportedException -> L14
    L16:
        r11 = r11 + 1;
    L20:
        monitor-exit(this);
        return r10;
    L14:
        CloneNotSupportedException e10 = e;
    L19:
        e10.printStackTrace();     // Catch: Throwable -> L12
    L17:
        e = move-exception;
        r10 = null;
        e10 = e;
    L12:
        th = move-exception;
        throw th;
    }

    public final boolean c(int r10) {
        if (r10 >= 64) goto L9;
        long r11 = this.f2907b;
        if ((r11 & (1 << r10)) == 0) goto L8;
        return true;
    L8:
        return false;
    L9:
        long[] r12 = this.f2908c;
        if (r12 != null) goto L12;
        return false;
    L12:
        int r13 = (r10 / 64) - 1;
        if (r13 < r12.length) goto L15;
        return false;
    L15:
        long r14 = r12[r13];
        if (((1 << (r10 % 64)) & r14) == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public synchronized void d(Object r10, int r11, Object r12) {
        monitor-enter(this);
        this.f2909d++;     // Catch: Throwable -> L12
        g(r10, r11, r12);     // Catch: Throwable -> L12
        int r13 = this.f2909d - 1;     // Catch: Throwable -> L12
        this.f2909d = r13;     // Catch: Throwable -> L12
        if (r13 != 0) goto L18;
        long[] r14 = this.f2908c;     // Catch: Throwable -> L12
        if (r14 == null) goto L15;
        int r15 = r14.length - 1;     // Catch: Throwable -> L12
    L8:
        if (r15 < 0) goto L15;
        long r16 = this.f2908c[r15];     // Catch: Throwable -> L12
        if (r16 == 0) goto L14;
        j((r15 + 1) * 64, r16);     // Catch: Throwable -> L12
        this.f2908c[r15] = 0;     // Catch: Throwable -> L12
    L14:
        r15 = r15 - 1;     // Catch: Throwable -> L12
    L15:
        long r17 = this.f2907b;     // Catch: Throwable -> L12
        if (r17 == 0) goto L18;
        j(0, r17);     // Catch: Throwable -> L12
        this.f2907b = 0;     // Catch: Throwable -> L12
    L18:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void e(Object r10, int r11, Object r12, int r13, int r14, long r15) {
        long r16 = 1;
    L3:
        if (r13 >= r14) goto L8;
        if ((r15 & r16) != 0) goto L7;
        this.f2910e.a(this.f2906a.get(r13), r10, r11, r12);
    L7:
        r16 = r16 << 1;
        r13 = r13 + 1;
        goto L3
    }

    public final void f(Object r11, int r12, Object r13) {
        e(r11, r12, r13, 0, Math.min(64, this.f2906a.size()), this.f2907b);
    }

    public final void g(Object r10, int r11, Object r12) {
        int r13 = this.f2906a.size();
        long[] r14 = this.f2908c;
        if (r14 != null) goto L5;
        int r15 = -1;
    L6:
        h(r10, r11, r12, r15);
        e(r10, r11, r12, (r15 + 2) * 64, r13, 0);
        return;
    L5:
        r15 = r14.length - 1;
        goto L6
    }

    public final void h(Object r10, int r11, Object r12, int r13) {
        if (r13 >= 0) goto L4;
        f(r10, r11, r12);
        return;
    L4:
        long r14 = this.f2908c[r13];
        int r15 = (r13 + 1) * 64;
        int r16 = Math.min(this.f2906a.size(), r15 + 64);
        h(r10, r11, r12, r13 - 1);
        e(r10, r11, r12, r15, r16, r14);
    }

    public synchronized void i(Object r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f2909d != 0) goto L8;
        this.f2906a.remove(r10);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L8:
        int r11 = this.f2906a.lastIndexOf(r10);     // Catch: Throwable -> L6
        if (r11 < 0) goto L11;
        k(r11);     // Catch: Throwable -> L6
        goto L11
    }

    public final void j(int r10, long r11) {
        int r12 = r10 + 63;
        long r13 = Long.MIN_VALUE;
    L3:
        if (r12 < r10) goto L8;
        if ((r11 & r13) == 0) goto L7;
        this.f2906a.remove(r12);
    L7:
        r13 = r13 >>> 1;
        r12 = r12 - 1;
        goto L3
    }

    public final void k(int r10) {
        if (r10 >= 64) goto L5;
        this.f2907b = (1 << r10) | this.f2907b;
        return;
    L5:
        int r11 = (r10 / 64) - 1;
        long[] r12 = this.f2908c;
        if (r12 != null) goto L9;
        this.f2908c = new long[this.f2906a.size() / 64];
    L11:
        long[] r13 = this.f2908c;
        r13[r11] = (1 << (r10 % 64)) | r13[r11];
        return;
    L9:
        if (r12.length > r11) goto L11;
        long[] r14 = new long[this.f2906a.size() / 64];
        long[] r15 = this.f2908c;
        System.arraycopy(r15, 0, r14, 0, r15.length);
        this.f2908c = r14;
        goto L11
    }
}
