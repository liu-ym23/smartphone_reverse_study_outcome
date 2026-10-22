package com.bytedance.android.live.liveinteract.channel.business;

import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$AudioCaptureState;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState;
import com.bytedance.android.live.fifa.core.IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole;
import com.bytedance.android.live.fifa.core.IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import io.reactivex.subjects.BehaviorSubject;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements IChannelLinkService {
    public c() {
        int r100 = de0.a.f468040i;
        BehaviorSubject.createDefault(new de0.a(((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().b(), IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole.Unknown, IChannelLinkService$ICurrentUserLinkStatus$AudioCaptureState.CLOSE, IChannelLinkService$ICurrentUserLinkStatus$AudioPublishState.CLOSE, IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.SILENT));
    }
}
