package com.stepos.taskrobot.ability;

import J7.c;
import com.mdisdk.action.Action;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.ability.MdiAbility", f = "MdiAbility.kt", l = {172}, m = "executeSingleAction$ability_release", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MdiAbility$executeSingleAction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Action f3987a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MdiAbility$executeSingleAction$1(a aVar, H7.c cVar) {
        super(cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.c(null, null, this);
    }
}
