package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements le.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IECLivePlayerClient f42758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePlayerView f42759b;

    @Override // le.b
    public final IECLivePlayerClient a() {
        if (this.f42758a != null) goto L5;
        this.f42758a = new a(this.f42759b);
    L5:
        IECLivePlayerClient r100 = this.f42758a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("liveClient");
    L8:
        return r100;
    }

    @Override // le.b
    public final LivePlayerView getView() {
        return this.f42759b;
    }

    public d(LivePlayerView r100) {
        Intrinsics.checkNotNullParameter(r100, "liveView");
        this.f42759b = r100;
    }

    @Override // le.b
    public final void setScaleType(int r100) {
        this.f42759b.setScaleType(r100);
    }
}
