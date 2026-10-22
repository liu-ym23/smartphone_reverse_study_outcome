package com.android.server.wm;

import android.os.Bundle;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import android.window.WindowContainerTransaction;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowOrganizerController extends IExtBase {
    default void onApplyWindowContainerTransaction(int transitionType, WindowContainerTransaction transaction) {
    }

    default void setTransitionRecentsFromRemote(ActivityTaskManagerService service, IBinder transitionToken, boolean forBackOrHome) {
    }

    default boolean startSplitFromRecentsOrLauncherWithoutWaitAsyncStartIfNeeded(Bundle launchOptions, Transition transition, Runnable startActivity) {
        return false;
    }
}
