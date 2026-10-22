package com.bytedance.keva;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    public void loadLibrary(String r10) {
        System.loadLibrary(r10);
    }

    public void logDebug(String r10) {
        Log.d(KevaConstants.TAG, r10);
    }

    public void onLoadRepo(String r10, int r11) {
        Log.d(KevaConstants.TAG, "load repo: " + r10 + ", with mode: " + r11);
    }

    public void reportThrowable(int r10, String r11, String r12, Object r13, Throwable r14) {
        Log.e(KevaConstants.TAG, "action: [" + r10 + "], repo: [" + r11 + "], key: [" + r12 + "], value: [" + r13 + "], has error: " + r14.getMessage(), r14);
    }

    public void reportWarning(int r10, String r11, String r12, Object r13, String r14) {
        Log.w(KevaConstants.TAG, "action: [" + r10 + "], repo: [" + r11 + "], key: [" + r12 + "], value: [" + r13 + "], has waring: " + r14);
    }
}
