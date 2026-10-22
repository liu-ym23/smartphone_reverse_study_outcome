package androidx.appcompat.app;

import android.view.View;
import java.util.WeakHashMap;
import mb.y;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f346a;

    public o(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f346a = appCompatDelegateImpl;
    }

    @Override // mb.y, v0.i0
    public final void d(View view) {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f346a;
        appCompatDelegateImpl.f281y.setAlpha(1.0f);
        appCompatDelegateImpl.B.e(null);
        appCompatDelegateImpl.B = null;
    }

    @Override // mb.y, v0.i0
    public final void e(View view) {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f346a;
        appCompatDelegateImpl.f281y.setVisibility(0);
        if (appCompatDelegateImpl.f281y.getParent() instanceof View) {
            View view2 = (View) appCompatDelegateImpl.f281y.getParent();
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            e0.c.b(view2);
        }
    }
}
