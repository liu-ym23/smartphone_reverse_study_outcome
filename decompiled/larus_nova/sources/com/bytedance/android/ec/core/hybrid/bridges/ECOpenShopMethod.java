package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECOpenShopMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenShopMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44123e;

    public static final class a {
    }

    static {
    }

    public ECOpenShopMethod() {
        this.f44123e = "openShop";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44123e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        boolean r102 = false;
        Integer r103 = Integer.valueOf(r100.optInt("tab", 0));
        if (r103.intValue() == 0) goto L5;
        boolean r104 = true;
    L6:
        String r105 = null;
        if (r104 == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        int r106 = r103.intValue();
    L13:
        String r107 = r100.optString("product_tab_params");
        if (r107 != null) goto L16;
    L18:
        if (r102 == false) goto L20;
        r105 = r107;
    L20:
        if (r105 != null) goto L23;
        r105 = "";
    L23:
        if (r106 == 0) goto L26;
        s0.a(new ah.d(r106, r105));
        return;
    L26:
        return;
    L16:
        if (r107.length() <= 0) goto L18;
        r102 = true;
        goto L18
    L12:
        r106 = 0;
        goto L13
    L5:
        r104 = false;
        goto L6
    }
}
