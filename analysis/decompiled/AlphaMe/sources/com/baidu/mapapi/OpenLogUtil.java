package com.baidu.mapapi;

/* loaded from: classes.dex */
public class OpenLogUtil {

    /* renamed from: a, reason: collision with root package name */
    private static ModuleName f5957a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5958b = true;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5959c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String f5960d;

    public static String getMapLogFilePath() {
        return f5960d;
    }

    public static boolean isMapLogEnable() {
        return f5959c;
    }

    public static boolean isNativeLogAnalysisEnable() {
        return f5958b;
    }

    public static void setMapLogEnable(boolean z4) {
        f5959c = z4;
    }

    public static void setMapLogFilePath(String str) {
        f5960d = str;
    }

    public static void setModuleLogEnable(ModuleName moduleName, boolean z4) {
        f5957a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z4, moduleName.ordinal());
    }

    public static void setNativeLogAnalysisEnable(boolean z4) {
        f5958b = z4;
    }
}
