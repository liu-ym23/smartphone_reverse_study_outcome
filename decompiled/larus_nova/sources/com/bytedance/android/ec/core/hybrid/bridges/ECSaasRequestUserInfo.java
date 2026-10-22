package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.s;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSaasRequestUserInfo;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSaasRequestUserInfo extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44130e;

    public ECSaasRequestUserInfo() {
        this.f44130e = "ec.sass.requestUserInfo";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44130e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, final ECBaseBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "iReturn");
        final String r101 = r100.optString("source", "");
        boolean r102 = r100.optBoolean("withAuth", false);
        int r103 = com.bytedance.forest.utils.h.f244547a;
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        Activity r105 = null;
        if (r104 == null) goto L7;
        s r106 = r104.getIHybridHostUserService();
        if (r106 == null) goto L7;
        String r107 = r106.getAccessToken();
    L9:
        if (com.bytedance.forest.utils.h.a(r107) == false) goto L12;
        d(r110, 0, true);
        return;
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        Context r108 = getContext();
        if (r108 != null) goto L17;
        Activity r109 = null;
    L34:
        if (r109 == null) goto L44;
        IHybridHostService r111 = com.bytedance.android.ec.hybrid.a.h();
        if (r111 == null) goto L45;
        s r112 = r111.getIHybridHostUserService();
        if (r112 == null) goto L46;
        r112.e(r109, r101, "", new ECSaasRequestUserInfo$handle$$inlined$let$lambda$1(this, r101, r110), new ECSaasRequestUserInfo$handle$$inlined$let$lambda$2(this, r101, r110));
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L17:
        if ((r108 instanceof Activity) == false) goto L20;
        r105 = (Activity) r108;
    L31:
        Activity r113 = r105;
    L32:
        r109 = r113;
        goto L34
    L20:
        if ((r108 instanceof Application) == true) goto L31;
        if ((r108 instanceof Service) == true) goto L31;
    L24:
        if (r108 == null) goto L31;
        if ((r108 instanceof Activity) == true) goto L27;
        if ((r108 instanceof ContextWrapper) == false) goto L31;
        r108 = ((ContextWrapper) r108).getBaseContext();
        goto L24
    L27:
        r113 = (Activity) r108;
    L7:
        r107 = null;
        goto L9
    }

    public static void d(ECBaseBridgeMethod.a r100, int r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        r103.put(Keys.API_RETURN_KEY_IS_LOGIN, r102);
        r103.put("authStatus", r101);
        Unit r104 = Unit.INSTANCE;
        r100.onSuccess(r103);
    }
}
