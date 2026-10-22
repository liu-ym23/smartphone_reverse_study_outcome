package com.bytedance.librarian;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public b() {
    }

    public void a(String r10) {
        Log.d(LibrarianImpl.Constants.TAG, r10);
    }

    public void b(String r10) {
        Log.w(LibrarianImpl.Constants.TAG, r10);
    }

    public void c(String r10, Throwable r11) {
        Log.w(LibrarianImpl.Constants.TAG, r10, r11);
    }

    public void d(String r10) {
        System.load(r10);
    }

    public void e(String r10) {
        System.loadLibrary(r10);
    }
}
