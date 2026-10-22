package androidx.compose.ui.platform;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\"\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a*\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a,\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002\u001a,\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0011j\b\u0012\u0004\u0012\u00020\u0001`\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a,\u0010\u000e\u001a\u00020\u000f*\u00020\u00012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0011j\b\u0012\u0004\u0012\u00020\u0001`\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¨\u0006\u0014"}, d2 = {"findUserSetNextFocus", "Landroid/view/View;", RootDescription.ROOT_ELEMENT, "direction", "", "findViewInsideOutShouldExist", "start", "id", "findViewByPredicateInsideOut", "predicate", "Lkotlin/Function1;", "", "findViewByPredicateTraversal", "childToSkip", "addFocusableViews", "", "views", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "inTouchMode", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FocusFinderCompat_androidKt {
    public static final /* synthetic */ void access$addFocusableViews(View r100, ArrayList r101, int r102) {
        addFocusableViews(r100, r101, r102);
    }

    public static final /* synthetic */ View access$findUserSetNextFocus(View r100, View r101, int r102) {
        return findUserSetNextFocus(r100, r101, r102);
    }

    public static final /* synthetic */ View access$findViewInsideOutShouldExist(View r100, View r101, int r102) {
        return findViewInsideOutShouldExist(r100, r101, r102);
    }

    private static final void addFocusableViews(View r110, ArrayList<View> r111, boolean r112) {
        int r100 = 0;
        boolean r101 = true;
        if (r110.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L19:
        boolean r103 = false;
    L21:
        if ((r110 instanceof ViewGroup) == false) goto L46;
        int r104 = r111.size();
        ViewGroup r105 = (ViewGroup) r110;
        if (r105.getDescendantFocusability() != 131072) goto L25;
        boolean r106 = true;
    L26:
        if (r103 == false) goto L30;
        if (r106 == false) goto L30;
        r111.add(r110);
    L30:
        if (r105.getDescendantFocusability() == 393216) goto L41;
        int r107 = r105.getChildCount();
        View[] r108 = new View[r107];
        int r109 = 0;
    L32:
        if (r109 >= r107) goto L34;
        r108[r109] = r105.getChildAt(r109);
        r109 = r109 + 1;
        goto L32
    L34:
        FocusSorter r113 = FocusSorter.INSTANCE;
        if (r105.getLayoutDirection() == 1) goto L38;
        r101 = false;
    L38:
        r113.sort(r108, r105, r101);
    L39:
        if (r100 >= r107) goto L41;
        addFocusableViews(r108[r100], r111, r112);
        r100 = r100 + 1;
    L41:
        if (r103 == false) goto L51;
        if (r106 == false) goto L44;
        return;
    L44:
        if (r104 != r111.size()) goto L53;
        r111.add(r110);
        return;
    L53:
        return;
    L51:
        return;
    L25:
        r106 = false;
        goto L26
    L46:
        if (r103 == false) goto L55;
        r111.add(r110);
        return;
    L55:
        return;
    L8:
        if (r110.isFocusable() == false) goto L19;
        if (r110.isEnabled() == false) goto L19;
        if (r110.getWidth() <= 0) goto L19;
        if (r110.getHeight() <= 0) goto L19;
        if (r112 == true) goto L17;
    L18:
        r103 = true;
        goto L21
    L17:
        if (r110.isFocusableInTouchMode() == false) goto L19;
    L5:
        r102 = false;
        goto L6
    }

    private static final View findUserSetNextFocus(final View r100, final View r101, int r102) {
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L7;
        return null;
    L7:
        int r103 = r100.getNextFocusForwardId();
        if (r103 != (-1)) goto L11;
        return null;
    L11:
        return findViewInsideOutShouldExist(r101, r100, r103);
    L13:
        if (r100.getId() != (-1)) goto L16;
        return null;
    L16:
        return findViewByPredicateInsideOut(r101, r100, new AnonymousClass1(r101, r100));
    }

    private static final View findViewByPredicateInsideOut(View r100, View r101, Function1<? super View, Boolean> r102) {
        View r103 = null;
    L3:
        View r104 = findViewByPredicateTraversal(r101, r102, r103);
        if (r104 != null) goto L14;
        if (r101 == r100) goto L14;
        Object r105 = r101.getParent();
        if (r105 == null) goto L13;
        if ((r105 instanceof View) == false) goto L13;
        View r106 = (View) r105;
        r103 = r101;
        r101 = r106;
    L13:
        return null;
    L14:
        return r104;
    }

    private static final View findViewByPredicateTraversal(View r100, Function1<? super View, Boolean> r101, View r102) {
        if (r101.invoke(r100).booleanValue() == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L21;
        View r106 = r103.getChildAt(r105);
        if (r106 == r102) goto L14;
        View r107 = findViewByPredicateTraversal(r106, r101, r102);
        if (r107 == null) goto L14;
        return r107;
    L14:
        r105 = r105 + 1;
        goto L8
    L21:
        return null;
    L15:
        return null;
    }

    private static final View findViewInsideOutShouldExist(View r100, View r101, final int r102) {
        return findViewByPredicateInsideOut(r100, r101, new C87641(r102));
    }

    private static final void addFocusableViews(View r100, ArrayList<View> r101, int r102) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        addFocusableViews(r100, r101, r100.isInTouchMode());
        return;
    L5:
        r100.addFocusables(r101, r102, r100.isInTouchMode() ? 1 : 0);
    }
}
