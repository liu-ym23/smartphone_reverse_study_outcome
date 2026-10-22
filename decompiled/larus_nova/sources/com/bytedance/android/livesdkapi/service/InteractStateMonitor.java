package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.livesdk.app.dataholder.Observer;

/* JADX INFO: loaded from: classes12.dex */
public interface InteractStateMonitor {
    public static final int IDLE = 0;
    public static final int ONLINE = 2;
    public static final int WAITING = 1;

    void addObserver(Observer<Integer> r100);

    int getState();

    Boolean isGuestLinker();

    void removeObserver(Observer<Integer> r100);
}
