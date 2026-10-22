package com.google.protobuf;

/* loaded from: classes3.dex */
public final class I0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$ServiceDescriptorProto f2840a;
    public final String b;
    public final E0 c;
    public final G0[] d;

    public I0(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, E0 e02) {
        this.f2840a = descriptorProtos$ServiceDescriptorProto;
        this.b = J0.a(e02, null, descriptorProtos$ServiceDescriptorProto.E());
        this.c = e02;
        this.d = new G0[descriptorProtos$ServiceDescriptorProto.e.size()];
        for (int i = 0; i < descriptorProtos$ServiceDescriptorProto.e.size(); i++) {
            this.d[i] = new G0((DescriptorProtos$MethodDescriptorProto) descriptorProtos$ServiceDescriptorProto.e.get(i), e02, this);
        }
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
        return this.f2840a.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2840a;
    }
}
