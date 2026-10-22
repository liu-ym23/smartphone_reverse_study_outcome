package com.google.protobuf;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes3.dex */
public final class D0 extends F0 implements Comparable, X0 {
    public static final WireFormat$FieldType[] m = WireFormat$FieldType.values();

    /* renamed from: a, reason: collision with root package name */
    public final int f2762a;
    public final DescriptorProtos$FieldDescriptorProto b;
    public final String c;
    public final E0 d;
    public final C1004w0 e;
    public final boolean f;
    public Descriptors$FieldDescriptor$Type g;
    public C1004w0 h;
    public C1004w0 i;

    /* renamed from: j, reason: collision with root package name */
    public final H0 f2763j;
    public A0 k;
    public Object l;

    static {
        if (Descriptors$FieldDescriptor$Type.g.length != DescriptorProtos$FieldDescriptorProto.Type.values().length) {
            throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
        }
    }

    public D0(DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto, E0 e02, C1004w0 c1004w0, int i, boolean z10) throws Descriptors$DescriptorValidationException {
        this.f2762a = i;
        this.b = descriptorProtos$FieldDescriptorProto;
        this.c = J0.a(e02, c1004w0, descriptorProtos$FieldDescriptorProto.H());
        this.d = e02;
        if (descriptorProtos$FieldDescriptorProto.S()) {
            this.g = Descriptors$FieldDescriptor$Type.g[(DescriptorProtos$FieldDescriptorProto.Type.a(descriptorProtos$FieldDescriptorProto.g) == null ? DescriptorProtos$FieldDescriptorProto.Type.TYPE_DOUBLE : r5).f2789a - 1];
        }
        this.f = descriptorProtos$FieldDescriptorProto.n;
        if (descriptorProtos$FieldDescriptorProto.e <= 0) {
            throw new Descriptors$DescriptorValidationException(this, "Field numbers must be positive integers.");
        }
        if (z10) {
            if (!descriptorProtos$FieldDescriptorProto.L()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.");
            }
            this.h = null;
            if (c1004w0 != null) {
                this.e = c1004w0;
            } else {
                this.e = null;
            }
            if (descriptorProtos$FieldDescriptorProto.P()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.");
            }
            this.f2763j = null;
        } else {
            if (descriptorProtos$FieldDescriptorProto.L()) {
                throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.");
            }
            this.h = c1004w0;
            if (descriptorProtos$FieldDescriptorProto.P()) {
                int i6 = descriptorProtos$FieldDescriptorProto.k;
                if (i6 < 0 || i6 >= c1004w0.f2982a.f2765j.size()) {
                    throw new Descriptors$DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + c1004w0.f2982a.E());
                }
                H0 h02 = (H0) c1004w0.j().get(descriptorProtos$FieldDescriptorProto.k);
                this.f2763j = h02;
                h02.f++;
            } else {
                this.f2763j = null;
            }
            this.e = null;
        }
        e02.g.b(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(D0 d02) throws Descriptors$DescriptorValidationException {
        E0 e02 = d02.d;
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = d02.b;
        if (descriptorProtos$FieldDescriptorProto.L()) {
            F0 f0F = e02.g.f(d02, descriptorProtos$FieldDescriptorProto.F());
            if (!(f0F instanceof C1004w0)) {
                throw new Descriptors$DescriptorValidationException(d02, "\"" + descriptorProtos$FieldDescriptorProto.F() + "\" is not a message type.");
            }
            C1004w0 c1004w0 = (C1004w0) f0F;
            d02.h = c1004w0;
            int i = descriptorProtos$FieldDescriptorProto.e;
            int iBinarySearch = Arrays.binarySearch(c1004w0.k, i);
            if (iBinarySearch < 0) {
                iBinarySearch = (~iBinarySearch) - 1;
            }
            if (iBinarySearch < 0 || i >= c1004w0.l[iBinarySearch]) {
                StringBuilder sb = new StringBuilder("\"");
                sb.append(d02.h.b);
                sb.append("\" does not declare ");
                throw new Descriptors$DescriptorValidationException(d02, androidx.appfunctions.metadata.a.o(sb, " as an extension number.", descriptorProtos$FieldDescriptorProto.e));
            }
        }
        if (descriptorProtos$FieldDescriptorProto.T()) {
            F0 f0F2 = e02.g.f(d02, descriptorProtos$FieldDescriptorProto.J());
            if (!descriptorProtos$FieldDescriptorProto.S()) {
                if (f0F2 instanceof C1004w0) {
                    d02.g = Descriptors$FieldDescriptor$Type.d;
                } else {
                    if (!(f0F2 instanceof A0)) {
                        throw new Descriptors$DescriptorValidationException(d02, "\"" + descriptorProtos$FieldDescriptorProto.J() + "\" is not a type.");
                    }
                    d02.g = Descriptors$FieldDescriptor$Type.f;
                }
            }
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = d02.g.f2824a;
            if (descriptors$FieldDescriptor$JavaType == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (!(f0F2 instanceof C1004w0)) {
                    throw new Descriptors$DescriptorValidationException(d02, "\"" + descriptorProtos$FieldDescriptorProto.J() + "\" is not a message type.");
                }
                d02.i = (C1004w0) f0F2;
                if (descriptorProtos$FieldDescriptorProto.K()) {
                    throw new Descriptors$DescriptorValidationException(d02, "Messages can't have default values.");
                }
            } else {
                if (descriptors$FieldDescriptor$JavaType != Descriptors$FieldDescriptor$JavaType.ENUM) {
                    throw new Descriptors$DescriptorValidationException(d02, "Field with primitive type has type_name.");
                }
                if (!(f0F2 instanceof A0)) {
                    throw new Descriptors$DescriptorValidationException(d02, "\"" + descriptorProtos$FieldDescriptorProto.J() + "\" is not an enum type.");
                }
                d02.k = (A0) f0F2;
            }
        } else {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2 = d02.g.f2824a;
            if (descriptors$FieldDescriptor$JavaType2 == Descriptors$FieldDescriptor$JavaType.MESSAGE || descriptors$FieldDescriptor$JavaType2 == Descriptors$FieldDescriptor$JavaType.ENUM) {
                throw new Descriptors$DescriptorValidationException(d02, "Field with message or enum type missing type_name.");
            }
        }
        if (descriptorProtos$FieldDescriptorProto.I().f && !d02.m()) {
            throw new Descriptors$DescriptorValidationException(d02, "[packed = true] can only be specified for repeated primitive fields.");
        }
        if (descriptorProtos$FieldDescriptorProto.K()) {
            if (d02.isRepeated()) {
                throw new Descriptors$DescriptorValidationException(d02, "Repeated fields cannot have default values.");
            }
            try {
                switch (d02.g.ordinal()) {
                    case 0:
                        if (!descriptorProtos$FieldDescriptorProto.E().equals("inf")) {
                            if (!descriptorProtos$FieldDescriptorProto.E().equals("-inf")) {
                                if (!descriptorProtos$FieldDescriptorProto.E().equals("nan")) {
                                    d02.l = Double.valueOf(descriptorProtos$FieldDescriptorProto.E());
                                    break;
                                } else {
                                    d02.l = Double.valueOf(Double.NaN);
                                    break;
                                }
                            } else {
                                d02.l = Double.valueOf(Double.NEGATIVE_INFINITY);
                                break;
                            }
                        } else {
                            d02.l = Double.valueOf(Double.POSITIVE_INFINITY);
                            break;
                        }
                    case 1:
                        if (!descriptorProtos$FieldDescriptorProto.E().equals("inf")) {
                            if (!descriptorProtos$FieldDescriptorProto.E().equals("-inf")) {
                                if (!descriptorProtos$FieldDescriptorProto.E().equals("nan")) {
                                    d02.l = Float.valueOf(descriptorProtos$FieldDescriptorProto.E());
                                    break;
                                } else {
                                    d02.l = Float.valueOf(Float.NaN);
                                    break;
                                }
                            } else {
                                d02.l = Float.valueOf(Float.NEGATIVE_INFINITY);
                                break;
                            }
                        } else {
                            d02.l = Float.valueOf(Float.POSITIVE_INFINITY);
                            break;
                        }
                    case 2:
                    case 15:
                    case 17:
                        d02.l = Long.valueOf(E2.c(descriptorProtos$FieldDescriptorProto.E(), true, true));
                        break;
                    case 3:
                    case 5:
                        d02.l = Long.valueOf(E2.c(descriptorProtos$FieldDescriptorProto.E(), false, true));
                        break;
                    case 4:
                    case 14:
                    case 16:
                        d02.l = Integer.valueOf((int) E2.c(descriptorProtos$FieldDescriptorProto.E(), true, false));
                        break;
                    case 6:
                    case 12:
                        d02.l = Integer.valueOf((int) E2.c(descriptorProtos$FieldDescriptorProto.E(), false, false));
                        break;
                    case 7:
                        d02.l = Boolean.valueOf(descriptorProtos$FieldDescriptorProto.E());
                        break;
                    case 8:
                        d02.l = descriptorProtos$FieldDescriptorProto.E();
                        break;
                    case 9:
                    case 10:
                        throw new Descriptors$DescriptorValidationException(d02, "Message type had default value.");
                    case 11:
                        try {
                            d02.l = E2.d(descriptorProtos$FieldDescriptorProto.E());
                            break;
                        } catch (TextFormat$InvalidEscapeSequenceException e) {
                            Descriptors$DescriptorValidationException descriptors$DescriptorValidationException = new Descriptors$DescriptorValidationException(d02, "Couldn't parse default value: " + e.getMessage());
                            descriptors$DescriptorValidationException.initCause(e);
                            throw descriptors$DescriptorValidationException;
                        }
                    case 13:
                        A0 a02 = d02.k;
                        String strE = descriptorProtos$FieldDescriptorProto.E();
                        F0 f0D = a02.c.g.d(a02.b + '.' + strE, Descriptors$DescriptorPool$SearchFilter.c);
                        C0 c02 = f0D instanceof C0 ? (C0) f0D : null;
                        d02.l = c02;
                        if (c02 == null) {
                            throw new Descriptors$DescriptorValidationException(d02, "Unknown enum default value: \"" + descriptorProtos$FieldDescriptorProto.E() + JsonFactory.DEFAULT_QUOTE_CHAR);
                        }
                        break;
                }
            } catch (NumberFormatException e6) {
                Descriptors$DescriptorValidationException descriptors$DescriptorValidationException2 = new Descriptors$DescriptorValidationException(d02, "Could not parse default value: \"" + descriptorProtos$FieldDescriptorProto.E() + JsonFactory.DEFAULT_QUOTE_CHAR);
                descriptors$DescriptorValidationException2.initCause(e6);
                throw descriptors$DescriptorValidationException2;
            }
        } else if (d02.isRepeated()) {
            d02.l = Collections.EMPTY_LIST;
        } else {
            int iOrdinal = d02.g.f2824a.ordinal();
            if (iOrdinal == 7) {
                d02.l = Collections.unmodifiableList(Arrays.asList(d02.k.d)).get(0);
            } else if (iOrdinal != 8) {
                d02.l = d02.g.f2824a.f2823a;
            } else {
                d02.l = null;
            }
        }
        C1004w0 c1004w02 = d02.h;
        if (c1004w02 == null || !c1004w02.f2982a.F().e) {
            return;
        }
        if (!descriptorProtos$FieldDescriptorProto.L()) {
            throw new Descriptors$DescriptorValidationException(d02, "MessageSets cannot have fields, only extensions.");
        }
        if (!d02.l() || d02.g != Descriptors$FieldDescriptor$Type.d) {
            throw new Descriptors$DescriptorValidationException(d02, "Extensions of MessageSets must be optional messages.");
        }
    }

    @Override // com.google.protobuf.F0
    public final E0 a() {
        return this.d;
    }

    @Override // com.google.protobuf.F0
    public final String b() {
        return this.c;
    }

    @Override // com.google.protobuf.F0
    public final String c() {
        return this.b.H();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        D0 d02 = (D0) obj;
        if (d02.h == this.h) {
            return this.b.e - d02.b.e;
        }
        throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.b;
    }

    public final Object f() {
        if (this.g.f2824a != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return this.l;
        }
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
    }

    public final A0 g() {
        if (this.g.f2824a == Descriptors$FieldDescriptor$JavaType.ENUM) {
            return this.k;
        }
        throw new UnsupportedOperationException(B7.a.m("This field is not of enum type. (", this.c, ")"));
    }

    public final WireFormat$FieldType h() {
        return m[this.g.ordinal()];
    }

    public final C1004w0 i() {
        if (this.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return this.i;
        }
        throw new UnsupportedOperationException(B7.a.m("This field is not of message type. (", this.c, ")"));
    }

    public final boolean isPacked() {
        if (!m()) {
            return false;
        }
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$SyntaxG = this.d.g();
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.f2825a;
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = this.b;
        return descriptors$FileDescriptor$SyntaxG == descriptors$FileDescriptor$Syntax ? descriptorProtos$FieldDescriptorProto.I().f : !descriptorProtos$FieldDescriptorProto.I().K() || descriptorProtos$FieldDescriptorProto.I().f;
    }

    public final boolean isRepeated() {
        DescriptorProtos$FieldDescriptorProto.Label labelA = DescriptorProtos$FieldDescriptorProto.Label.a(this.b.f);
        if (labelA == null) {
            labelA = DescriptorProtos$FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }
        return labelA == DescriptorProtos$FieldDescriptorProto.Label.LABEL_REPEATED;
    }

    public final boolean j() {
        if (isRepeated()) {
            return false;
        }
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = this.g;
        return descriptors$FieldDescriptor$Type == Descriptors$FieldDescriptor$Type.d || descriptors$FieldDescriptor$Type == Descriptors$FieldDescriptor$Type.c || this.f2763j != null || this.d.g() == Descriptors$FileDescriptor$Syntax.f2825a;
    }

    public final boolean k() {
        return this.g == Descriptors$FieldDescriptor$Type.d && isRepeated() && i().f2982a.F().h;
    }

    public final boolean l() {
        DescriptorProtos$FieldDescriptorProto.Label labelA = DescriptorProtos$FieldDescriptorProto.Label.a(this.b.f);
        if (labelA == null) {
            labelA = DescriptorProtos$FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }
        return labelA == DescriptorProtos$FieldDescriptorProto.Label.LABEL_OPTIONAL;
    }

    public final boolean m() {
        return isRepeated() && h().a();
    }

    public final boolean n() {
        DescriptorProtos$FieldDescriptorProto.Label labelA = DescriptorProtos$FieldDescriptorProto.Label.a(this.b.f);
        if (labelA == null) {
            labelA = DescriptorProtos$FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }
        return labelA == DescriptorProtos$FieldDescriptorProto.Label.LABEL_REQUIRED;
    }

    public final boolean o() {
        return this.g == Descriptors$FieldDescriptor$Type.f && this.d.g() == Descriptors$FileDescriptor$Syntax.f2825a;
    }

    public final boolean p() {
        if (this.g != Descriptors$FieldDescriptor$Type.b) {
            return false;
        }
        if (this.h.f2982a.F().h) {
            return true;
        }
        E0 e02 = this.d;
        if (e02.g() == Descriptors$FileDescriptor$Syntax.b) {
            return true;
        }
        return e02.f2826a.F().i;
    }

    public final String toString() {
        return this.c;
    }
}
