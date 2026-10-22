package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f18258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18260c;

    public interface Natives {
        void reportJavaException(boolean r10, Throwable r11);

        void reportJavaStackTrace(String r10);
    }

    static {
    }

    public JavaExceptionReporter(Thread.UncaughtExceptionHandler r10, boolean r11) {
        this.f18258a = r10;
        this.f18259b = r11;
    }

    @CalledByNative
    private static void installHandler(boolean r10) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r10));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r10, Throwable r11) {
        if (this.f18260c == true) goto L5;
        this.f18260c = true;
        g.b().reportJavaException(this.f18259b, r11);
    L5:
        Thread.UncaughtExceptionHandler r12 = this.f18258a;
        if (r12 == null) goto L9;
        r12.uncaughtException(r10, r11);
        return;
    }
}
