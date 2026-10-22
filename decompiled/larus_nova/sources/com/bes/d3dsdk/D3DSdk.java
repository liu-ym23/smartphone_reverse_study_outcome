package com.bes.d3dsdk;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class D3DSdk {
    public native void d3dInit(int r100, int r101, int r102, int r103);

    public native float[] d3dProcess(int r100, float r101, float r102, float r103, float[] r104, float[] r105);

    public native void d3dShutdown();

    public D3DSdk() throws Exception {
        Intrinsics.checkNotNullParameter("d3d_sdk", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> d3d_sdk");
        a.c("d3d_sdk");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> d3d_sdk");
    }
}
