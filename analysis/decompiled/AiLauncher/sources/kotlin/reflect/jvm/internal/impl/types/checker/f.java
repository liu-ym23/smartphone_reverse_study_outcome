package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import ya.K0;
import ya.S;

/* loaded from: classes5.dex */
public final class f implements e {

    /* renamed from: c, reason: collision with root package name */
    public final c f36103c;

    /* renamed from: d, reason: collision with root package name */
    public final KotlinTypePreparator f36104d;

    /* renamed from: e, reason: collision with root package name */
    public final OverridingUtil f36105e;

    public f(c kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        p.i(kotlinTypePreparator, "kotlinTypePreparator");
        this.f36103c = kotlinTypeRefiner;
        this.f36104d = kotlinTypePreparator;
        OverridingUtil overridingUtilM = OverridingUtil.m(d());
        p.h(overridingUtilM, "createWithTypeRefiner(...)");
        this.f36105e = overridingUtilM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public OverridingUtil a() {
        return this.f36105e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    public boolean b(S subtype, S supertype) {
        p.i(subtype, "subtype");
        p.i(supertype, "supertype");
        return g(a.b(true, false, null, f(), d(), 6, null), subtype.K0(), supertype.K0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    public boolean c(S a10, S b10) {
        p.i(a10, "a");
        p.i(b10, "b");
        return e(a.b(false, false, null, f(), d(), 6, null), a10.K0(), b10.K0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public c d() {
        return this.f36103c;
    }

    public final boolean e(TypeCheckerState typeCheckerState, K0 a10, K0 b10) {
        p.i(typeCheckerState, "<this>");
        p.i(a10, "a");
        p.i(b10, "b");
        return kotlin.reflect.jvm.internal.impl.types.b.f36092a.m(typeCheckerState, a10, b10);
    }

    public KotlinTypePreparator f() {
        return this.f36104d;
    }

    public final boolean g(TypeCheckerState typeCheckerState, K0 subType, K0 superType) {
        p.i(typeCheckerState, "<this>");
        p.i(subType, "subType");
        p.i(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.b.w(kotlin.reflect.jvm.internal.impl.types.b.f36092a, typeCheckerState, subType, superType, false, 8, null);
    }

    public /* synthetic */ f(c cVar, KotlinTypePreparator kotlinTypePreparator, int i10, i iVar) {
        this(cVar, (i10 & 2) != 0 ? KotlinTypePreparator.a.f36096a : kotlinTypePreparator);
    }
}
