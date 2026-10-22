package g2;

import android.graphics.Rect;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f8951a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8952b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8953c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8954d;

    public b(Rect rect) {
        int i10 = rect.left;
        int i11 = rect.top;
        int i12 = rect.right;
        int i13 = rect.bottom;
        this.f8951a = i10;
        this.f8952b = i11;
        this.f8953c = i12;
        this.f8954d = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!b.class.equals(obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        b bVar = (b) obj;
        return this.f8951a == bVar.f8951a && this.f8952b == bVar.f8952b && this.f8953c == bVar.f8953c && this.f8954d == bVar.f8954d;
    }

    public final int hashCode() {
        return (((((this.f8951a * 31) + this.f8952b) * 31) + this.f8953c) * 31) + this.f8954d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) b.class.getSimpleName());
        sb2.append(" { [");
        sb2.append(this.f8951a);
        sb2.append(',');
        sb2.append(this.f8952b);
        sb2.append(',');
        sb2.append(this.f8953c);
        sb2.append(',');
        return ai.onnxruntime.a.j("] }", this.f8954d, sb2);
    }
}
