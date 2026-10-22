package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.C1661b;
import w2.C5721e;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f19731a;

    public abstract void a(Drawable drawable, boolean z10, boolean z11, boolean z12);

    public final void b(Context context, C5721e c5721e, boolean z10) {
        int i10 = this.f19731a;
        a(i10 != 0 ? context.getResources().getDrawable(i10) : null, z10, false, false);
    }

    public final void c(Context context, Bitmap bitmap, boolean z10) {
        C1661b.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
