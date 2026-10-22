package androidx.appcompat.app;

import K.S;
import K.e0;
import android.view.ViewGroup;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2676a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f2677b;

    public /* synthetic */ r(F f4, int i4) {
        this.f2676a = i4;
        this.f2677b = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i4 = this.f2676a;
        int i5 = 0;
        F f4 = this.f2677b;
        switch (i4) {
            case 0:
                if ((f4.f2504S & 1) != 0) {
                    f4.h(0);
                }
                if ((f4.f2504S & 4096) != 0) {
                    f4.h(108);
                }
                f4.f2503R = false;
                f4.f2504S = 0;
                break;
            default:
                f4.f2522o.showAtLocation(f4.f2521n, 55, 0, 0);
                e0 e0Var = f4.f2524q;
                if (e0Var != null) {
                    e0Var.b();
                }
                if (!(f4.f2526s && (viewGroup = f4.f2527t) != null && viewGroup.isLaidOut())) {
                    f4.f2521n.setAlpha(1.0f);
                    f4.f2521n.setVisibility(0);
                    break;
                } else {
                    f4.f2521n.setAlpha(Property.DEFAULT_FLOAT_VALUE);
                    e0 e0VarA = S.a(f4.f2521n);
                    e0VarA.a(1.0f);
                    f4.f2524q = e0VarA;
                    e0VarA.e(new t(i5, this));
                    break;
                }
        }
    }
}
