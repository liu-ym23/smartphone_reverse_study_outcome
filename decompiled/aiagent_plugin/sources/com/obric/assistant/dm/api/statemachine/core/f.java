package com.obric.assistant.dm.api.statemachine.core;

import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f<S extends State, E extends DMEvent> {

    /* JADX INFO: compiled from: Transition.kt */
    public static final class a {
        public static <S extends State, E extends DMEvent> void a(f<S, E> r2, S r3, E r4) {
            f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
            o.e(r3, "currentState");
            o.e(r4, "event");
        }

        public static <S extends State, E extends DMEvent> void a(f<S, E> r2, S r3, S r4, E r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.aiagent.plugin");
            o.e(r3, "previousState");
            o.e(r4, "newState");
            o.e(r5, "event");
        }
    }

    Class<? extends S> a();

    void a(S r1, S r2, E r3);

    boolean a(S r1, E r2);

    S b(S r1, E r2);

    Class<? extends S> b();

    Class<? extends E> c();

    void c(S r1, E r2);
}
