package com.stepos.common.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.fragment.app.r;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class LibraryInitProvider extends ContentProvider {

    /* renamed from: c, reason: collision with root package name */
    public boolean f2535c = false;

    /* renamed from: f, reason: collision with root package name */
    public Handler f2536f;

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
        if (this.f2535c) {
            Log.i("[LibraryInitProvider]", "has init already.");
            return true;
        }
        if (this.f2536f == null) {
            this.f2536f = new Handler();
        }
        this.f2535c = true;
        Handler handler = this.f2536f;
        r rVar = new r(11);
        rVar.f1301f = this;
        VarHandle.storeStoreFence();
        handler.postDelayed(rVar, 3000L);
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
