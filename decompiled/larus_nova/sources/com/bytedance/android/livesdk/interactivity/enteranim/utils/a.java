package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.enteranim.utils.a$a, reason: collision with other inner class name */
    public class C2174a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s72.c f136772a;

        public C2174a(s72.c r100) {
            this.f136772a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            s72.c r101 = this.f136772a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            s72.c r101 = this.f136772a;
            if (r101 == null) goto L6;
            r101.onAnimationStart(r100);
            return;
        }
    }

    public static Animator a(View r100, String r101, float... r102) {
        if (((Integer) InteractivityOpt.c(LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT)).intValue() <= 0) goto L7;
        return LiveDegradeFpsAnimator.ofFloat(r100, r101, r102);
    L7:
        return ObjectAnimator.ofFloat(r100, r101, r102);
    }

    public static Animator c(View r100, s72.c r101, boolean r102) {
        return b(r100, r101, -1, -1, -1, r102, false);
    }

    public static Animator b(View r110, s72.c r111, int r112, int r113, int r210, boolean r211, boolean r212) {
        View r100 = r110;
        if (r100 == null) goto L5;
        int r101 = (s1.y() * MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
        if (r112 <= 0) goto L13;
        int r102 = r112;
    L14:
        if (r113 <= 0) goto L16;
        int r103 = r113;
    L17:
        int r104 = -((s1.y() * MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        float r105 = r102;
        Animator r106 = a(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101, r105}).setDuration(600);
        float r107 = r103;
        Animator r108 = a(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r105, r107});
        if (r210 <= 0) goto L20;
        long r114 = r210;
    L21:
        Animator r109 = r108.setDuration(r114);
        Animator r115 = a(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r107, r104}).setDuration(400);
        r106.addListener(new C2174a(r111));
        r106.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.8f, 0.74f, 1.0f));
        r109.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        r115.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.6f, 0.2f));
        AnimatorSet r116 = new AnimatorSet();
        r116.playSequentially(new Animator[]{r106, r109, r115});
        if (r212 == true) goto L24;
    L26:
        r100.setAlpha(0.0f);
        Animator r117 = a(r100, "alpha", new float[]{0.0f, 1.0f}).setDuration(600);
        if (r211 == false) goto L29;
        r117.setStartDelay(400);
    L29:
        r117.setInterpolator(new LinearInterpolator());
        AnimatorSet r118 = new AnimatorSet();
        r118.playTogether(new Animator[]{r116, r117});
        r118.addListener(r111);
        return r118;
    L24:
        if (r110.getParent() == null) goto L26;
        r100 = (View) r110.getParent();
        goto L26
    L20:
        r114 = 1700;
        goto L21
    L16:
        r103 = (6 * s1.y()) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
        goto L17
    L13:
        r102 = (16 * s1.y()) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
        goto L14
    L5:
        if (((Integer) InteractivityOpt.c(LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT)).intValue() <= 0) goto L7;
        Animator r119 = LiveDegradeFpsAnimator.ofFloat(new float[]{0.0f, 1.0f});
    L8:
        r119.setDuration(100);
        r119.addListener(r111);
        return r119;
    L7:
        r119 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        goto L8
    }
}
