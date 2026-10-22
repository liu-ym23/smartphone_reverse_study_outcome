package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentTransitionImpl {
    public FragmentTransitionImpl() {
    }

    public abstract void addTarget(Object r100, View r101);

    public abstract void addTargets(Object r100, ArrayList<View> r101);

    public abstract void beginDelayedTransition(ViewGroup r100, Object r101);

    public abstract boolean canHandle(Object r100);

    public abstract Object cloneTransition(Object r100);

    public abstract Object mergeTransitionsInSequence(Object r100, Object r101, Object r102);

    public abstract Object mergeTransitionsTogether(Object r100, Object r101, Object r102);

    public abstract void removeTarget(Object r100, View r101);

    public abstract void replaceTargets(Object r100, ArrayList<View> r101, ArrayList<View> r102);

    public abstract void scheduleHideFragmentView(Object r100, View r101, ArrayList<View> r102);

    public abstract void scheduleRemoveTargets(Object r100, Object r101, ArrayList<View> r102, Object r103, ArrayList<View> r104, Object r105, ArrayList<View> r106);

    public abstract void setEpicenter(Object r100, Rect r101);

    public abstract void setEpicenter(Object r100, View r101);

    public abstract void setSharedElementTargets(Object r100, View r101, ArrayList<View> r102);

    public abstract void swapSharedElementTargets(Object r100, ArrayList<View> r101, ArrayList<View> r102);

    public abstract Object wrapTransitionInSet(Object r100);

    public static boolean isNullOrEmpty(List r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> r100) {
        ArrayList<String> r101 = new ArrayList();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        View r104 = (View) ListProtector.get(r100, r103);
        r101.add(ViewCompat.getTransitionName(r104));
        ViewCompat.setTransitionName(r104, null);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static void bfsAddViewChildren(List<View> r100, View r101) {
        int r102 = r100.size();
        if (containedBeforeIndex(r100, r101, r102) == false) goto L6;
        return;
    L6:
        if (ViewCompat.getTransitionName(r101) == null) goto L8;
        r100.add(r101);
    L8:
        int r103 = r102;
    L10:
        if (r103 >= r100.size()) goto L22;
        View r104 = (View) ListProtector.get(r100, r103);
        if ((r104 instanceof ViewGroup) == false) goto L21;
        ViewGroup r105 = (ViewGroup) r104;
        int r106 = r105.getChildCount();
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L21;
        View r108 = r105.getChildAt(r107);
        if (containedBeforeIndex(r100, r108, r102) == true) goto L20;
        if (ViewCompat.getTransitionName(r108) == null) goto L20;
        r100.add(r108);
    L20:
        r107 = r107 + 1;
    L21:
        r103 = r103 + 1;
        goto L10
    }

    public void getBoundsOnScreen(View r100, Rect r101) {
        if (ViewCompat.isAttachedToWindow(r100) == true) goto L5;
        return;
    L5:
        RectF r102 = new RectF();
        r102.set(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        r100.getMatrix().mapRect(r102);
        r102.offset(r100.getLeft(), r100.getTop());
        Object r103 = r100.getParent();
    L7:
        if ((r103 instanceof View) == false) goto L9;
        View r104 = (View) r103;
        r102.offset(-r104.getScrollX(), -r104.getScrollY());
        r104.getMatrix().mapRect(r102);
        r102.offset(r104.getLeft(), r104.getTop());
        r103 = r104.getParent();
        goto L7
    L9:
        int[] r105 = new int[2];
        r100.getRootView().getLocationOnScreen(r105);
        r102.offset(r105[0], r105[1]);
        r101.set(Math.round(r102.left), Math.round(r102.top), Math.round(r102.right), Math.round(r102.bottom));
    }

    private static boolean containedBeforeIndex(List<View> r100, View r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (ListProtector.get(r100, r103) == r101) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void setListenerForTransitionEnd(Fragment r100, Object r101, CancellationSignal r102, Runnable r103) {
        r103.run();
    }

    public void setNameOverridesReordered(View r100, final ArrayList<View> r110, final ArrayList<View> r111, final ArrayList<String> r112, Map<String, String> r113) {
        final int r101 = r111.size();
        final ArrayList r102 = new ArrayList();
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L14;
        View r104 = (View) ListProtector.get(r110, r103);
        String r105 = ViewCompat.getTransitionName(r104);
        r102.add(r105);
        if (r105 == null) goto L13;
        ViewCompat.setTransitionName(r104, null);
        String r106 = r113.get(r105);
        int r107 = 0;
    L8:
        if (r107 >= r101) goto L13;
        if (r106.equals(ListProtector.get(r112, r107)) == true) goto L11;
        r107 = r107 + 1;
        goto L8
    L11:
        ViewCompat.setTransitionName((View) ListProtector.get(r111, r107), r105);
    L13:
        r103 = r103 + 1;
        goto L3
    L14:
        OneShotPreDrawListener.add(r100, new AnonymousClass1(this, r101, r111, r112, r110, r102));
    }
}
