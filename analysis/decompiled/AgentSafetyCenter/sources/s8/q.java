package s8;

import java.time.ZoneId;
import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11900c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ZoneId f11901f;

    public /* synthetic */ q(int i) {
        this.f11900c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f11900c) {
            case 0:
                ZoneId zoneId = this.f11901f;
                return com.stepos.statsrpk.h.j(Long.valueOf(g1.q((j3) obj2, zoneId)), Long.valueOf(g1.q((j3) obj, zoneId)));
            default:
                ZoneId zoneId2 = this.f11901f;
                return com.stepos.statsrpk.h.j(Long.valueOf(g1.q((j3) obj2, zoneId2)), Long.valueOf(g1.q((j3) obj, zoneId2)));
        }
    }
}
