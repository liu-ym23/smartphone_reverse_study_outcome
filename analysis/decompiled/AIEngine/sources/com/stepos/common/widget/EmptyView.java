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
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EmptyView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f6878a;

    /* renamed from: b, reason: collision with root package name */
    public final LimitedWHLinearLayout f6879b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6880c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6881d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f6882e;
    public final View h;

    /* renamed from: j, reason: collision with root package name */
    public final Context f6883j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6884k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6885l;

    /* renamed from: m, reason: collision with root package name */
    public final RelativeLayout f6886m;

    /* renamed from: n, reason: collision with root package name */
    public int f6887n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<String> f6888o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f6889p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f6890q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.common.widget.EmptyView$a$a, reason: collision with other inner class name */
        public class RunnableC0047a implements Runnable {
            public RunnableC0047a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                EmptyView.this.f6881d.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TextView textView = EmptyView.this.f6881d;
            textView.getViewTreeObserver().removeOnPreDrawListener(this);
            textView.post(new RunnableC0047a());
            return true;
        }
    }

    public EmptyView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        super(context, attributeSet, 0);
        this.f6883j = context;
        ArrayList<String> arrayList3 = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_image);
        this.f6878a = imageView;
        this.f6880c = (TextView) viewInflate.findViewById(R.id.empty_title);
        this.f6881d = (TextView) viewInflate.findViewById(R.id.empty_summary);
        this.f6882e = (LinearLayout) viewInflate.findViewById(R.id.empty_tips_panel);
        this.h = viewInflate.findViewById(R.id.titleDivider);
        LimitedWHLinearLayout limitedWHLinearLayout = (LimitedWHLinearLayout) viewInflate.findViewById(R.id.content_panel);
        this.f6879b = limitedWHLinearLayout;
        this.f6886m = (RelativeLayout) viewInflate.findViewById(R.id.layout);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) limitedWHLinearLayout.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9077c, R.attr.StepOSCommon_EmptyViewStyle, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        limitedWHLinearLayout.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f6889p = typedArrayObtainStyledAttributes.getString(6);
        this.f6890q = typedArrayObtainStyledAttributes.getString(2);
        String string = typedArrayObtainStyledAttributes.getString(4);
        Context context2 = getContext();
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainStyledAttributes.getValue(5, typedValue)) {
            int i10 = typedValue.resourceId;
            if (i10 == 0) {
                throw new IllegalStateException("can't find the resourceId");
            }
            TypedArray typedArrayObtainTypedArray = context2.getResources().obtainTypedArray(i10);
            int length = typedArrayObtainTypedArray.length();
            ArrayList<String> arrayList4 = new ArrayList<>(length);
            for (int i11 = 0; i11 < length; i11++) {
                arrayList4.add(typedArrayObtainTypedArray.getString(i11));
            }
            typedArrayObtainTypedArray.recycle();
            arrayList3 = arrayList4;
        }
        this.f6888o = arrayList3;
        this.f6885l = typedArrayObtainStyledAttributes.getBoolean(0, true);
        try {
            this.f6881d.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, R.style.TextAppearance_Small_EmptyView_Summary));
            this.f6880c.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(7, R.style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iB = l8.f.b(R.attr.colorPrimary, getContext());
        this.f6884k = getContext().getColor(R.color.fd_sys_color_primary_blue);
        if (iB != 0) {
            this.f6884k = getContext().getColor(iB);
        }
        setTitle(this.f6889p);
        setSummary(this.f6890q);
        if (string == null) {
            setTextOfTips(this.f6888o);
        } else {
            setTextOfTips(string);
        }
        TextView textView = this.f6880c;
        if (!TextUtils.isEmpty(this.f6889p) && TextUtils.isEmpty(this.f6890q) && ((arrayList2 = this.f6888o) == null || arrayList2.size() == 0)) {
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.f6889p) || (arrayList = this.f6888o) == null || arrayList.size() <= 0) {
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
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f6878a.getDrawable() != null) {
            return;
        }
        RelativeLayout relativeLayout = this.f6886m;
        this.f6887n = (int) (((RelativeLayout) relativeLayout.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.f6887n;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i10) {
        this.f6879b.setMaxWidth(i10);
    }

    public void setEmptyMarginBottom(int i10) {
        RelativeLayout relativeLayout = this.f6886m;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i10;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i10) {
        RelativeLayout relativeLayout = this.f6886m;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i10;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6879b.getLayoutParams();
        if (z) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.f6883j.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.f6878a;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i10) {
        ImageView imageView = this.f6878a;
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setIsShowDot(boolean z) throws Resources.NotFoundException {
        if (this.f6885l != z) {
            this.f6885l = z;
            setTextOfTips(this.f6888o);
        }
    }

    public void setSummary(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f6881d;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f6890q = charSequence;
        textView.setText(charSequence);
        textView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new a());
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setLinkTextColor(this.f6884k);
        textView.setVisibility(0);
        ArrayList<String> arrayList = this.f6888o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.h.setVisibility(0);
    }

    public void setSummaryColor(int i10) {
        this.f6881d.setTextColor(i10);
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
        TextView textView = this.f6880c;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f6889p = charSequence;
        textView.setText(charSequence);
        textView.setVisibility(0);
        ArrayList<String> arrayList = this.f6888o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.h.setVisibility(0);
    }

    public void setTitleColor(int i10) {
        this.f6880c.setTextColor(i10);
    }

    public void setTitleTextSize(float f8) {
        this.f6880c.setTextSize(f8);
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        ArrayList<String> arrayList2 = arrayList;
        this.f6888o = arrayList2 == null ? new ArrayList<>() : arrayList2;
        LinearLayout linearLayout = this.f6882e;
        linearLayout.removeAllViews();
        ArrayList<String> arrayList3 = this.f6888o;
        View view = this.h;
        if (arrayList3 != null && arrayList3.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            Context context = this.f6883j;
            layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_margin_Bottom);
            layoutParams2.topMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_top);
            layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_right);
            float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space);
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.mc_default_word_point);
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                String str = arrayList2.get(i11);
                i11++;
                String str2 = str;
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout2.setOrientation(i10);
                linearLayout2.setGravity(48);
                if (this.f6885l) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageDrawable(drawable);
                    linearLayout2.addView(imageView);
                }
                TextView textView = new TextView(context);
                textView.setLayoutParams(layoutParams3);
                textView.setTextAppearance(getContext(), R.style.TextAppearance_Small_EmptyView);
                textView.setText(str2);
                textView.setLineSpacing(dimensionPixelSize, 1.0f);
                linearLayout2.addView(textView);
                linearLayout.addView(linearLayout2);
                arrayList2 = arrayList;
                i10 = 0;
            }
            if (TextUtils.isEmpty(this.f6889p) && TextUtils.isEmpty(this.f6890q)) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }
}
