package com.obric.common.oea.foundation.graphics.smoothcorner.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ISmoothCornerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&J.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016Jv\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u0013J@\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "", "()V", "roundRect", "Landroid/graphics/RectF;", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "", "top", "right", "bottom", "radius", "buildRoundRect", "canDraw", "", "minDimension", "drawAndroidRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "posX", "posY", "tl", "tr", "bl", "br", "drawSmoothCornerRect", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ISmoothCornerImpl {
    public static final Companion Companion = null;
    private final RectF roundRect;

    /* JADX INFO: compiled from: ISmoothCornerImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl$Companion;", "", "()V", "arcTo", "", "Landroid/graphics/Path;", "arcCenter", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/Point;", "radius", "", "startAngle", "endAngle", "arcTo$foundation_standardRelease", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void arcTo$foundation_standardRelease(Path r9, Point r10, float r11, float r12, float r13) {
            Intrinsics.checkNotNullParameter(r9, "$this$arcTo");
            Intrinsics.checkNotNullParameter(r10, "arcCenter");
            r9.arcTo(r10.getX() - r11, r10.getY() - r11, r10.getX() + r11, r10.getY() + r11, r12, r13 - r12, false);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract Path buildPath(float r1, float r2, float r3, float r4, float r5);

    public boolean canDraw(float r1, float r2) {
        return true;
    }

    public abstract String getType();

    public ISmoothCornerImpl() {
        this.roundRect = new RectF();
    }

    public final Path buildRoundRect(float r9, float r10, float r11, float r12, float r13) {
        Path r8 = new Path();
        r8.addRoundRect(r9, r10, r11, r12, r13, r13, Path.Direction.CW);
        r8.close();
        return r8;
    }

    public void drawSmoothCornerRect(Canvas r7, Paint r8, float r9, float r10, float r11, float r12, float r13) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r8, "paint");
        r7.drawPath(buildPath(r9, r10, r11, r12, r13), r8);
    }

    public static /* synthetic */ void drawAndroidRoundRect$default(ISmoothCornerImpl r17, Canvas r18, Paint r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, Object r32) {
        if (r32 != null) goto L23;
        if ((r31 & 512) == 0) goto L7;
        boolean r13 = true;
    L9:
        if ((r31 & 1024) == 0) goto L11;
        boolean r14 = true;
    L13:
        if ((r31 & 2048) == 0) goto L15;
        boolean r15 = true;
    L17:
        if ((r31 & 4096) == 0) goto L19;
        boolean r16 = true;
    L20:
        r17.drawAndroidRoundRect(r18, r19, r20, r21, r22, r23, r24, r25, r26, r13, r14, r15, r16);
        return;
    L19:
        r16 = r30;
        goto L20
    L15:
        r15 = r29;
        goto L17
    L11:
        r14 = r28;
        goto L13
    L7:
        r13 = r27;
        goto L9
    L23:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawAndroidRoundRect");
    }

    public final void drawAndroidRoundRect(Canvas r11, Paint r12, float r13, float r14, float r15, float r16, float r17, float r18, float r19, boolean r20, boolean r21, boolean r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        Intrinsics.checkNotNullParameter(r12, "paint");
        float r7 = r17 - r15;
        float r8 = r18 - r16;
        this.roundRect.set(r15, r16, r17, r18);
        r11.drawRoundRect(this.roundRect, r19, r19, r12);
        if (r20 == true) goto L5;
        float r6 = 2;
        float r9 = r7 / r6;
        float r10 = r8 / r6;
        r11.drawRect(0.0f, 0.0f, r9, r10, r12);
        Path r4 = new Path();
        r4.moveTo(0.0f, r10);
        r4.lineTo(0.0f, 0.0f);
        r4.lineTo(r9, 0.0f);
        r11.drawPath(r4, r12);
    L5:
        if (r21 == true) goto L7;
        float r5 = 2;
        float r24 = r7 / r5;
        float r25 = r8 / r5;
        r11.drawRect(r24, 0.0f, r7, r25, r12);
        Path r26 = new Path();
        r26.moveTo(r24, 0.0f);
        r26.lineTo(r7, 0.0f);
        r26.lineTo(r7, r25);
        r11.drawPath(r26, r12);
    L7:
        if (r22 == true) goto L9;
        float r27 = 2;
        float r28 = r8 / r27;
        float r29 = r7 / r27;
        r11.drawRect(0.0f, r28, r29, r8, r12);
        Path r30 = new Path();
        r30.moveTo(0.0f, r28);
        r30.lineTo(0.0f, r8);
        r30.lineTo(r29, r8);
        r11.drawPath(r30, r12);
    L9:
        if (r23 == true) goto L12;
        float r0 = 2;
        float r3 = r7 / r0;
        float r1 = r8 / r0;
        r11.drawRect(r3, r1, r7, r8, r12);
        Path r31 = new Path();
        r31.moveTo(r3, r8);
        r31.lineTo(r7, r8);
        r31.lineTo(r7, r1);
        r11.drawPath(r31, r12);
        return;
    }
}
