package com.android.server.location.injector;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class SystemLocationPowerSaveModeHelper extends LocationPowerSaveModeHelper implements Consumer<PowerSaveState> {
    private final Context mContext;
    private volatile int mLocationPowerSaveMode;
    private boolean mReady;

    /* JADX INFO: renamed from: $r8$lambda$ic8IvMLJ6vQCSmvs8tXdFedL-KE, reason: not valid java name */
    public static /* synthetic */ void m5378$r8$lambda$ic8IvMLJ6vQCSmvs8tXdFedLKE(SystemLocationPowerSaveModeHelper r0, int r1) {
        r0.lambda$accept$0(r1);
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(PowerSaveState r1) {
        accept2(r1);
    }

    public SystemLocationPowerSaveModeHelper(Context context) {
        this.mContext = context;
    }

    public void onSystemReady() {
        if (this.mReady == false) goto L5;
        return;
    L5:
        ((PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class)).registerLowPowerModeObserver(1, this);
        PowerManager r0 = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        r0.getClass();
        this.mLocationPowerSaveMode = r0.getLocationPowerSaveMode();
        this.mReady = true;
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(PowerSaveState powerSaveState) {
        if (powerSaveState.batterySaverEnabled == true) goto L5;
        final int locationPowerSaveMode = 0;
    L7:
        if (locationPowerSaveMode != this.mLocationPowerSaveMode) goto L9;
        return;
    L9:
        this.mLocationPowerSaveMode = locationPowerSaveMode;
        FgThread.getHandler().post(new SystemLocationPowerSaveModeHelper$$ExternalSyntheticLambda0(this, locationPowerSaveMode));
        return;
    L5:
        locationPowerSaveMode = powerSaveState.locationMode;
        goto L7
    }

    private /* synthetic */ void lambda$accept$0(int locationPowerSaveMode) {
        notifyLocationPowerSaveModeChanged(locationPowerSaveMode);
    }

    @Override // com.android.server.location.injector.LocationPowerSaveModeHelper
    public int getLocationPowerSaveMode() {
        Preconditions.checkState(this.mReady);
        return this.mLocationPowerSaveMode;
    }
}
