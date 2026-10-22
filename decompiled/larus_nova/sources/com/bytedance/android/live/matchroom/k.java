package com.bytedance.android.live.matchroom;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f82895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f82896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f82897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f82898d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f82895a = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f82895a == true) goto L8;
        boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
        if (MatchRoomLandScapeAnimUtil.f82834c != 0) goto L9;
        this.f82896b.setClipToOutline(false);
        ALogger.i("MatchRoomAnimUtil", "hide end clipToOutline[false] onAnimationEnd for " + ((String) this.f82897c.getKey()));
        return;
    L9:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f82896b.setClipToOutline(true);
    }

    public k(View r100, Map.Entry r101, List r102) {
        this.f82896b = r100;
        this.f82897c = r101;
        this.f82898d = r102;
    }
}
