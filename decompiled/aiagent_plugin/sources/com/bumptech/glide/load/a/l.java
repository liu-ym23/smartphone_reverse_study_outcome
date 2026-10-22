package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l<T> implements d<T> {
    private static final String TAG = "LocalUriFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f3388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f3389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f3390c;

    public abstract void a(T r1);

    public abstract T b(Uri r1, ContentResolver r2);

    @Override // com.bumptech.glide.load.a.d
    public void c() {
    }

    public l(ContentResolver r1, Uri r2) {
        this.f3389b = r1;
        this.f3388a = r2;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void a(com.bumptech.glide.e r2, d.a<? super T> r3) {
        d.a r4 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
        T r5 = b(this.f3388a, this.f3389b);     // Catch: FileNotFoundException -> L6
        this.f3390c = r5;     // Catch: FileNotFoundException -> L6
        r4.a(r5);
        return;
    L6:
        e = move-exception;
        if (a(TAG, 3) == false) goto L10;
        a(TAG, "Failed to open Uri", e);
    L10:
        r4.a(e);
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        T r0 = this.f3390c;
        if (r0 == null) goto L9;
        a(r0);     // Catch: IOException -> L6
        return;
    L10:
        return;
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
