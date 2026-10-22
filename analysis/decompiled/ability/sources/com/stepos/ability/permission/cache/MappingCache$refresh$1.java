package com.stepos.ability.permission.cache;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import p4.C1791a;
import s4.e;

@J7.c(c = "com.stepos.ability.permission.cache.MappingCache$refresh$1", f = "MappingCache.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class MappingCache$refresh$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f3208a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MappingCache$refresh$1(a aVar, String str, H7.c cVar) {
        super(2, cVar);
        this.f3208a = aVar;
        this.b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new MappingCache$refresh$1(this.f3208a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        MappingCache$refresh$1 mappingCache$refresh$1 = (MappingCache$refresh$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        mappingCache$refresh$1.invokeSuspend(rVar);
        return rVar;
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        P3.b bVar = P3.c.f1086a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        try {
            e eVar = (e) this.f3208a.f3212a.invoke(Boolean.TRUE);
            if (eVar != null) {
                a aVar = this.f3208a;
                aVar.d = new C1791a(eVar, ((Number) aVar.c.invoke()).longValue());
                P3.c.b("SlaPermMapping", "refresh ok reason=" + this.b + " funcs=" + eVar.f5984a.size() + " scopes=" + eVar.b.size() + " stale=" + eVar.c);
            } else {
                String msg = "refresh got null reason=" + this.b + " -> 保留旧缓存 (hasCache=" + (this.f3208a.d != null) + ")";
                k.f(msg, "msg");
                bVar.invoke(5, "Ability_".concat("SlaPermMapping"), msg, null);
            }
        } finally {
            try {
                return r.f317a;
            } finally {
            }
        }
        return r.f317a;
    }
}
