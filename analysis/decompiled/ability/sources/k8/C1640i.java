package k8;

import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1526i;
import h8.InterfaceC1527j;
import h8.InterfaceC1529l;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: k8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1640i extends t implements InterfaceC1526i {

    /* renamed from: D, reason: collision with root package name */
    public final boolean f4847D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1640i(InterfaceC1522e interfaceC1522e, InterfaceC1526i interfaceC1526i, InterfaceC1561g interfaceC1561g, boolean z10, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind, InterfaceC1503K interfaceC1503K) {
        super(G8.h.e, interfaceC1522e, interfaceC1526i, interfaceC1503K, interfaceC1561g, callableMemberDescriptor$Kind);
        if (interfaceC1522e == null) {
            C0(0);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(1);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(2);
            throw null;
        }
        if (interfaceC1503K == null) {
            C0(3);
            throw null;
        }
        this.f4847D = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void C0(int r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.C1640i.C0(int):void");
    }

    @Override // k8.t, h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.d(this, obj);
    }

    @Override // k8.t, h8.InterfaceC1520c
    public final InterfaceC1520c U(InterfaceC1522e interfaceC1522e, Modality modality, C1531n c1531n) {
        return (C1640i) R0(interfaceC1522e, modality, c1531n);
    }

    @Override // h8.InterfaceC1526i
    public final boolean a0() {
        return this.f4847D;
    }

    @Override // h8.InterfaceC1526i
    public final InterfaceC1522e b0() {
        InterfaceC1522e interfaceC1522eD = d();
        if (interfaceC1522eD != null) {
            return interfaceC1522eD;
        }
        C0(18);
        throw null;
    }

    @Override // k8.t
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public C1640i T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        if (interfaceC1527j == null) {
            C0(23);
            throw null;
        }
        if (callableMemberDescriptor$Kind == null) {
            C0(24);
            throw null;
        }
        if (interfaceC1561g == null) {
            C0(25);
            throw null;
        }
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind2 = CallableMemberDescriptor$Kind.f4950a;
        if (callableMemberDescriptor$Kind == callableMemberDescriptor$Kind2 || callableMemberDescriptor$Kind == CallableMemberDescriptor$Kind.d) {
            return new C1640i((InterfaceC1522e) interfaceC1527j, this, interfaceC1561g, this.f4847D, callableMemberDescriptor$Kind2, interfaceC1503K);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + interfaceC1527j + "\nkind: " + callableMemberDescriptor$Kind);
    }

    @Override // k8.AbstractC1645n, h8.InterfaceC1527j
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1522e d() {
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) super.d();
        if (interfaceC1522e != null) {
            return interfaceC1522e;
        }
        C0(17);
        throw null;
    }

    @Override // k8.t, h8.InterfaceC1520c, h8.InterfaceC1519b
    public final Collection e() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        C0(21);
        throw null;
    }

    @Override // k8.t, k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    /* renamed from: e1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final C1640i a() {
        C1640i c1640i = (C1640i) super.a();
        if (c1640i != null) {
            return c1640i;
        }
        C0(19);
        throw null;
    }

    public final void f1(List list, C1531n c1531n) {
        if (list == null) {
            C0(13);
            throw null;
        }
        if (c1531n != null) {
            g1(list, c1531n, d().h());
        } else {
            C0(14);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g1(java.util.List r12, h8.C1531n r13, java.util.List r14) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L61
            if (r13 == 0) goto L5b
            if (r14 == 0) goto L55
            h8.e r1 = r11.d()
            boolean r2 = r1.q()
            if (r2 == 0) goto L21
            h8.j r1 = r1.d()
            boolean r2 = r1 instanceof h8.InterfaceC1522e
            if (r2 == 0) goto L21
            h8.e r1 = (h8.InterfaceC1522e) r1
            k8.u r1 = r1.B0()
            r4 = r1
            goto L22
        L21:
            r4 = r0
        L22:
            h8.e r1 = r11.d()
            java.util.List r2 = r1.T()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L3e
            java.util.List r1 = r1.T()
            if (r1 == 0) goto L38
        L36:
            r5 = r1
            goto L43
        L38:
            r11 = 15
            C0(r11)
            throw r0
        L3e:
            java.util.List r1 = java.util.Collections.EMPTY_LIST
            if (r1 == 0) goto L4f
            goto L36
        L43:
            r8 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r9 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.b
            r3 = 0
            r2 = r11
            r7 = r12
            r10 = r13
            r6 = r14
            r2.W0(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        L4f:
            r11 = 16
            C0(r11)
            throw r0
        L55:
            r11 = 12
            C0(r11)
            throw r0
        L5b:
            r11 = 11
            C0(r11)
            throw r0
        L61:
            r11 = 10
            C0(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.C1640i.g1(java.util.List, h8.n, java.util.List):void");
    }

    @Override // k8.t, h8.InterfaceC1536s, h8.InterfaceC1505M
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public final C1640i b(kotlin.reflect.jvm.internal.impl.types.a aVar) {
        if (aVar != null) {
            return (C1640i) super.b(aVar);
        }
        C0(20);
        throw null;
    }

    @Override // k8.t, h8.InterfaceC1520c
    public final void u0(Collection collection) {
        if (collection != null) {
            return;
        }
        C0(22);
        throw null;
    }
}
