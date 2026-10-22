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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class t4 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean[] f27996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f27997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y4 f27998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<OfflineMapProvince> f27999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List<OfflineMapProvince> f28000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private z4 f28001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OfflineMapManager f28002g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f28003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t4 f28004b;

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            t4.a(this.f28004b).a(this.f28003a);
        }

        public a(t4 r100, OfflineMapCity r101) {
            this.f28004b = r100;
            this.f28003a = r101;
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y4 f28005a;

        public b(t4 r100) {
        }
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
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int r100, int r101) {
        return true;
    }

    public void a() {
        int r100 = this.f28000e.size();     // Catch: Exception -> L10
    L3:
        if (r100 <= 0) goto L8;
        OfflineMapProvince r101 = (OfflineMapProvince) ListProtector.get(this.f28000e, r100 - 1);     // Catch: Exception -> L10
        if (r101.getDownloadedCityList().size() != 0) goto L7;
        this.f28000e.remove(r101);     // Catch: Exception -> L10
    L7:
        r100 = r100 - 1;     // Catch: Exception -> L10
        goto L3
    L8:
        this.f27996a = new boolean[this.f28000e.size()];     // Catch: Exception -> L10
        notifyDataSetChanged();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void b() {
        Iterator<OfflineMapProvince> r100 = this.f27999d.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        OfflineMapProvince r101 = r100.next();
        if (r101.getDownloadedCityList().size() <= 0) goto L4;
        if (this.f28000e.contains(r101) == true) goto L4;
        this.f28000e.add(r101);
        goto L4
    L10:
        this.f27996a = new boolean[this.f28000e.size()];
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f28000e.size();
    }

    public static /* synthetic */ z4 a(t4 r100) {
        return r100.f28001f;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int r100) {
        return ((OfflineMapProvince) ListProtector.get(this.f28000e, r100)).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int r100) {
        return ((OfflineMapProvince) ListProtector.get(this.f28000e, r100)).getProvinceName();
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int r100) {
        this.f27996a[r100] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int r100) {
        this.f27996a[r100] = true;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int r100, int r101) {
        return ListProtector.get(((OfflineMapProvince) ListProtector.get(this.f28000e, r100)).getDownloadedCityList(), r101);
    }

    public t4(Context r100, z4 r101, OfflineMapManager r102, List<OfflineMapProvince> r103) {
        this.f27999d = new ArrayList();
        this.f28000e = new ArrayList();
        this.f27997b = r100;
        this.f28001f = r101;
        this.f28002g = r102;
        if (r103 != null) goto L5;
    L14:
        this.f27996a = new boolean[this.f28000e.size()];
        return;
    L5:
        if (r103.size() <= 0) goto L14;
        this.f27999d.clear();
        this.f27999d.addAll(r103);
        Iterator<OfflineMapProvince> r104 = this.f27999d.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        OfflineMapProvince r105 = r104.next();
        if (r105 == null) goto L8;
        if (r105.getDownloadedCityList().size() <= 0) goto L8;
        this.f28000e.add(r105);
        goto L8
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int r100, boolean r101, View r102, ViewGroup r103) {
        if (r102 != null) goto L4;
        r102 = (RelativeLayout) b5.a(this.f27997b, R.array.branch_integer_array, null);
    L4:
        TextView r104 = (TextView) r102.findViewById(2147479572);
        ImageView r105 = (ImageView) r102.findViewById(2147479573);
        r104.setText(((OfflineMapProvince) ListProtector.get(this.f28000e, r100)).getProvinceName());
        if (this.f27996a[r100] == false) goto L7;
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
        b r105 = (b) r103.getTag();
    L5:
        OfflineMapProvince r106 = (OfflineMapProvince) ListProtector.get(this.f28000e, r100);
        if (r101 >= r106.getDownloadedCityList().size()) goto L8;
        OfflineMapCity r107 = (OfflineMapCity) ListProtector.get(r106.getDownloadedCityList(), r101);
        r105.f28005a.a(r107);
        r103.setOnClickListener(new a(this, r107));
    L8:
        return r103;
    L4:
        r105 = new b(this);
        y4 r108 = new y4(this.f27997b, this.f28002g);
        this.f27998c = r108;
        r108.a(2);
        r103 = this.f27998c.d();
        r105.f28005a = this.f27998c;
        r103.setTag(r105);
        goto L5
    }
}
