package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a extends v0.a {

    /* renamed from: a, reason: collision with root package name */
    public final b.a f5381a;

    public a(Context context, int i10) {
        this.f5381a = new b.a(16, context.getString(i10));
    }

    @Override // v0.a
    public void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.b(this.f5381a);
    }
}
