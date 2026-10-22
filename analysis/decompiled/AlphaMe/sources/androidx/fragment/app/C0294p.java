package androidx.fragment.app;

import android.util.Log;
import android.view.View;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0294p implements androidx.lifecycle.V {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f3795a;

    public C0294p(r rVar) {
        this.f3795a = rVar;
    }

    @Override // androidx.lifecycle.V
    public final void onChanged(Object obj) {
        if (((androidx.lifecycle.G) obj) != null) {
            r rVar = this.f3795a;
            if (rVar.f3816h) {
                View viewRequireView = rVar.requireView();
                if (viewRequireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (rVar.f3820l != null) {
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + rVar.f3820l);
                    }
                    rVar.f3820l.setContentView(viewRequireView);
                }
            }
        }
    }
}
