package stepos.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.C0189a;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;

/* renamed from: stepos.support.v7.widget.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewTreeObserverOnPreDrawListenerC0883c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f15071a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15072b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarContextView f15073c;

    public ViewTreeObserverOnPreDrawListenerC0883c(ActionBarContextView actionBarContextView, ViewGroup viewGroup, int i4) {
        this.f15073c = actionBarContextView;
        this.f15071a = viewGroup;
        this.f15072b = i4;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f15071a;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ActionBarContextView actionBarContextView = this.f15073c;
        int i4 = actionBarContextView.f14725w;
        C0189a c0189a = actionBarContextView.f14727y;
        if (i4 == 2) {
            c0189a.c(view);
            return false;
        }
        float height = view.getHeight();
        WeakHashMap weakHashMap = K.S.f939a;
        view.setTranslationY(height);
        K.e0 e0VarA = K.S.a(view);
        e0VarA.h(Property.DEFAULT_FLOAT_VALUE);
        e0VarA.c(260L);
        e0VarA.d(ActionBarContextView.f14712A);
        ((ActionBarContextView) c0189a.f3051d).f14728z = e0VarA;
        c0189a.f3050c = this.f15072b;
        e0VarA.e(c0189a);
        e0VarA.g();
        return false;
    }
}
