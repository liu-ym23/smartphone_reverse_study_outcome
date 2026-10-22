package com.android.contacts.util;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes2.dex */
public interface AsyncTaskExecutor {
    <T> AsyncTask<T, ?, ?> submit(Object r1, AsyncTask<T, ?, ?> r2, T... r3);
}
