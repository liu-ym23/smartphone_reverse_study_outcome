package com.android.server.wm;

import android.content.res.Configuration;
import android.pico.utils.IExtBase;
import android.view.SurfaceControl;
import com.android.internal.util.ToBooleanFunction;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowContainer extends IExtBase {
    boolean forAllWindows(ToBooleanFunction<WindowState> r1, boolean r2);

    Task getTransitionTask();

    boolean isContainerAllDrawn();

    boolean isContainerWaitingForAllDrawn();

    void setContainerWaitingForAllDrawn(boolean r1);

    default void traceStartTrace(SurfaceControl.Transaction transaction, String tag) {
    }

    default void traceEndTrace(SurfaceControl.Transaction transaction) {
    }

    default void updateResolvedOverrideConfiguration(Configuration configuration) {
    }
}
