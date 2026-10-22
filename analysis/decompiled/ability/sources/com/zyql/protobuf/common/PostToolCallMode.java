package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum PostToolCallMode implements InterfaceC0974o1 {
    POST_TOOL_CALL_MODE_UNSPECIFIED(0),
    POST_TOOL_CALL_MODE_IGNORE(1),
    POST_TOOL_CALL_MODE_BLOCK(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4267a;

    PostToolCallMode(int i) {
        this.f4267a = i;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4267a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
