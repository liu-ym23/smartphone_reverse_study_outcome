package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class RxViewAnimationExtensionKt$backgroundColorToCompletable$1 implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f45368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f45370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f45371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Interpolator f45372e;

    public RxViewAnimationExtensionKt$backgroundColorToCompletable$1(View r100, int r101, int r102, Long r103, Interpolator r104) {
        this.f45368a = r100;
        this.f45369b = r101;
        this.f45370c = r102;
        this.f45371d = r103;
        this.f45372e = r104;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(final CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        RxViewAnimationExtensionKt.b(ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(this.f45369b), Integer.valueOf(this.f45370c)}), this.f45371d, this.f45372e, new AnonymousClass1(r100), new AnonymousClass2(this));
    }
}
