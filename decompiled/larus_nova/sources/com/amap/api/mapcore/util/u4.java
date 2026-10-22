package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class u4 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean[] f28049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<OfflineMapProvince> f28051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OfflineMapManager f28052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f28053e;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y4 f28054a;

        public a(u4 r100) {
        }
    }

    public void a() {
        this.f28050b = 0;
        notifyDataSetChanged();
    }

    public void b() {
        this.f28050b = -1;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int r100, int r101) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int r100, int r101) {
        return r101;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int r100) {
        return r100;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int r100, int r101) {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        int r100 = this.f28050b;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        return this.f28051c.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int r100) {
        if (r100 == 0) goto L6;
        boolean r101 = true;
        if (r100 == (getGroupCount() - 1)) goto L6;
    L7:
        if (r101 == false) goto L11;
        return ((OfflineMapProvince) ListProtector.get(this.f28051c, r100)).getCityList().size();
    L11:
        return ((OfflineMapProvince) ListProtector.get(this.f28051c, r100)).getCityList().size();
    L6:
        r101 = false;
        goto L7
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int r100) {
        return ((OfflineMapProvince) ListProtector.get(this.f28051c, r100)).getProvinceName();
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int r100) {
        this.f28049a[r100] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int r100) {
        this.f28049a[r100] = true;
    }

    public u4(List<OfflineMapProvince> r100, OfflineMapManager r101, Context r102) {
        this.f28050b = -1;
        this.f28051c = r100;
        this.f28052d = r101;
        this.f28053e = r102;
        this.f28049a = new boolean[r100.size()];
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int r100, boolean r101, View r102, ViewGroup r103) {
        if (r102 != null) goto L4;
        r102 = (RelativeLayout) b5.a(this.f28053e, R.array.branch_integer_array, null);
    L4:
        TextView r104 = (TextView) r102.findViewById(2147479572);
        ImageView r105 = (ImageView) r102.findViewById(2147479573);
        r104.setText(((OfflineMapProvince) ListProtector.get(this.f28051c, r100)).getProvinceName());
        if (this.f28049a[r100] == false) goto L7;
        r105.setImageDrawable(b5.a().getDrawable(R.animator.design_appbar_state_list_animator));
    L8:
        return r102;
    L7:
        r105.setImageDrawable(b5.a().getDrawable(R.animator.design_fab_hide_motion_spec));
        goto L8
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int r100, int r101, boolean r102, View r103, ViewGroup r104) {
        if (r103 == null) goto L4;
        a r105 = (a) r103.getTag();
    L5:
        OfflineMapCity r106 = (OfflineMapCity) ListProtector.get(((OfflineMapProvince) ListProtector.get(this.f28051c, r100)).getCityList(), r101);
        r105.f28054a.a(r106);
        return r103;
    L4:
        r105 = new a(this);
        y4 r107 = new y4(this.f28053e, this.f28052d);
        r107.a(1);
        View r108 = r107.d();
        r105.f28054a = r107;
        r108.setTag(r105);
        r103 = r108;
        goto L5
    }
}
