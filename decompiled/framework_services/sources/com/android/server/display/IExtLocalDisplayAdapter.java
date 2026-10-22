package com.android.server.display;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtLocalDisplayAdapter extends IExtBase {
    void setDisplayBrightness(long r1, float r3, float r4, float r5, float r6, float r7, float r8);

    void setDisplayState(long r1, int r3, int r4);

    default boolean setDisplayBrightnessState(long physicalDisplayId, int oldState, int state, float brightnessState, float sdrBrightnessState) {
        return false;
    }
}
