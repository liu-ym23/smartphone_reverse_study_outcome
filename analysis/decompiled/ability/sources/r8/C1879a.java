package r8;

import J8.k;
import J8.m;
import T8.o;
import h8.InterfaceC1520c;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;

/* renamed from: r8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1879a extends m {
    public final /* synthetic */ o c;
    public final /* synthetic */ LinkedHashSet d;
    public final /* synthetic */ boolean e;

    public C1879a(o oVar, LinkedHashSet linkedHashSet, boolean z10) {
        this.c = oVar;
        this.d = linkedHashSet;
        this.e = z10;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i == 2) {
            objArr[0] = "fromCurrent";
        } else if (i == 3) {
            objArr[0] = "member";
        } else if (i != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "setOverriddenDescriptors";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // J8.m
    public final void b(InterfaceC1520c interfaceC1520c) {
        if (interfaceC1520c == null) {
            a(0);
            throw null;
        }
        k.r(interfaceC1520c, new J4.b(this, 19));
        this.d.add(interfaceC1520c);
    }

    @Override // J8.m
    public final void d(InterfaceC1520c interfaceC1520c, InterfaceC1520c interfaceC1520c2) {
        if (interfaceC1520c2 != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // J8.m
    public final void p(InterfaceC1520c interfaceC1520c, Collection collection) {
        if (interfaceC1520c == null) {
            a(3);
            throw null;
        }
        if (!this.e || interfaceC1520c.getKind() == CallableMemberDescriptor$Kind.b) {
            interfaceC1520c.u0(collection);
        }
    }
}
