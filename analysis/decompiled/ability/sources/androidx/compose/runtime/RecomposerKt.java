package androidx.compose.runtime;

import C7.r;
import S7.n;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\n\"\u0019\u0010\u0010\u001a\u00060\fj\u0002`\r8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"R", "Lkotlin/Function3;", "Lm9/z;", "Landroidx/compose/runtime/Recomposer;", "LH7/c;", "", "block", "withRunningRecomposer", "(LS7/o;LH7/c;)Ljava/lang/Object;", "ProduceAnotherFrame", "Ljava/lang/Object;", "FramePending", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getRecomposerCompoundHashKey", "()J", "RecomposerCompoundHashKey", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecomposerKt {
    private static final Object ProduceAnotherFrame = new Object();
    private static final Object FramePending = new Object();

    @J7.c(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", f = "Recomposer.kt", l = {98, 100}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ o $block;
        private /* synthetic */ Object L$0;
        int label;

        @J7.c(c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1", f = "Recomposer.kt", l = {97}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ Recomposer $recomposer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Recomposer recomposer, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$recomposer = recomposer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$recomposer, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    Recomposer recomposer = this.$recomposer;
                    this.label = 1;
                    if (recomposer.runRecomposeAndApplyChanges(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(o oVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$block = oVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Recomposer recomposer;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                recomposer = new Recomposer(interfaceC1733z.getCoroutineContext());
                AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(recomposer, null), 3);
                o oVar = this.$block;
                this.L$0 = recomposer;
                this.label = 1;
                obj = oVar.invoke(interfaceC1733z, recomposer, this);
                if (obj != coroutineSingletons) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = this.L$0;
                kotlin.b.b(obj);
                return obj2;
            }
            recomposer = (Recomposer) this.L$0;
            kotlin.b.b(obj);
            recomposer.close();
            this.L$0 = obj;
            this.label = 2;
            return recomposer.join(this) == coroutineSingletons ? coroutineSingletons : obj;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private static final long getRecomposerCompoundHashKey() {
        return 1000;
    }

    public static final <R> Object withRunningRecomposer(o oVar, H7.c<? super R> cVar) {
        return AbstractC1683A.f(new AnonymousClass2(oVar, null), cVar);
    }
}
