package H9;

import E9.AbstractC0811p;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.InterfaceC0805j;
import E9.b0;
import E9.i0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* renamed from: H9.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0830i extends AbstractC0839s implements kotlin.reflect.jvm.internal.impl.descriptors.b {

    /* renamed from: E, reason: collision with root package name */
    public final boolean f3129E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0830i(InterfaceC0797b interfaceC0797b, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, F9.g gVar, boolean z10, CallableMemberDescriptor.Kind kind, E9.W w10) {
        super(interfaceC0797b, cVar, gVar, ga.g.f32750j, kind, w10);
        if (interfaceC0797b == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (kind == null) {
            T(2);
        }
        if (w10 == null) {
            T(3);
        }
        this.f3129E = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void T(int r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H9.C0830i.T(int):void");
    }

    public static C0830i h1(InterfaceC0797b interfaceC0797b, F9.g gVar, boolean z10, E9.W w10) {
        if (interfaceC0797b == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (w10 == null) {
            T(6);
        }
        return new C0830i(interfaceC0797b, null, gVar, z10, CallableMemberDescriptor.Kind.DECLARATION, w10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public boolean X() {
        return this.f3129E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public InterfaceC0797b Y() {
        InterfaceC0797b interfaceC0797bB = b();
        if (interfaceC0797bB == null) {
            T(18);
        }
        return interfaceC0797bB;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.e> d() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            T(21);
        }
        return set;
    }

    public final List<E9.S> e1() {
        InterfaceC0797b interfaceC0797bB = b();
        if (interfaceC0797bB.V().isEmpty()) {
            List<E9.S> list = Collections.EMPTY_LIST;
            if (list == null) {
                T(16);
            }
            return list;
        }
        List<E9.S> listV = interfaceC0797bB.V();
        if (listV == null) {
            T(15);
        }
        return listV;
    }

    public E9.S f1() {
        InterfaceC0797b interfaceC0797bB = b();
        if (!interfaceC0797bB.x()) {
            return null;
        }
        InterfaceC0803h interfaceC0803hB = interfaceC0797bB.b();
        if (interfaceC0803hB instanceof InterfaceC0797b) {
            return ((InterfaceC0797b) interfaceC0803hB).D0();
        }
        return null;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.b y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, CallableMemberDescriptor.Kind kind, boolean z10) {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) super.y(interfaceC0803h, modality, abstractC0811p, kind, z10);
        if (bVar == null) {
            T(27);
        }
        return bVar;
    }

    @Override // H9.AbstractC0839s
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public C0830i F0(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g gVar, E9.W w10) {
        if (interfaceC0803h == null) {
            T(23);
        }
        if (kind == null) {
            T(24);
        }
        if (gVar == null) {
            T(25);
        }
        if (w10 == null) {
            T(26);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind == kind2 || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            return new C0830i((InterfaceC0797b) interfaceC0803h, this, gVar, this.f3129E, kind2, w10);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC0803h + "\nkind: " + kind);
    }

    @Override // H9.AbstractC0835n, E9.InterfaceC0803h
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b b() {
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) super.b();
        if (interfaceC0797b == null) {
            T(17);
        }
        return interfaceC0797b;
    }

    public C0830i k1(List<i0> list, AbstractC0811p abstractC0811p) {
        if (list == null) {
            T(13);
        }
        if (abstractC0811p == null) {
            T(14);
        }
        l1(list, abstractC0811p, b().o());
        return this;
    }

    public C0830i l1(List<i0> list, AbstractC0811p abstractC0811p, List<b0> list2) {
        if (list == null) {
            T(10);
        }
        if (abstractC0811p == null) {
            T(11);
        }
        if (list2 == null) {
            T(12);
        }
        super.L0(null, f1(), e1(), list2, list, null, Modality.FINAL, abstractC0811p);
        return this;
    }

    @Override // H9.AbstractC0839s, E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return interfaceC0805j.k(this, d10);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void x0(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            T(22);
        }
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e, E9.Y
    public kotlin.reflect.jvm.internal.impl.descriptors.b c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            T(20);
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.b) super.c(typeSubstitutor);
    }

    @Override // H9.AbstractC0839s, H9.AbstractC0835n
    public kotlin.reflect.jvm.internal.impl.descriptors.b a() {
        kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) super.a();
        if (bVar == null) {
            T(19);
        }
        return bVar;
    }
}
