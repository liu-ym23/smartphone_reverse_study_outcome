package android.view;

import C7.r;
import J7.c;
import S7.n;
import android.view.Lifecycle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import o9.C1785k;
import o9.InterfaceC1786l;
import p9.d;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/c;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle$State;", "minActiveState", "flowWithLifecycle", "(Lp9/c;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;)Lp9/c;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowExtKt {

    @c(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lo9/l;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ p9.c $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01201 extends SuspendLambda implements n {
            final /* synthetic */ InterfaceC1786l $$this$callbackFlow;
            final /* synthetic */ p9.c $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01201(p9.c cVar, InterfaceC1786l interfaceC1786l, H7.c<? super C01201> cVar2) {
                super(2, cVar2);
                this.$this_flowWithLifecycle = cVar;
                this.$$this$callbackFlow = interfaceC1786l;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01201(this.$this_flowWithLifecycle, this.$$this$callbackFlow, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    p9.c cVar = this.$this_flowWithLifecycle;
                    final InterfaceC1786l interfaceC1786l = this.$$this$callbackFlow;
                    d dVar = new d() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // p9.d
                        public final Object emit(T t9, H7.c<? super r> cVar2) {
                            Object objP = ((C1785k) interfaceC1786l).d.p(cVar2, t9);
                            return objP == CoroutineSingletons.f4909a ? objP : r.f317a;
                        }
                    };
                    this.label = 1;
                    if (cVar.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01201) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, p9.c cVar, H7.c<? super AnonymousClass1> cVar2) {
            super(2, cVar2);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC1786l interfaceC1786l;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                InterfaceC1786l interfaceC1786l2 = (InterfaceC1786l) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C01201 c01201 = new C01201(this.$this_flowWithLifecycle, interfaceC1786l2, null);
                this.L$0 = interfaceC1786l2;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c01201, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                interfaceC1786l = interfaceC1786l2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC1786l = (InterfaceC1786l) this.L$0;
                b.b(obj);
            }
            ((C1785k) interfaceC1786l).s(null);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final <T> p9.c flowWithLifecycle(p9.c cVar, Lifecycle lifecycle, Lifecycle.State minActiveState) {
        k.f(cVar, "<this>");
        k.f(lifecycle, "lifecycle");
        k.f(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.d.c(new AnonymousClass1(lifecycle, minActiveState, cVar, null));
    }

    public static /* synthetic */ p9.c flowWithLifecycle$default(p9.c cVar, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(cVar, lifecycle, state);
    }
}
