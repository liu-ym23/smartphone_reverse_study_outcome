package com.bytedance.apm.trace.api.wrapper;

import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;

/* JADX INFO: loaded from: classes.dex */
public interface ITracingWrapper {
    void addTracingTag(String r10, String r11);

    void cancel();

    void createAndEndWindowSpan(String r10, long r11, long r12);

    ITracingWindowSpan createWindowSpan(String r10);

    void end();

    void end(long r10);

    void endSpan(String r10);

    void endWindowSpan(String r10, long r11, long r12);

    void start();

    ITracingSpan startSpan(String r10);

    void startWithCross();
}
