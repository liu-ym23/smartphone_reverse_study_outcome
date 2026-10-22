package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.k;
import r0.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements c.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ View f2125g;
    public final /* synthetic */ ViewGroup h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k.a f2126i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2127j;

    public f(View view, ViewGroup viewGroup, k.a aVar, SpecialEffectsController.Operation operation) {
        this.f2125g = view;
        this.h = viewGroup;
        this.f2126i = aVar;
        this.f2127j = operation;
    }

    @Override // r0.c.a
    public final void onCancel() {
        View view = this.f2125g;
        view.clearAnimation();
        this.h.endViewTransition(view);
        this.f2126i.a();
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2127j + " has been cancelled.");
        }
    }
}
