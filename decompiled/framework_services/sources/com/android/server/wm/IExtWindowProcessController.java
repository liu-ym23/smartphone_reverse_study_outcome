package com.android.server.wm;

import android.pico.utils.IExtBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowProcessController extends IExtBase {
    default void traceHandleAppDied(WindowProcessController wpc, ArrayList<ActivityRecord> activities) {
    }
}
