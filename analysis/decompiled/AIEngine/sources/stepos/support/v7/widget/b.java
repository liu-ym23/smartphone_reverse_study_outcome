package stepos.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f12703a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f12704b;

    public b(ActionBarContextView actionBarContextView, ViewGroup viewGroup, int i10) {
        this.f12704b = actionBarContextView;
        this.f12703a = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewGroup viewGroup = this.f12703a;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        ActionBarContextView actionBarContextView = this.f12704b;
        int i10 = actionBarContextView.z;
        ActionBarContextView.b bVar = actionBarContextView.B;
        if (i10 == 2) {
            bVar.d(viewGroup);
            return false;
        }
        float height = viewGroup.getHeight();
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        viewGroup.setTranslationY(height);
        h0 h0VarA = v0.e0.a(viewGroup);
        h0VarA.h(0.0f);
        h0VarA.c(260L);
        h0VarA.d(ActionBarContextView.D);
        ActionBarContextView.this.C = h0VarA;
        h0VarA.e(bVar);
        h0VarA.g();
        return false;
    }
}
