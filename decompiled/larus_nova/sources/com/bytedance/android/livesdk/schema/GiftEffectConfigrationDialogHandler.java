package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.GiftEffectConfigurationShowModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/GiftEffectConfigrationDialogHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/GiftEffectConfigurationShowModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectConfigrationDialogHandler implements IBaseSchemaHandler<GiftEffectConfigurationShowModel> {
    public GiftEffectConfigrationDialogHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getHost();
        if (r101 == null) goto L6;
        return r101.equals(SchemaHandlerHostConstants.GIFT_EFFECT_SETTING);
    L6:
        return false;
    }

    public boolean handle(Context r100, GiftEffectConfigurationShowModel r101) {
        IGiftServiceExternal r102 = (IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class);
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.TRUE;
        r102.openGiftEffectConfigurationDialog(r100, r103, r103);
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (GiftEffectConfigurationShowModel) r101);
    }
}
