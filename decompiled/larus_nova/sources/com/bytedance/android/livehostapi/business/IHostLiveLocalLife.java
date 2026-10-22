package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeAnchorView;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeFragmentDelegate;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.texturerender.TextureRenderKeys;
import is2.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016JB\u0010\u001b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016JT\u0010#\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020\nH&J\b\u0010)\u001a\u00020\nH\u0016J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0004H\u0016J.\u0010.\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00022\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fH\u0016J\u001e\u0010/\u001a\u00020\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010$0\u001fH&JS\u00106\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\u00022\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\r2\b\u00105\u001a\u0004\u0018\u000104H&¢\u0006\u0004\b6\u00107J8\u0010;\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00022&\u0010-\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u000109j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`:H&J\u0012\u0010=\u001a\u0004\u0018\u00010<2\u0006\u00108\u001a\u00020\u0002H\u0016J\u0012\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010>H&J\u0012\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010>H&J\u0018\u0010B\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0002H\u0016J\b\u0010C\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010H\u001a\u00020\n2\u0006\u0010F\u001a\u00020E2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\rH\u0016J \u0010K\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0002H\u0016J\u0018\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u000204H\u0016J(\u0010Q\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00022\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010OH\u0016J\u0085\u0001\u0010X\u001a\u0002042\b\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010S\u001a\u0004\u0018\u00010R2g\u0010W\u001ac\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(0\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0012\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\n0TH\u0016J\u0085\u0001\u0010Y\u001a\u0002042\b\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010S\u001a\u0004\u0018\u00010R2g\u0010W\u001ac\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(0\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0012\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\n0TH\u0016J\u008f\u0001\u0010Z\u001a\u00020R2\b\u00100\u001a\u0004\u0018\u00010\u00022\b\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\u0012\u001a\u0004\u0018\u00010R2g\u0010W\u001ac\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(0\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(\u0012\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\n0TH\u0016J2\u0010^\u001a\u0004\u0018\u00010\u00022\u0006\u0010F\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00022\u0016\b\u0002\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001fH\u0016J0\u0010^\u001a\u0004\u0018\u00010\u00022\u0006\u0010`\u001a\u00020_2\u0006\u0010\\\u001a\u00020\u00022\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001fH\u0016J \u0010c\u001a\u00020R2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u0002042\u0006\u0010b\u001a\u00020\rH\u0016J\u0012\u0010d\u001a\u0004\u0018\u00010R2\u0006\u0010`\u001a\u00020_H\u0016J8\u0010e\u001a\u00020\r2\u0006\u0010`\u001a\u00020_2\u0006\u00101\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$\u0018\u00010\u001fH\u0016J$\u0010f\u001a\u00020\n2\u0006\u0010`\u001a\u00020_2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u001fH\u0016J\b\u0010g\u001a\u00020\rH\u0016JH\u0010m\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u00022\u0006\u0010i\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u00022\u0006\u0010k\u001a\u00020\u00022\u0006\u0010l\u001a\u00020\u0002H\u0016J\"\u0010o\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010n\u001a\u0004\u0018\u00010\u0002H\u0016J4\u0010s\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010p\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\u00022\b\u0010q\u001a\u0004\u0018\u00010\u00022\b\u0010r\u001a\u0004\u0018\u00010$H\u0016J\b\u0010t\u001a\u00020\rH\u0016J\b\u0010u\u001a\u00020\rH\u0016J\u0012\u0010v\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010w\u001a\u00020\rH&R\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020x0>8&X¦\u0004¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006|À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostLiveLocalLife;", "Lcom/bytedance/android/live/base/IService;", "", "requestFrom", "", "roomId", "Lcom/bytedance/android/livehostapi/business/depend/livead/IGroupPurchaseItemCallback;", "callback", "uniqueKey", ControlRule.KEY_EXTRA_DATA, "", "getLifeComponentInfo", "url", "", "isAutoOpenDetail", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeFragmentDelegate;", "getLiveGoodsDetailDialogFragment", "Landroid/os/Bundle;", "params", "Landroidx/fragment/app/DialogFragment;", "getLiveGoodsShelvesDialogFragment", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "lynxUrl", NativeDownloadModel.JsonKey.WEB_URL, "grouponId", "mpId", "openMiniApp", "groupPurchaseCardInfoJson", "groupPurchaseExtraJson", "eventFrom", "", "lifeExtraInfoMap", "clickFrom", "sourceBtmToken", "jumpByPreviewCardInfo", "", "liveEnterRoomBridge", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ILiveLocalLifeAnchorView;", "getGroupPurchaseAnchorView", "initRoomController", "callInjectMessage", "triggerTime", "startIconAnimation", "event", "map", "sendLog", "openLiveLifeGrouponPage", "eventName", "btm", "enter_new_page", "add_btm_chain", "", "chain_length", "sendPoiLog", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "sessionId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateSessionInfo", "Lorg/json/JSONObject;", "fetchSessionInfo", "", "getInvalidCouponInfo", "getFullCouponInfo", "scheme", "openUrlByBullet", "isLifeCart", "setLifeCartShown", "Landroidx/fragment/app/FragmentActivity;", "activity", "isPreview", "setLiveActivity", TextureRenderKeys.KEY_MODULE_NAME, "actionParams", "setEnterModuleName", "enterFrom", "count", "notifyWatchedRoomCount", "", "eventParams", "log", "Lcom/google/gson/JsonObject;", "extra", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "jsEventDelegate", "registerLiveLifeMsgCenter", "unRegisterLiveLifeMsgCenter", "postMsg", "Landroid/app/Activity;", "sourceBtm", "bcm", "createBtmSourceToken", "Landroid/view/View;", "view", "chainLength", "isDomainStandard", "getBcmChain", "getPageBtmInfo", "registerBtmPage", "setBcmParams", "getLiveLifeIconButtonOptEnable", "anchorId", "enterFromMerge", "enterMethod", ReportConstant.COMMON_ACTION_TYPE, "enterLocalLifeParams", "doExtremeShelfPreload", "goodsShelvesBtmToken", "handleEnterAction", "type", "title", "content", "addDebugData", "isLiveLifeMemoryLeakExperimentHit", "shouldResetEnterFromMerge", "getExpoundCardId", "useAppendExpoundCardIdInjector", "Lis2/b;", "getRoomBackendHandlers", "()Ljava/util/List;", "roomBackendHandlers", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostLiveLocalLife extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostLiveLocalLife$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addDebugData(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Object r105) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r103, "name");
        }

        public static void $default$callInjectMessage(IHostLiveLocalLife r100) {
        }

        public static String $default$createBtmSourceToken(IHostLiveLocalLife r100, Activity r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "sourceBtm");
            return null;
        }

        public static String $default$createBtmSourceToken(IHostLiveLocalLife r100, View r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "sourceBtm");
            return null;
        }

        public static void $default$doExtremeShelfPreload(IHostLiveLocalLife r100, String r101, FragmentActivity r102, long r103, String r104, String r105, String r106, String r107, String r108) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "activity");
            Intrinsics.checkNotNullParameter(r104, "anchorId");
            Intrinsics.checkNotNullParameter(r105, "enterFromMerge");
            Intrinsics.checkNotNullParameter(r106, "enterMethod");
            Intrinsics.checkNotNullParameter(r107, ReportConstant.COMMON_ACTION_TYPE);
            Intrinsics.checkNotNullParameter(r108, "enterLocalLifeParams");
        }

        public static JSONObject $default$fetchSessionInfo(IHostLiveLocalLife r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            return null;
        }

        public static ILiveLocalLifeAnchorView $default$getGroupPurchaseAnchorView(IHostLiveLocalLife r100, Context r101, Bundle r102, String r103, Object r104) {
            Intrinsics.checkNotNullParameter(r103, "uniqueKey");
            return null;
        }

        public static void $default$getLifeComponentInfo(IHostLiveLocalLife r100, String r101, long r102, IGroupPurchaseItemCallback r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r104, "uniqueKey");
            Intrinsics.checkNotNullParameter(r105, ControlRule.KEY_EXTRA_DATA);
        }

        public static ILiveLocalLifeFragmentDelegate $default$getLiveGoodsDetailDialogFragment(IHostLiveLocalLife r100, String r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r103, "uniqueKey");
            return null;
        }

        public static DialogFragment $default$getLiveGoodsShelvesDialogFragment(IHostLiveLocalLife r100, String r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            return null;
        }

        public static boolean $default$getLiveLifeIconButtonOptEnable(IHostLiveLocalLife r100) {
            return true;
        }

        public static boolean $default$handleEnterAction(IHostLiveLocalLife r100, String r101, Context r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return false;
        }

        public static boolean $default$isLifeCart(IHostLiveLocalLife r100) {
            return false;
        }

        public static boolean $default$isLiveLifeMemoryLeakExperimentHit(IHostLiveLocalLife r100) {
            return false;
        }

        public static void $default$jumpByPreviewCardInfo(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Map r105, String r106, String r107) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r104, "eventFrom");
            Intrinsics.checkNotNullParameter(r106, "clickFrom");
        }

        public static void $default$log(IHostLiveLocalLife r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r101, "eventName");
        }

        public static void $default$notifyWatchedRoomCount(IHostLiveLocalLife r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "enterFrom");
        }

        public static void $default$openMiniApp(IHostLiveLocalLife r100, String r101, Context r102, String r103, String r104, String r105, String r106) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        }

        public static void $default$openUrlByBullet(IHostLiveLocalLife r100, Context r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "scheme");
        }

        public static boolean $default$registerBtmPage(IHostLiveLocalLife r100, View r101, String r102, String r103, Map r104) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "btm");
            return false;
        }

        public static int $default$registerLiveLifeMsgCenter(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3 r103) {
            Intrinsics.checkNotNullParameter(r103, "jsEventDelegate");
            return 0;
        }

        public static void $default$sendLog(IHostLiveLocalLife r100, String r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "event");
        }

        public static void $default$setBcmParams(IHostLiveLocalLife r100, View r101, Map r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "bcm");
        }

        public static void $default$setEnterModuleName(IHostLiveLocalLife r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_MODULE_NAME);
            Intrinsics.checkNotNullParameter(r103, "actionParams");
        }

        public static void $default$setLifeCartShown(IHostLiveLocalLife r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        }

        public static void $default$setLiveActivity(IHostLiveLocalLife r100, FragmentActivity r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        }

        public static boolean $default$shouldResetEnterFromMerge(IHostLiveLocalLife r100) {
            return false;
        }

        public static boolean $default$startIconAnimation(IHostLiveLocalLife r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            return false;
        }

        public static int $default$unRegisterLiveLifeMsgCenter(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3 r103) {
            Intrinsics.checkNotNullParameter(r103, "jsEventDelegate");
            return 0;
        }

        public static /* synthetic */ void access$callInjectMessage$jd(IHostLiveLocalLife r100) {
            $default$callInjectMessage(r100);
        }

        public static /* synthetic */ boolean access$getLiveLifeIconButtonOptEnable$jd(IHostLiveLocalLife r100) {
            return $default$getLiveLifeIconButtonOptEnable(r100);
        }

        public static /* synthetic */ boolean access$isLifeCart$jd(IHostLiveLocalLife r100) {
            return $default$isLifeCart(r100);
        }

        public static /* synthetic */ boolean access$isLiveLifeMemoryLeakExperimentHit$jd(IHostLiveLocalLife r100) {
            return $default$isLiveLifeMemoryLeakExperimentHit(r100);
        }

        public static /* synthetic */ boolean access$shouldResetEnterFromMerge$jd(IHostLiveLocalLife r100) {
            return $default$shouldResetEnterFromMerge(r100);
        }

        public static JsonObject $default$getPageBtmInfo(IHostLiveLocalLife r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            return new JsonObject();
        }

        public static /* synthetic */ JSONObject access$fetchSessionInfo$jd(IHostLiveLocalLife r100, String r101) {
            return $default$fetchSessionInfo(r100, r101);
        }

        public static /* synthetic */ JsonObject access$getPageBtmInfo$jd(IHostLiveLocalLife r100, View r101) {
            return $default$getPageBtmInfo(r100, r101);
        }

        public static /* synthetic */ void access$setLifeCartShown$jd(IHostLiveLocalLife r100, String r101) {
            $default$setLifeCartShown(r100, r101);
        }

        public static /* synthetic */ DialogFragment access$getLiveGoodsShelvesDialogFragment$jd(IHostLiveLocalLife r100, String r101, Bundle r102) {
            return $default$getLiveGoodsShelvesDialogFragment(r100, r101, r102);
        }

        public static /* synthetic */ void access$log$jd(IHostLiveLocalLife r100, String r101, Map r102) {
            $default$log(r100, r101, r102);
        }

        public static /* synthetic */ void access$notifyWatchedRoomCount$jd(IHostLiveLocalLife r100, String r101, int r102) {
            $default$notifyWatchedRoomCount(r100, r101, r102);
        }

        public static /* synthetic */ void access$openUrlByBullet$jd(IHostLiveLocalLife r100, Context r101, String r102) {
            $default$openUrlByBullet(r100, r101, r102);
        }

        public static /* synthetic */ void access$setBcmParams$jd(IHostLiveLocalLife r100, View r101, Map r102) {
            $default$setBcmParams(r100, r101, r102);
        }

        public static /* synthetic */ boolean access$startIconAnimation$jd(IHostLiveLocalLife r100, String r101, long r102) {
            return $default$startIconAnimation(r100, r101, r102);
        }

        public static JsonObject $default$getBcmChain(IHostLiveLocalLife r100, View r101, int r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "view");
            return new JsonObject();
        }

        public static /* synthetic */ String access$createBtmSourceToken$jd(IHostLiveLocalLife r100, Activity r101, String r102, Map r103) {
            return $default$createBtmSourceToken(r100, r101, r102, r103);
        }

        public static /* synthetic */ JsonObject access$getBcmChain$jd(IHostLiveLocalLife r100, View r101, int r102, boolean r103) {
            return $default$getBcmChain(r100, r101, r102, r103);
        }

        public static /* synthetic */ ILiveLocalLifeFragmentDelegate access$getLiveGoodsDetailDialogFragment$jd(IHostLiveLocalLife r100, String r101, boolean r102, String r103) {
            return $default$getLiveGoodsDetailDialogFragment(r100, r101, r102, r103);
        }

        public static /* synthetic */ boolean access$handleEnterAction$jd(IHostLiveLocalLife r100, String r101, Context r102, String r103) {
            return $default$handleEnterAction(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$registerLiveLifeMsgCenter$jd(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3 r103) {
            return $default$registerLiveLifeMsgCenter(r100, r101, r102, r103);
        }

        public static /* synthetic */ void access$sendLog$jd(IHostLiveLocalLife r100, String r101, String r102, Map r103) {
            $default$sendLog(r100, r101, r102, r103);
        }

        public static /* synthetic */ void access$setEnterModuleName$jd(IHostLiveLocalLife r100, String r101, String r102, String r103) {
            $default$setEnterModuleName(r100, r101, r102, r103);
        }

        public static /* synthetic */ void access$setLiveActivity$jd(IHostLiveLocalLife r100, FragmentActivity r101, String r102, boolean r103) {
            $default$setLiveActivity(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$unRegisterLiveLifeMsgCenter$jd(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3 r103) {
            return $default$unRegisterLiveLifeMsgCenter(r100, r101, r102, r103);
        }

        public static /* synthetic */ String access$createBtmSourceToken$jd(IHostLiveLocalLife r100, View r101, String r102, Map r103) {
            return $default$createBtmSourceToken(r100, r101, r102, r103);
        }

        public static JsonObject $default$postMsg(IHostLiveLocalLife r100, String r101, JsonObject r102, JsonObject r103, Function3 r104) {
            Intrinsics.checkNotNullParameter(r104, "jsEventDelegate");
            return new JsonObject();
        }

        public static /* synthetic */ ILiveLocalLifeAnchorView access$getGroupPurchaseAnchorView$jd(IHostLiveLocalLife r100, Context r101, Bundle r102, String r103, Object r104) {
            return $default$getGroupPurchaseAnchorView(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ JsonObject access$postMsg$jd(IHostLiveLocalLife r100, String r101, JsonObject r102, JsonObject r103, Function3 r104) {
            return $default$postMsg(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ boolean access$registerBtmPage$jd(IHostLiveLocalLife r100, View r101, String r102, String r103, Map r104) {
            return $default$registerBtmPage(r100, r101, r102, r103, r104);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void log$default(IHostLiveLocalLife r100, String r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.log(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }

        public static /* synthetic */ void access$addDebugData$jd(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Object r105) {
            $default$addDebugData(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ void access$getLifeComponentInfo$jd(IHostLiveLocalLife r100, String r101, long r102, IGroupPurchaseItemCallback r103, String r104, String r105) {
            $default$getLifeComponentInfo(r100, r101, r102, r103, r104, r105);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String createBtmSourceToken$default(IHostLiveLocalLife r100, Activity r101, String r102, Map r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.createBtmSourceToken(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBtmSourceToken");
        }

        public static /* synthetic */ void access$openMiniApp$jd(IHostLiveLocalLife r100, String r101, Context r102, String r103, String r104, String r105, String r106) {
            $default$openMiniApp(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ void access$jumpByPreviewCardInfo$jd(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Map r105, String r106, String r107) {
            $default$jumpByPreviewCardInfo(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        public static /* synthetic */ void access$doExtremeShelfPreload$jd(IHostLiveLocalLife r100, String r101, FragmentActivity r102, long r103, String r104, String r105, String r106, String r107, String r108) {
            $default$doExtremeShelfPreload(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void callInjectMessage(IHostLiveLocalLife r100) {
            CC.access$callInjectMessage$jd(r100);
        }

        public static boolean getLiveLifeIconButtonOptEnable(IHostLiveLocalLife r100) {
            return CC.access$getLiveLifeIconButtonOptEnable$jd(r100);
        }

        public static boolean isLifeCart(IHostLiveLocalLife r100) {
            return CC.access$isLifeCart$jd(r100);
        }

        public static boolean isLiveLifeMemoryLeakExperimentHit(IHostLiveLocalLife r100) {
            return CC.access$isLiveLifeMemoryLeakExperimentHit$jd(r100);
        }

        public static boolean shouldResetEnterFromMerge(IHostLiveLocalLife r100) {
            return CC.access$shouldResetEnterFromMerge$jd(r100);
        }

        public static JSONObject fetchSessionInfo(IHostLiveLocalLife r100, String r101) {
            return CC.access$fetchSessionInfo$jd(r100, r101);
        }

        public static JsonObject getPageBtmInfo(IHostLiveLocalLife r100, View r101) {
            return CC.access$getPageBtmInfo$jd(r100, r101);
        }

        public static void setLifeCartShown(IHostLiveLocalLife r100, String r101) {
            CC.access$setLifeCartShown$jd(r100, r101);
        }

        public static DialogFragment getLiveGoodsShelvesDialogFragment(IHostLiveLocalLife r100, String r101, Bundle r102) {
            return CC.access$getLiveGoodsShelvesDialogFragment$jd(r100, r101, r102);
        }

        public static void log(IHostLiveLocalLife r100, String r101, Map<String, String> r102) {
            CC.access$log$jd(r100, r101, r102);
        }

        public static void notifyWatchedRoomCount(IHostLiveLocalLife r100, String r101, int r102) {
            CC.access$notifyWatchedRoomCount$jd(r100, r101, r102);
        }

        public static void openUrlByBullet(IHostLiveLocalLife r100, Context r101, String r102) {
            CC.access$openUrlByBullet$jd(r100, r101, r102);
        }

        public static void setBcmParams(IHostLiveLocalLife r100, View r101, Map<String, ? extends Object> r102) {
            CC.access$setBcmParams$jd(r100, r101, r102);
        }

        public static boolean startIconAnimation(IHostLiveLocalLife r100, String r101, long r102) {
            return CC.access$startIconAnimation$jd(r100, r101, r102);
        }

        public static String createBtmSourceToken(IHostLiveLocalLife r100, Activity r101, String r102, Map<String, ? extends Object> r103) {
            return CC.access$createBtmSourceToken$jd(r100, r101, r102, r103);
        }

        public static JsonObject getBcmChain(IHostLiveLocalLife r100, View r101, int r102, boolean r103) {
            return CC.access$getBcmChain$jd(r100, r101, r102, r103);
        }

        public static ILiveLocalLifeFragmentDelegate getLiveGoodsDetailDialogFragment(IHostLiveLocalLife r100, String r101, boolean r102, String r103) {
            return CC.access$getLiveGoodsDetailDialogFragment$jd(r100, r101, r102, r103);
        }

        public static boolean handleEnterAction(IHostLiveLocalLife r100, String r101, Context r102, String r103) {
            return CC.access$handleEnterAction$jd(r100, r101, r102, r103);
        }

        public static int registerLiveLifeMsgCenter(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r103) {
            return CC.access$registerLiveLifeMsgCenter$jd(r100, r101, r102, r103);
        }

        public static void sendLog(IHostLiveLocalLife r100, String r101, String r102, Map<String, String> r103) {
            CC.access$sendLog$jd(r100, r101, r102, r103);
        }

        public static void setEnterModuleName(IHostLiveLocalLife r100, String r101, String r102, String r103) {
            CC.access$setEnterModuleName$jd(r100, r101, r102, r103);
        }

        public static void setLiveActivity(IHostLiveLocalLife r100, FragmentActivity r101, String r102, boolean r103) {
            CC.access$setLiveActivity$jd(r100, r101, r102, r103);
        }

        public static int unRegisterLiveLifeMsgCenter(IHostLiveLocalLife r100, String r101, JsonObject r102, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r103) {
            return CC.access$unRegisterLiveLifeMsgCenter$jd(r100, r101, r102, r103);
        }

        public static String createBtmSourceToken(IHostLiveLocalLife r100, View r101, String r102, Map<String, ? extends Object> r103) {
            return CC.access$createBtmSourceToken$jd(r100, r101, r102, r103);
        }

        public static ILiveLocalLifeAnchorView getGroupPurchaseAnchorView(IHostLiveLocalLife r100, Context r101, Bundle r102, String r103, Object r104) {
            return CC.access$getGroupPurchaseAnchorView$jd(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ void log$default(IHostLiveLocalLife r100, String r101, Map r102, int r103, Object r104) {
            CC.log$default(r100, r101, r102, r103, r104);
        }

        public static JsonObject postMsg(IHostLiveLocalLife r100, String r101, JsonObject r102, JsonObject r103, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r104) {
            return CC.access$postMsg$jd(r100, r101, r102, r103, r104);
        }

        public static boolean registerBtmPage(IHostLiveLocalLife r100, View r101, String r102, String r103, Map<String, ? extends Object> r104) {
            return CC.access$registerBtmPage$jd(r100, r101, r102, r103, r104);
        }

        public static void addDebugData(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Object r105) {
            CC.access$addDebugData$jd(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ String createBtmSourceToken$default(IHostLiveLocalLife r100, Activity r101, String r102, Map r103, int r104, Object r105) {
            return CC.createBtmSourceToken$default(r100, r101, r102, r103, r104, r105);
        }

        public static void getLifeComponentInfo(IHostLiveLocalLife r100, String r101, long r102, IGroupPurchaseItemCallback r103, String r104, String r105) {
            CC.access$getLifeComponentInfo$jd(r100, r101, r102, r103, r104, r105);
        }

        public static void openMiniApp(IHostLiveLocalLife r100, String r101, Context r102, String r103, String r104, String r105, String r106) {
            CC.access$openMiniApp$jd(r100, r101, r102, r103, r104, r105, r106);
        }

        public static void jumpByPreviewCardInfo(IHostLiveLocalLife r100, String r101, String r102, String r103, String r104, Map<String, String> r105, String r106, String r107) {
            CC.access$jumpByPreviewCardInfo$jd(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        public static void doExtremeShelfPreload(IHostLiveLocalLife r100, String r101, FragmentActivity r102, long r103, String r104, String r105, String r106, String r107, String r108) {
            CC.access$doExtremeShelfPreload$jd(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }
    }

    void addDebugData(String r100, String r101, String r102, String r103, Object r104);

    void callInjectMessage();

    String createBtmSourceToken(Activity r100, String r101, Map<String, ? extends Object> r102);

    String createBtmSourceToken(View r100, String r101, Map<String, ? extends Object> r102);

    void doExtremeShelfPreload(String r100, FragmentActivity r101, long r102, String r103, String r104, String r105, String r106, String r107);

    JSONObject fetchSessionInfo(String r100);

    JsonObject getBcmChain(View r100, int r101, boolean r102);

    String getExpoundCardId(long r100);

    List<Object> getFullCouponInfo();

    ILiveLocalLifeAnchorView getGroupPurchaseAnchorView(Context r100, Bundle r101, String r102, Object r103);

    List<Object> getInvalidCouponInfo();

    void getLifeComponentInfo(String r100, long r101, IGroupPurchaseItemCallback r102, String r103, String r104);

    ILiveLocalLifeFragmentDelegate getLiveGoodsDetailDialogFragment(String r100, boolean r101, String r102);

    DialogFragment getLiveGoodsShelvesDialogFragment(String r100, Bundle r101);

    boolean getLiveLifeIconButtonOptEnable();

    JsonObject getPageBtmInfo(View r100);

    List<b> getRoomBackendHandlers();

    boolean handleEnterAction(String r100, Context r101, String r102);

    void initRoomController();

    boolean isLifeCart();

    boolean isLiveLifeMemoryLeakExperimentHit();

    void jumpByPreviewCardInfo(String r100, String r101, String r102, String r103, Map<String, String> r104, String r105, String r106);

    void log(String r100, Map<String, String> r101);

    void notifyWatchedRoomCount(String r100, int r101);

    void openLiveLifeGrouponPage(Map<String, ? extends Object> r100);

    void openMiniApp(String r100, Context r101, String r102, String r103, String r104, String r105);

    void openUrlByBullet(Context r100, String r101);

    JsonObject postMsg(String r100, JsonObject r101, JsonObject r102, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r103);

    boolean registerBtmPage(View r100, String r101, String r102, Map<String, ? extends Object> r103);

    int registerLiveLifeMsgCenter(String r100, JsonObject r101, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r102);

    void sendLog(String r100, String r101, Map<String, String> r102);

    void sendPoiLog(String r100, Map<String, String> r101, String r102, Boolean r103, Boolean r104, Integer r105);

    void setBcmParams(View r100, Map<String, ? extends Object> r101);

    void setEnterModuleName(String r100, String r101, String r102);

    void setLifeCartShown(String r100);

    void setLiveActivity(FragmentActivity r100, String r101, boolean r102);

    boolean shouldResetEnterFromMerge();

    boolean startIconAnimation(String r100, long r101);

    int unRegisterLiveLifeMsgCenter(String r100, JsonObject r101, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r102);

    boolean updateSessionInfo(String r100, HashMap<String, String> r101);

    boolean useAppendExpoundCardIdInjector();
}
