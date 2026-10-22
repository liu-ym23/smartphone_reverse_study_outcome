package com.bytedance.android.live.room.api.visibilitycontrol;

import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    void Gc(LiveVisibilityControl.KEY r100, boolean r101, long r102);

    void addControlItem(d r100);

    void removeControlItem(LiveVisibilityControl.KEY r100);

    NextLiveData<Integer> wd(LiveVisibilityControl.KEY r100);
}
