package com.google.protobuf;

/* loaded from: classes3.dex */
public final class G0 extends F0 {

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$MethodDescriptorProto f2833a;
    public final String b;
    public final E0 c;

    public G0(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, E0 e02, I0 i02) {
        this.f2833a = descriptorProtos$MethodDescriptorProto;
        this.c = e02;
        this.b = i02.b + '.' + descriptorProtos$MethodDescriptorProto.F();
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
        return this.f2833a.F();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2833a;
    }
}
