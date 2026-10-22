package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.g;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.p;
import c.a;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;
import x.b;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;

    @NonNull
    private SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private NavigationBarItemView[] buttons;
    private Drawable itemBackground;
    private int itemBackgroundRes;

    @Dimension
    private int itemIconSize;

    @Nullable
    private ColorStateList itemIconTint;
    private final Pools$Pool<NavigationBarItemView> itemPool;

    @StyleRes
    private int itemTextAppearanceActive;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;

    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @NonNull
    private final TransitionSet set;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public NavigationBarMenuView(@NonNull Context r10) {
        super(r10);
        this.itemPool = new Pools$SynchronizedPool(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        AutoTransition r11 = new AutoTransition();
        this.set = r11;
        r11.J(0);
        r11.H(ACTIVE_ANIMATION_DURATION_MS);
        r11.I(new b());
        r11.x(new TextScale());
        this.onClickListener = new AnonymousClass1(this);
        ViewCompat.A0(this, 1);
    }

    public static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView r10) {
        return r10.presenter;
    }

    public static /* synthetic */ MenuBuilder access$100(NavigationBarMenuView r10) {
        return r10.menu;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView r10 = this.itemPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return createNavigationBarItemView(getContext());
    }

    private boolean isValidId(int r10) {
        if (r10 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void removeUnusedBadges() {
        HashSet r10 = new HashSet();
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.menu.size()) goto L7;
        r10.add(Integer.valueOf(this.menu.getItem(r12).getItemId()));
        r12 = r12 + 1;
    L7:
        if (r11 >= this.badgeDrawables.size()) goto L12;
        int r13 = this.badgeDrawables.keyAt(r11);
        if (r10.contains(Integer.valueOf(r13)) == true) goto L11;
        this.badgeDrawables.delete(r13);
    L11:
        r11 = r11 + 1;
        goto L7
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView r10) {
        int r11 = r10.getId();
        if (isValidId(r11) == true) goto L5;
        return;
    L5:
        BadgeDrawable r12 = this.badgeDrawables.get(r11);
        if (r12 == null) goto L9;
        r10.setBadge(r12);
        return;
    }

    private void validateMenuItemId(int r10) {
        if (isValidId(r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r10 + " is not a valid view id");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L11;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        NavigationBarItemView r13 = r10[r12];
        if (r13 == null) goto L9;
        this.itemPool.release(r13);
        r13.removeBadge();
    L9:
        r12 = r12 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean r14 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r15 = 0;
    L16:
        if (r15 >= this.menu.size()) goto L26;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r15).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView r16 = getNewItem();
        this.buttons[r15] = r16;
        r16.setIconTintList(this.itemIconTint);
        r16.setIconSize(this.itemIconSize);
        r16.setTextColor(this.itemTextColorDefault);
        r16.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r16.setTextAppearanceActive(this.itemTextAppearanceActive);
        r16.setTextColor(this.itemTextColorFromUser);
        Drawable r17 = this.itemBackground;
        if (r17 == null) goto L20;
        r16.setItemBackground(r17);
    L21:
        r16.setShifting(r14);
        r16.setLabelVisibilityMode(this.labelVisibilityMode);
        g r18 = (g) this.menu.getItem(r15);
        r16.initialize(r18, 0);
        r16.setItemPosition(r15);
        int r19 = r18.getItemId();
        r16.setOnTouchListener(this.onTouchListeners.get(r19));
        r16.setOnClickListener(this.onClickListener);
        int r20 = this.selectedItemId;
        if (r20 == 0) goto L25;
        if (r19 != r20) goto L25;
        this.selectedItemPosition = r15;
    L25:
        setBadgeIfNeeded(r16);
        addView(r16);
        r15 = r15 + 1;
        goto L16
    L20:
        r16.setItemBackground(this.itemBackgroundRes);
        goto L21
    L26:
        int r21 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r21;
        this.menu.getItem(r21).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r11 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r11, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r12 = a.a(getContext(), r11.resourceId);
        if (getContext().getTheme().resolveAttribute(R$attr.colorPrimary, r11, true) == true) goto L8;
        return null;
    L8:
        int r13 = r11.data;
        int r14 = r12.getDefaultColor();
        int[] r15 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r15, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r12.getColorForState(r15, r14), r13, r14});
    }

    @NonNull
    public abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context r10);

    @Nullable
    public NavigationBarItemView findItemView(int r10) {
        validateMenuItemId(r10);
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        if (r14.getId() == r10) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return r14;
    L14:
        return null;
    L10:
        return null;
    }

    @Nullable
    public BadgeDrawable getBadge(int r10) {
        return this.badgeDrawables.get(r10);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] r10 = this.buttons;
        if (r10 == null) goto L9;
        if (r10.length <= 0) goto L9;
        return r10[0].getBackground();
    L9:
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @Nullable
    public MenuBuilder getMenu() {
        return this.menu;
    }

    public BadgeDrawable getOrCreateBadge(int r10) {
        validateMenuItemId(r10);
        BadgeDrawable r11 = this.badgeDrawables.get(r10);
        if (r11 != null) goto L5;
        r11 = BadgeDrawable.create(getContext());
        this.badgeDrawables.put(r10, r11);
    L5:
        NavigationBarItemView r12 = findItemView(r10);
        if (r12 == null) goto L8;
        r12.setBadge(r11);
    L8:
        return r11;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder r10) {
        this.menu = r10;
    }

    public boolean isShifting(int r10, int r11) {
        if (r10 == (-1)) goto L5;
        if (r10 == 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r11 > 3) goto L10;
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.B0(r10).X(AccessibilityNodeInfoCompat.b.b(1, this.menu.getVisibleItems().size(), false, 1));
    }

    public void removeBadge(int r10) {
        validateMenuItemId(r10);
        BadgeDrawable r11 = this.badgeDrawables.get(r10);
        NavigationBarItemView r12 = findItemView(r10);
        if (r12 == null) goto L5;
        r12.removeBadge();
    L5:
        if (r11 == null) goto L8;
        this.badgeDrawables.remove(r10);
        return;
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> r10) {
        this.badgeDrawables = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        NavigationBarItemView r14 = r11[r13];
        r14.setBadge(r10.get(r14.getId()));
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setIconTintList(@Nullable ColorStateList r10) {
        this.itemIconTint = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setIconTintList(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.itemBackground = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemBackground(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r10) {
        this.itemBackgroundRes = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setItemBackground(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemIconSize(@Dimension int r10) {
        this.itemIconSize = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setIconSize(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int r10, @Nullable View.OnTouchListener r11) {
        if (r11 != null) goto L4;
        this.onTouchListeners.remove(r10);
    L5:
        NavigationBarItemView[] r12 = this.buttons;
        if (r12 == null) goto L13;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L17;
        NavigationBarItemView r15 = r12[r14];
        if (r15.getItemData().getItemId() != r10) goto L12;
        r15.setOnTouchListener(r11);
    L12:
        r14 = r14 + 1;
        goto L8
    L17:
        return;
    L13:
        return;
    L4:
        this.onTouchListeners.put(r10, r11);
        goto L5
    }

    public void setItemTextAppearanceActive(@StyleRes int r10) {
        this.itemTextAppearanceActive = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        r14.setTextAppearanceActive(r10);
        ColorStateList r15 = this.itemTextColorFromUser;
        if (r15 == null) goto L9;
        r14.setTextColor(r15);
    L9:
        r13 = r13 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceInactive(@StyleRes int r10) {
        this.itemTextAppearanceInactive = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L14;
        NavigationBarItemView r14 = r11[r13];
        r14.setTextAppearanceInactive(r10);
        ColorStateList r15 = this.itemTextColorFromUser;
        if (r15 == null) goto L9;
        r14.setTextColor(r15);
    L9:
        r13 = r13 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.itemTextColorFromUser = r10;
        NavigationBarItemView[] r11 = this.buttons;
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        r11[r13].setTextColor(r10);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r10) {
        this.labelVisibilityMode = r10;
    }

    public void setPresenter(@NonNull NavigationBarPresenter r10) {
        this.presenter = r10;
    }

    public void tryRestoreSelectedItemId(int r10) {
        int r11 = this.menu.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        MenuItem r13 = this.menu.getItem(r12);
        if (r10 == r13.getItemId()) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        this.selectedItemId = r10;
        this.selectedItemPosition = r12;
        r13.setChecked(true);
        return;
    }

    public void updateMenuView() {
        MenuBuilder r10 = this.menu;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L28;
        int r11 = r10.size();
        if (r11 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r12 = this.selectedItemId;
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L18;
        MenuItem r14 = this.menu.getItem(r13);
        if (r14.isChecked() == false) goto L16;
        this.selectedItemId = r14.getItemId();
        this.selectedItemPosition = r13;
    L16:
        r13 = r13 + 1;
        goto L12
    L18:
        if (r12 == this.selectedItemId) goto L20;
        p.a(this, this.set);
    L20:
        boolean r15 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r16 = 0;
    L21:
        if (r16 >= r11) goto L29;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r16].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r16].setShifting(r15);
        this.buttons[r16].initialize((g) this.menu.getItem(r16), 0);
        this.presenter.setUpdateSuspended(false);
        r16 = r16 + 1;
        goto L21
    L29:
        return;
    }
}
