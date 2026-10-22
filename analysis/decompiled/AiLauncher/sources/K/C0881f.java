package K;

import K.W;

/* renamed from: K.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0881f extends W.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3960a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3961b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3962c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3963d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3964e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3965f;

    public C0881f(int i10, String str, int i11, int i12, int i13, int i14) {
        this.f3960a = i10;
        if (str == null) {
            throw new NullPointerException("Null mediaType");
        }
        this.f3961b = str;
        this.f3962c = i11;
        this.f3963d = i12;
        this.f3964e = i13;
        this.f3965f = i14;
    }

    @Override // K.W.a
    public int b() {
        return this.f3962c;
    }

    @Override // K.W.a
    public int c() {
        return this.f3964e;
    }

    @Override // K.W.a
    public int d() {
        return this.f3960a;
    }

    @Override // K.W.a
    public String e() {
        return this.f3961b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W.a) {
            W.a aVar = (W.a) obj;
            if (this.f3960a == aVar.d() && this.f3961b.equals(aVar.e()) && this.f3962c == aVar.b() && this.f3963d == aVar.g() && this.f3964e == aVar.c() && this.f3965f == aVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // K.W.a
    public int f() {
        return this.f3965f;
    }

    @Override // K.W.a
    public int g() {
        return this.f3963d;
    }

    public int hashCode() {
        return this.f3965f ^ ((((((((((this.f3960a ^ 1000003) * 1000003) ^ this.f3961b.hashCode()) * 1000003) ^ this.f3962c) * 1000003) ^ this.f3963d) * 1000003) ^ this.f3964e) * 1000003);
    }

    public String toString() {
        return "AudioProfileProxy{codec=" + this.f3960a + ", mediaType=" + this.f3961b + ", bitrate=" + this.f3962c + ", sampleRate=" + this.f3963d + ", channels=" + this.f3964e + ", profile=" + this.f3965f + "}";
    }
}
