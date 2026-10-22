package com.stepos.taskrobot.vdbroadcast;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import m9.c0;

@c(c = "com.stepos.taskrobot.vdbroadcast.VdTaskService$onDestroy$2$joined$1", f = "VdTaskService.kt", l = {462}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class VdTaskService$onDestroy$2$joined$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f4073a;
    public final /* synthetic */ c0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VdTaskService$onDestroy$2$joined$1(c0 c0Var, H7.c cVar) {
        super(2, cVar);
        this.b = c0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new VdTaskService$onDestroy$2$joined$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((VdTaskService$onDestroy$2$joined$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f4073a;
        if (i == 0) {
            b.b(obj);
            this.f4073a = 1;
            if (this.b.g(this) == coroutineSingletons) {
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
}
