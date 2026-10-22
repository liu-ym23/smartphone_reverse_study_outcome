package net.zetetic.database.sqlcipher;

import android.util.Log;

/* loaded from: classes4.dex */
public final class SQLiteDebug {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f5401a;
    public static final boolean b;

    public static class DbStats {
        public DbStats(String str, long j5, long j6, int i, int i6, int i10, int i11) {
        }
    }

    public static class PagerStats {
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    static {
        Log.isLoggable("SQLiteLog", 2);
        f5401a = Log.isLoggable("SQLiteStatements", 2);
        b = Log.isLoggable("SQLiteTime", 2);
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);
}
