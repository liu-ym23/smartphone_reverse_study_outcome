package e2;

import java.util.Arrays;

/* renamed from: e2.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3980g {

    /* renamed from: a, reason: collision with root package name */
    public final b2.b f32269a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f32270b;

    public C3980g(b2.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f32269a = bVar;
        this.f32270b = bArr;
    }

    public byte[] a() {
        return this.f32270b;
    }

    public b2.b b() {
        return this.f32269a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3980g)) {
            return false;
        }
        C3980g c3980g = (C3980g) obj;
        if (this.f32269a.equals(c3980g.f32269a)) {
            return Arrays.equals(this.f32270b, c3980g.f32270b);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f32270b) ^ ((this.f32269a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f32269a + ", bytes=[...]}";
    }
}
