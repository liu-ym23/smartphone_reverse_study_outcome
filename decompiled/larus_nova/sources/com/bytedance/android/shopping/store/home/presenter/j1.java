package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class j1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f184212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f184213b;

    public j1(View r100, int r101) {
        this.f184212a = r100;
        this.f184213b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        dm.a.a("paomadeng").a("marqueeOffset:" + r101);
        wg.a.f(this.f184212a, com.bytedance.android.shopping.extensions.b.b(8), RangesKt.coerceAtLeast(r101.intValue(), this.f184213b + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
    }
}
