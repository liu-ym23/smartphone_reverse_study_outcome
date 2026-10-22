package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssetsDefaultDownloadPolicy f129145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f129146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f129147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f129148d;

    public b(AssetsDefaultDownloadPolicy r100, com.bytedance.android.live.core.resources.e r101, int r102, long r103) {
        this.f129145a = r100;
        this.f129146b = r101;
        this.f129147c = r102;
        this.f129148d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        boolean r100 = this.f129145a.f129130h.ib(this.f129146b, null, this.f129147c, AssetDownloadPriority.NORMAL);
        this.f129145a.f129123a.put(Long.valueOf(this.f129146b.getId()), Long.valueOf(this.f129148d));
        this.f129145a.b(this.f129146b, r100);
    }
}
