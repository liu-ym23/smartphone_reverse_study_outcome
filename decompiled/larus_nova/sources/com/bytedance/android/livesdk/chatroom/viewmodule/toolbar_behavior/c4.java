package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.event.ToolbarEvent;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.message.model.nh;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f117101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Room f117102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f117103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vlc.d f117104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f117105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f117106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HSImageView f117107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f117108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f117109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f117110j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f117111a = null;

        static {
            f117111a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).recordSnowFlakeShown();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c4 f117112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f117113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f117114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f117115d;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            Function0 r102 = this.f117113b;
            if (r102 == null) goto L6;
            Unit r103 = (Unit) r102.invoke();
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            Function2 r104 = this.f117114c;
            if (r104 == null) goto L7;
            Boolean r105 = (Boolean) r104.invoke(r103, r102);
            if (r105 == null) goto L7;
            boolean r106 = r105.booleanValue();
        L8:
            c4.b(this.f117112a, r102, this.f117115d, this.f117113b);
            if (r106 == false) goto L13;
            if (r102 == null) goto L14;
            r102.start();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r106 = true;
            goto L8
        }

        public b(c4 r100, Function0 r101, Function2 r102, Function0 r103) {
            this.f117112a = r100;
            this.f117113b = r101;
            this.f117114c = r102;
            this.f117115d = r103;
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
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.f117110j;
    }

    public c4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f117110j = r100;
        this.f117101a = "ToolbarOpenPlatformMiniAppBehavior";
        new nh();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
        HSImageView r101 = this.f117107g;
        if (r101 == null) goto L5;
        r101.post(a.f117111a);
    L5:
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).onSnowFlakeShow(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof pp1.i) == false) goto L10;
        Object r101 = ((pp1.i) r100).f530189a;
        if ((r101 instanceof nh) == false) goto L11;
        if (r101 == null) goto L9;
        nh r102 = (nh) r101;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.OpenPlatformCardMessage");
    L11:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Context r101 = this.f117110j;
        Long r102 = null;
        if ((r101 instanceof FragmentActivity) == true) goto L6;
        r101 = null;
    L6:
        if (((FragmentActivity) r101) != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.utils.c1.b(this.f117103c) == false) goto L10;
    L11:
        Room r103 = this.f117102b;
        if (r103 == null) goto L14;
        IUser r104 = r103.author();
    L15:
        if (r104 == null) goto L36;
        JSONObject r105 = new JSONObject();
        Room r106 = this.f117102b;
        if (r106 == null) goto L21;
        IUser r107 = r106.author();
        if (r107 == null) goto L21;
        String r108 = r107.getIdString();
    L22:
        r105.put("anchor_id", String.valueOf(r108));
        Room r109 = this.f117102b;
        if (r109 == null) goto L25;
        r102 = Long.valueOf(r109.f162599id);
    L25:
        r105.put("room_id", String.valueOf(r102));
        if (com.bytedance.android.livesdk.utils.c1.b(this.f117103c) == false) goto L28;
        Map<String, String> r110 = com.bytedance.android.livesdk.utils.c1.e(this.f117103c);
    L29:
        ILiveDouPlusService r111 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        HashMap r112 = new HashMap();
        r112.put("refer", "link");
        r112.put("ad_extra_data", r105.toString());
        if (r110 != null) goto L32;
    L35:
        r111.logEvent(true, "live_ad", "applet_click", r112);
        int r113 = com.bytedance.android.livesdk.utils.x1.f159205a;
        goto L36
    L32:
        if (r110.isEmpty() == true) goto L35;
        r112.putAll(r110);
        goto L35
    L28:
        r110 = com.bytedance.android.livesdk.utils.c1.f(this.f117103c);
    L21:
        r108 = null;
    L36:
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).reportMpLiveLinkClick();
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).openSnowFlake();
        return;
    L14:
        r104 = null;
        goto L15
    L10:
        if (com.bytedance.android.livesdk.utils.c1.c(this.f117103c) == false) goto L36;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r100) {
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).onSnowFlakeHide(r100);
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).deleteMiniAppMountInfo();
        HSImageView r101 = this.f117105e;
        if (r101 == null) goto L9;
        DraweeController r102 = r101.getController();
        if (r102 == null) goto L9;
        Animatable r103 = r102.getAnimatable();
        if (r103 == null) goto L9;
        r103.stop();
    L9:
        HSImageView r104 = this.f117108h;
        if (r104 == null) goto L17;
        DraweeController r105 = r104.getController();
        if (r105 == null) goto L18;
        Animatable r106 = r105.getAnimatable();
        if (r106 == null) goto L19;
        r106.stop();
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).setAudienceMiniAppReady(false);
        Disposable r102 = this.f117109i;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        Disposable r103 = this.f117106f;
        if (r103 == null) goto L9;
        r103.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r110, DataCenter r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        this.f117105e = (HSImageView) r110.findViewById(R.id.open_platform_small_card_animation);
        this.f117107g = (HSImageView) r110.findViewById(R.id.open_platform_static_icon);
        ev1.q r100 = ev1.q.f474230d;
        if (r100.getValue().booleanValue() == false) goto L5;
        int r101 = R.drawable.live_toolbar_ic_v2_miniapp_static;
    L6:
        mo0.a r102 = ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).getOpenPlatformImageLoader();
        if (r102 == null) goto L9;
        r102.a(this.f117107g, r101, new mo0.b(ImageTag.SNOW_FLAKE, null, false, false, 30));
    L9:
        this.f117108h = (HSImageView) r110.findViewById(R.id.open_platform_animated_icon);
        if (r100.getValue().booleanValue() == false) goto L17;
        HSImageView r103 = this.f117108h;
        if (r103 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r103);
    L14:
        HSImageView r104 = (HSImageView) r110.findViewById(R.id.open_platform_animated_icon_v2);
        this.f117108h = r104;
        if (r104 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r104);
    L17:
        ko0.e.f504362e.getClass();
        String r105 = o90.f120886a.getValue().h();
        if (ko0.e.a.b() == false) goto L27;
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L27;
        boolean r107 = true;
    L28:
        Disposable r108 = null;
        if (r107 == true) goto L32;
        r105 = null;
    L32:
        if (r105 == null) goto L41;
        HSImageView r109 = this.f117108h;
        if (r109 == null) goto L38;
        GenericDraweeHierarchy r112 = r109.getHierarchy();
        if (r112 == null) goto L38;
        r112.setFadeDuration(0);
    L38:
        mo0.a r113 = ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).getOpenPlatformImageLoader();
        if (r113 == null) goto L41;
        r113.b(this.f117108h, r105, new mo0.b(ImageTag.SPREAD_FLOWERS, new b4(this), false, true, 10));
    L41:
        int r114 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.f116309a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.f117107g);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r110);
        Room r115 = (Room) r111.get("data_room", null);
        this.f117102b = r115;
        this.f117103c = r111;
        if (ht2.g.f(r115, 6, true) == false) goto L44;
        ht2.g.c(6, this.f117102b, null);
    L44:
        this.f117104d = (vlc.d) r111.get("data_message_manager", null);
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).setAudienceMiniAppReady(true);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r116 = AudienceMiniAppDataContext.a.a();
        if (r116 == null) goto L51;
        com.bytedance.live.datacontext.n<ToolbarEvent> r117 = r116.getToolbarEvent();
        if (r117 == null) goto L51;
        Observable<sh6.b<ToolbarEvent>> r118 = r117.a();
        if (r118 == null) goto L51;
        r108 = r118.subscribe(new g4(this));
    L51:
        this.f117109i = r108;
        return;
    L21:
        if (r105.length() == 0) goto L24;
        r106 = false;
    L27:
        r107 = false;
        goto L28
    L5:
        r101 = R.drawable.ttlive_ic_mini_app_new;
        goto L6
    }

    public static void b(c4 r100, Animatable r101, Function0 r102, Function0 r103) {
        r100.getClass();
        if ((r101 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r101).setAnimationListener(new f4(r102, r103, r101, null));
        return;
    }

    public final void a(ImageTag r100, HSImageView r110, String r111, Function2<? super ImageInfo, ? super Animatable, Boolean> r112, Function0<Unit> r113, Function0<Unit> r114) {
        if (r110 == null) goto L7;
        mo0.a r101 = ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).getOpenPlatformImageLoader();
        if (r101 == null) goto L8;
        r101.b(r110, r111, new mo0.b(r100, new b(this, r114, r112, r113), true, true, 2));
        return;
    L8:
        return;
    }
}
