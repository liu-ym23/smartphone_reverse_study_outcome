package com.android.server.power;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswPowerGroup {

    public interface Listener {
        void onDirtyChangeLocked(int r1, boolean r2);
    }

    void dozeLocked(int r1);

    boolean enterFakeSleep(int r1);

    void exitFakeSleep();

    void noteScreenState(int r1);

    void registerListener(Listener r1);

    void wakeUpLocked(int r1, int r2, String r3);
}
