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
import androidx.appcompat.R$layout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d implements MenuPresenter, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MenuBuilder f547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MenuPresenter.Callback f552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f554j;

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f556b;

        public a(d r10) {
            this.f556b = r10;
            this.f555a = -1;
            a();
        }

        public void a() {
            g r10 = this.f556b.f547c.getExpandedItem();
            if (r10 == null) goto L11;
            ArrayList<g> r11 = this.f556b.f547c.getNonActionItems();
            int r12 = r11.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L11;
            if (r11.get(r13) == r10) goto L8;
            r13 = r13 + 1;
            goto L5
        L8:
            this.f555a = r13;
            return;
        L11:
            this.f555a = -1;
        }

        public g b(int r10) {
            ArrayList<g> r11 = this.f556b.f547c.getNonActionItems();
            int r12 = r10 + this.f556b.f549e;
            int r13 = this.f555a;
            if (r13 < 0) goto L7;
            if (r12 < r13) goto L7;
            r12 = r12 + 1;
        L7:
            return r11.get(r12);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r10 = this.f556b.f547c.getNonActionItems().size() - this.f556b.f549e;
            if (this.f555a >= 0) goto L6;
            return r10;
        L6:
            return r10 - 1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r10) {
            return b(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L5;
            d r13 = this.f556b;
            r11 = r13.f546b.inflate(r13.f551g, r12, false);
        L5:
            ((MenuView.ItemView) r11).initialize(b(r10), 0);
            return r11;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public d(Context r10, int r11) {
        this(r11, 0);
        this.f545a = r10;
        this.f546b = LayoutInflater.from(r10);
    }

    public ListAdapter a() {
        if (this.f553i != null) goto L6;
        this.f553i = new a(this);
    L6:
        return this.f553i;
    }

    public void b(Bundle r10) {
        SparseArray<Parcelable> r11 = r10.getSparseParcelableArray("android:menu:list");
        if (r11 == null) goto L6;
        this.f548d.restoreHierarchyState(r11);
        return;
    }

    public void c(Bundle r10) {
        SparseArray<Parcelable> r11 = new SparseArray();
        ExpandedMenuView r12 = this.f548d;
        if (r12 == null) goto L5;
        r12.saveHierarchyState(r11);
    L5:
        r10.putSparseParcelableArray("android:menu:list", r11);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, g r11) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, g r11) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f554j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        if (this.f548d != null) goto L9;
        this.f548d = (ExpandedMenuView) this.f546b.inflate(R$layout.abc_expanded_menu_layout, r10, false);
        if (this.f553i != null) goto L7;
        this.f553i = new a(this);
    L7:
        this.f548d.setAdapter(this.f553i);
        this.f548d.setOnItemClickListener(this);
    L9:
        return this.f548d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r10, MenuBuilder r11) {
        if (this.f550f == 0) goto L6;
        ContextThemeWrapper r12 = new ContextThemeWrapper(r10, this.f550f);
        this.f545a = r12;
        this.f546b = LayoutInflater.from(r12);
    L10:
        this.f547c = r11;
        a r13 = this.f553i;
        if (r13 == null) goto L14;
        r13.notifyDataSetChanged();
        return;
    L14:
        return;
    L6:
        if (this.f545a == null) goto L10;
        this.f545a = r10;
        if (this.f546b != null) goto L10;
        this.f546b = LayoutInflater.from(r10);
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        MenuPresenter.Callback r12 = this.f552h;
        if (r12 == null) goto L6;
        r12.onCloseMenu(r10, r11);
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
        this.f547c.performItemAction(this.f553i.b(r12), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
        b((Bundle) r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.f548d != null) goto L6;
        return null;
    L6:
        Bundle r10 = new Bundle();
        c(r10);
        return r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(m r10) {
        if (r10.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        new f(r10).b(null);
        MenuPresenter.Callback r11 = this.f552h;
        if (r11 == null) goto L11;
        r11.onOpenSubMenu(r10);
        return true;
    L11:
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.f552h = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        a r11 = this.f553i;
        if (r11 == null) goto L6;
        r11.notifyDataSetChanged();
        return;
    }

    public d(int r10, int r11) {
        this.f551g = r10;
        this.f550f = r11;
    }
}
