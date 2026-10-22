package androidx.appcompat.app;

import android.view.View;
import android.view.ViewGroup;
import mb.y;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f344a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            AppCompatDelegateImpl appCompatDelegateImpl = n.this.f344a;
            appCompatDelegateImpl.f281y.setAlpha(1.0f);
            appCompatDelegateImpl.B.e(null);
            appCompatDelegateImpl.B = null;
        }

        @Override // mb.y, v0.i0
        public final void e(View view) {
            n.this.f344a.f281y.setVisibility(0);
        }
    }

    public n(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f344a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        AppCompatDelegateImpl appCompatDelegateImpl = this.f344a;
        appCompatDelegateImpl.z.showAtLocation(appCompatDelegateImpl.f281y, 55, 0, 0);
        h0 h0Var = appCompatDelegateImpl.B;
        if (h0Var != null) {
            h0Var.b();
        }
        if (!appCompatDelegateImpl.D || (viewGroup = appCompatDelegateImpl.E) == null || !viewGroup.isLaidOut()) {
            appCompatDelegateImpl.f281y.setAlpha(1.0f);
            appCompatDelegateImpl.f281y.setVisibility(0);
            return;
        }
        appCompatDelegateImpl.f281y.setAlpha(0.0f);
        h0 h0VarA = e0.a(appCompatDelegateImpl.f281y);
        h0VarA.a(1.0f);
        appCompatDelegateImpl.B = h0VarA;
        h0VarA.e(new a());
    }
}
