package com.bef.effectsdk;

/* JADX INFO: loaded from: classes39.dex */
public class ModelnamesAssigner {
    private ModelnamesAssigner() {
    }

    private static native int nativeSetAssignedModelNames(long r100, String[] r101, String[] r102);

    private static native int nativeSetAssignedModelNamesWithPriority(long r100, String[] r101, String[] r102, int[] r103);

    public static int setAssignedModelNames(long r100, String[] r101, String[] r102) {
        return nativeSetAssignedModelNames(r100, r101, r102);
    }

    public static int setAssignedModelNamesWithPriority(long r100, String[] r101, String[] r102, int[] r103) {
        return nativeSetAssignedModelNamesWithPriority(r100, r101, r102, r103);
    }
}
