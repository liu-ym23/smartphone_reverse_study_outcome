package com.obric.assistant.dm.api.statemachine.core;

import com.obric.assistant.dm.api.statemachine.core.State;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface e<S extends State> {
    void a(S r1, DMEvent r2, Exception r3);

    void a(S r1, S r2, DMEvent r3);
}
