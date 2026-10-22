package com.google.protobuf;

import c0.C0868b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.i0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0949i0 extends AbstractC0930d1 {
    public int f;
    public DescriptorProtos$FeatureSet g;
    public C0986r2 h;
    public List i;

    public C0949i0() {
        super(null);
        this.i = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2953J;
        c0868b.g(DescriptorProtos$OneofOptions.class, C0949i0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$OneofOptions m() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptions = new DescriptorProtos$OneofOptions(this);
        descriptorProtos$OneofOptions.g = (byte) -1;
        if ((this.f & 2) != 0) {
            this.i = Collections.unmodifiableList(this.i);
            this.f &= -3;
        }
        descriptorProtos$OneofOptions.f = this.i;
        int i = this.f;
        if (i != 0) {
            int i6 = 1;
            if ((i & 1) != 0) {
                C0986r2 c0986r2 = this.h;
                descriptorProtos$OneofOptions.e = c0986r2 == null ? this.g : (DescriptorProtos$FeatureSet) c0986r2.a();
            } else {
                i6 = 0;
            }
            descriptorProtos$OneofOptions.d |= i6;
        }
        K();
        return descriptorProtos$OneofOptions;
    }

    public final void U(DescriptorProtos$OneofOptions descriptorProtos$OneofOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$OneofOptions == DescriptorProtos$OneofOptions.h) {
            return;
        }
        if (descriptorProtos$OneofOptions.F()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$OneofOptions.E();
            C0986r2 c0986r2 = this.h;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 1) == 0 || (descriptorProtos$FeatureSet = this.g) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.g = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 1;
                    L();
                    C0986r2 c0986r22 = this.h;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.g;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.h = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.g = null;
                    }
                    ((N) this.h.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.g != null) {
                this.f |= 1;
                L();
            }
        }
        if (!descriptorProtos$OneofOptions.f.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = descriptorProtos$OneofOptions.f;
                this.f &= -3;
            } else {
                if ((this.f & 2) == 0) {
                    this.i = new ArrayList(this.i);
                    this.f |= 2;
                }
                this.i.addAll(descriptorProtos$OneofOptions.f);
            }
            L();
        }
        P(descriptorProtos$OneofOptions);
        I(descriptorProtos$OneofOptions.b);
        L();
    }

    public final void V(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 10) {
                            C0986r2 c0986r2 = this.h;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.g;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.h = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.g = null;
                            }
                            abstractC0972o.v(this.h.b(), r02);
                            this.f |= 1;
                        } else if (iD == 7994) {
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 2) == 0) {
                                this.i = new ArrayList(this.i);
                                this.f |= 2;
                            }
                            this.i.add(descriptorProtos$UninterpretedOption);
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
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptionsM = m();
        if (descriptorProtos$OneofOptionsM.isInitialized()) {
            return descriptorProtos$OneofOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$OneofOptionsM);
    }

    public final Object clone() {
        return (C0949i0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2952I;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$OneofOptions.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // com.google.protobuf.Y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized() {
        /*
            r4 = this;
            int r0 = r4.f
            r1 = 1
            r0 = r0 & r1
            r2 = 0
            if (r0 == 0) goto L1f
            com.google.protobuf.r2 r0 = r4.h
            if (r0 != 0) goto L12
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r4.g
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
            r0 = r2
        L20:
            java.util.List r3 = r4.i
            int r3 = r3.size()
            if (r0 >= r3) goto L3a
            java.util.List r3 = r4.i
            java.lang.Object r3 = r3.get(r0)
            com.google.protobuf.DescriptorProtos$UninterpretedOption r3 = (com.google.protobuf.DescriptorProtos$UninterpretedOption) r3
            boolean r3 = r3.isInitialized()
            if (r3 != 0) goto L37
            goto L40
        L37:
            int r0 = r0 + 1
            goto L20
        L3a:
            boolean r4 = r4.O()
            if (r4 != 0) goto L41
        L40:
            return r2
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0949i0.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$OneofOptions descriptorProtos$OneofOptionsM = m();
        if (descriptorProtos$OneofOptionsM.isInitialized()) {
            return descriptorProtos$OneofOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$OneofOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$OneofOptions) {
            U((DescriptorProtos$OneofOptions) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$OneofOptions) {
            U((DescriptorProtos$OneofOptions) abstractC0924c);
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
        return DescriptorProtos$OneofOptions.h;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }
}
