package com.apm.lite;

/* JADX INFO: loaded from: classes39.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r100, Thread r101);

    boolean onNativeCrashFilter(String r100, String r101);
}
