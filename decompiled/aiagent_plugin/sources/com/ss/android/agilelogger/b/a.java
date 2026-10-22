package com.ss.android.agilelogger.b;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static File a(Context r2) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "logs");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    public static String b(Context r2) {
        File r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getFilesDir();
        if (r3 == null) goto L9;
        File r0 = new File(r3.getAbsolutePath(), "ALOG");
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0.getAbsolutePath();
    L9:
        return null;
    }
}
