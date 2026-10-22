package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2085a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2086b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2087c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2088d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ k.a f2089e;

    public c(ViewGroup viewGroup, View view, boolean z, SpecialEffectsController.Operation operation, k.a aVar) {
        this.f2085a = viewGroup;
        this.f2086b = view;
        this.f2087c = z;
        this.f2088d = operation;
        this.f2089e = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f2085a;
        View view = this.f2086b;
        viewGroup.endViewTransition(view);
        boolean z = this.f2087c;
        SpecialEffectsController.Operation operation = this.f2088d;
        if (z) {
            operation.f2054a.a(view);
        }
        this.f2089e.a();
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Animator from operation " + operation + " has ended.");
        }
    }
}
