package com.stepos.taskrobot.ability;

import C7.r;
import J7.c;
import S7.n;
import com.mdisdk.Task;
import com.mdisdk.action.UiSnapshotAction;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.taskrobot.ability.MdiAbility$handleSnapshot$result$1", f = "MdiAbility.kt", l = {659}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/mdisdk/action/ActionResult;", "<anonymous>", "(Lm9/z;)Lcom/mdisdk/action/ActionResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MdiAbility$handleSnapshot$result$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3993a;
    public final /* synthetic */ Task b;
    public final /* synthetic */ UiSnapshotAction c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MdiAbility$handleSnapshot$result$1(Task task, UiSnapshotAction uiSnapshotAction, H7.c cVar) {
        super(2, cVar);
        this.b = task;
        this.c = uiSnapshotAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new MdiAbility$handleSnapshot$result$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((MdiAbility$handleSnapshot$result$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3993a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        this.f3993a = 1;
        Object objExecute = this.b.execute(this.c, this);
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
