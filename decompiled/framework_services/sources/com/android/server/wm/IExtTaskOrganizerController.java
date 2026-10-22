package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.window.StartingWindowRemovalInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTaskOrganizerController extends IExtBase {
    boolean deferStartingWindowRemove(ActivityRecord r1, StartingWindowRemovalInfo r2);
}
