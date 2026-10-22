package com.stepos.common.app;

import A6.l;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes3.dex */
public class LibraryInitProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3571a = false;
    public Handler b;

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
        if (this.f3571a) {
            Log.i("[LibraryInitProvider]", "has init already.");
            return true;
        }
        if (this.b == null) {
            this.b = new Handler();
        }
        this.f3571a = true;
        this.b.postDelayed(new l(this, 16), 3000L);
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
