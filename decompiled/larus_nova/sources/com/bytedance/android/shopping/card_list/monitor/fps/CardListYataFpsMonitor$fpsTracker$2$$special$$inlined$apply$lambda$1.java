package com.bytedance.android.shopping.card_list.monitor.fps;

import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardListYataFpsMonitor$fpsTracker$2 f171704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f171705b;

    public CardListYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(CardListYataFpsMonitor$fpsTracker$2 r100, String r101) {
        this.f171704a = r100;
        this.f171705b = r101;
    }

    @Override // et3.c.d
    public final void fpsCallBack(final double r100) {
        CardListRunCatchExtKt.a(this.f171704a.this$0.f171702c, "CardListYataFpsMonitor-asyncFpsEvent", new AnonymousClass1(this, r100));
    }
}
