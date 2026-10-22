package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/ECPostActionMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPostActionMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f42901e;

    public ECPostActionMethod() {
        this.f42901e = "ecPostAction";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f42901e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("action", "");
        int r103 = r100.optInt("type", 0);
        String r104 = r100.optString(a.KEY_PAGE_ID, "");
        if (r103 != 0) goto L5;
        int r105 = ECSdk.f48106a;
        IECUserTrackerService r106 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r106 == null) goto L26;
        of.a r107 = r106.getMarketingService();
        if (r107 == null) goto L26;
        r107.a(r102, PostActionType.DO, r104);
    L26:
        r101.onSuccess(new JSONObject());
        return;
    L5:
        if (r103 != 1) goto L7;
        int r108 = ECSdk.f48106a;
        IECUserTrackerService r109 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r109 == null) goto L20;
        of.a r110 = r109.getMarketingService();
        if (r110 == null) goto L20;
        r110.a(r102, PostActionType.START_DURATION, r104);
    L20:
        r101.onSuccess(new JSONObject());
        return;
    L7:
        if (r103 == 2) goto L9;
        r101.onFailed(0, "error type");
        return;
    L9:
        int r111 = ECSdk.f48106a;
        IECUserTrackerService r112 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r112 == null) goto L14;
        of.a r113 = r112.getMarketingService();
        if (r113 == null) goto L14;
        r113.a(r102, PostActionType.END_DURATION, r104);
    L14:
        r101.onSuccess(new JSONObject());
    }
}
