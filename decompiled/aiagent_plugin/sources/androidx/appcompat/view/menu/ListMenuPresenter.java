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
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuPresenter implements AdapterView.OnItemClickListener, d {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    MenuAdapter mAdapter;
    private d.a mCallback;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;
    int mItemIndexOffset;
    int mItemLayoutRes;
    MenuBuilder mMenu;
    ExpandedMenuView mMenuView;
    int mThemeRes;

    private class MenuAdapter extends BaseAdapter {
        private int mExpandedIndex;
        final /* synthetic */ ListMenuPresenter this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public MenuAdapter(ListMenuPresenter r1) {
            this.this$0 = r1;
            this.mExpandedIndex = -1;
            findExpandedIndex();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r0 = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
            if (this.mExpandedIndex >= 0) goto L6;
            return r0;
        L6:
            return r0 - 1;
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int r3) {
            ArrayList<MenuItemImpl> r0 = this.this$0.mMenu.getNonActionItems();
            int r4 = r3 + this.this$0.mItemIndexOffset;
            int r2 = this.mExpandedIndex;
            if (r2 < 0) goto L7;
            if (r4 < r2) goto L7;
            r4 = r4 + 1;
        L7:
            return (MenuItemImpl) ZeusTransformUtils.preCheckCast(r0.get(r4), MenuItemImpl.class, "com.obric.aiagent.plugin");
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L5;
            r5 = ZeusTransformUtils.inflate(this.this$0.mInflater, this.this$0.mItemLayoutRes, r6, false, "com.obric.aiagent.plugin");
        L5:
            ((e.a) ZeusTransformUtils.preCheckCast(r5, e.a.class, "com.obric.aiagent.plugin")).initialize(getItem(r4), 0);
            return r5;
        }

        void findExpandedIndex() {
            MenuItemImpl r0 = this.this$0.mMenu.getExpandedItem();
            if (r0 == null) goto L11;
            ArrayList<MenuItemImpl> r1 = this.this$0.mMenu.getNonActionItems();
            int r2 = r1.size();
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L11;
            if (((MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r3), MenuItemImpl.class, "com.obric.aiagent.plugin")) == r0) goto L8;
            r3 = r3 + 1;
            goto L5
        L8:
            this.mExpandedIndex = r3;
            return;
        L11:
            this.mExpandedIndex = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean flagActionItems() {
        return false;
    }

    public ListMenuPresenter(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this(r4, 0);
        Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.mContext = r6;
        this.mInflater = LayoutInflater.from(r6);
    }

    public ListMenuPresenter(int r1, int r2) {
        this.mItemLayoutRes = r1;
        this.mThemeRes = r2;
    }

    @Override // androidx.appcompat.view.menu.d
    public void initForMenu(Context r4, MenuBuilder r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.mThemeRes == 0) goto L6;
        Context r7 = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper(r6, this.mThemeRes), "com.obric.aiagent.plugin");
        this.mContext = r7;
        this.mInflater = LayoutInflater.from(r7);
    L10:
        this.mMenu = r5;
        MenuAdapter r3 = this.mAdapter;
        if (r3 == null) goto L14;
        r3.notifyDataSetChanged();
        return;
    L14:
        return;
    L6:
        if (this.mContext == null) goto L10;
        Context r8 = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.mContext = r8;
        if (this.mInflater != null) goto L10;
        this.mInflater = LayoutInflater.from(r8);
        goto L10
    }

    public e getMenuView(ViewGroup r5) {
        if (this.mMenuView != null) goto L9;
        this.mMenuView = (ExpandedMenuView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.mInflater, ZeusTransformUtils.mapRes(R.layout.abc_expanded_menu_layout, "layout", "abc_expanded_menu_layout"), r5, false, "com.obric.aiagent.plugin"), ExpandedMenuView.class, "com.obric.aiagent.plugin");
        if (this.mAdapter != null) goto L7;
        this.mAdapter = new MenuAdapter(this);
    L7:
        this.mMenuView.setAdapter(this.mAdapter);
        this.mMenuView.setOnItemClickListener(this);
    L9:
        return this.mMenuView;
    }

    public ListAdapter getAdapter() {
        if (this.mAdapter != null) goto L6;
        this.mAdapter = new MenuAdapter(this);
    L6:
        return this.mAdapter;
    }

    @Override // androidx.appcompat.view.menu.d
    public void updateMenuView(boolean r1) {
        MenuAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    @Override // androidx.appcompat.view.menu.d
    public void setCallback(d.a r3) {
        this.mCallback = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean onSubMenuSelected(SubMenuBuilder r3) {
        if (r3.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        new MenuDialogHelper(r3).show(null);
        d.a r2 = this.mCallback;
        if (r2 == null) goto L11;
        r2.onOpenSubMenu(r3);
        return true;
    L11:
        return true;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        d.a r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
        return;
    }

    int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    public void setItemIndexOffset(int r1) {
        this.mItemIndexOffset = r1;
        if (this.mMenuView == null) goto L6;
        updateMenuView(false);
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mMenu.performItemAction(this.mAdapter.getItem(r3), this, 0);
    }

    public void saveHierarchyState(Bundle r2) {
        SparseArray<Parcelable> r0 = new SparseArray();
        ExpandedMenuView r1 = this.mMenuView;
        if (r1 == null) goto L5;
        r1.saveHierarchyState(r0);
    L5:
        r2.putSparseParcelableArray(VIEWS_TAG, r0);
    }

    public void restoreHierarchyState(Bundle r2) {
        SparseArray<Parcelable> r3 = r2.getSparseParcelableArray(VIEWS_TAG);
        if (r3 == null) goto L6;
        this.mMenuView.restoreHierarchyState(r3);
        return;
    }

    public void setId(int r1) {
        this.mId = r1;
    }

    @Override // androidx.appcompat.view.menu.d
    public int getId() {
        return this.mId;
    }

    @Override // androidx.appcompat.view.menu.d
    public Parcelable onSaveInstanceState() {
        if (this.mMenuView != null) goto L6;
        return null;
    L6:
        Bundle r0 = new Bundle();
        saveHierarchyState(r0);
        return r0;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onRestoreInstanceState(Parcelable r3) {
        restoreHierarchyState((Bundle) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"), Bundle.class, "com.obric.aiagent.plugin"));
    }
}
