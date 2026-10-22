package x2;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f11125a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final p f11126b;

    /* renamed from: c, reason: collision with root package name */
    public p f11127c;

    /* renamed from: d, reason: collision with root package name */
    public p f11128d;

    /* renamed from: e, reason: collision with root package name */
    public int f11129e;

    /* renamed from: f, reason: collision with root package name */
    public int f11130f;

    public m(p pVar) {
        this.f11126b = pVar;
        this.f11127c = pVar;
    }

    public final void a() {
        this.f11125a = 1;
        this.f11127c = this.f11126b;
        this.f11130f = 0;
    }

    public final boolean b() {
        y2.a aVarB = this.f11127c.f11144b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.f3097i).get(iA + aVarB.f3094f) == 0) || this.f11129e == 65039;
    }
}
