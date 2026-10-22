package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.view.ViewGroup;
import cc2.n;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements n<cc2.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinWidget f138863a;

    public k(PinWidget r100) {
        this.f138863a = r100;
    }

    @Override // cc2.n
    public final void a(cc2.k r100, Boolean r101) {
        ViewGroup r102 = this.f138863a.containerView;
        if (r102 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r102);
        return;
    }

    @Override // cc2.n
    public final void b(cc2.k r100, Boolean r101) {
        ViewGroup r102 = this.f138863a.containerView;
        if (r102 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r102);
        return;
    }
}
