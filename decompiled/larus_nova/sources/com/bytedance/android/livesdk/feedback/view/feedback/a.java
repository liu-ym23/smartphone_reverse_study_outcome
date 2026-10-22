package com.bytedance.android.livesdk.feedback.view.feedback;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GlobalQuestionFeedback f124975a;

    public a(GlobalQuestionFeedback r100) {
        this.f124975a = r100;
    }

    public final void a() {
        GlobalQuestionFeedback r100 = this.f124975a;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        ViewGroup r102 = r100.f124873c;
        if (r102 == null) goto L9;
        float[] r110 = new float[2];
        r110[0] = r102.getTranslationY();
        float r111 = r102.getTranslationY();
        ViewGroup r112 = r100.f124873c;
        if (r112 == null) goto L7;
        float r113 = r100.e() - r112.getY();
    L8:
        r110[1] = r111 + r113;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_Y, r110);
        r103.setDuration(200);
        Unit r114 = Unit.INSTANCE;
        r101.add(r103);
        goto L9
    L7:
        r113 = 0.0f;
    L9:
        ViewGroup r104 = r100.f124871a;
        if (r104 != null) goto L12;
    L24:
        ViewGroup r105 = r100.f124872b;
        if (r105 != null) goto L27;
    L41:
        AnimatorSet r106 = new AnimatorSet();
        r106.addListener(new b(r100, r101));
        r106.playTogether(r101);
        r106.start();
        return;
    L27:
        if (r100.f124882l == null) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
        ViewGroup r115 = r105;
    L33:
        if (r115 == null) goto L41;
        float[] r108 = new float[2];
        r108[0] = r115.getTranslationY();
        float r109 = r115.getTranslationY();
        ViewGroup r116 = r100.f124872b;
        if (r116 == null) goto L39;
        float r117 = r116.getY();
        ViewGroup r118 = r100.f124871a;
        if (r118 == null) goto L39;
        float r119 = (((r100.e() * 3) + r118.getHeight()) + UtilityKotlinExtentionsKt.h(24)) - r117;
    L40:
        r108[1] = r109 + r119;
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r115, LiveDegradeFpsAnimator.TRANSLATION_Y, r108);
        r120.setDuration(200);
        Unit r121 = Unit.INSTANCE;
        r101.add(r120);
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r115, "alpha", new float[]{0.0f, 1.0f});
        r122.setInterpolator(new AccelerateInterpolator());
        r122.setDuration(200);
        r101.add(r122);
    L39:
        r119 = 0.0f;
        goto L40
    L32:
        r115 = null;
        goto L33
    L29:
        r107 = false;
        goto L30
    L12:
        if (r100.f124881k == null) goto L14;
        boolean r123 = true;
    L15:
        if (r123 == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L24;
        float[] r124 = new float[2];
        r124[0] = r104.getTranslationY();
        float r125 = r104.getTranslationY();
        ViewGroup r126 = r100.f124871a;
        if (r126 == null) goto L22;
        float r127 = ((r100.e() * 2) + UtilityKotlinExtentionsKt.h(24)) - r126.getY();
    L23:
        r124[1] = r125 + r127;
        ObjectAnimator r128 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_Y, r124);
        r128.setDuration(200);
        Unit r129 = Unit.INSTANCE;
        r101.add(r128);
        goto L24
    L22:
        r127 = 0.0f;
        goto L23
    L14:
        r123 = false;
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
