package com.android.server.scene;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface SysInfoChangedListener {
    void noteConfigruarationChanged(Configuration r1);

    void noteScreenStateChanged(int r1);

    void notifySettingsStatusChanged(int r1, int r2);

    void onKeyGuardGoingAway();
}
