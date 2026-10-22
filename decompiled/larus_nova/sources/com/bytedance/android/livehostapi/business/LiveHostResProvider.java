package com.bytedance.android.livehostapi.business;

import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0017¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livehostapi/business/LiveHostResProvider;", "Lcom/bytedance/android/livehostapi/business/IHostResProvider;", "()V", "getPauseIconResIdForNotify", "", "getPlayIconResIdForNotify", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveHostResProvider implements IHostResProvider {
    public LiveHostResProvider() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostResProvider
    public int getPauseIconResIdForNotify() {
        return R.drawable.live_icon_notify_play;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostResProvider
    public int getPlayIconResIdForNotify() {
        return R.drawable.live_icon_notify_pause;
    }
}
