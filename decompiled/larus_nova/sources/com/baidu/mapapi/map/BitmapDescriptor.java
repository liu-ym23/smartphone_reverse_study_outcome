package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class BitmapDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bitmap f30786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f30787b;

    public Bundle a() {
        if (this.f30786a == null) goto L21;
        if (this.f30787b != null) goto L19;
        Bundle r100 = new Bundle();
        r100.putInt("image_width", this.f30786a.getWidth());
        r100.putInt("image_height", this.f30786a.getHeight());
        byte[] r101 = b();
        r100.putByteArray("image_data", r101);
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
    L11:
        if (r102 == null) goto L17;
        int r103 = 0;
        r102.update(r101, 0, r101.length);
        byte[] r104 = r102.digest();
        StringBuilder r105 = new StringBuilder("");
    L14:
        if (r103 >= r104.length) goto L16;
        r105.append(Integer.toString((r104[r103] & UByte.MAX_VALUE) + 256, 16).substring(1));
        r103 = r103 + 1;
        goto L14
    L16:
        r100.putString("image_hashcode", r105.toString());
    L17:
        this.f30787b = r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
    L19:
        return this.f30787b;
    L21:
        throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
    }

    public byte[] b() {
        ByteBuffer r100 = ByteBuffer.allocate((this.f30786a.getWidth() * this.f30786a.getHeight()) * 4);
        this.f30786a.copyPixelsToBuffer(r100);
        return r100.array();
    }

    public void clearCache() {
        Bundle r100 = this.f30787b;
        if (r100 == null) goto L6;
        r100.clear();
        this.f30787b = null;
        return;
    }

    public void recycle() {
        Bitmap r100 = this.f30786a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        this.f30786a.recycle();
        this.f30786a = null;
        return;
    }

    public Bitmap getBitmap() {
        return this.f30786a;
    }

    public BitmapDescriptor(Bitmap r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        this.f30786a = a(r100, r100.getWidth(), r100.getHeight());
        return;
    }

    private Bitmap a(Bitmap r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isRecycled() == true) goto L10;
        Bitmap r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        r105.setFilterBitmap(true);
        r104.drawBitmap(r100, 0.0f, 0.0f, r105);
        return r103;
    L10:
        return null;
    }
}
