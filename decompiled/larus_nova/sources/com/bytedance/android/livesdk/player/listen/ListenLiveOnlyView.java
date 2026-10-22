package com.bytedance.android.livesdk.player.listen;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.a11;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ListenLiveEventHandler;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004R#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/player/listen/ListenLiveOnlyView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdkapi/model/ListenLiveEventHandler;", "Lcom/bytedance/android/livesdk/config/a11;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getListenConfig", "()Lcom/bytedance/android/livesdk/config/a11;", "listenConfig", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "h", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getPlayerClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "playerClient", "Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus;", "getListenLiveStatus", "()Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus;", "listenLiveStatus", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListenLiveOnlyView extends FrameLayout implements Observer<KVData>, ListenLiveEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f155559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f155560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f155561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f155562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ListenLiveOnlyView$switchResolutionObserver$1 f155563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f155564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f155565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f155566h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILivePlayerClient f155567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155568b;

        public a(ILivePlayerClient r100, ListenLiveOnlyView r101) {
            this.f155567a = r100;
            this.f155568b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            ILivePlayerClient r102 = this.f155567a;
            HashMap<String, String> r103 = new HashMap();
            if (this.f155567a.isSupportResolutionSwitch(ListenLiveOnlyView.a(this.f155568b).a()) == false) goto L5;
            String r104 = "true";
        L6:
            r103.put("is_support_ao", r104);
            Unit r105 = Unit.INSTANCE;
            r102.injectAppLoggerParams("live_player_play_end", r103);
            this.f155567a.getEventHub().getSwitchResolutionResult().observe(this.f155567a.getLifecycleOwner(), this.f155568b.f155563e);
            return;
        L5:
            r104 = "false";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155569a;

        public b(ListenLiveOnlyView r100) {
            this.f155569a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LiveFloatWindowStatus r101 = (LiveFloatWindowStatus) r100;
            if (r101.isShow() == false) goto L15;
            ILivePlayerScene r102 = r101.getScene();
            com.bytedance.android.livesdk.floatview.f.N0.getClass();
            if (Intrinsics.areEqual(r102, com.bytedance.android.livesdk.floatview.f.a.f125138a) == false) goto L8;
            String r103 = ListenLiveStatus.END_IN_ROOM_WINDOW;
        L14:
            ListenLiveOnlyView.b(this.f155569a).setEndReason(r103);
            this.f155569a.logDuration(r103);
            return;
        L8:
            if (Intrinsics.areEqual(r102, com.bytedance.android.livesdk.floatview.f.a.f125139b) == false) goto L10;
        L13:
            r103 = ListenLiveStatus.END_OUT_ROOM_WINDOW;
            goto L14
        L10:
            if (Intrinsics.areEqual(r102, com.bytedance.android.livesdk.floatview.f.a.f125140c) == true) goto L13;
            r103 = ListenLiveStatus.END_EXIT_ROOM;
            goto L14
        L15:
            ListenLiveOnlyView r104 = this.f155569a;
            r104.f155559a = System.currentTimeMillis();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155570a;

        public c(ListenLiveOnlyView r100) {
            this.f155570a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.d(this.f155570a.f155560b, "listen float window status error!");
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155571a;

        public d(ListenLiveOnlyView r100) {
            this.f155571a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ListenLiveStatus r101 = (ListenLiveStatus) this.f155571a.getDataCenter().get("cmd_change_listen_live_status", new ListenLiveStatus());
            r101.setOpen(!r101.isOpen());
            r101.setEndReason(ListenLiveStatus.END_USER_OPERATE);
            this.f155571a.getDataCenter().put("cmd_change_listen_live_status", r101);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155572a;

        public e(ListenLiveOnlyView r100) {
            this.f155572a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (ListenLiveOnlyView.b(this.f155572a).getInChanging() == false) goto L10;
            ALogger.d(this.f155572a.f155560b, "change ao resolution time out!");     // Catch: Throwable -> L7
            ListenLiveOnlyView.c(this.f155572a);     // Catch: Throwable -> L7
            return;
        }
    }

    public static final class f implements LivePlayerView.OperateInterceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenLiveOnlyView f155573a;

        @Override // com.bytedance.android.livesdkapi.roomplayer.LivePlayerView.OperateInterceptor
        public final boolean interceptSetVisible() {
            ListenLiveStatus r100 = (ListenLiveStatus) this.f155573a.getDataCenter().get("cmd_change_listen_live_status", null);
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isOpen() != true) goto L7;
            return true;
        }

        public f(ListenLiveOnlyView r100) {
            this.f155573a = r100;
        }
    }

    private final a11 getListenConfig() {
        return (a11) this.f155562d.getValue();
    }

    private final ListenLiveStatus getListenLiveStatus() {
        return (ListenLiveStatus) this.f155566h.get("cmd_change_listen_live_status", new ListenLiveStatus());
    }

    private final ILivePlayerClient getPlayerClient() {
        return LivePlatformPlayerManager.f();
    }

    public final void e() {
        ILivePlayerClient r100 = getPlayerClient();
        if (r100 != null) goto L6;
        ALogger.d(this.f155560b, "null player client! handleListenLiveSwitch failed! ");
        return;
    L6:
        IRenderView r101 = r100.getRenderView();
        ViewParent r102 = null;
        if (r101 == null) goto L9;
        ViewParent r103 = r101.getParent();
    L11:
        if ((r103 instanceof LivePlayerView) == false) goto L14;
        r102 = r103;
    L14:
        LivePlayerView r104 = (LivePlayerView) r102;
        if (r104 != null) goto L18;
        ALogger.d(this.f155560b, "null player view! handleListenLiveSwitch failed! ");
        return;
    L18:
        this.f155559a = System.currentTimeMillis();
        r104.setVisibility(4);
        setVisibility(0);
        r104.addOperateInterceptor(this.f155565g);
        getListenLiveStatus().setInChanging(false);
        if (z.m(this.f155566h, true) == false) goto L22;
        post(new com.bytedance.android.livesdk.player.listen.a(this));
    L22:
        ALogger.d(this.f155560b, "switch ao resolution success!");
        return;
    L9:
        r103 = null;
        goto L11
    }

    public final DataCenter getDataCenter() {
        return this.f155566h;
    }

    public static final /* synthetic */ a11 a(ListenLiveOnlyView r100) {
        return r100.getListenConfig();
    }

    public static final /* synthetic */ ListenLiveStatus b(ListenLiveOnlyView r100) {
        return r100.getListenLiveStatus();
    }

    public static final void c(ListenLiveOnlyView r100) {
        Context r101 = r100.getContext();
        if ((r101 instanceof Activity) == true) goto L5;
        r101 = null;
    L5:
        Activity r102 = (Activity) r101;
        if (r102 != null) goto L8;
    L12:
        f2.c("听播模式切换失败", 0);
        r100.getListenLiveStatus().setOpen(!r100.getListenLiveStatus().isOpen());
        r100.getListenLiveStatus().setChangedFailed(true);
        r100.f155566h.put("cmd_change_listen_live_status", r100.getListenLiveStatus());
        return;
    L8:
        if (r102.isFinishing() == false) goto L10;
        return;
    L10:
        if (r102.isDestroyed() == false) goto L12;
    }

    @Override // com.bytedance.android.livesdkapi.model.ListenLiveEventHandler
    public final void handleListenLiveSwitch(ListenLiveStatus r110) {
        Intrinsics.checkNotNullParameter(r110, "listenStatus");
        ILivePlayerClient r100 = getPlayerClient();
        if (r100 != null) goto L6;
        ALogger.d(this.f155560b, "null player client! handleListenLiveSwitch failed! ");
        return;
    L6:
        IRenderView r101 = r100.getRenderView();
        if (r101 == null) goto L9;
        ViewParent r102 = r101.getParent();
    L11:
        if ((r102 instanceof LivePlayerView) == true) goto L13;
        r102 = null;
    L13:
        LivePlayerView r103 = (LivePlayerView) r102;
        if (r103 != null) goto L18;
        ALogger.d(this.f155560b, "null player view! handleListenLiveSwitch failed! ");
        return;
    L18:
        if (r110.isInit() == false) goto L21;
        r110.setInit(false);
        return;
    L21:
        Integer r104 = (Integer) this.f155566h.get("data_link_state", 0);
        if (r104 == null) goto L24;
        int r105 = r104.intValue();
    L26:
        if (z.m(this.f155566h, true) == true) goto L28;
    L46:
        String r106 = getListenConfig().a();
        if (r110.isOpen() == false) goto L51;
        this.f155561c = r100.getCurrentResolution();
        r110.setInChanging(true);
        f2.c("正在切换至听播模式", 0);
        r100.switchResolution(getListenConfig().a(), "enter_listen_live", null);
        if (getListenConfig().c() == false) goto L54;
        postDelayed(this.f155564f, getListenConfig().d() * ((long) 1000));
    L54:
        r110.setChangedFailed(false);
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, this.f155566h, 0, 2);
        if (r107 == null) goto L59;
        m<ListenLiveStatus> r108 = r107.getListenLiveStatus();
        if (r108 == null) goto L59;
        r108.setValue(r110);
    L59:
        String r109 = this.f155560b;
        StringBuilder r111 = new StringBuilder();
        if (r110.isOpen() == false) goto L62;
        String r112 = "open";
    L63:
        r111.append(r112);
        r111.append(" listen live, change resolution to changedResolution : ");
        r111.append(r106);
        r111.append(", normalResolutionKey:");
        r111.append(this.f155561c);
        ALogger.d(r109, r111.toString());
        return;
    L62:
        r112 = "close";
        goto L63
    L51:
        r106 = this.f155561c;
        r103.setVisibility(0);
        setVisibility(8);
        r110.setInChanging(false);
        r100.resetLastSwitchResolutionOperation();
        r100.switchResolution(this.f155561c, "exit_listen_live", null);
        r103.removeOperateInterceptor(this.f155565g);
        if (r110.getChangedFailed() == true) goto L54;
        g r113 = u.l();
        HashMap r114 = new HashMap();
        x r115 = new x();
        r115.f4349a = "live";
        r115.f4353e = "click";
        r113.sendLog("livesdk_live_listening_stop", r114, new Object[]{Room.class, r115});
        ListenLiveEventHandler.DefaultImpls.logDuration$default(this, null, 1, null);
        goto L54
    L28:
        if (v.a(r105, 2) == false) goto L30;
    L41:
        boolean r116 = true;
    L42:
        if (r116 == false) goto L44;
        Context r117 = getContext();
        float r118 = 210.0f;
    L45:
        setPadding(0, (int) fm3.e.a(r117, r118), 0, 0);
        goto L46
    L44:
        r117 = getContext();
        r118 = 170.0f;
        goto L45
    L30:
        if (v.a(r105, 4) == true) goto L41;
        if (v.a(r105, 16) == true) goto L41;
        if (v.a(r105, 64) == true) goto L41;
        if (v.a(r105, 128) == true) goto L41;
        if (v.a(r105, 256) == true) goto L41;
        r116 = false;
        goto L42
    L24:
        r105 = 0;
        goto L26
    L9:
        r102 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.model.ListenLiveEventHandler
    public final void logDuration(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        r110 = getListenLiveStatus().getEndReason();
    L9:
        if (this.f155559a == (-1)) goto L11;
        HashMap r101 = new HashMap();
        r101.put("end_reason", r110);
        r101.put("duration", String.valueOf(System.currentTimeMillis() - this.f155559a));
        g r111 = u.l();
        x r102 = new x();
        r102.f4349a = "live";
        r102.f4353e = "click";
        r111.sendLog("livesdk_live_listening_duration", r101, new Object[]{Room.class, r102});
    L11:
        this.f155559a = -1;
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == 193203799) goto L12;
        return;
    L12:
        if (r102.equals("cmd_change_listen_live_status") == false) goto L17;
        ListenLiveStatus r103 = (ListenLiveStatus) r101.getData(null);
        if (r103 == null) goto L18;
        handleListenLiveSwitch(r103);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.lifecycle.Observer, com.bytedance.android.livesdk.player.listen.ListenLiveOnlyView$switchResolutionObserver$1] */
    public ListenLiveOnlyView(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100);
        this.f155566h = r101;
        this.f155559a = -1;
        this.f155560b = "listen_live";
        this.f155561c = "";
        this.f155562d = LazyKt.lazy(ListenLiveOnlyView$listenConfig$2.INSTANCE);
        ?? r102 = new ListenLiveOnlyView$switchResolutionObserver$1(this);
        this.f155563e = r102;
        this.f155564f = new e(this);
        this.f155565g = new f(this);
        View.inflate(r100, R.layout.ttlive_view_live_listen_only, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setVisibility(8);
        r101.observe("data_is_portrait", this);
        r101.observe("cmd_change_listen_live_status", this);
        r101.observe("data_online_changed_list", this);
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        if (r103 == null) goto L9;
        m<LiveFloatWindowStatus> r104 = r103.getFloatWindowStatus();
        if (r104 == null) goto L9;
        Observable<LiveFloatWindowStatus> r105 = r104.a();
        if (r105 == null) goto L9;
        r105.subscribe(new b(this), new c(this));
    L9:
        findViewById(R.id.live_listen_recover_live).setOnClickListener(new d(this));
        ILivePlayerClient r106 = getPlayerClient();
        if (r106 == null) goto L12;
        r106.getEventHub().getSwitchResolutionResult().observe(r106.getLifecycleOwner(), r102);
        r106.getEventHub().getStartPullStream().observeForever(new a(r106, this));
        return;
    L12:
        ALogger.d("listen_live", "null player client! observer switch resolution failed!");
    }

    public final void d(ViewGroup r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (getParent() == null) goto L12;
        ViewParent r102 = getParent();
        if ((r102 instanceof ViewGroup) == true) goto L9;
        r102 = null;
    L9:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 == null) goto L12;
        r103.removeView(this);
    L12:
        r100.addView(this);
        if (r101 == false) goto L15;
        setPadding(0, (int) fm3.e.a(getContext(), 170.0f), 0, 0);
        return;
    L15:
        setPadding(0, (int) fm3.e.a(getContext(), 108.0f), 0, 0);
    }
}
