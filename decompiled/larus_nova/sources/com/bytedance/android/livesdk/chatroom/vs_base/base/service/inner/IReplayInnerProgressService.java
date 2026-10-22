package com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jm1.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001c\u0010\u0019\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0017H&J;\u0010\u001d\u001a\u00020\b\"\b\b\u0000\u0010\u001a*\u00020\u00012\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H&¢\u0006\u0004\b\u001d\u0010\u001eJS\u0010#\u001a\u00020\b\"\b\b\u0000\u0010\u001a*\u00020\u0001\"\b\b\u0001\u0010\u001f*\u00020\u00012\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0 2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001H&¢\u0006\u0004\b#\u0010$Jk\u0010#\u001a\u00020\b\"\b\b\u0000\u0010\u001a*\u00020\u0001\"\b\b\u0001\u0010\u001f*\u00020\u0001\"\b\b\u0002\u0010%*\u00020\u00012$\u0010\u0018\u001a \u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0&2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u00012\u0006\u0010'\u001a\u00028\u0002H&¢\u0006\u0004\b#\u0010(J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\fH&J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0006H&J\b\u0010-\u001a\u00020\bH&J\b\u0010.\u001a\u00020\bH&J\u0018\u00101\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H&J\b\u00102\u001a\u00020\bH&J\b\u00103\u001a\u00020\fH&J\u0016\u00107\u001a\u00020\b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020504H&¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/service/inner/IReplayInnerProgressService;", "", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerProgressServiceContext;", "provideContext", "", "time", "", "seekTo", "pause", "resume", "", "atLatest", "setAtLatest", "getCurrentTimeInContext", "()Ljava/lang/Long;", "getCurrentDisplayTimeInContext", "getTotalTimeInContext", "Ljm1/c;", "listener", "addProgressChangeListener", "removeProgressChangeListener", "Lkotlin/reflect/KFunction1;", "action", "handleProgressListener", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction2;", "param", "handleProgressListener2", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;)V", "R", "Lkotlin/reflect/KFunction3;", "param1", "param2", "handleProgressListener3", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;Ljava/lang/Object;)V", ExifInterface.LONGITUDE_EAST, "Lkotlin/reflect/KFunction4;", "param3", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "boolean", "setThumbProcessViewEnable", "delayTimeMs", "showThumbProcessViewDelay", "hideThumbProcessView", "onProgressGestureStartTouch", "seekToTime", "mTotalTime", "onProgressGestureTracking", "onProgressGestureEndTouch", "isScheduleCloseDialogShowing", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "list", "setHighLightList", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReplayInnerProgressService {
    void addProgressChangeListener(c r100);

    Long getCurrentDisplayTimeInContext();

    Long getCurrentTimeInContext();

    Long getTotalTimeInContext();

    void handleProgressListener(KFunction<Unit> r100);

    <T> void handleProgressListener2(KFunction<Unit> r100, T r101);

    <T, R> void handleProgressListener3(KFunction<Unit> r100, T r101, R r102);

    <T, R, E> void handleProgressListener3(KFunction<Unit> r100, T r101, R r102, E r103);

    void hideThumbProcessView();

    boolean isScheduleCloseDialogShowing();

    void onProgressGestureEndTouch();

    void onProgressGestureStartTouch();

    void onProgressGestureTracking(long r100, long r101);

    void pause();

    PlayerProgressServiceContext provideContext(DataCenter r100);

    void removeProgressChangeListener(c r100);

    void resume();

    void seekTo(long r100);

    void setAtLatest(boolean r100);

    void setHighLightList(List<? extends EpisodeHighLight> r100);

    void setThumbProcessViewEnable(boolean r100);

    void showThumbProcessViewDelay(long r100);
}
