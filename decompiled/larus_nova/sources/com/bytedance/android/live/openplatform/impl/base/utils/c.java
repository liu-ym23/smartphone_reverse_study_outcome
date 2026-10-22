package com.bytedance.android.live.openplatform.impl.base.utils;

import android.content.Context;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f84044a = 0;

    static {
    }

    @JvmStatic
    public static final File a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("miniapp_cover", "dirName");
        String r101 = Environment.getExternalStorageState();     // Catch: NullPointerException -> L5
    L7:
        if (Intrinsics.areEqual("mounted", r101) == false) goto L16;
        File r102 = r100.getExternalCacheDir();
        Intrinsics.checkNotNull(r102);
        if (r102.exists() == false) goto L11;
    L17:
        if (r102 != null) goto L19;
        r102 = r100.getCacheDir();
    L19:
        Intrinsics.checkNotNull(r102);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "miniapp_cover");
        if (r103.exists() == true) goto L25;
        if (r103.mkdir() == true) goto L25;
        return r102;
    L25:
        return r103;
    L11:
        if (r102.mkdirs() == false) goto L16;
        new PolarisFileWrapper(r102, ".nomedia").createNewFile();     // Catch: IOException -> L15
    L16:
        r102 = null;
    L5:
        r101 = "";
        goto L7
    }
}
