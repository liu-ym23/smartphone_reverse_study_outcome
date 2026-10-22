package com.bytedance.android.livesdkapi.depend.model.live.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/IRoomPreloadTaskManager;", "", "postAtFirstFrame", "", "runnable", "Ljava/lang/Runnable;", "tag", "", "postTask", "delay", "", "stopAllTask", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomPreloadTaskManager {
    void postAtFirstFrame(Runnable r100, String r101);

    void postTask(Runnable r100, long r101, String r102);

    void stopAllTask(String r100);
}
