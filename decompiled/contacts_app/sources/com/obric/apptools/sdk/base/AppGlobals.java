package com.obric.apptools.sdk.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppGlobals.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/obric/apptools/sdk/base/AppGlobals;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "app$delegate", "Lkotlin/Lazy;", "getApplication", "getApplicationContext", "Landroid/content/Context;", "getResource", "Landroid/content/res/Resources;", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppGlobals {
    public static final AppGlobals INSTANCE = null;
    private static final Lazy app$delegate = null;

    private AppGlobals() {
    }

    static {
        INSTANCE = new AppGlobals();
        app$delegate = LazyKt.lazy(AppGlobals$app$2.INSTANCE);
    }

    private final Application getApp() {
        return (Application) app$delegate.getValue();
    }

    @JvmStatic
    public static final synchronized Application getApplication() {
        monitor-enter(AppGlobals.class);
        Application r1 = INSTANCE.getApp();     // Catch: Throwable -> L7
        monitor-exit(AppGlobals.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final Context getApplicationContext() {
        Context r0 = getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "getApplication().applicationContext");
        return r0;
    }

    @JvmStatic
    public static final Resources getResource() {
        Resources r0 = getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(r0, "getApplication().resources");
        return r0;
    }
}
