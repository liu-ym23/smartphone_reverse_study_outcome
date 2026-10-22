package com.bytedanceos.common.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ActorScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.common.utils.AndroidContentFlow$values$1$sequential$1", f = "ValueFlow.kt", i = {}, l = {31, 31}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidContentFlow$values$1$sequential$1 extends SuspendLambda implements Function2<ActorScope<Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<Object> $$this$callbackFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AndroidContentFlow this$0;

    public AndroidContentFlow$values$1$sequential$1(ProducerScope<Object> r10, AndroidContentFlow r11, Continuation<? super AndroidContentFlow$values$1$sequential$1> r12) {
        this.$$this$callbackFlow = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        AndroidContentFlow$values$1$sequential$1 r12 = new AndroidContentFlow$values$1$sequential$1(this.$$this$callbackFlow, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ActorScope<Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006d -> B:20:0x0070). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ProducerScope<Object> r13 = (ProducerScope) this.L$1;
        ChannelIterator r14 = (ChannelIterator) this.L$0;
        kotlin.c.b(r10);
    L20:
        r13.mo53trySendJP2dKIU(r10);
        ChannelIterator r15 = r14;
    L11:
        this.L$0 = r15;
        this.L$1 = null;
        this.label = 1;
        Object r16 = r15.hasNext(this);
        if (r16 != r11) goto L14;
        return r11;
    L14:
        r14 = r15;
        r10 = r16;
    L16:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        r14.next();
        r13 = this.$$this$callbackFlow;
        Function2 r17 = AndroidContentFlow.b(this.this$0);
        Context r18 = AndroidContentFlow.a(this.this$0);
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 2;
        r10 = r17.mo0invoke(r18, this);
        if (r10 != r11) goto L20;
        return r11;
    L22:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ChannelIterator r19 = (ChannelIterator) this.L$0;
        kotlin.c.b(r10);
        r14 = r19;
        goto L16
    L10:
        kotlin.c.b(r10);
        r15 = ((ActorScope) this.L$0).getChannel().iterator();
        goto L11
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ActorScope<Unit> r10, @Nullable Continuation<? super Unit> r11) {
        return ((AndroidContentFlow$values$1$sequential$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
