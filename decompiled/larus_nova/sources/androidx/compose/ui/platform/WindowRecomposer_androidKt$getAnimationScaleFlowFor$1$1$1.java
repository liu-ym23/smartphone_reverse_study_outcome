package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", i = {0, 1}, l = {118, 125}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Channel<Unit> $channel;
    final /* synthetic */ WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver r100, Uri r101, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 r102, Channel<Unit> r103, Context r104, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> r105) {
        this.$resolver = r100;
        this.$animationScaleUri = r101;
        this.$contentObserver = r102;
        this.$channel = r103;
        this.$applicationContext = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 r101 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Float> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Float> r100, Continuation<? super Unit> r101) {
        return ((WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0083 -> B:36:0x0049). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L11;
        if (r101 != 2) goto L10;
        ChannelIterator<Unit> r102 = (ChannelIterator) this.L$1;
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L31
        FlowCollector r111 = r103;
    L16:
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 r104 = this;
    L36:
        r104.L$0 = r111;     // Catch: Throwable -> L29
        r104.L$1 = r102;     // Catch: Throwable -> L29
        r104.label = 1;     // Catch: Throwable -> L29
        Object r105 = r102.hasNext(r104);     // Catch: Throwable -> L29
        if (r105 != r100) goto L20;
        return r100;
    L20:
        FlowCollector r106 = r111;
        r110 = r105;
    L22:
        if (((Boolean) r110).booleanValue() == false) goto L27;
        r102.next();     // Catch: Throwable -> L29
        Float r112 = Boxing.boxFloat(Settings.Global.getFloat(r104.$applicationContext.getContentResolver(), "animator_duration_scale", 1.0f));     // Catch: Throwable -> L29
        r104.L$0 = r106;     // Catch: Throwable -> L29
        r104.L$1 = r102;     // Catch: Throwable -> L29
        r104.label = 2;     // Catch: Throwable -> L29
        if (r106.emit(r112, r104) != r100) goto L26;
        return r100;
    L26:
        r111 = r106;
        goto L36
    L27:
        r104.$resolver.unregisterContentObserver(r104.$contentObserver);
        return Unit.INSTANCE;
    L29:
        th = th;
    L33:
        r104.$resolver.unregisterContentObserver(r104.$contentObserver);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r102 = (ChannelIterator) this.L$1;
        FlowCollector r107 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L31
        r106 = r107;
        r104 = this;
        goto L22
    L14:
        ResultKt.throwOnFailure(r110);
        r111 = (FlowCollector) this.L$0;
        this.$resolver.registerContentObserver(this.$animationScaleUri, false, this.$contentObserver);
        r102 = this.$channel.iterator();     // Catch: Throwable -> L31
    L31:
        th = th;
        r104 = this;
        goto L33
    }
}
