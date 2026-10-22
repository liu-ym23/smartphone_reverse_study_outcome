package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public interface IStartLiveFragment {
    public static final String LIVE_LOG_ENTER_FROM = "live_log_enter_from";
    public static final String LIVE_LOG_SOURCE = "live_log_source";

    int getCameraType();

    FrameLayout getCommerceView();

    Fragment getFragment();

    void handleUserVerifyResult(HashMap<String, String> r100);

    void loadingDialogDismiss();

    void notifyEffectParams();

    void notifyPreviewReady();

    void onHideStartLiveFragment();

    void onShowBlessingSticker(Sticker r100, int r101);

    void onShowStartLiveFragment();

    void restartStartLiveFragment();

    void setBundle(Bundle r100);

    void setCameraType(int r100);

    void setEnterSource(String r100);

    void setImagePickerStatsListener(ILiveBroadcast.ImagePickerStatsListener r100);

    void setLiveParamsListener(ILiveParamsListener r100);

    void setPreviewCameraListener(ILivePreviewCameraListener r100);

    void setRoomTitleLimit(int r100);

    void setStartFragmentStatusListener(IStartLiveFragmentStatusListener r100);

    void startLive();

    void updateSourceParams(Bundle r100);
}
