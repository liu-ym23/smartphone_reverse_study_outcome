package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/ResolutionServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionServiceWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f161245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f161246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f161247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StreamUrl f161248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f161249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h80.d<gs0.c> f161250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f161251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f161252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RoomSession f161253i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResolutionServiceWidget f161254a;

        public a(ResolutionServiceWidget r100) {
            this.f161254a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != 4) goto L22;
            ResolutionServiceWidget r102 = this.f161254a;
            r102.getClass();
            IKtvService r103 = (IKtvService) jc1.k.f(IKtvService.class);
            if (r103 == null) goto L12;
            gd2.c r104 = r103.getChorusConcertService();
            if (r104 == null) goto L12;
            boolean r105 = r104.d();
        L14:
            if (((IInteractService) jc1.k.n(IInteractService.class)).isAudienceLinkEngineOn() == true) goto L20;
            if (r105 == true) goto L20;
            Context r106 = r102.context;
            if (r106 == null) goto L23;
            AudienceVideoResolutionManager.A(r106, r102.dataCenter);
            return;
        L23:
            return;
        L20:
            com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_cannot_switch_when_link, 0);
            return;
        L12:
            r105 = false;
            goto L14
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResolutionServiceWidget f161255a;

        public b(ResolutionServiceWidget r100) {
            this.f161255a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            ResolutionServiceWidget.wq(this.f161255a);
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResolutionServiceWidget f161256a;

        public c(ResolutionServiceWidget r100) {
            this.f161256a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            ResolutionServiceWidget.wq(this.f161256a);
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        RoomSession r100 = this.f161253i;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.room.p0 r101 = r100.getEventHub();
        if (r101 == null) goto L9;
        NextLiveData<Boolean> r102 = r101.getStartPull();
        if (r102 == null) goto L9;
        r102.removeObserver(this.f161251g);
    L9:
        RoomSession r103 = this.f161253i;
        if (r103 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.room.p0 r104 = r103.getEventHub();
        if (r104 == null) goto L16;
        NextLiveData<Boolean> r105 = r104.getSwitchStreamDataEvent();
        if (r105 == null) goto L16;
        r105.removeObserver(this.f161252h);
    L16:
        ILivePlayerClient r106 = LivePlatformPlayerManager.f();
        if (r106 == null) goto L30;
        IRoomEventHub r107 = r106.getEventHub();
        if (r107 == null) goto L30;
        ILivePlayerClient r108 = LivePlatformPlayerManager.f();
        if (r108 == null) goto L30;
        LifecycleOwner r109 = r108.getLifecycleOwner();
        if (r109 == null) goto L30;
        r107.getPlayerMediaError().removeObservers(r109);
        r107.getPlayResume().removeObservers(r109);
        MutableLiveData<SwitchResolutionResult> r110 = r107.getSwitchResolutionResult();
        if (r110 == null) goto L29;
        r110.removeObservers(r109);
    L29:
        r107.getPlayComplete().removeObservers(r109);
    L30:
        Disposable r111 = this.f161249e;
        if (r111 == null) goto L33;
        r111.dispose();
    L33:
        Disposable r112 = this.f161245a;
        if (r112 == null) goto L36;
        r112.dispose();
    L36:
        this.f161245a = null;
    }

    public final String xq() {
        StreamUrl r100 = this.f161248d;
        String r101 = null;
        if (r100 == null) goto L25;
        List<IQuality> r102 = r100.qualityList;
        if (r102 == null) goto L25;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        IQuality r105 = (IQuality) r104;
        if (r105 == null) goto L12;
        String r106 = r105.getSdkKey();
    L13:
        ILivePlayerClient r107 = LivePlatformPlayerManager.f();
        if (r107 == null) goto L16;
        String r108 = r107.getCurrentResolution();
    L18:
        if (TextUtils.equals(r106, r108) == false) goto L8;
    L21:
        IQuality r109 = (IQuality) r104;
        if (r109 == null) goto L25;
        r101 = r109.getName();
        goto L25
    L16:
        r108 = null;
        goto L18
    L12:
        r106 = null;
        goto L13
    L20:
        r104 = null;
    L25:
        if (TextUtils.isEmpty(r101) == false) goto L49;
        StreamUrl r110 = this.f161248d;
        String r111 = "";
        if (r110 != null) goto L30;
    L38:
        StreamUrl r112 = this.f161248d;
        if (r112 == null) goto L45;
        String r113 = r112.getDefaultQuality();
        if (r113 == null) goto L45;
        r111 = r113;
    L45:
        return AudienceVideoResolutionManager.g(r111);
    L30:
        if (r110.isMultiPullDataValid() != true) goto L38;
        StreamUrl r114 = this.f161248d;
        if (r114 == null) goto L50;
        String r115 = r114.getMultiStreamDefaultQualityName();
        if (r115 == null) goto L50;
        r111 = r115;
    L50:
        return AudienceVideoResolutionManager.g(r111);
    L49:
        return AudienceVideoResolutionManager.g(r101);
    }

    public ResolutionServiceWidget(RoomSession r100) {
        this.f161253i = r100;
        this.f161251g = new b(this);
        this.f161252h = new c(this);
    }

    public static final void wq(ResolutionServiceWidget r100) {
        r100.getClass();
        ILivePlayerClient r101 = LivePlatformPlayerManager.f();
        if (r101 == null) goto L19;
        IRoomEventHub r102 = r101.getEventHub();
        if (r102 == null) goto L22;
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L20;
        LifecycleOwner r104 = r103.getLifecycleOwner();
        if (r104 == null) goto L23;
        MutableLiveData<SwitchResolutionResult> r105 = r102.getSwitchResolutionResult();
        if (r105 == null) goto L15;
        r105.observe(r104, new d2(r100));
    L15:
        r102.getPlayResume().observe(r104, new e2(r100));
        MutableLiveData<String> r106 = r102.getResolutionDegrade();
        if (r106 == null) goto L21;
        r106.observe(r104, new f2(r100));
        return;
    L21:
        return;
    L23:
        return;
    L20:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Room r101 = com.bytedance.android.live.core.utils.z.o(this.dataCenter);
        nm1.m r102 = pm1.f.l();
        Disposable r103 = null;
        if (r102 != null) goto L5;
    L14:
        StreamUrl r104 = r101.getStreamUrl();
    L15:
        this.f161248d = r104;
        RoomContext.a r105 = RoomContext.Companion;
        RoomContext r106 = RoomContext.a.c(r105, this.dataCenter, 0, 2);
        if (r106 == null) goto L19;
        this.f161249e = r106.getCameraId().a().subscribe(new c2(this, r101));
    L19:
        this.f161247c = xq();
        ILivePlayerClient r107 = LivePlatformPlayerManager.f();
        if (r107 != null) goto L22;
        return;
    L22:
        if (r107.getLifecycleOwner() == null) goto L48;
        RoomSession r108 = this.f161253i;
        if (r108 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.room.p0 r109 = r108.getEventHub();
        if (r109 == null) goto L31;
        NextLiveData<Boolean> r110 = r109.getStartPull();
        if (r110 == null) goto L31;
        r110.observeForever(this.f161251g, true);
    L31:
        RoomSession r111 = this.f161253i;
        if (r111 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.room.p0 r112 = r111.getEventHub();
        if (r112 == null) goto L38;
        NextLiveData<Boolean> r113 = r112.getSwitchStreamDataEvent();
        if (r113 == null) goto L38;
        r113.observeForever(this.f161252h, true);
    L38:
        RoomContext r114 = RoomContext.a.c(r105, this.dataCenter, 0, 2);
        if (r114 == null) goto L45;
        com.bytedance.live.datacontext.m<Integer> r115 = r114.getOpenPanelInRoom();
        if (r115 == null) goto L45;
        Observable<Integer> r116 = r115.a();
        if (r116 == null) goto L45;
        r103 = r116.subscribe(new a(this));
    L45:
        this.f161245a = r103;
        return;
    L48:
        return;
    L5:
        if (r102.a(this.dataCenter) != true) goto L14;
        nm1.m r117 = pm1.f.l();
        if (r117 == null) goto L9;
        IBaseStreamUrl r118 = r117.E(this.dataCenter);
    L11:
        if ((r118 instanceof StreamUrl) == true) goto L13;
        r118 = null;
    L13:
        r104 = (StreamUrl) r118;
        goto L15
    L9:
        r118 = null;
        goto L11
    }
}
