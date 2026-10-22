package com.bytedance.android.accessibilityLib_Core.report;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public final class AccessibilityLibReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38309a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/report/AccessibilityLibReport$ConfigType;", "", "local", "dynamic", "xml", "remote", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
    public static final enum ConfigType extends Enum<ConfigType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConfigType[] f38310a = null;
        public static final ConfigType dynamic = null;
        public static final ConfigType local = null;
        public static final ConfigType remote = null;
        public static final ConfigType xml = null;

        static {
            ConfigType r100 = new ConfigType("local", 0);
            local = r100;
            ConfigType r101 = new ConfigType("dynamic", 1);
            dynamic = r101;
            ConfigType r102 = new ConfigType("xml", 2);
            xml = r102;
            ConfigType r103 = new ConfigType("remote", 3);
            remote = r103;
            f38310a = new ConfigType[]{r100, r101, r102, r103};
        }

        public static ConfigType valueOf(String r100) {
            return (ConfigType) a.a(ConfigType.class, r100);
        }

        public static ConfigType[] values() {
            return (ConfigType[]) f38310a.clone();
        }

        public ConfigType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
