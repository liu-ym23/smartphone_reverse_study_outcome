package org.libpag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import org.libpag.PAGImageView;

/* loaded from: classes.dex */
class g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGImageView f19231a;

    g(PAGImageView pAGImageView) {
        this.f19231a = pAGImageView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ArrayList arrayList;
        super.onAnimationCancel(animator);
        synchronized (this.f19231a) {
            arrayList = new ArrayList(this.f19231a.f19148B);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGImageView.PAGImageViewListener) obj).onAnimationCancel(this.f19231a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        int repeatCount = ((ValueAnimator) animator).getRepeatCount();
        if (repeatCount < 0 || animator.getDuration() <= 0 || this.f19231a.f19182z / animator.getDuration() <= repeatCount) {
            return;
        }
        this.f19231a.n();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        ArrayList arrayList;
        super.onAnimationRepeat(animator);
        synchronized (this.f19231a) {
            arrayList = new ArrayList(this.f19231a.f19148B);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGImageView.PAGImageViewListener) obj).onAnimationRepeat(this.f19231a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ArrayList arrayList;
        super.onAnimationStart(animator);
        synchronized (this.f19231a) {
            arrayList = new ArrayList(this.f19231a.f19148B);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGImageView.PAGImageViewListener) obj).onAnimationStart(this.f19231a);
        }
    }
}
