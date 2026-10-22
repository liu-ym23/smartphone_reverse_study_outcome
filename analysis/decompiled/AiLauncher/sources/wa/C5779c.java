package wa;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.W;
import H9.C0830i;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;

/* renamed from: wa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5779c extends C0830i implements InterfaceC5778b {

    /* renamed from: F, reason: collision with root package name */
    public final ProtoBuf$Constructor f43180F;

    /* renamed from: G, reason: collision with root package name */
    public final InterfaceC4020d f43181G;

    /* renamed from: H, reason: collision with root package name */
    public final ea.h f43182H;

    /* renamed from: I, reason: collision with root package name */
    public final ea.j f43183I;

    /* renamed from: J, reason: collision with root package name */
    public final InterfaceC5793q f43184J;

    public /* synthetic */ C5779c(InterfaceC0797b interfaceC0797b, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, F9.g gVar, boolean z10, CallableMemberDescriptor.Kind kind, ProtoBuf$Constructor protoBuf$Constructor, InterfaceC4020d interfaceC4020d, ea.h hVar, ea.j jVar, InterfaceC5793q interfaceC5793q, W w10, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC0797b, cVar, gVar, z10, kind, protoBuf$Constructor, interfaceC4020d, hVar, jVar, interfaceC5793q, (i10 & 1024) != 0 ? null : w10);
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // wa.InterfaceC5794r
    public ea.h C() {
        return this.f43182H;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC4020d F() {
        return this.f43181G;
    }

    @Override // wa.InterfaceC5794r
    public InterfaceC5793q G() {
        return this.f43184J;
    }

    @Override // H9.AbstractC0839s, E9.InterfaceC0816v
    public boolean isExternal() {
        return false;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isSuspend() {
        return false;
    }

    @Override // H9.C0830i
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public C5779c F0(InterfaceC0803h newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g annotations, W source) {
        kotlin.jvm.internal.p.i(newOwner, "newOwner");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(annotations, "annotations");
        kotlin.jvm.internal.p.i(source, "source");
        C5779c c5779c = new C5779c((InterfaceC0797b) newOwner, (kotlin.reflect.jvm.internal.impl.descriptors.c) eVar, annotations, this.f3129E, kind, a0(), F(), C(), o1(), G(), source);
        c5779c.S0(K0());
        return c5779c;
    }

    @Override // wa.InterfaceC5794r
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Constructor a0() {
        return this.f43180F;
    }

    public ea.j o1() {
        return this.f43183I;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public C5779c(E9.InterfaceC0797b r12, kotlin.reflect.jvm.internal.impl.descriptors.c r13, F9.g r14, boolean r15, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r16, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r17, ea.InterfaceC4020d r18, ea.h r19, ea.j r20, wa.InterfaceC5793q r21, E9.W r22) {
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
            if (r22 != 0) goto L38
            E9.W r0 = E9.W.f2444a
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
            r11.f43180F = r7
            r11.f43181G = r8
            r11.f43182H = r9
            r11.f43183I = r10
            r1 = r21
            r11.f43184J = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wa.C5779c.<init>(E9.b, kotlin.reflect.jvm.internal.impl.descriptors.c, F9.g, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, ea.d, ea.h, ea.j, wa.q, E9.W):void");
    }
}
