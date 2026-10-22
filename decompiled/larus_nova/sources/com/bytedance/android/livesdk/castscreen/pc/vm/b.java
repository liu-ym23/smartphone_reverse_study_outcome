package com.bytedance.android.livesdk.castscreen.pc.vm;

import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public interface b {
    k<a> getCastResult();

    k<Unit> getPlaySuccess();

    d<Boolean> getScanning();

    void initDataCenter(DataCenter r100);

    boolean isScanning();

    void release();
}
