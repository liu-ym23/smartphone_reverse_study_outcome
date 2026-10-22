package com.bytedance.android.livesdk.feed.banner.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.banner.a;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import pv1.b;

/* JADX INFO: loaded from: classes8.dex */
public class BannerPageAdapter extends AbsPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f123658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f123659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f123660c;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<a> r100 = this.f123658a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        if (((ArrayList) r100).size() <= 1) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return ((ArrayList) this.f123658a).size();
    }

    @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        View r103 = (View) r102;
        r100.removeView(r103);
        if (this.mScrapViews.size() >= ((ArrayList) this.f123658a).size()) goto L7;
        this.mScrapViews.add(r103);
    L7:
        unbindView(r103);
    }

    @Override // com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter
    public final View getView(int r100, View r101, ViewGroup r102) {
        if (r101 != null) goto L5;
        r101 = this.mInflater.inflate(R.layout.ttlive_item_banner, r102, false);
        b r103 = new b(r101, r102.getContext(), this.f123659b, this.f123660c);
        r101.setTag(r103);
    L6:
        List<a> r104 = this.f123658a;
        if (r104 != null) goto L9;
    L23:
        return r101;
    L9:
        if (((ArrayList) r104).isEmpty() == true) goto L23;
        List<a> r105 = this.f123658a;
        a r106 = (a) ListProtector.get(r105, r100 % ((ArrayList) r105).size());
        r103.f530795h = r100 % ((ArrayList) this.f123658a).size();
        r103.f530792e = r106;
        if (r106 == null) goto L23;
        r103.f530790c.setVisibility(8);
        String r107 = r106.e();
        if (r106.c() == null) goto L20;
        if (r106.c().getUrls() == null) goto L20;
        if (r106.c().getUrls().size() <= 0) goto L20;
        r103.f530788a.setImageURI((String) ListProtector.get(r106.c().getUrls(), 0));
    L20:
        if (TextUtils.isEmpty(r107) == false) goto L22;
        r103.f530789b.setVisibility(8);
        goto L23
    L22:
        r103.f530789b.setVisibility(0);
        r103.f530789b.setText(r107);
        goto L23
    L5:
        r103 = (b) r101.getTag();
        goto L6
    }

    public BannerPageAdapter(Context r100, LayoutInflater r101, String r102, l r103) {
        super(r100, r101);
        this.f123658a = new ArrayList();
        this.f123659b = r102;
        this.f123660c = r103;
    }
}
