package com.bytedance.android.live.profile.seeselftransition;

import android.animation.ValueAnimator;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f86171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f86172b;

    public i(b r100, b r101) {
        this.f86171a = r100;
        this.f86172b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        long r101 = r100.getCurrentPlayTime();
        Object r102 = null;
        if (0 > r101) goto L14;
        if (200 < r101) goto L14;
        Object r103 = r100.getAnimatedValue("beforeIconScale");
        if ((r103 instanceof Float) == true) goto L10;
        r103 = null;
    L10:
        Float r104 = (Float) r103;
        if (r104 == null) goto L14;
        this.f86171a.setDressIconScale(r104.floatValue());
    L14:
        if (200 <= r101) goto L17;
    L24:
        if (200 <= r101) goto L27;
        return;
    L27:
        if (AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME < r101) goto L36;
        Object r105 = r100.getAnimatedValue("dialogMark");
        if ((r105 instanceof Float) == false) goto L32;
        r102 = r105;
    L32:
        Float r106 = (Float) r102;
        if (r106 == null) goto L37;
        float r107 = r106.floatValue();
        this.f86171a.es(r107);
        this.f86172b.es(r107 + 220.0f);
        return;
    L37:
        return;
    L36:
        return;
    L17:
        if (900 < r101) goto L24;
        Object r108 = r100.getAnimatedValue("currentIconScale");
        if ((r108 instanceof Float) == true) goto L21;
        r108 = null;
    L21:
        Float r109 = (Float) r108;
        if (r109 == null) goto L24;
        this.f86172b.setDressIconScale(r109.floatValue());
        goto L24
    }
}
