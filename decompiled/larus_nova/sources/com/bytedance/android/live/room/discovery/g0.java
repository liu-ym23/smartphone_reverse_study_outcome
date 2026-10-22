package com.bytedance.android.live.room.discovery;

import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes47.dex */
public final class g0 implements rv2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHotSpotWidget f99523a;

    @Override // rv2.d
    public final void a() {
        UIUtils.setViewVisibility(this.f99523a.contentView, 0);
    }

    @Override // rv2.d
    public final void b() {
        UIUtils.setViewVisibility(this.f99523a.contentView, 4);
    }

    public g0(LiveHotSpotWidget r100) {
        this.f99523a = r100;
    }
}
