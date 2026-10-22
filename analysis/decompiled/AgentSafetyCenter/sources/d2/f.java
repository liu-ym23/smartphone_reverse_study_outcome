package d2;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3095c;

    public /* synthetic */ f(int i) {
        this.f3095c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3095c) {
        }
        return com.stepos.statsrpk.h.j(Integer.valueOf(((e) obj).f3078b), Integer.valueOf(((e) obj2).f3078b));
    }
}
