package com.stepos.agentframework.chatui.view;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0013\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001a¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/chatui/view/I0;", "", "<init>", "()V", "", "topPx", "bottomPx", "topHoldPx", "bottomHoldPx", "", "c", "(FFFF)Z", "Landroid/view/View;", "view", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/Function1;", "LY8/t;", "drawContent", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/graphics/Canvas;Lp9/l;)V", "", "width", "height", Const.INTENT_KEY_PKGNAME, "(IIFFFF)V", "F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/LinearGradient;", "topShader", "Landroid/graphics/LinearGradient;", "bottomShader", "shaderWidth", "I", "shaderHeight", "shaderTopPx", "shaderBottomPx", "shaderTopHoldPx", "shaderBottomHoldPx", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class I0 {
    private float bottomHoldPx;
    private float bottomPx;
    private LinearGradient bottomShader;
    private final Paint paint;
    private float shaderBottomHoldPx;
    private float shaderBottomPx;
    private int shaderHeight;
    private float shaderTopHoldPx;
    private float shaderTopPx;
    private int shaderWidth;
    private float topHoldPx;
    private float topPx;
    private LinearGradient topShader;

    public I0() {
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.paint = paint;
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderTopPx = -1.0f;
        this.shaderBottomPx = -1.0f;
        this.shaderTopHoldPx = -1.0f;
        this.shaderBottomHoldPx = -1.0f;
    }

    public static /* synthetic */ boolean d(I0 i02, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        return i02.c(f10, f11, f12, f13);
    }

    public final void a(View view, Canvas canvas, InterfaceC5074l<? super Canvas, Y8.t> drawContent) {
        Canvas canvas2;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(canvas, "canvas");
        kotlin.jvm.internal.p.i(drawContent, "drawContent");
        float f10 = this.topPx;
        float f11 = this.bottomPx;
        if (f10 <= 0.0f && f11 <= 0.0f) {
            drawContent.invoke(canvas);
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            drawContent.invoke(canvas);
            return;
        }
        float f12 = width;
        float f13 = height;
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f12, f13, null);
        drawContent.invoke(canvas);
        b(width, height, f10, f11, this.topHoldPx, this.bottomHoldPx);
        if (f10 > 0.0f) {
            this.paint.setShader(this.topShader);
            canvas.drawRect(0.0f, 0.0f, f12, f10, this.paint);
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
        }
        if (f11 > 0.0f) {
            this.paint.setShader(this.bottomShader);
            canvas2.drawRect(0.0f, f13 - f11, f12, f13, this.paint);
        }
        this.paint.setShader(null);
        canvas2.restoreToCount(iSaveLayer);
    }

    public final void b(int width, int height, float topPx, float bottomPx, float topHoldPx, float bottomHoldPx) {
        float f10;
        char c10;
        char c11;
        int i10;
        int i11;
        LinearGradient linearGradient;
        LinearGradient linearGradient2;
        if (this.shaderWidth == width && this.shaderHeight == height && this.shaderTopPx == topPx && this.shaderBottomPx == bottomPx && this.shaderTopHoldPx == topHoldPx && this.shaderBottomHoldPx == bottomHoldPx) {
            return;
        }
        this.shaderWidth = width;
        this.shaderHeight = height;
        this.shaderTopPx = topPx;
        this.shaderBottomPx = bottomPx;
        this.shaderTopHoldPx = topHoldPx;
        this.shaderBottomHoldPx = bottomHoldPx;
        if (topPx > 0.0f) {
            c10 = 2;
            f10 = 1.0f;
            i10 = 0;
            c11 = 1;
            i11 = -16777216;
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, topPx, new int[]{-16777216, -16777216, 0}, new float[]{0.0f, C5685n.m(topHoldPx / topPx, 0.0f, 1.0f), 1.0f}, Shader.TileMode.CLAMP);
        } else {
            f10 = 1.0f;
            c10 = 2;
            c11 = 1;
            i10 = 0;
            i11 = -16777216;
            linearGradient = null;
        }
        this.topShader = linearGradient;
        if (bottomPx > 0.0f) {
            float f11 = height;
            float fM = C5685n.m(f10 - (bottomHoldPx / bottomPx), 0.0f, f10);
            float[] fArr = new float[3];
            fArr[i10] = 0.0f;
            fArr[c11] = fM;
            fArr[c10] = f10;
            linearGradient2 = new LinearGradient(0.0f, f11 - bottomPx, 0.0f, f11, new int[]{i10, i11, i11}, fArr, Shader.TileMode.CLAMP);
        } else {
            linearGradient2 = null;
        }
        this.bottomShader = linearGradient2;
    }

    public final boolean c(float topPx, float bottomPx, float topHoldPx, float bottomHoldPx) {
        float fE = C5685n.e(topPx, 0.0f);
        float fE2 = C5685n.e(bottomPx, 0.0f);
        float fM = C5685n.m(topHoldPx, 0.0f, fE);
        float fM2 = C5685n.m(bottomHoldPx, 0.0f, fE2);
        if (this.topPx == fE && this.bottomPx == fE2 && this.topHoldPx == fM && this.bottomHoldPx == fM2) {
            return false;
        }
        this.topPx = fE;
        this.bottomPx = fE2;
        this.topHoldPx = fM;
        this.bottomHoldPx = fM2;
        return true;
    }
}
