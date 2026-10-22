package e;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f38756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f38757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f38758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f38759e;
    public boolean f;
    public v g;
    public v h;

    /* JADX INFO: compiled from: Segment.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f38755a = new a(null);
    }

    public v() {
        this.f38756b = new byte[8192];
        this.f = true;
        this.f38759e = false;
    }

    public v(byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        d.h.b.o.e(r2, "data");
        this.f38756b = r2;
        this.f38757c = r3;
        this.f38758d = r4;
        this.f38759e = r5;
        this.f = r6;
    }

    public final v a() {
        this.f38759e = true;
        return new v(this.f38756b, this.f38757c, this.f38758d, true, false);
    }

    public final v b() {
        byte[] r0 = this.f38756b;
        byte[] r1 = Arrays.copyOf(r0, r0.length);
        d.h.b.o.c(r1, "copyOf(this, size)");
        return new v(r1, this.f38757c, this.f38758d, false, true);
    }

    public final v c() {
        v r0 = this.g;
        if (r0 != this) goto L6;
        r0 = null;
    L6:
        v r2 = this.h;
        d.h.b.o.a(r2);
        r2.g = this.g;
        v r3 = this.g;
        d.h.b.o.a(r3);
        r3.h = this.h;
        this.g = null;
        this.h = null;
        return r0;
    }

    public final v a(v r2) {
        d.h.b.o.e(r2, MonitorConstants.SEGMENT);
        r2.h = this;
        r2.g = this.g;
        v r0 = this.g;
        d.h.b.o.a(r0);
        r0.h = r2;
        this.g = r2;
        return r2;
    }

    public final v a(int r9) {
        if (r9 > 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L15;
        if (r9 < 1024) goto L11;
        v r1 = a();
    L12:
        r1.f38758d = r1.f38757c + r9;
        this.f38757c += r9;
        v r8 = this.h;
        d.h.b.o.a(r8);
        r8.a(r1);
        return r1;
    L11:
        r1 = w.a();
        byte[] r2 = this.f38756b;
        byte[] r3 = r1.f38756b;
        int r4 = this.f38757c;
        d.a.i.a(r2, r3, 0, r4, r4 + r9, 2, null);
        goto L12
    L15:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L4:
        if (r9 > (this.f38758d - this.f38757c)) goto L6;
        r0 = true;
        goto L7
    }

    public final void d() {
        v r0 = this.h;
        int r1 = 0;
        if (r0 == this) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L20;
        d.h.b.o.a(r0);
        if (r0.f == true) goto L10;
        return;
    L10:
        int r3 = this.f38758d - this.f38757c;
        v r4 = this.h;
        d.h.b.o.a(r4);
        int r5 = 8192 - r4.f38758d;
        v r6 = this.h;
        d.h.b.o.a(r6);
        if (r6.f38759e == true) goto L15;
        v r7 = this.h;
        d.h.b.o.a(r7);
        r1 = r7.f38757c;
    L15:
        if (r3 <= (r5 + r1)) goto L17;
        return;
    L17:
        v r8 = this.h;
        d.h.b.o.a(r8);
        a(r8, r3);
        c();
        w.a(this);
        return;
    L20:
        throw new IllegalStateException("cannot compact".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void a(v r9, int r10) {
        d.h.b.o.e(r9, "sink");
        if (r9.f == false) goto L18;
        int r5 = r9.f38758d;
        if ((r5 + r10) > 8192) goto L7;
    L15:
        byte[] r0 = this.f38756b;
        byte[] r1 = r9.f38756b;
        int r2 = r9.f38758d;
        int r3 = this.f38757c;
        d.a.i.a(r0, r1, r2, r3, r3 + r10);
        r9.f38758d += r10;
        this.f38757c += r10;
        return;
    L7:
        if (r9.f38759e == true) goto L14;
        int r4 = r9.f38757c;
        if (((r5 + r10) - r4) > 8192) goto L12;
        byte[] r6 = r9.f38756b;
        d.a.i.a(r6, r6, 0, r4, r5, 2, null);
        r9.f38758d -= r9.f38757c;
        r9.f38757c = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }
}
