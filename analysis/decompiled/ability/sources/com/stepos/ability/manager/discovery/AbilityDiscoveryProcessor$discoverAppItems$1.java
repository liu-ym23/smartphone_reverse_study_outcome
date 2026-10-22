package com.stepos.ability.manager.discovery;

import J7.c;
import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor", f = "AbilityDiscoveryProcessor.kt", l = {118, 121, 134}, m = "discoverAppItems", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityDiscoveryProcessor$discoverAppItems$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3138a;
    public Map b;
    public Map c;
    public Map d;
    public EmptyList e;
    public /* synthetic */ Object f;
    public final /* synthetic */ a g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityDiscoveryProcessor$discoverAppItems$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.c(null, this);
    }
}
