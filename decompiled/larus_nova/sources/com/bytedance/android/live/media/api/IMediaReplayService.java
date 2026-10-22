package com.bytedance.android.live.media.api;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import wl0.a;
import wl0.b;
import wl0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0018\u001a\u00020\u0007H&J\b\u0010\u0019\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0004H&J\b\u0010\u001d\u001a\u00020\u0004H&J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0002H&J\b\u0010 \u001a\u00020\u001fH&J\b\u0010!\u001a\u00020\u001fH&J \u0010&\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H&J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0004H&J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004H&¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/media/api/IMediaReplayService;", "Lcom/bytedance/android/live/base/IService;", "", "roomId", "", "isReplaySync", "isReplay", "", "updateReplayState", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "shouldStartReplay", "isShowGenerating", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "", "pullVideoRatio", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lwl0/c;", "mediaRoomMeta", "Lwl0/b;", "mediaReplayListener", "startReplay", "pause", "play", "stopReplay", "playing", "updatePlaying", "isPlaying", "seekTo", "", "getDuration", "getCurrentTime", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lwl0/a;", "mediaReplayCallback", "checkReplay", "isPortrait", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "getVideoControlWidget", "Landroid/view/View;", "visible", "setInteractionVisibility", "livemedia-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMediaReplayService extends IService {
    void checkReplay(long r100, LifecycleOwner r101, a r102);

    int getCurrentTime();

    int getDuration();

    LiveWidget getVideoControlWidget(boolean r100);

    boolean isPlaying();

    boolean isReplaySync(long r100);

    boolean isShowGenerating();

    void pause();

    void play();

    void seekTo(long r100);

    void setInteractionVisibility(View r100, boolean r101);

    boolean shouldStartReplay(Room r100);

    void startReplay(ViewGroup r100, float r101, DataCenter r102, c r103, b r104);

    void stopReplay();

    void updatePlaying(boolean r100);

    void updateReplayState(long r100, boolean r101);
}
