package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class MenuPopupHelper implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener r100 = this.mOnDismissListener;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    private MenuPopup createPopup() {
        Display r100 = ((WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r101 = new Point();
        r100.getRealSize(r101);
        if (Math.min(r101.x, r101.y) < this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        MenuPopup r103 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
    L9:
        r103.addMenu(this.mMenu);
        r103.setOnDismissListener(this.mInternalOnDismissListener);
        r103.setAnchorView(this.mAnchorView);
        r103.setCallback(this.mPresenterCallback);
        r103.setForceShowIcon(this.mForceShowIcon);
        r103.setGravity(this.mDropDownGravity);
        return r103;
    L8:
        r103 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public MenuPopup getPopup() {
        if (this.mPopup != null) goto L6;
        this.mPopup = createPopup();
    L6:
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup r100 = this.mPopup;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L8;
        return false;
    L8:
        showPopup(0, 0, false, false);
        return true;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuPopupHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void setAnchorView(View r100) {
        this.mAnchorView = r100;
    }

    public void setForceShowIcon(boolean r100) {
        this.mForceShowIcon = r100;
        MenuPopup r101 = this.mPopup;
        if (r101 == null) goto L6;
        r101.setForceShowIcon(r100);
        return;
    }

    public void setGravity(int r100) {
        this.mDropDownGravity = r100;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.Callback r100) {
        this.mPresenterCallback = r100;
        MenuPopup r101 = this.mPopup;
        if (r101 == null) goto L6;
        r101.setCallback(r100);
        return;
    }

    public MenuPopupHelper(Context r100, MenuBuilder r101) {
        this(r100, r101, null, false, R.attr.popupMenuStyle, 0);
    }

    public void show(int r100, int r101) {
        if (tryShow(r100, r101) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow(int r100, int r101) {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mAnchorView != null) goto L9;
        return false;
    L9:
        showPopup(r100, r101, true, true);
        return true;
    }

    public MenuPopupHelper(Context r100, MenuBuilder r101, View r110) {
        this(r100, r101, r110, false, R.attr.popupMenuStyle, 0);
    }

    private void showPopup(int r100, int r101, boolean r102, boolean r103) {
        MenuPopup r104 = getPopup();
        r104.setShowTitle(r103);
        if (r102 == true) goto L5;
    L8:
        r104.show();
        return;
    L5:
        if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L7;
        r100 = r100 - this.mAnchorView.getWidth();
    L7:
        r104.setHorizontalOffset(r100);
        r104.setVerticalOffset(r101);
        int r105 = (int) ((INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuPopupHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density * 48.0f) / 2.0f);
        r104.setEpicenterBounds(new Rect(r100 - r105, r101 - r105, r100 + r105, r101 + r105));
        goto L8
    }

    public MenuPopupHelper(Context r100, MenuBuilder r101, View r110, boolean r111, int r112) {
        this(r100, r101, r110, r111, r112, 0);
    }

    public MenuPopupHelper(Context r100, MenuBuilder r101, View r102, boolean r103, int r104, int r105) {
        this.mDropDownGravity = GravityCompat.START;
        this.mInternalOnDismissListener = new AnonymousClass1(this);
        this.mContext = r100;
        this.mMenu = r101;
        this.mAnchorView = r102;
        this.mOverflowOnly = r103;
        this.mPopupStyleAttr = r104;
        this.mPopupStyleRes = r105;
    }
}
