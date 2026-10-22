package com.obric.callsummary.model.aikernel;

import com.GlobalProxyLancet;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper;", "", "name", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;)V", "baseModel", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "getName", "()Ljava/lang/String;", "getParams", "()Lcom/obric/aikernel/sdk/config/RequestParams;", "getScriptModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScriptModelLoadHelper {
    public static final Companion Companion = null;
    private static final long LOAD_MODEL_TIME_OUT_SECONDS = 10;
    private static final String TAG = "ScriptModelLoadHelper";
    private IBaseModel baseModel;
    private final String name;
    private final RequestParams params;

    /* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/callsummary/model/aikernel/ScriptModelLoadHelper$Companion;", "", "()V", "LOAD_MODEL_TIME_OUT_SECONDS", "", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.model.aikernel.ScriptModelLoadHelper$getScriptModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.model.aikernel.ScriptModelLoadHelper", f = "ScriptModelLoadHelper.kt", i = {0, 1, 1, 2, 3}, l = {30, 33, 36, 41}, m = "getScriptModel", n = {"this", "this", "$this$getScriptModel_u24lambda_u241", "this", "this"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ScriptModelLoadHelper this$0;

        AnonymousClass1(ScriptModelLoadHelper r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getScriptModel(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ScriptModelLoadHelper(String r2, RequestParams r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.name = r2;
        this.params = r3;
    }

    public final String getName() {
        return this.name;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    public final Object getScriptModel(Continuation<? super IBaseModel> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r14;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r1.label;
        Object r8 = null;
        boolean r11 = true;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ScriptModelLoadHelper this = (ScriptModelLoadHelper) r1.L$2;
        PackageResource r0 = (PackageResource) r1.L$1;
        ScriptModelLoadHelper r3 = (ScriptModelLoadHelper) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L65:
        this.baseModel = (IBaseModel) r15;
    L59:
        this = r3;
    L66:
        monitor-enter(this);
        IBaseModel r16 = this.baseModel;     // Catch: Throwable -> L70
        monitor-exit(this);
        return r16;
    L70:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ScriptModelLoadHelper r13 = (ScriptModelLoadHelper) r1.L$2;
        PackageResource r4 = (PackageResource) r1.L$1;
        r3 = (ScriptModelLoadHelper) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L58:
        r13.baseModel = (IBaseModel) r15;
        goto L59
    L18:
        PackageResource r17 = (PackageResource) r1.L$2;
        PackageResource r5 = (PackageResource) r1.L$1;
        ScriptModelLoadHelper r6 = (ScriptModelLoadHelper) r1.L$0;
        ResultKt.throwOnFailure(r15);
        Object r7 = ((Result) r15).m812unboximpl();
        ScriptModelLoadHelper r18 = r6;
        PackageResource r10 = r5;
    L44:
        if (Result.m809isFailureimpl(r7) == true) goto L47;
        r8 = r7;
    L47:
        PackageResource r12 = (PackageResource) r8;
        if (r12 != null) goto L50;
    L52:
        r11 = false;
    L53:
        if (r11 == false) goto L60;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getScriptModel[" + r17.getName() + "] onReady");
        AIKernelManager r19 = AIKernelManager.INSTANCE;
        String r20 = r17.getName();
        RequestParams r21 = r18.params;
        r1.L$0 = r18;
        r1.L$1 = r10;
        r1.L$2 = r18;
        r1.label = 3;
        Object r110 = IAIKernelManager.DefaultImpls.loadPackage$default(r19, r20, false, r21, r1, 2, null);
        if (r110 != r9) goto L57;
        return r9;
    L57:
        r3 = r18;
        r15 = r110;
        r13 = r3;
        goto L58
    L60:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getScriptModel[" + r17.getName() + "] onNotReady");
        this = r18;
        goto L66
    L50:
        if (r12.isAvailable() != true) goto L52;
    L19:
        this = (ScriptModelLoadHelper) r1.L$0;
        ResultKt.throwOnFailure(r15);
        Object r111 = ((Result) r15).m812unboximpl();
    L33:
        if (Result.m809isFailureimpl(r111) == false) goto L35;
        r111 = null;
    L35:
        PackageResource r112 = (PackageResource) r111;
        if (r112 == null) goto L66;
        if (r112.isAvailable() == true) goto L61;
        AIKernelManager r22 = AIKernelManager.INSTANCE;
        r1.L$0 = this;
        r1.L$1 = r112;
        r1.L$2 = r112;
        r1.label = 2;
        r7 = IAIKernelManager.DefaultImpls.m314updatePackage0E7RQCE$default(r22, r112, null, r1, 2, null);
        if (r7 != r9) goto L42;
        return r9;
    L42:
        r10 = r112;
        r18 = this;
        r17 = r10;
        goto L44
    L61:
        AIKernelManager r23 = AIKernelManager.INSTANCE;
        String r24 = r112.getName();
        RequestParams r25 = this.params;
        r1.L$0 = this;
        r1.L$1 = r112;
        r1.L$2 = this;
        r1.label = 4;
        r15 = IAIKernelManager.DefaultImpls.loadPackage$default(r23, r24, false, r25, r1, 2, null);
        if (r15 != r9) goto L64;
        return r9;
    L64:
        r3 = this;
        goto L65
    L20:
        ResultKt.throwOnFailure(r15);
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L23:
        if (this.baseModel == null) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getScriptModel return baseModel , baseModel: " + this.baseModel);     // Catch: Throwable -> L73
        IBaseModel r113 = this.baseModel;     // Catch: Throwable -> L73
        monitor-exit(this);
        return r113;
    L27:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(this);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getScriptModel[" + this.name + "] start load script model.");
        AIKernelManager r115 = AIKernelManager.INSTANCE;
        String r26 = this.name;
        RequestParams r27 = this.params;
        r1.L$0 = this;
        r1.label = 1;
        r111 = r115.mo311getPackage0E7RQCE(r26, r27, r1);
        if (r111 != r9) goto L33;
        return r9;
    L7:
        r1 = new AnonymousClass1(this, r14);
        goto L8
    }
}
