package com.stepos.common.widget;

import O6.s;
import O6.w;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.common.R$attr;
import com.stepos.common.R$string;
import com.stepos.common.R$styleable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ImageFontCompatView extends FrameLayout {
    private static final String ASSET_PATH_DEFAULT = "ImageFont.ttf";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_TEXT_COLOR_IF_FONT = -16777216;
    private static final int DEFAULT_TEXT_SIZE_IF_FONT = 25;
    public static final int ICON_FONT_TYPE = 1;
    public static final int IMAGE_TYPE = 2;
    public static final int NONE_TYPE = -1;
    private static final int SYSTEM_DEFAULT_WEIGHT = 400;
    private static final String TAG = "IconFontCompatView";
    private static final String TYPE_JPEG = "image/jpeg";
    private static final String TYPE_PNG = "image/png";
    private String mAssetPath;
    private ImageView mImage;
    private String mImageResName;
    private int mResType;
    private ColorStateList mTextColor;
    private String mTextResName;
    private float mTextSize;
    private int mTextSizeUnit;
    private TextView mTextView;

    public ImageFontCompatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.steposIconFontCompatViewStyle);
    }

    public final void a(Context context) {
        this.mImage = new ImageView(context);
        addView(this.mImage, new FrameLayout.LayoutParams(-2, -2));
    }

    public final Typeface b(Context context, String str, int i10) {
        int i11 = i10 + 400;
        int iC = O6.g.c(i11);
        Context context2 = getContext();
        int i12 = R$string.icon_font_more_search;
        if (!TextUtils.equals(context2.getString(i12), this.mTextResName)) {
            Log.d(TAG, "mTextResName " + this.mTextResName + " weight " + iC);
        }
        if (iC == 100) {
            str = "StepOSIcon-Thin.otf";
        } else if (iC == 200) {
            str = "StepOSIcon-ExtraLight.otf";
        } else if (iC == 300) {
            if (TextUtils.equals(getContext().getString(i12), this.mTextResName) || TextUtils.equals(getContext().getString(R$string.icon_font_more_voice), this.mTextResName)) {
                i11 = i10 + 401;
            } else {
                str = "StepOSIcon-Light.otf";
            }
        }
        return O6.g.b(context, str, i11);
    }

    public final boolean c(Context context) {
        int identifier = context.getResources().getIdentifier(this.mImageResName, "drawable", context.getPackageName());
        if (identifier <= 0) {
            return g(context);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), identifier, options);
        String str = options.outMimeType;
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() <= 0) {
            d(context, str, identifier);
        } else if (getChildAt(0) instanceof ImageView) {
            i(context, str, identifier);
        } else {
            removeAllViews();
            d(context, str, identifier);
        }
        this.mResType = 2;
        return true;
    }

    public final void d(Context context, String str, int i10) {
        a(context);
        i(context, str, i10);
    }

    public final void e(Context context) {
        if (this.mAssetPath == null) {
            this.mResType = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.mTextResName);
                this.mTextView.setTextSize(this.mTextSizeUnit, this.mTextSize);
                this.mTextView.setTextColor(this.mTextColor);
            } else {
                removeAllViews();
                f(context);
            }
        } else {
            f(context);
        }
        this.mResType = 1;
    }

    public final void f(Context context) {
        this.mTextView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            this.mTextView.setTypeface(b(context, this.mAssetPath, configuration.fontWeightAdjustment));
        }
        addView(this.mTextView, layoutParams);
        this.mTextView.setText(this.mTextResName);
        this.mTextView.setTextSize(this.mTextSizeUnit, this.mTextSize);
        this.mTextView.setTextColor(this.mTextColor);
        this.mTextView.setMovementMethod(null);
        this.mTextView.setVerticalScrollBarEnabled(false);
        this.mTextView.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.mTextView.setScaleX(-1.0f);
        }
    }

    public final boolean g(Context context) {
        Drawable drawableA;
        try {
            drawableA = w.a(context, this.mImageResName);
        } catch (Exception | NoSuchMethodError unused) {
            Log.w(TAG, "has no such method 'getCustomRes' in fwk.");
            drawableA = null;
        }
        if (drawableA != null) {
            Log.i(TAG, "drawable from theme app.");
            if (getChildCount() > 1) {
                removeAllViews();
            }
            if (getChildCount() <= 0) {
                a(context);
                this.mImage.setImageDrawable(drawableA);
            } else if (getChildAt(0) instanceof ImageView) {
                this.mImage.setImageDrawable(drawableA);
            } else {
                removeAllViews();
                a(context);
                this.mImage.setImageDrawable(drawableA);
            }
        } else {
            Log.i(TAG, "the resource:" + this.mImageResName + " has no drawable from theme app.");
        }
        return drawableA != null;
    }

    public int getResType() {
        return this.mResType;
    }

    public String getTextResName() {
        return this.mTextResName;
    }

    public final void h() {
        if (this.mImageResName == null || !c(getContext())) {
            e(getContext());
        }
    }

    public final void i(Context context, String str, int i10) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.mImage.setImageResource(i10);
        } else {
            this.mImage.setImageDrawable(q1.f.b(context.getResources(), i10, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setEnabled(z10);
        }
        ImageView imageView = this.mImage;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
    }

    public void setImageResName(String str) {
        this.mImageResName = str;
        h();
    }

    public void setTextColor(int i10) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
        this.mTextColor = colorStateListValueOf;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(String str) {
        this.mTextResName = str;
        h();
    }

    public void setTextSize(float f10) {
        this.mTextSize = f10;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextSize(f10);
            this.mTextSizeUnit = 2;
        }
    }

    public ImageFontCompatView(Context context, AttributeSet attributeSet, int i10) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, i10);
        this.mAssetPath = ASSET_PATH_DEFAULT;
        this.mTextSize = 25.0f;
        this.mResType = -1;
        this.mTextSizeUnit = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageFontCompatView, i10, 0);
        this.mTextResName = typedArrayObtainStyledAttributes.getString(R$styleable.ImageFontCompatView_textResName);
        this.mImageResName = typedArrayObtainStyledAttributes.getString(R$styleable.ImageFontCompatView_imageResName);
        int i11 = R$styleable.ImageFontCompatView_fontTextSize;
        if (typedArrayObtainStyledAttributes.hasValue(i11) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i11)) != null) {
            this.mTextSizeUnit = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.mTextSize = dimension;
            int i12 = this.mTextSizeUnit;
            if (i12 == 2) {
                this.mTextSize = s.h(getContext(), dimension);
            } else if (i12 == 1) {
                this.mTextSize = s.g(getContext(), dimension);
            }
        }
        this.mTextColor = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.ImageFontCompatView_fontTextColor);
        typedArrayObtainStyledAttributes.recycle();
        h();
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mTextColor = colorStateList;
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
