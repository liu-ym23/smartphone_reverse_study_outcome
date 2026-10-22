package com.stepos.common.app;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes.dex */
public class LibraryInitProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13596a = false;

    /* renamed from: b, reason: collision with root package name */
    private Handler f13597b;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws ClassNotFoundException {
            try {
                Class.forName("com.meizu.nightmode.MzHighContrastManager");
                Log.i("[LibraryInitProvider]", "start init");
                J1.a.c((Application) LibraryInitProvider.this.getContext().getApplicationContext());
            } catch (Exception unused) {
                Log.i("[LibraryInitProvider]", "not Support high contrast");
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
            Log.i("[LibraryInitProvider]", "init fail context is null");
            return true;
        }
        if (this.f13596a) {
            Log.i("[LibraryInitProvider]", "has init already.");
            return true;
        }
        if (this.f13597b == null) {
            this.f13597b = new Handler();
        }
        this.f13596a = true;
        this.f13597b.postDelayed(new a(), 3000L);
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
