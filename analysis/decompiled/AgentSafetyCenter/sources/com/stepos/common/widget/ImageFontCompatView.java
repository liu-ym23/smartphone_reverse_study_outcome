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
import com.stepos.agentsafetycenter.R;
import d5.o;
import d5.p;
import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ImageFontCompatView extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public TextView f2599c;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f2600f;

    /* renamed from: g, reason: collision with root package name */
    public String f2601g;

    /* renamed from: h, reason: collision with root package name */
    public String f2602h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public float f2603j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f2604k;

    /* renamed from: l, reason: collision with root package name */
    public int f2605l;

    /* renamed from: m, reason: collision with root package name */
    public int f2606m;

    public ImageFontCompatView(Context context, AttributeSet attributeSet, int i) {
        TypedValue typedValuePeekValue;
        super(context, attributeSet, i);
        this.i = "ImageFont.ttf";
        this.f2603j = 25.0f;
        this.f2605l = -1;
        this.f2606m = 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.f10201d, i, 0);
        this.f2601g = typedArrayObtainStyledAttributes.getString(3);
        this.f2602h = typedArrayObtainStyledAttributes.getString(2);
        if (typedArrayObtainStyledAttributes.hasValue(1) && (typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(1)) != null) {
            this.f2606m = typedValuePeekValue.getComplexUnit();
            float dimension = typedValuePeekValue.getDimension(getResources().getDisplayMetrics());
            this.f2603j = dimension;
            int i3 = this.f2606m;
            if (i3 == 2) {
                this.f2603j = (int) ((dimension / getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
            } else if (i3 == 1) {
                this.f2603j = dimension / getContext().getResources().getDisplayMetrics().density;
            }
        }
        this.f2604k = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    public final void a(Context context) {
        this.f2600f = new ImageView(context);
        addView(this.f2600f, new FrameLayout.LayoutParams(-2, -2));
    }

    public final void b(Context context) {
        String str;
        Typeface typefaceCreateFromAsset;
        this.f2599c = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration != null) {
            int i = configuration.fontWeightAdjustment;
            int i3 = i + 400;
            SparseArray sparseArray = u9.b.f14260a;
            int i10 = i3 < 150 ? 100 : i3 < 250 ? 200 : i3 < 350 ? 300 : i3 < 450 ? 400 : i3 < 550 ? 500 : i3 < 650 ? 600 : i3 < 750 ? 700 : i3 < 850 ? 800 : 900;
            if (!TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f2601g)) {
                Log.d("IconFontCompatView", "mTextResName " + this.f2601g + " weight " + i10);
            }
            if (i10 == 100) {
                str = "StepOSIcon-Thin.otf";
            } else if (i10 == 200) {
                str = "StepOSIcon-ExtraLight.otf";
            } else {
                String str2 = this.i;
                if (i10 != 300) {
                    str = str2;
                } else if (TextUtils.equals(getContext().getString(R.string.icon_font_more_search), this.f2601g) || TextUtils.equals(getContext().getString(R.string.icon_font_more_voice), this.f2601g)) {
                    i3 = i + 401;
                    str = str2;
                } else {
                    str = "StepOSIcon-Light.otf";
                }
            }
            SparseArray sparseArray2 = u9.b.f14260a;
            if (sparseArray2.get(i3) == null) {
                try {
                    typefaceCreateFromAsset = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i3, 0)).build();
                } catch (IOException e10) {
                    Log.e("FontLoader", "has an error:" + e10);
                    typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str);
                }
                sparseArray2.put(i3, typefaceCreateFromAsset);
            } else {
                typefaceCreateFromAsset = (Typeface) sparseArray2.get(i3);
            }
            this.f2599c.setTypeface(typefaceCreateFromAsset);
        }
        addView(this.f2599c, layoutParams);
        this.f2599c.setText(this.f2601g);
        this.f2599c.setTextSize(this.f2606m, this.f2603j);
        this.f2599c.setTextColor(this.f2604k);
        this.f2599c.setMovementMethod(null);
        this.f2599c.setVerticalScrollBarEnabled(false);
        this.f2599c.setHorizontalScrollBarEnabled(false);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f2599c.setScaleX(-1.0f);
        }
    }

    public final void c() {
        Drawable drawableK;
        if (this.f2602h != null) {
            Context context = getContext();
            int identifier = context.getResources().getIdentifier(this.f2602h, "drawable", context.getPackageName());
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
                this.f2605l = 2;
                return;
            }
            try {
                drawableK = t2.a.k(context, this.f2602h);
            } catch (Exception | NoSuchMethodError unused) {
                Log.w("IconFontCompatView", "has no such method 'getCustomRes' in fwk.");
                drawableK = null;
            }
            if (drawableK != null) {
                Log.i("IconFontCompatView", "drawable from theme app.");
                if (getChildCount() > 1) {
                    removeAllViews();
                }
                if (getChildCount() <= 0) {
                    a(context);
                    this.f2600f.setImageDrawable(drawableK);
                } else if (getChildAt(0) instanceof ImageView) {
                    this.f2600f.setImageDrawable(drawableK);
                } else {
                    removeAllViews();
                    a(context);
                    this.f2600f.setImageDrawable(drawableK);
                }
            } else {
                Log.i("IconFontCompatView", "the resource:" + this.f2602h + " has no drawable from theme app.");
            }
            if (drawableK != null) {
                return;
            }
        }
        Context context2 = getContext();
        if (this.i == null) {
            this.f2605l = -1;
            return;
        }
        if (getChildCount() > 1) {
            removeAllViews();
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setText(this.f2601g);
                this.f2599c.setTextSize(this.f2606m, this.f2603j);
                this.f2599c.setTextColor(this.f2604k);
            } else {
                removeAllViews();
                b(context2);
            }
        } else {
            b(context2);
        }
        this.f2605l = 1;
    }

    public final void d(Context context, String str, int i) {
        if ("image/png".equals(str) || "image/jpeg".equals(str)) {
            this.f2600f.setImageResource(i);
            return;
        }
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        p pVar = new p();
        ThreadLocal threadLocal = e3.k.f3478a;
        pVar.f3209c = resources.getDrawable(i, theme);
        new o(pVar.f3209c.getConstantState());
        this.f2600f.setImageDrawable(pVar);
    }

    public int getResType() {
        return this.f2605l;
    }

    public String getTextResName() {
        return this.f2601g;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        TextView textView = this.f2599c;
        if (textView != null) {
            textView.setEnabled(z10);
        }
        ImageView imageView = this.f2600f;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
    }

    public void setImageResName(String str) {
        this.f2602h = str;
        c();
    }

    public void setTextColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        this.f2604k = colorStateListValueOf;
        TextView textView = this.f2599c;
        if (textView != null) {
            textView.setTextColor(colorStateListValueOf);
        }
    }

    public void setTextResName(String str) {
        this.f2601g = str;
        c();
    }

    public void setTextSize(float f5) {
        this.f2603j = f5;
        TextView textView = this.f2599c;
        if (textView != null) {
            textView.setTextSize(f5);
            this.f2606m = 2;
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f2604k = colorStateList;
        TextView textView = this.f2599c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public ImageFontCompatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.steposIconFontCompatViewStyle);
    }

    public ImageFontCompatView(Context context) {
        this(context, null);
    }
}
