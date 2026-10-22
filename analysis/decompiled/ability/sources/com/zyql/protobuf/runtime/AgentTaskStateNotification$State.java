package com.zyql.protobuf.runtime;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum AgentTaskStateNotification$State implements InterfaceC0974o1 {
    STATE_UNSPECIFIED(0),
    STATE_INITIALIZED(1),
    STATE_PROCESSING(2),
    STATE_COMPLETED(3),
    STATE_INTERRUPTED(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4273a;

    AgentTaskStateNotification$State(int i) {
        this.f4273a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4273a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
