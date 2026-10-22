package com.bytedance.android.livesdkapi.vsplayer;

import com.bytedance.common.utility.NetworkUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import nic.j;
import nic.p;
import tic.a;

/* JADX INFO: loaded from: classes12.dex */
public class VSVideoPlayerConfiger implements j {
    public Resolution targetResolution;
    public int textureLayout;
    public int useSurfaceView;

    @Override // nic.j
    public boolean interceptPlay(NetworkUtils.NetworkType r100) {
        return false;
    }

    @Override // nic.j
    public boolean interceptPlayWhenVideoInfoReady(VideoRef r100) {
        return false;
    }

    @Override // nic.j
    public VideoInfo selectVideoInfoToPlay(VideoRef r100) {
        return null;
    }

    public VideoInfo selectVideoInfoToPlay(p r100, VideoModel r101, a r102) {
        return null;
    }

    public VSVideoPlayerConfiger() {
        this.textureLayout = 0;
        this.useSurfaceView = 0;
    }

    @Override // nic.j
    public VideoInfo selectVideoInfoToPlay(VideoModel r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        VideoInfo r101 = r100.getVideoInfo(this.targetResolution, null);
        if (r101 == null) goto L8;
        return r101;
    L8:
        return r100.getVideoInfo(TTVideoEngine.findDefaultResolution(r100, this.targetResolution), null);
    }
}
