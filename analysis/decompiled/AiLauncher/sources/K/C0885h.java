package K;

import K.W;

/* renamed from: K.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0885h extends W.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3972a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3973b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3974c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3975d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3976e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3977f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3978g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3979h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3980i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3981j;

    public C0885h(int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f3972a = i10;
        if (str == null) {
            throw new NullPointerException("Null mediaType");
        }
        this.f3973b = str;
        this.f3974c = i11;
        this.f3975d = i12;
        this.f3976e = i13;
        this.f3977f = i14;
        this.f3978g = i15;
        this.f3979h = i16;
        this.f3980i = i17;
        this.f3981j = i18;
    }

    @Override // K.W.c
    public int b() {
        return this.f3979h;
    }

    @Override // K.W.c
    public int c() {
        return this.f3974c;
    }

    @Override // K.W.c
    public int d() {
        return this.f3980i;
    }

    @Override // K.W.c
    public int e() {
        return this.f3972a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W.c) {
            W.c cVar = (W.c) obj;
            if (this.f3972a == cVar.e() && this.f3973b.equals(cVar.i()) && this.f3974c == cVar.c() && this.f3975d == cVar.f() && this.f3976e == cVar.l() && this.f3977f == cVar.h() && this.f3978g == cVar.j() && this.f3979h == cVar.b() && this.f3980i == cVar.d() && this.f3981j == cVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // K.W.c
    public int f() {
        return this.f3975d;
    }

    @Override // K.W.c
    public int g() {
        return this.f3981j;
    }

    @Override // K.W.c
    public int h() {
        return this.f3977f;
    }

    public int hashCode() {
        return this.f3981j ^ ((((((((((((((((((this.f3972a ^ 1000003) * 1000003) ^ this.f3973b.hashCode()) * 1000003) ^ this.f3974c) * 1000003) ^ this.f3975d) * 1000003) ^ this.f3976e) * 1000003) ^ this.f3977f) * 1000003) ^ this.f3978g) * 1000003) ^ this.f3979h) * 1000003) ^ this.f3980i) * 1000003);
    }

    @Override // K.W.c
    public String i() {
        return this.f3973b;
    }

    @Override // K.W.c
    public int j() {
        return this.f3978g;
    }

    @Override // K.W.c
    public int l() {
        return this.f3976e;
    }

    public String toString() {
        return "VideoProfileProxy{codec=" + this.f3972a + ", mediaType=" + this.f3973b + ", bitrate=" + this.f3974c + ", frameRate=" + this.f3975d + ", width=" + this.f3976e + ", height=" + this.f3977f + ", profile=" + this.f3978g + ", bitDepth=" + this.f3979h + ", chromaSubsampling=" + this.f3980i + ", hdrFormat=" + this.f3981j + "}";
    }
}
