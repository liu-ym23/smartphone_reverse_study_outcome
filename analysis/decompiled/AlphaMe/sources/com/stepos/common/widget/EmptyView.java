package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
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
import com.stepos.alphame.R;
import i2.AbstractC0620a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EmptyView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f11606a;

    /* renamed from: b, reason: collision with root package name */
    public final LimitedWHLinearLayout f11607b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f11608c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f11609d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f11610e;

    /* renamed from: f, reason: collision with root package name */
    public final View f11611f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f11612g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11613h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11614i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f11615j;

    /* renamed from: k, reason: collision with root package name */
    public int f11616k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f11617l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f11618m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f11619n;

    public EmptyView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ArrayList arrayList;
        ArrayList arrayList2;
        super(context, attributeSet, 0);
        this.f11612g = context;
        ArrayList arrayList3 = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_image);
        this.f11606a = imageView;
        this.f11608c = (TextView) viewInflate.findViewById(R.id.empty_title);
        this.f11609d = (TextView) viewInflate.findViewById(R.id.empty_summary);
        this.f11610e = (LinearLayout) viewInflate.findViewById(R.id.empty_tips_panel);
        this.f11611f = viewInflate.findViewById(R.id.titleDivider);
        LimitedWHLinearLayout limitedWHLinearLayout = (LimitedWHLinearLayout) viewInflate.findViewById(R.id.content_panel);
        this.f11607b = limitedWHLinearLayout;
        this.f11615j = (RelativeLayout) viewInflate.findViewById(R.id.layout);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) limitedWHLinearLayout.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13021c, R.attr.StepOSCommon_EmptyViewStyle, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        limitedWHLinearLayout.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f11618m = typedArrayObtainStyledAttributes.getString(6);
        this.f11619n = typedArrayObtainStyledAttributes.getString(2);
        String string = typedArrayObtainStyledAttributes.getString(4);
        Context context2 = getContext();
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainStyledAttributes.getValue(5, typedValue)) {
            int i4 = typedValue.resourceId;
            if (i4 == 0) {
                throw new IllegalStateException("can't find the resourceId");
            }
            TypedArray typedArrayObtainTypedArray = context2.getResources().obtainTypedArray(i4);
            int length = typedArrayObtainTypedArray.length();
            ArrayList arrayList4 = new ArrayList(length);
            for (int i5 = 0; i5 < length; i5++) {
                arrayList4.add(typedArrayObtainTypedArray.getString(i5));
            }
            typedArrayObtainTypedArray.recycle();
            arrayList3 = arrayList4;
        }
        this.f11617l = arrayList3;
        this.f11614i = typedArrayObtainStyledAttributes.getBoolean(0, true);
        try {
            this.f11609d.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, R.style.TextAppearance_Small_EmptyView_Summary));
            this.f11608c.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(7, R.style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iF = m2.o.f(R.attr.colorPrimary, getContext());
        this.f11613h = androidx.core.content.b.a(getContext(), R.color.fd_sys_color_primary_blue);
        if (iF != 0) {
            this.f11613h = androidx.core.content.b.a(getContext(), iF);
        }
        setTitle(this.f11618m);
        setSummary(this.f11619n);
        if (string == null) {
            setTextOfTips(this.f11617l);
        } else {
            setTextOfTips(string);
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.f11618m);
        TextView textView = this.f11608c;
        if (!zIsEmpty && TextUtils.isEmpty(this.f11619n) && ((arrayList2 = this.f11617l) == null || arrayList2.size() == 0)) {
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.f11618m) || (arrayList = this.f11617l) == null || arrayList.size() <= 0) {
                return;
            }
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.mc_empty_title_margin_top);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EmptyView.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f11606a.getDrawable() != null) {
            return;
        }
        RelativeLayout relativeLayout = this.f11615j;
        this.f11616k = (int) (((RelativeLayout) relativeLayout.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.f11616k;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i4) {
        this.f11607b.setMaxWidth(i4);
    }

    public void setEmptyMarginBottom(int i4) {
        RelativeLayout relativeLayout = this.f11615j;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i4;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i4) {
        RelativeLayout relativeLayout = this.f11615j;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i4;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z4) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11607b.getLayoutParams();
        if (z4) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.f11612g.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.f11606a;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i4) {
        ImageView imageView = this.f11606a;
        if (imageView != null) {
            imageView.setImageResource(i4);
        }
    }

    public void setIsShowDot(boolean z4) throws Resources.NotFoundException {
        if (this.f11614i != z4) {
            this.f11614i = z4;
            setTextOfTips(this.f11617l);
        }
    }

    public void setSummary(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f11609d;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f11619n = charSequence;
        textView.setText(charSequence);
        textView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new A.e(1, this));
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setLinkTextColor(this.f11613h);
        textView.setVisibility(0);
        ArrayList arrayList = this.f11617l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f11611f.setVisibility(0);
    }

    public void setSummaryColor(int i4) {
        this.f11609d.setTextColor(i4);
    }

    public void setTextOfTips(String str) throws Resources.NotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        setTextOfTips(arrayList);
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f11608c;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f11618m = charSequence;
        textView.setText(charSequence);
        textView.setVisibility(0);
        ArrayList arrayList = this.f11617l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f11611f.setVisibility(0);
    }

    public void setTitleColor(int i4) {
        this.f11608c.setTextColor(i4);
    }

    public void setTitleTextSize(float f4) {
        this.f11608c.setTextSize(f4);
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        this.f11617l = arrayList == null ? new ArrayList<>() : arrayList;
        LinearLayout linearLayout = this.f11610e;
        linearLayout.removeAllViews();
        ArrayList arrayList2 = this.f11617l;
        View view = this.f11611f;
        if (arrayList2 != null && arrayList2.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            Context context = this.f11612g;
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_margin_Bottom);
            layoutParams2.topMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_top);
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_right);
            float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space);
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.mc_default_word_point);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(48);
                if (this.f11614i) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageDrawable(drawable);
                    linearLayout2.addView(imageView);
                }
                TextView textView = new TextView(context);
                textView.setLayoutParams(layoutParams3);
                textView.setTextAppearance(getContext(), R.style.TextAppearance_Small_EmptyView);
                textView.setText(next);
                textView.setLineSpacing(dimensionPixelSize, 1.0f);
                linearLayout2.addView(textView);
                linearLayout.addView(linearLayout2);
            }
            if (TextUtils.isEmpty(this.f11618m) && TextUtils.isEmpty(this.f11619n)) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }
}
