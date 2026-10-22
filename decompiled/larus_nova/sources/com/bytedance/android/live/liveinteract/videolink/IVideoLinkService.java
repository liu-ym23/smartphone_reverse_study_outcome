package com.bytedance.android.live.liveinteract.videolink;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;
import rj0.m;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.liveinteract.videotalk.VideoLinkService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videolink/IVideoLinkService;", "Lcom/bytedance/android/live/base/IService;", "Lrj0/m;", "getVideoTalkService", "videolink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVideoLinkService extends IService {
    m getVideoTalkService();
}
