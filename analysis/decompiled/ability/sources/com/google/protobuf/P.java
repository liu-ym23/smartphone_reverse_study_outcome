package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import c0.C0868b;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class P extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public Serializable f2862j;
    public Serializable k;
    public Serializable l;
    public int m;
    public Serializable n;
    public DescriptorProtos$FieldOptions o;
    public C0986r2 p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2863q;

    public P() {
        super(null);
        this.f = "";
        this.h = 1;
        this.i = 1;
        this.f2862j = "";
        this.k = "";
        this.l = "";
        this.n = "";
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.n;
        c0868b.g(DescriptorProtos$FieldDescriptorProto.class, P.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FieldDescriptorProto m() {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = new DescriptorProtos$FieldDescriptorProto(this);
        descriptorProtos$FieldDescriptorProto.d = "";
        int i = 0;
        descriptorProtos$FieldDescriptorProto.e = 0;
        descriptorProtos$FieldDescriptorProto.f = 1;
        descriptorProtos$FieldDescriptorProto.g = 1;
        descriptorProtos$FieldDescriptorProto.h = "";
        descriptorProtos$FieldDescriptorProto.i = "";
        descriptorProtos$FieldDescriptorProto.f2782j = "";
        descriptorProtos$FieldDescriptorProto.k = 0;
        descriptorProtos$FieldDescriptorProto.l = "";
        descriptorProtos$FieldDescriptorProto.n = false;
        descriptorProtos$FieldDescriptorProto.o = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$FieldDescriptorProto.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$FieldDescriptorProto.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$FieldDescriptorProto.f = this.h;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$FieldDescriptorProto.g = this.i;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$FieldDescriptorProto.h = this.f2862j;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$FieldDescriptorProto.i = this.k;
                i |= 32;
            }
            if ((i6 & 64) != 0) {
                descriptorProtos$FieldDescriptorProto.f2782j = this.l;
                i |= 64;
            }
            if ((i6 & 128) != 0) {
                descriptorProtos$FieldDescriptorProto.k = this.m;
                i |= 128;
            }
            if ((i6 & 256) != 0) {
                descriptorProtos$FieldDescriptorProto.l = this.n;
                i |= 256;
            }
            if ((i6 & 512) != 0) {
                C0986r2 c0986r2 = this.p;
                descriptorProtos$FieldDescriptorProto.m = c0986r2 == null ? this.o : (DescriptorProtos$FieldOptions) c0986r2.a();
                i |= 512;
            }
            if ((i6 & 1024) != 0) {
                descriptorProtos$FieldDescriptorProto.n = this.f2863q;
                i |= 1024;
            }
            descriptorProtos$FieldDescriptorProto.c |= i;
        }
        K();
        return descriptorProtos$FieldDescriptorProto;
    }

    public final void O(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions2;
        if (descriptorProtos$FieldDescriptorProto == DescriptorProtos$FieldDescriptorProto.p) {
            return;
        }
        if ((descriptorProtos$FieldDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$FieldDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.O()) {
            this.g = descriptorProtos$FieldDescriptorProto.e;
            this.e |= 2;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.N()) {
            DescriptorProtos$FieldDescriptorProto.Label labelA = DescriptorProtos$FieldDescriptorProto.Label.a(descriptorProtos$FieldDescriptorProto.f);
            if (labelA == null) {
                labelA = DescriptorProtos$FieldDescriptorProto.Label.LABEL_OPTIONAL;
            }
            this.e |= 4;
            this.h = labelA.f2783a;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.S()) {
            DescriptorProtos$FieldDescriptorProto.Type typeA = DescriptorProtos$FieldDescriptorProto.Type.a(descriptorProtos$FieldDescriptorProto.g);
            if (typeA == null) {
                typeA = DescriptorProtos$FieldDescriptorProto.Type.TYPE_DOUBLE;
            }
            this.e |= 8;
            this.i = typeA.f2789a;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.T()) {
            this.f2862j = descriptorProtos$FieldDescriptorProto.h;
            this.e |= 16;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.L()) {
            this.k = descriptorProtos$FieldDescriptorProto.i;
            this.e |= 32;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.K()) {
            this.l = descriptorProtos$FieldDescriptorProto.f2782j;
            this.e |= 64;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.P()) {
            this.m = descriptorProtos$FieldDescriptorProto.k;
            this.e |= 128;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.M()) {
            this.n = descriptorProtos$FieldDescriptorProto.l;
            this.e |= 256;
            L();
        }
        if (descriptorProtos$FieldDescriptorProto.Q()) {
            DescriptorProtos$FieldOptions descriptorProtos$FieldOptionsI = descriptorProtos$FieldDescriptorProto.I();
            C0986r2 c0986r2 = this.p;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 512) == 0 || (descriptorProtos$FieldOptions = this.o) == null || descriptorProtos$FieldOptions == (descriptorProtos$FieldOptions2 = DescriptorProtos$FieldOptions.f2790s)) {
                    this.o = descriptorProtos$FieldOptionsI;
                } else {
                    this.e = i | 512;
                    L();
                    C0986r2 c0986r22 = this.p;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FieldOptions descriptorProtos$FieldOptions3 = this.o;
                            if (descriptorProtos$FieldOptions3 != null) {
                                descriptorProtos$FieldOptions2 = descriptorProtos$FieldOptions3;
                            }
                        } else {
                            descriptorProtos$FieldOptions2 = (DescriptorProtos$FieldOptions) c0986r22.c();
                        }
                        this.p = new C0986r2(descriptorProtos$FieldOptions2, E(), this.c);
                        this.o = null;
                    }
                    ((S) this.p.b()).V(descriptorProtos$FieldOptionsI);
                }
            } else {
                c0986r2.d(descriptorProtos$FieldOptionsI);
            }
            if (this.o != null) {
                this.e |= 512;
                L();
            }
        }
        if (descriptorProtos$FieldDescriptorProto.R()) {
            this.f2863q = descriptorProtos$FieldDescriptorProto.n;
            this.e |= 1024;
            L();
        }
        I(descriptorProtos$FieldDescriptorProto.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    switch (iD) {
                        case 0:
                            z10 = true;
                        case 10:
                            this.f = abstractC0972o.l();
                            this.e |= 1;
                        case 18:
                            this.k = abstractC0972o.l();
                            this.e |= 32;
                        case 24:
                            this.g = abstractC0972o.s();
                            this.e |= 2;
                        case 32:
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$FieldDescriptorProto.Label.a(iN) == null) {
                                J(4, iN);
                            } else {
                                this.h = iN;
                                this.e |= 4;
                            }
                        case 40:
                            int iN2 = abstractC0972o.n();
                            if (DescriptorProtos$FieldDescriptorProto.Type.a(iN2) == null) {
                                J(5, iN2);
                            } else {
                                this.i = iN2;
                                this.e |= 8;
                            }
                        case 50:
                            this.f2862j = abstractC0972o.l();
                            this.e |= 16;
                        case 58:
                            this.l = abstractC0972o.l();
                            this.e |= 64;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            C0986r2 c0986r2 = this.p;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FieldOptions = this.o;
                                    if (descriptorProtos$FieldOptions == null) {
                                        descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.f2790s;
                                    }
                                } else {
                                    descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions) c0986r2.c();
                                }
                                this.p = new C0986r2(descriptorProtos$FieldOptions, E(), this.c);
                                this.o = null;
                            }
                            abstractC0972o.v(this.p.b(), r02);
                            this.e |= 512;
                        case 72:
                            this.m = abstractC0972o.s();
                            this.e |= 128;
                        case 82:
                            this.n = abstractC0972o.l();
                            this.e |= 256;
                        case 136:
                            this.f2863q = abstractC0972o.k();
                            this.e |= 1024;
                        default:
                            if (!p().m(iD, abstractC0972o)) {
                                z10 = true;
                            }
                    }
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
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProtoM = m();
        if (descriptorProtos$FieldDescriptorProtoM.isInitialized()) {
            return descriptorProtos$FieldDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$FieldDescriptorProtoM);
    }

    public final Object clone() {
        return (P) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.m;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FieldDescriptorProto.p;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions;
        if ((this.e & 512) == 0) {
            return true;
        }
        C0986r2 c0986r2 = this.p;
        if (c0986r2 == null) {
            descriptorProtos$FieldOptions = this.o;
            if (descriptorProtos$FieldOptions == null) {
                descriptorProtos$FieldOptions = DescriptorProtos$FieldOptions.f2790s;
            }
        } else {
            descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions) c0986r2.c();
        }
        return descriptorProtos$FieldOptions.isInitialized();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProtoM = m();
        if (descriptorProtos$FieldDescriptorProtoM.isInitialized()) {
            return descriptorProtos$FieldDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$FieldDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FieldDescriptorProto) {
            O((DescriptorProtos$FieldDescriptorProto) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$FieldDescriptorProto) {
            O((DescriptorProtos$FieldDescriptorProto) abstractC0924c);
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
        return DescriptorProtos$FieldDescriptorProto.p;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
