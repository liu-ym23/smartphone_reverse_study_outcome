package qd;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import bg.h;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuffXfermode f23638b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Paint f23639c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Paint f23640d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Matrix f23641e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinearGradient f23642f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinearGradient f23643g = null;

    static {
        f23637a = new b();
        PorterDuffXfermode r10 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        f23638b = r10;
        f23639c = new Paint();
        Paint r11 = new Paint();
        r11.setXfermode(r10);
        f23640d = r11;
        f23641e = new Matrix();
        Shader.TileMode r12 = Shader.TileMode.CLAMP;
        f23642f = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, -1, 16777215, r12);
        f23643g = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, 16777215, -1, r12);
    }

    public b() {
    }

    public final Paint a(Paint r10) {
        q.g(r10, "sourcePaint");
        Paint r11 = f23639c;
        r11.reset();
        if (r10.getBlendMode() == null) goto L6;
        r11.setBlendMode(r10.getBlendMode());
        return r11;
    L6:
        if (r10.getXfermode() == null) goto L8;
        r11.setXfermode(r10.getXfermode());
        return r11;
    L8:
        return null;
    }

    public final void b(Canvas r16, float r17, float r18, Paint r19, Paint r20, c r21, float r22, float r23, float r24, float r25, float r26, float r27, Function1 r28, BlendMode r29, Xfermode r30) {
        q.g(r16, "canvas");
        q.g(r20, "paint");
        q.g(r21, "cache");
        q.g(r28, "blurMaskFilterProvider");
        if (r25 > r24) goto L5;
        return;
    L5:
        int r14 = r16.saveLayer(r17, 0.0f, r18, r26, r19);
        r20.setBlendMode(null);     // Catch: Throwable -> L9
        r20.setXfermode(null);     // Catch: Throwable -> L9
        r20.setMaskFilter((MaskFilter) r28.invoke(Float.valueOf(r27)));     // Catch: Throwable -> L9
        r16.clipRect(r24, 0.0f, r25, r26);     // Catch: Throwable -> L9
        r16.drawText(r21.c(), 0, r21.c().length, r22, r23, r20);     // Catch: Throwable -> L9
        r16.restoreToCount(r14);
        r20.setBlendMode(r29);
        r20.setXfermode(r30);
        return;
    L9:
        th = move-exception;
        r16.restoreToCount(r14);
        r20.setBlendMode(r29);
        r20.setXfermode(r30);
        throw th;
    }

    public final void c(Canvas r15, float r16, float r17, Paint r18, Paint r19, c r20, float r21, float r22, float r23, float r24, float r25, boolean r26, BlendMode r27, Xfermode r28) {
        q.g(r15, "canvas");
        q.g(r19, "paint");
        q.g(r20, "cache");
        int r12 = r15.saveLayer(r16, 0.0f, r17, r25, r18);
        r19.setBlendMode(null);     // Catch: Throwable -> L6
        r19.setXfermode(null);     // Catch: Throwable -> L6
        r19.setMaskFilter(null);     // Catch: Throwable -> L6
        r15.drawText(r20.c(), 0, r20.c().length, r21, r22, r19);     // Catch: Throwable -> L6
        if (r26 == false) goto L8;
        LinearGradient r10 = f23642f;     // Catch: Throwable -> L6
    L9:
        Matrix r11 = f23641e;     // Catch: Throwable -> L6
        r11.reset();     // Catch: Throwable -> L6
        r11.setScale(h.c(r24 - r23, 0.001f), 1.0f);     // Catch: Throwable -> L6
        r11.postTranslate(r23, 0.0f);     // Catch: Throwable -> L6
        r10.setLocalMatrix(r11);     // Catch: Throwable -> L6
        Paint r13 = f23640d;     // Catch: Throwable -> L6
        r13.setShader(r10);     // Catch: Throwable -> L6
        r15.drawRect(r16, 0.0f, r17, r25, r13);     // Catch: Throwable -> L6
        r13.setShader(null);
        r15.restoreToCount(r12);
        r19.setBlendMode(r27);
        r19.setXfermode(r28);
        return;
    L8:
        r10 = f23643g;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        f23640d.setShader(null);
        r15.restoreToCount(r12);
        r19.setBlendMode(r27);
        r19.setXfermode(r28);
        throw th;
    }
}
