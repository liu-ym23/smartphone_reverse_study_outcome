package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: com.google.protobuf.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1004w0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$DescriptorProto f2982a;
    public final String b;
    public final E0 c;
    public final C1004w0[] d;
    public final A0[] e;
    public final D0[] f;
    public final D0[] g;
    public final D0[] h;
    public final H0[] i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2983j;
    public final int[] k;
    public final int[] l;

    public C1004w0(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, E0 e02, C1004w0 c1004w0) throws Descriptors$DescriptorValidationException {
        this.f2982a = descriptorProtos$DescriptorProto;
        this.b = J0.a(e02, c1004w0, descriptorProtos$DescriptorProto.E());
        this.c = e02;
        this.i = descriptorProtos$DescriptorProto.f2765j.size() > 0 ? new H0[descriptorProtos$DescriptorProto.f2765j.size()] : J0.g;
        int i = 0;
        for (int i6 = 0; i6 < descriptorProtos$DescriptorProto.f2765j.size(); i6++) {
            this.i[i6] = new H0((DescriptorProtos$OneofDescriptorProto) descriptorProtos$DescriptorProto.f2765j.get(i6), e02, this, i6);
        }
        this.d = descriptorProtos$DescriptorProto.g.size() > 0 ? new C1004w0[descriptorProtos$DescriptorProto.g.size()] : J0.c;
        for (int i10 = 0; i10 < descriptorProtos$DescriptorProto.g.size(); i10++) {
            this.d[i10] = new C1004w0((DescriptorProtos$DescriptorProto) descriptorProtos$DescriptorProto.g.get(i10), e02, this);
        }
        this.e = descriptorProtos$DescriptorProto.h.size() > 0 ? new A0[descriptorProtos$DescriptorProto.h.size()] : J0.e;
        for (int i11 = 0; i11 < descriptorProtos$DescriptorProto.h.size(); i11++) {
            this.e[i11] = new A0((DescriptorProtos$EnumDescriptorProto) descriptorProtos$DescriptorProto.h.get(i11), e02, this);
        }
        this.f = descriptorProtos$DescriptorProto.e.size() > 0 ? new D0[descriptorProtos$DescriptorProto.e.size()] : J0.d;
        for (int i12 = 0; i12 < descriptorProtos$DescriptorProto.e.size(); i12++) {
            this.f[i12] = new D0((DescriptorProtos$FieldDescriptorProto) descriptorProtos$DescriptorProto.e.get(i12), e02, this, i12, false);
        }
        this.g = descriptorProtos$DescriptorProto.e.size() > 0 ? (D0[]) this.f.clone() : J0.d;
        this.h = descriptorProtos$DescriptorProto.f.size() > 0 ? new D0[descriptorProtos$DescriptorProto.f.size()] : J0.d;
        for (int i13 = 0; i13 < descriptorProtos$DescriptorProto.f.size(); i13++) {
            this.h[i13] = new D0((DescriptorProtos$FieldDescriptorProto) descriptorProtos$DescriptorProto.f.get(i13), e02, this, i13, true);
        }
        for (int i14 = 0; i14 < descriptorProtos$DescriptorProto.f2765j.size(); i14++) {
            H0 h02 = this.i[i14];
            h02.g = new D0[h02.f];
            h02.f = 0;
        }
        for (int i15 = 0; i15 < descriptorProtos$DescriptorProto.e.size(); i15++) {
            D0 d02 = this.f[i15];
            H0 h03 = d02.f2763j;
            if (h03 != null) {
                D0[] d0Arr = h03.g;
                int i16 = h03.f;
                h03.f = i16 + 1;
                d0Arr[i16] = d02;
            }
        }
        int i17 = 0;
        for (H0 h04 : this.i) {
            D0[] d0Arr2 = h04.g;
            if (d0Arr2.length == 1 && d0Arr2[0].f) {
                i17++;
            } else if (i17 > 0) {
                throw new Descriptors$DescriptorValidationException(this, "Synthetic oneofs must come last.");
            }
        }
        this.f2983j = this.i.length - i17;
        e02.g.b(this);
        if (descriptorProtos$DescriptorProto.i.size() <= 0) {
            int[] iArr = J0.b;
            this.k = iArr;
            this.l = iArr;
            return;
        }
        this.k = new int[descriptorProtos$DescriptorProto.i.size()];
        this.l = new int[descriptorProtos$DescriptorProto.i.size()];
        for (DescriptorProtos$DescriptorProto.ExtensionRange extensionRange : descriptorProtos$DescriptorProto.i) {
            this.k[i] = extensionRange.d;
            this.l[i] = extensionRange.e;
            i++;
        }
        Arrays.sort(this.k);
        Arrays.sort(this.l);
    }

    @Override // com.google.protobuf.F0
    public final E0 a() {
        return this.c;
    }

    @Override // com.google.protobuf.F0
    public final String b() {
        return this.b;
    }

    @Override // com.google.protobuf.F0
    public final String c() {
        return this.f2982a.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2982a;
    }

    public final void e() throws Descriptors$DescriptorValidationException {
        for (C1004w0 c1004w0 : this.d) {
            c1004w0.e();
        }
        for (D0 d02 : this.f) {
            D0.e(d02);
        }
        D0[] d0Arr = this.g;
        Arrays.sort(d0Arr);
        int i = 0;
        while (true) {
            int i6 = i + 1;
            if (i6 >= d0Arr.length) {
                for (D0 d03 : this.h) {
                    D0.e(d03);
                }
                return;
            }
            D0 d04 = d0Arr[i];
            D0 d05 = d0Arr[i6];
            if (d04.b.e == d05.b.e) {
                throw new Descriptors$DescriptorValidationException(d05, "Field number " + d05.b.e + " has already been used in \"" + d05.h.b + "\" by field \"" + d04.b.H() + "\".");
            }
            i = i6;
        }
    }

    public final D0 f(String str) {
        F0 f0D = this.c.g.d(this.b + '.' + str, Descriptors$DescriptorPool$SearchFilter.c);
        if (f0D instanceof D0) {
            return (D0) f0D;
        }
        return null;
    }

    public final D0 g(int i) {
        D0[] d0Arr = this.g;
        int length = d0Arr.length;
        WireFormat$FieldType[] wireFormat$FieldTypeArr = D0.m;
        Logger logger = J0.f2844a;
        int i6 = length - 1;
        int i10 = 0;
        while (i10 <= i6) {
            int i11 = (i10 + i6) / 2;
            D0 d02 = d0Arr[i11];
            int i12 = d02.b.e;
            if (i < i12) {
                i6 = i11 - 1;
            } else {
                if (i <= i12) {
                    return d02;
                }
                i10 = i11 + 1;
            }
        }
        return null;
    }

    public final List h() {
        return Collections.unmodifiableList(Arrays.asList(this.f));
    }

    public final List i() {
        return Collections.unmodifiableList(Arrays.asList(this.d));
    }

    public final List j() {
        return Collections.unmodifiableList(Arrays.asList(this.i));
    }

    public C1004w0(String str) {
        String strSubstring;
        String strSubstring2;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring2 = str.substring(iLastIndexOf + 1);
            strSubstring = str.substring(0, iLastIndexOf);
        } else {
            strSubstring = "";
            strSubstring2 = str;
        }
        C0991t c0991tH = DescriptorProtos$DescriptorProto.o.toBuilder();
        strSubstring2.getClass();
        c0991tH.f = strSubstring2;
        c0991tH.e |= 1;
        c0991tH.L();
        C0999v c0999vI = DescriptorProtos$DescriptorProto.ExtensionRange.h.toBuilder();
        c0999vI.f = 1;
        c0999vI.e |= 1;
        c0999vI.L();
        c0999vI.g = 536870912;
        c0999vI.e |= 2;
        c0999vI.L();
        DescriptorProtos$DescriptorProto.ExtensionRange extensionRangeN = c0999vI.m();
        if (extensionRangeN.isInitialized()) {
            c0991tH.O();
            c0991tH.k.add(extensionRangeN);
            c0991tH.L();
            DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProtoN = c0991tH.m();
            if (descriptorProtos$DescriptorProtoN.isInitialized()) {
                this.f2982a = descriptorProtos$DescriptorProtoN;
                this.b = str;
                this.d = J0.c;
                this.e = J0.e;
                D0[] d0Arr = J0.d;
                this.f = d0Arr;
                this.g = d0Arr;
                this.h = d0Arr;
                this.i = J0.g;
                this.f2983j = 0;
                this.c = new E0(strSubstring, this);
                this.k = new int[]{1};
                this.l = new int[]{536870912};
                return;
            }
            throw AbstractC0916a.x(descriptorProtos$DescriptorProtoN);
        }
        throw AbstractC0916a.x(extensionRangeN);
    }
}
