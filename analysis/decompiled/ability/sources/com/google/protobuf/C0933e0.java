package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.e0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0933e0 extends AbstractC0930d1 {
    public int f;
    public boolean g;
    public int h;
    public DescriptorProtos$FeatureSet i;

    /* renamed from: j, reason: collision with root package name */
    public C0986r2 f2916j;
    public List k;

    public C0933e0() {
        super(null);
        this.h = 0;
        this.k = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2961R;
        c0868b.g(DescriptorProtos$MethodOptions.class, C0933e0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$MethodOptions m() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions = new DescriptorProtos$MethodOptions(this);
        int i = 0;
        descriptorProtos$MethodOptions.e = false;
        descriptorProtos$MethodOptions.f = 0;
        descriptorProtos$MethodOptions.i = (byte) -1;
        if ((this.f & 8) != 0) {
            this.k = Collections.unmodifiableList(this.k);
            this.f &= -9;
        }
        descriptorProtos$MethodOptions.h = this.k;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$MethodOptions.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$MethodOptions.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.f2916j;
                descriptorProtos$MethodOptions.g = c0986r2 == null ? this.i : (DescriptorProtos$FeatureSet) c0986r2.a();
                i |= 4;
            }
            descriptorProtos$MethodOptions.d = i | descriptorProtos$MethodOptions.d;
        }
        K();
        return descriptorProtos$MethodOptions;
    }

    public final void U(DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$MethodOptions == DescriptorProtos$MethodOptions.f2817j) {
            return;
        }
        if ((descriptorProtos$MethodOptions.d & 1) != 0) {
            this.g = descriptorProtos$MethodOptions.e;
            this.f |= 1;
            L();
        }
        if (descriptorProtos$MethodOptions.G()) {
            DescriptorProtos$MethodOptions.IdempotencyLevel idempotencyLevelA = DescriptorProtos$MethodOptions.IdempotencyLevel.a(descriptorProtos$MethodOptions.f);
            if (idempotencyLevelA == null) {
                idempotencyLevelA = DescriptorProtos$MethodOptions.IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
            }
            this.f |= 2;
            this.h = idempotencyLevelA.f2818a;
            L();
        }
        if (descriptorProtos$MethodOptions.F()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$MethodOptions.E();
            C0986r2 c0986r2 = this.f2916j;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 4) == 0 || (descriptorProtos$FeatureSet = this.i) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.i = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 4;
                    L();
                    C0986r2 c0986r22 = this.f2916j;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.i;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.f2916j = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.i = null;
                    }
                    ((N) this.f2916j.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.i != null) {
                this.f |= 4;
                L();
            }
        }
        if (!descriptorProtos$MethodOptions.h.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = descriptorProtos$MethodOptions.h;
                this.f &= -9;
            } else {
                if ((this.f & 8) == 0) {
                    this.k = new ArrayList(this.k);
                    this.f |= 8;
                }
                this.k.addAll(descriptorProtos$MethodOptions.h);
            }
            L();
        }
        P(descriptorProtos$MethodOptions);
        I(descriptorProtos$MethodOptions.b);
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
                        if (iD == 264) {
                            this.g = abstractC0972o.k();
                            this.f |= 1;
                        } else if (iD == 272) {
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$MethodOptions.IdempotencyLevel.a(iN) == null) {
                                J(34, iN);
                            } else {
                                this.h = iN;
                                this.f |= 2;
                            }
                        } else if (iD == 282) {
                            C0986r2 c0986r2 = this.f2916j;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.i;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.f2916j = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.i = null;
                            }
                            abstractC0972o.v(this.f2916j.b(), r02);
                            this.f |= 4;
                        } else if (iD == 7994) {
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 8) == 0) {
                                this.k = new ArrayList(this.k);
                                this.f |= 8;
                            }
                            this.k.add(descriptorProtos$UninterpretedOption);
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
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptionsM = m();
        if (descriptorProtos$MethodOptionsM.isInitialized()) {
            return descriptorProtos$MethodOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$MethodOptionsM);
    }

    public final Object clone() {
        return (C0933e0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2960Q;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$MethodOptions.f2817j;
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
            r0 = r0 & 4
            r1 = 0
            if (r0 == 0) goto L1f
            com.google.protobuf.r2 r0 = r3.f2916j
            if (r0 != 0) goto L12
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r3.i
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
            java.util.List r2 = r3.k
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.k
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0933e0.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptionsM = m();
        if (descriptorProtos$MethodOptionsM.isInitialized()) {
            return descriptorProtos$MethodOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$MethodOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$MethodOptions) {
            U((DescriptorProtos$MethodOptions) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$MethodOptions) {
            U((DescriptorProtos$MethodOptions) abstractC0924c);
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
        return DescriptorProtos$MethodOptions.f2817j;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }
}
