package com.bytedance.android.livesdk.tabs;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.monitor.a;
import com.bytedance.android.livesdk.chatroom.monitor.e;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.vscore_api.schema.HorizonXTabSchemaModel;
import com.bytedance.android.livesdk.vscore_api.schema.IHorizonXTabActionHandler;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import xs2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/tabs/HorizonXTabActionHandler;", "Lcom/bytedance/android/livesdk/vscore_api/schema/IHorizonXTabActionHandler;", "Lcom/bytedance/android/livesdk/vscore_api/schema/HorizonXTabSchemaModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "handleXTab", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizonXTabActionHandler implements IHorizonXTabActionHandler<HorizonXTabSchemaModel> {
    public HorizonXTabActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return TextUtils.equals(SchemaHandlerHostConstants.HORIZON_XTAB, r100.getHost());
    }

    public boolean handle(Context r100, HorizonXTabSchemaModel r101) {
        e r102 = a.a();
        if (r102 == null) goto L5;
        r102.i(SchemaHandlerHostConstants.HORIZON_XTAB);
    L5:
        boolean r103 = handleXTab(r100, r101);
        if (r103 == false) goto L9;
        if (r102 == null) goto L9;
        r102.h();
        r102.g();
    L9:
        return r103;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.schema.IHorizonXTabActionHandler
    public boolean handleXTab(Context r100, HorizonXTabSchemaModel r101) {
        b r102 = b.a();
        if (r101 == null) goto L7;
        Integer r103 = r101.getTabId();
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.intValue());
    L8:
        r102.post(new mu2.a(r104));
        return true;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (HorizonXTabSchemaModel) r101);
    }
}
