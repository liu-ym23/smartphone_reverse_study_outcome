package com.android.server.am;

import android.os.Trace;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class TraceErrorLogger {
    private static final String COUNTER_PREFIX = "ErrorId:";
    private static final int PLACEHOLDER_VALUE = 1;

    public TraceErrorLogger() {
    }

    public boolean isAddErrorIdEnabled() {
        return true;
    }

    public UUID generateErrorId() {
        return UUID.randomUUID();
    }

    public void addProcessInfoAndErrorIdToTrace(String processName, int pid, UUID errorId) {
        Trace.traceCounter(64, COUNTER_PREFIX + processName + " " + pid + "#" + errorId.toString(), 1);
    }

    public void addSubjectToTrace(String subject, UUID errorId) {
        Trace.traceCounter(64, String.format("Subject(for ErrorId %s):%s", new Object[]{errorId.toString(), subject}), 1);
    }
}
