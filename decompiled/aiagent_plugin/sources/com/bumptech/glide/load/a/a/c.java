package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.a.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.a.d<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f3354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f3355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f3356c;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f3357b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f3358a;

        a(ContentResolver r1) {
            this.f3358a = r1;
        }

        static {
            f3357b = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.a.a.d
        public Cursor query(Uri r8) {
            String r9 = r8.getLastPathSegment();
            return ZeusProviderTransform.query(this.f3358a, MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f3357b, "kind = 1 AND image_id = ?", new String[]{r9}, null, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f3359b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f3360a;

        b(ContentResolver r1) {
            this.f3360a = r1;
        }

        static {
            f3359b = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.a.a.d
        public Cursor query(Uri r8) {
            String r9 = r8.getLastPathSegment();
            return ZeusProviderTransform.query(this.f3360a, MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f3359b, "kind = 1 AND video_id = ?", new String[]{r9}, null, "com.obric.aiagent.plugin");
        }
    }

    @Override // com.bumptech.glide.load.a.d
    public void c() {
    }

    public static c a(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a(r4, r3, new a(r4.getContentResolver()));
    }

    public static c b(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a(r4, r3, new b(r4.getContentResolver()));
    }

    private static c a(Context r3, Uri r4, d r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r0 = Glide.get(r6).getArrayPool();
        return new c(r4, new e(Glide.get(r6).getRegistry().a(), r7, r0, r6.getContentResolver()));
    }

    c(Uri r1, e r2) {
        this.f3354a = r1;
        this.f3355b = r2;
    }

    @Override // com.bumptech.glide.load.a.d
    public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super InputStream> r3) {
        com.bumptech.glide.load.a.d.a r4 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
        InputStream r5 = e();     // Catch: FileNotFoundException -> L6
        this.f3356c = r5;     // Catch: FileNotFoundException -> L6
        r4.a(r5);
        return;
    L6:
        e = move-exception;
        if (a(TAG, 3) == false) goto L10;
        a(TAG, "Failed to find thumbnail file", e);
    L10:
        r4.a(e);
    }

    private InputStream e() {
        InputStream r0 = this.f3355b.b(this.f3354a);
        if (r0 == null) goto L5;
        int r3 = this.f3355b.a(this.f3354a);
    L6:
        if (r3 != (-1)) goto L8;
        return r0;
    L8:
        return new g(r0, r3);
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        InputStream r0 = this.f3356c;
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.a.d
    public com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.f3349a;
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
