package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;
import g5.p;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8994a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8995b;

    public /* synthetic */ i(Object obj, int i10) {
        this.f8994a = i10;
        this.f8995b = obj;
    }

    @Override // d5.v
    public final u b(d5.i iVar, TypeToken typeToken) {
        switch (this.f8994a) {
            case 0:
                if (typeToken.getRawType() == Object.class) {
                    return new j(iVar, (d5.t) this.f8995b);
                }
                return null;
            default:
                Class rawType = typeToken.getRawType();
                if (rawType == Calendar.class || rawType == GregorianCalendar.class) {
                    return (p.r) this.f8995b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f8994a) {
            case 1:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((p.r) this.f8995b) + "]";
            default:
                return super.toString();
        }
    }
}
