package com.bytedance.android.livesdkapi.feed.manager;

import android.content.Context;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/ILiveListManager;", "", "requestAndGetView", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openFeedParams", "Lcom/bytedance/android/livesdkapi/feed/model/OpenFeedParams;", "callback", "Lcom/bytedance/android/livesdkapi/feed/manager/ILiveListCardCallback;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveListManager {
    void requestAndGetView(Context r100, OpenFeedParams r101, ILiveListCardCallback r102);
}
