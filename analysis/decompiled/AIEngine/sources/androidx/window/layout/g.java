package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.layout.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final g2.b f2736a;

    /* renamed from: b, reason: collision with root package name */
    public final a f2737b;

    /* renamed from: c, reason: collision with root package name */
    public final f.b f2738c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f2739b = new a("FOLD");

        /* renamed from: c, reason: collision with root package name */
        public static final a f2740c = new a("HINGE");

        /* renamed from: a, reason: collision with root package name */
        public final String f2741a;

        public a(String str) {
            this.f2741a = str;
        }

        public final String toString() {
            return this.f2741a;
        }
    }

    public g(g2.b bVar, a aVar, f.b bVar2) {
        int i10 = bVar.f8952b;
        this.f2736a = bVar;
        this.f2737b = aVar;
        this.f2738c = bVar2;
        int i11 = bVar.f8953c;
        int i12 = bVar.f8951a;
        if (i11 - i12 == 0 && bVar.f8954d - i10 == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i12 != 0 && i10 != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    @Override // androidx.window.layout.f
    public final boolean a() {
        a aVar = a.f2740c;
        a aVar2 = this.f2737b;
        if (kotlin.jvm.internal.g.b(aVar2, aVar)) {
            return true;
        }
        return kotlin.jvm.internal.g.b(aVar2, a.f2739b) && kotlin.jvm.internal.g.b(this.f2738c, f.b.f2734c);
    }

    @Override // androidx.window.layout.f
    public final f.a b() {
        g2.b bVar = this.f2736a;
        return bVar.f8953c - bVar.f8951a > bVar.f8954d - bVar.f8952b ? f.a.f2731c : f.a.f2730b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g.class.equals(obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.g.b(this.f2736a, gVar.f2736a) && kotlin.jvm.internal.g.b(this.f2737b, gVar.f2737b) && kotlin.jvm.internal.g.b(this.f2738c, gVar.f2738c);
    }

    @Override // androidx.window.layout.a
    public final Rect getBounds() {
        g2.b bVar = this.f2736a;
        return new Rect(bVar.f8951a, bVar.f8952b, bVar.f8953c, bVar.f8954d);
    }

    public final int hashCode() {
        return this.f2738c.hashCode() + ((this.f2737b.hashCode() + (this.f2736a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return ((Object) g.class.getSimpleName()) + " { " + this.f2736a + ", type=" + this.f2737b + ", state=" + this.f2738c + " }";
    }
}
