package com.bytedance.android.livesdkapi.openplatform;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/openplatform/OpenPlatformOuterServiceDummy;", "Lcom/bytedance/android/livesdkapi/openplatform/IOpenPlatformOuterService;", "()V", "invokeLiveOpenApi", "", "appId", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/android/livesdkapi/openplatform/LiveOpenApiCallback;", "openExplainCardSettingDialog", "openMiniGameAnchorPanel", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformOuterServiceDummy implements IOpenPlatformOuterService {
    @Override // com.bytedance.android.livesdkapi.openplatform.IOpenPlatformOuterService
    public void invokeLiveOpenApi(String r100, JSONObject r101, LiveOpenApiCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // com.bytedance.android.livesdkapi.openplatform.IOpenPlatformOuterService
    public void openExplainCardSettingDialog(String r100, JSONObject r101, LiveOpenApiCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // com.bytedance.android.livesdkapi.openplatform.IOpenPlatformOuterService
    public void openMiniGameAnchorPanel(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    public OpenPlatformOuterServiceDummy() {
        k.l(IOpenPlatformOuterService.class, this);
    }
}
