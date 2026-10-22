package com.obric.oui.orecyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f15681e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f15682f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f15683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f15686d;

    public class a implements Comparator {
        public a() {
        }

        public int a(C0200c r10, C0200c r11) {
            RecyclerView r12 = r10.f15694d;
            if (r12 != null) goto L5;
            boolean r13 = true;
        L7:
            if (r11.f15694d != null) goto L9;
            boolean r14 = true;
        L11:
            if (r13 == r14) goto L16;
            if (r12 != null) goto L15;
            return 1;
        L15:
            return -1;
        L16:
            boolean r15 = r10.f15691a;
            if (r15 == r11.f15691a) goto L21;
            if (r15 == true) goto L20;
            return 1;
        L20:
            return -1;
        L21:
            int r16 = r11.f15692b - r10.f15692b;
            if (r16 == 0) goto L24;
            return r16;
        L24:
            int r17 = r10.f15693c - r11.f15693c;
            if (r17 == 0) goto L27;
            return r17;
        L27:
            return 0;
        L9:
            r14 = false;
            goto L11
        L5:
            r13 = false;
            goto L7
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((C0200c) r10, (C0200c) r11);
        }
    }

    public static class b implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f15689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15690d;

        public b() {
        }

        public void a() {
            int[] r10 = this.f15689c;
            if (r10 == null) goto L5;
            Arrays.fill(r10, -1);
        L5:
            this.f15690d = 0;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r10, int r11) {
            if (r10 < 0) goto L15;
            if (r11 < 0) goto L13;
            int r12 = this.f15690d;
            int r13 = r12 * 2;
            int[] r14 = this.f15689c;
            if (r14 != null) goto L8;
            int[] r15 = new int[4];
            this.f15689c = r15;
            Arrays.fill(r15, -1);
        L10:
            int[] r16 = this.f15689c;
            r16[r13] = r10;
            r16[r13 + 1] = r11;
            this.f15690d++;
            return;
        L8:
            if (r13 < r14.length) goto L10;
            int[] r17 = new int[r12 * 4];
            this.f15689c = r17;
            System.arraycopy(r14, 0, r17, 0, r14.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void b(RecyclerView r10, boolean r11) {
            this.f15690d = 0;
            int[] r12 = this.f15689c;
            if (r12 == null) goto L5;
            Arrays.fill(r12, -1);
        L5:
            RecyclerView.LayoutManager r13 = r10.f15456n;
            if (r10.f15454m == null) goto L21;
            if (r13 != null) goto L9;
            return;
        L9:
            if (r13.p0() == false) goto L23;
            if (r11 == false) goto L15;
            if (r10.f15438e.n() == true) goto L17;
            r13.n(r10.f15454m.e(), this);
        L17:
            int r14 = this.f15690d;
            if (r14 <= r13.f15506l) goto L24;
            r13.f15506l = r14;
            r13.f15507m = r11;
            r10.f15434c.O();
            return;
        L24:
            return;
        L15:
            if (r10.j0() == true) goto L17;
            r13.m(this.f15687a, this.f15688b, r10.f15445h0, this);
            goto L17
        L23:
            return;
        }

        public boolean c(int r10) {
            if (this.f15689c == null) goto L11;
            int r11 = this.f15690d * 2;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L11;
            if (this.f15689c[r12] == r10) goto L8;
            r12 = r12 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        public void d(int r10, int r11) {
            this.f15687a = r10;
            this.f15688b = r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.c$c, reason: collision with other inner class name */
    public static class C0200c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f15694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15695e;

        public C0200c() {
        }

        public void a() {
            this.f15691a = false;
            this.f15692b = 0;
            this.f15693c = 0;
            this.f15694d = null;
            this.f15695e = 0;
        }
    }

    static {
        f15681e = new ThreadLocal();
        f15682f = new a();
    }

    public c() {
        this.f15683a = new ArrayList();
        this.f15686d = new ArrayList();
    }

    public static boolean e(RecyclerView r10, int r11) {
        int r12 = r10.f15440f.j();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        RecyclerView.t r14 = RecyclerView.d0(r10.f15440f.i(r13));
        if (r14.f15568c != r11) goto L10;
        if (r14.v() == true) goto L10;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    public void a(RecyclerView r10) {
        if (RecyclerView.E0 == true) goto L5;
    L9:
        this.f15683a.add(r10);
        return;
    L5:
        if (this.f15683a.contains(r10) == false) goto L9;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    public final void b() {
        int r10 = this.f15683a.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RecyclerView r13 = (RecyclerView) this.f15683a.get(r11);
        if (r13.getWindowVisibility() != 0) goto L7;
        r13.f15443g0.b(r13, false);
        r12 = r12 + r13.f15443g0.f15690d;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.f15686d.ensureCapacity(r12);
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r14 >= r10) goto L26;
        RecyclerView r16 = (RecyclerView) this.f15683a.get(r14);
        if (r16.getWindowVisibility() != 0) goto L25;
        b r17 = r16.f15443g0;
        int r18 = Math.abs(r17.f15687a) + Math.abs(r17.f15688b);
        int r19 = 0;
    L15:
        if (r19 >= (r17.f15690d * 2)) goto L25;
        if (r15 < this.f15686d.size()) goto L19;
        C0200c r20 = new C0200c();
        this.f15686d.add(r20);
    L20:
        int[] r21 = r17.f15689c;
        int r110 = r21[r19 + 1];
        if (r110 > r18) goto L23;
        boolean r111 = true;
    L24:
        r20.f15691a = r111;
        r20.f15692b = r18;
        r20.f15693c = r110;
        r20.f15694d = r16;
        r20.f15695e = r21[r19];
        r15 = r15 + 1;
        r19 = r19 + 2;
        goto L15
    L23:
        r111 = false;
        goto L24
    L19:
        r20 = (C0200c) this.f15686d.get(r15);
    L25:
        r14 = r14 + 1;
        goto L9
    L26:
        Collections.sort(this.f15686d, f15682f);
    }

    public final void c(C0200c r10, long r11) {
        if (r10.f15691a == false) goto L5;
        long r12 = Long.MAX_VALUE;
    L6:
        RecyclerView.t r13 = i(r10.f15694d, r10.f15695e, r12);
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.f15567b != null) goto L11;
        return;
    L11:
        if (r13.u() == true) goto L13;
        return;
    L13:
        if (r13.v() == true) goto L19;
        h((RecyclerView) r13.f15567b.get(), r11);
        return;
    L19:
        return;
    L5:
        r12 = r11;
        goto L6
    }

    public final void d(long r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f15686d.size()) goto L9;
        C0200c r12 = (C0200c) this.f15686d.get(r11);
        if (r12.f15694d == null) goto L12;
        c(r12, r10);
        r12.a();
        r11 = r11 + 1;
        goto L4
    L12:
        return;
    }

    public void f(RecyclerView r10, int r11, int r12) {
        if (r10.isAttachedToWindow() == true) goto L5;
    L14:
        r10.f15443g0.d(r11, r12);
        return;
    L5:
        if (RecyclerView.E0 == false) goto L12;
        if (this.f15683a.contains(r10) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.f15684b != 0) goto L14;
        this.f15684b = r10.getNanoTime();
        r10.post(this);
        goto L14
    }

    public void g(long r10) {
        b();
        d(r10);
    }

    public final void h(RecyclerView r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.F == true) goto L7;
    L9:
        b r12 = r10.f15443g0;
        r12.b(r10, true);
        if (r12.f15690d != 0) goto L22;
        return;
    L22:
        androidx.core.os.g.a("RV Nested Prefetch");     // Catch: Throwable -> L16
        r10.f15445h0.e(r10.f15454m);     // Catch: Throwable -> L16
        int r13 = 0;
    L13:
        if (r13 >= (r12.f15690d * 2)) goto L18;
        i(r10, r12.f15689c[r13], r11);     // Catch: Throwable -> L16
        r13 = r13 + 2;
        goto L13
    L18:
        androidx.core.os.g.b();
        return;
    L16:
        th = move-exception;
        androidx.core.os.g.b();
        throw th;
    L7:
        if (r10.f15440f.j() == 0) goto L9;
        r10.S0();
        goto L9
    }

    public final RecyclerView.t i(RecyclerView r10, int r11, long r12) {
        if (e(r10, r11) == false) goto L6;
        return null;
    L6:
        RecyclerView.o r13 = r10.f15434c;
        r10.D0();     // Catch: Throwable -> L14
        RecyclerView.t r14 = r13.M(r11, false, r12);     // Catch: Throwable -> L14
        if (r14 != null) goto L10;
    L17:
        r10.F0(false);
        return r14;
    L10:
        if (r14.u() == true) goto L12;
    L16:
        r13.a(r14, false);     // Catch: Throwable -> L14
        goto L17
    L12:
        if (r14.v() == true) goto L16;
        r13.F(r14.f15566a);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r10.F0(false);
        throw th;
    }

    public void j(RecyclerView r10) {
        boolean r11 = this.f15683a.remove(r10);
        if (RecyclerView.E0 == false) goto L8;
        if (r11 == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("RecyclerView removal failed!");
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.core.os.g.a("RV Prefetch");     // Catch: Throwable -> L12
        if (this.f15683a.isEmpty() == false) goto L7;
    L5:
        this.f15684b = 0;
        androidx.core.os.g.b();
        return;
    L7:
        int r10 = this.f15683a.size();     // Catch: Throwable -> L12
        int r11 = 0;
        long r12 = 0;
    L8:
        if (r11 >= r10) goto L16;
        RecyclerView r13 = (RecyclerView) this.f15683a.get(r11);     // Catch: Throwable -> L12
        if (r13.getWindowVisibility() != 0) goto L14;
        r12 = Math.max(r13.getDrawingTime(), r12);     // Catch: Throwable -> L12
    L14:
        r11 = r11 + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        if (r12 == 0) goto L5;
        g(TimeUnit.MILLISECONDS.toNanos(r12) + this.f15685c);     // Catch: Throwable -> L12
        this.f15684b = 0;
        androidx.core.os.g.b();
        return;
    L12:
        th = move-exception;
        this.f15684b = 0;
        androidx.core.os.g.b();
        throw th;
    }
}
