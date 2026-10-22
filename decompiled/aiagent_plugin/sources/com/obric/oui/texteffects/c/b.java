package com.obric.oui.texteffects.c;

import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: CanvasTextLayerRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuffXfermode f36441b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f36442c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Paint f36443d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Matrix f36444e = null;
    private static final LinearGradient f = null;
    private static final LinearGradient g = null;

    private b() {
    }

    static {
        f36440a = new b();
        PorterDuffXfermode r0 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        f36441b = r0;
        f36442c = new Paint();
        Paint r1 = new Paint();
        r1.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(r0, Xfermode.class, "com.obric.aiagent.plugin"));
        f36443d = r1;
        f36444e = new Matrix();
        f = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, -1, 16777215, Shader.TileMode.CLAMP);
        g = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, 16777215, -1, Shader.TileMode.CLAMP);
    }

    public final Paint a(Paint r4) {
        o.e(r4, "sourcePaint");
        Paint r3 = f36442c;
        r3.reset();
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r4.getBlendMode() == null) goto L8;
        r3.setBlendMode(r4.getBlendMode());
    L11:
        if (r1 == true) goto L15;
        return null;
    L15:
        return r3;
    L8:
        if (r4.getXfermode() == null) goto L10;
        r3.setXfermode(r4.getXfermode());
        goto L11
    L10:
        r1 = false;
        goto L11
    }

    public final void a(Canvas r17, float r18, float r19, Paint r20, Paint r21, c r22, float r23, float r24, float r25, float r26, float r27, float r28, d.h.a.b<? super Float, ? extends BlurMaskFilter> r29, BlendMode r30, Xfermode r31) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r29, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r17, "canvas");
        o.e(r21, "paint");
        o.e(r22, "cache");
        o.e(r13, "blurMaskFilterProvider");
        if (r26 > r25) goto L5;
        return;
    L5:
        int r15 = r17.saveLayer(r18, 0.0f, r19, r27, r20);
    L19:
        th = th;
        int r12 = 29;
    L21:
        r17.restoreToCount(r15);
        if (Build.VERSION.SDK_INT < r12) goto L24;
        r21.setBlendMode(r30);
    L24:
        r21.setXfermode(r31);
        throw th;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r21.setBlendMode(null);     // Catch: Throwable -> L19
    L9:
        r21.setXfermode(null);     // Catch: Throwable -> L19
        r21.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(r13.invoke(Float.valueOf(r28)), MaskFilter.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r17.clipRect(r25, 0.0f, r26, r27);     // Catch: Throwable -> L19
        r12 = 29;
        r17.drawText(r22.b(), 0, r22.b().length, r23, r24, r21);     // Catch: Throwable -> L17
        r17.restoreToCount(r15);
        if (Build.VERSION.SDK_INT < 29) goto L15;
        r21.setBlendMode(r30);
    L15:
        r21.setXfermode(r31);
        return;
    L17:
        th = th;
        goto L21
    }

    public final void a(Canvas r16, float r17, float r18, Paint r19, Paint r20, c r21, float r22, float r23, float r24, float r25, float r26, boolean r27, BlendMode r28, Xfermode r29) {
        o.e(r16, "canvas");
        o.e(r20, "paint");
        o.e(r21, "cache");
        int r12 = r16.saveLayer(r17, 0.0f, r18, r26, r19);
    L16:
        th = move-exception;
        f36443d.setShader(null);
        r16.restoreToCount(r12);
        if (Build.VERSION.SDK_INT < 29) goto L20;
        r20.setBlendMode(r28);
    L20:
        r20.setXfermode(r29);
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r20.setBlendMode(null);     // Catch: Throwable -> L16
    L6:
        r20.setXfermode(null);     // Catch: Throwable -> L16
        r20.setMaskFilter(null);     // Catch: Throwable -> L16
        r16.drawText(r21.b(), 0, r21.b().length, r22, r23, r20);     // Catch: Throwable -> L16
        if (r27 == false) goto L9;
        LinearGradient r1 = f;     // Catch: Throwable -> L16
    L10:
        Matrix r2 = f36444e;     // Catch: Throwable -> L16
        r2.reset();     // Catch: Throwable -> L16
        r2.setScale(n.a(r25 - r24, 0.001f), 1.0f);     // Catch: Throwable -> L16
        r2.postTranslate(r24, 0.0f);     // Catch: Throwable -> L16
        r1.setLocalMatrix(r2);     // Catch: Throwable -> L16
        Paint r0 = f36443d;     // Catch: Throwable -> L16
        r0.setShader((Shader) ZeusTransformUtils.preCheckCast(r1, Shader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        r16.drawRect(r17, 0.0f, r18, r26, r0);     // Catch: Throwable -> L16
        r0.setShader(null);
        r16.restoreToCount(r12);
        if (Build.VERSION.SDK_INT < 29) goto L14;
        r20.setBlendMode(r28);
    L14:
        r20.setXfermode(r29);
        return;
    L9:
        r1 = g;     // Catch: Throwable -> L16
        goto L10
    }
}
