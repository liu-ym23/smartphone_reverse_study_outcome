package K;

import K.W;
import java.util.List;

/* renamed from: K.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0883g extends W.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3967a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3968b;

    /* renamed from: c, reason: collision with root package name */
    public final List<W.a> f3969c;

    /* renamed from: d, reason: collision with root package name */
    public final List<W.c> f3970d;

    public C0883g(int i10, int i11, List<W.a> list, List<W.c> list2) {
        this.f3967a = i10;
        this.f3968b = i11;
        if (list == null) {
            throw new NullPointerException("Null audioProfiles");
        }
        this.f3969c = list;
        if (list2 == null) {
            throw new NullPointerException("Null videoProfiles");
        }
        this.f3970d = list2;
    }

    @Override // K.W
    public int a() {
        return this.f3967a;
    }

    @Override // K.W
    public List<W.c> b() {
        return this.f3970d;
    }

    @Override // K.W
    public int e() {
        return this.f3968b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W.b) {
            W.b bVar = (W.b) obj;
            if (this.f3967a == bVar.a() && this.f3968b == bVar.e() && this.f3969c.equals(bVar.f()) && this.f3970d.equals(bVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // K.W
    public List<W.a> f() {
        return this.f3969c;
    }

    public int hashCode() {
        return this.f3970d.hashCode() ^ ((((((this.f3967a ^ 1000003) * 1000003) ^ this.f3968b) * 1000003) ^ this.f3969c.hashCode()) * 1000003);
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.f3967a + ", recommendedFileFormat=" + this.f3968b + ", audioProfiles=" + this.f3969c + ", videoProfiles=" + this.f3970d + "}";
    }
}
