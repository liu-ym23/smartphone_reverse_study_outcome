package com.bytedance.android.live.effect.beauty.presets;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f67478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f67479b = null;

    static {
        int[] r100 = new int[PresetOperationType.values().length];
        f67478a = r100;
        PresetOperationType r101 = PresetOperationType.INIT;
        r100[r101.ordinal()] = 1;
        PresetOperationType r102 = PresetOperationType.ADD_PRESET;
        r100[r102.ordinal()] = 2;
        PresetOperationType r103 = PresetOperationType.DELETE_PRESET;
        r100[r103.ordinal()] = 3;
        PresetOperationType r104 = PresetOperationType.RENAME_PRESET;
        r100[r104.ordinal()] = 4;
        PresetOperationType r105 = PresetOperationType.SELECT_PRESET;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[PresetOperationType.values().length];
        f67479b = r106;
        r106[r102.ordinal()] = 1;
        r106[r101.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        r106[PresetOperationType.EDIT_MODE.ordinal()] = 6;
    }
}
