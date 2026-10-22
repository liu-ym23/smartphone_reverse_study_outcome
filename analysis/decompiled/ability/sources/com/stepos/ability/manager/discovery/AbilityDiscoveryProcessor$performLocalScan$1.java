package com.stepos.ability.manager.discovery;

import J7.c;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.discovery.AbilityDiscoveryProcessor", f = "AbilityDiscoveryProcessor.kt", l = {52, 58}, m = "performLocalScan", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityDiscoveryProcessor$performLocalScan$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Context f3139a;
    public List b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityDiscoveryProcessor$performLocalScan$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.d(null, this);
    }
}
