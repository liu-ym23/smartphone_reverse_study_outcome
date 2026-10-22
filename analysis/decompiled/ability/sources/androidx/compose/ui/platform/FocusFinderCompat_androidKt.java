package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0004\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005\u001a1\u0010\f\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000f\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0011j\b\u0012\u0004\u0012\u00020\u0000`\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0011j\b\u0012\u0004\u0012\u00020\u0000`\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/view/View;", "root", "", "direction", "findUserSetNextFocus", "(Landroid/view/View;Landroid/view/View;I)Landroid/view/View;", "start", "id", "findViewInsideOutShouldExist", "Lkotlin/Function1;", "", "predicate", "findViewByPredicateInsideOut", "(Landroid/view/View;Landroid/view/View;LS7/k;)Landroid/view/View;", "childToSkip", "findViewByPredicateTraversal", "(Landroid/view/View;LS7/k;Landroid/view/View;)Landroid/view/View;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "views", "LC7/r;", "addFocusableViews", "(Landroid/view/View;Ljava/util/ArrayList;I)V", "inTouchMode", "(Landroid/view/View;Ljava/util/ArrayList;Z)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusFinderCompat_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void addFocusableViews(View view, ArrayList<View> arrayList, int i) {
        view.addFocusables(arrayList, i, view.isInTouchMode() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View findUserSetNextFocus(final View view, final View view2, int i) {
        int nextFocusForwardId;
        if (i == 1) {
            if (view.getId() == -1) {
                return null;
            }
            return findViewByPredicateInsideOut(view2, view, new S7.k() { // from class: androidx.compose.ui.platform.FocusFinderCompat_androidKt.findUserSetNextFocus.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final Boolean invoke(View view3) {
                    return Boolean.valueOf(FocusFinderCompat_androidKt.findViewInsideOutShouldExist(view2, view3, view3.getNextFocusForwardId()) == view);
                }
            });
        }
        if (i == 2 && (nextFocusForwardId = view.getNextFocusForwardId()) != -1) {
            return findViewInsideOutShouldExist(view2, view, nextFocusForwardId);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.View findViewByPredicateInsideOut(android.view.View r4, android.view.View r5, S7.k r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            android.view.View r1 = findViewByPredicateTraversal(r5, r6, r1)
            if (r1 != 0) goto L1d
            if (r5 != r4) goto Lb
            goto L1d
        Lb:
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L1c
            boolean r2 = r1 instanceof android.view.View
            if (r2 != 0) goto L16
            goto L1c
        L16:
            android.view.View r1 = (android.view.View) r1
            r3 = r1
            r1 = r5
            r5 = r3
            goto L2
        L1c:
            return r0
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.FocusFinderCompat_androidKt.findViewByPredicateInsideOut(android.view.View, android.view.View, S7.k):android.view.View");
    }

    private static final View findViewByPredicateTraversal(View view, S7.k kVar, View view2) {
        View viewFindViewByPredicateTraversal;
        if (((Boolean) kVar.invoke(view)).booleanValue()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view2 && (viewFindViewByPredicateTraversal = findViewByPredicateTraversal(childAt, kVar, view2)) != null) {
                return viewFindViewByPredicateTraversal;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View findViewInsideOutShouldExist(View view, View view2, final int i) {
        return findViewByPredicateInsideOut(view, view2, new S7.k() { // from class: androidx.compose.ui.platform.FocusFinderCompat_androidKt.findViewInsideOutShouldExist.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(View view3) {
                return Boolean.valueOf(view3.getId() == i);
            }
        });
    }

    private static final void addFocusableViews(View view, ArrayList<View> arrayList, boolean z10) {
        boolean z11 = view.getVisibility() == 0 && view.isFocusable() && view.isEnabled() && view.getWidth() > 0 && view.getHeight() > 0 && (!z10 || view.isFocusableInTouchMode());
        if (!(view instanceof ViewGroup)) {
            if (z11) {
                arrayList.add(view);
                return;
            }
            return;
        }
        int size = arrayList.size();
        ViewGroup viewGroup = (ViewGroup) view;
        boolean z12 = viewGroup.getDescendantFocusability() == 131072;
        if (z11 && z12) {
            arrayList.add(view);
        }
        if (viewGroup.getDescendantFocusability() != 393216) {
            int childCount = viewGroup.getChildCount();
            View[] viewArr = new View[childCount];
            for (int i = 0; i < childCount; i++) {
                viewArr[i] = viewGroup.getChildAt(i);
            }
            FocusSorter.INSTANCE.sort(viewArr, viewGroup, viewGroup.getLayoutDirection() == 1);
            for (int i6 = 0; i6 < childCount; i6++) {
                addFocusableViews(viewArr[i6], arrayList, z10);
            }
        }
        if (z11 && !z12 && size == arrayList.size()) {
            arrayList.add(view);
        }
    }
}
