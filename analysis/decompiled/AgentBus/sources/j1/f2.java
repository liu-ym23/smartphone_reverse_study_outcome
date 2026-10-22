package j1;

import android.view.View;

/* loaded from: classes.dex */
public final class f2 implements View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f5163f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b0.j2 f5164g;

    public f2(View view, b0.j2 j2Var) {
        this.f5163f = view;
        this.f5164g = j2Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f5163f.removeOnAttachStateChangeListener(this);
        this.f5164g.d();
    }
}
