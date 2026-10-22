package com.bytedance.android.rtcplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.json.JSONException;
import org.json.JSONObject;
import yf2.f;
import zf2.q;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b*\u0002$'\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u000e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\"\u0010\u0011\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u001b\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R$\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/bytedance/android/rtcplayer/LiveRTCPlayerService;", "Lcom/bytedance/android/livesdk/player/rtcplay/ILiveRTCPlayerService;", "Landroid/content/Context;", "initContext", "", "initRtcEngine", "", "streamId", "Lcom/bytedance/android/livesdk/player/rtcplay/ILiveRTCPlayerService$a;", "callback", "", "setRtcCallback", "playAudio", "playVideo", "playWtnStream", "stopAudio", "stopVideo", "stopPlayWtnStream", "Landroid/view/Surface;", "surface", "setWtnStreamPlaySurface", "wtnStreamID", "", "Landroid/graphics/Bitmap;", "lutBitmap", "", "effectValue", "setWTNRemoteVideoRenderColorFilter", ITTVideoEngineEventSource.KEY_MUTE, "setWtnStreamPlayMute", "releaseWtnStream", "", "Lyf2/c;", "wtnStreams", "Ljava/util/Map;", "rtcCallbacks", "com/bytedance/android/rtcplayer/LiveRTCPlayerService$b", "rtcEngineEventHandler", "Lcom/bytedance/android/rtcplayer/LiveRTCPlayerService$b;", "com/bytedance/android/rtcplayer/LiveRTCPlayerService$c", "wtnEventHandler", "Lcom/bytedance/android/rtcplayer/LiveRTCPlayerService$c;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRTCPlayerService implements ILiveRTCPlayerService {
    public static final a Companion = null;
    private static yf2.a rtcEngineInstance;
    private final Map<String, ILiveRTCPlayerService.a> rtcCallbacks;
    private final b rtcEngineEventHandler;
    private final c wtnEventHandler;
    private final Map<String, yf2.c> wtnStreams;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends ag2.a {
        public b() {
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveRTCPlayerService() {
        k.l(ILiveRTCPlayerService.class, this);
        this.wtnStreams = new LinkedHashMap();
        this.rtcCallbacks = new LinkedHashMap();
        this.rtcEngineEventHandler = new b();
        this.wtnEventHandler = new c();
    }

    public static final /* synthetic */ Map access$getRtcCallbacks$p(LiveRTCPlayerService r100) {
        return r100.rtcCallbacks;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public boolean initRtcEngine(Context r100) {
        JSONObject r101 = new JSONObject();
        String r102 = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).getServerDeviceId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put("rtc.device_id", r102);
        r101.put("rtc.env", 0);
        q r103 = new q();
        r103.f571740a = r100;
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().createRTCEngineMulti(r103, this.rtcEngineEventHandler);
        new JSONObject().put("rtc.scene_tag", "audience_wtn_live");     // Catch: JSONException -> L8
    L10:
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        r105.put("enable", true);     // Catch: JSONException -> L13
        r105.put("report_interval", 20000);     // Catch: JSONException -> L13
        r105.put("delay_window_size", 1000);     // Catch: JSONException -> L13
        r105.put("video_stall_threshold", 200);     // Catch: JSONException -> L13
        r105.put("audio_stall_threshold", 200);     // Catch: JSONException -> L13
        r104.put("rtc.custom_wtn_live_report", r105);     // Catch: JSONException -> L13
    L15:
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void releaseWtnStream(String r100) {
        if (this.wtnStreams.containsKey(r100) == false) goto L6;
        this.wtnStreams.remove(r100);
    L6:
        if (this.rtcCallbacks.containsKey(r100) == false) goto L9;
        this.rtcCallbacks.remove(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void setRtcCallback(String r100, ILiveRTCPlayerService.a r101) {
        this.rtcCallbacks.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void setWtnStreamPlayMute(String r100, boolean r101) {
        Map<String, yf2.c> r102 = this.wtnStreams;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.containsKey(r100) == false) goto L11;
        yf2.c r103 = this.wtnStreams.get(r100);
        if (r103 == null) goto L12;
        r103.d();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void setWtnStreamPlaySurface(String r100, Surface r101) {
        if (this.wtnStreams.containsKey(r100) == false) goto L8;
        f r102 = new f();
        r102.f567437a = null;
        r102.f567438b = r101;
        r102.f567439c = 2;
        yf2.c r103 = this.wtnStreams.get(r100);
        if (r103 == null) goto L9;
        r103.h();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void playWtnStream(String r100, boolean r101, boolean r102) {
        if (this.wtnStreams.containsKey(r100) == true) goto L5;
        this.wtnStreams.put(r100, null);
    L5:
        yf2.c r103 = this.wtnStreams.get(r100);
        if (r103 == null) goto L8;
        r103.b();
    L8:
        yf2.c r104 = this.wtnStreams.get(r100);
        if (r104 == null) goto L12;
        r104.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void setWTNRemoteVideoRenderColorFilter(String r100, List<Bitmap> r101, List<Float> r102) {
        if (this.wtnStreams.containsKey(r100) == true) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        Bitmap r103 = (Bitmap) ListProtector.get(r101, 0);
    L7:
        if (r102 == null) goto L11;
        Float r104 = (Float) CollectionsKt.getOrNull(r102, 0);
        if (r104 == null) goto L11;
        r104.floatValue();
    L11:
        yf2.c r105 = this.wtnStreams.get(r100);
        if (r105 == null) goto L16;
        r105.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.player.rtcplay.ILiveRTCPlayerService
    public void stopPlayWtnStream(String r100, boolean r101, boolean r102) {
        if (this.wtnStreams.containsKey(r100) == false) goto L11;
        yf2.c r103 = this.wtnStreams.get(r100);
        if (r103 == null) goto L7;
        r103.b();
    L7:
        yf2.c r104 = this.wtnStreams.get(r100);
        if (r104 == null) goto L12;
        r104.g();
        return;
    L12:
        return;
    }
}
