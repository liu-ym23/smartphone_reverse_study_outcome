package com.google.protobuf;

import c0.C0868b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.a0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0917a0 extends AbstractC0930d1 {
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2906j;
    public boolean k;
    public DescriptorProtos$FeatureSet l;
    public C0986r2 m;
    public List n;

    public C0917a0() {
        super(null);
        this.n = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2948D;
        c0868b.g(DescriptorProtos$MessageOptions.class, C0917a0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$MessageOptions m() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = new DescriptorProtos$MessageOptions(this);
        int i = 0;
        descriptorProtos$MessageOptions.e = false;
        descriptorProtos$MessageOptions.f = false;
        descriptorProtos$MessageOptions.g = false;
        descriptorProtos$MessageOptions.h = false;
        descriptorProtos$MessageOptions.i = false;
        descriptorProtos$MessageOptions.l = (byte) -1;
        if ((this.f & 64) != 0) {
            this.n = Collections.unmodifiableList(this.n);
            this.f &= -65;
        }
        descriptorProtos$MessageOptions.k = this.n;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$MessageOptions.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$MessageOptions.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$MessageOptions.g = this.i;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$MessageOptions.h = this.f2906j;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$MessageOptions.i = this.k;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                C0986r2 c0986r2 = this.m;
                descriptorProtos$MessageOptions.f2815j = c0986r2 == null ? this.l : (DescriptorProtos$FeatureSet) c0986r2.a();
                i |= 32;
            }
            descriptorProtos$MessageOptions.d = i | descriptorProtos$MessageOptions.d;
        }
        K();
        return descriptorProtos$MessageOptions;
    }

    public final void U(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$MessageOptions == DescriptorProtos$MessageOptions.m) {
            return;
        }
        if ((descriptorProtos$MessageOptions.d & 1) != 0) {
            this.g = descriptorProtos$MessageOptions.e;
            this.f |= 1;
            L();
        }
        if (descriptorProtos$MessageOptions.J()) {
            this.h = descriptorProtos$MessageOptions.f;
            this.f |= 2;
            L();
        }
        if (descriptorProtos$MessageOptions.F()) {
            this.i = descriptorProtos$MessageOptions.g;
            this.f |= 4;
            L();
        }
        if (descriptorProtos$MessageOptions.I()) {
            this.f2906j = descriptorProtos$MessageOptions.h;
            this.f |= 8;
            L();
        }
        if (descriptorProtos$MessageOptions.G()) {
            this.k = descriptorProtos$MessageOptions.i;
            this.f |= 16;
            L();
        }
        if (descriptorProtos$MessageOptions.H()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$MessageOptions.E();
            C0986r2 c0986r2 = this.m;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 32) == 0 || (descriptorProtos$FeatureSet = this.l) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.l = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 32;
                    L();
                    C0986r2 c0986r22 = this.m;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.l;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.m = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.l = null;
                    }
                    ((N) this.m.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.l != null) {
                this.f |= 32;
                L();
            }
        }
        if (!descriptorProtos$MessageOptions.k.isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = descriptorProtos$MessageOptions.k;
                this.f &= -65;
            } else {
                if ((this.f & 64) == 0) {
                    this.n = new ArrayList(this.n);
                    this.f |= 64;
                }
                this.n.addAll(descriptorProtos$MessageOptions.k);
            }
            L();
        }
        P(descriptorProtos$MessageOptions);
        I(descriptorProtos$MessageOptions.b);
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
                        if (iD == 8) {
                            this.g = abstractC0972o.k();
                            this.f |= 1;
                        } else if (iD == 16) {
                            this.h = abstractC0972o.k();
                            this.f |= 2;
                        } else if (iD == 24) {
                            this.i = abstractC0972o.k();
                            this.f |= 4;
                        } else if (iD == 56) {
                            this.f2906j = abstractC0972o.k();
                            this.f |= 8;
                        } else if (iD == 88) {
                            this.k = abstractC0972o.k();
                            this.f |= 16;
                        } else if (iD == 98) {
                            C0986r2 c0986r2 = this.m;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.l;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.m = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.l = null;
                            }
                            abstractC0972o.v(this.m.b(), r02);
                            this.f |= 32;
                        } else if (iD == 7994) {
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 64) == 0) {
                                this.n = new ArrayList(this.n);
                                this.f |= 64;
                            }
                            this.n.add(descriptorProtos$UninterpretedOption);
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
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptionsM = m();
        if (descriptorProtos$MessageOptionsM.isInitialized()) {
            return descriptorProtos$MessageOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$MessageOptionsM);
    }

    public final Object clone() {
        return (C0917a0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2947C;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$MessageOptions.m;
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
            r0 = r0 & 32
            r1 = 0
            if (r0 == 0) goto L1f
            com.google.protobuf.r2 r0 = r3.m
            if (r0 != 0) goto L12
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r3.l
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
            java.util.List r2 = r3.n
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.n
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0917a0.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptionsM = m();
        if (descriptorProtos$MessageOptionsM.isInitialized()) {
            return descriptorProtos$MessageOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$MessageOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$MessageOptions) {
            U((DescriptorProtos$MessageOptions) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$MessageOptions) {
            U((DescriptorProtos$MessageOptions) abstractC0924c);
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
        return DescriptorProtos$MessageOptions.m;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }
}
