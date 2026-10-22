package com.stepos.ability.voicewakeup.ui;

import C7.r;
import J4.f;
import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1718k;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.voicewakeup.ui.WakeupPagPlayer$playOnceAndAwait$2", f = "WakeupPagPlayer.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class WakeupPagPlayer$playOnceAndAwait$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3434a;
    public final /* synthetic */ d b;
    public final /* synthetic */ WakeupPagAnimation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeupPagPlayer$playOnceAndAwait$2(d dVar, WakeupPagAnimation wakeupPagAnimation, H7.c cVar) {
        super(2, cVar);
        this.b = dVar;
        this.c = wakeupPagAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new WakeupPagPlayer$playOnceAndAwait$2(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((WakeupPagPlayer$playOnceAndAwait$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3434a;
        if (i == 0) {
            kotlin.b.b(obj);
            this.f3434a = 1;
            C1718k c1718k = new C1718k(1, U7.a.I(this));
            c1718k.y();
            d dVar = this.b;
            if (dVar.d) {
                c1718k.l(new CancellationException("PAG player has been released"));
            } else if (c1718k.isActive()) {
                c cVar = new c(dVar, this.c, WakeupPagPlayer$Mode.b, c1718k, 0L, 8);
                c1718k.j(new f(0, dVar, cVar));
                if (c1718k.isActive()) {
                    dVar.b(cVar);
                }
            }
            if (c1718k.x() == coroutineSingletons) {
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
