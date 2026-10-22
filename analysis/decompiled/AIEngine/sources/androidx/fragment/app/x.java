package androidx.fragment.app;

import android.content.res.Configuration;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements u0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2204a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2205b;

    public /* synthetic */ x(Object obj, int i10) {
        this.f2204a = i10;
        this.f2205b = obj;
    }

    @Override // u0.a
    public final void accept(Object obj) {
        int i10 = this.f2204a;
        Object obj2 = this.f2205b;
        switch (i10) {
            case 0:
                FragmentManager fragmentManager = (FragmentManager) obj2;
                Integer num = (Integer) obj;
                if (fragmentManager.I() && num.intValue() == 80) {
                    fragmentManager.l(false);
                    break;
                }
                break;
            case 1:
                FragmentManager fragmentManager2 = (FragmentManager) obj2;
                androidx.core.app.m mVar = (androidx.core.app.m) obj;
                if (fragmentManager2.I()) {
                    fragmentManager2.r(mVar.f1514a, false);
                    break;
                }
                break;
            default:
                ((o) obj2).lambda$init$1((Configuration) obj);
                break;
        }
    }
}
