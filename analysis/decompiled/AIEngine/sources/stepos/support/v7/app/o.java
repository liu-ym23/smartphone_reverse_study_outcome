package stepos.support.v7.app;

import android.view.View;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends mb.y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImplV7 f12172a;

    public o(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f12172a = appCompatDelegateImplV7;
    }

    @Override // mb.y, v0.i0
    public final void d(View view) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f12172a;
        ActionBarContextView actionBarContextView = appCompatDelegateImplV7.f11993u;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        actionBarContextView.setAlpha(1.0f);
        appCompatDelegateImplV7.f11996x.e(null);
        appCompatDelegateImplV7.f11996x = null;
    }

    @Override // mb.y, v0.i0
    public final void e(View view) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f12172a;
        appCompatDelegateImplV7.f11993u.setVisibility(0);
        appCompatDelegateImplV7.f11993u.sendAccessibilityEvent(32);
        if (appCompatDelegateImplV7.f11993u.getParent() != null) {
            View view2 = (View) appCompatDelegateImplV7.f11993u.getParent();
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.c.b(view2);
        }
    }
}
