package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141225a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.textmessage.utils.a$a, reason: collision with other inner class name */
    public static final class C2234a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2234a f141226a = null;

        static {
            f141226a = new C2234a();
        }

        public C2234a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }
    }

    static {
    }

    public static Animator a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        q4.f159129j.getClass();
        ValueAnimator r101 = q4.a.b(r100, "alpha", new float[]{0.0f, 1.0f});
        r101.setDuration(500);
        r101.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        r101.addUpdateListener(C2234a.f141226a);
        return r101;
    }

    public static Animator c(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "propertyName");
        q4.f159129j.getClass();
        ValueAnimator r102 = q4.a.b(r100, r101, new float[]{0.8f, 1.0f});
        r102.setDuration(500);
        r102.setInterpolator(PathInterpolatorCompat.create(0.22f, 1.0f, 0.36f, 1.0f));
        return r102;
    }

    public static Animator e(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        q4.f159129j.getClass();
        ValueAnimator r103 = q4.a.b(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101, r102});
        r103.setDuration(300);
        r103.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r103.addUpdateListener(c.f141228a);
        return r103;
    }

    public static Animator d(View r100, float r101, float r102, long r103, float r104, float r105, float r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        q4.f159129j.getClass();
        ValueAnimator r106 = q4.a.b(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101, r102});
        r106.setDuration(r103);
        r106.setInterpolator(PathInterpolatorCompat.create(r104, r105, r110, 1.0f));
        r106.addUpdateListener(b.f141227a);
        return r106;
    }

    public static Animator b(View r100, String r101, float r102, float r103, long r104, float r105, float r110, float r111, float r112) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "propertyName");
        q4.f159129j.getClass();
        ValueAnimator r106 = q4.a.b(r100, r101, new float[]{r102, r103});
        r106.setDuration(r104);
        r106.setInterpolator(PathInterpolatorCompat.create(r105, r110, r111, r112));
        return r106;
    }
}
