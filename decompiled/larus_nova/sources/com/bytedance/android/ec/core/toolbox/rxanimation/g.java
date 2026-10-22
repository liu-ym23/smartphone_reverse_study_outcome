package com.bytedance.android.ec.core.toolbox.rxanimation;

import android.animation.TimeInterpolator;
import android.widget.TextView;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f45483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f45484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TimeInterpolator f45485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Long f45486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f45487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f45488f;

    public g(TextView r100, long r101, TimeInterpolator r102, Long r103, String r104, boolean r105) {
        this.f45483a = r100;
        this.f45484b = r101;
        this.f45485c = r102;
        this.f45486d = r103;
        this.f45487e = r104;
        this.f45488f = r105;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        final String r100 = (String) r110;
        Intrinsics.checkNotNullParameter(r100, "defaultText");
        TextView r101 = this.f45483a;
        long r102 = 2;
        Long r103 = Long.valueOf(this.f45484b / r102);
        TimeInterpolator r104 = this.f45485c;
        Long r105 = this.f45486d;
        Intrinsics.checkNotNullParameter(r101, "$this$fadeOut");
        Completable r106 = RxViewAnimationExtensionKt.c(r101, 0.0f, r103, r104, r105, false).doOnComplete(new f(this));
        TextView r111 = this.f45483a;
        Long r112 = Long.valueOf(this.f45484b / r102);
        TimeInterpolator r113 = this.f45485c;
        Intrinsics.checkNotNullParameter(r111, "$this$fadeIn");
        return RxViewAnimationExtensionKt.h(r106.andThen(RxViewAnimationExtensionKt.c(r111, 1.0f, r112, r113, 300L, false)), this.f45488f, new RxViewAnimationExtensionKt$text$1$2(this, r100));
    }
}
