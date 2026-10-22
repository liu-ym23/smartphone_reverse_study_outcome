package com.alipay.sdk.app;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class EnvUtils {
    public static EnvEnum mEnv;

    public static final enum EnvEnum extends Enum<EnvEnum> {
        public static final /* synthetic */ EnvEnum[] $VALUES = null;
        public static final EnvEnum ONLINE = null;
        public static final EnvEnum PRE_SANDBOX = null;
        public static final EnvEnum SANDBOX = null;

        static {
            EnvEnum r100 = new EnvEnum("ONLINE", 0);
            ONLINE = r100;
            EnvEnum r101 = new EnvEnum("PRE_SANDBOX", 1);
            PRE_SANDBOX = r101;
            EnvEnum r102 = new EnvEnum("SANDBOX", 2);
            SANDBOX = r102;
            $VALUES = new EnvEnum[]{r100, r101, r102};
        }

        public static EnvEnum[] values() {
            return (EnvEnum[]) $VALUES.clone();
        }

        public static EnvEnum valueOf(String r100) {
            return (EnvEnum) a.a(EnvEnum.class, r100);
        }

        public EnvEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        mEnv = EnvEnum.ONLINE;
    }

    public static boolean isNewSanBox() {
        if (mEnv != EnvEnum.SANDBOX) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isPreSandBox() {
        if (mEnv != EnvEnum.PRE_SANDBOX) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSandBox() {
        if (isPreSandBox() == false) goto L5;
    L8:
        return true;
    L5:
        if (isNewSanBox() == true) goto L8;
        return false;
    }

    public EnvUtils() {
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static void setEnv(EnvEnum r100) {
        mEnv = r100;
    }
}
