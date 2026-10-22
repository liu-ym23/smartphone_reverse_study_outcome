package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$3", f = "ToolTaskExecutor.kt", l = {325}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class ToolTaskExecutor$execute$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3304a;
    public final /* synthetic */ g b;
    public final /* synthetic */ InternalTask c;
    public final /* synthetic */ Ref$ObjectRef d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$execute$3(g gVar, InternalTask internalTask, Ref$ObjectRef ref$ObjectRef, String str, H7.c cVar) {
        super(2, cVar);
        this.b = gVar;
        this.c = internalTask;
        this.d = ref$ObjectRef;
        this.e = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ToolTaskExecutor$execute$3(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ToolTaskExecutor$execute$3) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3304a;
        if (i == 0) {
            kotlin.b.b(obj);
            FunctionCallResult functionCallResult = (FunctionCallResult) this.d.f4920a;
            this.f3304a = 1;
            if (this.b.b(this.c, functionCallResult, this.e, null, null, this) == coroutineSingletons) {
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
}
