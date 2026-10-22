package com.zyql.protobuf.task.engine;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum TaskState implements InterfaceC0974o1 {
    Running(0),
    Stop(1),
    Pending(2),
    Complete(3),
    Failed(4),
    Canceled(5),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4282a;

    TaskState(int i6) {
        this.f4282a = i6;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4282a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
