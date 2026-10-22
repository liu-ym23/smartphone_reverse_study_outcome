package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f131107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UgcGiftSelectView f131108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public py.k f131109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f131110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f131111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f131112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewStub f131113g;

    public static final class a {
    }

    static {
    }

    public final void d() {
        if (this.f131107a == false) goto L16;
        final UgcGiftSelectView r100 = this.f131108b;
        if (r100 == null) goto L17;
        View r101 = r100.f131075j;
        if (r101 == null) goto L18;
        r101.setVisibility(0);
        HSImageView r102 = r100.f131068c;
        if (r102 == null) goto L11;
        r102.setAlpha(0.6f);
    L11:
        Animator r103 = r100.f131067b;
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r103);
    L14:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, "rotation", new float[]{0.0f, 360.0f});
        r104.setRepeatCount(-1);
        r104.setDuration(1000);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.c(r104, new UgcGiftSelectView$startLoadingAnimation$$inlined$let$lambda$1(r100));
        Unit r105 = Unit.INSTANCE;
        r100.f131067b = r104;
        r104.start();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void e() {
        if (this.f131107a == false) goto L28;
        UgcGiftSelectView r100 = this.f131108b;
        if (r100 == null) goto L29;
        Pair<Float, Animator> r101 = r100.f131066a;
        if (r101 != null) goto L9;
    L14:
        Pair<Float, Animator> r102 = new Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r100, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.06f, 1.0f}), PropertyValuesHolder.ofFloat(LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.06f, 1.0f})}));
        r100.f131066a = r102;
        Animator r103 = (Animator) r102.second;
        if (r103 == null) goto L17;
        r103.setDuration(200);
    L17:
        Interpolator r104 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        Pair<Float, Animator> r105 = r100.f131066a;
        if (r105 == null) goto L22;
        Animator r106 = (Animator) r105.second;
        if (r106 == null) goto L22;
        r106.setInterpolator(r104);
    L22:
        Pair<Float, Animator> r107 = r100.f131066a;
        if (r107 == null) goto L30;
        Animator r108 = (Animator) r107.second;
        if (r108 == null) goto L31;
        r108.start();
        return;
    L31:
        return;
    L30:
        return;
    L9:
        if (((Animator) r101.second) == null) goto L14;
        Object r109 = r101.first;
        if (((Float) r109) == null) goto L14;
        if ((!Intrinsics.areEqual((Float) r109, 1.06f)) == false) goto L22;
    L29:
        return;
    }

    public final void f() {
        if (this.f131107a == false) goto L13;
        UgcGiftSelectView r100 = this.f131108b;
        if (r100 == null) goto L14;
        Animator r101 = r100.f131067b;
        if (r101 == null) goto L9;
        r101.end();
    L9:
        Animator r102 = r100.f131067b;
        if (r102 == null) goto L15;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r102);
        return;
    L15:
        return;
    L14:
        return;
    }

    public t(ViewStub r100) {
        this.f131113g = r100;
        this.f131110d = "";
        this.f131111e = "";
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (this.f131107a == false) goto L7;
        UgcGiftSelectView r101 = this.f131108b;
        if (r101 == null) goto L7;
        r101.a(r100);
    L7:
        this.f131112f = r100;
    }

    public final void c(int r100) {
        if (this.f131107a == false) goto L7;
        UgcGiftSelectView r101 = this.f131108b;
        if (r101 == null) goto L19;
        r101.setVisibility(r100);
        return;
    L19:
        return;
    L7:
        if (r100 != 0) goto L21;
        ViewStub r102 = this.f131113g;
        if (r102 == null) goto L11;
        View r103 = r102.inflate();
    L13:
        if ((r103 instanceof UgcGiftSelectView) == false) goto L15;
        this.f131108b = (UgcGiftSelectView) r103;
    L15:
        this.f131107a = true;
        UgcGiftSelectView r104 = this.f131108b;
        if (r104 == null) goto L22;
        r104.b(this.f131109c, this.f131110d, this.f131111e, this.f131112f);
        return;
    L22:
        return;
    L11:
        r103 = null;
        goto L13
    }

    public final void b(py.k r100, String r101, String r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "giftName");
        Intrinsics.checkNotNullParameter(r102, DyVerifyReqConstants.Value.DIAMOND);
        Intrinsics.checkNotNullParameter(r103, "config");
        if (this.f131107a == false) goto L7;
        UgcGiftSelectView r104 = this.f131108b;
        if (r104 == null) goto L7;
        r104.b(r100, r101, r102, r103);
    L7:
        this.f131109c = r100;
        this.f131111e = r102;
        this.f131110d = r101;
        this.f131112f = r103;
    }
}
