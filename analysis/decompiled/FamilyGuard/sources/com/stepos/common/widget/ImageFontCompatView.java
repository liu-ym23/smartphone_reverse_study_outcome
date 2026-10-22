package com.stepos.common.widget;

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
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageFontCompatView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f13989a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f13990b;

    /* renamed from: c, reason: collision with root package name */
    private String f13991c;

    /* renamed from: d, reason: collision with root package name */
    private String f13992d;

    /* renamed from: e, reason: collision with root package name */
    private String f13993e;

    /* renamed from: f, reason: collision with root package name */
    private float f13994f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f13995g;

    /* renamed from: h, reason: collision with root package name */
    private int f13996h;

    /* renamed from: i, reason: collision with root package name */
    private int f13997i;

    public ImageFontCompatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2069p);
    }

    private void a(Context context) {
        this.f13990b = new ImageView(context);
        addView(this.f13990b, new FrameLayout.LayoutParams(-2, -2));
    }

    private Typeface b(Context context, String str, int i5) {
        int i6 = i5 + 400;
        int iC = N1.c.c(i6);
        Context context2 = getContext();
        int i7 = H1.k.f2343a;
        if (!TextUtils.equals(context2.getString(i7), this.f13991c)) {
            Log.d("IconFontCompatView", "mTextResName " + this.f13991c + " weight " + iC);
        }
        if (iC == 100) {
            str = "StepOSIcon-Thin.otf";
        } else if (iC == 200) {
            str = "StepOSIcon-ExtraLight.otf";
        } else if (iC == 300) {
            if (TextUtils.equals(getContext().getString(i7), this.f13991c) || TextUtils.equals(getContext().getString(H1.k.f2344b), this.f13991c)) {
                i6 = i5 + 401;
            } else {
                str = "StepOSIcon-Light.otf";
            }
        }
        return N1.c.b(context, str, i6);
    }

    private boolean c(Context context) {
        int identifier = context.getResources().getIdentifier(this.f13992d, "drawable", context.getPackageName());
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
        this.f13996h = 2;
        return true;
    }

    private void d(Context context, String str, int i5) {
        a(context);
        i(context, str, i5);
    }

    private void e(Context context) {
        if (this.f13993e == null) {
            this.f13996h = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.f13991c);
                this.f13989a.setTextSize(this.f13997i, this.f13994f);
                this.f13989a.setTextColor(this.f13995g);
            } else {
                removeAllViews();
                f(context);
            }
        } else {
            f(context);
        }
        this.f13996h = 1;
    }

    private void f(Context context) {
        this.f13989a = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            this.f13989a.setTypeface(b(context, this.f13993e, configuration.fontWeightAdjustment));
        }
        addView(this.f13989a, layoutParams);
        this.f13989a.setText(this.f13991c);
        this.f13989a.setTextSize(this.f13997i, this.f13994f);
        this.f13989a.setTextColor(this.f13995g);
        this.f13989a.setMovementMethod(null);
        this.f13989a.setVerticalScrollBarEnabled(false);
        this.f13989a.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f13989a.setScaleX(-1.0f);
        }
    }

    private boolean g(Context context) {
        Drawable drawableA;
        try {
            drawableA = N1.m.a(context, this.f13992d);
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
                this.f13990b.setImageDrawable(drawableA);
            } else if (getChildAt(0) instanceof ImageView) {
                this.f13990b.setImageDrawable(drawableA);
            } else {
                removeAllViews();
                a(context);
                this.f13990b.setImageDrawable(drawableA);
            }
        } else {
            Log.i("IconFontCompatView", "the resource:" + this.f13992d + " has no drawable from theme app.");
        }
        return drawableA != null;
    }

    private void h() {
        if (this.f13992d == null || !c(getContext())) {
            e(getContext());
        }
    }

    private void i(Context context, String str, int i5) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.f13990b.setImageResource(i5);
        } else {
            this.f13990b.setImageDrawable(androidx.vectordrawable.graphics.drawable.f.b(context.getResources(), i5, context.getTheme()));
        }
    }

    public int getResType() {
        return this.f13996h;
    }

    public String getTextResName() {
        return this.f13991c;
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        TextView textView = this.f13989a;
        if (textView != null) {
            textView.setEnabled(z5);
        }
        ImageView imageView = this.f13990b;
        if (imageView != null) {
            imageView.setEnabled(z5);
        }
    }

    public void setImageResName(String str) {
        this.f13992d = str;
        h();
    }

    public void setTextColor(int i5) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i5);
        this.f13995g = colorStateListValueOf;
        TextView textView = this.f13989a;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(String str) {
        this.f13991c = str;
        h();
    }

    public void setTextSize(float f5) {
        this.f13994f = f5;
        TextView textView = this.f13989a;
        if (textView != null) {
            textView.setTextSize(f5);
            this.f13997i = 2;
        }
    }

    public ImageFontCompatView(Context context, AttributeSet attributeSet, int i5) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, i5);
        this.f13993e = "ImageFont.ttf";
        this.f13994f = 25.0f;
        this.f13996h = -1;
        this.f13997i = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2447K1, i5, 0);
        this.f13991c = typedArrayObtainStyledAttributes.getString(H1.m.f2471O1);
        this.f13992d = typedArrayObtainStyledAttributes.getString(H1.m.f2465N1);
        int i6 = H1.m.f2459M1;
        if (typedArrayObtainStyledAttributes.hasValue(i6) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i6)) != null) {
            this.f13997i = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.f13994f = dimension;
            int i7 = this.f13997i;
            if (i7 == 2) {
                this.f13994f = N1.i.j(getContext(), dimension);
            } else if (i7 == 1) {
                this.f13994f = N1.i.i(getContext(), dimension);
            }
        }
        this.f13995g = typedArrayObtainStyledAttributes.getColorStateList(H1.m.f2453L1);
        typedArrayObtainStyledAttributes.recycle();
        h();
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f13995g = colorStateList;
        TextView textView = this.f13989a;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
