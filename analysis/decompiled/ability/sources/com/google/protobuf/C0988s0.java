package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0988s0 extends AbstractC0926c1 {
    public int e;
    public List f;
    public Serializable g;
    public long h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public double f2939j;
    public ByteString k;
    public Serializable l;

    public C0988s0() {
        super(null);
        this.f = Collections.EMPTY_LIST;
        this.g = "";
        this.k = ByteString.b;
        this.l = "";
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2963T;
        c0868b.g(DescriptorProtos$UninterpretedOption.class, C0988s0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$UninterpretedOption m() {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = new DescriptorProtos$UninterpretedOption(this);
        descriptorProtos$UninterpretedOption.e = "";
        descriptorProtos$UninterpretedOption.f = 0L;
        descriptorProtos$UninterpretedOption.g = 0L;
        descriptorProtos$UninterpretedOption.h = 0.0d;
        descriptorProtos$UninterpretedOption.i = ByteString.b;
        descriptorProtos$UninterpretedOption.f2820j = "";
        descriptorProtos$UninterpretedOption.k = (byte) -1;
        int i = 1;
        if ((this.e & 1) != 0) {
            this.f = Collections.unmodifiableList(this.f);
            this.e &= -2;
        }
        descriptorProtos$UninterpretedOption.d = this.f;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 2) != 0) {
                descriptorProtos$UninterpretedOption.e = this.g;
            } else {
                i = 0;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$UninterpretedOption.f = this.h;
                i |= 2;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$UninterpretedOption.g = this.i;
                i |= 4;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$UninterpretedOption.h = this.f2939j;
                i |= 8;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$UninterpretedOption.i = this.k;
                i |= 16;
            }
            if ((i6 & 64) != 0) {
                descriptorProtos$UninterpretedOption.f2820j = this.l;
                i |= 32;
            }
            descriptorProtos$UninterpretedOption.c |= i;
        }
        K();
        return descriptorProtos$UninterpretedOption;
    }

    public final void O(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (descriptorProtos$UninterpretedOption == DescriptorProtos$UninterpretedOption.l) {
            return;
        }
        if (!descriptorProtos$UninterpretedOption.d.isEmpty()) {
            if (this.f.isEmpty()) {
                this.f = descriptorProtos$UninterpretedOption.d;
                this.e &= -2;
            } else {
                if ((this.e & 1) == 0) {
                    this.f = new ArrayList(this.f);
                    this.e |= 1;
                }
                this.f.addAll(descriptorProtos$UninterpretedOption.d);
            }
            L();
        }
        if ((descriptorProtos$UninterpretedOption.c & 1) != 0) {
            this.g = descriptorProtos$UninterpretedOption.e;
            this.e |= 2;
            L();
        }
        if (descriptorProtos$UninterpretedOption.J()) {
            this.h = descriptorProtos$UninterpretedOption.f;
            this.e |= 4;
            L();
        }
        if (descriptorProtos$UninterpretedOption.I()) {
            this.i = descriptorProtos$UninterpretedOption.g;
            this.e |= 8;
            L();
        }
        if (descriptorProtos$UninterpretedOption.H()) {
            this.f2939j = descriptorProtos$UninterpretedOption.h;
            this.e |= 16;
            L();
        }
        if (descriptorProtos$UninterpretedOption.K()) {
            ByteString byteString = descriptorProtos$UninterpretedOption.i;
            byteString.getClass();
            this.k = byteString;
            this.e |= 32;
            L();
        }
        if (descriptorProtos$UninterpretedOption.G()) {
            this.l = descriptorProtos$UninterpretedOption.f2820j;
            this.e |= 64;
            L();
        }
        I(descriptorProtos$UninterpretedOption.b);
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
                        if (iD == 18) {
                            DescriptorProtos$UninterpretedOption.NamePart namePart = (DescriptorProtos$UninterpretedOption.NamePart) abstractC0972o.u(DescriptorProtos$UninterpretedOption.NamePart.h, r02);
                            if ((this.e & 1) == 0) {
                                this.f = new ArrayList(this.f);
                                this.e = 1 | this.e;
                            }
                            this.f.add(namePart);
                        } else if (iD == 26) {
                            this.g = abstractC0972o.l();
                            this.e |= 2;
                        } else if (iD == 32) {
                            this.h = abstractC0972o.F();
                            this.e |= 4;
                        } else if (iD == 40) {
                            this.i = abstractC0972o.t();
                            this.e |= 8;
                        } else if (iD == 49) {
                            this.f2939j = abstractC0972o.m();
                            this.e |= 16;
                        } else if (iD == 58) {
                            this.k = abstractC0972o.l();
                            this.e |= 32;
                        } else if (iD == 66) {
                            this.l = abstractC0972o.l();
                            this.e |= 64;
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
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOptionM = m();
        if (descriptorProtos$UninterpretedOptionM.isInitialized()) {
            return descriptorProtos$UninterpretedOptionM;
        }
        throw AbstractC0916a.x(descriptorProtos$UninterpretedOptionM);
    }

    public final Object clone() {
        return (C0988s0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2962S;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.l;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        for (int i = 0; i < this.f.size(); i++) {
            if (!((DescriptorProtos$UninterpretedOption.NamePart) this.f.get(i)).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOptionM = m();
        if (descriptorProtos$UninterpretedOptionM.isInitialized()) {
            return descriptorProtos$UninterpretedOptionM;
        }
        throw AbstractC0916a.x(descriptorProtos$UninterpretedOptionM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$UninterpretedOption) {
            O((DescriptorProtos$UninterpretedOption) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$UninterpretedOption) {
            O((DescriptorProtos$UninterpretedOption) abstractC0924c);
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
        return DescriptorProtos$UninterpretedOption.l;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
