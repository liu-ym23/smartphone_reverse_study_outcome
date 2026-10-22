package com.bytedance.android.ec.adapter.impl.adapters.browser;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends qe.a<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IECBridgeMethod f42750a;

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        IECBridgeMethod.Access r100 = this.f42750a.getAccess();
        int r101 = qe.c.f532608a[r100.ordinal()];
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
        this.f42750a.release();
    }

    public f(IECBridgeMethod r100) {
        this.f42750a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalActivityResultListener
    public final void setFragment(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        IECBridgeMethod r101 = this.f42750a;
        if ((r101 instanceof pd.a) == true) goto L5;
        r101 = null;
    L5:
        pd.a r102 = (pd.a) r101;
        if (r102 == null) goto L9;
        r102.setFragment(r100);
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IECBridgeMethod.a.a(this.f42750a, r101.getContext(), r102, new d(this), new e(r101));
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalActivityResultListener
    public final void onActivityResult(int r100, int r101, Intent r102) {
        IECBridgeMethod r103 = this.f42750a;
        if ((r103 instanceof pd.a) == true) goto L5;
        r103 = null;
    L5:
        pd.a r104 = (pd.a) r103;
        if (r104 == null) goto L9;
        r104.onActivityResult(r100, r101, r102);
        return;
    }
}
