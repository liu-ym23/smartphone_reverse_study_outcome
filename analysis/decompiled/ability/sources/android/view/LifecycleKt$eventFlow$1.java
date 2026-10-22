package android.view;

import C7.r;
import J7.c;
import S7.a;
import S7.n;
import android.view.Lifecycle;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o9.C1785k;
import o9.InterfaceC1786l;

@c(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {373}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo9/l;", "Landroidx/lifecycle/Lifecycle$Event;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes2.dex */
public final class LifecycleKt$eventFlow$1 extends SuspendLambda implements n {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, H7.c<? super LifecycleKt$eventFlow$1> cVar) {
        super(2, cVar);
        this.$this_eventFlow = lifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(InterfaceC1786l interfaceC1786l, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        C1785k c1785k = (C1785k) interfaceC1786l;
        c1785k.a(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            c1785k.s(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r invokeSuspend$lambda$1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return r.f317a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, cVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.L$0;
            final C0778g c0778g = new C0778g(interfaceC1786l, 0);
            this.$this_eventFlow.addObserver(c0778g);
            final Lifecycle lifecycle = this.$this_eventFlow;
            a aVar = new a() { // from class: androidx.lifecycle.h
                @Override // S7.a
                public final Object invoke() {
                    return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(lifecycle, c0778g);
                }
            };
            this.label = 1;
            if (kotlinx.coroutines.channels.b.a(interfaceC1786l, aVar, this) == coroutineSingletons) {
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
    public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
        return ((LifecycleKt$eventFlow$1) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
    }
}
