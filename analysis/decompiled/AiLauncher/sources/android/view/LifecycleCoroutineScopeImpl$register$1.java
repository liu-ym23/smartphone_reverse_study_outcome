package android.view;

import Ua.M;
import Y8.t;
import android.view.Lifecycle;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.JobKt__JobKt;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14196a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14197b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LifecycleCoroutineScopeImpl f14198c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, InterfaceC4014c<? super LifecycleCoroutineScopeImpl$register$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14198c = lifecycleCoroutineScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.f14198c, interfaceC4014c);
        lifecycleCoroutineScopeImpl$register$1.f14197b = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f14196a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        M m10 = (M) this.f14197b;
        if (this.f14198c.getLifecycle().getState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
            this.f14198c.getLifecycle().a(this.f14198c);
        } else {
            JobKt__JobKt.e(m10.getCoroutineContext(), null, 1, null);
        }
        return t.f7040a;
    }
}
