package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import kotlin.Lazy;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class AppGlobals {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppGlobals f11863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f11864b = null;

    static {
        f11863a = new AppGlobals();
        f11864b = kotlin.b.b(AppGlobals$app$2.INSTANCE);
    }

    public AppGlobals() {
    }

    public final Application a() {
        return (Application) f11864b.getValue();
    }

    public final Application b() {
        return a();
    }

    public final Context c() {
        Context r10 = b().getApplicationContext();
        q.f(r10, "getApplication().applicationContext");
        return r10;
    }
}
