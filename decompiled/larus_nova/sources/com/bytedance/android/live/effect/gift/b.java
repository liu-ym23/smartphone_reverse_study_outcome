package com.bytedance.android.live.effect.gift;

import com.bytedance.android.livesdk.revenue.service.effect.k;
import com.ss.android.ugc.effectmanager.IFetchModelListener;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements IFetchModelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f68025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.a f68026b;

    @Override // com.ss.android.ugc.effectmanager.IFetchModelListener
    public final void onFailed(Exception r100) {
        com.bytedance.android.live.effect.api.a r101 = this.f68026b;
        if (r101 == null) goto L6;
        r101.onFailure(r100);
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchModelListener
    public final void onSuccess(String[] r100) {
        com.bytedance.android.live.effect.api.a r101 = this.f68026b;
        if (r101 == null) goto L6;
        r101.onSuccess();
        return;
    }

    public b(Map r100, k.a r101) {
        this.f68025a = r100;
        this.f68026b = r101;
    }
}
