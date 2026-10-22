package com.bumptech.glide.load.resource.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.f.j;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f3858a;

    public b(Resources r3) {
        this.f3858a = (Resources) ZeusTransformUtils.preCheckCast(j.a(r3), Resources.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public v<BitmapDrawable> a(v<Bitmap> r2, i r3) {
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
        return u.a(this.f3858a, r4);
    }
}
