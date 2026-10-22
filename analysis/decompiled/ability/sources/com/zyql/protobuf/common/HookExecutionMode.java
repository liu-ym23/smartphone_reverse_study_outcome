package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum HookExecutionMode implements InterfaceC0974o1 {
    HOOK_EXECUTION_MODE_UNSPECIFIED(0),
    HOOK_EXECUTION_MODE_SYNC(1),
    HOOK_EXECUTION_MODE_ASYNC(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4257a;

    HookExecutionMode(int i) {
        this.f4257a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4257a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
