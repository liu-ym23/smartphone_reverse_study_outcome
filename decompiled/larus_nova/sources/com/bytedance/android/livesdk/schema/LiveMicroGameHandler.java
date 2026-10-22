package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.OpenMicroGameSchemaModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/LiveMicroGameHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/OpenMicroGameSchemaModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMicroGameHandler implements IBaseSchemaHandler<OpenMicroGameSchemaModel> {
    public LiveMicroGameHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(SchemaHandlerHostConstants.LIVE_MG, r100.getHost());
    }

    public boolean handle(Context r100, OpenMicroGameSchemaModel r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        IOpenPlatformMgAudienceService r102 = (IOpenPlatformMgAudienceService) jc1.k.f(IOpenPlatformMgAudienceService.class);
        if (r102 == null) goto L14;
        if (Intrinsics.areEqual(r102.getMicroGameInfo(), r101.getAppId()) == false) goto L14;
        String r103 = (String) ((HashMap) com.bytedance.android.live.schema.helper.h.a(r101.getUri())).get("url");
        if (r103 == null) goto L14;
        r102.openMountedMiniGame(MountedMiniGameSource.LiveRoomBussiness, r103);
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (OpenMicroGameSchemaModel) r101);
    }
}
