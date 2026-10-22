package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class z implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHashtagWidget f99601a;

    public z(LiveHashtagWidget r100) {
        this.f99601a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_circle_tag_anchor_hint, 0);
        LiveHashtagWidget.wq(this.f99601a);
    }
}
