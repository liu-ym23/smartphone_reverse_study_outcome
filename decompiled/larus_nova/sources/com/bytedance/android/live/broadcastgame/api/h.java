package com.bytedance.android.live.broadcastgame.api;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.IOException;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {
    public static final String a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("xplay_peformance.log", "filename");
        Intrinsics.checkNotNullParameter(r101, "content");
        File[] r102 = ContextCompat.getExternalFilesDirs(r100, null);
        if (r102.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == true) goto L9;
    L21:
        return null;
    L9:
        if (r102[0] == null) goto L21;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102[0], "xplay_peformance.log");     // Catch: IOException -> L19
        PolarisFileWriterWrapper r105 = new PolarisFileWriterWrapper(r104, true);     // Catch: IOException -> L19
        r105.append(r101);     // Catch: Throwable -> L14
        r105.append("\n");     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r105, null);     // Catch: IOException -> L19
        return r104.getAbsolutePath();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L5:
        r103 = false;
        goto L7
    }
}
