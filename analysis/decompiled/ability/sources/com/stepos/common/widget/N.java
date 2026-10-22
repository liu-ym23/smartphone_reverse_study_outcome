package com.stepos.common.widget;

import a5.AbstractC0301a;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes3.dex */
public final class N extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmoothCornerView f3725a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(SmoothCornerView smoothCornerView, Context context, Handler handler) {
        super(handler);
        this.f3725a = smoothCornerView;
        this.b = context;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        float fA = AbstractC0301a.a(this.b);
        SmoothCornerView smoothCornerView = this.f3725a;
        smoothCornerView.setRadiusRatio(fA);
        smoothCornerView.b = true;
        smoothCornerView.invalidate();
    }
}
