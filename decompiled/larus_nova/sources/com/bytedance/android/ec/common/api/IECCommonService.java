package com.bytedance.android.ec.common.api;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import cf.p;
import cf.t;
import cf.u;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ec.model.e;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.livesdk.livecommerce.iron.helper.d;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mf.b;
import ul.i;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0094\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H&Jj\u00100\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020 2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&J\u009a\u0003\u0010X\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\u0006\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\u0006\u0010=\u001a\u00020<2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010@\u001a\u00020<2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010C\u001a\u00020<2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010E\u001a\u00020<2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010H\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010J\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N2\u0018\b\u0002\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010P2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00112%\b\u0002\u0010W\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016H&¢\u0006\u0004\bX\u0010YJ}\u0010g\u001a\u00020\u00142\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020\u00042\b\u0010^\u001a\u0004\u0018\u00010 2\b\u0010_\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&¢\u0006\u0004\bg\u0010hJ\u0087\u0001\u0010g\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\b\b\u0001\u0010j\u001a\u00020i2\b\b\u0001\u0010k\u001a\u00020i2\u0006\u0010]\u001a\u00020\u00042\b\u0010`\u001a\u0004\u0018\u00010Z2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010<2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010H&¢\u0006\u0004\bg\u0010lJ\u0016\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010PH&J,\u0010s\u001a\u0004\u0018\u00010r2\u000e\u0010p\u001a\n\u0012\u0006\b\u0001\u0012\u00020o0n2\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010\u0010H&J2\u0010w\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010t\u001a\u00020\u00112\u0006\u0010u\u001a\u00020\u00042\b\u0010v\u001a\u0004\u0018\u00010\u0011H&J2\u0010~\u001a\u00020\u00142\u0006\u0010x\u001a\u00020\u00112\u0006\u0010z\u001a\u00020y2\u0006\u0010{\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u00112\b\b\u0002\u0010}\u001a\u00020<H&J!\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\b\u0010\u007f\u001a\u0004\u0018\u00010\u00112\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0011H&J\u001d\u0010\u0087\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00112\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H&J\u001e\u0010\u0087\u0001\u001a\u00030\u0086\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H&¨\u0006\u008a\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/api/IECCommonService;", "", "Lcom/bytedance/android/ec/model/response/ECPromotionCampaign;", "campaign", "", "serverTime", "Lcom/bytedance/android/ec/model/promotion/ECUICampaign;", "convertCampaign", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/ec/model/sku/SkuParams;", "skuParams", "Lcf/t;", "skuLiveService", "Lcom/bytedance/android/btm/api/model/l;", "btmModel", "Lkotlin/Function0;", "", "promotionListEntranceInfo", "Lkotlin/Function2;", "", "adLogCallBack", "Lkotlin/Function1;", "finishPlaybackPageListener", "Lcom/bytedance/android/ec/model/sku/SkuShowAndDismissState;", "showAndDismissListener", "Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "refreshDetailInfoCallback", "Lcom/bytedance/android/ec/model/sku/SkuCartResult;", "cartListener", "Lcom/bytedance/android/ec/model/sku/SkuCheckResult;", "skuCheckResultCallback", "", "ultimateBuyType", "Lul/i;", "skuSchema", "addCartSuccessListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcf/u;", "showSkuPanel", "Lcom/bytedance/android/ec/model/promotion/ECResultDialogContentVO;", "content", "type", "showDialogCallback", "dismissDialogCallback", "cancelBtnCallback", "confirmBtnCallback", "showResultDialog", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "addToastType", "originType", "originId", "promotionId", "productId", "authorId", "secAuthorId", "roomId", "shopId", "trackExtra", "", "isGroupBuying", "receiveAddressId", "marketChannel", "needShowAddCartMotion", "addCartEntranceInfo", "comboId", "isHourArrivedRoom", "btmPageId", "useNewAddApi", "skuSessionId", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "authorOpenId", "comboNum", "bizCampaignType", "Lcom/bytedance/android/ec/model/e;", "extraParams", "Lcf/a;", "customAddCartListener", "", "trackMeta", "foodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "Lkotlin/ParameterName;", "name", "count", "addCartListener", "addCartDirectly", "(Landroid/content/Context;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/btm/api/model/l;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/e;Lcf/a;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/View;", "sourceView", "destinationView", "delay", "windowsPriority", "isDeleteStatusHeight", "animLayout", "", "animLayoutWidth", "animLayoutHeight", "Landroid/animation/AnimatorSet;", "customAnimator", "callback", "addCartMotion", "(Landroid/view/View;Landroid/view/View;JLjava/lang/Integer;Ljava/lang/Boolean;Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Landroid/animation/AnimatorSet;Lkotlin/jvm/functions/Function0;)V", "", "sourceLocation", "destinationLocation", "(Landroid/content/Context;[F[FJLandroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Landroid/animation/AnimatorSet;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "getExplainReplayCommonParams", "Ljava/lang/Class;", "Lmf/b;", "clazz", "newInstance", "Lmf/a;", "getOpenOrderSchemaHelper", "selectSkuId", "buyNum", "sourceBtmToken", "buyNowDirectly", "orderUrl", "Landroid/app/Activity;", "activity", "packLogId", "skuLogId", "isInSplit", "openBuyNowSchemaWidthRouterHelper", "listenerId", "listenerExtra", "Lcf/p;", "createPageStateListenerHelper", "url", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "entranceInfoScene", "Lcom/bytedance/android/ec/model/order/IOrderSchema;", "convertToOrderSchema", "Landroid/net/Uri;", "uri", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECCommonService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IECCommonService r110, View r111, View r112, Integer r113, Boolean r114, Function0 r115, int r116) {
            if ((r116 & 512) == 0) goto L5;
            Function0 r117 = null;
        L6:
            r110.addCartMotion(r111, r112, 50, r113, r114, null, null, null, null, r117);
            return;
        L5:
            r117 = r115;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(IECCommonService r100, Context r101, ECResultDialogContentVO r110, Function0 r111, Function0 r112, Function0 r113, int r114) {
            if ((r114 & 8) == 0) goto L5;
            Function0 r102 = null;
        L7:
            if ((r114 & 32) == 0) goto L9;
            Function0 r103 = null;
        L11:
            if ((r114 & 64) == 0) goto L13;
            Function0 r104 = null;
        L14:
            r100.showResultDialog(r101, r110, 0, r102, null, r103, r104);
            return;
        L13:
            r104 = r113;
            goto L14
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ u d(IECCommonService r110, FragmentManager r210, SkuParams r211, d r212, l r213, Function0 r214, Function2 r215, Function1 r216, Function1 r217, Function1 r218, Function1 r219, Function1 r310, int r311, SkuSchemaParams r312, Function0 r313, Context r314, int r315) {
            if ((r315 & 4) == 0) goto L5;
            d r100 = null;
        L7:
            if ((r315 & 8) == 0) goto L9;
            l r101 = null;
        L11:
            if ((r315 & 16) == 0) goto L13;
            Function0 r102 = null;
        L15:
            if ((r315 & 32) == 0) goto L17;
            Function2 r103 = null;
        L19:
            if ((r315 & 64) == 0) goto L21;
            Function1 r111 = null;
        L23:
            if ((r315 & 256) == 0) goto L25;
            Function1 r112 = null;
        L27:
            if ((r315 & 512) == 0) goto L29;
            Function1 r113 = null;
        L31:
            if ((r315 & 1024) == 0) goto L33;
            Function1 r114 = null;
        L35:
            if ((r315 & 2048) == 0) goto L37;
            int r115 = 0;
        L39:
            if ((r315 & 4096) == 0) goto L41;
            SkuSchemaParams r116 = null;
        L43:
            if ((r315 & 8192) == 0) goto L45;
            Function0 r117 = null;
        L47:
            if ((r315 & 16384) == 0) goto L49;
            Context r118 = null;
        L51:
            return r110.showSkuPanel(r210, r211, r100, r101, r102, r103, r111, r217, r112, r113, r114, r115, r116, r117, r118);
        L49:
            r118 = r314;
            goto L51
        L45:
            r117 = r313;
            goto L47
        L41:
            r116 = r312;
            goto L43
        L37:
            r115 = r311;
            goto L39
        L33:
            r114 = r310;
            goto L35
        L29:
            r113 = r219;
            goto L31
        L25:
            r112 = r218;
            goto L27
        L21:
            r111 = r216;
            goto L23
        L17:
            r103 = r215;
            goto L19
        L13:
            r102 = r214;
            goto L15
        L9:
            r101 = r213;
            goto L11
        L5:
            r100 = r212;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IECCommonService r310, Context r311, int r410, int r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, boolean r511, String r512, String r513, boolean r514, String r515, String r516, l r517, boolean r518, String r519, String r610, Integer r611, String r612, String r613, e r614, cf.a r615, Map r616, String r617, String r618, Function1 r619, int r710, int r711) {
            if ((r710 & 4) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r710 & 8192) == 0) goto L9;
            String r110 = null;
        L11:
            if ((r710 & 16384) == 0) goto L13;
            String r111 = null;
        L15:
            if ((32768 & r710) == 0) goto L17;
            boolean r112 = false;
        L19:
            if ((131072 & r710) == 0) goto L21;
            String r210 = null;
        L23:
            if ((524288 & r710) == 0) goto L25;
            String r211 = null;
        L27:
            if ((1048576 & r710) == 0) goto L29;
            l r212 = null;
        L31:
            if ((2097152 & r710) == 0) goto L33;
            boolean r213 = false;
        L35:
            if ((4194304 & r710) == 0) goto L37;
            String r214 = null;
        L39:
            if ((8388608 & r710) == 0) goto L41;
            String r215 = null;
        L43:
            if ((16777216 & r710) == 0) goto L45;
            Integer r216 = 0;
        L47:
            if ((33554432 & r710) == 0) goto L49;
            String r217 = null;
        L51:
            if ((134217728 & r710) == 0) goto L53;
            String r312 = null;
        L55:
            if ((268435456 & r710) == 0) goto L57;
            e r313 = null;
        L59:
            if ((536870912 & r710) == 0) goto L61;
            cf.a r314 = null;
        L63:
            if ((1073741824 & r710) == 0) goto L65;
            Map r315 = null;
        L67:
            if ((r710 & Integer.MIN_VALUE) == 0) goto L69;
            String r316 = null;
        L71:
            if ((r711 & 1) == 0) goto L73;
            String r317 = null;
        L75:
            if ((r711 & 2) == 0) goto L77;
            Function1 r318 = null;
        L78:
            r310.addCartDirectly(r311, r410, r100, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r110, r111, r112, null, r210, false, r211, r212, r213, r214, r215, r216, r217, null, r312, r313, r314, r315, r316, r317, r318);
            return;
        L77:
            r318 = r619;
            goto L78
        L73:
            r317 = r618;
            goto L75
        L69:
            r316 = r617;
            goto L71
        L65:
            r315 = r616;
            goto L67
        L61:
            r314 = r615;
            goto L63
        L57:
            r313 = r614;
            goto L59
        L53:
            r312 = r613;
            goto L55
        L49:
            r217 = r612;
            goto L51
        L45:
            r216 = r611;
            goto L47
        L41:
            r215 = r610;
            goto L43
        L37:
            r214 = r519;
            goto L39
        L33:
            r213 = r518;
            goto L35
        L29:
            r212 = r517;
            goto L31
        L25:
            r211 = r516;
            goto L27
        L21:
            r210 = r515;
            goto L23
        L17:
            r112 = r514;
            goto L19
        L13:
            r111 = r513;
            goto L15
        L9:
            r110 = r512;
            goto L11
        L5:
            r100 = r411;
            goto L7
        }
    }

    void addCartDirectly(Context r100, int r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, boolean r113, String r114, String r115, boolean r116, String r117, String r118, boolean r119, String r210, l r211, boolean r212, String r213, String r214, Integer r215, String r216, Integer r217, String r218, e r219, cf.a r310, Map<String, ? extends Object> r311, String r312, String r313, Function1<? super Integer, Unit> r314);

    void addCartMotion(Context r100, float[] r101, float[] r102, long r103, View r104, Float r105, Float r106, Integer r107, AnimatorSet r110, Boolean r111, Function0<Unit> r112);

    void addCartMotion(View r100, View r101, long r102, Integer r103, Boolean r104, View r105, Float r106, Float r107, AnimatorSet r110, Function0<Unit> r111);

    void buyNowDirectly(Context r100, SkuParams r101, String r102, long r103, String r104);

    ECUICampaign convertCampaign(ECPromotionCampaign r100, long r101);

    IOrderSchema convertToOrderSchema(Uri r100, EntranceInfoScene r101);

    IOrderSchema convertToOrderSchema(String r100, EntranceInfoScene r101);

    p createPageStateListenerHelper(String r100, String r101);

    Map<String, String> getExplainReplayCommonParams();

    mf.a getOpenOrderSchemaHelper(Class<? extends b> r100, Function0<? extends b> r101);

    void openBuyNowSchemaWidthRouterHelper(String r100, Activity r101, String r102, String r103, boolean r104);

    void showResultDialog(Context r100, ECResultDialogContentVO r101, int r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Unit> r106);

    u showSkuPanel(FragmentManager r100, SkuParams r101, t r102, l r103, Function0<String> r104, Function2<? super SkuParams, ? super Long, Unit> r105, Function1<? super String, Unit> r106, Function1<? super SkuShowAndDismissState, Unit> r107, Function1<? super SkuProductDetailInfo, Unit> r108, Function1<? super SkuCartResult, Unit> r110, Function1<? super SkuCheckResult, Unit> r111, int r112, i r113, Function0<Unit> r114, Context r115);
}
