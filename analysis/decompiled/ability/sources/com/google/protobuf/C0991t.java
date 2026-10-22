package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import c0.C0868b;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0991t extends AbstractC0926c1 {
    public int e;
    public Serializable f;
    public List g;
    public List h;
    public List i;

    /* renamed from: j, reason: collision with root package name */
    public List f2942j;
    public List k;
    public List l;
    public DescriptorProtos$MessageOptions m;
    public C0986r2 n;
    public List o;
    public C1005w1 p;

    public C0991t() {
        super(null);
        this.f = "";
        List list = Collections.EMPTY_LIST;
        this.g = list;
        this.h = list;
        this.i = list;
        this.f2942j = list;
        this.k = list;
        this.l = list;
        this.o = list;
        this.p = C1005w1.c;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.d;
        c0868b.g(DescriptorProtos$DescriptorProto.class, C0991t.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$DescriptorProto m() {
        int i;
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = new DescriptorProtos$DescriptorProto(this);
        descriptorProtos$DescriptorProto.d = "";
        descriptorProtos$DescriptorProto.m = C1005w1.c;
        descriptorProtos$DescriptorProto.n = (byte) -1;
        if ((this.e & 2) != 0) {
            this.g = Collections.unmodifiableList(this.g);
            this.e &= -3;
        }
        descriptorProtos$DescriptorProto.e = this.g;
        if ((this.e & 4) != 0) {
            this.h = Collections.unmodifiableList(this.h);
            this.e &= -5;
        }
        descriptorProtos$DescriptorProto.f = this.h;
        if ((this.e & 8) != 0) {
            this.i = Collections.unmodifiableList(this.i);
            this.e &= -9;
        }
        descriptorProtos$DescriptorProto.g = this.i;
        if ((this.e & 16) != 0) {
            this.f2942j = Collections.unmodifiableList(this.f2942j);
            this.e &= -17;
        }
        descriptorProtos$DescriptorProto.h = this.f2942j;
        if ((this.e & 32) != 0) {
            this.k = Collections.unmodifiableList(this.k);
            this.e &= -33;
        }
        descriptorProtos$DescriptorProto.i = this.k;
        if ((this.e & 64) != 0) {
            this.l = Collections.unmodifiableList(this.l);
            this.e &= -65;
        }
        descriptorProtos$DescriptorProto.f2765j = this.l;
        if ((this.e & 256) != 0) {
            this.o = Collections.unmodifiableList(this.o);
            this.e &= -257;
        }
        descriptorProtos$DescriptorProto.l = this.o;
        int i6 = this.e;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$DescriptorProto.d = this.f;
                i = 1;
            } else {
                i = 0;
            }
            if ((i6 & 128) != 0) {
                C0986r2 c0986r2 = this.n;
                descriptorProtos$DescriptorProto.k = c0986r2 == null ? this.m : (DescriptorProtos$MessageOptions) c0986r2.a();
                i |= 2;
            }
            if ((i6 & 512) != 0) {
                this.p.makeImmutable();
                descriptorProtos$DescriptorProto.m = this.p;
            }
            descriptorProtos$DescriptorProto.c |= i;
        }
        K();
        return descriptorProtos$DescriptorProto;
    }

    public final void O() {
        if ((this.e & 32) == 0) {
            this.k = new ArrayList(this.k);
            this.e |= 32;
        }
    }

    public final C0991t P(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$DescriptorProto) {
            R((DescriptorProtos$DescriptorProto) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    public final C0991t Q(AbstractC0972o abstractC0972o, R0 r02) {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
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
                            DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto) abstractC0972o.u(DescriptorProtos$FieldDescriptorProto.f2781q, r02);
                            if ((this.e & 2) == 0) {
                                this.g = new ArrayList(this.g);
                                this.e |= 2;
                            }
                            this.g.add(descriptorProtos$FieldDescriptorProto);
                        case 26:
                            DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto) abstractC0972o.u(DescriptorProtos$DescriptorProto.p, r02);
                            if ((this.e & 8) == 0) {
                                this.i = new ArrayList(this.i);
                                this.e |= 8;
                            }
                            this.i.add(descriptorProtos$DescriptorProto);
                        case 34:
                            DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto) abstractC0972o.u(DescriptorProtos$EnumDescriptorProto.k, r02);
                            if ((this.e & 16) == 0) {
                                this.f2942j = new ArrayList(this.f2942j);
                                this.e |= 16;
                            }
                            this.f2942j.add(descriptorProtos$EnumDescriptorProto);
                        case 42:
                            DescriptorProtos$DescriptorProto.ExtensionRange extensionRange = (DescriptorProtos$DescriptorProto.ExtensionRange) abstractC0972o.u(DescriptorProtos$DescriptorProto.ExtensionRange.i, r02);
                            O();
                            this.k.add(extensionRange);
                        case 50:
                            DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto2 = (DescriptorProtos$FieldDescriptorProto) abstractC0972o.u(DescriptorProtos$FieldDescriptorProto.f2781q, r02);
                            if ((this.e & 4) == 0) {
                                this.h = new ArrayList(this.h);
                                this.e |= 4;
                            }
                            this.h.add(descriptorProtos$FieldDescriptorProto2);
                        case 58:
                            C0986r2 c0986r2 = this.n;
                            if (c0986r2 == null) {
                                if (c0986r2 == null) {
                                    descriptorProtos$MessageOptions = this.m;
                                    if (descriptorProtos$MessageOptions == null) {
                                        descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.m;
                                    }
                                } else {
                                    descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions) c0986r2.c();
                                }
                                this.n = new C0986r2(descriptorProtos$MessageOptions, E(), this.c);
                                this.m = null;
                            }
                            abstractC0972o.v(this.n.b(), r02);
                            this.e |= 128;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                            DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto = (DescriptorProtos$OneofDescriptorProto) abstractC0972o.u(DescriptorProtos$OneofDescriptorProto.h, r02);
                            if ((this.e & 64) == 0) {
                                this.l = new ArrayList(this.l);
                                this.e |= 64;
                            }
                            this.l.add(descriptorProtos$OneofDescriptorProto);
                        case 74:
                            DescriptorProtos$DescriptorProto.ReservedRange reservedRange = (DescriptorProtos$DescriptorProto.ReservedRange) abstractC0972o.u(DescriptorProtos$DescriptorProto.ReservedRange.h, r02);
                            if ((this.e & 256) == 0) {
                                this.o = new ArrayList(this.o);
                                this.e |= 256;
                            }
                            this.o.add(reservedRange);
                        case 82:
                            ByteString byteStringL = abstractC0972o.l();
                            if (!this.p.f2920a) {
                                this.p = new C1005w1(this.p);
                            }
                            this.e |= 512;
                            this.p.a(byteStringL);
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
        return this;
    }

    public final C0991t R(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions2;
        if (descriptorProtos$DescriptorProto == DescriptorProtos$DescriptorProto.o) {
            return this;
        }
        if ((descriptorProtos$DescriptorProto.c & 1) != 0) {
            this.f = descriptorProtos$DescriptorProto.d;
            this.e |= 1;
            L();
        }
        if (!descriptorProtos$DescriptorProto.e.isEmpty()) {
            if (this.g.isEmpty()) {
                this.g = descriptorProtos$DescriptorProto.e;
                this.e &= -3;
            } else {
                if ((this.e & 2) == 0) {
                    this.g = new ArrayList(this.g);
                    this.e |= 2;
                }
                this.g.addAll(descriptorProtos$DescriptorProto.e);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.f.isEmpty()) {
            if (this.h.isEmpty()) {
                this.h = descriptorProtos$DescriptorProto.f;
                this.e &= -5;
            } else {
                if ((this.e & 4) == 0) {
                    this.h = new ArrayList(this.h);
                    this.e |= 4;
                }
                this.h.addAll(descriptorProtos$DescriptorProto.f);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.g.isEmpty()) {
            if (this.i.isEmpty()) {
                this.i = descriptorProtos$DescriptorProto.g;
                this.e &= -9;
            } else {
                if ((this.e & 8) == 0) {
                    this.i = new ArrayList(this.i);
                    this.e |= 8;
                }
                this.i.addAll(descriptorProtos$DescriptorProto.g);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.h.isEmpty()) {
            if (this.f2942j.isEmpty()) {
                this.f2942j = descriptorProtos$DescriptorProto.h;
                this.e &= -17;
            } else {
                if ((this.e & 16) == 0) {
                    this.f2942j = new ArrayList(this.f2942j);
                    this.e |= 16;
                }
                this.f2942j.addAll(descriptorProtos$DescriptorProto.h);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.i.isEmpty()) {
            if (this.k.isEmpty()) {
                this.k = descriptorProtos$DescriptorProto.i;
                this.e &= -33;
            } else {
                O();
                this.k.addAll(descriptorProtos$DescriptorProto.i);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.f2765j.isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = descriptorProtos$DescriptorProto.f2765j;
                this.e &= -65;
            } else {
                if ((this.e & 64) == 0) {
                    this.l = new ArrayList(this.l);
                    this.e |= 64;
                }
                this.l.addAll(descriptorProtos$DescriptorProto.f2765j);
            }
            L();
        }
        if (descriptorProtos$DescriptorProto.G()) {
            DescriptorProtos$MessageOptions descriptorProtos$MessageOptionsF = descriptorProtos$DescriptorProto.F();
            C0986r2 c0986r2 = this.n;
            if (c0986r2 == null) {
                int i = this.e;
                if ((i & 128) == 0 || (descriptorProtos$MessageOptions = this.m) == null || descriptorProtos$MessageOptions == (descriptorProtos$MessageOptions2 = DescriptorProtos$MessageOptions.m)) {
                    this.m = descriptorProtos$MessageOptionsF;
                } else {
                    this.e = i | 128;
                    L();
                    C0986r2 c0986r22 = this.n;
                    if (c0986r22 == null) {
                        if (c0986r22 == null) {
                            DescriptorProtos$MessageOptions descriptorProtos$MessageOptions3 = this.m;
                            if (descriptorProtos$MessageOptions3 != null) {
                                descriptorProtos$MessageOptions2 = descriptorProtos$MessageOptions3;
                            }
                        } else {
                            descriptorProtos$MessageOptions2 = (DescriptorProtos$MessageOptions) c0986r22.c();
                        }
                        this.n = new C0986r2(descriptorProtos$MessageOptions2, E(), this.c);
                        this.m = null;
                    }
                    ((C0917a0) this.n.b()).U(descriptorProtos$MessageOptionsF);
                }
            } else {
                c0986r2.d(descriptorProtos$MessageOptionsF);
            }
            if (this.m != null) {
                this.e |= 128;
                L();
            }
        }
        if (!descriptorProtos$DescriptorProto.l.isEmpty()) {
            if (this.o.isEmpty()) {
                this.o = descriptorProtos$DescriptorProto.l;
                this.e &= -257;
            } else {
                if ((this.e & 256) == 0) {
                    this.o = new ArrayList(this.o);
                    this.e |= 256;
                }
                this.o.addAll(descriptorProtos$DescriptorProto.l);
            }
            L();
        }
        if (!descriptorProtos$DescriptorProto.m.isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = descriptorProtos$DescriptorProto.m;
                this.e |= 512;
            } else {
                if (!this.p.f2920a) {
                    this.p = new C1005w1(this.p);
                }
                this.e |= 512;
                this.p.addAll(descriptorProtos$DescriptorProto.m);
            }
            L();
        }
        I(descriptorProtos$DescriptorProto.b);
        L();
        return this;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProtoM = m();
        if (descriptorProtos$DescriptorProtoM.isInitialized()) {
            return descriptorProtos$DescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$DescriptorProtoM);
    }

    public final Object clone() {
        return (C0991t) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.c;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.o;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions;
        int i = 0;
        while (true) {
            if (i >= this.g.size()) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.h.size()) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= this.i.size()) {
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= this.f2942j.size()) {
                                        int i12 = 0;
                                        while (true) {
                                            if (i12 >= this.k.size()) {
                                                int i13 = 0;
                                                while (true) {
                                                    if (i13 >= this.l.size()) {
                                                        if ((this.e & 128) == 0) {
                                                            return true;
                                                        }
                                                        C0986r2 c0986r2 = this.n;
                                                        if (c0986r2 == null) {
                                                            descriptorProtos$MessageOptions = this.m;
                                                            if (descriptorProtos$MessageOptions == null) {
                                                                descriptorProtos$MessageOptions = DescriptorProtos$MessageOptions.m;
                                                            }
                                                        } else {
                                                            descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions) c0986r2.c();
                                                        }
                                                        if (!descriptorProtos$MessageOptions.isInitialized()) {
                                                            break;
                                                        }
                                                        return true;
                                                    }
                                                    if (!((DescriptorProtos$OneofDescriptorProto) this.l.get(i13)).isInitialized()) {
                                                        break;
                                                    }
                                                    i13++;
                                                }
                                            } else {
                                                if (!((DescriptorProtos$DescriptorProto.ExtensionRange) this.k.get(i12)).isInitialized()) {
                                                    break;
                                                }
                                                i12++;
                                            }
                                        }
                                    } else {
                                        if (!((DescriptorProtos$EnumDescriptorProto) this.f2942j.get(i11)).isInitialized()) {
                                            break;
                                        }
                                        i11++;
                                    }
                                }
                            } else {
                                if (!((DescriptorProtos$DescriptorProto) this.i.get(i10)).isInitialized()) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    } else {
                        if (!((DescriptorProtos$FieldDescriptorProto) this.h.get(i6)).isInitialized()) {
                            break;
                        }
                        i6++;
                    }
                }
            } else {
                if (!((DescriptorProtos$FieldDescriptorProto) this.g.get(i)).isInitialized()) {
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
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProtoM = m();
        if (descriptorProtos$DescriptorProtoM.isInitialized()) {
            return descriptorProtos$DescriptorProtoM;
        }
        throw AbstractC0916a.x(descriptorProtos$DescriptorProtoM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a r(AbstractC0924c abstractC0924c) {
        P(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a t(AbstractC0924c abstractC0924c) {
        P(abstractC0924c);
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
        return DescriptorProtos$DescriptorProto.o;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }
}
