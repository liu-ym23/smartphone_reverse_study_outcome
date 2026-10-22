package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.VSOptimizeUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.c0;
import com.bytedance.android.livesdk.model.d0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.TouchEventFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MultiCameraBasicInfo;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import j40.f4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/PortraitHorizontalLinkedCameraTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitHorizontalLinkedCameraTetris extends LiveTetris<d90.d> implements Observer<KVData>, o70.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f159595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TouchEventFrameLayout f159596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f159597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VideoViewParams f159598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f159599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WidgetElement f159600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public WidgetElement f159601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public q4.b f159602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public q4.b f159603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CompositeDisposable f159604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Disposable f159605y;

    public static final class a<T> implements h80.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitHorizontalLinkedCameraTetris f159606a;

        public a(PortraitHorizontalLinkedCameraTetris r100) {
            this.f159606a = r100;
        }

        @Override // h80.a
        public final void accept(Object r110) {
            IRoom r111 = (IRoom) r110;
            PortraitHorizontalLinkedCameraTetris r100 = this.f159606a;
            r100.getClass();
            Disposable r101 = null;
            if (c0.a(r111) == 2) goto L31;
            boolean r102 = lu2.b.j(r111);
            boolean r112 = RoomKt.hasMultiCamera(r111);
            if (r102 == true) goto L8;
            if (r112 == false) goto L31;
        L8:
            int r113 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.f159779a;
            DataCenter r114 = r100.getDataCenter();
            if (r114 == null) goto L13;
            IRoom r115 = lu2.c.f(r114);
            if (r115 == null) goto L13;
            String r116 = String.valueOf(r115.getId());
        L14:
            if (r116 == null) goto L31;
            d0 r103 = f4.f497216s.getValue();
            if (r103 == null) goto L31;
            HashMap<String, Long> r104 = r103.f153936a;
            if (r104 == null) goto L31;
            long r105 = System.currentTimeMillis();
            Iterator<Map.Entry<String, Long>> r106 = r104.entrySet().iterator();
        L24:
            if (r106.hasNext() == false) goto L29;
            if ((r105 - r106.next().getValue().longValue()) <= BaseConstants.Time.WEEK) goto L24;
            r106.remove();
            goto L24
        L29:
            if (r104.containsKey(r116) == false) goto L32;
            com.bytedance.android.livesdk.sharedpref.e<d0> r117 = f4.f497216s;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r103.f153936a = r104;
            Unit r107 = Unit.INSTANCE;
            r117.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r117, r103);
            goto L31
        L32:
            r104.put(r116, Long.valueOf(r105));
            com.bytedance.android.livesdk.sharedpref.e<d0> r118 = f4.f497216s;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r103.f153936a = r104;
            Unit r108 = Unit.INSTANCE;
            r118.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r118, r103);
            boolean r119 = true;
        L33:
            if (r119 == false) goto L57;
            this.f159606a.b0(false);
            PortraitHorizontalLinkedCameraTetris r120 = this.f159606a;
            DataCenter r109 = r120.getDataCenter();
            int r121 = 5;
            if (r109 == null) goto L43;
            IRoom r122 = lu2.c.f(r109);
            if (r122 == null) goto L43;
            EpisodeExtraInfo r123 = lu2.c.a(r122);
            if (r123 == null) goto L43;
            MultiCameraBasicInfo r124 = r123.getMultiCameraBasicInfo();
            if (r124 == null) goto L43;
            int r125 = r124.getDefaultDisplayDuration();
        L44:
            if (r125 <= 0) goto L47;
            r121 = r125;
        L47:
            Disposable r126 = Observable.timer(r121, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r120));
            if (r126 == null) goto L50;
            RxUtilKt.c(r126, r120.f159604x);
            r101 = r126;
        L50:
            r120.f159605y = r101;
            return;
        L43:
            r125 = 5;
            goto L44
        L57:
            return;
        L13:
            r116 = null;
        L31:
            r119 = false;
            goto L33
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitHorizontalLinkedCameraTetris f159607a;

        public b(PortraitHorizontalLinkedCameraTetris r100) {
            this.f159607a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            this.f159607a.V();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitHorizontalLinkedCameraTetris f159608a;

        public c(PortraitHorizontalLinkedCameraTetris r100) {
            this.f159608a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f159608a.a0(false);
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(MultiCameraPanelEvent.class);
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        if (((VSOptimizeConfig) VSOptimizeUtils.f117919a.getValue()).getMultiCamera() == false) goto L26;
        DataCenter r100 = getDataCenter();
        IRoom r101 = null;
        if (r100 == null) goto L7;
        IRoom r102 = lu2.c.f(r100);
    L9:
        if (RoomKt.hasMultiCamera(r102) == true) goto L25;
        DataCenter r103 = getDataCenter();
        if (r103 == null) goto L14;
        r101 = lu2.c.f(r103);
    L14:
        if (lu2.c.b(r101) == true) goto L25;
        ou2.a r104 = ou2.c.a(getDataCenter());
        if (r104 == null) goto L28;
        com.bytedance.live.datacontext.k<Object> r105 = r104.getDataChanged();
        if (r105 == null) goto L29;
        PublishSubject r106 = r105.onEvent();
        if (r106 == null) goto L30;
        Disposable r107 = r106.subscribe(new c(this));
        if (r107 == null) goto L31;
        RxUtilKt.c(r107, this.f159604x);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L25:
        a0(true);
        return;
    L7:
        r102 = null;
        goto L9
    L26:
        a0(true);
    }

    public final void V() {
        a r100 = new a(this);
        u r101 = Z();
        if (r101 == null) goto L27;
        com.bytedance.live.datacontext.n<?> r102 = r101.g();
        Object r103 = null;
        if (r102 == null) goto L8;
        Object r104 = r102.getValue();
    L9:
        if (r104 != null) goto L11;
        com.bytedance.live.datacontext.n<?> r105 = r101.g();
        if (r105 == null) goto L24;
        Observable<sh6.b<?>> r106 = r105.a();
        if (r106 == null) goto L25;
        Disposable r107 = r106.subscribe(new j(r100));
        if (r107 == null) goto L26;
        RxUtilKt.c(r107, this.f159604x);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if ((r104 instanceof IRoom) == false) goto L14;
        r103 = r104;
    L14:
        r100.accept((IRoom) r103);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public PortraitHorizontalLinkedCameraTetris() {
        this.f159604x = new CompositeDisposable();
    }

    public final u Z() {
        return r.u(getDataCenter(), null, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DataCenter getDataCenter() {
        return ((d90.d) K()).f467480h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        u r100 = Z();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.z1();
        if (r101 == null) goto L7;
        r101.setValue(Boolean.FALSE);
    L7:
        DataCenter r102 = ((d90.d) K()).f467480h;
        if (r102 == null) goto L10;
        r102.removeObserver(this);
    L10:
        this.f159604x.clear();
        this.f159599s = false;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_vs_portrait_horizontal_linked_camera_panel_tetris);
        this.f159595o = (ViewGroup) r101.findViewById(R.id.top_mask);
        this.f159596p = (TouchEventFrameLayout) r101.findViewById(R.id.panel_container);
        this.f159597q = r101;
        return r101;
    }

    public final void W(boolean r100) {
        TouchEventFrameLayout r101 = this.f159596p;
        if (r101 != null) goto L5;
        return;
    L5:
        u r102 = Z();
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.z1();
        if (r103 == null) goto L12;
        if (r103.getValue().booleanValue() == true) goto L12;
        return;
    L12:
        Disposable r104 = this.f159605y;
        if (r104 != null) goto L15;
    L19:
        HashMap r105 = new HashMap();
        DataCenter r106 = getDataCenter();
        if (r106 == null) goto L24;
        IRoom r107 = lu2.c.f(r106);
        if (r107 == null) goto L24;
        int r108 = ju2.f.M;
        r105.putAll(ju2.f.a.a(r107).b());
    L24:
        if (r100 == false) goto L26;
        String r109 = "manual";
    L27:
        r105.put("action_type", r109);
        r.l().sendLog("livesdk_relevant_live_panel_close", r105, new Object[]{x.class, Room.class});
        q4.b r110 = u4.c(new PortraitHorizontalLinkedCameraTetris$dismissPanel$1(this, r101));
        this.f159603w = r110;
        if (r110.b() != true) goto L30;
        return;
    L30:
        q4.b r111 = this.f159602v;
        if (r111 != null) goto L33;
    L37:
        q4.b r112 = this.f159603w;
        if (r112 == null) goto L41;
        r112.c();
        return;
    L41:
        return;
    L33:
        if (r111.b() != true) goto L37;
        q4.b r113 = this.f159602v;
        if (r113 == null) goto L37;
        r113.a();
        goto L37
    L26:
        r109 = "auto";
        goto L27
    L15:
        if (r104.isDisposed() == true) goto L19;
        Disposable r114 = this.f159605y;
        if (r114 == null) goto L19;
        r114.dispose();
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0(boolean r100) {
        if (this.f159599s == false) goto L5;
        return;
    L5:
        DataCenter r101 = getDataCenter();
        if (r101 == null) goto L10;
        VideoViewParams r102 = (VideoViewParams) r101.get("live_render_view_params", null);
        if (r102 == null) goto L10;
        c0(r102);
    L10:
        DataCenter r103 = ((d90.d) K()).f467480h;
        if (r103 == null) goto L13;
        r103.observe("live_render_view_params", this);
    L13:
        View r104 = this.f159597q;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r104);
    L17:
        if (PadConfigUtils.c() == false) goto L26;
        u r105 = Z();
        if (r105 == null) goto L26;
        com.bytedance.live.datacontext.n<PadOrientation> r106 = r105.w();
        if (r106 == null) goto L26;
        Disposable r107 = i80.a.b(r106, new PortraitHorizontalLinkedCameraTetris$initView$2(this));
        if (r107 == null) goto L26;
        RxUtilKt.c(r107, this.f159604x);
    L26:
        if (r100 == false) goto L44;
        u r108 = Z();
        if (r108 == null) goto L35;
        com.bytedance.live.datacontext.j<Unit> r109 = r108.k();
        if (r109 == null) goto L35;
        if (r109.hasValue() != true) goto L35;
        V();
    L35:
        u r110 = Z();
        if (r110 == null) goto L44;
        com.bytedance.live.datacontext.j<Unit> r111 = r110.k();
        if (r111 == null) goto L44;
        Maybe<sh6.b<Unit>> r112 = r111.b();
        if (r112 == null) goto L44;
        Disposable r113 = r112.subscribe(new b(this));
        if (r113 == null) goto L44;
        RxUtilKt.c(r113, this.f159604x);
    L44:
        this.f159599s = true;
    }

    public final void b0(boolean r110) {
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(getDataCenter());
        PaidInteractEntry r100 = PaidInteractEntry.CONTROL_ENTRY_COMMENT;
        u r101 = Z();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.z1();
        if (r102 == null) goto L9;
        if (r102.getValue().booleanValue() != true) goto L9;
        return;
    L9:
        Object r103 = pm1.h.f529822d.c(vr1.l.class);
        Intrinsics.checkNotNull(r103);
        WidgetElement r104 = null;
        if (((vr1.l) r103).a() == false) goto L19;
        DataCenter r105 = getDataCenter();
        if (r105 == null) goto L14;
        IRoom r106 = lu2.c.f(r105);
    L16:
        if (RoomKt.hasMultiCamera(r106) == false) goto L19;
        f2.c("连麦状态下不支持切换多机位", 0);
        return;
    L14:
        r106 = null;
    L19:
        View r107 = this.f159597q;
        if (r107 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r107);
    L22:
        TouchEventFrameLayout r108 = this.f159596p;
        if (r108 == null) goto L25;
        WidgetElement r111 = LiveTetris.Q(this, PortraitHorizontalLinkedCameraPanel.class, r108, false, new Object[]{Boolean.valueOf(r110)}, 16);
    L26:
        this.f159600t = r111;
        ViewGroup r109 = this.f159595o;
        if (r109 == null) goto L29;
        r104 = LiveTetris.Q(this, MultiCameraLinkedRoomTopWidget.class, r109, false, null, 24);
    L29:
        this.f159601u = r104;
        r3.n(this.f159596p);
        r3.n(this.f159595o);
        TouchEventFrameLayout r112 = this.f159596p;
        if (r112 == null) goto L33;
        UtilityKotlinExtentionsKt.t(r112);
    L33:
        if (this.f159602v != null) goto L38;
        TouchEventFrameLayout r113 = this.f159596p;
        if (r113 != null) goto L37;
        return;
    L37:
        this.f159602v = u4.c(new PortraitHorizontalLinkedCameraTetris$openPanel$1(this, r113));
    L38:
        q4.b r114 = this.f159602v;
        if (r114 != null) goto L41;
    L43:
        q4.b r115 = this.f159603w;
        if (r115 != null) goto L46;
    L50:
        q4.b r116 = this.f159602v;
        if (r116 == null) goto L54;
        r116.c();
        return;
    L54:
        return;
    L46:
        if (r115.b() != true) goto L50;
        q4.b r117 = this.f159603w;
        if (r117 == null) goto L50;
        r117.a();
        goto L50
    L41:
        if (r114.b() != true) goto L43;
        return;
    L25:
        r111 = null;
        goto L26
    }

    public final void c0(VideoViewParams r100) {
        if (Intrinsics.areEqual(this.f159598r, r100) == false) goto L5;
        return;
    L5:
        this.f159598r = r100;
        if (r100 == null) goto L18;
        View r101 = this.f159597q;
        if (r101 == null) goto L13;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L13;
        r102.width = -1;
        r102.height = -1;
    L13:
        ViewGroup r103 = this.f159595o;
        if (r103 == null) goto L17;
        a1.k(r103, r100.f112570b + r100.f112571c);
        return;
    L17:
        return;
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
        if (r102.hashCode() == (-1882223254)) goto L12;
        return;
    L12:
        if (r102.equals("live_render_view_params") == false) goto L15;
        c0((VideoViewParams) r101.getData(null));
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof MultiCameraPanelEvent) == false) goto L12;
        MultiCameraPanelEvent.Action r101 = ((MultiCameraPanelEvent) r100).f159577a;
        int r102 = i.f159635a[r101.ordinal()];
        if (r102 != 1) goto L7;
        b0(true);
        return;
    L7:
        if (r102 != 2) goto L14;
        W(true);
        return;
    L14:
        return;
    }
}
