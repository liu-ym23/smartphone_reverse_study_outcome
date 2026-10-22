package com.obric.callsummary;

import android.content.Context;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel;
import com.obric.callsummary.model.aikernel.AIKernelCallSummaryModel;
import com.obric.callsummary.model.aikernel.AIKernelCallSummaryModelLocal;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.contactprovider.CallLogProviderHelper;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.database.entity.CallFeatureEntity;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.settings.AIModelSettings;
import com.obric.settings.SettingsProviderHelper;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.CallSummaryEvent;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: CallSummaryGenerateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0016\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0011J0\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0011J&\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010&\u001a\u00020'J.\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u001f\u001a\u00020\u0011H\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u0019H\u0007J \u0010/\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004Jj\u00100\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u000202H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lcom/obric/callsummary/CallSummaryGenerateManager;", "", "()V", "TAG", "", "aiKernelLocalModel", "Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModelLocal;", "getAiKernelLocalModel", "()Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModelLocal;", "aiKernelLocalModel$delegate", "Lkotlin/Lazy;", "aiKernelOnlineModel", "Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModel;", "getAiKernelOnlineModel", "()Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModel;", "aiKernelOnlineModel$delegate", "vlmProvisionedCache", "", "getVlmProvisionedCache", "()Z", "setVlmProvisionedCache", "(Z)V", "checkVlmProvisioned", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateAndSaveCallSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "context", "Landroid/content/Context;", "callCreateTime", "", "phoneNumber", "isRetry", "generateAndSaveCallSummaryLocalModel", "composeResult", "generateCallSimplify", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "generateCallSummary", "model", "Lcom/obric/callsummary/CallSummaryGenerateManager$MODEL;", "init", "", "resultSuccess", "result", "retryCallSummary", "trackCallSummaryEvent", "modelType", "", "isSummarySuccess", "inputTextLength", "outputTextLength", "summaryDuration", AccountConst.KEY_ERROR_CODE, "is_retry", "summaryRecordDurationMs", "sentenceCount", "MODEL", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryGenerateManager {
    public static final CallSummaryGenerateManager INSTANCE = null;
    private static final String TAG = "CallSummaryGenerateManager";
    private static final Lazy aiKernelLocalModel$delegate = null;
    private static final Lazy aiKernelOnlineModel$delegate = null;
    private static boolean vlmProvisionedCache;

    /* JADX INFO: compiled from: CallSummaryGenerateManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/callsummary/CallSummaryGenerateManager$MODEL;", "", "typeValue", "", "(Ljava/lang/String;II)V", "getTypeValue", "()I", "AI_KERNEL_ONLINE", "AI_KERNEL_LOCAL", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum MODEL extends Enum<MODEL> {
        private static final /* synthetic */ MODEL[] $VALUES = null;
        public static final MODEL AI_KERNEL_LOCAL = null;
        public static final MODEL AI_KERNEL_ONLINE = null;
        private final int typeValue;

        private static final /* synthetic */ MODEL[] $values() {
            return new MODEL[]{AI_KERNEL_ONLINE, AI_KERNEL_LOCAL};
        }

        public static MODEL valueOf(String r1) {
            return (MODEL) Enum.valueOf(MODEL.class, r1);
        }

        public static MODEL[] values() {
            return (MODEL[]) $VALUES.clone();
        }

        private MODEL(String r1, int r2, int r3) {
            super(r1, r2);
            this.typeValue = r3;
        }

        public final int getTypeValue() {
            return this.typeValue;
        }

        static {
            AI_KERNEL_ONLINE = new MODEL("AI_KERNEL_ONLINE", 0, 0);
            AI_KERNEL_LOCAL = new MODEL("AI_KERNEL_LOCAL", 1, 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: CallSummaryGenerateManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[MODEL.values().length];
            r0[MODEL.AI_KERNEL_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MODEL.AI_KERNEL_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.CallSummaryGenerateManager$checkVlmProvisioned$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallSummaryGenerateManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.CallSummaryGenerateManager", f = "CallSummaryGenerateManager.kt", i = {}, l = {338, 345}, m = "checkVlmProvisioned", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CallSummaryGenerateManager this$0;

        AnonymousClass1(CallSummaryGenerateManager r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.checkVlmProvisioned(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.CallSummaryGenerateManager$init$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallSummaryGenerateManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.CallSummaryGenerateManager$init$1", f = "CallSummaryGenerateManager.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class C02401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        int label;

        C02401(Context r1, Continuation<? super C02401> r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02401(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C02401) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CallSummaryGenerateManager r2 = (CallSummaryGenerateManager) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            r2.setVlmProvisionedCache(((Boolean) r5).booleanValue());
            if (CallSummaryGenerateManager.INSTANCE.getVlmProvisionedCache() == true) goto L15;
            int r6 = MODEL.AI_KERNEL_ONLINE.getTypeValue();
        L16:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryGenerateManager.TAG, "init defaultModel:" + r6);
            SettingsProviderHelper.INSTANCE.setSummaryModelType(this.$context, r6);
            return Unit.INSTANCE;
        L15:
            r6 = SettingsProviderHelper.INSTANCE.getSummaryModelType(this.$context);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CallSummaryGenerateManager r7 = CallSummaryGenerateManager.INSTANCE;
            this.L$0 = r7;
            this.label = 1;
            Object r3 = CallSummaryGenerateManager.INSTANCE.checkVlmProvisioned(this);
            if (r3 != r0) goto L11;
            return r0;
        L11:
            r2 = r7;
            r5 = r3;
            goto L12
        }
    }

    public static /* synthetic */ void $r8$lambda$wSfwAMZJsrhn6Gh87N9f8HPwKmM(Context r0, long r1, String r3, int r4, boolean r5, int r6, int r7, long r8, long r10, int r12, String r13, boolean r14) {
        trackCallSummaryEvent$lambda$5(r0, r1, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14);
    }

    private CallSummaryGenerateManager() {
    }

    static {
        INSTANCE = new CallSummaryGenerateManager();
        aiKernelOnlineModel$delegate = LazyKt.lazy(CallSummaryGenerateManager$aiKernelOnlineModel$2.INSTANCE);
        aiKernelLocalModel$delegate = LazyKt.lazy(CallSummaryGenerateManager$aiKernelLocalModel$2.INSTANCE);
        vlmProvisionedCache = true;
    }

    private final AIKernelCallSummaryModel getAiKernelOnlineModel() {
        return (AIKernelCallSummaryModel) aiKernelOnlineModel$delegate.getValue();
    }

    private final AIKernelCallSummaryModelLocal getAiKernelLocalModel() {
        return (AIKernelCallSummaryModelLocal) aiKernelLocalModel$delegate.getValue();
    }

    public final boolean getVlmProvisionedCache() {
        return vlmProvisionedCache;
    }

    public final void setVlmProvisionedCache(boolean r1) {
        vlmProvisionedCache = r1;
    }

    public final void init(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02401(r7, null), 2, null);
    }

    @JvmStatic
    public static final CallSummaryResult generateCallSummary(MODEL r6, Context r7, List<CallSummaryASRMessageBean> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "model");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "asrMessage");
        int r10 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r10 != 1) goto L5;
        AIKernelCallSummaryModel r11 = INSTANCE.getAiKernelOnlineModel();
    L11:
        return r11.generateCallSummary(r7, r8, false, ABSAIKernelCallSummaryModel.PowerMode.BALANCED, r9);
    L5:
        if (r10 != 2) goto L8;
        r11 = INSTANCE.getAiKernelLocalModel();
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ CallSummaryResult generateCallSimplify$default(CallSummaryGenerateManager r0, Context r1, List r2, ABSAIKernelCallSummaryModel.PowerMode r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = ABSAIKernelCallSummaryModel.PowerMode.BALANCED;
    L6:
        return r0.generateCallSimplify(r1, r2, r3);
    }

    public final CallSummaryResult generateCallSimplify(Context r8, List<CallSummaryASRMessageBean> r9, ABSAIKernelCallSummaryModel.PowerMode r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "asrMessage");
        Intrinsics.checkNotNullParameter(r10, ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE);
        return getAiKernelLocalModel().generateCallSummary(r8, r9, true, r10, false);
    }

    public final CallSummaryResult retryCallSummary(Context r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "phoneNumber");
        String r6 = AISummary.getSummaryResult(r9, r10, r12);
        if (r6 != null) goto L6;
        return generateAndSaveCallSummary(r9, r10, r12, true);
    L6:
        return generateAndSaveCallSummaryLocalModel(r9, r10, r12, r6, true);
    }

    public final CallSummaryResult generateAndSaveCallSummary(Context r22, long r23, String r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r25, "phoneNumber");
        List<CallFeatureEntity> r0 = ObricCallLogProviderHelper.INSTANCE.getCallFeatureEntity(r22, r23, r25);
        if (r0.isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate remote noFeature date=" + r23 + " isRetry=" + r26);
        return null;
    L6:
        List<CallSummaryASRMessageBean> r5 = ObricCallLogProviderHelper.INSTANCE.getCallSummaryASRMessageBean(r22, r23, r25);
        Iterator<T> r8 = r5.iterator();
        long r13 = 0;
    L8:
        if (r8.hasNext() == false) goto L10;
        r13 = r13 + ((CallSummaryASRMessageBean) r8.next()).getDurationMs();
        goto L8
    L10:
        int r15 = r5.size();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate remote start date=" + r23 + " asrCount=" + r5.size() + " isRetry=" + r26);
        int r6 = SettingsProviderHelper.INSTANCE.getSummaryModelType(r22);
        MODEL r9 = AIModelSettings.Companion.modelTypeIndex2ModelEnum(r6);
        long r10 = System.currentTimeMillis();
        CallSummaryResult r17 = generateCallSummary(r9, r22, r5, r26);
        long r11 = System.currentTimeMillis() - r10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate remote done date=" + r23 + " model=" + r9.name() + " error=" + r17.getErrorCode() + " summaryError=" + r17.getData().getErrorCode() + " shouldPersist=" + resultSuccess(r17) + " duration=" + r11);
        if (resultSuccess(r17) == true) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate remote drop date=" + r23 + " error=" + r17.getErrorCode());
        trackCallSummaryEvent(r22, r23, r25, r6, false, r17.getInputTextLength(), r17.getOutputTextLength(), r11, String.valueOf(r17.getErrorCode()), r26, r13, r15);
        return null;
    L14:
        CallFeatureEntity r1 = r0.get(0);
        r1.changeStatus(1, true);
        ObricCallLogProviderHelper.INSTANCE.updateCallSummaryToObricCallLogById(r22, r1.getId(), r17.getData());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate remote saved date=" + r23 + " id=" + r1.getId() + " error=" + r17.getErrorCode() + " summaryError=" + r17.getData().getErrorCode());
        if (r17.getErrorCode() != 0) goto L17;
        boolean r7 = true;
    L18:
        trackCallSummaryEvent(r22, r23, r25, r6, r7, r17.getInputTextLength(), r17.getOutputTextLength(), r11, String.valueOf(r17.getErrorCode()), r26, r13, r15);
        return r17;
    L17:
        r7 = false;
        goto L18
    }

    public final CallSummaryResult generateAndSaveCallSummaryLocalModel(Context r24, long r25, String r27, String r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r27, "phoneNumber");
        Intrinsics.checkNotNullParameter(r28, "composeResult");
        List<CallFeatureEntity> r13 = ObricCallLogProviderHelper.INSTANCE.getCallFeatureEntity(r24, r25, r27);
        if (r13.isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate local noFeature date=" + r25 + " isRetry=" + r29);
        return null;
    L6:
        List<CallSummaryASRMessageBean> r5 = ObricCallLogProviderHelper.INSTANCE.getCallSummaryASRMessageBean(r24, r25, r27);
        Iterator<T> r6 = r5.iterator();
        long r17 = 0;
    L8:
        if (r6.hasNext() == false) goto L10;
        r17 = r17 + ((CallSummaryASRMessageBean) r6.next()).getDurationMs();
        goto L8
    L10:
        int r19 = r5.size();
        if (TextUtils.isEmpty(r28) == true) goto L13;
        ArrayList r11 = new ArrayList();
        r11.add(new CallSummaryASRMessageBean(r28, "", 0, 4, null));
        r5 = r11;
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate local start date=" + r25 + " asrCount=" + r5.size() + " isRetry=" + r29);
        int r7 = MODEL.AI_KERNEL_LOCAL.getTypeValue();
        long r8 = System.currentTimeMillis();
        CallSummaryResult r20 = generateCallSummary(MODEL.AI_KERNEL_LOCAL, r24, r5, r29);
        long r9 = System.currentTimeMillis() - r8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate local done date=" + r25 + " error=" + r20.getErrorCode() + " summaryError=" + r20.getData().getErrorCode() + " shouldPersist=" + resultSuccess(r20) + " duration=" + r9);
        if (resultSuccess(r20) == true) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate local drop date=" + r25 + " error=" + r20.getErrorCode());
        trackCallSummaryEvent(r24, r25, r27, r7, false, r20.getInputTextLength(), r20.getOutputTextLength(), r9, String.valueOf(r20.getErrorCode()), r29, r17, r19);
        return null;
    L17:
        CallFeatureEntity r4 = r13.get(0);
        r4.changeStatus(1, true);
        ObricCallLogProviderHelper.INSTANCE.updateCallSummaryToObricCallLogById(r24, r4.getId(), r20.getData());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "generate local saved date=" + r25 + " id=" + r4.getId() + " error=" + r20.getErrorCode() + " summaryError=" + r20.getData().getErrorCode());
        if (r20.getErrorCode() != 0) goto L20;
        boolean r10 = true;
    L21:
        trackCallSummaryEvent(r24, r25, r27, r7, r10, r20.getInputTextLength(), r20.getOutputTextLength(), r9, String.valueOf(r20.getErrorCode()), r29, r17, r19);
        return r20;
    L20:
        r10 = false;
        goto L21
    }

    private final void trackCallSummaryEvent(Context r19, final long r20, final String r22, final int r23, final boolean r24, final int r25, final int r26, final long r27, final String r29, final boolean r30, final long r31, final int r33) {
        final Context r1 = r19.getApplicationContext();
        GlobalUtils.INSTANCE.execute(new CallSummaryGenerateManager$$ExternalSyntheticLambda0(r1, r20, r22, r23, r24, r25, r26, r27, r31, r33, r29, r30));
    }

    private static final void trackCallSummaryEvent$lambda$5(Context r20, long r21, String r23, int r24, boolean r25, int r26, int r27, long r28, long r30, int r32, String r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r23, "$phoneNumber");
        CallLogProviderHelper r2 = CallLogProviderHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r20, "applicationContext");
        CallSummaryEvent r0 = new CallSummaryEvent(r24, r25, r26, r27, r28, r2.getCallDuration(r20, r21, r23), r30, r32, r33, r34 ? 1 : 0, null, 1024, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "trackCallSummaryEvent event is " + r0);
        EventTrackerManager.INSTANCE.track(r0);
    }

    @JvmStatic
    public static final boolean resultSuccess(CallSummaryResult r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getErrorCode() != 0) goto L8;
    L9:
        return true;
    L8:
        if (r2.getErrorCode() == 2001) goto L9;
        return false;
    }

    public final Object checkVlmProvisioned(Continuation<? super Boolean> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        boolean r4 = false;
        Object r6 = null;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
        Object r11 = ((Result) r8).m812unboximpl();
    L38:
        Result r12 = Result.m802boximpl(r11);
    L40:
        StringBuilder r13 = new StringBuilder("updatePackage  ");
        if (r12 == null) goto L46;
        Object r2 = r12.m812unboximpl();
        if (Result.m809isFailureimpl(r2) == false) goto L45;
        r2 = null;
    L45:
        PackageResource r3 = (PackageResource) r2;
    L47:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r13.append(r3).toString());
        if (r12 == null) goto L59;
        Object r14 = r12.m812unboximpl();
        if (Result.m809isFailureimpl(r14) == true) goto L53;
        r6 = r14;
    L53:
        PackageResource r7 = (PackageResource) r6;
        if (r7 == null) goto L59;
        if (r7.isProvisioned() != true) goto L59;
        r4 = true;
    L59:
        return Boxing.boxBoolean(r4);
    L46:
        r3 = null;
        goto L47
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        Object r15 = ((Result) r8).m812unboximpl();
    L20:
        if (Result.m809isFailureimpl(r15) == false) goto L22;
        Object r5 = null;
    L23:
        PackageResource r16 = (PackageResource) r5;
        if (r16 != null) goto L26;
    L28:
        boolean r17 = false;
    L29:
        if (r17 == false) goto L61;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getPackage   不支持的算法包:");
        if (Result.m809isFailureimpl(r15) == false) goto L33;
        r15 = null;
    L33:
        PackageResource r18 = (PackageResource) r15;
        RequestParams r19 = new RequestParams(null, null, 3, null);
        ParamsKt.setUpdateParams(r19, true);
        if (r18 == null) goto L39;
        IAIKernelManager r20 = AIKernelManager.INSTANCE.invoke();
        r0.label = 2;
        r11 = r20.mo312updatePackage0E7RQCE(r18, r19, r0);
        if (r11 != r10) goto L38;
        return r10;
    L39:
        r12 = null;
        goto L40
    L61:
        if (Result.m809isFailureimpl(r15) == true) goto L64;
        r6 = r15;
    L64:
        PackageResource r21 = (PackageResource) r6;
        if (r21 == null) goto L70;
        if (r21.isProvisioned() != true) goto L70;
        r4 = true;
    L70:
        return Boxing.boxBoolean(r4);
    L26:
        if (r16.isProvisioned() == true) goto L28;
        r17 = true;
        goto L29
    L22:
        r5 = r15;
        goto L23
    L16:
        ResultKt.throwOnFailure(r8);
        final String r22 = ABSAIKernelCallSummaryModel.PARAMETER_VALUE_LORA_TYPE_SUMMARY_TODO;
        RequestParams r23 = new RequestParams(null, new CallSummaryGenerateManager$checkVlmProvisioned$requestParams$1(r22), 1, null);
        IAIKernelManager r24 = AIKernelManager.INSTANCE.invoke();
        r0.label = 1;
        r15 = r24.mo311getPackage0E7RQCE(ABSAIKernelCallSummaryModel.MODEL_NAME_LOCAL, r23, r0);
        if (r15 != r10) goto L20;
        return r10;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }
}
