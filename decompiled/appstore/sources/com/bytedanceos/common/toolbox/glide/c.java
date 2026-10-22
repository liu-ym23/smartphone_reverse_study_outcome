package com.bytedanceos.common.toolbox.glide;

import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Matrix;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class c extends BitmapTransformation {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f10061c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f10062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f10063b;

    static {
        f10061c = "com.bytedanceos.common.toolbox.glide.RotateTransformation".getBytes(Charset.forName("UTF-8"));
    }

    public c() {
        this.f10062a = 0.0f;
        this.f10063b = new Matrix();
    }

    public void a(float r10) {
        this.f10062a = r10;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r10, Bitmap r11, int r12, int r13) {
        this.f10063b.reset();
        Camera r14 = new Camera();
        r14.translate(r14.getLocationX(), r14.getLocationY() + r11.getHeight(), r14.getLocationZ());
        r14.save();
        r14.rotateY(this.f10062a);
        r14.getMatrix(this.f10063b);
        r14.restore();
        return Bitmap.createBitmap(r11, 0, 0, r11.getWidth(), r11.getHeight(), this.f10063b, true);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r10) {
        r10.update(f10061c);
        r10.update(ByteBuffer.allocate(8).putInt(this.f10063b.hashCode()).putFloat(this.f10062a).array());
    }
}
