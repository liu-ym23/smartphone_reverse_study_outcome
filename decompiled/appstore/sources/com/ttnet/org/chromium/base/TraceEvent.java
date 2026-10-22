package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class TraceEvent implements AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f18311b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18312a;

    public interface Natives {
        void begin(String r10, String r11);

        void beginToplevel(String r10);

        void end(String r10, String r11);

        void endToplevel(String r10);

        void finishAsync(String r10, long r11);

        void instant(String r10, String r11);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String r10);

        void startATrace(String r10);

        void startAsync(String r10, long r11);

        void stopATrace();
    }

    public static void a(String r10) {
        b(r10, null);
    }

    public static void b(String r10, String r11) {
        EarlyTraceEvent.e(r10, false);
        if (f18311b == false) goto L6;
        r.b().end(r10, r11);
        return;
    }

    public static void c() {
    }

    @CalledByNative
    public static void setEnabled(boolean r10) {
        if (r10 == false) goto L5;
        EarlyTraceEvent.a();
    L5:
        if (f18311b == r10) goto L8;
        f18311b = r10;
        return;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        a(this.f18312a);
    }
}
