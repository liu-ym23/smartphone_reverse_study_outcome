package com.android.ttcjpaysdk.facelive.core;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.eventbus.Observer;
import com.android.ttcjpaysdk.base.framework.event.CJBackToPayHomeEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayConfirmAfterGetFaceDataEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishH5ActivityEvent;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import com.android.ttcjpaysdk.base.service.bean.CJPayH5ToAnnieXConfig;
import com.android.ttcjpaysdk.base.service.bean.H5ParamBuilder;
import com.android.ttcjpaysdk.base.service.bean.WebViewCommonConfig;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.android.ttcjpaysdk.facelive.data.GetTicketResponse;
import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.TTPayAnnieContainerImpl;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ve4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J\u001b\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00140\u0013H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/FaceLiveKSImpl;", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive;", "Lcom/android/ttcjpaysdk/base/eventbus/Observer;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "()V", "CJTag", "", "doFace", "", "activity", "Landroid/app/Activity;", "ticketResponse", "Lcom/android/ttcjpaysdk/facelive/data/GetTicketResponse;", "extra", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$IExtra;", "isFromFaceVerifyFullPage", "", "enterFrom", "listEvents", "", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "()[Ljava/lang/Class;", "onEvent", "event", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceLiveKSImpl implements IFaceLive, Observer, ICJTag {
    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "FaceLiveKSImpl";
    }

    @Override // com.android.ttcjpaysdk.base.eventbus.Observer
    public Class<? extends BaseEvent>[] listEvents() {
        return new Class[]{CJPayFinishH5ActivityEvent.class, CJPayConfirmAfterGetFaceDataEvent.class};
    }

    public FaceLiveKSImpl() {
        EventManager.INSTANCE.register(this);
    }

    private final boolean isFromFaceVerifyFullPage(String r100) {
        if (Intrinsics.areEqual("enter_from_face_verify_native", r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual("enter_from_face_verify_h5", r100) == true) goto L10;
        if (Intrinsics.areEqual("enter_from_face_verify_bullet", r100) == true) goto L10;
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.eventbus.Observer
    public void onEvent(BaseEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof CJPayFinishH5ActivityEvent) == false) goto L8;
        if (((CJPayFinishH5ActivityEvent) r100).isFromFaceNative() == false) goto L8;
        EventManager r101 = EventManager.INSTANCE;
        r101.notify(new CJBackToPayHomeEvent(false, 1, null));
        r101.unregister(this);
        return;
    L8:
        if ((r100 instanceof CJPayConfirmAfterGetFaceDataEvent) == true) goto L10;
        return;
    L10:
        if (isFromFaceVerifyFullPage(((CJPayConfirmAfterGetFaceDataEvent) r100).enterFrom) == false) goto L12;
        EventManager.INSTANCE.notifyLast(r100);
    L12:
        EventManager.INSTANCE.unregister(this);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // com.android.ttcjpaysdk.facelive.core.IFaceLive
    public void doFace(Activity r110, GetTicketResponse r210, IFaceLive.IExtra r211) {
        Intrinsics.checkNotNullParameter(r210, "ticketResponse");
        if (r110 == null) goto L78;
        if (TextUtils.isEmpty(r210.ticket) == true) goto L78;
        ICJPayH5Service r100 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        H5ParamBuilder r101 = new H5ParamBuilder().setUrl(r210.ticket).setContext(r110).setTitle(r110.getString(R.string.cj_pay_face_check)).setDisableH5History(true);
        if (r211 == null) goto L9;
        String r102 = r211.getEnterFrom();
    L10:
        String r111 = CJPayFinishH5ActivityEvent.ENTER_FROM_FACE_PLUS_CHECK_NATIVE;
        if (r102 == null) goto L26;
        int r112 = r102.hashCode();
        if (r112 == (-498618305)) goto L23;
        if (r112 == 333643636) goto L19;
        if (r112 != 658958985) goto L26;
        r102.equals("enter_from_face_verify_native");
        goto L26
    L19:
        if (r102.equals("enter_from_face_verify_bullet") == false) goto L26;
        r111 = CJPayFinishH5ActivityEvent.ENTER_FROM_FACE_PLUS_CHECK_BULLET;
        goto L26
    L23:
        if (r102.equals("enter_from_face_verify_h5") == false) goto L26;
        r111 = CJPayFinishH5ActivityEvent.ENTER_FROM_FACE_PLUS_CHECK_H5;
    L26:
        H5ParamBuilder r103 = r101.setEnterFrom(r111);
        if (r211 == null) goto L29;
        String r104 = r211.getEnterFrom();
    L30:
        boolean r113 = false;
        if (r104 == null) goto L50;
        int r105 = r104.hashCode();
        ICJPayH5Service r114 = r100;
        if (r105 == (-498618305)) goto L47;
        if (r105 == 333643636) goto L43;
        if (r105 == 658958985) goto L40;
    L51:
        Map<String, String> r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("clientSource", String.valueOf(CJPayFaceLiveManager.INSTANCE.getSource())), TuplesKt.to("scene", r210.scene), TuplesKt.to("faceScene", r210.face_scene), TuplesKt.to(CJDyPayResult.EXT_K_RETURN_URL, CJPayConstant.FACE_LITE_RETURN_URL)});
    L52:
        H5ParamBuilder r107 = r103.setExtendParams(r106);
        WebViewCommonConfig r108 = CJPaySettingsManager.getInstance().getWebViewCommonConfig();
        if (r108 == null) goto L55;
        CJPayH5ToAnnieXConfig r109 = r108.cj_h5_to_anniex_config;
    L56:
        FacePPRedirectLogger r115 = new FacePPRedirectLogger();
        if (r109 == null) goto L59;
        Boolean r116 = Boolean.valueOf(r109.enable_facepp);
    L60:
        if (r116 == null) goto L62;
        boolean r117 = r116.booleanValue();
    L63:
        r115.setSettingsEnable(r117);
        if (r109 == null) goto L66;
        Boolean r118 = Boolean.valueOf(r109.enable_facepp);
    L67:
        if (r118 == null) goto L70;
        r113 = r118.booleanValue();
    L70:
        if (r113 == false) goto L75;
        r115.setContainer("anniex");
        String r119 = new Uri.Builder().scheme(ShareChannel.DOUYIN).authority("webview").appendQueryParameter("bid", TTPayAnnieContainerImpl.CAIJING_BID).appendQueryParameter("url", r210.ticket).appendQueryParameter("title", r107.getTitle()).appendQueryParameter("enable_third_party_web_ui", "1").appendQueryParameter("ttpay_annie_query", new Uri.Builder().appendQueryParameter("cj_biz", "face_verify").appendQueryParameter("extend_params", r107.getExtendParams()).appendQueryParameter("enter_from", r107.getEnterFrom()).appendQueryParameter("use_cj_title_bar", "1").build().getQuery()).build().toString();
        IContainerHostDepend r120 = (IContainerHostDepend) b.b(IContainerHostDepend.class);
        if (r120 == null) goto L74;
        r120.openSchema(r119, r110);
    L76:
        r115.report();
        return;
    L74:
        ICJTag.DefaultImpls.e$default(this, "[doFace] IHostContainerInfo is null", null, 2, null);
        r115.setContainer("cj_h5");
        r115.setFallbackCJH5(true);
        r114.startH5(r107);
        goto L76
    L75:
        r115.setContainer("cj_h5");
        r114.startH5(r107);
        goto L76
    L66:
        r118 = null;
        goto L67
    L62:
        r117 = false;
        goto L63
    L59:
        r116 = null;
        goto L60
    L55:
        r109 = null;
        goto L56
    L40:
        if (r104.equals("enter_from_face_verify_native") == false) goto L51;
        r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("clientSource", String.valueOf(CJPayFaceLiveManager.INSTANCE.getSource())), TuplesKt.to("scene", r210.scene), TuplesKt.to("faceScene", r210.face_scene), TuplesKt.to("enterFrom", "enter_from_face_verify_native"), TuplesKt.to(CJDyPayResult.EXT_K_RETURN_URL, CJPayConstant.FACE_LITE_RETURN_URL)});
        goto L52
    L43:
        if (r104.equals("enter_from_face_verify_bullet") == false) goto L51;
        r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("clientSource", "1003"), TuplesKt.to("scene", r210.scene), TuplesKt.to("faceScene", r210.face_scene), TuplesKt.to("enterFrom", "enter_from_face_verify_bullet"), TuplesKt.to(CJDyPayResult.EXT_K_RETURN_URL, CJPayConstant.FACE_LITE_RETURN_URL)});
        goto L52
    L47:
        if (r104.equals("enter_from_face_verify_h5") == false) goto L51;
        r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to("clientSource", "4000"), TuplesKt.to("scene", r210.scene), TuplesKt.to("faceScene", r210.face_scene), TuplesKt.to("enterFrom", "enter_from_face_verify_h5"), TuplesKt.to(CJDyPayResult.EXT_K_RETURN_URL, CJPayConstant.FACE_LITE_RETURN_URL)});
        goto L52
    L50:
        r114 = r100;
        goto L51
    L29:
        r104 = null;
        goto L30
    L9:
        r102 = null;
    }
}
