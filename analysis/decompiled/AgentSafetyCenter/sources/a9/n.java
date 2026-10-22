package a9;

import android.view.View;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import n3.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f292c;

    public /* synthetic */ n(int i) {
        this.f292c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f292c) {
            case 0:
                return com.stepos.statsrpk.h.j(Long.valueOf(((l) obj2).f287e), Long.valueOf(((l) obj).f287e));
            case 1:
                return com.stepos.statsrpk.h.j(Long.valueOf(((q) obj2).f303e), Long.valueOf(((q) obj).f303e));
            case 2:
                WeakHashMap weakHashMap = k0.f8724a;
                float z10 = ((View) obj).getZ();
                float z11 = ((View) obj2).getZ();
                if (z10 > z11) {
                    return -1;
                }
                return z10 < z11 ? 1 : 0;
            case 3:
                w2.c.d(obj);
                throw null;
            case 4:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 5:
                return com.stepos.statsrpk.h.j(((pd.g) obj).f10013a, ((pd.g) obj2).f10013a);
            case 6:
                return com.stepos.statsrpk.h.j((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 7:
                return com.stepos.statsrpk.h.j((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 8:
                return com.stepos.statsrpk.h.j(((s4.e) obj).f11387a, ((s4.e) obj2).f11387a);
            case 9:
                return com.stepos.statsrpk.h.j(((s4.g) obj).f11399a, ((s4.g) obj2).f11399a);
            default:
                return ((u2.e) obj).f14015f - ((u2.e) obj2).f14015f;
        }
    }
}
