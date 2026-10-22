package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class M implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3629a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f3630b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3631c;

    public M(N n4, c0 c0Var) {
        this.f3631c = n4;
        this.f3630b = c0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i4 = this.f3629a;
        Object obj = this.f3631c;
        switch (i4) {
            case 0:
                c0 c0Var = this.f3630b;
                D d4 = c0Var.f3722c;
                c0Var.j();
                r0.g((ViewGroup) d4.mView.getParent(), ((N) obj).f3632a).e();
                break;
            default:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(view2);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public M(c0 c0Var, View view) {
        this.f3630b = c0Var;
        this.f3631c = view;
    }
}
