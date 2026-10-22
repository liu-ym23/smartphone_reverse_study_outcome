package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.AnchorOpenLotterySchemaModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/AnchorOpenLotteryHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/AnchorOpenLotterySchemaModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorOpenLotteryHandler implements IBaseSchemaHandler<AnchorOpenLotterySchemaModel> {
    public AnchorOpenLotteryHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getHost();
        if (r101 == null) goto L6;
        return r101.equals(SchemaHandlerHostConstants.ANCHOR_OPEN_LOTTERY_SCHEMA_HOST);
    L6:
        return false;
    }

    public boolean handle(Context r100, AnchorOpenLotterySchemaModel r101) {
        com.bytedance.android.live.profit.lottery.i r102 = yt0.c.f();
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.k<Unit> r103 = r102.getOnToolbarButtonClick();
        if (r103 == null) goto L10;
        r103.post(Unit.INSTANCE);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (AnchorOpenLotterySchemaModel) r101);
    }
}
