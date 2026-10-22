package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.browser.jsbridge.base.ShareImageUrlToPanelResultModel;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.qe;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareImageUrlToPanel")
public final class kc extends w20.i6<qe, ShareImageUrlToPanelResultModel> {

    public static final class a {
    }

    static {
    }

    public kc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r210, CallContext r211) {
        qe r100 = (qe) r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        HashMap<String, String> r101 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r102 == null) goto L5;
        r101.putAll(r102.getMap());
    L5:
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r102 == null) goto L8;
        r101.putAll(r103.getMap());
    L8:
        r101.put("enter_from", "sjb_afterheat");
        r101.put(IPerformanceManager.Params.room_type, "h5_activity");
        r101.put("content_type", "sjb_afterheat");
        r101.put("sjb_content_type", "sjb_afterheat");
        ILiveService r104 = TTLiveService.getLiveService();
        if (r104 == null) goto L11;
        ILiveQrCodeShareHelper r105 = r104.getQrCodeShareHelper(5);
    L12:
        int r106 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r100.d()) == false) goto L16;
        if (r105 == null) goto L16;
        r105.setRaceLogo(new ImageModel(r100.d(), CollectionsKt.listOf(r100.d())));
    L16:
        if (r105 == null) goto L18;
        r105.setOriginalPic(new ImageModel(r100.a(), CollectionsKt.listOf(r100.a())));
    L18:
        LiveQrCodeConfig r107 = new LiveQrCodeConfig();
        r107.setPanelType(4);
        if ((r105 instanceof IQrCodeShareHelper) == true) goto L21;
        ILiveQrCodeShareHelper r108 = null;
    L22:
        IQrCodeShareHelper r109 = (IQrCodeShareHelper) r108;
        if (r109 == null) goto L25;
        r107.setQrCodeShareHelper(r109);
    L25:
        ShareParams.Builder r110 = ShareParams.builder();
        if (r110 == null) goto L42;
        r110.setUrl(r100.b());
        r110.setShareSceneConfigName(r100.c());
        r110.setLiveQrCodeConfig(r107);
        r110.setShareSubScene(ShareSubScene.LiveAfterMatch);
        r110.setLogExtraParams(r101);
        r110.setEnterFrom("sjb_afterheat");
        SharePublishParam r111 = new SharePublishParam();
        if (r105 == null) goto L31;
        String r112 = r105.getRelatedReviewContent();
        if (r112 == null) goto L31;
    L32:
        r111.setRelatedReviewContent(r112);
        Unit r113 = Unit.INSTANCE;
        r110.setSharePublishParam(r111);
        ShareParams r114 = r110.build();
        if (r114 == null) goto L42;
        Context r115 = r211.getContext();
        if ((r115 instanceof Activity) == true) goto L37;
        r115 = null;
    L37:
        Activity r116 = (Activity) r115;
        if (r116 == null) goto L40;
        Activity r117 = r116;
    L41:
        ((ILiveShareService) jc1.k.n(ILiveShareService.class)).share(new i81.a(null, r117, null, r114, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareImageUrlToPanelMethod", LiveShareType.SHARE_DIALOG, null);
        goto L42
    L40:
        r117 = null;
    L31:
        r112 = "";
    L42:
        finishWithSuccess();
        return;
    L21:
        r108 = r105;
        goto L22
    L11:
        r105 = null;
        goto L12
    }
}
