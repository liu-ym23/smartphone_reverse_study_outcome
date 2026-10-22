package com.bytedance.android.livesdkapi.player;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\rR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002030\u000b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\rR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u0002030\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\rR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\rR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\rR\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0007R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\rR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\rR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0007R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0007R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\rR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\r¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/LiveZygoteBaseEventHub;", "", "()V", "allWidgetLoaded", "Landroidx/lifecycle/MutableLiveData;", "", "getAllWidgetLoaded", "()Landroidx/lifecycle/MutableLiveData;", "allWidgetLoadedV2", "getAllWidgetLoadedV2", "autoLoadMore", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getAutoLoadMore", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "crashPopEvent", "", "getCrashPopEvent", "endRoom", "getEndRoom", "exitPage", "getExitPage", "forceLoginEvent", "", "getForceLoginEvent", "hideInteraction", "getHideInteraction", "hideLoading", "getHideLoading", "initRoom", "getInitRoom", "interactionResume", "getInteractionResume", "isRoomVisible", "isScrolling", "leaveForProfile", "getLeaveForProfile", "legacyPull", "getLegacyPull", "liveIllegal", "getLiveIllegal", "mediaGeneratingViewShowing", "getMediaGeneratingViewShowing", "mediaStartRender", "getMediaStartRender", "p0WidgetLoaded", "getP0WidgetLoaded", "p1WidgetLoaded", "getP1WidgetLoaded", "p2WidgetLoaded", "getP2WidgetLoaded", "partShowInteraction", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getPartShowInteraction", "prePull", "getPrePull", "preloadInitRoom", "getPreloadInitRoom", "preloadInteraction", "getPreloadInteraction", "reloadWidget", "getReloadWidget", "retryEnter", "", "getRetryEnter", "roomScrolled", "getRoomScrolled", "showInteraction", "getShowInteraction", "showLiveEnd", "getShowLiveEnd", "showMediaVideoBackground", "getShowMediaVideoBackground", "showVSLoading", "getShowVSLoading", "startEnter", "getStartEnter", "startEnterRoomRequest", "getStartEnterRoomRequest", "startExitLive", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "getStartExitLive", "startPull", "getStartPull", "switchStreamDataEvent", "getSwitchStreamDataEvent", "traceApmEvent", "getTraceApmEvent", "tryShowLoading", "getTryShowLoading", "updateInteraction", "getUpdateInteraction", "updateRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getUpdateRoom", "visible", "getVisible", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveZygoteBaseEventHub {
    private final MutableLiveData<Boolean> allWidgetLoaded;
    private final MutableLiveData<Boolean> allWidgetLoadedV2;
    private final NextLiveData<Boolean> autoLoadMore;
    private final MutableLiveData<String> crashPopEvent;
    private final MutableLiveData<Boolean> endRoom;
    private final MutableLiveData<Boolean> exitPage;
    private final MutableLiveData<Integer> forceLoginEvent;
    private final NextLiveData<Boolean> hideInteraction;
    private final MutableLiveData<Boolean> hideLoading;
    private final MutableLiveData<Boolean> initRoom;
    private final MutableLiveData<Boolean> interactionResume;
    private final MutableLiveData<Boolean> isRoomVisible;
    private final MutableLiveData<Boolean> isScrolling;
    private final MutableLiveData<String> leaveForProfile;
    private final MutableLiveData<Boolean> legacyPull;
    private final MutableLiveData<Boolean> liveIllegal;
    private final MutableLiveData<Boolean> mediaGeneratingViewShowing;
    private final MutableLiveData<Boolean> mediaStartRender;
    private final MutableLiveData<Boolean> p0WidgetLoaded;
    private final MutableLiveData<Boolean> p1WidgetLoaded;
    private final MutableLiveData<Boolean> p2WidgetLoaded;
    private final NextLiveData<IRoom> partShowInteraction;
    private final MutableLiveData<Boolean> prePull;
    private final MutableLiveData<Boolean> preloadInitRoom;
    private final NextLiveData<IRoom> preloadInteraction;
    private final MutableLiveData<Boolean> reloadWidget;
    private final MutableLiveData<Long> retryEnter;
    private final MutableLiveData<Boolean> roomScrolled;
    private final NextLiveData<IRoom> showInteraction;
    private final NextLiveData<Boolean> showLiveEnd;
    private final MutableLiveData<Boolean> showMediaVideoBackground;
    private final NextLiveData<Boolean> showVSLoading;
    private final MutableLiveData<Boolean> startEnter;
    private final MutableLiveData<Boolean> startEnterRoomRequest;
    private final MutableLiveData<EndReason> startExitLive;
    private final NextLiveData<Boolean> startPull;
    private final NextLiveData<Boolean> switchStreamDataEvent;
    private final MutableLiveData<String> traceApmEvent;
    private final MutableLiveData<Boolean> tryShowLoading;
    private final NextLiveData<Object> updateInteraction;
    private final MutableLiveData<Room> updateRoom;
    private final NextLiveData<Boolean> visible;

    public LiveZygoteBaseEventHub() {
        this.initRoom = new MutableLiveData();
        this.preloadInitRoom = new MutableLiveData();
        this.isRoomVisible = new MutableLiveData();
        this.updateRoom = new MutableLiveData();
        this.startEnter = new MutableLiveData();
        this.endRoom = new MutableLiveData();
        this.exitPage = new MutableLiveData();
        this.showLiveEnd = new NextLiveData();
        this.startExitLive = new MutableLiveData();
        this.showVSLoading = new NextLiveData();
        this.reloadWidget = new MutableLiveData();
        this.prePull = new MutableLiveData();
        this.preloadInteraction = new NextLiveData();
        this.partShowInteraction = new NextLiveData();
        this.showInteraction = new NextLiveData();
        this.hideInteraction = new NextLiveData();
        this.updateInteraction = new NextLiveData();
        this.p0WidgetLoaded = new MutableLiveData();
        this.p1WidgetLoaded = new MutableLiveData();
        this.p2WidgetLoaded = new MutableLiveData();
        this.allWidgetLoaded = new MutableLiveData();
        this.allWidgetLoadedV2 = new MutableLiveData();
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        Boolean r101 = Boolean.FALSE;
        r100.postValue(r101);
        Unit r102 = Unit.INSTANCE;
        this.isScrolling = r100;
        this.liveIllegal = new MutableLiveData();
        this.leaveForProfile = new MutableLiveData();
        this.crashPopEvent = new MutableLiveData();
        this.mediaStartRender = new MutableLiveData();
        this.mediaGeneratingViewShowing = new MutableLiveData();
        this.showMediaVideoBackground = new MutableLiveData();
        this.tryShowLoading = new MutableLiveData();
        this.hideLoading = new MutableLiveData();
        this.retryEnter = new MutableLiveData();
        this.forceLoginEvent = new MutableLiveData();
        this.startPull = new NextLiveData();
        this.legacyPull = new MutableLiveData();
        this.interactionResume = new MutableLiveData();
        this.startEnterRoomRequest = new MutableLiveData();
        this.traceApmEvent = new MutableLiveData();
        this.roomScrolled = new MutableLiveData();
        NextLiveData<Boolean> r103 = new NextLiveData();
        r103.setValue(r101);
        this.visible = r103;
        this.autoLoadMore = new NextLiveData();
        NextLiveData<Boolean> r104 = new NextLiveData();
        r104.setValue(r101);
        this.switchStreamDataEvent = r104;
    }

    public final MutableLiveData<Boolean> getAllWidgetLoaded() {
        return this.allWidgetLoaded;
    }

    public final MutableLiveData<Boolean> getAllWidgetLoadedV2() {
        return this.allWidgetLoadedV2;
    }

    public final NextLiveData<Boolean> getAutoLoadMore() {
        return this.autoLoadMore;
    }

    public final MutableLiveData<String> getCrashPopEvent() {
        return this.crashPopEvent;
    }

    public final MutableLiveData<Boolean> getEndRoom() {
        return this.endRoom;
    }

    public final MutableLiveData<Boolean> getExitPage() {
        return this.exitPage;
    }

    public final MutableLiveData<Integer> getForceLoginEvent() {
        return this.forceLoginEvent;
    }

    public final NextLiveData<Boolean> getHideInteraction() {
        return this.hideInteraction;
    }

    public final MutableLiveData<Boolean> getHideLoading() {
        return this.hideLoading;
    }

    public final MutableLiveData<Boolean> getInitRoom() {
        return this.initRoom;
    }

    public final MutableLiveData<Boolean> getInteractionResume() {
        return this.interactionResume;
    }

    public final MutableLiveData<String> getLeaveForProfile() {
        return this.leaveForProfile;
    }

    public final MutableLiveData<Boolean> getLegacyPull() {
        return this.legacyPull;
    }

    public final MutableLiveData<Boolean> getLiveIllegal() {
        return this.liveIllegal;
    }

    public final MutableLiveData<Boolean> getMediaGeneratingViewShowing() {
        return this.mediaGeneratingViewShowing;
    }

    public final MutableLiveData<Boolean> getMediaStartRender() {
        return this.mediaStartRender;
    }

    public final MutableLiveData<Boolean> getP0WidgetLoaded() {
        return this.p0WidgetLoaded;
    }

    public final MutableLiveData<Boolean> getP1WidgetLoaded() {
        return this.p1WidgetLoaded;
    }

    public final MutableLiveData<Boolean> getP2WidgetLoaded() {
        return this.p2WidgetLoaded;
    }

    public final NextLiveData<IRoom> getPartShowInteraction() {
        return this.partShowInteraction;
    }

    public final MutableLiveData<Boolean> getPrePull() {
        return this.prePull;
    }

    public final MutableLiveData<Boolean> getPreloadInitRoom() {
        return this.preloadInitRoom;
    }

    public final NextLiveData<IRoom> getPreloadInteraction() {
        return this.preloadInteraction;
    }

    public final MutableLiveData<Boolean> getReloadWidget() {
        return this.reloadWidget;
    }

    public final MutableLiveData<Long> getRetryEnter() {
        return this.retryEnter;
    }

    public final MutableLiveData<Boolean> getRoomScrolled() {
        return this.roomScrolled;
    }

    public final NextLiveData<IRoom> getShowInteraction() {
        return this.showInteraction;
    }

    public final NextLiveData<Boolean> getShowLiveEnd() {
        return this.showLiveEnd;
    }

    public final MutableLiveData<Boolean> getShowMediaVideoBackground() {
        return this.showMediaVideoBackground;
    }

    public final NextLiveData<Boolean> getShowVSLoading() {
        return this.showVSLoading;
    }

    public final MutableLiveData<Boolean> getStartEnter() {
        return this.startEnter;
    }

    public final MutableLiveData<Boolean> getStartEnterRoomRequest() {
        return this.startEnterRoomRequest;
    }

    public final MutableLiveData<EndReason> getStartExitLive() {
        return this.startExitLive;
    }

    public final NextLiveData<Boolean> getStartPull() {
        return this.startPull;
    }

    public final NextLiveData<Boolean> getSwitchStreamDataEvent() {
        return this.switchStreamDataEvent;
    }

    public final MutableLiveData<String> getTraceApmEvent() {
        return this.traceApmEvent;
    }

    public final MutableLiveData<Boolean> getTryShowLoading() {
        return this.tryShowLoading;
    }

    public final NextLiveData<Object> getUpdateInteraction() {
        return this.updateInteraction;
    }

    public final MutableLiveData<Room> getUpdateRoom() {
        return this.updateRoom;
    }

    public final NextLiveData<Boolean> getVisible() {
        return this.visible;
    }

    public final MutableLiveData<Boolean> isRoomVisible() {
        return this.isRoomVisible;
    }

    public final MutableLiveData<Boolean> isScrolling() {
        return this.isScrolling;
    }
}
