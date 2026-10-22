package com.bytedance.android.live.wallet.platform.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.ChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.CustomChargeDeal;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zc1.o;

/* JADX INFO: loaded from: classes7.dex */
@XBridgeMethod(biz = "webcast", name = "walletOpenCJCounter")
public final class j extends com.bytedance.ies.web.jsbridge2.f<d, Object> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$a;", "", "", "bizPage", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "bizScene", "b", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("biz_page")
        private final String bizPage;

        @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
        private final String bizScene;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.bizPage, r101.bizPage) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.bizScene, r101.bizScene) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.bizPage;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.bizScene;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "BizChannelParams(bizPage=" + this.bizPage + ", bizScene=" + this.bizScene + ")";
        }

        public a() {
            this.bizPage = null;
            this.bizScene = null;
        }

        public final String a() {
            return this.bizPage;
        }

        public final String b() {
            return this.bizScene;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$b;", "", "", "scene", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "tradeName", "b", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("scene")
        private final String scene;

        @SerializedName("trade_name")
        private final String tradeName;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.tradeName, r101.tradeName) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.scene;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.tradeName;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "OneStepPayParams(scene=" + this.scene + ", tradeName=" + this.tradeName + ")";
        }

        public b() {
            this.scene = null;
            this.tradeName = null;
        }

        public final String a() {
            return this.scene;
        }

        public final String b() {
            return this.tradeName;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$c;", "", "", "version", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "", "display_type", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setDisplay_type", "(Ljava/lang/Integer;)V", "order_id", "c", "setOrder_id", "is_balance_enough", "h", "set_balance_enough", "is_first_package", RXScreenCaptureService.KEY_INDEX, "set_first_package", "", "previous_pay_money", "J", "e", "()J", "setPrevious_pay_money", "(J)V", "money_diff", "b", "setMoney_diff", "recommend_packages", "f", "setRecommend_packages", "pay_id", "d", "setPay_id", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("display_type")
        private Integer display_type;

        @SerializedName("is_balance_enough")
        private String is_balance_enough;

        @SerializedName("is_first_package")
        private String is_first_package;

        @SerializedName("money_diff")
        private long money_diff;

        @SerializedName("order_id")
        private String order_id;

        @SerializedName("pay_id")
        private String pay_id;

        @SerializedName("previous_pay_money")
        private long previous_pay_money;

        @SerializedName("recommend_packages")
        private long recommend_packages;

        @SerializedName("version")
        private String version;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L24;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.display_type, r101.display_type) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.order_id, r101.order_id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.is_balance_enough, r101.is_balance_enough) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.is_first_package, r101.is_first_package) == true) goto L16;
            return false;
        L16:
            if (this.previous_pay_money == r101.previous_pay_money) goto L18;
            return false;
        L18:
            if (this.money_diff == r101.money_diff) goto L20;
            return false;
        L20:
            if (this.recommend_packages == r101.recommend_packages) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.pay_id, r101.pay_id) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            String r100 = this.version;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.display_type;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.order_id;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.is_balance_enough;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.is_first_package;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            long r116 = this.previous_pay_money;
            int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
            long r118 = this.money_diff;
            int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
            long r120 = this.recommend_packages;
            int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
            String r122 = this.pay_id;
            if (r122 == null) goto L26;
            r101 = r122.hashCode();
        L26:
            return r121 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "OpenRechargeDialogArgs(version=" + this.version + ", display_type=" + this.display_type + ", order_id=" + this.order_id + ", is_balance_enough=" + this.is_balance_enough + ", is_first_package=" + this.is_first_package + ", previous_pay_money=" + this.previous_pay_money + ", money_diff=" + this.money_diff + ", recommend_packages=" + this.recommend_packages + ", pay_id=" + this.pay_id + ")";
        }

        public c() {
            this.version = null;
            this.display_type = null;
            this.order_id = null;
            this.is_balance_enough = null;
            this.is_first_package = null;
            this.previous_pay_money = 0;
            this.money_diff = 0;
            this.recommend_packages = 0;
            this.pay_id = null;
        }

        public final Integer a() {
            return this.display_type;
        }

        public final long b() {
            return this.money_diff;
        }

        public final String c() {
            return this.order_id;
        }

        public final String d() {
            return this.pay_id;
        }

        public final long e() {
            return this.previous_pay_money;
        }

        public final long f() {
            return this.recommend_packages;
        }

        public final String g() {
            return this.version;
        }

        public final String h() {
            return this.is_balance_enough;
        }

        public final String i() {
            return this.is_first_package;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\u001c\u00104\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u00109\u001a\u0004\u0018\u0001088\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$d;", "", "", "requestPage", "Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/String;", "chargeReason", "e", "eventModule", RXScreenCaptureService.KEY_INDEX, "", "isRecommend", "Ljava/lang/Integer;", "o", "()Ljava/lang/Integer;", "chargeOrderSource", "d", "businessScene", "c", "Lcom/bytedance/android/livesdkapi/depend/model/ChargeDeal;", "diamondData", "Lcom/bytedance/android/livesdkapi/depend/model/ChargeDeal;", "h", "()Lcom/bytedance/android/livesdkapi/depend/model/ChargeDeal;", "Lcom/bytedance/android/livesdkapi/depend/model/CustomChargeDeal;", "customizedDiamond", "Lcom/bytedance/android/livesdkapi/depend/model/CustomChargeDeal;", ce.f26391f, "()Lcom/bytedance/android/livesdkapi/depend/model/CustomChargeDeal;", "", "customPrice", "J", "f", "()J", "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$c;", "args", "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$c;", "setArgs", "(Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$c;)V", "", "extra", "Ljava/util/Map;", ce.f26395j, "()Ljava/util/Map;", "bizExtra", "b", "guideSource", ce.f26396k, "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$a;", "rechargeChannel", "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$a;", "m", "()Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$a;", "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$b;", "oneStepPayParams", "Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$b;", "l", "()Lcom/bytedance/android/live/wallet/platform/jsbridge/methods/j$b;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d {

        @SerializedName("args")
        private c args;

        @SerializedName("biz_extra")
        private final Map<String, String> bizExtra;

        @SerializedName("business_scene")
        private final Integer businessScene;

        @SerializedName("source")
        private final Integer chargeOrderSource;

        @SerializedName("charge_reason")
        private final String chargeReason;

        @SerializedName("custom_price")
        private final long customPrice;

        @SerializedName("customized_diamond")
        private final CustomChargeDeal customizedDiamond;

        @SerializedName("common_diamond")
        private final ChargeDeal diamondData;

        @SerializedName("event_module")
        private final String eventModule;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("guide_source")
        private final String guideSource;

        @SerializedName(sz1.a.KEY_IS_RECOMMEND)
        private final Integer isRecommend;

        @SerializedName("one_step_pay_option")
        private final b oneStepPayParams;

        @SerializedName("recharge_channel")
        private final a rechargeChannel;

        @SerializedName("request_page")
        private final String requestPage;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L36;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.requestPage, r101.requestPage) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.chargeReason, r101.chargeReason) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.eventModule, r101.eventModule) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isRecommend, r101.isRecommend) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.chargeOrderSource, r101.chargeOrderSource) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.businessScene, r101.businessScene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.diamondData, r101.diamondData) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.customizedDiamond, r101.customizedDiamond) == true) goto L22;
            return false;
        L22:
            if (this.customPrice == r101.customPrice) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.args, r101.args) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.bizExtra, r101.bizExtra) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.guideSource, r101.guideSource) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.rechargeChannel, r101.rechargeChannel) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.oneStepPayParams, r101.oneStepPayParams) == true) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        public final int hashCode() {
            String r100 = this.requestPage;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.chargeReason;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.eventModule;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.isRecommend;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.chargeOrderSource;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.businessScene;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            ChargeDeal r119 = this.diamondData;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            CustomChargeDeal r122 = this.customizedDiamond;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            long r125 = this.customPrice;
            int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
            c r127 = this.args;
            if (r127 == null) goto L37;
            int r128 = r127.hashCode();
        L38:
            int r129 = (r126 + r128) * 31;
            Map<String, String> r130 = this.extra;
            if (r130 == null) goto L41;
            int r131 = r130.hashCode();
        L42:
            int r132 = (r129 + r131) * 31;
            Map<String, String> r133 = this.bizExtra;
            if (r133 == null) goto L45;
            int r134 = r133.hashCode();
        L46:
            int r135 = (r132 + r134) * 31;
            String r136 = this.guideSource;
            if (r136 == null) goto L49;
            int r137 = r136.hashCode();
        L50:
            int r138 = (r135 + r137) * 31;
            a r139 = this.rechargeChannel;
            if (r139 == null) goto L53;
            int r140 = r139.hashCode();
        L54:
            int r141 = (r138 + r140) * 31;
            b r142 = this.oneStepPayParams;
            if (r142 == null) goto L58;
            r101 = r142.hashCode();
        L58:
            return r141 + r101;
        L53:
            r140 = 0;
            goto L54
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(requestPage=" + this.requestPage + ", chargeReason=" + this.chargeReason + ", eventModule=" + this.eventModule + ", isRecommend=" + this.isRecommend + ", chargeOrderSource=" + this.chargeOrderSource + ", businessScene=" + this.businessScene + ", diamondData=" + this.diamondData + ", customizedDiamond=" + this.customizedDiamond + ", customPrice=" + this.customPrice + ", args=" + this.args + ", extra=" + this.extra + ", bizExtra=" + this.bizExtra + ", guideSource=" + this.guideSource + ", rechargeChannel=" + this.rechargeChannel + ", oneStepPayParams=" + this.oneStepPayParams + ")";
        }

        public final c a() {
            return this.args;
        }

        public final Map<String, String> b() {
            return this.bizExtra;
        }

        public final Integer c() {
            return this.businessScene;
        }

        public final Integer d() {
            return this.chargeOrderSource;
        }

        public final String e() {
            return this.chargeReason;
        }

        public final long f() {
            return this.customPrice;
        }

        public final CustomChargeDeal g() {
            return this.customizedDiamond;
        }

        public final ChargeDeal h() {
            return this.diamondData;
        }

        public final String i() {
            return this.eventModule;
        }

        public final Map<String, String> j() {
            return this.extra;
        }

        public final String k() {
            return this.guideSource;
        }

        public final b l() {
            return this.oneStepPayParams;
        }

        public final a m() {
            return this.rechargeChannel;
        }

        public final String n() {
            return this.requestPage;
        }

        public final Integer o() {
            return this.isRecommend;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(d r110, CallContext r111) {
        d r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, "callContext");
        HashMap r101 = new HashMap();
        Map<String, String> r102 = r100.j();
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r101.put(r104.getKey(), r104.getValue());
    L8:
        r101.put("event_module", r100.i());
        Integer r105 = r100.o();
        Integer r112 = null;
        if (r105 == null) goto L11;
        String r106 = String.valueOf(r105.intValue());
    L12:
        r101.put(sz1.a.KEY_IS_RECOMMEND, r106);
        c r107 = r100.a();
        if (r107 == null) goto L16;
        r101.put("version", r107.g());
        r101.put("displayType", String.valueOf(r107.a()));
        r101.put("order_id", r107.c());
        r101.put("is_balance_enough", r107.h());
        r101.put("is_first_package", r107.i());
        r101.put("business_scene", String.valueOf(r100.c()));
        r101.put("previous_pay_money", String.valueOf(r107.e()));
        r101.put("money_diff", String.valueOf(r107.b()));
        r101.put("recommend_packages", String.valueOf(r107.f()));
        r101.put("pay_id", r107.d());
    L16:
        if (r100.k() == null) goto L18;
        r101.put("guide_source", r100.k().toString());
    L18:
        a r108 = r100.m();
        if (r108 == null) goto L21;
        String r109 = r108.a();
    L22:
        a r113 = r100.m();
        if (r113 == null) goto L25;
        String r114 = r113.b();
    L26:
        boolean r115 = true;
        com.bytedance.android.live.recharge.order.i r116 = new com.bytedance.android.live.recharge.order.i(r109, r114, 1);
        JSONObject r117 = new JSONObject();
        Map<String, String> r118 = r100.b();
        if (r118 == null) goto L32;
        Iterator<Map.Entry<String, String>> r119 = r118.entrySet().iterator();
    L30:
        if (r119.hasNext() == false) goto L32;
        Map.Entry<String, String> r120 = r119.next();
        d60.b.a(r117, r120.getKey(), r120.getValue());
    L32:
        b r121 = r100.l();
        if (r121 == null) goto L50;
        String r122 = r121.a();
        if (r122 != null) goto L37;
        r122 = "";
    L49:
        String r123 = r122;
    L52:
        if (r100.f() <= 0) goto L56;
        CustomChargeDeal r124 = r100.g();
        if (r124 == null) goto L59;
        r124.setCustomPrice(r100.f());
        r124.setPrice((int) r100.f());
        r124.setDiamondCount((int) (r124.getDiamondCountRate() * r100.f()));
        r124.setTotalDiamond(r124.getDiamondCount() + r124.getRewardDiamondCount());
        DetailChargeDeal r125 = j(this, r100.n(), r100.e(), r100.d(), r100.c(), r124, r101, r117, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
    L60:
        JSONObject r126 = new JSONObject();
        if (r125 == null) goto L64;
        String r127 = r125.getChargeReason();
        if (r127 == null) goto L64;
    L65:
        d60.b.a(r126, "charge_reason", r127);
        if (r125 == null) goto L69;
        String r128 = r125.getChargeScene();
        if (r128 == null) goto L69;
    L70:
        d60.b.a(r126, "charge_scene", r128);
        Object r129 = "0";
        if (r125 == null) goto L73;
        Object r130 = Long.valueOf(r125.getDiamondId());
    L74:
        d60.b.a(r126, "diamond_id", r130);
        if (r125 == null) goto L77;
        r129 = Integer.valueOf(r125.getTotalDiamond());
    L77:
        d60.b.a(r126, "money", r129);
        if (r125 == null) goto L80;
        r112 = Integer.valueOf(r125.getPrice());
    L80:
        d60.b.a(r126, "money_paid", String.valueOf(r112));
        d60.b.a(r126, "rd_recharge_scene", "wallet_diamond_recharge");
        d60.b.a(r126, "request_page", "wallet_diamond_recharge");
        b r131 = r100.l();
        if (r131 == null) goto L84;
        String r132 = r131.b();
        if (r132 == null) goto L84;
    L85:
        d60.b.a(r126, "trade_name", r132);
        d60.b.a(r126, "trade_type", "SDK");
        d60.b.a(r126, IPerformanceManager.Params.room_type, "wallet");
        d60.b.a(r126, "pay_scene", "wallet");
        r101.put("continue_pay_info", r126.toString());
        if (r125 == null) goto L88;
        r125.setQueriesMap(MapsKt.mapOf(TuplesKt.to("recharge_channel", r116.a())));
    L88:
        Context r133 = r111.getContext();
        if ((r133 instanceof Activity) == false) goto L92;
        o.a((Activity) r133, r125, new k(this));
        return;
    L92:
        return;
    L84:
        r132 = "";
        goto L85
    L73:
        r130 = "0";
    L69:
        r128 = "";
    L64:
        r127 = "";
    L59:
        r125 = null;
        goto L60
    L56:
        ChargeDeal r134 = r100.h();
        if (r134 == null) goto L59;
        r101.put("diamond_safe", r134.getDiamondSignInfo());
        r125 = j(this, r100.n(), r100.e(), r100.d(), r100.c(), r134, r101, r117, r134.getIapProductId(), r123, 128);
        goto L60
    L37:
        if (r122.length() > 0) goto L40;
        r115 = false;
    L40:
        if (r115 == false) goto L44;
        JSONObject r135 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).I(r122);
        if (r135 == null) goto L45;
        r101.put("create_pay_type", "1");
        r101.put("caijing_pay_params", r135.toString());
    L45:
        String r136 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r136 == null) goto L49;
        r101.put("sdk_version", r136);
        goto L49
    L44:
        r122 = "";
        goto L45
    L50:
        r123 = "";
        goto L52
    L25:
        r114 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L11:
        r106 = null;
        goto L12
    }

    public static DetailChargeDeal j(j r100, String r101, String r102, Integer r103, Integer r104, ChargeDeal r105, HashMap r110, JSONObject r111, String r112, String r113, int r114) {
        String r106 = "";
        if ((r114 & 1) == 0) goto L6;
        r101 = "";
    L6:
        if ((r114 & 256) == 0) goto L9;
        r112 = "";
    L9:
        if ((r114 & 512) == 0) goto L11;
        r113 = "";
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        Intrinsics.checkNotNullParameter(r105, "deal");
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r111, "bizExtra");
        DetailChargeDeal.Builder r107 = new DetailChargeDeal.Builder().diamondId(r105.getId()).price(r105.getPrice()).tradeType(0).totalDiamond(r105.getTotalDiamond()).showFastPay(false).combineAmount(0);
        if (r103 == null) goto L14;
        int r108 = r103.intValue();
    L15:
        DetailChargeDeal.Builder r109 = r107.chargeOrderSource(r108);
        if ("".equals(r101) == false) goto L18;
        r101 = AppConstants.EVENT_PROFILE_SELF;
    L18:
        DetailChargeDeal.Builder r115 = r109.requestPage(r101).chargeReason(r102).extra(r110).bizExtra(r111).oneStepScene(r113);
        if (r104 == null) goto L22;
        r115.chargeOrderBusinessScene(r104.intValue());
    L22:
        if (r105.isCustomizedDiamond() == false) goto L25;
        r115.customPrice(r105.getPrice());
    L25:
        if ((r105 instanceof CustomChargeDeal) == false) goto L28;
        r115.customPrice(((CustomChargeDeal) r105).getCustomPrice());
    L28:
        if (r2.a(r112) == false) goto L37;
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == false) goto L37;
        r115.iapProductId(r112);
        r115.isIapPay(true);
        com.bytedance.android.live.wallet.pay.iap.a r116 = RechargeFacadeUtilsKt.a().g();
        if (r112 == null) goto L35;
        r106 = r112;
    L35:
        r116.L0(CollectionsKt.listOf(r106));
    L37:
        return r115.build();
    L14:
        r108 = 1;
        goto L15
    }
}
