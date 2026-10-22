package org.tensorflow.lite.task.core;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.io.Closeable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BaseTaskApi.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d implements Closeable {
    private static final String TAG = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f40638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f40639b;

    static {
    }

    public abstract void a(long r1);

    public d(long r3) {
        if (r3 == 0) goto L7;
        this.f40638a = r3;
        return;
    L7:
        throw new IllegalArgumentException("Failed to load C++ pointer from JNI");
    }

    public boolean a() {
        return this.f40639b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f40639b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        a(this.f40638a);     // Catch: Throwable -> L10
        this.f40639b = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public long b() {
        return this.f40638a;
    }

    public void c() {
        if (a() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Internal error: The task lib has already been closed.");
    }

    public void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.f40639b == true) goto L5;
        a(TAG, "Closing an already closed native lib");     // Catch: Throwable -> L7
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
