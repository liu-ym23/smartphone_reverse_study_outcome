package vc;

import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f13501a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f13502b;

    /* renamed from: c, reason: collision with root package name */
    public int f13503c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f13504a = new a();
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = this.f13503c + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = this.f13501a[i11];
            if (obj instanceof rc.e) {
                rc.e eVar = (rc.e) obj;
                if (!kotlin.jvm.internal.g.b(eVar.d(), j.b.f11802a)) {
                    int i12 = this.f13502b[i11];
                    if (i12 >= 0) {
                        sb2.append(".");
                        sb2.append(eVar.f(i12));
                    }
                } else if (this.f13502b[i11] != -1) {
                    sb2.append("[");
                    sb2.append(this.f13502b[i11]);
                    sb2.append("]");
                }
            } else if (obj != a.f13504a) {
                sb2.append("['");
                sb2.append(obj);
                sb2.append("']");
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public final String toString() {
        return a();
    }
}
