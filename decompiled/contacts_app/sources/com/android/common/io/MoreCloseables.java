package com.android.common.io;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class MoreCloseables {
    public MoreCloseables() {
    }

    public static void closeQuietly(Cursor r0) {
        if (r0 == null) goto L5;
        r0.close();
        return;
    }

    public static void closeQuietly(AssetFileDescriptor r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }
}
