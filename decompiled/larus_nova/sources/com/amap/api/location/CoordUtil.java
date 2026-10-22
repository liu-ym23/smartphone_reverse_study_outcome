package com.amap.api.location;

/* JADX INFO: loaded from: classes28.dex */
public class CoordUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f26760a;

    public CoordUtil() {
    }

    public static native int convertToGcj(double[] r100, double[] r101);

    public static boolean isLoadedSo() {
        return f26760a;
    }

    public static void setLoadedSo(boolean r100) {
        f26760a = r100;
    }
}
