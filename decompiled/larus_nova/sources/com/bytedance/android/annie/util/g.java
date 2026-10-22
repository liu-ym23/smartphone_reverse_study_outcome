package com.bytedance.android.annie.util;

import android.content.Context;
import android.graphics.Bitmap;
import bytedance.io.BdFileSystem;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static final q a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sourceFilePath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sourceFile");
        if (r102.exists() == true) goto L6;
        return new q(false, "source file not exists");
    L6:
        if (r102.isFile() == false) goto L11;
        r100.getCacheDir().getCanonicalPath();
        String r103 = r100.getCacheDir().getAbsolutePath() + File.separator + r102.getName();
        BdFileSystem.copyFile(r102, new PolarisFileWrapper(r103));
        return new q(true, r103);
    L11:
        return new q(false, "source file is not a file");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static final boolean b(Bitmap r100, PolarisFileWrapper r101, int r102, Bitmap.CompressFormat r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L22
        if (r100.isRecycled() == false) goto L30;
        return false;
    L30:
        BufferedOutputStream r105 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L22
        r100.compress(r103, r102, r105);     // Catch: Throwable -> L16
        r105.flush();     // Catch: Throwable -> L16
        r100 = 1;
        ?? r106 = 1;
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L25:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L29;
        HybridLogger r110 = HybridLogger.f246343a;
        HybridLogger.i("FileUtil", "saveImageBitmap error:" + r109.getMessage(), null, 12);
        return false;
    L29:
        return r106;
    L14:
        Throwable th10 = th;
    L35:
        throw th10;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r105, th10);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L16:
        th = move-exception;
        th10 = th;
        r100 = 0;
    L12:
        Throwable th11 = th;
    L24:
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th11));
        r106 = r100;
    L22:
        th = move-exception;
        th11 = th;
        r100 = 0;
        goto L24
    }
}
