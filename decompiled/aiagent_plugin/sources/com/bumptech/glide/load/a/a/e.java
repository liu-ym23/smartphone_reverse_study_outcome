package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.f;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ThumbnailStreamOpener.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    private static final String TAG = "ThumbStreamOpener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f3361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f3363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f3365e;
    private final List<ImageHeaderParser> f;

    static {
        f3361a = new a();
    }

    e(List<ImageHeaderParser> r9, d r10, com.bumptech.glide.load.engine.a.b r11, ContentResolver r12) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this(r3, f3361a, r5, r6, r12);
    }

    e(List<ImageHeaderParser> r3, a r4, d r5, com.bumptech.glide.load.engine.a.b r6, ContentResolver r7) {
        List<ImageHeaderParser> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r10 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3362b = r4;
        this.f3363c = r9;
        this.f3364d = r10;
        this.f3365e = r7;
        this.f = r8;
    }

    int a(Uri r5) {
        InputStream r1 = null;
        r1 = this.f3365e.openInputStream(r5);     // Catch: Throwable -> L7 Throwable -> L9
        int r4 = f.a(this.f, r1, this.f3364d);     // Catch: Throwable -> L7 Throwable -> L9
        if (r1 != null) goto L24;
    L6:
        return r4;
    L24:
        r1.close();     // Catch: IOException -> L21
        goto L6
    L7:
        th = move-exception;
        if (r1 != null) goto L26;
    L20:
        throw th;
    L26:
        r1.close();     // Catch: IOException -> L22
    L9:
        e = move-exception;
        if (a(TAG, 3) == false) goto L14;
        a(TAG, "Failed to open uri: " + r5, e);     // Catch: Throwable -> L7
    L14:
        if (r1 == null) goto L32;
        r1.close();     // Catch: IOException -> L23
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    }

    public InputStream b(Uri r5) {
        String r0 = c(r5);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        File r1 = this.f3362b.a(r0);
        if (a(r1) == true) goto L8;
        return null;
    L8:
        Uri r2 = Uri.fromFile(r1);
        return this.f3365e.openInputStream(r2);
    L11:
        e = move-exception;
        throw ((FileNotFoundException) ZeusTransformUtils.preCheckCast(new FileNotFoundException("NPE opening uri: " + r5 + " -> " + r2).initCause(e), FileNotFoundException.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private String c(Uri r6) {
        ?? r1 = 0;
        Cursor r5 = this.f3363c.query(r6);     // Catch: Throwable -> L16 SecurityException -> L18
        if (r5 != null) goto L33;
    L13:
        if (r5 == null) goto L15;
        r5.close();
    L15:
        return null;
    L33:
    L11:
        e = e;
    L22:
        if (a(TAG, 3) == false) goto L24;
        a(TAG, "Failed to query for thumbnail for Uri: " + r6, e);     // Catch: Throwable -> L27
    L24:
        if (r5 == null) goto L26;
        r5.close();
    L26:
        return null;
    L6:
        if (r5.moveToFirst() == false) goto L13;
        String r7 = r5.getString(0);     // Catch: SecurityException -> L11 Throwable -> L27
        if (r5 == null) goto L10;
        r5.close();
    L10:
        return r7;
    L27:
        th = th;
        r1 = this;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L18:
        e = e;
        r5 = null;
    L16:
        th = th;
        goto L29
    }

    private boolean a(File r3) {
        if (this.f3362b.a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (0 >= this.f3362b.b(r3)) goto L7;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
