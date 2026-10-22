package com.android.contacts.util;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyLoader extends Loader<Object> {

    public static class Callback implements LoaderManager.LoaderCallbacks<Object> {
        private final Context mContext;

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoadFinished(Loader<Object> r1, Object r2) {
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Object> r1) {
        }

        public Callback(Context r1) {
            this.mContext = r1.getApplicationContext();
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Object> onCreateLoader(int r1, Bundle r2) {
            return new EmptyLoader(this.mContext);
        }
    }

    public EmptyLoader(Context r1) {
        super(r1);
    }
}
