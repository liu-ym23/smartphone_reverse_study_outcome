package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.li;
import com.bytedance.android.livesdk.config.setting.NewStartLiveFragmentConfig;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements com.bytedance.android.scope.o, nz.o, j00.e, com.bytedance.android.live.broadcast.api.scope.service.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nz.o f105477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f105478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f105479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<Boolean> f105480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<Integer> f105481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner f105482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner f105483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.sharedpref.e<String> f105484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f105485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f105486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i00.a f105487k;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f105488a;

        public a(b0 r100) {
            this.f105488a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            b0 r101 = this.f105488a;
            r101.onLiveModeChange((LiveMode) r100);
        }
    }

    @Override // nz.o
    public final void a() {
        nz.o r100 = this.f105477a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // nz.o
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        nz.o r100 = this.f105477a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveStream();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f105487k.h() == false) goto L5;
        return;
    L5:
        this.f105487k.f(Reflection.getOrCreateKotlinClass(b0.class), this.f105487k.getScope());
        ALogger.i("BroadcastInLiveInstanceScope", "StreamFragmentManagerService start");
        PropertyOwner<LiveMode> r100 = this.f105485i.f105512e;
        r100.getClass();
        RxUtilKt.c(r100.subscribe(new a(this)), this.f105478b);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f105478b.clear();
    }

    @Override // nz.o
    public final void onLiveModeChange(LiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "liveMode");
        ALogger.i("StreamFragmentManagerService", "onLiveModeChange from " + this.f105485i.a() + " to " + r100);
        Boolean r101 = NewBroadcastMonitor.f64916a;
        NewBroadcastMonitor.i(r100);
        nz.o r102 = this.f105477a;
        if (r102 == null) goto L5;
        r102.onLiveModeChange(r100);
    L5:
        d(this.f105484h.getValue(), "liveMode_change");
    }

    public final void d(String r100, String r101) {
        LiveMode r102 = this.f105485i.a();
        if (r102 != LiveMode.VIDEO) goto L5;
    L7:
        FragmentActivity r103 = this.f105486j.getActivity();
        if (r103 == null) goto L12;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L12;
        Fragment r105 = r104.findFragmentByTag("IBroadcastStreamFragment");
    L13:
        if (r105 == null) goto L15;
        return;
    L15:
        c(this.f105486j.a().f105435h, r100, r101);
        return;
    L12:
        r105 = null;
        goto L13
    L5:
        if (r102 == LiveMode.MEDIA) goto L7;
        if (r102 == null) goto L7;
    }

    public b0(h r100, d r101, i00.a r102) {
        Intrinsics.checkNotNullParameter(r100, "roomService");
        Intrinsics.checkNotNullParameter(r101, "envInitService");
        Intrinsics.checkNotNullParameter(r102, "instance");
        this.f105485i = r100;
        this.f105486j = r101;
        this.f105487k = r102;
        this.f105478b = new CompositeDisposable();
        PropertyOwner<Boolean> r103 = new PropertyOwner(Boolean.FALSE);
        this.f105480d = r103;
        PropertyOwner<Integer> r104 = new PropertyOwner(-1);
        this.f105481e = r104;
        this.f105482f = r103;
        this.f105483g = r104;
        this.f105484h = new com.bytedance.android.livesdk.sharedpref.e("live_preview_stream_info", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v24, types: [androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r4v19, types: [androidx.fragment.app.FragmentTransaction, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v20, types: [androidx.fragment.app.FragmentTransaction] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    public final void c(StreamUrlExtra r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "streamUrlExtra");
        Intrinsics.checkNotNullParameter(r211, "sdkParams");
        Intrinsics.checkNotNullParameter(r212, "from");
        Room r100 = this.f105485i.f105508a;
        StringBuilder r101 = new StringBuilder("showBroadcastStreamFragment: ");
        r101.append(r212);
        r101.append(" , room = ");
        if (r100 == null) goto L6;
        String r102 = String.valueOf(r100.f162599id);
        if (r102 == null) goto L6;
    L7:
        r101.append(r102);
        ALogger.i("StreamFragmentManagerService", r101.toString());
        h r103 = this.f105485i;
        r103.getClass();
        r103.f105517j.c(fg1.k.q.f476813a);
        this.f105480d.a(Boolean.FALSE);
        this.f105481e.a(-1);
        FragmentActivity r104 = this.f105486j.getActivity();
        if (r104 == null) goto L103;
        FragmentManager r110 = r104.getSupportFragmentManager();
        if (r110 == null) goto L104;
        Fragment r105 = r110.findFragmentByTag("IBroadcastStreamFragment");
        if (r105 == null) goto L15;
        r110.beginTransaction().remove(r105).commitAllowingStateLoss();
        boolean r111 = true;
    L16:
        f00.h r106 = this.f105487k.getScope();
        com.bytedance.android.scope.m r107 = com.bytedance.android.scope.m.f163449e;
        c0 r108 = (c0) r107.d(r106, c0.class);
        if (r108 == null) goto L27;
        FragmentActivity r109 = r108.f105497b.getActivity();
        if (r109 == null) goto L27;
        FragmentManager r112 = r109.getSupportFragmentManager();
        if (r112 == null) goto L27;
        Fragment r113 = r112.findFragmentByTag("IBroadcastCoreFragment");
        if (r113 == null) goto L26;
        r112.beginTransaction().remove(r113).commitAllowingStateLoss();
    L26:
        r108.f105496a = null;
    L27:
        t r114 = (t) r107.d(this.f105487k.getScope(), t.class);
        if (r114 == null) goto L46;
        FragmentActivity r115 = r114.f105533c.getActivity();
        if (r115 == null) goto L34;
        FragmentManager r116 = r115.getSupportFragmentManager();
        if (r116 == null) goto L34;
        Fragment r117 = r116.findFragmentByTag(com.bytedance.android.live.room.h.I0);
    L35:
        if (r117 == null) goto L45;
        FragmentActivity r118 = r114.f105533c.getActivity();
        if (r118 == null) goto L45;
        FragmentManager r119 = r118.getSupportFragmentManager();
        if (r119 == null) goto L45;
        FragmentTransaction r120 = r119.beginTransaction();
        if (r120 == null) goto L45;
        FragmentTransaction r121 = r120.remove(r117);
        if (r121 == null) goto L45;
        r121.commitAllowingStateLoss();
    L45:
        r114.f105531a = null;
    L34:
        r117 = null;
    L46:
        LiveMode r122 = this.f105485i.a();
        if (r122 != null) goto L49;
        r122 = LiveMode.VIDEO;
    L49:
        LiveMode r123 = r122;
        IBroadcastService r124 = (IBroadcastService) jc1.k.n(IBroadcastService.class);
        if (((Number) NewStartLiveFragmentConfig.f121206b.getValue()).intValue() > 0) goto L52;
    L57:
        boolean r125 = false;
    L58:
        if (r125 == false) goto L60;
        nz.k r126 = new n();
    L61:
        Bundle r127 = new Bundle();
        r127.putBoolean("is_all_in_one", this.f105486j.a().f105428a);
        r127.putBoolean("is_all_in_one_in_preview", this.f105485i.aO());
        LiveMode r128 = this.f105485i.a();
        Room r129 = this.f105485i.f105508a;
        if (r128 != LiveMode.VIDEO) goto L80;
        if (li.f120681a.getValue().isEnable() == true) goto L78;
        if (r129 == null) goto L78;
        AnchorData r130 = r129.getAnchorData();
        if (r130 == null) goto L78;
        String r131 = r130.getFrameScale();
        if (r131 == null) goto L78;
        if (r131.length() <= 0) goto L73;
        boolean r132 = true;
    L75:
        if (r132 == true) goto L80;
    L73:
        r132 = false;
    L78:
        boolean r133 = true;
    L81:
        r127.putBoolean("need_restart_live_stream", !r133);
        Long r134 = this.f105486j.a().f105440m;
        if (r134 == null) goto L84;
        long r135 = r134.longValue();
    L85:
        r127.putLong("extra_live_start_session_code", r135);
        r127.putBoolean("extra_direct_enter_activity", this.f105486j.a().f105429b);
        Unit r136 = Unit.INSTANCE;
        ?? r137 = r124.createBroadcastStreamFragment(r126, r123, r210, r211, r127);
        if ((r137 instanceof nz.o) == false) goto L88;
        this.f105477a = (nz.o) r137;
    L88:
        ?? r138 = r110.beginTransaction();
        boolean r139 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r138, r137, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "IBroadcastStreamFragment", R.id.stream_container);
        ?? r140 = r138;
        if (r139 == true) goto L92;
        r140 = r138.add(R.id.stream_container, r137, "IBroadcastStreamFragment");
    L92:
        r140.commitAllowingStateLoss();
        this.f105479c = true;
        if (r100 == null) goto L96;
        String r141 = String.valueOf(r100.f162599id);
        if (r141 == null) goto L96;
    L97:
        NewBroadcastMonitor.a r142 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_SHOW_BROADCAST_STREAM_FRAGMENT, null, null, 14);
        r142.l(0);
        if (r111 == false) goto L100;
        String r143 = "1";
    L101:
        r142.i("remove_old", r143);
        r142.i("from", r212);
        r142.i("room_id", r141);
        r142.i("live_mode", r123.name());
        r142.a().report();
        return;
    L100:
        r143 = "0";
    L96:
        r141 = "";
        goto L97
    L84:
        r135 = 0;
    L80:
        r133 = false;
        goto L81
    L60:
        r126 = new w(this.f105487k, this.f105485i, this);
        goto L61
    L52:
        if (r123 != LiveMode.VIDEO) goto L54;
    L56:
        r125 = true;
        goto L58
    L54:
        if (r123 == LiveMode.MEDIA) goto L56;
        if (r123 != null) goto L57;
    L15:
        r111 = false;
        goto L16
    L104:
        return;
    L103:
        return;
    L6:
        r102 = "none";
        goto L7
    }
}
