package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f81041a;

    public b0(ImageView r100) {
        this.f81041a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f81041a.getLayoutParams();
        int r104 = s1.f(30.0f);
        r103.width = r104;
        r103.height = (r102 * r104) / r101;
        this.f81041a.setLayoutParams(r103);
    }
}
