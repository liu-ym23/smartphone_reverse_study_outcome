package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a%\u0010\u0011\u001a\u00020\u0012*\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInteropUtils_androidKt {
    public static final Rect calculateBoundingRectRelativeTo(View view, View view2) {
        FocusInteropUtils.Companion companion = FocusInteropUtils.INSTANCE;
        view.getLocationInWindow(companion.getTempCoordinates());
        int i = companion.getTempCoordinates()[0];
        int i6 = companion.getTempCoordinates()[1];
        view2.getLocationInWindow(companion.getTempCoordinates());
        float f = i - companion.getTempCoordinates()[0];
        float f7 = i6 - companion.getTempCoordinates()[1];
        return new Rect(f, f7, view.getWidth() + f, view.getHeight() + f7);
    }

    public static final boolean requestInteropFocus(View view, Integer num, android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !viewGroup.hasFocus()) {
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return ((AndroidComposeView) view).requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    /* renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m3783toAndroidFocusDirection3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m3771equalsimpl0(i, companion.m3782getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3775getDowndhqQ8s())) {
            return 130;
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3778getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3781getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m3771equalsimpl0(i, companion.m3779getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m3771equalsimpl0(i, companion.m3780getPreviousdhqQ8s()) ? 1 : null;
    }

    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3780getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3779getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3778getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3782getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3781getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3775getDowndhqQ8s());
    }

    /* renamed from: toFocusDirection-ZmokQxo, reason: not valid java name */
    public static final FocusDirection m3784toFocusDirectionZmokQxo(KeyEvent keyEvent) {
        long jM5275getKeyZmokQxo = KeyEvent_androidKt.m5275getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.INSTANCE;
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5127getNavigatePreviousEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3780getPreviousdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5125getNavigateNextEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3779getNextdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5203getTabEK5gGoQ())) {
            return FocusDirection.m3768boximpl(KeyEvent_androidKt.m5281isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m3780getPreviousdhqQ8s() : FocusDirection.INSTANCE.m3779getNextdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5044getDirectionRightEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3781getRightdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5043getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3778getLeftdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5045getDirectionUpEK5gGoQ()) || Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5156getPageUpEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3782getUpdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5040getDirectionDownEK5gGoQ()) || Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5155getPageDownEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3775getDowndhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5039getDirectionCenterEK5gGoQ()) || Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5053getEnterEK5gGoQ()) || Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5145getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3776getEnterdhqQ8s());
        }
        if (Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m4982getBackEK5gGoQ()) || Key.m4967equalsimpl0(jM5275getKeyZmokQxo, companion.m5056getEscapeEK5gGoQ())) {
            return FocusDirection.m3768boximpl(FocusDirection.INSTANCE.m3777getExitdhqQ8s());
        }
        return null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }
}
