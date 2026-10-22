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
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/HideTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HideTaskBannerMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ecomHideTaskBanner";
    }

    public HideTaskBannerMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("containerID");
        Map<String, LynxTaskBanner> r103 = LynxTaskBanner.f44339i;
        if (r102 != null) goto L5;
        boolean r104 = false;
    L10:
        if (r104 == false) goto L17;
        r101.onSuccess(new JSONObject());
        WeakReference<Function1<String, Unit>> r105 = com.bytedance.android.shopping.hybrid.bridges.a.f176219b;
        if (r105 == null) goto L14;
        Function1<String, Unit> r106 = r105.get();
    L15:
        if (r106 == null) goto L19;
        Unit r107 = r106.invoke(r102);
        return;
    L19:
        return;
    L14:
        r106 = null;
        goto L15
    L17:
        r101.onFailed(0, "invalid containerID");
        return;
    L5:
        Map<String, LynxTaskBanner> r108 = LynxTaskBanner.f44339i;
        LynxTaskBanner r109 = (LynxTaskBanner) ((LinkedHashMap) r108).get(r102);
        if (r109 == null) goto L8;
        r109.b();
        r104 = true;
    L9:
        r108.remove(r102);
        goto L10
    L8:
        r104 = false;
        goto L9
    }
}
