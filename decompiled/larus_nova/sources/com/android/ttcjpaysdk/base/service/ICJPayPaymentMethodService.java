package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0006456789J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J,\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0007H&J\u0014\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J*\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J$\u0010 \u001a\u00020\u00032\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`#H&Ja\u0010$\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010*Jo\u0010+\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010,\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u00020\u00032\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000300H&J \u00101\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0005H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0005H&¨\u0006:"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "changePaymentMethod", "", "methodStr", "", "defaultChangeToCreditPay", "", "currentAssetInfoBean", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "disableSelectedAndStart", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "height", "", "msg", "assetInfoID", "fetchSelectPayMethod", "Lorg/json/JSONObject;", "init", "params", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OutParams;", "isDataReady", "preQuery", "creditPayActivateStatus", "redoPreQuery", "onResul", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IQueryPayTypeResultCallback;", "topAssetList", "Lorg/json/JSONArray;", "release", "releaseCallbacks", "setInsufficientCard", "cards", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "start", ShareData.ISCOMBINEPAY, ShareData.START_HEIGHT, "limitAssetInfoID", "pageTitle", "subAssetInfoID", "(Landroid/content/Context;IZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "startActivity", "needActivityAnim", "(Landroid/content/Context;Ljava/lang/Integer;ZLjava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateOutParams", "updateFunc", "Lkotlin/Function1;", "updateUnavailableAndStart", "cardId", "updateUnavailableCard", "FromScene", "IPaymentMethodBindCardCallback", "IPaymentMethodChangeCallback", "IQueryPayTypeResultCallback", "OnActivityResultCallback", "OutParams", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayPaymentMethodService extends ICJPayService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void preQuery$default(ICJPayPaymentMethodService r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.preQuery(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preQuery");
        }

        public static void redoPreQuery(ICJPayPaymentMethodService r100, String r101, JSONArray r102, IQueryPayTypeResultCallback r103) {
            r100.redoPreQuery(r101, r103);
        }

        public static /* synthetic */ void redoPreQuery$default(ICJPayPaymentMethodService r100, String r101, IQueryPayTypeResultCallback r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.redoPreQuery(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redoPreQuery");
        }

        public static /* synthetic */ void changePaymentMethod$default(ICJPayPaymentMethodService r100, String r101, boolean r102, AssetInfoBean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L6;
            r102 = true;
        L6:
            r100.changePaymentMethod(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changePaymentMethod");
        }

        public static /* synthetic */ void redoPreQuery$default(ICJPayPaymentMethodService r100, String r101, JSONArray r102, IQueryPayTypeResultCallback r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.redoPreQuery(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redoPreQuery");
        }

        public static /* synthetic */ void disableSelectedAndStart$default(ICJPayPaymentMethodService r100, Context r101, int r102, String r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L6;
            r103 = "";
        L6:
            r100.disableSelectedAndStart(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableSelectedAndStart");
        }

        public static /* synthetic */ void start$default(ICJPayPaymentMethodService r110, Context r111, int r112, boolean r113, Integer r114, String r115, String r116, String r117, String r210, int r211, Object r212) {
            if (r212 != null) goto L27;
            if ((r211 & 8) == 0) goto L7;
            Integer r100 = null;
        L9:
            if ((r211 & 16) == 0) goto L11;
            String r101 = null;
        L13:
            if ((r211 & 32) == 0) goto L15;
            String r102 = null;
        L17:
            if ((r211 & 64) == 0) goto L19;
            String r118 = null;
        L21:
            if ((r211 & 128) == 0) goto L23;
            String r119 = null;
        L24:
            r110.start(r111, r112, r113, r100, r101, r102, r118, r119);
            return;
        L23:
            r119 = r210;
            goto L24
        L19:
            r118 = r117;
            goto L21
        L15:
            r102 = r116;
            goto L17
        L11:
            r101 = r115;
            goto L13
        L7:
            r100 = r114;
            goto L9
        L27:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }

        public static /* synthetic */ void startActivity$default(ICJPayPaymentMethodService r110, Context r111, Integer r112, boolean r113, Integer r114, boolean r115, String r116, String r210, String r211, String r212, int r213, Object r214) {
            if (r214 != null) goto L35;
            if ((r213 & 2) == 0) goto L7;
            Integer r100 = null;
        L9:
            if ((r213 & 8) == 0) goto L11;
            Integer r101 = null;
        L13:
            if ((r213 & 16) == 0) goto L15;
            boolean r102 = true;
        L17:
            if ((r213 & 32) == 0) goto L19;
            String r103 = null;
        L21:
            if ((r213 & 64) == 0) goto L23;
            String r117 = null;
        L25:
            if ((r213 & 128) == 0) goto L27;
            String r118 = null;
        L29:
            if ((r213 & 256) == 0) goto L31;
            String r119 = null;
        L32:
            r110.startActivity(r111, r100, r113, r101, r102, r103, r117, r118, r119);
            return;
        L31:
            r119 = r212;
            goto L32
        L27:
            r118 = r211;
            goto L29
        L23:
            r117 = r210;
            goto L25
        L19:
            r103 = r116;
            goto L21
        L15:
            r102 = r115;
            goto L17
        L11:
            r101 = r114;
            goto L13
        L7:
            r100 = r112;
            goto L9
        L35:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startActivity");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;", "", "(Ljava/lang/String;I)V", "FROM_STANDARD", "FROM_INTEGRATE", "FROM_FRONT_ET", "FROM_O_OUTER", "FROM_FRONT_STANDARD", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FromScene extends Enum<FromScene> {
        private static final /* synthetic */ FromScene[] $VALUES = null;
        public static final FromScene FROM_FRONT_ET = null;
        public static final FromScene FROM_FRONT_STANDARD = null;
        public static final FromScene FROM_INTEGRATE = null;
        public static final FromScene FROM_O_OUTER = null;
        public static final FromScene FROM_STANDARD = null;

        private static final /* synthetic */ FromScene[] $values() {
            return new FromScene[]{FROM_STANDARD, FROM_INTEGRATE, FROM_FRONT_ET, FROM_O_OUTER, FROM_FRONT_STANDARD};
        }

        public static FromScene valueOf(String r100) {
            return (FromScene) a.a(FromScene.class, r100);
        }

        public static FromScene[] values() {
            return (FromScene[]) $VALUES.clone();
        }

        static {
            FROM_STANDARD = new FromScene("FROM_STANDARD", 0);
            FROM_INTEGRATE = new FromScene("FROM_INTEGRATE", 1);
            FROM_FRONT_ET = new FromScene("FROM_FRONT_ET", 2);
            FROM_O_OUTER = new FromScene("FROM_O_OUTER", 3);
            FROM_FRONT_STANDARD = new FromScene("FROM_FRONT_STANDARD", 4);
            $VALUES = $values();
        }

        private FromScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodBindCardCallback;", "", "onBindCardPayResult", "", "result", "", "checkList", "params", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IPaymentMethodBindCardCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onBindCardPayResult$default(IPaymentMethodBindCardCallback r100, String r101, String r102, JSONObject r103, int r104, Object r105) {
                if (r105 != null) goto L9;
                if ((r104 & 4) == 0) goto L6;
                r103 = null;
            L6:
                r100.onBindCardPayResult(r101, r102, r103);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBindCardPayResult");
            }
        }

        void onBindCardPayResult(String r100, String r101, JSONObject r102);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&J2\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodChangeCallback;", "", "updateSelectedCombineCard", "", "jsonObject", "Lorg/json/JSONObject;", "updateSelectedMethod", "isCreditPayActivateSuccess", "", "creditPayActivateVerifyInfo", "updateSelectedMethodWithExtra", ControlRule.KEY_EXTRA_DATA, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IPaymentMethodChangeCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void updateSelectedMethodWithExtra(IPaymentMethodChangeCallback r100, JSONObject r101, JSONObject r102, boolean r103, JSONObject r104) {
                r100.updateSelectedMethod(r101, r103, r104);
            }

            public static /* synthetic */ void updateSelectedMethod$default(IPaymentMethodChangeCallback r100, JSONObject r101, boolean r102, JSONObject r103, int r104, Object r105) {
                if (r105 != null) goto L12;
                if ((r104 & 2) == 0) goto L7;
                r102 = false;
            L7:
                if ((r104 & 4) == 0) goto L9;
                r103 = null;
            L9:
                r100.updateSelectedMethod(r101, r102, r103);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSelectedMethod");
            }

            public static /* synthetic */ void updateSelectedMethodWithExtra$default(IPaymentMethodChangeCallback r100, JSONObject r101, JSONObject r102, boolean r103, JSONObject r104, int r105, Object r106) {
                if (r106 != null) goto L12;
                if ((r105 & 4) == 0) goto L7;
                r103 = false;
            L7:
                if ((r105 & 8) == 0) goto L9;
                r104 = null;
            L9:
                r100.updateSelectedMethodWithExtra(r101, r102, r103, r104);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSelectedMethodWithExtra");
            }
        }

        void updateSelectedCombineCard(JSONObject r100);

        void updateSelectedMethod(JSONObject r100, boolean r101, JSONObject r102);

        void updateSelectedMethodWithExtra(JSONObject r100, JSONObject r101, boolean r102, JSONObject r103);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IQueryPayTypeResultCallback;", "", "onResult", "", "isSuccess", "", "data", "Lorg/json/JSONObject;", "(Ljava/lang/Boolean;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IQueryPayTypeResultCallback {
        void onResult(Boolean r100, JSONObject r101);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OnActivityResultCallback;", "", "showVerifyFragment", "", "height", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnActivityResultCallback {
        int showVerifyFragment(int r100);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010`\u001a\u00020%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001a\u00109\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001a\u0010<\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u001a\u0010>\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u001a\u0010@\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001c\u0010K\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001c\u0010N\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0012\"\u0004\bP\u0010\u0014R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014R\u001c\u0010T\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0012\"\u0004\bV\u0010\u0014R\u001a\u0010W\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010E\"\u0004\bY\u0010GR\u001a\u0010Z\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010E\"\u0004\b\\\u0010GR\u001a\u0010]\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00103\"\u0004\b_\u00105¨\u0006a"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OutParams;", "", "()V", "animCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OnActivityResultCallback;", "getAnimCallback", "()Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OnActivityResultCallback;", "setAnimCallback", "(Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OnActivityResultCallback;)V", "bindCardCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodBindCardCallback;", "getBindCardCallback", "()Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodBindCardCallback;", "setBindCardCallback", "(Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodBindCardCallback;)V", "bindCardInfo", "Lorg/json/JSONObject;", "getBindCardInfo", "()Lorg/json/JSONObject;", "setBindCardInfo", "(Lorg/json/JSONObject;)V", "changeMethodCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodChangeCallback;", "getChangeMethodCallback", "()Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodChangeCallback;", "setChangeMethodCallback", "(Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$IPaymentMethodChangeCallback;)V", "commonLogParams", "getCommonLogParams", "setCommonLogParams", "expandResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "getExpandResult", "()Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "setExpandResult", "(Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;)V", "forbidCombinePay", "", "getForbidCombinePay", "()Ljava/lang/Boolean;", "setForbidCombinePay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fromScene", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;", "getFromScene", "()Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;", "setFromScene", "(Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$FromScene;)V", "hideInsurance", "getHideInsurance", "()Z", "setHideInsurance", "(Z)V", "hostInfo", "getHostInfo", "setHostInfo", "ifHasExpanded", "getIfHasExpanded", "setIfHasExpanded", "isDoBindCardProcess", "setDoBindCardProcess", "isStdAssetProcess", "setStdAssetProcess", "isUseNewGroupInfo", "setUseNewGroupInfo", "nextPage", "", "getNextPage", "()Ljava/lang/String;", "setNextPage", "(Ljava/lang/String;)V", "payInfo", "getPayInfo", "setPayInfo", "payNewCardReconfirmInfo", "getPayNewCardReconfirmInfo", "setPayNewCardReconfirmInfo", "processInfo", "getProcessInfo", "setProcessInfo", "riskInfo", "getRiskInfo", "setRiskInfo", "secondaryConfirmInfo", "getSecondaryConfirmInfo", "setSecondaryConfirmInfo", "source", "getSource", "setSource", "sourcePageName", "getSourcePageName", "setSourcePageName", "useVoucherMsgV2", "getUseVoucherMsgV2", "setUseVoucherMsgV2", "getIsFront", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OutParams {
        private OnActivityResultCallback animCallback;
        private IPaymentMethodBindCardCallback bindCardCallback;
        private JSONObject bindCardInfo;
        private IPaymentMethodChangeCallback changeMethodCallback;
        private JSONObject commonLogParams;
        private VoucherDialogExpandResult expandResult;
        private Boolean forbidCombinePay;
        private FromScene fromScene;
        private boolean hideInsurance;
        private JSONObject hostInfo;
        private boolean ifHasExpanded;
        private boolean isDoBindCardProcess;
        private boolean isStdAssetProcess;
        private boolean isUseNewGroupInfo;
        private String nextPage;
        private JSONObject payInfo;
        private JSONObject payNewCardReconfirmInfo;
        private JSONObject processInfo;
        private JSONObject riskInfo;
        private JSONObject secondaryConfirmInfo;
        private String source;
        private String sourcePageName;
        private boolean useVoucherMsgV2;

        public final boolean getIsFront() {
            FromScene r100 = this.fromScene;
            if (r100 != FromScene.FROM_FRONT_ET) goto L5;
        L8:
            return true;
        L5:
            if (r100 == FromScene.FROM_FRONT_STANDARD) goto L8;
            return false;
        }

        public OutParams() {
            this.source = "";
            this.fromScene = FromScene.FROM_STANDARD;
            this.sourcePageName = "";
            this.isDoBindCardProcess = true;
            this.forbidCombinePay = Boolean.FALSE;
        }

        public final OnActivityResultCallback getAnimCallback() {
            return this.animCallback;
        }

        public final IPaymentMethodBindCardCallback getBindCardCallback() {
            return this.bindCardCallback;
        }

        public final JSONObject getBindCardInfo() {
            return this.bindCardInfo;
        }

        public final IPaymentMethodChangeCallback getChangeMethodCallback() {
            return this.changeMethodCallback;
        }

        public final JSONObject getCommonLogParams() {
            return this.commonLogParams;
        }

        public final VoucherDialogExpandResult getExpandResult() {
            return this.expandResult;
        }

        public final Boolean getForbidCombinePay() {
            return this.forbidCombinePay;
        }

        public final FromScene getFromScene() {
            return this.fromScene;
        }

        public final boolean getHideInsurance() {
            return this.hideInsurance;
        }

        public final JSONObject getHostInfo() {
            return this.hostInfo;
        }

        public final boolean getIfHasExpanded() {
            return this.ifHasExpanded;
        }

        public final String getNextPage() {
            return this.nextPage;
        }

        public final JSONObject getPayInfo() {
            return this.payInfo;
        }

        public final JSONObject getPayNewCardReconfirmInfo() {
            return this.payNewCardReconfirmInfo;
        }

        public final JSONObject getProcessInfo() {
            return this.processInfo;
        }

        public final JSONObject getRiskInfo() {
            return this.riskInfo;
        }

        public final JSONObject getSecondaryConfirmInfo() {
            return this.secondaryConfirmInfo;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getSourcePageName() {
            return this.sourcePageName;
        }

        public final boolean getUseVoucherMsgV2() {
            return this.useVoucherMsgV2;
        }

        public final boolean isDoBindCardProcess() {
            return this.isDoBindCardProcess;
        }

        public final boolean isStdAssetProcess() {
            return this.isStdAssetProcess;
        }

        public final boolean isUseNewGroupInfo() {
            return this.isUseNewGroupInfo;
        }

        public final void setAnimCallback(OnActivityResultCallback r100) {
            this.animCallback = r100;
        }

        public final void setBindCardCallback(IPaymentMethodBindCardCallback r100) {
            this.bindCardCallback = r100;
        }

        public final void setBindCardInfo(JSONObject r100) {
            this.bindCardInfo = r100;
        }

        public final void setChangeMethodCallback(IPaymentMethodChangeCallback r100) {
            this.changeMethodCallback = r100;
        }

        public final void setCommonLogParams(JSONObject r100) {
            this.commonLogParams = r100;
        }

        public final void setDoBindCardProcess(boolean r100) {
            this.isDoBindCardProcess = r100;
        }

        public final void setExpandResult(VoucherDialogExpandResult r100) {
            this.expandResult = r100;
        }

        public final void setForbidCombinePay(Boolean r100) {
            this.forbidCombinePay = r100;
        }

        public final void setFromScene(FromScene r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.fromScene = r100;
        }

        public final void setHideInsurance(boolean r100) {
            this.hideInsurance = r100;
        }

        public final void setHostInfo(JSONObject r100) {
            this.hostInfo = r100;
        }

        public final void setIfHasExpanded(boolean r100) {
            this.ifHasExpanded = r100;
        }

        public final void setNextPage(String r100) {
            this.nextPage = r100;
        }

        public final void setPayInfo(JSONObject r100) {
            this.payInfo = r100;
        }

        public final void setPayNewCardReconfirmInfo(JSONObject r100) {
            this.payNewCardReconfirmInfo = r100;
        }

        public final void setProcessInfo(JSONObject r100) {
            this.processInfo = r100;
        }

        public final void setRiskInfo(JSONObject r100) {
            this.riskInfo = r100;
        }

        public final void setSecondaryConfirmInfo(JSONObject r100) {
            this.secondaryConfirmInfo = r100;
        }

        public final void setSource(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.source = r100;
        }

        public final void setSourcePageName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.sourcePageName = r100;
        }

        public final void setStdAssetProcess(boolean r100) {
            this.isStdAssetProcess = r100;
        }

        public final void setUseNewGroupInfo(boolean r100) {
            this.isUseNewGroupInfo = r100;
        }

        public final void setUseVoucherMsgV2(boolean r100) {
            this.useVoucherMsgV2 = r100;
        }
    }

    void changePaymentMethod(String r100, boolean r101, AssetInfoBean r102);

    void disableSelectedAndStart(Context r100, int r101, String r102, String r103);

    JSONObject fetchSelectPayMethod();

    void init(OutParams r100);

    boolean isDataReady();

    void preQuery(String r100);

    void redoPreQuery(String r100, IQueryPayTypeResultCallback r101);

    void redoPreQuery(String r100, JSONArray r101, IQueryPayTypeResultCallback r102);

    void release();

    void releaseCallbacks();

    void setInsufficientCard(ArrayList<String> r100);

    void start(Context r100, int r101, boolean r102, Integer r103, String r104, String r105, String r106, String r107);

    void startActivity(Context r100, Integer r101, boolean r102, Integer r103, boolean r104, String r105, String r106, String r107, String r108);

    void updateOutParams(Function1<? super OutParams, Unit> r100);

    void updateUnavailableAndStart(Context r100, int r101, String r102);

    void updateUnavailableCard(Context r100, String r101);
}
