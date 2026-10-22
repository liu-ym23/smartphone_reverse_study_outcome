package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153082a = 0;

    static {
    }

    public static void a(String r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        r102.getPath();     // Catch: IOException -> L5 FileNotFoundException -> L7
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: IOException -> L5 FileNotFoundException -> L7
        r101.compress(Bitmap.CompressFormat.JPEG, 80, r103);     // Catch: IOException -> L5 FileNotFoundException -> L7
        r103.flush();     // Catch: IOException -> L5 FileNotFoundException -> L7
        r103.close();     // Catch: IOException -> L5 FileNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
