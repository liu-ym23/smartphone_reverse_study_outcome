package com.google.protobuf;

/* loaded from: classes.dex */
public enum w implements k2 {
    EDITION_UNKNOWN(0),
    EDITION_LEGACY(900),
    EDITION_PROTO2(998),
    EDITION_PROTO3(999),
    EDITION_2023(1000),
    EDITION_2024(1001),
    EDITION_1_TEST_ONLY(1),
    EDITION_2_TEST_ONLY(2),
    EDITION_99997_TEST_ONLY(99997),
    EDITION_99998_TEST_ONLY(99998),
    EDITION_99999_TEST_ONLY(99999),
    EDITION_MAX(Integer.MAX_VALUE);


    /* renamed from: f, reason: collision with root package name */
    public final int f2609f;

    w(int i2) {
        this.f2609f = i2;
    }

    public static w a(int i2) {
        if (i2 == 0) {
            return EDITION_UNKNOWN;
        }
        if (i2 == 1) {
            return EDITION_1_TEST_ONLY;
        }
        if (i2 == 2) {
            return EDITION_2_TEST_ONLY;
        }
        if (i2 == 900) {
            return EDITION_LEGACY;
        }
        if (i2 == Integer.MAX_VALUE) {
            return EDITION_MAX;
        }
        switch (i2) {
            case 998:
                return EDITION_PROTO2;
            case 999:
                return EDITION_PROTO3;
            case 1000:
                return EDITION_2023;
            case 1001:
                return EDITION_2024;
            default:
                switch (i2) {
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

    @Override // com.google.protobuf.k2
    public final int getNumber() {
        return this.f2609f;
    }
}
