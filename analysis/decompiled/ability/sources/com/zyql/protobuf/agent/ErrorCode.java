package com.zyql.protobuf.agent;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum ErrorCode implements InterfaceC0974o1 {
    ERROR_UNSPECIFIED(0),
    ERROR_TIMEOUT(1),
    ERROR_NOT_FOUND(2),
    ERROR_INVALID_ARGUMENT(3),
    ERROR_PERMISSION_DENIED(4),
    ERROR_INTERNAL(5),
    ERROR_UNAVAILABLE(6),
    ERROR_CANCELLED(7),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4250a;

    ErrorCode(int i) {
        this.f4250a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4250a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
