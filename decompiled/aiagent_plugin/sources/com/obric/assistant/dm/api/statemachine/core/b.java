package com.obric.assistant.dm.api.statemachine.core;

/* JADX INFO: compiled from: IDMStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a(DMState r1);

    void a(TaskInfo r1);

    void a(TaskInfo r1, State r2, DMEvent r3, Exception r4);

    void a(TaskInfo r1, State r2, State r3, DMEvent r4);

    void b(TaskInfo r1);
}
