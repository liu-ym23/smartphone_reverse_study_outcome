package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EmptyView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13972a;

    /* renamed from: b, reason: collision with root package name */
    private LimitedWHLinearLayout f13973b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f13974c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f13975d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f13976e;

    /* renamed from: f, reason: collision with root package name */
    private View f13977f;

    /* renamed from: g, reason: collision with root package name */
    private Context f13978g;

    /* renamed from: h, reason: collision with root package name */
    private int f13979h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13980i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13981j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout f13982k;

    /* renamed from: l, reason: collision with root package name */
    private int f13983l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f13984m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f13985n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f13986o;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: com.stepos.common.widget.EmptyView$a$a, reason: collision with other inner class name */
        class RunnableC0175a implements Runnable {
            RunnableC0175a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.f13975d.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            EmptyView.this.f13975d.getViewTreeObserver().removeOnPreDrawListener(this);
            EmptyView.this.f13975d.post(new RunnableC0175a());
            return true;
        }
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        if (!TextUtils.isEmpty(this.f13985n) && TextUtils.isEmpty(this.f13986o) && ((arrayList2 = this.f13984m) == null || arrayList2.size() == 0)) {
            TextView textView = this.f13974c;
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(H1.f.f2151m), this.f13974c.getPaddingRight(), this.f13974c.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.f13985n) || (arrayList = this.f13984m) == null || arrayList.size() <= 0) {
                return;
            }
            ((LinearLayout.LayoutParams) this.f13974c.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(H1.f.f2153o);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EmptyView.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f13972a.getDrawable() != null) {
            return;
        }
        this.f13983l = (int) (((RelativeLayout) this.f13982k.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13982k.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.f13983l;
        this.f13982k.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i5) {
        this.f13973b.setMaxWidth(i5);
    }

    public void setEmptyMarginBottom(int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13982k.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i5;
        this.f13982k.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i5) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13982k.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i5;
        this.f13982k.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z5) {
        this.f13980i = z5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13973b.getLayoutParams();
        if (z5) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.f13978g.getResources().getDimensionPixelSize(H1.f.f2160v);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.f13972a;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i5) {
        ImageView imageView = this.f13972a;
        if (imageView != null) {
            imageView.setImageResource(i5);
        }
    }

    public void setIsShowDot(boolean z5) throws Resources.NotFoundException {
        if (this.f13981j != z5) {
            this.f13981j = z5;
            setTextOfTips(this.f13984m);
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f13975d.setVisibility(8);
            return;
        }
        this.f13986o = charSequence;
        this.f13975d.setText(charSequence);
        this.f13975d.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = this.f13975d.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new a());
        } else {
            this.f13975d.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.f13975d.setLinkTextColor(this.f13979h);
        this.f13975d.setVisibility(0);
        ArrayList<String> arrayList = this.f13984m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f13977f.setVisibility(0);
    }

    public void setSummaryColor(int i5) {
        this.f13975d.setTextColor(i5);
    }

    public void setTextOfTips(String str) throws Resources.NotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        setTextOfTips(arrayList);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f13974c.setVisibility(8);
            return;
        }
        this.f13985n = charSequence;
        this.f13974c.setText(charSequence);
        this.f13974c.setVisibility(0);
        ArrayList<String> arrayList = this.f13984m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f13977f.setVisibility(0);
    }

    public void setTitleColor(int i5) {
        this.f13974c.setTextColor(i5);
    }

    public void setTitleTextSize(float f5) {
        this.f13974c.setTextSize(f5);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        this.f13978g = context;
        View viewInflate = LayoutInflater.from(context).inflate(H1.i.f2314e, (ViewGroup) null);
        this.f13972a = (ImageView) viewInflate.findViewById(H1.h.f2271r);
        this.f13974c = (TextView) viewInflate.findViewById(H1.h.f2277u);
        this.f13975d = (TextView) viewInflate.findViewById(H1.h.f2273s);
        this.f13976e = (LinearLayout) viewInflate.findViewById(H1.h.f2275t);
        this.f13977f = viewInflate.findViewById(H1.h.f2278u0);
        this.f13973b = (LimitedWHLinearLayout) viewInflate.findViewById(H1.h.f2257k);
        this.f13982k = (RelativeLayout) viewInflate.findViewById(H1.h.f2285y);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f13972a.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f13973b.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2476P0, H1.c.f2055b, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2530Y0, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2536Z0, 0);
        this.f13973b.setMaxWidth(this.f13978g.getResources().getDimensionPixelSize(H1.f.f2148j));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(H1.m.f2488R0);
        if (drawable != null) {
            this.f13972a.setImageDrawable(drawable);
        }
        this.f13985n = typedArrayObtainStyledAttributes.getString(H1.m.f2518W0);
        this.f13986o = typedArrayObtainStyledAttributes.getString(H1.m.f2494S0);
        String string = typedArrayObtainStyledAttributes.getString(H1.m.f2506U0);
        this.f13984m = N1.i.f(getContext(), typedArrayObtainStyledAttributes, H1.m.f2512V0);
        this.f13981j = typedArrayObtainStyledAttributes.getBoolean(H1.m.f2482Q0, true);
        try {
            this.f13975d.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(H1.m.f2500T0, H1.l.f2380l));
            this.f13974c.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(H1.m.f2524X0, H1.l.f2381m));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iD = N1.i.d(H1.c.f2066m, getContext());
        this.f13979h = androidx.core.content.a.c(getContext(), H1.e.f2084f);
        if (iD != 0) {
            this.f13979h = androidx.core.content.a.c(getContext(), iD);
        }
        setTitle(this.f13985n);
        setSummary(this.f13986o);
        if (string == null) {
            setTextOfTips(this.f13984m);
        } else {
            setTextOfTips(string);
        }
        b();
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        this.f13984m = arrayList == null ? new ArrayList<>() : arrayList;
        this.f13976e.removeAllViews();
        ArrayList<String> arrayList2 = this.f13984m;
        if (arrayList2 != null && arrayList2.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.f13978g.getResources().getDimensionPixelSize(H1.f.f2152n);
            layoutParams2.topMargin = this.f13978g.getResources().getDimensionPixelSize(H1.f.f2150l);
            layoutParams2.rightMargin = this.f13978g.getResources().getDimensionPixelSize(H1.f.f2149k);
            float dimensionPixelSize = this.f13978g.getResources().getDimensionPixelSize(H1.f.f2151m);
            Drawable drawable = getContext().getResources().getDrawable(H1.g.f2188d);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                String str = arrayList.get(i5);
                i5++;
                String str2 = str;
                LinearLayout linearLayout = new LinearLayout(this.f13978g);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(48);
                if (this.f13981j) {
                    ImageView imageView = new ImageView(this.f13978g);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageDrawable(drawable);
                    linearLayout.addView(imageView);
                }
                TextView textView = new TextView(this.f13978g);
                textView.setLayoutParams(layoutParams3);
                textView.setTextAppearance(getContext(), H1.l.f2379k);
                textView.setText(str2);
                textView.setLineSpacing(dimensionPixelSize, 1.0f);
                linearLayout.addView(textView);
                this.f13976e.addView(linearLayout);
            }
            if (TextUtils.isEmpty(this.f13985n) && TextUtils.isEmpty(this.f13986o)) {
                return;
            }
            this.f13977f.setVisibility(0);
            return;
        }
        this.f13977f.setVisibility(8);
    }
}
