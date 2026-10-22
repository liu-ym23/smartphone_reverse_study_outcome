package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import android.content.Context;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends w {
    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void d() {
        com.bytedance.android.gamecp.host_api.a.b().getCloudGameService().p();
    }

    public c(Context r100, Store r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r101);
        new CompositeDisposable();
    }
}
