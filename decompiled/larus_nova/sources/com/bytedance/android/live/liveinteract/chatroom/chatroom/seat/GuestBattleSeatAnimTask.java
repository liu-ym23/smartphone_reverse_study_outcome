package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.view.animation.Animation;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class GuestBattleSeatAnimTask extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f72194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f72195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f72196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f72197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MicSeatSponsorView f72198f;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.d
    public final void b(final w r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof b) == false) goto L48;
        b r100 = (b) r110;
        if (r100.f72213a == false) goto L24;
        HSImageView r111 = this.f72197e;
        if (r111 == null) goto L11;
        Animation r112 = r111.getAnimation();
        if (r112 == null) goto L11;
        r112.cancel();
    L11:
        HSImageView r113 = this.f72197e;
        if (r113 == null) goto L14;
        r113.setVisibility(8);
    L14:
        MicSeatSponsorView r114 = this.f72198f;
        if (r114 == null) goto L17;
        r114.setVisibility(8);
    L17:
        ALogger.e("GuestBattleSeatAnimTask", "#GuestBattleDebug# [cancelGuestBattleSeatAnimation] last " + this.f72194b, new Throwable());
        b r115 = this.f72194b;
        if (r115 == null) goto L22;
        Function0<Unit> r116 = r115.f72221i;
        if (r116 == null) goto L22;
        r116.invoke();
    L22:
        this.f72194b = null;
        return;
    L24:
        e r101 = this.f72195c;
        if (r101 == null) goto L27;
        r101.a(r110);
    L27:
        Uri r102 = r100.f72218f;
        Function0<Unit> r103 = new GuestBattleSeatAnimTask$handle$2(this, r110);
        HSImageView r117 = this.f72197e;
        boolean r104 = true;
        if (r117 == null) goto L30;
        r117.setController(Fresco.newDraweeControllerBuilder().setUri(r102).setAutoPlayAnimations(true).setControllerListener(new c(this, r103)).build());
    L30:
        HSImageView r118 = this.f72197e;
        if (r118 == null) goto L33;
        r118.setVisibility(0);
    L33:
        ALogger.d("GuestBattleSeatAnimTask", "#GuestBattleDebug# [playGuestBattleSeatAnimation] " + this.f72194b);
        if (this.f72198f == null) goto L47;
        String r119 = r100.f72219g;
        if (r119 != null) goto L38;
    L41:
        if (r104 == true) goto L47;
        this.f72198f.setVisibility(0);
        MicSeatSponsorView r120 = this.f72198f;
        String r105 = r100.f72219g;
        if (r105 != null) goto L46;
        r105 = "";
    L46:
        r120.a(r105, r100.f72220h);
        AnimatorSet r121 = new AnimatorSet();
        ArrayList r106 = new ArrayList();
        ObjectAnimator r107 = ObjectAnimator.ofFloat(this.f72198f, "alpha", new float[]{0.0f, 1.0f});
        r107.setDuration(300);
        r106.add(r107);
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this.f72198f, "alpha", new float[]{1.0f, 1.0f});
        r108.setDuration(2400);
        r106.add(r108);
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f72198f, "alpha", new float[]{1.0f, 0.0f});
        r109.setDuration(300);
        com.bytedance.android.live.ktv.common.midi.v2.a.a(r109, new GuestBattleSeatAnimTask$handelSponsorAnim$1(this));
        r106.add(r109);
        r121.playSequentially(r106);
        r121.start();
        goto L47
    L38:
        if (r119.length() == 0) goto L41;
        r104 = false;
    L47:
        this.f72194b = r100;
        this.f72196d.a(SeatAnimTaskState.REVENUE_DRESS_ANIM);
        return;
    L48:
        d r122 = this.f72224a;
        if (r122 == null) goto L53;
        r122.b(r110);
        return;
    }

    public GuestBattleSeatAnimTask(f r100, HSImageView r101, MicSeatSponsorView r102) {
        Intrinsics.checkNotNullParameter(r100, "taskStateListener");
        this.f72196d = r100;
        this.f72197e = r101;
        this.f72198f = r102;
    }
}
