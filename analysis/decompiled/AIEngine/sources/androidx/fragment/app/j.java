package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.c f2149a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2150b;

    public j(k.c cVar, SpecialEffectsController.Operation operation) {
        this.f2149a = cVar;
        this.f2150b = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2149a.a();
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Transition for operation " + this.f2150b + "has completed");
        }
    }
}
