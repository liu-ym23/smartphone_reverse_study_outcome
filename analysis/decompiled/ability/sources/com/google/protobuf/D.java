package com.google.protobuf;

import c0.C0868b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class D extends AbstractC0930d1 {
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public DescriptorProtos$FeatureSet f2761j;
    public C0986r2 k;
    public List l;

    public D() {
        super(null);
        this.l = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2955L;
        c0868b.g(DescriptorProtos$EnumOptions.class, D.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$EnumOptions m() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions = new DescriptorProtos$EnumOptions(this);
        int i = 0;
        descriptorProtos$EnumOptions.e = false;
        descriptorProtos$EnumOptions.f = false;
        descriptorProtos$EnumOptions.g = false;
        descriptorProtos$EnumOptions.f2769j = (byte) -1;
        if ((this.f & 16) != 0) {
            this.l = Collections.unmodifiableList(this.l);
            this.f &= -17;
        }
        descriptorProtos$EnumOptions.i = this.l;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$EnumOptions.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$EnumOptions.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$EnumOptions.g = this.i;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                C0986r2 c0986r2 = this.k;
                descriptorProtos$EnumOptions.h = c0986r2 == null ? this.f2761j : (DescriptorProtos$FeatureSet) c0986r2.a();
                i |= 8;
            }
            descriptorProtos$EnumOptions.d = i | descriptorProtos$EnumOptions.d;
        }
        K();
        return descriptorProtos$EnumOptions;
    }

    public final D U(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 16) {
                            this.g = abstractC0972o.k();
                            this.f |= 1;
                        } else if (iD == 24) {
                            this.h = abstractC0972o.k();
                            this.f |= 2;
                        } else if (iD == 48) {
                            this.i = abstractC0972o.k();
                            this.f |= 4;
                        } else if (iD == 58) {
                            C0986r2 c0986r2 = this.k;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.f2761j;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.k = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.f2761j = null;
                            }
                            abstractC0972o.v(this.k.b(), r02);
                            this.f |= 8;
                        } else if (iD == 7994) {
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 16) == 0) {
                                this.l = new ArrayList(this.l);
                                this.f |= 16;
                            }
                            this.l.add(descriptorProtos$UninterpretedOption);
                        } else if (!Q(abstractC0972o, r02, iD)) {
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

    public final D V(DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$EnumOptions == DescriptorProtos$EnumOptions.k) {
            return this;
        }
        if ((descriptorProtos$EnumOptions.d & 1) != 0) {
            this.g = descriptorProtos$EnumOptions.e;
            this.f |= 1;
            L();
        }
        if (descriptorProtos$EnumOptions.F()) {
            this.h = descriptorProtos$EnumOptions.f;
            this.f |= 2;
            L();
        }
        if (descriptorProtos$EnumOptions.G()) {
            this.i = descriptorProtos$EnumOptions.g;
            this.f |= 4;
            L();
        }
        if (descriptorProtos$EnumOptions.H()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$EnumOptions.E();
            C0986r2 c0986r2 = this.k;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 8) == 0 || (descriptorProtos$FeatureSet = this.f2761j) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.f2761j = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 8;
                    L();
                    C0986r2 c0986r22 = this.k;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.f2761j;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.k = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.f2761j = null;
                    }
                    ((N) this.k.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.f2761j != null) {
                this.f |= 8;
                L();
            }
        }
        if (!descriptorProtos$EnumOptions.i.isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = descriptorProtos$EnumOptions.i;
                this.f &= -17;
            } else {
                if ((this.f & 16) == 0) {
                    this.l = new ArrayList(this.l);
                    this.f |= 16;
                }
                this.l.addAll(descriptorProtos$EnumOptions.i);
            }
            L();
        }
        P(descriptorProtos$EnumOptions);
        I(descriptorProtos$EnumOptions.b);
        L();
        return this;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptionsM = m();
        if (descriptorProtos$EnumOptionsM.isInitialized()) {
            return descriptorProtos$EnumOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumOptionsM);
    }

    public final Object clone() {
        return (D) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2954K;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$EnumOptions.k;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // com.google.protobuf.Y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized() {
        /*
            r3 = this;
            int r0 = r3.f
            r0 = r0 & 8
            r1 = 0
            if (r0 == 0) goto L1f
            com.google.protobuf.r2 r0 = r3.k
            if (r0 != 0) goto L12
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r3.f2761j
            if (r0 != 0) goto L18
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = com.google.protobuf.DescriptorProtos$FeatureSet.l
            goto L18
        L12:
            com.google.protobuf.c r0 = r0.c()
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = (com.google.protobuf.DescriptorProtos$FeatureSet) r0
        L18:
            boolean r0 = r0.isInitialized()
            if (r0 != 0) goto L1f
            goto L40
        L1f:
            r0 = r1
        L20:
            java.util.List r2 = r3.l
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.l
            java.lang.Object r2 = r2.get(r0)
            com.google.protobuf.DescriptorProtos$UninterpretedOption r2 = (com.google.protobuf.DescriptorProtos$UninterpretedOption) r2
            boolean r2 = r2.isInitialized()
            if (r2 != 0) goto L37
            goto L40
        L37:
            int r0 = r0 + 1
            goto L20
        L3a:
            boolean r3 = r3.O()
            if (r3 != 0) goto L41
        L40:
            return r1
        L41:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.D.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptionsM = m();
        if (descriptorProtos$EnumOptionsM.isInitialized()) {
            return descriptorProtos$EnumOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        U(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$EnumOptions) {
            V((DescriptorProtos$EnumOptions) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$EnumOptions) {
            V((DescriptorProtos$EnumOptions) abstractC0924c);
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
        return DescriptorProtos$EnumOptions.k;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        U(abstractC0972o, r02);
        return this;
    }
}
