package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f118191a = null;

    static {
        f118191a = VSSettingKeys.LIVE_VS_USE_STREAM_ORIENTATION.getValue();
    }

    public static int a(IVSCameraInfo r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (f118191a.booleanValue() == false) goto L23;
        IBaseStreamUrl r101 = r100.getStreamUrl();
        if (r101 != null) goto L10;
    L11:
        IBaseStreamUrl r102 = r100.getStreamUrl();
        if (r102 != null) goto L14;
    L16:
        IBaseStreamUrl r103 = r100.getStreamUrl();
        if (r103 == null) goto L19;
        Integer r104 = Integer.valueOf(r103.getStreamOrientation());
    L21:
        return c(r104);
    L19:
        r104 = null;
        goto L21
    L14:
        if (r102.getVrType() != 2) goto L16;
    L15:
        return 2;
    L10:
        if (r101.getVrType() == 1) goto L15;
    L23:
        return r100.getStyle();
    }

    public static int b(IRoom r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        IEpisodeExtraInfo r101 = null;
        Integer r102 = null;
        if (f118191a.booleanValue() == false) goto L15;
        IBaseStreamUrl r103 = r100.getStreamUrl();
        if (r103 == null) goto L10;
        r102 = Integer.valueOf(r103.getStreamOrientation());
    L10:
        int r104 = c(r102);
        if (r100.getVRType() != 1) goto L13;
    L14:
        return 2;
    L13:
        if (r100.getVRType() == 2) goto L14;
        return r104;
    L15:
        IEpisodeExtraInfo r105 = r100.getEpisodeComponentData();
        if (r105 == null) goto L30;
        if (r105.getStyle() != 0) goto L30;
        IEpisodeExtraInfo r106 = r100.getEpisodeComponentData();
        if ((r106 instanceof EpisodeExtraInfo) == true) goto L22;
        r106 = null;
    L22:
        EpisodeExtraInfo r107 = (EpisodeExtraInfo) r106;
        if (r107 == null) goto L30;
        IBaseStreamUrl r108 = r100.getStreamUrl();
        if (r108 == null) goto L27;
        Integer r109 = Integer.valueOf(r108.getStreamOrientation());
    L28:
        r107.setStyle(c(r109));
        goto L30
    L27:
        r109 = null;
    L30:
        if (r100.getVRType() != 1) goto L32;
    L33:
        IEpisodeExtraInfo r110 = r100.getEpisodeComponentData();
        if ((r110 instanceof EpisodeExtraInfo) == false) goto L37;
        r101 = r110;
    L37:
        EpisodeExtraInfo r111 = (EpisodeExtraInfo) r101;
        if (r111 == null) goto L40;
        r111.setStyle(2);
    L40:
        IEpisodeExtraInfo r112 = r100.getEpisodeComponentData();
        if (r112 != null) goto L43;
        return 0;
    L43:
        return r112.getStyle();
    L32:
        if (r100.getVRType() != 2) goto L40;
        goto L33
    }

    public static int c(Integer r100) {
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        return 0;
    L11:
        if (r100.intValue() != 2) goto L13;
        return 1;
    L6:
        if (r100.intValue() != 1) goto L8;
        return 2;
    }
}
