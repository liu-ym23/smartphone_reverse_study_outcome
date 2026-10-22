package com.stepos.alphame.common.utils;

import android.util.Log;
import com.stepos.alphame.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u001a \u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u001a\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u001a$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u001a\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"DEBUG", "", "ERROR", "INFO", "VERBOSE", "WARN", "debugFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDebugFlag", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setDebugFlag", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "logD", "", "tag", "", "msg", "logE", "tr", "", "logI", "logV", "logW", BuildConfig.BUILD_TYPE, "", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LogKt {
    private static final int DEBUG = 2;
    private static final int ERROR = 5;
    private static final int INFO = 3;
    private static final int VERBOSE = 1;
    private static final int WARN = 4;

    @NotNull
    private static AtomicBoolean debugFlag = new AtomicBoolean(true);

    @NotNull
    public static final AtomicBoolean getDebugFlag() {
        return debugFlag;
    }

    public static final void logD(@NotNull String tag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (debugFlag.get()) {
            Log.d(tag, String.valueOf(str));
        }
    }

    public static final void logE(@NotNull String tag, @Nullable String str, @NotNull Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(tr, "tr");
        if (debugFlag.get()) {
            Log.e(tag, String.valueOf(str), tr);
        }
    }

    public static final void logI(@NotNull String tag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (debugFlag.get()) {
            Log.i(tag, String.valueOf(str));
        }
    }

    public static final void logV(@NotNull String tag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (debugFlag.get()) {
            Log.v(tag, String.valueOf(str));
        }
    }

    public static final void logW(@NotNull String tag, @Nullable String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (debugFlag.get()) {
            if (th == null) {
                Log.w(tag, String.valueOf(str));
            } else {
                Log.w(tag, String.valueOf(str), th);
            }
        }
    }

    public static /* synthetic */ void logW$default(String str, String str2, Throwable th, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            th = null;
        }
        logW(str, str2, th);
    }

    public static final void setDebugFlag(@NotNull AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        debugFlag = atomicBoolean;
    }

    public static final void setDebugFlag(boolean z4) {
        debugFlag.set(z4);
    }
}
