package com.baidu.vi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.stepos.alphame.utils.Property;
import java.nio.IntBuffer;

/* loaded from: classes.dex */
public class EnvDrawText {
    private static final String DEVICE_VIVOX3L = "vivo X3L";
    private static final int FONT_STYLE_BOLD = 1;
    private static final int FONT_STYLE_ITALIC = 2;
    private static final int FONT_STYLE_NORMAL = 0;
    private static Bitmap defaultFontBmp;
    public static SparseArray<a> fontCache;
    private static Context mContext;
    private static String phonetype;

    private static synchronized int[] drawText(String str, int i4, int i5, int[] iArr, int i6, int i7, int i8, int i9, int i10) {
        Paint.FontMetrics fontMetrics;
        int i11;
        int i12;
        int iPow;
        int i13;
        int desiredWidth;
        int i14;
        int i15;
        int iCeil;
        int i16;
        int desiredWidth2;
        try {
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            if (TextUtils.isEmpty(phonetype)) {
                phonetype = Build.MODEL;
            }
            String str2 = phonetype;
            int i17 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i5 : 0;
            textPaint.reset();
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(i4);
            textPaint.setShadowLayer(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
            textPaint.setTypeface(getTypeface(i17));
            if (i9 != 0) {
                textPaint.setStrokeWidth(i9);
                textPaint.setStrokeCap(Paint.Cap.ROUND);
                textPaint.setStrokeJoin(Paint.Join.ROUND);
                textPaint.setStyle(Paint.Style.STROKE);
            }
            int iIndexOf = str.indexOf(92, 0);
            Bitmap bitmap = null;
            if (iIndexOf == -1) {
                Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                desiredWidth = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                iCeil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                iArr[0] = desiredWidth;
                iArr[1] = iCeil;
                if (iArr.length == 4) {
                    int iPow2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth) / Math.log(2.0d)));
                    iCeil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iCeil) / Math.log(2.0d)));
                    desiredWidth = iPow2;
                }
                if (desiredWidth == 0 && iCeil == 0) {
                    iCeil = 0;
                    desiredWidth = 0;
                }
                if (iArr.length == 4) {
                    iArr[2] = desiredWidth;
                    iArr[3] = iCeil;
                }
                if (desiredWidth > 0 && iCeil > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(desiredWidth, iCeil, Bitmap.Config.ARGB_8888);
                    if (bitmapCreateBitmap == null) {
                        return new int[0];
                    }
                    canvas.setBitmap(bitmapCreateBitmap);
                    bitmap = bitmapCreateBitmap;
                }
                if ((i8 & (-16777216)) == 0) {
                    canvas.drawColor(16777215);
                } else {
                    canvas.drawColor(i8);
                }
                if (i9 != 0) {
                    textPaint.setStrokeWidth(i9);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i7);
                    canvas.drawText(str, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE - fontMetrics2.ascent, textPaint);
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i6);
                canvas.drawText(str, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE - fontMetrics2.ascent, textPaint);
            } else {
                int i18 = iIndexOf + 1;
                int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint) + 0.5d);
                int i19 = 2;
                while (true) {
                    int iIndexOf2 = str.indexOf(92, i18);
                    if (iIndexOf2 <= 0) {
                        break;
                    }
                    int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i18, iIndexOf2), textPaint) + 0.5d);
                    if (desiredWidth4 > desiredWidth3) {
                        desiredWidth3 = desiredWidth4;
                    }
                    i18 = iIndexOf2 + 1;
                    i19++;
                }
                if (i18 != str.length() && (desiredWidth2 = (int) (Layout.getDesiredWidth(str.substring(i18, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                    desiredWidth3 = desiredWidth2;
                }
                Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                int iCeil2 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                int i20 = i19 * iCeil2;
                iArr[0] = desiredWidth3;
                iArr[1] = i20;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics3;
                    i11 = iCeil2;
                    int iPow3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                    iPow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i20) / Math.log(2.0d)));
                    i12 = iPow3;
                } else {
                    fontMetrics = fontMetrics3;
                    i11 = iCeil2;
                    i12 = desiredWidth3;
                    iPow = i20;
                }
                if (i12 == 0 && iPow == 0) {
                    i13 = 0;
                    desiredWidth = 0;
                } else {
                    i13 = iPow;
                    desiredWidth = i12;
                }
                if (iArr.length == 4) {
                    iArr[2] = desiredWidth;
                    iArr[3] = i13;
                }
                if (desiredWidth > 0 && i13 > 0) {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(desiredWidth, i13, Bitmap.Config.ARGB_8888);
                    if (bitmapCreateBitmap2 == null) {
                        return new int[0];
                    }
                    canvas.setBitmap(bitmapCreateBitmap2);
                    bitmap = bitmapCreateBitmap2;
                }
                if ((i8 & (-16777216)) == 0) {
                    canvas.drawColor(16777215);
                } else {
                    canvas.drawColor(i8);
                }
                textPaint.setTextAlign(getTextAlignedType(i10));
                if (i10 == 1) {
                    i14 = 0;
                    i15 = 0;
                } else if (i10 == 2) {
                    i14 = 0;
                    i15 = iArr[0];
                } else {
                    i14 = 0;
                    i15 = iArr[0] / 2;
                }
                int i21 = i14;
                while (true) {
                    int iIndexOf3 = str.indexOf(92, i14);
                    if (iIndexOf3 <= 0) {
                        break;
                    }
                    String strSubstring = str.substring(i14, iIndexOf3);
                    Layout.getDesiredWidth(strSubstring, textPaint);
                    int i22 = iIndexOf3 + 1;
                    if (i9 != 0) {
                        textPaint.setStrokeWidth(i9);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i7);
                        i16 = i13;
                        canvas.drawText(strSubstring, i15, (i21 * i11) - fontMetrics.ascent, textPaint);
                    } else {
                        i16 = i13;
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i6);
                    canvas.drawText(strSubstring, i15, (i21 * i11) - fontMetrics.ascent, textPaint);
                    i21++;
                    i13 = i16;
                    i14 = i22;
                }
                int i23 = i13;
                if (i14 != str.length()) {
                    String strSubstring2 = str.substring(i14, str.length());
                    Layout.getDesiredWidth(strSubstring2, textPaint);
                    if (i9 != 0) {
                        textPaint.setStrokeWidth(i9);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i7);
                        canvas.drawText(strSubstring2, i15, (i21 * i11) - fontMetrics.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i6);
                    canvas.drawText(strSubstring2, i15, (i21 * i11) - fontMetrics.ascent, textPaint);
                }
                iCeil = i23;
            }
            Bitmap bitmap2 = bitmap;
            int[] iArr2 = new int[desiredWidth * iCeil];
            if (bitmap2 != null) {
                bitmap2.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
            }
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            return iArr2;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static Bitmap drawTextAlpha(String str, int i4, int i5, int i6) {
        int desiredWidth;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (TextUtils.isEmpty(phonetype)) {
            phonetype = Build.MODEL;
        }
        String str2 = phonetype;
        int i7 = 0;
        int i8 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i5 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize(i4);
        textPaint.setTypeface(getTypeface(i8));
        float f4 = (i6 * 1.3f) + 0.5f;
        int i9 = 92;
        int iIndexOf = str.indexOf(92, 0);
        Bitmap bitmapCreateBitmap = null;
        if (iIndexOf == -1) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f4);
            int iCeil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            if (desiredWidth2 > 0 && iCeil > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(desiredWidth2, iCeil, Bitmap.Config.ALPHA_8);
                if (bitmapCreateBitmap == null) {
                    return bitmapCreateBitmap;
                }
                bitmapCreateBitmap.eraseColor(0);
                canvas.setBitmap(bitmapCreateBitmap);
            }
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(str, f4 * 0.5f, Property.DEFAULT_FLOAT_VALUE - fontMetrics.ascent, textPaint);
        } else {
            int i10 = iIndexOf + 1;
            int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint) + 0.5d);
            int i11 = 2;
            while (true) {
                int iIndexOf2 = str.indexOf(i9, i10);
                if (iIndexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i10, iIndexOf2), textPaint) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i10 = iIndexOf2 + 1;
                i11++;
                i9 = 92;
            }
            if (i10 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i10, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int i12 = desiredWidth3 + i6;
            int iCeil2 = i11 * ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent));
            if (i12 > 0 && iCeil2 > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(i12, iCeil2, Bitmap.Config.ALPHA_8);
                if (bitmapCreateBitmap == null) {
                    return bitmapCreateBitmap;
                }
                bitmapCreateBitmap.eraseColor(0);
                canvas.setBitmap(bitmapCreateBitmap);
            }
            textPaint.setTextAlign(getTextAlignedType(3));
            float f5 = i12 - (f4 * 0.5f);
            int i13 = 0;
            while (true) {
                int iIndexOf3 = str.indexOf(92, i7);
                if (iIndexOf3 <= 0) {
                    break;
                }
                String strSubstring = str.substring(i7, iIndexOf3);
                Layout.getDesiredWidth(strSubstring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(strSubstring, f5, (i13 * r7) - fontMetrics2.ascent, textPaint);
                i13++;
                i7 = iIndexOf3 + 1;
            }
            if (i7 != str.length()) {
                String strSubstring2 = str.substring(i7, str.length());
                Layout.getDesiredWidth(strSubstring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(strSubstring2, f5, (i13 * r7) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmapCreateBitmap;
    }

    private static synchronized Bitmap drawTextExt(String str, int i4, int i5, int[] iArr, int i6, int i7, int i8, int i9, int i10) {
        Paint.FontMetrics fontMetrics;
        int i11;
        int i12;
        int i13;
        Paint.FontMetrics fontMetrics2;
        int desiredWidth;
        int i14;
        try {
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            if (TextUtils.isEmpty(phonetype)) {
                phonetype = Build.MODEL;
            }
            String str2 = phonetype;
            int i15 = (str2 == null || !str2.equals(DEVICE_VIVOX3L)) ? i5 : 0;
            textPaint.reset();
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(i4);
            textPaint.setShadowLayer(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
            textPaint.setTypeface(getTypeface(i15));
            if (i9 != 0) {
                textPaint.setStrokeWidth(i9);
                textPaint.setStrokeCap(Paint.Cap.ROUND);
                textPaint.setStrokeJoin(Paint.Join.ROUND);
                textPaint.setStyle(Paint.Style.STROKE);
            }
            int iIndexOf = str.indexOf(92, 0);
            Bitmap bitmap = null;
            if (iIndexOf == -1) {
                Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                int iCeil = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                iArr[0] = desiredWidth2;
                iArr[1] = iCeil;
                if (iArr.length == 4) {
                    int iPow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                    iCeil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iCeil) / Math.log(2.0d)));
                    desiredWidth2 = iPow;
                }
                if (desiredWidth2 == 0 && iCeil == 0) {
                    iCeil = 0;
                    i14 = 0;
                } else {
                    i14 = desiredWidth2;
                }
                if (iArr.length == 4) {
                    iArr[2] = i14;
                    iArr[3] = iCeil;
                }
                if (i14 > 0 && iCeil > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i14, iCeil, Bitmap.Config.ARGB_8888);
                    if (bitmapCreateBitmap == null) {
                        return bitmapCreateBitmap;
                    }
                    canvas.setBitmap(bitmapCreateBitmap);
                    bitmap = bitmapCreateBitmap;
                }
                if ((i8 & (-16777216)) == 0) {
                    canvas.drawColor(16777215);
                } else {
                    canvas.drawColor(i8);
                }
                if (i9 != 0) {
                    textPaint.setStrokeWidth(i9);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                    textPaint.setColor(i7);
                    canvas.drawText(str, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE - fontMetrics3.ascent, textPaint);
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i6);
                canvas.drawText(str, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE - fontMetrics3.ascent, textPaint);
            } else {
                int i16 = iIndexOf + 1;
                int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, iIndexOf), textPaint) + 0.5d);
                int i17 = 2;
                while (true) {
                    int iIndexOf2 = str.indexOf(92, i16);
                    if (iIndexOf2 <= 0) {
                        break;
                    }
                    int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i16, iIndexOf2), textPaint) + 0.5d);
                    if (desiredWidth4 > desiredWidth3) {
                        desiredWidth3 = desiredWidth4;
                    }
                    i16 = iIndexOf2 + 1;
                    i17++;
                }
                if (i16 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i16, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                    desiredWidth3 = desiredWidth;
                }
                Paint.FontMetrics fontMetrics4 = textPaint.getFontMetrics();
                int iCeil2 = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                int iPow2 = i17 * iCeil2;
                iArr[0] = desiredWidth3;
                iArr[1] = iPow2;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics4;
                    i11 = iCeil2;
                    int iPow3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                    iPow2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(iPow2) / Math.log(2.0d)));
                    desiredWidth3 = iPow3;
                } else {
                    fontMetrics = fontMetrics4;
                    i11 = iCeil2;
                }
                if (desiredWidth3 == 0 && iPow2 == 0) {
                    desiredWidth3 = 0;
                    iPow2 = 0;
                }
                if (iArr.length == 4) {
                    iArr[2] = desiredWidth3;
                    iArr[3] = iPow2;
                }
                if (desiredWidth3 > 0 && iPow2 > 0) {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(desiredWidth3, iPow2, Bitmap.Config.ARGB_8888);
                    if (bitmapCreateBitmap2 == null) {
                        return bitmapCreateBitmap2;
                    }
                    canvas.setBitmap(bitmapCreateBitmap2);
                    bitmap = bitmapCreateBitmap2;
                }
                if ((i8 & (-16777216)) == 0) {
                    canvas.drawColor(16777215);
                } else {
                    canvas.drawColor(i8);
                }
                textPaint.setTextAlign(getTextAlignedType(i10));
                if (i10 == 1) {
                    i12 = 0;
                    i13 = 0;
                } else if (i10 == 2) {
                    i12 = 0;
                    i13 = iArr[0];
                } else {
                    i12 = 0;
                    i13 = iArr[0] / 2;
                }
                int i18 = i12;
                while (true) {
                    int iIndexOf3 = str.indexOf(92, i12);
                    if (iIndexOf3 <= 0) {
                        break;
                    }
                    String strSubstring = str.substring(i12, iIndexOf3);
                    Layout.getDesiredWidth(strSubstring, textPaint);
                    int i19 = iIndexOf3 + 1;
                    if (i9 != 0) {
                        textPaint.setStrokeWidth(i9);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i7);
                        fontMetrics2 = fontMetrics;
                        canvas.drawText(strSubstring, i13, (i18 * i11) - fontMetrics2.ascent, textPaint);
                    } else {
                        fontMetrics2 = fontMetrics;
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i6);
                    canvas.drawText(strSubstring, i13, (i18 * i11) - fontMetrics2.ascent, textPaint);
                    i18++;
                    i12 = i19;
                    fontMetrics = fontMetrics2;
                }
                Paint.FontMetrics fontMetrics5 = fontMetrics;
                if (i12 != str.length()) {
                    String strSubstring2 = str.substring(i12, str.length());
                    Layout.getDesiredWidth(strSubstring2, textPaint);
                    if (i9 != 0) {
                        textPaint.setStrokeWidth(i9);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i7);
                        canvas.drawText(strSubstring2, i13, (i18 * i11) - fontMetrics5.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i6);
                    canvas.drawText(strSubstring2, i13, (i18 * i11) - fontMetrics5.ascent, textPaint);
                }
            }
            return bitmap;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static Paint.Align getTextAlignedType(int i4) {
        return 1 == i4 ? Paint.Align.LEFT : 2 == i4 ? Paint.Align.RIGHT : Paint.Align.CENTER;
    }

    private static Bitmap getTextBitmap() {
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(false);
        paint.setTextSize(12.0f);
        paint.setTypeface(Typeface.DEFAULT);
        float fMeasureText = paint.measureText("!");
        float fDescent = paint.descent() - paint.ascent();
        if (fMeasureText <= Property.DEFAULT_FLOAT_VALUE) {
            fMeasureText = 3.0f;
        }
        if (fDescent <= Property.DEFAULT_FLOAT_VALUE) {
            fDescent = 15.0f;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) Math.ceil(fMeasureText), (int) Math.ceil(fDescent), Bitmap.Config.ALPHA_8);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawText("!", Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE - paint.ascent(), paint);
        return bitmapCreateBitmap;
    }

    private static short[] getTextSize(String str, int i4, int i5) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i4);
        textPaint.setTypeface(getTypeface(i5));
        short[] sArr = new short[length];
        for (int i6 = 0; i6 < length; i6++) {
            sArr[i6] = (short) (Layout.getDesiredWidth(str, 0, r3, textPaint) + 0.5d);
        }
        return sArr;
    }

    private static float[] getTextSizeExt(String str, int i4, int i5) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i4);
        paint.setTypeface(getTypeface(i5));
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    private static short[] getTextSizeWithHalo(String str, int i4, int i5, int i6) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i4);
        textPaint.setTypeface(getTypeface(i5));
        if (i6 != 0) {
            textPaint.setStrokeWidth(i6);
            textPaint.setStrokeCap(Paint.Cap.ROUND);
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStyle(Paint.Style.STROKE);
        }
        short[] sArr = new short[length];
        for (int i7 = 0; i7 < length; i7++) {
            sArr[i7] = (short) (Layout.getDesiredWidth(str, 0, r2, textPaint) + 0.5d);
        }
        return sArr;
    }

    private static Typeface getTypeface(int i4) {
        Typeface typeface = Typeface.DEFAULT;
        return i4 != 1 ? i4 != 2 ? typeface : Typeface.create(typeface, 2) : Typeface.DEFAULT_BOLD;
    }

    private static synchronized boolean isSystemFontChanged() {
        if (defaultFontBmp == null) {
            defaultFontBmp = getTextBitmap();
            return false;
        }
        Bitmap textBitmap = getTextBitmap();
        if (!(!nativeIsBitmapSame(textBitmap, defaultFontBmp))) {
            textBitmap.recycle();
            return false;
        }
        defaultFontBmp.recycle();
        defaultFontBmp = Bitmap.createBitmap(textBitmap);
        textBitmap.recycle();
        return true;
    }

    private static native boolean nativeIsBitmapSame(Bitmap bitmap, Bitmap bitmap2);

    public static synchronized void registFontCache(int i4, Typeface typeface) {
        if (i4 == 0 || typeface == null) {
            return;
        }
        try {
            if (fontCache == null) {
                fontCache = new SparseArray<>();
            }
            a aVar = fontCache.get(i4);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.f9496a = typeface;
                aVar2.f9497b++;
                fontCache.put(i4, aVar2);
            } else {
                aVar.f9497b++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void removeFontCache(int i4) {
        a aVar = fontCache.get(i4);
        if (aVar == null) {
            return;
        }
        int i5 = aVar.f9497b - 1;
        aVar.f9497b = i5;
        if (i5 == 0) {
            fontCache.remove(i4);
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
