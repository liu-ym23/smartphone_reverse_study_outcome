package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements d<T> {
    private static final String TAG = "AssetPathFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f3367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f3368c;

    public abstract T a(AssetManager r1, String r2);

    public abstract void a(T r1);

    @Override // com.bumptech.glide.load.a.d
    public void c() {
    }

    public b(AssetManager r1, String r2) {
        this.f3367b = r1;
        this.f3366a = r2;
    }

    @Override // com.bumptech.glide.load.a.d
    public void a(com.bumptech.glide.e r2, d.a<? super T> r3) {
        d.a r4 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
        T r5 = a(this.f3367b, this.f3366a);     // Catch: IOException -> L6
        this.f3368c = r5;     // Catch: IOException -> L6
        r4.a(r5);
        return;
    L6:
        e = move-exception;
        if (a(TAG, 3) == false) goto L10;
        a(TAG, "Failed to load data from asset manager", e);
    L10:
        r4.a(e);
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        T r0 = this.f3368c;
        if (r0 != null) goto L8;
        return;
    L8:
        a(r0);     // Catch: IOException -> L7
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
