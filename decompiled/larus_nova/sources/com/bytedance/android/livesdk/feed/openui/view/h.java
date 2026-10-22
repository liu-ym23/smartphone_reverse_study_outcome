package com.bytedance.android.livesdk.feed.openui.view;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleLiveView f124276a;

    @Override // com.bytedance.android.live.core.utils.q0
    public final void f(k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void g(k r100) {
    }

    public h(SimpleLiveView r100) {
        this.f124276a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = ((HSImageView) this.f124276a.a(R.id.iv_content_label)).getLayoutParams();
        r103.width = (int) (r103.height * (r101 / r102));
        ((HSImageView) this.f124276a.a(R.id.iv_content_label)).setLayoutParams(r103);
        this.f124276a.post(new g(this, r103));
    }
}
