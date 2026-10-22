package com.obric.aiagent.product.platform.api.app;

import android.content.Context;

/* JADX INFO: compiled from: IObricActivityTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricActivityTaskManager {
    boolean finishAndRemoveAllTask(Context r1);

    boolean registerActivitySwitchListener(ObricActivitySwitchListener r1);

    boolean registerAppSwitchListener(ObricAppSwitchListener r1);

    boolean registerFocusListener(ObricFocusListener r1);

    boolean registerSystemAnimationListener(ObricSystemAnimationListener r1);

    boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1);

    boolean unregisterAppSwitchListener(ObricAppSwitchListener r1);

    boolean unregisterFocusListener(ObricFocusListener r1);

    boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1);
}
