package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface ISvpSenarioHandler {
    default void svpColdStarting(int pid, boolean svpLimit) {
    }

    default void svpWarmStarting(int pid, boolean svpLimit) {
    }

    default void svpEndStarting(int pid) {
    }
}
