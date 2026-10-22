package K;

import com.stepos.renderfilter.functor.Functor;
import n.InterfaceC0773a;
import t2.C0933b;

/* renamed from: K.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0073e implements o0.r, InterfaceC0773a, com.google.android.material.textfield.z, C2.g, C2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f958a;

    public /* synthetic */ C0073e(int i4) {
        this.f958a = i4;
    }

    @Override // C2.a
    public final void a(Functor functor) {
        int i4 = this.f958a;
        C0933b c0933b = functor.f12306b;
        switch (i4) {
            case 12:
                c0933b.g();
                break;
            default:
                c0933b.b();
                break;
        }
    }

    @Override // n.InterfaceC0773a
    public final Object apply() {
        String str = B0.r.f166x;
        return null;
    }
}
