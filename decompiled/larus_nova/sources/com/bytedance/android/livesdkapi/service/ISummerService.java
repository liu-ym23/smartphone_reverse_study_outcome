package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.summer.ISummerTask;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.summer.SummerService")
public interface ISummerService extends IService, ISummerServiceForSaas {
    public static final int SUMMER_TASK_COUNT = 8;
    public static final int TASK_ID_ASSETS_ASYNC_PRELOAD = 4;
    public static final int TASK_ID_ASSETS_MANAGER_ASYNC_PRELOAD = 3;
    public static final int TASK_ID_PRECREATE_CastScreenConnectDataContext = 7;
    public static final int TASK_ID_PRECREATE_CastScreenViewModel = 8;
    public static final int TASK_ID_PRECREATE_RoomContext = 5;
    public static final int TASK_ID_PRECREATE_VSProgressServiceContext = 6;
    public static final int TASK_ID_WIDGET_ASYNC_PRELOAD = 1;
    public static final int TASK_ID_WIDGET_SYNC_PRELOAD = 2;

    public @interface TaskID {
    }

    void cancelTask(int r100);

    ISummerTask findTask(int r100);

    int getLiveTheme();

    Map<String, Boolean> getStrategyMap();

    void onHostTrigger();

    void registerTask(int r100, ISummerTask r101);

    void setLiveTheme(int r100);
}
