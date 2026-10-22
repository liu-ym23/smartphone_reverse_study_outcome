package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends Canvas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f163185a;

    public a() {
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r100) {
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r100) {
        Intrinsics.checkNotNullParameter(r100, "picture");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() <= 0) goto L9;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRenderNode(RenderNode r100) {
        Intrinsics.checkNotNullParameter(r100, "renderNode");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long r100) {
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r100, BlendMode r101) {
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, "pts");
        Intrinsics.checkNotNullParameter(r101, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawOval(RectF r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, "oval");
        Intrinsics.checkNotNullParameter(r101, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPath(Path r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "picture");
        Intrinsics.checkNotNullParameter(r101, "dst");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() <= 0) goto L9;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, "pts");
        Intrinsics.checkNotNullParameter(r101, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(Rect r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, "r");
        Intrinsics.checkNotNullParameter(r101, "paint");
        if (r100.isEmpty() == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r100, PorterDuff.Mode r101) {
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "picture");
        Intrinsics.checkNotNullParameter(r101, "dst");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() <= 0) goto L9;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(RectF r100, Paint r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r101, "paint");
        if (r100.isEmpty() == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long r100, BlendMode r101) {
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r100, Matrix r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "matrix");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (r100.isRecycled() == true) goto L12;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawPoint(float r100, float r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r102, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(String r100, float[] r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        Intrinsics.checkNotNullParameter(r102, "paint");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRGB(int r100, int r101, int r102) {
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawARGB(int r100, int r101, int r102, int r103) {
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r100, Rect r101, Rect r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "dst");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (r100.isRecycled() == true) goto L12;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawCircle(float r100, float r101, float r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r103, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] r100, int r101, int r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, "pts");
        Intrinsics.checkNotNullParameter(r103, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] r100, int r101, int r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r103, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(RectF r100, float r101, float r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r103, "paint");
        if (r100.isEmpty() == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(String r100, float r101, float r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, "paint");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r100, Rect r101, RectF r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "dst");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (r100.isRecycled() == true) goto L12;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r100, float r101, float r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (r100.isRecycled() == true) goto L12;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawArc(RectF r100, float r101, float r102, boolean r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "oval");
        Intrinsics.checkNotNullParameter(r104, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF r100, float[] r101, RectF r102, float[] r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_OUTER);
        Intrinsics.checkNotNullParameter(r101, "outerRadii");
        Intrinsics.checkNotNullParameter(r102, RNParamRegisterEventHandler.SRC_INNER);
        Intrinsics.checkNotNullParameter(r103, "innerRadii");
        Intrinsics.checkNotNullParameter(r104, "paint");
        if (r100.isEmpty() == true) goto L5;
    L6:
        this.f163185a = true;
        return;
    L5:
        if (r102.isEmpty() == false) goto L6;
    }

    @Override // android.graphics.Canvas
    public final void drawLine(float r100, float r101, float r102, float r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r104, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawOval(float r100, float r101, float r102, float r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r104, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(char[] r100, int r101, int r102, float[] r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        Intrinsics.checkNotNullParameter(r104, "paint");
        if (TextUtils.isEmpty(new String(r100)) == false) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(float r100, float r101, float r102, float r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r104, "paint");
        if (new RectF(r100, r101, r102, r103).isEmpty() == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(String r100, Path r101, float r102, float r103, Paint r104) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r104, "paint");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(char[] r100, int r101, int r102, float r103, float r104, Paint r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "paint");
        if (TextUtils.isEmpty(new String(r100)) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(CharSequence r100, int r101, int r102, float r103, float r104, Paint r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "paint");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(String r100, int r101, int r102, float r103, float r104, Paint r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "paint");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF r100, float r101, float r102, RectF r103, float r104, float r105, Paint r106) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_OUTER);
        Intrinsics.checkNotNullParameter(r103, RNParamRegisterEventHandler.SRC_INNER);
        Intrinsics.checkNotNullParameter(r106, "paint");
        if (r100.isEmpty() == true) goto L5;
    L6:
        this.f163185a = true;
        return;
    L5:
        if (r103.isEmpty() == false) goto L6;
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(float r100, float r101, float r102, float r103, float r104, float r105, Paint r106) {
        Intrinsics.checkNotNullParameter(r106, "paint");
        if (new RectF(r100, r101, r102, r103).isEmpty() == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(char[] r100, int r101, int r102, Path r103, float r104, float r105, Paint r106) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, "path");
        Intrinsics.checkNotNullParameter(r106, "paint");
        if (TextUtils.isEmpty(new String(r100)) == true) goto L6;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawArc(float r100, float r101, float r102, float r103, float r104, float r105, boolean r106, Paint r107) {
        Intrinsics.checkNotNullParameter(r107, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmapMesh(Bitmap r100, int r101, int r102, float[] r103, int r104, int[] r105, int r106, Paint r107) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r103, "verts");
        if (r100.getWidth() > 0) goto L5;
        return;
    L5:
        if (r100.getHeight() > 0) goto L7;
        return;
    L7:
        if (r100.isRecycled() == true) goto L12;
        this.f163185a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] r100, int r101, int r102, float r103, float r104, int r105, int r106, boolean r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(MeasuredText r100, int r101, int r102, int r103, int r104, float r105, float r106, boolean r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] r100, int r101, int r102, int r103, int r104, int r105, int r106, boolean r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(CharSequence r100, int r101, int r102, int r103, int r104, float r105, float r106, boolean r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(char[] r100, int r101, int r102, int r103, int r104, float r105, float r106, boolean r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        this.f163185a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawVertices(Canvas.VertexMode r100, int r101, float[] r102, int r103, float[] r104, int r105, int[] r106, int r107, short[] r108, int r110, int r111, Paint r112) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r102, "verts");
        Intrinsics.checkNotNullParameter(r112, "paint");
        this.f163185a = true;
    }
}
