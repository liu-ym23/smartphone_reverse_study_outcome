package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import android.app.Activity;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÒ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a¢\u0006\u0002\u0010\u001fJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J&\u0010:\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010HÆ\u0003Jæ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aHÆ\u0001J\u0013\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\b\u0010I\u001a\u00020\u0005H\u0016R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R.\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010-R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010-R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R%\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'¨\u0006J"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainShowParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "tradeNo", "", "contactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "selectAssert", "Lorg/json/JSONObject;", "fromScene", ShareData.ISCOMBINEPAY, "", "isBioDegrade", "isSupportBio", "commonTrackParams", "", "processInfo", "selectMetaInfos", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "Lkotlin/collections/ArrayList;", "primaryCategory", "currentVerifyType", "extraTeaCommonParams", "finishTask", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShowDilog", "", "(Landroid/app/Activity;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;Lorg/json/JSONObject;Ljava/lang/String;ZZZLjava/util/Map;Lorg/json/JSONObject;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function1;)V", "getCommonTrackParams", "()Ljava/util/Map;", "getContactInfo", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "getContext", "()Landroid/app/Activity;", "getCurrentVerifyType", "()Ljava/lang/String;", "getExtraTeaCommonParams", "()Lorg/json/JSONObject;", "getFinishTask", "()Lkotlin/jvm/functions/Function1;", "getFromScene", "()Z", "getPrimaryCategory", "getProcessInfo", "getSelectAssert", "getSelectMetaInfos", "()Ljava/util/ArrayList;", "getTradeNo", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainShowParams implements CJPayObject {
    private final Map<String, String> commonTrackParams;
    private final CJPayRetainContactInfo contactInfo;
    private final Activity context;
    private final String currentVerifyType;
    private final JSONObject extraTeaCommonParams;
    private final Function1<Boolean, Unit> finishTask;
    private final String fromScene;
    private final boolean isBioDegrade;
    private final boolean isCombinePay;
    private final boolean isSupportBio;
    private final String primaryCategory;
    private final JSONObject processInfo;
    private final JSONObject selectAssert;
    private final ArrayList<AssetInfoBean.AssetMetaInfoBean> selectMetaInfos;
    private final String tradeNo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayRetainShowParams copy$default(CJPayRetainShowParams r110, Activity r111, String r112, CJPayRetainContactInfo r113, JSONObject r210, String r211, boolean r212, boolean r213, boolean r214, Map r215, JSONObject r216, ArrayList r217, String r218, String r219, JSONObject r310, Function1 r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        Activity r100 = r110.context;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.tradeNo;
    L11:
        if ((r312 & 4) == 0) goto L13;
        CJPayRetainContactInfo r102 = r110.contactInfo;
    L15:
        if ((r312 & 8) == 0) goto L17;
        JSONObject r103 = r110.selectAssert;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.fromScene;
    L23:
        if ((r312 & 32) == 0) goto L25;
        boolean r105 = r110.isCombinePay;
    L27:
        if ((r312 & 64) == 0) goto L29;
        boolean r106 = r110.isBioDegrade;
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r107 = r110.isSupportBio;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Map r114 = r110.commonTrackParams;
    L39:
        if ((r312 & 512) == 0) goto L41;
        JSONObject r115 = r110.processInfo;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        ArrayList r116 = r110.selectMetaInfos;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r117 = r110.primaryCategory;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r118 = r110.currentVerifyType;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        JSONObject r119 = r110.extraTeaCommonParams;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        Function1 r108 = r110.finishTask;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Activity component1() {
        return this.context;
    }

    public final JSONObject component10() {
        return this.processInfo;
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> component11() {
        return this.selectMetaInfos;
    }

    public final String component12() {
        return this.primaryCategory;
    }

    public final String component13() {
        return this.currentVerifyType;
    }

    public final JSONObject component14() {
        return this.extraTeaCommonParams;
    }

    public final Function1<Boolean, Unit> component15() {
        return this.finishTask;
    }

    public final String component2() {
        return this.tradeNo;
    }

    public final CJPayRetainContactInfo component3() {
        return this.contactInfo;
    }

    public final JSONObject component4() {
        return this.selectAssert;
    }

    public final String component5() {
        return this.fromScene;
    }

    public final boolean component6() {
        return this.isCombinePay;
    }

    public final boolean component7() {
        return this.isBioDegrade;
    }

    public final boolean component8() {
        return this.isSupportBio;
    }

    public final Map<String, String> component9() {
        return this.commonTrackParams;
    }

    public final CJPayRetainShowParams copy(Activity r110, String r111, CJPayRetainContactInfo r210, JSONObject r211, String r212, boolean r213, boolean r214, boolean r215, Map<String, String> r216, JSONObject r217, ArrayList<AssetInfoBean.AssetMetaInfoBean> r218, String r219, String r310, JSONObject r311, Function1<? super Boolean, Unit> r312) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "tradeNo");
        Intrinsics.checkNotNullParameter(r210, "contactInfo");
        Intrinsics.checkNotNullParameter(r212, "fromScene");
        Intrinsics.checkNotNullParameter(r217, "processInfo");
        return new CJPayRetainShowParams(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainShowParams) == true) goto L8;
        return false;
    L8:
        CJPayRetainShowParams r101 = (CJPayRetainShowParams) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contactInfo, r101.contactInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectAssert, r101.selectAssert) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fromScene, r101.fromScene) == true) goto L24;
        return false;
    L24:
        if (this.isCombinePay == r101.isCombinePay) goto L27;
        return false;
    L27:
        if (this.isBioDegrade == r101.isBioDegrade) goto L30;
        return false;
    L30:
        if (this.isSupportBio == r101.isSupportBio) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.commonTrackParams, r101.commonTrackParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.processInfo, r101.processInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectMetaInfos, r101.selectMetaInfos) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.primaryCategory, r101.primaryCategory) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.currentVerifyType, r101.currentVerifyType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.extraTeaCommonParams, r101.extraTeaCommonParams) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.finishTask, r101.finishTask) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.context.hashCode() * 31) + this.tradeNo.hashCode()) * 31) + this.contactInfo.hashCode()) * 31;
        JSONObject r101 = this.selectAssert;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.fromScene.hashCode()) * 31;
        int r105 = 1231;
        if (this.isCombinePay == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.isBioDegrade == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.isSupportBio == true) goto L18;
        r105 = 1237;
    L18:
        int r110 = (r109 + r105) * 31;
        Map<String, String> r111 = this.commonTrackParams;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (((r110 + r112) * 31) + this.processInfo.hashCode()) * 31;
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r114 = this.selectMetaInfos;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.primaryCategory;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        String r120 = this.currentVerifyType;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        JSONObject r123 = this.extraTeaCommonParams;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        Function1<Boolean, Unit> r126 = this.finishTask;
        if (r126 == null) goto L43;
        r102 = r126.hashCode();
    L43:
        return r125 + r102;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CJPayRetainShowParams(context=" + this.context + ", tradeNo='" + this.tradeNo + "', contactInfo=" + this.contactInfo + ", selectAssert=" + this.selectAssert + ", fromScene='" + this.fromScene + "', isCombinePay=" + this.isCombinePay + ", isBioDegrade=" + this.isBioDegrade + ", isSupportBio=" + this.isSupportBio + ", commonTrackParams=" + this.commonTrackParams + ", processInfo=" + this.processInfo + ", selectMetaInfos=" + this.selectMetaInfos + ", primaryCategory=" + this.primaryCategory + ", currentVerifyType=" + this.currentVerifyType + ')';
    }

    public final Map<String, String> getCommonTrackParams() {
        return this.commonTrackParams;
    }

    public final CJPayRetainContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final String getCurrentVerifyType() {
        return this.currentVerifyType;
    }

    public final JSONObject getExtraTeaCommonParams() {
        return this.extraTeaCommonParams;
    }

    public final Function1<Boolean, Unit> getFinishTask() {
        return this.finishTask;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final String getPrimaryCategory() {
        return this.primaryCategory;
    }

    public final JSONObject getProcessInfo() {
        return this.processInfo;
    }

    public final JSONObject getSelectAssert() {
        return this.selectAssert;
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> getSelectMetaInfos() {
        return this.selectMetaInfos;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public final boolean isBioDegrade() {
        return this.isBioDegrade;
    }

    public final boolean isCombinePay() {
        return this.isCombinePay;
    }

    public final boolean isSupportBio() {
        return this.isSupportBio;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayRetainShowParams(Activity r100, String r101, CJPayRetainContactInfo r110, JSONObject r111, String r112, boolean r113, boolean r114, boolean r115, Map<String, String> r116, JSONObject r117, ArrayList<AssetInfoBean.AssetMetaInfoBean> r118, String r119, String r210, JSONObject r211, Function1<? super Boolean, Unit> r212) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "tradeNo");
        Intrinsics.checkNotNullParameter(r110, "contactInfo");
        Intrinsics.checkNotNullParameter(r112, "fromScene");
        Intrinsics.checkNotNullParameter(r117, "processInfo");
        this.context = r100;
        this.tradeNo = r101;
        this.contactInfo = r110;
        this.selectAssert = r111;
        this.fromScene = r112;
        this.isCombinePay = r113;
        this.isBioDegrade = r114;
        this.isSupportBio = r115;
        this.commonTrackParams = r116;
        this.processInfo = r117;
        this.selectMetaInfos = r118;
        this.primaryCategory = r119;
        this.currentVerifyType = r210;
        this.extraTeaCommonParams = r211;
        this.finishTask = r212;
    }

    public /* synthetic */ CJPayRetainShowParams(Activity r110, String r210, CJPayRetainContactInfo r211, JSONObject r212, String r213, boolean r214, boolean r215, boolean r216, Map r217, JSONObject r218, ArrayList r219, String r310, String r311, JSONObject r312, Function1 r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 128) == 0) goto L5;
        boolean r111 = false;
    L7:
        if ((r314 & 256) == 0) goto L9;
        Map r112 = null;
    L11:
        if ((r314 & 1024) == 0) goto L13;
        ArrayList r113 = null;
    L15:
        if ((r314 & 2048) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r314 & 4096) == 0) goto L21;
        String r115 = null;
    L23:
        if ((r314 & 8192) == 0) goto L25;
        JSONObject r116 = null;
    L27:
        if ((r314 & 16384) == 0) goto L29;
        Function1 r117 = null;
    L30:
        this(r110, r210, r211, r212, r213, r214, r215, r111, r112, r218, r113, r114, r115, r116, r117);
        return;
    L29:
        r117 = r313;
        goto L30
    L25:
        r116 = r312;
        goto L27
    L21:
        r115 = r311;
        goto L23
    L17:
        r114 = r310;
        goto L19
    L13:
        r113 = r219;
        goto L15
    L9:
        r112 = r217;
        goto L11
    L5:
        r111 = r216;
        goto L7
    }
}
