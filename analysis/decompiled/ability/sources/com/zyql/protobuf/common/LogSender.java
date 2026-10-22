package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum LogSender implements InterfaceC0974o1 {
    LOG_SENDER_UNSPECIFIED(0),
    LOG_SENDER_APP(1),
    LOG_SENDER_RUNTIME(2),
    LOG_SENDER_AGENT(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4265a;

    LogSender(int i) {
        this.f4265a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4265a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
