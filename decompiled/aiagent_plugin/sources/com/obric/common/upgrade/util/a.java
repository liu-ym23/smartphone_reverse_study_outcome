package com.obric.common.upgrade.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32648a = null;

    static {
        f32648a = new a();
    }

    private a() {
    }

    public final long a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        PackageInfo r3 = r1.getPackageManager().getPackageInfo(r1.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L9
        if (Build.VERSION.SDK_INT < 28) goto L8;
        return r3.getLongVersionCode();
    L8:
        return r3.versionCode;
    L9:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public final String b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return r1.getPackageManager().getPackageInfo(r1.getPackageName(), 0).versionName;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String a() {
        return Build.MODEL;
    }

    public final int b() {
        return Build.VERSION.SDK_INT;
    }
}
