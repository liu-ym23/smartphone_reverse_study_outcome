package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class FragmentTransitionCompat21 extends FragmentTransitionImpl {

    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void addListener(Transition r100, Transition.TransitionListener r101) {
            r100.addListener(r101);
        }

        public static void removeListener(Transition r100, Transition.TransitionListener r101) {
            r100.removeListener(r101);
        }
    }

    public FragmentTransitionCompat21() {
    }

    private static boolean hasSimpleTarget(Transition r100) {
        if (FragmentTransitionImpl.isNullOrEmpty(r100.getTargetIds()) == true) goto L5;
    L10:
        return true;
    L5:
        if (FragmentTransitionImpl.isNullOrEmpty(r100.getTargetNames()) == false) goto L10;
        if (FragmentTransitionImpl.isNullOrEmpty(r100.getTargetTypes()) == false) goto L10;
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object r100) {
        return r100 instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((Transition) r100).clone();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        TransitionSet r101 = new TransitionSet();
        r101.addTransition((Transition) r100);
        return r101;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object r100, View r101) {
        if (r100 == null) goto L5;
        ((Transition) r100).addTarget(r101);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object r100, ArrayList<View> r101) {
        Transition r102 = (Transition) r100;
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = 0;
        if ((r102 instanceof TransitionSet) == false) goto L11;
        TransitionSet r104 = (TransitionSet) r102;
        int r105 = r104.getTransitionCount();
    L8:
        if (r103 >= r105) goto L21;
        addTargets(r104.getTransitionAt(r103), r101);
        r103 = r103 + 1;
        goto L8
    L21:
        return;
    L11:
        if (hasSimpleTarget(r102) == false) goto L13;
        return;
    L13:
        if (FragmentTransitionImpl.isNullOrEmpty(r102.getTargets()) == false) goto L20;
        int r106 = r101.size();
    L15:
        if (r103 >= r106) goto L22;
        r102.addTarget((View) ListProtector.get(r101, r103));
        r103 = r103 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup r100, Object r101) {
        TransitionManager.beginDelayedTransition(r100, (Transition) r101);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object r100, View r101) {
        if (r100 == null) goto L5;
        ((Transition) r100).removeTarget(r101);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r100, View r101) {
        if (r101 == null) goto L5;
        final Rect r102 = new Rect();
        getBoundsOnScreen(r101, r102);
        ((Transition) r100).setEpicenterCallback(new AnonymousClass1(this, r102));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object r100, final Rect r101) {
        if (r100 == null) goto L5;
        ((Transition) r100).setEpicenterCallback(new AnonymousClass5(this, r101));
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object r100, Object r101, Object r102) {
        Transition r103 = (Transition) r100;
        Transition r104 = (Transition) r101;
        Transition r105 = (Transition) r102;
        if (r103 == null) goto L6;
        if (r104 == null) goto L6;
        r103 = new TransitionSet().addTransition(r103).addTransition(r104).setOrdering(1);
    L11:
        if (r105 == null) goto L17;
        TransitionSet r106 = new TransitionSet();
        if (r103 == null) goto L15;
        r106.addTransition(r103);
    L15:
        r106.addTransition(r105);
        return r106;
    L17:
        return r103;
    L6:
        if (r103 != null) goto L11;
        if (r104 == null) goto L10;
        r103 = r104;
        goto L11
    L10:
        r103 = null;
        goto L11
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object r100, Object r101, Object r102) {
        TransitionSet r103 = new TransitionSet();
        if (r100 == null) goto L5;
        r103.addTransition((Transition) r100);
    L5:
        if (r101 == null) goto L7;
        r103.addTransition((Transition) r101);
    L7:
        if (r102 == null) goto L9;
        r103.addTransition((Transition) r102);
    L9:
        return r103;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object r100, ArrayList<View> r101, ArrayList<View> r102) {
        Transition r103 = (Transition) r100;
        int r104 = 0;
        if ((r103 instanceof TransitionSet) == false) goto L8;
        TransitionSet r105 = (TransitionSet) r103;
        int r106 = r105.getTransitionCount();
    L5:
        if (r104 >= r106) goto L31;
        replaceTargets(r105.getTransitionAt(r104), r101, r102);
        r104 = r104 + 1;
        goto L5
    L31:
        return;
    L8:
        if (hasSimpleTarget(r103) == true) goto L23;
        List<View> r107 = r103.getTargets();
        if (r107 != null) goto L12;
        return;
    L12:
        if (r107.size() == r101.size()) goto L14;
        return;
    L14:
        if (r107.containsAll(r101) == false) goto L30;
        if (r102 != null) goto L17;
        int r108 = 0;
    L18:
        if (r104 >= r108) goto L20;
        r103.addTarget((View) ListProtector.get(r102, r104));
        r104 = r104 + 1;
        goto L18
    L20:
        int r109 = r101.size() - 1;
    L21:
        if (r109 < 0) goto L32;
        r103.removeTarget((View) ListProtector.get(r101, r109));
        r109 = r109 - 1;
        goto L21
    L32:
        return;
    L17:
        r108 = r102.size();
        goto L18
    L30:
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object r100, final View r101, final ArrayList<View> r102) {
        ((Transition) r100).addListener(new AnonymousClass2(this, r101, r102));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object r100, View r101, ArrayList<View> r102) {
        TransitionSet r103 = (TransitionSet) r100;
        List<View> r104 = r103.getTargets();
        r104.clear();
        int r105 = r102.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        FragmentTransitionImpl.bfsAddViewChildren(r104, (View) ListProtector.get(r102, r106));
        r106 = r106 + 1;
        goto L3
    L5:
        r104.add(r101);
        r102.add(r101);
        addTargets(r103, r102);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object r100, ArrayList<View> r101, ArrayList<View> r102) {
        TransitionSet r103 = (TransitionSet) r100;
        if (r103 == null) goto L6;
        r103.getTargets().clear();
        r103.getTargets().addAll(r102);
        replaceTargets(r103, r101, r102);
        return;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment r100, Object r101, CancellationSignal r102, final Runnable r103) {
        ((Transition) r101).addListener(new AnonymousClass4(this, r103));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object r110, final Object r111, final ArrayList<View> r112, final Object r113, final ArrayList<View> r114, final Object r115, final ArrayList<View> r116) {
        ((Transition) r110).addListener(new AnonymousClass3(this, r111, r112, r113, r114, r115, r116));
    }
}
