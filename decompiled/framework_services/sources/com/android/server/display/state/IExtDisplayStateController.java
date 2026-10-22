package com.android.server.display.state;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.IExtBase;
import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayStateController extends IExtBase {
    Pair<Integer, Integer> updateDisplayState(DisplayManagerInternal.DisplayPowerRequest r1, int r2, boolean r3, boolean r4, int r5, int r6);
}
