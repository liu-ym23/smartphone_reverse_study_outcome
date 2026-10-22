package com.google.protobuf;

import c0.C0868b;
import com.google.protobuf.DescriptorProtos$FeatureSet;

/* loaded from: classes3.dex */
public final class N extends AbstractC0930d1 {
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f2858j;
    public int k;
    public int l;

    public N() {
        super(null);
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.f2858j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = AbstractC1000v0.f2967X;
        c0868b.g(DescriptorProtos$FeatureSet.class, N.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final DescriptorProtos$FeatureSet m() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSet = new DescriptorProtos$FeatureSet(this);
        int i = 0;
        descriptorProtos$FeatureSet.e = 0;
        descriptorProtos$FeatureSet.f = 0;
        descriptorProtos$FeatureSet.g = 0;
        descriptorProtos$FeatureSet.h = 0;
        descriptorProtos$FeatureSet.i = 0;
        descriptorProtos$FeatureSet.f2774j = 0;
        descriptorProtos$FeatureSet.k = (byte) -1;
        int i6 = this.f;
        if (i6 != 0) {
            if ((i6 & 1) != 0) {
                descriptorProtos$FeatureSet.e = this.g;
                i = 1;
            }
            if ((i6 & 2) != 0) {
                descriptorProtos$FeatureSet.f = this.h;
                i |= 2;
            }
            if ((i6 & 4) != 0) {
                descriptorProtos$FeatureSet.g = this.i;
                i |= 4;
            }
            if ((i6 & 8) != 0) {
                descriptorProtos$FeatureSet.h = this.f2858j;
                i |= 8;
            }
            if ((i6 & 16) != 0) {
                descriptorProtos$FeatureSet.i = this.k;
                i |= 16;
            }
            if ((i6 & 32) != 0) {
                descriptorProtos$FeatureSet.f2774j = this.l;
                i |= 32;
            }
            descriptorProtos$FeatureSet.d = i | descriptorProtos$FeatureSet.d;
        }
        K();
        return descriptorProtos$FeatureSet;
    }

    public final N U(DescriptorProtos$FeatureSet descriptorProtos$FeatureSet) {
        if (descriptorProtos$FeatureSet == DescriptorProtos$FeatureSet.l) {
            return this;
        }
        if ((descriptorProtos$FeatureSet.d & 1) != 0) {
            DescriptorProtos$FeatureSet.FieldPresence fieldPresenceA = DescriptorProtos$FeatureSet.FieldPresence.a(descriptorProtos$FeatureSet.e);
            if (fieldPresenceA == null) {
                fieldPresenceA = DescriptorProtos$FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN;
            }
            this.f |= 1;
            this.g = fieldPresenceA.f2776a;
            L();
        }
        if (descriptorProtos$FeatureSet.E()) {
            DescriptorProtos$FeatureSet.EnumType enumTypeA = DescriptorProtos$FeatureSet.EnumType.a(descriptorProtos$FeatureSet.f);
            if (enumTypeA == null) {
                enumTypeA = DescriptorProtos$FeatureSet.EnumType.ENUM_TYPE_UNKNOWN;
            }
            this.f |= 2;
            this.h = enumTypeA.f2775a;
            L();
        }
        if (descriptorProtos$FeatureSet.H()) {
            DescriptorProtos$FeatureSet.RepeatedFieldEncoding repeatedFieldEncodingA = DescriptorProtos$FeatureSet.RepeatedFieldEncoding.a(descriptorProtos$FeatureSet.g);
            if (repeatedFieldEncodingA == null) {
                repeatedFieldEncodingA = DescriptorProtos$FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN;
            }
            this.f |= 4;
            this.i = repeatedFieldEncodingA.f2779a;
            L();
        }
        if (descriptorProtos$FeatureSet.I()) {
            DescriptorProtos$FeatureSet.Utf8Validation utf8ValidationA = DescriptorProtos$FeatureSet.Utf8Validation.a(descriptorProtos$FeatureSet.h);
            if (utf8ValidationA == null) {
                utf8ValidationA = DescriptorProtos$FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN;
            }
            this.f |= 8;
            this.f2858j = utf8ValidationA.f2780a;
            L();
        }
        if (descriptorProtos$FeatureSet.G()) {
            DescriptorProtos$FeatureSet.MessageEncoding messageEncodingA = DescriptorProtos$FeatureSet.MessageEncoding.a(descriptorProtos$FeatureSet.i);
            if (messageEncodingA == null) {
                messageEncodingA = DescriptorProtos$FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN;
            }
            this.f |= 16;
            this.k = messageEncodingA.f2778a;
            L();
        }
        if (descriptorProtos$FeatureSet.F()) {
            DescriptorProtos$FeatureSet.JsonFormat jsonFormatA = DescriptorProtos$FeatureSet.JsonFormat.a(descriptorProtos$FeatureSet.f2774j);
            if (jsonFormatA == null) {
                jsonFormatA = DescriptorProtos$FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN;
            }
            this.f |= 32;
            this.l = jsonFormatA.f2777a;
            L();
        }
        P(descriptorProtos$FeatureSet);
        I(descriptorProtos$FeatureSet.b);
        L();
        return this;
    }

    public final void V(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 8) {
                            int iN = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.FieldPresence.a(iN) == null) {
                                J(1, iN);
                            } else {
                                this.g = iN;
                                this.f |= 1;
                            }
                        } else if (iD == 16) {
                            int iN2 = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.EnumType.a(iN2) == null) {
                                J(2, iN2);
                            } else {
                                this.h = iN2;
                                this.f |= 2;
                            }
                        } else if (iD == 24) {
                            int iN3 = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.RepeatedFieldEncoding.a(iN3) == null) {
                                J(3, iN3);
                            } else {
                                this.i = iN3;
                                this.f |= 4;
                            }
                        } else if (iD == 32) {
                            int iN4 = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.Utf8Validation.a(iN4) == null) {
                                J(4, iN4);
                            } else {
                                this.f2858j = iN4;
                                this.f |= 8;
                            }
                        } else if (iD == 40) {
                            int iN5 = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.MessageEncoding.a(iN5) == null) {
                                J(5, iN5);
                            } else {
                                this.k = iN5;
                                this.f |= 16;
                            }
                        } else if (iD == 48) {
                            int iN6 = abstractC0972o.n();
                            if (DescriptorProtos$FeatureSet.JsonFormat.a(iN6) == null) {
                                J(6, iN6);
                            } else {
                                this.l = iN6;
                                this.f |= 32;
                            }
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
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSetM = m();
        if (descriptorProtos$FeatureSetM.isInitialized()) {
            return descriptorProtos$FeatureSetM;
        }
        throw AbstractC0916a.x(descriptorProtos$FeatureSetM);
    }

    public final Object clone() {
        return (N) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return AbstractC1000v0.f2966W;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return DescriptorProtos$FeatureSet.l;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return O();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        N(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        DescriptorProtos$FeatureSet descriptorProtos$FeatureSetM = m();
        if (descriptorProtos$FeatureSetM.isInitialized()) {
            return descriptorProtos$FeatureSetM;
        }
        throw AbstractC0916a.x(descriptorProtos$FeatureSetM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof DescriptorProtos$FeatureSet) {
            U((DescriptorProtos$FeatureSet) abstractC0924c);
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
        if (abstractC0924c instanceof DescriptorProtos$FeatureSet) {
            U((DescriptorProtos$FeatureSet) abstractC0924c);
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
        return DescriptorProtos$FeatureSet.l;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        V(abstractC0972o, r02);
        return this;
    }
}
