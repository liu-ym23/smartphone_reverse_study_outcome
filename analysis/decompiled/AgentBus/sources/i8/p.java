package i8;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class p extends h9.m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4832b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractCollection f4833c;

    public /* synthetic */ p(AbstractCollection abstractCollection, int i2) {
        this.f4832b = i2;
        this.f4833c = abstractCollection;
    }

    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "fromSuper";
        } else if (i2 != 2) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "fromCurrent";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        if (i2 == 1 || i2 == 2) {
            objArr[2] = "conflict";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // h9.m
    public final void b(f8.c cVar) {
        switch (this.f4832b) {
            case 0:
                if (cVar == null) {
                    a(0);
                    throw null;
                }
                h9.l.r(cVar, null);
                ((LinkedHashSet) this.f4833c).add(cVar);
                return;
            default:
                q7.k.e(cVar, "fakeOverride");
                h9.l.r(cVar, null);
                ((ArrayList) this.f4833c).add(cVar);
                return;
        }
    }

    @Override // h9.m
    public final void d(f8.c cVar, f8.c cVar2) {
        switch (this.f4832b) {
            case 0:
                if (cVar2 != null) {
                    return;
                }
                a(2);
                throw null;
            default:
                q7.k.e(cVar2, "fromCurrent");
                if (cVar2 instanceof u) {
                    ((u) cVar2).N0(f8.p.f3506a, cVar);
                    return;
                }
                return;
        }
    }
}
