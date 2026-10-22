package com.stepos.taskrobot.ability;

import J7.c;
import com.mdisdk.Task;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.taskrobot.ability.MdiAbility", f = "MdiAbility.kt", l = {258}, m = "openAppOnVirtualDisplay", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MdiAbility$openAppOnVirtualDisplay$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3994a;
    public String b;
    public Task c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MdiAbility$openAppOnVirtualDisplay$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.j(null, null, false, this);
    }
}
