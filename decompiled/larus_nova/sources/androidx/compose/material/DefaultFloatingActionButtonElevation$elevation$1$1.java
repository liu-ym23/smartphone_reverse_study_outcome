package androidx.compose.material;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1$1", f = "FloatingActionButton.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultFloatingActionButtonElevation$elevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
    int label;
    final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

    public DefaultFloatingActionButtonElevation$elevation$1$1(FloatingActionButtonElevationAnimatable r100, DefaultFloatingActionButtonElevation r101, Continuation<? super DefaultFloatingActionButtonElevation$elevation$1$1> r102) {
        this.$animatable = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DefaultFloatingActionButtonElevation$elevation$1$1(this.$animatable, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DefaultFloatingActionButtonElevation$elevation$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FloatingActionButtonElevationAnimatable r103 = this.$animatable;
        float r104 = DefaultFloatingActionButtonElevation.access$getDefaultElevation$p(this.this$0);
        float r105 = DefaultFloatingActionButtonElevation.access$getPressedElevation$p(this.this$0);
        float r106 = DefaultFloatingActionButtonElevation.access$getHoveredElevation$p(this.this$0);
        float r107 = DefaultFloatingActionButtonElevation.access$getFocusedElevation$p(this.this$0);
        this.label = 1;
        if (r103.m1663updateElevationlDy3nrA(r104, r105, r106, r107, this) != r101) goto L12;
        return r101;
    }
}
