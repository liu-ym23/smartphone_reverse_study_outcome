package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f7679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharSequence f7680b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CharSequence f7681c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7682d = -1;

    static {
        f7679a = "sony";
        f7680b = "amigo";
        f7681c = "funtouch";
    }

    public static boolean a() {
        int r0 = f7682d;
        if (r0 == (-1)) goto L18;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L18:
    L12:
        f7682d = 0;
    L14:
        if (f7682d == 1) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (ZeusTransformUtils.forName("ohos.utils.system.SystemCapability", "com.obric.aiagent.plugin") == null) goto L10;
        f7682d = 1;     // Catch: Throwable -> L12
    L17:
        goto L14
    L10:
        f7682d = 0;     // Catch: Throwable -> L12
        goto L17
    }
}
