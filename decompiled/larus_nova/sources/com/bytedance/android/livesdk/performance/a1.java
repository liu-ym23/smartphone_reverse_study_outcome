package com.bytedance.android.livesdk.performance;

import com.bytedance.android.live.initialize.IWTORepeatableTask;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.livesdkapi.wto.IWTOManager;

/* JADX INFO: loaded from: classes11.dex */
public final class a1 implements IWTOManager {
    public a1() {
    }

    @Override // com.bytedance.android.livesdkapi.wto.IWTOManager
    public final void cancelRepeatableTask(IWTORepeatableTask r100) {
        LiveWTO.INSTANCE.cancelRepeatableTask(r100);
    }

    @Override // com.bytedance.android.livesdkapi.wto.IWTOManager
    public final void commitRepeatableTask(IWTORepeatableTask r100) {
        LiveWTO.INSTANCE.commitRepeatableTask(r100);
    }
}
