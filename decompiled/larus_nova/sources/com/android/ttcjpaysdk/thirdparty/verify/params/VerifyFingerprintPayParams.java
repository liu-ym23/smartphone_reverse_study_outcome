package com.android.ttcjpaysdk.thirdparty.verify.params;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintService;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBioOpenAndPayInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J3\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J3\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001aR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyFingerprintPayParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "isFingerprintAdded", "", "isLocalFingerprintTokenCleared", "fingerDegradeReason", "", "isActiveCancelFinger", "fingerPrintIsWindowStyle", "Lkotlin/Function0;", "isFingerprintOpenAndPay", "bioOpenAndPayInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayBioOpenAndPayInfo;", "(ZZLjava/lang/String;ZLkotlin/jvm/functions/Function0;ZLcom/android/ttcjpaysdk/thirdparty/data/CJPayBioOpenAndPayInfo;)V", "getVerifyInfo", "Lorg/json/JSONObject;", "isLocalFingerUnableExp", "(Ljava/lang/Boolean;)Lorg/json/JSONObject;", "setLocalFingerprintTokenCleared", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uid", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "(Landroid/content/Context;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/CJPayHostInfo;Ljava/lang/Boolean;)V", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;)V", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyFingerprintPayParams implements CJPayObject {
    public CJPayBioOpenAndPayInfo bioOpenAndPayInfo;
    public String fingerDegradeReason;
    public Function0<Boolean> fingerPrintIsWindowStyle;
    public boolean isActiveCancelFinger;
    public boolean isFingerprintAdded;
    public boolean isFingerprintOpenAndPay;
    public boolean isLocalFingerprintTokenCleared;

    public VerifyFingerprintPayParams() {
        this(false, false, null, false, null, false, null, 127, null);
    }

    public final JSONObject getVerifyInfo(Boolean r100) {
        if (this.isFingerprintAdded == false) goto L5;
    L8:
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L11;
        boolean r102 = r100.booleanValue();
    L12:
        if (r102 == false) goto L14;
        String r103 = "localUnable";
    L15:
        KtSafeMethodExtensionKt.safePut(r101, "verify_change_type", r103);
        return r101;
    L14:
        r103 = GearStrategyConsts.EV_DOWNGRADE_TYPE;
        goto L15
    L11:
        r102 = false;
        goto L12
    L5:
        if (this.isLocalFingerprintTokenCleared == true) goto L8;
        return null;
    }

    public final void setLocalFingerprintTokenCleared(Context r100, String r101, JSONObject r102, Boolean r103) {
        boolean r104 = true;
        this.isLocalFingerprintTokenCleared = true;
        boolean r105 = false;
        if (r103 == null) goto L5;
        boolean r106 = r103.booleanValue();
    L6:
        if (r106 == false) goto L21;
        if (r101 != null) goto L9;
        Boolean r107 = null;
    L14:
        if (r107 == null) goto L16;
        r105 = r107.booleanValue();
    L16:
        if (r105 == false) goto L22;
        ICJPayFingerprintService r108 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        if (r108 == null) goto L23;
        r108.closeFingerprintByUserInfo(r100, r101, r102);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if (r101.length() > 0) goto L12;
        r104 = false;
    L12:
        r107 = Boolean.valueOf(r104);
        goto L14
    L21:
        return;
    L5:
        r106 = false;
        goto L6
    }

    public final void setLocalFingerprintTokenCleared(Context r100, String r101, CJPayHostInfo r102, Boolean r103) {
        setLocalFingerprintTokenCleared(r100, r101, CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r102, null, 2, null), r103);
    }

    public VerifyFingerprintPayParams(boolean r100, boolean r101, String r102, boolean r103, Function0<Boolean> r104, boolean r105, CJPayBioOpenAndPayInfo r106) {
        Intrinsics.checkNotNullParameter(r102, "fingerDegradeReason");
        this.isFingerprintAdded = r100;
        this.isLocalFingerprintTokenCleared = r101;
        this.fingerDegradeReason = r102;
        this.isActiveCancelFinger = r103;
        this.fingerPrintIsWindowStyle = r104;
        this.isFingerprintOpenAndPay = r105;
        this.bioOpenAndPayInfo = r106;
    }

    public /* synthetic */ VerifyFingerprintPayParams(boolean r100, boolean r101, String r102, boolean r103, Function0 r110, boolean r111, CJPayBioOpenAndPayInfo r112, int r113, DefaultConstructorMarker r114) {
        boolean r104 = false;
        if ((r113 & 1) == 0) goto L5;
        boolean r115 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = "";
    L13:
        String r106 = r102;
        if ((r113 & 8) == 0) goto L16;
        boolean r107 = false;
    L18:
        if ((r113 & 16) == 0) goto L20;
        Function0 r108 = null;
    L22:
        if ((r113 & 32) != 0) goto L26;
        r104 = r111;
    L26:
        if ((r113 & 64) == 0) goto L28;
        CJPayBioOpenAndPayInfo r116 = null;
    L29:
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L28:
        r116 = r112;
        goto L29
    L20:
        r108 = r110;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
