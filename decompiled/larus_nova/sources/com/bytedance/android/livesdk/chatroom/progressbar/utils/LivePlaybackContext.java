package com.bytedance.android.livesdk.chatroom.progressbar.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.utils.h1;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.config.ki0;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.message.model.fj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001e\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0019\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b4\u00105J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u0000J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00100\u001a\u0004\u0018\u00010/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progressbar/utils/LivePlaybackContext;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/live/datacontext/DataContext;", "", "doOnRelease", "", "mode", "", "isLink", "isStreamHorizontal", "shutdownPlayBack", "initialize", "Ltlc/d;", "message", "onMessage", "t", "onChanged", "Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "controlService$delegate", "Lkotlin/Lazy;", "getControlService", "()Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "controlService", "Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "controlContext$delegate", "getControlContext", "()Lcom/bytedance/android/live/room/api/visibilitycontrol/LiveVisibilityControlContext;", "controlContext", "com/bytedance/android/livesdk/chatroom/progressbar/utils/LivePlaybackContext$progressChangeListener$2$a", "progressChangeListener$delegate", "getProgressChangeListener", "()Lcom/bytedance/android/livesdk/chatroom/progressbar/utils/LivePlaybackContext$progressChangeListener$2$a;", "progressChangeListener", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "stopObserver$delegate", "getStopObserver", "()Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "stopObserver", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "dataContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getDataContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdk/chatroom/RoomContext;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlaybackContext extends DataContext implements l, Observer<KVData> {

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private CompositeDisposable f107886cd;
    private final Lazy controlContext$delegate;
    private final Lazy controlService$delegate;
    private final DataCenter dataCenter;
    private final RoomContext dataContext;
    private final Lazy progressChangeListener$delegate;
    private final Lazy stopObserver$delegate;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlaybackContext f107887a;

        public a(LivePlaybackContext r100) {
            this.f107887a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            LivePlaybackContext.access$getCd$p(this.f107887a).clear();
            d r100 = n3.e(this.f107887a.getDataCenter());
            if (r100 == null) goto L5;
            r100.removeMessageListener(MessageType.LIVE_PLAY_BACK_SIGNAL.getIntType(), this.f107887a);
        L5:
            rk1.a r101 = (rk1.a) k.f(rk1.a.class);
            if (r101 == null) goto L10;
            IPlayerProgressService r102 = r101.M4(this.f107887a.getDataCenter());
            if (r102 == null) goto L10;
            r102.removeProgressChangeListener(LivePlaybackContext.access$getProgressChangeListener$p(this.f107887a));
        L10:
            ILivePlayerClient r103 = LivePlatformPlayerManager.c(z.o(this.f107887a.getDataCenter()).getRoomId(), false).player();
            if (r103 == null) goto L18;
            IRoomEventHub r104 = r103.getEventHub();
            if (r104 == null) goto L19;
            MutableLiveData<Boolean> r105 = r104.getStopped();
            if (r105 == null) goto L20;
            r105.removeObserver(LivePlaybackContext.access$getStopObserver$p(this.f107887a));
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlaybackContext f107888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRoomEventHub f107889b;

        public b(LivePlaybackContext r100, IRoomEventHub r101) {
            this.f107888a = r100;
            this.f107889b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = Boolean.FALSE;
            if (Intrinsics.areEqual((Boolean) r100, r101) == false) goto L15;
            IRoomEventHub r102 = this.f107889b;
            if (r102 == null) goto L9;
            MutableLiveData<Boolean> r103 = r102.getStopped();
            if (r103 == null) goto L9;
            Boolean r104 = r103.getValue();
        L11:
            if (Intrinsics.areEqual(r104, r101) == false) goto L15;
            IVisibilityControlService r105 = LivePlaybackContext.access$getControlService$p(this.f107888a);
            if (r105 == null) goto L19;
            r105.startPlayBackTimer();
            return;
        L19:
            return;
        L9:
            r104 = null;
        L15:
            IVisibilityControlService r106 = LivePlaybackContext.access$getControlService$p(this.f107888a);
            if (r106 == null) goto L21;
            r106.pausePlayBackTimer();
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePlaybackContext f107890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IPlayerProgressService f107891b;

        public c(LivePlaybackContext r100, IPlayerProgressService r101) {
            this.f107890a = r100;
            this.f107891b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            LiveVisibilityControlContext r102 = LivePlaybackContext.access$getControlContext$p(this.f107890a);
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.enablePlayBackAbility() != true) goto L18;
            int r103 = ClearScreenConst$InteractType.INTERACT_SHOW.getId();
            if (r101 != null) goto L10;
            return;
        L10:
            if (r101.intValue() == r103) goto L12;
            return;
        L12:
            if (z.m(this.f107890a.getDataCenter(), true) == true) goto L14;
            return;
        L14:
            if (LivePlaybackContext.access$isStreamHorizontal(this.f107890a) == true) goto L21;
            RxUtilKt.c(Observable.timer(800, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.progressbar.utils.a(this)), LivePlaybackContext.access$getCd$p(this.f107890a));
            return;
        L21:
            return;
        }
    }

    private final LiveVisibilityControlContext getControlContext() {
        return (LiveVisibilityControlContext) this.controlContext$delegate.getValue();
    }

    private final IVisibilityControlService getControlService() {
        return (IVisibilityControlService) this.controlService$delegate.getValue();
    }

    private final LivePlaybackContext$progressChangeListener$2.a getProgressChangeListener() {
        return (LivePlaybackContext$progressChangeListener$2.a) this.progressChangeListener$delegate.getValue();
    }

    private final Observer<Boolean> getStopObserver() {
        return (Observer) this.stopObserver$delegate.getValue();
    }

    private final boolean isStreamHorizontal() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r100 == null) goto L11;
        n<Function0<Boolean>> r101 = r100.isStreamHorizontal();
        if (r101 == null) goto L11;
        Function0<Boolean> r102 = r101.getValue();
        if (r102 == null) goto L11;
        if (r102.invoke().booleanValue() != true) goto L11;
        return true;
    L11:
        return false;
    }

    private final void shutdownPlayBack() {
        PlayerProgressServiceContext.a r100 = PlayerProgressServiceContext.Companion;
        DataCenter r101 = this.dataCenter;
        r100.getClass();
        PlayerProgressServiceContext r102 = PlayerProgressServiceContext.a.a(r101);
        IVisibilityControlService r103 = null;
        if (r102 == null) goto L7;
        m<Boolean> r104 = r102.getAtLatest();
        if (r104 == null) goto L7;
        Boolean r105 = r104.getValue();
    L9:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L11;
        f2.c(ki0.f120605a.getValue().audienceCloseToast, 0);
    L11:
        IPlayerProgressService r106 = ((rk1.a) k.n(rk1.a.class)).M4(this.dataCenter);
        if (r106 == null) goto L14;
        r106.setAtLatest(true);
    L14:
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r107 == null) goto L21;
        h r108 = i.c(r107);
        if (r108 == null) goto L21;
        j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r109 = r108.getPublicScreenContext();
        if (r109 == null) goto L21;
        r109.c(AnonymousClass1.INSTANCE);
    L21:
        IVisibilityControlBrickService r110 = (IVisibilityControlBrickService) k.f(IVisibilityControlBrickService.class);
        if (r110 == null) goto L24;
        r103 = r110.provideVisibilityControlService(this.dataCenter);
    L24:
        if (r103 == null) goto L27;
        r103.shutdownPlayback(this.dataCenter);
        return;
    L27:
        return;
    L7:
        r105 = null;
        goto L9
    }

    public final LivePlaybackContext initialize() {
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == true) goto L5;
        return this;
    L5:
        IPlayerProgressService r100 = ((rk1.a) k.n(rk1.a.class)).M4(this.dataCenter);
        d r101 = n3.e(this.dataCenter);
        if (r101 == null) goto L8;
        r101.addMessageListener(MessageType.LIVE_PLAY_BACK_SIGNAL.getIntType(), this);
    L8:
        this.dataCenter.observe("data_link_state", this, true);
        ILivePlayerClient r102 = LivePlatformPlayerManager.c(z.o(this.dataCenter).getRoomId(), false).player();
        if (r102 == null) goto L11;
        IRoomEventHub r103 = r102.getEventHub();
    L12:
        if (r103 == null) goto L16;
        MutableLiveData<Boolean> r104 = r103.getStopped();
        if (r104 == null) goto L16;
        r104.observeForever(getStopObserver());
    L16:
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L27;
        PlayerProgressServiceContext.Companion.getClass();
        PlayerProgressServiceContext r106 = PlayerProgressServiceContext.a.a(r105);
        if (r106 == null) goto L27;
        m<Boolean> r107 = r106.getAtLatest();
        if (r107 == null) goto L27;
        Observable<Boolean> r108 = r107.a();
        if (r108 == null) goto L27;
        Disposable r109 = r108.subscribe(new b(this, r103));
        if (r109 == null) goto L27;
        RxUtilKt.c(r109, this.f107886cd);
    L27:
        LiveVisibilityControlContext r110 = getControlContext();
        if (r110 == null) goto L34;
        m<Boolean> r111 = r110.getPlayBackAbilityInShiftMutable();
        if (r111 == null) goto L34;
        Disposable r112 = i80.a.a(r111, new AnonymousClass2(this));
        if (r112 == null) goto L34;
        RxUtilKt.c(r112, this.f107886cd);
    L34:
        rk1.a r113 = (rk1.a) k.f(rk1.a.class);
        if (r113 == null) goto L40;
        IPlayerProgressService r114 = r113.M4(this.dataCenter);
        if (r114 == null) goto L40;
        r114.addProgressChangeListener(getProgressChangeListener());
    L40:
        if (z.m(this.dataCenter, true) != true) goto L48;
        RoomContext r115 = this.dataContext;
        if (r115 == null) goto L48;
        m<Integer> r116 = r115.getCleanMode();
        if (r116 == null) goto L48;
        Disposable r117 = i80.a.a(r116, new AnonymousClass3(this));
        if (r117 == null) goto L48;
        RxUtilKt.c(r117, this.f107886cd);
    L48:
        RoomContext r118 = this.dataContext;
        if (r118 == null) goto L57;
        m<Integer> r119 = r118.getCleanMode();
        if (r119 == null) goto L57;
        Observable<Integer> r120 = r119.a();
        if (r120 == null) goto L57;
        Disposable r121 = r120.subscribe(new c(this, r100));
        if (r121 == null) goto L57;
        RxUtilKt.c(r121, this.f107886cd);
    L57:
        doOnRelease();
        return this;
    L11:
        r103 = null;
        goto L12
    }

    private final void doOnRelease() {
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), this.f107886cd);
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final RoomContext getDataContext() {
        return this.dataContext;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LivePlaybackContext r100) {
        return r100.f107886cd;
    }

    public static final /* synthetic */ LiveVisibilityControlContext access$getControlContext$p(LivePlaybackContext r100) {
        return r100.getControlContext();
    }

    public static final /* synthetic */ IVisibilityControlService access$getControlService$p(LivePlaybackContext r100) {
        return r100.getControlService();
    }

    public static final /* synthetic */ LivePlaybackContext$progressChangeListener$2.a access$getProgressChangeListener$p(LivePlaybackContext r100) {
        return r100.getProgressChangeListener();
    }

    public static final /* synthetic */ Observer access$getStopObserver$p(LivePlaybackContext r100) {
        return r100.getStopObserver();
    }

    public static final /* synthetic */ boolean access$isStreamHorizontal(LivePlaybackContext r100) {
        return r100.isStreamHorizontal();
    }

    private final boolean isLink(int r100) {
        if (v.a(r100, 2) == false) goto L5;
    L20:
        return true;
    L5:
        if (v.a(r100, 4) == true) goto L20;
        if (v.a(r100, 8) == true) goto L20;
        if (v.a(r100, 16) == true) goto L20;
        if (v.a(r100, 32) == true) goto L20;
        if (v.a(r100, 64) == true) goto L20;
        if (v.a(r100, 128) == true) goto L20;
        if (v.a(r100, 256) == true) goto L20;
        return false;
    }

    public void onChanged(KVData r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getKey();
    L5:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.hashCode() == 872172481) goto L11;
        return;
    L11:
        if (r101.equals("data_link_state") == false) goto L37;
        Integer r102 = (Integer) this.dataCenter.get("data_link_state", 0);
        h1.a r103 = h1.f114487b;
        DataCenter r104 = this.dataCenter;
        r103.getClass();
        LiveVisibilityControlContext r105 = h1.a.f(r104);
        if (r105 == null) goto L25;
        m<Boolean> r106 = r105.getPlayBackAbilityInMsgMutable();
        if (r106 == null) goto L25;
        if (r106.getValue().booleanValue() != true) goto L25;
        if (isLink(r102.intValue()) == false) goto L25;
        LiveVisibilityControlContext r107 = h1.a.f(this.dataCenter);
        if (r107 == null) goto L25;
        if (r107.enablePlayBackAbility() != true) goto L25;
        ALogger.i("shutdownPlayback", "shutdown playback because of DATA_LINK_STATE");
        shutdownPlayBack();
        return;
    L25:
        LiveVisibilityControlContext r108 = h1.a.f(this.dataCenter);
        if (r108 == null) goto L39;
        m<Boolean> r109 = r108.getPlayBackAbilityInMsgMutable();
        if (r109 != null) goto L30;
        return;
    L30:
        if (r109.getValue().booleanValue() == true) goto L32;
        return;
    L32:
        if (isLink(r102.intValue()) == false) goto L42;
        LiveVisibilityControlContext r110 = h1.a.f(this.dataCenter);
        if (r110 == null) goto L43;
        r110.setPlayBackAbilityInMsg(false);
        return;
    L43:
        return;
    L42:
        return;
    L39:
        return;
    L37:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // vlc.l
    public void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof fj) == false) goto L25;
        h1.a r101 = h1.f114487b;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        LiveVisibilityControlContext r103 = h1.a.f(r102);
        if (r103 == null) goto L14;
        m<Boolean> r104 = r103.getEnablePlaybackMutable();
        if (r104 == null) goto L14;
        if (r104.getValue().booleanValue() != true) goto L14;
        if (((fj) r100).realtimePlaybackEnabled == true) goto L26;
        ALogger.i("shutdownPlayback", "shutdown playback because of RealTimePlayBackMessage");
        shutdownPlayBack();
        return;
    L26:
        return;
    L14:
        LiveVisibilityControlContext r105 = h1.a.f(this.dataCenter);
        if (r105 == null) goto L28;
        m<Boolean> r106 = r105.getPlayBackAbilityInMsgMutable();
        if (r106 != null) goto L19;
        return;
    L19:
        if (r106.getValue().booleanValue() != true) goto L30;
        LiveVisibilityControlContext r107 = h1.a.f(this.dataCenter);
        if (r107 == null) goto L31;
        r107.setPlayBackAbilityInMsg(false);
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        onChanged((KVData) r100);
    }

    public LivePlaybackContext(DataCenter r100, RoomContext r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.dataCenter = r100;
        this.dataContext = r101;
        this.controlService$delegate = LazyKt.lazy(new LivePlaybackContext$controlService$2(this));
        this.controlContext$delegate = LazyKt.lazy(new LivePlaybackContext$controlContext$2(this));
        this.progressChangeListener$delegate = LazyKt.lazy(new LivePlaybackContext$progressChangeListener$2(this));
        this.f107886cd = new CompositeDisposable();
        this.stopObserver$delegate = LazyKt.lazy(new LivePlaybackContext$stopObserver$2(this));
    }

    public static final /* synthetic */ void access$setCd$p(LivePlaybackContext r100, CompositeDisposable r101) {
        r100.f107886cd = r101;
    }
}
