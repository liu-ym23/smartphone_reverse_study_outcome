package com.stepos.stepclaw.runtime;

import a8.b;
import android.content.Context;
import android.util.Log;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b=\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u0015J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0015HÆ\u0003J\u009f\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010M\u001a\u00020\u00152\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\tHÖ\u0001J\t\u0010P\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b-\u0010\u001dR\u0011\u0010.\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u0010\u001dR\u0011\u00100\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0011\u00102\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b3\u0010\u001dR\u0011\u00104\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\u001dR\u0011\u00108\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b9\u0010\u001d¨\u0006R"}, d2 = {"Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "rootfsMode", "Lcom/stepos/stepclaw/runtime/RootfsMode;", "rootfsRoot", "Ljava/io/File;", "gatewayHost", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "gatewayPort", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "healthPath", "installRelativePath", "stateRootRelativePath", "workspaceRelativePath", "extensionsRelativePath", "installedAssetStateRelativePath", "runtimeServiceName", "runtimeStartProperty", "runtimeStartValue", "runtimeStartPropertyType", "forceUpdate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lcom/stepos/stepclaw/runtime/RootfsMode;Ljava/io/File;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getRootfsMode", "()Lcom/stepos/stepclaw/runtime/RootfsMode;", "getRootfsRoot", "()Ljava/io/File;", "getGatewayHost", "()Ljava/lang/String;", "getGatewayPort", "()I", "getHealthPath", "getInstallRelativePath", "getStateRootRelativePath", "getWorkspaceRelativePath", "getExtensionsRelativePath", "getInstalledAssetStateRelativePath", "getRuntimeServiceName", "getRuntimeStartProperty", "getRuntimeStartValue", "getRuntimeStartPropertyType", "getForceUpdate", "()Z", "healthCheckUrl", "getHealthCheckUrl", "configRelativePath", "getConfigRelativePath", "agentRelativePath", "getAgentRelativePath", "authProfilesRelativePath", "getAuthProfilesRelativePath", "modelsRelativePath", "getModelsRelativePath", "nodesRelativePath", "getNodesRelativePath", "devicesRelativePath", "getDevicesRelativePath", "resolveRootfsPath", "relativePath", "isMountedRootfs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OpenClawRuntimeConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_EXTENSIONS_PATH = "root/.openclaw/extensions";
    private static final String DEFAULT_GATEWAY_HOST = "127.0.0.1";
    private static final int DEFAULT_GATEWAY_PORT = 18789;
    private static final String DEFAULT_HEALTH_PATH = "/health";
    private static final String DEFAULT_INSTALLED_ASSET_STATE_PATH = "root/.openclaw/android-installed-versions.json";
    private static final String DEFAULT_INSTALL_PATH = "usr/local/lib/node_modules/openclaw";
    private static final String DEFAULT_RUNTIME_SERVICE_NAME = "openclaw_env";
    private static final String DEFAULT_RUNTIME_START_PROPERTY = "sys.openclaw.env.start";
    private static final String DEFAULT_RUNTIME_START_PROPERTY_TYPE = "ctl_start_prop";
    private static final String DEFAULT_RUNTIME_START_VALUE = "1";
    private static final String DEFAULT_STATE_ROOT = "root/.openclaw";
    private static final String DEFAULT_WORKSPACE_PATH = "root/.openclaw/workspace";
    public static final String MOUNTED_ROOTFS_PATH = "/mnt/openclaw/rootfs";
    private static final String TAG = "OpenClawRuntimeConfig";
    public static final String USER_DATA_SUBDIR = "user-data";
    private final String extensionsRelativePath;
    private final boolean forceUpdate;
    private final String gatewayHost;
    private final int gatewayPort;
    private final String healthPath;
    private final String installRelativePath;
    private final String installedAssetStateRelativePath;
    private final RootfsMode rootfsMode;
    private final File rootfsRoot;
    private final String runtimeServiceName;
    private final String runtimeStartProperty;
    private final String runtimeStartPropertyType;
    private final String runtimeStartValue;
    private final String stateRootRelativePath;
    private final String workspaceRelativePath;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "MOUNTED_ROOTFS_PATH", "USER_DATA_SUBDIR", "DEFAULT_GATEWAY_HOST", "DEFAULT_GATEWAY_PORT", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DEFAULT_HEALTH_PATH", "DEFAULT_INSTALL_PATH", "DEFAULT_STATE_ROOT", "DEFAULT_WORKSPACE_PATH", "DEFAULT_EXTENSIONS_PATH", "DEFAULT_INSTALLED_ASSET_STATE_PATH", "DEFAULT_RUNTIME_SERVICE_NAME", "DEFAULT_RUNTIME_START_PROPERTY", "DEFAULT_RUNTIME_START_VALUE", "DEFAULT_RUNTIME_START_PROPERTY_TYPE", "fromContext", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "context", "Landroid/content/Context;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final OpenClawRuntimeConfig fromContext(Context context) {
            p.e(context, "context");
            File file = new File(OpenClawRuntimeConfig.MOUNTED_ROOTFS_PATH);
            Log.i(OpenClawRuntimeConfig.TAG, "Runtime mode=MOUNTED, rootfs=" + file.getAbsolutePath() + ", forceUpdate=false (debug=false)");
            return new OpenClawRuntimeConfig(RootfsMode.MOUNTED, file, "127.0.0.1", 18789, OpenClawRuntimeConfig.DEFAULT_HEALTH_PATH, OpenClawRuntimeConfig.DEFAULT_INSTALL_PATH, OpenClawRuntimeConfig.DEFAULT_STATE_ROOT, OpenClawRuntimeConfig.DEFAULT_WORKSPACE_PATH, OpenClawRuntimeConfig.DEFAULT_EXTENSIONS_PATH, OpenClawRuntimeConfig.DEFAULT_INSTALLED_ASSET_STATE_PATH, OpenClawRuntimeConfig.DEFAULT_RUNTIME_SERVICE_NAME, OpenClawRuntimeConfig.DEFAULT_RUNTIME_START_PROPERTY, OpenClawRuntimeConfig.DEFAULT_RUNTIME_START_VALUE, OpenClawRuntimeConfig.DEFAULT_RUNTIME_START_PROPERTY_TYPE, false);
        }

        private Companion() {
        }
    }

    public OpenClawRuntimeConfig(RootfsMode rootfsMode, File rootfsRoot, String gatewayHost, int i8, String healthPath, String installRelativePath, String stateRootRelativePath, String workspaceRelativePath, String extensionsRelativePath, String installedAssetStateRelativePath, String runtimeServiceName, String runtimeStartProperty, String runtimeStartValue, String runtimeStartPropertyType, boolean z) {
        p.e(rootfsMode, "rootfsMode");
        p.e(rootfsRoot, "rootfsRoot");
        p.e(gatewayHost, "gatewayHost");
        p.e(healthPath, "healthPath");
        p.e(installRelativePath, "installRelativePath");
        p.e(stateRootRelativePath, "stateRootRelativePath");
        p.e(workspaceRelativePath, "workspaceRelativePath");
        p.e(extensionsRelativePath, "extensionsRelativePath");
        p.e(installedAssetStateRelativePath, "installedAssetStateRelativePath");
        p.e(runtimeServiceName, "runtimeServiceName");
        p.e(runtimeStartProperty, "runtimeStartProperty");
        p.e(runtimeStartValue, "runtimeStartValue");
        p.e(runtimeStartPropertyType, "runtimeStartPropertyType");
        this.rootfsMode = rootfsMode;
        this.rootfsRoot = rootfsRoot;
        this.gatewayHost = gatewayHost;
        this.gatewayPort = i8;
        this.healthPath = healthPath;
        this.installRelativePath = installRelativePath;
        this.stateRootRelativePath = stateRootRelativePath;
        this.workspaceRelativePath = workspaceRelativePath;
        this.extensionsRelativePath = extensionsRelativePath;
        this.installedAssetStateRelativePath = installedAssetStateRelativePath;
        this.runtimeServiceName = runtimeServiceName;
        this.runtimeStartProperty = runtimeStartProperty;
        this.runtimeStartValue = runtimeStartValue;
        this.runtimeStartPropertyType = runtimeStartPropertyType;
        this.forceUpdate = z;
    }

    /* renamed from: component1, reason: from getter */
    public final RootfsMode getRootfsMode() {
        return this.rootfsMode;
    }

    /* renamed from: component10, reason: from getter */
    public final String getInstalledAssetStateRelativePath() {
        return this.installedAssetStateRelativePath;
    }

    /* renamed from: component11, reason: from getter */
    public final String getRuntimeServiceName() {
        return this.runtimeServiceName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getRuntimeStartProperty() {
        return this.runtimeStartProperty;
    }

    /* renamed from: component13, reason: from getter */
    public final String getRuntimeStartValue() {
        return this.runtimeStartValue;
    }

    /* renamed from: component14, reason: from getter */
    public final String getRuntimeStartPropertyType() {
        return this.runtimeStartPropertyType;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    /* renamed from: component2, reason: from getter */
    public final File getRootfsRoot() {
        return this.rootfsRoot;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGatewayHost() {
        return this.gatewayHost;
    }

    /* renamed from: component4, reason: from getter */
    public final int getGatewayPort() {
        return this.gatewayPort;
    }

    /* renamed from: component5, reason: from getter */
    public final String getHealthPath() {
        return this.healthPath;
    }

    /* renamed from: component6, reason: from getter */
    public final String getInstallRelativePath() {
        return this.installRelativePath;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStateRootRelativePath() {
        return this.stateRootRelativePath;
    }

    /* renamed from: component8, reason: from getter */
    public final String getWorkspaceRelativePath() {
        return this.workspaceRelativePath;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExtensionsRelativePath() {
        return this.extensionsRelativePath;
    }

    public final OpenClawRuntimeConfig copy(RootfsMode rootfsMode, File rootfsRoot, String gatewayHost, int gatewayPort, String healthPath, String installRelativePath, String stateRootRelativePath, String workspaceRelativePath, String extensionsRelativePath, String installedAssetStateRelativePath, String runtimeServiceName, String runtimeStartProperty, String runtimeStartValue, String runtimeStartPropertyType, boolean forceUpdate) {
        p.e(rootfsMode, "rootfsMode");
        p.e(rootfsRoot, "rootfsRoot");
        p.e(gatewayHost, "gatewayHost");
        p.e(healthPath, "healthPath");
        p.e(installRelativePath, "installRelativePath");
        p.e(stateRootRelativePath, "stateRootRelativePath");
        p.e(workspaceRelativePath, "workspaceRelativePath");
        p.e(extensionsRelativePath, "extensionsRelativePath");
        p.e(installedAssetStateRelativePath, "installedAssetStateRelativePath");
        p.e(runtimeServiceName, "runtimeServiceName");
        p.e(runtimeStartProperty, "runtimeStartProperty");
        p.e(runtimeStartValue, "runtimeStartValue");
        p.e(runtimeStartPropertyType, "runtimeStartPropertyType");
        return new OpenClawRuntimeConfig(rootfsMode, rootfsRoot, gatewayHost, gatewayPort, healthPath, installRelativePath, stateRootRelativePath, workspaceRelativePath, extensionsRelativePath, installedAssetStateRelativePath, runtimeServiceName, runtimeStartProperty, runtimeStartValue, runtimeStartPropertyType, forceUpdate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenClawRuntimeConfig)) {
            return false;
        }
        OpenClawRuntimeConfig openClawRuntimeConfig = (OpenClawRuntimeConfig) other;
        return this.rootfsMode == openClawRuntimeConfig.rootfsMode && p.a(this.rootfsRoot, openClawRuntimeConfig.rootfsRoot) && p.a(this.gatewayHost, openClawRuntimeConfig.gatewayHost) && this.gatewayPort == openClawRuntimeConfig.gatewayPort && p.a(this.healthPath, openClawRuntimeConfig.healthPath) && p.a(this.installRelativePath, openClawRuntimeConfig.installRelativePath) && p.a(this.stateRootRelativePath, openClawRuntimeConfig.stateRootRelativePath) && p.a(this.workspaceRelativePath, openClawRuntimeConfig.workspaceRelativePath) && p.a(this.extensionsRelativePath, openClawRuntimeConfig.extensionsRelativePath) && p.a(this.installedAssetStateRelativePath, openClawRuntimeConfig.installedAssetStateRelativePath) && p.a(this.runtimeServiceName, openClawRuntimeConfig.runtimeServiceName) && p.a(this.runtimeStartProperty, openClawRuntimeConfig.runtimeStartProperty) && p.a(this.runtimeStartValue, openClawRuntimeConfig.runtimeStartValue) && p.a(this.runtimeStartPropertyType, openClawRuntimeConfig.runtimeStartPropertyType) && this.forceUpdate == openClawRuntimeConfig.forceUpdate;
    }

    public final String getAgentRelativePath() {
        return b.n(this.stateRootRelativePath, "/agents/main/agent");
    }

    public final String getAuthProfilesRelativePath() {
        return b.n(getAgentRelativePath(), "/auth-profiles.json");
    }

    public final String getConfigRelativePath() {
        return b.n(this.stateRootRelativePath, "/openclaw.json");
    }

    public final String getDevicesRelativePath() {
        return b.n(this.stateRootRelativePath, "/devices");
    }

    public final String getExtensionsRelativePath() {
        return this.extensionsRelativePath;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final String getGatewayHost() {
        return this.gatewayHost;
    }

    public final int getGatewayPort() {
        return this.gatewayPort;
    }

    public final String getHealthCheckUrl() {
        return "http://" + this.gatewayHost + ":" + this.gatewayPort + this.healthPath;
    }

    public final String getHealthPath() {
        return this.healthPath;
    }

    public final String getInstallRelativePath() {
        return this.installRelativePath;
    }

    public final String getInstalledAssetStateRelativePath() {
        return this.installedAssetStateRelativePath;
    }

    public final String getModelsRelativePath() {
        return b.n(getAgentRelativePath(), "/models.json");
    }

    public final String getNodesRelativePath() {
        return b.n(this.stateRootRelativePath, "/nodes");
    }

    public final RootfsMode getRootfsMode() {
        return this.rootfsMode;
    }

    public final File getRootfsRoot() {
        return this.rootfsRoot;
    }

    public final String getRuntimeServiceName() {
        return this.runtimeServiceName;
    }

    public final String getRuntimeStartProperty() {
        return this.runtimeStartProperty;
    }

    public final String getRuntimeStartPropertyType() {
        return this.runtimeStartPropertyType;
    }

    public final String getRuntimeStartValue() {
        return this.runtimeStartValue;
    }

    public final String getStateRootRelativePath() {
        return this.stateRootRelativePath;
    }

    public final String getWorkspaceRelativePath() {
        return this.workspaceRelativePath;
    }

    public int hashCode() {
        return Boolean.hashCode(this.forceUpdate) + b.f(b.f(b.f(b.f(b.f(b.f(b.f(b.f(b.f(b.f(b.C(this.gatewayPort, b.f((this.rootfsRoot.hashCode() + (this.rootfsMode.hashCode() * 31)) * 31, 31, this.gatewayHost), 31), 31, this.healthPath), 31, this.installRelativePath), 31, this.stateRootRelativePath), 31, this.workspaceRelativePath), 31, this.extensionsRelativePath), 31, this.installedAssetStateRelativePath), 31, this.runtimeServiceName), 31, this.runtimeStartProperty), 31, this.runtimeStartValue), 31, this.runtimeStartPropertyType);
    }

    public final boolean isMountedRootfs() {
        return true;
    }

    public final File resolveRootfsPath(String relativePath) {
        p.e(relativePath, "relativePath");
        File canonicalFile = new File(this.rootfsRoot, n.B1(u.Z0(relativePath, AbstractJsonLexerKt.STRING_ESC, '/'), "/")).getCanonicalFile();
        File canonicalFile2 = this.rootfsRoot.getCanonicalFile();
        if (!p.a(canonicalFile, canonicalFile2)) {
            String path = canonicalFile.getPath();
            p.d(path, "getPath(...)");
            if (!u.c1(path, canonicalFile2.getPath() + File.separator, false)) {
                throw new IllegalArgumentException("Rootfs path escapes mounted root: ".concat(relativePath));
            }
        }
        p.b(canonicalFile);
        return canonicalFile;
    }

    public String toString() {
        RootfsMode rootfsMode = this.rootfsMode;
        File file = this.rootfsRoot;
        String str = this.gatewayHost;
        int i8 = this.gatewayPort;
        String str2 = this.healthPath;
        String str3 = this.installRelativePath;
        String str4 = this.stateRootRelativePath;
        String str5 = this.workspaceRelativePath;
        String str6 = this.extensionsRelativePath;
        String str7 = this.installedAssetStateRelativePath;
        String str8 = this.runtimeServiceName;
        String str9 = this.runtimeStartProperty;
        String str10 = this.runtimeStartValue;
        String str11 = this.runtimeStartPropertyType;
        boolean z = this.forceUpdate;
        StringBuilder sb = new StringBuilder("OpenClawRuntimeConfig(rootfsMode=");
        sb.append(rootfsMode);
        sb.append(", rootfsRoot=");
        sb.append(file);
        sb.append(", gatewayHost=");
        sb.append(str);
        sb.append(", gatewayPort=");
        sb.append(i8);
        sb.append(", healthPath=");
        b.A(sb, str2, ", installRelativePath=", str3, ", stateRootRelativePath=");
        b.A(sb, str4, ", workspaceRelativePath=", str5, ", extensionsRelativePath=");
        b.A(sb, str6, ", installedAssetStateRelativePath=", str7, ", runtimeServiceName=");
        b.A(sb, str8, ", runtimeStartProperty=", str9, ", runtimeStartValue=");
        b.A(sb, str10, ", runtimeStartPropertyType=", str11, ", forceUpdate=");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ OpenClawRuntimeConfig(RootfsMode rootfsMode, File file, String str, int i8, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, int i9, i iVar) {
        this(rootfsMode, file, str, i8, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, (i9 & ReaderJsonLexerKt.BATCH_SIZE) != 0 ? false : z);
    }
}
