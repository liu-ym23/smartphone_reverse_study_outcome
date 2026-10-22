package com.baidu.mapapi;

/* JADX INFO: loaded from: classes39.dex */
public class OpenLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ModuleName f30499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f30500b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f30501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f30502d;

    public OpenLogUtil() {
    }

    public static String getMapLogFilePath() {
        return f30502d;
    }

    public static boolean isMapLogEnable() {
        return f30501c;
    }

    public static boolean isNativeLogAnalysisEnable() {
        return f30500b;
    }

    public static void setMapLogEnable(boolean r100) {
        f30501c = r100;
    }

    public static void setMapLogFilePath(String r100) {
        f30502d = r100;
    }

    public static void setNativeLogAnalysisEnable(boolean r100) {
        f30500b = r100;
    }

    public static void setModuleLogEnable(ModuleName r100, boolean r101) {
        f30499a = r100;
        com.baidu.mapsdkplatform.comjni.tools.a.a(r101, r100.ordinal());
    }
}
