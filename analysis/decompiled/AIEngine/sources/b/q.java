package b;

import androidx.activity.OnBackPressedDispatcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3029a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f3030b;

    public /* synthetic */ q(OnBackPressedDispatcher onBackPressedDispatcher, int i10) {
        this.f3029a = i10;
        this.f3030b = onBackPressedDispatcher;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f3029a;
        OnBackPressedDispatcher onBackPressedDispatcher = this.f3030b;
        switch (i10) {
            case 0:
                onBackPressedDispatcher.c();
                break;
            default:
                onBackPressedDispatcher.c();
                break;
        }
        return lb.n.f10413a;
    }
}
