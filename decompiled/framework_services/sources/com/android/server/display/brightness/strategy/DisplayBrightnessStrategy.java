package com.android.server.display.brightness.strategy;

import com.android.server.display.DisplayBrightnessState;
import com.android.server.display.brightness.StrategyExecutionRequest;
import com.android.server.display.brightness.StrategySelectionNotifyRequest;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface DisplayBrightnessStrategy {
    void dump(PrintWriter r1);

    String getName();

    int getReason();

    void strategySelectionPostProcessor(StrategySelectionNotifyRequest r1);

    DisplayBrightnessState updateBrightness(StrategyExecutionRequest r1);
}
