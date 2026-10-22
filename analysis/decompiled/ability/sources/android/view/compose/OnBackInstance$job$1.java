package android.view.compose;

import C7.r;
import J7.c;
import S7.n;
import S7.o;
import android.view.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import m9.InterfaceC1733z;
import p9.C1792a;
import p9.d;
import p9.f;

@c(c = "androidx.activity.compose.OnBackInstance$job$1", f = "PredictiveBackHandler.kt", l = {121}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class OnBackInstance$job$1 extends SuspendLambda implements n {
    final /* synthetic */ OnBackPressedCallback $callback;
    final /* synthetic */ n $onBack;
    Object L$0;
    int label;
    final /* synthetic */ OnBackInstance this$0;

    @c(c = "androidx.activity.compose.OnBackInstance$job$1$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lp9/d;", "Landroidx/activity/BackEventCompat;", "", "it", "LC7/r;", "<anonymous>", "(Lp9/d;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.activity.compose.OnBackInstance$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements o {
        final /* synthetic */ Ref$BooleanRef $completed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$BooleanRef ref$BooleanRef, H7.c<? super AnonymousClass1> cVar) {
            super(3, cVar);
            this.$completed = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            this.$completed.f4916a = true;
            return r.f317a;
        }

        @Override // S7.o
        public final Object invoke(d dVar, Throwable th, H7.c<? super r> cVar) {
            return new AnonymousClass1(this.$completed, cVar).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnBackInstance$job$1(OnBackPressedCallback onBackPressedCallback, n nVar, OnBackInstance onBackInstance, H7.c<? super OnBackInstance$job$1> cVar) {
        super(2, cVar);
        this.$callback = onBackPressedCallback;
        this.$onBack = nVar;
        this.this$0 = onBackInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new OnBackInstance$job$1(this.$callback, this.$onBack, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$BooleanRef ref$BooleanRef;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            if (this.$callback.getIsEnabled()) {
                Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                n nVar = this.$onBack;
                f fVar = new f(new C1792a(this.this$0.getChannel(), true), new AnonymousClass1(ref$BooleanRef2, null));
                this.L$0 = ref$BooleanRef2;
                this.label = 1;
                if (nVar.invoke(fVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$BooleanRef = ref$BooleanRef2;
            }
            return r.f317a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$BooleanRef = (Ref$BooleanRef) this.L$0;
        b.b(obj);
        if (!ref$BooleanRef.f4916a) {
            throw new IllegalStateException("You must collect the progress flow");
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((OnBackInstance$job$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
