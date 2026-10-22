package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* renamed from: com.google.protobuf.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0941g0 extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public DescriptorProtos$OneofOptions g;
    public C0986r2 h;

    public C0941g0() {
        super(null);
        this.f = "";
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.p;
        c0868b.g(DescriptorProtos$OneofDescriptorProto.class, C0941g0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$OneofDescriptorProto m() {
        int i;
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = new DescriptorProtos$OneofDescriptorProto(this);
        descriptorProtos$OneofDescriptorProto.d = "";
        descriptorProtos$OneofDescriptorProto.f = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$OneofDescriptorProto.d = this.f;
                i = 1;
            } else {
                i = 0;
            }
            if ((i6 & 2) != 0) {
                C0986r2 c0986r2 = this.h;
                descriptorProtos$OneofDescriptorProto.e = c0986r2 == null ? this.g : (DescriptorProtos$OneofOptions) c0986r2.a();
                i |= 2;
            }
            descriptorProtos$OneofDescriptorProto.c |= i;
        }
        K();
        return descriptorProtos$OneofDescriptorProto;
    }

    public final void O(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions;
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions2;
        if (descriptorProtos$OneofDescriptorProto == DescriptorProtos$OneofDescriptorProto.g) {
            return;
        }
        if ((descriptorProtos$OneofDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$OneofDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (descriptorProtos$OneofDescriptorProto.G()) {
            DescriptorProtos$OneofOptions descriptorProtos$OneofOptionsF = descriptorProtos$OneofDescriptorProto.F();
            C0986r2 c0986r2 = this.h;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 2) == 0 || (descriptorProtos$OneofOptions = this.g) == null || descriptorProtos$OneofOptions == (descriptorProtos$OneofOptions2 = DescriptorProtos$OneofOptions.h)) {
                    this.g = descriptorProtos$OneofOptionsF;
                } else {
                    this.e = i | 2;
                    L();
                    C0986r2 c0986r22 = this.h;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$OneofOptions descriptorProtos$OneofOptions3 = this.g;
                            if (descriptorProtos$OneofOptions3 != null) {
                                descriptorProtos$OneofOptions2 = descriptorProtos$OneofOptions3;
                            }
                        } else {
                            descriptorProtos$OneofOptions2 = (DescriptorProtos$OneofOptions) c0986r22.c();
                        }
                        this.h = new C0986r2(descriptorProtos$OneofOptions2, E(), this.c);
                        this.g = null;
                    }
                    ((C0949i0) this.h.b()).U(descriptorProtos$OneofOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$OneofOptionsF);
            }
            if (this.g != null) {
                this.e |= 2;
                L();
            }
        }
        I(descriptorProtos$OneofDescriptorProto.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions;
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
                            C0986r2 c0986r2 = this.h;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$OneofOptions = this.g;
                                    if (descriptorProtos$OneofOptions == null) {
                                        descriptorProtos$OneofOptions = DescriptorProtos$OneofOptions.h;
                                    }
                                } else {
                                    descriptorProtos$OneofOptions = (DescriptorProtos$OneofOptions) c0986r2.c();
                                }
                                this.h = new C0986r2(descriptorProtos$OneofOptions, E(), this.c);
                                this.g = null;
                            }
                            abstractC0972o.v(this.h.b(), r02);
                            this.e |= 2;
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
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProtoM = m();
        if (descriptorProtos$OneofDescriptorProtoM.isInitialized()) {
            return descriptorProtos$OneofDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$OneofDescriptorProtoM);
    }

    public final Object clone() {
        return (C0941g0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.o;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$OneofDescriptorProto.g;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions;
        if ((this.e & 2) == 0) {
            return true;
        }
        C0986r2 c0986r2 = this.h;
        if (c0986r2 == null) {
            descriptorProtos$OneofOptions = this.g;
            if (descriptorProtos$OneofOptions == null) {
                descriptorProtos$OneofOptions = DescriptorProtos$OneofOptions.h;
            }
        } else {
            descriptorProtos$OneofOptions = (DescriptorProtos$OneofOptions) c0986r2.c();
        }
        return descriptorProtos$OneofOptions.isInitialized();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProtoM = m();
        if (descriptorProtos$OneofDescriptorProtoM.isInitialized()) {
            return descriptorProtos$OneofDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$OneofDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$OneofDescriptorProto) {
            O((DescriptorProtos$OneofDescriptorProto) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$OneofDescriptorProto) {
            O((DescriptorProtos$OneofDescriptorProto) abstractC0924c);
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
        return DescriptorProtos$OneofDescriptorProto.g;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
