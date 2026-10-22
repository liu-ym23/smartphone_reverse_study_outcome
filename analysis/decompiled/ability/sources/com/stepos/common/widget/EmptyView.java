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
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class EmptyView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f3707a;
    public final LimitedWHLinearLayout b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final View f;
    public final Context g;
    public final int h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f3708j;
    public int k;
    public ArrayList l;
    public CharSequence m;
    public CharSequence n;

    public EmptyView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ArrayList arrayList;
        ArrayList arrayList2;
        super(context, attributeSet, 0);
        this.g = context;
        ArrayList arrayList3 = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_image);
        this.f3707a = imageView;
        this.c = (TextView) viewInflate.findViewById(R.id.empty_title);
        this.d = (TextView) viewInflate.findViewById(R.id.empty_summary);
        this.e = (LinearLayout) viewInflate.findViewById(R.id.empty_tips_panel);
        this.f = viewInflate.findViewById(R.id.titleDivider);
        LimitedWHLinearLayout limitedWHLinearLayout = (LimitedWHLinearLayout) viewInflate.findViewById(R.id.content_panel);
        this.b = limitedWHLinearLayout;
        this.f3708j = (RelativeLayout) viewInflate.findViewById(R.id.layout);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) limitedWHLinearLayout.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.c, R.attr.StepOSCommon_EmptyViewStyle, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        limitedWHLinearLayout.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.m = typedArrayObtainStyledAttributes.getString(6);
        this.n = typedArrayObtainStyledAttributes.getString(2);
        String string = typedArrayObtainStyledAttributes.getString(4);
        Context context2 = getContext();
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainStyledAttributes.getValue(5, typedValue)) {
            int i = typedValue.resourceId;
            if (i == 0) {
                throw new IllegalStateException("can't find the resourceId");
            }
            TypedArray typedArrayObtainTypedArray = context2.getResources().obtainTypedArray(i);
            int length = typedArrayObtainTypedArray.length();
            ArrayList arrayList4 = new ArrayList(length);
            for (int i6 = 0; i6 < length; i6++) {
                arrayList4.add(typedArrayObtainTypedArray.getString(i6));
            }
            typedArrayObtainTypedArray.recycle();
            arrayList3 = arrayList4;
        }
        this.l = arrayList3;
        this.i = typedArrayObtainStyledAttributes.getBoolean(0, true);
        try {
            this.d.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, R.style.TextAppearance_Small_EmptyView_Summary));
            this.c.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(7, R.style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e) {
            e.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iE = a5.l.e(R.attr.colorPrimary, getContext());
        this.h = ContextCompat.getColor(getContext(), R.color.fd_sys_color_primary_blue);
        if (iE != 0) {
            this.h = ContextCompat.getColor(getContext(), iE);
        }
        setTitle(this.m);
        setSummary(this.n);
        if (string == null) {
            setTextOfTips(this.l);
        } else {
            setTextOfTips(string);
        }
        TextView textView = this.c;
        if (!TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.n) && ((arrayList2 = this.l) == null || arrayList2.size() == 0)) {
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.m) || (arrayList = this.l) == null || arrayList.size() <= 0) {
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
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        if (this.f3707a.getDrawable() != null) {
            return;
        }
        RelativeLayout relativeLayout = this.f3708j;
        this.k = (int) (((RelativeLayout) relativeLayout.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.k;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i) {
        this.b.setMaxWidth(i);
    }

    public void setEmptyMarginBottom(int i) {
        RelativeLayout relativeLayout = this.f3708j;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i) {
        RelativeLayout relativeLayout = this.f3708j;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        if (z10) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.g.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.f3707a;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i) {
        ImageView imageView = this.f3707a;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setIsShowDot(boolean z10) throws Resources.NotFoundException {
        if (this.i != z10) {
            this.i = z10;
            setTextOfTips(this.l);
        }
    }

    public void setSummary(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.d;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.n = charSequence;
        textView.setText(charSequence);
        textView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1114t(this, 0));
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setLinkTextColor(this.h);
        textView.setVisibility(0);
        ArrayList arrayList = this.l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f.setVisibility(0);
    }

    public void setSummaryColor(int i) {
        this.d.setTextColor(i);
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
        TextView textView = this.c;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.m = charSequence;
        textView.setText(charSequence);
        textView.setVisibility(0);
        ArrayList arrayList = this.l;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f.setVisibility(0);
    }

    public void setTitleColor(int i) {
        this.c.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.c.setTextSize(f);
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        this.l = arrayList == null ? new ArrayList<>() : arrayList;
        LinearLayout linearLayout = this.e;
        linearLayout.removeAllViews();
        ArrayList arrayList2 = this.l;
        View view = this.f;
        if (arrayList2 != null && arrayList2.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            Context context = this.g;
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
                if (this.i) {
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
            if (TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.n)) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }
}
