package com.android.server.power.stats;

/* JADX INFO: loaded from: classes3.dex */
public interface IBatteryStatsImplSmtEx {

    public interface IUidSmtEx {
        default BatteryStatsImpl.Timer getCameraTurnedOnBackgroundTimer() {
            return null;
        }

        default BatteryStatsImpl.Timer getAudioTurnedOnBackgroundTimer() {
            return null;
        }

        default BatteryStatsImpl.Timer getVideoTurnedOnBackgroundTimer() {
            return null;
        }

        default long getMobileRadioApBgWakeupCount(int which) {
            return 0;
        }

        default long getWifiRadioApBgWakeupCount(int which) {
            return 0;
        }

        default long getMobileRadioActiveBgTime(int which) {
            return 0;
        }
    }
}
