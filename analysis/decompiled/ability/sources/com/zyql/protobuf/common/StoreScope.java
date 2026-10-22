package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum StoreScope implements InterfaceC0974o1 {
    STORE_SCOPE_UNSPECIFIED(0),
    STORE_SCOPE_NORMAL(1),
    STORE_SCOPE_USER(2),
    STORE_SCOPE_APP(3),
    STORE_SCOPE_SESSION(4),
    STORE_SCOPE_TEMP(5),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4269a;

    StoreScope(int i6) {
        this.f4269a = i6;
    }

    public static StoreScope a(int i6) {
        if (i6 == 0) {
            return STORE_SCOPE_UNSPECIFIED;
        }
        if (i6 == 1) {
            return STORE_SCOPE_NORMAL;
        }
        if (i6 == 2) {
            return STORE_SCOPE_USER;
        }
        if (i6 == 3) {
            return STORE_SCOPE_APP;
        }
        if (i6 == 4) {
            return STORE_SCOPE_SESSION;
        }
        if (i6 != 5) {
            return null;
        }
        return STORE_SCOPE_TEMP;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4269a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
