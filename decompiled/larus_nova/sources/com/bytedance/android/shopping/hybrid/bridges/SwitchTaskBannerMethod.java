package com.bytedance.android.shopping.hybrid.bridges;

import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/SwitchTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchTaskBannerMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecomSwtichTaskBannerVisible";
    }

    public SwitchTaskBannerMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("containerID");
        int r103 = 0;
        if (r100.optInt("visible", 0) != 0) goto L5;
        boolean r104 = true;
    L6:
        Map<String, LynxTaskBanner> r105 = LynxTaskBanner.f44339i;
        if (r102 == null) goto L15;
        LynxTaskBanner r106 = (LynxTaskBanner) ((LinkedHashMap) LynxTaskBanner.f44339i).get(r102);
        if (r106 == null) goto L15;
        if (r104 == true) goto L14;
        r103 = 8;
    L14:
        r106.setVisibility(r103);
    L15:
        Function1<String, Unit> r107 = null;
        if (r104 == false) goto L23;
        WeakReference<Function3<JSONObject, String, Boolean, Unit>> r108 = com.bytedance.android.shopping.hybrid.bridges.a.f176218a;
        if (r108 == null) goto L20;
        Function3<JSONObject, String, Boolean, Unit> r109 = r108.get();
    L21:
        if (r109 == null) goto L29;
        Unit r110 = r109.invoke(null, r102, Boolean.TRUE);
        return;
    L29:
        return;
    L20:
        r109 = null;
        goto L21
    L23:
        WeakReference<Function1<String, Unit>> r111 = com.bytedance.android.shopping.hybrid.bridges.a.f176219b;
        if (r111 == null) goto L26;
        r107 = r111.get();
    L26:
        if (r107 == null) goto L31;
        Unit r112 = r107.invoke(r102);
        return;
    L31:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
