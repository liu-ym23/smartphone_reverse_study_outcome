package com.google.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class E0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$FileDescriptorProto f2826a;
    public final C1004w0[] b;
    public final A0[] c;
    public final I0[] d;
    public final D0[] e;
    public final E0[] f;
    public final C1012y0 g;

    public E0(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, E0[] e0Arr, C1012y0 c1012y0) throws Descriptors$DescriptorValidationException {
        this.g = c1012y0;
        this.f2826a = descriptorProtos$FileDescriptorProto;
        HashMap map = new HashMap();
        for (E0 e02 : e0Arr) {
            map.put(e02.f2826a.E(), e02);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < descriptorProtos$FileDescriptorProto.g.size(); i++) {
            int i6 = ((C0970n1) descriptorProtos$FileDescriptorProto.g).getInt(i);
            if (i6 < 0 || i6 >= descriptorProtos$FileDescriptorProto.f.b.size()) {
                throw new Descriptors$DescriptorValidationException(this, "Invalid public dependency index.");
            }
            E0 e03 = (E0) map.get(descriptorProtos$FileDescriptorProto.f.get(i6));
            if (e03 != null) {
                arrayList.add(e03);
            }
        }
        E0[] e0Arr2 = new E0[arrayList.size()];
        this.f = e0Arr2;
        arrayList.toArray(e0Arr2);
        c1012y0.a(this, this.f2826a.G());
        this.b = descriptorProtos$FileDescriptorProto.i.size() > 0 ? new C1004w0[descriptorProtos$FileDescriptorProto.i.size()] : J0.c;
        for (int i10 = 0; i10 < descriptorProtos$FileDescriptorProto.i.size(); i10++) {
            this.b[i10] = new C1004w0((DescriptorProtos$DescriptorProto) descriptorProtos$FileDescriptorProto.i.get(i10), this, null);
        }
        this.c = descriptorProtos$FileDescriptorProto.f2801j.size() > 0 ? new A0[descriptorProtos$FileDescriptorProto.f2801j.size()] : J0.e;
        for (int i11 = 0; i11 < descriptorProtos$FileDescriptorProto.f2801j.size(); i11++) {
            this.c[i11] = new A0((DescriptorProtos$EnumDescriptorProto) descriptorProtos$FileDescriptorProto.f2801j.get(i11), this, null);
        }
        this.d = descriptorProtos$FileDescriptorProto.k.size() > 0 ? new I0[descriptorProtos$FileDescriptorProto.k.size()] : J0.f;
        for (int i12 = 0; i12 < descriptorProtos$FileDescriptorProto.k.size(); i12++) {
            this.d[i12] = new I0((DescriptorProtos$ServiceDescriptorProto) descriptorProtos$FileDescriptorProto.k.get(i12), this);
        }
        this.e = descriptorProtos$FileDescriptorProto.l.size() > 0 ? new D0[descriptorProtos$FileDescriptorProto.l.size()] : J0.d;
        for (int i13 = 0; i13 < descriptorProtos$FileDescriptorProto.l.size(); i13++) {
            this.e[i13] = new D0((DescriptorProtos$FieldDescriptorProto) descriptorProtos$FileDescriptorProto.l.get(i13), this, null, i13, true);
        }
    }

    public static E0 e(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, E0[] e0Arr) throws Descriptors$DescriptorValidationException {
        E0 e02 = new E0(descriptorProtos$FileDescriptorProto, e0Arr, new C1012y0(e0Arr));
        for (C1004w0 c1004w0 : e02.b) {
            c1004w0.e();
        }
        for (I0 i02 : e02.d) {
            for (G0 g02 : i02.d) {
                C1012y0 c1012y0 = g02.c.g;
                DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = g02.f2833a;
                F0 f0F = c1012y0.f(g02, descriptorProtos$MethodDescriptorProto.E());
                if (!(f0F instanceof C1004w0)) {
                    throw new Descriptors$DescriptorValidationException(g02, "\"" + descriptorProtos$MethodDescriptorProto.E() + "\" is not a message type.");
                }
                F0 f0F2 = c1012y0.f(g02, descriptorProtos$MethodDescriptorProto.H());
                if (!(f0F2 instanceof C1004w0)) {
                    throw new Descriptors$DescriptorValidationException(g02, "\"" + descriptorProtos$MethodDescriptorProto.H() + "\" is not a message type.");
                }
            }
        }
        for (D0 d02 : e02.e) {
            D0.e(d02);
        }
        return e02;
    }

    public static E0 h(String[] strArr, E0[] e0Arr) throws InvalidProtocolBufferException {
        byte[] bytes;
        if (strArr.length == 1) {
            bytes = strArr[0].getBytes(AbstractC0989s1.b);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
            }
            bytes = sb.toString().getBytes(AbstractC0989s1.b);
        }
        try {
            V v10 = DescriptorProtos$FileDescriptorProto.f2800s;
            v10.getClass();
            X1 x1B = v10.b(bytes, bytes.length, AbstractC0936f.f2919a);
            if (x1B != null && !x1B.isInitialized()) {
                throw (x1B instanceof AbstractC0932e ? ((AbstractC0932e) x1B).k() : new UninitializedMessageException()).a();
            }
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto) x1B;
            try {
                return e(descriptorProtos$FileDescriptorProto, e0Arr);
            } catch (Descriptors$DescriptorValidationException e) {
                throw new IllegalArgumentException("Invalid embedded descriptor for \"" + descriptorProtos$FileDescriptorProto.E() + "\".", e);
            }
        } catch (InvalidProtocolBufferException e6) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e6);
        }
    }

    @Override // com.google.protobuf.F0
    public final E0 a() {
        return this;
    }

    @Override // com.google.protobuf.F0
    public final String b() {
        return this.f2826a.E();
    }

    @Override // com.google.protobuf.F0
    public final String c() {
        return this.f2826a.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2826a;
    }

    public final List f() {
        return Collections.unmodifiableList(Arrays.asList(this.b));
    }

    public final Descriptors$FileDescriptor$Syntax g() {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = this.f2826a;
        return "proto3".equals(descriptorProtos$FileDescriptorProto.I()) ? Descriptors$FileDescriptor$Syntax.b : "editions".equals(descriptorProtos$FileDescriptorProto.I()) ? Descriptors$FileDescriptor$Syntax.c : Descriptors$FileDescriptor$Syntax.f2825a;
    }

    public E0(String str, C1004w0 c1004w0) {
        C1012y0 c1012y0 = new C1012y0(new E0[0]);
        this.g = c1012y0;
        W wO = DescriptorProtos$FileDescriptorProto.f2799r.toBuilder();
        String str2 = c1004w0.b + ".placeholder.proto";
        str2.getClass();
        wO.f = str2;
        wO.e |= 1;
        wO.L();
        str.getClass();
        wO.g = str;
        wO.e |= 2;
        wO.L();
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = c1004w0.f2982a;
        descriptorProtos$DescriptorProto.getClass();
        wO.O();
        wO.k.add(descriptorProtos$DescriptorProto);
        wO.L();
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProtoN = wO.m();
        if (descriptorProtos$FileDescriptorProtoN.isInitialized()) {
            this.f2826a = descriptorProtos$FileDescriptorProtoN;
            this.f = new E0[0];
            this.b = new C1004w0[]{c1004w0};
            this.c = J0.e;
            this.d = J0.f;
            this.e = J0.d;
            c1012y0.a(this, str);
            c1012y0.b(c1004w0);
            return;
        }
        throw AbstractC0916a.x(descriptorProtos$FileDescriptorProtoN);
    }
}
