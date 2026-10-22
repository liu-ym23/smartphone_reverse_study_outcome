package com.bytedance.android.livesdk.provideservices;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.ILiveVersionService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/provideservices/LiveVersionService;", "Lcom/bytedance/android/livesdkapi/ILiveVersionService;", "()V", "getLiveCoreVersion", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVersionService implements ILiveVersionService {
    public LiveVersionService() {
    }

    @Override // com.bytedance.android.livesdkapi.ILiveVersionService
    public String getLiveCoreVersion() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        if (r100 == null) goto L6;
        String r101 = r100.getVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }
}
