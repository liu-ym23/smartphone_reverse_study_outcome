package kotlin.collections;

import com.tmall.wireless.tangram.structure.card.StaggeredCard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/sequences/g;", "", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", StaggeredCard.StaggeredStyle.KEY_GAP, "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator<Object> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public SlidingWindowKt$windowedIterator$1(int r10, int r11, Iterator<Object> r12, boolean r13, boolean r14, Continuation<? super SlidingWindowKt$windowedIterator$1> r15) {
        this.$size = r10;
        this.$step = r11;
        this.$iterator = r12;
        this.$reuseBuffer = r13;
        this.$partialWindows = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SlidingWindowKt$windowedIterator$1 r12 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0117 -> B:59:0x011a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:72:0x0148). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L17;
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L13;
        if (r12 == 4) goto L12;
        if (r12 == 5) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        p0 r13 = (p0) this.L$1;
        kotlin.sequences.g r14 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r11);
    L72:
        r13.g(this.$step);
    L64:
        if (r13.size() <= this.$step) goto L74;
        if (this.$reuseBuffer == false) goto L68;
        Object r15 = r13;
    L69:
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = null;
        this.label = 4;
        if (r14.a(r15, this) != r10) goto L72;
        return r10;
    L68:
        r15 = new ArrayList(r13);
        goto L69
    L74:
        if (r13.isEmpty() == true) goto L79;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 5;
        if (r14.a(r13, this) != r10) goto L79;
        return r10;
    L79:
        return Unit.f21064a;
    L13:
        Iterator<Object> r16 = (Iterator) this.L$2;
        p0 r17 = (p0) this.L$1;
        kotlin.sequences.g r18 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r11);
    L59:
        r17.g(this.$step);
    L46:
        if (r16.hasNext() == false) goto L61;
        r17.d(r16.next());
        if (r17.f() == false) goto L46;
        int r19 = r17.size();
        int r20 = this.$size;
        if (r19 >= r20) goto L53;
        r17 = r17.e(r20);
        goto L46
    L53:
        if (this.$reuseBuffer == false) goto L55;
        Object r110 = r17;
    L56:
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r16;
        this.label = 3;
        if (r18.a(r110, this) != r10) goto L59;
        return r10;
    L55:
        r110 = new ArrayList(r17);
        goto L56
    L61:
        if (this.$partialWindows == false) goto L79;
        r13 = r17;
        r14 = r18;
    L14:
        kotlin.c.b(r11);
        goto L79
    L15:
        int r21 = this.I$0;
        Iterator<Object> r22 = (Iterator) this.L$2;
        ArrayList r23 = (ArrayList) this.L$1;
        kotlin.sequences.g r24 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r11);
    L16:
        int r111 = r21;
        if (this.$reuseBuffer == false) goto L33;
        r23.clear();
    L34:
        r21 = r111;
    L21:
        if (r22.hasNext() == false) goto L36;
        Object r25 = r22.next();
        if (r111 > 0) goto L24;
        r23.add(r25);
        if (r23.size() != this.$size) goto L21;
        this.L$0 = r24;
        this.L$1 = r23;
        this.L$2 = r22;
        this.I$0 = r21;
        this.label = 1;
        if (r24.a(r23, this) != r10) goto L16;
        return r10;
    L24:
        r111 = r111 - 1;
        goto L21
    L36:
        if (r23.isEmpty() == true) goto L79;
        if (this.$partialWindows == false) goto L40;
    L41:
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (r24.a(r23, this) != r10) goto L79;
        return r10;
    L40:
        if (r23.size() != this.$size) goto L79;
    L33:
        r23 = new ArrayList(this.$size);
        goto L34
    L17:
        kotlin.c.b(r11);
        kotlin.sequences.g r112 = (kotlin.sequences.g) this.L$0;
        int r26 = bg.h.g(this.$size, 1024);
        int r27 = this.$step - this.$size;
        if (r27 < 0) goto L44;
        r24 = r112;
        r111 = 0;
        r23 = new ArrayList(r26);
        r22 = this.$iterator;
        r21 = r27;
        goto L21
    L44:
        r17 = new p0(r26);
        r16 = this.$iterator;
        r18 = r112;
        goto L46
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SlidingWindowKt$windowedIterator$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
