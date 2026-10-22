package com.bumptech.glide;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum Priority extends Enum<Priority> {
    private static final /* synthetic */ Priority[] $VALUES = null;
    public static final Priority HIGH = null;
    public static final Priority IMMEDIATE = null;
    public static final Priority LOW = null;
    public static final Priority NORMAL = null;

    static {
        Priority r100 = new Priority("IMMEDIATE", 0);
        IMMEDIATE = r100;
        Priority r101 = new Priority("HIGH", 1);
        HIGH = r101;
        Priority r102 = new Priority(EffectConstants.NORMAL, 2);
        NORMAL = r102;
        Priority r103 = new Priority("LOW", 3);
        LOW = r103;
        $VALUES = new Priority[]{r100, r101, r102, r103};
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }

    public static Priority valueOf(String r100) {
        return (Priority) a.a(Priority.class, r100);
    }

    private Priority(String r100, int r101) {
        super(r100, r101);
    }
}
