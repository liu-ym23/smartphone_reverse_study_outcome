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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
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
            float f = this.mSizeScale * fMin;
            float f7 = this.mResources.getDisplayMetrics().density;
            this.mHeaderRect.set(0.0f, 0.0f, f, f);
            this.mHeaderRect.offset(0.0f, (rect.height() - f) / 2.0f);
            this.mHeaderRect.offset(this.mOffsetX * fMin, 0.0f);
            if (Float.compare(this.mSizeScale, 1.0f) == 0) {
                this.mBorderWidth = 0;
                this.mBorderColor = 0;
            }
            this.mTextScale = this.mHeaderRect.width() / (f7 * 40.0f);
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
    private Header createDefaultHeader(Resources resources, int i, Object obj, int i6) {
        Header header = new Header(resources);
        header.mBorderColor = i6;
        header.mBorderWidth = i;
        header.mDefaultIcon = resources.getDrawable(R.drawable.stepos_contact_list_picture);
        header.mSizeScale = 1.0f;
        header.mBackgroundColor = parseBackgroundColor(obj);
        return header;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Header createHeader(Resources resources, int i, float f, Object obj, Object obj2, int i6) {
        Header header = new Header(resources);
        header.mBorderColor = i6;
        header.mBorderWidth = i;
        header.mSizeScale = f;
        if (obj instanceof String) {
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
        if (TextUtils.isEmpty(header.mText)) {
            header.mBackgroundColor = getColorByText(header.mText);
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
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        return i;
    }

    private String getChineseStr(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(mRegExChineseText).matcher(str);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }

    private int getColorByText(String str) {
        return colorArray[!TextUtils.isEmpty(str) ? Math.abs(str.hashCode()) % colorArray.length : 5];
    }

    public static int getEnglishCount(String str) {
        int i = 0;
        while (Pattern.compile(mRegExEnglish).matcher(str).find()) {
            i++;
        }
        return i;
    }

    private String getEnglishFirstLetters(String str) {
        String strReplaceAll = Pattern.compile(mRegExNumber).matcher(str).replaceAll(" ");
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile(mEnglishFirstLetters).matcher(strReplaceAll);
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString().toUpperCase();
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
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(DEFAULT_BG_COLOR);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setTypeface(Typeface.create(Typeface.create("sans-serif-medium", 0), 500, false));
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 19968 && c <= 40869) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnglish(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private int parseBackgroundColor(Object obj) {
        return obj instanceof String ? getColorByText((String) obj) : DEFAULT_BG_COLOR;
    }

    private void parseContent(Resources resources, Object[] objArr, Object[] objArr2, int i) {
        int iMin = Math.min(objArr != null ? objArr.length : 1, 3);
        int i6 = ((int) resources.getDisplayMetrics().density) + 1;
        int i10 = iMin - 1;
        float f = 1.0f - (i10 / 6.0f);
        if (objArr == null || objArr.length == 0) {
            Header headerCreateDefaultHeader = (objArr2 == null || objArr2.length == 0) ? createDefaultHeader(resources, i6, Integer.valueOf(colorArray[5]), i) : createDefaultHeader(resources, i6, objArr2[0], i);
            headerCreateDefaultHeader.mSizeScale = 1.0f;
            headerCreateDefaultHeader.mOffsetX = 0.0f;
            this.mHeaders[0] = headerCreateDefaultHeader;
            return;
        }
        while (i10 >= 0) {
            ContactHeaderDrawable contactHeaderDrawable = this;
            Resources resources2 = resources;
            Header headerCreateHeader = contactHeaderDrawable.createHeader(resources2, i6, f, objArr[i10], objArr2.length > i10 ? objArr2[i10] : null, i);
            headerCreateHeader.mSizeScale = f;
            headerCreateHeader.mOffsetX = (i10 * 1.0f) / 6.0f;
            contactHeaderDrawable.mHeaders[i10] = headerCreateHeader;
            i10--;
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
    public void draw(@NonNull Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setNightModeUse(canvas);
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
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mBitmapPaint.setAlpha(i);
        this.mTextPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mBitmapPaint.setColorFilter(colorFilter);
        this.mTextPaint.setColorFilter(colorFilter);
    }

    public void setContent(Resources resources, int i, int i6, Object[] objArr, Object[] objArr2, int i10) {
        float f = resources.getDisplayMetrics().density;
        this.mIntrinsicHeight = (int) (i * f);
        this.mIntrinsicWidth = (int) (i6 * f);
        parseContent(resources, objArr, objArr2, i10);
    }

    public ContactHeaderDrawable(Resources resources, int i, int i6, Object[] objArr, Object[] objArr2, int i10) {
        this.mBitmapPaint = new Paint();
        this.mTextPaint = new Paint();
        this.mHeaders = new Header[3];
        this.mBounds = new Rect();
        initPaint();
        setContent(resources, i, i6, objArr, objArr2, i10);
    }
}
