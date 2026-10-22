package com.ttreader.tttext.lite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class JavaCanvasHelper {
    protected Canvas canvas_;
    protected boolean is_bold_;
    protected boolean is_italic_;
    protected boolean is_underline_;
    protected final Paint paint_;

    /* JADX INFO: renamed from: com.ttreader.tttext.lite.JavaCanvasHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp = null;
        static final /* synthetic */ int[] $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType = null;

        static {
            int[] r0 = new int[TTTextDefinition.PathType.values().length];
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType = r0;
            r0[TTTextDefinition.PathType.kLines.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L93:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType[TTTextDefinition.PathType.kArc.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L113:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType[TTTextDefinition.PathType.kBezier.ordinal()] = 3;     // Catch: NoSuchFieldError -> L44
        L125:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType[TTTextDefinition.PathType.kMoveTo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L45
        L131:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType[TTTextDefinition.PathType.kMultiPath.ordinal()] = 5;     // Catch: NoSuchFieldError -> L46
        L12:
            int[] r5 = new int[TTTextDefinition.CanvasOp.values().length];
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp = r5;
            r5[TTTextDefinition.CanvasOp.kStartPaint.ordinal()] = 1;     // Catch: NoSuchFieldError -> L47
        L99:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kEndPaint.ordinal()] = 2;     // Catch: NoSuchFieldError -> L48
        L107:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSave.ordinal()] = 3;     // Catch: NoSuchFieldError -> L49
        L111:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRestore.ordinal()] = 4;     // Catch: NoSuchFieldError -> L50
        L119:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClear.ordinal()] = 5;     // Catch: NoSuchFieldError -> L51
        L139:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kTranslate.ordinal()] = 6;     // Catch: NoSuchFieldError -> L52
        L77:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kScale.ordinal()] = 7;     // Catch: NoSuchFieldError -> L53
        L97:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kRotate.ordinal()] = 8;     // Catch: NoSuchFieldError -> L54
        L103:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kSkew.ordinal()] = 9;     // Catch: NoSuchFieldError -> L55
        L123:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClipRect.ordinal()] = 10;     // Catch: NoSuchFieldError -> L56
        L129:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kClearRect.ordinal()] = 11;     // Catch: NoSuchFieldError -> L57
        L83:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kFillRect.ordinal()] = 12;     // Catch: NoSuchFieldError -> L58
        L85:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArc.ordinal()] = 13;     // Catch: NoSuchFieldError -> L59
        L105:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawLine.ordinal()] = 14;     // Catch: NoSuchFieldError -> L60
        L109:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawOval.ordinal()] = 15;     // Catch: NoSuchFieldError -> L61
        L133:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawPath.ordinal()] = 16;     // Catch: NoSuchFieldError -> L62
        L135:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRect.ordinal()] = 17;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawText.ordinal()] = 18;     // Catch: NoSuchFieldError -> L64
        L91:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawArcTo.ordinal()] = 19;     // Catch: NoSuchFieldError -> L65
        L115:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawColor.ordinal()] = 20;     // Catch: NoSuchFieldError -> L66
        L117:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImage.ordinal()] = 21;     // Catch: NoSuchFieldError -> L67
        L137:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawCircle.ordinal()] = 22;     // Catch: NoSuchFieldError -> L68
        L75:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawGlyphs.ordinal()] = 23;     // Catch: NoSuchFieldError -> L69
        L95:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawImageRect.ordinal()] = 24;     // Catch: NoSuchFieldError -> L70
        L101:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRunDelegate.ordinal()] = 25;     // Catch: NoSuchFieldError -> L71
        L121:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBackgroundDelegate.ordinal()] = 26;     // Catch: NoSuchFieldError -> L72
        L127:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawBlockRegion.ordinal()] = 27;     // Catch: NoSuchFieldError -> L73
        L81:
            $SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[TTTextDefinition.CanvasOp.kDrawRoundRect.ordinal()] = 28;     // Catch: NoSuchFieldError -> L74
            return;
        }
    }

    public void clear() {
    }

    public void endPaint() {
    }

    public void startPaint() {
    }

    public JavaCanvasHelper(Canvas r2) {
        this.paint_ = new Paint();
        this.canvas_ = r2;
    }

    public void drawBuffer(byte[] r2) {
        BBufferInputStream r0 = new BBufferInputStream(r2);
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r0.available() <= 0) goto L14;
        drawOp(TTTextDefinition.GetCanvasOp(r0.readByte()), r0);     // Catch: IOException -> L7
        goto L10
    }

    public void drawOp(TTTextDefinition.CanvasOp r2, BBufferInputStream r3) {
        switch(AnonymousClass1.$SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$CanvasOp[r2.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L13;
            case 20: goto L12;
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L9;
            case 24: goto L8;
            case 25: goto L7;
            case 26: goto L6;
            case 27: goto L59;
            case 28: goto L5;
            default: goto L59;
        };
    L5:
        drawRoundRect(r3);
        return;
    L6:
        drawBackgroundDelegate(r3);
        return;
    L7:
        drawRunDelegate(r3);
        return;
    L8:
        drawImgRect(r3);
        return;
    L9:
        drawGlyphs(r3);
        return;
    L10:
        drawCircle(r3);
        return;
    L11:
        drawImage(r3);
        return;
    L12:
        drawColor(r3);
        return;
    L13:
        drawArcTo(r3);
        return;
    L14:
        drawText(r3);
        return;
    L15:
        drawRect(r3);
        return;
    L16:
        drawPath(r3);
        return;
    L17:
        drawOval(r3);
        return;
    L18:
        drawLine(r3);
        return;
    L19:
        drawArc(r3);
        return;
    L20:
        fillRect(r3);
        return;
    L21:
        clearRect(r3);
        return;
    L22:
        clipRect(r3);
        return;
    L23:
        skew(r3);
        return;
    L24:
        rotate(r3);
        return;
    L25:
        scale(r3);
        return;
    L26:
        translate(r3);
        return;
    L27:
        clear();
        return;
    L28:
        restore();
        return;
    L29:
        save();
        return;
    L30:
        endPaint();
        return;
    L31:
        startPaint();
        return;
    }

    public void save() {
        this.canvas_.save();
    }

    public void restore() {
        this.canvas_.restore();
    }

    public void translate(BBufferInputStream r2) {
        float r0 = TTTextUtils.Dp2Px(r2.readFloat());
        float r3 = TTTextUtils.Dp2Px(r2.readFloat());
        this.canvas_.translate(r0, r3);
    }

    public void scale(BBufferInputStream r2) {
        float r0 = r2.readFloat();
        float r3 = r2.readFloat();
        this.canvas_.scale(r0, r3);
    }

    public void rotate(BBufferInputStream r1) {
        float r2 = r1.readFloat();
        this.canvas_.rotate(r2);
    }

    public void skew(BBufferInputStream r2) {
        float r0 = TTTextUtils.Dp2Px(r2.readFloat());
        float r3 = TTTextUtils.Dp2Px(r2.readFloat());
        this.canvas_.skew(r0, r3);
    }

    public void clipRect(BBufferInputStream r4) {
        float r0 = TTTextUtils.Dp2Px(r4.readFloat());
        float r1 = TTTextUtils.Dp2Px(r4.readFloat());
        float r2 = TTTextUtils.Dp2Px(r4.readFloat());
        float r5 = TTTextUtils.Dp2Px(r4.readFloat());
        this.canvas_.clipRect(r0, r1, r2, r5);
    }

    public void clearRect(BBufferInputStream r1) {
        TTTextUtils.Dp2Px(r1.readFloat());
        TTTextUtils.Dp2Px(r1.readFloat());
        TTTextUtils.Dp2Px(r1.readFloat());
        TTTextUtils.Dp2Px(r1.readFloat());
    }

    public void fillRect(BBufferInputStream r9) {
        int r0 = r9.readInt();
        float r3 = TTTextUtils.Dp2Px(r9.readFloat());
        float r4 = TTTextUtils.Dp2Px(r9.readFloat());
        float r5 = TTTextUtils.Dp2Px(r9.readFloat());
        float r6 = TTTextUtils.Dp2Px(r9.readFloat());
        Paint r7 = new Paint();
        r7.setColor(r0);
        r7.setStyle(Paint.Style.FILL);
        this.canvas_.drawRect(r3, r4, r5, r6, r7);
    }

    public void drawColor(BBufferInputStream r1) {
        r1.readInt();
    }

    public void drawLine(BBufferInputStream r8) {
        float r2 = TTTextUtils.Dp2Px(r8.readFloat());
        float r3 = TTTextUtils.Dp2Px(r8.readFloat());
        float r4 = TTTextUtils.Dp2Px(r8.readFloat());
        float r5 = TTTextUtils.Dp2Px(r8.readFloat());
        Paint r6 = ReadPaint(r8);
        this.canvas_.drawLine(r2, r3, r4, r5, r6);
    }

    public void drawRect(BBufferInputStream r8) {
        float r2 = TTTextUtils.Dp2Px(r8.readFloat());
        float r3 = TTTextUtils.Dp2Px(r8.readFloat());
        float r4 = TTTextUtils.Dp2Px(r8.readFloat());
        float r5 = TTTextUtils.Dp2Px(r8.readFloat());
        Paint r6 = ReadPaint(r8);
        this.canvas_.drawRect(r2, r3, r4, r5, r6);
    }

    public void drawRoundRect(BBufferInputStream r10) {
        float r2 = TTTextUtils.Dp2Px(r10.readFloat());
        float r3 = TTTextUtils.Dp2Px(r10.readFloat());
        float r4 = TTTextUtils.Dp2Px(r10.readFloat());
        float r5 = TTTextUtils.Dp2Px(r10.readFloat());
        float r7 = TTTextUtils.Dp2Px(r10.readFloat());
        Paint r11 = ReadPaint(r10);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.canvas_.drawRoundRect(r2, r3, r4, r5, r7, r7, r11);
        return;
    L5:
        this.canvas_.drawRect(r2, r3, r4, r5, r11);
    }

    public void drawOval(BBufferInputStream r2) {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2);
    }

    public void drawCircle(BBufferInputStream r4) {
        float r0 = TTTextUtils.Dp2Px(r4.readFloat());
        float r1 = TTTextUtils.Dp2Px(r4.readFloat());
        float r2 = TTTextUtils.Dp2Px(r4.readFloat());
        Paint r5 = ReadPaint(r4);
        this.canvas_.drawCircle(r0, r1, r2, r5);
    }

    public void drawArc(BBufferInputStream r2) {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        r2.readInt();
        ReadPaint(r2);
    }

    public void drawPath(BBufferInputStream r2) {
        Path r0 = new Path();
        ReadPath(r0, r2);
        r0.close();
        Paint r3 = ReadPaint(r2);
        this.canvas_.drawPath(r0, r3);
    }

    public void drawArcTo(BBufferInputStream r2) {
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2);
    }

    public void drawText(BBufferInputStream r7) {
        long r0 = r7.readLong();
        String r2 = r7.ReadCString();
        float r3 = TTTextUtils.Dp2Px(r7.readFloat());
        float r4 = TTTextUtils.Dp2Px(r7.readFloat());
        Paint r8 = ReadPaint(r7);
        int r1 = (int) r0;
        if (this.is_bold_ == false) goto L5;
        TTTextDefinition.FontWeight r5 = TTTextDefinition.FontWeight.kBold_700;
    L7:
        if (this.is_italic_ == false) goto L9;
        TTTextDefinition.FontStyle r6 = TTTextDefinition.FontStyle.kItalic;
    L10:
        JavaFontManager.ApplyFont(r8, r1, r5, r6);
        this.canvas_.drawText(r2, r3, r4, r8);
        return;
    L9:
        r6 = TTTextDefinition.FontStyle.kNormal;
        goto L10
    L5:
        r5 = TTTextDefinition.FontWeight.kNormal_400;
        goto L7
    }

    public void drawGlyphs(BBufferInputStream r8) {
        long r0 = r8.readLong();
        int r2 = r8.readInt();
        int[] r3 = new int[r2];
        float[] r4 = new float[r2];
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r3[r5] = r8.readInt();
        r4[r5] = TTTextUtils.Dp2Px(r8.readFloat());
        r5 = r5 + 1;
        goto L3
    L5:
        TTTextUtils.Dp2Px(r8.readFloat());
        Paint r9 = ReadPaint(r8);
        int r1 = (int) r0;
        if (this.is_bold_ == false) goto L8;
        TTTextDefinition.FontWeight r6 = TTTextDefinition.FontWeight.kBold_700;
    L10:
        if (this.is_italic_ == false) goto L12;
        TTTextDefinition.FontStyle r7 = TTTextDefinition.FontStyle.kItalic;
    L13:
        JavaFontManager.ApplyFont(r9, r1, r6, r7);
        return;
    L12:
        r7 = TTTextDefinition.FontStyle.kNormal;
        goto L13
    L8:
        r6 = TTTextDefinition.FontWeight.kNormal_400;
        goto L10
    }

    public void drawRunDelegate(BBufferInputStream r2) {
        r2.readInt();
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        TTTextUtils.Dp2Px(r2.readFloat());
        ReadPaint(r2);
    }

    public void drawBackgroundDelegate(BBufferInputStream r1) {
        r1.readInt();
        ReadPaint(r1);
    }

    public void drawImage(BBufferInputStream r10) {
        int r0 = r10.readInt();
        byte[] r1 = new byte[r0];
        r10.read(r1, 0, r0);
        float r3 = TTTextUtils.Dp2Px(r10.readFloat());
        float r4 = TTTextUtils.Dp2Px(r10.readFloat());
        float r5 = TTTextUtils.Dp2Px(r10.readFloat());
        float r6 = TTTextUtils.Dp2Px(r10.readFloat());
        Paint r11 = ReadPaint(r10);
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r0);
        this.canvas_.drawBitmap(r2, new Rect(0, 0, r2.getWidth(), r2.getHeight()), new Rect((int) r3, (int) r4, (int) r5, (int) r6), r11);
    }

    public void drawImgRect(BBufferInputStream r12) {
        int r0 = r12.readInt();
        byte[] r1 = new byte[r0];
        r12.read(r1, 0, r0);
        float r3 = TTTextUtils.Dp2Px(r12.readFloat());
        float r4 = TTTextUtils.Dp2Px(r12.readFloat());
        float r5 = TTTextUtils.Dp2Px(r12.readFloat());
        float r6 = TTTextUtils.Dp2Px(r12.readFloat());
        float r7 = TTTextUtils.Dp2Px(r12.readFloat());
        float r8 = TTTextUtils.Dp2Px(r12.readFloat());
        float r9 = TTTextUtils.Dp2Px(r12.readFloat());
        float r10 = TTTextUtils.Dp2Px(r12.readFloat());
        Paint r13 = ReadPaint(r12);
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r0);
        this.canvas_.drawBitmap(r2, new Rect((int) r3, (int) r4, (int) r5, (int) r6), new Rect((int) r7, (int) r8, (int) r9, (int) r10), r13);
    }

    public Paint ReadPaint(BBufferInputStream r4) {
        boolean r1 = true;
        this.paint_.setAntiAlias(true);
        this.paint_.setStrokeWidth(TTTextUtils.Dp2Px(r4.readFloat()));
        this.paint_.setColor(r4.readInt());
        this.paint_.setTextSize(TTTextUtils.Dp2Px(r4.readFloat()));
        byte r5 = r4.readByte();
        int r0 = r5 & 3;
        if (r0 == 0) goto L10;
        if (r0 != 1) goto L6;
        this.paint_.setStyle(Paint.Style.STROKE);
    L12:
        if ((r5 & 4) <= 0) goto L14;
        boolean r2 = true;
    L15:
        this.is_bold_ = r2;
        if ((r5 & 8) <= 0) goto L18;
        boolean r3 = true;
    L19:
        this.is_italic_ = r3;
        if ((r5 & 16) > 0) goto L23;
        r1 = false;
    L23:
        this.is_underline_ = r1;
        return this.paint_;
    L18:
        r3 = false;
        goto L19
    L14:
        r2 = false;
        goto L15
    L6:
        if (r0 != 2) goto L12;
        this.paint_.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L12
    L10:
        this.paint_.setStyle(Paint.Style.FILL);
        goto L12
    }

    public void ReadPath(Path r12, BBufferInputStream r13) {
        int r0 = AnonymousClass1.$SwitchMap$com$ttreader$tttext$lite$TTTextDefinition$PathType[TTTextDefinition.GetPathType(r13.readInt()).ordinal()];
        int r1 = 0;
        if (r0 != 1) goto L5;
        int r11 = r13.readInt();
    L26:
        if (r1 >= r11) goto L38;
        r12.lineTo(TTTextUtils.Dp2Px(r13.readFloat()), TTTextUtils.Dp2Px(r13.readFloat()));
        r1 = r1 + 1;
        goto L26
    L38:
        return;
    L5:
        if (r0 != 2) goto L7;
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        TTTextUtils.Dp2Px(r13.readFloat());
        return;
    L7:
        if (r0 != 3) goto L9;
        int r14 = r13.readInt();
        PointF[] r2 = new PointF[r14];
        int r5 = 0;
    L18:
        if (r5 >= r14) goto L20;
        r2[r5] = new PointF(TTTextUtils.Dp2Px(r13.readFloat()), TTTextUtils.Dp2Px(r13.readFloat()));
        r5 = r5 + 1;
        goto L18
    L20:
        if (r14 != 2) goto L22;
        r12.quadTo(r2[0].x, r2[0].y, r2[1].x, r2[1].y);
        return;
    L22:
        if (r14 < 3) goto L33;
        r12.cubicTo(r2[0].x, r2[0].y, r2[1].x, r2[1].y, r2[2].x, r2[2].y);
        return;
    L33:
        return;
    L9:
        if (r0 != 4) goto L11;
        r12.moveTo(TTTextUtils.Dp2Px(r13.readFloat()), TTTextUtils.Dp2Px(r13.readFloat()));
        return;
    L11:
        if (r0 != 5) goto L36;
        int r3 = r13.readInt();
    L14:
        if (r1 >= r3) goto L37;
        ReadPath(r12, r13);
        r1 = r1 + 1;
        goto L14
    L37:
        return;
    }
}
