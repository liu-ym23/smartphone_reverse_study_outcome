package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* renamed from: com.google.protobuf.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0925c0 extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public Serializable g;
    public Serializable h;
    public DescriptorProtos$MethodOptions i;

    /* renamed from: j, reason: collision with root package name */
    public C0986r2 f2910j;
    public boolean k;
    public boolean l;

    public C0925c0() {
        super(null);
        this.f = "";
        this.g = "";
        this.h = "";
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2980z;
        c0868b.g(DescriptorProtos$MethodDescriptorProto.class, C0925c0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$MethodDescriptorProto m() {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = new DescriptorProtos$MethodDescriptorProto(this);
        descriptorProtos$MethodDescriptorProto.d = "";
        descriptorProtos$MethodDescriptorProto.e = "";
        descriptorProtos$MethodDescriptorProto.f = "";
        int i = 0;
        descriptorProtos$MethodDescriptorProto.h = false;
        descriptorProtos$MethodDescriptorProto.i = false;
        descriptorProtos$MethodDescriptorProto.f2816j = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$MethodDescriptorProto.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$MethodDescriptorProto.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$MethodDescriptorProto.f = this.h;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                C0986r2 c0986r2 = this.f2910j;
                descriptorProtos$MethodDescriptorProto.g = c0986r2 == null ? this.i : (DescriptorProtos$MethodOptions) c0986r2.a();
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$MethodDescriptorProto.h = this.k;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$MethodDescriptorProto.i = this.l;
                i |= 32;
            }
            descriptorProtos$MethodDescriptorProto.c = i | descriptorProtos$MethodDescriptorProto.c;
        }
        K();
        return descriptorProtos$MethodDescriptorProto;
    }

    public final void O(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions2;
        if (descriptorProtos$MethodDescriptorProto == DescriptorProtos$MethodDescriptorProto.k) {
            return;
        }
        if ((descriptorProtos$MethodDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$MethodDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (descriptorProtos$MethodDescriptorProto.J()) {
            this.g = descriptorProtos$MethodDescriptorProto.e;
            this.e |= 2;
            L();
        }
        if (descriptorProtos$MethodDescriptorProto.L()) {
            this.h = descriptorProtos$MethodDescriptorProto.f;
            this.e |= 4;
            L();
        }
        if (descriptorProtos$MethodDescriptorProto.K()) {
            DescriptorProtos$MethodOptions descriptorProtos$MethodOptionsG = descriptorProtos$MethodDescriptorProto.G();
            C0986r2 c0986r2 = this.f2910j;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 8) == 0 || (descriptorProtos$MethodOptions = this.i) == null || descriptorProtos$MethodOptions == (descriptorProtos$MethodOptions2 = DescriptorProtos$MethodOptions.f2817j)) {
                    this.i = descriptorProtos$MethodOptionsG;
                } else {
                    this.e = i | 8;
                    L();
                    C0986r2 c0986r22 = this.f2910j;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$MethodOptions descriptorProtos$MethodOptions3 = this.i;
                            if (descriptorProtos$MethodOptions3 != null) {
                                descriptorProtos$MethodOptions2 = descriptorProtos$MethodOptions3;
                            }
                        } else {
                            descriptorProtos$MethodOptions2 = (DescriptorProtos$MethodOptions) c0986r22.c();
                        }
                        this.f2910j = new C0986r2(descriptorProtos$MethodOptions2, E(), this.c);
                        this.i = null;
                    }
                    ((C0933e0) this.f2910j.b()).U(descriptorProtos$MethodOptionsG);
                }
            } else {
                c0986r2.d(descriptorProtos$MethodOptionsG);
            }
            if (this.i != null) {
                this.e |= 8;
                L();
            }
        }
        if (descriptorProtos$MethodDescriptorProto.I()) {
            this.k = descriptorProtos$MethodDescriptorProto.h;
            this.e |= 16;
            L();
        }
        if (descriptorProtos$MethodDescriptorProto.M()) {
            this.l = descriptorProtos$MethodDescriptorProto.i;
            this.e |= 32;
            L();
        }
        I(descriptorProtos$MethodDescriptorProto.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
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
                            this.g = abstractC0972o.l();
                            this.e |= 2;
                        } else if (iD == 26) {
                            this.h = abstractC0972o.l();
                            this.e |= 4;
                        } else if (iD == 34) {
                            C0986r2 c0986r2 = this.f2910j;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$MethodOptions = this.i;
                                    if (descriptorProtos$MethodOptions == null) {
                                        descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.f2817j;
                                    }
                                } else {
                                    descriptorProtos$MethodOptions = (DescriptorProtos$MethodOptions) c0986r2.c();
                                }
                                this.f2910j = new C0986r2(descriptorProtos$MethodOptions, E(), this.c);
                                this.i = null;
                            }
                            abstractC0972o.v(this.f2910j.b(), r02);
                            this.e |= 8;
                        } else if (iD == 40) {
                            this.k = abstractC0972o.k();
                            this.e |= 16;
                        } else if (iD == 48) {
                            this.l = abstractC0972o.k();
                            this.e |= 32;
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
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProtoM = m();
        if (descriptorProtos$MethodDescriptorProtoM.isInitialized()) {
            return descriptorProtos$MethodDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$MethodDescriptorProtoM);
    }

    public final Object clone() {
        return (C0925c0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.y;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$MethodDescriptorProto.k;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        if ((this.e & 8) == 0) {
            return true;
        }
        C0986r2 c0986r2 = this.f2910j;
        if (c0986r2 == null) {
            descriptorProtos$MethodOptions = this.i;
            if (descriptorProtos$MethodOptions == null) {
                descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.f2817j;
            }
        } else {
            descriptorProtos$MethodOptions = (DescriptorProtos$MethodOptions) c0986r2.c();
        }
        return descriptorProtos$MethodOptions.isInitialized();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProtoM = m();
        if (descriptorProtos$MethodDescriptorProtoM.isInitialized()) {
            return descriptorProtos$MethodDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$MethodDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$MethodDescriptorProto) {
            O((DescriptorProtos$MethodDescriptorProto) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$MethodDescriptorProto) {
            O((DescriptorProtos$MethodDescriptorProto) abstractC0924c);
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
        return DescriptorProtos$MethodDescriptorProto.k;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
