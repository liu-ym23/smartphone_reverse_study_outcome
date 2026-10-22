package s7;

import java.sql.Timestamp;
import java.util.Date;
import m7.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final c f11412b = new c();

    /* renamed from: a, reason: collision with root package name */
    public n f11413a;

    @Override // m7.n
    public final Object read(u7.a aVar) {
        Date date = (Date) this.f11413a.read(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        this.f11413a.write(cVar, (Timestamp) obj);
    }
}
