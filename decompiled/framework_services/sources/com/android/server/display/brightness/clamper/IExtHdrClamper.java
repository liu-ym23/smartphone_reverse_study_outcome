package com.android.server.display.brightness.clamper;

import android.pico.utils.IExtBase;
import com.android.server.display.config.HdrBrightnessData;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtHdrClamper extends IExtBase {
    float getHdrExitTransitionRate(HdrBrightnessData r1);

    float getTransitionRate(HdrBrightnessData r1);
}
