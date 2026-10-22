package com.stepos.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import m2.AbstractC0770a;

/* loaded from: classes.dex */
public final class J extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmoothCornerView f11661a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11662b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(SmoothCornerView smoothCornerView, Context context, Handler handler) {
        super(handler);
        this.f11661a = smoothCornerView;
        this.f11662b = context;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        float fA = AbstractC0770a.a(this.f11662b);
        SmoothCornerView smoothCornerView = this.f11661a;
        smoothCornerView.setRadiusRatio(fA);
        smoothCornerView.f11784b = true;
        smoothCornerView.invalidate();
    }
}
