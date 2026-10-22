package com.bef.avatarsdk;

import com.ss.android.tecommonenvinitializer.diagnosis.b;
import java.util.Collections;

/* JADX INFO: loaded from: classes39.dex */
public class AvatarEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f33655a;

    public AvatarEnv() {
    }

    private static native int nativeInitialize();

    static {
        b.a(Collections.singletonList("effect"));
        if (f33655a == false) goto L5;
        return;
    L5:
        if (nativeInitialize() != 0) goto L7;
        boolean r100 = true;
    L8:
        f33655a = r100;
        return;
    L7:
        r100 = false;
        goto L8
    }
}
