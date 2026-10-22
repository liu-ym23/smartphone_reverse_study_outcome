package stepos.support.v7.app;

import android.view.View;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImplV7 f12156a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends mb.y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = n.this.f12156a;
            ActionBarContextView actionBarContextView = appCompatDelegateImplV7.f11993u;
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            actionBarContextView.setAlpha(1.0f);
            appCompatDelegateImplV7.f11996x.e(null);
            appCompatDelegateImplV7.f11996x = null;
        }

        @Override // mb.y, v0.i0
        public final void e(View view) {
            n.this.f12156a.f11993u.setVisibility(0);
        }
    }

    public n(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f12156a = appCompatDelegateImplV7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f12156a;
        appCompatDelegateImplV7.f11994v.showAtLocation(appCompatDelegateImplV7.f11993u, 55, 0, 0);
        appCompatDelegateImplV7.r();
        ActionBarContextView actionBarContextView = appCompatDelegateImplV7.f11993u;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        actionBarContextView.setAlpha(0.0f);
        v0.h0 h0VarA = v0.e0.a(appCompatDelegateImplV7.f11993u);
        h0VarA.a(1.0f);
        appCompatDelegateImplV7.f11996x = h0VarA;
        h0VarA.e(new a());
    }
}
