package com.google.protobuf;

/* loaded from: classes3.dex */
public enum DescriptorProtos$Edition implements InterfaceC0974o1 {
    EDITION_UNKNOWN(0),
    EDITION_PROTO2(998),
    EDITION_PROTO3(999),
    EDITION_2023(1000),
    EDITION_1_TEST_ONLY(1),
    EDITION_2_TEST_ONLY(2),
    EDITION_99997_TEST_ONLY(99997),
    EDITION_99998_TEST_ONLY(99998),
    EDITION_99999_TEST_ONLY(99999);


    /* renamed from: a, reason: collision with root package name */
    public final int f2767a;

    static {
        values();
    }

    DescriptorProtos$Edition(int i) {
        this.f2767a = i;
    }

    public static DescriptorProtos$Edition a(int i) {
        if (i == 0) {
            return EDITION_UNKNOWN;
        }
        if (i == 1) {
            return EDITION_1_TEST_ONLY;
        }
        if (i == 2) {
            return EDITION_2_TEST_ONLY;
        }
        switch (i) {
            case 998:
                return EDITION_PROTO2;
            case 999:
                return EDITION_PROTO3;
            case 1000:
                return EDITION_2023;
            default:
                switch (i) {
                    case 99997:
                        return EDITION_99997_TEST_ONLY;
                    case 99998:
                        return EDITION_99998_TEST_ONLY;
                    case 99999:
                        return EDITION_99999_TEST_ONLY;
                    default:
                        return null;
                }
        }
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        return this.f2767a;
    }
}
