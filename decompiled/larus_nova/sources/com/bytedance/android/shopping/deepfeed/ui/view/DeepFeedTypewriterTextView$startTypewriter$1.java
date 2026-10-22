package com.bytedance.android.shopping.deepfeed.ui.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView$startTypewriter$1", f = "DeepFeedTypewriterTextView.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {RXScreenCaptureService.KEY_INDEX}, s = {"I$0"})
final class DeepFeedTypewriterTextView$startTypewriter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $boldEnd;
    final /* synthetic */ int $boldStart;
    final /* synthetic */ long $charDelay;
    final /* synthetic */ String $cursor;
    final /* synthetic */ String $fullText;
    final /* synthetic */ Function0 $onFinish;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ DeepFeedTypewriterTextView this$0;

    public DeepFeedTypewriterTextView$startTypewriter$1(DeepFeedTypewriterTextView r100, String r101, int r102, int r103, String r104, long r105, Function0 r106, Continuation r107) {
        this.this$0 = r100;
        this.$fullText = r101;
        this.$boldStart = r102;
        this.$boldEnd = r103;
        this.$cursor = r104;
        this.$charDelay = r105;
        this.$onFinish = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        Intrinsics.checkNotNullParameter(r111, "completion");
        return new DeepFeedTypewriterTextView$startTypewriter$1(this.this$0, this.$fullText, this.$boldStart, this.$boldEnd, this.$cursor, this.$charDelay, this.$onFinish, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DeepFeedTypewriterTextView$startTypewriter$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0050 -> B:16:0x0053). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$1;
        int r103 = this.I$0;
        ResultKt.throwOnFailure(r110);
        DeepFeedTypewriterTextView$startTypewriter$1 r111 = this;
    L16:
        if (r103 == r102) goto L21;
        r103 = r103 + 1;
    L11:
        DeepFeedTypewriterTextView r112 = r111.this$0;
        String r104 = r111.$fullText;
        if (r104 == null) goto L19;
        r112.setText(DeepFeedTypewriterTextView.x(r112, r104.substring(0, r103), r111.$boldStart, r111.$boldEnd, r111.$cursor, true));
        long r105 = r111.$charDelay;
        r111.I$0 = r103;
        r111.I$1 = r102;
        r111.label = 1;
        if (DelayKt.delay(r105, r111) != r100) goto L16;
        return r100;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        DeepFeedTypewriterTextView r106 = r111.this$0;
        r106.setText(DeepFeedTypewriterTextView.x(r106, r111.$fullText, r111.$boldStart, r111.$boldEnd, r111.$cursor, false));
        Function0 r113 = r111.$onFinish;
        if (r113 == null) goto L25;
        Unit r114 = (Unit) r113.invoke();
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        int r115 = this.$fullText.length();
        if (1 > r115) goto L20;
        r103 = 1;
        r102 = r115;
        r111 = this;
        goto L11
    L20:
        r111 = this;
        goto L21
    }
}
