package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerSharedDataManager;", "", "getSharedData", "key", "", "putSharedData", "", "value", "removeSharedData", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerSharedDataManager {
    Object getSharedData(String r100);

    void putSharedData(String r100, Object r101);

    void removeSharedData(String r100);
}
