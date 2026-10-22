package com.stepos.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.R;
import i2.AbstractC0620a;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageFontCompatView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f11632a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f11633b;

    /* renamed from: c, reason: collision with root package name */
    public String f11634c;

    /* renamed from: d, reason: collision with root package name */
    public String f11635d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11636e;

    /* renamed from: f, reason: collision with root package name */
    public float f11637f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f11638g;

    /* renamed from: h, reason: collision with root package name */
    public int f11639h;

    /* renamed from: i, reason: collision with root package name */
    public int f11640i;

    public ImageFontCompatView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, R.attr.steposIconFontCompatViewStyle);
        this.f11636e = "ImageFont.ttf";
        this.f11637f = 25.0f;
        this.f11639h = -1;
        this.f11640i = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13023e, R.attr.steposIconFontCompatViewStyle, 0);
        this.f11634c = typedArrayObtainStyledAttributes.getString(3);
        this.f11635d = typedArrayObtainStyledAttributes.getString(2);
        if (typedArrayObtainStyledAttributes.hasValue(1) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(1)) != null) {
            this.f11640i = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.f11637f = dimension;
            int i4 = this.f11640i;
            if (i4 == 2) {
                this.f11637f = (int) ((dimension / getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
            } else if (i4 == 1) {
                this.f11637f = dimension / getContext().getResources().getDisplayMetrics().density;
            }
        }
        this.f11638g = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public final void a(Context context) {
        this.f11633b = new ImageView(context);
        addView(this.f11633b, new FrameLayout.LayoutParams(-2, -2));
    }

    public final void b(Context context) {
        String str;
        Typeface typefaceCreateFromAsset;
        this.f11632a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            int i4 = configuration.fontWeightAdjustment;
            int i5 = i4 + UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE;
            SparseArray sparseArray = m2.c.f13565a;
            int i6 = i5 < 150 ? 100 : i5 < 250 ? 200 : i5 < 350 ? 300 : i5 < 450 ? UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE : i5 < 550 ? 500 : i5 < 650 ? UIMsg.MSG_MAP_PANO_DATA : i5 < 750 ? 700 : i5 < 850 ? 800 : 900;
            if (!TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f11634c)) {
                Log.d("IconFontCompatView", "mTextResName " + this.f11634c + " weight " + i6);
            }
            if (i6 == 100) {
                str = "StepOSIcon-Thin.otf";
            } else if (i6 == 200) {
                str = "StepOSIcon-ExtraLight.otf";
            } else {
                String str2 = this.f11636e;
                if (i6 != 300) {
                    str = str2;
                } else if (TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f11634c) || TextUtils.equals(getContext().getString(R.string.icon_font_more_voice), this.f11634c)) {
                    i5 = i4 + 401;
                    str = str2;
                } else {
                    str = "StepOSIcon-Light.otf";
                }
            }
            SparseArray sparseArray2 = m2.c.f13565a;
            if (sparseArray2.get(i5) == null) {
                try {
                    typefaceCreateFromAsset = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i5, 0)).build();
                } catch (IOException e4) {
                    Log.e("FontLoader", "has an error:" + e4);
                    typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str);
                }
                sparseArray2.put(i5, typefaceCreateFromAsset);
            } else {
                typefaceCreateFromAsset = (Typeface) sparseArray2.get(i5);
            }
            this.f11632a.setTypeface(typefaceCreateFromAsset);
        }
        addView(this.f11632a, layoutParams);
        this.f11632a.setText(this.f11634c);
        this.f11632a.setTextSize(this.f11640i, this.f11637f);
        this.f11632a.setTextColor(this.f11638g);
        this.f11632a.setMovementMethod(null);
        this.f11632a.setVerticalScrollBarEnabled(false);
        this.f11632a.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f11632a.setScaleX(-1.0f);
        }
    }

    public final void c() {
        Drawable drawableD;
        if (this.f11635d != null) {
            Context context = getContext();
            int identifier = context.getResources().getIdentifier(this.f11635d, "drawable", context.getPackageName());
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
                this.f11639h = 2;
                return;
            }
            try {
                drawableD = m2.o.d(context, this.f11635d);
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
                    this.f11633b.setImageDrawable(drawableD);
                } else if (getChildAt(0) instanceof ImageView) {
                    this.f11633b.setImageDrawable(drawableD);
                } else {
                    removeAllViews();
                    a(context);
                    this.f11633b.setImageDrawable(drawableD);
                }
            } else {
                Log.i("IconFontCompatView", "the resource:" + this.f11635d + " has no drawable from theme app.");
            }
            if (drawableD != null) {
                return;
            }
        }
        Context context2 = getContext();
        if (this.f11636e == null) {
            this.f11639h = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.f11634c);
                this.f11632a.setTextSize(this.f11640i, this.f11637f);
                this.f11632a.setTextColor(this.f11638g);
            } else {
                removeAllViews();
                b(context2);
            }
        } else {
            b(context2);
        }
        this.f11639h = 1;
    }

    public final void d(Context context, String str, int i4) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.f11633b.setImageResource(i4);
            return;
        }
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        p0.o oVar = new p0.o();
        ThreadLocal threadLocal = C.o.f272a;
        oVar.f13857a = C.j.a(resources, i4, theme);
        new p0.n(oVar.f13857a.getConstantState());
        this.f11633b.setImageDrawable(oVar);
    }

    public int getResType() {
        return this.f11639h;
    }

    public String getTextResName() {
        return this.f11634c;
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        TextView textView = this.f11632a;
        if (textView != null) {
            textView.setEnabled(z4);
        }
        ImageView imageView = this.f11633b;
        if (imageView != null) {
            imageView.setEnabled(z4);
        }
    }

    public void setImageResName(String str) {
        this.f11635d = str;
        c();
    }

    public void setTextColor(@ColorInt int i4) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i4);
        this.f11638g = colorStateListValueOf;
        TextView textView = this.f11632a;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(@Nullable String str) {
        this.f11634c = str;
        c();
    }

    public void setTextSize(float f4) {
        this.f11637f = f4;
        TextView textView = this.f11632a;
        if (textView != null) {
            textView.setTextSize(f4);
            this.f11640i = 2;
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f11638g = colorStateList;
        TextView textView = this.f11632a;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
