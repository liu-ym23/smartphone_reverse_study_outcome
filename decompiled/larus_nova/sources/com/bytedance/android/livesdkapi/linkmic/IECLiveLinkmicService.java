package com.bytedance.android.livesdkapi.linkmic;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/linkmic/IECLiveLinkmicService;", "", "createECLinkmicExplainCardWidget", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "roomInfo", "Lcom/bytedance/android/livesdkapi/livereplay/ILiveRoomInfo;", "linkmicInfo", "Lcom/bytedance/android/livesdkapi/linkmic/ILinkmicInfo;", "getECLinkmicExplainCardState", "Landroidx/lifecycle/LiveData;", "", "authorId", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLiveLinkmicService {
    IExternalWidget createECLinkmicExplainCardWidget(Context r100, ILiveRoomInfo r101, ILinkmicInfo r102);

    LiveData<Boolean> getECLinkmicExplainCardState(String r100);
}
