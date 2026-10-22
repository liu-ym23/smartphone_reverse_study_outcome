package com.android.ttcjpaysdk.facelive.core;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Pair;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFaceCheckService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.facelive.data.GetTicketResponse;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J$\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/FaceLiveAiLabImpl;", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive;", "()V", "callFaceLiveSDK", "", "activity", "Landroid/app/Activity;", "map", "", "", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive$TTCJPayFaceLiveCallback;", "defaultCallback", "logMsg", "doFace", "ticketResponse", "Lcom/android/ttcjpaysdk/facelive/data/GetTicketResponse;", "extra", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$IExtra;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceLiveAiLabImpl implements IFaceLive {
    public FaceLiveAiLabImpl() {
    }

    private final void defaultCallback(TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r100, String r101) {
        FaceService.Companion.getClass();
        Pair<Integer, String> r102 = FaceService.a.f202222b;
        r100.onResult(FaceService.a.a(((Number) r102.first).intValue(), ((Number) r102.first).intValue(), (String) r102.second, r101));
        CJLogger.d("FaceLiveAiLabImpl", r101);
    }

    private final void callFaceLiveSDK(Activity r110, Map<String, String> r111, final TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r112) {
        long r100 = SystemClock.elapsedRealtime();
        HashMap r101 = MapsKt.hashMapOf(new kotlin.Pair[]{TuplesKt.to("input_param", new JSONObject(r111).toString())});
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.h(r102, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_call_face_cert_start", r101, null, 56);
        TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r103 = new FaceLiveAiLabImpl$callFaceLiveSDK$targetCallback$1(r112);
        ICJPayFaceCheckService r104 = (ICJPayFaceCheckService) CJPayServiceManager.getInstance().getIService(ICJPayFaceCheckService.class);
        if (r104 == null) goto L5;
        r104.invokeFace(r110, r111, r103);
        Unit r113 = Unit.INSTANCE;
    L6:
        if (r113 != null) goto L8;
        defaultCallback(r112, "ICJPayFaceCheckService is null");
    L8:
        r101.put("duration", Long.valueOf(SystemClock.elapsedRealtime() - r100));
        CJReporter.h(r102, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_call_face_cert_end", r101, null, 56);
        return;
    L5:
        r113 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.facelive.core.IFaceLive
    public void doFace(Activity r100, GetTicketResponse r110, IFaceLive.IExtra r111) {
        Intrinsics.checkNotNullParameter(r110, "ticketResponse");
        kotlin.Pair[] r101 = new kotlin.Pair[6];     // Catch: Throwable -> L32
        if (r110.face_scene.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        String r103 = r110.face_scene;     // Catch: Throwable -> L32
    L10:
        r101[0] = TuplesKt.to("scene", r103);     // Catch: Throwable -> L32
        r101[1] = TuplesKt.to("mode", "0");     // Catch: Throwable -> L32
        r101[2] = TuplesKt.to("ticket", r110.ticket);     // Catch: Throwable -> L32
        Map<String, String> r104 = null;
        if (r111 == null) goto L20;
        String r105 = r111.getCertAppId();     // Catch: Throwable -> L32
        if (r105 == null) goto L20;
        if ((!StringsKt.isBlank(r105)) == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
    L21:
        r101[3] = TuplesKt.to("cert_app_id", r105);     // Catch: Throwable -> L32
        r101[4] = TuplesKt.to("use_new_api", "true");     // Catch: Throwable -> L32
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L32
        KtSafeMethodExtensionKt.safePut(r106, "source", CJPayFaceLiveManager.INSTANCE.getUploadSource());     // Catch: Throwable -> L32
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L32
        r101[5] = TuplesKt.to("eventParams", r106.toString());     // Catch: Throwable -> L32
        Map<String, String> r108 = MapsKt.mutableMapOf(r101);     // Catch: Throwable -> L32
        if (r111 == null) goto L30;
        Map<String, String> r109 = r111.getCertConfig();     // Catch: Throwable -> L32
        if (r109 == null) goto L30;
        if ((true ^ r109.isEmpty()) == false) goto L28;
        r104 = r109;
    L28:
        if (r104 == null) goto L30;
        r108.putAll(r104);     // Catch: Throwable -> L32
    L30:
        callFaceLiveSDK(r100, r108, new FaceCheckCallback(new WeakReference(r100), r110.scene, r110.ticket, r111));     // Catch: Throwable -> L32
        return;
    L20:
        r105 = "1792";
        goto L21
    L9:
        r103 = r110.scene;     // Catch: Throwable -> L32
        goto L10
    L6:
        r102 = false;
    L32:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("FaceLiveAiLabImpl#doFace", th);
        CJBasicCommonUtils.logCatch("CJCatch", "FaceLiveAiLabImpl#doFace", th);
        CJReporter r112 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "FaceLiveAiLab_doFace", 0, th);
    }
}
