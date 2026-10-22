package com.bytedance.android.live.effect.gift;

import com.bytedance.android.livesdk.revenue.service.effect.k;
import com.ss.android.ugc.effectmanager.IFetchResourceListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements IFetchResourceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f68023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.a f68024b;

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onFailure(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        com.bytedance.android.live.effect.api.a r101 = this.f68024b;
        if (r101 == null) goto L6;
        r101.onFailure(r100);
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.IFetchResourceListener
    public final void onSuccess(long r100) {
        com.bytedance.android.live.effect.api.a r101 = this.f68024b;
        if (r101 == null) goto L6;
        r101.onSuccess();
        return;
    }

    public a(Map r100, k.a r101) {
        this.f68023a = r100;
        this.f68024b = r101;
    }
}
