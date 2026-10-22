package com.bytedance.android.ec.adapter.impl.adapters.browser;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IECBridgeMethod f42747a;

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        IECBridgeMethod.Access r100 = this.f42747a.getAccess();
        int r101 = qe.c.f532609b[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return PermissionGroup.PRIVATE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return PermissionGroup.PROTECTED;
    L13:
        return PermissionGroup.PUBLIC;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f42747a.release();
    }

    public c(IECBridgeMethod r100) {
        this.f42747a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IECBridgeMethod.a.a(this.f42747a, r101.getContext(), r102, new a(this), new b(r101));
    }
}
