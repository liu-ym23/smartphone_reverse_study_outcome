package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    MenuAdapter mAdapter;
    private MenuPresenter.Callback mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;

    public class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex;
        final /* synthetic */ ListMenuPresenter this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r100) {
            return r100;
        }

        public void findExpandedIndex() {
            MenuItemImpl r100 = this.this$0.mMenu.getExpandedItem();
            if (r100 == null) goto L11;
            ArrayList<MenuItemImpl> r101 = this.this$0.mMenu.getNonActionItems();
            int r102 = r101.size();
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L11;
            if (((MenuItemImpl) ListProtector.get(r101, r103)) == r100) goto L8;
            r103 = r103 + 1;
            goto L5
        L8:
            this.mExpandedIndex = r103;
            return;
        L11:
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r100 = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
            if (this.mExpandedIndex >= 0) goto L6;
            return r100;
        L6:
            return r100 - 1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }

        public MenuAdapter(ListMenuPresenter r100) {
            this.this$0 = r100;
            this.mExpandedIndex = -1;
            findExpandedIndex();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int r100) {
            ArrayList<MenuItemImpl> r101 = this.this$0.mMenu.getNonActionItems();
            int r102 = r100 + this.this$0.mItemIndexOffset;
            int r103 = this.mExpandedIndex;
            if (r103 < 0) goto L7;
            if (r102 < r103) goto L7;
            r102 = r102 + 1;
        L7:
            return (MenuItemImpl) ListProtector.get(r101, r102);
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r100) {
            return getItem(r100);
        }

        @Override // android.widget.Adapter
        public View getView(int r100, View r101, ViewGroup r102) {
            if (r101 != null) goto L5;
            ListMenuPresenter r103 = this.this$0;
            r101 = r103.mInflater.inflate(r103.mItemLayoutRes, r102, false);
        L5:
            ((MenuView.ItemView) r101).initialize(getItem(r100), 0);
            return r101;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.mAdapter != null) goto L6;
        this.mAdapter = new MenuAdapter(this);
    L6:
        return this.mAdapter;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.mMenuView != null) goto L6;
        return null;
    L6:
        Bundle r100 = new Bundle();
        saveHierarchyState(r100);
        return r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    public int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r100) {
        if (this.mMenuView != null) goto L9;
        this.mMenuView = (ExpandedMenuView) this.mInflater.inflate(R.layout.abc_expanded_menu_layout, r100, false);
        if (this.mAdapter != null) goto L7;
        this.mAdapter = new MenuAdapter(this);
    L7:
        this.mMenuView.setAdapter(this.mAdapter);
        this.mMenuView.setOnItemClickListener(this);
    L9:
        return this.mMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r100) {
        restoreHierarchyState((Bundle) r100);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        if (r100.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        new MenuDialogHelper(r100).show(null);
        MenuPresenter.Callback r101 = this.mCallback;
        if (r101 == null) goto L11;
        r101.onOpenSubMenu(r100);
        return true;
    L11:
        return true;
    }

    public void restoreHierarchyState(Bundle r100) {
        SparseArray<Parcelable> r101 = r100.getSparseParcelableArray(VIEWS_TAG);
        if (r101 == null) goto L6;
        this.mMenuView.restoreHierarchyState(r101);
        return;
    }

    public void saveHierarchyState(Bundle r100) {
        SparseArray<Parcelable> r101 = new SparseArray();
        ExpandedMenuView r102 = this.mMenuView;
        if (r102 == null) goto L5;
        r102.saveHierarchyState(r101);
    L5:
        r100.putSparseParcelableArray(VIEWS_TAG, r101);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r100) {
        this.mCallback = r100;
    }

    public void setId(int r100) {
        this.mId = r100;
    }

    public void setItemIndexOffset(int r100) {
        this.mItemIndexOffset = r100;
        if (this.mMenuView == null) goto L6;
        updateMenuView(false);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r100) {
        MenuAdapter r101 = this.mAdapter;
        if (r101 == null) goto L6;
        r101.notifyDataSetChanged();
        return;
    }

    public ListMenuPresenter(Context r100, int r101) {
        this(r101, 0);
        this.mContext = r100;
        this.mInflater = LayoutInflater.from(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r100, MenuBuilder r101) {
        if (this.mThemeRes == 0) goto L6;
        ContextThemeWrapper r102 = new ContextThemeWrapper(r100, this.mThemeRes);
        this.mContext = r102;
        this.mInflater = LayoutInflater.from(r102);
    L10:
        this.mMenu = r101;
        MenuAdapter r103 = this.mAdapter;
        if (r103 == null) goto L14;
        r103.notifyDataSetChanged();
        return;
    L14:
        return;
    L6:
        if (this.mContext == null) goto L10;
        this.mContext = r100;
        if (this.mInflater != null) goto L10;
        this.mInflater = LayoutInflater.from(r100);
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        MenuPresenter.Callback r102 = this.mCallback;
        if (r102 == null) goto L6;
        r102.onCloseMenu(r100, r101);
        return;
    }

    public ListMenuPresenter(int r100, int r101) {
        this.mItemLayoutRes = r100;
        this.mThemeRes = r101;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        this.mMenu.performItemAction(this.mAdapter.getItem(r102), this, 0);
    }
}
