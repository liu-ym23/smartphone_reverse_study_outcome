package b.a.a.a;

import android.app.Application;
import com.obric.eventkit.apphost.AppHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes.dex */
public final class c implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f3055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3059e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;

    public c(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        o.e(r4, "app");
        this.f3055a = r4;
        this.f3056b = "160";
        this.f3057c = 160;
        this.f3058d = new b();
        this.f3059e = 498349;
        this.f = "obric_assistant";
        this.g = "OGrace";
        this.h = "sdk";
        this.i = "0.0.1";
        this.j = 1;
        this.k = 1;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public a getAppClock() {
        return this.f3058d;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getAppId() {
        return this.f3059e;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getAppName() {
        return this.f;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getAppStringName() {
        return this.g;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public Application getApplication() {
        return this.f3055a;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getBuildChannel() {
        return this.h;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getManifestVersionCode() {
        return this.f3057c;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getManifestVersionName() {
        return this.f3056b;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getUpdateVersionCode() {
        return this.k;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getVersionCode() {
        return this.j;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getVersionName() {
        return this.i;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isDebugChannel() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isOversea() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isTestChannel() {
        return false;
    }
}
