package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000 Z2\u00020\u0001:\u0004Z[\\]J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0014\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0003H&J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020\rH&J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003H&J\u0012\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0005H&Jc\u0010*\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u0003H&¢\u0006\u0002\u00105J$\u00106\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\u0005H&Ja\u00107\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010;J[\u0010<\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010?JC\u0010@\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010CJ\u0085\u0001\u0010D\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u00101\u001a\u0002002\u0006\u0010G\u001a\u00020H2\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010LJ]\u0010M\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010F2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010NJ_\u0010O\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010RJk\u0010S\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020,2\b\u0010T\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010UJ$\u0010V\u001a\u00020\r2\b\u0010W\u001a\u0004\u0018\u00010\u00052\b\u0010X\u001a\u0004\u0018\u00010\u00052\u0006\u0010Y\u001a\u000200H&¨\u0006^"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getCopyWritingEnd", "", "getSecurityLoadingInfo", "", "getSecurityLoadingMinTime", "", "customScene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "(Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;)Ljava/lang/Long;", "getSecurityLoadingMsg", "hideCustomPanelViewLoading", "", "hideDiaLogViewLoading", "hideDialogLoading", "hideDialogLoadingForInnerInvoke", "hideLoading", "hidePanelLoading", "isCustomPanelLoadingViewShowing", "isDialogLoadingActivityShowing", "isDialogLoadingShowing", "isDialogLoadingViewShowing", "isNeedHideDialogLoading", "isPanelLoadingShowing", "isUniform", "isValidInfoSupportShow", "notifyPayEnd", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$UpdateCallBack;", "notifyUpdate", "isDialogLoading", "preLoad", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "release", "setCopyWritingEnd", "isEnd", "setDialogLoadingShowing", "isShowing", "setSecurityLoadingInfo", "securityLoadingInfo", "showCustomPanelViewLoading", "scene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;", "loadingInfo", "specialCopyWriting", "loadingTimeout", "", "containerHeightDip", "url", "showWatermark", "isReuse", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ZZ)Z", "showDialogLoading", "showDialogLoadingForInnerInvoke", "isPwdFreeDegrade", "isPayNewCard", "isFromStd", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;ZZLcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;Ljava/lang/Integer;Ljava/lang/Boolean;)Z", "showDialogLoadingForSpecialCopyWriting", "securityLoadingCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingCallback;Ljava/lang/Integer;Ljava/lang/Boolean;)Z", DyPayConstant.KEY_SHOW_LOADING, "loadinginfo", "isBgTrans", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Z", "showPanelLoading", "containerView", "Landroid/view/ViewGroup;", "percent", "", "isHitLoadingUniform", "needLayoutCenter", "isHidePre", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Landroid/view/ViewGroup;IFZZZZLjava/lang/Boolean;Ljava/lang/String;)Z", "showPanelLoadingForCommon", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Landroid/view/ViewGroup;IZZLjava/lang/Boolean;)Z", "showPanelLoadingForSpecial", "params", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;ZZLjava/lang/Boolean;)Z", "showStdDialogViewLoading", "securityLoadingInfoString", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Ljava/lang/String;ZZLcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;Ljava/lang/Integer;Ljava/lang/Boolean;)Z", "updateDialogViewStatusForReuse", "msg", "subMsg", "iconType", "Companion", "LoadingCustomScene", "SecurityLoadingScene", "UpdateCallBack", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPaySecurityLoadingService extends ICJPayService {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$Companion;", "", "()V", "getSdkShowInfo", "", "jo", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final String getSdkShowInfo(JSONObject r100) {
            if (r100 == null) goto L24;
            JSONObject r101 = r100.optJSONObject("sdk_show_info");     // Catch: Exception -> L19
            if (r101 == null) goto L25;
            String r102 = r101.toString();     // Catch: Exception -> L19
            if (r102 != null) goto L9;
            return "";
        L9:
            if (StringsKt.isBlank(r102) == true) goto L13;
            if (Intrinsics.areEqual(r102, SliceInitService.DEFAULT_SWITCH) == true) goto L13;
            boolean r103 = true;
        L14:
            if (r103 == true) goto L17;
            r102 = null;
        L17:
            if (r102 != null) goto L28;
            return "";
        L28:
            return r102;
        L13:
            r103 = false;
            goto L14
        L25:
            return "";
        L19:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("ICJPaySecurityLoadingService#getSdkShowInfo", e);
            CJBasicCommonUtils.logCatch("CJCatch", "ICJPaySecurityLoadingService#getSdkShowInfo", e);
            return "";
        L24:
            return "";
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean notifyPayEnd$default(ICJPaySecurityLoadingService r100, UpdateCallBack r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L7;
            r101 = null;
        L7:
            return r100.notifyPayEnd(r101);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyPayEnd");
        }

        public static /* synthetic */ boolean showLoading$default(ICJPaySecurityLoadingService r100, Context r101, String r102, String r103, Boolean r110, Boolean r111, int r112, Object r113) {
            if (r113 != null) goto L15;
            if ((r112 & 4) == 0) goto L6;
            r103 = null;
        L6:
            String r104 = r103;
            if ((r112 & 8) == 0) goto L9;
            r110 = Boolean.FALSE;
        L9:
            Boolean r105 = r110;
            if ((r112 & 16) == 0) goto L13;
            r111 = Boolean.FALSE;
        L13:
            return r100.showLoading(r101, r102, r104, r105, r111);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
        }

        public static /* synthetic */ boolean showDialogLoadingForSpecialCopyWriting$default(ICJPaySecurityLoadingService r110, Context r111, String r112, String r113, LoadingCustomScene r114, ICJPaySecurityLoadingCallback r115, Integer r116, Boolean r117, int r118, Object r119) {
            if (r119 != null) goto L26;
            if ((r118 & 4) == 0) goto L6;
            String r100 = null;
        L8:
            if ((r118 & 8) == 0) goto L10;
            LoadingCustomScene r101 = null;
        L12:
            if ((r118 & 16) == 0) goto L14;
            ICJPaySecurityLoadingCallback r102 = null;
        L16:
            if ((r118 & 32) == 0) goto L18;
            Integer r103 = -1;
        L20:
            if ((r118 & 64) == 0) goto L22;
            Boolean r104 = Boolean.FALSE;
        L24:
            return r110.showDialogLoadingForSpecialCopyWriting(r111, r112, r100, r101, r102, r103, r104);
        L22:
            r104 = r117;
            goto L24
        L18:
            r103 = r116;
            goto L20
        L14:
            r102 = r115;
            goto L16
        L10:
            r101 = r114;
            goto L12
        L6:
            r100 = r113;
            goto L8
        L26:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialogLoadingForSpecialCopyWriting");
        }

        public static /* synthetic */ boolean showDialogLoadingForInnerInvoke$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, boolean r114, boolean r115, LoadingCustomScene r116, Integer r117, Boolean r210, int r211, Object r212) {
            if (r212 != null) goto L27;
            if ((r211 & 8) == 0) goto L7;
            boolean r100 = false;
        L9:
            if ((r211 & 16) == 0) goto L11;
            boolean r101 = false;
        L13:
            if ((r211 & 32) == 0) goto L15;
            LoadingCustomScene r102 = null;
        L17:
            if ((r211 & 64) == 0) goto L19;
            Integer r118 = -1;
        L21:
            if ((r211 & 128) == 0) goto L23;
            Boolean r119 = Boolean.FALSE;
        L25:
            return r110.showDialogLoadingForInnerInvoke(r111, r112, r113, r100, r101, r102, r118, r119);
        L23:
            r119 = r210;
            goto L25
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
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialogLoadingForInnerInvoke");
        }

        public static /* synthetic */ boolean showPanelLoadingForCommon$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, ViewGroup r114, int r115, boolean r116, boolean r117, Boolean r118, int r210, Object r211) {
            if (r211 != null) goto L23;
            if ((r210 & 16) == 0) goto L7;
            int r100 = 470;
        L9:
            if ((r210 & 32) == 0) goto L11;
            boolean r101 = false;
        L13:
            if ((r210 & 64) == 0) goto L15;
            boolean r102 = false;
        L17:
            if ((r210 & 128) == 0) goto L19;
            Boolean r119 = Boolean.FALSE;
        L21:
            return r110.showPanelLoadingForCommon(r111, r112, r113, r114, r100, r101, r102, r119);
        L19:
            r119 = r118;
            goto L21
        L15:
            r102 = r117;
            goto L17
        L11:
            r101 = r116;
            goto L13
        L7:
            r100 = r115;
            goto L9
        L23:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanelLoadingForCommon");
        }

        public static /* synthetic */ boolean showPanelLoadingForSpecial$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, ViewGroup r114, ViewGroup.LayoutParams r115, boolean r116, boolean r117, Boolean r118, int r210, Object r211) {
            if (r211 != null) goto L23;
            if ((r210 & 16) == 0) goto L7;
            ViewGroup.LayoutParams r100 = null;
        L9:
            if ((r210 & 32) == 0) goto L11;
            boolean r101 = false;
        L13:
            if ((r210 & 64) == 0) goto L15;
            boolean r102 = false;
        L17:
            if ((r210 & 128) == 0) goto L19;
            Boolean r119 = Boolean.FALSE;
        L21:
            return r110.showPanelLoadingForSpecial(r111, r112, r113, r114, r100, r101, r102, r119);
        L19:
            r119 = r118;
            goto L21
        L15:
            r102 = r117;
            goto L17
        L11:
            r101 = r116;
            goto L13
        L7:
            r100 = r115;
            goto L9
        L23:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanelLoadingForSpecial");
        }

        public static /* synthetic */ boolean showCustomPanelViewLoading$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, String r114, Integer r115, int r116, String r117, boolean r210, boolean r211, int r212, Object r213) {
            if (r213 != null) goto L15;
            if ((r212 & 16) == 0) goto L7;
            Integer r100 = -1;
        L9:
            if ((r212 & 256) == 0) goto L11;
            boolean r118 = false;
        L13:
            return r110.showCustomPanelViewLoading(r111, r112, r113, r114, r100, r116, r117, r210, r118);
        L11:
            r118 = r211;
            goto L13
        L7:
            r100 = r115;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCustomPanelViewLoading");
        }

        public static /* synthetic */ boolean showStdDialogViewLoading$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, String r114, boolean r115, boolean r116, LoadingCustomScene r210, Integer r211, Boolean r212, int r213, Object r214) {
            if (r214 != null) goto L27;
            if ((r213 & 16) == 0) goto L7;
            boolean r100 = false;
        L9:
            if ((r213 & 32) == 0) goto L11;
            boolean r101 = false;
        L13:
            if ((r213 & 64) == 0) goto L15;
            LoadingCustomScene r117 = null;
        L17:
            if ((r213 & 128) == 0) goto L19;
            Integer r118 = -1;
        L21:
            if ((r213 & 256) == 0) goto L23;
            Boolean r119 = Boolean.FALSE;
        L25:
            return r110.showStdDialogViewLoading(r111, r112, r113, r114, r100, r101, r117, r118, r119);
        L23:
            r119 = r212;
            goto L25
        L19:
            r118 = r211;
            goto L21
        L15:
            r117 = r210;
            goto L17
        L11:
            r101 = r116;
            goto L13
        L7:
            r100 = r115;
            goto L9
        L27:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showStdDialogViewLoading");
        }

        public static /* synthetic */ boolean showPanelLoading$default(ICJPaySecurityLoadingService r110, Context r111, SecurityLoadingScene r112, String r113, ViewGroup r210, int r211, float r212, boolean r213, boolean r214, boolean r215, boolean r216, Boolean r217, String r218, int r219, Object r310) {
            if (r310 != null) goto L35;
            if ((r219 & 16) == 0) goto L7;
            int r100 = 0;
        L9:
            if ((r219 & 64) == 0) goto L11;
            boolean r114 = false;
        L13:
            if ((r219 & 128) == 0) goto L15;
            boolean r115 = false;
        L17:
            if ((r219 & 256) == 0) goto L19;
            boolean r116 = false;
        L21:
            if ((r219 & 512) == 0) goto L23;
            boolean r117 = true;
        L25:
            if ((r219 & 1024) == 0) goto L27;
            Boolean r118 = Boolean.FALSE;
        L29:
            if ((r219 & 2048) == 0) goto L31;
            String r119 = null;
        L33:
            return r110.showPanelLoading(r111, r112, r113, r210, r100, r212, r114, r115, r116, r117, r118, r119);
        L31:
            r119 = r218;
            goto L33
        L27:
            r118 = r217;
            goto L29
        L23:
            r117 = r216;
            goto L25
        L19:
            r116 = r215;
            goto L21
        L15:
            r115 = r214;
            goto L17
        L11:
            r114 = r213;
            goto L13
        L7:
            r100 = r211;
            goto L9
        L35:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanelLoading");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "VERIFY_PRE_LOADING", "LOADING_ROUND_SCENE", "LOADING_REUSE_AND_UPDATE_INFO", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LoadingCustomScene extends Enum<LoadingCustomScene> {
        private static final /* synthetic */ LoadingCustomScene[] $VALUES = null;
        public static final LoadingCustomScene LOADING_REUSE_AND_UPDATE_INFO = null;
        public static final LoadingCustomScene LOADING_ROUND_SCENE = null;
        public static final LoadingCustomScene VERIFY_PRE_LOADING = null;
        private final String scene;

        private static final /* synthetic */ LoadingCustomScene[] $values() {
            return new LoadingCustomScene[]{VERIFY_PRE_LOADING, LOADING_ROUND_SCENE, LOADING_REUSE_AND_UPDATE_INFO};
        }

        public static LoadingCustomScene valueOf(String r100) {
            return (LoadingCustomScene) a.a(LoadingCustomScene.class, r100);
        }

        public static LoadingCustomScene[] values() {
            return (LoadingCustomScene[]) $VALUES.clone();
        }

        static {
            VERIFY_PRE_LOADING = new LoadingCustomScene("VERIFY_PRE_LOADING", 0, "verify_pre_loading");
            LOADING_ROUND_SCENE = new LoadingCustomScene("LOADING_ROUND_SCENE", 1, "loading_round_scene");
            LOADING_REUSE_AND_UPDATE_INFO = new LoadingCustomScene("LOADING_REUSE_AND_UPDATE_INFO", 2, "loading_reuse_and_update_info");
            $VALUES = $values();
        }

        public final String getScene() {
            return this.scene;
        }

        private LoadingCustomScene(String r100, int r101, String r102) {
            super(r100, r101);
            this.scene = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;", "", "sceneDes", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneDes", "()Ljava/lang/String;", "SECURITY_LOADING_SCENE_NORMAL", "SECURITY_LOADING_SCENE_PAY", "SECURITY_LOADING_SCENE_COMBINE", "SECURITY_LOADING_SCENE_REUSE", "SECURITY_LOADING_SCENE_REUSE_AND_UPDATE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SecurityLoadingScene extends Enum<SecurityLoadingScene> {
        private static final /* synthetic */ SecurityLoadingScene[] $VALUES = null;
        public static final SecurityLoadingScene SECURITY_LOADING_SCENE_COMBINE = null;
        public static final SecurityLoadingScene SECURITY_LOADING_SCENE_NORMAL = null;
        public static final SecurityLoadingScene SECURITY_LOADING_SCENE_PAY = null;
        public static final SecurityLoadingScene SECURITY_LOADING_SCENE_REUSE = null;
        public static final SecurityLoadingScene SECURITY_LOADING_SCENE_REUSE_AND_UPDATE = null;
        private final String sceneDes;

        private static final /* synthetic */ SecurityLoadingScene[] $values() {
            return new SecurityLoadingScene[]{SECURITY_LOADING_SCENE_NORMAL, SECURITY_LOADING_SCENE_PAY, SECURITY_LOADING_SCENE_COMBINE, SECURITY_LOADING_SCENE_REUSE, SECURITY_LOADING_SCENE_REUSE_AND_UPDATE};
        }

        public static SecurityLoadingScene valueOf(String r100) {
            return (SecurityLoadingScene) a.a(SecurityLoadingScene.class, r100);
        }

        public static SecurityLoadingScene[] values() {
            return (SecurityLoadingScene[]) $VALUES.clone();
        }

        static {
            SECURITY_LOADING_SCENE_NORMAL = new SecurityLoadingScene("SECURITY_LOADING_SCENE_NORMAL", 0, "普通接口触发场景");
            SECURITY_LOADING_SCENE_PAY = new SecurityLoadingScene("SECURITY_LOADING_SCENE_PAY", 1, "支付接口触发场景");
            SECURITY_LOADING_SCENE_COMBINE = new SecurityLoadingScene("SECURITY_LOADING_SCENE_COMBINE", 2, "合并接口触发场景");
            SECURITY_LOADING_SCENE_REUSE = new SecurityLoadingScene("SECURITY_LOADING_SCENE_REUSE", 3, "文案复用当前显示的文案");
            SECURITY_LOADING_SCENE_REUSE_AND_UPDATE = new SecurityLoadingScene("SECURITY_LOADING_SCENE_REUSE_AND_UPDATE", 4, "复用loading并更新loading数据");
            $VALUES = $values();
        }

        public final String getSceneDes() {
            return this.sceneDes;
        }

        private SecurityLoadingScene(String r100, int r101, String r102) {
            super(r100, r101);
            this.sceneDes = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$UpdateCallBack;", "", "completeGifOnStop", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UpdateCallBack {
        void completeGifOnStop();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean getCopyWritingEnd();

    String getSecurityLoadingInfo();

    Long getSecurityLoadingMinTime(LoadingCustomScene r100);

    String getSecurityLoadingMsg(LoadingCustomScene r100);

    void hideCustomPanelViewLoading();

    void hideDiaLogViewLoading();

    void hideDialogLoading();

    void hideDialogLoadingForInnerInvoke();

    void hideLoading();

    void hidePanelLoading();

    boolean isCustomPanelLoadingViewShowing();

    boolean isDialogLoadingActivityShowing();

    boolean isDialogLoadingShowing();

    boolean isDialogLoadingViewShowing();

    boolean isNeedHideDialogLoading();

    boolean isPanelLoadingShowing();

    boolean isUniform();

    boolean isValidInfoSupportShow();

    boolean notifyPayEnd(UpdateCallBack r100);

    void notifyUpdate(boolean r100);

    void preLoad(Context r100);

    void release();

    void setCopyWritingEnd(boolean r100);

    void setDialogLoadingShowing(boolean r100);

    void setSecurityLoadingInfo(String r100);

    boolean showCustomPanelViewLoading(Context r100, SecurityLoadingScene r101, String r102, String r103, Integer r104, int r105, String r106, boolean r107, boolean r108);

    boolean showDialogLoading(Context r100, SecurityLoadingScene r101, String r102);

    boolean showDialogLoadingForInnerInvoke(Context r100, SecurityLoadingScene r101, String r102, boolean r103, boolean r104, LoadingCustomScene r105, Integer r106, Boolean r107);

    boolean showDialogLoadingForSpecialCopyWriting(Context r100, String r101, String r102, LoadingCustomScene r103, ICJPaySecurityLoadingCallback r104, Integer r105, Boolean r106);

    boolean showLoading(Context r100, String r101, String r102, Boolean r103, Boolean r104);

    boolean showPanelLoading(Context r100, SecurityLoadingScene r101, String r102, ViewGroup r103, int r104, float r105, boolean r106, boolean r107, boolean r108, boolean r110, Boolean r111, String r112);

    boolean showPanelLoadingForCommon(Context r100, SecurityLoadingScene r101, String r102, ViewGroup r103, int r104, boolean r105, boolean r106, Boolean r107);

    boolean showPanelLoadingForSpecial(Context r100, SecurityLoadingScene r101, String r102, ViewGroup r103, ViewGroup.LayoutParams r104, boolean r105, boolean r106, Boolean r107);

    boolean showStdDialogViewLoading(Context r100, SecurityLoadingScene r101, String r102, String r103, boolean r104, boolean r105, LoadingCustomScene r106, Integer r107, Boolean r108);

    void updateDialogViewStatusForReuse(String r100, String r101, int r102);
}
