package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import am2.x;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f72442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f72443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f72446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f72447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f72448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f72449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f72450i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f72451a;

        public a(b r100) {
            this.f72451a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            b r101 = this.f72451a;
            int r102 = ((com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.c) r100).f72457a;
            if (r101.f72445d == true) goto L15;
            l.f537955n2.getClass();
            l r103 = l.a.a();
            if (r103 != null) goto L7;
        L8:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r104 = IVoiceChatGuestService.a.a();
            if (r104 != null) goto L11;
        L12:
            if (r102 == 0) goto L15;
            r101.c();
            return;
        L11:
            if (r104.isEngineOn() == true) goto L15;
        L7:
            if (r103.isEngineOn() != true) goto L8;
        L15:
            r101.f72444c = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b$b, reason: collision with other inner class name */
    public static final class C1161b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f72452a;

        public C1161b(b r100) {
            this.f72452a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((h) r100).f72465a == false) goto L6;
            this.f72452a.a();
            return;
        }
    }

    public static final class c extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f72453a;

        public static final class a extends BaseAnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f72454a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f72455b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Animatable f72456c;

            @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
            public final void onAnimationStop(AnimatedDrawable2 r100) {
                Intrinsics.checkNotNullParameter(r100, "drawable");
                b r101 = this.f72455b.f72453a;
                if (r101.f72444c == false) goto L9;
                Disposable r102 = r101.f72443b;
                if (r102 == null) goto L7;
                r102.dispose();
            L7:
                r101.f72443b = Observable.timer(r101.f72449h, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.a(r101));
                return;
            }

            public a(c r100, Animatable r101) {
                this.f72455b = r100;
                this.f72456c = r101;
                this.f72454a = -1;
            }

            @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
            public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, "drawable");
                if (r101 >= this.f72454a) goto L5;
                this.f72456c.stop();
            L5:
                this.f72454a = r101;
            }
        }

        public c(b r100) {
            this.f72453a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r102).setAnimationListener(new a(this, r102));
            return;
        }
    }

    public final void a() {
        this.f72444c = false;
        HSImageView r100 = this.f72442a;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        Disposable r101 = this.f72443b;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f72442a = null;
        if (this.f72448g.isDisposed() == true) goto L12;
        this.f72448g.dispose();
        return;
    }

    public final void c() {
        AbstractDraweeController r100 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(this.f72450i)).setAutoPlayAnimations(true).setControllerListener(new c(this)).build();
        fj0.a r101 = fj0.b.f477460a;
        String r102 = this.f72446e;
        String r103 = this.f72447f;
        PaidLinkMicContext r104 = PaidLinkMicContext.Companion.getContext();
        if (r104 == null) goto L7;
        m<Integer> r105 = r104.getDiscountMode();
        if (r105 == null) goto L7;
        Integer r106 = r105.getValue();
    L8:
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "roomId");
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("anchor_id", r102);
        r107.put("room_id", r103);
        TalkRoomLogUtils.I0(r107, je0.d.f());
        TalkRoomLogUtils.B0(r107, null, null, 6);
        r107.put(FastStartLiveConfig.PLAY_MODE, "rechargeable_normal");
        if (r106 != null) goto L12;
    L14:
        if (r106 != null) goto L17;
    L19:
        if (r106 != null) goto L22;
    L24:
        String r108 = "";
    L25:
        r107.put("discount_type", r108);
        j0.l().sendLog("livesdk_audience_rechargeable_discount_popup", r107, new Object[]{IRoom.class, x.class});
        HSImageView r109 = this.f72442a;
        if (r109 == null) goto L28;
        r109.setVisibility(0);
    L28:
        HSImageView r110 = this.f72442a;
        if (r110 == null) goto L32;
        r110.setController(r100);
        return;
    L32:
        return;
    L22:
        if (r106.intValue() != 3) goto L24;
        r108 = BdpAppEventConstant.PARAMS_STRATEGY_NAME;
        goto L25
    L17:
        if (r106.intValue() != 2) goto L19;
        r108 = "activity";
        goto L25
    L12:
        if (r106.intValue() != 1) goto L14;
        r108 = "vip";
    L7:
        r106 = null;
        goto L8
    }

    public b() {
        this.f72444c = true;
        this.f72446e = "";
        this.f72447f = "";
        this.f72448g = new CompositeDisposable();
        this.f72449h = ((Number) vm2.d.f555884k7.getValue(null, vm2.d.f555776a[423(0x1a7, float:5.93E-43)])).longValue();
        this.f72450i = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_toolbar_first_discount_anim.webp";
    }

    public final void b(HSImageView r100, boolean r101, String r102, String r103) {
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f72446e = r102;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f72447f = r103;
        this.f72445d = r101;
        this.f72442a = r100;
        Disposable r104 = xs2.b.a().b(com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        if (r104 == null) goto L11;
        this.f72448g.add(r104);
    L11:
        Disposable r105 = xs2.b.a().b(h.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new C1161b(this));
        if (r105 == null) goto L15;
        this.f72448g.add(r105);
        return;
    }
}
