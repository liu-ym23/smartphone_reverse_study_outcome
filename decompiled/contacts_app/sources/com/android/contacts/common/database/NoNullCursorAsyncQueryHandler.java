package com.android.contacts.common.database;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class NoNullCursorAsyncQueryHandler extends AsyncQueryHandler {

    private static class CookieWithProjection {
        public final Object originalCookie;
        public final String[] projection;

        public CookieWithProjection(Object r1, String[] r2) {
            this.originalCookie = r1;
            this.projection = r2;
        }
    }

    protected abstract void onNotNullableQueryComplete(int r1, Object r2, Cursor r3);

    public NoNullCursorAsyncQueryHandler(ContentResolver r1) {
        super(r1);
    }

    @Override // android.content.AsyncQueryHandler
    public void startQuery(int r9, Object r10, Uri r11, String[] r12, String r13, String[] r14, String r15) {
        super.startQuery(r9, new CookieWithProjection(r10, r12), r11, r12, r13, r14, r15);
    }

    @Override // android.content.AsyncQueryHandler
    protected final void onQueryComplete(int r2, Object r3, Cursor r4) {
        CookieWithProjection r5 = (CookieWithProjection) r3;
        super.onQueryComplete(r2, r5.originalCookie, r4);
        if (r4 != null) goto L5;
        r4 = new EmptyCursor(r5.projection);
    L5:
        onNotNullableQueryComplete(r2, r5.originalCookie, r4);
    }
}
