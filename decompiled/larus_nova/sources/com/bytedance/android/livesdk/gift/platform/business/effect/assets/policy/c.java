package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssetsDefaultDownloadPolicy f129149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f129150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f129151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f129152d;

    public c(AssetsDefaultDownloadPolicy r100, com.bytedance.android.live.core.resources.e r101, int r102, long r103) {
        this.f129149a = r100;
        this.f129150b = r101;
        this.f129151c = r102;
        this.f129152d = r103;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        boolean r100 = this.f129149a.f129130h.Re(this.f129150b, this.f129151c);
        this.f129149a.f129123a.put(Long.valueOf(this.f129150b.getId()), Long.valueOf(this.f129152d));
        this.f129149a.b(this.f129150b, r100);
    }
}
