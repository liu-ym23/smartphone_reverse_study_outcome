package com.bytedance.android.live.room.discovery;

import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes47.dex */
public final class y implements rv2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHashtagWidget f99600a;

    @Override // rv2.d
    public final void a() {
        UIUtils.setViewVisibility(this.f99600a.contentView, 0);
    }

    @Override // rv2.d
    public final void b() {
        UIUtils.setViewVisibility(this.f99600a.contentView, 4);
    }

    public y(LiveHashtagWidget r100) {
        this.f99600a = r100;
    }
}
