package com.obric.oui;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.oui.common.style.OUISoundEffectHelper;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUISdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/OUISdk;", "Landroid/content/ComponentCallbacks2;", "()V", "TAG", "", "initialized", "", "getApplicationReflect", "Landroid/app/Application;", "init", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUISdk implements ComponentCallbacks2 {
    public static final OUISdk INSTANCE = null;
    private static final String TAG = "OUISdk";
    private static boolean initialized;

    static {
        INSTANCE = new OUISdk();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        Intrinsics.checkNotNullParameter(r1, "newConfig");
    }

    private OUISdk() {
    }

    public final void init() {
    L12:
        e = move-exception;
        L.e(TAG, "init failed", e);
        return;
    L4:
        if (initialized == true) goto L10;
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L12
        Application r4 = getApplicationReflect();     // Catch: Exception -> L12
        if (r4 == null) goto L9;
        r4.registerComponentCallbacks(this);     // Catch: Exception -> L12
    L9:
        OEALogger.INSTANCE.enableAndroidDebugLog();     // Catch: Exception -> L12
        initialized = true;     // Catch: Exception -> L12
        L.d(TAG, "init success, cost: " + (System.currentTimeMillis() - r2) + " ms");     // Catch: Exception -> L12
        return;
    L10:
        L.d(TAG, "init already");     // Catch: Exception -> L12
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        OUISoundEffectHelper.INSTANCE.release();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        OUISoundEffectHelper.INSTANCE.release();
    }

    private final Application getApplicationReflect() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        L.e(TAG, "getApplicationReflect failed", e);
        Application r0 = (Application) null;
        return null;
    }
}
