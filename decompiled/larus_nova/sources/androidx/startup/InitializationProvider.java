package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r100 = getContext();
        if (r100 == null) goto L10;
        if (r100.getApplicationContext() == null) goto L11;
        AppInitializer.getInstance(r100).discoverAndInitialize();
        return true;
    L11:
        return true;
    L10:
        throw new StartupException("Context cannot be null");
    }

    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r100) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r100, ContentValues r101) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r100, String r101, String[] r102) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        throw new IllegalStateException("Not allowed.");
    }
}
