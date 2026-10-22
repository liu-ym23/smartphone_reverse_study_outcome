package h6;

import java.util.Comparator;
import n9.e;
import x9.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9350a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9350a) {
            case 0:
                return ob.b.a(((s) obj).f9340c, ((s) obj2).f9340c);
            case 1:
                return ob.b.a(Integer.valueOf(((e.b) obj).f10689b.f13770a), Integer.valueOf(((e.b) obj2).f10689b.f13770a));
            default:
                return ob.b.a(Integer.valueOf(((h.b) obj).f13773b.f13770a), Integer.valueOf(((h.b) obj2).f13773b.f13770a));
        }
    }
}
