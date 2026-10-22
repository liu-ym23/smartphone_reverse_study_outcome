package com.apm.insight.log;

import java.util.List;

/* loaded from: classes2.dex */
public interface ILog {
    void asyncFlush();

    void d(String str, String str2);

    void e(String str, String str2);

    List<String> getFiles(long j5, long j6);

    List<String> getFilesOfAllProcesses(long j5, long j6);

    long getNativeRef();

    void i(String str, String str2);

    void syncFlush();

    void timedSyncFlush(int i);

    void v(String str, String str2);

    void w(String str, String str2);
}
