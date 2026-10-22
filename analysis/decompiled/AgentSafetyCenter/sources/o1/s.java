package o1;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final long f9071a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9072b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9073c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9074d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9075e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9076f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9077g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9078h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9079j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9080k;

    /* renamed from: l, reason: collision with root package name */
    public final long f9081l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9082m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9083n;

    /* renamed from: o, reason: collision with root package name */
    public s f9084o;

    public s(long j10, long j11, long j12, boolean z10, float f5, long j13, long j14, boolean z11, boolean z12, int i, long j15) {
        this.f9071a = j10;
        this.f9072b = j11;
        this.f9073c = j12;
        this.f9074d = z10;
        this.f9075e = f5;
        this.f9076f = j13;
        this.f9077g = j14;
        this.f9078h = z11;
        this.i = i;
        this.f9079j = j15;
        this.f9081l = 0L;
        this.f9082m = z12;
        this.f9083n = z12;
    }

    public final void a() {
        s sVar = this.f9084o;
        if (sVar == null) {
            this.f9082m = true;
            this.f9083n = true;
        } else if (sVar != null) {
            sVar.a();
        }
    }

    public final boolean b() {
        s sVar = this.f9084o;
        return sVar != null ? sVar.b() : this.f9082m || this.f9083n;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PointerInputChange(id=");
        sb2.append((Object) r.b(this.f9071a));
        sb2.append(", uptimeMillis=");
        sb2.append(this.f9072b);
        sb2.append(", position=");
        sb2.append((Object) c1.b.j(this.f9073c));
        sb2.append(", pressed=");
        sb2.append(this.f9074d);
        sb2.append(", pressure=");
        sb2.append(this.f9075e);
        sb2.append(", previousUptimeMillis=");
        sb2.append(this.f9076f);
        sb2.append(", previousPosition=");
        sb2.append((Object) c1.b.j(this.f9077g));
        sb2.append(", previousPressed=");
        sb2.append(this.f9078h);
        sb2.append(", isConsumed=");
        sb2.append(b());
        sb2.append(", type=");
        int i = this.i;
        sb2.append((Object) (i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch"));
        sb2.append(", historical=");
        Object obj = this.f9080k;
        if (obj == null) {
            obj = kb.s.f7404c;
        }
        sb2.append(obj);
        sb2.append(",scrollDelta=");
        sb2.append((Object) c1.b.j(this.f9079j));
        sb2.append(')');
        return sb2.toString();
    }

    public s(long j10, long j11, long j12, boolean z10, float f5, long j13, long j14, boolean z11, int i, ArrayList arrayList, long j15, long j16) {
        this(j10, j11, j12, z10, f5, j13, j14, z11, false, i, j15);
        this.f9080k = arrayList;
        this.f9081l = j16;
    }
}
