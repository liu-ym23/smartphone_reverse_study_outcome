package net.zetetic.database;

/* loaded from: classes2.dex */
public class NoopTarget implements LogTarget {
    @Override // net.zetetic.database.LogTarget
    public boolean isLoggable(String str, int i4) {
        return false;
    }

    @Override // net.zetetic.database.LogTarget
    public void log(int i4, String str, String str2, Throwable th) {
    }
}
