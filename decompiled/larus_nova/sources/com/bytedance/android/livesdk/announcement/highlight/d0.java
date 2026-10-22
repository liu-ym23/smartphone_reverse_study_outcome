package com.bytedance.android.livesdk.announcement.highlight;

import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f103472a = 0;

    static {
    }

    public static void a(ImageView r210) {
        Intrinsics.checkNotNullParameter(r210, "imageView");
        AnimationSet r100 = new AnimationSet(true);
        r100.setInterpolator(new LinearInterpolator());
        r100.setFillAfter(false);
        RotateAnimation r101 = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        long r102 = 100;
        r101.setDuration(r102);
        r100.addAnimation(r101);
        RotateAnimation r103 = new RotateAnimation(10.0f, -20.0f, 1, 0.5f, 1, 0.5f);
        r103.setStartOffset(r102);
        r103.setDuration(r102);
        r100.addAnimation(r103);
        RotateAnimation r104 = new RotateAnimation(-20.0f, 20.0f, 1, 0.5f, 1, 0.5f);
        r104.setStartOffset(200);
        r104.setDuration(r102);
        r100.addAnimation(r104);
        RotateAnimation r105 = new RotateAnimation(20.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        r105.setStartOffset(300);
        r105.setDuration(r102);
        r100.addAnimation(r105);
        r210.startAnimation(r100);
    }
}
