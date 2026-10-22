package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f74118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<MvSelectListView> f74119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f74120c;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<String> r100 = this.f74118a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public MvSelectPagerAdapter() {
        this.f74119b = new ArrayList();
        this.f74120c = new f(null, 3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (r101 < 0) goto L15;
        if (r101 >= this.f74119b.size()) goto L15;
        MvSelectListView r102 = (MvSelectListView) ListProtector.get(this.f74119b, r101);
        int r103 = this.f74119b.size();
        if (r101 < 0) goto L12;
        if (r103 <= r101) goto L12;
        f r104 = this.f74120c;
        r102.a(r104.f74146b, r104.f74145a.getName(), false, null);
    L12:
        r100.addView(r102);
        return r102;
    L15:
        return new Object();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r102 instanceof View) == false) goto L8;
        View r103 = (View) r102;
        if (r100.indexOfChild(r103) < 0) goto L9;
        r100.removeView(r103);
        return;
    L9:
        return;
    }

    public final void f(f r100, int r101, boolean r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "tabBean");
        Intrinsics.checkNotNullParameter(r103, "refreshCB");
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 > (this.f74119b.size() - 1)) goto L18;
        this.f74120c = r100;
        MvSelectListView r104 = (MvSelectListView) ListProtector.get(this.f74119b, r101);
        int r105 = this.f74119b.size();
        if (r101 < 0) goto L19;
        if (r105 > r101) goto L12;
        return;
    L12:
        if (this.f74119b.isEmpty() == true) goto L20;
        r104.a(r100.f74146b, r100.f74145a.getName(), r102, r103);
        return;
    L20:
        return;
    L19:
        return;
    }
}
