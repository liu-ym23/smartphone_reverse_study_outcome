package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.livesdk.livecommerce.utils.p0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends p0<ge.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f151833a;

    public e(Function0 r100) {
        this.f151833a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        Intrinsics.checkNotNullParameter((ge.a) r100, "iUser");
        this.f151833a.invoke();
    }
}
