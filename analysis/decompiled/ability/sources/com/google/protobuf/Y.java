package com.google.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import c0.C0868b;
import com.google.protobuf.DescriptorProtos$FileOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes3.dex */
public final class Y extends AbstractC0930d1 {

    /* renamed from: A, reason: collision with root package name */
    public DescriptorProtos$FeatureSet f2891A;

    /* renamed from: B, reason: collision with root package name */
    public C0986r2 f2892B;

    /* renamed from: C, reason: collision with root package name */
    public List f2893C;
    public int f;
    public Serializable g;
    public Serializable h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2894j;
    public boolean k;
    public int l;
    public Serializable m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2895q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2896r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2897s;

    /* renamed from: t, reason: collision with root package name */
    public Serializable f2898t;
    public Serializable u;

    /* renamed from: v, reason: collision with root package name */
    public Serializable f2899v;

    /* renamed from: w, reason: collision with root package name */
    public Serializable f2900w;

    /* renamed from: x, reason: collision with root package name */
    public Serializable f2901x;
    public Serializable y;

    /* renamed from: z, reason: collision with root package name */
    public Serializable f2902z;

    public Y() {
        super(null);
        this.g = "";
        this.h = "";
        this.l = 1;
        this.m = "";
        this.f2897s = true;
        this.f2898t = "";
        this.u = "";
        this.f2899v = "";
        this.f2900w = "";
        this.f2901x = "";
        this.y = "";
        this.f2902z = "";
        this.f2893C = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2946B;
        c0868b.g(DescriptorProtos$FileOptions.class, Y.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FileOptions m() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions = new DescriptorProtos$FileOptions(this);
        descriptorProtos$FileOptions.e = "";
        descriptorProtos$FileOptions.f = "";
        int i = 0;
        descriptorProtos$FileOptions.g = false;
        descriptorProtos$FileOptions.h = false;
        descriptorProtos$FileOptions.i = false;
        descriptorProtos$FileOptions.f2805j = 1;
        descriptorProtos$FileOptions.k = "";
        descriptorProtos$FileOptions.l = false;
        descriptorProtos$FileOptions.m = false;
        descriptorProtos$FileOptions.n = false;
        descriptorProtos$FileOptions.o = false;
        descriptorProtos$FileOptions.p = false;
        descriptorProtos$FileOptions.f2806q = true;
        descriptorProtos$FileOptions.f2807r = "";
        descriptorProtos$FileOptions.f2808s = "";
        descriptorProtos$FileOptions.f2809t = "";
        descriptorProtos$FileOptions.u = "";
        descriptorProtos$FileOptions.f2810v = "";
        descriptorProtos$FileOptions.f2811w = "";
        descriptorProtos$FileOptions.f2812x = "";
        descriptorProtos$FileOptions.f2804A = (byte) -1;
        if ((this.f & 2097152) != 0) {
            this.f2893C = Collections.unmodifiableList(this.f2893C);
            this.f &= -2097153;
        }
        descriptorProtos$FileOptions.f2813z = this.f2893C;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$FileOptions.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$FileOptions.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$FileOptions.g = this.i;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$FileOptions.h = this.f2894j;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$FileOptions.i = this.k;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$FileOptions.f2805j = this.l;
                i |= 32;
            }
            if ((i6 & 64) != 0) {
                descriptorProtos$FileOptions.k = this.m;
                i |= 64;
            }
            if ((i6 & 128) != 0) {
                descriptorProtos$FileOptions.l = this.n;
                i |= 128;
            }
            if ((i6 & 256) != 0) {
                descriptorProtos$FileOptions.m = this.o;
                i |= 256;
            }
            if ((i6 & 512) != 0) {
                descriptorProtos$FileOptions.n = this.p;
                i |= 512;
            }
            if ((i6 & 1024) != 0) {
                descriptorProtos$FileOptions.o = this.f2895q;
                i |= 1024;
            }
            if ((i6 & 2048) != 0) {
                descriptorProtos$FileOptions.p = this.f2896r;
                i |= 2048;
            }
            if ((i6 & 4096) != 0) {
                descriptorProtos$FileOptions.f2806q = this.f2897s;
                i |= 4096;
            }
            if ((i6 & 8192) != 0) {
                descriptorProtos$FileOptions.f2807r = this.f2898t;
                i |= 8192;
            }
            if ((i6 & 16384) != 0) {
                descriptorProtos$FileOptions.f2808s = this.u;
                i |= 16384;
            }
            if ((i6 & 32768) != 0) {
                descriptorProtos$FileOptions.f2809t = this.f2899v;
                i |= 32768;
            }
            if ((i6 & 65536) != 0) {
                descriptorProtos$FileOptions.u = this.f2900w;
                i |= 65536;
            }
            if ((i6 & 131072) != 0) {
                descriptorProtos$FileOptions.f2810v = this.f2901x;
                i |= 131072;
            }
            if ((i6 & 262144) != 0) {
                descriptorProtos$FileOptions.f2811w = this.y;
                i |= 262144;
            }
            if ((i6 & 524288) != 0) {
                descriptorProtos$FileOptions.f2812x = this.f2902z;
                i |= 524288;
            }
            if ((i6 & 1048576) != 0) {
                C0986r2 c0986r2 = this.f2892B;
                descriptorProtos$FileOptions.y = c0986r2 == null ? this.f2891A : (DescriptorProtos$FeatureSet) c0986r2.a();
                i |= 1048576;
            }
            descriptorProtos$FileOptions.d |= i;
        }
        K();
        return descriptorProtos$FileOptions;
    }

    public final void U(DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet;
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet2;
        if (descriptorProtos$FileOptions == DescriptorProtos$FileOptions.f2803B) {
            return;
        }
        if ((descriptorProtos$FileOptions.d & 1) != 0) {
            this.g = descriptorProtos$FileOptions.e;
            this.f |= 1;
            L();
        }
        if (descriptorProtos$FileOptions.Y()) {
            this.h = descriptorProtos$FileOptions.f;
            this.f |= 2;
            L();
        }
        if (descriptorProtos$FileOptions.X()) {
            this.i = descriptorProtos$FileOptions.g;
            this.f |= 4;
            L();
        }
        if (descriptorProtos$FileOptions.V()) {
            this.f2894j = descriptorProtos$FileOptions.h;
            this.f |= 8;
            L();
        }
        if (descriptorProtos$FileOptions.Z()) {
            this.k = descriptorProtos$FileOptions.i;
            this.f |= 16;
            L();
        }
        if (descriptorProtos$FileOptions.b0()) {
            DescriptorProtos$FileOptions.OptimizeMode optimizeModeA = DescriptorProtos$FileOptions.OptimizeMode.a(descriptorProtos$FileOptions.f2805j);
            if (optimizeModeA == null) {
                optimizeModeA = DescriptorProtos$FileOptions.OptimizeMode.SPEED;
            }
            this.f |= 32;
            this.l = optimizeModeA.f2814a;
            L();
        }
        if (descriptorProtos$FileOptions.U()) {
            this.m = descriptorProtos$FileOptions.k;
            this.f |= 64;
            L();
        }
        if (descriptorProtos$FileOptions.Q()) {
            this.n = descriptorProtos$FileOptions.l;
            this.f |= 128;
            L();
        }
        if (descriptorProtos$FileOptions.W()) {
            this.o = descriptorProtos$FileOptions.m;
            this.f |= 256;
            L();
        }
        if (descriptorProtos$FileOptions.g0()) {
            this.p = descriptorProtos$FileOptions.n;
            this.f |= 512;
            L();
        }
        if (descriptorProtos$FileOptions.d0()) {
            this.f2895q = descriptorProtos$FileOptions.o;
            this.f |= 1024;
            L();
        }
        if (descriptorProtos$FileOptions.S()) {
            this.f2896r = descriptorProtos$FileOptions.p;
            this.f |= 2048;
            L();
        }
        if (descriptorProtos$FileOptions.P()) {
            this.f2897s = descriptorProtos$FileOptions.f2806q;
            this.f |= 4096;
            L();
        }
        if (descriptorProtos$FileOptions.a0()) {
            this.f2898t = descriptorProtos$FileOptions.f2807r;
            this.f |= 8192;
            L();
        }
        if (descriptorProtos$FileOptions.R()) {
            this.u = descriptorProtos$FileOptions.f2808s;
            this.f |= 16384;
            L();
        }
        if (descriptorProtos$FileOptions.i0()) {
            this.f2899v = descriptorProtos$FileOptions.f2809t;
            this.f |= 32768;
            L();
        }
        if (descriptorProtos$FileOptions.c0()) {
            this.f2900w = descriptorProtos$FileOptions.u;
            this.f |= 65536;
            L();
        }
        if (descriptorProtos$FileOptions.f0()) {
            this.f2901x = descriptorProtos$FileOptions.f2810v;
            this.f |= 131072;
            L();
        }
        if (descriptorProtos$FileOptions.e0()) {
            this.y = descriptorProtos$FileOptions.f2811w;
            this.f |= 262144;
            L();
        }
        if (descriptorProtos$FileOptions.h0()) {
            this.f2902z = descriptorProtos$FileOptions.f2812x;
            this.f |= 524288;
            L();
        }
        if (descriptorProtos$FileOptions.T()) {
            DescriptorProtos$FeatureSet descriptorProtos$FeatureSetF = descriptorProtos$FileOptions.F();
            C0986r2 c0986r2 = this.f2892B;
            if (c0986r2 == null) {
                int i = this.f;
                if ((i & 1048576) == 0 || (descriptorProtos$FeatureSet = this.f2891A) == null || descriptorProtos$FeatureSet == (descriptorProtos$FeatureSet2 = DescriptorProtos$FeatureSet.l)) {
                    this.f2891A = descriptorProtos$FeatureSetF;
                } else {
                    this.f = i | 1048576;
                    L();
                    C0986r2 c0986r22 = this.f2892B;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FeatureSet descriptorProtos$FeatureSet3 = this.f2891A;
                            if (descriptorProtos$FeatureSet3 != null) {
                                descriptorProtos$FeatureSet2 = descriptorProtos$FeatureSet3;
                            }
                        } else {
                            descriptorProtos$FeatureSet2 = (DescriptorProtos$FeatureSet) c0986r22.c();
                        }
                        this.f2892B = new C0986r2(descriptorProtos$FeatureSet2, E(), this.c);
                        this.f2891A = null;
                    }
                    ((N) this.f2892B.b()).U(descriptorProtos$FeatureSetF);
                }
            } else {
                c0986r2.d(descriptorProtos$FeatureSetF);
            }
            if (this.f2891A != null) {
                this.f |= 1048576;
                L();
            }
        }
        if (!descriptorProtos$FileOptions.f2813z.isEmpty()) {
            if (this.f2893C.isEmpty()) {
                this.f2893C = descriptorProtos$FileOptions.f2813z;
                this.f &= -2097153;
            } else {
                if ((this.f & 2097152) == 0) {
                    this.f2893C = new ArrayList(this.f2893C);
                    this.f |= 2097152;
                }
                this.f2893C.addAll(descriptorProtos$FileOptions.f2813z);
            }
            L();
        }
        P(descriptorProtos$FileOptions);
        I(descriptorProtos$FileOptions.b);
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
                    switch (iD) {
                        case 0:
                            z10 = true;
                        case 10:
                            this.g = abstractC0972o.l();
                            this.f |= 1;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            this.h = abstractC0972o.l();
                            this.f |= 2;
                        case 72:
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$FileOptions.OptimizeMode.a(iN) == null) {
                                J(9, iN);
                            } else {
                                this.l = iN;
                                this.f |= 32;
                            }
                        case WebSocketImpl.DEFAULT_PORT /* 80 */:
                            this.i = abstractC0972o.k();
                            this.f |= 4;
                        case 90:
                            this.m = abstractC0972o.l();
                            this.f |= 64;
                        case 128:
                            this.n = abstractC0972o.k();
                            this.f |= 128;
                        case 136:
                            this.o = abstractC0972o.k();
                            this.f |= 256;
                        case 144:
                            this.p = abstractC0972o.k();
                            this.f |= 512;
                        case 160:
                            this.f2894j = abstractC0972o.k();
                            this.f |= 8;
                        case 184:
                            this.f2896r = abstractC0972o.k();
                            this.f |= 2048;
                        case 216:
                            this.k = abstractC0972o.k();
                            this.f |= 16;
                        case 248:
                            this.f2897s = abstractC0972o.k();
                            this.f |= 4096;
                        case 290:
                            this.f2898t = abstractC0972o.l();
                            this.f |= 8192;
                        case 298:
                            this.u = abstractC0972o.l();
                            this.f |= 16384;
                        case 314:
                            this.f2899v = abstractC0972o.l();
                            this.f |= 32768;
                        case 322:
                            this.f2900w = abstractC0972o.l();
                            this.f |= 65536;
                        case 330:
                            this.f2901x = abstractC0972o.l();
                            this.f |= 131072;
                        case 336:
                            this.f2895q = abstractC0972o.k();
                            this.f |= 1024;
                        case 354:
                            this.y = abstractC0972o.l();
                            this.f |= 262144;
                        case 362:
                            this.f2902z = abstractC0972o.l();
                            this.f |= 524288;
                        case TypedValues.CycleType.TYPE_VISIBILITY /* 402 */:
                            C0986r2 c0986r2 = this.f2892B;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FeatureSet = this.f2891A;
                                    if (descriptorProtos$FeatureSet == null) {
                                        descriptorProtos$FeatureSet = DescriptorProtos$FeatureSet.l;
                                    }
                                } else {
                                    descriptorProtos$FeatureSet = (DescriptorProtos$FeatureSet) c0986r2.c();
                                }
                                this.f2892B = new C0986r2(descriptorProtos$FeatureSet, E(), this.c);
                                this.f2891A = null;
                            }
                            abstractC0972o.v(this.f2892B.b(), r02);
                            this.f |= 1048576;
                        case 7994:
                            DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption) abstractC0972o.u(DescriptorProtos$UninterpretedOption.m, r02);
                            if ((this.f & 2097152) == 0) {
                                this.f2893C = new ArrayList(this.f2893C);
                                this.f |= 2097152;
                            }
                            this.f2893C.add(descriptorProtos$UninterpretedOption);
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
        DescriptorProtos$FileOptions descriptorProtos$FileOptionsM = m();
        if (descriptorProtos$FileOptionsM.isInitialized()) {
            return descriptorProtos$FileOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$FileOptionsM);
    }

    public final Object clone() {
        return (Y) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2945A;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FileOptions.f2803B;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    @Override // com.google.protobuf.Y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized() {
        /*
            r3 = this;
            int r0 = r3.f
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            r1 = 0
            if (r0 == 0) goto L20
            com.google.protobuf.r2 r0 = r3.f2892B
            if (r0 != 0) goto L13
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = r3.f2891A
            if (r0 != 0) goto L19
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = com.google.protobuf.DescriptorProtos$FeatureSet.l
            goto L19
        L13:
            com.google.protobuf.c r0 = r0.c()
            com.google.protobuf.DescriptorProtos$FeatureSet r0 = (com.google.protobuf.DescriptorProtos$FeatureSet) r0
        L19:
            boolean r0 = r0.isInitialized()
            if (r0 != 0) goto L20
            goto L41
        L20:
            r0 = r1
        L21:
            java.util.List r2 = r3.f2893C
            int r2 = r2.size()
            if (r0 >= r2) goto L3b
            java.util.List r2 = r3.f2893C
            java.lang.Object r2 = r2.get(r0)
            com.google.protobuf.DescriptorProtos$UninterpretedOption r2 = (com.google.protobuf.DescriptorProtos$UninterpretedOption) r2
            boolean r2 = r2.isInitialized()
            if (r2 != 0) goto L38
            goto L41
        L38:
            int r0 = r0 + 1
            goto L21
        L3b:
            boolean r3 = r3.O()
            if (r3 != 0) goto L42
        L41:
            return r1
        L42:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Y.isInitialized():boolean");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptionsM = m();
        if (descriptorProtos$FileOptionsM.isInitialized()) {
            return descriptorProtos$FileOptionsM;
        }
        throw AbstractC0916a.x(descriptorProtos$FileOptionsM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FileOptions) {
            U((DescriptorProtos$FileOptions) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$FileOptions) {
            U((DescriptorProtos$FileOptions) abstractC0924c);
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
        return DescriptorProtos$FileOptions.f2803B;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }
}
