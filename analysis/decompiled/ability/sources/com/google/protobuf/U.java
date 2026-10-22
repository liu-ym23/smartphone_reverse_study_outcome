package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class U extends AbstractC0926c1 {
    public int e;
    public int f;
    public Serializable g;

    public U() {
        super(null);
        this.f = 0;
        this.g = "";
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2951H;
        c0868b.g(DescriptorProtos$FieldOptions.EditionDefault.class, U.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FieldOptions.EditionDefault m() {
        DescriptorProtos$FieldOptions.EditionDefault editionDefault = new DescriptorProtos$FieldOptions.EditionDefault(this);
        int i = 0;
        editionDefault.d = 0;
        editionDefault.e = "";
        editionDefault.f = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                editionDefault.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                editionDefault.e = this.g;
                i |= 2;
            }
            editionDefault.c = i | editionDefault.c;
        }
        K();
        return editionDefault;
    }

    public final void O(DescriptorProtos$FieldOptions.EditionDefault editionDefault) {
        if (editionDefault == DescriptorProtos$FieldOptions.EditionDefault.g) {
            return;
        }
        if ((editionDefault.c & 1) != 0) {
            DescriptorProtos$Edition descriptorProtos$EditionA = DescriptorProtos$Edition.a(editionDefault.d);
            if (descriptorProtos$EditionA == null) {
                descriptorProtos$EditionA = DescriptorProtos$Edition.EDITION_UNKNOWN;
            }
            this.e |= 1;
            this.f = descriptorProtos$EditionA.f2767a;
            L();
        }
        if (editionDefault.F()) {
            this.g = editionDefault.e;
            this.e |= 2;
            L();
        }
        I(editionDefault.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 18) {
                            this.g = abstractC0972o.l();
                            this.e |= 2;
                        } else if (iD == 24) {
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$Edition.a(iN) == null) {
                                J(3, iN);
                            } else {
                                this.f = iN;
                                this.e |= 1;
                            }
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
        DescriptorProtos$FieldOptions.EditionDefault editionDefaultM = m();
        if (editionDefaultM.isInitialized()) {
            return editionDefaultM;
        }
        throw AbstractC0916a.x(editionDefaultM);
    }

    public final Object clone() {
        return (U) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2950G;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.EditionDefault.g;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$FieldOptions.EditionDefault editionDefaultM = m();
        if (editionDefaultM.isInitialized()) {
            return editionDefaultM;
        }
        throw AbstractC0916a.x(editionDefaultM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FieldOptions.EditionDefault) {
            O((DescriptorProtos$FieldOptions.EditionDefault) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$FieldOptions.EditionDefault) {
            O((DescriptorProtos$FieldOptions.EditionDefault) abstractC0924c);
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
        return DescriptorProtos$FieldOptions.EditionDefault.g;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
