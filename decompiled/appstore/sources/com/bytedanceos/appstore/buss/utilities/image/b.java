package com.bytedanceos.appstore.buss.utilities.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8855b;

    public b() {
        this.f8854a = 0;
        this.f8855b = 0;
    }

    @Override // com.bytedanceos.appstore.buss.utilities.image.a
    public Bitmap b(Context r10, BitmapPool r11, Bitmap r12, int r13, int r14) {
        Bitmap r15 = TransformationUtils.circleCrop(r11, r12, r13, r14);
        a(r12, r15);
        Paint r16 = new Paint();
        r16.setColor(this.f8855b);
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeWidth(this.f8854a);
        r16.setAntiAlias(true);
        new Canvas(r15).drawCircle(r13 / 2.0f, r14 / 2.0f, (Math.max(r13, r14) / 2.0f) - (this.f8854a / 2.0f), r16);
        return r15;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof b) == false) goto L9;
        b r11 = (b) r10;
        if (r11.f8854a != this.f8854a) goto L9;
        if (r11.f8855b != this.f8855b) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return ((882652245 + (this.f8854a * 100)) + this.f8855b) + 10;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r10) {
        r10.update(("jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1" + this.f8854a + this.f8855b).getBytes(Key.CHARSET));
    }
}
