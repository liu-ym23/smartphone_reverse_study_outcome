package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.download.IECDownloadAppService;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECDownloadAppAdMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Lqi/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDownloadAppAdMethod extends ECBaseBridgeMethod implements qi.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44111e;

    public static final class a {
    }

    static {
    }

    public ECDownloadAppAdMethod() {
        this.f44111e = "iesecDownloadAppAd";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44111e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        Context r102 = getContext();
        if (r102 != null) goto L14;
        return;
    L14:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L11
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L11
        r104.put("event_tag", r100.opt("eventTag"));     // Catch: Exception -> L11
        r104.put("pkg_name", r100.opt("pkgName"));     // Catch: Exception -> L11
        r104.put("download_url", r100.opt("downloadURL"));     // Catch: Exception -> L11
        r104.put("open_url", r100.opt("openURL"));     // Catch: Exception -> L11
        r103.put("data", r104);     // Catch: Exception -> L11
        int r105 = ECSdk.f48106a;     // Catch: Exception -> L11
        IECHostService r106 = (IECHostService) ECSdk.a(IECHostService.class);     // Catch: Exception -> L11
        if (r106 == null) goto L12;
        IECDownloadAppService r107 = r106.getIECDownloadAppService();     // Catch: Exception -> L11
        if (r107 == null) goto L12;
        r107.downloadApp(r102, r103, this);     // Catch: Exception -> L11
    L12:
        r101.onSuccess(new JSONObject());
        return;
    L11:
        r101.onFailed(-1, "download failed");
        goto L12
    }
}
