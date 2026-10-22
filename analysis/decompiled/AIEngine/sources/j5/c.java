package j5;

import com.google.gson.reflect.TypeToken;
import d5.i;
import d5.u;
import d5.v;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends u<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9700b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final u<Date> f9701a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements v {
        @Override // d5.v
        public final <T> u<T> b(i iVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            iVar.getClass();
            return new c(iVar.e(TypeToken.get(Date.class)));
        }
    }

    public c(u uVar) {
        this.f9701a = uVar;
    }

    @Override // d5.u
    public final Timestamp a(k5.a aVar) {
        Date dateA = this.f9701a.a(aVar);
        if (dateA != null) {
            return new Timestamp(dateA.getTime());
        }
        return null;
    }

    @Override // d5.u
    public final void b(k5.b bVar, Timestamp timestamp) {
        this.f9701a.b(bVar, timestamp);
    }
}
