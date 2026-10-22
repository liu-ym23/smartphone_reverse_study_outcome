package V8;

import H8.AbstractC0241b;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import k8.K;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;

/* loaded from: classes4.dex */
public final class s extends K implements b {

    /* renamed from: D, reason: collision with root package name */
    public final ProtoBuf$Function f1406D;
    public final D8.f E;

    /* renamed from: F, reason: collision with root package name */
    public final D8.j f1407F;

    /* renamed from: G, reason: collision with root package name */
    public final D8.k f1408G;

    /* renamed from: L, reason: collision with root package name */
    public final j f1409L;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public s(h8.InterfaceC1527j r12, k8.K r13, i8.InterfaceC1561g r14, G8.f r15, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r16, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r17, D8.f r18, D8.j r19, D8.k r20, V8.j r21, h8.InterfaceC1503K r22) {
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
            r11.f1406D = r7
            r11.E = r8
            r11.f1407F = r9
            r11.f1408G = r10
            r1 = r21
            r11.f1409L = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: V8.s.<init>(h8.j, k8.K, i8.g, G8.f, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, D8.f, D8.j, D8.k, V8.j, h8.K):void");
    }

    @Override // V8.k
    public final j B() {
        return this.f1409L;
    }

    @Override // k8.K, k8.t
    public final k8.t T0(G8.f fVar, InterfaceC1527j newOwner, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g annotations, CallableMemberDescriptor$Kind kind) {
        kotlin.jvm.internal.k.f(newOwner, "newOwner");
        kotlin.jvm.internal.k.f(kind, "kind");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        K k = (K) interfaceC1536s;
        if (fVar == null) {
            fVar = getName();
            kotlin.jvm.internal.k.e(fVar, "getName(...)");
        }
        s sVar = new s(newOwner, k, annotations, fVar, kind, this.f1406D, this.E, this.f1407F, this.f1408G, this.f1409L, interfaceC1503K);
        sVar.f4869v = this.f4869v;
        return sVar;
    }

    @Override // V8.k
    public final AbstractC0241b d0() {
        return this.f1406D;
    }

    @Override // V8.k
    public final D8.j v() {
        return this.f1407F;
    }

    @Override // V8.k
    public final D8.f y() {
        return this.E;
    }
}
