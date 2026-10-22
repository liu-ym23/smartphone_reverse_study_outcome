package com.bytedance.android.livesdkapi.livereplay;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/livereplay/IECLiveReplayService;", "", "getECProductWidget", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "roomInfo", "Lcom/bytedance/android/livesdkapi/livereplay/ILiveRoomInfo;", "replayId", "", "replayStartTime", "", "params", "Lcom/bytedance/android/livesdkapi/livereplay/IECLiveReplayParams;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLiveReplayService {
    IExternalWidget getECProductWidget(Context r100, ILiveRoomInfo r101, String r102, long r103, IECLiveReplayParams r104);
}
