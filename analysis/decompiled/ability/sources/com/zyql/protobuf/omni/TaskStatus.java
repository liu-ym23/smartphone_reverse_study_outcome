package com.zyql.protobuf.omni;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum TaskStatus implements InterfaceC0974o1 {
    UNKNOWN(0),
    PROGRESS(1),
    COMPLETED(2),
    FAILED(3),
    CANCELLED(4),
    PAUSED(5),
    ASK_FOR_INPUT(6),
    AUTHENTICATION(7),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4272a;

    TaskStatus(int i) {
        this.f4272a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4272a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
