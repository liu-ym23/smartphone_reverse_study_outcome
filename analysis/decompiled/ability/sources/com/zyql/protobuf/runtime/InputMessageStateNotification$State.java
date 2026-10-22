package com.zyql.protobuf.runtime;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum InputMessageStateNotification$State implements InterfaceC0974o1 {
    STATE_UNSPECIFIED(0),
    STATE_QUEUED(1),
    STATE_SUBMITTED(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4276a;

    InputMessageStateNotification$State(int i) {
        this.f4276a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4276a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
