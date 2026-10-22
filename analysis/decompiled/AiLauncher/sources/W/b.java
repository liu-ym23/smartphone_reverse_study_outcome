package W;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f6572a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6573b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6574c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6575d;

    /* renamed from: e, reason: collision with root package name */
    public final Size f6576e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6577f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6578g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6579h;

    public b(UUID uuid, int i10, int i11, Rect rect, Size size, int i12, boolean z10, boolean z11) {
        if (uuid == null) {
            throw new NullPointerException("Null getUuid");
        }
        this.f6572a = uuid;
        this.f6573b = i10;
        this.f6574c = i11;
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.f6575d = rect;
        if (size == null) {
            throw new NullPointerException("Null getSize");
        }
        this.f6576e = size;
        this.f6577f = i12;
        this.f6578g = z10;
        this.f6579h = z11;
    }

    @Override // W.e
    public Rect a() {
        return this.f6575d;
    }

    @Override // W.e
    public int b() {
        return this.f6574c;
    }

    @Override // W.e
    public int c() {
        return this.f6577f;
    }

    @Override // W.e
    public Size d() {
        return this.f6576e;
    }

    @Override // W.e
    public int e() {
        return this.f6573b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f6572a.equals(eVar.f()) && this.f6573b == eVar.e() && this.f6574c == eVar.b() && this.f6575d.equals(eVar.a()) && this.f6576e.equals(eVar.d()) && this.f6577f == eVar.c() && this.f6578g == eVar.g() && this.f6579h == eVar.k()) {
                return true;
            }
        }
        return false;
    }

    @Override // W.e
    public UUID f() {
        return this.f6572a;
    }

    @Override // W.e
    public boolean g() {
        return this.f6578g;
    }

    public int hashCode() {
        return ((((((((((((((this.f6572a.hashCode() ^ 1000003) * 1000003) ^ this.f6573b) * 1000003) ^ this.f6574c) * 1000003) ^ this.f6575d.hashCode()) * 1000003) ^ this.f6576e.hashCode()) * 1000003) ^ this.f6577f) * 1000003) ^ (this.f6578g ? 1231 : 1237)) * 1000003) ^ (this.f6579h ? 1231 : 1237);
    }

    @Override // W.e
    public boolean k() {
        return this.f6579h;
    }

    public String toString() {
        return "OutConfig{getUuid=" + this.f6572a + ", getTargets=" + this.f6573b + ", getFormat=" + this.f6574c + ", getCropRect=" + this.f6575d + ", getSize=" + this.f6576e + ", getRotationDegrees=" + this.f6577f + ", isMirroring=" + this.f6578g + ", shouldRespectInputCropRect=" + this.f6579h + "}";
    }
}
