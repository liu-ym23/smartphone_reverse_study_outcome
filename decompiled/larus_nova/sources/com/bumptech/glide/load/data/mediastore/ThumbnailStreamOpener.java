package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
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

    private String getPath(Uri r100) {
        Cursor r101 = null;
        Cursor r102 = this.query.query(r100);     // Catch: Throwable -> L15 SecurityException -> L17
        if (r102 != null) goto L28;
    L12:
        if (r102 == null) goto L14;
        r102.close();
    L14:
        return null;
    L28:
    L10:
        e = e;
    L19:
        GlideLogUtil.e(TAG, "Failed to query for thumbnail for Uri: " + r100, e);     // Catch: Throwable -> L23
        if (r102 == null) goto L22;
        r102.close();
    L22:
        return null;
    L23:
        th = th;
        r101 = r102;
    L25:
        if (r101 == null) goto L27;
        r101.close();
    L27:
        throw th;
    L6:
        if (r102.moveToFirst() == false) goto L12;
        String r103 = r102.getString(0);     // Catch: SecurityException -> L10 Throwable -> L23
        r102.close();
        return r103;
    L17:
        e = e;
        r102 = null;
    L15:
        th = th;
        goto L25
    }

    private boolean isValid(File r100) {
        if (this.service.exists(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (0 >= this.service.length(r100)) goto L7;
        return true;
    }

    public int getOrientation(Uri r100) {
        InputStream r101 = null;
        r101 = ContentResolverWrapper.openInputStream(this.contentResolver, r100);     // Catch: Throwable -> L7 Throwable -> L9 IOException -> L11
        int r102 = ImageHeaderParserUtils.getOrientation(this.parsers, r101, this.byteArrayPool);     // Catch: Throwable -> L7 Throwable -> L9 IOException -> L11
        if (r101 != null) goto L25;
    L6:
        return r102;
    L25:
        r101.close();     // Catch: IOException -> L20
    L7:
        th = move-exception;
        if (0 != 0) goto L23;
    L19:
        throw th;
    L23:
        r101.close();     // Catch: IOException -> L21
    L9:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to open uri: " + r100, e);     // Catch: Throwable -> L7
        if (r101 == null) goto L31;
        r101.close();     // Catch: IOException -> L22
        return -1;
    L32:
        return -1;
    L31:
        return -1;
    }

    public InputStream open(Uri r100) throws FileNotFoundException {
        String r101 = getPath(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        File r102 = this.service.get(r101);
        if (isValid(r102) == true) goto L8;
        return null;
    L8:
        Uri r103 = Uri.fromFile(r102);
        return ContentResolverWrapper.openInputStream(this.contentResolver, r103);
    L11:
        e = move-exception;
        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + r100 + " -> " + r103).initCause(e));
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> r100, ThumbnailQuery r101, ArrayPool r102, ContentResolver r110) {
        this(r100, DEFAULT_SERVICE, r101, r102, r110);
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> r100, FileService r101, ThumbnailQuery r102, ArrayPool r103, ContentResolver r104) {
        this.service = r101;
        this.query = r102;
        this.byteArrayPool = r103;
        this.contentResolver = r104;
        this.parsers = r100;
    }
}
