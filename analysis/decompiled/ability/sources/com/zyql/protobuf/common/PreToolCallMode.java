package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum PreToolCallMode implements InterfaceC0974o1 {
    PRE_TOOL_CALL_MODE_UNSPECIFIED(0),
    PRE_TOOL_CALL_MODE_ALLOW(1),
    PRE_TOOL_CALL_MODE_DENY(2),
    PRE_TOOL_CALL_MODE_ASK(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4268a;

    PreToolCallMode(int i) {
        this.f4268a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4268a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
