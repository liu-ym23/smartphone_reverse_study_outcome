package com.bytedance.als;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes43.dex */
public final class ThreadUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f38085a = null;

    public static class IncorrectThreadException extends RuntimeException {
        public IncorrectThreadException(String r100) {
            super(r100);
        }
    }

    static {
        f38085a = new Handler(Looper.getMainLooper());
    }
}
