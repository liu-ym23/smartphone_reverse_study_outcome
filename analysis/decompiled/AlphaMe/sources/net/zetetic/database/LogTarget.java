package net.zetetic.database;

/* loaded from: classes2.dex */
public interface LogTarget {
    boolean isLoggable(String str, int i4);

    void log(int i4, String str, String str2, Throwable th);
}
