package com.bytedance.android.livesdkapi.view;

import com.bytedance.android.livesdkapi.model.CropSeiData;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public interface IVideoViewCropper {

    public interface CropCallback {
        void onCropStateChanged(boolean r100);

        void resizeViewByCropper(boolean r100, int r101, int r102);

        boolean supportCrop();
    }

    CropSeiData currentCropSeiData();

    void exitVideoViewCrop(boolean r100, boolean r101);

    Pair<Integer, Integer> getOriginVideoInfo();

    boolean isInteract();

    void onOrientationChanged(boolean r100);

    void onSeiUpdate(long r100, String r101, boolean r102);

    void onSurfaceTextureUpdated(long r100);
}
