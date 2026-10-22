package com.bytedance.apm.trace.api;

import f2.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ITracingSpanAbility {
    ITracingSpan addLog(String r10);

    ITracingSpan addLog(String r10, Map<String, String> r11);

    ITracingSpan addTag(String r10, String r11);

    long getFinishTime();

    List<Object> getLogs();

    long getParentId();

    long getReferenceId();

    long getSpanId();

    String getSpanName();

    long getStartTime();

    Map<String, String> getTags();

    String getThreadName();

    a getTracingContext();

    void setErrorTag(String r10);

    ITracingSpan setParentId(long r10);

    ITracingSpan setReferenceId(long r10);

    ITracingSpan setThreadName(String r10);
}
