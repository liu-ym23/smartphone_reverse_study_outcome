package com.bytedance.android.livesdkapi.feed.manager;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import kotlin.Metadata;
import ld0.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/manager/IInteractFeedViewListener;", "", "", "sei", "", "onSeiUpdateRaw", "Lld0/a;", "videoSei", "onKtvVideoStateChange", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "seiAppData", "updateSceneByVer", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractFeedViewListener {
    void onKtvVideoStateChange(a r100);

    void onSeiUpdateRaw(String r100);

    void updateSceneByVer(SeiAppData r100);
}
