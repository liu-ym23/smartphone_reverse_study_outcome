package p7;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9896c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ m7.n f9897f;

    public /* synthetic */ s(int i) {
        this.f9896c = i;
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        switch (this.f9896c) {
            case 0:
                if (aVar.getRawType() == Number.class) {
                    return (t) this.f9897f;
                }
                return null;
            default:
                Class rawType = aVar.getRawType();
                if (rawType == Calendar.class || rawType == GregorianCalendar.class) {
                    return (u0) this.f9897f;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f9896c) {
            case 1:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((u0) this.f9897f) + "]";
            default:
                return super.toString();
        }
    }
}
