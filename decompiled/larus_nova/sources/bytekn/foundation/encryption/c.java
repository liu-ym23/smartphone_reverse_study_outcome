package bytekn.foundation.encryption;

import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f21775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21779e;

    public abstract void a(byte[] r100);

    public abstract byte[] b(long r100);

    public abstract void c();

    public abstract void d(byte[] r100);

    public final byte[] e() {
        byte[] r100 = new byte[this.f21779e];
        byte[] r101 = b(this.f21777c);
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L6;
        int r103 = this.f21778d;
        int r104 = this.f21776b;
        int r105 = (r103 - r104) + r102;
        ArraysKt.copyInto(r101, this.f21775a, r104, r102, r105);
        d(this.f21775a);
        this.f21776b = 0;
        r102 = r105;
        goto L4
    L6:
        a(r100);
        c();
        int r106 = b.f21774a;
        return r100;
    }

    public c() {
        this.f21778d = 64;
        this.f21779e = 16;
        this.f21775a = new byte[64];
    }

    public final c update(byte[] r100) {
        return update(r100, 0, r100.length);
    }

    public final c update(byte[] r100, int r101, int r102) {
        int r103 = r102;
    L3:
        if (r103 <= 0) goto L8;
        int r104 = Math.min(this.f21778d - this.f21776b, r103);
        int r105 = r104 + r101;
        ArraysKt.copyInto(r100, this.f21775a, this.f21776b, r101, r105);
        r103 = r103 - r104;
        int r106 = this.f21776b + r104;
        this.f21776b = r106;
        int r107 = this.f21778d;
        if (r106 < r107) goto L7;
        this.f21776b = r106 - r107;
        d(this.f21775a);
    L7:
        r101 = r105;
        goto L3
    L8:
        this.f21777c += (long) r102;
        return this;
    }
}
