package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class RxViewAnimationExtensionKt$widthToCompletable$1 implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f45468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f45470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Interpolator f45471d;

    public RxViewAnimationExtensionKt$widthToCompletable$1(View r100, int r101, Long r102, Interpolator r103) {
        this.f45468a = r100;
        this.f45469b = r101;
        this.f45470c = r102;
        this.f45471d = r103;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(final CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        float r101 = this.f45469b;
        Resources r102 = Resources.getSystem();
        RxViewAnimationExtensionKt.b(ValueAnimator.ofInt(new int[]{this.f45468a.getWidth(), (int) (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)}), this.f45470c, this.f45471d, new AnonymousClass1(r100), new AnonymousClass2(this));
    }
}
