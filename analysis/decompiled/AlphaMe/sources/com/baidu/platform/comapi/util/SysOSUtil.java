package com.baidu.platform.comapi.util;

import com.baidu.vi.VIContext;

/* loaded from: classes.dex */
public class SysOSUtil {

    /* renamed from: a, reason: collision with root package name */
    private static SysOSUtil f9274a = new SysOSUtil();

    /* renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.b f9275b = null;

    /* renamed from: c, reason: collision with root package name */
    private com.baidu.platform.comapi.util.a.a f9276c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9277d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f9278e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f9279f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f9280g = "";

    private SysOSUtil() {
    }

    public static SysOSUtil getInstance() {
        return f9274a;
    }

    public String getCompatibleSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9275b;
        return bVar != null ? bVar.a() : "";
    }

    public float getDensity() {
        com.baidu.platform.comapi.util.a.a aVar = this.f9276c;
        if (aVar != null) {
            return aVar.a();
        }
        return 1.0f;
    }

    public int getDensityDPI() {
        com.baidu.platform.comapi.util.a.a aVar = this.f9276c;
        if (aVar != null) {
            return aVar.b();
        }
        return 1;
    }

    public String getExternalFilesDir() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9275b;
        return bVar != null ? bVar.b() : "";
    }

    public String getGLRenderer() {
        return this.f9280g;
    }

    public String getGLVersion() {
        return this.f9279f;
    }

    public String getNetType() {
        return this.f9278e;
    }

    public String getOutputCache() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9275b;
        return bVar != null ? bVar.c() : "";
    }

    public String getOutputDirPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9275b;
        return bVar != null ? bVar.d() : "";
    }

    public int getScreenHeight() {
        com.baidu.platform.comapi.util.a.a aVar = this.f9276c;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public int getScreenWidth() {
        com.baidu.platform.comapi.util.a.a aVar = this.f9276c;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public String getSdcardPath() {
        com.baidu.platform.comapi.util.a.b bVar = this.f9275b;
        return bVar != null ? bVar.e() : "";
    }

    public void init(com.baidu.platform.comapi.util.a.b bVar, com.baidu.platform.comapi.util.a.a aVar) {
        if (this.f9277d) {
            return;
        }
        this.f9275b = bVar;
        this.f9276c = aVar;
        if (bVar == null) {
            this.f9275b = new com.baidu.platform.comapi.util.a.b();
        }
        if (this.f9276c == null) {
            this.f9276c = new com.baidu.platform.comapi.util.a.a();
        }
        this.f9275b.a(VIContext.getContext());
        this.f9276c.a(VIContext.getContext());
        try {
            NetworkUtil.registerNetwork(VIContext.getContext());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f9277d = true;
    }

    public void setGLInfo(String str, String str2) {
        if (this.f9280g.equals(str2) && this.f9279f.equals(str)) {
            return;
        }
        this.f9279f = str;
        this.f9280g = str2;
    }

    public void updateNetType(String str) {
        this.f9278e = str;
    }
}
