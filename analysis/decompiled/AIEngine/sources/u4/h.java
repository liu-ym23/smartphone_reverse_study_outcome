package u4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f13158a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13159b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f13160c;

    public h(i iVar, boolean z, int i10) {
        this.f13160c = iVar;
        this.f13158a = z;
        this.f13159b = i10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        i iVar = this.f13160c;
        iVar.f13144b.setTranslationX(0.0f);
        iVar.a(0.0f, this.f13158a, this.f13159b);
    }
}
