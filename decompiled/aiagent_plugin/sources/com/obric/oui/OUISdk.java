package com.obric.oui;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import com.obric.common.oea.foundation.b.c;
import com.obric.oui.common.style.h;
import com.obric.oui.d.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OUISdk.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OUISdk implements ComponentCallbacks2 {
    public static final OUISdk INSTANCE = null;
    private static final String TAG = "OUISdk";
    private static boolean initialized;

    static {
        INSTANCE = new OUISdk();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        o.e(r1, "newConfig");
    }

    private OUISdk() {
    }

    public final void init() {
    L12:
        e = move-exception;
        b.b(TAG, "init failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        if (initialized == true) goto L10;
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L12
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationReflect(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r4 == null) goto L9;
        r4.registerComponentCallbacks((ComponentCallbacks) ZeusTransformUtils.preCheckCast(this, ComponentCallbacks.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
    L9:
        c.f32472a.a();     // Catch: Exception -> L12
        initialized = true;     // Catch: Exception -> L12
        b.b(TAG, "init success, cost: " + (System.currentTimeMillis() - r2) + " ms");     // Catch: Exception -> L12
        return;
    L10:
        b.b(TAG, "init already");     // Catch: Exception -> L12
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        h.f34529a.a();
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        h.f34529a.a();
        return;
    }

    private final Application getApplicationReflect() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]), Application.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        b.b(TAG, "getApplicationReflect failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return (Application) ZeusTransformUtils.preCheckCast(null, Application.class, "com.obric.aiagent.plugin");
    }
}
