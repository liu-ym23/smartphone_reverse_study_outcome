package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import java.io.Serializable;

/* renamed from: com.google.protobuf.q0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0981q0 extends AbstractC0926c1 {
    public int e;
    public InterfaceC0982q1 f;
    public InterfaceC0982q1 g;
    public Serializable h;
    public Serializable i;

    /* renamed from: j, reason: collision with root package name */
    public C1005w1 f2935j;

    public C0981q0() {
        super(null);
        C0970n1 c0970n1 = C0970n1.d;
        this.f = c0970n1;
        this.g = c0970n1;
        this.h = "";
        this.i = "";
        this.f2935j = C1005w1.c;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.b0;
        c0868b.g(DescriptorProtos$SourceCodeInfo.Location.class, C0981q0.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$SourceCodeInfo.Location m() {
        int i;
        DescriptorProtos$SourceCodeInfo.Location location = new DescriptorProtos$SourceCodeInfo.Location(this);
        C0970n1 c0970n1 = C0970n1.d;
        location.d = c0970n1;
        location.e = -1;
        location.f = c0970n1;
        location.g = -1;
        location.h = "";
        location.i = "";
        location.f2819j = C1005w1.c;
        location.k = (byte) -1;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                ((AbstractC0940g) this.f).makeImmutable();
                location.d = this.f;
            }
            if ((i6 & 2) != 0) {
                ((AbstractC0940g) this.g).makeImmutable();
                location.f = this.g;
            }
            if ((i6 & 4) != 0) {
                location.h = this.h;
                i = 1;
            } else {
                i = 0;
            }
            if ((i6 & 8) != 0) {
                location.i = this.i;
                i |= 2;
            }
            if ((i6 & 16) != 0) {
                this.f2935j.makeImmutable();
                location.f2819j = this.f2935j;
            }
            location.c |= i;
        }
        K();
        return location;
    }

    public final void O() {
        InterfaceC0985r1 interfaceC0985r1 = this.f;
        if (!((AbstractC0940g) interfaceC0985r1).f2920a) {
            this.f = (InterfaceC0982q1) GeneratedMessageV3.A(interfaceC0985r1);
        }
        this.e |= 1;
    }

    public final void P() {
        InterfaceC0985r1 interfaceC0985r1 = this.g;
        if (!((AbstractC0940g) interfaceC0985r1).f2920a) {
            this.g = (InterfaceC0982q1) GeneratedMessageV3.A(interfaceC0985r1);
        }
        this.e |= 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(DescriptorProtos$SourceCodeInfo.Location location) {
        if (location == DescriptorProtos$SourceCodeInfo.Location.l) {
            return;
        }
        if (!location.d.isEmpty()) {
            if (this.f.isEmpty()) {
                InterfaceC0982q1 interfaceC0982q1 = location.d;
                this.f = interfaceC0982q1;
                ((AbstractC0940g) interfaceC0982q1).makeImmutable();
                this.e |= 1;
            } else {
                O();
                this.f.addAll(location.d);
            }
            L();
        }
        if (!location.f.isEmpty()) {
            if (this.g.isEmpty()) {
                InterfaceC0982q1 interfaceC0982q12 = location.f;
                this.g = interfaceC0982q12;
                ((AbstractC0940g) interfaceC0982q12).makeImmutable();
                this.e |= 2;
            } else {
                P();
                this.g.addAll(location.f);
            }
            L();
        }
        if ((location.c & 1) != 0) {
            this.h = location.h;
            this.e |= 4;
            L();
        }
        if (location.G()) {
            this.i = location.i;
            this.e |= 8;
            L();
        }
        if (!location.f2819j.isEmpty()) {
            if (this.f2935j.isEmpty()) {
                this.f2935j = location.f2819j;
                this.e |= 16;
            } else {
                if (!this.f2935j.f2920a) {
                    this.f2935j = new C1005w1(this.f2935j);
                }
                this.e |= 16;
                this.f2935j.addAll(location.f2819j);
            }
            L();
        }
        I(location.b);
        L();
    }

    public final void R(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 8) {
                            int iS = abstractC0972o.s();
                            O();
                            ((C0970n1) this.f).addInt(iS);
                        } else if (iD == 10) {
                            int iJ = abstractC0972o.j(abstractC0972o.w());
                            O();
                            while (abstractC0972o.e() > 0) {
                                ((C0970n1) this.f).addInt(abstractC0972o.s());
                            }
                            abstractC0972o.i(iJ);
                        } else if (iD == 16) {
                            int iS2 = abstractC0972o.s();
                            P();
                            ((C0970n1) this.g).addInt(iS2);
                        } else if (iD == 18) {
                            int iJ2 = abstractC0972o.j(abstractC0972o.w());
                            P();
                            while (abstractC0972o.e() > 0) {
                                ((C0970n1) this.g).addInt(abstractC0972o.s());
                            }
                            abstractC0972o.i(iJ2);
                        } else if (iD == 26) {
                            this.h = abstractC0972o.l();
                            this.e |= 4;
                        } else if (iD == 34) {
                            this.i = abstractC0972o.l();
                            this.e |= 8;
                        } else if (iD == 50) {
                            ByteString byteStringL = abstractC0972o.l();
                            if (!this.f2935j.f2920a) {
                                this.f2935j = new C1005w1(this.f2935j);
                            }
                            this.e |= 16;
                            this.f2935j.a(byteStringL);
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
        DescriptorProtos$SourceCodeInfo.Location locationM = m();
        if (locationM.isInitialized()) {
            return locationM;
        }
        throw AbstractC0916a.x(locationM);
    }

    public final Object clone() {
        return (C0981q0) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2971a0;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo.Location.l;
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
        DescriptorProtos$SourceCodeInfo.Location locationM = m();
        if (locationM.isInitialized()) {
            return locationM;
        }
        throw AbstractC0916a.x(locationM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$SourceCodeInfo.Location) {
            Q((DescriptorProtos$SourceCodeInfo.Location) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$SourceCodeInfo.Location) {
            Q((DescriptorProtos$SourceCodeInfo.Location) abstractC0924c);
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
        return DescriptorProtos$SourceCodeInfo.Location.l;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        R(abstractC0972o, r02);
        return this;
    }
}
