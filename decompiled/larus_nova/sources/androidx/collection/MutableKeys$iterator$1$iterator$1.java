package androidx.collection;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableKeys$iterator$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1626}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0", "I$2", "I$3"})
public final class MutableKeys$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableKeys<K, V> this$0;

    public MutableKeys$iterator$1$iterator$1(MutableKeys<K, V> r100, Continuation<? super MutableKeys$iterator$1$iterator$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MutableKeys$iterator$1$iterator$1 r102 = new MutableKeys$iterator$1$iterator$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Integer> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super Integer> r100, Continuation<? super Unit> r101) {
        return ((MutableKeys$iterator$1$iterator$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0056 -> B:28:0x00af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0058 -> B:14:0x006d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009b -> B:24:0x00a0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$3;
        int r103 = this.I$2;
        long r104 = this.J$0;
        int r105 = this.I$1;
        int r110 = this.I$0;
        long[] r111 = (long[]) this.L$1;
        SequenceScope r112 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r210);
        SequenceScope r113 = r112;
        long[] r114 = r111;
        MutableKeys$iterator$1$iterator$1 r115 = this;
    L24:
        MutableKeys$iterator$1$iterator$1 r116 = r115;
        int r117 = r110;
        MutableKeys$iterator$1$iterator$1 r118 = r116;
    L25:
        r104 = r104 >> 8;
        r102 = r102 + 1;
    L14:
        if (r102 < r103) goto L16;
        if (r103 != 8) goto L31;
        int r106 = r105;
        MutableKeys$iterator$1$iterator$1 r107 = r118;
        int r108 = r117;
        long[] r109 = r114;
        SequenceScope r119 = r113;
    L28:
        if (r106 == r108) goto L31;
        r106 = r106 + 1;
    L11:
        long r120 = r109[r106];
        if (((((~r120) << 7) & r120) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        r113 = r119;
        r102 = 0;
        r114 = r109;
        r103 = 8 - ((~(r106 - r108)) >>> 31);
        r117 = r108;
        r118 = r107;
        r105 = r106;
        r104 = r120;
    L31:
        return Unit.INSTANCE;
    L16:
        if ((255 & r104) >= 128) goto L32;
        if (1 == 0) goto L25;
        Integer r121 = Boxing.boxInt((r105 << 3) + r102);
        r118.L$0 = r113;
        r118.L$1 = r114;
        r118.I$0 = r117;
        r118.I$1 = r105;
        r118.J$0 = r104;
        r118.I$2 = r103;
        r118.I$3 = r102;
        r118.label = 1;
        if (r113.yield(r121, r118) != r100) goto L23;
        return r100;
    L23:
        int r122 = r117;
        r115 = r118;
        r110 = r122;
        goto L24
    L32:
        if (0 == 0) goto L25;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r210);
        r119 = (SequenceScope) this.L$0;
        r109 = MutableKeys.access$getParent$p(this.this$0).metadata;
        r108 = r109.length - 2;
        if (r108 < 0) goto L31;
        r107 = this;
        r106 = 0;
        goto L11
    }
}
