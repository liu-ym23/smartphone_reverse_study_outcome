package com.bytedance.android.shopping.hybrid.bridges;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECShopSharedMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSharedMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f176216e;

    public ECShopSharedMethod() {
        this.f176216e = "shareShop";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f176216e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        String r100 = r110.optString("uid", "");
        String r101 = r110.optString("sec_uid", "");
        String r102 = r110.optString(InstantPlayContext.NICKNAME, "");
        String r112 = r110.optString("avatar_medium", "");
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (r102 == null) goto L20;
        if (r112 == null) goto L20;
        ECUrlModel r103 = new ECUrlModel();
        r103.setUrlList(CollectionsKt.listOf(r112));
        Activity r104 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r104 == null) goto L17;
        Window r113 = r104.getWindow();
        if (r113 == null) goto L17;
        View r114 = r113.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r115 = ThreadMethodProxy.currentThread();
        if (r115 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r115, "getDecorView");
    L18:
        View r105 = r114;
        ih3.f r106 = ih3.f.f489805b;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r105);
        r106.c(r104, r105, r100, r101, r103, r102);
        return;
    L17:
        r114 = null;
    L20:
        JSONObject r116 = new JSONObject();
        r116.put("code", 0);
        Unit r107 = Unit.INSTANCE;
        r111.a(r116);
    }
}
