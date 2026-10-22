package b02;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboProgressAnimationView f16835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16837c;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ComboProgressAnimationView r101 = this.f16835a;
        boolean r102 = r101.f128648j;
        if (r102 == true) goto L5;
    L7:
        if (r102 == true) goto L10;
        r101.f128644f = false;
    L10:
        if (this.f16836b == false) goto L13;
        this.f16835a.f128645g = false;
        return;
    L13:
        return;
    L5:
        if (this.f16837c == false) goto L7;
        ComboProgressAnimationView.b(r101, true);
        goto L10
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100, r101);
        ComboProgressAnimationView r102 = this.f16835a;
        r102.f128644f = true;
        if (this.f16836b == false) goto L6;
        r102.f128645g = true;
        return;
    }

    public i(ComboProgressAnimationView r100, boolean r101, boolean r102) {
        this.f16835a = r100;
        this.f16836b = r101;
        this.f16837c = r102;
    }
}
