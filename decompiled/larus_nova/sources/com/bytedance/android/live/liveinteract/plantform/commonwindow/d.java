package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.animation.ValueAnimator;
import android.view.View;
import java.security.SecureRandom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f75634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f75635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f75636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f75637d;

    public d(float r100, View r101, float r102, float r103) {
        this.f75634a = r100;
        this.f75635b = r101;
        this.f75636c = r102;
        this.f75637d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        float r101 = new SecureRandom().nextFloat() * this.f75634a;
        float r102 = new SecureRandom().nextFloat() * this.f75634a;
        this.f75635b.setX(this.f75636c + r101);
        this.f75635b.setY(this.f75637d + r102);
    }
}
