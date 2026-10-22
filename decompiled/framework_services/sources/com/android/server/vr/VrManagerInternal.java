package com.android.server.vr;

import android.app.Vr2dDisplayProperties;
import android.content.ComponentName;
import android.service.vr.IPersistentVrStateCallbacks;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VrManagerInternal {
    public static final int NO_ERROR = 0;

    public abstract void addPersistentVrModeStateListener(IPersistentVrStateCallbacks r1);

    public abstract int getVr2dDisplayId();

    public abstract int hasVrPackage(ComponentName r1, int r2);

    public abstract boolean isCurrentVrListener(String r1, int r2);

    public abstract void onScreenStateChanged(boolean r1);

    public abstract void setPersistentVrModeEnabled(boolean r1);

    public abstract void setVr2dDisplayProperties(Vr2dDisplayProperties r1);

    public abstract void setVrMode(boolean r1, ComponentName r2, int r3, int r4, ComponentName r5);

    public VrManagerInternal() {
    }
}
