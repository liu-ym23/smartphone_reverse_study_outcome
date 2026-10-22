package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements l<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public c() {
    }

    @Override // com.bumptech.glide.load.d
    public /* synthetic */ boolean a(Object r3, File r4, i r5) {
        return a((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.c a(i r1) {
        return com.bumptech.glide.load.c.f3506a;
    }

    public boolean a(v<GifDrawable> r1, File r2, i r3) {
        com.bumptech.glide.f.a.a(((GifDrawable) ZeusTransformUtils.preCheckCast(((v) ZeusTransformUtils.wrapperContextForParams(r1, v.class, "com.obric.aiagent.plugin")).d(), GifDrawable.class, "com.obric.aiagent.plugin")).getBuffer(), r2);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (a(TAG, 5) == false) goto L9;
        a(TAG, "Failed to encode GIF drawable data", e);
    L9:
        return false;
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
        return Log.w(r1, r2, r3);
    }
}
