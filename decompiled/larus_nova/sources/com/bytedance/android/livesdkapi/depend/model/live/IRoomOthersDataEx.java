package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersDataEx;", "", "getAnchorBottomToolbar", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorBottomToolbar;", "getGroupData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "getMV", "", "()Ljava/lang/Long;", "getmRoomChatGuideLocaleCity", "", "setMV", "", "version", "(Ljava/lang/Long;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomOthersDataEx {
    IAnchorBottomToolbar getAnchorBottomToolbar();

    IGroupLiveData getGroupData();

    Long getMV();

    String getmRoomChatGuideLocaleCity();

    void setMV(Long r100);
}
