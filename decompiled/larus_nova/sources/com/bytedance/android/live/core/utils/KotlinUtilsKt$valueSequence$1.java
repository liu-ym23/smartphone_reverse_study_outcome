package com.bytedance.android.live.core.utils;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.utils.KotlinUtilsKt$valueSequence$1", f = "KotlinUtils.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0"})
final class KotlinUtilsKt$valueSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SparseArray $this_valueSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public KotlinUtilsKt$valueSequence$1(SparseArray r100, Continuation r101) {
        this.$this_valueSequence = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        KotlinUtilsKt$valueSequence$1 r102 = new KotlinUtilsKt$valueSequence$1(this.$this_valueSequence, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<Object> r100, Continuation<? super Unit> r101) {
        return ((KotlinUtilsKt$valueSequence$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0044 -> B:13:0x0047). Please report as a decompilation issue!!! */
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
        KotlinUtilsKt$valueSequence$1 r106 = this;
    L13:
        r104 = r104 + 1;
    L9:
        if (r104 >= r103) goto L15;
        Object r107 = r106.$this_valueSequence.valueAt(r104);
        r106.L$0 = r105;
        r106.I$0 = r104;
        r106.I$1 = r103;
        r106.label = 1;
        if (r105.yield(r107, r106) != r101) goto L13;
        return r101;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SequenceScope r108 = (SequenceScope) this.L$0;
        r103 = this.$this_valueSequence.size();
        r104 = 0;
        r105 = r108;
        r106 = this;
        goto L9
    }
}
