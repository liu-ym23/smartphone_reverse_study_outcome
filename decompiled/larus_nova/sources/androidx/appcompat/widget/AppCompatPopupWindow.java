package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: classes2.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    static {
        COMPAT_OVERLAP_ANCHOR = false;
    }

    public static /* synthetic */ void access$000(PopupWindow r100, View r101, int r102, int r103) {
        super.showAsDropDown(r101, r102, r103);
    }

    public static /* synthetic */ void access$001(PopupWindow r100, View r101, int r102, int r103, int r104) {
        super.showAsDropDown(r101, r102, r103, r104);
    }

    public static /* synthetic */ void access$002(PopupWindow r100, View r101, int r102, int r103, int r104, int r105) {
        super.update(r101, r102, r103, r104, r105);
    }

    private void setSupportOverlapAnchor(boolean r100) {
        if (COMPAT_OVERLAP_ANCHOR == false) goto L5;
        this.mOverlapAnchor = r100;
        return;
    L5:
        PopupWindowCompat.setOverlapAnchor(this, r100);
    }

    public AppCompatPopupWindow(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101, r102, 0);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r100, int r101, int r102) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r100, r101, r102);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r102 = r102 - r100.getHeight();
        goto L7
    }

    public AppCompatPopupWindow(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        init(r100, r101, r102, r103);
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r100, View r101, int r102, int r103) {
        OverlaySource r104 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r104) == false) goto L5;
        return;
    L5:
        access$000(r100, r101, r102, r103);
        PopupWindowLancet.trackAfterShow(r100, r104, r101);
    }

    private void init(Context r100, AttributeSet r101, int r102, int r103) {
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.popupBackground, R.attr.popupAnimationStyle, com.larus.nova.R.attr.overlapAnchor}, r102, r103);
        if (r104.hasValue(2) == false) goto L5;
        setSupportOverlapAnchor(r104.getBoolean(2, false));
    L5:
        setBackgroundDrawable(r104.getDrawable(0));
        r104.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r100, int r101, int r102, int r103) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(this, r100, r101, r102, r103);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r102 = r102 - r100.getHeight();
        goto L7
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAsDropDown(PopupWindow r100, View r101, int r102, int r103, int r104) {
        OverlaySource r105 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r105) == false) goto L5;
        return;
    L5:
        access$001(r100, r101, r102, r103, r104);
        PopupWindowLancet.trackAfterShow(r100, r105, r101);
    }

    @Override // android.widget.PopupWindow
    public void update(View r100, int r101, int r102, int r110, int r111) {
        if (COMPAT_OVERLAP_ANCHOR == true) goto L5;
    L7:
        INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(this, r100, r101, r102, r110, r111);
        return;
    L5:
        if (this.mOverlapAnchor == false) goto L7;
        r102 = r102 - r100.getHeight();
        goto L7
    }

    public static void INVOKESPECIAL_androidx_appcompat_widget_AppCompatPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r100, View r101, int r102, int r103, int r104, int r105) {
        if ((r100 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r100) == false) goto L9;
        access$002(r100, r101, r102, r103, r104, r105);
        return;
    L9:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r100, r101, r102, r103, r104, r105) == false) goto L11;
        return;
    L11:
        access$002(r100, r101, r102, r103, r104, r105);
    }
}
