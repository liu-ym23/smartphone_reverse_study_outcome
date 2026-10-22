package com.android.contacts.common.util;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class WeakAsyncTask<Params, Progress, Result, WeakTarget> extends AsyncTask<Params, Progress, Result> {
    protected WeakReference<WeakTarget> mTarget;

    protected abstract Result doInBackground(WeakTarget r1, Params... r2);

    protected void onPostExecute(WeakTarget r1, Result r2) {
    }

    protected void onPreExecute(WeakTarget r1) {
    }

    public WeakAsyncTask(WeakTarget r2) {
        this.mTarget = new WeakReference(r2);
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        WeakTarget r0 = this.mTarget.get();
        if (r0 == null) goto L6;
        onPreExecute(r0);
        return;
    }

    @Override // android.os.AsyncTask
    protected final Result doInBackground(Params... r2) {
        WeakTarget r0 = this.mTarget.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return doInBackground(r0, r2);
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Result r2) {
        WeakTarget r0 = this.mTarget.get();
        if (r0 == null) goto L6;
        onPostExecute(r0, r2);
        return;
    }
}
