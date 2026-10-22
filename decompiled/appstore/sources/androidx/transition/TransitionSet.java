package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f5013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5017e;

    public class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Transition f5018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TransitionSet f5019b;

        public a(TransitionSet r10, Transition r11) {
            this.f5019b = r10;
            this.f5018a = r11;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            this.f5018a.runAnimators();
            r10.removeListener(this);
        }
    }

    public static class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TransitionSet f5020a;

        public b(TransitionSet r10) {
            this.f5020a = r10;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            TransitionSet r11 = this.f5020a;
            int r12 = r11.f5015c - 1;
            r11.f5015c = r12;
            if (r12 != 0) goto L5;
            r11.f5016d = false;
            r11.end();
        L5:
            r10.removeListener(this);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            TransitionSet r11 = this.f5020a;
            if (r11.f5016d == true) goto L6;
            r11.start();
            this.f5020a.f5016d = true;
            return;
        }
    }

    public TransitionSet() {
        this.f5013a = new ArrayList();
        this.f5014b = true;
        this.f5016d = false;
        this.f5017e = 0;
    }

    public int A() {
        return this.f5013a.size();
    }

    public TransitionSet B(Transition.TransitionListener r10) {
        return (TransitionSet) super.removeListener(r10);
    }

    public TransitionSet C(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    public TransitionSet D(View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    public TransitionSet E(Class r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    public TransitionSet F(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).removeTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.removeTarget(r10);
    }

    public TransitionSet G(Transition r10) {
        this.f5013a.remove(r10);
        r10.mParent = null;
        return this;
    }

    public TransitionSet H(long r10) {
        super.setDuration(r10);
        if (this.mDuration < 0) goto L9;
        ArrayList r11 = this.f5013a;
        if (r11 == null) goto L9;
        int r12 = r11.size();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        ((Transition) this.f5013a.get(r13)).setDuration(r10);
        r13 = r13 + 1;
    L9:
        return this;
    }

    public TransitionSet I(TimeInterpolator r10) {
        this.f5017e |= 1;
        ArrayList r11 = this.f5013a;
        if (r11 == null) goto L8;
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        ((Transition) this.f5013a.get(r13)).setInterpolator(r10);
        r13 = r13 + 1;
    L8:
        return (TransitionSet) super.setInterpolator(r10);
    }

    public TransitionSet J(int r10) {
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        this.f5014b = false;
    L9:
        return this;
    L7:
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + r10);
    L8:
        this.f5014b = true;
        goto L9
    }

    public TransitionSet K(long r10) {
        return (TransitionSet) super.setStartDelay(r10);
    }

    public final void L() {
        b r10 = new b(this);
        Iterator r11 = this.f5013a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((Transition) r11.next()).addListener(r10);
        goto L4
    L6:
        this.f5015c = this.f5013a.size();
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addListener(Transition.TransitionListener r10) {
        return s(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(int r10) {
        return t(r10);
    }

    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int r10 = this.f5013a.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((Transition) this.f5013a.get(r11)).cancel();
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(s r10) {
        if (isValidTarget(r10.f5086b) == false) goto L10;
        Iterator r11 = this.f5013a.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        Transition r12 = (Transition) r11.next();
        if (r12.isValidTarget(r10.f5086b) == false) goto L6;
        r12.captureEndValues(r10);
        r10.f5087c.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(s r10) {
        super.capturePropagationValues(r10);
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).capturePropagationValues(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(s r10) {
        if (isValidTarget(r10.f5086b) == false) goto L10;
        Iterator r11 = this.f5013a.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        Transition r12 = (Transition) r11.next();
        if (r12.isValidTarget(r10.f5086b) == false) goto L6;
        r12.captureStartValues(r10);
        r10.f5087c.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo3clone() {
        return clone();
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup r13, t r14, t r15, ArrayList r16, ArrayList r17) {
        long r10 = getStartDelay();
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        Transition r18 = (Transition) this.f5013a.get(r12);
        if (r10 <= 0) goto L13;
        if (this.f5014b == true) goto L9;
        if (r12 != 0) goto L13;
    L9:
        long r19 = r18.getStartDelay();
        if (r19 <= 0) goto L12;
        r18.setStartDelay(r19 + r10);
        goto L13
    L12:
        r18.setStartDelay(r10);
    L13:
        r18.createAnimators(r13, r14, r15, r16, r17);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r12)).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup r10) {
        super.forceToEnd(r10);
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).forceToEnd(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void pause(View r10) {
        super.pause(r10);
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).pause(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeListener(Transition.TransitionListener r10) {
        return B(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(int r10) {
        return C(r10);
    }

    @Override // androidx.transition.Transition
    public void resume(View r10) {
        super.resume(r10);
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).resume(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.f5013a.isEmpty() == false) goto L6;
        start();
        end();
        return;
    L6:
        L();
        if (this.f5014b == true) goto L15;
        int r10 = 1;
    L10:
        if (r10 >= this.f5013a.size()) goto L12;
        ((Transition) this.f5013a.get(r10 - 1)).addListener(new a(this, (Transition) this.f5013a.get(r10)));
        r10 = r10 + 1;
        goto L10
    L12:
        Transition r11 = (Transition) this.f5013a.get(0);
        if (r11 == null) goto L19;
        r11.runAnimators();
        return;
    L19:
        return;
    L15:
        Iterator r12 = this.f5013a.iterator();
    L17:
        if (r12.hasNext() == false) goto L23;
        ((Transition) r12.next()).runAnimators();
        goto L17
    }

    public TransitionSet s(Transition.TransitionListener r10) {
        return (TransitionSet) super.addListener(r10);
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean r10) {
        super.setCanRemoveViews(r10);
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).setCanRemoveViews(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long r10) {
        return H(r10);
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.f r10) {
        super.setEpicenterCallback(r10);
        this.f5017e |= 8;
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).setEpicenterCallback(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setInterpolator(TimeInterpolator r10) {
        return I(r10);
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r10) {
        super.setPathMotion(r10);
        this.f5017e |= 4;
        if (this.f5013a == null) goto L8;
        int r11 = 0;
    L6:
        if (r11 >= this.f5013a.size()) goto L10;
        ((Transition) this.f5013a.get(r11)).setPathMotion(r10);
        r11 = r11 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.transition.Transition
    public void setPropagation(q r10) {
        super.setPropagation(r10);
        this.f5017e |= 2;
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((Transition) this.f5013a.get(r12)).setPropagation(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setStartDelay(long r10) {
        return K(r10);
    }

    public TransitionSet t(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    @Override // androidx.transition.Transition
    public String toString(String r10) {
        String r11 = super.toString(r10);
        int r12 = 0;
    L4:
        if (r12 >= this.f5013a.size()) goto L6;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11);
        r13.append("\n");
        r13.append(((Transition) this.f5013a.get(r12)).toString(r10 + "  "));
        r11 = r13.toString();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public TransitionSet u(View r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    public TransitionSet v(Class r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    public TransitionSet w(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r11)).addTarget(r10);
        r11 = r11 + 1;
        goto L4
    L7:
        return (TransitionSet) super.addTarget(r10);
    }

    public TransitionSet x(Transition r10) {
        y(r10);
        long r11 = this.mDuration;
        if (r11 < 0) goto L6;
        r10.setDuration(r11);
    L6:
        if ((this.f5017e & 1) == 0) goto L9;
        r10.setInterpolator(getInterpolator());
    L9:
        if ((this.f5017e & 2) == 0) goto L12;
        r10.setPropagation(getPropagation());
    L12:
        if ((this.f5017e & 4) == 0) goto L15;
        r10.setPathMotion(getPathMotion());
    L15:
        if ((this.f5017e & 8) == 0) goto L17;
        r10.setEpicenterCallback(getEpicenterCallback());
    L17:
        return this;
    }

    public final void y(Transition r10) {
        this.f5013a.add(r10);
        r10.mParent = this;
    }

    public Transition z(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 < this.f5013a.size()) goto L7;
        return null;
    L7:
        return (Transition) this.f5013a.get(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(View r10) {
        return u(r10);
    }

    @Override // androidx.transition.Transition
    public Transition clone() {
        TransitionSet r10 = (TransitionSet) super.clone();
        r10.f5013a = new ArrayList();
        int r11 = this.f5013a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.y(((Transition) this.f5013a.get(r12)).clone());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(View r10) {
        return D(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(Class r10) {
        return v(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(Class r10) {
        return E(r10);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition addTarget(String r10) {
        return w(r10);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r12)).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition removeTarget(String r10) {
        return F(r10);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f5013a = new ArrayList();
        this.f5014b = true;
        this.f5016d = false;
        this.f5017e = 0;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f5002i);
        J(n.g.c(r12, (XmlResourceParser) r11, "transitionOrdering", 0, 0));
        r12.recycle();
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r12)).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class r10, boolean r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.f5013a.size()) goto L7;
        ((Transition) this.f5013a.get(r12)).excludeTarget(r10, r11);
        r12 = r12 + 1;
        goto L4
    L7:
        return super.excludeTarget(r10, r11);
    }
}
