package com.obric.callsummary.model.aikernel;

import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallAssignment;
import com.obric.callsummary.bean.CallAssignmentData;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.callsummary.bean.SummaryAndTodo;
import com.obric.callsummary.bean.SummaryData;
import com.obric.callsummary.bean.SummaryTodo;
import com.obric.callsummary.model.intf.ICallSummaryGenerateModel;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

/* JADX INFO: compiled from: ABSAIKernelCallSummaryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H$JB\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH$J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ<\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0014R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel;", "Lcom/obric/callsummary/model/intf/ICallSummaryGenerateModel;", "()V", "modelLoadHelper", "Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "getModelLoadHelper", "()Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "generateCallSummary", "Lcom/obric/callsummary/bean/CallSummaryResult;", "context", "Landroid/content/Context;", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "isSimplify", "", ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "isRetry", "generateCallSummaryCleanup", "", "parameter", "Lorg/json/JSONObject;", "generateModelParameter", "Lkotlin/Pair;", "", "getModule", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResultText", "resultText", "", "inputTextLength", "outputTextLength", "Companion", "PowerMode", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ABSAIKernelCallSummaryModel implements ICallSummaryGenerateModel {
    public static final Companion Companion = null;
    public static final int ERR_CODE_MODEL_SUMMARY_FAIL = 2001;
    public static final int HANDLE_MODEL_RESULT_ERROR = -3;
    public static final int LOAD_MODEL_ERROR = -1;
    public static final String MODEL_NAME_LOCAL = "vlm_local";
    public static final String MODEL_NAME_ONLINE = "summary_and_todo";
    public static final int NO_ERROR = 0;
    public static final String PARAMETER_KEY_LORA_TYPE = "loraType";
    public static final String PARAMETER_KEY_POWER_MODE = "powerMode";
    public static final String PARAMETER_VALUE_LORA_TYPE_SIMPLIFY = "simplify";
    public static final String PARAMETER_VALUE_LORA_TYPE_SUMMARY_TODO = "summary_todo_json";
    public static final int RUN_MODEL_ERROR = -2;
    private static final String TAG = "ABSAIKernelCallSummaryModel";

    /* JADX INFO: compiled from: ABSAIKernelCallSummaryModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$Companion;", "", "()V", "ERR_CODE_MODEL_SUMMARY_FAIL", "", "HANDLE_MODEL_RESULT_ERROR", "LOAD_MODEL_ERROR", "MODEL_NAME_LOCAL", "", "MODEL_NAME_ONLINE", "NO_ERROR", "PARAMETER_KEY_LORA_TYPE", "PARAMETER_KEY_POWER_MODE", "PARAMETER_VALUE_LORA_TYPE_SIMPLIFY", "PARAMETER_VALUE_LORA_TYPE_SUMMARY_TODO", "RUN_MODEL_ERROR", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ABSAIKernelCallSummaryModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "POWER_SAVER", "BALANCED", "BURST", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum PowerMode extends Enum<PowerMode> {
        private static final /* synthetic */ PowerMode[] $VALUES = null;
        public static final PowerMode BALANCED = null;
        public static final PowerMode BURST = null;
        public static final PowerMode POWER_SAVER = null;
        private final String value;

        private static final /* synthetic */ PowerMode[] $values() {
            return new PowerMode[]{POWER_SAVER, BALANCED, BURST};
        }

        public static PowerMode valueOf(String r1) {
            return (PowerMode) Enum.valueOf(PowerMode.class, r1);
        }

        public static PowerMode[] values() {
            return (PowerMode[]) $VALUES.clone();
        }

        private PowerMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            POWER_SAVER = new PowerMode("POWER_SAVER", 0, "powersaver");
            BALANCED = new PowerMode("BALANCED", 1, "balance");
            BURST = new PowerMode("BURST", 2, "burst");
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel$generateCallSummary$1, reason: invalid class name */
    /* JADX INFO: compiled from: ABSAIKernelCallSummaryModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/callsummary/bean/CallSummaryResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel$generateCallSummary$1", f = "ABSAIKernelCallSummaryModel.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {157, 184, 186}, m = "invokeSuspend", n = {"parameter", "summaryTextSb", AccountConst.KEY_ERROR_CODE, "errorMessage", "inputTextLength", "parameter", "summaryTextSb", AccountConst.KEY_ERROR_CODE, "errorMessage", "inputTextLength"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CallSummaryResult>, Object> {
        final /* synthetic */ List<CallSummaryASRMessageBean> $asrMessage;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $isRetry;
        final /* synthetic */ boolean $isSimplify;
        final /* synthetic */ PowerMode $powerMode;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ABSAIKernelCallSummaryModel this$0;

        AnonymousClass1(boolean r1, PowerMode r2, boolean r3, List<CallSummaryASRMessageBean> r4, ABSAIKernelCallSummaryModel r5, Context r6, Continuation<? super AnonymousClass1> r7) {
            this.$isSimplify = r1;
            this.$powerMode = r2;
            this.$isRetry = r3;
            this.$asrMessage = r4;
            this.this$0 = r5;
            this.$context = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$isSimplify, this.$powerMode, this.$isRetry, this.$asrMessage, this.this$0, this.$context, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super CallSummaryResult> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super CallSummaryResult> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            int r3 = this.I$0;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$3;
            Ref.IntRef r5 = (Ref.IntRef) this.L$2;
            StringBuilder r6 = (StringBuilder) this.L$1;
            JSONObject r7 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r22);
        L33:
            int r10 = r3;
            final StringBuilder r9 = r6;
            final JSONObject r8 = r7;
            final Ref.ObjectRef r11 = r4;
            final Ref.IntRef r12 = r5;
        L35:
            this.this$0.generateCallSummaryCleanup(this.$context, r8);
            if (r12.element == 0) goto L39;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model infer returnFail simplify=" + this.$isSimplify + " error=" + r12.element);
            return new CallSummaryResult(r12.element, (String) r11.element, null, 0, 0, 28, null);
        L39:
            String r13 = r9.toString();
            Intrinsics.checkNotNullExpressionValue(r13, "summaryTextSb.toString()");
            return this.this$0.handleResultText(this.$context, r13, r10, r13.length(), this.$isSimplify, this.$powerMode);
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r14 = this.I$0;
            r11 = (Ref.ObjectRef) this.L$3;
            r12 = (Ref.IntRef) this.L$2;
            StringBuilder r15 = (StringBuilder) this.L$1;
            r8 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r22);
            r9 = r15;
            int r16 = r14;
            Object r17 = r22;
        L27:
            Flow r18 = (Flow) r17;
            if (r18 == null) goto L34;
            final boolean r19 = this.$isSimplify;
            this.L$0 = r8;
            this.L$1 = r9;
            this.L$2 = r12;
            this.L$3 = r11;
            this.I$0 = r16;
            this.label = 3;
            if (r18.collect(new AnonymousClass2(r9, r12, r11, r19), this) != r1) goto L32;
            return r1;
        L32:
            r4 = r11;
            r5 = r12;
            r3 = r16;
            r7 = r8;
            r6 = r9;
            goto L33
        L34:
            r10 = r16;
            goto L35
        L11:
            ResultKt.throwOnFailure(r22);
            Object r20 = r22;
        L19:
            IBaseModel r21 = (IBaseModel) r20;
            if (r21 != null) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model infer loadFail simplify=" + this.$isSimplify);
            return new CallSummaryResult(-1, "Load model error!", null, 0, 0, 28, null);
        L23:
            Pair<JSONObject, Integer> r23 = this.this$0.generateModelParameter(this.$context, this.$asrMessage, this.$isSimplify, this.$powerMode, this.$isRetry);
            r8 = r23.component1();
            r16 = r23.component2().intValue();
            r9 = new StringBuilder();
            Ref.IntRef r110 = new Ref.IntRef();
            Ref.ObjectRef r111 = new Ref.ObjectRef();
            r111.element = "";
            final Function1<RequestParams, Unit> r112 = new ABSAIKernelCallSummaryModel$generateCallSummary$1$appendCommonParams$1(r8);
            this.L$0 = r8;
            this.L$1 = r9;
            this.L$2 = r110;
            this.L$3 = r111;
            this.I$0 = r16;
            this.label = 2;
            r17 = r21.inferAsFlow(new RequestParams(null, new C00741(r112), 1, null), this);
            if (r17 != r1) goto L26;
            return r1;
        L26:
            r12 = r110;
            r11 = r111;
            goto L27
        L12:
            ResultKt.throwOnFailure(r22);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model infer start simplify=" + this.$isSimplify + " powerMode=" + this.$powerMode + " isRetry=" + this.$isRetry + " asrCount=" + this.$asrMessage.size());
            if (this.$asrMessage.isEmpty() == false) goto L16;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model infer emptyAsr simplify=" + this.$isSimplify);
            return new CallSummaryResult(-3, "ASR message is empty", null, 0, 0, 4, null);
        L16:
            this.label = 1;
            r20 = this.this$0.getModule(this.$isSimplify, this);
            if (r20 != r1) goto L19;
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected abstract void generateCallSummaryCleanup(Context r1, JSONObject r2);

    protected abstract Pair<JSONObject, Integer> generateModelParameter(Context r1, List<CallSummaryASRMessageBean> r2, boolean r3, PowerMode r4, boolean r5);

    protected abstract ScriptModelLoadHelper getModelLoadHelper();

    public Object getModule(boolean r1, Continuation<? super IBaseModel> r2) {
        return getModule$suspendImpl(this, r1, r2);
    }

    public ABSAIKernelCallSummaryModel() {
    }

    public static /* synthetic */ CallSummaryResult handleResultText$default(ABSAIKernelCallSummaryModel r7, Context r8, String r9, int r10, int r11, boolean r12, PowerMode r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 16) == 0) goto L6;
        r12 = false;
    L6:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L10;
        r13 = PowerMode.BALANCED;
    L10:
        return r7.handleResultText(r8, r9, r10, r11, r5, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleResultText");
    }

    protected CallSummaryResult handleResultText(Context r24, String r25, int r26, int r27, boolean r28, PowerMode r29) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "resultText");
        Intrinsics.checkNotNullParameter(r29, PARAMETER_KEY_POWER_MODE);
        if (r28 == true) goto L5;
        SummaryData r1 = (SummaryData) GlobalUtils.INSTANCE.getGson().fromJson(r25, SummaryData.class);     // Catch: Exception -> L52
        if (r1.getCode() != 2001) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model handle unable code=" + r1.getCode() + " inputLen=" + r26 + " outputLen=" + r27);     // Catch: Exception -> L52
        String r0 = r24.getString(R.string.unable_to_summarize);     // Catch: Exception -> L52
        Intrinsics.checkNotNullExpressionValue(r0, "context.getString(R.string.unable_to_summarize)");     // Catch: Exception -> L52
        return new CallSummaryResult(r1.getCode(), r1.getMsg(), new CallSummary(null, null, null, null, r1.getCode(), 15, null), 0, r0.length());
    L11:
        if (r1.getCode() == 0) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model handle fail code=" + r1.getCode() + " msg=" + r1.getMsg());     // Catch: Exception -> L52
        return new CallSummaryResult(r1.getCode(), r1.getMsg(), null, 0, 0, 28, null);
    L14:
        SummaryAndTodo r2 = r1.getData();     // Catch: Exception -> L52
        if (r2 == null) goto L21;
        String r3 = r2.getSummary();     // Catch: Exception -> L52
        if (r3 == null) goto L21;
        String r4 = StringsKt.trim(r3).toString();     // Catch: Exception -> L52
        if (r4 == null) goto L21;
    L22:
        List<String> r5 = new Regex("\\d\\. ").split(r4, 0);     // Catch: Exception -> L52
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Exception -> L52
        Iterator<T> r7 = r5.iterator();     // Catch: Exception -> L52
    L24:
        if (r7.hasNext() == false) goto L26;
        r6.add(StringsKt.trim((String) r7.next()).toString());     // Catch: Exception -> L52
        goto L24
    L26:
        ArrayList r8 = r6;     // Catch: Exception -> L52
        if (new Regex("^\\d\\. ").matches(r4) == true) goto L29;
        Pair r9 = new Pair(r8.get(0), r8.subList(1, r8.size()));     // Catch: Exception -> L52
    L30:
        String r13 = (String) r9.component1();     // Catch: Exception -> L52
        List r14 = (List) r9.component2();     // Catch: Exception -> L52
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L52
        SummaryAndTodo r11 = r1.getData();     // Catch: Exception -> L52
        if (r11 == null) goto L43;
        List<SummaryTodo> r12 = r11.getTasks();     // Catch: Exception -> L52
        if (r12 == null) goto L43;
        Iterator<T> r15 = r12.iterator();     // Catch: Exception -> L52
    L36:
        if (r15.hasNext() == false) goto L43;
        SummaryTodo r16 = (SummaryTodo) r15.next();     // Catch: Exception -> L52
        if (r16.getTask().length() <= 0) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L36;
        r10.add(new CallAssignmentData(r16.getTask(), 0, 0, null, 14, null));     // Catch: Exception -> L52
        goto L36
    L40:
        r17 = false;
    L43:
        CallAssignment r18 = new CallAssignment(r10);     // Catch: Exception -> L52
        SummaryAndTodo r19 = r1.getData();     // Catch: Exception -> L52
        if (r19 == null) goto L49;
        String r20 = r19.getTitle();     // Catch: Exception -> L52
        if (r20 == null) goto L49;
        String r110 = r20;
    L51:
        return new CallSummaryResult(0, null, new CallSummary(r13, r14, r18, r110, 0, 16, null), r26, r27, 3, null);
    L49:
        r110 = "";
        goto L51
    L29:
        r9 = new Pair("", r8);     // Catch: Exception -> L52
    L21:
        r4 = "";
    L52:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "model handle exception inputLen=" + r26 + " outputLen=" + r27, e);
        return new CallSummaryResult(-3, "handle model result text error!", null, 0, 0, 28, null);
    L5:
        return new CallSummaryResult(0, null, new CallSummary(r25, CollectionsKt.emptyList(), null, null, 0, 28, null), r26, r27, 3, null);
    }

    @Override // com.obric.callsummary.model.intf.ICallSummaryGenerateModel
    public synchronized CallSummaryResult generateCallSummary(Context r11, List<CallSummaryASRMessageBean> r12, boolean r13, PowerMode r14, boolean r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "context");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r12, "asrMessage");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r14, PARAMETER_KEY_POWER_MODE);     // Catch: Throwable -> L6
        CallSummaryResult r16 = (CallSummaryResult) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(r13, r14, r15, r12, this, r11, null));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r16;
    L6:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ Object getModule$suspendImpl(ABSAIKernelCallSummaryModel r0, boolean r1, Continuation<? super IBaseModel> r2) {
        return r0.getModelLoadHelper().getScriptModel(r2);
    }
}
