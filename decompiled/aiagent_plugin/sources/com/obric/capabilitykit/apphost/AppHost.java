package com.obric.capabilitykit.apphost;

import android.app.Application;
import com.obric.capabilitykit.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public interface AppHost {
    public static final Companion Companion = null;

    public static final class Companion implements AppHost {
        public static final /* synthetic */ Companion $$INSTANCE = null;
        private static AppHost _inst;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        private final AppHost getInst() {
            AppHost r1 = _inst;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("app module must call Apphost.setApphost()");
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public g getAppClock() {
            return getInst().getAppClock();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getAppId() {
            return getInst().getAppId();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getAppName() {
            return getInst().getAppName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getAppStringName() {
            return getInst().getAppStringName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public Application getApplication() {
            return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getInst().getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getBuildChannel() {
            return getInst().getBuildChannel();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getManifestVersionCode() {
            return getInst().getManifestVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getManifestVersionName() {
            return getInst().getManifestVersionName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getUpdateVersionCode() {
            return getInst().getUpdateVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getVersionCode() {
            return getInst().getVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getVersionName() {
            return getInst().getVersionName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isDebug() {
            return getInst().isDebug();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isDebugChannel() {
            return getInst().isDebugChannel();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isOversea() {
            return getInst().isOversea();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isTestChannel() {
            return getInst().isTestChannel();
        }

        public final void setAppHost(AppHost r2) {
            AppHost r1 = (AppHost) ZeusTransformUtils.wrapperContextForParams(r2, AppHost.class, "com.obric.aiagent.plugin");
            o.e(r1, "impl");
            _inst = r1;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    g getAppClock();

    int getAppId();

    String getAppName();

    String getAppStringName();

    Application getApplication();

    String getBuildChannel();

    int getManifestVersionCode();

    String getManifestVersionName();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isDebugChannel();

    boolean isOversea();

    boolean isTestChannel();
}
