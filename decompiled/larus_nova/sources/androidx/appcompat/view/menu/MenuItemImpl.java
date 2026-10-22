package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private int mIconResId;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L6;
        return false;
    L6:
        if (this.mActionView != null) goto L9;
        return true;
    L9:
        MenuItem.OnActionExpandListener r100 = this.mOnActionExpandListener;
        if (r100 == null) goto L16;
        if (r100.onMenuItemActionCollapse(this) == true) goto L16;
        return false;
    L16:
        return this.mMenu.collapseItemActionView(this);
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View r100 = this.mActionView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ActionProvider r101 = this.mActionProvider;
        if (r101 == null) goto L9;
        View r102 = r101.onCreateActionView(this);
        this.mActionView = r102;
        return r102;
    L9:
        return null;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable r100 = this.mIconDrawable;
        if (r100 == null) goto L7;
        return applyIconTintIfNecessary(r100);
    L7:
        if (this.mIconResId == 0) goto L10;
        Drawable r101 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = r101;
        return applyIconTintIfNecessary(r101);
    L10:
        return null;
    }

    public char getShortcut() {
        if (this.mMenu.isQwertyMode() == false) goto L6;
        return this.mShortcutAlphabeticChar;
    L6:
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r100 = this.mTitleCondensed;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.mTitle;
    }

    public boolean hasCollapsibleActionView() {
        if ((this.mShowAsAction & 8) != 0) goto L5;
        return false;
    L5:
        if (this.mActionView != null) goto L10;
        ActionProvider r100 = this.mActionProvider;
        if (r100 == null) goto L10;
        this.mActionView = r100.onCreateActionView(this);
    L10:
        if (this.mActionView == null) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.mSubMenu == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r100 = this.mClickListener;
        if (r100 != null) goto L5;
    L7:
        MenuBuilder r101 = this.mMenu;
        if (r101.dispatchMenuItemSelected(r101, this) == false) goto L10;
        return true;
    L10:
        Runnable r102 = this.mItemCallback;
        if (r102 == null) goto L15;
        r102.run();
        return true;
    L15:
        if (this.mIntent != null) goto L26;
    L19:
        ActionProvider r103 = this.mActionProvider;
        if (r103 != null) goto L22;
        return false;
    L22:
        if (r103.onPerformDefaultAction() == false) goto L28;
        return true;
    L28:
        return false;
    L26:
        this.mMenu.getContext().startActivity(this.mIntent);     // Catch: ActivityNotFoundException -> L18
        return true;
    L5:
        if (r100.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    public boolean isActionButton() {
        if ((this.mFlags & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.mFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.mFlags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider r100 = this.mActionProvider;
        if (r100 == null) goto L14;
        if (r100.overridesItemVisibility() == false) goto L14;
        if ((this.mFlags & 8) == 0) goto L9;
    L11:
        return false;
    L9:
        if (this.mActionProvider.isVisible() == false) goto L11;
        return true;
    L14:
        if ((this.mFlags & 8) == 0) goto L19;
        return false;
    L19:
        return true;
    }

    public boolean requestsActionButton() {
        if ((this.mShowAsAction & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        if ((this.mShowAsAction & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean shouldShowShortcut() {
        if (this.mMenu.isShortcutsVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (getShortcut() == 0) goto L7;
        return true;
    }

    public boolean showsTextAsAction() {
        if ((this.mShowAsAction & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        CharSequence r100 = this.mTitle;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (hasCollapsibleActionView() == true) goto L5;
        return false;
    L5:
        MenuItem.OnActionExpandListener r100 = this.mOnActionExpandListener;
        if (r100 == null) goto L12;
        if (r100.onMenuItemActionExpand(this) == true) goto L12;
        return false;
    L12:
        return this.mMenu.expandItemActionView(this);
    }

    public String getShortcutLabel() {
        char r100 = getShortcut();
        if (r100 != 0) goto L6;
        return "";
    L6:
        Resources r101 = this.mMenu.getContext().getResources();
        StringBuilder r102 = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey() == false) goto L10;
        r102.append(r101.getString(R.string.abc_prepend_shortcut_label));
    L10:
        if (this.mMenu.isQwertyMode() == false) goto L12;
        int r103 = this.mShortcutAlphabeticModifiers;
    L13:
        appendModifier(r102, r103, 65536, r101.getString(R.string.abc_menu_meta_shortcut_label));
        appendModifier(r102, r103, 4096, r101.getString(R.string.abc_menu_ctrl_shortcut_label));
        appendModifier(r102, r103, 2, r101.getString(R.string.abc_menu_alt_shortcut_label));
        appendModifier(r102, r103, 1, r101.getString(R.string.abc_menu_shift_shortcut_label));
        appendModifier(r102, r103, 4, r101.getString(R.string.abc_menu_sym_shortcut_label));
        appendModifier(r102, r103, 8, r101.getString(R.string.abc_menu_function_shortcut_label));
        if (r100 != '\b') goto L16;
        r102.append(r101.getString(R.string.abc_menu_delete_shortcut_label));
    L24:
        return r102.toString();
    L16:
        if (r100 != '\n') goto L18;
        r102.append(r101.getString(R.string.abc_menu_enter_shortcut_label));
        goto L24
    L18:
        if (r100 == ' ') goto L20;
        r102.append(r100);
        goto L24
    L20:
        r102.append(r101.getString(R.string.abc_menu_space_shortcut_label));
        goto L24
    L12:
        r103 = this.mShortcutNumericModifiers;
        goto L13
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        if (requiresActionButton() == false) goto L5;
    L7:
        return false;
    L5:
        if (requestsActionButton() == true) goto L7;
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public Runnable getCallback() {
        return this.mItemCallback;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    private Drawable applyIconTintIfNecessary(Drawable r100) {
        if (r100 != null) goto L4;
    L16:
        return r100;
    L4:
        if (this.mNeedToApplyIconTint == false) goto L16;
        if (this.mHasIconTint == false) goto L8;
    L9:
        r100 = DrawableCompat.wrap(r100).mutate();
        if (this.mHasIconTint == false) goto L13;
        DrawableCompat.setTintList(r100, this.mIconTintList);
    L13:
        if (this.mHasIconTintMode == false) goto L15;
        DrawableCompat.setTintMode(r100, this.mIconTintMode);
    L15:
        this.mNeedToApplyIconTint = false;
        goto L16
    L8:
        if (this.mHasIconTintMode == false) goto L16;
        goto L9
    }

    public CharSequence getTitleForItemView(MenuView.ItemView r100) {
        if (r100 == null) goto L7;
        if (r100.prefersCondensedTitle() == false) goto L7;
        return getTitleCondensed();
    L7:
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r100) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View r100) {
        this.mActionView = r100;
        this.mActionProvider = null;
        if (r100 != null) goto L5;
    L9:
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    L5:
        if (r100.getId() != (-1)) goto L9;
        int r101 = this.mId;
        if (r101 <= 0) goto L9;
        r100.setId(r101);
        goto L9
    }

    public void setActionViewExpanded(boolean r100) {
        this.mIsActionViewExpanded = r100;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r100) {
        if (this.mShortcutAlphabeticChar != r100) goto L5;
        return this;
    L5:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r100);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable r100) {
        this.mItemCallback = r100;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r100) {
        int r101 = this.mFlags;
        int r102 = r100 ? 1 : 0;
        int r103 = r102 | (r101 & (-2));
        this.mFlags = r103;
        if (r101 == r103) goto L5;
        this.mMenu.onItemsChanged(false);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r100) {
        if ((this.mFlags & 4) == 0) goto L5;
        this.mMenu.setExclusiveItemChecked(this);
    L6:
        return this;
    L5:
        setCheckedInt(r100);
        goto L6
    }

    public void setCheckedInt(boolean r100) {
        int r101 = this.mFlags;
        int r102 = r101 & (-3);
        if (r100 == false) goto L5;
        int r103 = 2;
    L6:
        int r104 = r103 | r102;
        this.mFlags = r104;
        if (r101 == r104) goto L10;
        this.mMenu.onItemsChanged(false);
        return;
    L10:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence r100) {
        this.mContentDescription = r100;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r100) {
        if (r100 == false) goto L4;
        this.mFlags |= 16;
    L5:
        this.mMenu.onItemsChanged(false);
        return this;
    L4:
        this.mFlags &= -17;
        goto L5
    }

    public void setExclusiveCheckable(boolean r100) {
        int r101 = this.mFlags & (-5);
        if (r100 == false) goto L5;
        int r102 = 4;
    L6:
        this.mFlags = r102 | r101;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r100) {
        this.mIconDrawable = null;
        this.mIconResId = r100;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r100) {
        this.mIconTintList = r100;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r100) {
        this.mIconTintMode = r100;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r100) {
        this.mIntent = r100;
        return this;
    }

    public void setIsActionButton(boolean r100) {
        if (r100 == false) goto L4;
        this.mFlags |= 32;
        return;
    L4:
        this.mFlags &= -33;
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo r100) {
        this.mMenuInfo = r100;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r100) {
        if (this.mShortcutNumericChar != r100) goto L5;
        return this;
    L5:
        this.mShortcutNumericChar = r100;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r100) {
        this.mOnActionExpandListener = r100;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r100) {
        this.mClickListener = r100;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r100) {
        int r101 = r100 & 3;
        if (r101 != 0) goto L5;
    L11:
        this.mShowAsAction = r100;
        this.mMenu.onItemActionRequestChanged(this);
        return;
    L5:
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L11;
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r100) {
        return setShowAsActionFlags(r100);
    }

    public void setSubMenu(SubMenuBuilder r100) {
        this.mSubMenu = r100;
        r100.setHeaderTitle(getTitle());
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider r100) {
        ActionProvider r101 = this.mActionProvider;
        if (r101 == null) goto L5;
        r101.reset();
    L5:
        this.mActionView = null;
        this.mActionProvider = r100;
        this.mMenu.onItemsChanged(true);
        ActionProvider r102 = this.mActionProvider;
        if (r102 == null) goto L8;
        r102.setVisibilityListener(new AnonymousClass1(this));
    L8:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r100) {
        this.mTitle = r100;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder r101 = this.mSubMenu;
        if (r101 == null) goto L5;
        r101.setHeaderTitle(r100);
    L5:
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r100) {
        this.mTitleCondensed = r100;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence r100) {
        this.mTooltipText = r100;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r100) {
        if (setVisibleInt(r100) == false) goto L5;
        this.mMenu.onItemVisibleChanged(this);
    L5:
        return this;
    }

    public boolean setVisibleInt(boolean r100) {
        int r101 = this.mFlags;
        int r102 = r101 & (-9);
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        int r104 = r103 | r102;
        this.mFlags = r104;
        if (r101 == r104) goto L10;
        return true;
    L10:
        return false;
    L5:
        r103 = 8;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int r100) {
        Context r101 = this.mMenu.getContext();
        setActionView(LayoutInflater.from(r101).inflate(r100, new LinearLayout(r101), false));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r100) {
        return setContentDescription(r100);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r100) {
        this.mIconResId = 0;
        this.mIconDrawable = r100;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int r100) {
        setShowAsAction(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r100) {
        return setTitle(this.mMenu.getContext().getString(r100));
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r100) {
        return setTooltipText(r100);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int r100) {
        return setActionView(r100);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View r100) {
        return setActionView(r100);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r100, int r101) {
        if (this.mShortcutAlphabeticChar == r100) goto L5;
    L7:
        this.mShortcutAlphabeticChar = Character.toLowerCase(r100);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r101);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutAlphabeticModifiers != r101) goto L7;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char r100, int r101) {
        if (this.mShortcutNumericChar == r100) goto L5;
    L7:
        this.mShortcutNumericChar = r100;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r101);
        this.mMenu.onItemsChanged(false);
        return this;
    L5:
        if (this.mShortcutNumericModifiers != r101) goto L7;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101) {
        this.mShortcutNumericChar = r100;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r101);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    private static void appendModifier(StringBuilder r100, int r101, int r102, String r103) {
        if ((r101 & r102) != r102) goto L6;
        r100.append(r103);
        return;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101, int r102, int r103) {
        this.mShortcutNumericChar = r100;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r102);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r101);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r103);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItemImpl(MenuBuilder r100, int r101, int r102, int r103, int r104, CharSequence r105, int r106) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mIsActionViewExpanded = false;
        this.mMenu = r100;
        this.mId = r102;
        this.mGroup = r101;
        this.mCategoryOrder = r103;
        this.mOrdering = r104;
        this.mTitle = r105;
        this.mShowAsAction = r106;
    }
}
