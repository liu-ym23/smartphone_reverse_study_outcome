package com.stepos.ability.permission.cache;

import C7.r;
import S7.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import s4.f;

@J7.c(c = "com.stepos.ability.permission.cache.ModeCache$refresh$1", f = "ModeCache.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class ModeCache$refresh$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3209a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeCache$refresh$1(b bVar, boolean z10, boolean z11, String str, H7.c cVar) {
        super(2, cVar);
        this.f3209a = bVar;
        this.b = z10;
        this.c = z11;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ModeCache$refresh$1(this.f3209a, this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        ModeCache$refresh$1 modeCache$refresh$1 = (ModeCache$refresh$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        modeCache$refresh$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        P3.b bVar = P3.c.f1086a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        try {
            f fVar = (f) this.f3209a.f3213a.invoke(Boolean.valueOf(this.b));
            if (fVar != null) {
                b bVar2 = this.f3209a;
                p4.b bVar3 = bVar2.d;
                List listA = b.a(bVar2, bVar3 != null ? bVar3.f5539a : null, fVar);
                long jLongValue = ((Number) this.f3209a.c.invoke()).longValue();
                this.f3209a.d = new p4.b(fVar, jLongValue);
                if (this.c) {
                    this.f3209a.e = jLongValue;
                }
                String str2 = this.d;
                int size = fVar.f5985a.size();
                boolean z10 = fVar.b;
                if (listA.isEmpty()) {
                    str = "";
                } else {
                    str = " changed=" + listA;
                }
                P3.c.b("SlaPermMode", "refresh ok reason=" + str2 + " groups=" + size + " stale=" + z10 + str);
            } else {
                String msg = "refresh got null reason=" + this.d + " -> 保留旧缓存 (hasCache=" + (this.f3209a.d != null) + ")";
                k.f(msg, "msg");
                bVar.invoke(5, "Ability_".concat("SlaPermMode"), msg, null);
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
