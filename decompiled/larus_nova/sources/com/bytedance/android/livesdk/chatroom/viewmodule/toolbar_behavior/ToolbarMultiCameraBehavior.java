package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.av0;
import com.bytedance.android.livesdk.config.ox0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.google.gson.Gson;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarMultiCameraBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f117012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoomContext f117013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f117014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f117015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DraweeController f117016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f117017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f117018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f117019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f117020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f117021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f117022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f117023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f117024m;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarMultiCameraBehavior f117025a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.MULTI_CAMERA;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.g.f114779b;
        }

        public a(ToolbarMultiCameraBehavior r100) {
            this.f117025a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r100) {
            this.f117025a.c("vrAnimScheduled");
            long r101 = System.currentTimeMillis();
            int r102 = av0.f119822a.getValue().a();
            ToolbarMultiCameraBehavior r103 = this.f117025a;
            if ((r101 - r103.f117021j) >= (r102 - 100)) goto L6;
            r103.c("return time=" + (r101 - this.f117025a.f117021j) + ",interval=" + r102);
            return false;
        L6:
            r103.f117021j = r101;
            HSImageView r104 = r103.f117015d;
            if (r104 != null) goto L9;
            return true;
        L9:
            if (r104 == null) goto L11;
            r104.setVisibility(0);
        L11:
            DraweeController r105 = this.f117025a.f117016e;
            if (r105 == null) goto L16;
            Animatable r106 = r105.getAnimatable();
            if (r106 == null) goto L16;
            r106.start();
        L16:
            ToolbarMultiCameraBehavior r107 = this.f117025a;
            if (r107.f117019h == false) goto L21;
            HSImageView r108 = r107.f117014c;
            if (r108 == null) goto L21;
            r108.setVisibility(8);
        L21:
            this.f117025a.f117020i = true;
            return true;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarMultiCameraBehavior f117026a;

        public b(ToolbarMultiCameraBehavior r100) {
            this.f117026a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            es0.a r111 = (es0.a) ((KVData) r110).getData();
            String r100 = "0";
            if ((r111 instanceof es0.a.d) == false) goto L42;
            final ToolbarMultiCameraBehavior r112 = this.f117026a;
            LiveToolbarData r101 = com.bytedance.android.live.core.utils.z.o(r112.f117024m).getToolbarData();
            String r102 = null;
            if (r101 == null) goto L29;
            List<IToolbarComponentData> r103 = r101.getToolbarDataList();
            if (r103 == null) goto L29;
            Iterator<T> r104 = r103.iterator();
        L10:
            if (r104.hasNext() == false) goto L17;
            T r105 = r104.next();
            if (((IToolbarComponentData) r105).getId() != 42) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == false) goto L10;
        L18:
            IToolbarComponentData r107 = (IToolbarComponentData) r105;
            if (r107 == null) goto L29;
            String r108 = r107.getExtraData();
            if (r108 == null) goto L29;
            ym0.b r109 = (ym0.b) GsonProtectorUtils.fromJson(new Gson(), r108, ym0.b.class);
            if (r109 == null) goto L29;
            List<ym0.a> r113 = r109.b();
            if (r113 == null) goto L29;
            ym0.a r114 = (ym0.a) CollectionsKt.firstOrNull(r113);
            if (r114 == null) goto L29;
            final String r115 = r114.a();
        L30:
            if (r115 == null) goto L35;
            HSImageView r116 = r112.f117015d;
            if (r116 == null) goto L35;
            r116.post(new ToolbarMultiCameraBehavior$setSubCameraIcon$1(r112, r115));
        L35:
            this.f117026a.f117022k = System.currentTimeMillis();
            if (this.f117026a.b() == false) goto L61;
            ToolbarMultiCameraBehavior r117 = this.f117026a;
            String r118 = String.valueOf(VrUtils.l(r117.f117024m));
            com.bytedance.android.livesdk.log.g r119 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r120 = new Pair[6];
            User r121 = com.bytedance.android.live.core.utils.z.o(r117.f117024m).mo8271getOwner();
            if (r121 == null) goto L40;
            r102 = r121.getIdString();
        L40:
            r120[0] = TuplesKt.to("anchor_id", r102);
            r120[1] = TuplesKt.to("room_id", com.bytedance.android.live.core.utils.z.o(r117.f117024m).getIdStr());
            r120[2] = TuplesKt.to(VrBgLogData.KEY_VR_TYPE, VrUtils.n());
            r120[3] = TuplesKt.to("is_vr_machine", "1");
            r120[4] = TuplesKt.to("is_original_vr", "0");
            r120[5] = TuplesKt.to("screen_direction", r118);
            r119.sendLog("livesdk_live_vr_label_show", MapsKt.mapOf(r120), new Object[]{Room.class, am2.x.class});
            return;
        L61:
            return;
        L14:
            r106 = false;
            goto L15
        L17:
            r105 = null;
        L29:
            r115 = null;
            goto L30
        L42:
            if ((r111 instanceof es0.a.c) == false) goto L63;
            ToolbarMultiCameraBehavior r122 = this.f117026a;
            r122.getClass();
            IAnimationScheduler.M0.getClass();
            if (IAnimationScheduler.Companion.b() == false) goto L49;
            IAnimationScheduler r123 = IAnimationScheduler.Companion.a(r122.f117024m);
            if (r123 == null) goto L49;
            r123.unRegisterListener(r122.f117018g);
        L49:
            ToolbarMultiCameraBehavior.a(this.f117026a);
            if (this.f117026a.b() == false) goto L64;
            boolean r124 = this.f117026a.b();
            com.bytedance.android.livesdk.log.g r125 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r126 = new Pair[2];
            r126[0] = TuplesKt.to("entrance_action_type", "show");
            if (r124 == false) goto L54;
            r100 = "1";
        L54:
            r126[1] = TuplesKt.to("is_vr_multicamera", r100);
            r125.sendLog("livesdk_live_multicamera_entrance", MapsKt.mapOf(r126), new Object[]{Room.class, am2.x.class});
            return;
        L64:
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarMultiCameraBehavior f117027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f117028b;

        public c(ToolbarMultiCameraBehavior r100, DataCenter r101) {
            this.f117027a = r100;
            this.f117028b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) ((KVData) r100).getData();
            if (r101 != null) goto L5;
            r101 = Boolean.FALSE;
        L5:
            boolean r102 = r101.booleanValue();
            Object r103 = null;
            Object r104 = this.f117028b.get("cmd_current_camera_info", null);
            if ((r104 instanceof ym0.a) == false) goto L9;
            r103 = r104;
        L9:
            ym0.a r105 = (ym0.a) r103;
            if (r102 == false) goto L15;
            if (r105 != null) goto L13;
            return;
        L13:
            if (r105.d() != 0) goto L21;
            ToolbarMultiCameraBehavior.a(this.f117027a);
            this.f117027a.f117022k = -1;
            return;
        L21:
            return;
        L15:
            if (r105 != null) goto L17;
            return;
        L17:
            if (r105.d() != 0) goto L24;
            ToolbarMultiCameraBehavior r106 = this.f117027a;
            r106.f117022k = System.currentTimeMillis();
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataCenter f117029a;

        public d(DataCenter r100) {
            this.f117029a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            com.bytedance.android.livesdk.interactivity.api.h r102 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f117029a, 1);
            if (r102 == null) goto L10;
            com.bytedance.live.datacontext.n<b42.b> r103 = r102.getMultiCameraContext();
            if (r103 == null) goto L11;
            b42.b r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.m6();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean b() {
        Integer r100 = (Integer) this.f117024m.get("cmd_multicamera_biz_type", -1);
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public ToolbarMultiCameraBehavior(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f117024m = r100;
        this.f117012a = "ToolbarMultiCameraBehavior";
        this.f117018g = new a(this);
        this.f117022k = -1;
    }

    public static final void a(ToolbarMultiCameraBehavior r100) {
        if (r100.f117022k <= 0) goto L5;
        r100.f117023l += System.currentTimeMillis() - r100.f117022k;
    L5:
        r100.f117024m.put("cmd_sub_camera_total_duration", Long.valueOf(r100.f117023l));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f116202l.f116104b == true) goto L6;
        return;
    L6:
        if (ox0.f120939a.getValue().booleanValue() == false) goto L16;
        py.k r101 = r100.f116193c;
        if (r101 == null) goto L10;
        ImageUtil.loadImage(this.f117014c, r101, 0);
        return;
    L10:
        HSImageView r102 = this.f117014c;
        if (r102 == null) goto L18;
        r102.setActualImageResource(R.drawable.ttlive_icon_multi_camera);
        return;
    L18:
        return;
    }

    public final void c(String r100) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d(this.f117012a, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof pp1.m) == false) goto L6;
        int r101 = ((pp1.m) r100).f530192a;
        return;
    L6:
        if ((r100 instanceof pp1.c) == false) goto L23;
        RoomContext r102 = this.f117013b;
        Context r103 = null;
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c>> r104 = r102.getToolbarBubbleManager();
        if (r104 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c> r105 = r104.getValue();
    L13:
        HSImageView r106 = this.f117014c;
        if (r106 == null) goto L16;
        r103 = r106.getContext();
    L16:
        if (r103 == null) goto L24;
        HSImageView r107 = this.f117014c;
        if (r105 == null) goto L25;
        if (r107 == null) goto L26;
        r105.addBubble(r100, ((pp1.c) r100).f530177k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.f117024m, r103, r107), new ToolbarMultiCameraBehavior$onCommand$$inlined$lets$lambda$1(this, r100));
        System.currentTimeMillis();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r105 = null;
        goto L13
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c("ToolbarMultiCameraBehavior Click");
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f117024m).F0(PaidInteractEntry.CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA) == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.h r101 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f117024m, 1);
        if (r101 == null) goto L13;
        com.bytedance.live.datacontext.n<b42.b> r102 = r101.getMultiCameraContext();
        if (r102 == null) goto L14;
        b42.b r103 = r102.getValue();
        if (r103 == null) goto L15;
        r103.on();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Disposable r102 = this.f117017f;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isDisposed() == true) goto L12;
        Disposable r103 = this.f117017f;
        if (r103 == null) goto L9;
        r103.dispose();
    L9:
        this.f117017f = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117013b = RoomContext.a.c(RoomContext.Companion, r101, 0, 2);
        this.f117014c = (HSImageView) r100.findViewById(R.id.static_icon);
        LiveToolbarData r102 = com.bytedance.android.live.core.utils.z.o(r101).getToolbarData();
        IToolbarComponentData r103 = null;
        Object r104 = null;
        r103 = null;
        if (r102 == null) goto L16;
        List<IToolbarComponentData> r105 = r102.getToolbarDataList();
        if (r105 == null) goto L16;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (((IToolbarComponentData) r107).getId() != 42) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L8;
        r104 = r107;
        goto L15
    L12:
        r108 = false;
    L15:
        r103 = (IToolbarComponentData) r104;
    L16:
        int r109 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.f116309a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(r101, false))) == false) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.f117014c);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r100.findViewById(R.id.multi_camera_static_icon_container));
        if (r103 == null) goto L23;
        py.k r110 = r103.getIcon();
        if (r110 == null) goto L23;
        ImageUtil.loadImage(this.f117014c, r110, 0);
    L23:
        HSImageView r111 = this.f117014c;
        if (r111 == null) goto L26;
        r111.setActualImageResource(R.drawable.ttlive_icon_multi_camera);
    L26:
        this.f117015d = (HSImageView) r100.findViewById(R.id.animated_icon);
        r101.observe("cmd_current_sub_camera_state", new b(this));
        r101.observe("cmd_is_current_in_background", new c(this, r101));
        this.f117017f = Observable.timer(10, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r101));
    }
}
