package com.obric.callsummary.model.aikernel;

import android.content.Context;
import com.GlobalProxyLancet;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AIKernelCallSummaryModelLocal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002JB\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0014J\u001b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$R\u001b\u0010\u0003\u001a\u00020\u00048TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModelLocal;", "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel;", "()V", "modelLoadHelper", "Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "getModelLoadHelper", "()Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "modelLoadHelper$delegate", "Lkotlin/Lazy;", "modelLoadHelperSimplify", "getModelLoadHelperSimplify", "modelLoadHelperSimplify$delegate", "modelLoadHelperSummaryTodo", "getModelLoadHelperSummaryTodo", "modelLoadHelperSummaryTodo$delegate", "generateCallSummaryCleanup", "", "context", "Landroid/content/Context;", "parameter", "Lorg/json/JSONObject;", "generateContentString", "", "asrMessage", "", "Lcom/obric/contactprovider/bean/CallSummaryASRMessageBean;", "generateModelParameter", "Lkotlin/Pair;", "", "isSimplify", "", ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, "Lcom/obric/callsummary/model/aikernel/ABSAIKernelCallSummaryModel$PowerMode;", "isRetry", "getModule", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AIKernelCallSummaryModelLocal extends ABSAIKernelCallSummaryModel {
    private static final int ASR_TEXT_MAX_SIZE = 4000;
    public static final Companion Companion = null;
    private static final String PARAMETER_KEY_CONTENT = "content";
    public static final String PARAMETER_KEY_FORCEEXECUTE = "_ForceExecute";
    public static final String PARAMETER_KEY_PRIORITY = "_Priority";
    private static final String TAG = "AIKernelCallSummaryModelLocal";
    private final Lazy modelLoadHelper$delegate;
    private final Lazy modelLoadHelperSimplify$delegate;
    private final Lazy modelLoadHelperSummaryTodo$delegate;

    /* JADX INFO: compiled from: AIKernelCallSummaryModelLocal.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AIKernelCallSummaryModelLocal$Companion;", "", "()V", "ASR_TEXT_MAX_SIZE", "", "PARAMETER_KEY_CONTENT", "", "PARAMETER_KEY_FORCEEXECUTE", "PARAMETER_KEY_PRIORITY", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected void generateCallSummaryCleanup(Context r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "parameter");
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    public Object getModule(boolean r1, Continuation<? super IBaseModel> r2) {
        return getModule$suspendImpl(this, r1, r2);
    }

    public static final /* synthetic */ ScriptModelLoadHelper access$getModelLoadHelperSummaryTodo(AIKernelCallSummaryModelLocal r0) {
        return r0.getModelLoadHelperSummaryTodo();
    }

    public AIKernelCallSummaryModelLocal() {
        this.modelLoadHelperSummaryTodo$delegate = LazyKt.lazy(AIKernelCallSummaryModelLocal$modelLoadHelperSummaryTodo$2.INSTANCE);
        this.modelLoadHelperSimplify$delegate = LazyKt.lazy(AIKernelCallSummaryModelLocal$modelLoadHelperSimplify$2.INSTANCE);
        this.modelLoadHelper$delegate = LazyKt.lazy(new AIKernelCallSummaryModelLocal$modelLoadHelper$2(this));
    }

    private final ScriptModelLoadHelper getModelLoadHelperSummaryTodo() {
        return (ScriptModelLoadHelper) this.modelLoadHelperSummaryTodo$delegate.getValue();
    }

    private final ScriptModelLoadHelper getModelLoadHelperSimplify() {
        return (ScriptModelLoadHelper) this.modelLoadHelperSimplify$delegate.getValue();
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected ScriptModelLoadHelper getModelLoadHelper() {
        return (ScriptModelLoadHelper) this.modelLoadHelper$delegate.getValue();
    }

    static /* synthetic */ Object getModule$suspendImpl(AIKernelCallSummaryModelLocal r0, boolean r1, Continuation<? super IBaseModel> r2) {
        if (r1 == false) goto L4;
        ScriptModelLoadHelper r3 = r0.getModelLoadHelperSimplify();
    L6:
        return r3.getScriptModel(r2);
    L4:
        r3 = r0.getModelLoadHelperSummaryTodo();
        goto L6
    }

    @Override // com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel
    protected Pair<JSONObject, Integer> generateModelParameter(Context r2, List<CallSummaryASRMessageBean> r3, boolean r4, ABSAIKernelCallSummaryModel.PowerMode r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "asrMessage");
        Intrinsics.checkNotNullParameter(r5, ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE);
        String r1 = generateContentString(r3);
        JSONObject r7 = new JSONObject();
        if (r4 == false) goto L5;
        r7.put("loraType", ABSAIKernelCallSummaryModel.PARAMETER_VALUE_LORA_TYPE_SIMPLIFY);
    L6:
        r7.put("content", r1);
        r7.put(ABSAIKernelCallSummaryModel.PARAMETER_KEY_POWER_MODE, r5.getValue());
        r7.put("_Priority", 1);
        if (r6 == false) goto L10;
        r7.put("_ForceExecute", 1);
    L10:
        return new Pair(r7, Integer.valueOf(r1.length()));
    L5:
        r7.put("loraType", ABSAIKernelCallSummaryModel.PARAMETER_VALUE_LORA_TYPE_SUMMARY_TODO);
        goto L6
    }

    private final String generateContentString(List<CallSummaryASRMessageBean> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<CallSummaryASRMessageBean> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        CallSummaryASRMessageBean r0 = r5.next();
        if (r3.length() >= ASR_TEXT_MAX_SIZE) goto L7;
        r3.append(r0.getName() + ": " + r0.getAsrText() + '\n');
        goto L4
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "asr text is too long, length is " + r3.length() + ", max is 4000");
    L9:
        String r6 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "sb.toString()");
        return r6;
    }
}
