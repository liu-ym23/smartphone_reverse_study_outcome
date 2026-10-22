package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = null;
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    static {
        DEFAULT_SERVICE = new FileService();
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> r10, ThumbnailQuery r11, ArrayPool r12, ContentResolver r13) {
        this(r10, DEFAULT_SERVICE, r11, r12, r13);
    }

    @Nullable
    private String getPath(@NonNull Uri r10) {
        Cursor r11 = this.query.query(r10);
        if (r11 != null) goto L16;
    L12:
        if (r11 == null) goto L18;
        r11.close();
        return null;
    L18:
        return null;
    L16:
    L9:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        if (r11.moveToFirst() == false) goto L12;
        String r12 = r11.getString(0);     // Catch: Throwable -> L9
        r11.close();
        return r12;
    }

    private boolean isValid(File r10) {
        if (this.service.exists(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (0 >= this.service.length(r10)) goto L7;
        return true;
    }

    public int getOrientation(Uri r10) {
        InputStream r11 = null;
        r11 = this.contentResolver.openInputStream(r10);     // Catch: Throwable -> L7 Throwable -> L9
        int r12 = ImageHeaderParserUtils.getOrientation(this.parsers, r11, this.byteArrayPool);     // Catch: Throwable -> L7 Throwable -> L9
        if (r11 != null) goto L26;
    L6:
        return r12;
    L26:
        r11.close();     // Catch: IOException -> L21
        goto L6
    L7:
        th = move-exception;
        if (r11 != null) goto L29;
    L20:
        throw th;
    L29:
        r11.close();     // Catch: IOException -> L22
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "Failed to open uri: " + r10, e);     // Catch: Throwable -> L7
    L14:
        if (r11 == null) goto L32;
        r11.close();     // Catch: IOException -> L23
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    }

    public InputStream open(Uri r10) throws FileNotFoundException {
        String r11 = getPath(r10);
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        File r12 = this.service.get(r11);
        if (isValid(r12) == true) goto L8;
        return null;
    L8:
        Uri r13 = Uri.fromFile(r12);
        return this.contentResolver.openInputStream(r13);
    L11:
        e = move-exception;
        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + r10 + " -> " + r13).initCause(e));
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> r10, FileService r11, ThumbnailQuery r12, ArrayPool r13, ContentResolver r14) {
        this.service = r11;
        this.query = r12;
        this.byteArrayPool = r13;
        this.contentResolver = r14;
        this.parsers = r10;
    }
}
