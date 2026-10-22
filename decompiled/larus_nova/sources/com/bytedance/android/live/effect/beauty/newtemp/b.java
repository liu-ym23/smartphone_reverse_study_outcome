package com.bytedance.android.live.effect.beauty.newtemp;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveOneTapBeautyAdapter f67387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f67388b;

    public b(LiveOneTapBeautyAdapter r100, int r101) {
        this.f67387a = r100;
        this.f67388b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = this.f67388b;
        LiveOneTapBeautyAdapter r102 = this.f67387a;
        if (r101 != r102.f67361e) goto L5;
        return;
    L5:
        LiveOneTapBeautyAdapter.y2(false, (o90.a) ListProtector.get(r102.f67359c, r101), this.f67388b);
        LiveOneTapBeautyAdapter r103 = this.f67387a;
        LiveOneTapBeautyAdapter.b r104 = r103.f67362f;
        if (r104 != null) goto L8;
        return;
    L8:
        if (r103.f67363g == false) goto L12;
        r104.onItemClick(this.f67388b);
        return;
    }
}
