package a2;

import java.util.Comparator;
import s8.j3;
import s8.p3;
import s8.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f31c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Comparator f32f;

    public /* synthetic */ a0(int i) {
        this.f31c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f31c) {
            case 0:
                int iCompare = ((z) this.f32f).compare(obj, obj2);
                return iCompare != 0 ? iCompare : com.stepos.statsrpk.h.j(Integer.valueOf(((p) obj).f91g), Integer.valueOf(((p) obj2).f91g));
            case 1:
                return ((y) this.f32f).compare(((i9.c) obj).f5845b, ((i9.c) obj2).f5845b);
            case 2:
                return ((y) this.f32f).compare(((i9.c) obj).f5845b, ((i9.c) obj2).f5845b);
            case 3:
                return ((y) this.f32f).compare((String) ((jb.g) obj).f6760f, (String) ((jb.g) obj2).f6760f);
            case 4:
                int iCompare2 = ((s8.q) this.f32f).compare(obj, obj2);
                return iCompare2 != 0 ? iCompare2 : com.stepos.statsrpk.h.j(Long.valueOf(x0.i((j3) obj2)), Long.valueOf(x0.i((j3) obj)));
            case 5:
                int iCompare3 = ((s8.r) this.f32f).compare(obj, obj2);
                return iCompare3 != 0 ? iCompare3 : com.stepos.statsrpk.h.j(((p3) obj2).f11877c, ((p3) obj).f11877c);
            case 6:
                int iCompare4 = ((s8.q) this.f32f).compare(obj, obj2);
                return iCompare4 != 0 ? iCompare4 : com.stepos.statsrpk.h.j(Long.valueOf(x0.i((j3) obj2)), Long.valueOf(x0.i((j3) obj)));
            default:
                int iCompare5 = ((s8.r) this.f32f).compare(obj, obj2);
                return iCompare5 != 0 ? iCompare5 : com.stepos.statsrpk.h.j(((p3) obj).f11886m, ((p3) obj2).f11886m);
        }
    }
}
