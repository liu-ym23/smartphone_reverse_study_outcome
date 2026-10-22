package com.bytedance.apm.block.evil;

/* JADX INFO: loaded from: classes2.dex */
public class EvilMethodSwitcher {
    public static long getEvilThresholdMs() {
        return 1000;
    }

    public static long getLaunchEvilThresholdMs() {
        return 100;
    }

    public static boolean isLaunchLimitEvilMethodDepth() {
        return false;
    }

    public static boolean isLimitEvilMethodDepth() {
        return false;
    }

    public static boolean isMessageKeyEnable() {
        return false;
    }

    public static boolean isOpenLaunchEvilMethod() {
        return false;
    }

    public EvilMethodSwitcher() {
    }
}
