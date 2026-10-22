package m7;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8246a;

    public /* synthetic */ b(int i) {
        this.f8246a = i;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException {
        switch (this.f8246a) {
            case 0:
                if (aVar.Y() != u7.b.f14169m) {
                    return Double.valueOf(aVar.P());
                }
                aVar.U();
                return null;
            case 1:
                if (aVar.Y() != u7.b.f14169m) {
                    return Float.valueOf((float) aVar.P());
                }
                aVar.U();
                return null;
            default:
                aVar.e0();
                return null;
        }
    }

    public String toString() {
        switch (this.f8246a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        switch (this.f8246a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    e.a(dDoubleValue);
                    cVar.O(dDoubleValue);
                    break;
                } else {
                    cVar.C();
                    break;
                }
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    e.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    cVar.R(numberValueOf);
                    break;
                } else {
                    cVar.C();
                    break;
                }
            default:
                cVar.C();
                break;
        }
    }
}
