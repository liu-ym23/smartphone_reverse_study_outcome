package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f4945a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4946b;

    /* renamed from: c, reason: collision with root package name */
    public final a f4947c;

    /* renamed from: d, reason: collision with root package name */
    public final a f4948d;

    /* renamed from: e, reason: collision with root package name */
    public final a f4949e;

    /* renamed from: f, reason: collision with root package name */
    public final a f4950f;

    /* renamed from: g, reason: collision with root package name */
    public final a f4951g;
    public final Paint h;

    public b(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(w4.b.c(context, MaterialCalendar.class.getCanonicalName(), R.attr.materialCalendarStyle).data, k4.a.f9912q);
        this.f4945a = a.a(typedArrayObtainStyledAttributes.getResourceId(4, 0), context);
        this.f4951g = a.a(typedArrayObtainStyledAttributes.getResourceId(2, 0), context);
        this.f4946b = a.a(typedArrayObtainStyledAttributes.getResourceId(3, 0), context);
        this.f4947c = a.a(typedArrayObtainStyledAttributes.getResourceId(5, 0), context);
        ColorStateList colorStateListA = w4.c.a(context, typedArrayObtainStyledAttributes, 7);
        this.f4948d = a.a(typedArrayObtainStyledAttributes.getResourceId(9, 0), context);
        this.f4949e = a.a(typedArrayObtainStyledAttributes.getResourceId(8, 0), context);
        this.f4950f = a.a(typedArrayObtainStyledAttributes.getResourceId(10, 0), context);
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
