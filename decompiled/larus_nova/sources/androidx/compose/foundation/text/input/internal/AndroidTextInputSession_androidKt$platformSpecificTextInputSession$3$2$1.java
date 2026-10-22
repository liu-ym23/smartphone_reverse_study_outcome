package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1", f = "AndroidTextInputSession.android.kt", i = {}, l = {111, 112}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ MutableSharedFlow<Unit> $it;
    int label;

    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1(MutableSharedFlow<Unit> r100, ComposeInputMethodManager r101, Continuation<? super AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1> r102) {
        this.$it = r100;
        this.$composeImm = r101;
        super(2, r102);
    }

    public static /* synthetic */ Unit a(long r100) {
        return invokeSuspend$lambda$0(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1(this.$it, this.$composeImm, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    private static final Unit invokeSuspend$lambda$0(long r100) {
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L7;
        ResultKt.throwOnFailure(r100);
    L17:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        MutableSharedFlow<Unit> r103 = this.$it;
        final ComposeInputMethodManager r104 = this.$composeImm;
        FlowCollector<? super Unit> r105 = new AnonymousClass2(r104);
        this.label = 2;
        if (r103.collect(r105, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        Function1 r106 = new f();
        this.label = 1;
        if (MonotonicFrameClockKt.withFrameMillis(r106, this) != r101) goto L13;
        return r101;
    }
}
