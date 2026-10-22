package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuItem implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresActionButton() {
        return true;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean requiresOverflow() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int r100) {
    }

    private void applyIconTint() {
        Drawable r100 = this.mIconDrawable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mHasIconTint == false) goto L7;
    L8:
        Drawable r101 = DrawableCompat.wrap(r100);
        this.mIconDrawable = r101;
        Drawable r102 = r101.mutate();
        this.mIconDrawable = r102;
        if (this.mHasIconTint == false) goto L12;
        DrawableCompat.setTintList(r102, this.mIconTintList);
    L12:
        if (this.mHasIconTintMode == false) goto L17;
        DrawableCompat.setTintMode(this.mIconDrawable, this.mIconTintMode);
        return;
    L17:
        return;
    L7:
        if (this.mHasIconTintMode == true) goto L8;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence r100 = this.mTitleCondensed;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.mTitle;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener r100 = this.mClickListener;
        if (r100 != null) goto L5;
    L7:
        Intent r101 = this.mIntent;
        if (r101 == null) goto L11;
        this.mContext.startActivity(r101);
        return true;
    L11:
        return false;
    L5:
        if (r100.onMenuItemClick(this) == false) goto L7;
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) == 0) goto L5;
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

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.mFlags & 8) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mIconDrawable;
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
    public int getItemId() {
        return this.mId;
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
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char r100) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean r100) {
        int r101 = this.mFlags & (-2);
        this.mFlags = (r100 ? 1 : 0) | r101;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean r100) {
        int r101 = this.mFlags & (-3);
        if (r100 == false) goto L5;
        int r102 = 2;
    L6:
        this.mFlags = r102 | r101;
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence r100) {
        return setContentDescription(r100);
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean r100) {
        int r101 = this.mFlags & (-17);
        if (r100 == false) goto L5;
        int r102 = 16;
    L6:
        this.mFlags = r102 | r101;
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public ActionMenuItem setExclusiveCheckable(boolean r100) {
        int r101 = this.mFlags & (-5);
        if (r100 == false) goto L5;
        int r102 = 4;
    L6:
        this.mFlags = r102 | r101;
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int r100) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, r100);
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList r100) {
        this.mIconTintList = r100;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode r100) {
        this.mIconTintMode = r100;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent r100) {
        this.mIntent = r100;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char r100) {
        this.mShortcutNumericChar = r100;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener r100) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener r100) {
        this.mClickListener = r100;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int r100) {
        return setShowAsActionFlags(r100);
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(ActionProvider r100) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int r100) {
        this.mTitle = this.mContext.getResources().getString(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence r100) {
        this.mTitleCondensed = r100;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence r100) {
        return setTooltipText(r100);
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean r100) {
        int r101 = 8;
        int r102 = this.mFlags & 8;
        if (r100 == false) goto L5;
        r101 = 0;
    L5:
        this.mFlags = r102 | r101;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setActionView(View r100) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setContentDescription(CharSequence r100) {
        this.mContentDescription = r100;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable r100) {
        this.mIconDrawable = r100;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setShowAsActionFlags(int r100) {
        setShowAsAction(r100);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence r100) {
        this.mTitle = r100;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public SupportMenuItem setTooltipText(CharSequence r100) {
        this.mTooltipText = r100;
        return this;
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
        this.mShortcutAlphabeticChar = Character.toLowerCase(r100);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r101);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char r100, int r101) {
        this.mShortcutNumericChar = r100;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r101);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101) {
        this.mShortcutNumericChar = r100;
        this.mShortcutAlphabeticChar = Character.toLowerCase(r101);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char r100, char r101, int r102, int r103) {
        this.mShortcutNumericChar = r100;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(r102);
        this.mShortcutAlphabeticChar = Character.toLowerCase(r101);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(r103);
        return this;
    }

    public ActionMenuItem(Context r100, int r101, int r102, int r103, int r104, CharSequence r105) {
        this.mShortcutNumericModifiers = 4096;
        this.mShortcutAlphabeticModifiers = 4096;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mFlags = 16;
        this.mContext = r100;
        this.mId = r102;
        this.mGroup = r101;
        this.mOrdering = r104;
        this.mTitle = r105;
    }
}
