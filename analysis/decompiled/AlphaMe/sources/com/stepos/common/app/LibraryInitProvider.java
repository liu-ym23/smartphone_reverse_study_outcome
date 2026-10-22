package com.stepos.common.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import h.RunnableC0583a;

/* loaded from: classes.dex */
public class LibraryInitProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11310a = false;

    /* renamed from: b, reason: collision with root package name */
    public Handler f11311b;

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
        if (this.f11310a) {
            Log.i("[LibraryInitProvider]", "has init already.");
            return true;
        }
        if (this.f11311b == null) {
            this.f11311b = new Handler();
        }
        this.f11310a = true;
        this.f11311b.postDelayed(new RunnableC0583a(15, this), VehicleBluetoothManager.MIN_CONNECT_DISTANCE);
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
