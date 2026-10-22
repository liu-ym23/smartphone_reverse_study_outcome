package com.android.server.display.brightness.strategy;

import android.pico.utils.IExtBase;
import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.StrategyExecutionRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtTemporaryBrightnessStrategy extends IExtBase {
    DisplayBrightnessState updateBrightness(StrategyExecutionRequest r1);
}
