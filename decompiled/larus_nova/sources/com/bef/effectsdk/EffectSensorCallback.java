package com.bef.effectsdk;

/* JADX INFO: loaded from: classes3.dex */
public class EffectSensorCallback {
    private static GetSensorInfo sGetSensorInfo;

    /* JADX INFO: loaded from: classes39.dex */
    public interface GetSensorInfo {
        boolean onRegister(int r100, int r101);

        boolean onSetRate(int r100, int r101);

        boolean onUnregister(int r100);
    }

    public EffectSensorCallback() {
    }

    public static void setSensorInfoCallback(GetSensorInfo r100) {
        sGetSensorInfo = r100;
    }

    private static boolean unregisterStr(int r100) {
        GetSensorInfo r101 = sGetSensorInfo;
        if (r101 != null) goto L7;
        return true;
    L7:
        return r101.onUnregister(r100);
    }

    private static boolean registerStr(int r100, int r101) {
        GetSensorInfo r102 = sGetSensorInfo;
        if (r102 != null) goto L7;
        return true;
    L7:
        return r102.onRegister(r100, r101);
    }

    private static boolean setRateStr(int r100, int r101) {
        GetSensorInfo r102 = sGetSensorInfo;
        if (r102 != null) goto L7;
        return true;
    L7:
        return r102.onSetRate(r100, r101);
    }
}
