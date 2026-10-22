package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2118a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2119b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2120c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k.a f2121d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e eVar = e.this;
            eVar.f2119b.endViewTransition(eVar.f2120c);
            eVar.f2121d.a();
        }
    }

    public e(View view, ViewGroup viewGroup, k.a aVar, SpecialEffectsController.Operation operation) {
        this.f2118a = operation;
        this.f2119b = viewGroup;
        this.f2120c = view;
        this.f2121d = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f2119b.post(new a());
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2118a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2118a + " has reached onAnimationStart.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
