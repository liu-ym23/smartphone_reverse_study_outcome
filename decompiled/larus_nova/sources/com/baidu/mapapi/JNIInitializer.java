package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

/* JADX INFO: loaded from: classes39.dex */
public class JNIInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f30493a;

    public JNIInitializer() {
    }

    public static Context getCachedContext() {
        return f30493a;
    }

    public static void setContext(Application r100) {
        if (r100 == null) goto L9;
        if (f30493a != null) goto L6;
        f30493a = r100;
    L6:
        VIContext.init(r100);
        return;
    L9:
        throw new RuntimeException();
    }
}
