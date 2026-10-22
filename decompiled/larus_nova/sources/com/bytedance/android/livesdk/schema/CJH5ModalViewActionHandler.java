package com.bytedance.android.livesdk.schema;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdk.schema.model.CjH5ModalSchemaModel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes11.dex */
public class CJH5ModalViewActionHandler implements IBaseSchemaHandler<CjH5ModalSchemaModel> {
    private static final String URL_PARAM_BACKGROUND = "web_bg_color";
    private static final String URL_PARAM_ENABLE_ANIMATION = "web_enable_animation";
    private static final String URL_PARAM_SCREEN_TYPE = "web_screen_type";

    public CJH5ModalViewActionHandler() {
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public boolean canHandle(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(SchemaHandlerHostConstants.CJ_H5_MODAL_VIEW_SCHEMA_HOST, r100.getHost());
    }

    private String appendTag(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        Uri.Builder r102 = UriProtector.parse(r101).buildUpon();
        r102.appendQueryParameter("tag", r100);
        return r102.build().toString();
    }

    public boolean handle(Context r110, CjH5ModalSchemaModel r111) {
        if (r111 != null) goto L5;
        return false;
    L5:
        String r100 = r111.getUrl();
        String r101 = r111.getTag();
        if (StringUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        String r102 = appendTag(r101, r100);
        String r103 = r111.getWebBgColor();
        if (TextUtils.isEmpty(r103) == false) goto L11;
        r103 = "#01000000";
    L11:
        String r104 = r103;
        String r105 = r111.getWebScreenType();
        if (r111.getWebEnableAnimation() != null) goto L14;
        boolean r106 = false;
    L15:
        zv0.a r107 = ((IRechargeServiceExternal) jc1.k.f(IRechargeServiceExternal.class)).getCJExternalService();
        int r108 = d5.b(r105);
        Uri r112 = r111.getUri();
        ((com.bytedance.android.live.wallet.c) r107).getClass();
        com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).j0(r110, r102, r108, r106, r104, r112);
        return true;
    L14:
        r106 = r111.getWebEnableAnimation().booleanValue();
        goto L15
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler
    public /* bridge */ /* synthetic */ boolean handle(Context r100, BaseSchemaModel r101) {
        return handle(r100, (CjH5ModalSchemaModel) r101);
    }
}
