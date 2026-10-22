package com.bytedance.android.livesdk.focus;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f125319o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f125320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f125321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f125322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f125323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f125324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f125325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f125326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f125327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f125328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f125329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f125330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f125331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ExposureSeekBarView f125332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f125333n;

    public interface a {
        ExposureCompensationInfo getCameraECInfo();

        void setExposure(int r100);
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.focus.b$b, reason: collision with other inner class name */
    public static final class C2007b {
    }

    static {
    }

    public static final AnimatorSet a(b r100, View r101, Function0 r110) {
        r100.getClass();
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{1.0f, 1.0f});
        r102.setDuration(500);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{1.0f, 0.5f});
        r103.setDuration(1000);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{0.5f, 0.5f});
        r104.setDuration(500);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{0.5f, 0.0f});
        r105.setDuration(500);
        r105.addListener(new FocusAndExposureManager$getAlphaDisappearAnimation$1(r100, r101, r110));
        AnimatorSet r106 = new AnimatorSet();
        r106.playSequentially(new Animator[]{r102, r103, r104, r105});
        return r106;
    }

    public b(ViewGroup r100, ImageView r101, ExposureSeekBarView r102, LiveFocusWidget.c r103) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "focusIcon");
        Intrinsics.checkNotNullParameter(r102, "exposureSeekBar");
        Intrinsics.checkNotNullParameter(r103, "cameraListener");
        this.f125330k = r100;
        this.f125331l = r101;
        this.f125332m = r102;
        this.f125333n = r103;
        this.f125327h = LazyKt.lazy(new FocusAndExposureManager$defaultAnimationSet$2(this));
        this.f125328i = LazyKt.lazy(new FocusAndExposureManager$focusIconAlphaDisappearAnimationSet$2(this));
        this.f125329j = LazyKt.lazy(new FocusAndExposureManager$exposureSeekBarAlphaDisappearAnimationSet$2(this));
    }
}
