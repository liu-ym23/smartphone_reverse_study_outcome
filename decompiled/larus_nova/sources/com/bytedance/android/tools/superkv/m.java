package com.bytedance.android.tools.superkv;

import android.os.Build;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.security.AccessController;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f187651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f187652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f187653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class f187654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f187655e;

    public static void a(MappedByteBuffer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.force();
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        AccessController.doPrivileged(new k(r100));
        return;
    L7:
        AccessController.doPrivileged(new l(r100));
    }
}
