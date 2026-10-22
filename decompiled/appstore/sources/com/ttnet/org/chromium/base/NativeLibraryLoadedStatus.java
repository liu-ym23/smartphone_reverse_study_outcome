package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeLibraryLoadedStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NativeLibraryLoadedStatusProvider f18269a;

    public interface NativeLibraryLoadedStatusProvider {
        boolean areMainDexNativeMethodsReady();

        boolean areNativeMethodsReady();
    }

    public static void a(boolean r10) {
        if (c.f18315a == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatusProvider r11 = f18269a;
        if (r11 != null) goto L8;
        return;
    L8:
        if (r10 == false) goto L10;
        boolean r12 = r11.areMainDexNativeMethodsReady();
    L11:
        if (r12 == false) goto L14;
        return;
    L14:
        throw new JniException("Native method called before the native library was ready.");
    L10:
        r12 = r11.areNativeMethodsReady();
        goto L11
    }
}
