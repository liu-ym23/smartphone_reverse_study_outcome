package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.n;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSharePanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSharePanelMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f44137e;

    public static final class a implements n {
        public a() {
        }
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecSharePanel";
    }

    public ECSharePanelMethod() {
        this.f44137e = new a();
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        JSONObject r100 = new JSONObject();
        boolean r101 = true;
        r100.put("code", 1);
        r111.a(r100);
        if (r110.optString("bcmChain").length() == 0) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L14;
        kc.a r102 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, PageFinder.via(b().f545990a), 0, false, 6, null);
        if (r102 == null) goto L10;
        JSONObject r103 = r102.a();
    L11:
        if (r103 == null) goto L14;
        r110.put("bcmChain", r103.toString());
        goto L14
    L10:
        r103 = null;
    L14:
        if (getContext() == null) goto L26;
        int r112 = ECSdk.f48106a;
        s83.g r113 = (s83.g) ECSdk.a(s83.g.class);
        if (r113 == null) goto L20;
        s83.e r114 = r113.W();
        if (r114 == null) goto L20;
        r114.d(r110, "click", r110.optString("enterFrom"));
    L20:
        s83.g r115 = (s83.g) ECSdk.a(s83.g.class);
        if (r115 == null) goto L27;
        s83.e r116 = r115.W();
        if (r116 == null) goto L28;
        r116.f(r110, this.f44137e);
        return;
    L28:
        return;
    L27:
        return;
    }
}
