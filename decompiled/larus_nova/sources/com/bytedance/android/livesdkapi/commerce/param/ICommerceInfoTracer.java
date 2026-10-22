package com.bytedance.android.livesdkapi.commerce.param;

import com.bytedance.android.livesdkapi.commerce.ICommerceEntranceData;
import com.bytedance.android.livesdkapi.commerce.ICommerceFlashData;

/* JADX INFO: loaded from: classes12.dex */
public interface ICommerceInfoTracer {
    void onFlashTraced(ICommerceFlashData r100);

    void onInfoTraced(ICommerceEntranceData r100);
}
