package com.obric.capabilitykit;

import android.app.Application;
import com.obric.capabilitykit.apphost.AppHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Application f32142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f32145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32146e;
    private final String f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final String j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final int n;
    private final int o;

    public i(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "app");
        this.f32142a = r4;
        this.f32143b = "160";
        this.f32144c = 160;
        this.f32145d = new h();
        this.f32146e = 498349;
        this.f = "obric_assistant";
        this.g = "OGrace";
        this.j = "sdk";
        this.m = "0.0.1";
        this.n = 1;
        this.o = 1;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public g getAppClock() {
        return this.f32145d;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getAppId() {
        return this.f32146e;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppName() {
        return this.f;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppStringName() {
        return this.g;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public Application getApplication() {
        return this.f32142a;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getBuildChannel() {
        return this.j;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getManifestVersionCode() {
        return this.f32144c;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getManifestVersionName() {
        return this.f32143b;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getUpdateVersionCode() {
        return this.o;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getVersionCode() {
        return this.n;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getVersionName() {
        return this.m;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebug() {
        return this.h;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebugChannel() {
        return this.l;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isOversea() {
        return this.i;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isTestChannel() {
        return this.k;
    }
}
