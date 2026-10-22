package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.service.bean.OuterPayInnerBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 B2\u00020\u0001:\u0001BJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J@\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&J*\u0010\u0013\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH&J2\u0010\u0013\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u001a\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u0003H&J&\u0010\u001c\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH&J8\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u0007H&J\\\u0010$\u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00072\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010(H&J\u001a\u0010+\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020\u0003H&J:\u0010-\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010-\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u00108\u001a\u0004\u0018\u0001092\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010:\u001a\u0004\u0018\u000103H&J:\u0010;\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010<\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020>2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010<\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u0002072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&JD\u0010<\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010?\u001a\u0004\u0018\u0001032\b\u00102\u001a\u0004\u0018\u0001032\b\u0010@\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010A\u001a\u0004\u0018\u00010\fH&J$\u0010<\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006C"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IOuterPayService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "addOuterCallback", "", "callback", "Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;", "hideLoading", "", "activity", "Landroid/app/Activity;", "isShowUserInfo", "userName", "", "isShowTargetView", "targetAnimationType", "isDynamicPwd", "hideOuterLoading", "", "callbackId", "onFinishCallback", "status", "extra", "msg", "reShowLoading", "release", "resetTargetView", "setTargetViewHeight", "height", "setUserInfo", "nickName", "avatar", "showGifLoading", "showSingleBtnErrorDialog", "Landroid/app/Dialog;", "content", "needMask", "showTipsDialog", "buttonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "leftBtnListener", "Lkotlin/Function0;", "rightBtnListener", "singleBtnListener", "startAnimationForNewHeight", "newHeight", "startBDOuterPay", "intent", "Landroid/content/Intent;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "hostInfo", "Lorg/json/JSONObject;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "outerPayInnerBean", "Lcom/android/ttcjpaysdk/base/service/bean/OuterPayInnerBean;", "startLoading", "Landroid/view/View;", "viewConfig", "startLoginContainer", "startOuterProcessInvokeForInner", "outerPayBean", "Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "params", "source", "sceneSource", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOuterPayService extends ICJPayService {
    public static final String CJ_PAY_SDK_VERSION_ERROR = "100";
    public static final Companion Companion = null;
    public static final String RESULT_CODE_CANCEL = "1";
    public static final String RESULT_CODE_FAIL = "2";
    public static final String RESULT_CODE_PROCESSING = "3";
    public static final String RESULT_CODE_SUCCESS = "0";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/IOuterPayService$Companion;", "", "()V", "CJ_PAY_SDK_VERSION_ERROR", "", "RESULT_CODE_CANCEL", "RESULT_CODE_FAIL", "RESULT_CODE_PROCESSING", "RESULT_CODE_SUCCESS", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String CJ_PAY_SDK_VERSION_ERROR = "100";
        public static final String RESULT_CODE_CANCEL = "1";
        public static final String RESULT_CODE_FAIL = "2";
        public static final String RESULT_CODE_PROCESSING = "3";
        public static final String RESULT_CODE_SUCCESS = "0";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ View startLoading$default(IOuterPayService r100, Activity r101, JSONObject r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.startLoading(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startLoading");
        }

        public static void onFinishCallback(IOuterPayService r100, Activity r101, int r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r103, "status");
            Intrinsics.checkNotNullParameter(r104, "msg");
            Intrinsics.checkNotNullParameter(r105, "extra");
            r100.onFinishCallback(r101, r102, r103, r105);
        }

        public static /* synthetic */ Dialog showSingleBtnErrorDialog$default(IOuterPayService r100, Activity r101, int r102, String r103, String r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 8) == 0) goto L6;
            r110 = "2";
        L6:
            String r104 = r110;
            if ((r112 & 16) == 0) goto L9;
            boolean r105 = false;
        L11:
            return r100.showSingleBtnErrorDialog(r101, r102, r103, r104, r105);
        L9:
            r105 = r111;
            goto L11
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSingleBtnErrorDialog");
        }

        public static /* synthetic */ boolean hideLoading$default(IOuterPayService r100, Activity r101, boolean r102, String r110, boolean r111, int r112, boolean r113, int r114, Object r115) {
            if (r115 != null) goto L17;
            if ((r114 & 4) == 0) goto L6;
            r110 = "";
        L6:
            String r103 = r110;
            if ((r114 & 16) == 0) goto L9;
            int r104 = -1;
        L11:
            if ((r114 & 32) == 0) goto L13;
            boolean r105 = false;
        L15:
            return r100.hideLoading(r101, r102, r103, r111, r104, r105);
        L13:
            r105 = r113;
            goto L15
        L9:
            r104 = r112;
            goto L11
        L17:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideLoading");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int addOuterCallback(CJOuterPayCallback r100);

    boolean hideLoading(Activity r100, boolean r101, String r102, boolean r103, int r104, boolean r105);

    void hideOuterLoading(int r100);

    void onFinishCallback(Activity r100, int r101, String r102, String r103);

    void onFinishCallback(Activity r100, int r101, String r102, String r103, String r104);

    void reShowLoading(Activity r100);

    void release(int r100);

    void resetTargetView(Activity r100);

    void setTargetViewHeight(Activity r100, int r101);

    void setUserInfo(Activity r100, String r101, String r102);

    void showGifLoading(Activity r100);

    Dialog showSingleBtnErrorDialog(Activity r100, int r101, String r102, String r103, boolean r104);

    Dialog showTipsDialog(Activity r100, int r101, CJPayButtonInfo r102, boolean r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Unit> r106);

    void startAnimationForNewHeight(Activity r100, int r101);

    void startBDOuterPay(Activity r100, Intent r101, ViewGroup r102, JSONObject r103, CJOuterPayCallback r104);

    void startBDOuterPay(Context r100, OuterPayInnerBean r101, CJOuterPayCallback r102);

    View startLoading(Activity r100, JSONObject r101);

    void startLoginContainer(Activity r100, Intent r101, ViewGroup r102, JSONObject r103, CJOuterPayCallback r104);

    void startOuterProcessInvokeForInner(Activity r100, CJOuterPayBean r101, CJOuterPayCallback r102);

    void startOuterProcessInvokeForInner(Activity r100, OuterPayInnerBean r101, CJOuterPayCallback r102);

    void startOuterProcessInvokeForInner(Activity r100, JSONObject r101, JSONObject r102, String r103, CJOuterPayCallback r104, String r105);

    void startOuterProcessInvokeForInner(Context r100, OuterPayInnerBean r101, CJOuterPayCallback r102);
}
