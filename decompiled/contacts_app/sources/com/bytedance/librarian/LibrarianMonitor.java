package com.bytedance.librarian;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class LibrarianMonitor {
    public LibrarianMonitor() {
    }

    protected void logDebug(String r1) {
        Log.d(LibrarianImpl.Constants.TAG, r1);
    }

    protected void logWarning(String r1) {
        Log.w(LibrarianImpl.Constants.TAG, r1);
    }

    protected void logWarning(String r1, Throwable r2) {
        Log.w(LibrarianImpl.Constants.TAG, r1, r2);
    }

    protected void logError(String r1) {
        Log.e(LibrarianImpl.Constants.TAG, r1);
    }

    protected void logError(String r1, Throwable r2) {
        Log.e(LibrarianImpl.Constants.TAG, r1, r2);
    }

    protected void systemLoadLibrary(String r1) {
        System.loadLibrary(r1);
    }

    protected void systemLoad(String r1) {
        System.load(r1);
    }
}
