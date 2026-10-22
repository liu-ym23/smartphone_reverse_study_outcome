package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.videolink.IVideoLinkService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/VideoLinkService;", "Lcom/bytedance/android/live/liveinteract/videolink/IVideoLinkService;", "Lrj0/m;", "getVideoTalkService", "outService", "Lrj0/m;", "<init>", "()V", "videolink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class VideoLinkService implements IVideoLinkService {
    private rj0.m outService;

    public VideoLinkService() {
    }

    @Override // com.bytedance.android.live.liveinteract.videolink.IVideoLinkService
    public rj0.m getVideoTalkService() {
        if (this.outService != null) goto L6;
        this.outService = new i0();
    L6:
        return this.outService;
    }
}
