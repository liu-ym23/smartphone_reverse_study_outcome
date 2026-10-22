package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import android.graphics.Bitmap;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.broadcast.utils.BlackFrameDetectionUtil$isBitmapMostlyBlack$1", f = "BlackFrameDetectionUtil.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {171}, m = "invokeSuspend", n = {"$this$runBlocking", "sample", "splitLines", "partWidth", "partHeight", RXScreenCaptureService.KEY_INDEX, ce.f26395j}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "I$3", "I$5"})
final class BlackFrameDetectionUtil$isBitmapMostlyBlack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $sampleSize;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public BlackFrameDetectionUtil$isBitmapMostlyBlack$1(Bitmap r100, int r101, Continuation r102) {
        this.$bitmap = r100;
        this.$sampleSize = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r102 = new BlackFrameDetectionUtil$isBitmapMostlyBlack$1(this.$bitmap, this.$sampleSize, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((BlackFrameDetectionUtil$isBitmapMostlyBlack$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006f -> B:22:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cf -> B:27:0x00d4). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        int r102 = this.I$6;
        int r103 = this.I$5;
        int r104 = this.I$4;
        int r105 = this.I$3;
        int r106 = this.I$2;
        int r107 = this.I$1;
        int r110 = this.I$0;
        Ref.IntRef r111 = (Ref.IntRef) this.L$1;
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Exception -> L8
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r108 = this;
        int r113 = r104;
        int r109 = r106;
        int r114 = r107;
        int r115 = r110;
        Ref.IntRef r116 = r111;
        CoroutineScope r117 = r112;
        int r118 = r103;
        Object r119 = r210;
    L28:
        if (((Boolean) r119).booleanValue() == true) goto L31;
        return Boxing.boxBoolean(false);
    L31:
        int r120 = r118 + 1;
        int r121 = r113;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r122 = r108;
    L22:
        if (r120 >= r102) goto L34;
        CoroutineDispatcher r211 = Dispatchers.getDefault();     // Catch: Exception -> L8
        r108 = r122;
        int r123 = r115;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1 r212 = new BlackFrameDetectionUtil$isBitmapMostlyBlack$1$deferred$1(r122, r105, r114, r120, r109, r116, null);     // Catch: Exception -> L8
        r113 = r121;
        int r124 = r109;
        int r213 = r105;
        int r214 = r114;
        Ref.IntRef r215 = r116;
        r118 = r120;
        Deferred r125 = BuildersKt.async$default(r117, r211, null, r212, 2, null);     // Catch: Exception -> L8
        r108.L$0 = r117;     // Catch: Exception -> L8
        r108.L$1 = r215;     // Catch: Exception -> L8
        r108.I$0 = r123;     // Catch: Exception -> L8
        r108.I$1 = r214;     // Catch: Exception -> L8
        r108.I$2 = r124;     // Catch: Exception -> L8
        r108.I$3 = r213;     // Catch: Exception -> L8
        r108.I$4 = r113;     // Catch: Exception -> L8
        r108.I$5 = r118;     // Catch: Exception -> L8
        r108.I$6 = r102;     // Catch: Exception -> L8
        r108.label = 1;     // Catch: Exception -> L8
        r119 = r125.await(r108);     // Catch: Exception -> L8
        if (r119 != r100) goto L26;
        return r100;
    L26:
        r116 = r215;
        r114 = r214;
        r105 = r213;
        r109 = r124;
        r115 = r123;
        goto L28
    L34:
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r126 = r122;
        int r127 = r115;
        int r128 = r121;
        int r129 = r109;
        Ref.IntRef r130 = r116;
        int r131 = r105 + 1;
        int r132 = r127;
        Ref.IntRef r133 = r130;
        int r134 = r114;
        CoroutineScope r135 = r117;
        int r136 = r128;
        int r137 = r129;
        BlackFrameDetectionUtil$isBitmapMostlyBlack$1 r138 = r126;
    L20:
        if (r131 >= r136) goto L36;
        r115 = r132;
        r122 = r138;
        r117 = r135;
        r116 = r133;
        r121 = r136;
        r102 = r115;
        r114 = r134;
        r109 = r137;
        r105 = r131;
        r120 = 0;
        goto L22
    L36:
        return Boxing.boxBoolean(true);
    L8:
        e = move-exception;
        ALogger.e("BlackFrameDetectionUtil", "Scan Bitmap Exception: " + e);
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r210);
        r135 = (CoroutineScope) this.L$0;
        if (this.$bitmap == null) goto L15;
        r133 = new Ref.IntRef();
        r133.element = 1;
        int r139 = this.$sampleSize;
        if (r139 <= 0) goto L19;
        r133.element = r139;
    L19:
        r136 = 4;
        r134 = this.$bitmap.getWidth() / 4;
        r137 = this.$bitmap.getHeight() / 4;
        r138 = this;
        r132 = 4;
        r131 = 0;
        goto L20
    L15:
        return Boxing.boxBoolean(false);
    }
}
