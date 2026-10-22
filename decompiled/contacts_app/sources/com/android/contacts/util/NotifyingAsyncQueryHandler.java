package com.android.contacts.util;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class NotifyingAsyncQueryHandler extends AsyncQueryHandler {
    private WeakReference<AsyncQueryListener> mListener;

    public interface AsyncQueryListener {
        void onQueryComplete(int r1, Object r2, Cursor r3);
    }

    public NotifyingAsyncQueryHandler(Context r1, AsyncQueryListener r2) {
        super(r1.getContentResolver());
        setQueryListener(r2);
    }

    public void setQueryListener(AsyncQueryListener r2) {
        this.mListener = new WeakReference(r2);
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int r1, Object r2, Cursor r3) {
        AsyncQueryListener r0 = this.mListener.get();
        if (r0 == null) goto L5;
        r0.onQueryComplete(r1, r2, r3);
        return;
    L5:
        if (r3 == null) goto L9;
        r3.close();
        return;
    }
}
