package s8;

import java.time.LocalDate;
import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11911c;

    public /* synthetic */ r(int i) {
        this.f11911c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f11911c) {
            case 0:
                return com.stepos.statsrpk.h.j((Long) ((jb.g) obj2).f6759c, (Long) ((jb.g) obj).f6759c);
            case 1:
                return com.stepos.statsrpk.h.j(Long.valueOf(x0.i((j3) obj2)), Long.valueOf(x0.i((j3) obj)));
            case 2:
                return com.stepos.statsrpk.h.j((Long) ((jb.g) obj2).f6759c, (Long) ((jb.g) obj).f6759c);
            case 3:
                return com.stepos.statsrpk.h.j(Long.valueOf(x0.i(((c2) obj2).f11502a)), Long.valueOf(x0.i(((c2) obj).f11502a)));
            case 4:
                return com.stepos.statsrpk.h.j((Long) ((jb.g) obj2).f6759c, (Long) ((jb.g) obj).f6759c);
            case 5:
                return com.stepos.statsrpk.h.j(Long.valueOf(x0.i((j3) obj2)), Long.valueOf(x0.i((j3) obj)));
            case 6:
                return com.stepos.statsrpk.h.j((LocalDate) ((jb.l) obj).f6769c, (LocalDate) ((jb.l) obj2).f6769c);
            case 7:
                return com.stepos.statsrpk.h.j(Long.valueOf(((p3) obj2).f11895v), Long.valueOf(((p3) obj).f11895v));
            case 8:
                long j10 = ((t3) obj2).f11984a.f11895v;
                Long lValueOf = Long.valueOf(j10);
                if (j10 <= 0) {
                    lValueOf = null;
                }
                Long lValueOf2 = Long.valueOf(lValueOf != null ? lValueOf.longValue() : Long.MIN_VALUE);
                long j11 = ((t3) obj).f11984a.f11895v;
                Long lValueOf3 = j11 > 0 ? Long.valueOf(j11) : null;
                return com.stepos.statsrpk.h.j(lValueOf2, Long.valueOf(lValueOf3 != null ? lValueOf3.longValue() : Long.MIN_VALUE));
            default:
                Long lValueOf4 = Long.valueOf(((p3) obj).f11895v);
                if (lValueOf4.longValue() <= 0) {
                    lValueOf4 = null;
                }
                if (lValueOf4 == null) {
                    lValueOf4 = l;
                }
                Long lValueOf5 = Long.valueOf(((p3) obj2).f11895v);
                Long l2 = lValueOf5.longValue() > 0 ? lValueOf5 : null;
                return com.stepos.statsrpk.h.j(lValueOf4, l2 != null ? l2 : Long.MAX_VALUE);
        }
    }
}
