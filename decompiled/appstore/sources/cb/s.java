package cb;

import android.app.Application;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.apphost.AppHost;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f6089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.obric.capabilitykit.j f6092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6093e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f6098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f6101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f6103o;

    public s(Application r10) {
        kotlin.jvm.internal.q.g(r10, ServerElements.APP);
        this.f6089a = r10;
        this.f6090b = "160";
        this.f6091c = 160;
        this.f6092d = new r();
        this.f6093e = 498349;
        this.f6094f = "obric_assistant";
        this.f6095g = "OGrace";
        this.f6098j = "sdk";
        this.f6101m = "0.0.1";
        this.f6102n = 1;
        this.f6103o = 1;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public com.obric.capabilitykit.j getAppClock() {
        return this.f6092d;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getAppId() {
        return this.f6093e;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppName() {
        return this.f6094f;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getAppStringName() {
        return this.f6095g;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public Application getApplication() {
        return this.f6089a;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getBuildChannel() {
        return this.f6098j;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getManifestVersionCode() {
        return this.f6091c;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getManifestVersionName() {
        return this.f6090b;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getUpdateVersionCode() {
        return this.f6103o;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public int getVersionCode() {
        return this.f6102n;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public String getVersionName() {
        return this.f6101m;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebug() {
        return this.f6096h;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isDebugChannel() {
        return this.f6100l;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isOversea() {
        return this.f6097i;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public boolean isTestChannel() {
        return this.f6099k;
    }
}
