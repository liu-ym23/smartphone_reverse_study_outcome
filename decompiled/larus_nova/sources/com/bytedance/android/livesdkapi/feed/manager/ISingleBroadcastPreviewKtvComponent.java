package com.bytedance.android.livesdkapi.feed.manager;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/ISingleBroadcastPreviewKtvComponent;", "", "getFeedView", "Landroid/view/View;", "registerFeedViewListener", "", "listener", "Lcom/bytedance/android/livesdkapi/feed/manager/IInteractFeedViewListener;", "unregisterFeedViewListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISingleBroadcastPreviewKtvComponent {
    View getFeedView();

    void registerFeedViewListener(IInteractFeedViewListener r100);

    void unregisterFeedViewListener(IInteractFeedViewListener r100);
}
