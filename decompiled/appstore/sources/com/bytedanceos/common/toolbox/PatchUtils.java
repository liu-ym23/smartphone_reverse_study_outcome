package com.bytedanceos.common.toolbox;

/* JADX INFO: loaded from: classes2.dex */
public class PatchUtils {
    static {
        System.loadLibrary("ApkPatchLibrary");     // Catch: UnsatisfiedLinkError -> L5
        return;
    L5:
        e = move-exception;
        j.n(e.getMessage());
        h.d("ApkPatchLibrary");
    }

    public static native synchronized int patch(String r10, String r11, String r12);
}
