package p8;

import h9.m;
import java.util.Collection;
import java.util.LinkedHashSet;
import r9.l;

/* loaded from: classes.dex */
public final class a extends m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f8500b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinkedHashSet f8501c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f8502d;

    public a(l lVar, LinkedHashSet linkedHashSet, boolean z4) {
        this.f8500b = lVar;
        this.f8501c = linkedHashSet;
        this.f8502d = z4;
    }

    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "fromSuper";
        } else if (i2 == 2) {
            objArr[0] = "fromCurrent";
        } else if (i2 == 3) {
            objArr[0] = "member";
        } else if (i2 != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i2 == 1 || i2 == 2) {
            objArr[2] = "conflict";
        } else if (i2 == 3 || i2 == 4) {
            objArr[2] = "setOverriddenDescriptors";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // h9.m
    public final void b(f8.c cVar) {
        if (cVar == null) {
            a(0);
            throw null;
        }
        h9.l.r(cVar, new c6.i(5, this));
        this.f8501c.add(cVar);
    }

    @Override // h9.m
    public final void d(f8.c cVar, f8.c cVar2) {
        if (cVar2 != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // h9.m
    public final void p(f8.c cVar, Collection collection) {
        if (cVar == null) {
            a(3);
            throw null;
        }
        if (!this.f8502d || cVar.getKind() == 2) {
            cVar.d0(collection);
        }
    }
}
