package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MenuBuilder f557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f562f;

    public e(MenuBuilder r10, LayoutInflater r11, boolean r12, int r13) {
        this.f558b = -1;
        this.f560d = r12;
        this.f561e = r11;
        this.f557a = r10;
        this.f562f = r13;
        a();
    }

    public void a() {
        g r10 = this.f557a.getExpandedItem();
        if (r10 == null) goto L11;
        ArrayList<g> r11 = this.f557a.getNonActionItems();
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (r11.get(r13) == r10) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        this.f558b = r13;
        return;
    L11:
        this.f558b = -1;
    }

    public MenuBuilder b() {
        return this.f557a;
    }

    public g c(int r10) {
        if (this.f560d == false) goto L5;
        ArrayList<g> r11 = this.f557a.getNonActionItems();
    L6:
        int r12 = this.f558b;
        if (r12 < 0) goto L11;
        if (r10 < r12) goto L11;
        r10 = r10 + 1;
    L11:
        return r11.get(r10);
    L5:
        r11 = this.f557a.getVisibleItems();
        goto L6
    }

    public void d(boolean r10) {
        this.f559c = r10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f560d == false) goto L5;
        ArrayList<g> r10 = this.f557a.getNonActionItems();
    L7:
        if (this.f558b >= 0) goto L11;
        return r10.size();
    L11:
        return r10.size() - 1;
    L5:
        r10 = this.f557a.getVisibleItems();
        goto L7
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return c(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L5;
        r11 = this.f561e.inflate(this.f562f, r12, false);
    L5:
        int r13 = c(r10).getGroupId();
        int r14 = r10 - 1;
        if (r14 < 0) goto L8;
        int r15 = c(r14).getGroupId();
    L9:
        ListMenuItemView r16 = (ListMenuItemView) r11;
        if (this.f557a.isGroupDividerEnabled() == false) goto L13;
        if (r13 == r15) goto L13;
        boolean r17 = true;
    L14:
        r16.setGroupDividerEnabled(r17);
        MenuView.ItemView r18 = (MenuView.ItemView) r11;
        if (this.f559c == false) goto L17;
        r16.setForceShowIcon(true);
    L17:
        r18.initialize(c(r10), 0);
        return r11;
    L13:
        r17 = false;
        goto L14
    L8:
        r15 = r13;
        goto L9
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
