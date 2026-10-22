package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import java.io.Serializable;

/* renamed from: com.google.protobuf.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0996u0 extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public boolean g;

    public C0996u0() {
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
        C0868b c0868b = AbstractC1000v0.f2965V;
        c0868b.g(DescriptorProtos$UninterpretedOption.NamePart.class, C0996u0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$UninterpretedOption.NamePart m() {
        DescriptorProtos$UninterpretedOption.NamePart namePart = new DescriptorProtos$UninterpretedOption.NamePart(this);
        namePart.d = "";
        int i = 0;
        namePart.e = false;
        namePart.f = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                namePart.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                namePart.e = this.g;
                i |= 2;
            }
            namePart.c = i | namePart.c;
        }
        K();
        return namePart;
    }

    public final void O(DescriptorProtos$UninterpretedOption.NamePart namePart) {
        if (namePart == DescriptorProtos$UninterpretedOption.NamePart.g) {
            return;
        }
        if (namePart.G()) {
            this.f = namePart.d;
            this.e |= 1;
            L();
        }
        if (namePart.F()) {
            this.g = namePart.e;
            this.e |= 2;
            L();
        }
        I(namePart.b);
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
                        if (iD == 10) {
                            this.f = abstractC0972o.l();
                            this.e |= 1;
                        } else if (iD == 16) {
                            this.g = abstractC0972o.k();
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
        DescriptorProtos$UninterpretedOption.NamePart namePartM = m();
        if (namePartM.isInitialized()) {
            return namePartM;
        }
        throw AbstractC0916a.x(namePartM);
    }

    public final Object clone() {
        return (C0996u0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2964U;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.NamePart.g;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        int i = this.e;
        return ((i & 1) == 0 || (i & 2) == 0) ? false : true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$UninterpretedOption.NamePart namePartM = m();
        if (namePartM.isInitialized()) {
            return namePartM;
        }
        throw AbstractC0916a.x(namePartM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$UninterpretedOption.NamePart) {
            O((DescriptorProtos$UninterpretedOption.NamePart) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$UninterpretedOption.NamePart) {
            O((DescriptorProtos$UninterpretedOption.NamePart) abstractC0924c);
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
        return DescriptorProtos$UninterpretedOption.NamePart.g;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
