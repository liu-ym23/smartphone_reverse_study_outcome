package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.performance.LiveCleanScreenManager")
public interface ICleanScreenManager extends IService {
    public static final int SCENE_CLEAR_SCREEN = 1;
    public static final int SCENE_DEVICE_LOW_SCORE = 10;
    public static final int SCENE_DIALOG_BOTTOM = 3;
    public static final int SCENE_DIALOG_BOTTOM_LESS_HALF = 6;
    public static final int SCENE_DIALOG_TOP = 4;
    public static final int SCENE_FRONT_BACK_CHANGE = 5;
    public static final int SCENE_NONE = 0;
    public static final int SCENE_SCROLL = 2;

    void enterCleanScreen(int r100);

    void exitCleanScreen(int r100);
}
