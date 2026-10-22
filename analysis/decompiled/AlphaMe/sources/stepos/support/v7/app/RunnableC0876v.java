package stepos.support.v7.app;

import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;

/* renamed from: stepos.support.v7.app.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0876v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14590a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0880z f14591b;

    public /* synthetic */ RunnableC0876v(AbstractC0880z abstractC0880z, int i4) {
        this.f14590a = i4;
        this.f14591b = abstractC0880z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f14590a;
        AbstractC0880z abstractC0880z = this.f14591b;
        switch (i4) {
            case 0:
                if ((abstractC0880z.f14621J & 1) != 0) {
                    AbstractC0880z.n(abstractC0880z, 0);
                }
                if ((abstractC0880z.f14621J & 4096) != 0) {
                    AbstractC0880z.n(abstractC0880z, 108);
                }
                abstractC0880z.f14620I = false;
                abstractC0880z.f14621J = 0;
                break;
            default:
                abstractC0880z.f14633v.showAtLocation(abstractC0880z.f14632u, 55, 0, 0);
                abstractC0880z.s();
                ActionBarContextView actionBarContextView = abstractC0880z.f14632u;
                WeakHashMap weakHashMap = K.S.f939a;
                actionBarContextView.setAlpha(Property.DEFAULT_FLOAT_VALUE);
                K.e0 e0VarA = K.S.a(abstractC0880z.f14632u);
                e0VarA.a(1.0f);
                abstractC0880z.f14635x = e0VarA;
                e0VarA.e(new androidx.appcompat.app.t(3, this));
                break;
        }
    }
}
