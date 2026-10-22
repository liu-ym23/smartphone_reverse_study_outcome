package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import e0.a;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r10, String r11, String[] r12) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r10) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r10, ContentValues r11) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r10 = getContext();
        if (r10 == null) goto L10;
        if (r10.getApplicationContext() == null) goto L11;
        a.e(r10).a();
        return true;
    L11:
        return true;
    L10:
        throw new StartupException("Context cannot be null");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new IllegalStateException("Not allowed.");
    }
}
