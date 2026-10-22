package com.bytedance.android.service.manager.alliance;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes12.dex */
public class ICommonInstrumentationImplOfMock implements ICommonInstrumentation {
    public ICommonInstrumentationImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public IBinder getBinder() {
        return null;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public int getStartInstrumentationFlag() {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public void initInstrumentation() {
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public boolean startInstrumentation(ComponentName r100, Bundle r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.ICommonInstrumentation
    public boolean startInstrumentation(ComponentName r100, Bundle r101, int r102) {
        return false;
    }
}
