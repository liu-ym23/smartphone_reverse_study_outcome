package com.android.server.display;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtDisplayPowerState extends IExtBase {
    default void init(int displayId) {
    }

    default void setScreenState(int state, int reason) {
    }

    default void setColorFadeLevel(float level) {
    }

    default void screenUpdateRunnable(int state, float colorFadeLevel, float brightnessState, float sdrBrightnessState, int aodLevel) {
    }
}
