package com.stepos.base.crash;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NativeCrashHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f6220a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f6221b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Boolean f6222c;

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String> f6223d;

    static {
        boolean z;
        new NativeCrashHandler();
        try {
            System.loadLibrary("aiengine_crash");
            z = true;
        } catch (SecurityException | UnsatisfiedLinkError unused) {
            z = false;
        }
        f6220a = z;
        f6221b = new AtomicBoolean(false);
        new AtomicReference(null);
        f6223d = new AtomicReference<>(null);
    }

    public static final void a(File file) {
        String absolutePath = file.getAbsolutePath();
        f6223d.set(absolutePath);
        if (f6220a) {
            try {
                nativeBindMarkerDir(absolutePath);
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }

    public static final synchronized void b() {
        if (f6222c != null) {
            return;
        }
        boolean zNativeInstall = false;
        if (f6220a) {
            try {
                zNativeInstall = nativeInstall();
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        if (zNativeInstall) {
            f6221b.set(true);
        }
        f6222c = Boolean.valueOf(zNativeInstall);
    }

    private static final native void nativeBindCurrentInference(String str);

    private static final native void nativeBindMarkerDir(String str);

    private static final native boolean nativeInstall();
}
