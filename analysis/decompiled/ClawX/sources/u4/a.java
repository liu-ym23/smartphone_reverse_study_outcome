package u4;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f5640a = TimeZone.getTimeZone("GMT");

    public static final d a(Long l3) {
        Calendar calendar = Calendar.getInstance(f5640a, Locale.ROOT);
        p.b(calendar);
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        int i8 = calendar.get(16) + calendar.get(15);
        int i9 = calendar.get(13);
        int i10 = calendar.get(12);
        int i11 = calendar.get(11);
        int i12 = (calendar.get(7) + 5) % 7;
        f.f5654a.getClass();
        f fVar = (f) f.f5656c.get(i12);
        int i13 = calendar.get(5);
        int i14 = calendar.get(6);
        p0.b bVar = e.f5651a;
        int i15 = calendar.get(2);
        bVar.getClass();
        return new d(i9, i10, i11, fVar, i13, i14, (e) e.f5653c.get(i15), calendar.get(1), calendar.getTimeInMillis() + i8);
    }
}
