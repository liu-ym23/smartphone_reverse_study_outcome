package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView this$0;

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            PopupCallback r100 = this.this$0.mPopupCallback;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            ActionMenuItemView r100 = this.this$0;
            MenuBuilder.ItemInvoker r101 = r100.mItemInvoker;
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r101.invokeItem(r100.mItemData) == false) goto L13;
            ShowableListMenu r102 = getPopup();
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r102.isShowing() == false) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }

        public ActionMenuItemForwardingListener(ActionMenuItemView r100) {
            this.this$0 = r100;
            super(r100);
        }
    }

    public static abstract class PopupCallback {
        public PopupCallback() {
        }

        public abstract ShowableListMenu getPopup();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r100, char r101) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    private void updateTextButtonVisibility() {
        boolean r100 = true;
        boolean r101 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) goto L5;
    L12:
        boolean r102 = r101 & r100;
        CharSequence r103 = null;
        if (r102 == false) goto L15;
        CharSequence r104 = this.mTitle;
    L16:
        setText(r104);
        CharSequence r105 = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(r105) == false) goto L22;
        if (r102 == false) goto L20;
        CharSequence r106 = null;
    L21:
        setContentDescription(r106);
    L23:
        CharSequence r107 = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(r107) == false) goto L29;
        if (r102 == true) goto L28;
        r103 = this.mItemData.getTitle();
    L28:
        TooltipCompat.setTooltipText(this, r103);
        return;
    L29:
        TooltipCompat.setTooltipText(this, r107);
        return;
    L20:
        r106 = this.mItemData.getTitle();
        goto L21
    L22:
        setContentDescription(r105);
        goto L23
    L15:
        r104 = null;
        goto L16
    L5:
        if (this.mItemData.showsTextAsAction() == true) goto L7;
    L11:
        r100 = false;
        goto L12
    L7:
        if (this.mAllowTextWithIcon == true) goto L12;
        if (this.mExpandedFormat == false) goto L11;
        goto L11
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration r100 = getContext().getResources().getConfiguration();
        int r101 = r100.screenWidthDp;
        int r102 = r100.screenHeightDp;
        if (r101 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r101 < 640) goto L8;
        if (r102 >= 480) goto L11;
    L8:
        if (r100.orientation == 2) goto L11;
        return false;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        if (hasText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mItemData.getIcon() != null) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public ActionMenuItemView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_ActionMenuItemView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        MenuBuilder.ItemInvoker r101 = this.mItemInvoker;
        if (r101 == null) goto L6;
        r101.invokeItem(this.mItemData);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mItemData.hasSubMenu() == false) goto L11;
        ForwardingListener r101 = this.mForwardingListener;
        if (r101 == null) goto L11;
        if (r101.onTouch(this, r100) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r100);
    }

    public void setExpandedFormat(boolean r100) {
        if (this.mExpandedFormat == r100) goto L8;
        this.mExpandedFormat = r100;
        MenuItemImpl r101 = this.mItemData;
        if (r101 == null) goto L9;
        r101.actionFormatChanged();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r100) {
        this.mIcon = r100;
        if (r100 == null) goto L11;
        int r101 = r100.getIntrinsicWidth();
        int r102 = r100.getIntrinsicHeight();
        int r103 = this.mMaxIconSize;
        if (r101 <= r103) goto L7;
        r102 = (int) (r102 * (r103 / r101));
        r101 = r103;
    L7:
        if (r102 <= r103) goto L9;
        r101 = (int) (r101 * (r103 / r102));
    L10:
        r100.setBounds(0, 0, r101, r103);
        goto L11
    L9:
        r103 = r102;
    L11:
        setCompoundDrawables(r100, null, null, null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker r100) {
        this.mItemInvoker = r100;
    }

    public void setPopupCallback(PopupCallback r100) {
        this.mPopupCallback = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r100) {
        this.mTitle = r100;
        updateTextButtonVisibility();
    }

    public ActionMenuItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r100, int r101) {
        this.mItemData = r100;
        setIcon(r100.getIcon());
        setTitle(r100.getTitleForItemView(this));
        setId(r100.getItemId());
        if (r100.isVisible() == false) goto L5;
        int r102 = 0;
    L6:
        setVisibility(r102);
        setEnabled(r100.isEnabled());
        if (r100.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.mForwardingListener != null) goto L13;
        this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        return;
    L13:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        boolean r102 = hasText();
        if (r102 == false) goto L7;
        int r103 = this.mSavedPaddingLeft;
        if (r103 < 0) goto L7;
        super.setPadding(r103, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r100, r101);
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getSize(r100);
        int r106 = getMeasuredWidth();
        if (r104 != Integer.MIN_VALUE) goto L10;
        int r107 = Math.min(r105, this.mMinWidth);
    L12:
        if (r104 != 1073741824) goto L14;
    L17:
        if (r102 == false) goto L19;
        return;
    L19:
        if (this.mIcon == null) goto L23;
        super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L23:
        return;
    L14:
        if (this.mMinWidth <= 0) goto L17;
        if (r106 >= r107) goto L17;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r107, 1073741824), r101);
        goto L17
    L10:
        r107 = this.mMinWidth;
        goto L12
    }

    public ActionMenuItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Resources r103 = r100.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.minWidth}, r102, 0);
        this.mMinWidth = r104.getDimensionPixelSize(0, 0);
        r104.recycle();
        this.mMaxIconSize = (int) ((INVOKEVIRTUAL_androidx_appcompat_view_menu_ActionMenuItemView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r103).density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r100, int r101, int r102, int r103) {
        this.mSavedPaddingLeft = r100;
        super.setPadding(r100, r101, r102, r103);
    }
}
