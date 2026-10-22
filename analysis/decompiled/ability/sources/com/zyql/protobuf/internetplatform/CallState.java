package com.zyql.protobuf.internetplatform;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum CallState implements InterfaceC0974o1 {
    OK(0),
    FAIL(1),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4270a;

    CallState(int i) {
        this.f4270a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4270a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
