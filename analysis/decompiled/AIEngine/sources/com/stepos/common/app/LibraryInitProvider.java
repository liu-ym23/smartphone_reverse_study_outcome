package com.stepos.common.app;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import h8.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class LibraryInitProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6482a = false;

    /* renamed from: b, reason: collision with root package name */
    public Handler f6483b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() throws ClassNotFoundException {
            try {
                Class.forName("com.stepos.nightmode.StepOSHighContrastManager");
                Log.i("[LibraryInitProvider]", "start init");
                Application application = (Application) LibraryInitProvider.this.getContext().getApplicationContext();
                if (application == null || b.f9373b != null) {
                    StringBuilder sb2 = new StringBuilder("init return application is null :");
                    sb2.append(application == null);
                    Log.i("HighContrast_Common", sb2.toString());
                } else {
                    b bVar = new b();
                    new Handler(Looper.getMainLooper());
                    bVar.f9374a = application;
                    b.f9373b = bVar;
                    Log.i("HighContrast_Common", "sInstance init success");
                    new Thread(new h8.a()).start();
                }
            } catch (Exception unused) {
                Log.i("[LibraryInitProvider]", "not Support high contrast");
            }
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (getContext() == null) {
            Log.i("[LibraryInitProvider]", "init fail context is null");
            return true;
        }
        if (this.f6482a) {
            Log.i("[LibraryInitProvider]", "has init already.");
            return true;
        }
        if (this.f6483b == null) {
            this.f6483b = new Handler();
        }
        this.f6482a = true;
        this.f6483b.postDelayed(new a(), 3000L);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
