package com.android.ttcjpaysdk.facelive.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u00012\u00020\u0002B»\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\r\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\nJ\r\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\nR\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/data/FaceVerifyParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "serverSource", "", "clientSource", "", "orderId", "liveRoute", "isShowDialog", "", "hostInfo", "Lorg/json/JSONObject;", "showStyle", "skipCheckAgreement", "buttonDesc", "uid", "faceScene", "logSource", "title", "iconUrl", "isSigned", "enterFrom", "configurationParams", "extParams", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCertAppId", "getEncryptVersion", "()Ljava/lang/Integer;", "getPathPrefix", "getPublicKey", "getServerDomain", "hasSrc", "hitFintech", "()Ljava/lang/Boolean;", "isAILab", "isAliYun", "isBindCard", "isEnterFromBullet", "isEnterFromH5", "isEnterFromNative", "isFacePlus", "isPayment", "isPaymentPay", "isPaymentVerify", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceVerifyParams implements CJPayObject, Serializable {
    public String buttonDesc;
    public int clientSource;
    public String configurationParams;
    public String enterFrom;
    public String extParams;
    public String faceScene;
    public JSONObject hostInfo;
    public String iconUrl;
    public boolean isShowDialog;
    public boolean isSigned;
    public String liveRoute;
    public String logSource;
    public String orderId;
    public String serverSource;
    public String showStyle;
    public boolean skipCheckAgreement;
    public String title;
    public String uid;

    public FaceVerifyParams() {
        this(null, 0, null, null, false, null, null, false, null, null, null, null, null, null, false, null, null, null, 262143, null);
    }

    public final String getCertAppId() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((String) KtSafeMethodExtensionKt.tf(r102.has("cert_app_id"), r102.optString("cert_app_id"), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r100 = r103;
    L12:
        return (String) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final Integer getEncryptVersion() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((Integer) KtSafeMethodExtensionKt.tf(r102.has("encrypt_version"), Integer.valueOf(r102.optInt("encrypt_version")), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r100 = r103;
    L12:
        return (Integer) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final String getPathPrefix() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((String) KtSafeMethodExtensionKt.tf(r102.has("path_prefix"), r102.optString("path_prefix"), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r100 = r103;
    L12:
        return (String) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final String getPublicKey() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((String) KtSafeMethodExtensionKt.tf(r102.has("public_key"), r102.optString("public_key"), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r100 = r103;
    L12:
        return (String) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final String getServerDomain() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((String) KtSafeMethodExtensionKt.tf(r102.has("server_domain"), r102.optString("server_domain"), null));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r100 = r103;
    L12:
        return (String) r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean hasSrc() {
        return Intrinsics.areEqual(this.faceScene, "cj_live_check");
    }

    public final Boolean hitFintech() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r101 = new JSONObject(this.extParams);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(((Boolean) KtSafeMethodExtensionKt.tf(r101.has("is_fintech"), Boolean.valueOf(Intrinsics.areEqual(r101.optString("is_fintech"), "1")), Boolean.FALSE)).booleanValue()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (Boolean) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean isAILab() {
        return Intrinsics.areEqual(this.liveRoute, "AILABFIA");
    }

    public final boolean isAliYun() {
        return Intrinsics.areEqual(this.liveRoute, "ALIYUNFIA");
    }

    public final boolean isEnterFromBullet() {
        return Intrinsics.areEqual("enter_from_face_verify_bullet", this.enterFrom);
    }

    public final boolean isEnterFromH5() {
        return Intrinsics.areEqual("enter_from_face_verify_h5", this.enterFrom);
    }

    public final boolean isEnterFromNative() {
        return Intrinsics.areEqual("enter_from_face_verify_native", this.enterFrom);
    }

    public final boolean isFacePlus() {
        return Intrinsics.areEqual(this.liveRoute, "KSKJFIA");
    }

    public final boolean isBindCard() {
        return CollectionsKt.listOf(new String[]{"普通绑卡", "一键绑卡", "云闪付绑卡"}).contains(this.logSource);
    }

    public final boolean isPayment() {
        if (isPaymentPay() == false) goto L5;
    L8:
        return true;
    L5:
        if (isPaymentVerify() == true) goto L8;
        return false;
    }

    public final boolean isPaymentPay() {
        return CollectionsKt.listOf(new String[]{"未输错密码-刷脸支付", "输错密码-刷脸支付", "极速付-加验", "密码页挽留弹窗", "忘记密码-刷脸支付", "密码锁定-刷脸支付", "挽留弹窗-刷脸支付", "密码未锁定-刷脸支付", "右上角-刷脸支付"}).contains(this.logSource);
    }

    public final boolean isPaymentVerify() {
        return CollectionsKt.listOf(new String[]{"密码-加验", "CVV-加验", "指纹-加验", "免密-加验", "大额支付", "对公转账", "免验证-加验", "设置密码并支付", "密码未锁定-刷脸支付"}).contains(this.logSource);
    }

    public FaceVerifyParams(String r110, int r111, String r112, String r113, boolean r210, JSONObject r211, String r212, boolean r213, String r214, String r215, String r216, String r217, String r218, String r219, boolean r310, String r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r110, "serverSource");
        Intrinsics.checkNotNullParameter(r112, "orderId");
        Intrinsics.checkNotNullParameter(r113, "liveRoute");
        Intrinsics.checkNotNullParameter(r212, "showStyle");
        Intrinsics.checkNotNullParameter(r214, "buttonDesc");
        Intrinsics.checkNotNullParameter(r215, "uid");
        Intrinsics.checkNotNullParameter(r216, "faceScene");
        Intrinsics.checkNotNullParameter(r217, "logSource");
        Intrinsics.checkNotNullParameter(r218, "title");
        Intrinsics.checkNotNullParameter(r219, "iconUrl");
        Intrinsics.checkNotNullParameter(r311, "enterFrom");
        Intrinsics.checkNotNullParameter(r312, "configurationParams");
        Intrinsics.checkNotNullParameter(r313, "extParams");
        this.serverSource = r110;
        this.clientSource = r111;
        this.orderId = r112;
        this.liveRoute = r113;
        this.isShowDialog = r210;
        this.hostInfo = r211;
        this.showStyle = r212;
        this.skipCheckAgreement = r213;
        this.buttonDesc = r214;
        this.uid = r215;
        this.faceScene = r216;
        this.logSource = r217;
        this.title = r218;
        this.iconUrl = r219;
        this.isSigned = r310;
        this.enterFrom = r311;
        this.configurationParams = r312;
        this.extParams = r313;
    }

    public /* synthetic */ FaceVerifyParams(String r210, int r211, String r212, String r213, boolean r214, JSONObject r215, String r216, boolean r217, String r218, String r219, String r310, String r311, String r312, String r313, boolean r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r318 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r318 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r318 & 32) == 0) goto L25;
        JSONObject r105 = new JSONObject();
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r318 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r107 = "";
    L59:
        if ((r318 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r318 & 131072) == 0) goto L73;
        String r109 = "";
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r107 = r313;
        goto L59
    L53:
        r115 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
