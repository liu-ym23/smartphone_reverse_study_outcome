package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0957k0 extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public List g;
    public DescriptorProtos$ServiceOptions h;
    public C0986r2 i;

    public C0957k0() {
        super(null);
        this.f = "";
        this.g = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2979x;
        c0868b.g(DescriptorProtos$ServiceDescriptorProto.class, C0957k0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$ServiceDescriptorProto m() {
        int i;
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = new DescriptorProtos$ServiceDescriptorProto(this);
        descriptorProtos$ServiceDescriptorProto.d = "";
        descriptorProtos$ServiceDescriptorProto.g = (byte) -1;
        if ((this.e & 2) != 0) {
            this.g = Collections.unmodifiableList(this.g);
            this.e &= -3;
        }
        descriptorProtos$ServiceDescriptorProto.e = this.g;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$ServiceDescriptorProto.d = this.f;
                i = 1;
            } else {
                i = 0;
            }
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.i;
                descriptorProtos$ServiceDescriptorProto.f = c0986r2 == null ? this.h : (DescriptorProtos$ServiceOptions) c0986r2.a();
                i |= 2;
            }
            descriptorProtos$ServiceDescriptorProto.c |= i;
        }
        K();
        return descriptorProtos$ServiceDescriptorProto;
    }

    public final void O(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions2;
        if (descriptorProtos$ServiceDescriptorProto == DescriptorProtos$ServiceDescriptorProto.h) {
            return;
        }
        if ((descriptorProtos$ServiceDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$ServiceDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (!descriptorProtos$ServiceDescriptorProto.e.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = descriptorProtos$ServiceDescriptorProto.e;
                this.e &= -3;
            } else {
                if ((this.e & 2) == 0) {
                    this.g = new ArrayList(this.g);
                    this.e |= 2;
                }
                this.g.addAll(descriptorProtos$ServiceDescriptorProto.e);
            }
            L();
        }
        if (descriptorProtos$ServiceDescriptorProto.G()) {
            DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptionsF = descriptorProtos$ServiceDescriptorProto.F();
            C0986r2 c0986r2 = this.i;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 4) == 0 || (descriptorProtos$ServiceOptions = this.h) == null || descriptorProtos$ServiceOptions == (descriptorProtos$ServiceOptions2 = DescriptorProtos$ServiceOptions.i)) {
                    this.h = descriptorProtos$ServiceOptionsF;
                } else {
                    this.e = i | 4;
                    L();
                    C0986r2 c0986r22 = this.i;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions3 = this.h;
                            if (descriptorProtos$ServiceOptions3 != null) {
                                descriptorProtos$ServiceOptions2 = descriptorProtos$ServiceOptions3;
                            }
                        } else {
                            descriptorProtos$ServiceOptions2 = (DescriptorProtos$ServiceOptions) c0986r22.c();
                        }
                        this.i = new C0986r2(descriptorProtos$ServiceOptions2, E(), this.c);
                        this.h = null;
                    }
                    ((C0965m0) this.i.b()).U(descriptorProtos$ServiceOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$ServiceOptionsF);
            }
            if (this.h != null) {
                this.e |= 4;
                L();
            }
        }
        I(descriptorProtos$ServiceDescriptorProto.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 10) {
                            this.f = abstractC0972o.l();
                            this.e |= 1;
                        } else if (iD == 18) {
                            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto) abstractC0972o.u(DescriptorProtos$MethodDescriptorProto.l, r02);
                            if ((this.e & 2) == 0) {
                                this.g = new ArrayList(this.g);
                                this.e |= 2;
                            }
                            this.g.add(descriptorProtos$MethodDescriptorProto);
                        } else if (iD == 26) {
                            C0986r2 c0986r2 = this.i;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$ServiceOptions = this.h;
                                    if (descriptorProtos$ServiceOptions == null) {
                                        descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.i;
                                    }
                                } else {
                                    descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions) c0986r2.c();
                                }
                                this.i = new C0986r2(descriptorProtos$ServiceOptions, E(), this.c);
                                this.h = null;
                            }
                            abstractC0972o.v(this.i.b(), r02);
                            this.e |= 4;
                        } else if (!p().m(iD, abstractC0972o)) {
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.h();
                }
            } catch (Throwable th) {
                L();
                throw th;
            }
        }
        L();
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProtoM = m();
        if (descriptorProtos$ServiceDescriptorProtoM.isInitialized()) {
            return descriptorProtos$ServiceDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$ServiceDescriptorProtoM);
    }

    public final Object clone() {
        return (C0957k0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2978w;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.h;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions;
        int i = 0;
        while (true) {
            if (i >= this.g.size()) {
                if ((this.e & 4) == 0) {
                    return true;
                }
                C0986r2 c0986r2 = this.i;
                if (c0986r2 == null) {
                    descriptorProtos$ServiceOptions = this.h;
                    if (descriptorProtos$ServiceOptions == null) {
                        descriptorProtos$ServiceOptions = DescriptorProtos$ServiceOptions.i;
                    }
                } else {
                    descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions) c0986r2.c();
                }
                if (!descriptorProtos$ServiceOptions.isInitialized()) {
                    break;
                }
                return true;
            }
            if (!((DescriptorProtos$MethodDescriptorProto) this.g.get(i)).isInitialized()) {
                break;
            }
            i++;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProtoM = m();
        if (descriptorProtos$ServiceDescriptorProtoM.isInitialized()) {
            return descriptorProtos$ServiceDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$ServiceDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$ServiceDescriptorProto) {
            O((DescriptorProtos$ServiceDescriptorProto) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$ServiceDescriptorProto) {
            O((DescriptorProtos$ServiceDescriptorProto) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void v(M2 m2) {
        I(m2);
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a y(D0 d02, Object obj) {
        M(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.h;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
