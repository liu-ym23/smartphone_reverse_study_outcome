package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes14.dex */
public interface AgentLog {
    public static final int AUDIT = 6;
    public static final int DEBUG = 5;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int VERBOSE = 4;
    public static final int WARNING = 2;

    void audit(String r100);

    void debug(String r100);

    void error(String r100);

    void error(String r100, Throwable r101);

    int getLevel();

    void info(String r100);

    void setLevel(int r100);

    void verbose(String r100);

    void warning(String r100);
}
