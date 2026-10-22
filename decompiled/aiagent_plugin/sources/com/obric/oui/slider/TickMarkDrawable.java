package com.obric.oui.slider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.obric.oui.common.util.g;
import d.h.b.o;

/* JADX INFO: compiled from: ThumbDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TickMarkDrawable extends BitmapDrawable {
    private final Resources res;

    public TickMarkDrawable(Resources r2, Bitmap r3) {
        o.e(r2, "res");
        o.e(r3, "bitmap");
        super(r2, r3);
        this.res = r2;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return g.a(this.res, 18);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return g.a(this.res, 14);
    }
}
