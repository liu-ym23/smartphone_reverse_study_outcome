package com.bytedance.android.livesdkapi.depend.model.live;

import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public interface IBaseStreamUrlExtra extends Serializable {
    int getAnchorInteractProfile();

    int getAudienceInteractProfile();

    int getBitrateAdaptStrategy();

    int getDefaultBitrate();

    int getFPS();

    float getGopSec();

    int getHeight();

    int getMaxBitrate();

    int getMinBitrate();

    int getPreviewHeight();

    int getPreviewWidth();

    int getProfile();

    ISrConfig getSrConfig();

    int getWidth();

    boolean isEnableBFrame();

    boolean isEnableH265();

    boolean isHardwareEncode();

    boolean isRoi();

    boolean isSwRoi();
}
