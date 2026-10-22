package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import androidx.fragment.app.SpecialEffectsController;
import r0.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements c.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Animator f2094g;
    public final /* synthetic */ SpecialEffectsController.Operation h;

    public d(Animator animator, SpecialEffectsController.Operation operation) {
        this.f2094g = animator;
        this.h = operation;
    }

    @Override // r0.c.a
    public final void onCancel() {
        this.f2094g.end();
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Animator from operation " + this.h + " has been canceled.");
        }
    }
}
