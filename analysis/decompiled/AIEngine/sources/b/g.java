package b;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements androidx.lifecycle.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3000b;

    public /* synthetic */ g(Object obj, int i10) {
        this.f2999a = i10;
        this.f3000b = obj;
    }

    @Override // androidx.lifecycle.o
    public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
        int i10 = this.f2999a;
        Object obj = this.f3000b;
        switch (i10) {
            case 0:
                k._init_$lambda$4((k) obj, qVar, event);
                break;
            default:
                x1.a aVar = (x1.a) obj;
                if (event != Lifecycle.Event.ON_START) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        aVar.h = false;
                        break;
                    }
                } else {
                    aVar.h = true;
                    break;
                }
                break;
        }
    }
}
