package com.bytedance.android.livesdk.player.rtcplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.rtcplayer.LiveRTCPlayerService")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\"\u0010\u000e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&J\"\u0010\u0011\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H&J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J2\u0010\u001b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H&J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u0004H&J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/player/rtcplay/ILiveRTCPlayerService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "initContext", "", "initRtcEngine", "", "streamId", "Lcom/bytedance/android/livesdk/player/rtcplay/ILiveRTCPlayerService$a;", "callback", "", "setRtcCallback", "playAudio", "playVideo", "playWtnStream", "stopAudio", "stopVideo", "stopPlayWtnStream", "Landroid/view/Surface;", "surface", "setWtnStreamPlaySurface", "wtnStreamID", "", "Landroid/graphics/Bitmap;", "lutBitmap", "", "effectValue", "setWTNRemoteVideoRenderColorFilter", ITTVideoEngineEventSource.KEY_MUTE, "setWtnStreamPlayMute", "releaseWtnStream", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRTCPlayerService extends IService {

    public interface a {
    }

    boolean initRtcEngine(Context r100);

    void playWtnStream(String r100, boolean r101, boolean r102);

    void releaseWtnStream(String r100);

    void setRtcCallback(String r100, a r101);

    void setWTNRemoteVideoRenderColorFilter(String r100, List<Bitmap> r101, List<Float> r102);

    void setWtnStreamPlayMute(String r100, boolean r101);

    void setWtnStreamPlaySurface(String r100, Surface r101);

    void stopPlayWtnStream(String r100, boolean r101, boolean r102);
}
