package com.bytedance.android.live.effect.soundeffect;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSoundAdapter f68123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveSoundAdapter.ViewHolder f68124b;

    public c(LiveSoundAdapter r100, LiveSoundAdapter.ViewHolder r101) {
        this.f68123a = r100;
        this.f68124b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() == 1) goto L6;
        return false;
    L6:
        if (this.f68124b.f68109j == true) goto L10;
        r100.performClick();
        return false;
    L10:
        if (this.f68123a.f68093b == null) goto L12;
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "disable PlayMode");
    L12:
        LiveSoundAdapter.ViewHolder r102 = this.f68124b;
        r102.f68103d.setVisibility(8);
        ViewParent r103 = r102.f68108i.getParent();
        if (r103 == null) goto L15;
        r103.requestDisallowInterceptTouchEvent(false);
    L15:
        r102.f68109j = false;
        return true;
    }
}
