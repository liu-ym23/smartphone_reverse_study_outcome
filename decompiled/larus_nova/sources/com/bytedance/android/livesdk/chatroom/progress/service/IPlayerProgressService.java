package com.bytedance.android.livesdk.chatroom.progress.service;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.d;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeOnlyTaSegmentScope;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeOnlyTaSegments;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H&J\u001c\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u0018H&J;\u0010\u001e\u001a\u00020\b\"\b\b\u0000\u0010\u001b*\u00020\u00012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H&¢\u0006\u0004\b\u001e\u0010\u001fJS\u0010$\u001a\u00020\b\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010 *\u00020\u00012\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H&¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\fH&J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0006H&J\b\u0010*\u001a\u00020\bH&J\b\u0010+\u001a\u00020\bH&J\u0018\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H&J\b\u0010/\u001a\u00020\bH&J\b\u00100\u001a\u00020\fH&J\u0016\u00104\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H&J\b\u00105\u001a\u00020\bH&J\b\u00106\u001a\u00020\bH&J\b\u00107\u001a\u00020\bH&J\b\u00108\u001a\u00020\bH&J\u0018\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000202H&J\b\u0010=\u001a\u00020\fH&J\u0010\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H&J\b\u0010A\u001a\u00020\bH&J\b\u0010B\u001a\u00020\bH&J\b\u0010C\u001a\u00020\fH&J\u0019\u0010E\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\bE\u0010FJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010:\u001a\u0002092\u0006\u0010H\u001a\u00020GH&J\n\u0010K\u001a\u0004\u0018\u00010JH&¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progress/service/IPlayerProgressService;", "", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerProgressServiceContext;", "provideContext", "", "time", "", "seekTo", "pause", "resume", "", "atLatest", "setAtLatest", "isAtLatest", "getCurrentTimeInContext", "()Ljava/lang/Long;", "getCurrentDisplayTimeInContext", "getTotalTimeInContext", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;", "listener", "addProgressChangeListener", "removeProgressChangeListener", "Lkotlin/reflect/KFunction1;", "action", "handleProgressListener", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction2;", "param", "handleProgressListener2", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;)V", "R", "Lkotlin/reflect/KFunction3;", "param1", "param2", "handleProgressListener3", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;Ljava/lang/Object;)V", "boolean", "setThumbProcessViewEnable", "delayTimeMs", "showThumbProcessViewDelay", "hideThumbProcessView", "onProgressGestureStartTouch", "seekToTime", "mTotalTime", "onProgressGestureTracking", "onProgressGestureEndTouch", "getHighLightDisplayStatus", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "list", "setHighLightList", "removeHighLightList", "updateHighLightTotalTime", "seekToFirstHighLight", "seekToRandomHighLight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "highLight", "seekToHighLight", "getOnlyTaDisplayStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeOnlyTaSegments;", DBDefinition.SEGMENT_TABLE_NAME, "setOnlyTaSegment", "removeOnlyTaSegment", "seekToFirstOnlyTaSegment", "seekToNearestOnlyTaSegment", "currentTime", "seekToNextOnlyTaSegment", "(Ljava/lang/Long;)Z", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeOnlyTaSegmentScope;", "scope", "seekToOnlyTaByScope", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "seekWithForceResolution", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerProgressService {
    void addProgressChangeListener(d r100);

    Long getCurrentDisplayTimeInContext();

    Long getCurrentTimeInContext();

    boolean getHighLightDisplayStatus();

    boolean getOnlyTaDisplayStatus();

    Long getTotalTimeInContext();

    void handleProgressListener(KFunction<Unit> r100);

    <T> void handleProgressListener2(KFunction<Unit> r100, T r101);

    <T, R> void handleProgressListener3(KFunction<Unit> r100, T r101, R r102);

    void hideThumbProcessView();

    boolean isAtLatest();

    void onProgressGestureEndTouch();

    void onProgressGestureStartTouch();

    void onProgressGestureTracking(long r100, long r101);

    void pause();

    PlayerProgressServiceContext provideContext(DataCenter r100);

    void removeHighLightList();

    void removeOnlyTaSegment();

    void removeProgressChangeListener(d r100);

    void resume();

    void seekTo(long r100);

    void seekToFirstHighLight();

    void seekToFirstOnlyTaSegment();

    void seekToHighLight(Context r100, EpisodeHighLight r101);

    boolean seekToNearestOnlyTaSegment();

    boolean seekToNextOnlyTaSegment(Long r100);

    void seekToOnlyTaByScope(Context r100, EpisodeOnlyTaSegmentScope r101);

    void seekToRandomHighLight();

    IQuality seekWithForceResolution();

    void setAtLatest(boolean r100);

    void setHighLightList(List<? extends EpisodeHighLight> r100);

    void setOnlyTaSegment(EpisodeOnlyTaSegments r100);

    void setThumbProcessViewEnable(boolean r100);

    void showThumbProcessViewDelay(long r100);

    void updateHighLightTotalTime();
}
