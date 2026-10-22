package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;

    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public void cancel() {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r100 = this.mAnimators.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().cancel();
        goto L7
    L9:
        this.mIsStarted = false;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r100 = this.mAnimators.iterator();
    L7:
        if (r100.hasNext() == false) goto L18;
        ViewPropertyAnimatorCompat r101 = r100.next();
        long r102 = this.mDuration;
        if (r102 < 0) goto L11;
        r101.setDuration(r102);
    L11:
        Interpolator r103 = this.mInterpolator;
        if (r103 == null) goto L15;
        r101.setInterpolator(r103);
    L15:
        if (this.mListener == null) goto L17;
        r101.setListener(this.mProxyListener);
    L17:
        r101.start();
        goto L7
    L18:
        this.mIsStarted = true;
    }

    public ViewPropertyAnimatorCompatSet() {
        this.mDuration = -1;
        this.mProxyListener = new AnonymousClass1(this);
        this.mAnimators = new ArrayList();
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat r100) {
        if (this.mIsStarted == true) goto L5;
        this.mAnimators.add(r100);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long r100) {
        if (this.mIsStarted == true) goto L5;
        this.mDuration = r100;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator r100) {
        if (this.mIsStarted == true) goto L5;
        this.mInterpolator = r100;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener r100) {
        if (this.mIsStarted == true) goto L5;
        this.mListener = r100;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat r100, ViewPropertyAnimatorCompat r101) {
        this.mAnimators.add(r100);
        r101.setStartDelay(r100.getDuration());
        this.mAnimators.add(r101);
        return this;
    }
}
