package com.google.protobuf;

import c0.C0868b;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class F extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public int g;
    public DescriptorProtos$EnumValueOptions h;
    public C0986r2 i;

    public F() {
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
        C0868b c0868b = AbstractC1000v0.f2977v;
        c0868b.g(DescriptorProtos$EnumValueDescriptorProto.class, F.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final DescriptorProtos$EnumValueDescriptorProto m() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = new DescriptorProtos$EnumValueDescriptorProto(this);
        descriptorProtos$EnumValueDescriptorProto.d = "";
        int i = 0;
        descriptorProtos$EnumValueDescriptorProto.e = 0;
        descriptorProtos$EnumValueDescriptorProto.g = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$EnumValueDescriptorProto.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$EnumValueDescriptorProto.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.i;
                descriptorProtos$EnumValueDescriptorProto.f = c0986r2 == null ? this.h : (DescriptorProtos$EnumValueOptions) c0986r2.a();
                i |= 4;
            }
            descriptorProtos$EnumValueDescriptorProto.c = i | descriptorProtos$EnumValueDescriptorProto.c;
        }
        K();
        return descriptorProtos$EnumValueDescriptorProto;
    }

    public final F O(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
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
                        } else if (iD == 16) {
                            this.g = abstractC0972o.s();
                            this.e |= 2;
                        } else if (iD == 26) {
                            C0986r2 c0986r2 = this.i;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$EnumValueOptions = this.h;
                                    if (descriptorProtos$EnumValueOptions == null) {
                                        descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.f2770j;
                                    }
                                } else {
                                    descriptorProtos$EnumValueOptions = (DescriptorProtos$EnumValueOptions) c0986r2.c();
                                }
                                this.i = new C0986r2(descriptorProtos$EnumValueOptions, E(), this.c);
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

    public final F P(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions2;
        if (descriptorProtos$EnumValueDescriptorProto == DescriptorProtos$EnumValueDescriptorProto.h) {
            return this;
        }
        if ((descriptorProtos$EnumValueDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$EnumValueDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (descriptorProtos$EnumValueDescriptorProto.G()) {
            this.g = descriptorProtos$EnumValueDescriptorProto.e;
            this.e |= 2;
            L();
        }
        if (descriptorProtos$EnumValueDescriptorProto.H()) {
            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptionsF = descriptorProtos$EnumValueDescriptorProto.F();
            C0986r2 c0986r2 = this.i;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 4) == 0 || (descriptorProtos$EnumValueOptions = this.h) == null || descriptorProtos$EnumValueOptions == (descriptorProtos$EnumValueOptions2 = DescriptorProtos$EnumValueOptions.f2770j)) {
                    this.h = descriptorProtos$EnumValueOptionsF;
                } else {
                    this.e = i | 4;
                    L();
                    C0986r2 c0986r22 = this.i;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions3 = this.h;
                            if (descriptorProtos$EnumValueOptions3 != null) {
                                descriptorProtos$EnumValueOptions2 = descriptorProtos$EnumValueOptions3;
                            }
                        } else {
                            descriptorProtos$EnumValueOptions2 = (DescriptorProtos$EnumValueOptions) c0986r22.c();
                        }
                        this.i = new C0986r2(descriptorProtos$EnumValueOptions2, E(), this.c);
                        this.h = null;
                    }
                    ((H) this.i.b()).V(descriptorProtos$EnumValueOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$EnumValueOptionsF);
            }
            if (this.h != null) {
                this.e |= 4;
                L();
            }
        }
        I(descriptorProtos$EnumValueDescriptorProto.b);
        L();
        return this;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProtoBuildPartial = buildPartial();
        if (descriptorProtos$EnumValueDescriptorProtoBuildPartial.isInitialized()) {
            return descriptorProtos$EnumValueDescriptorProtoBuildPartial;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumValueDescriptorProtoBuildPartial);
    }

    public final Object clone() {
        return (F) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.u;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueDescriptorProto.h;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        if ((this.e & 4) == 0) {
            return true;
        }
        C0986r2 c0986r2 = this.i;
        if (c0986r2 == null) {
            descriptorProtos$EnumValueOptions = this.h;
            if (descriptorProtos$EnumValueOptions == null) {
                descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.f2770j;
            }
        } else {
            descriptorProtos$EnumValueOptions = (DescriptorProtos$EnumValueOptions) c0986r2.c();
        }
        return descriptorProtos$EnumValueOptions.isInitialized();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProtoBuildPartial = buildPartial();
        if (descriptorProtos$EnumValueDescriptorProtoBuildPartial.isInitialized()) {
            return descriptorProtos$EnumValueDescriptorProtoBuildPartial;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumValueDescriptorProtoBuildPartial);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$EnumValueDescriptorProto) {
            P((DescriptorProtos$EnumValueDescriptorProto) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$EnumValueDescriptorProto) {
            P((DescriptorProtos$EnumValueDescriptorProto) abstractC0924c);
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
        return DescriptorProtos$EnumValueDescriptorProto.h;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }
}
