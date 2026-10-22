package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BitmapImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends e<Bitmap> {
    @Override // com.bumptech.glide.request.target.e
    public /* synthetic */ void a(Bitmap r3) {
        a2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.aiagent.plugin"));
    }

    public b(ImageView r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Bitmap r3) {
        ((ImageView) ZeusTransformUtils.preCheckCast(this.f3957a, ImageView.class, "com.obric.aiagent.plugin")).setImageBitmap(r3);
    }
}
