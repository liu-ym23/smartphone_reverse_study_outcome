package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$DescriptorProto;

/* renamed from: com.google.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0999v extends AbstractC0926c1 {
    public int e;
    public int f;
    public int g;
    public DescriptorProtos$ExtensionRangeOptions h;
    public C0986r2 i;

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f;
        c0868b.g(DescriptorProtos$DescriptorProto.ExtensionRange.class, C0999v.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$DescriptorProto.ExtensionRange m() {
        DescriptorProtos$DescriptorProto.ExtensionRange extensionRange = new DescriptorProtos$DescriptorProto.ExtensionRange(this);
        int i = 0;
        extensionRange.d = 0;
        extensionRange.e = 0;
        extensionRange.g = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                extensionRange.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                extensionRange.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.i;
                extensionRange.f = c0986r2 == null ? this.h : (DescriptorProtos$ExtensionRangeOptions) c0986r2.a();
                i |= 4;
            }
            extensionRange.c = i | extensionRange.c;
        }
        K();
        return extensionRange;
    }

    public final C0999v O(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 8) {
                            this.f = abstractC0972o.s();
                            this.e |= 1;
                        } else if (iD == 16) {
                            this.g = abstractC0972o.s();
                            this.e |= 2;
                        } else if (iD == 26) {
                            C0986r2 c0986r2 = this.i;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$ExtensionRangeOptions = this.h;
                                    if (descriptorProtos$ExtensionRangeOptions == null) {
                                        descriptorProtos$ExtensionRangeOptions = DescriptorProtos$ExtensionRangeOptions.f2771j;
                                    }
                                } else {
                                    descriptorProtos$ExtensionRangeOptions = (DescriptorProtos$ExtensionRangeOptions) c0986r2.c();
                                }
                                this.i = new C0986r2(descriptorProtos$ExtensionRangeOptions, E(), this.c);
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
        return this;
    }

    public final C0999v P(DescriptorProtos$DescriptorProto.ExtensionRange extensionRange) {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions2;
        if (extensionRange == DescriptorProtos$DescriptorProto.ExtensionRange.h) {
            return this;
        }
        if ((extensionRange.c & 1) != 0) {
            this.f = extensionRange.d;
            this.e |= 1;
            L();
        }
        if (extensionRange.F()) {
            this.g = extensionRange.e;
            this.e |= 2;
            L();
        }
        if (extensionRange.G()) {
            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptionsE = extensionRange.E();
            C0986r2 c0986r2 = this.i;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 4) == 0 || (descriptorProtos$ExtensionRangeOptions = this.h) == null || descriptorProtos$ExtensionRangeOptions == (descriptorProtos$ExtensionRangeOptions2 = DescriptorProtos$ExtensionRangeOptions.f2771j)) {
                    this.h = descriptorProtos$ExtensionRangeOptionsE;
                } else {
                    this.e = i | 4;
                    L();
                    C0986r2 c0986r22 = this.i;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions3 = this.h;
                            if (descriptorProtos$ExtensionRangeOptions3 != null) {
                                descriptorProtos$ExtensionRangeOptions2 = descriptorProtos$ExtensionRangeOptions3;
                            }
                        } else {
                            descriptorProtos$ExtensionRangeOptions2 = (DescriptorProtos$ExtensionRangeOptions) c0986r22.c();
                        }
                        this.i = new C0986r2(descriptorProtos$ExtensionRangeOptions2, E(), this.c);
                        this.h = null;
                    }
                    ((J) this.i.b()).V(descriptorProtos$ExtensionRangeOptionsE);
                }
            } else {
                c0986r2.d(descriptorProtos$ExtensionRangeOptionsE);
            }
            if (this.h != null) {
                this.e |= 4;
                L();
            }
        }
        I(extensionRange.b);
        L();
        return this;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$DescriptorProto.ExtensionRange extensionRangeM = m();
        if (extensionRangeM.isInitialized()) {
            return extensionRangeM;
        }
        throw AbstractC0916a.x(extensionRangeM);
    }

    public final Object clone() {
        return (C0999v) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.e;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.ExtensionRange.h;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions;
        if ((this.e & 4) == 0) {
            return true;
        }
        C0986r2 c0986r2 = this.i;
        if (c0986r2 == null) {
            descriptorProtos$ExtensionRangeOptions = this.h;
            if (descriptorProtos$ExtensionRangeOptions == null) {
                descriptorProtos$ExtensionRangeOptions = DescriptorProtos$ExtensionRangeOptions.f2771j;
            }
        } else {
            descriptorProtos$ExtensionRangeOptions = (DescriptorProtos$ExtensionRangeOptions) c0986r2.c();
        }
        return descriptorProtos$ExtensionRangeOptions.isInitialized();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$DescriptorProto.ExtensionRange extensionRangeM = m();
        if (extensionRangeM.isInitialized()) {
            return extensionRangeM;
        }
        throw AbstractC0916a.x(extensionRangeM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$DescriptorProto.ExtensionRange) {
            P((DescriptorProtos$DescriptorProto.ExtensionRange) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$DescriptorProto.ExtensionRange) {
            P((DescriptorProtos$DescriptorProto.ExtensionRange) abstractC0924c);
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
        return DescriptorProtos$DescriptorProto.ExtensionRange.h;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }
}
