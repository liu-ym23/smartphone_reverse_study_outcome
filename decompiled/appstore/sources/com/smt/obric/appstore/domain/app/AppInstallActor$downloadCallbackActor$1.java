package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ActorScope;", "Lcom/smt/obric/appstore/domain/app/AppInstallActor$b$b;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/ActorScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor$downloadCallbackActor$1", f = "AppInstallActor.kt", i = {}, l = {955, 956}, m = "invokeSuspend", n = {}, s = {})
public final class AppInstallActor$downloadCallbackActor$1 extends SuspendLambda implements Function2<ActorScope<AppInstallActor.b.AbstractC0215b>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$downloadCallbackActor$1(AppInstallActor r10, Continuation<? super AppInstallActor$downloadCallbackActor$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AppInstallActor$downloadCallbackActor$1 r12 = new AppInstallActor$downloadCallbackActor$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ActorScope<AppInstallActor.b.AbstractC0215b> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0060 -> B:7:0x0015). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        ChannelIterator r13 = (ChannelIterator) this.L$0;
        kotlin.c.b(r10);
    L7:
        ChannelIterator r14 = r13;
    L12:
        this.L$0 = r14;
        this.label = 1;
        Object r15 = r14.hasNext(this);
        if (r15 != r11) goto L15;
        return r11;
    L15:
        r13 = r14;
        r10 = r15;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        AppInstallActor.b.AbstractC0215b r16 = (AppInstallActor.b.AbstractC0215b) r13.next();
        AppInstallActor r17 = this.this$0;
        SendChannel r18 = r17.T();
        this.L$0 = r13;
        this.label = 2;
        if (AppInstallActor.E(r17, r16, r18, this) != r11) goto L7;
        return r11;
    L22:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = (ChannelIterator) this.L$0;
        kotlin.c.b(r10);
        goto L17
    L11:
        kotlin.c.b(r10);
        r14 = ((ActorScope) this.L$0).getChannel().iterator();
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ActorScope<AppInstallActor.b.AbstractC0215b> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AppInstallActor$downloadCallbackActor$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
