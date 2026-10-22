package com.smt.obric.appstore.domain.app;

import com.bytedance.apm.constant.PerfTraceConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$installRetryTicker$1", f = "AppInstallActor.kt", i = {}, l = {454, 456}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$installRetryTicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<AppInstallActor.b> $actorMailbox;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AppInstallActor$installRetryTicker$1(SendChannel<? super AppInstallActor.b> r10, Continuation<? super AppInstallActor$installRetryTicker$1> r11) {
        this.$actorMailbox = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$installRetryTicker$1 r12 = new AppInstallActor$installRetryTicker$1(this.$actorMailbox, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:7:0x0015). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        ChannelIterator r12 = (ChannelIterator) this.L$0;
        kotlin.c.b(r14);
    L7:
        ChannelIterator r15 = r12;
    L12:
        this.L$0 = r15;
        this.label = 1;
        Object r13 = r15.hasNext(this);
        if (r13 != r10) goto L15;
        return r10;
    L15:
        r12 = r15;
        r14 = r13;
    L17:
        if (((Boolean) r14).booleanValue() == false) goto L22;
        r12.next();
        SendChannel<AppInstallActor.b> r16 = this.$actorMailbox;
        AppInstallActor.b.s r17 = AppInstallActor.b.s.f17937a;
        this.L$0 = r12;
        this.label = 2;
        if (r16.send(r17, this) != r10) goto L7;
        return r10;
    L22:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r12 = (ChannelIterator) this.L$0;
        kotlin.c.b(r14);
        goto L17
    L11:
        kotlin.c.b(r14);
        r15 = TickerChannelsKt.f(PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS, 0, ((CoroutineScope) this.L$0).getCoroutineContext(), null, 8, null).iterator();
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$installRetryTicker$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
