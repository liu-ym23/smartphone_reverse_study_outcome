package com.google.protobuf;

/* loaded from: classes3.dex */
public final class C0 extends F0 implements InterfaceC0974o1 {
    public static final B0 d = new B0();

    /* renamed from: a, reason: collision with root package name */
    public final DescriptorProtos$EnumValueDescriptorProto f2759a;
    public final String b;
    public final A0 c;

    public C0(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, E0 e02, A0 a02) {
        this.f2759a = descriptorProtos$EnumValueDescriptorProto;
        this.c = a02;
        this.b = a02.b + '.' + descriptorProtos$EnumValueDescriptorProto.E();
        e02.g.b(this);
    }

    @Override // com.google.protobuf.F0
    public final E0 a() {
        return this.c.c;
    }

    @Override // com.google.protobuf.F0
    public final String b() {
        return this.b;
    }

    @Override // com.google.protobuf.F0
    public final String c() {
        return this.f2759a.E();
    }

    @Override // com.google.protobuf.F0
    public final AbstractC0924c d() {
        return this.f2759a;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        return this.f2759a.e;
    }

    public final String toString() {
        return this.f2759a.E();
    }

    public C0(A0 a02, Integer num) {
        String str = "UNKNOWN_ENUM_VALUE_" + a02.f2755a.E() + "_" + num;
        F builder = DescriptorProtos$EnumValueDescriptorProto.h.toBuilder();
        str.getClass();
        builder.f = str;
        builder.e |= 1;
        builder.L();
        builder.g = num.intValue();
        builder.e |= 2;
        builder.L();
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProtoBuildPartial = builder.buildPartial();
        if (descriptorProtos$EnumValueDescriptorProtoBuildPartial.isInitialized()) {
            this.f2759a = descriptorProtos$EnumValueDescriptorProtoBuildPartial;
            this.c = a02;
            this.b = a02.b + '.' + descriptorProtos$EnumValueDescriptorProtoBuildPartial.E();
            return;
        }
        throw AbstractC0916a.x(descriptorProtos$EnumValueDescriptorProtoBuildPartial);
    }
}
