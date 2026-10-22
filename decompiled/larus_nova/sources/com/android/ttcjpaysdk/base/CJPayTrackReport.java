package com.android.ttcjpaysdk.base;

import android.util.Log;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySettingService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00172*\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u000fJ&\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fJ`\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2,\b\u0002\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0017H\u0002J\u001c\u0010\u001c\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fJJ\u0010\u001c\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2,\b\u0002\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\u000fJ\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010 \u001a\u00020\u0017R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007RJ\u0010\n\u001a>\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u000bj$\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0010`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport;", "", "()V", "pendingReportQueue", "Ljava/util/concurrent/LinkedBlockingDeque;", "Lcom/android/ttcjpaysdk/base/CJPayTrackReport$TrackerReportData;", "getPendingReportQueue", "()Ljava/util/concurrent/LinkedBlockingDeque;", "pendingReportQueue$delegate", "Lkotlin/Lazy;", "scenesMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/CJPayTrackReport$Section;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "doReport", "", InvRouter.SCENES, "section", "type", "time", "", "p", "doTrackReport", "params", "curTime", "end", "flush", "remove", "start", DyPayConstant.KEY_START_TIME, "Companion", "FrontCounterSubSectionEnum", "Scenes", "Section", "TrackerReportData", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTrackReport {
    public static final Companion Companion = null;
    private static final Lazy<CJPayTrackReport> SINGLE_INSTANCE$delegate = null;
    private static final String START_SECTION = "TIME_TRACK_START_SECTION";
    private static final String TAG = "CJPayTrackReport";
    private final Lazy pendingReportQueue$delegate;
    private final HashMap<String, ArrayList<Section>> scenesMap;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0007R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$Companion;", "", "()V", "SINGLE_INSTANCE", "Lcom/android/ttcjpaysdk/base/CJPayTrackReport;", "getSINGLE_INSTANCE$annotations", "getSINGLE_INSTANCE", "()Lcom/android/ttcjpaysdk/base/CJPayTrackReport;", "SINGLE_INSTANCE$delegate", "Lkotlin/Lazy;", "START_SECTION", "", "TAG", "getInstance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSINGLE_INSTANCE$annotations() {
        }

        @JvmStatic
        public final CJPayTrackReport getInstance() {
            return getSINGLE_INSTANCE();
        }

        public final CJPayTrackReport getSINGLE_INSTANCE() {
            return (CJPayTrackReport) CJPayTrackReport.access$getSINGLE_INSTANCE$delegate$cp().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$FrontCounterSubSectionEnum;", "", SocialConstants.PARAM_APP_DESC, "", "isReported", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "PrepareCreateOrder", "SubmitOrder", "OrderDataAnalysis", "TTPayTrigger", "TradeConfirmPre", "TradeQueryPre", "ArrivalResult", "Overall", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FrontCounterSubSectionEnum extends Enum<FrontCounterSubSectionEnum> {
        private static final /* synthetic */ FrontCounterSubSectionEnum[] $VALUES = null;
        public static final FrontCounterSubSectionEnum ArrivalResult = null;
        public static final Companion Companion = null;
        public static final FrontCounterSubSectionEnum OrderDataAnalysis = null;
        public static final FrontCounterSubSectionEnum Overall = null;
        public static final FrontCounterSubSectionEnum PrepareCreateOrder = null;
        public static final FrontCounterSubSectionEnum SubmitOrder = null;
        public static final FrontCounterSubSectionEnum TTPayTrigger = null;
        public static final FrontCounterSubSectionEnum TradeConfirmPre = null;
        public static final FrontCounterSubSectionEnum TradeQueryPre = null;
        public final String desc;
        public boolean isReported;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$FrontCounterSubSectionEnum$Companion;", "", "()V", "doSubSectionTrackReport", "", "section", "Lcom/android/ttcjpaysdk/base/CJPayTrackReport$FrontCounterSubSectionEnum;", "checkType", "", "curTime", "", "releaseSubSection", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final void releaseSubSection() {
                FrontCounterSubSectionEnum.SubmitOrder.isReported = false;
                FrontCounterSubSectionEnum.OrderDataAnalysis.isReported = false;
                FrontCounterSubSectionEnum.TTPayTrigger.isReported = false;
                FrontCounterSubSectionEnum.TradeConfirmPre.isReported = false;
                FrontCounterSubSectionEnum.TradeQueryPre.isReported = false;
                FrontCounterSubSectionEnum.ArrivalResult.isReported = false;
                FrontCounterSubSectionEnum.Overall.isReported = false;
                CJPayTrackReport.Companion.getInstance().remove(Scenes.FRONT_COUNTER.getValue());
            }

            @JvmStatic
            public final void doSubSectionTrackReport(FrontCounterSubSectionEnum r110, String r111, long r112) {
                Intrinsics.checkNotNullParameter(r110, "section");
                FrontCounterSubSectionEnum r100 = FrontCounterSubSectionEnum.Overall;
                if (r110 == r100) goto L5;
            L18:
                boolean r101 = true;
            L19:
                if (r101 == true) goto L21;
                return;
            L21:
                if (r110.isReported == true) goto L31;
                r110.isReported = true;
                LinkedHashMap r102 = new LinkedHashMap();
                if (r111 != null) goto L25;
                r111 = "";
            L25:
                r102.put("check_type", r111);
                if (r110 != r100) goto L28;
                CJPayTrackReport.Companion.getInstance().end(Scenes.FRONT_COUNTER.getValue(), "", r102);
                return;
            L28:
                CJPayTrackReport.access$doTrackReport(CJPayTrackReport.Companion.getInstance(), Scenes.FRONT_COUNTER.getValue(), r110.desc, "", r102, r112);
                return;
            L31:
                return;
            L5:
                if (FrontCounterSubSectionEnum.SubmitOrder.isReported == true) goto L7;
            L17:
                r101 = false;
                goto L19
            L7:
                if (FrontCounterSubSectionEnum.OrderDataAnalysis.isReported == false) goto L17;
                if (FrontCounterSubSectionEnum.TTPayTrigger.isReported == false) goto L17;
                if (FrontCounterSubSectionEnum.TradeConfirmPre.isReported == false) goto L17;
                if (FrontCounterSubSectionEnum.TradeQueryPre.isReported == false) goto L17;
                if (FrontCounterSubSectionEnum.ArrivalResult.isReported == false) goto L17;
                goto L17
            }

            public static /* synthetic */ void doSubSectionTrackReport$default(Companion r100, FrontCounterSubSectionEnum r101, String r102, long r103, int r104, Object r105) {
                if ((r104 & 4) == 0) goto L5;
                r103 = 0;
            L5:
                r100.doSubSectionTrackReport(r101, r102, r103);
            }
        }

        private static final /* synthetic */ FrontCounterSubSectionEnum[] $values() {
            return new FrontCounterSubSectionEnum[]{PrepareCreateOrder, SubmitOrder, OrderDataAnalysis, TTPayTrigger, TradeConfirmPre, TradeQueryPre, ArrivalResult, Overall};
        }

        @JvmStatic
        public static final void doSubSectionTrackReport(FrontCounterSubSectionEnum r100, String r101, long r102) {
            Companion.doSubSectionTrackReport(r100, r101, r102);
        }

        @JvmStatic
        public static final void releaseSubSection() {
            Companion.releaseSubSection();
        }

        public static FrontCounterSubSectionEnum valueOf(String r100) {
            return (FrontCounterSubSectionEnum) r27.a.a(FrontCounterSubSectionEnum.class, r100);
        }

        public static FrontCounterSubSectionEnum[] values() {
            return (FrontCounterSubSectionEnum[]) $VALUES.clone();
        }

        static {
            PrepareCreateOrder = new FrontCounterSubSectionEnum("PrepareCreateOrder", 0, "解析提交订单接口数据", false);
            SubmitOrder = new FrontCounterSubSectionEnum("SubmitOrder", 1, "提交订单", false);
            OrderDataAnalysis = new FrontCounterSubSectionEnum("OrderDataAnalysis", 2, "解析提交订单接口数据", false);
            TTPayTrigger = new FrontCounterSubSectionEnum("TTPayTrigger", 3, "ttpay 调用耗时", false);
            TradeConfirmPre = new FrontCounterSubSectionEnum("TradeConfirmPre", 4, "发起确认支付前耗时", false);
            TradeQueryPre = new FrontCounterSubSectionEnum("TradeQueryPre", 5, "确认支付耗时", false);
            ArrivalResult = new FrontCounterSubSectionEnum("ArrivalResult", 6, "财经查询结果耗时", false);
            Overall = new FrontCounterSubSectionEnum("Overall", 7, "总和", false);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private FrontCounterSubSectionEnum(String r100, int r101, String r102, boolean r103) {
            super(r100, r101);
            this.desc = r102;
            this.isReported = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$Scenes;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "START_INTEGRATED_COUNTER", "START_FRONT_COUNTER", "START_RECHARGE_COUNTER", "START_WITHDRAW_COUNTER", "START_MY_CARD", "START_CARD_BIN", "START_PAY_PROCESS", "FRONT_COUNTER", "INTEGRATED_COUNTER_NO_PWD_MERGE_API", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Scenes extends Enum<Scenes> {
        private static final /* synthetic */ Scenes[] $VALUES = null;
        public static final Scenes FRONT_COUNTER = null;
        public static final Scenes INTEGRATED_COUNTER_NO_PWD_MERGE_API = null;
        public static final Scenes START_CARD_BIN = null;
        public static final Scenes START_FRONT_COUNTER = null;
        public static final Scenes START_INTEGRATED_COUNTER = null;
        public static final Scenes START_MY_CARD = null;
        public static final Scenes START_PAY_PROCESS = null;
        public static final Scenes START_RECHARGE_COUNTER = null;
        public static final Scenes START_WITHDRAW_COUNTER = null;
        private String value;

        private static final /* synthetic */ Scenes[] $values() {
            return new Scenes[]{START_INTEGRATED_COUNTER, START_FRONT_COUNTER, START_RECHARGE_COUNTER, START_WITHDRAW_COUNTER, START_MY_CARD, START_CARD_BIN, START_PAY_PROCESS, FRONT_COUNTER, INTEGRATED_COUNTER_NO_PWD_MERGE_API};
        }

        public static Scenes valueOf(String r100) {
            return (Scenes) r27.a.a(Scenes.class, r100);
        }

        public static Scenes[] values() {
            return (Scenes[]) $VALUES.clone();
        }

        static {
            START_INTEGRATED_COUNTER = new Scenes("START_INTEGRATED_COUNTER", 0, "聚合支付收银台启动耗时");
            START_FRONT_COUNTER = new Scenes("START_FRONT_COUNTER", 1, "前置收银台启动耗时");
            START_RECHARGE_COUNTER = new Scenes("START_RECHARGE_COUNTER", 2, "充值收银启动耗时");
            START_WITHDRAW_COUNTER = new Scenes("START_WITHDRAW_COUNTER", 3, "提现收银启动耗时");
            START_MY_CARD = new Scenes("START_MY_CARD", 4, "我的银行卡启动耗时");
            START_CARD_BIN = new Scenes("START_CARD_BIN", 5, "绑卡首页启动耗时");
            START_PAY_PROCESS = new Scenes("START_PAY_PROCESS", 6, "支付流程");
            FRONT_COUNTER = new Scenes("FRONT_COUNTER", 7, "电商");
            INTEGRATED_COUNTER_NO_PWD_MERGE_API = new Scenes("INTEGRATED_COUNTER_NO_PWD_MERGE_API", 8, "聚合支付收银台免密接口合并");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.value = r100;
        }

        private Scenes(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$Section;", "", "name", "", "currentTime", "", "deltaTime", "(Ljava/lang/String;JJ)V", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "getDeltaTime", "setDeltaTime", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Section {
        private long currentTime;
        private long deltaTime;
        private String name;

        public final long getCurrentTime() {
            return this.currentTime;
        }

        public final long getDeltaTime() {
            return this.deltaTime;
        }

        public final String getName() {
            return this.name;
        }

        public final void setCurrentTime(long r100) {
            this.currentTime = r100;
        }

        public final void setDeltaTime(long r100) {
            this.deltaTime = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public Section(String r100, long r101, long r102) {
            this.name = r100;
            this.currentTime = r101;
            this.deltaTime = r102;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012*\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015R5\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayTrackReport$TrackerReportData;", "", InvRouter.SCENES, "", "section", "type", "time", "", "p", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/HashMap;)V", "getP", "()Ljava/util/HashMap;", "getScenes", "()Ljava/lang/String;", "getSection", "getTime", "()J", "getType", "toParams", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TrackerReportData {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final HashMap<String, String> f29333p;
        private final String scenes;
        private final String section;
        private final long time;
        private final String type;

        public final JSONObject toParams() {
            JSONObject r100 = CJPayParamsUtils.getCommonLogParams("", "");
            r100.put("scenes_name", this.scenes);
            r100.put("sub_section", this.section);
            r100.put("type", this.type);
            r100.put("time", this.time);
            HashMap<String, String> r101 = this.f29333p;
            if (r101 == null) goto L8;
            Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            Map.Entry<String, String> r103 = r102.next();
            r100.put(r103.getKey(), r103.getValue());
        L8:
            return r100;
        }

        public final HashMap<String, String> getP() {
            return this.f29333p;
        }

        public final String getScenes() {
            return this.scenes;
        }

        public final String getSection() {
            return this.section;
        }

        public final long getTime() {
            return this.time;
        }

        public final String getType() {
            return this.type;
        }

        public TrackerReportData(String r100, String r101, String r102, long r103, HashMap<String, String> r104) {
            this.scenes = r100;
            this.section = r101;
            this.type = r102;
            this.time = r103;
            this.f29333p = r104;
        }
    }

    public /* synthetic */ CJPayTrackReport(DefaultConstructorMarker r100) {
        this();
    }

    @JvmStatic
    public static final CJPayTrackReport getInstance() {
        return Companion.getInstance();
    }

    public static final CJPayTrackReport getSINGLE_INSTANCE() {
        return Companion.getSINGLE_INSTANCE();
    }

    static {
        Companion = new Companion(null);
        SINGLE_INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CJPayTrackReport$Companion$SINGLE_INSTANCE$2.INSTANCE);
    }

    private final LinkedBlockingDeque<TrackerReportData> getPendingReportQueue() {
        return (LinkedBlockingDeque) this.pendingReportQueue$delegate.getValue();
    }

    private CJPayTrackReport() {
        this.scenesMap = new HashMap();
        this.pendingReportQueue$delegate = LazyKt.lazy(CJPayTrackReport$pendingReportQueue$2.INSTANCE);
    }

    public final void flush() {
    L10:
        TrackerReportData r100 = getPendingReportQueue().poll();     // Catch: Exception -> L7
        if (r100 == null) goto L14;
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_custom_scenes_time", new JSONObject[]{r100.toParams()});     // Catch: Exception -> L7
        goto L10
    L14:
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTrackReport#flush", e);
        CJLogger.b(TAG, Log.getStackTraceString(e));
    }

    public static final /* synthetic */ Lazy access$getSINGLE_INSTANCE$delegate$cp() {
        return SINGLE_INSTANCE$delegate;
    }

    public final void remove(String r100) {
        ICJPaySettingService r101 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isEventUpload());
    L6:
        if (r102 == null) goto L8;
        boolean r103 = r102.booleanValue();
    L9:
        if (r103 == false) goto L12;
        this.scenesMap.remove(r100);
        return;
    L12:
        return;
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final synchronized void end(String r100, String r101) {
        monitor-enter(this);
        end(r100, r101, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void start(String r100, long r110) {
        monitor-enter(this);
        ICJPaySettingService r101 = (ICJPaySettingService) CJPayServiceManager.getInstance().getIService(ICJPaySettingService.class);     // Catch: Throwable -> L22
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.isEventUpload());     // Catch: Throwable -> L22
    L7:
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();     // Catch: Throwable -> L22
    L11:
        if (r103 == true) goto L25;
    L20:
        monitor-exit(this);
        return;
    L25:
        this.scenesMap.remove(r100);     // Catch: Exception -> L18 Throwable -> L22
        ArrayList<Section> r104 = new ArrayList();     // Catch: Exception -> L18 Throwable -> L22
        if (r110 > 0) goto L16;
        r110 = System.currentTimeMillis();     // Catch: Exception -> L18 Throwable -> L22
    L16:
        r104.add(new Section(START_SECTION, r110, 0));     // Catch: Exception -> L18 Throwable -> L22
        this.scenesMap.put(r100, r104);     // Catch: Exception -> L18 Throwable -> L22
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTrackReport#start", e);     // Catch: Throwable -> L22
        CJLogger.b(TAG, e.toString());     // Catch: Throwable -> L22
        goto L20
    L10:
        r103 = false;
        goto L11
    L6:
        r102 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final void doTrackReport(String r110, String r111, String r112) {
        doTrackReport$default(this, r110, r111, r112, null, 0, 16, null);
    }

    public final synchronized void end(String r100, String r110, HashMap<String, String> r111) {
        monitor-enter(this);
    L21:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTrackReport#end", e);     // Catch: Throwable -> L19
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTrackReport#end", e);     // Catch: Throwable -> L19
    L23:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.scenesMap.containsKey(r100) == false) goto L23;
        ArrayList<Section> r101 = this.scenesMap.remove(r100);     // Catch: Throwable -> L19 Exception -> L21
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L19 Exception -> L21
        long r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L13;
        Section r104 = (Section) r102.next();     // Catch: Throwable -> L19 Exception -> L21
        if (Intrinsics.areEqual(r104.getName(), START_SECTION) == true) goto L9;
        r103 = r103 + r104.getDeltaTime();     // Catch: Throwable -> L19 Exception -> L21
        goto L9
    L13:
        long r105 = r103;
    L16:
        if (r105 <= 0) goto L23;
        doReport(r100, "总和", r110, r105, r111);     // Catch: Throwable -> L19 Exception -> L21
    L14:
        r105 = 0;
        goto L16
    }

    private final synchronized void doTrackReport(String r110, String r111, String r112, HashMap<String, String> r113, long r114) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTrackReport#doTrackReport", e);     // Catch: Throwable -> L18
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTrackReport#doTrackReport", e);     // Catch: Throwable -> L18
    L22:
        monitor-exit(this);
        return;
    L5:
        if (this.scenesMap.containsKey(r110) == false) goto L22;
        ArrayList<Section> r100 = this.scenesMap.get(r110);     // Catch: Throwable -> L18 Exception -> L20
        if (r100 == null) goto L22;
        if (r114 <= 0) goto L11;
        long r115 = r114;
    L12:
        Section r101 = (Section) CollectionsKt.lastOrNull(r100);     // Catch: Throwable -> L18 Exception -> L20
        if (r101 == null) goto L15;
        long r102 = r101.getCurrentTime();     // Catch: Throwable -> L18 Exception -> L20
    L16:
        long r116 = r115 - r102;     // Catch: Throwable -> L18 Exception -> L20
        doReport(r110, r111, r112, r116, r113);     // Catch: Throwable -> L18 Exception -> L20
        r100.add(new Section(r110, r115, r116));     // Catch: Throwable -> L18 Exception -> L20
    L15:
        r102 = System.currentTimeMillis();     // Catch: Throwable -> L18 Exception -> L20
        goto L16
    L11:
        r115 = System.currentTimeMillis();     // Catch: Throwable -> L18 Exception -> L20
        goto L12
    }

    public static /* synthetic */ void end$default(CJPayTrackReport r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "";
    L5:
        r100.end(r101, r102);
    }

    public static /* synthetic */ void start$default(CJPayTrackReport r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.start(r101, r102);
    }

    public final void doReport(String r110, String r111, String r112, long r113, HashMap<String, String> r114) {
        getPendingReportQueue().offer(new TrackerReportData(r110, r111, r112, r113, r114));
        b.c(new AnonymousClass1(this), 0);
    }

    public static final /* synthetic */ void access$doTrackReport(CJPayTrackReport r100, String r101, String r102, String r103, HashMap r104, long r105) {
        r100.doTrackReport(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void doTrackReport$default(CJPayTrackReport r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = "";
    L5:
        r100.doTrackReport(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void end$default(CJPayTrackReport r100, String r101, String r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.end(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doTrackReport$default(CJPayTrackReport r100, String r101, String r102, String r110, HashMap r111, long r112, int r113, Object r114) {
        if ((r113 & 4) == 0) goto L5;
        r110 = "";
    L5:
        String r103 = r110;
        if ((r113 & 8) == 0) goto L8;
        r111 = null;
    L8:
        HashMap r104 = r111;
        if ((r113 & 16) == 0) goto L11;
        r112 = 0;
    L11:
        r100.doTrackReport(r101, r102, r103, r104, r112);
    }
}
