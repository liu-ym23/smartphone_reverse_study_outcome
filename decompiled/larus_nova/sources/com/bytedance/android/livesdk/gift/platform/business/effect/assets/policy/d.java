package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssetsDefaultDownloadPolicy f129153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f129154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f129155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f129156d;

    public d(AssetsDefaultDownloadPolicy r100, com.bytedance.android.live.core.resources.e r101, int r102, long r103) {
        this.f129153a = r100;
        this.f129154b = r101;
        this.f129155c = r102;
        this.f129156d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        boolean r100 = this.f129153a.f129130h.ib(this.f129154b, null, this.f129155c, AssetDownloadPriority.NORMAL);
        this.f129153a.f129123a.put(Long.valueOf(this.f129154b.getId()), Long.valueOf(this.f129156d));
        this.f129153a.b(this.f129154b, r100);
    }
}
