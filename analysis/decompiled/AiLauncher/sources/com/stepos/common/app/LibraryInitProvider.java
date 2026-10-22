package com.stepos.common.app;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes3.dex */
public class LibraryInitProvider extends ContentProvider {
    private static final int INIT_DELAY = 3000;
    private static final String TAG = "[LibraryInitProvider]";
    private Handler mHandler;
    private boolean mHasInit = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws ClassNotFoundException {
            try {
                Class.forName("com.meizu.nightmode.MzHighContrastManager");
                Log.i(LibraryInitProvider.TAG, "start init");
                com.stepos.common.app.a.c((Application) LibraryInitProvider.this.getContext().getApplicationContext());
            } catch (Exception unused) {
                Log.i(LibraryInitProvider.TAG, "not Support high contrast");
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() == null) {
            Log.i(TAG, "init fail context is null");
            return true;
        }
        if (this.mHasInit) {
            Log.i(TAG, "has init already.");
            return true;
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        this.mHasInit = true;
        this.mHandler.postDelayed(new a(), 3000L);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
