package com.obric.autogui.operator.a.b.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: ImageProcessorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {
    private static final String TAG = "AndroidNativeProcessor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0761a f29535a = null;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageProcessorFactory.kt */
    public static final class C0761a {
        public /* synthetic */ C0761a(h r1) {
            this();
        }

        private C0761a() {
        }
    }

    static {
        f29535a = new C0761a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.operator.a.b.b.b
    public Bitmap a(Bitmap r5) {
        o.e(r5, "bitmap");
        Bitmap r1 = c(r5);     // Catch: Exception -> L15
        float r2 = b(r1);     // Catch: Exception -> L15
        if (r2 >= 0.3f) goto L7;
        float r3 = 1.3f;
    L10:
        Bitmap r4 = a(r1, r3);     // Catch: Exception -> L15
        if (o.a(r1, r5) == true) goto L13;
        r1.recycle();     // Catch: Exception -> L15
    L13:
        ILogDepend.Companion.d(TAG, "自适应图像处理完成");     // Catch: Exception -> L15
        return r4;
    L7:
        if (r2 >= 0.6f) goto L9;
        r3 = 1.2f;
        goto L10
    L9:
        r3 = 1.1f;
    L15:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "自适应图像处理失败: " + e.getMessage());
        Bitmap.Config r6 = r5.getConfig();
        if (r6 != null) goto L19;
        r6 = Bitmap.Config.ARGB_8888;
    L19:
        Bitmap r7 = r5.copy(r6, false);
        o.c(r7, "copy(...)");
        return r7;
    }

    public float b(Bitmap r20) {
        String r1 = "com.obric.aiagent.plugin";
        o.e(r20, "bitmap");
        Bitmap r3 = c(r20);     // Catch: Exception -> L29
        int r4 = r3.getWidth();     // Catch: Exception -> L29
        long r6 = 0;
        int r8 = 4;
        int r9 = 0;
        d.l.h r5 = n.a((d.l.h) ZeusTransformUtils.preCheckCast(n.b(0, r3.getHeight()), d.l.h.class, "com.obric.aiagent.plugin"), 4);     // Catch: Exception -> L29
        int r10 = r5.a();     // Catch: Exception -> L29
        int r11 = r5.b();     // Catch: Exception -> L29
        int r7 = r5.c();     // Catch: Exception -> L29
        if (r7 <= 0) goto L6;
        if (r10 > r11) goto L6;
    L8:
        int r12 = 0;
    L9:
        d.l.h r13 = n.a((d.l.h) ZeusTransformUtils.preCheckCast(n.b(r9, r4), d.l.h.class, r1), r8);     // Catch: Exception -> L29
        int r14 = r13.a();     // Catch: Exception -> L29
        int r15 = r13.b();     // Catch: Exception -> L29
        int r16 = r13.c();     // Catch: Exception -> L29
        if (r16 <= 0) goto L12;
        if (r14 > r15) goto L12;
    L14:
        int r17 = r3.getPixel(r14, r10);     // Catch: Exception -> L29
        int r18 = Color.red(r17);     // Catch: Exception -> L29
        int r19 = Color.green(r17);     // Catch: Exception -> L29
        int r2 = Color.blue(r17);     // Catch: Exception -> L29
        String r110 = r1;
        Bitmap r111 = r3;
        r6 = r6 + ((long) ((int) (((((double) r18) * 0.299d) + (((double) r19) * 0.587d)) + (((double) r2) * 0.114d))));     // Catch: Exception -> L29
        r12 = r12 + 1;     // Catch: Exception -> L29
        if (r14 == r15) goto L18;
        r14 = r14 + r16;     // Catch: Exception -> L29
        r1 = r110;
        r3 = r111;
    L18:
        if (r10 == r11) goto L20;
        r10 = r10 + r7;     // Catch: Exception -> L29
        r1 = r110;
        r3 = r111;
        r8 = 4;
        r9 = 0;
        goto L9
    L20:
        int r21 = r12;
    L22:
        if (r21 <= 0) goto L24;
        float r0 = (r6 / r21) / 255.0f;     // Catch: Exception -> L29
    L26:
        if (o.a(r111, r20) == true) goto L28;
        r111.recycle();     // Catch: Exception -> L29
    L28:
        return r0;
    L24:
        r0 = 0.5f;
    L12:
        if (r16 >= 0) goto L17;
        if (r15 <= r14) goto L14;
    L17:
        r110 = r1;
        r111 = r3;
    L6:
        if (r7 >= 0) goto L21;
        if (r11 <= r10) goto L8;
    L21:
        r111 = r3;
        r21 = 0;
    L29:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "亮度计算失败: " + e.getMessage());
        return 0.5f;
    }

    private final Bitmap c(Bitmap r2) {
        if (r2.getConfig() != Bitmap.Config.HARDWARE) goto L6;
        Bitmap r3 = r2.copy(Bitmap.Config.ARGB_8888, false);
        o.a(r3);
        return r3;
    L6:
        return r2;
    }

    private final Bitmap a(Bitmap r11, float r12) {
        Bitmap r10 = Bitmap.createBitmap(r11.getWidth(), r11.getHeight(), Bitmap.Config.ARGB_8888);
        o.c(r10, "createBitmap(...)");
        Canvas r0 = new Canvas(r10);
        Paint r1 = new Paint();
        ColorMatrix r2 = new ColorMatrix();
        r2.setSaturation(0.0f);
        float r5 = ((1.0f - r12) * 128.0f) * 0.3f;
        ColorMatrix r6 = new ColorMatrix();
        r6.set(new float[]{r12, 0.0f, 0.0f, 0.0f, r5, 0.0f, r12, 0.0f, 0.0f, r5, 0.0f, 0.0f, r12, 0.0f, r5, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        ColorMatrix r13 = new ColorMatrix();
        r13.postConcat(r2);
        r13.postConcat(r6);
        r1.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new ColorMatrixColorFilter(r13), ColorFilter.class, "com.obric.aiagent.plugin"));
        r1.setAntiAlias(true);
        r0.drawBitmap(r11, 0.0f, 0.0f, r1);
        return r10;
    }
}
