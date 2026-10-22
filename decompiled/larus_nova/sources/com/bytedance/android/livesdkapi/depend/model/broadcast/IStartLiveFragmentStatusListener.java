package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IStartLiveFragmentStatusListener;", "", "onCreateInfoSuccess", "", "sdkParams", "", "onLiveModeChange", "liveMode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "onPreviewFragmentRecreate", "updateSourceParams", "params", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IStartLiveFragmentStatusListener {
    void onCreateInfoSuccess(String r100);

    void onLiveModeChange(LiveMode r100);

    void onPreviewFragmentRecreate();

    void updateSourceParams(String r100);
}
