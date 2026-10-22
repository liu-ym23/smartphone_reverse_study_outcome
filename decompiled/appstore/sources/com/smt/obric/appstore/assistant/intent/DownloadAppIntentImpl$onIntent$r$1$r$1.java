package com.smt.obric.appstore.assistant.intent;

import com.bytedanceos.common.toolbox.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/f;", "Lcom/smt/obric/appstore/assistant/intent/b;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/f;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl$onIntent$r$1$r$1", f = "DownloadAppIntentImpl.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadAppIntentImpl$onIntent$r$1$r$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f>, Object> {
    final /* synthetic */ ReceiveChannel<b> $resultCh;
    final /* synthetic */ Ref$ObjectRef<String> $sessionId;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadAppIntentImpl$onIntent$r$1$r$1(Ref$ObjectRef<String> r10, ReceiveChannel<? extends b> r11, Continuation<? super DownloadAppIntentImpl$onIntent$r$1$r$1> r12) {
        this.$sessionId = r10;
        this.$resultCh = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new DownloadAppIntentImpl$onIntent$r$1$r$1(this.$sessionId, this.$resultCh, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super f> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        c.b(r10);
        Object r13 = ((f) r10).l();
    L12:
        return f.b(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.b(r10);
        j.o("[AI_Intent] [DownloadApp] waiting result, sid=" + this.$sessionId.element);
        ReceiveChannel<b> r14 = this.$resultCh;
        this.label = 1;
        r13 = r14.mo51receiveCatchingJP2dKIU(this);
        if (r13 != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super f> r11) {
        return ((DownloadAppIntentImpl$onIntent$r$1$r$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
