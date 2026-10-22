package V8;

import H8.AbstractC0241b;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import h8.InterfaceC1526i;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import k8.C1640i;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;

/* loaded from: classes4.dex */
public final class c extends C1640i implements b {
    public final ProtoBuf$Constructor E;

    /* renamed from: F, reason: collision with root package name */
    public final D8.f f1389F;

    /* renamed from: G, reason: collision with root package name */
    public final D8.j f1390G;

    /* renamed from: L, reason: collision with root package name */
    public final D8.k f1391L;

    /* renamed from: M, reason: collision with root package name */
    public final j f1392M;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public c(h8.InterfaceC1522e r12, h8.InterfaceC1526i r13, i8.InterfaceC1561g r14, boolean r15, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r16, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r17, D8.f r18, D8.j r19, D8.k r20, V8.j r21, h8.InterfaceC1503K r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.k.f(r12, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.k.f(r14, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            kotlin.jvm.internal.k.f(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.k.f(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.k.f(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.k.f(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.k.f(r10, r0)
            if (r22 != 0) goto L38
            h8.L r0 = h8.InterfaceC1503K.f4577I
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L3f
        L38:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L3f:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.E = r7
            r11.f1389F = r8
            r11.f1390G = r9
            r11.f1391L = r10
            r1 = r21
            r11.f1392M = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: V8.c.<init>(h8.e, h8.i, i8.g, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, D8.f, D8.j, D8.k, V8.j, h8.K):void");
    }

    @Override // V8.k
    public final j B() {
        return this.f1392M;
    }

    @Override // k8.C1640i, k8.t
    public final /* bridge */ /* synthetic */ k8.t T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        return i1(interfaceC1527j, interfaceC1536s, callableMemberDescriptor$Kind, interfaceC1561g, interfaceC1503K);
    }

    @Override // k8.C1640i
    /* renamed from: c1 */
    public final /* bridge */ /* synthetic */ C1640i T0(G8.f fVar, InterfaceC1527j interfaceC1527j, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g interfaceC1561g, CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        return i1(interfaceC1527j, interfaceC1536s, callableMemberDescriptor$Kind, interfaceC1561g, interfaceC1503K);
    }

    @Override // V8.k
    public final AbstractC0241b d0() {
        return this.E;
    }

    public final c i1(InterfaceC1527j newOwner, InterfaceC1536s interfaceC1536s, CallableMemberDescriptor$Kind kind, InterfaceC1561g annotations, InterfaceC1503K interfaceC1503K) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        c cVar = new c((InterfaceC1522e) newOwner, (InterfaceC1526i) interfaceC1536s, annotations, this.f4847D, kind, this.E, this.f1389F, this.f1390G, this.f1391L, this.f1392M, interfaceC1503K);
        cVar.f4869v = this.f4869v;
        return cVar;
    }

    @Override // k8.t, h8.InterfaceC1539v
    public final boolean isExternal() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean isInline() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean isSuspend() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean t() {
        return false;
    }

    @Override // V8.k
    public final D8.j v() {
        return this.f1390G;
    }

    @Override // V8.k
    public final D8.f y() {
        return this.f1389F;
    }
}
