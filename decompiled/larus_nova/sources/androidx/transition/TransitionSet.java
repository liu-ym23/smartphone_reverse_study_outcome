package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import tb2.c;

/* JADX INFO: loaded from: classes17.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private ArrayList<Transition> mTransitions;

    public static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet r100) {
            this.mTransitionSet = r100;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r100) {
            TransitionSet r101 = this.mTransitionSet;
            int r102 = r101.mCurrentListeners - 1;
            r101.mCurrentListeners = r102;
            if (r102 != 0) goto L5;
            r101.mStarted = false;
            r101.end();
        L5:
            r100.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r100) {
            TransitionSet r101 = this.mTransitionSet;
            if (r101.mStarted == true) goto L6;
            r101.start();
            this.mTransitionSet.mStarted = true;
            return;
        }
    }

    private void setupStartEndListeners() {
        TransitionSetListener r100 = new TransitionSetListener(this);
        Iterator<Transition> r101 = this.mTransitions.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().addListener(r100);
        goto L4
    L6:
        this.mCurrentListeners = this.mTransitions.size();
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.mTransitions.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        setupStartEndListeners();
        if (this.mPlayTogether == true) goto L15;
        int r100 = 1;
    L10:
        if (r100 >= this.mTransitions.size()) goto L12;
        Transition r101 = (Transition) ListProtector.get(this.mTransitions, r100 - 1);
        final Transition r102 = (Transition) ListProtector.get(this.mTransitions, r100);
        r101.addListener(new AnonymousClass1(this, r102));
        r100 = r100 + 1;
        goto L10
    L12:
        Transition r103 = (Transition) ListProtector.get(this.mTransitions, 0);
        if (r103 == null) goto L19;
        r103.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator<Transition> r104 = this.mTransitions.iterator();
    L17:
        if (r104.hasNext() == false) goto L23;
        r104.next().runAnimators();
        goto L17
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int r100 = this.mTransitions.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r101)).cancel();
        r101 = r101 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public Transition clone() {
        TransitionSet r100 = (TransitionSet) super.clone();
        r100.mTransitions = new ArrayList();
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.addTransition(((Transition) ListProtector.get(this.mTransitions, r102)).clone());
        r102 = r102 + 1;
        goto L3
    L5:
        return r100;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo7958clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.transition.Transition
    public TransitionSet addListener(Transition.TransitionListener r100) {
        return (TransitionSet) super.addListener(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).addTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r100);
    }

    public TransitionSet addTransition(Transition r100) {
        this.mTransitions.add(r100);
        r100.mParent = this;
        long r101 = this.mDuration;
        if (r101 < 0) goto L6;
        r100.setDuration(r101);
    L6:
        if ((this.mChangeFlags & 1) == 0) goto L9;
        r100.setInterpolator(getInterpolator());
    L9:
        if ((this.mChangeFlags & 2) == 0) goto L12;
        r100.setPropagation(getPropagation());
    L12:
        if ((this.mChangeFlags & 4) == 0) goto L15;
        r100.setPathMotion(getPathMotion());
    L15:
        if ((this.mChangeFlags & 8) == 0) goto L17;
        r100.setEpicenterCallback(getEpicenterCallback());
    L17:
        return this;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        if (isValidTarget(r100.view) == false) goto L10;
        Iterator<Transition> r101 = this.mTransitions.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Transition r102 = r101.next();
        if (r102.isValidTarget(r100.view) == false) goto L6;
        r102.captureEndValues(r100);
        r100.mTargetedTransitions.add(r102);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues r100) {
        super.capturePropagationValues(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).capturePropagationValues(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        if (isValidTarget(r100.view) == false) goto L10;
        Iterator<Transition> r101 = this.mTransitions.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Transition r102 = r101.next();
        if (r102.isValidTarget(r100.view) == false) goto L6;
        r102.captureStartValues(r100);
        r100.mTargetedTransitions.add(r102);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup r100) {
        super.forceToEnd(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).forceToEnd(r100);
        r102 = r102 + 1;
        goto L3
    }

    public Transition getTransitionAt(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.mTransitions.size()) goto L7;
        return null;
    L7:
        return (Transition) ListProtector.get(this.mTransitions, r100);
    }

    @Override // androidx.transition.Transition
    public void pause(View r100) {
        super.pause(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).pause(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeListener(Transition.TransitionListener r100) {
        return (TransitionSet) super.removeListener(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).removeTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r100);
    }

    public TransitionSet removeTransition(Transition r100) {
        this.mTransitions.remove(r100);
        r100.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    public void resume(View r100) {
        super.resume(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).resume(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean r100) {
        super.setCanRemoveViews(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).setCanRemoveViews(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public TransitionSet setDuration(long r100) {
        super.setDuration(r100);
        if (this.mDuration < 0) goto L7;
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r102)).setDuration(r100);
        r102 = r102 + 1;
    L7:
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback r100) {
        super.setEpicenterCallback(r100);
        this.mChangeFlags |= 8;
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).setEpicenterCallback(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public TransitionSet setInterpolator(TimeInterpolator r100) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> r101 = this.mTransitions;
        if (r101 == null) goto L8;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        ((Transition) ListProtector.get(this.mTransitions, r103)).setInterpolator(r100);
        r103 = r103 + 1;
    L8:
        return (TransitionSet) super.setInterpolator(r100);
    }

    public TransitionSet setOrdering(int r100) {
        if (r100 == 0) goto L8;
        if (r100 != 1) goto L7;
        this.mPlayTogether = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r100);
    L8:
        this.mPlayTogether = true;
        goto L9
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r100) {
        super.setPathMotion(r100);
        this.mChangeFlags |= 4;
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L6;
        ((Transition) ListProtector.get(this.mTransitions, r101)).setPathMotion(r100);
        r101 = r101 + 1;
        goto L4
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation r100) {
        super.setPropagation(r100);
        this.mChangeFlags |= 2;
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).setPropagation(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup r100) {
        super.setSceneRoot(r100);
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((Transition) ListProtector.get(this.mTransitions, r102)).setSceneRoot(r100);
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    @Override // androidx.transition.Transition
    public TransitionSet setStartDelay(long r100) {
        return (TransitionSet) super.setStartDelay(r100);
    }

    @Override // androidx.transition.Transition
    public String toString(String r100) {
        String r101 = super.toString(r100);
        int r102 = 0;
    L4:
        if (r102 >= this.mTransitions.size()) goto L6;
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        r103.append("\n");
        r103.append(((Transition) ListProtector.get(this.mTransitions, r102)).toString(r100 + c.DEFAULT_TEXT));
        r101 = r103.toString();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addListener(Transition.TransitionListener r100) {
        return addListener(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).addTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeListener(Transition.TransitionListener r100) {
        return removeListener(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).removeTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long r100) {
        return setDuration(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setInterpolator(TimeInterpolator r100) {
        return setInterpolator(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setSceneRoot(ViewGroup r100) {
        return setSceneRoot(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r100) {
        return setStartDelay(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(Class r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).addTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(Class r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).removeTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet addTarget(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).addTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public TransitionSet removeTarget(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r101)).removeTarget(r100);
        r101 = r101 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(int r100) {
        return addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(int r100) {
        return removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(View r100) {
        return addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(View r100) {
        return removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(Class r100) {
        return addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(Class r100) {
        return removeTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(String r100) {
        return addTarget(r100);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(String r100) {
        return removeTarget(r100);
    }

    public TransitionSet(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mTransitions = new ArrayList();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(r102, (XmlResourceParser) r101, "transitionOrdering", 0, 0));
        r102.recycle();
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r102)).excludeTarget(r100, r101);
        r102 = r102 + 1;
        goto L4
    L7:
        return super.excludeTarget(r100, r101);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r102)).excludeTarget(r100, r101);
        r102 = r102 + 1;
        goto L4
    L7:
        return super.excludeTarget(r100, r101);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r102)).excludeTarget(r100, r101);
        r102 = r102 + 1;
        goto L4
    L7:
        return super.excludeTarget(r100, r101);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String r100, boolean r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mTransitions.size()) goto L7;
        ((Transition) ListProtector.get(this.mTransitions, r102)).excludeTarget(r100, r101);
        r102 = r102 + 1;
        goto L4
    L7:
        return super.excludeTarget(r100, r101);
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup r110, TransitionValuesMaps r111, TransitionValuesMaps r112, ArrayList<TransitionValues> r113, ArrayList<TransitionValues> r114) {
        long r100 = getStartDelay();
        int r101 = this.mTransitions.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        Transition r103 = (Transition) ListProtector.get(this.mTransitions, r102);
        if (r100 <= 0) goto L13;
        if (this.mPlayTogether == true) goto L9;
        if (r102 != 0) goto L13;
    L9:
        long r104 = r103.getStartDelay();
        if (r104 <= 0) goto L12;
        r103.setStartDelay(r104 + r100);
        goto L13
    L12:
        r103.setStartDelay(r100);
    L13:
        r103.createAnimators(r110, r111, r112, r113, r114);
        r102 = r102 + 1;
        goto L3
    }
}
