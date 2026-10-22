package wa;

import E9.InterfaceC0803h;
import E9.W;
import H9.AbstractC0839s;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;

/* renamed from: wa.M, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5771M extends H9.O implements InterfaceC5778b {

    /* renamed from: E, reason: collision with root package name */
    public final ProtoBuf$Function f43156E;

    /* renamed from: F, reason: collision with root package name */
    public final InterfaceC4020d f43157F;

    /* renamed from: G, reason: collision with root package name */
    public final ea.h f43158G;

    /* renamed from: H, reason: collision with root package name */
    public final ea.j f43159H;

    /* renamed from: I, reason: collision with root package name */
    public final InterfaceC5793q f43160I;

    public /* synthetic */ C5771M(InterfaceC0803h interfaceC0803h, kotlin.reflect.jvm.internal.impl.descriptors.g gVar, F9.g gVar2, ga.e eVar, CallableMemberDescriptor.Kind kind, ProtoBuf$Function protoBuf$Function, InterfaceC4020d interfaceC4020d, ea.h hVar, ea.j jVar, InterfaceC5793q interfaceC5793q, W w10, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC0803h, gVar, gVar2, eVar, kind, protoBuf$Function, interfaceC4020d, hVar, jVar, interfaceC5793q, (i10 & 1024) != 0 ? null : w10);
    }

    @Override // wa.InterfaceC5794r
    public ea.h C() {
        return this.f43158G;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC4020d F() {
        return this.f43157F;
    }

    @Override // H9.O, H9.AbstractC0839s
    public AbstractC0839s F0(InterfaceC0803h newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g annotations, W source) {
        ga.e eVar3;
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) eVar;
        if (eVar2 == null) {
            ga.e name = getName();
            kotlin.jvm.internal.p.h(name, "getName(...)");
            eVar3 = name;
        } else {
            eVar3 = eVar2;
        }
        C5771M c5771m = new C5771M(newOwner, gVar, annotations, eVar3, kind, a0(), F(), C(), k1(), G(), source);
        c5771m.S0(K0());
        return c5771m;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC5793q G() {
        return this.f43160I;
    }

    @Override // wa.InterfaceC5794r
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Function a0() {
        return this.f43156E;
    }

    public ea.j k1() {
        return this.f43159H;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public C5771M(E9.InterfaceC0803h r12, kotlin.reflect.jvm.internal.impl.descriptors.g r13, F9.g r14, ga.e r15, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r16, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r17, ea.InterfaceC4020d r18, ea.h r19, ea.j r20, wa.InterfaceC5793q r21, E9.W r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.p.i(r14, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.p.i(r15, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            kotlin.jvm.internal.p.i(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.p.i(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.p.i(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.p.i(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.p.i(r10, r0)
            if (r22 != 0) goto L3d
            E9.W r0 = E9.W.f2444a
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L44
        L3d:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L44:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.f43156E = r7
            r11.f43157F = r8
            r11.f43158G = r9
            r11.f43159H = r10
            r1 = r21
            r11.f43160I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.C5771M.<init>(E9.h, kotlin.reflect.jvm.internal.impl.descriptors.g, F9.g, ga.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, ea.d, ea.h, ea.j, wa.q, E9.W):void");
    }
}
