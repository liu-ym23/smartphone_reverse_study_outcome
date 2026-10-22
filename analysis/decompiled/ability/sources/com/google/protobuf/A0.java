package com.google.protobuf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class A0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$EnumDescriptorProto f2755a;
    public final String b;
    public final E0 c;
    public final C0[] d;
    public final C0[] e;
    public final int f;
    public HashMap g = null;
    public ReferenceQueue h = null;

    public A0(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, E0 e02, C1004w0 c1004w0) throws Descriptors$DescriptorValidationException {
        this.f2755a = descriptorProtos$EnumDescriptorProto;
        this.b = J0.a(e02, c1004w0, descriptorProtos$EnumDescriptorProto.E());
        this.c = e02;
        if (descriptorProtos$EnumDescriptorProto.e.size() == 0) {
            throw new Descriptors$DescriptorValidationException(this, "Enums must contain at least one value.");
        }
        this.d = new C0[descriptorProtos$EnumDescriptorProto.e.size()];
        int i = 0;
        for (int i6 = 0; i6 < descriptorProtos$EnumDescriptorProto.e.size(); i6++) {
            this.d[i6] = new C0((DescriptorProtos$EnumValueDescriptorProto) descriptorProtos$EnumDescriptorProto.e.get(i6), e02, this);
        }
        C0[] c0Arr = (C0[]) this.d.clone();
        this.e = c0Arr;
        Arrays.sort(c0Arr, C0.d);
        for (int i10 = 1; i10 < descriptorProtos$EnumDescriptorProto.e.size(); i10++) {
            C0[] c0Arr2 = this.e;
            C0 c02 = c0Arr2[i];
            C0 c03 = c0Arr2[i10];
            if (c02.f2759a.e != c03.f2759a.e) {
                i++;
                c0Arr2[i] = c03;
            }
        }
        int i11 = i + 1;
        this.f = i11;
        Arrays.fill(this.e, i11, descriptorProtos$EnumDescriptorProto.e.size(), (Object) null);
        e02.g.b(this);
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
        return this.f2755a.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2755a;
    }

    public final C0 e(int i) {
        int i6 = this.f - 1;
        int i10 = 0;
        while (i10 <= i6) {
            int i11 = (i10 + i6) / 2;
            C0 c02 = this.e[i11];
            int i12 = c02.f2759a.e;
            if (i < i12) {
                i6 = i11 - 1;
            } else {
                if (i <= i12) {
                    return c02;
                }
                i10 = i11 + 1;
            }
        }
        return null;
    }

    public final C0 f(int i) {
        C0 c02;
        C0 c0E = e(i);
        if (c0E != null) {
            return c0E;
        }
        synchronized (this) {
            try {
                if (this.h == null) {
                    this.h = new ReferenceQueue();
                    this.g = new HashMap();
                } else {
                    while (true) {
                        C1016z0 c1016z0 = (C1016z0) this.h.poll();
                        if (c1016z0 == null) {
                            break;
                        }
                        this.g.remove(Integer.valueOf(c1016z0.f2988a));
                    }
                }
                WeakReference weakReference = (WeakReference) this.g.get(Integer.valueOf(i));
                c02 = weakReference == null ? null : (C0) weakReference.get();
                if (c02 == null) {
                    c02 = new C0(this, Integer.valueOf(i));
                    this.g.put(Integer.valueOf(i), new C1016z0(i, c02));
                }
            } finally {
            }
        }
        return c02;
    }
}
