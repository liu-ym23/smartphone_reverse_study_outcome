package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import c0.C0868b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes3.dex */
public final class W extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public Serializable g;
    public C1005w1 h;
    public InterfaceC0982q1 i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0982q1 f2880j;
    public List k;
    public List l;
    public List m;
    public List n;
    public DescriptorProtos$FileOptions o;
    public C0986r2 p;

    /* renamed from: q, reason: collision with root package name */
    public DescriptorProtos$SourceCodeInfo f2881q;

    /* renamed from: r, reason: collision with root package name */
    public C0986r2 f2882r;

    /* renamed from: s, reason: collision with root package name */
    public Serializable f2883s;

    /* renamed from: t, reason: collision with root package name */
    public int f2884t;

    public W() {
        super(null);
        this.f = "";
        this.g = "";
        this.h = C1005w1.c;
        C0970n1 c0970n1 = C0970n1.d;
        this.i = c0970n1;
        this.f2880j = c0970n1;
        List list = Collections.EMPTY_LIST;
        this.k = list;
        this.l = list;
        this.m = list;
        this.n = list;
        this.f2883s = "";
        this.f2884t = 0;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.b;
        c0868b.g(DescriptorProtos$FileDescriptorProto.class, W.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FileDescriptorProto m() {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = new DescriptorProtos$FileDescriptorProto(this);
        descriptorProtos$FileDescriptorProto.d = "";
        descriptorProtos$FileDescriptorProto.e = "";
        descriptorProtos$FileDescriptorProto.f = C1005w1.c;
        C0970n1 c0970n1 = C0970n1.d;
        descriptorProtos$FileDescriptorProto.g = c0970n1;
        descriptorProtos$FileDescriptorProto.h = c0970n1;
        descriptorProtos$FileDescriptorProto.o = "";
        int i = 0;
        descriptorProtos$FileDescriptorProto.p = 0;
        descriptorProtos$FileDescriptorProto.f2802q = (byte) -1;
        if ((this.e & 32) != 0) {
            this.k = Collections.unmodifiableList(this.k);
            this.e &= -33;
        }
        descriptorProtos$FileDescriptorProto.i = this.k;
        if ((this.e & 64) != 0) {
            this.l = Collections.unmodifiableList(this.l);
            this.e &= -65;
        }
        descriptorProtos$FileDescriptorProto.f2801j = this.l;
        if ((this.e & 128) != 0) {
            this.m = Collections.unmodifiableList(this.m);
            this.e &= -129;
        }
        descriptorProtos$FileDescriptorProto.k = this.m;
        if ((this.e & 256) != 0) {
            this.n = Collections.unmodifiableList(this.n);
            this.e &= -257;
        }
        descriptorProtos$FileDescriptorProto.l = this.n;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$FileDescriptorProto.d = this.f;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$FileDescriptorProto.e = this.g;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                this.h.makeImmutable();
                descriptorProtos$FileDescriptorProto.f = this.h;
            }
            if ((i6 & 8) != 0) {
                ((AbstractC0940g) this.i).makeImmutable();
                descriptorProtos$FileDescriptorProto.g = this.i;
            }
            if ((i6 & 16) != 0) {
                ((AbstractC0940g) this.f2880j).makeImmutable();
                descriptorProtos$FileDescriptorProto.h = this.f2880j;
            }
            if ((i6 & 512) != 0) {
                C0986r2 c0986r2 = this.p;
                descriptorProtos$FileDescriptorProto.m = c0986r2 == null ? this.o : (DescriptorProtos$FileOptions) c0986r2.a();
                i |= 4;
            }
            if ((i6 & 1024) != 0) {
                C0986r2 c0986r22 = this.f2882r;
                descriptorProtos$FileDescriptorProto.n = c0986r22 == null ? this.f2881q : (DescriptorProtos$SourceCodeInfo) c0986r22.a();
                i |= 8;
            }
            if ((i6 & 2048) != 0) {
                descriptorProtos$FileDescriptorProto.o = this.f2883s;
                i |= 16;
            }
            if ((i6 & 4096) != 0) {
                descriptorProtos$FileDescriptorProto.p = this.f2884t;
                i |= 32;
            }
            descriptorProtos$FileDescriptorProto.c = i | descriptorProtos$FileDescriptorProto.c;
        }
        K();
        return descriptorProtos$FileDescriptorProto;
    }

    public final void O() {
        if ((this.e & 32) == 0) {
            this.k = new ArrayList(this.k);
            this.e |= 32;
        }
    }

    public final void P() {
        InterfaceC0985r1 interfaceC0985r1 = this.i;
        if (!((AbstractC0940g) interfaceC0985r1).f2920a) {
            this.i = (InterfaceC0982q1) GeneratedMessageV3.A(interfaceC0985r1);
        }
        this.e |= 8;
    }

    public final void Q() {
        InterfaceC0985r1 interfaceC0985r1 = this.f2880j;
        if (!((AbstractC0940g) interfaceC0985r1).f2920a) {
            this.f2880j = (InterfaceC0982q1) GeneratedMessageV3.A(interfaceC0985r1);
        }
        this.e |= 16;
    }

    public final C0986r2 R() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        C0986r2 c0986r2 = this.f2882r;
        if (c0986r2 == null) {
            if (c0986r2 == null) {
                descriptorProtos$SourceCodeInfo = this.f2881q;
                if (descriptorProtos$SourceCodeInfo == null) {
                    descriptorProtos$SourceCodeInfo = DescriptorProtos$SourceCodeInfo.e;
                }
            } else {
                descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo) c0986r2.c();
            }
            this.f2882r = new C0986r2(descriptorProtos$SourceCodeInfo, E(), this.c);
            this.f2881q = null;
        }
        return this.f2882r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo;
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        DescriptorProtos$FileOptions descriptorProtos$FileOptions2;
        if (descriptorProtos$FileDescriptorProto == DescriptorProtos$FileDescriptorProto.f2799r) {
            return;
        }
        if ((descriptorProtos$FileDescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$FileDescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (descriptorProtos$FileDescriptorProto.L()) {
            this.g = descriptorProtos$FileDescriptorProto.e;
            this.e |= 2;
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.f.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = descriptorProtos$FileDescriptorProto.f;
                this.e |= 4;
            } else {
                if (!this.h.f2920a) {
                    this.h = new C1005w1(this.h);
                }
                this.e |= 4;
                this.h.addAll(descriptorProtos$FileDescriptorProto.f);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.g.isEmpty()) {
            if (this.i.isEmpty()) {
                InterfaceC0982q1 interfaceC0982q1 = descriptorProtos$FileDescriptorProto.g;
                this.i = interfaceC0982q1;
                ((AbstractC0940g) interfaceC0982q1).makeImmutable();
                this.e |= 8;
            } else {
                P();
                this.i.addAll(descriptorProtos$FileDescriptorProto.g);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.h.isEmpty()) {
            if (this.f2880j.isEmpty()) {
                InterfaceC0982q1 interfaceC0982q12 = descriptorProtos$FileDescriptorProto.h;
                this.f2880j = interfaceC0982q12;
                ((AbstractC0940g) interfaceC0982q12).makeImmutable();
                this.e |= 16;
            } else {
                Q();
                this.f2880j.addAll(descriptorProtos$FileDescriptorProto.h);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.i.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = descriptorProtos$FileDescriptorProto.i;
                this.e &= -33;
            } else {
                O();
                this.k.addAll(descriptorProtos$FileDescriptorProto.i);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.f2801j.isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = descriptorProtos$FileDescriptorProto.f2801j;
                this.e &= -65;
            } else {
                if ((this.e & 64) == 0) {
                    this.l = new ArrayList(this.l);
                    this.e |= 64;
                }
                this.l.addAll(descriptorProtos$FileDescriptorProto.f2801j);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.k.isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = descriptorProtos$FileDescriptorProto.k;
                this.e &= -129;
            } else {
                if ((this.e & 128) == 0) {
                    this.m = new ArrayList(this.m);
                    this.e |= 128;
                }
                this.m.addAll(descriptorProtos$FileDescriptorProto.k);
            }
            L();
        }
        if (!descriptorProtos$FileDescriptorProto.l.isEmpty()) {
            if (this.n.isEmpty()) {
                this.n = descriptorProtos$FileDescriptorProto.l;
                this.e &= -257;
            } else {
                if ((this.e & 256) == 0) {
                    this.n = new ArrayList(this.n);
                    this.e |= 256;
                }
                this.n.addAll(descriptorProtos$FileDescriptorProto.l);
            }
            L();
        }
        if (descriptorProtos$FileDescriptorProto.K()) {
            DescriptorProtos$FileOptions descriptorProtos$FileOptionsF = descriptorProtos$FileDescriptorProto.F();
            C0986r2 c0986r2 = this.p;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 512) == 0 || (descriptorProtos$FileOptions = this.o) == null || descriptorProtos$FileOptions == (descriptorProtos$FileOptions2 = DescriptorProtos$FileOptions.f2803B)) {
                    this.o = descriptorProtos$FileOptionsF;
                } else {
                    this.e = i | 512;
                    L();
                    C0986r2 c0986r22 = this.p;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$FileOptions descriptorProtos$FileOptions3 = this.o;
                            if (descriptorProtos$FileOptions3 != null) {
                                descriptorProtos$FileOptions2 = descriptorProtos$FileOptions3;
                            }
                        } else {
                            descriptorProtos$FileOptions2 = (DescriptorProtos$FileOptions) c0986r22.c();
                        }
                        this.p = new C0986r2(descriptorProtos$FileOptions2, E(), this.c);
                        this.o = null;
                    }
                    ((Y) this.p.b()).U(descriptorProtos$FileOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$FileOptionsF);
            }
            if (this.o != null) {
                this.e |= 512;
                L();
            }
        }
        if (descriptorProtos$FileDescriptorProto.M()) {
            DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfoH = descriptorProtos$FileDescriptorProto.H();
            C0986r2 c0986r23 = this.f2882r;
            if (c0986r23 == null) {
                int i6 = this.e;
                if ((i6 & 1024) == 0 || (descriptorProtos$SourceCodeInfo = this.f2881q) == null || descriptorProtos$SourceCodeInfo == DescriptorProtos$SourceCodeInfo.e) {
                    this.f2881q = descriptorProtos$SourceCodeInfoH;
                } else {
                    this.e = i6 | 1024;
                    L();
                    ((C0973o0) R().b()).O(descriptorProtos$SourceCodeInfoH);
                }
            } else {
                c0986r23.d(descriptorProtos$SourceCodeInfoH);
            }
            if (this.f2881q != null) {
                this.e |= 1024;
                L();
            }
        }
        if (descriptorProtos$FileDescriptorProto.N()) {
            this.f2883s = descriptorProtos$FileDescriptorProto.o;
            this.e |= 2048;
            L();
        }
        if (descriptorProtos$FileDescriptorProto.J()) {
            DescriptorProtos$Edition descriptorProtos$EditionA = DescriptorProtos$Edition.a(descriptorProtos$FileDescriptorProto.p);
            if (descriptorProtos$EditionA == null) {
                descriptorProtos$EditionA = DescriptorProtos$Edition.EDITION_UNKNOWN;
            }
            this.e |= 4096;
            this.f2884t = descriptorProtos$EditionA.f2767a;
            L();
        }
        I(descriptorProtos$FileDescriptorProto.b);
        L();
    }

    public final void T(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
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
                            this.f = abstractC0972o.l();
                            this.e |= 1;
                        case 18:
                            this.g = abstractC0972o.l();
                            this.e |= 2;
                        case 26:
                            ByteString byteStringL = abstractC0972o.l();
                            if (!this.h.f2920a) {
                                this.h = new C1005w1(this.h);
                            }
                            this.e |= 4;
                            this.h.a(byteStringL);
                        case 34:
                            DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto) abstractC0972o.u(DescriptorProtos$DescriptorProto.p, r02);
                            O();
                            this.k.add(descriptorProtos$DescriptorProto);
                        case 42:
                            DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto) abstractC0972o.u(DescriptorProtos$EnumDescriptorProto.k, r02);
                            if ((this.e & 64) == 0) {
                                this.l = new ArrayList(this.l);
                                this.e |= 64;
                            }
                            this.l.add(descriptorProtos$EnumDescriptorProto);
                        case 50:
                            DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto) abstractC0972o.u(DescriptorProtos$ServiceDescriptorProto.i, r02);
                            if ((this.e & 128) == 0) {
                                this.m = new ArrayList(this.m);
                                this.e |= 128;
                            }
                            this.m.add(descriptorProtos$ServiceDescriptorProto);
                        case 58:
                            DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto) abstractC0972o.u(DescriptorProtos$FieldDescriptorProto.f2781q, r02);
                            if ((this.e & 256) == 0) {
                                this.n = new ArrayList(this.n);
                                this.e |= 256;
                            }
                            this.n.add(descriptorProtos$FieldDescriptorProto);
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            C0986r2 c0986r2 = this.p;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$FileOptions = this.o;
                                    if (descriptorProtos$FileOptions == null) {
                                        descriptorProtos$FileOptions = DescriptorProtos$FileOptions.f2803B;
                                    }
                                } else {
                                    descriptorProtos$FileOptions = (DescriptorProtos$FileOptions) c0986r2.c();
                                }
                                this.p = new C0986r2(descriptorProtos$FileOptions, E(), this.c);
                                this.o = null;
                            }
                            abstractC0972o.v(this.p.b(), r02);
                            this.e |= 512;
                        case 74:
                            abstractC0972o.v(R().b(), r02);
                            this.e |= 1024;
                        case WebSocketImpl.DEFAULT_PORT /* 80 */:
                            int iS = abstractC0972o.s();
                            P();
                            ((C0970n1) this.i).addInt(iS);
                        case 82:
                            int iJ = abstractC0972o.j(abstractC0972o.w());
                            P();
                            while (abstractC0972o.e() > 0) {
                                ((C0970n1) this.i).addInt(abstractC0972o.s());
                            }
                            abstractC0972o.i(iJ);
                        case 88:
                            int iS2 = abstractC0972o.s();
                            Q();
                            ((C0970n1) this.f2880j).addInt(iS2);
                        case 90:
                            int iJ2 = abstractC0972o.j(abstractC0972o.w());
                            Q();
                            while (abstractC0972o.e() > 0) {
                                ((C0970n1) this.f2880j).addInt(abstractC0972o.s());
                            }
                            abstractC0972o.i(iJ2);
                        case 98:
                            this.f2883s = abstractC0972o.l();
                            this.e |= 2048;
                        case 112:
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$Edition.a(iN) == null) {
                                J(14, iN);
                            } else {
                                this.f2884t = iN;
                                this.e |= 4096;
                            }
                        default:
                            if (!p().m(iD, abstractC0972o)) {
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
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProtoM = m();
        if (descriptorProtos$FileDescriptorProtoM.isInitialized()) {
            return descriptorProtos$FileDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$FileDescriptorProtoM);
    }

    public final Object clone() {
        return (W) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2970a;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorProto.f2799r;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$FileOptions descriptorProtos$FileOptions;
        int i = 0;
        while (true) {
            if (i >= this.k.size()) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.l.size()) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= this.m.size()) {
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= this.n.size()) {
                                        if ((this.e & 512) == 0) {
                                            return true;
                                        }
                                        C0986r2 c0986r2 = this.p;
                                        if (c0986r2 == null) {
                                            descriptorProtos$FileOptions = this.o;
                                            if (descriptorProtos$FileOptions == null) {
                                                descriptorProtos$FileOptions = DescriptorProtos$FileOptions.f2803B;
                                            }
                                        } else {
                                            descriptorProtos$FileOptions = (DescriptorProtos$FileOptions) c0986r2.c();
                                        }
                                        if (!descriptorProtos$FileOptions.isInitialized()) {
                                            break;
                                        }
                                        return true;
                                    }
                                    if (!((DescriptorProtos$FieldDescriptorProto) this.n.get(i11)).isInitialized()) {
                                        break;
                                    }
                                    i11++;
                                }
                            } else {
                                if (!((DescriptorProtos$ServiceDescriptorProto) this.m.get(i10)).isInitialized()) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    } else {
                        if (!((DescriptorProtos$EnumDescriptorProto) this.l.get(i6)).isInitialized()) {
                            break;
                        }
                        i6++;
                    }
                }
            } else {
                if (!((DescriptorProtos$DescriptorProto) this.k.get(i)).isInitialized()) {
                    break;
                }
                i++;
            }
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
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProtoM = m();
        if (descriptorProtos$FileDescriptorProtoM.isInitialized()) {
            return descriptorProtos$FileDescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$FileDescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        T(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FileDescriptorProto) {
            S((DescriptorProtos$FileDescriptorProto) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        T(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FileDescriptorProto) {
            S((DescriptorProtos$FileDescriptorProto) abstractC0924c);
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
        return DescriptorProtos$FileDescriptorProto.f2799r;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        T(abstractC0972o, r02);
        return this;
    }
}
