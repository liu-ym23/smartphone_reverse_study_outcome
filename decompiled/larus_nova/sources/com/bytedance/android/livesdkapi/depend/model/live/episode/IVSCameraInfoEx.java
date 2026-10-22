package com.bytedance.android.livesdkapi.depend.model.live.episode;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfoEx;", "", "getCameraPaidInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraPaidInfo;", "getMatchId", "", "hasEnd", "", "isMatchCamera", "isPaidCamera", "viewRight", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVSCameraInfoEx {
    ICameraPaidInfo getCameraPaidInfo();

    long getMatchId();

    boolean hasEnd();

    boolean isMatchCamera();

    boolean isPaidCamera();

    boolean viewRight();
}
