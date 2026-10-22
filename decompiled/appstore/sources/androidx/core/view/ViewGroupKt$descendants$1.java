package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "Landroid/view/View;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {119, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ViewGroupKt$descendants$1(ViewGroup r10, Continuation<? super ViewGroupKt$descendants$1> r11) {
        this.$this_descendants = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ViewGroupKt$descendants$1 r12 = new ViewGroupKt$descendants$1(this.$this_descendants, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:22:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0092 -> B:24:0x0094). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        int r13 = this.I$1;
        int r14 = this.I$0;
        ViewGroup r15 = (ViewGroup) this.L$1;
        kotlin.sequences.g r16 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r10);
    L22:
        kotlin.sequences.g r17 = r16;
        ViewGroup r18 = r15;
        int r19 = r13;
        ViewGroup r20 = r18;
    L24:
        int r21 = r19;
        int r22 = r14 + 1;
        int r23 = r21;
    L11:
        if (r22 >= r23) goto L26;
        View r24 = r20.getChildAt(r22);
        kotlin.jvm.internal.q.f(r24, "getChildAt(index)");
        this.L$0 = r17;
        this.L$1 = r20;
        this.L$2 = r24;
        this.I$0 = r22;
        this.I$1 = r23;
        this.label = 1;
        if (r17.a(r24, this) != r11) goto L15;
        return r11;
    L15:
        ViewGroup r25 = r20;
        r13 = r23;
        r14 = r22;
        View r26 = r24;
    L17:
        if ((r26 instanceof ViewGroup) == false) goto L23;
        Sequence r27 = ViewGroupKt.b((ViewGroup) r26);
        this.L$0 = r17;
        this.L$1 = r25;
        this.L$2 = null;
        this.I$0 = r14;
        this.I$1 = r13;
        this.label = 2;
        if (r17.c(r27, this) != r11) goto L21;
        return r11;
    L21:
        r15 = r25;
        r16 = r17;
        goto L22
    L23:
        r19 = r13;
        r20 = r25;
        goto L24
    L26:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r13 = this.I$1;
        r14 = this.I$0;
        r26 = (View) this.L$2;
        r25 = (ViewGroup) this.L$1;
        kotlin.sequences.g r28 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r10);
        r17 = r28;
        goto L17
    L10:
        kotlin.c.b(r10);
        r17 = (kotlin.sequences.g) this.L$0;
        r20 = this.$this_descendants;
        r23 = r20.getChildCount();
        r22 = 0;
        goto L11
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
        return ((ViewGroupKt$descendants$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
