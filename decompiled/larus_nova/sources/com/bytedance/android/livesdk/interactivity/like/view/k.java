package com.bytedance.android.livesdk.interactivity.like.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements n81.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiggCountFlipperLayout f137946b;

    @Override // n81.b
    public final void onShow() {
        DiggCountFlipperLayout r100 = this.f137946b;
        Function1<? super String, Unit> r101 = r100.f137834w;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(r100.f137820i);
        return;
    }

    public k(DiggCountFlipperLayout r100) {
        this.f137946b = r100;
    }
}
