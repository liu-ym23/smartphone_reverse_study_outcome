package com.android.ttcjpaysdk.thirdparty.front.counter.directbank.bean;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0087\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/directbank/bean/CJPayDirectBankBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "uid", "", "merchant_id", "app_id", b.A0, b.B0, "need_face", SendClosePdpEventParam.KEY_LYNX_URL, CrashHianalyticsData.PROCESS_ID, "zg_app_id", "zg_merchant_id", "track_info", "direct_biz_scene", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isNeedFace", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDirectBankBean implements CJPayObject, Serializable {
    public String app_id;
    public String direct_biz_scene;
    public CJPayFaceVerifyInfo face_verify_info;
    public String lynx_url;
    public String merchant_id;
    public String need_face;
    public String out_trade_no;
    public String process_id;
    public String track_info;
    public String trade_no;
    public String uid;
    public String zg_app_id;
    public String zg_merchant_id;

    public CJPayDirectBankBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public final boolean isNeedFace() {
        return Intrinsics.areEqual("1", this.need_face);
    }

    public CJPayDirectBankBean(CJPayFaceVerifyInfo r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "face_verify_info");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "merchant_id");
        Intrinsics.checkNotNullParameter(r103, "app_id");
        Intrinsics.checkNotNullParameter(r104, b.A0);
        Intrinsics.checkNotNullParameter(r105, b.B0);
        Intrinsics.checkNotNullParameter(r106, "need_face");
        Intrinsics.checkNotNullParameter(r107, SendClosePdpEventParam.KEY_LYNX_URL);
        Intrinsics.checkNotNullParameter(r110, CrashHianalyticsData.PROCESS_ID);
        Intrinsics.checkNotNullParameter(r111, "zg_app_id");
        Intrinsics.checkNotNullParameter(r112, "zg_merchant_id");
        Intrinsics.checkNotNullParameter(r113, "track_info");
        Intrinsics.checkNotNullParameter(r114, "direct_biz_scene");
        this.face_verify_info = r100;
        this.uid = r101;
        this.merchant_id = r102;
        this.app_id = r103;
        this.out_trade_no = r104;
        this.trade_no = r105;
        this.need_face = r106;
        this.lynx_url = r107;
        this.process_id = r110;
        this.zg_app_id = r111;
        this.zg_merchant_id = r112;
        this.track_info = r113;
        this.direct_biz_scene = r114;
    }

    public /* synthetic */ CJPayDirectBankBean(CJPayFaceVerifyInfo r210, String r211, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, int r411, DefaultConstructorMarker r412) {
        if ((r411 & 1) == 0) goto L5;
        CJPayFaceVerifyInfo r100 = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    L6:
        String r101 = "";
        if ((r411 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r411 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r411 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r411 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r411 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r411 & 512) == 0) goto L41;
        String r111 = "";
    L43:
        if ((r411 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r411 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r411 & 4096) != 0) goto L54;
        r101 = r410;
    L54:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r101);
        return;
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
        r108 = r315;
        goto L35
    L29:
        r107 = r314;
        goto L31
    L25:
        r106 = r313;
        goto L27
    L21:
        r105 = r312;
        goto L23
    L17:
        r104 = r311;
        goto L19
    L13:
        r103 = r310;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L6
    }
}
