package com.zyql.protobuf.task.engine;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum InvokeState implements InterfaceC0974o1 {
    OK(0),
    fail(1),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4281a;

    InvokeState(int i) {
        this.f4281a = i;
    }

    public static InvokeState a(int i) {
        if (i == 0) {
            return OK;
        }
        if (i != 1) {
            return null;
        }
        return fail;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4281a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
