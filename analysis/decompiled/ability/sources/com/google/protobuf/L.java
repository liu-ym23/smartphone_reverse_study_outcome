package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class L extends AbstractC0926c1 {
    public int e;
    public int f;
    public Serializable g;
    public Serializable h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2850j;

    public L() {
        super(null);
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
        C0868b c0868b = AbstractC1000v0.l;
        c0868b.g(DescriptorProtos$ExtensionRangeOptions.Declaration.class, L.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$ExtensionRangeOptions.Declaration m() {
        DescriptorProtos$ExtensionRangeOptions.Declaration declaration = new DescriptorProtos$ExtensionRangeOptions.Declaration(this);
        int i = 0;
        declaration.d = 0;
        declaration.e = "";
        declaration.f = "";
        declaration.g = false;
        declaration.h = false;
        declaration.i = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                declaration.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                declaration.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                declaration.f = this.h;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                declaration.g = this.i;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                declaration.h = this.f2850j;
                i |= 16;
            }
            declaration.c = i | declaration.c;
        }
        K();
        return declaration;
    }

    public final void O(DescriptorProtos$ExtensionRangeOptions.Declaration declaration) {
        if (declaration == DescriptorProtos$ExtensionRangeOptions.Declaration.f2772j) {
            return;
        }
        if ((declaration.c & 1) != 0) {
            this.f = declaration.d;
            this.e |= 1;
            L();
        }
        if (declaration.G()) {
            this.g = declaration.e;
            this.e |= 2;
            L();
        }
        if (declaration.J()) {
            this.h = declaration.f;
            this.e |= 4;
            L();
        }
        if (declaration.I()) {
            this.i = declaration.g;
            this.e |= 8;
            L();
        }
        if (declaration.H()) {
            this.f2850j = declaration.h;
            this.e |= 16;
            L();
        }
        I(declaration.b);
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
                        if (iD == 8) {
                            this.f = abstractC0972o.s();
                            this.e |= 1;
                        } else if (iD == 18) {
                            this.g = abstractC0972o.l();
                            this.e |= 2;
                        } else if (iD == 26) {
                            this.h = abstractC0972o.l();
                            this.e |= 4;
                        } else if (iD == 40) {
                            this.i = abstractC0972o.k();
                            this.e |= 8;
                        } else if (iD == 48) {
                            this.f2850j = abstractC0972o.k();
                            this.e |= 16;
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
        DescriptorProtos$ExtensionRangeOptions.Declaration declarationM = m();
        if (declarationM.isInitialized()) {
            return declarationM;
        }
        throw AbstractC0916a.x(declarationM);
    }

    public final Object clone() {
        return (L) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.k;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$ExtensionRangeOptions.Declaration.f2772j;
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
        DescriptorProtos$ExtensionRangeOptions.Declaration declarationM = m();
        if (declarationM.isInitialized()) {
            return declarationM;
        }
        throw AbstractC0916a.x(declarationM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$ExtensionRangeOptions.Declaration) {
            O((DescriptorProtos$ExtensionRangeOptions.Declaration) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$ExtensionRangeOptions.Declaration) {
            O((DescriptorProtos$ExtensionRangeOptions.Declaration) abstractC0924c);
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
        return DescriptorProtos$ExtensionRangeOptions.Declaration.f2772j;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
