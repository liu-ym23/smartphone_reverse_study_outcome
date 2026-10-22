package com.obric.aiagent.platform.depend;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: IAppContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAppContext {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IAppContext.kt */
    public static final class Companion implements IAppContext {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static volatile IAppContext cachedImpl;
        private static final f<IAppContext> impl$delegate = null;

        public static /* synthetic */ IAppContext lambda$fZOr8MusU57Pf64SB80lRWvyq5c() {
            return impl_delegate$lambda$0();
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            impl$delegate = g.a($$Lambda$IAppContext$Companion$fZOr8MusU57Pf64SB80lRWvyq5c.INSTANCE);
        }

        private final IAppContext getImpl() {
            return (IAppContext) ZeusTransformUtils.preCheckCast(impl$delegate.b(), IAppContext.class, "com.obric.aiagent.plugin");
        }

        private static final IAppContext impl_delegate$lambda$0() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L7;
            IAppContext r1 = r0.getAppContext();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (IAppContext) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppContext.class), IAppContext.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public int getAppId() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getAppId();
        L6:
            return DefaultImpls.getAppId(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public int getOldAiagentAppId() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getOldAiagentAppId();
        L6:
            return DefaultImpls.getOldAiagentAppId(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getMsSdkLicense() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L7;
            String r1 = r0.getMsSdkLicense();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return DefaultImpls.getMsSdkLicense(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public Application getApplication() {
            IAppContext r2 = getImpl();
            if (r2 == null) goto L8;
            Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L8;
            return r3;
        L8:
            throw new RuntimeException("IAppContext not initialized");
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public Context getContext() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L7;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getAppName() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getAppName();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getAppStringName() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getAppStringName();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getPackageName() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L7;
            String r1 = r0.getPackageName();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return DefaultImpls.getPackageName(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public boolean isDebug() {
            IAppContext r0 = getImpl();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isDebug();
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public int getVersionCode() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getVersionCode();
        L6:
            return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getVersionName() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            String r1 = r0.getVersionName();
            if (r1 == null) goto L6;
            return r1;
        L6:
            String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public int getManifestVersionCode() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getManifestVersionCode();
        L6:
            return DefaultImpls.getManifestVersionCode(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getManifestVersionName() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L7;
            String r1 = r0.getManifestVersionName();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return DefaultImpls.getManifestVersionName(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public int getUpdateVersionCode() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getUpdateVersionCode();
        L6:
            return DefaultImpls.getUpdateVersionCode(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public long getCurrentTimeMillis() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.getCurrentTimeMillis();
        L6:
            return DefaultImpls.getCurrentTimeMillis(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public String getBuildChannel() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L7;
            String r1 = r0.getBuildChannel();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return DefaultImpls.getBuildChannel(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public boolean isTestChannel() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.isTestChannel();
        L6:
            return DefaultImpls.isTestChannel(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public boolean isDebugChannel() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.isDebugChannel();
        L6:
            return DefaultImpls.isDebugChannel(this);
        }

        @Override // com.obric.aiagent.platform.depend.IAppContext
        public boolean isReleaseChannel() {
            IAppContext r0 = getImpl();
            if (r0 == null) goto L6;
            return r0.isReleaseChannel();
        L6:
            return DefaultImpls.isReleaseChannel(this);
        }
    }

    /* JADX INFO: compiled from: IAppContext.kt */
    public static final class DefaultImpls {
        public static int getAppId(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return 0;
        }

        public static String getBuildChannel(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return "";
        }

        public static String getMsSdkLicense(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return "";
        }

        public static int getOldAiagentAppId(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return 0;
        }

        public static boolean isDebugChannel(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static boolean isTestChannel(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static Context getContext(IAppContext r2) {
            return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin")).getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        public static String getPackageName(IAppContext r2) {
            String r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin")).getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName();
            o.c(r3, "getPackageName(...)");
            return r3;
        }

        public static int getManifestVersionCode(IAppContext r2) {
            return ((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin")).getVersionCode();
        }

        public static String getManifestVersionName(IAppContext r2) {
            return ((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin")).getVersionName();
        }

        public static int getUpdateVersionCode(IAppContext r2) {
            return ((IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin")).getVersionCode();
        }

        public static long getCurrentTimeMillis(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            return System.currentTimeMillis();
        }

        public static boolean isReleaseChannel(IAppContext r2) {
            IAppContext r3 = (IAppContext) ZeusTransformUtils.wrapperContextForParams(r2, IAppContext.class, "com.obric.aiagent.plugin");
            if (r3.isTestChannel() == false) goto L5;
        L7:
            return false;
        L5:
            if (r3.isDebugChannel() == true) goto L7;
            return true;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int getAppId();

    String getAppName();

    String getAppStringName();

    Application getApplication();

    String getBuildChannel();

    Context getContext();

    long getCurrentTimeMillis();

    int getManifestVersionCode();

    String getManifestVersionName();

    String getMsSdkLicense();

    int getOldAiagentAppId();

    String getPackageName();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isDebugChannel();

    boolean isReleaseChannel();

    boolean isTestChannel();
}
