package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.headset.HeadsetServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IHeadsetService;", "Lcom/bytedance/android/live/base/IService;", "addHeadsetChangeListener", "", "listener", "Lcom/bytedance/android/livesdkapi/service/IHeadsetChange;", "getHeadSetType", "Lcom/bytedance/android/livesdkapi/service/HeadsetType;", "forceRefresh", "", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "removeHeadsetChangeListener", "startListenHeadSetChange", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHeadsetService extends IService {
    void addHeadsetChangeListener(IHeadsetChange r100);

    HeadsetType getHeadSetType(boolean r100);

    void init(Context r100);

    void removeHeadsetChangeListener(IHeadsetChange r100);

    void startListenHeadSetChange();
}
