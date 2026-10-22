package com.stepos.taskrobot.ability;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.ability.MdiAbility", f = "MdiAbility.kt", l = {197}, m = "resolveElementCoords$ability_release", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MdiAbility$resolveElementCoords$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3996a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MdiAbility$resolveElementCoords$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.k(null, null, null, this);
    }
}
