package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends e<Drawable> {
    @Override // com.bumptech.glide.request.target.e
    public /* synthetic */ void a(Drawable r3) {
        d((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"));
    }

    public d(ImageView r1) {
        super(r1);
    }

    public void d(Drawable r3) {
        ((ImageView) ZeusTransformUtils.preCheckCast(this.f3957a, ImageView.class, "com.obric.aiagent.plugin")).setImageDrawable(r3);
    }
}
