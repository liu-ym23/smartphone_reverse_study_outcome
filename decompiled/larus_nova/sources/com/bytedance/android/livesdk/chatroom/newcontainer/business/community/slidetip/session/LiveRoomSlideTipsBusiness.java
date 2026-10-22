package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session;

import am2.x;
import android.app.Activity;
import android.os.Handler;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.o;
import com.bytedance.android.livesdk.chatroom.widget.j;
import com.bytedance.android.livesdk.config.ih1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.ContainerScrollLifecycle;
import com.bytedance.android.livesdk.slideuptip.LiveSlideUpTipsGuideUtil;
import com.bytedance.android.livesdk.slideuptip.SlideUpTipsTriggerSource;
import com.bytedance.android.livesdk.slideuptip.k;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomSlideTipsBusiness extends os2.d<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ls2.d f107443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ik1.d f107444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f107445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f107446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f107447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f107448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f107449h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomSlideTipsBusiness f107450a;

        public a(LiveRoomSlideTipsBusiness r100) {
            this.f107450a = r100;
        }

        public final void a(int r100, boolean r101) {
            FrameLayout r102 = null;
            Room r103 = null;
            if (r101 == false) goto L41;
            ls2.d r104 = this.f107450a.f107443b;
            if (r104 == null) goto L7;
            ik1.b r105 = (ik1.b) r104.b("RoomSessionTaskConst_live_room_inner_feed_data");
        L8:
            LiveRoomSlideTipsBusiness r106 = this.f107450a;
            final ls2.d r107 = r106.f107443b;
            ik1.d r108 = r106.f107444c;
            if (r108 == null) goto L11;
            final ik1.h r109 = r108.f490241q;
        L12:
            if (r108 == null) goto L14;
            final FrameLayout r110 = r108.f490234j;
        L15:
            String r111 = s1.B(R.string.ttlive_chat_auto_join_tips);
            j r112 = r109.f490260d;
            if (r112 == null) goto L18;
            r110.removeView(r112);
        L18:
            Activity r113 = r107.f510523l;
            if (r113 == null) goto L36;
            j r114 = new j(r113);
            r109.f490260d = r114;
            r114.setTips(r111);
            r109.f490260d.setOnClickListener(new g(r107, r109, r110));
            FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-1, -2);
            r115.gravity = 16;
            r110.addView(r109.f490260d, r115);
            com.bytedance.android.livesdk.e.b().a();
            ILiveRoomListProvider r116 = r105.f490186c;
            if (r116 == null) goto L23;
            r103 = (Room) ListProtector.get(r116.getRoomList(), r107.f510527p);
        L23:
            int r117 = o.f114564a;
            HashMap r118 = new HashMap();
            i4.b(r118);
            if (r103 == null) goto L32;
            Map<String, Long> r119 = r103.getLinkMap();
            if (r119 == null) goto L32;
            if (r119.containsKey(String.valueOf(9)) == false) goto L30;
            r118.put("function_type", "ktv");
            goto L32
        L30:
            r118.put("function_type", "radio");
        L32:
            if (r100 != 0) goto L34;
            r118.put("request_page", "click");
        L35:
            u.l().sendLog("livesdk_guest_connection_match_toast_show", r118, new Object[]{x.class, Room.class});
            goto L36
        L34:
            r118.put("request_page", "draw");
        L36:
            LiveRoomSlideTipsBusiness r120 = this.f107450a;
            ls2.d r121 = r120.f107443b;
            if (r121 == null) goto L49;
            Handler r122 = r121.f510530s;
            if (r122 == null) goto L50;
            r122.postDelayed(new com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session.a(r120), 5000);
            return;
        L50:
            return;
        L49:
            return;
        L14:
            r110 = null;
            goto L15
        L11:
            r109 = null;
            goto L12
        L7:
            r105 = null;
            goto L8
        L41:
            LiveRoomSlideTipsBusiness r123 = this.f107450a;
            ls2.d r124 = r123.f107443b;
            ik1.d r125 = r123.f107444c;
            if (r125 == null) goto L44;
            ik1.h r126 = r125.f490241q;
        L45:
            if (r125 == null) goto L47;
            r102 = r125.f490234j;
        L47:
            h.a(r124, r126, r102);
            return;
        L44:
            r126 = null;
            goto L45
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomSlideTipsBusiness f107451a;

        public b(LiveRoomSlideTipsBusiness r100) {
            this.f107451a = r100;
        }

        public final void a(boolean r100) {
            FrameLayout r101 = null;
            if (r100 == false) goto L18;
            ls2.d r102 = this.f107451a.f107443b;
            if (r102 == null) goto L7;
            ik1.b r103 = (ik1.b) r102.b("RoomSessionTaskConst_live_room_inner_feed_data");
        L8:
            LiveRoomSlideTipsBusiness r104 = this.f107451a;
            ls2.d r105 = r104.f107443b;
            ik1.d r106 = r104.f107444c;
            if (r106 == null) goto L11;
            ik1.h r107 = r106.f490241q;
        L12:
            if (r103 == null) goto L14;
            LiveVerticalViewPager r108 = r103.f490188e;
        L15:
            if (r106 == null) goto L17;
            r101 = r106.f490234j;
        L17:
            h.c(r105, r107, r108, r101, SlideUpTipsTriggerSource.SLIDE_UP_V1);
            return;
        L14:
            r108 = null;
            goto L15
        L11:
            r107 = null;
            goto L12
        L7:
            r103 = null;
            goto L8
        L18:
            LiveRoomSlideTipsBusiness r109 = this.f107451a;
            ls2.d r110 = r109.f107443b;
            ik1.d r111 = r109.f107444c;
            if (r111 == null) goto L21;
            ik1.h r112 = r111.f490241q;
        L22:
            if (r111 == null) goto L24;
            r101 = r111.f490234j;
        L24:
            h.b(r110, r112, r101);
            return;
        L21:
            r112 = null;
            goto L22
        }
    }

    public static final class c implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomSlideTipsBusiness f107452a;

        public c(LiveRoomSlideTipsBusiness r100) {
            this.f107452a = r100;
        }

        @Override // com.bytedance.android.livesdk.slideuptip.k.a
        public final void a(boolean r100, SlideUpTipsTriggerSource r101) {
            FrameLayout r102 = null;
            String r103 = null;
            if (r100 == false) goto L33;
            ls2.d r104 = this.f107452a.f107443b;
            if (r104 == null) goto L7;
            ik1.b r105 = (ik1.b) r104.b("RoomSessionTaskConst_live_room_inner_feed_data");
        L8:
            LiveRoomSlideTipsBusiness r106 = this.f107452a;
            ls2.d r107 = r106.f107443b;
            ik1.d r108 = r106.f107444c;
            if (r108 == null) goto L11;
            ik1.h r109 = r108.f490241q;
        L12:
            if (r105 == null) goto L14;
            LiveVerticalViewPager r110 = r105.f490188e;
        L15:
            if (r108 == null) goto L17;
            FrameLayout r111 = r108.f490234j;
        L18:
            h.c(r107, r109, r110, r111, r101);
            ls2.d r112 = this.f107452a.f107443b;
            if (r112 == null) goto L21;
            String r113 = r112.f510516e;
        L22:
            if (r112 == null) goto L24;
            r103 = r112.f510517f;
        L24:
            List<String> r114 = k.f158424a;
            Map r115 = (Map) LiveSlideUpTipsGuideUtil.f158383a.getValue();
            if (r115 == null) goto L29;
            ih1 r116 = (ih1) r115.get(r113 + '_' + r103);
            if (r116 == null) goto L29;
            long r117 = r116.a();
        L31:
            if (r117 <= 0) goto L41;
            LiveRoomSlideTipsBusiness.m(this.f107452a, r117 * ((long) 1000));
            return;
        L41:
            return;
        L29:
            r117 = 7;
            goto L31
        L21:
            r113 = null;
            goto L22
        L17:
            r111 = null;
            goto L18
        L14:
            r110 = null;
            goto L15
        L11:
            r109 = null;
            goto L12
        L7:
            r105 = null;
            goto L8
        L33:
            LiveRoomSlideTipsBusiness r118 = this.f107452a;
            ls2.d r119 = r118.f107443b;
            ik1.d r120 = r118.f107444c;
            if (r120 == null) goto L36;
            ik1.h r121 = r120.f490241q;
        L37:
            if (r120 == null) goto L39;
            r102 = r120.f490234j;
        L39:
            h.b(r119, r121, r102);
            return;
        L36:
            r121 = null;
            goto L37
        }
    }

    public static final class d implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomSlideTipsBusiness f107453a;

        public d(LiveRoomSlideTipsBusiness r100) {
            this.f107453a = r100;
        }

        @Override // com.bytedance.android.livesdk.slideuptip.k.a
        public final void a(boolean r100, SlideUpTipsTriggerSource r101) {
            FrameLayout r102 = null;
            if (r100 == false) goto L20;
            ls2.d r103 = this.f107453a.f107443b;
            if (r103 == null) goto L7;
            ik1.b r104 = (ik1.b) r103.b("RoomSessionTaskConst_live_room_inner_feed_data");
        L8:
            LiveRoomSlideTipsBusiness r105 = this.f107453a;
            ls2.d r106 = r105.f107443b;
            ik1.d r107 = r105.f107444c;
            if (r107 == null) goto L11;
            ik1.h r108 = r107.f490241q;
        L12:
            if (r104 == null) goto L14;
            LiveVerticalViewPager r109 = r104.f490188e;
        L15:
            if (r107 == null) goto L17;
            r102 = r107.f490234j;
        L17:
            h.c(r106, r108, r109, r102, r101);
            if (k.b() <= 0) goto L28;
            LiveRoomSlideTipsBusiness.m(this.f107453a, k.b() * ((long) 1000));
            return;
        L28:
            return;
        L14:
            r109 = null;
            goto L15
        L11:
            r108 = null;
            goto L12
        L7:
            r104 = null;
            goto L8
        L20:
            LiveRoomSlideTipsBusiness r110 = this.f107453a;
            ls2.d r111 = r110.f107443b;
            ik1.d r112 = r110.f107444c;
            if (r112 == null) goto L23;
            ik1.h r113 = r112.f490241q;
        L24:
            if (r112 == null) goto L26;
            r102 = r112.f490234j;
        L26:
            h.b(r111, r113, r102);
            return;
        L23:
            r113 = null;
            goto L24
        }
    }

    public static final class e implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomSlideTipsBusiness f107454a;

        public e(LiveRoomSlideTipsBusiness r100) {
            this.f107454a = r100;
        }

        @Override // com.bytedance.android.livesdk.slideuptip.k.a
        public final void a(boolean r100, SlideUpTipsTriggerSource r101) {
            FrameLayout r102 = null;
            if (r100 == false) goto L20;
            ls2.d r103 = this.f107454a.f107443b;
            if (r103 == null) goto L7;
            ik1.b r104 = (ik1.b) r103.b("RoomSessionTaskConst_live_room_inner_feed_data");
        L8:
            LiveRoomSlideTipsBusiness r105 = this.f107454a;
            ls2.d r106 = r105.f107443b;
            ik1.d r107 = r105.f107444c;
            if (r107 == null) goto L11;
            ik1.h r108 = r107.f490241q;
        L12:
            if (r104 == null) goto L14;
            LiveVerticalViewPager r109 = r104.f490188e;
        L15:
            if (r107 == null) goto L17;
            r102 = r107.f490234j;
        L17:
            h.c(r106, r108, r109, r102, r101);
            if (k.b() <= 0) goto L28;
            LiveRoomSlideTipsBusiness.m(this.f107454a, k.b() * ((long) 1000));
            return;
        L28:
            return;
        L14:
            r109 = null;
            goto L15
        L11:
            r108 = null;
            goto L12
        L7:
            r104 = null;
            goto L8
        L20:
            LiveRoomSlideTipsBusiness r110 = this.f107454a;
            ls2.d r111 = r110.f107443b;
            ik1.d r112 = r110.f107444c;
            if (r112 == null) goto L23;
            ik1.h r113 = r112.f490241q;
        L24:
            if (r112 == null) goto L26;
            r102 = r112.f490234j;
        L26:
            h.b(r111, r113, r102);
            return;
        L23:
            r113 = null;
            goto L24
        }
    }

    public static final class f {
        public f(LiveRoomSlideTipsBusiness r100) {
        }
    }

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public LiveRoomSlideTipsBusiness() {
        this.f107445d = new e(this);
        this.f107446e = new c(this);
        this.f107447f = new d(this);
        new f(this);
        this.f107448g = new b(this);
        this.f107449h = new a(this);
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> l(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f107443b = r100;
        this.f107444c = (ik1.d) r100.b("RoomSessionTaskConst_live_room_container_data");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public static final void m(LiveRoomSlideTipsBusiness r100, long r101) {
        ls2.d r102 = r100.f107443b;
        if (r102 == null) goto L8;
        Handler r103 = r102.f510530s;
        if (r103 == null) goto L9;
        r103.postDelayed(new com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session.b(r100), r101);
        return;
    L9:
        return;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> f(final ls2.d r100, ContainerScrollLifecycle r101, final ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.e(r101, new LiveRoomSlideTipsBusiness$containerScrollStateChanged$1(this, r100, r102));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(final ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final ik1.b r103 = (ik1.b) r100.b("RoomSessionTaskConst_live_room_inner_feed_data");
        if (r101 == null) goto L5;
        ts2.d.a(r101, LiveRoomSlideTipsBusiness$containerStateChanged$1.INSTANCE);
    L5:
        if (r101 == null) goto L7;
        ts2.d.h(r101, new LiveRoomSlideTipsBusiness$containerStateChanged$2(this, r103, r100));
    L7:
        if (r101 == null) goto L11;
        Function0<Unit> r104 = new LiveRoomSlideTipsBusiness$containerStateChanged$3(this, r103, r100);
        Intrinsics.checkNotNullParameter(r101, "$this$onRoomDataChanged");
        Intrinsics.checkNotNullParameter(r104, "action");
        if (r101 != ContainerLifecycle.ON_ROOM_DATA_CHANGED) goto L11;
        r104.invoke();
    L11:
        if (r101 == null) goto L13;
        ts2.d.j(r101, new LiveRoomSlideTipsBusiness$containerStateChanged$4(this));
    L13:
        if (r101 == null) goto L15;
        ts2.d.b(r101, new LiveRoomSlideTipsBusiness$containerStateChanged$5(this, r100));
    L15:
        if (r101 == null) goto L19;
        ts2.d.d(r101, new LiveRoomSlideTipsBusiness$containerStateChanged$6(r103));
        return null;
    L19:
        return null;
    }
}
