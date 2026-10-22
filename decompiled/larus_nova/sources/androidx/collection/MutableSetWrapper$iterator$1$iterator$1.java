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
@DebugMetadata(c = "androidx.collection.MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1188}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
public final class MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableSetWrapper<E> this$0;
    final /* synthetic */ MutableSetWrapper.AnonymousClass1 this$1;

    public MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper<E> r100, MutableSetWrapper.AnonymousClass1 r101, Continuation<? super MutableSetWrapper$iterator$1$iterator$1> r102) {
        this.this$0 = r100;
        this.this$1 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MutableSetWrapper$iterator$1$iterator$1 r102 = new MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((SequenceScope) r100, r101);
    }

    public final Object invoke(SequenceScope<? super E> r100, Continuation<? super Unit> r101) {
        return ((MutableSetWrapper$iterator$1$iterator$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0062 -> B:28:0x00d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0064 -> B:14:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00bb -> B:24:0x00bf). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        int r102 = 8;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r103 = this.I$3;
        int r104 = this.I$2;
        long r105 = this.J$0;
        int r106 = this.I$1;
        int r110 = this.I$0;
        long[] r111 = (long[]) this.L$3;
        MutableSetWrapper<E> r112 = (MutableSetWrapper) this.L$2;
        MutableSetWrapper.AnonymousClass1 r113 = (MutableSetWrapper.AnonymousClass1) this.L$1;
        SequenceScope r114 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r210);
        MutableSetWrapper$iterator$1$iterator$1<E> r107 = this;
    L24:
        SequenceScope r115 = r114;
        MutableSetWrapper.AnonymousClass1 r116 = r113;
        MutableSetWrapper<E> r117 = r112;
        MutableSetWrapper$iterator$1$iterator$1<E> r118 = r107;
        r102 = 8;
    L25:
        r105 = r105 >> r102;
        r103 = r103 + 1;
    L14:
        if (r103 < r104) goto L16;
        if (r104 != r102) goto L31;
        long[] r108 = r111;
        MutableSetWrapper$iterator$1$iterator$1<E> r119 = r118;
        MutableSetWrapper<E> r109 = r117;
        MutableSetWrapper.AnonymousClass1 r120 = r116;
        SequenceScope r121 = r115;
        int r211 = r110;
        int r122 = r106;
        int r123 = r211;
    L28:
        if (r122 == r123) goto L31;
        r122 = r122 + 1;
    L11:
        long r124 = r108[r122];
        if (((((~r124) << 7) & r124) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        r115 = r121;
        r103 = 0;
        MutableSetWrapper$iterator$1$iterator$1<E> r212 = r119;
        r111 = r108;
        r104 = 8 - ((~(r122 - r123)) >>> 31);
        r116 = r120;
        r117 = r109;
        r118 = r212;
        r105 = r124;
        int r213 = r122;
        r110 = r123;
        r106 = r213;
    L31:
        return Unit.INSTANCE;
    L16:
        if ((r105 & 255) >= 128) goto L32;
        if (1 == 0) goto L25;
        int r125 = (r106 << 3) + r103;
        r116.setCurrent(r125);
        Object r126 = MutableSetWrapper.access$getParent$p(r117).elements[r125];
        r118.L$0 = r115;
        r118.L$1 = r116;
        r118.L$2 = r117;
        r118.L$3 = r111;
        r118.I$0 = r110;
        r118.I$1 = r106;
        r118.J$0 = r105;
        r118.I$2 = r104;
        r118.I$3 = r103;
        r118.label = 1;
        if (r115.yield(r126, r118) != r100) goto L23;
        return r100;
    L23:
        r107 = r118;
        r112 = r117;
        r113 = r116;
        r114 = r115;
        goto L24
    L32:
        if (0 == 0) goto L25;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r210);
        r121 = (SequenceScope) this.L$0;
        MutableScatterSet r127 = MutableSetWrapper.access$getParent$p(this.this$0);
        r120 = this.this$1;
        r109 = this.this$0;
        r108 = r127.metadata;
        r123 = r108.length - 2;
        if (r123 < 0) goto L31;
        r119 = this;
        r122 = 0;
        goto L11
    }
}
