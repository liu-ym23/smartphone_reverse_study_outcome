package com.android.contacts.list;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import androidx.loader.content.CursorLoader;

/* JADX INFO: loaded from: classes2.dex */
public class JoinContactLoader extends CursorLoader {
    private String[] mProjection;
    private Uri mSuggestionUri;

    public static class JoinContactLoaderResult extends CursorWrapper {
        public final Cursor suggestionCursor;

        public JoinContactLoaderResult(Cursor r1, Cursor r2) {
            super(r1);
            this.suggestionCursor = r2;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.suggestionCursor.close();     // Catch: Throwable -> L5
            super.close();
            return;
        L5:
            th = move-exception;
            super.close();
            throw th;
        }
    }

    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    public JoinContactLoader(Context r8) {
        super(r8, null, null, null, null, null);
    }

    public void setSuggestionUri(Uri r1) {
        this.mSuggestionUri = r1;
    }

    @Override // androidx.loader.content.CursorLoader
    public void setProjection(String[] r1) {
        super.setProjection(r1);
        this.mProjection = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        Cursor r0 = getContext().getContentResolver().query(this.mSuggestionUri, this.mProjection, null, null, null);
        return new JoinContactLoaderResult(super.loadInBackground(), r0);
    }
}
