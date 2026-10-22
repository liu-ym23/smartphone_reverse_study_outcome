package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: compiled from: NativeLibraryLoadedStatus.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f37713a;

    /* JADX INFO: compiled from: NativeLibraryLoadedStatus.java */
    public interface a {
        boolean a();

        boolean b();
    }

    public static void a(boolean r1) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        a r0 = f37713a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r1 == false) goto L10;
        boolean r2 = r0.a();
    L11:
        if (r2 == false) goto L14;
        return;
    L14:
        throw new h("Native method called before the native library was ready.");
    L10:
        r2 = r0.b();
        goto L11
    }
}
