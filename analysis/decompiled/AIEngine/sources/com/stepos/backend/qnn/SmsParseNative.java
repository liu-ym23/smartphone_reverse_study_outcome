package com.stepos.backend.qnn;

import android.content.Context;
import android.util.Log;
import java.io.File;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SmsParseNative {
    private static final String TAG = "SmsParseNative";
    private static volatile boolean runtimeReady;
    public static final SmsParseNative INSTANCE = new SmsParseNative();
    private static final Object lock = new Object();

    private SmsParseNative() {
    }

    private static final void ensureRuntime$lambda$0$tryLoad(String str, boolean z) {
        try {
            System.loadLibrary(str);
            Log.d(TAG, "✅ Loaded: " + str);
        } catch (UnsatisfiedLinkError e10) {
            String strL = ai.onnxruntime.a.l("loadLibrary(", str, ") failed: ", e10.getMessage());
            if (!z) {
                ai.onnxruntime.a.x("⚠️ ", strL, " (optional, skipped)", TAG);
                return;
            }
            Log.e(TAG, "❌ " + strL);
            throw e10;
        }
    }

    public static /* synthetic */ void ensureRuntime$lambda$0$tryLoad$default(String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = true;
        }
        ensureRuntime$lambda$0$tryLoad(str, z);
    }

    public final void ensureRuntime(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (runtimeReady) {
            return;
        }
        synchronized (lock) {
            if (runtimeReady) {
                return;
            }
            ensureRuntime$lambda$0$tryLoad("cdsprpc", false);
            ensureRuntime$lambda$0$tryLoad$default("QnnSystem", false, 2, null);
            ensureRuntime$lambda$0$tryLoad$default("QnnHtpPrepare", false, 2, null);
            ensureRuntime$lambda$0$tryLoad$default("QnnHtpV81Stub", false, 2, null);
            ensureRuntime$lambda$0$tryLoad$default("QnnHtp", false, 2, null);
            File file = new File(context.getApplicationInfo().nativeLibraryDir, "libGenie.so");
            if (file.exists()) {
                try {
                    System.load(file.getAbsolutePath());
                    Log.d(TAG, "✅ Loaded: libGenie.so from APK");
                } catch (UnsatisfiedLinkError e10) {
                    Log.w(TAG, "⚠️ Failed to load libGenie.so: " + e10.getMessage());
                }
            } else {
                ensureRuntime$lambda$0$tryLoad("Genie", false);
            }
            runtimeReady = true;
            Log.i(TAG, "SMS-parse runtime ready (QNN V81, vendor)");
        }
    }
}
