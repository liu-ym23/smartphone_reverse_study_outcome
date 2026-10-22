package com.obric.autogui.common.api.platform.packages.appinfo;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.o;

/* JADX INFO: compiled from: OpenableAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OpenableAppInfo {
    private final String appLabel;
    private final String appPackageName;
    private final String appSign;
    private final OpenableAppType type;

    /* JADX INFO: compiled from: OpenableAppInfo.kt */
    public static final enum OpenableAppType extends Enum<OpenableAppType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ OpenableAppType[] $VALUES = null;
        public static final OpenableAppType AppName = null;
        public static final OpenableAppType LauncherEntry = null;
        public static final OpenableAppType LauncherShortcut = null;

        private static final /* synthetic */ OpenableAppType[] $values() {
            return new OpenableAppType[]{AppName, LauncherEntry, LauncherShortcut};
        }

        public static a<OpenableAppType> getEntries() {
            return $ENTRIES;
        }

        private OpenableAppType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            AppName = new OpenableAppType("AppName", 0);
            LauncherEntry = new OpenableAppType("LauncherEntry", 1);
            LauncherShortcut = new OpenableAppType("LauncherShortcut", 2);
            OpenableAppType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static OpenableAppType valueOf(String r2) {
            return (OpenableAppType) ZeusTransformUtils.preCheckCast(Enum.valueOf(OpenableAppType.class, r2), OpenableAppType.class, "com.obric.aiagent.plugin");
        }

        public static OpenableAppType[] values() {
            return (OpenableAppType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OpenableAppType[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ OpenableAppInfo copy$default(OpenableAppInfo r0, String r1, String r2, String r3, OpenableAppType r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.appLabel;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.appPackageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.appSign;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.type;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.appLabel;
    }

    public final String component2() {
        return this.appPackageName;
    }

    public final String component3() {
        return this.appSign;
    }

    public final OpenableAppType component4() {
        return this.type;
    }

    public final OpenableAppInfo copy(String r1, String r2, String r3, OpenableAppType r4) {
        o.e(r1, "appLabel");
        o.e(r2, "appPackageName");
        o.e(r4, "type");
        return new OpenableAppInfo(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OpenableAppInfo.class) == true) goto L8;
        return false;
    L8:
        OpenableAppInfo r6 = (OpenableAppInfo) ZeusTransformUtils.preCheckCast(r5, OpenableAppInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.appLabel, r6.appLabel) == true) goto L12;
        return false;
    L12:
        if (o.a(this.appPackageName, r6.appPackageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.appSign, r6.appSign) == true) goto L18;
        return false;
    L18:
        if (this.type == r6.type) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.appLabel.hashCode() * 31) + this.appPackageName.hashCode()) * 31;
        String r1 = this.appSign;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.type.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenableAppInfo(appLabel=" + this.appLabel + ", appPackageName=" + this.appPackageName + ", appSign=" + this.appSign + ", type=" + this.type + ')';
    }

    public OpenableAppInfo(String r2, String r3, String r4, OpenableAppType r5) {
        o.e(r2, "appLabel");
        o.e(r3, "appPackageName");
        o.e(r5, "type");
        this.appLabel = r2;
        this.appPackageName = r3;
        this.appSign = r4;
        this.type = r5;
    }

    public final String getAppLabel() {
        return this.appLabel;
    }

    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final String getAppSign() {
        return this.appSign;
    }

    public final OpenableAppType getType() {
        return this.type;
    }
}
