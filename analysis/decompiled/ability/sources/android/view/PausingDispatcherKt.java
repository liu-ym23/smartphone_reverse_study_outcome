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
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\u0007\u0010\b\u001a>\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\u0007\u0010\n\u001a>\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\u000b\u0010\b\u001a>\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\u000b\u0010\n\u001a>\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\f\u0010\b\u001a>\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\f\u0010\n\u001aF\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Lm9/z;", "LH7/c;", "", "block", "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;LS7/n;LH7/c;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;LS7/n;LH7/c;)Ljava/lang/Object;", "lifecycle-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PausingDispatcherKt {

    @c(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {213}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, n nVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    b.b(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            b.b(obj);
            c0 c0Var = (c0) ((InterfaceC1733z) this.L$0).getCoroutineContext().get(b0.f5325a);
            if (c0Var == null) {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, c0Var);
            try {
                n nVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = AbstractC1683A.w(pausingDispatcher, nVar, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super T> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @C7.c
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, n nVar, H7.c<? super T> cVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), nVar, cVar);
    }

    @C7.c
    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, n nVar, H7.c<? super T> cVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), nVar, cVar);
    }

    @C7.c
    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, n nVar, H7.c<? super T> cVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), nVar, cVar);
    }

    @C7.c
    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, n nVar, H7.c<? super T> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(k.f6003a.d, new AnonymousClass2(lifecycle, state, nVar, null), cVar);
    }

    @C7.c
    public static final <T> Object whenCreated(Lifecycle lifecycle, n nVar, H7.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, nVar, cVar);
    }

    @C7.c
    public static final <T> Object whenResumed(Lifecycle lifecycle, n nVar, H7.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, nVar, cVar);
    }

    @C7.c
    public static final <T> Object whenStarted(Lifecycle lifecycle, n nVar, H7.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, nVar, cVar);
    }
}
