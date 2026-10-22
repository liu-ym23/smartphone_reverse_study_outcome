package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = null;
    private ArrayList<MenuItemImpl> mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mNonActionItems;
    private boolean mOptionalIconsVisible;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented;
    private ArrayList<MenuItemImpl> mTempShortcutItemList;
    private ArrayList<MenuItemImpl> mVisibleItems;

    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder r100, MenuItem r101);

        void onMenuModeChange(MenuBuilder r100);
    }

    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl r100);
    }

    static {
        sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented == false) goto L6;
        this.mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        return;
    }

    public void changeMenuMode() {
        Callback r100 = this.mCallback;
        if (r100 == null) goto L6;
        r100.onMenuModeChange(this);
        return;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl r100 = this.mExpandedItem;
        if (r100 == null) goto L5;
        collapseItemActionView(r100);
    L5:
        this.mItems.clear();
        onItemsChanged(true);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (this.mIsVisibleItemsStale == false) goto L5;
        this.mVisibleItems.clear();
        int r100 = this.mItems.size();
        int r101 = 0;
    L7:
        if (r101 >= r100) goto L12;
        MenuItemImpl r102 = (MenuItemImpl) ListProtector.get(this.mItems, r101);
        if (r102.isVisible() == false) goto L11;
        this.mVisibleItems.add(r102);
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    L5:
        return this.mVisibleItems;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems == false) goto L5;
        return true;
    L5:
        int r100 = size();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L11;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r101)).isVisible() == true) goto L9;
        r101 = r101 + 1;
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged == true) goto L6;
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        return;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> r100 = getVisibleItems();
        if (this.mIsActionItemsStale == true) goto L5;
        return;
    L5:
        Iterator<WeakReference<MenuPresenter>> r101 = this.mPresenters.iterator();
        boolean r102 = false;
    L7:
        if (r101.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r103 = r101.next();
        MenuPresenter r104 = r103.get();
        if (r104 == null) goto L10;
        r102 = r102 | r104.flagActionItems();
        goto L7
    L10:
        this.mPresenters.remove(r103);
        goto L7
    L12:
        if (r102 == false) goto L20;
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        int r105 = r100.size();
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L21;
        MenuItemImpl r107 = (MenuItemImpl) ListProtector.get(r100, r106);
        if (r107.isActionButton() == false) goto L18;
        this.mActionItems.add(r107);
    L19:
        r106 = r106 + 1;
        goto L14
    L18:
        this.mNonActionItems.add(r107);
    L21:
        this.mIsActionItemsStale = false;
        return;
    L20:
        this.mActionItems.clear();
        this.mNonActionItems.clear();
        this.mNonActionItems.addAll(getVisibleItems());
        goto L21
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public MenuBuilder(Context r100) {
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = r100;
        this.mResources = r100.getResources();
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private void dispatchPresenterUpdate(boolean r100) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r101 = this.mPresenters.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r102 = r101.next();
        MenuPresenter r103 = r102.get();
        if (r103 == null) goto L10;
        r103.updateMenuView(r100);
        goto L7
    L10:
        this.mPresenters.remove(r102);
        goto L7
    L12:
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle r100) {
        SparseArray r101 = r100.getSparseParcelableArray(PRESENTER_KEY);
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mPresenters.isEmpty() == true) goto L29;
        Iterator<WeakReference<MenuPresenter>> r102 = this.mPresenters.iterator();
    L9:
        if (r102.hasNext() == false) goto L30;
        WeakReference<MenuPresenter> r103 = r102.next();
        MenuPresenter r104 = r103.get();
        if (r104 == null) goto L12;
        int r105 = r104.getId();
        if (r105 <= 0) goto L9;
        Parcelable r106 = (Parcelable) r101.get(r105);
        if (r106 == null) goto L9;
        r104.onRestoreInstanceState(r106);
        goto L9
    L12:
        this.mPresenters.remove(r103);
        goto L9
    L30:
        return;
    }

    private void dispatchSaveInstanceState(Bundle r100) {
        if (this.mPresenters.isEmpty() == false) goto L5;
        return;
    L5:
        SparseArray<? extends Parcelable> r101 = new SparseArray();
        Iterator<WeakReference<MenuPresenter>> r102 = this.mPresenters.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        WeakReference<MenuPresenter> r103 = r102.next();
        MenuPresenter r104 = r103.get();
        if (r104 == null) goto L10;
        int r105 = r104.getId();
        if (r105 <= 0) goto L7;
        Parcelable r106 = r104.onSaveInstanceState();
        if (r106 == null) goto L7;
        r101.put(r105, r106);
        goto L7
    L10:
        this.mPresenters.remove(r103);
        goto L7
    L16:
        r100.putSparseParcelableArray(PRESENTER_KEY, r101);
    }

    private static int getOrdering(int r100) {
        int r101 = ((-65536) & r100) >> 16;
        if (r101 < 0) goto L9;
        int[] r102 = sCategoryToOrder;
        if (r101 >= r102.length) goto L9;
        int r103 = r100 & 65535;
        return r103 | (r102[r101] << 16);
    L9:
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void setShortcutsVisibleInner(boolean r100) {
        if (r100 == false) goto L8;
        boolean r101 = true;
        if (this.mResources.getConfiguration().keyboard == 1) goto L8;
        if (ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext) == false) goto L8;
    L9:
        this.mShortcutsVisible = r101;
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // android.view.Menu
    public MenuItem add(int r100) {
        return addInternal(0, 0, 0, this.mResources.getString(r100));
    }

    public void addMenuPresenter(MenuPresenter r100) {
        addMenuPresenter(r100, this.mContext);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100) {
        return addSubMenu(0, 0, 0, this.mResources.getString(r100));
    }

    public final void close(boolean r100) {
        if (this.mIsClosing == false) goto L5;
        return;
    L5:
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> r101 = this.mPresenters.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        WeakReference<MenuPresenter> r102 = r101.next();
        MenuPresenter r103 = r102.get();
        if (r103 == null) goto L10;
        r103.onCloseMenu(this, r100);
        goto L7
    L10:
        this.mPresenters.remove(r102);
        goto L7
    L12:
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl r100) {
        boolean r101 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
    L18:
        return r101;
    L5:
        if (this.mExpandedItem != r100) goto L18;
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r102 = this.mPresenters.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r103 = r102.next();
        MenuPresenter r104 = r103.get();
        if (r104 == null) goto L12;
        r101 = r104.collapseItemActionView(this, r100);
        if (r101 == false) goto L9;
    L12:
        this.mPresenters.remove(r103);
    L15:
        startDispatchingItemsChanged();
        if (r101 == false) goto L18;
        this.mExpandedItem = null;
        goto L18
    }

    public boolean expandItemActionView(MenuItemImpl r100) {
        boolean r101 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> r102 = this.mPresenters.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        WeakReference<MenuPresenter> r103 = r102.next();
        MenuPresenter r104 = r103.get();
        if (r104 == null) goto L10;
        r101 = r104.expandItemActionView(this, r100);
        if (r101 == false) goto L7;
    L10:
        this.mPresenters.remove(r103);
    L13:
        startDispatchingItemsChanged();
        if (r101 == false) goto L16;
        this.mExpandedItem = r100;
    L16:
        return r101;
    }

    public int findGroupIndex(int r100) {
        return findGroupIndex(r100, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        MenuItemImpl r103 = (MenuItemImpl) ListProtector.get(this.mItems, r102);
        if (r103.getItemId() == r100) goto L6;
        if (r103.hasSubMenu() == false) goto L12;
        MenuItem r104 = r103.getSubMenu().findItem(r100);
        if (r104 == null) goto L12;
        return r104;
    L12:
        r102 = r102 + 1;
        goto L3
    L6:
        return r103;
    L13:
        return null;
    }

    public int findItemIndex(int r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r102)).getItemId() == r100) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int r100) {
        return (MenuItem) ListProtector.get(this.mItems, r100);
    }

    public void onItemActionRequestChanged(MenuItemImpl r100) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(MenuItemImpl r100) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean r100) {
        if (this.mPreventDispatchingItemsChanged == true) goto L7;
        if (r100 == false) goto L6;
        this.mIsVisibleItemsStale = true;
        this.mIsActionItemsStale = true;
    L6:
        dispatchPresenterUpdate(r100);
        return;
    L7:
        this.mItemsChangedWhileDispatchPrevented = true;
        if (r100 == false) goto L12;
        this.mStructureChangedWhileDispatchPrevented = true;
        return;
    }

    @Override // android.view.Menu
    public void removeGroup(int r100) {
        int r101 = findGroupIndex(r100);
        if (r101 < 0) goto L14;
        int r102 = this.mItems.size() - r101;
        int r103 = 0;
    L5:
        int r104 = r103 + 1;
        if (r103 >= r102) goto L10;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r101)).getGroupId() != r100) goto L10;
        removeItemAtInt(r101, false);
        r103 = r104;
    L10:
        onItemsChanged(true);
        return;
    }

    @Override // android.view.Menu
    public void removeItem(int r100) {
        removeItemAtInt(findItemIndex(r100), true);
    }

    public void removeItemAt(int r100) {
        removeItemAtInt(r100, true);
    }

    public void removeMenuPresenter(MenuPresenter r100) {
        Iterator<WeakReference<MenuPresenter>> r101 = this.mPresenters.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        WeakReference<MenuPresenter> r102 = r101.next();
        MenuPresenter r103 = r102.get();
        if (r103 == null) goto L8;
        if (r103 != r100) goto L4;
    L8:
        this.mPresenters.remove(r102);
        goto L4
    }

    public void restoreActionViewStates(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SparseArray<Parcelable> r101 = r100.getSparseParcelableArray(getActionViewStatesKey());
        int r102 = size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L15;
        MenuItem r104 = getItem(r103);
        View r105 = r104.getActionView();
        if (r105 == null) goto L12;
        if (r105.getId() == (-1)) goto L12;
        r105.restoreHierarchyState(r101);
    L12:
        if (r104.hasSubMenu() == false) goto L14;
        ((SubMenuBuilder) r104.getSubMenu()).restoreActionViewStates(r100);
    L14:
        r103 = r103 + 1;
        goto L5
    L15:
        int r106 = r100.getInt(EXPANDED_ACTION_VIEW_ID);
        if (r106 <= 0) goto L24;
        MenuItem r107 = findItem(r106);
        if (r107 == null) goto L25;
        r107.expandActionView();
        return;
    L25:
        return;
    }

    public void restorePresenterStates(Bundle r100) {
        dispatchRestoreInstanceState(r100);
    }

    public void saveActionViewStates(Bundle r100) {
        int r101 = size();
        SparseArray<? extends Parcelable> r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L17;
        MenuItem r104 = getItem(r103);
        View r105 = r104.getActionView();
        if (r105 == null) goto L14;
        if (r105.getId() == (-1)) goto L14;
        if (r102 != null) goto L10;
        r102 = new SparseArray();
    L10:
        r105.saveHierarchyState(r102);
        if (r104.isActionViewExpanded() == false) goto L14;
        r100.putInt(EXPANDED_ACTION_VIEW_ID, r104.getItemId());
    L14:
        if (r104.hasSubMenu() == false) goto L16;
        ((SubMenuBuilder) r104.getSubMenu()).saveActionViewStates(r100);
    L16:
        r103 = r103 + 1;
        goto L3
    L17:
        if (r102 == null) goto L23;
        r100.putSparseParcelableArray(getActionViewStatesKey(), r102);
        return;
    }

    public void savePresenterStates(Bundle r100) {
        dispatchSaveInstanceState(r100);
    }

    public void setCallback(Callback r100) {
        this.mCallback = r100;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo r100) {
        this.mCurrentMenuInfo = r100;
    }

    public MenuBuilder setDefaultShowAsAction(int r100) {
        this.mDefaultShowAsAction = r100;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem r100) {
        int r101 = r100.getGroupId();
        int r102 = this.mItems.size();
        stopDispatchingItemsChanged();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        MenuItemImpl r104 = (MenuItemImpl) ListProtector.get(this.mItems, r103);
        if (r104.getGroupId() != r101) goto L16;
        if (r104.isExclusiveCheckable() == false) goto L16;
        if (r104.isCheckable() == false) goto L16;
        if (r104 != r100) goto L14;
        boolean r105 = true;
    L15:
        r104.setCheckedInt(r105);
        goto L16
    L14:
        r105 = false;
    L16:
        r103 = r103 + 1;
        goto L3
    L17:
        startDispatchingItemsChanged();
    }

    @Override // androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r100) {
        this.mGroupDividerEnabled = r100;
    }

    public MenuBuilder setHeaderIconInt(int r100) {
        setHeaderInternal(0, null, r100, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int r100) {
        setHeaderInternal(r100, null, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View r100) {
        setHeaderInternal(0, null, 0, null, r100);
        return this;
    }

    public void setOptionalIconsVisible(boolean r100) {
        this.mOptionalIconsVisible = r100;
    }

    public void setOverrideVisibleItems(boolean r100) {
        this.mOverrideVisibleItems = r100;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean r100) {
        this.mQwertyMode = r100;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean r100) {
        if (this.mShortcutsVisible != r100) goto L5;
        return;
    L5:
        setShortcutsVisibleInner(r100);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence r100) {
        return addInternal(0, 0, 0, r100);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence r100) {
        return addSubMenu(0, 0, 0, r100);
    }

    public MenuBuilder setHeaderIconInt(Drawable r100) {
        setHeaderInternal(0, null, 0, r100, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence r100) {
        setHeaderInternal(0, r100, 0, null, null);
        return this;
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder r100, MenuPresenter r101) {
        boolean r102 = false;
        if (this.mPresenters.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r101 == null) goto L7;
        r102 = r101.onSubMenuSelected(r100);
    L7:
        Iterator<WeakReference<MenuPresenter>> r103 = this.mPresenters.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        WeakReference<MenuPresenter> r104 = r103.next();
        MenuPresenter r105 = r104.get();
        if (r105 == null) goto L12;
        if (r102 == true) goto L9;
        r102 = r105.onSubMenuSelected(r100);
        goto L9
    L12:
        this.mPresenters.remove(r104);
        goto L9
    L15:
        return r102;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> r100, int r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L9;
        if (((MenuItemImpl) ListProtector.get(r100, r102)).getOrdering() <= r101) goto L7;
        r102 = r102 - 1;
        goto L3
    L7:
        return r102 + 1;
    L9:
        return 0;
    }

    private void removeItemAtInt(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.mItems.size()) goto L12;
        ListProtector.remove(this.mItems, r100);
        if (r101 == false) goto L11;
        onItemsChanged(true);
        return;
    L11:
        return;
    }

    public void addMenuPresenter(MenuPresenter r100, Context r101) {
        this.mPresenters.add(new WeakReference(r100));
        r100.initForMenu(r101, this);
        this.mIsActionItemsStale = true;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder r100, MenuItem r101) {
        Callback r102 = this.mCallback;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.onMenuItemSelected(r100, r101) == false) goto L7;
        return true;
    }

    public int findGroupIndex(int r100, int r101) {
        int r102 = size();
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        if (r101 >= r102) goto L10;
        if (((MenuItemImpl) ListProtector.get(this.mItems, r101)).getGroupId() == r100) goto L8;
        r101 = r101 + 1;
        goto L5
    L8:
        return r101;
    L10:
        return -1;
    }

    public MenuItemImpl findItemWithShortcutForKey(int r110, KeyEvent r111) {
        ArrayList<MenuItemImpl> r100 = this.mTempShortcutItemList;
        r100.clear();
        findItemsWithShortcutForKey(r100, r110, r111);
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        int r101 = r111.getMetaState();
        KeyCharacterMap.KeyData r102 = new KeyCharacterMap.KeyData();
        r111.getKeyData(r102);
        int r112 = r100.size();
        if (r112 == 1) goto L8;
        boolean r103 = isQwertyMode();
        int r104 = 0;
    L10:
        if (r104 >= r112) goto L30;
        MenuItemImpl r105 = (MenuItemImpl) ListProtector.get(r100, r104);
        if (r103 == false) goto L14;
        char r106 = r105.getAlphabeticShortcut();
    L15:
        char[] r107 = r102.meta;
        if (r106 != r107[0]) goto L20;
        if ((r101 & 2) != 0) goto L20;
    L28:
        return r105;
    L20:
        if (r106 == r107[2]) goto L22;
    L23:
        if (r103 == false) goto L29;
        if (r106 != '\b') goto L29;
        if (r110 == 67) goto L28;
    L29:
        r104 = r104 + 1;
        goto L10
    L22:
        if ((r101 & 2) != 0) goto L28;
    L14:
        r106 = r105.getNumericShortcut();
        goto L15
    L30:
        return null;
    L8:
        return (MenuItemImpl) ListProtector.get(r100, 0);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int r100, KeyEvent r101) {
        if (findItemWithShortcutForKey(r100, r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int r100, int r101) {
        return performItemAction(findItem(r100), r101);
    }

    public boolean performItemAction(MenuItem r100, int r101) {
        return performItemAction(r100, null, r101);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int r100, boolean r101) {
        int r102 = this.mItems.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MenuItemImpl r104 = (MenuItemImpl) ListProtector.get(this.mItems, r103);
        if (r104.getGroupId() != r100) goto L7;
        r104.setEnabled(r101);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public void setGroupVisible(int r100, boolean r101) {
        int r102 = this.mItems.size();
        int r103 = 0;
        boolean r104 = false;
    L4:
        if (r103 >= r102) goto L11;
        MenuItemImpl r105 = (MenuItemImpl) ListProtector.get(this.mItems, r103);
        if (r105.getGroupId() != r100) goto L10;
        if (r105.setVisibleInt(r101) == false) goto L10;
        r104 = true;
    L10:
        r103 = r103 + 1;
        goto L4
    L11:
        if (r104 == false) goto L18;
        onItemsChanged(true);
        return;
    }

    public void findItemsWithShortcutForKey(List<MenuItemImpl> r110, int r111, KeyEvent r112) {
        boolean r100 = isQwertyMode();
        int r101 = r112.getModifiers();
        KeyCharacterMap.KeyData r102 = new KeyCharacterMap.KeyData();
        if (r112.getKeyData(r102) == true) goto L6;
        if (r111 == 67) goto L6;
        return;
    L6:
        int r103 = this.mItems.size();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L35;
        MenuItemImpl r105 = (MenuItemImpl) ListProtector.get(this.mItems, r104);
        if (r105.hasSubMenu() == false) goto L11;
        ((MenuBuilder) r105.getSubMenu()).findItemsWithShortcutForKey(r110, r111, r112);
    L11:
        if (r100 == false) goto L13;
        char r106 = r105.getAlphabeticShortcut();
    L14:
        if (r100 == false) goto L16;
        int r107 = r105.getAlphabeticModifiers();
    L18:
        if ((r101 & SupportMenu.SUPPORTED_MODIFIERS_MASK) != (r107 & SupportMenu.SUPPORTED_MODIFIERS_MASK)) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L34;
        if (r106 == 0) goto L34;
        char[] r109 = r102.meta;
        if (r106 == r109[0]) goto L32;
        if (r106 == r109[2]) goto L32;
        if (r100 == false) goto L34;
        if (r106 != '\b') goto L34;
        if (r111 != 67) goto L34;
    L32:
        if (r105.isEnabled() == false) goto L34;
        r110.add(r105);
    L34:
        r104 = r104 + 1;
        goto L7
    L20:
        r108 = false;
        goto L21
    L16:
        r107 = r105.getNumericModifiers();
        goto L18
    L13:
        r106 = r105.getNumericShortcut();
        goto L14
    }

    public boolean performItemAction(MenuItem r100, MenuPresenter r101, int r102) {
        MenuItemImpl r103 = (MenuItemImpl) r100;
        if (r103 != null) goto L5;
    L38:
        return false;
    L5:
        if (r103.isEnabled() == false) goto L38;
        boolean r104 = r103.invoke();
        ActionProvider r105 = r103.getSupportActionProvider();
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L14:
        if (r103.hasCollapsibleActionView() == false) goto L19;
        r104 = r104 | r103.expandActionView();
        if (r104 == false) goto L37;
        close(true);
    L37:
        return r104;
    L19:
        if (r103.hasSubMenu() == true) goto L26;
        if (r106 == true) goto L26;
        if ((r102 & 1) != 0) goto L37;
        close(true);
    L26:
        if ((r102 & 4) != 0) goto L29;
        close(false);
    L29:
        if (r103.hasSubMenu() == true) goto L31;
        r103.setSubMenu(new SubMenuBuilder(getContext(), this, r103));
    L31:
        SubMenuBuilder r107 = (SubMenuBuilder) r103.getSubMenu();
        if (r106 == false) goto L34;
        r105.onPrepareSubMenu(r107);
    L34:
        r104 = r104 | dispatchSubMenuSelected(r107, r101);
        if (r104 == true) goto L37;
        close(true);
        goto L37
    L10:
        if (r105.hasSubMenu() == false) goto L12;
        r106 = true;
        goto L14
    }

    @Override // android.view.Menu
    public boolean performShortcut(int r100, KeyEvent r101, int r102) {
        MenuItemImpl r103 = findItemWithShortcutForKey(r100, r101);
        if (r103 == null) goto L5;
        boolean r104 = performItemAction(r103, r102);
    L7:
        if ((r102 & 2) == 0) goto L9;
        close(true);
    L9:
        return r104;
    L5:
        r104 = false;
        goto L7
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int r100, boolean r101, boolean r102) {
        int r103 = this.mItems.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        MenuItemImpl r105 = (MenuItemImpl) ListProtector.get(this.mItems, r104);
        if (r105.getGroupId() != r100) goto L7;
        r105.setExclusiveCheckable(r102);
        r105.setCheckable(r101);
    L7:
        r104 = r104 + 1;
        goto L3
    }

    @Override // android.view.Menu
    public MenuItem add(int r100, int r101, int r102, int r103) {
        return addInternal(r100, r101, r102, this.mResources.getString(r103));
    }

    public MenuItem addInternal(int r100, int r110, int r111, CharSequence r112) {
        int r101 = getOrdering(r111);
        MenuItemImpl r102 = createNewMenuItem(r100, r110, r111, r101, r112, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo r113 = this.mCurrentMenuInfo;
        if (r113 == null) goto L5;
        r102.setMenuInfo(r113);
    L5:
        ArrayList<MenuItemImpl> r114 = this.mItems;
        ListProtector.add(r114, findInsertIndex(r114, r101), r102);
        onItemsChanged(true);
        return r102;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, CharSequence r103) {
        MenuItemImpl r104 = (MenuItemImpl) addInternal(r100, r101, r102, r103);
        SubMenuBuilder r105 = new SubMenuBuilder(this.mContext, this, r104);
        r104.setSubMenu(r105);
        return r105;
    }

    @Override // android.view.Menu
    public MenuItem add(int r100, int r101, int r102, CharSequence r103) {
        return addInternal(r100, r101, r102, r103);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, int r103) {
        return addSubMenu(r100, r101, r102, this.mResources.getString(r103));
    }

    private void setHeaderInternal(int r100, CharSequence r101, int r102, Drawable r103, View r104) {
        Resources r105 = getResources();
        if (r104 == null) goto L5;
        this.mHeaderView = r104;
        this.mHeaderTitle = null;
        this.mHeaderIcon = null;
    L14:
        onItemsChanged(false);
        return;
    L5:
        if (r100 <= 0) goto L7;
        this.mHeaderTitle = r105.getText(r100);
    L9:
        if (r102 <= 0) goto L11;
        this.mHeaderIcon = ContextCompat.getDrawable(getContext(), r102);
    L13:
        this.mHeaderView = null;
        goto L14
    L11:
        if (r103 == null) goto L13;
        this.mHeaderIcon = r103;
        goto L13
    L7:
        if (r101 == null) goto L9;
        this.mHeaderTitle = r101;
        goto L9
    }

    private MenuItemImpl createNewMenuItem(int r110, int r111, int r112, int r113, CharSequence r114, int r115) {
        return new MenuItemImpl(this, r110, r111, r112, r113, r114, r115);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int r100, int r101, int r110, ComponentName r111, Intent[] r112, Intent r113, int r114, MenuItem[] r115) {
        PackageManager r102 = this.mContext.getPackageManager();
        int r103 = 0;
        List<ResolveInfo> r116 = r102.queryIntentActivityOptions(r111, r112, r113, 0);
        if (r116 == null) goto L5;
        int r104 = r116.size();
    L7:
        if ((r114 & 1) != 0) goto L9;
        removeGroup(r100);
    L9:
        if (r103 >= r104) goto L20;
        ResolveInfo r117 = (ResolveInfo) ListProtector.get(r116, r103);
        int r105 = r117.specificIndex;
        if (r105 >= 0) goto L13;
        Intent r106 = r113;
    L14:
        Intent r107 = new Intent(r106);
        ActivityInfo r108 = r117.activityInfo;
        r107.setComponent(new ComponentName(r108.applicationInfo.packageName, r108.name));
        MenuItem r109 = add(r100, r101, r110, r117.loadLabel(r102)).setIcon(r117.loadIcon(r102)).setIntent(r107);
        if (r115 == null) goto L19;
        int r118 = r117.specificIndex;
        if (r118 < 0) goto L19;
        r115[r118] = r109;
    L19:
        r103 = r103 + 1;
        goto L9
    L13:
        r106 = r112[r105];
        goto L14
    L20:
        return r104;
    L5:
        r104 = 0;
        goto L7
    }
}
