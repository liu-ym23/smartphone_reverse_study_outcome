package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.bytedance.android.live.profit.vote.ui.VoteTextMapper$getComposedVoteText$seq$1", f = "VoteTextMapper.kt", i = {0, 0}, l = {87}, m = "invokeSuspend", n = {"$this$sequence", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0"})
final class VoteTextMapper$getComposedVoteText$seq$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $nCodePoints;
    final /* synthetic */ String $rawText;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public VoteTextMapper$getComposedVoteText$seq$1(int r100, String r101, Continuation r102) {
        this.$nCodePoints = r100;
        this.$rawText = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        VoteTextMapper$getComposedVoteText$seq$1 r102 = new VoteTextMapper$getComposedVoteText$seq$1(this.$nCodePoints, this.$rawText, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Integer> r100, Continuation<? super Unit> r101) {
        return ((VoteTextMapper$getComposedVoteText$seq$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0046 -> B:15:0x0049). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        int r103 = this.I$1;
        int r104 = this.I$0;
        SequenceScope r105 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        VoteTextMapper$getComposedVoteText$seq$1 r106 = this;
    L15:
        r104 = r104 + 1;
    L9:
        if (r104 >= r103) goto L19;
        String r107 = r106.$rawText;
        if (r107 == null) goto L17;
        Integer r108 = Boxing.boxInt(r107.codePointAt(r104));
        r106.L$0 = r105;
        r106.I$0 = r104;
        r106.I$1 = r103;
        r106.label = 1;
        if (r105.yield(r108, r106) != r101) goto L15;
        return r101;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SequenceScope r109 = (SequenceScope) this.L$0;
        r103 = this.$nCodePoints;
        r104 = 0;
        r105 = r109;
        r106 = this;
        goto L9
    }
}
