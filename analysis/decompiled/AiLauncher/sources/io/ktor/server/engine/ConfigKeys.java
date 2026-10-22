package io.ktor.server.engine;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/ktor/server/engine/ConfigKeys;", "", "<init>", "()V", "", "applicationIdPath", "Ljava/lang/String;", "hostConfigPath", "hostPortPath", "hostWatchPaths", "rootPathPath", "hostSslPortPath", "hostSslKeyStore", "hostSslKeyAlias", "hostSslKeyStorePassword", "hostSslPrivateKeyPassword", "developmentModeKey", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigKeys {
    public static final ConfigKeys INSTANCE = new ConfigKeys();
    public static final String applicationIdPath = "ktor.application.id";
    public static final String developmentModeKey = "ktor.development";
    public static final String hostConfigPath = "ktor.deployment.host";
    public static final String hostPortPath = "ktor.deployment.port";
    public static final String hostSslKeyAlias = "ktor.security.ssl.keyAlias";
    public static final String hostSslKeyStore = "ktor.security.ssl.keyStore";
    public static final String hostSslKeyStorePassword = "ktor.security.ssl.keyStorePassword";
    public static final String hostSslPortPath = "ktor.deployment.sslPort";
    public static final String hostSslPrivateKeyPassword = "ktor.security.ssl.privateKeyPassword";
    public static final String hostWatchPaths = "ktor.deployment.watch";
    public static final String rootPathPath = "ktor.deployment.rootPath";

    private ConfigKeys() {
    }
}
