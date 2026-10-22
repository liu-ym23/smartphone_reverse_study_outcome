package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmoothCornerView f7206a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7207b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(SmoothCornerView smoothCornerView, Context context, Handler handler) {
        super(handler);
        this.f7206a = smoothCornerView;
        this.f7207b = context;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        float fA = l8.a.a(this.f7207b);
        SmoothCornerView smoothCornerView = this.f7206a;
        smoothCornerView.setRadiusRatio(fA);
        smoothCornerView.f7037b = true;
        smoothCornerView.invalidate();
    }
}
