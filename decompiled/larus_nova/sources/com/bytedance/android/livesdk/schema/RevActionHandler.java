package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.RevSchemaTempModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/RevActionHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseSchemaHandler;", "Lcom/bytedance/android/livesdk/schema/model/RevSchemaTempModel;", "()V", "canHandle", "", "uri", "Landroid/net/Uri;", "handle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevActionHandler implements IBaseSchemaHandler<RevSchemaTempModel> {
    public RevActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        com.bytedance.android.live.revenue.a r102 = (com.bytedance.android.live.revenue.a) com.bytedance.android.live.revenue.core.util.h.e(com.bytedance.android.live.revenue.a.class);
        if (r102 != null) goto L8;
        return false;
    L8:
        return r102.p5(r100);
    }

    public boolean handle(Context r100, RevSchemaTempModel r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        com.bytedance.android.live.revenue.a r103 = (com.bytedance.android.live.revenue.a) com.bytedance.android.live.revenue.core.util.h.e(com.bytedance.android.live.revenue.a.class);
        if (r103 == null) goto L12;
        if (r101 == null) goto L12;
        Uri r104 = r101.getUri();
        if (r104 == null) goto L12;
        r103.J3(r100, r104);
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (RevSchemaTempModel) r101);
    }
}
