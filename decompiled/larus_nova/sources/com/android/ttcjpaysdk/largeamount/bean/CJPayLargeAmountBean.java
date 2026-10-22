package com.android.ttcjpaysdk.largeamount.bean;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayVerifyIdentityInfo;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BÍ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cR\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/largeamount/bean/CJPayLargeAmountBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "uid", "", "merchant_id", "app_id", b.A0, b.B0, "need_face", "need_identity", SendClosePdpEventParam.KEY_LYNX_URL, CrashHianalyticsData.PROCESS_ID, "need_bind_card", "need_query_face_data", "need_query_identity_data", "zg_app_id", "zg_merchant_id", "track_info", "need_open_account", "open_account_url", "banks_url", "verify_identity", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayVerifyIdentityInfo;", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayVerifyIdentityInfo;)V", "isNeedBindCard", "", "isNeedFace", "isNeedGotoBanks", "isNeedOpenAccount", "isNeedQueryFaceInfo", "isNeedQueryVerifyInfo", "isNeedVerifyIdentity", "base-pay-largeamount_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLargeAmountBean implements CJPayObject, Serializable {
    public String app_id;
    public String banks_url;
    public CJPayFaceVerifyInfo face_verify_info;
    public String lynx_url;
    public String merchant_id;
    public String need_bind_card;
    public String need_face;
    public String need_identity;
    public String need_open_account;
    public String need_query_face_data;
    public String need_query_identity_data;
    public String open_account_url;
    public String out_trade_no;
    public String process_id;
    public String track_info;
    public String trade_no;
    public String uid;
    public CJPayVerifyIdentityInfo verify_identity;
    public String zg_app_id;
    public String zg_merchant_id;

    public CJPayLargeAmountBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public final boolean isNeedBindCard() {
        return Intrinsics.areEqual("1", this.need_bind_card);
    }

    public final boolean isNeedFace() {
        return Intrinsics.areEqual("1", this.need_face);
    }

    public final boolean isNeedGotoBanks() {
        if (this.banks_url.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNeedOpenAccount() {
        return Intrinsics.areEqual("1", this.need_open_account);
    }

    public final boolean isNeedQueryFaceInfo() {
        return Intrinsics.areEqual("1", this.need_query_face_data);
    }

    public final boolean isNeedQueryVerifyInfo() {
        return Intrinsics.areEqual("1", this.need_query_identity_data);
    }

    public final boolean isNeedVerifyIdentity() {
        return Intrinsics.areEqual(this.need_identity, "1");
    }

    public CJPayLargeAmountBean(CJPayFaceVerifyInfo r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, CJPayVerifyIdentityInfo r316) {
        Intrinsics.checkNotNullParameter(r110, "face_verify_info");
        Intrinsics.checkNotNullParameter(r111, "uid");
        Intrinsics.checkNotNullParameter(r112, "merchant_id");
        Intrinsics.checkNotNullParameter(r210, "app_id");
        Intrinsics.checkNotNullParameter(r211, b.A0);
        Intrinsics.checkNotNullParameter(r212, b.B0);
        Intrinsics.checkNotNullParameter(r213, "need_face");
        Intrinsics.checkNotNullParameter(r214, "need_identity");
        Intrinsics.checkNotNullParameter(r215, SendClosePdpEventParam.KEY_LYNX_URL);
        Intrinsics.checkNotNullParameter(r216, CrashHianalyticsData.PROCESS_ID);
        Intrinsics.checkNotNullParameter(r217, "need_bind_card");
        Intrinsics.checkNotNullParameter(r218, "need_query_face_data");
        Intrinsics.checkNotNullParameter(r219, "need_query_identity_data");
        Intrinsics.checkNotNullParameter(r310, "zg_app_id");
        Intrinsics.checkNotNullParameter(r311, "zg_merchant_id");
        Intrinsics.checkNotNullParameter(r312, "track_info");
        Intrinsics.checkNotNullParameter(r313, "need_open_account");
        Intrinsics.checkNotNullParameter(r314, "open_account_url");
        Intrinsics.checkNotNullParameter(r315, "banks_url");
        Intrinsics.checkNotNullParameter(r316, "verify_identity");
        this.face_verify_info = r110;
        this.uid = r111;
        this.merchant_id = r112;
        this.app_id = r210;
        this.out_trade_no = r211;
        this.trade_no = r212;
        this.need_face = r213;
        this.need_identity = r214;
        this.lynx_url = r215;
        this.process_id = r216;
        this.need_bind_card = r217;
        this.need_query_face_data = r218;
        this.need_query_identity_data = r219;
        this.zg_app_id = r310;
        this.zg_merchant_id = r311;
        this.track_info = r312;
        this.need_open_account = r313;
        this.open_account_url = r314;
        this.banks_url = r315;
        this.verify_identity = r316;
    }

    public /* synthetic */ CJPayLargeAmountBean(CJPayFaceVerifyInfo r210, String r211, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, CJPayVerifyIdentityInfo r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 1) == 0) goto L5;
        CJPayFaceVerifyInfo r100 = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r418 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r418 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r418 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r418 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r418 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r418 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r418 & 512) == 0) goto L41;
        String r111 = "";
    L43:
        if ((r418 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r418 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r418 & 4096) == 0) goto L53;
        String r114 = "";
    L55:
        if ((r418 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r418 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r418 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r418 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r418 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r418 & 262144) == 0) goto L77;
        String r119 = "";
    L79:
        if ((r418 & 524288) == 0) goto L81;
        CJPayVerifyIdentityInfo r109 = new CJPayVerifyIdentityInfo(null, null, 3, null);
    L82:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r417;
        goto L82
    L77:
        r119 = r416;
        goto L79
    L73:
        r118 = r415;
        goto L75
    L69:
        r117 = r414;
        goto L71
    L65:
        r116 = r413;
        goto L67
    L61:
        r108 = r412;
        goto L63
    L57:
        r115 = r411;
        goto L59
    L53:
        r114 = r410;
        goto L55
    L49:
        r113 = r319;
        goto L51
    L45:
        r112 = r318;
        goto L47
    L41:
        r111 = r317;
        goto L43
    L37:
        r110 = r316;
        goto L39
    L33:
        r107 = r315;
        goto L35
    L29:
        r106 = r314;
        goto L31
    L25:
        r105 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
