package com.bytedance.android.livesdkapi.util;

import com.bytedance.android.live.base.IService;
import java.util.Map;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

/* JADX INFO: loaded from: classes12.dex */
public interface ILivePreInflateService extends IService {
    public static final String LIVE_DETAIL_ACTIVITY = "LiveDetailActivity";
    public static final String LIVE_PLAY_ACTIVITY = "LivePlayActivity";
    public static final String MAIN_ACTIVITY = "MainActivity";
    public static final int SCENE_PRE_WIDGET = -1;

    @Retention(AnnotationRetention.SOURCE)
    public @interface ActivityName {
    }

    int getHostActivityTheme(String r100);

    void initHostActivityTheme(Map<String, Integer> r100);
}
