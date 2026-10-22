package com.google.protobuf;

/* loaded from: classes3.dex */
public final class H0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2839a;
    public final DescriptorProtos$OneofDescriptorProto b;
    public final String c;
    public final E0 d;
    public final C1004w0 e;
    public int f = 0;
    public D0[] g;

    public H0(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, E0 e02, C1004w0 c1004w0, int i) {
        this.b = descriptorProtos$OneofDescriptorProto;
        this.c = J0.a(e02, c1004w0, descriptorProtos$OneofDescriptorProto.E());
        this.d = e02;
        this.f2839a = i;
        this.e = c1004w0;
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
        return this.b.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.b;
    }
}
