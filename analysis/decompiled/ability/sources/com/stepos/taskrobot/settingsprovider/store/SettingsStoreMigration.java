package com.stepos.taskrobot.settingsprovider.store;

import H4.o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/store/SettingsStoreMigration;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;", AgentBusWakeContract.EXTRA_SOURCE, TypedValues.AttributesType.S_TARGET, "LC7/r;", "migrateIfNeeded", "(Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;Lcom/stepos/taskrobot/settingsprovider/store/KeyValueStore;)V", "", "KEY_MIGRATED", "Ljava/lang/String;", "", "LEGACY_STRING_KEYS", "Ljava/util/List;", "getLEGACY_STRING_KEYS$settingsprovider_release", "()Ljava/util/List;", "LEGACY_BOOLEAN_KEYS", "getLEGACY_BOOLEAN_KEYS$settingsprovider_release", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsStoreMigration {
    public static final String KEY_MIGRATED = "migrated_from_default_mmkv";
    public static final SettingsStoreMigration INSTANCE = new SettingsStoreMigration();
    private static final List<String> LEGACY_STRING_KEYS = o.N(SettingsConfig.MMKV_KEY_WHITELIST_CACHE, SettingsConfig.MMKV_KEY_WHITELIST_OVERRIDES);
    private static final List<String> LEGACY_BOOLEAN_KEYS = o.N(SettingsConfig.MMKV_KEY_MASTER_SWITCH, "authorization_status");

    private SettingsStoreMigration() {
    }

    public final List<String> getLEGACY_BOOLEAN_KEYS$settingsprovider_release() {
        return LEGACY_BOOLEAN_KEYS;
    }

    public final List<String> getLEGACY_STRING_KEYS$settingsprovider_release() {
        return LEGACY_STRING_KEYS;
    }

    public final void migrateIfNeeded(KeyValueStore source, KeyValueStore target) {
        String string;
        k.f(source, "source");
        k.f(target, "target");
        if (target.getBoolean(KEY_MIGRATED, false)) {
            return;
        }
        for (String str : LEGACY_STRING_KEYS) {
            if (!target.contains(str) && (string = source.getString(str)) != null) {
                target.putString(str, string);
            }
        }
        for (String str2 : LEGACY_BOOLEAN_KEYS) {
            if (!target.contains(str2) && source.contains(str2)) {
                target.putBoolean(str2, source.getBoolean(str2, false));
            }
        }
        target.putBoolean(KEY_MIGRATED, true);
    }
}
