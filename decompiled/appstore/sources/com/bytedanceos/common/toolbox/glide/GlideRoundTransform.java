package com.bytedanceos.common.toolbox.glide;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class GlideRoundTransform extends BitmapTransformation {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f10058c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10060b;

    static {
        f10058c = "com.bytedanceos.common.toolbox.glide.GlideRoundTransform".getBytes(Charset.forName("UTF-8"));
    }

    public GlideRoundTransform() {
        this.f10059a = 21;
        this.f10060b = 15;
    }

    public final void a(Canvas r10, Paint r11, int r12, int r13) {
        Path r14 = new Path();
        r14.moveTo(0.0f, r13 - r12);
        float r15 = r13;
        r14.lineTo(0.0f, r15);
        r14.lineTo(r12, r15);
        int r16 = r12 * 2;
        r14.arcTo(new RectF(0.0f, r13 - r16, r16, r15), 90.0f, 90.0f);
        r14.close();
        r10.drawPath(r14, r11);
    }

    public final void b(Canvas r10, Paint r11, int r12) {
        Path r13 = new Path();
        float r14 = r12;
        r13.moveTo(0.0f, r14);
        r13.lineTo(0.0f, 0.0f);
        r13.lineTo(r14, 0.0f);
        float r15 = r12 * 2;
        r13.arcTo(new RectF(0.0f, 0.0f, r15, r15), 270.0f, -90.0f);
        r13.close();
        r10.drawPath(r13, r11);
    }

    public final void c(Canvas r10, Paint r11, int r12, int r13, int r14) {
        Path r15 = new Path();
        float r16 = r14;
        r15.moveTo(r13 - r12, r16);
        float r17 = r13;
        r15.lineTo(r17, r16);
        r15.lineTo(r17, r14 - r12);
        int r18 = r12 * 2;
        r15.arcTo(new RectF(r13 - r18, r14 - r18, r17, r16), 0.0f, 90.0f);
        r15.close();
        r10.drawPath(r15, r11);
    }

    public final void d(Canvas r10, Paint r11, int r12, int r13, int r14) {
        Path r15 = new Path();
        float r16 = r12;
        r15.moveTo(r16, r13);
        r15.lineTo(r16, 0.0f);
        r15.lineTo(r12 - r13, 0.0f);
        int r17 = r13 * 2;
        r15.arcTo(new RectF(r12 - r17, 0.0f, r16, r17), 270.0f, 90.0f);
        r15.close();
        r10.drawPath(r15, r11);
    }

    public GlideRoundTransform e(int r10) {
        this.f10059a = r10;
        return this;
    }

    public GlideRoundTransform f(int r10) {
        this.f10060b = r10;
        return this;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r10, Bitmap r11, int r12, int r13) {
        int r14 = r11.getWidth();
        int r15 = r11.getHeight();
        Bitmap.Config r16 = Bitmap.Config.ARGB_8888;
        Bitmap r17 = r10.get(r14, r15, r16);
        if (r17 != null) goto L5;
        r17 = Bitmap.createBitmap(r11.getWidth(), r11.getHeight(), r16);
    L5:
        Canvas r18 = new Canvas(r17);
        Paint r19 = new Paint();
        r19.setAntiAlias(true);
        Shader.TileMode r20 = Shader.TileMode.CLAMP;
        r19.setShader(new BitmapShader(r11, r20, r20));
        if (this.f10060b != 15) goto L8;
        float r110 = (r11.getWidth() * 0.02f) / 2.0f;
        float r21 = (r11.getHeight() * 0.02f) / 2.0f;
        RectF r22 = new RectF(r110, r21, r11.getWidth() - r110, r11.getHeight() - r21);
        int r23 = this.f10059a;
        r18.drawRoundRect(r22, r23, r23, r19);
        Paint r24 = new Paint();
        r24.setStyle(Paint.Style.STROKE);
        r24.setColor(BaseApplication.c().getResources().getColor(R$color.icon_bitmap_stroke_color));
        r24.setStrokeWidth(BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.icon_bitmap_stroke));
        RectF r25 = new RectF(r110, r21, r11.getWidth() - r110, r11.getHeight() - r21);
        int r26 = this.f10059a;
        r18.drawRoundRect(r25, r26, r26, r24);
    L20:
        return r17;
    L8:
        r18.drawRect(new Rect(0, 0, r11.getWidth(), r11.getHeight()), r19);
        int r111 = (int) (this.f10059a * ((r11.getWidth() * 1.0f) / r12));
        Paint r27 = new Paint();
        r27.setAntiAlias(true);
        r27.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if ((this.f10060b & 1) != 1) goto L12;
        b(r18, r27, r111);
    L12:
        if ((this.f10060b & 4) != 4) goto L15;
        a(r18, r27, r111, r11.getHeight());
    L15:
        if ((this.f10060b & 2) != 2) goto L18;
        d(r18, r27, r111, r11.getWidth(), r11.getHeight());
    L18:
        if ((this.f10060b & 8) != 8) goto L20;
        c(r18, r27, r111, r11.getWidth(), r11.getHeight());
        goto L20
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r10) {
        r10.update(f10058c);
        r10.update(ByteBuffer.allocate(8).putInt(this.f10059a).putInt(this.f10060b).array());
    }
}
