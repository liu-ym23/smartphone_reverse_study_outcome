package com.bytedance.android.ec.adapter.api.player;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.tencent.connect.share.QzonePublish;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import le.a;
import org.json.JSONObject;
import td.e;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001a\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J7\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H&J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0017H&J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\u001eH&J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H&J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0007H&J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H&J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H'J\n\u0010-\u001a\u0004\u0018\u00010,H&J-\u0010-\u001a\u00020\u00022#\u0010/\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00020\u0010H&J\b\u00100\u001a\u00020\u0017H&J-\u00101\u001a\u00020\u00022#\u0010/\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00020\u0010H&JN\u00105\u001a\u00020\u00022D\u0010/\u001a@\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000103¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u000202H&J\b\u00106\u001a\u00020\u0002H&J\b\u00107\u001a\u00020&H&J\b\u00108\u001a\u00020\u0002H&J\b\u00109\u001a\u00020\u0002H&J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020&H&J\u0011\u0010<\u001a\u0004\u0018\u00010&H&¢\u0006\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020>8&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R(\u0010G\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0B8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020J8&X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010IR\u0014\u0010Q\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0016\u0010U\u001a\u0004\u0018\u00010\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010PR\u001c\u0010Y\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bV\u0010I\"\u0004\bW\u0010XR\u001c\u0010\\\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bZ\u0010I\"\u0004\b[\u0010XR\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u001c\u0010a\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b_\u0010I\"\u0004\b`\u0010XR\u0014\u0010c\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010I¨\u0006d"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/player/IECLivePlayerClient;", "", "", ITTVideoEngineEventSource.KEY_MUTE, "unmute", "blur", "unblur", "", "isMute", "stop", "resumePlay", "release", "Lorg/json/JSONObject;", "getStatsLog", "Lle/a;", "request", "Lkotlin/Function1;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/ParameterName;", "name", "lifecycleOwner", "eventListener", "stream", "", "resolutionKey", "switchResolution", "streamData", "switchStreamData", "updateRequest", "roomId", "", ITTVideoEngineEventSource.KEY_VOLUME, "setPlayerVolume", "curPlayerVolume", "Landroid/content/Context;", "activity", "preCreateSurface", "disableVideoRender", "", "layout", "setImageLayout", "topOffset", "bottomOffset", "clipRenderViewVertical", "Landroid/graphics/Bitmap;", "getBitmap", SimplayerImageStrategy.RESULT_BITMAP, "callback", LocationMonitorConst.IDENTIFIER, "saveFrame", "Lkotlin/Function2;", "", "extraInfo", "saveFrameV2", "bindRenderView", "getVoiceDB", "pause", "resume", "shift", "seekBy", "livePlayClientHashCode", "()Ljava/lang/Integer;", "Ltd/e;", "getEventHub", "()Ltd/e;", "eventHub", "Lkotlin/Pair;", "getVideoSize", "()Lkotlin/Pair;", "setVideoSize", "(Lkotlin/Pair;)V", QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, "isVideoHorizontal", "()Z", "", "getAudioLostFocusTime", "()J", "audioLostFocusTime", "isPlaying", "getStreamFormat", "()Ljava/lang/String;", "streamFormat", "getCurrentResolution", "currentResolution", "getPullStreamData", ILiveRoomPlayFragmentConstant.LIVE_PULL_STREAM_DATA, "getShouldDestroy", "setShouldDestroy", "(Z)V", "shouldDestroy", "getEnableBackgroundStop", "setEnableBackgroundStop", "enableBackgroundStop", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getStopBarrier", "setStopBarrier", "stopBarrier", "getBufferFull", "bufferFull", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLivePlayerClient {
    void bindRenderView();

    void blur();

    void clipRenderViewVertical(int r100, int r101);

    float curPlayerVolume();

    void disableVideoRender(boolean r100);

    long getAudioLostFocusTime();

    Bitmap getBitmap();

    void getBitmap(Function1<? super Bitmap, Unit> r100);

    boolean getBufferFull();

    String getCurrentResolution();

    boolean getEnableBackgroundStop();

    e getEventHub();

    LifecycleOwner getLifecycleOwner();

    String getPullStreamData();

    boolean getShouldDestroy();

    JSONObject getStatsLog();

    boolean getStopBarrier();

    String getStreamFormat();

    Pair<Integer, Integer> getVideoSize();

    int getVoiceDB();

    String identifier();

    boolean isMute();

    boolean isPlaying();

    boolean isVideoHorizontal();

    Integer livePlayClientHashCode();

    void mute();

    void pause();

    boolean preCreateSurface(Context r100);

    void release();

    void resume();

    void resumePlay();

    void saveFrame(Function1<? super Bitmap, Unit> r100);

    void saveFrameV2(Function2<? super Map<String, ? extends Object>, ? super Bitmap, Unit> r100);

    void seekBy(int r100);

    void setEnableBackgroundStop(boolean r100);

    void setImageLayout(int r100);

    void setPlayerVolume(float r100);

    void setShouldDestroy(boolean r100);

    void setStopBarrier(boolean r100);

    void setVideoSize(Pair<Integer, Integer> r100);

    void stop();

    void stream(a r100, Function1<? super LifecycleOwner, Unit> r101);

    void switchResolution(String r100);

    void switchStreamData(String r100);

    void switchStreamData(String r100, a r101, String r102);

    void unblur();

    void unmute();
}
