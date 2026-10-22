package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    private long mDuration;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;

    public ViewPropertyAnimatorCompatSet() {
        this.mDuration = -1;
        this.mProxyListener = new AnonymousClass1(this);
        this.mAnimators = new ArrayList();
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat r2) {
        if (this.mIsStarted == true) goto L5;
        this.mAnimators.add(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat r3, ViewPropertyAnimatorCompat r4) {
        this.mAnimators.add(r3);
        r4.setStartDelay(r3.getDuration());
        this.mAnimators.add(r4);
        return this;
    }

    public void start() {
        if (this.mIsStarted == false) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r0 = this.mAnimators.iterator();
    L7:
        if (r0.hasNext() == false) goto L18;
        ViewPropertyAnimatorCompat r1 = r0.next();
        long r2 = this.mDuration;
        if (r2 < 0) goto L11;
        r1.setDuration(r2);
    L11:
        Interpolator r3 = this.mInterpolator;
        if (r3 == null) goto L15;
        r1.setInterpolator(r3);
    L15:
        if (this.mListener == null) goto L17;
        r1.setListener(this.mProxyListener);
    L17:
        r1.start();
        goto L7
    L18:
        this.mIsStarted = true;
    }

    void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public void cancel() {
        if (this.mIsStarted == true) goto L5;
        return;
    L5:
        Iterator<ViewPropertyAnimatorCompat> r0 = this.mAnimators.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().cancel();
        goto L7
    L9:
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long r2) {
        if (this.mIsStarted == true) goto L5;
        this.mDuration = r2;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator r2) {
        if (this.mIsStarted == true) goto L5;
        this.mInterpolator = r2;
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener r2) {
        if (this.mIsStarted == true) goto L5;
        this.mListener = r2;
    L5:
        return this;
    }
}
