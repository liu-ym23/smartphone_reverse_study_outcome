package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridCard f88456a;

    public f(HybridCard r100) {
        this.f88456a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f88456a.release();
        return null;
    }
}
