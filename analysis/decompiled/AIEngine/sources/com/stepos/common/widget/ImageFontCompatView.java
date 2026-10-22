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
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import e2.f;
import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ImageFontCompatView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f6908a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f6909b;

    /* renamed from: c, reason: collision with root package name */
    public String f6910c;

    /* renamed from: d, reason: collision with root package name */
    public String f6911d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6912e;
    public float h;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f6913j;

    /* renamed from: k, reason: collision with root package name */
    public int f6914k;

    /* renamed from: l, reason: collision with root package name */
    public int f6915l;

    public ImageFontCompatView(Context context, AttributeSet attributeSet) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, R.attr.steposIconFontCompatViewStyle);
        this.f6912e = "ImageFont.ttf";
        this.h = 25.0f;
        this.f6914k = -1;
        this.f6915l = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9079e, R.attr.steposIconFontCompatViewStyle, 0);
        this.f6910c = typedArrayObtainStyledAttributes.getString(3);
        this.f6911d = typedArrayObtainStyledAttributes.getString(2);
        if (typedArrayObtainStyledAttributes.hasValue(1) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(1)) != null) {
            this.f6915l = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.h = dimension;
            int i10 = this.f6915l;
            if (i10 == 2) {
                this.h = (int) ((dimension / getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
            } else if (i10 == 1) {
                this.h = dimension / getContext().getResources().getDisplayMetrics().density;
            }
        }
        this.f6913j = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public final void a(Context context) {
        this.f6909b = new ImageView(context);
        addView(this.f6909b, new FrameLayout.LayoutParams(-2, -2));
    }

    public final void b(Context context) {
        String str;
        Typeface typefaceCreateFromAsset;
        this.f6908a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            int i10 = Build.VERSION.SDK_INT >= 31 ? configuration.fontWeightAdjustment : 0;
            int i11 = i10 + AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS;
            SparseArray<Typeface> sparseArray = l8.b.f10349a;
            int i12 = i11 < 150 ? 100 : i11 < 250 ? 200 : i11 < 350 ? 300 : i11 < 450 ? AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS : i11 < 550 ? 500 : i11 < 650 ? 600 : i11 < 750 ? 700 : i11 < 850 ? EngineRuntimeConfig.MIN_ABSOLUTE_TARGET_MB : 900;
            if (!TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f6910c)) {
                Log.d("IconFontCompatView", "mTextResName " + this.f6910c + " weight " + i12);
            }
            if (i12 == 100) {
                str = "StepOSIcon-Thin.otf";
            } else if (i12 == 200) {
                str = "StepOSIcon-ExtraLight.otf";
            } else {
                String str2 = this.f6912e;
                if (i12 != 300) {
                    str = str2;
                } else if (TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f6910c) || TextUtils.equals(getContext().getString(R.string.icon_font_more_voice), this.f6910c)) {
                    i11 = i10 + 401;
                    str = str2;
                } else {
                    str = "StepOSIcon-Light.otf";
                }
            }
            SparseArray<Typeface> sparseArray2 = l8.b.f10349a;
            if (sparseArray2.get(i11) == null) {
                try {
                    typefaceCreateFromAsset = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i11, 0)).build();
                } catch (IOException e10) {
                    Log.e("FontLoader", "has an error:" + e10);
                    typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str);
                }
                sparseArray2.put(i11, typefaceCreateFromAsset);
            } else {
                typefaceCreateFromAsset = sparseArray2.get(i11);
            }
            this.f6908a.setTypeface(typefaceCreateFromAsset);
        }
        addView(this.f6908a, layoutParams);
        this.f6908a.setText(this.f6910c);
        this.f6908a.setTextSize(this.f6915l, this.h);
        this.f6908a.setTextColor(this.f6913j);
        this.f6908a.setMovementMethod(null);
        this.f6908a.setVerticalScrollBarEnabled(false);
        this.f6908a.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f6908a.setScaleX(-1.0f);
        }
    }

    public final void c() {
        Drawable drawableA;
        if (this.f6911d != null) {
            Context context = getContext();
            int identifier = context.getResources().getIdentifier(this.f6911d, "drawable", context.getPackageName());
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
                this.f6914k = 2;
                return;
            }
            try {
                drawableA = l8.j.a(context, this.f6911d);
            } catch (Exception | NoSuchMethodError unused) {
                Log.w("IconFontCompatView", "has no such method 'getCustomRes' in fwk.");
                drawableA = null;
            }
            if (drawableA != null) {
                Log.i("IconFontCompatView", "drawable from theme app.");
                if (getChildCount() > 1) {
                    removeAllViews();
                }
                if (getChildCount() <= 0) {
                    a(context);
                    this.f6909b.setImageDrawable(drawableA);
                } else if (getChildAt(0) instanceof ImageView) {
                    this.f6909b.setImageDrawable(drawableA);
                } else {
                    removeAllViews();
                    a(context);
                    this.f6909b.setImageDrawable(drawableA);
                }
            } else {
                Log.i("IconFontCompatView", "the resource:" + this.f6911d + " has no drawable from theme app.");
            }
            if (drawableA != null) {
                return;
            }
        }
        Context context2 = getContext();
        if (this.f6912e == null) {
            this.f6914k = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.f6910c);
                this.f6908a.setTextSize(this.f6915l, this.h);
                this.f6908a.setTextColor(this.f6913j);
            } else {
                removeAllViews();
                b(context2);
            }
        } else {
            b(context2);
        }
        this.f6914k = 1;
    }

    public final void d(Context context, String str, int i10) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.f6909b.setImageResource(i10);
            return;
        }
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        e2.f fVar = new e2.f();
        fVar.f8538a = m0.f.a(resources, i10, theme);
        new f.h(fVar.f8538a.getConstantState());
        this.f6909b.setImageDrawable(fVar);
    }

    public int getResType() {
        return this.f6914k;
    }

    public String getTextResName() {
        return this.f6910c;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        TextView textView = this.f6908a;
        if (textView != null) {
            textView.setEnabled(z);
        }
        ImageView imageView = this.f6909b;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    public void setImageResName(String str) {
        this.f6911d = str;
        c();
    }

    public void setTextColor(int i10) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
        this.f6913j = colorStateListValueOf;
        TextView textView = this.f6908a;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(String str) {
        this.f6910c = str;
        c();
    }

    public void setTextSize(float f8) {
        this.h = f8;
        TextView textView = this.f6908a;
        if (textView != null) {
            textView.setTextSize(f8);
            this.f6915l = 2;
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f6913j = colorStateList;
        TextView textView = this.f6908a;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
