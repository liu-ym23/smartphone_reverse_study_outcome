package com.bytedance.android.anya.dsl;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes43.dex */
public final class d<SUPER_STATE extends MVIState<?>, PAGE_STATE extends MVIState<?>, PAGE_ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, t0<SUPER_STATE, PAGE_STATE>> f41591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<ViewGroup, Integer, Integer, com.bytedance.android.anya.c<PAGE_STATE, PAGE_ACTION>> f41592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager f41593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends com.bytedance.android.anya.c<PAGE_STATE, PAGE_ACTION>>, MVIViewPagerAdapter<PAGE_STATE, PAGE_ACTION>> f41594d;

    public d(Function2 r100, Function3 r101, ViewPager r102, Function1 r103) {
        this.f41591a = r100;
        this.f41592b = r101;
        this.f41593c = r102;
        this.f41594d = r103;
    }
}
