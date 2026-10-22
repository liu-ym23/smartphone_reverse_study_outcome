package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f3856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3857b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat r1, int r2) {
        this.f3856a = r1;
        this.f3857b = r2;
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public v<byte[]> a(v<Bitmap> r4, i r5) {
        v r6 = (v) ZeusTransformUtils.wrapperContextForParams(r4, v.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();
        ((Bitmap) ZeusTransformUtils.preCheckCast(r6.d(), Bitmap.class, "com.obric.aiagent.plugin")).compress(this.f3856a, this.f3857b, r7);
        r6.f();
        return new com.bumptech.glide.load.resource.a.b(r7.toByteArray());
    }
}
