package com.bytedance.android.service.manager.alliance;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes12.dex */
public interface ICommonInstrumentation {
    IBinder getBinder();

    int getStartInstrumentationFlag();

    void initInstrumentation();

    boolean startInstrumentation(ComponentName r100, Bundle r101);

    boolean startInstrumentation(ComponentName r100, Bundle r101, int r102);
}
