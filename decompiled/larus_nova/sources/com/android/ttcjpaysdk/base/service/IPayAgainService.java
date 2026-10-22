package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001:\u0004+,-.J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J8\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0005H&J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&Jw\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010*¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayAgainService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "finishAllFragment", "", "isDoAnim", "", "finishPayAgainGuideRightNow", "init", "activity", "Landroidx/fragment/app/FragmentActivity;", "contentResId", "", "params", "Lcom/android/ttcjpaysdk/base/service/IPayAgainService$OutParams;", "callback", "Lcom/android/ttcjpaysdk/base/service/IPayAgainService$IPayAgainCallback;", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "isEmpty", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "relayoutCurrentPageAfterHostLayoutChanged", "reason", "", "release", "start", "hintInfoJO", "Lorg/json/JSONObject;", "combineType", "isFromNormalPage", "extParam", "height", "errorCode", "errorMessage", "showMask", "inAnim", "outAnim", "isFromSuperPayFail", "(Lorg/json/JSONObject;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Boolean;Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;)V", "FromScene", "IPayAgainCallback", "OutParams", "VerifyResult", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayAgainService extends ICJPayService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void finishAllFragment$default(IPayAgainService r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = true;
        L6:
            r100.finishAllFragment(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishAllFragment");
        }

        public static /* synthetic */ void release$default(IPayAgainService r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = true;
        L6:
            r100.release(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
        }

        public static /* synthetic */ void start$default(IPayAgainService r110, JSONObject r111, String r112, boolean r113, String r210, int r211, String r212, String r213, String r214, int r215, int r216, Boolean r217, CJContext r218, int r219, Object r310) {
            if (r310 != null) goto L19;
            if ((r219 & 256) == 0) goto L7;
            int r114 = -1;
        L9:
            if ((r219 & 512) == 0) goto L11;
            int r115 = -1;
        L13:
            if ((r219 & 1024) == 0) goto L15;
            Boolean r116 = Boolean.FALSE;
        L16:
            r110.start(r111, r112, r113, r210, r211, r212, r213, r214, r114, r115, r116, r218);
            return;
        L15:
            r116 = r217;
            goto L16
        L11:
            r115 = r216;
            goto L13
        L7:
            r114 = r215;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;", "", "(Ljava/lang/String;I)V", "FROM_STANDARD", "FROM_FRONT_ET", "FROM_FRONT_STANDARD", "FROM_NEW_ET", "FROM_NEW_STANDARD", "FROM_NEW_INTEGRATE", "FROM_O_OUTER_INDEPENDENT", "FROM_SUPER_PAY_FAIL", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FromScene extends Enum<FromScene> {
        private static final /* synthetic */ FromScene[] $VALUES = null;
        public static final FromScene FROM_FRONT_ET = null;
        public static final FromScene FROM_FRONT_STANDARD = null;
        public static final FromScene FROM_NEW_ET = null;
        public static final FromScene FROM_NEW_INTEGRATE = null;
        public static final FromScene FROM_NEW_STANDARD = null;
        public static final FromScene FROM_O_OUTER_INDEPENDENT = null;
        public static final FromScene FROM_STANDARD = null;
        public static final FromScene FROM_SUPER_PAY_FAIL = null;

        private static final /* synthetic */ FromScene[] $values() {
            return new FromScene[]{FROM_STANDARD, FROM_FRONT_ET, FROM_FRONT_STANDARD, FROM_NEW_ET, FROM_NEW_STANDARD, FROM_NEW_INTEGRATE, FROM_O_OUTER_INDEPENDENT, FROM_SUPER_PAY_FAIL};
        }

        public static FromScene valueOf(String r100) {
            return (FromScene) a.a(FromScene.class, r100);
        }

        public static FromScene[] values() {
            return (FromScene[]) $VALUES.clone();
        }

        static {
            FROM_STANDARD = new FromScene("FROM_STANDARD", 0);
            FROM_FRONT_ET = new FromScene("FROM_FRONT_ET", 1);
            FROM_FRONT_STANDARD = new FromScene("FROM_FRONT_STANDARD", 2);
            FROM_NEW_ET = new FromScene("FROM_NEW_ET", 3);
            FROM_NEW_STANDARD = new FromScene("FROM_NEW_STANDARD", 4);
            FROM_NEW_INTEGRATE = new FromScene("FROM_NEW_INTEGRATE", 5);
            FROM_O_OUTER_INDEPENDENT = new FromScene("FROM_O_OUTER_INDEPENDENT", 6);
            FROM_SUPER_PAY_FAIL = new FromScene("FROM_SUPER_PAY_FAIL", 7);
            $VALUES = $values();
        }

        private FromScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005H&JN\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005H&J2\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0013H&J&\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H&J@\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0005H&J\b\u0010(\u001a\u00020\u0003H&JL\u0010)\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010 2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010 H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0005H&J&\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010 2\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005H&J\u001e\u00105\u001a\u00020\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00107\u001a\u00020\u0005H&J2\u00108\u001a\u00020\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\u0005H&¨\u00069"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayAgainService$IPayAgainCallback;", "", "close", "", "hasBindCard", "", "code", "", "closeAll", "finishPrePage", "forceFinish", "getErrorDialogClickListener", "Landroid/view/View$OnClickListener;", "action", "dialog", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "jumpUrl", "", "appId", "merchantId", "onErrorDialogBtnClick", "hideFullLoading", "isShowMask", "isDoAnim", "hideLoading", "isBindNewCardForPay", "onBindCardPayResult", "result", "checkList", "params", "Lorg/json/JSONObject;", "onCreditPayActivateResult", "creditAmount", "realTradeAmount", "successDesc", "activateFailDesc", "activateToastFailDesc", "showSuccessToast", "onPayAgainMainPageDidShow", "onVerifyResult", "Lcom/android/ttcjpaysdk/base/service/IPayAgainService$VerifyResult;", "responseBean", "verifyParamsJson", "sharedParams", "", "queryBean", "performLayerViewVisible", "isVisible", "setCheckoutResponseBean", "jsonObject", "isFrontMethod", "showFullLoading", "payMessage", "isPayScene", DyPayConstant.KEY_SHOW_LOADING, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IPayAgainCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void finishPrePage$default(IPayAgainCallback r100, boolean r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = false;
            L6:
                r100.finishPrePage(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishPrePage");
            }

            public static /* synthetic */ void close$default(IPayAgainCallback r100, boolean r101, int r102, int r103, Object r104) {
                if (r104 != null) goto L9;
                if ((r103 & 2) == 0) goto L6;
                r102 = 113;
            L6:
                r100.close(r101, r102);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }

            public static /* synthetic */ void hideFullLoading$default(IPayAgainCallback r100, boolean r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = true;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = false;
            L9:
                r100.hideFullLoading(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideFullLoading");
            }

            public static /* synthetic */ void showFullLoading$default(IPayAgainCallback r100, String r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = "";
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = true;
            L9:
                r100.showFullLoading(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFullLoading");
            }

            public static /* synthetic */ void onBindCardPayResult$default(IPayAgainCallback r100, String r101, String r102, JSONObject r103, int r104, Object r105) {
                if (r105 != null) goto L9;
                if ((r104 & 4) == 0) goto L6;
                r103 = null;
            L6:
                r100.onBindCardPayResult(r101, r102, r103);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBindCardPayResult");
            }

            public static /* synthetic */ void setCheckoutResponseBean$default(IPayAgainCallback r100, JSONObject r101, boolean r102, boolean r103, int r104, Object r105) {
                if (r105 != null) goto L12;
                if ((r104 & 2) == 0) goto L7;
                r102 = false;
            L7:
                if ((r104 & 4) == 0) goto L9;
                r103 = false;
            L9:
                r100.setCheckoutResponseBean(r101, r102, r103);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCheckoutResponseBean");
            }

            public static /* synthetic */ void hideLoading$default(IPayAgainCallback r100, boolean r101, boolean r102, boolean r103, String r104, int r105, Object r106) {
                if (r106 != null) goto L18;
                if ((r105 & 1) == 0) goto L7;
                r101 = true;
            L7:
                if ((r105 & 2) == 0) goto L10;
                r102 = false;
            L10:
                if ((r105 & 4) == 0) goto L13;
                r103 = false;
            L13:
                if ((r105 & 8) == 0) goto L15;
                r104 = null;
            L15:
                r100.hideLoading(r101, r102, r103, r104);
                return;
            L18:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideLoading");
            }

            public static /* synthetic */ void showLoading$default(IPayAgainCallback r100, String r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
                if (r106 != null) goto L18;
                if ((r105 & 1) == 0) goto L7;
                r101 = "";
            L7:
                if ((r105 & 2) == 0) goto L10;
                r102 = false;
            L10:
                if ((r105 & 4) == 0) goto L13;
                r103 = false;
            L13:
                if ((r105 & 8) == 0) goto L15;
                r104 = true;
            L15:
                r100.showLoading(r101, r102, r103, r104);
                return;
            L18:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void onVerifyResult$default(IPayAgainCallback r100, VerifyResult r101, JSONObject r102, JSONObject r110, Map r111, JSONObject r112, int r113, Object r114) {
                if (r114 != null) goto L22;
                if ((r113 & 2) == 0) goto L6;
                JSONObject r103 = null;
            L8:
                if ((r113 & 4) == 0) goto L10;
                JSONObject r104 = null;
            L12:
                if ((r113 & 8) == 0) goto L14;
                Map r105 = null;
            L16:
                if ((r113 & 16) == 0) goto L18;
                JSONObject r106 = null;
            L19:
                r100.onVerifyResult(r101, r103, r104, r105, r106);
                return;
            L18:
                r106 = r112;
                goto L19
            L14:
                r105 = r111;
                goto L16
            L10:
                r104 = r110;
                goto L12
            L6:
                r103 = r102;
                goto L8
            L22:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVerifyResult");
            }
        }

        void close(boolean r100, int r101);

        void closeAll(int r100);

        void finishPrePage(boolean r100);

        View.OnClickListener getErrorDialogClickListener(int r100, Dialog r101, Activity r102, String r103, String r104, String r105, View.OnClickListener r106);

        void hideFullLoading(boolean r100, boolean r101);

        void hideLoading(boolean r100, boolean r101, boolean r102, String r103);

        void onBindCardPayResult(String r100, String r101, JSONObject r102);

        void onCreditPayActivateResult(String r100, int r101, int r102, String r103, String r104, String r105, boolean r106);

        void onPayAgainMainPageDidShow();

        void onVerifyResult(VerifyResult r100, JSONObject r101, JSONObject r102, Map<String, String> r103, JSONObject r104);

        void performLayerViewVisible(boolean r100);

        void setCheckoutResponseBean(JSONObject r100, boolean r101, boolean r102);

        void showFullLoading(String r100, boolean r101);

        void showLoading(String r100, boolean r101, boolean r102, boolean r103);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010M\u001a\u00020\u0012J\u0006\u0010N\u001a\u00020\u0012J\u0006\u0010O\u001a\u00020\u0012J\u0006\u0010P\u001a\u00020\u0012J\u0006\u0010Q\u001a\u00020\u0012J\u0006\u0010R\u001a\u00020\u0012R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010(\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001a\u0010*\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001a\u0010.\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001a\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R\u001a\u0010<\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001a\u0010?\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108R6\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Cj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR6\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050Cj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010H¨\u0006S"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayAgainService$OutParams;", "", "()V", "cashierTag", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCashierTag", "()Ljava/util/ArrayList;", "setCashierTag", "(Ljava/util/ArrayList;)V", "commonLogParams", "Lorg/json/JSONObject;", "getCommonLogParams", "()Lorg/json/JSONObject;", "setCommonLogParams", "(Lorg/json/JSONObject;)V", "forbidRetainDefault", "", "getForbidRetainDefault", "()Z", "setForbidRetainDefault", "(Z)V", "fromScene", "Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;", "getFromScene", "()Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;", "setFromScene", "(Lcom/android/ttcjpaysdk/base/service/IPayAgainService$FromScene;)V", "hostInfo", "getHostInfo", "setHostInfo", "httpRiskInfoMap", "", "getHttpRiskInfoMap", "()Ljava/util/Map;", "setHttpRiskInfoMap", "(Ljava/util/Map;)V", "isAssetStandard", "setAssetStandard", "isFirstEntry", "setFirstEntry", "isOuterPayForOut", "setOuterPayForOut", "isStandardPayAgainLegacyVerify", "setStandardPayAgainLegacyVerify", "needResignCard", "getNeedResignCard", "setNeedResignCard", "processInfo", "getProcessInfo", "setProcessInfo", "pwdCheckWay", "getPwdCheckWay", "()Ljava/lang/String;", "setPwdCheckWay", "(Ljava/lang/String;)V", "riskInfo", "getRiskInfo", "setRiskInfo", "source", "getSource", "setSource", "tradeNo", "getTradeNo", "setTradeNo", "unavailableAssetMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUnavailableAssetMap", "()Ljava/util/HashMap;", "setUnavailableAssetMap", "(Ljava/util/HashMap;)V", "unavailableCardIds", "getUnavailableCardIds", "setUnavailableCardIds", "getHttpRiskInfo", "resetIdentityToken", "getIsFront", "isFromSuperPay", "isNewDyPayScene", "isOuterBdPay", "isOuterIndependentBdPay", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OutParams {
        private ArrayList<String> cashierTag;
        private JSONObject commonLogParams;
        private boolean forbidRetainDefault;
        private FromScene fromScene;
        private JSONObject hostInfo;
        private Map<Boolean, JSONObject> httpRiskInfoMap;
        private boolean isAssetStandard;
        private boolean isFirstEntry;
        private boolean isOuterPayForOut;
        private boolean isStandardPayAgainLegacyVerify;
        private boolean needResignCard;
        private JSONObject processInfo;
        private String pwdCheckWay;
        private JSONObject riskInfo;
        private String source;
        private String tradeNo;
        private HashMap<String, String> unavailableAssetMap;
        private HashMap<String, String> unavailableCardIds;

        public final boolean getIsFront() {
            FromScene r100 = this.fromScene;
            if (r100 != FromScene.FROM_FRONT_ET) goto L5;
        L8:
            return true;
        L5:
            if (r100 == FromScene.FROM_FRONT_STANDARD) goto L8;
            return false;
        }

        public final boolean isFromSuperPay() {
            if (this.fromScene != FromScene.FROM_SUPER_PAY_FAIL) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isNewDyPayScene() {
            FromScene r100 = this.fromScene;
            if (r100 != FromScene.FROM_NEW_ET) goto L5;
        L14:
            return true;
        L5:
            if (r100 == FromScene.FROM_NEW_STANDARD) goto L14;
            if (r100 == FromScene.FROM_NEW_INTEGRATE) goto L14;
            if (r100 == FromScene.FROM_O_OUTER_INDEPENDENT) goto L14;
            if (r100 == FromScene.FROM_SUPER_PAY_FAIL) goto L14;
            return false;
        }

        public final boolean isOuterBdPay() {
            if (this.fromScene != FromScene.FROM_O_OUTER_INDEPENDENT) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isOuterIndependentBdPay() {
            if (this.fromScene != FromScene.FROM_O_OUTER_INDEPENDENT) goto L5;
            return true;
        L5:
            return false;
        }

        public OutParams() {
            this.unavailableCardIds = new HashMap();
            this.unavailableAssetMap = new HashMap();
            this.pwdCheckWay = "";
            this.tradeNo = "";
            this.source = "";
            this.fromScene = FromScene.FROM_STANDARD;
            this.httpRiskInfoMap = new LinkedHashMap();
        }

        public final ArrayList<String> getCashierTag() {
            return this.cashierTag;
        }

        public final JSONObject getCommonLogParams() {
            return this.commonLogParams;
        }

        public final boolean getForbidRetainDefault() {
            return this.forbidRetainDefault;
        }

        public final FromScene getFromScene() {
            return this.fromScene;
        }

        public final JSONObject getHostInfo() {
            return this.hostInfo;
        }

        public final Map<Boolean, JSONObject> getHttpRiskInfoMap() {
            return this.httpRiskInfoMap;
        }

        public final boolean getNeedResignCard() {
            return this.needResignCard;
        }

        public final JSONObject getProcessInfo() {
            return this.processInfo;
        }

        public final String getPwdCheckWay() {
            return this.pwdCheckWay;
        }

        public final JSONObject getRiskInfo() {
            return this.riskInfo;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getTradeNo() {
            return this.tradeNo;
        }

        public final HashMap<String, String> getUnavailableAssetMap() {
            return this.unavailableAssetMap;
        }

        public final HashMap<String, String> getUnavailableCardIds() {
            return this.unavailableCardIds;
        }

        public final boolean isAssetStandard() {
            return this.isAssetStandard;
        }

        public final boolean isFirstEntry() {
            return this.isFirstEntry;
        }

        public final boolean isOuterPayForOut() {
            return this.isOuterPayForOut;
        }

        public final boolean isStandardPayAgainLegacyVerify() {
            return this.isStandardPayAgainLegacyVerify;
        }

        public final JSONObject getHttpRiskInfo(boolean r100) {
            return this.httpRiskInfoMap.get(Boolean.valueOf(r100));
        }

        public final void setAssetStandard(boolean r100) {
            this.isAssetStandard = r100;
        }

        public final void setCashierTag(ArrayList<String> r100) {
            this.cashierTag = r100;
        }

        public final void setCommonLogParams(JSONObject r100) {
            this.commonLogParams = r100;
        }

        public final void setFirstEntry(boolean r100) {
            this.isFirstEntry = r100;
        }

        public final void setForbidRetainDefault(boolean r100) {
            this.forbidRetainDefault = r100;
        }

        public final void setFromScene(FromScene r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.fromScene = r100;
        }

        public final void setHostInfo(JSONObject r100) {
            this.hostInfo = r100;
        }

        public final void setHttpRiskInfoMap(Map<Boolean, JSONObject> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.httpRiskInfoMap = r100;
        }

        public final void setNeedResignCard(boolean r100) {
            this.needResignCard = r100;
        }

        public final void setOuterPayForOut(boolean r100) {
            this.isOuterPayForOut = r100;
        }

        public final void setProcessInfo(JSONObject r100) {
            this.processInfo = r100;
        }

        public final void setPwdCheckWay(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.pwdCheckWay = r100;
        }

        public final void setRiskInfo(JSONObject r100) {
            this.riskInfo = r100;
        }

        public final void setSource(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.source = r100;
        }

        public final void setStandardPayAgainLegacyVerify(boolean r100) {
            this.isStandardPayAgainLegacyVerify = r100;
        }

        public final void setTradeNo(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.tradeNo = r100;
        }

        public final void setUnavailableAssetMap(HashMap<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.unavailableAssetMap = r100;
        }

        public final void setUnavailableCardIds(HashMap<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.unavailableCardIds = r100;
        }

        public static /* synthetic */ JSONObject getHttpRiskInfo$default(OutParams r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getHttpRiskInfo(r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IPayAgainService$VerifyResult;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "LOGIN_FAILED", "TO_CONFIRM", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum VerifyResult extends Enum<VerifyResult> {
        private static final /* synthetic */ VerifyResult[] $VALUES = null;
        public static final VerifyResult FAILED = null;
        public static final VerifyResult LOGIN_FAILED = null;
        public static final VerifyResult SUCCESS = null;
        public static final VerifyResult TO_CONFIRM = null;

        private static final /* synthetic */ VerifyResult[] $values() {
            return new VerifyResult[]{SUCCESS, FAILED, LOGIN_FAILED, TO_CONFIRM};
        }

        public static VerifyResult valueOf(String r100) {
            return (VerifyResult) a.a(VerifyResult.class, r100);
        }

        public static VerifyResult[] values() {
            return (VerifyResult[]) $VALUES.clone();
        }

        static {
            SUCCESS = new VerifyResult("SUCCESS", 0);
            FAILED = new VerifyResult("FAILED", 1);
            LOGIN_FAILED = new VerifyResult("LOGIN_FAILED", 2);
            TO_CONFIRM = new VerifyResult("TO_CONFIRM", 3);
            $VALUES = $values();
        }

        private VerifyResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    void finishAllFragment(boolean r100);

    void finishPayAgainGuideRightNow();

    void init(FragmentActivity r100, int r101, OutParams r102, IPayAgainCallback r103, CJContext r104);

    boolean isEmpty();

    boolean onActivityResult(int r100, int r101, Intent r102);

    boolean onBackPressed();

    void relayoutCurrentPageAfterHostLayoutChanged(String r100);

    void release(boolean r100);

    void start(JSONObject r100, String r101, boolean r102, String r103, int r104, String r105, String r106, String r107, int r108, int r110, Boolean r111, CJContext r112);
}
