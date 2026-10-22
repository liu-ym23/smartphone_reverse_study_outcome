package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.g6;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public HSImageView A;
    public TextView B;
    public LinearLayout C;
    public HSImageView D;
    public TextView E;
    public LottieAnimationView F;
    public TextView G;
    public AnimatorSet H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinearLayout f75786z;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return R.layout.ttlive_layer_multilink_audio_guest_large_c_position;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonFirstUserGuestMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        gh0.b.a("audio_layer_update", "MultiLinkAudioFirstUserMicSeatBasicLayer#onCreate", false);
        this.F = (LottieAnimationView) q().findViewById(R.id.guide_avatar_effect);
        this.G = (TextView) q().findViewById(R.id.guide_anchor_description_tv);
        this.f75786z = (LinearLayout) q().findViewById(R.id.guide_anchor_info_left_layout);
        this.A = (HSImageView) q().findViewById(R.id.guide_anchor_info_left_icon);
        this.B = (TextView) q().findViewById(R.id.guide_anchor_info_left_tv);
        this.C = (LinearLayout) q().findViewById(R.id.guide_anchor_info_right_layout);
        this.D = (HSImageView) q().findViewById(R.id.guide_anchor_info_right_icon);
        this.E = (TextView) q().findViewById(R.id.guide_anchor_info_right_tv);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        super.A(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r100, int r101) {
        A(r100, r101);
    }

    public h(MicSeatScene r100, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r101, xg0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "layoutConfig");
        Intrinsics.checkNotNullParameter(r102, "linkSeatAbilityProvider");
        super(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r110, int r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "itemData");
        Intrinsics.checkNotNullParameter(r210, WsConstants.KEY_PAYLOAD);
        super.B(r110, r111, r210);
        Iterator<String> r100 = r210.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L103;
        String r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.hashCode() != 281544963) goto L4;
        if (r101.equals("payload_key_audio_anchor_guest_info_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r102 = this.f75723e;
        if ((r102 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L16;
        r102 = null;
    L16:
        MultiLinkAudioFirstUserViewBinder.a r103 = (MultiLinkAudioFirstUserViewBinder.a) r102;
        if (r103 == null) goto L4;
        ch0.l r104 = r103.f75905s;
        if (r104 == null) goto L4;
        f6 r105 = r104.f23752b;
        if (r105 == null) goto L71;
        List<g6> r106 = r105.getInfoItems();
        if (r106 == null) goto L71;
        if (r106.size() < 3) goto L71;
        String r107 = "right = " + ((g6) ListProtector.get(r106, 0)).getContent() + ", left = " + ((g6) ListProtector.get(r106, 1)).getContent() + ", description = " + ((g6) ListProtector.get(r106, 2)).getContent();
        boolean r112 = gh0.b.f481244a;
        gh0.b.a("AudioAnchorGuide", "bindAnchorGuideInfo, content = " + r107, false);
        int r108 = 0;
    L29:
        if (r108 > 2) goto L71;
        g6 r113 = (g6) ListProtector.get(r106, r108);
        if (r108 == 0) goto L33;
        if (r108 != 1) goto L62;
        if (TextUtils.isEmpty(r113.getContent()) == false) goto L52;
        LinearLayout r114 = this.f75786z;
        if (r114 == null) goto L69;
        r114.setVisibility(4);
    L69:
        r108 = r108 + 1;
        goto L29
    L52:
        TextView r115 = this.B;
        if (r115 == null) goto L56;
        r115.setText(r113.getContent());
    L56:
        if (r113.getIconModel() != null) goto L60;
        HSImageView r116 = this.A;
        if (r116 == null) goto L69;
        r116.setVisibility(8);
        goto L69
    L60:
        int r117 = s1.f(14.0f);
        ImageUtil.loadImage(this.A, r113.getIconModel(), r117, r117, null);
        goto L69
    L62:
        if (TextUtils.isEmpty(r113.getContent()) == false) goto L66;
        TextView r118 = this.G;
        if (r118 == null) goto L69;
        r118.setVisibility(8);
        goto L69
    L66:
        TextView r119 = this.G;
        if (r119 == null) goto L69;
        r119.setText(r113.getContent());
        goto L69
    L33:
        if (TextUtils.isEmpty(r113.getContent()) == false) goto L37;
        LinearLayout r120 = this.C;
        if (r120 == null) goto L69;
        r120.setVisibility(4);
        goto L69
    L37:
        TextView r121 = this.E;
        if (r121 == null) goto L41;
        r121.setText(r113.getContent());
    L41:
        if (r113.getIconModel() != null) goto L45;
        HSImageView r122 = this.D;
        if (r122 == null) goto L69;
        r122.setVisibility(8);
        goto L69
    L45:
        int r123 = s1.f(14.0f);
        ImageUtil.loadImage(this.D, r113.getIconModel(), r123, r123, null);
    L71:
        if (GuestBattleContext.Companion.e() == true) goto L4;
        if (ThemedCompetitionContext.Companion.g() == true) goto L4;
        int r109 = s1.f(30.0f);
        MultiLinkMicSeatGiftIconElement r124 = this.f75731m;
        if (r124 == null) goto L78;
        LinkMicQuickInteractView r125 = r124.f75666c;
    L79:
        ObjectAnimator r126 = ObjectAnimator.ofFloat(r125, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator r127 = ObjectAnimator.ofFloat(this.G, View.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet r128 = new AnimatorSet();
        r128.setDuration(240);
        r128.playTogether(new Animator[]{r126, r127});
        r128.addListener(new b(this));
        float r129 = r109;
        ObjectAnimator r130 = ObjectAnimator.ofFloat(this.C, View.TRANSLATION_Y, new float[]{r129, 0.0f});
        r130.setDuration(800);
        r130.setInterpolator(PathInterpolatorCompat.create(0.03f, 0.2f, 0.16f, 0.99f));
        ObjectAnimator r131 = ObjectAnimator.ofFloat(this.C, View.ALPHA, new float[]{0.0f, 1.0f});
        r131.setDuration(400);
        AnimatorSet r132 = new AnimatorSet();
        r132.setStartDelay(240);
        r132.playTogether(new Animator[]{r131, r130});
        r132.addListener(new c(this));
        ObjectAnimator r133 = ObjectAnimator.ofFloat(this.f75786z, View.TRANSLATION_Y, new float[]{r129, 0.0f});
        r133.setInterpolator(PathInterpolatorCompat.create(0.14f, 1.0f, 0.34f, 1.0f));
        r133.setDuration(800);
        ObjectAnimator r134 = ObjectAnimator.ofFloat(this.f75786z, View.ALPHA, new float[]{0.0f, 1.0f});
        r134.setDuration(400);
        AnimatorSet r135 = new AnimatorSet();
        r135.setStartDelay(640);
        r135.playTogether(new Animator[]{r134, r133});
        r135.addListener(new d(this));
        ObjectAnimator r136 = ObjectAnimator.ofFloat(this.G, View.ALPHA, new float[]{1.0f, 0.0f});
        r136.setDuration(240);
        r136.setStartDelay(5480);
        r136.addListener(new e(this));
        float r137 = -r129;
        ObjectAnimator r138 = ObjectAnimator.ofFloat(this.C, View.TRANSLATION_Y, new float[]{0.0f, r137});
        r138.setDuration(800);
        r138.setInterpolator(PathInterpolatorCompat.create(0.84f, 0.02f, 0.75f, 0.99f));
        ObjectAnimator r139 = ObjectAnimator.ofFloat(this.C, View.ALPHA, new float[]{1.0f, 0.0f});
        r139.setDuration(320);
        AnimatorSet r140 = new AnimatorSet();
        r140.setStartDelay(5000);
        r140.playTogether(new Animator[]{r138, r139});
        r140.addListener(new f(this));
        ObjectAnimator r141 = ObjectAnimator.ofFloat(this.f75786z, View.TRANSLATION_Y, new float[]{0.0f, r137});
        r141.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.68f, 0.06f));
        r141.setDuration(760);
        ObjectAnimator r142 = ObjectAnimator.ofFloat(this.f75786z, View.ALPHA, new float[]{1.0f, 0.0f});
        r142.setDuration(320);
        AnimatorSet r143 = new AnimatorSet();
        r143.setStartDelay(5040);
        r143.playTogether(new Animator[]{r141, r142});
        r143.addListener(new g(this));
        this.H = new AnimatorSet();
        TextView r144 = this.G;
        if (r144 == null) goto L82;
        CharSequence r145 = r144.getText();
    L84:
        if (TextUtils.isEmpty(r145) == false) goto L88;
        AnimatorSet r146 = this.H;
        if (r146 == null) goto L91;
        r146.playTogether(new Animator[]{r132, r135, r143, r140, r136});
    L91:
        AnimatorSet r147 = this.H;
        if (r147 == null) goto L94;
        r147.start();
    L94:
        LottieAnimationView r148 = this.F;
        if (r148 == null) goto L97;
        r148.setVisibility(0);
    L97:
        LottieAnimationView r149 = this.F;
        if (r149 == null) goto L100;
        r149.setAnimation("radio_guide_oval.json");
    L100:
        LottieAnimationView r150 = this.F;
        if (r150 == null) goto L4;
        r150.playAnimation();
        goto L4
    L88:
        AnimatorSet r151 = this.H;
        if (r151 == null) goto L91;
        r151.playTogether(new Animator[]{r128, r132, r135, r143, r140, r136});
        goto L91
    L82:
        r145 = null;
        goto L84
    L78:
        r125 = null;
        goto L79
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r100, int r101, Bundle r102) {
        B(r100, r101, r102);
    }
}
