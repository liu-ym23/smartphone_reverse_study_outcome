package com.android.server.accessibility;

import android.os.Handler;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
public interface IObricAccessibilityManagerService extends IObricBase {
    void clearFrequencyLimit(AbstractAccessibilityServiceConnection r1);

    void handleClientAdded(AccessibilityManagerService.Client r1, Handler r2);

    void setMinumumIntervalObric(String r1, int r2, int r3, AbstractAccessibilityServiceConnection r4);
}
