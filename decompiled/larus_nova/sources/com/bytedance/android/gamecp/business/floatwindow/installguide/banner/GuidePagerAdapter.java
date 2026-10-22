package com.bytedance.android.gamecp.business.floatwindow.installguide.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.gamecp.business.floatwindow.installguide.n;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import fu.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class GuidePagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f53201a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r101 != r100) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f53201a.size();
    }

    public GuidePagerAdapter(List<n> r100) {
        this.f53201a = r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_install_guide_banner_view, r100, false);
        TextView r103 = (TextView) r102.findViewById(R.id.tv_title);
        HSImageView r104 = (HSImageView) r102.findViewById(R.id.iv_content);
        n r105 = (n) ListProtector.get(this.f53201a, r101);
        r103.setText(r105.title);
        ImageModel r106 = new ImageModel();
        ArrayList r107 = new ArrayList();
        r107.add(r105.img);
        r106.setUrls(r107);
        j.b(r104, r106);
        r100.addView(r102);
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        if ((r102 instanceof View) == false) goto L6;
        r100.removeView((View) r102);
        return;
    }
}
