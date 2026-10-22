package w0;

/* renamed from: w0.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2089j {

    /* renamed from: a, reason: collision with root package name */
    public String f6814a;
    public C2089j b;
    public long c;
    public int d;
    public int e;
    public boolean f;
    public long g;
    public boolean h;
    public final /* synthetic */ C2091l i;

    public C2089j(C2091l c2091l) {
        this.i = c2091l;
    }

    public final void a(long j5) {
        int i;
        long j6 = this.c + j5;
        this.c = j6;
        int i6 = this.e + 1;
        this.e = i6;
        C2089j c2089j = this.b;
        if (c2089j == null || i6 != (i = this.d)) {
            return;
        }
        if (this.h) {
            c2089j.h = true;
        }
        C2091l c2091l = this.i;
        if (j6 >= c2091l.k && !this.h) {
            String str = this.f6814a;
            if (j6 <= 68719476736L) {
                if (c2091l.u == null) {
                    c2091l.u = new B1.b(c2091l.l);
                }
                c2091l.u.g(new C2088i(str, j6, i));
            }
            this.b.h = true;
        }
        this.b.a(this.c);
        if (this.f) {
            c2091l.m(this.d, this.f6814a, this.c, this.g);
        }
    }
}
