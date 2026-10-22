package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmoothCornerView f2722a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2723b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SmoothCornerView smoothCornerView, Context context, Handler handler) {
        super(handler);
        this.f2722a = smoothCornerView;
        this.f2723b = context;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        float fA = u9.a.a(this.f2723b);
        SmoothCornerView smoothCornerView = this.f2722a;
        smoothCornerView.setRadiusRatio(fA);
        smoothCornerView.f2625f = true;
        smoothCornerView.invalidate();
    }
}
