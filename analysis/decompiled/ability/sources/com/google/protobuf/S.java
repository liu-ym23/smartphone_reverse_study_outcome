package com.google.protobuf;

import androidx.compose.material3.MenuKt;
import c0.C0868b;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes3.dex */
public final class S extends AbstractC0930d1 {
    public int f;
    public int g;
    public boolean h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2870j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public List p;

    /* renamed from: q, reason: collision with root package name */
    public List f2871q;

    /* renamed from: r, reason: collision with root package name */
    public DescriptorProtos$FeatureSet f2872r;

    /* renamed from: s, reason: collision with root package name */
    public C0986r2 f2873s;

    /* renamed from: t, reason: collision with root package name */
    public List f2874t;

    public S() {
        super(null);
        this.g = 0;
        this.i = 0;
        this.o = 0;
        List list = Collections.EMPTY_LIST;
        this.p = list;
        this.f2871q = list;
        this.f2874t = list;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2949F;
        c0868b.g(DescriptorProtos$FieldOptions.class, S.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FieldOptions m() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = new DescriptorProtos$FieldOptions(this);
        int i = 0;
        descriptorProtos$FieldOptions.e = 0;
        descriptorProtos$FieldOptions.f = false;
        descriptorProtos$FieldOptions.g = 0;
        descriptorProtos$FieldOptions.h = false;
        descriptorProtos$FieldOptions.i = false;
        descriptorProtos$FieldOptions.f2791j = false;
        descriptorProtos$FieldOptions.k = false;
        descriptorProtos$FieldOptions.l = false;
        descriptorProtos$FieldOptions.m = 0;
        descriptorProtos$FieldOptions.f2793r = (byte) -1;
        if ((this.f & 512) != 0) {
            this.p = Collections.unmodifiableList(this.p);
            this.f &= -513;
        }
        descriptorProtos$FieldOptions.n = this.p;
        if ((this.f & 1024) != 0) {
            this.f2871q = Collections.unmodifiableList(this.f2871q);
            this.f &= -1025;
        }
        descriptorProtos$FieldOptions.o = this.f2871q;
        if ((this.f & 4096) != 0) {
            this.f2874t = Collections.unmodifiableList(this.f2874t);
            this.f &= -4097;
        }
        descriptorProtos$FieldOptions.f2792q = this.f2874t;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$FieldOptions.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$FieldOptions.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$FieldOptions.g = this.i;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$FieldOptions.h = this.f2870j;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$FieldOptions.i = this.k;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$FieldOptions.f2791j = this.l;
                i |= 32;
            }
            if ((i6 & 64) != 0) {
                descriptorProtos$FieldOptions.k = this.m;
                i |= 64;
            }
            if ((i6 & 128) != 0) {
                descriptorProtos$FieldOptions.l = this.n;
                i |= 128;
            }
            if ((i6 & 256) != 0) {
                descriptorProtos$FieldOptions.m = this.o;
                i |= 256;
            }
            if ((i6 & 2048) != 0) {
                C0986r2 c0986r2 = this.f2873s;
                descriptorProtos$FieldOptions.p = c0986r2 == null ? this.f2872r : (DescriptorProtos$FeatureSet) c0986r2.a();
                i |= 512;
            }
            descriptorProtos$FieldOptions.d = i | descriptorProtos$FieldOptions.d;
        }
        K();
        return descriptorProtos$FieldOptions;
    }

    public final void U() {
        if ((this.f & 512) == 0) {
            this.p = new ArrayList(this.p);
            this.f |= 512;
        }
    }

    public final void V(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$FieldOptions == DescriptorProtos$FieldOptions.f2790s) {
            return;
        }
        if ((descriptorProtos$FieldOptions.d & 1) != 0) {
            DescriptorProtos$FieldOptions.CType cTypeA = DescriptorProtos$FieldOptions.CType.a(descriptorProtos$FieldOptions.e);
            if (cTypeA == null) {
                cTypeA = DescriptorProtos$FieldOptions.CType.STRING;
            }
            this.f |= 1;
            this.g = cTypeA.f2794a;
            L();
        }
        if (descriptorProtos$FieldOptions.K()) {
            this.h = descriptorProtos$FieldOptions.f;
            this.f |= 2;
            L();
        }
        if (descriptorProtos$FieldOptions.I()) {
            DescriptorProtos$FieldOptions.JSType jSTypeA = DescriptorProtos$FieldOptions.JSType.a(descriptorProtos$FieldOptions.g);
            if (jSTypeA == null) {
                jSTypeA = DescriptorProtos$FieldOptions.JSType.JS_NORMAL;
            }
            this.f |= 4;
            this.i = jSTypeA.f2795a;
            L();
        }
        if (descriptorProtos$FieldOptions.J()) {
            this.f2870j = descriptorProtos$FieldOptions.h;
            this.f |= 8;
            L();
        }
        if (descriptorProtos$FieldOptions.M()) {
            this.k = descriptorProtos$FieldOptions.i;
            this.f |= 16;
            L();
        }
        if (descriptorProtos$FieldOptions.G()) {
            this.l = descriptorProtos$FieldOptions.f2791j;
            this.f |= 32;
            L();
        }
        if (descriptorProtos$FieldOptions.N()) {
            this.m = descriptorProtos$FieldOptions.k;
            this.f |= 64;
            L();
        }
        if (descriptorProtos$FieldOptions.F()) {
            this.n = descriptorProtos$FieldOptions.l;
            this.f |= 128;
            L();
        }
        if (descriptorProtos$FieldOptions.L()) {
            DescriptorProtos$FieldOptions.OptionRetention optionRetentionA = DescriptorProtos$FieldOptions.OptionRetention.a(descriptorProtos$FieldOptions.m);
            if (optionRetentionA == null) {
                optionRetentionA = DescriptorProtos$FieldOptions.OptionRetention.RETENTION_UNKNOWN;
            }
            this.f |= 256;
            this.o = optionRetentionA.f2796a;
            L();
        }
        if (!descriptorProtos$FieldOptions.n.isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = descriptorProtos$FieldOptions.n;
                this.f &= -513;
            } else {
                U();
                this.p.addAll(descriptorProtos$FieldOptions.n);
            }
            L();
        }
        if (!descriptorProtos$FieldOptions.o.isEmpty()) {
            if (this.f2871q.isEmpty()) {
                this.f2871q = descriptorProtos$FieldOptions.o;
                this.f &= -1025;
            } else {
                if ((this.f & 1024) == 0) {
                    this.f2871q = new ArrayList(this.f2871q);
                    this.f |= 1024;
                }
                this.f2871q.addAll(descriptorProtos$FieldOptions.o);
            }
            L();
        }
        if (descriptorProtos$FieldOptions.H()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetE = descriptorProtos$FieldOptions.E();
            C0986r2 c0986r2 = this.f2873s;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 2048) == 0 || (descriptorProtos$FeatureSet = this.f2872r) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.f2872r = descriptorProtos$FeatureSetE;
                } else {
                    this.f = i | 2048;
                    L();
                    C0986r2 c0986r22 = this.f2873s;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.f2872r;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.f2873s = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.f2872r = null;
                    }
                    ((N) this.f2873s.b()).U(descriptorProtos$FeatureSetE);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetE);
            }
            if (this.f2872r != null) {
                this.f |= 2048;
                L();
            }
        }
        if (!descriptorProtos$FieldOptions.f2792q.isEmpty()) {
            if (this.f2874t.isEmpty()) {
                this.f2874t = descriptorProtos$FieldOptions.f2792q;
                this.f &= -4097;
            } else {
                if ((this.f & 4096) == 0) {
                    this.f2874t = new ArrayList(this.f2874t);
                    this.f |= 4096;
                }
                this.f2874t.addAll(descriptorProtos$FieldOptions.f2792q);
            }
            L();
        }
        P(descriptorProtos$FieldOptions);
        I(descriptorProtos$FieldOptions.b);
        L();
    }

    public final void W(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    switch (iD) {
                        case 0:
                            z10 = true;
                        case 8:
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$FieldOptions.CType.a(iN) == null) {
                                J(1, iN);
                            } else {
                                this.g = iN;
                                this.f |= 1;
                            }
                        case 16:
                            this.h = abstractC0972o.k();
                            this.f |= 2;
                        case 24:
                            this.l = abstractC0972o.k();
                            this.f |= 32;
                        case 40:
                            this.f2870j = abstractC0972o.k();
                            this.f |= 8;
                        case 48:
                            int iN2 = abstractC0972o.n();
                            if (DescriptorProtos$FieldOptions.JSType.a(iN2) == null) {
                                J(6, iN2);
                            } else {
                                this.i = iN2;
                                this.f |= 4;
                            }
                        case WebSocketImpl.DEFAULT_PORT /* 80 */:
                            this.m = abstractC0972o.k();
                            this.f |= 64;
                        case MenuKt.InTransitionDuration /* 120 */:
                            this.k = abstractC0972o.k();
                            this.f |= 16;
                        case 128:
                            this.n = abstractC0972o.k();
                            this.f |= 128;
                        case 136:
                            int iN3 = abstractC0972o.n();
                            if (DescriptorProtos$FieldOptions.OptionRetention.a(iN3) == null) {
                                J(17, iN3);
                            } else {
                                this.o = iN3;
                                this.f |= 256;
                            }
                        case 152:
                            int iN4 = abstractC0972o.n();
                            if (DescriptorProtos$FieldOptions.OptionTargetType.a(iN4) == null) {
                                J(19, iN4);
                            } else {
                                U();
                                this.p.add(Integer.valueOf(iN4));
                            }
                        case 154:
                            int iJ = abstractC0972o.j(abstractC0972o.w());
                            while (abstractC0972o.e() > 0) {
                                int iN5 = abstractC0972o.n();
                                if (DescriptorProtos$FieldOptions.OptionTargetType.a(iN5) == null) {
                                    J(19, iN5);
                                } else {
                                    U();
                                    this.p.add(Integer.valueOf(iN5));
                                }
                            }
                            abstractC0972o.i(iJ);
                        case 162:
                            DescriptorProtos$FieldOptions.EditionDefault editionDefault = (DescriptorProtos$FieldOptions.EditionDefault) abstractC0972o.u(DescriptorProtos$FieldOptions.EditionDefault.h, r02);
                            if ((this.f & 1024) == 0) {
                                this.f2871q = new ArrayList(this.f2871q);
                                this.f |= 1024;
                            }
                            this.f2871q.add(editionDefault);
                        case 170:
                            C0986r2 c0986r2 = this.f2873s;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.f2872r;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.f2873s = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.f2872r = null;
                            }
                            abstractC0972o.v(this.f2873s.b(), r02);
                            this.f |= 2048;
                        case 7994:
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 4096) == 0) {
                                this.f2874t = new ArrayList(this.f2874t);
                                this.f |= 4096;
                            }
                            this.f2874t.add(descriptorProtos$UninterpretedOption);
                        default:
                            if (!Q(abstractC0972o, r02, iD)) {
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
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptionsM = m();
        if (descriptorProtos$FieldOptionsM.isInitialized()) {
            return descriptorProtos$FieldOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$FieldOptionsM);
    }

    public final Object clone() {
        return (S) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.E;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.f2790s;
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
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r1 = 0
            if (r0 == 0) goto L1f
            com.google.protobuf.r2 r0 = r3.f2873s
            if (r0 != 0) goto L12
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r3.f2872r
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
            java.util.List r2 = r3.f2874t
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.f2874t
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptionsM = m();
        if (descriptorProtos$FieldOptionsM.isInitialized()) {
            return descriptorProtos$FieldOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$FieldOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        W(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FieldOptions) {
            V((DescriptorProtos$FieldOptions) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        W(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FieldOptions) {
            V((DescriptorProtos$FieldOptions) abstractC0924c);
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
        return DescriptorProtos$FieldOptions.f2790s;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        W(abstractC0972o, r02);
        return this;
    }
}
