package com.bytedance.android.accessibilityLib_Core.config.remote.repo;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/repo/ConfigFileProviderMode;", "", AccountType.LOCAL, "REMOTE_RELEASE", "REMOTE_DEVELOP", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum ConfigFileProviderMode extends Enum<ConfigFileProviderMode> {
    public static final ConfigFileProviderMode LOCAL = null;
    public static final ConfigFileProviderMode REMOTE_DEVELOP = null;
    public static final ConfigFileProviderMode REMOTE_RELEASE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConfigFileProviderMode[] f38212a = null;

    static {
        ConfigFileProviderMode r100 = new ConfigFileProviderMode(AccountType.LOCAL, 0);
        LOCAL = r100;
        ConfigFileProviderMode r101 = new ConfigFileProviderMode("REMOTE_RELEASE", 1);
        REMOTE_RELEASE = r101;
        ConfigFileProviderMode r102 = new ConfigFileProviderMode("REMOTE_DEVELOP", 2);
        REMOTE_DEVELOP = r102;
        f38212a = new ConfigFileProviderMode[]{r100, r101, r102};
    }

    public static ConfigFileProviderMode valueOf(String r100) {
        return (ConfigFileProviderMode) a.a(ConfigFileProviderMode.class, r100);
    }

    public static ConfigFileProviderMode[] values() {
        return (ConfigFileProviderMode[]) f38212a.clone();
    }

    public ConfigFileProviderMode(String r100, int r101) {
        super(r100, r101);
    }
}
