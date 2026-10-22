package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: classes.dex */
public interface AgentLog {
    public static final int AUDIT = 6;
    public static final int DEBUG = 5;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int VERBOSE = 4;
    public static final int WARNING = 2;

    void audit(String r10);

    void debug(String r10);

    void error(String r10);

    void error(String r10, Throwable r11);

    int getLevel();

    void info(String r10);

    void setLevel(int r10);

    void verbose(String r10);

    void warning(String r10);
}
