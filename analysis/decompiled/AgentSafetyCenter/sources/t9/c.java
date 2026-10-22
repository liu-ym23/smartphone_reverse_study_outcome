package t9;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ d f13275a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f13276b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        d dVar = this.f13275a;
        int i = this.f13276b;
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() + i;
        b bVar = dVar.f13283l;
        bVar.setBounds(i, bVar.getBounds().top, iIntValue, bVar.getBounds().bottom);
    }
}
