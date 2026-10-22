package com.bytedance.apm.trace.api.wrapper;

import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;

/* JADX INFO: loaded from: classes2.dex */
public interface ITracingWrapper {
    void addTracingTag(String r1, String r2);

    void cancel();

    void createAndEndWindowSpan(String r1, long r2, long r4);

    ITracingWindowSpan createWindowSpan(String r1);

    void end();

    void end(long r1);

    void endSpan(String r1);

    void endWindowSpan(String r1, long r2, long r4);

    void start();

    ITracingSpan startSpan(String r1);

    void startWithCross();
}
