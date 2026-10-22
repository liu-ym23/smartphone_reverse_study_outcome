package com.android.server.signedconfig;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class GlobalSettingsConfigApplicator {
    private static final Set<String> ALLOWED_KEYS = null;
    private static final Map<String, String> HIDDEN_API_POLICY_KEY_MAP = null;
    private static final Map<String, Map<String, String>> KEY_VALUE_MAPPERS = null;
    private static final String TAG = "SignedConfig";
    private final Context mContext;
    private final SignedConfigEvent mEvent;
    private final String mSourcePackage;
    private final SignatureVerifier mVerifier;

    static {
        ALLOWED_KEYS = Collections.unmodifiableSet(new ArraySet(Arrays.asList(new String[]{"hidden_api_policy", "hidden_api_blacklist_exemptions"})));
        HIDDEN_API_POLICY_KEY_MAP = makeMap(new Object[]{"DEFAULT", String.valueOf(-1), "DISABLED", String.valueOf(0), "JUST_WARN", String.valueOf(1), "ENABLED", String.valueOf(2)});
        KEY_VALUE_MAPPERS = makeMap(new Object[]{"hidden_api_policy", HIDDEN_API_POLICY_KEY_MAP});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> Map<K, V> makeMap(Object... keyValuePairs) {
        if ((keyValuePairs.length % 2) != 0) goto L10;
        int len = keyValuePairs.length / 2;
        ArrayMap r1 = new ArrayMap(len);
        int i = 0;
    L5:
        if (i >= len) goto L8;
        r1.put(keyValuePairs[i * 2], keyValuePairs[(i * 2) + 1]);
        i = i + 1;
        goto L5
    L8:
        return Collections.unmodifiableMap(r1);
    L10:
        throw new IllegalArgumentException();
    }

    GlobalSettingsConfigApplicator(Context context, String sourcePackage, SignedConfigEvent event) {
        this.mContext = context;
        this.mSourcePackage = sourcePackage;
        this.mEvent = event;
        this.mVerifier = new SignatureVerifier(this.mEvent);
    }

    private boolean checkSignature(String data, String signature) {
        return this.mVerifier.verifySignature(data, signature);
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to verify signature", e);
        this.mEvent.status = 4;
        return false;
    }

    private int getCurrentConfigVersion() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "signed_config_version", 0);
    }

    private void updateCurrentConfig(int version, Map<String, String> values) {
        Iterator<Map.Entry<String, String>> r0 = values.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> e = r0.next();
        Settings.Global.putString(this.mContext.getContentResolver(), e.getKey(), e.getValue());
        goto L4
    L6:
        Settings.Global.putInt(this.mContext.getContentResolver(), "signed_config_version", version);
    }

    void applyConfig(String configStr, String signature) {
        if (checkSignature(configStr, signature) == true) goto L20;
        Slog.e(TAG, "Signature check on global settings in package " + this.mSourcePackage + " failed; ignoring");
        return;
    L20:
        SignedConfig config = SignedConfig.parse(configStr, ALLOWED_KEYS, KEY_VALUE_MAPPERS);     // Catch: InvalidConfigException -> L17
        this.mEvent.version = config.version;     // Catch: InvalidConfigException -> L17
        int currentVersion = getCurrentConfigVersion();
        if (currentVersion < config.version) goto L11;
        Slog.i(TAG, "Global settings from package " + this.mSourcePackage + " is older than existing: " + config.version + "<=" + currentVersion);
        this.mEvent.status = 6;
        return;
    L11:
        Slog.i(TAG, "Got new global settings from package " + this.mSourcePackage + ": version " + config.version + " replacing existing version " + currentVersion);
        SignedConfig.PerSdkConfig matchedConfig = config.getMatchingConfig(Build.VERSION.SDK_INT);
        if (matchedConfig != null) goto L15;
        Slog.i(TAG, "Settings is not applicable to current SDK version; ignoring");
        this.mEvent.status = 8;
        return;
    L15:
        Slog.i(TAG, "Updating global settings to version " + config.version);
        updateCurrentConfig(config.version, matchedConfig.values);
        this.mEvent.status = 1;
        return;
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to parse global settings from package " + this.mSourcePackage, e);
        this.mEvent.status = 5;
    }
}
