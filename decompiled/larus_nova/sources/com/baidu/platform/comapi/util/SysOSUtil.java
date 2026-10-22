package com.baidu.platform.comapi.util;

import com.baidu.vi.VIContext;

/* JADX INFO: loaded from: classes39.dex */
public class SysOSUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SysOSUtil f33394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.b f33395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.a f33396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f33398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f33400g;

    static {
        f33394a = new SysOSUtil();
    }

    public String getCompatibleSdcardPath() {
        com.baidu.platform.comapi.util.a.b r100 = this.f33395b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.a();
    }

    public float getDensity() {
        com.baidu.platform.comapi.util.a.a r100 = this.f33396c;
        if (r100 != null) goto L5;
        return 1.0f;
    L5:
        return r100.a();
    }

    public int getDensityDPI() {
        com.baidu.platform.comapi.util.a.a r100 = this.f33396c;
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.b();
    }

    public String getExternalFilesDir() {
        com.baidu.platform.comapi.util.a.b r100 = this.f33395b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.b();
    }

    public String getOutputCache() {
        com.baidu.platform.comapi.util.a.b r100 = this.f33395b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.c();
    }

    public String getOutputDirPath() {
        com.baidu.platform.comapi.util.a.b r100 = this.f33395b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.d();
    }

    public int getScreenHeight() {
        com.baidu.platform.comapi.util.a.a r100 = this.f33396c;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.c();
    }

    public int getScreenWidth() {
        com.baidu.platform.comapi.util.a.a r100 = this.f33396c;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.d();
    }

    public String getSdcardPath() {
        com.baidu.platform.comapi.util.a.b r100 = this.f33395b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.e();
    }

    private SysOSUtil() {
        this.f33395b = null;
        this.f33396c = null;
        this.f33397d = false;
        this.f33398e = "";
        this.f33399f = "";
        this.f33400g = "";
    }

    public static SysOSUtil getInstance() {
        return f33394a;
    }

    public String getGLRenderer() {
        return this.f33400g;
    }

    public String getGLVersion() {
        return this.f33399f;
    }

    public String getNetType() {
        return this.f33398e;
    }

    public void updateNetType(String r100) {
        this.f33398e = r100;
    }

    public void init(com.baidu.platform.comapi.util.a.b r100, com.baidu.platform.comapi.util.a.a r101) {
        if (this.f33397d == true) goto L19;
        this.f33395b = r100;
        this.f33396c = r101;
        if (r100 != null) goto L8;
        this.f33395b = new com.baidu.platform.comapi.util.a.b();
    L8:
        if (this.f33396c != null) goto L10;
        this.f33396c = new com.baidu.platform.comapi.util.a.a();
    L10:
        this.f33395b.a(VIContext.getContext());
        this.f33396c.a(VIContext.getContext());
        NetworkUtil.registerNetwork(VIContext.getContext());     // Catch: Exception -> L13
    L15:
        this.f33397d = true;
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public void setGLInfo(String r100, String r101) {
        if (this.f33400g.equals(r101) == true) goto L5;
    L6:
        this.f33399f = r100;
        this.f33400g = r101;
        return;
    L5:
        if (this.f33399f.equals(r100) == false) goto L6;
    }
}
