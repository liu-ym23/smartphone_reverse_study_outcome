package stepos.support.v7.widget;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ ViewGroup f12734c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ActionBarContextView f12735f;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewGroup viewGroup = this.f12734c;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        ActionBarContextView actionBarContextView = this.f12735f;
        int i = actionBarContextView.A;
        l3.d dVar = actionBarContextView.C;
        if (i == 2) {
            dVar.d();
            return false;
        }
        float height = viewGroup.getHeight();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        viewGroup.setTranslationY(height);
        n3.o0 o0VarA = n3.k0.a(viewGroup);
        o0VarA.h(0.0f);
        o0VarA.c(260L);
        o0VarA.d(ActionBarContextView.E);
        ((ActionBarContextView) dVar.f7721f).D = o0VarA;
        o0VarA.e(dVar);
        o0VarA.g();
        return false;
    }
}
