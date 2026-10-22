package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f117945a;

    public static boolean a() {
        Boolean r100 = f117945a;
        if (r100 != null) goto L5;
        boolean r101 = false;
        Method r102 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L15
        r102.setAccessible(true);     // Catch: Throwable -> L15
        Object r103 = r102.invoke(null, new Object[]{"ro.vivo.os.version"});     // Catch: Throwable -> L15
        if ((r103 instanceof String) == true) goto L10;
    L17:
        f117945a = Boolean.valueOf(r101);
        return r101;
    L10:
        if (TextUtils.isEmpty((CharSequence) r103) == true) goto L17;
        if ((!Intrinsics.areEqual("unknown", r103)) == false) goto L17;
        r101 = true;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L5:
        return r100.booleanValue();
    }

    static {
    }
}
