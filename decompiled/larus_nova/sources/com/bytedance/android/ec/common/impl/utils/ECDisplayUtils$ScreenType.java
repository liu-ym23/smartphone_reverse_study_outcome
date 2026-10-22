package com.bytedance.android.ec.common.impl.utils;

import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public final enum ECDisplayUtils$ScreenType extends Enum<ECDisplayUtils$ScreenType> {
    public static final ECDisplayUtils$ScreenType FULL_SCREEN = null;
    public static final ECDisplayUtils$ScreenType NORMAL_SCREEN = null;
    public static final ECDisplayUtils$ScreenType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECDisplayUtils$ScreenType[] f43591a = null;

    static {
        ECDisplayUtils$ScreenType r100 = new ECDisplayUtils$ScreenType("FULL_SCREEN", 0);
        FULL_SCREEN = r100;
        ECDisplayUtils$ScreenType r101 = new ECDisplayUtils$ScreenType("NORMAL_SCREEN", 1);
        NORMAL_SCREEN = r101;
        ECDisplayUtils$ScreenType r102 = new ECDisplayUtils$ScreenType("UNKNOWN", 2);
        UNKNOWN = r102;
        f43591a = new ECDisplayUtils$ScreenType[]{r100, r101, r102};
    }

    public static ECDisplayUtils$ScreenType[] values() {
        return (ECDisplayUtils$ScreenType[]) f43591a.clone();
    }

    public static ECDisplayUtils$ScreenType valueOf(String r100) {
        return (ECDisplayUtils$ScreenType) a.a(ECDisplayUtils$ScreenType.class, r100);
    }

    public ECDisplayUtils$ScreenType(String r100, int r101) {
        super(r100, r101);
    }
}
