package com.stepos.ability.manager;

import J7.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.manager.AbilityCatalogImpl", f = "AbilityCatalogImpl.kt", l = {26, 28}, m = "listAbilities", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AbilityCatalogImpl$listAbilities$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public List f3101a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityCatalogImpl$listAbilities$1(a aVar, H7.c cVar) {
        super(cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.listAbilities(null, null, this);
    }
}
