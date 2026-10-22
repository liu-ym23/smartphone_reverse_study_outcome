package com.bytedance.android.livesdkapi.depend.live.vs;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.vs.video.IVideoLifecycleObserver;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEngine;", "Lcom/bytedance/android/live/base/IService;", "eventHub", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "getEventHub", "()Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "addLifecycleObserver", "", "observer", "Lcom/bytedance/android/livesdkapi/depend/live/vs/video/IVideoLifecycleObserver;", "index", "", "addTask", "task", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoTask;", MapMonitorConst.EVENT_DESTROY, "endVideo", "reason", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "enterVideo", "startInteraction", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoEngine extends IService {
    void addLifecycleObserver(IVideoLifecycleObserver r100);

    void addLifecycleObserver(IVideoLifecycleObserver r100, int r101);

    void addTask(IVideoTask r100);

    void destroy();

    void endVideo(EndReason r100);

    void enterVideo();

    IVideoEventHub getEventHub();

    void startInteraction();
}
