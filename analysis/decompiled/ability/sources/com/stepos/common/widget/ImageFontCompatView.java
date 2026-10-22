package com.stepos.common.widget;

import a5.AbstractC0302b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.stepos.ability.R;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ImageFontCompatView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f3713a;
    public ImageView b;
    public String c;
    public String d;
    public final String e;
    public float f;
    public ColorStateList g;
    public int h;
    public int i;

    public ImageFontCompatView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, R.attr.steposIconFontCompatViewStyle);
        this.e = "ImageFont.ttf";
        this.f = 25.0f;
        this.h = -1;
        this.i = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.e, R.attr.steposIconFontCompatViewStyle, 0);
        this.c = typedArrayObtainStyledAttributes.getString(3);
        this.d = typedArrayObtainStyledAttributes.getString(2);
        if (typedArrayObtainStyledAttributes.hasValue(1) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(1)) != null) {
            this.i = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.f = dimension;
            int i = this.i;
            if (i == 2) {
                this.f = (int) ((dimension / getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
            } else if (i == 1) {
                this.f = dimension / getContext().getResources().getDisplayMetrics().density;
            }
        }
        this.g = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public final void a(Context context) {
        this.b = new ImageView(context);
        addView(this.b, new FrameLayout.LayoutParams(-2, -2));
    }

    public final void b(Context context) {
        String str;
        Typeface typefaceCreateFromAsset;
        this.f3713a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            int i = configuration.fontWeightAdjustment;
            int i6 = i + 400;
            SparseArray sparseArray = AbstractC0302b.f1638a;
            int i10 = i6 < 150 ? 100 : i6 < 250 ? 200 : i6 < 350 ? 300 : i6 < 450 ? 400 : i6 < 550 ? 500 : i6 < 650 ? 600 : i6 < 750 ? TypedValues.TransitionType.TYPE_DURATION : i6 < 850 ? 800 : TypedValues.Custom.TYPE_INT;
            if (!TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.c)) {
                Log.d("IconFontCompatView", "mTextResName " + this.c + " weight " + i10);
            }
            if (i10 == 100) {
                str = "StepOSIcon-Thin.otf";
            } else if (i10 == 200) {
                str = "StepOSIcon-ExtraLight.otf";
            } else {
                String str2 = this.e;
                if (i10 != 300) {
                    str = str2;
                } else if (TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.c) || TextUtils.equals(getContext().getString(R.string.icon_font_more_voice), this.c)) {
                    i6 = i + 401;
                    str = str2;
                } else {
                    str = "StepOSIcon-Light.otf";
                }
            }
            SparseArray sparseArray2 = AbstractC0302b.f1638a;
            if (sparseArray2.get(i6) == null) {
                try {
                    typefaceCreateFromAsset = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i6, 0)).build();
                } catch (IOException e) {
                    Log.e("FontLoader", "has an error:" + e);
                    typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str);
                }
                sparseArray2.put(i6, typefaceCreateFromAsset);
            } else {
                typefaceCreateFromAsset = (Typeface) sparseArray2.get(i6);
            }
            this.f3713a.setTypeface(typefaceCreateFromAsset);
        }
        addView(this.f3713a, layoutParams);
        this.f3713a.setText(this.c);
        this.f3713a.setTextSize(this.i, this.f);
        this.f3713a.setTextColor(this.g);
        this.f3713a.setMovementMethod(null);
        this.f3713a.setVerticalScrollBarEnabled(false);
        this.f3713a.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f3713a.setScaleX(-1.0f);
        }
    }

    public final void c() {
        Drawable drawableD;
        if (this.d != null) {
            Context context = getContext();
            int identifier = context.getResources().getIdentifier(this.d, "drawable", context.getPackageName());
            if (identifier > 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(getResources(), identifier, options);
                String str = options.outMimeType;
                if (getChildCount() > 1) {
                    removeAllViews();
                }
                if (getChildCount() <= 0) {
                    a(context);
                    d(context, str, identifier);
                } else if (getChildAt(0) instanceof ImageView) {
                    d(context, str, identifier);
                } else {
                    removeAllViews();
                    a(context);
                    d(context, str, identifier);
                }
                this.h = 2;
                return;
            }
            try {
                drawableD = a5.l.d(context, this.d);
            } catch (Exception | NoSuchMethodError unused) {
                Log.w("IconFontCompatView", "has no such method 'getCustomRes' in fwk.");
                drawableD = null;
            }
            if (drawableD != null) {
                Log.i("IconFontCompatView", "drawable from theme app.");
                if (getChildCount() > 1) {
                    removeAllViews();
                }
                if (getChildCount() <= 0) {
                    a(context);
                    this.b.setImageDrawable(drawableD);
                } else if (getChildAt(0) instanceof ImageView) {
                    this.b.setImageDrawable(drawableD);
                } else {
                    removeAllViews();
                    a(context);
                    this.b.setImageDrawable(drawableD);
                }
            } else {
                Log.i("IconFontCompatView", "the resource:" + this.d + " has no drawable from theme app.");
            }
            if (drawableD != null) {
                return;
            }
        }
        Context context2 = getContext();
        if (this.e == null) {
            this.h = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.c);
                this.f3713a.setTextSize(this.i, this.f);
                this.f3713a.setTextColor(this.g);
            } else {
                removeAllViews();
                b(context2);
            }
        } else {
            b(context2);
        }
        this.h = 1;
    }

    public final void d(Context context, String str, int i) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.b.setImageResource(i);
        } else {
            this.b.setImageDrawable(VectorDrawableCompat.create(context.getResources(), i, context.getTheme()));
        }
    }

    public int getResType() {
        return this.h;
    }

    public String getTextResName() {
        return this.c;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        TextView textView = this.f3713a;
        if (textView != null) {
            textView.setEnabled(z10);
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
    }

    public void setImageResName(String str) {
        this.d = str;
        c();
    }

    public void setTextColor(@ColorInt int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        this.g = colorStateListValueOf;
        TextView textView = this.f3713a;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(@Nullable String str) {
        this.c = str;
        c();
    }

    public void setTextSize(float f) {
        this.f = f;
        TextView textView = this.f3713a;
        if (textView != null) {
            textView.setTextSize(f);
            this.i = 2;
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g = colorStateList;
        TextView textView = this.f3713a;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
