package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "Lkotlinx/coroutines/Job;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {955, 957}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1451:1\n341#2,6:1452\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n957#1:1452,6\n*E\n"})
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    public JobSupport$children$1(JobSupport r10, Continuation<? super JobSupport$children$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        JobSupport$children$1 r12 = new JobSupport$children$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) this.L$2;
        kotlinx.coroutines.internal.n r14 = (kotlinx.coroutines.internal.n) this.L$1;
        kotlin.sequences.g r15 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r10);
    L27:
        r13 = r13.h();
    L21:
        if (kotlin.jvm.internal.q.b(r13, r14) == true) goto L29;
        if ((r13 instanceof s) == false) goto L27;
        ChildJob r16 = ((s) r13).f21673e;
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.label = 2;
        if (r15.a(r16, this) != r11) goto L27;
        return r11;
    L29:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.c.b(r10);
        goto L29
    L10:
        kotlin.c.b(r10);
        kotlin.sequences.g r17 = (kotlin.sequences.g) this.L$0;
        Object r18 = this.this$0.E();
        if ((r18 instanceof s) == false) goto L16;
        ChildJob r19 = ((s) r18).f21673e;
        this.label = 1;
        if (r17.a(r19, this) != r11) goto L29;
        return r11;
    L16:
        if ((r18 instanceof Incomplete) == false) goto L29;
        p1 r20 = ((Incomplete) r18).getList();
        if (r20 == null) goto L29;
        Object r21 = r20.g();
        kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r22 = (LockFreeLinkedListNode) r21;
        r15 = r17;
        r14 = r20;
        r13 = r22;
        goto L21
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
        return ((JobSupport$children$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
