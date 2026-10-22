package com.bytedance.android.livesdkapi.ambientlight;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.ambientlight.LiveAmbientLightManager")
public interface ILiveAmbientLightService extends IService {

    public interface OnLuxLevelChangeListener {
        void onLuxLevelChanged(int r100, float r101);
    }

    int getCurrentLuxLevel();

    int getCurrentLuxValue();

    boolean isInitialized();

    void setOnLuxLevelChangeListener(OnLuxLevelChangeListener r100);

    void start();

    void stop();
}
