package com.bytedance.android.livesdkapi.feed;

import com.bytedance.android.livesdkapi.depend.model.open.OpenRoom;
import com.lynx.tasm.LynxError;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/FeedLoadingCallback;", "", "onFailed", "", LynxError.LYNX_THROWABLE, "", "onSuccess", "newList", "", "Lcom/bytedance/android/livesdkapi/depend/model/open/OpenRoom;", "hasMore", "", "liveFeedUrl", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FeedLoadingCallback {
    void onFailed(Throwable r100);

    void onSuccess(List<OpenRoom> r100, boolean r101, String r102);
}
