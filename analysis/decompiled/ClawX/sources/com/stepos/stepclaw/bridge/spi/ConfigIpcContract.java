package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/ConfigIpcContract;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "AUTHORITY_SUFFIX", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "CONFIG_SERVICE_NAME", "METHOD_READ_CONFIG", "METHOD_READ_MODEL_PRESETS", "METHOD_SAVE_CONFIG", "KEY_API_KEY", "KEY_MODEL", "KEY_PROVIDER", "KEY_BASE_URL", "KEY_PORT", "KEY_IMAGE_INPUT", "KEY_API_FORMAT", "KEY_MODEL_PRESETS", "KEY_OK", "KEY_ERROR_MESSAGE", "authorityFor", "packageName", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConfigIpcContract {
    public static final String AUTHORITY_SUFFIX = ".PERF_BINDER_IPC_CALL";
    public static final String CONFIG_SERVICE_NAME = "com.stepos.stepclaw.runtime.config.ConfigService";
    public static final ConfigIpcContract INSTANCE = new ConfigIpcContract();
    public static final String KEY_API_FORMAT = "api";
    public static final String KEY_API_KEY = "apiKey";
    public static final String KEY_BASE_URL = "baseUrl";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_IMAGE_INPUT = "imageInput";
    public static final String KEY_MODEL = "model";
    public static final String KEY_MODEL_PRESETS = "modelPresets";
    public static final String KEY_OK = "ok";
    public static final String KEY_PORT = "port";
    public static final String KEY_PROVIDER = "provider";
    public static final String METHOD_READ_CONFIG = "readConfig";
    public static final String METHOD_READ_MODEL_PRESETS = "readModelPresets";
    public static final String METHOD_SAVE_CONFIG = "saveConfig";

    private ConfigIpcContract() {
    }

    public final String authorityFor(String packageName) {
        p.e(packageName, "packageName");
        return packageName.concat(AUTHORITY_SUFFIX);
    }
}
