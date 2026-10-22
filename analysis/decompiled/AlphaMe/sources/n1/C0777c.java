package n1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.util.ArrayList;
import q.l;

/* renamed from: n1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0777c {

    /* renamed from: a, reason: collision with root package name */
    public final l f13655a = new l();

    /* renamed from: b, reason: collision with root package name */
    public final l f13656b = new l();

    public static C0777c a(int i4, Context context) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i4);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return b(arrayList);
        } catch (Exception e4) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i4), e4);
            return null;
        }
    }

    public static C0777c b(ArrayList arrayList) {
        C0777c c0777c = new C0777c();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Animator animator = (Animator) arrayList.get(i4);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c0777c.f13656b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            C0778d c0778d = new C0778d();
            c0778d.f13660d = 0;
            c0778d.f13661e = 1;
            c0778d.f13657a = startDelay;
            c0778d.f13658b = duration;
            c0778d.f13659c = interpolator;
            c0778d.f13660d = objectAnimator.getRepeatCount();
            c0778d.f13661e = objectAnimator.getRepeatMode();
            c0777c.f13655a.put(propertyName, c0778d);
        }
        return c0777c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0777c) {
            return this.f13655a.equals(((C0777c) obj).f13655a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13655a.hashCode();
    }

    public final String toString() {
        return "\n" + C0777c.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f13655a + "}\n";
    }
}
