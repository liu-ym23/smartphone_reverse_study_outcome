package com.stepos.common.drawble;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.aiengine.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ContactHeaderDrawable extends Drawable {
    private static final int COLOR_DRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BG_COLOR = -11227562;
    private static final int DEFAULT_BORDER_COLOR = -1;
    private static final int MAX_COUNT = 3;
    private static final String mEnglishFirstLetters = "\\b[a-zA-Z]";
    private static final String mRegExChinese = "[一-龥]";
    private static final String mRegExChineseText = "([一-龥]+)";
    private static final String mRegExEnglish = "[a-zA-Z]";
    private static final String mRegExNumber = "\\d";
    private static final String mSpace = " ";
    private static Method sMethodSetNightModeUseOf;
    private final Paint mBitmapPaint;
    private final Rect mBounds;
    private final Header[] mHeaders;
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private final Paint mTextPaint;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int[] colorArray = {-148165, -435152, -1169103, -10464278, -14315542, -14565170, -12402834};

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Header {
        public int mBackgroundColor;
        public Bitmap mBitmap;
        public int mBorderColor;
        public int mBorderWidth;
        public Drawable mDefaultIcon;
        public float mOffsetX;
        private final Resources mResources;
        public float mSizeScale;
        public String mText;
        public int mTextColor = -1;
        private final RectF mHeaderRect = new RectF();
        private float mTextScale = 1.0f;
        private final Path bitmapClip = new Path();
        private final Matrix mMatrix = new Matrix();
        private final RectF bitmapRect = new RectF();

        public Header(Resources resources) {
            this.mResources = resources;
        }

        private void dealHeaderRect(Rect rect) {
            float fMin = Math.min(rect.width(), rect.height());
            float f8 = this.mSizeScale * fMin;
            float f9 = this.mResources.getDisplayMetrics().density;
            float fWidth = (this.mOffsetX * fMin) + ((rect.width() - r0) / 2.0f) + rect.left;
            float fHeight = ((rect.height() - f8) / 2.0f) + rect.top;
            this.mHeaderRect.set(fWidth, fHeight, fWidth + f8, f8 + fHeight);
            if (Float.compare(this.mSizeScale, 1.0f) == 0) {
                this.mBorderWidth = 0;
                this.mBorderColor = 0;
            }
            this.mTextScale = this.mHeaderRect.width() / (f9 * 40.0f);
            this.mHeaderRect.inset(getScaleBorderWidth() / 2.0f, getScaleBorderWidth() / 2.0f);
        }

        private void drawBackground(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            int color = paint.getColor();
            paint.setColor(this.mBackgroundColor);
            canvas.drawOval(this.mHeaderRect, paint);
            paint.setColor(color);
        }

        private void drawBitmap(Canvas canvas, Paint paint) {
            this.bitmapClip.reset();
            this.mMatrix.reset();
            this.bitmapRect.set(0.0f, 0.0f, this.mBitmap.getWidth(), this.mBitmap.getHeight());
            this.mMatrix.setRectToRect(this.bitmapRect, this.mHeaderRect, Matrix.ScaleToFit.FILL);
            canvas.save();
            this.bitmapClip.addCircle(this.mHeaderRect.centerX(), this.mHeaderRect.centerY(), (this.mHeaderRect.width() - getScaleBorderWidth()) / 2.0f, Path.Direction.CCW);
            canvas.clipPath(this.bitmapClip);
            canvas.drawBitmap(this.mBitmap, this.mMatrix, paint);
            canvas.restore();
        }

        private void drawBorder(Canvas canvas, Paint paint) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(this.mBorderColor);
            paint.setStrokeWidth(getScaleBorderWidth());
            paint.setShader(null);
            canvas.drawOval(this.mHeaderRect, paint);
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }

        private float getScaleBorderWidth() {
            return Math.max(1.0f, this.mTextScale) * this.mBorderWidth;
        }

        public void draw(Canvas canvas, Rect rect, Paint paint, Paint paint2) {
            dealHeaderRect(rect);
            drawBackground(canvas, paint);
            drawBorder(canvas, paint);
            if (!TextUtils.isEmpty(this.mText)) {
                int dimensionPixelSize = this.mText.length() == 1 ? this.mResources.getDimensionPixelSize(R.dimen.avatar_name_char_one) : this.mResources.getDimensionPixelSize(R.dimen.avatar_name_char_two);
                paint2.setColor(this.mTextColor);
                paint2.setTextSize(dimensionPixelSize * this.mTextScale);
                canvas.drawText(this.mText, this.mHeaderRect.centerX() - (paint2.measureText(this.mText) / 2.0f), this.mHeaderRect.centerY() - ((paint2.ascent() + paint2.descent()) / 2.0f), paint2);
                return;
            }
            if (this.mBitmap != null) {
                drawBitmap(canvas, paint);
                return;
            }
            Drawable drawable = this.mDefaultIcon;
            if (drawable != null) {
                RectF rectF = this.mHeaderRect;
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.mDefaultIcon.draw(canvas);
            }
        }
    }

    public ContactHeaderDrawable(Resources resources) {
        this.mBitmapPaint = new Paint();
        this.mTextPaint = new Paint();
        this.mHeaders = new Header[3];
        this.mBounds = new Rect();
        initPaint();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Header createDefaultHeader(Resources resources, int i10, Object obj, int i11) {
        Header header = new Header(resources);
        header.mBorderColor = i11;
        header.mBorderWidth = i10;
        header.mDefaultIcon = resources.getDrawable(R.drawable.stepos_contact_list_picture);
        header.mSizeScale = 1.0f;
        header.mBackgroundColor = parseBackgroundColor(obj);
        return header;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Header createHeader(Resources resources, int i10, float f8, Object obj, Object obj2, int i11) {
        Header header = new Header(resources);
        header.mBorderColor = i11;
        header.mBorderWidth = i10;
        header.mSizeScale = f8;
        boolean z = obj instanceof String;
        if (z) {
            String headerText = getHeaderText((String) obj);
            header.mText = headerText;
            if (TextUtils.isEmpty(headerText)) {
                header.mDefaultIcon = resources.getDrawable(R.drawable.stepos_contact_list_picture);
            }
        } else if (obj instanceof Bitmap) {
            header.mBitmap = (Bitmap) obj;
        } else if (obj instanceof Drawable) {
            header.mBitmap = getBitmapFromDrawable((Drawable) obj);
        } else {
            header.mDefaultIcon = resources.getDrawable(R.drawable.stepos_contact_list_picture);
        }
        if (obj2 != null) {
            header.mBackgroundColor = parseBackgroundColor(obj2);
            return header;
        }
        if (z) {
            header.mBackgroundColor = getColorByText((String) obj);
            return header;
        }
        header.mBackgroundColor = DEFAULT_BG_COLOR;
        return header;
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            return drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, BITMAP_CONFIG) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
        } catch (OutOfMemoryError unused) {
            Log.e("ContactHeaderUtils ", "getBitmapFromDrawable  OutOfMemoryError !");
            return null;
        }
    }

    private int getChineseCount(String str) {
        Matcher matcher = Pattern.compile(mRegExChinese).matcher(str);
        int i10 = 0;
        while (matcher.find()) {
            i10++;
        }
        return i10;
    }

    private String getChineseStr(String str) {
        StringBuilder sb2 = new StringBuilder();
        Matcher matcher = Pattern.compile(mRegExChineseText).matcher(str);
        while (matcher.find()) {
            sb2.append(matcher.group());
        }
        return sb2.toString();
    }

    private int getColorByText(String str) {
        return colorArray[!TextUtils.isEmpty(str) ? Math.abs(str.hashCode()) % colorArray.length : 5];
    }

    public static int getEnglishCount(String str) {
        int i10 = 0;
        while (Pattern.compile(mRegExEnglish).matcher(str).find()) {
            i10++;
        }
        return i10;
    }

    private String getEnglishFirstLetters(String str) {
        String strReplaceAll = Pattern.compile(mRegExNumber).matcher(str).replaceAll(mSpace);
        StringBuilder sb2 = new StringBuilder();
        Matcher matcher = Pattern.compile(mEnglishFirstLetters).matcher(strReplaceAll);
        while (matcher.find()) {
            sb2.append(matcher.group());
        }
        return sb2.toString().toUpperCase();
    }

    private String getHeaderText(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String chineseStr = getChineseStr(str);
        if (isChinese(chineseStr)) {
            int chineseCount = getChineseCount(chineseStr);
            if (chineseCount >= 2) {
                if (chineseCount != 2) {
                    return chineseStr.substring(chineseStr.length() - 2);
                }
                if (str.length() != chineseStr.length() && !str.contains(chineseStr)) {
                    return chineseStr.substring(chineseStr.length() - 2);
                }
            }
            return chineseStr;
        }
        if (!isEnglish(str.substring(0, 1))) {
            return "";
        }
        String englishFirstLetters = getEnglishFirstLetters(str);
        if (getEnglishCount(englishFirstLetters) <= 2) {
            return englishFirstLetters;
        }
        return englishFirstLetters.charAt(0) + englishFirstLetters.substring(englishFirstLetters.length() - 1);
    }

    private void initPaint() {
        this.mBitmapPaint.setFlags(2);
        this.mBitmapPaint.setAntiAlias(true);
        this.mBitmapPaint.setFilterBitmap(true);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(DEFAULT_BG_COLOR);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTypeface(Typeface.create(Typeface.create("sans-serif-medium", 0), 500, false));
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c9 : str.toCharArray()) {
            if (c9 >= 19968 && c9 <= 40869) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnglish(String str) {
        if (str == null) {
            return false;
        }
        for (char c9 : str.toCharArray()) {
            if (c9 >= 'a' && c9 <= 'z') {
                return true;
            }
            if (c9 >= 'A' && c9 <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private int parseBackgroundColor(Object obj) {
        return obj instanceof String ? getColorByText((String) obj) : DEFAULT_BG_COLOR;
    }

    private void parseContent(Resources resources, Object[] objArr, Object[] objArr2, int i10) {
        int iMin = Math.min(objArr != null ? objArr.length : 1, 3);
        int i11 = ((int) resources.getDisplayMetrics().density) + 1;
        int i12 = iMin - 1;
        float f8 = 1.0f - (i12 / 6.0f);
        if (objArr == null || objArr.length == 0) {
            Header headerCreateDefaultHeader = (objArr2 == null || objArr2.length == 0) ? createDefaultHeader(resources, i11, Integer.valueOf(colorArray[5]), i10) : createDefaultHeader(resources, i11, objArr2[0], i10);
            headerCreateDefaultHeader.mSizeScale = 1.0f;
            headerCreateDefaultHeader.mOffsetX = 0.0f;
            this.mHeaders[0] = headerCreateDefaultHeader;
            return;
        }
        while (i12 >= 0) {
            ContactHeaderDrawable contactHeaderDrawable = this;
            Resources resources2 = resources;
            Header headerCreateHeader = contactHeaderDrawable.createHeader(resources2, i11, f8, objArr[i12], (objArr2 == null || objArr2.length <= i12) ? null : objArr2[i12], i10);
            headerCreateHeader.mSizeScale = f8;
            headerCreateHeader.mOffsetX = (i12 * 1.0f) / 6.0f;
            contactHeaderDrawable.mHeaders[i12] = headerCreateHeader;
            i12--;
            this = contactHeaderDrawable;
            resources = resources2;
        }
    }

    private void setNightModeUse(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (sMethodSetNightModeUseOf == null) {
                sMethodSetNightModeUseOf = Canvas.class.getDeclaredMethod("setNightModeUseOf", Integer.TYPE);
            }
            sMethodSetNightModeUseOf.invoke(canvas, 2);
        } catch (Exception unused) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setNightModeUse(canvas);
        if (this.mBounds.isEmpty()) {
            this.mBounds.set(0, 0, this.mIntrinsicWidth, this.mIntrinsicHeight);
        }
        for (int length = this.mHeaders.length - 1; length >= 0; length--) {
            Header header = this.mHeaders[length];
            if (header != null) {
                header.draw(canvas, this.mBounds, this.mBitmapPaint, this.mTextPaint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mIntrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mIntrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mTextPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mBitmapPaint.setAlpha(i10);
        this.mTextPaint.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        this.mTextPaint.setColorFilter(colorFilter);
    }

    public void setContent(Resources resources, int i10, int i11, Object[] objArr, Object[] objArr2, int i12) {
        float f8 = resources.getDisplayMetrics().density;
        this.mIntrinsicWidth = (int) (i10 * f8);
        this.mIntrinsicHeight = (int) (i11 * f8);
        parseContent(resources, objArr, objArr2, i12);
    }

    public ContactHeaderDrawable(Resources resources, int i10, int i11, Object[] objArr, Object[] objArr2, int i12) {
        this.mBitmapPaint = new Paint();
        this.mTextPaint = new Paint();
        this.mHeaders = new Header[3];
        this.mBounds = new Rect();
        initPaint();
        setContent(resources, i10, i11, objArr, objArr2, i12);
    }
}
