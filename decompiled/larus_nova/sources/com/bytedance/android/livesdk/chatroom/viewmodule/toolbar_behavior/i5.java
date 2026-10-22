package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.xl;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class i5 implements Consumer<Response<com.bytedance.android.livesdk.chatroom.model.k3>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f117246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareParams.Builder f117247b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Response<com.bytedance.android.livesdk.chatroom.model.k3> r100) throws Exception {
        Response<com.bytedance.android.livesdk.chatroom.model.k3> r101 = r100;
        if (r101 != null) goto L6;
        ALogger.e(MoreMixSharePanelUtils.TAG, ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL);
        return;
    L6:
        if (r101.statusCode != 0) goto L30;
        com.bytedance.android.livesdk.chatroom.model.k3 r102 = r101.data;
        if (r102 != null) goto L11;
        ALogger.e(MoreMixSharePanelUtils.TAG, "ShopGuideID Error: response.data == null，获取导购信息失败! ");
        return;
    L11:
        if (r102.b() == null) goto L16;
        if (xl.f121614a.getValue().booleanValue() == false) goto L16;
        this.f117246a.putAll(r101.data.b());
    L16:
        if (r101.data.a() != null) goto L18;
    L24:
        ALogger.e(MoreMixSharePanelUtils.TAG, "ShopGuideID Error: 导购信息 == null! ");
    L25:
        m50 r103 = m50.f120732a;
        if (r103.getValue().p() == false) goto L28;
    L29:
        this.f117247b.setEnableLandscapeOpt(true);
        return;
    L28:
        if (r103.getValue().o() == true) goto L29;
        return;
    L18:
        if (r101.data.a().booleanValue() != true) goto L24;
        if (StringUtils.isEmpty(r101.data.c()) == true) goto L24;
        if (StringUtils.isEmpty(r101.data.d()) == true) goto L24;
        this.f117247b.setUrl(r101.data.c());
        this.f117247b.getExtras().putString(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID, r101.data.d());
        goto L25
    L30:
        ALogger.e(MoreMixSharePanelUtils.TAG, "ShopGuideID Error: response.statusCode != 0! ");
    }

    public i5(HashMap r100, ShareParams.Builder r101) {
        this.f117246a = r100;
        this.f117247b = r101;
    }
}
