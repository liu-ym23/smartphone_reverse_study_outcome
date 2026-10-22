package com.bytedance.android.livesdkapi.feed.manager;

import com.bytedance.android.livesdkapi.feed.ui.ILiveCardView;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/ILiveListCardCallback;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "error", "", "onReceive", "list", "", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveListCardCallback {
    void onError(Throwable r100);

    void onReceive(List<? extends ILiveCardView> r100);
}
