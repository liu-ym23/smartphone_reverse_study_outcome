package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class J extends AbstractC0930d1 {
    public int f;
    public List g;
    public List h;
    public DescriptorProtos$FeatureSet i;

    /* renamed from: j, reason: collision with root package name */
    public C0986r2 f2843j;
    public int k;

    public J() {
        super(null);
        List list = Collections.EMPTY_LIST;
        this.g = list;
        this.h = list;
        this.k = 1;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2972j;
        c0868b.g(DescriptorProtos$ExtensionRangeOptions.class, J.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$ExtensionRangeOptions m() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions = new DescriptorProtos$ExtensionRangeOptions(this);
        int i = 1;
        descriptorProtos$ExtensionRangeOptions.h = 1;
        descriptorProtos$ExtensionRangeOptions.i = (byte) -1;
        if ((this.f & 1) != 0) {
            this.g = Collections.unmodifiableList(this.g);
            this.f &= -2;
        }
        descriptorProtos$ExtensionRangeOptions.e = this.g;
        if ((this.f & 2) != 0) {
            this.h = Collections.unmodifiableList(this.h);
            this.f &= -3;
        }
        descriptorProtos$ExtensionRangeOptions.f = this.h;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.f2843j;
                descriptorProtos$ExtensionRangeOptions.g = c0986r2 == null ? this.i : (DescriptorProtos$FeatureSet) c0986r2.a();
            } else {
                i = 0;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$ExtensionRangeOptions.h = this.k;
                i |= 2;
            }
            descriptorProtos$ExtensionRangeOptions.d = i | descriptorProtos$ExtensionRangeOptions.d;
        }
        K();
        return descriptorProtos$ExtensionRangeOptions;
    }

    public final J U(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD != 18) {
                            DescriptorProtos$ExtensionRangeOptions.VerificationState verificationState = null;
                            if (iD == 24) {
                                int iN = abstractC0972o.n();
                                if (iN == 0) {
                                    verificationState = DescriptorProtos$ExtensionRangeOptions.VerificationState.DECLARATION;
                                } else if (iN != 1) {
                                    DescriptorProtos$ExtensionRangeOptions.VerificationState verificationState2 = DescriptorProtos$ExtensionRangeOptions.VerificationState.DECLARATION;
                                } else {
                                    verificationState = DescriptorProtos$ExtensionRangeOptions.VerificationState.UNVERIFIED;
                                }
                                if (verificationState == null) {
                                    J(3, iN);
                                } else {
                                    this.k = iN;
                                    this.f |= 8;
                                }
                            } else if (iD == 402) {
                                C0986r2 c0986r2 = this.f2843j;
                                if (c0986r2 == null) {
                                    if (c0986r2 == null) {
                                        descriptorProtos$FeatureSet = this.i;
                                        if (descriptorProtos$FeatureSet == null) {
                                            descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                        }
                                    } else {
                                        descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                    }
                                    this.f2843j = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                    this.i = null;
                                }
                                abstractC0972o.v(this.f2843j.b(), r02);
                                this.f |= 4;
                            } else if (iD == 7994) {
                                DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                                if ((this.f & 1) == 0) {
                                    this.g = new ArrayList(this.g);
                                    this.f = 1 | this.f;
                                }
                                this.g.add(descriptorProtos$UninterpretedOption);
                            } else if (!Q(abstractC0972o, r02, iD)) {
                            }
                        } else {
                            DescriptorProtos$ExtensionRangeOptions.Declaration declaration = (DescriptorProtos$ExtensionRangeOptions.Declaration) abstractC0972o.u(DescriptorProtos$ExtensionRangeOptions.Declaration.k, r02);
                            if ((this.f & 2) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f |= 2;
                            }
                            this.h.add(declaration);
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

    public final void V(DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$ExtensionRangeOptions == DescriptorProtos$ExtensionRangeOptions.f2771j) {
            return;
        }
        if (!descriptorProtos$ExtensionRangeOptions.e.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = descriptorProtos$ExtensionRangeOptions.e;
                this.f &= -2;
            } else {
                if ((this.f & 1) == 0) {
                    this.g = new ArrayList(this.g);
                    this.f |= 1;
                }
                this.g.addAll(descriptorProtos$ExtensionRangeOptions.e);
            }
            L();
        }
        if (!descriptorProtos$ExtensionRangeOptions.f.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = descriptorProtos$ExtensionRangeOptions.f;
                this.f &= -3;
            } else {
                if ((this.f & 2) == 0) {
                    this.h = new ArrayList(this.h);
                    this.f |= 2;
                }
                this.h.addAll(descriptorProtos$ExtensionRangeOptions.f);
            }
            L();
        }
        DescriptorProtos$ExtensionRangeOptions.VerificationState verificationState = null;
        if (descriptorProtos$ExtensionRangeOptions.F()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$ExtensionRangeOptions.E();
            C0986r2 c0986r2 = this.f2843j;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 4) == 0 || (descriptorProtos$FeatureSet = this.i) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.i = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 4;
                    L();
                    C0986r2 c0986r22 = this.f2843j;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.i;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.f2843j = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.i = null;
                    }
                    ((N) this.f2843j.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.i != null) {
                this.f |= 4;
                L();
            }
        }
        if (descriptorProtos$ExtensionRangeOptions.G()) {
            int i6 = descriptorProtos$ExtensionRangeOptions.h;
            if (i6 == 0) {
                verificationState = DescriptorProtos$ExtensionRangeOptions.VerificationState.DECLARATION;
            } else if (i6 != 1) {
                DescriptorProtos$ExtensionRangeOptions.VerificationState verificationState2 = DescriptorProtos$ExtensionRangeOptions.VerificationState.DECLARATION;
            } else {
                verificationState = DescriptorProtos$ExtensionRangeOptions.VerificationState.UNVERIFIED;
            }
            if (verificationState == null) {
                verificationState = DescriptorProtos$ExtensionRangeOptions.VerificationState.UNVERIFIED;
            }
            this.f |= 8;
            this.k = verificationState.f2773a;
            L();
        }
        P(descriptorProtos$ExtensionRangeOptions);
        I(descriptorProtos$ExtensionRangeOptions.b);
        L();
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptionsM = m();
        if (descriptorProtos$ExtensionRangeOptionsM.isInitialized()) {
            return descriptorProtos$ExtensionRangeOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$ExtensionRangeOptionsM);
    }

    public final Object clone() {
        return (J) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.i;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$ExtensionRangeOptions.f2771j;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    @Override // com.google.protobuf.Y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized() {
        /*
            r3 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.List r2 = r3.g
            int r2 = r2.size()
            if (r1 >= r2) goto L1c
            java.util.List r2 = r3.g
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.DescriptorProtos$UninterpretedOption r2 = (com.google.protobuf.DescriptorProtos$UninterpretedOption) r2
            boolean r2 = r2.isInitialized()
            if (r2 != 0) goto L19
            goto L40
        L19:
            int r1 = r1 + 1
            goto L2
        L1c:
            int r1 = r3.f
            r1 = r1 & 4
            if (r1 == 0) goto L3a
            com.google.protobuf.r2 r1 = r3.f2843j
            if (r1 != 0) goto L2d
            com.google.protobuf.DescriptorProtos$FeatureSet r1 = r3.i
            if (r1 != 0) goto L33
            com.google.protobuf.DescriptorProtos$FeatureSet r1 = com.google.protobuf.DescriptorProtos$FeatureSet.l
            goto L33
        L2d:
            com.google.protobuf.c r1 = r1.c()
            com.google.protobuf.DescriptorProtos$FeatureSet r1 = (com.google.protobuf.DescriptorProtos$FeatureSet) r1
        L33:
            boolean r1 = r1.isInitialized()
            if (r1 != 0) goto L3a
            goto L40
        L3a:
            boolean r3 = r3.O()
            if (r3 != 0) goto L41
        L40:
            return r0
        L41:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.J.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$ExtensionRangeOptions descriptorProtos$ExtensionRangeOptionsM = m();
        if (descriptorProtos$ExtensionRangeOptionsM.isInitialized()) {
            return descriptorProtos$ExtensionRangeOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$ExtensionRangeOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        U(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$ExtensionRangeOptions) {
            V((DescriptorProtos$ExtensionRangeOptions) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        U(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$ExtensionRangeOptions) {
            V((DescriptorProtos$ExtensionRangeOptions) abstractC0924c);
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
        R(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return DescriptorProtos$ExtensionRangeOptions.f2771j;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        U(abstractC0972o, r02);
        return this;
    }
}
