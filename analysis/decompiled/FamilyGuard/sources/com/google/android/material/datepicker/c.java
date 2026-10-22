package com.google.android.material.datepicker;

import a1.C0409b;
import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import q1.C0980b;
import q1.C0981c;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    final b f12667a;

    /* renamed from: b, reason: collision with root package name */
    final b f12668b;

    /* renamed from: c, reason: collision with root package name */
    final b f12669c;

    /* renamed from: d, reason: collision with root package name */
    final b f12670d;

    /* renamed from: e, reason: collision with root package name */
    final b f12671e;

    /* renamed from: f, reason: collision with root package name */
    final b f12672f;

    /* renamed from: g, reason: collision with root package name */
    final b f12673g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f12674h;

    c(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(C0980b.f(context, C0409b.f6730q, i.class.getCanonicalName()), C0418k.f7237x2);
        this.f12667a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6944B2, 0));
        this.f12673g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f7249z2, 0));
        this.f12668b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6938A2, 0));
        this.f12669c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6950C2, 0));
        ColorStateList colorStateListA = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f6956D2);
        this.f12670d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6968F2, 0));
        this.f12671e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6962E2, 0));
        this.f12672f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f6974G2, 0));
        Paint paint = new Paint();
        this.f12674h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
