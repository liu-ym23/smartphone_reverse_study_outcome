package com.bytedance.android.livesdk.slideuptip;

import com.bytedance.android.livesdk.widget.d1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSlideUpTipsGuideStrategy f158402a;

    public b(LiveSlideUpTipsGuideStrategy r100) {
        this.f158402a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d1 r101 = (d1) r100;
        if (r101 == null) goto L6;
        this.f158402a.f158380n = r101.f161687a;
        LiveSlideUpTipsGuideStrategy.b("onEvent LiveGuidePageViewStatusEvent isLiveGuideWidgetShown: " + this.f158402a.f158380n);
        return;
    }
}
