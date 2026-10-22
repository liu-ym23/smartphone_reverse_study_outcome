package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.o1;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.vz;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public class g extends jg0.a<MultiLinkGuestViewBinder.a> implements jg0.e, LinkSucAnimationView.a, e6, jg0.d<MultiLinkGuestViewBinder.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiLinkGuestViewBinder.a f75723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f75724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintLayout f75725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f75726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f75727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnchorPauseTipsView f75728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f75729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f75730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MultiLinkMicSeatGiftIconElement f75731m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f75732n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f75733o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f75734p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public j22.c f75735q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AnimatorSet f75736r;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f75737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f75738b;

        public static final class a extends BaseControllerListener<ImageInfo> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f75739a;

            public a(b r100) {
                this.f75739a = r100;
            }

            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
                super.onFinalImageSet(r100, (ImageInfo) r101, r102);
                if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
                Animatable r103 = null;
            L6:
                AnimatedDrawable2 r104 = (AnimatedDrawable2) r103;
                if (r104 == null) goto L9;
                r104.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r102).getAnimationBackend()));
            L9:
                HSImageView r105 = this.f75739a.f75737a.f75734p;
                if (r105 == null) goto L13;
                r105.postDelayed(new h(this), 500);
                return;
            L13:
                return;
            L5:
                r103 = r102;
                goto L6
            }
        }

        public b(g r100, Ref.IntRef r101) {
            this.f75737a = r100;
            this.f75738b = r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100, r101);
            HSImageView r102 = this.f75737a.f75734p;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            String r103 = vz.f121488a.getValue();
            HSImageView r104 = this.f75737a.f75734p;
            if (r104 == null) goto L9;
            r104.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(r103).setControllerListener(new a(this)).build());
            return;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public c() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
            r102 = null;
        L5:
            AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
            if (r104 == null) goto L9;
            r104.stop();
            r104.jumpToFrame(1);
            return;
        }
    }

    static {
    }

    public void C() {
    }

    public void E(boolean r100) {
    }

    public void c(d6 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // jg0.e
    public void i() {
    }

    @Override // jg0.c, jg0.f
    public void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public boolean u() {
        return this instanceof k;
    }

    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b w() {
        return null;
    }

    public View x() {
        return null;
    }

    public Integer y() {
        return null;
    }

    public boolean z() {
        return true;
    }

    public final void D() {
        MultiLinkGuestViewBinder.a r100 = this.f75723e;
        if (r100 == null) goto L11;
        ch0.e r101 = r100.f75934k;
        if (r101 == null) goto L11;
        ILinkPlayerInfoBridge r102 = r101.f23724a;
        if (r102 == null) goto L11;
        if (n.f(r102) != true) goto L11;
        v();
        return;
    L11:
        HSImageView r103 = this.f75727i;
        if (r103 == null) goto L14;
        r103.setController(null);
    L14:
        HSImageView r104 = this.f75727i;
        if (r104 == null) goto L19;
        r104.setVisibility(4);
        return;
    }

    public void F() {
        if (SelfDisciplineContext.Companion.e() == false) goto L5;
    L25:
        MultiLinkMicSeatGiftIconElement r100 = this.f75731m;
        if (r100 == null) goto L33;
        r100.e(8);
        return;
    L33:
        return;
    L5:
        if (ThemedCompetitionContext.Companion.g() == true) goto L25;
        AnchorPauseTipsView r101 = this.f75728j;
        if (r101 != null) goto L9;
    L11:
        MultiLinkGuestViewBinder.a r102 = this.f75723e;
        if (r102 == null) goto L22;
        ch0.e r103 = r102.f75934k;
        if (r103 == null) goto L22;
        ILinkPlayerInfoBridge r104 = r103.f23724a;
        if (r104 == null) goto L22;
        if (r104.isOpenSendGift() != true) goto L22;
        MultiLinkMicSeatGiftIconElement r105 = this.f75731m;
        if (r105 == null) goto L29;
        r105.e(0);
        return;
    L29:
        return;
    L22:
        MultiLinkMicSeatGiftIconElement r106 = this.f75731m;
        if (r106 == null) goto L31;
        r106.e(8);
        return;
    L31:
        return;
    L9:
        if (r101.getVisibility() != 0) goto L11;
        goto L11
    }

    public final void G() {
        MultiLinkGuestViewBinder.a r100 = this.f75723e;
        if (r100 == null) goto L27;
        ch0.e r101 = r100.f75934k;
        if (r101 == null) goto L28;
        ILinkPlayerInfoBridge r102 = r101.f23724a;
        if (r102 == null) goto L29;
        n.f(r102);
        if (n.h(r102) == true) goto L17;
        if (n.f(r102) == false) goto L17;
        HSImageView r103 = this.f75727i;
        if (r103 == null) goto L15;
        r103.setController(null);
    L15:
        v();
        return;
    L17:
        if (n.h(r102) == false) goto L19;
        return;
    L19:
        if (n.f(r102) == true) goto L32;
        HSImageView r104 = this.f75727i;
        if (r104 == null) goto L23;
        r104.setController(null);
    L23:
        HSImageView r105 = this.f75727i;
        if (r105 == null) goto L33;
        r105.setVisibility(4);
        return;
    L33:
        return;
    L32:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // jg0.e
    public bd0.c f() {
        HSImageView r100 = this.f75726h;
        if (r100 == null) goto L5;
        int r101 = r100.getWidth();
    L6:
        HSImageView r102 = this.f75726h;
        if (r102 == null) goto L9;
        int r103 = r102.getHeight();
    L11:
        if (r101 <= 0) goto L19;
        if (r103 <= 0) goto L19;
        ConstraintLayout r104 = this.f75725g;
        if (r104 == null) goto L19;
        if (r104.getVisibility() != 0) goto L19;
        boolean r105 = false;
    L20:
        String r106 = null;
        if (r105 == false) goto L46;
        int[] r107 = new int[2];
        q().getLocationOnScreen(r107);
        float r110 = r107[0] + (q().getWidth() / 2.0f);
        float r111 = r107[1] + (q().getHeight() / 2.0f);
        HSImageView r108 = this.f75726h;
        HSImageView r112 = this.f75724f;
        MultiLinkGuestViewBinder.a r109 = this.f75723e;
        if (r109 == null) goto L31;
        ch0.e r113 = r109.f75934k;
        if (r113 == null) goto L31;
        ILinkPlayerInfoBridge r114 = r113.f23724a;
        if (r114 == null) goto L31;
        IBaseUser r115 = r114.getUser();
        if (r115 == null) goto L31;
        String r116 = r115.getIdString();
    L32:
        MultiLinkGuestViewBinder.a r117 = this.f75723e;
        if (r117 == null) goto L45;
        ch0.e r118 = r117.f75934k;
        if (r118 == null) goto L45;
        ILinkPlayerInfoBridge r119 = r118.f23724a;
        if (r119 == null) goto L45;
        IBaseUser r120 = r119.getUser();
        if (r120 == null) goto L45;
        py.k r121 = je0.d.n(r120, AvatarType.AVATAR_THUMB.getValue());
        if (r121 == null) goto L45;
        List<String> r122 = r121.getUrls();
        if (r122 == null) goto L45;
        r106 = (String) ListProtector.get(r122, 0);
    L45:
        bd0.c r123 = new bd0.c(r108, r112, r116, true, r110, r111, r106, false, null, null, null, null, 3968);
    L70:
        return r123;
    L31:
        r116 = null;
        goto L32
    L46:
        HSImageView r124 = this.f75726h;
        HSImageView r125 = this.f75724f;
        MultiLinkGuestViewBinder.a r126 = this.f75723e;
        if (r126 == null) goto L55;
        ch0.e r127 = r126.f75934k;
        if (r127 == null) goto L55;
        ILinkPlayerInfoBridge r128 = r127.f23724a;
        if (r128 == null) goto L55;
        IBaseUser r129 = r128.getUser();
        if (r129 == null) goto L55;
        String r210 = r129.getIdString();
    L56:
        MultiLinkGuestViewBinder.a r130 = this.f75723e;
        if (r130 == null) goto L69;
        ch0.e r131 = r130.f75934k;
        if (r131 == null) goto L69;
        ILinkPlayerInfoBridge r132 = r131.f23724a;
        if (r132 == null) goto L69;
        IBaseUser r133 = r132.getUser();
        if (r133 == null) goto L69;
        py.k r134 = je0.d.n(r133, AvatarType.AVATAR_THUMB.getValue());
        if (r134 == null) goto L69;
        List<String> r135 = r134.getUrls();
        if (r135 == null) goto L69;
        r106 = (String) ListProtector.get(r135, 0);
    L69:
        r123 = new bd0.c(r124, r125, r210, false, 0.0f, 0.0f, r106, false, null, null, null, null, 4024);
    L55:
        r210 = null;
    L19:
        r105 = true;
        goto L20
    L9:
        r103 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void g() {
        MultiLinkMicSeatGiftIconElement r100 = this.f75731m;
        if (r100 == null) goto L6;
        r100.e(8);
        return;
    }

    public void r() {
        MultiLinkGuestViewBinder.a r100 = this.f75723e;
        py.k r101 = null;
        if (r100 == null) goto L27;
        ch0.e r102 = r100.f75934k;
        if (r102 == null) goto L27;
        ILinkPlayerInfoBridge r103 = r102.f23724a;
        if (r103 == null) goto L27;
        if (r103.isAnonymous() != true) goto L27;
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder();
        MultiLinkGuestViewBinder.a r105 = this.f75723e;
        if (r105 == null) goto L23;
        ch0.e r106 = r105.f75934k;
        if (r106 == null) goto L23;
        ILinkPlayerInfoBridge r107 = r106.f23724a;
        if (r107 == null) goto L23;
        IBaseUser r108 = r107.getUser();
        if (r108 == null) goto L23;
        py.k r109 = r108.getAvatarMedium();
        if (r109 == null) goto L23;
        List<String> r110 = r109.getUrls();
        if (r110 == null) goto L23;
        String r111 = (String) CollectionsKt.firstOrNull(r110);
    L24:
        AbstractDraweeController r112 = r104.setUri(r111).setControllerListener(new i(this)).build();
        HSImageView r113 = this.f75726h;
        if (r113 == null) goto L43;
        r113.setController(r112);
    L43:
        MultiLinkGuestViewBinder.a r114 = this.f75723e;
        if (r114 == null) goto L72;
        ch0.e r115 = r114.f75934k;
        if (r115 == null) goto L72;
        ILinkPlayerInfoBridge r116 = r115.f23724a;
        if (r116 == null) goto L72;
        IBaseUser r117 = r116.getUser();
        if (r117 == null) goto L72;
        if (r117.isMysteryMan() != true) goto L72;
        TextView r118 = this.f75729k;
        if (r118 == null) goto L66;
        MultiLinkGuestViewBinder.a r119 = this.f75723e;
        if (r119 == null) goto L64;
        ch0.e r120 = r119.f75934k;
        if (r120 == null) goto L64;
        ILinkPlayerInfoBridge r121 = r120.f23724a;
        if (r121 == null) goto L64;
        IBaseUser r122 = r121.getUser();
        if (r122 == null) goto L64;
        String r123 = r122.getNickName();
    L65:
        r118.setText(r123);
    L64:
        r123 = null;
    L66:
        HSImageView r124 = this.f75724f;
        if (r124 == null) goto L69;
        r124.setController(null);
    L69:
        HSImageView r125 = this.f75724f;
        if (r125 == null) goto L106;
        r125.setBackgroundColor(ColorProtector.parseColor("#ffa393c8"));
        return;
    L106:
        return;
    L72:
        TextView r126 = this.f75729k;
        if (r126 == null) goto L85;
        MultiLinkGuestViewBinder.a r127 = this.f75723e;
        if (r127 == null) goto L83;
        ch0.e r128 = r127.f75934k;
        if (r128 == null) goto L83;
        ILinkPlayerInfoBridge r129 = r128.f23724a;
        if (r129 == null) goto L83;
        IBaseUser r130 = r129.getUser();
        if (r130 == null) goto L83;
        String r131 = r130.getRealNickName();
    L84:
        r126.setText(r131);
    L83:
        r131 = null;
    L85:
        MultiLinkGuestViewBinder.a r132 = this.f75723e;
        if (r132 == null) goto L94;
        ch0.e r133 = r132.f75934k;
        if (r133 == null) goto L94;
        ILinkPlayerInfoBridge r134 = r133.f23724a;
        if (r134 == null) goto L94;
        if (r134.isAnonymous() != true) goto L94;
        int r135 = 50;
    L95:
        HSImageView r136 = this.f75724f;
        MultiLinkGuestViewBinder.a r137 = this.f75723e;
        if (r137 == null) goto L104;
        ch0.e r138 = r137.f75934k;
        if (r138 == null) goto L104;
        ILinkPlayerInfoBridge r139 = r138.f23724a;
        if (r139 == null) goto L104;
        IBaseUser r140 = r139.getUser();
        if (r140 == null) goto L104;
        r101 = r140.getAvatarMedium();
    L104:
        ImageLoader.bindImage(r136, r101, new l3(r135));
        return;
    L94:
        r135 = 15;
    L23:
        r111 = null;
    L27:
        HSImageView r141 = this.f75726h;
        if (r141 == null) goto L32;
        Drawable r142 = r141.getBackground();
        if (r142 == null) goto L32;
        r142.setAlpha(1);
    L32:
        HSImageView r143 = this.f75726h;
        MultiLinkGuestViewBinder.a r144 = this.f75723e;
        if (r144 == null) goto L41;
        ch0.e r145 = r144.f75934k;
        if (r145 == null) goto L41;
        ILinkPlayerInfoBridge r146 = r145.f23724a;
        if (r146 == null) goto L41;
        IBaseUser r147 = r146.getUser();
        if (r147 == null) goto L41;
        py.k r148 = r147.getAvatarMedium();
    L42:
        ImageUtil.loadRoundImageAntiFlink(r143, r148, 0);
    L41:
        r148 = null;
        goto L42
    }

    public final void t() {
        AnimatorSet r100 = this.f75736r;
        if (r100 == null) goto L7;
        if (r100.isRunning() != true) goto L7;
        return;
    L7:
        if (this.f75726h == null) goto L31;
        this.f75736r = new AnimatorSet();
        PropertyValuesHolder r101 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.2f});
        PropertyValuesHolder r102 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.2f});
        PropertyValuesHolder r103 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.2f, 1.0f});
        PropertyValuesHolder r104 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.2f, 1.0f});
        ObjectAnimator r105 = ObjectAnimator.ofPropertyValuesHolder(this.f75726h, new PropertyValuesHolder[]{r101, r102});
        r105.setDuration(160);
        ObjectAnimator r106 = ObjectAnimator.ofPropertyValuesHolder(this.f75733o, new PropertyValuesHolder[]{r101, r102});
        r106.setDuration(160);
        ObjectAnimator r107 = ObjectAnimator.ofPropertyValuesHolder(this.f75734p, new PropertyValuesHolder[]{r101, r102});
        r107.setDuration(160);
        ObjectAnimator r108 = ObjectAnimator.ofPropertyValuesHolder(this.f75726h, new PropertyValuesHolder[]{r103, r104});
        r108.setDuration(300);
        ObjectAnimator r110 = ObjectAnimator.ofPropertyValuesHolder(this.f75733o, new PropertyValuesHolder[]{r103, r104});
        r110.setDuration(300);
        ObjectAnimator r109 = ObjectAnimator.ofPropertyValuesHolder(this.f75734p, new PropertyValuesHolder[]{r103, r104});
        r109.setDuration(300);
        AnimatorSet r111 = new AnimatorSet();
        AnimatorSet.Builder r112 = r111.play(r105);
        if (r112 == null) goto L14;
        AnimatorSet.Builder r113 = r112.with(r106);
        if (r113 == null) goto L14;
        r113.with(r107);
    L14:
        AnimatorSet r114 = new AnimatorSet();
        AnimatorSet.Builder r115 = r114.play(r108);
        if (r115 == null) goto L19;
        AnimatorSet.Builder r116 = r115.with(r110);
        if (r116 == null) goto L19;
        r116.with(r109);
    L19:
        AnimatorSet r117 = this.f75736r;
        if (r117 == null) goto L24;
        AnimatorSet.Builder r118 = r117.play(r111);
        if (r118 == null) goto L24;
        r118.before(r114);
    L24:
        Ref.IntRef r119 = new Ref.IntRef();
        r119.element = 1;
        AnimatorSet r120 = this.f75736r;
        if (r120 == null) goto L27;
        r120.addListener(new b(this, r119));
    L27:
        AnimatorSet r121 = this.f75736r;
        if (r121 == null) goto L32;
        r121.start();
        return;
    L32:
        return;
    }

    public void v() {
        MultiLinkGuestViewBinder.a r100 = this.f75723e;
        DraweeController r101 = null;
        if (r100 == null) goto L7;
        ch0.e r102 = r100.f75934k;
        if (r102 == null) goto L7;
        ILinkPlayerInfoBridge r103 = r102.f23724a;
    L8:
        if (r103 != null) goto L10;
        return;
    L10:
        if (n.f(r103) == false) goto L71;
        HSImageView r104 = this.f75727i;
        if (r104 == null) goto L15;
        DraweeController r105 = r104.getController();
    L16:
        if (r105 == null) goto L64;
        HSImageView r106 = this.f75727i;
        if (r106 == null) goto L45;
        DraweeController r107 = r106.getController();
        if (r107 == null) goto L45;
        Animatable r108 = r107.getAnimatable();
    L46:
        if (r108 == null) goto L68;
        HSImageView r109 = this.f75727i;
        if (r109 == null) goto L52;
        DraweeController r110 = r109.getController();
        if (r110 == null) goto L52;
        Animatable r111 = r110.getAnimatable();
    L54:
        if ((r111 instanceof AnimatedDrawable2) == false) goto L69;
        HSImageView r112 = this.f75727i;
        if (r112 == null) goto L58;
        r101 = r112.getController();
    L58:
        Intrinsics.checkNotNull(r101);
        Animatable r113 = r101.getAnimatable();
        if (r113 == null) goto L62;
        AnimatedDrawable2 r114 = (AnimatedDrawable2) r113;
        r114.stop();
        r114.jumpToFrame(1);
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.fresco.animation.drawable.AnimatedDrawable2");
    L69:
        return;
    L52:
        r111 = null;
        goto L54
    L68:
        return;
    L45:
        r108 = null;
        goto L46
    L64:
        kd1.b r115 = r103.getMicDress();     // Catch: Exception -> L37
        if (r115 == null) goto L27;
        kd1.c r116 = r115.getVoiceWave();     // Catch: Exception -> L37
        if (r116 == null) goto L27;
        py.k r117 = r116.getMediumImg();     // Catch: Exception -> L37
        if (r117 == null) goto L27;
        List<String> r118 = r117.getUrls();     // Catch: Exception -> L37
        if (r118 == null) goto L27;
        String r119 = (String) ListProtector.get(r118, 0);     // Catch: Exception -> L37
    L28:
        c r120 = new c();
        PipelineDraweeControllerBuilder r121 = Fresco.newDraweeControllerBuilder().setUri(r119);
        HSImageView r122 = this.f75727i;
        if (r122 == null) goto L31;
        r101 = r122.getController();
    L31:
        AbstractDraweeController r123 = r121.setOldController(r101).setControllerListener(r120).setAutoPlayAnimations(false).build();
        HSImageView r124 = this.f75727i;
        if (r124 == null) goto L34;
        r124.setController(r123);
    L34:
        HSImageView r125 = this.f75727i;
        if (r125 == null) goto L66;
        r125.setVisibility(0);
        return;
    L66:
        return;
    L27:
        r119 = null;
    L37:
        e = move-exception;
        ALogger.e("MultiLinkGuestMicSeatBasicLayer", "get url fail. Exception type:".concat(e.getClass().getSimpleName()));
        return;
    L15:
        r105 = null;
        goto L16
    L71:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void h() {
        r();
        F();
    }

    public void H(int r100) {
        MultiLinkGuestViewBinder.a r101 = this.f75723e;
        if (r101 == null) goto L11;
        ch0.e r102 = r101.f75934k;
        if (r102 == null) goto L11;
        ILinkPlayerInfoBridge r103 = r102.f23724a;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r103.getRoomLinkSilenceStatus() != 1) goto L11;
    L12:
        View r105 = null;
        if (r104 == false) goto L25;
        View r106 = this.f75730l;
        if (r106 == null) goto L17;
        r106.setVisibility(0);
    L17:
        View r107 = this.f75730l;
        if ((r107 instanceof ImageView) == false) goto L21;
        r105 = r107;
    L21:
        ImageView r108 = (ImageView) r105;
        if (r108 == null) goto L24;
        r108.setImageResource(R.drawable.ttlive_icon_link_room_silence);
    L24:
        D();
        return;
    L25:
        if (r100 == 0) goto L37;
        View r109 = this.f75730l;
        if (r109 == null) goto L29;
        r109.setVisibility(0);
    L29:
        View r110 = this.f75730l;
        if ((r110 instanceof ImageView) == false) goto L33;
        r105 = r110;
    L33:
        ImageView r111 = (ImageView) r105;
        if (r111 == null) goto L36;
        r111.setImageResource(R.drawable.ttlive_icon_video_silence);
    L36:
        D();
        return;
    L37:
        View r112 = this.f75730l;
        if (r112 == null) goto L43;
        r112.setVisibility(8);
        return;
    L43:
        return;
    L11:
        r104 = false;
        goto L12
    }

    @Override // jg0.c, jg0.f
    public void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        this.f75724f = (HSImageView) q().findViewById(R.id.ttlive_guest_bg);
        this.f75725g = (ConstraintLayout) q().findViewById(R.id.ttlive_guest_container);
        this.f75726h = (HSImageView) q().findViewById(R.id.ttlive_guest_avatar);
        this.f75728j = (AnchorPauseTipsView) q().findViewById(R.id.ttlive_leave_view);
        LinearLayout r101 = (LinearLayout) q().findViewById(R.id.ttlive_guest_name_container);
        this.f75729k = (TextView) q().findViewById(R.id.ttlive_guest_name);
        this.f75730l = q().findViewById(R.id.ttlive_guest_identification);
        this.f75727i = (HSImageView) q().findViewById(R.id.ttlive_volume_Anim);
        int r102 = 0;
        if ((this instanceof f) == false) goto L5;
    L8:
        View r103 = q().findViewById(R.id.play_mode_user_info_bar);
        AttributeSet r104 = null;
        if ((r103 instanceof FrameLayout) == true) goto L11;
        r103 = null;
    L11:
        FrameLayout r105 = (FrameLayout) r103;
        LinkMicQuickInteractView r106 = new LinkMicQuickInteractView(r100, r104, 6, r102);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 19;
        r106.setLayoutParams(r107);
        r106.setId(R.id.ttlive_guest_fans_ticket_count_dynamic);
        if (r105 == null) goto L14;
        r105.addView(r106);
    L14:
        LinkMicQuickInteractView.a(r106, true, false, 2);
        r106.f79543x = "0";
        r106.f79533n.f();
        MultiLinkMicSeatGiftIconElement r108 = new MultiLinkMicSeatGiftIconElement(r106, true);
        this.f75731m = r108;
        r108.e(8);
    L15:
        this.f75732n = (FrameLayout) q().findViewById(R.id.ttlive_xplay_h5_container);
        this.f75735q = new j22.c(this.f75727i);
        return;
    L5:
        if ((this instanceof d) == true) goto L8;
        this.f75731m = new MultiLinkMicSeatGiftIconElement((LinkMicQuickInteractView) q().findViewById(R.id.ttlive_guest_fans_ticket_count), false);
        goto L15
    }

    public g(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        super(r100, r101);
    }

    public void A(MultiLinkGuestViewBinder.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        this.f75723e = r100;
        MultiLinkMicSeatGiftIconElement r102 = this.f75731m;
        if (r102 == null) goto L5;
        r102.f75668a = r100;
        r102.d();
    L5:
        r();
        AnchorPauseTipsView r103 = this.f75728j;
        if (r103 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r103);
    L8:
        F();
        MultiLinkGuestViewBinder.a r104 = this.f75723e;
        if (r104 == null) goto L15;
        ch0.e r105 = r104.f75934k;
        if (r105 == null) goto L15;
        ILinkPlayerInfoBridge r106 = r105.f23724a;
        if (r106 == null) goto L15;
        int r107 = r106.getSilenceStatus();
    L16:
        H(r107);
        MultiLinkGuestViewBinder.a r108 = this.f75723e;
        if (r108 == null) goto L24;
        ch0.e r109 = r108.f75934k;
        if (r109 == null) goto L24;
        ILinkPlayerInfoBridge r110 = r109.f23724a;
        if (r110 == null) goto L24;
        String r111 = r110.getFanTicketDisplayStr();
        if (r111 == null) goto L24;
    L25:
        MultiLinkGuestViewBinder.a r112 = this.f75723e;
        if (r112 == null) goto L35;
        ch0.e r113 = r112.f75934k;
        if (r113 == null) goto L35;
        ILinkPlayerInfoBridge r114 = r113.f23724a;
        if (r114 == null) goto L35;
        IBaseUser r115 = r114.getUser();
        if (r115 == null) goto L35;
        String r116 = r115.getIdString();
        if (r116 == null) goto L35;
    L36:
        s(r111, r116);
        G();
        Object r117 = q().getParent();
        CharSequence r118 = null;
        if ((r117 instanceof View) == true) goto L39;
        r117 = null;
    L39:
        View r119 = (View) r117;
        StringBuilder r120 = new StringBuilder();
        r120.append(r101);
        r120.append(s1.B(R.string.ttlive_mic_no));
        r120.append(' ');
        TextView r121 = this.f75729k;
        if (r121 == null) goto L42;
        r118 = r121.getText();
    L42:
        r120.append(r118);
        r3.c(r119, r120.toString(), true);
        return;
    L35:
        r116 = "";
    L24:
        r111 = "0";
    L15:
        r107 = -1;
        goto L16
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r100, int r101) {
        A(r100, r101);
    }

    public final void s(String r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r211, "playerUid");
        MultiLinkGuestViewBinder.a r100 = this.f75723e;
        if (r100 == null) goto L7;
        ch0.e r101 = r100.f75934k;
        if (r101 == null) goto L7;
        ILinkPlayerInfoBridge r102 = r101.f23724a;
    L8:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        boolean r103 = false;
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.c(r102) == true) goto L11;
    L46:
        MultiLinkMicSeatGiftIconElement r104 = this.f75731m;
        if (r104 == null) goto L64;
        Intrinsics.checkNotNullParameter(r210, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r211, "playerUid");
        if (r104.b() != null) goto L51;
        r103 = true;
    L51:
        if (r103 == false) goto L65;
        LinkMicQuickInteractView r105 = r104.f75666c;
        if (r105 == null) goto L66;
        r105.b(r210, r211);
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L11:
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a() == null) goto L46;
        TeamFightContext.a r106 = TeamFightContext.Companion;
        if (r106.f() == true) goto L17;
        if (r106.e() == true) goto L17;
    L21:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r107 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.a();
        Intrinsics.checkNotNull(r107);
        if (r107.isEmpty() == false) goto L24;
    L37:
        MultiLinkMicSeatGiftIconElement r108 = this.f75731m;
        if (r108 == null) goto L60;
        Intrinsics.checkNotNullParameter(r210, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r211, "playerUid");
        if (r108.b() != null) goto L42;
        r103 = true;
    L42:
        if (r103 == false) goto L61;
        LinkMicQuickInteractView r109 = r108.f75666c;
        if (r109 == null) goto L62;
        r109.b(r210, r211);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L24:
        if (r106.f() == true) goto L37;
        if (r106.e() == true) goto L37;
        if (ThemedCompetitionContext.Companion.g() == true) goto L37;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r110 = MultiRevenueDataContext.a.b();
        if (r110 != null) goto L32;
    L34:
        MultiLinkMicSeatGiftIconElement r111 = this.f75731m;
        if (r111 == null) goto L58;
        r111.c(new QuickInteractTask(je0.d.b0(), r210, 0, null, null, null, 0, null, false, null, null, null, null, 8188));
        return;
    L58:
        return;
    L32:
        if (r110.isFightShowing() != true) goto L34;
    L17:
        if (je0.d.r() == false) goto L21;
        MultiLinkMicSeatGiftIconElement r112 = this.f75731m;
        if (r112 == null) goto L56;
        r112.c(new QuickInteractTask(je0.d.b0(), r210, 0, null, null, null, 0, null, false, null, null, null, null, 8188));
        return;
    L56:
        return;
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void B(MultiLinkGuestViewBinder.a r110, int r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r110, "itemData");
        Intrinsics.checkNotNullParameter(r211, WsConstants.KEY_PAYLOAD);
        this.f75723e = r110;
        Iterator<String> r100 = r211.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L317;
        String r101 = r100.next();
        if (r101 == null) goto L4;
        ILinkPlayerInfoBridge r102 = null;
        py.k r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        DraweeController r104 = null;
        Integer r105 = null;
        DraweeController r106 = null;
        DraweeController r107 = null;
        Object r108 = null;
        r102 = null;
        boolean r109 = false;
        int r111 = -1;
        switch(r101.hashCode()) {
            case -2108878291: goto L252;
            case -1998665887: goto L249;
            case -1919610850: goto L246;
            case -1902415957: goto L233;
            case -1227871264: goto L199;
            case -1010189482: goto L187;
            case -715388833: goto L184;
            case -703589172: goto L181;
            case -643953561: goto L56;
            case 268668786: goto L53;
            case 316138020: goto L50;
            case 826672197: goto L47;
            case 1640944494: goto L44;
            case 1793196717: goto L39;
            case 2021952839: goto L12;
            default: goto L4;
        };
    L12:
        if (r101.equals("payload_key_silence_status_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r112 = this.f75723e;
        if (r112 == null) goto L20;
        ch0.e r113 = r112.f75934k;
        if (r113 == null) goto L20;
        ILinkPlayerInfoBridge r114 = r113.f23724a;
        if (r114 == null) goto L20;
        r111 = r114.getSilenceStatus();
    L20:
        H(r111);
        MultiLinkGuestViewBinder.a r115 = this.f75723e;
        if (r115 == null) goto L4;
        ch0.e r116 = r115.f75934k;
        if (r116 == null) goto L4;
        ILinkPlayerInfoBridge r117 = r116.f23724a;
        if (r117 == null) goto L4;
        if (r117.isBackground() != true) goto L4;
        MultiLinkGuestViewBinder.a r118 = this.f75723e;
        if (r118 == null) goto L37;
        ch0.e r119 = r118.f75934k;
        if (r119 == null) goto L37;
        ILinkPlayerInfoBridge r120 = r119.f23724a;
        if (r120 == null) goto L37;
        if (r120.isBackground() != true) goto L37;
        r109 = true;
    L37:
        E(r109);
        goto L4
    L39:
        if (r101.equals("payload_key_dynamic_data_update_for_gift_icon_info") == false) goto L4;
        MultiLinkMicSeatGiftIconElement r121 = this.f75731m;
        if (r121 == null) goto L4;
        r121.f75668a = this.f75723e;
        r121.d();
        goto L4
    L44:
        if (r101.equals("payload_key_mic_dress") == false) goto L4;
        G();
        goto L4
    L47:
        if (r101.equals("payload_key_linkmic_2d_avatar_update") == false) goto L4;
    L247:
        r();
        goto L4
    L50:
        if (r101.equals("payload_key_linkmic_3d_avatar_update") == false) goto L4;
    L53:
        if (r101.equals("payload_key_is_open_send_gift_update") == false) goto L4;
        F();
        goto L4
    L56:
        if (r101.equals("payload_key_mic_talk_state") == false) goto L4;
        ?? r122 = ch0.f.a(r110.f75934k);
        if (r110.f75934k.f23724a.getSilenceStatus() != 0) goto L59;
        if (r122 > 0) goto L61;
        MultiLinkGuestViewBinder.a r123 = this.f75723e;
        if (r123 == null) goto L156;
        IVoiceLiveTheme r124 = r123.f545687c;
    L157:
        if (r124 == null) goto L163;
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r124) != true) goto L163;
        j22.c r125 = this.f75735q;
        if (r125 == null) goto L4;
        r125.f496963d = true;
    L163:
        MultiLinkGuestViewBinder.a r126 = this.f75723e;
        if (r126 == null) goto L174;
        ch0.e r127 = r126.f75934k;
        if (r127 == null) goto L174;
        ILinkPlayerInfoBridge r128 = r127.f23724a;
        if (r128 == null) goto L174;
        if (n.f(r128) != true) goto L174;
        j22.c r129 = this.f75735q;
        if (r129 == null) goto L4;
        r129.f496963d = true;
    L174:
        HSImageView r130 = this.f75727i;
        if (r130 == null) goto L177;
        r130.setController(null);
    L177:
        HSImageView r131 = this.f75727i;
        if (r131 == null) goto L4;
        r131.setVisibility(4);
        goto L4
    L156:
        r124 = null;
        goto L157
    L61:
        HSImageView r132 = this.f75727i;
        if (r132 == null) goto L64;
        r132.setVisibility(0);
    L64:
        MultiLinkGuestViewBinder.a r133 = this.f75723e;
        if (r133 == null) goto L89;
        ch0.e r134 = r133.f75934k;
        if (r134 == null) goto L89;
        ILinkPlayerInfoBridge r135 = r134.f23724a;
        if (r135 == null) goto L89;
        if (n.f(r135) != true) goto L89;
        MultiLinkGuestViewBinder.a r136 = this.f75723e;
        if (r136 == null) goto L83;
        ch0.e r137 = r136.f75934k;
        if (r137 == null) goto L83;
        ILinkPlayerInfoBridge r138 = r137.f23724a;
        if (r138 == null) goto L83;
        kd1.b r139 = r138.getMicDress();
        if (r139 == null) goto L83;
        kd1.c r140 = r139.getVoiceWave();
        if (r140 == null) goto L83;
        r103 = kd1.d.a(r140, r122 == true ? 1 : 0);
    L83:
        j22.c r141 = this.f75735q;
        if (r141 == null) goto L86;
        r141.f(r103);
    L86:
        HSImageView r142 = this.f75727i;
        if (r142 == null) goto L4;
        r142.setVisibility(0);
    L89:
        MultiLinkGuestViewBinder.a r143 = this.f75723e;
        if (r143 == null) goto L92;
        IVoiceLiveTheme r144 = r143.f545687c;
    L93:
        if (r144 != null) goto L94;
        PipelineDraweeControllerBuilder r145 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(vm2.d.t()));
        HSImageView r146 = this.f75727i;
        if (r146 == null) goto L147;
        r104 = r146.getController();
    L147:
        AbstractDraweeController r147 = r145.setOldController(r104).setAutoPlayAnimations(true).build();
        HSImageView r148 = this.f75727i;
        if (r148 == null) goto L150;
        r148.setController(r147);
    L150:
        HSImageView r149 = this.f75727i;
        if (r149 == null) goto L4;
        r149.setVisibility(0);
        goto L4
    L94:
        if (r143 == null) goto L98;
        ch0.e r150 = r143.f75934k;
        if (r150 == null) goto L98;
        ILinkPlayerInfoBridge r151 = r150.f23724a;
    L99:
        if (r143 == null) goto L101;
        IVoiceLiveTheme r152 = r143.f545687c;
    L102:
        if (r152 != null) goto L104;
    L116:
        if (r152 == null) goto L118;
        py.k r153 = r152.getEffectAvatarTalk();
    L119:
        if (r153 == null) goto L135;
        if (r152 == null) goto L122;
        py.k r154 = r152.getEffectAvatarTalk();
    L123:
        Intrinsics.checkNotNull(r154);
        if (CollectionUtils.isEmpty(r154.getUrls()) == true) goto L135;
        PipelineDraweeControllerBuilder r155 = Fresco.newDraweeControllerBuilder();
        if (r152 == null) goto L128;
        py.k r156 = r152.getEffectAvatarTalk();
    L129:
        PipelineDraweeControllerBuilder r157 = r155.setFirstAvailableImageRequests(a1.b(r156, -1));
        HSImageView r158 = this.f75727i;
        if (r158 == null) goto L132;
        r106 = r158.getController();
    L132:
        AbstractDraweeController r159 = r157.setOldController(r106).setAutoPlayAnimations(true).build();
        HSImageView r160 = this.f75727i;
        if (r160 == null) goto L141;
        r160.setController(r159);
    L141:
        HSImageView r161 = this.f75727i;
        if (r161 == null) goto L4;
        r161.setVisibility(0);
        goto L4
    L128:
        r156 = null;
        goto L129
    L122:
        r154 = null;
    L135:
        PipelineDraweeControllerBuilder r162 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.t());
        HSImageView r163 = this.f75727i;
        if (r163 == null) goto L138;
        r107 = r163.getController();
    L138:
        AbstractDraweeController r164 = r162.setOldController(r107).setAutoPlayAnimations(true).build();
        HSImageView r165 = this.f75727i;
        if (r165 == null) goto L141;
        r165.setController(r164);
        goto L141
    L118:
        r153 = null;
        goto L119
    L104:
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r152) != true) goto L116;
        if (r151 != null) goto L107;
    L112:
        int r166 = 0;
    L113:
        py.k r167 = IVoiceLiveThemeKt.getVolumeAnim(r152, 3, r122 == true ? 1 : 0, r166, o1.a(), u());
        j22.c r168 = this.f75735q;
        if (r168 == null) goto L141;
        r168.e(r167);
        goto L141
    L107:
        if (r151.getUser() == null) goto L112;
        IBaseUser r169 = r151.getUser();
        if (r169 == null) goto L111;
        r105 = Integer.valueOf(r169.getGender());
    L111:
        Intrinsics.checkNotNull(r105);
        r166 = r105.intValue();
        goto L113
    L101:
        r152 = null;
    L98:
        r151 = null;
        goto L99
    L92:
        r144 = null;
        goto L93
    L59:
        D();
        goto L4
    L181:
        if (r101.equals("payload_key_user_position") == false) goto L4;
        A(r110, r210);
        goto L4
    L184:
        if (r101.equals("payload_key_is_c_position_update") == false) goto L4;
        A(r110, r210);
        goto L4
    L187:
        if (r101.equals("payload_key_background_status_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r170 = this.f75723e;
        if (r170 == null) goto L197;
        ch0.e r171 = r170.f75934k;
        if (r171 == null) goto L197;
        ILinkPlayerInfoBridge r172 = r171.f23724a;
        if (r172 == null) goto L197;
        if (r172.isBackground() != true) goto L197;
        r109 = true;
    L197:
        E(r109);
        goto L4
    L199:
        if (r101.equals("payload_key_gift_icon_flash_update") == false) goto L4;
        Intrinsics.checkNotNullParameter(r110, "itemData");
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "onGiftIconFlash");
        MultiLinkMicSeatGiftIconElement r173 = this.f75731m;
        if (r173 == null) goto L205;
        LinkMicQuickInteractView r174 = r173.f75666c;
        if (r174 == null) goto L205;
        Integer r175 = Integer.valueOf(r174.getVisibility());
    L206:
        if (r175 == null) goto L4;
        if (r175.intValue() != 0) goto L4;
        r110.f75934k.f23727d.remove("EXT_KEY_GIFT_ICON_FLASH");
        MultiLinkMicSeatGiftIconElement r176 = this.f75731m;
        if (r176 == null) goto L4;
        LinkMicQuickInteractView r177 = r176.f75666c;
        if (r177 == null) goto L4;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r178 = r177.f79533n;
        AnimatorSet r179 = r178.f79582i;
        if (r179 == null) goto L220;
        if (r179.isRunning() == true) goto L4;
    L220:
        if (((Boolean) vm2.d.f555891l4.getValue(null, vm2.d.f555776a[269(0x10d, float:3.77E-43)])).booleanValue() == false) goto L224;
        if (r178.f79581h != null) goto L4;
    L224:
        r178.f79583j = 3;
        r178.c();
        r178.b();
        ObjectAnimator r180 = ObjectAnimator.ofFloat(r178.f79574a, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.1f});
        ObjectAnimator r181 = ObjectAnimator.ofFloat(r178.f79574a, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.1f});
        Animator r182 = r178.d(0, 200);
        ObjectAnimator r183 = ObjectAnimator.ofFloat(r178.f79575b, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.2f});
        ObjectAnimator r184 = ObjectAnimator.ofFloat(r178.f79575b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.3f});
        ObjectAnimator r185 = ObjectAnimator.ofFloat(r178.f79575b, "alpha", new float[]{0.0f, 0.8f});
        AnimatorSet r186 = new AnimatorSet();
        r186.setDuration(200);
        r186.playTogether(new Animator[]{r180, r181, r182, r183, r184, r185});
        ObjectAnimator r187 = ObjectAnimator.ofFloat(r178.f79575b, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.2f, 1.4f});
        ObjectAnimator r188 = ObjectAnimator.ofFloat(r178.f79575b, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.3f, 1.5f});
        ObjectAnimator r189 = ObjectAnimator.ofFloat(r178.f79575b, "alpha", new float[]{0.8f, 0.0f});
        AnimatorSet r190 = new AnimatorSet();
        r190.setDuration(300);
        r190.playTogether(new Animator[]{r187, r188, r189});
        ObjectAnimator r191 = ObjectAnimator.ofFloat(r178.f79574a, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.1f, 1.0f, 1.0f});
        ObjectAnimator r192 = ObjectAnimator.ofFloat(r178.f79574a, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.1f, 1.0f, 1.0f});
        Animator r193 = r178.e(700, 400);
        AnimatorSet r194 = new AnimatorSet();
        r194.setStartDelay(700);
        r194.setDuration(400);
        r194.playTogether(new Animator[]{r191, r192, r193});
        AnimatorSet r195 = new AnimatorSet();
        r178.f79582i = r195;
        r195.addListener(new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.b(r178));
        AnimatorSet r196 = r178.f79582i;
        if (r196 == null) goto L227;
        boolean r197 = true;
        r196.playSequentially(new Animator[]{r186, r190, r194});
    L228:
        AnimatorSet r198 = r178.f79582i;
        if (r198 == null) goto L231;
        r198.start();
    L231:
        r178.f79585l = r197;
        goto L4
    L227:
        r197 = true;
    L205:
        r175 = null;
        goto L206
    L233:
        if (r101.equals("payload_key_interact_task_update") == false) goto L4;
        Object r199 = r110.f75934k.f23727d.get("EXT_KEY_QUICK_INTERACT_TASK");
        if ((r199 instanceof QuickInteractTask) == false) goto L238;
        r108 = r199;
    L238:
        QuickInteractTask r200 = (QuickInteractTask) r108;
        if (r200 == null) goto L4;
        if (r200.getType() != 0) goto L4;
        r110.f75934k.f23727d.remove("EXT_KEY_QUICK_INTERACT_TASK");
        Intrinsics.checkNotNullParameter(r200, "task");
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "onReceiveInteractTask");
        MultiLinkMicSeatGiftIconElement r201 = this.f75731m;
        if (r201 == null) goto L4;
        r201.a(r200);
        goto L4
    L246:
        if (r101.equals("payload_key_avatar_update") == false) goto L4;
    L249:
        if (r101.equals("payload_key_video_status_update") == false) goto L4;
        C();
        goto L4
    L252:
        if (r101.equals("payload_key_fan_ticket_str_update") == false) goto L4;
        Object r202 = r110.f75934k.f23727d.remove("EXT_KEY_QUICK_INTERACT_MESSAGE");
        if ((r202 instanceof QuickInteractTask) == true) goto L256;
        r202 = null;
    L256:
        QuickInteractTask r203 = (QuickInteractTask) r202;
        if (r203 == null) goto L4;
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "updateFanTicketStr, task: " + r203);
        String r204 = r203.f79479b;
        if (r204 == null) goto L4;
        MultiLinkGuestViewBinder.a r205 = this.f75723e;
        if (r205 == null) goto L265;
        ch0.e r206 = r205.f75934k;
        if (r206 == null) goto L265;
        r102 = r206.f23724a;
    L265:
        if (r102 == null) goto L267;
        r102.setFanTicketDisplayStr(r204);
    L267:
        F();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.f79516r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C1237b.c(r102) == true) goto L269;
        MultiLinkMicSeatGiftIconElement r207 = this.f75731m;
        if (r207 == null) goto L4;
        Intrinsics.checkNotNullParameter(r204, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        if (r207.b() != null) goto L312;
        boolean r208 = true;
    L313:
        if (r208 == false) goto L4;
        LinkMicQuickInteractView r209 = r207.f75666c;
        if (r209 == null) goto L4;
        r209.j(r204);
        goto L4
    L312:
        r208 = false;
        goto L313
    L269:
        TeamFightContext.a r212 = TeamFightContext.Companion;
        if (r212.f() == true) goto L274;
        if (r212.e() == true) goto L274;
    L279:
        if (r212.f() == true) goto L297;
        if (r212.e() == true) goto L297;
        if (ThemedCompetitionContext.Companion.g() == true) goto L297;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r213 = MultiRevenueDataContext.a.b();
        if (r213 == null) goto L293;
        if (r213.isFightShowing() != true) goto L293;
        com.bytedance.android.live.liveinteract.revenuebase.b r214 = MultiRevenueDataContext.a.b();
        if (r214 == null) goto L297;
        if (r214.A4() != true) goto L297;
    L293:
        MultiLinkMicSeatGiftIconElement r215 = this.f75731m;
        if (r215 == null) goto L4;
        r215.c(r203);
    L297:
        MultiLinkMicSeatGiftIconElement r216 = this.f75731m;
        if (r216 == null) goto L4;
        Intrinsics.checkNotNullParameter(r204, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        if (r216.b() != null) goto L302;
        boolean r217 = true;
    L303:
        if (r217 == false) goto L4;
        LinkMicQuickInteractView r218 = r216.f75666c;
        if (r218 == null) goto L4;
        r218.j(r204);
        goto L4
    L302:
        r217 = false;
    L274:
        if (je0.d.r() == false) goto L279;
        MultiLinkMicSeatGiftIconElement r219 = this.f75731m;
        if (r219 == null) goto L4;
        r219.c(r203);
        goto L4
    L317:
        C();
    }

    public void e(int r100, p r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (Intrinsics.areEqual(r101, bj0.e.f19204b) == false) goto L14;
        MultiLinkGuestViewBinder.a r103 = this.f75723e;
        if (r103 == null) goto L11;
        ch0.e r104 = r103.f75934k;
        if (r104 == null) goto L11;
        ILinkPlayerInfoBridge r105 = r104.f23724a;
        if (r105 == null) goto L11;
        int r106 = r105.getSilenceStatus();
    L12:
        H(r106);
        return;
    L11:
        r106 = -1;
        goto L12
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r100, int r101, Bundle r102) {
        B(r100, r101, r102);
    }
}
