package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

/* loaded from: classes.dex */
public class JNIInitializer {

    /* renamed from: a, reason: collision with root package name */
    private static Context f5952a;

    public static Context getCachedContext() {
        return f5952a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f5952a == null) {
            f5952a = application;
        }
        VIContext.init(application);
    }
}
