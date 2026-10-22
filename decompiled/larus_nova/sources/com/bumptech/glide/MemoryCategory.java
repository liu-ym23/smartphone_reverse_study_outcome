package com.bumptech.glide;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum MemoryCategory extends Enum<MemoryCategory> {
    private static final /* synthetic */ MemoryCategory[] $VALUES = null;
    public static final MemoryCategory HIGH = null;
    public static final MemoryCategory LOW = null;
    public static final MemoryCategory NORMAL = null;
    private final float multiplier;

    static {
        MemoryCategory r100 = new MemoryCategory("LOW", 0, 0.5f);
        LOW = r100;
        MemoryCategory r101 = new MemoryCategory(EffectConstants.NORMAL, 1, 1.0f);
        NORMAL = r101;
        MemoryCategory r102 = new MemoryCategory("HIGH", 2, 1.5f);
        HIGH = r102;
        $VALUES = new MemoryCategory[]{r100, r101, r102};
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[]) $VALUES.clone();
    }

    public float getMultiplier() {
        return this.multiplier;
    }

    public static MemoryCategory valueOf(String r100) {
        return (MemoryCategory) a.a(MemoryCategory.class, r100);
    }

    private MemoryCategory(String r100, int r101, float r102) {
        super(r100, r101);
        this.multiplier = r102;
    }
}
