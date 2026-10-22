package com.bytedance.android.livesdkapi.feed.manager;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/ILivePreviewKtvComponentWidget;", "", "onBind", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "unBind", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewKtvComponentWidget {
    void onBind(IRoom r100);

    void unBind();
}
