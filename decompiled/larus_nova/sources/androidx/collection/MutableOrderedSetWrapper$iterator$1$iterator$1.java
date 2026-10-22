package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1", f = "OrderedScatterSet.kt", i = {0, 0, 0}, l = {1489}, m = "invokeSuspend", n = {"$this$iterator", "nodes$iv", "previousNode$iv"}, s = {"L$0", "L$3", "I$0"})
public final class MutableOrderedSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableOrderedSetWrapper<E> this$0;
    final /* synthetic */ MutableOrderedSetWrapper.AnonymousClass1 this$1;

    public MutableOrderedSetWrapper$iterator$1$iterator$1(MutableOrderedSetWrapper<E> r100, MutableOrderedSetWrapper.AnonymousClass1 r101, Continuation<? super MutableOrderedSetWrapper$iterator$1$iterator$1> r102) {
        this.this$0 = r100;
        this.this$1 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MutableOrderedSetWrapper$iterator$1$iterator$1 r102 = new MutableOrderedSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((SequenceScope) r100, r101);
    }

    public final Object invoke(SequenceScope<? super E> r100, Continuation<? super Unit> r101) {
        return ((MutableOrderedSetWrapper$iterator$1$iterator$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$0;
        long[] r103 = (long[]) this.L$3;
        MutableOrderedSetWrapper<E> r104 = (MutableOrderedSetWrapper) this.L$2;
        MutableOrderedSetWrapper.AnonymousClass1 r105 = (MutableOrderedSetWrapper.AnonymousClass1) this.L$1;
        SequenceScope r106 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r110);
    L10:
        if (r102 == Integer.MAX_VALUE) goto L16;
        int r107 = (int) ((r103[r102] >> 31) & SieveCacheKt.NodeLinkMask);
        r105.setCurrent(r102);
        Object r108 = MutableOrderedSetWrapper.access$getParent$p(r104).elements[r102];
        this.L$0 = r106;
        this.L$1 = r105;
        this.L$2 = r104;
        this.L$3 = r103;
        this.I$0 = r107;
        this.label = 1;
        if (r106.yield(r108, this) == r100) goto L13;
        r102 = r107;
        goto L10
    L13:
        return r100;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        SequenceScope r111 = (SequenceScope) this.L$0;
        MutableOrderedScatterSet r109 = MutableOrderedSetWrapper.access$getParent$p(this.this$0);
        MutableOrderedSetWrapper.AnonymousClass1 r112 = this.this$1;
        r104 = this.this$0;
        long[] r113 = r109.nodes;
        r102 = r109.tail;
        r106 = r111;
        r105 = r112;
        r103 = r113;
        goto L10
    }
}
