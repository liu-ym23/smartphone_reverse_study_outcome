package a2;

import java.util.Comparator;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f150c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Comparator f151f;

    public /* synthetic */ z(int i) {
        this.f150c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f150c) {
            case 0:
                int iCompare = this.f151f.compare(obj, obj2);
                if (iCompare != 0) {
                    return iCompare;
                }
                return g0.V.compare(((p) obj).f87c, ((p) obj2).f87c);
            default:
                throw null;
        }
    }
}
