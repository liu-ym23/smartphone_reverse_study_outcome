package com.smt.obric.appstore.assistant.intent;

import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemDownloadAppParams;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl$doAction$result$1$newDeferred$1", f = "DownloadAppIntentImpl.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadAppIntentImpl$doAction$result$1$newDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<AppInfoEntity[]>>, Object> {
    final /* synthetic */ DispatchContext $dispatchContext;
    final /* synthetic */ SystemDownloadAppParams $params;
    int label;
    final /* synthetic */ DownloadAppIntentImpl this$0;

    public DownloadAppIntentImpl$doAction$result$1$newDeferred$1(DownloadAppIntentImpl r10, SystemDownloadAppParams r11, DispatchContext r12, Continuation<? super DownloadAppIntentImpl$doAction$result$1$newDeferred$1> r13) {
        this.this$0 = r10;
        this.$params = r11;
        this.$dispatchContext = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new DownloadAppIntentImpl$doAction$result$1$newDeferred$1(this.this$0, this.$params, this.$dispatchContext, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super IntentResult<AppInfoEntity[]>> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        c.b(r14);     // Catch: Exception -> L7
    L15:
        return (IntentResult) r14;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        c.b(r14);
        DownloadAppIntentImpl r15 = this.this$0;     // Catch: Exception -> L7
        SystemDownloadAppParams r12 = this.$params;     // Catch: Exception -> L7
        DispatchContext r13 = this.$dispatchContext;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        r14 = DownloadAppIntentImpl.access$onIntent(r15, r12, r13, this);     // Catch: Exception -> L7
        if (r14 != r10) goto L15;
        return r10;
    L7:
        e = move-exception;
        j.q("[AI_Intent] [DownloadApp] doAction err, appName=" + this.$params.getAppName(), e);
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super IntentResult<AppInfoEntity[]>> r11) {
        return ((DownloadAppIntentImpl$doAction$result$1$newDeferred$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
