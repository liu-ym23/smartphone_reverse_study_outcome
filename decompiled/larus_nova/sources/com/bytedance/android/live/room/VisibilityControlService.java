package com.bytedance.android.live.room;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\rH\u0016JR\u0010.\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0010\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\u0010\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u00020\rH\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016R\u0014\u0010A\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\bD\u0010BR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010BR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006\\"}, d2 = {"Lcom/bytedance/android/live/room/VisibilityControlService;", "Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "provideContext", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "manager", "", "injectWidgetManager", "getWidgetManager", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "widget", "registerControlWidget", "clearControlWidget", "", "getLockStatus", "lock", "setLockStatus", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$KEY;", "key", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "getControlItemStatus", "visible", "setControlItemStatus", "", "customDuration", "getVisibilityStatus", "setVisibilityStatus", "changeVisibilityStatus", "changeTetrisVisible", "markVisibilityStatusChangeByUser", "resetHideTask", "enable", "setAutoHideTaskEnable", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Type;", "type", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControl$Style;", "style", "Landroid/view/View;", "view", "", "attachMarginDp", "needDynamicControl", "ignoreLock", "Lcom/bytedance/android/live/room/api/visibilitycontrol/a;", "reverse", "addControlItem", "Lcom/bytedance/android/live/room/api/visibilitycontrol/d;", MapController.ITEM_LAYER_TAG, "removeControlItem", "releaseService", "Lio/reactivex/Observable;", "startVisibilityTimer", "stopVisibilityTimer", "startPlayBackTimer", "pausePlayBackTimer", "isPlayingInPlayBack", "stopPlayBackTimer", "resetPlayBackTimer", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "shutdownPlayback", "countdown", "countDownShift", "onUnload", "ANIM_DURATION", "J", "defaultTimer", "HIDE_VIEW_DELAY_TIME", "Lcom/bytedance/android/live/room/api/visibilitycontrol/f;", "timer$delegate", "Lkotlin/Lazy;", "getTimer", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/f;", UploadTypeInf.TIMER, "playbackDuration", "lastPlaybackStartTime", "prePlayingInPlayBack", "Z", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "activeClearWidget", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "widgetManager", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "Lio/reactivex/disposables/Disposable;", "shiftDisposal", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VisibilityControlService implements IVisibilityControlService {
    public static final a Companion = null;
    private static final String durationTag = null;
    private final long ANIM_DURATION;
    private final long HIDE_VIEW_DELAY_TIME;
    private com.bytedance.android.live.room.api.visibilitycontrol.c activeClearWidget;
    private LiveVisibilityControlContext context;
    private final long defaultTimer;
    private long lastPlaybackStartTime;
    private long playbackDuration;
    private boolean prePlayingInPlayBack;
    private Disposable shiftDisposal;
    private final Lazy timer$delegate;
    private WidgetManager widgetManager;

    public static final class a {
        public static String a() {
            return "VisibilityControlService#" + VisibilityControlService.Companion.hashCode();
        }

        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VisibilityControlService f98861a;

        public b(VisibilityControlService r100) {
            this.f98861a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ALogger.d("enterRoomInPlayback", "shift countdown 结束，setPlayBackAbilityInShift true");
            VisibilityControlService.access$getContext$p(this.f98861a).setPlayBackAbilityInShift(true);
        }
    }

    private final com.bytedance.android.live.room.api.visibilitycontrol.f getTimer() {
        return (com.bytedance.android.live.room.api.visibilitycontrol.f) this.timer$delegate.getValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void clearControlWidget() {
        this.activeClearWidget = null;
        Companion.getClass();
        ALogger.w(a.a(), "clear activeWidget!");
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void releaseService() {
        this.activeClearWidget = null;
        this.widgetManager = null;
        com.bytedance.android.live.room.api.visibilitycontrol.f r100 = getTimer();
        r100.a();
        r100.f99178a = null;
        Companion.getClass();
        ALogger.w(a.a(), "release service");
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void startPlayBackTimer() {
        this.prePlayingInPlayBack = true;
        this.lastPlaybackStartTime = System.currentTimeMillis();
        String r100 = durationTag;
        ALogger.d(r100, "startPlayBackTimer");
        ALogger.d(r100, "lastPlaybackStartTime is " + this.lastPlaybackStartTime);
    }

    static {
        Companion = new a();
        durationTag = "durationTag";
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void changeTetrisVisible() {
        LiveVisibilityControlContext r100 = this.context;
        r100.setPlaybackVisibleValue(!r100.getPlaybackVisibleValue());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void changeVisibilityStatus() {
        LiveVisibilityControlContext r100 = this.context;
        r100.setViewVisibleValue(!r100.getViewVisibleMutable().getValue().booleanValue());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public boolean getLockStatus() {
        return this.context.isLocked().getValue().booleanValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public boolean getVisibilityStatus() {
        return this.context.getViewVisibleMutable().getValue().booleanValue();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void markVisibilityStatusChangeByUser() {
        this.context.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void onUnload() {
        Disposable r100 = this.shiftDisposal;
        if (r100 != null) goto L5;
    L10:
        this.context.setPlaybackVisibleValue(false);
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void pausePlayBackTimer() {
        if (this.lastPlaybackStartTime != 0) goto L5;
    L7:
        this.prePlayingInPlayBack = false;
        return;
    L5:
        if (this.prePlayingInPlayBack == false) goto L7;
        String r100 = durationTag;
        ALogger.d(r100, "pausePlayBackTimer");
        ALogger.d(r100, "lastPlaybackStartTime is " + this.lastPlaybackStartTime);
        long r101 = System.currentTimeMillis();
        ALogger.d(r100, "currentTimeMillis is " + r101);
        long r102 = r101 - this.lastPlaybackStartTime;
        this.playbackDuration = this.playbackDuration + r102;
        ALogger.d(r100, "该事件段消费时长为 is " + r102);
        ALogger.d(r100, "playbackDuration update to " + this.playbackDuration);
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void resetHideTask() {
        this.context.getResetHideTaskEvent().post(Unit.INSTANCE);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void resetPlayBackTimer() {
        this.playbackDuration = 0;
        this.lastPlaybackStartTime = 0;
        this.prePlayingInPlayBack = false;
    }

    public VisibilityControlService() {
        this.ANIM_DURATION = 300;
        this.defaultTimer = 5;
        this.HIDE_VIEW_DELAY_TIME = 5000;
        this.timer$delegate = LazyKt.lazy(VisibilityControlService$timer$2.INSTANCE);
        this.context = new LiveVisibilityControlContext();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public Observable<Unit> startVisibilityTimer() {
        com.bytedance.android.live.room.api.visibilitycontrol.f r100 = getTimer();
        long r101 = this.defaultTimer;
        r100.getClass();
        ALogger.d(LiveVisibilityControlContext.timerTag, "start countdown, duration is " + r101);
        r100.a();
        r100.f99178a = Observable.timer(r101, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.api.visibilitycontrol.e(r100));
        return r100.f99180c;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void stopVisibilityTimer() {
        getTimer().a();
    }

    public static final /* synthetic */ String access$getDurationTag$cp() {
        return durationTag;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public WidgetManager getWidgetManager() {
        return this.widgetManager;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public LiveVisibilityControlContext provideContext() {
        return this.context;
    }

    public static final /* synthetic */ LiveVisibilityControlContext access$getContext$p(VisibilityControlService r100) {
        return r100.context;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void addControlItem(com.bytedance.android.live.room.api.visibilitycontrol.d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.live.room.api.visibilitycontrol.c r101 = this.activeClearWidget;
        if (r101 == null) goto L9;
        r101.addControlItem(r100);
        Companion.getClass();
        String r102 = a.a();
        StringBuilder r103 = new StringBuilder("activeWidget[");
        com.bytedance.android.live.room.api.visibilitycontrol.c r104 = this.activeClearWidget;
        if (r104 == null) goto L7;
        int r105 = r104.hashCode();
    L8:
        r103.append(r105);
        r103.append("] not null,do direct add, key:");
        r103.append(r100.f99168f.getDescribe());
        ALogger.d(r102, r103.toString());
        return;
    L7:
        r105 = 0;
        goto L8
    L9:
        this.context.getTmpControlItemList().add(r100);
        Companion.getClass();
        ALogger.w(a.a(), "activeWidget null,add to tmp list,key:" + r100.f99168f.getDescribe());
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void countDownShift(long r100) {
        Disposable r101 = this.shiftDisposal;
        if (r101 != null) goto L5;
    L10:
        this.shiftDisposal = Observable.timer(r100, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L5:
        if ((!r101.isDisposed()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r101.dispose();
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public NextLiveData<Integer> getControlItemStatus(LiveVisibilityControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r101 = this.activeClearWidget;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.wd(r100);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void injectWidgetManager(WidgetManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.activeClearWidget = null;
        this.widgetManager = r100;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void registerControlWidget(com.bytedance.android.live.room.api.visibilitycontrol.c r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.activeClearWidget = r100;
        Companion.getClass();
        String r101 = a.a();
        StringBuilder r102 = new StringBuilder("register activeWidget![");
        com.bytedance.android.live.room.api.visibilitycontrol.c r103 = this.activeClearWidget;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L6:
        r102.append(r104);
        r102.append(']');
        ALogger.w(r101, r102.toString());
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void removeControlItem(LiveVisibilityControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r101 = this.activeClearWidget;
        if (r101 == null) goto L10;
        r101.removeControlItem(r100);
        Companion.getClass();
        String r102 = a.a();
        StringBuilder r103 = new StringBuilder("activeWidget[");
        com.bytedance.android.live.room.api.visibilitycontrol.c r104 = this.activeClearWidget;
        if (r104 == null) goto L7;
        int r105 = r104.hashCode();
    L8:
        r103.append(r105);
        r103.append("] not null,do remove, key:");
        r103.append(r100.getDescribe());
        ALogger.d(r102, r103.toString());
        return;
    L7:
        r105 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setAutoHideTaskEnable(boolean r100) {
        this.context.getAutoHideTaskEnable().setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setLockStatus(boolean r100) {
        this.context.isLocked().setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setVisibilityStatus(boolean r100) {
        this.context.setViewVisibleValue(r100);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void shutdownPlayback(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        LiveVisibilityControlContext r101 = this.context;
        if (r101 == null) goto L5;
        r101.setPlayBackAbilityInMsg(false);
    L5:
        LiveVisibilityControlContext r102 = this.context;
        if (r102 == null) goto L8;
        r102.setPlaybackVisibleValue(false);
    L8:
        setControlItemStatus(LiveVisibilityControl.KEY.LiveProgressBar, false);
        setControlItemStatus(LiveVisibilityControl.KEY.LivePlayControl, false);
        setControlItemStatus(LiveVisibilityControl.KEY.LiveThumb, false);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public long stopPlayBackTimer(boolean r100) {
        String r101 = durationTag;
        ALogger.d(r101, "stopPlayBackTimer");
        if (r100 == true) goto L5;
    L7:
        ALogger.d(r101, "playbackDuration is  " + this.playbackDuration);
        return this.playbackDuration;
    L5:
        if (this.prePlayingInPlayBack == false) goto L7;
        this.playbackDuration += System.currentTimeMillis() - this.lastPlaybackStartTime;
        goto L7
    }

    public static final /* synthetic */ void access$setContext$p(VisibilityControlService r100, LiveVisibilityControlContext r101) {
        r100.context = r101;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setControlItemStatus(LiveVisibilityControl.KEY r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r102 = this.activeClearWidget;
        if (r102 == null) goto L6;
        r102.Gc(r100, r101, this.ANIM_DURATION);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setVisibilityStatus(boolean r100, long r101) {
        Companion.getClass();
        ALogger.w(a.a(), "setVisibilityStatus[" + r100 + "] with customDuration:" + r101);
        this.context.getCustomAnimDuration().setValue(Long.valueOf(r101));
        this.context.setViewVisibleValue(r100);
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void setControlItemStatus(LiveVisibilityControl.KEY r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.c r103 = this.activeClearWidget;
        if (r103 == null) goto L6;
        r103.Gc(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlService
    public void addControlItem(LiveVisibilityControl.KEY r110, LiveVisibilityControl.Type r111, LiveVisibilityControl.Style r112, View r113, float r114, boolean r115, boolean r116, com.bytedance.android.live.room.api.visibilitycontrol.a r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "style");
        Intrinsics.checkNotNullParameter(r113, "view");
        if (r117 == null) goto L5;
        com.bytedance.android.live.room.api.visibilitycontrol.d r100 = new com.bytedance.android.live.room.api.visibilitycontrol.d(r110, r117, r113, r111, r112, r114, r115, r116, r210);
    L6:
        addControlItem(r100);
        return;
    L5:
        r100 = new com.bytedance.android.live.room.api.visibilitycontrol.d(r110, null, r113, r111, r112, r114, r115, r116, r210);
        goto L6
    }
}
