package com.stepos.taskrobot.ability;

import J7.c;
import com.mdisdk.Task;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.ability.MdiAbility", f = "MdiAbility.kt", l = {436, 457}, m = "handleClick", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MdiAbility$handleClick$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Task f3991a;
    public String b;
    public String c;
    public long d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MdiAbility$handleClick$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.h(null, this);
    }
}
