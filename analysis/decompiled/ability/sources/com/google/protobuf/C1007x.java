package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$DescriptorProto;

/* renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1007x extends AbstractC0926c1 {
    public int e;
    public int f;
    public int g;

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.h;
        c0868b.g(DescriptorProtos$DescriptorProto.ReservedRange.class, C1007x.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$DescriptorProto.ReservedRange m() {
        DescriptorProtos$DescriptorProto.ReservedRange reservedRange = new DescriptorProtos$DescriptorProto.ReservedRange(this);
        int i = 0;
        reservedRange.d = 0;
        reservedRange.e = 0;
        reservedRange.f = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                reservedRange.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                reservedRange.e = this.g;
                i |= 2;
            }
            reservedRange.c = i | reservedRange.c;
        }
        K();
        return reservedRange;
    }

    public final C1007x O(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 8) {
                            this.f = abstractC0972o.s();
                            this.e |= 1;
                        } else if (iD == 16) {
                            this.g = abstractC0972o.s();
                            this.e |= 2;
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

    public final void P(DescriptorProtos$DescriptorProto.ReservedRange reservedRange) {
        if (reservedRange == DescriptorProtos$DescriptorProto.ReservedRange.g) {
            return;
        }
        if ((reservedRange.c & 1) != 0) {
            this.f = reservedRange.d;
            this.e |= 1;
            L();
        }
        if (reservedRange.E()) {
            this.g = reservedRange.e;
            this.e |= 2;
            L();
        }
        I(reservedRange.b);
        L();
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$DescriptorProto.ReservedRange reservedRangeM = m();
        if (reservedRangeM.isInitialized()) {
            return reservedRangeM;
        }
        throw AbstractC0916a.x(reservedRangeM);
    }

    public final Object clone() {
        return (C1007x) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.g;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.ReservedRange.g;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$DescriptorProto.ReservedRange reservedRangeM = m();
        if (reservedRangeM.isInitialized()) {
            return reservedRangeM;
        }
        throw AbstractC0916a.x(reservedRangeM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$DescriptorProto.ReservedRange) {
            P((DescriptorProtos$DescriptorProto.ReservedRange) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$DescriptorProto.ReservedRange) {
            P((DescriptorProtos$DescriptorProto.ReservedRange) abstractC0924c);
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
        return DescriptorProtos$DescriptorProto.ReservedRange.g;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        O(abstractC0972o, r02);
        return this;
    }
}
