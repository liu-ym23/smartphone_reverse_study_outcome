package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.stepos.alphame.utils.Property;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class BitmapDescriptor {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f6261a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f6262b;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f6261a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i4, int i5) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, paint);
        return bitmapCreateBitmap;
    }

    public byte[] b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f6261a.getHeight() * this.f6261a.getWidth() * 4);
        this.f6261a.copyPixelsToBuffer(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public void clearCache() {
        Bundle bundle = this.f6262b;
        if (bundle != null) {
            bundle.clear();
            this.f6262b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f6261a;
    }

    public void recycle() {
        Bitmap bitmap = this.f6261a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f6261a.recycle();
        this.f6261a = null;
    }

    public Bundle a() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        if (this.f6261a != null) {
            if (this.f6262b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("image_width", this.f6261a.getWidth());
                bundle.putInt("image_height", this.f6261a.getHeight());
                byte[] bArrB = b();
                bundle.putByteArray("image_data", bArrB);
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e4) {
                    e4.printStackTrace();
                    messageDigest = null;
                }
                if (messageDigest != null) {
                    messageDigest.update(bArrB, 0, bArrB.length);
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder("");
                    for (byte b4 : bArrDigest) {
                        sb.append(Integer.toString((b4 & UByte.MAX_VALUE) + 256, 16).substring(1));
                    }
                    bundle.putString("image_hashcode", sb.toString());
                }
                this.f6262b = bundle;
            }
            return this.f6262b;
        }
        throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
    }
}
