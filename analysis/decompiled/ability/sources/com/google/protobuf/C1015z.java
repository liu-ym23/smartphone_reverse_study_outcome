package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1015z extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public List g;
    public DescriptorProtos$EnumOptions h;
    public C0986r2 i;

    /* renamed from: j, reason: collision with root package name */
    public List f2987j;
    public C1005w1 k;

    public C1015z() {
        super(null);
        this.f = "";
        List list = Collections.EMPTY_LIST;
        this.g = list;
        this.f2987j = list;
        this.k = C1005w1.c;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2974r;
        c0868b.g(DescriptorProtos$EnumDescriptorProto.class, C1015z.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$EnumDescriptorProto m() {
        int i;
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = new DescriptorProtos$EnumDescriptorProto(this);
        descriptorProtos$EnumDescriptorProto.d = "";
        descriptorProtos$EnumDescriptorProto.h = C1005w1.c;
        descriptorProtos$EnumDescriptorProto.i = (byte) -1;
        if ((this.e & 2) != 0) {
            this.g = Collections.unmodifiableList(this.g);
            this.e &= -3;
        }
        descriptorProtos$EnumDescriptorProto.e = this.g;
        if ((this.e & 8) != 0) {
            this.f2987j = Collections.unmodifiableList(this.f2987j);
            this.e &= -9;
        }
        descriptorProtos$EnumDescriptorProto.g = this.f2987j;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$EnumDescriptorProto.d = this.f;
                i = 1;
            } else {
                i = 0;
            }
            if ((i6 & 4) != 0) {
                C0986r2 c0986r2 = this.i;
                descriptorProtos$EnumDescriptorProto.f = c0986r2 == null ? this.h : (DescriptorProtos$EnumOptions) c0986r2.a();
                i |= 2;
            }
            if ((i6 & 16) != 0) {
                this.k.makeImmutable();
                descriptorProtos$EnumDescriptorProto.h = this.k;
            }
            descriptorProtos$EnumDescriptorProto.c |= i;
        }
        K();
        return descriptorProtos$EnumDescriptorProto;
    }

    public final C1015z O(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$EnumDescriptorProto) {
            Q((DescriptorProtos$EnumDescriptorProto) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    public final C1015z P(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
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
                        } else if (iD == 18) {
                            DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto) abstractC0972o.u(DescriptorProtos$EnumValueDescriptorProto.i, r02);
                            if ((this.e & 2) == 0) {
                                this.g = new ArrayList(this.g);
                                this.e |= 2;
                            }
                            this.g.add(descriptorProtos$EnumValueDescriptorProto);
                        } else if (iD == 26) {
                            C0986r2 c0986r2 = this.i;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$EnumOptions = this.h;
                                    if (descriptorProtos$EnumOptions == null) {
                                        descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.k;
                                    }
                                } else {
                                    descriptorProtos$EnumOptions = (DescriptorProtos$EnumOptions) c0986r2.c();
                                }
                                this.i = new C0986r2(descriptorProtos$EnumOptions, E(), this.c);
                                this.h = null;
                            }
                            abstractC0972o.v(this.i.b(), r02);
                            this.e |= 4;
                        } else if (iD == 34) {
                            DescriptorProtos$EnumDescriptorProto.EnumReservedRange enumReservedRange = (DescriptorProtos$EnumDescriptorProto.EnumReservedRange) abstractC0972o.u(DescriptorProtos$EnumDescriptorProto.EnumReservedRange.h, r02);
                            if ((this.e & 8) == 0) {
                                this.f2987j = new ArrayList(this.f2987j);
                                this.e |= 8;
                            }
                            this.f2987j.add(enumReservedRange);
                        } else if (iD == 42) {
                            ByteString byteStringL = abstractC0972o.l();
                            if (!this.k.f2920a) {
                                this.k = new C1005w1(this.k);
                            }
                            this.e |= 16;
                            this.k.a(byteStringL);
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
        return this;
    }

    public final C1015z Q(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions2;
        if (descriptorProtos$EnumDescriptorProto == DescriptorProtos$EnumDescriptorProto.f2768j) {
            return this;
        }
        if ((descriptorProtos$EnumDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$EnumDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (!descriptorProtos$EnumDescriptorProto.e.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = descriptorProtos$EnumDescriptorProto.e;
                this.e &= -3;
            } else {
                if ((this.e & 2) == 0) {
                    this.g = new ArrayList(this.g);
                    this.e |= 2;
                }
                this.g.addAll(descriptorProtos$EnumDescriptorProto.e);
            }
            L();
        }
        if (descriptorProtos$EnumDescriptorProto.G()) {
            DescriptorProtos$EnumOptions descriptorProtos$EnumOptionsF = descriptorProtos$EnumDescriptorProto.F();
            C0986r2 c0986r2 = this.i;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 4) == 0 || (descriptorProtos$EnumOptions = this.h) == null || descriptorProtos$EnumOptions == (descriptorProtos$EnumOptions2 = DescriptorProtos$EnumOptions.k)) {
                    this.h = descriptorProtos$EnumOptionsF;
                } else {
                    this.e = i | 4;
                    L();
                    C0986r2 c0986r22 = this.i;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$EnumOptions descriptorProtos$EnumOptions3 = this.h;
                            if (descriptorProtos$EnumOptions3 != null) {
                                descriptorProtos$EnumOptions2 = descriptorProtos$EnumOptions3;
                            }
                        } else {
                            descriptorProtos$EnumOptions2 = (DescriptorProtos$EnumOptions) c0986r22.c();
                        }
                        this.i = new C0986r2(descriptorProtos$EnumOptions2, E(), this.c);
                        this.h = null;
                    }
                    ((D) this.i.b()).V(descriptorProtos$EnumOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$EnumOptionsF);
            }
            if (this.h != null) {
                this.e |= 4;
                L();
            }
        }
        if (!descriptorProtos$EnumDescriptorProto.g.isEmpty()) {
            if (this.f2987j.isEmpty()) {
                this.f2987j = descriptorProtos$EnumDescriptorProto.g;
                this.e &= -9;
            } else {
                if ((this.e & 8) == 0) {
                    this.f2987j = new ArrayList(this.f2987j);
                    this.e |= 8;
                }
                this.f2987j.addAll(descriptorProtos$EnumDescriptorProto.g);
            }
            L();
        }
        if (!descriptorProtos$EnumDescriptorProto.h.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = descriptorProtos$EnumDescriptorProto.h;
                this.e |= 16;
            } else {
                if (!this.k.f2920a) {
                    this.k = new C1005w1(this.k);
                }
                this.e |= 16;
                this.k.addAll(descriptorProtos$EnumDescriptorProto.h);
            }
            L();
        }
        I(descriptorProtos$EnumDescriptorProto.b);
        L();
        return this;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProtoM = m();
        if (descriptorProtos$EnumDescriptorProtoM.isInitialized()) {
            return descriptorProtos$EnumDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumDescriptorProtoM);
    }

    public final Object clone() {
        return (C1015z) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2973q;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto.f2768j;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$EnumOptions descriptorProtos$EnumOptions;
        int i = 0;
        while (true) {
            if (i >= this.g.size()) {
                if ((this.e & 4) == 0) {
                    return true;
                }
                C0986r2 c0986r2 = this.i;
                if (c0986r2 == null) {
                    descriptorProtos$EnumOptions = this.h;
                    if (descriptorProtos$EnumOptions == null) {
                        descriptorProtos$EnumOptions = DescriptorProtos$EnumOptions.k;
                    }
                } else {
                    descriptorProtos$EnumOptions = (DescriptorProtos$EnumOptions) c0986r2.c();
                }
                if (!descriptorProtos$EnumOptions.isInitialized()) {
                    break;
                }
                return true;
            }
            if (!((DescriptorProtos$EnumValueDescriptorProto) this.g.get(i)).isInitialized()) {
                break;
            }
            i++;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProtoM = m();
        if (descriptorProtos$EnumDescriptorProtoM.isInitialized()) {
            return descriptorProtos$EnumDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a r(AbstractC0924c abstractC0924c) {
        O(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a t(AbstractC0924c abstractC0924c) {
        O(abstractC0924c);
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
        return DescriptorProtos$EnumDescriptorProto.f2768j;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
