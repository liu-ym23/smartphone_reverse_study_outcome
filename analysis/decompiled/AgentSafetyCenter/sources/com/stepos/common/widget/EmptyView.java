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
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class EmptyView extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f2586c;

    /* renamed from: f, reason: collision with root package name */
    public final LimitedWHLinearLayout f2587f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f2588g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f2589h;
    public final LinearLayout i;

    /* renamed from: j, reason: collision with root package name */
    public final View f2590j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f2591k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2592l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2593m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f2594n;

    /* renamed from: o, reason: collision with root package name */
    public int f2595o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f2596p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f2597q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2598r;

    public EmptyView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        ArrayList arrayList;
        ArrayList arrayList2;
        super(context, attributeSet, i);
        this.f2591k = context;
        ArrayList arrayList3 = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mc_empty_view, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_image);
        this.f2586c = imageView;
        this.f2588g = (TextView) viewInflate.findViewById(R.id.empty_title);
        this.f2589h = (TextView) viewInflate.findViewById(R.id.empty_summary);
        this.i = (LinearLayout) viewInflate.findViewById(R.id.empty_tips_panel);
        this.f2590j = viewInflate.findViewById(R.id.titleDivider);
        LimitedWHLinearLayout limitedWHLinearLayout = (LimitedWHLinearLayout) viewInflate.findViewById(R.id.content_panel);
        this.f2587f = limitedWHLinearLayout;
        this.f2594n = (RelativeLayout) viewInflate.findViewById(R.id.layout);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) limitedWHLinearLayout.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.f10199b, R.attr.StepOSCommon_EmptyViewStyle, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        limitedWHLinearLayout.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_empty_content_panel_max_width));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f2597q = typedArrayObtainStyledAttributes.getString(6);
        this.f2598r = typedArrayObtainStyledAttributes.getString(2);
        String string = typedArrayObtainStyledAttributes.getString(4);
        Context context2 = getContext();
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainStyledAttributes.getValue(5, typedValue)) {
            int i3 = typedValue.resourceId;
            if (i3 == 0) {
                od.f.e("can't find the resourceId");
                throw null;
            }
            TypedArray typedArrayObtainTypedArray = context2.getResources().obtainTypedArray(i3);
            int length = typedArrayObtainTypedArray.length();
            ArrayList arrayList4 = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList4.add(typedArrayObtainTypedArray.getString(i10));
            }
            typedArrayObtainTypedArray.recycle();
            arrayList3 = arrayList4;
        }
        this.f2596p = arrayList3;
        this.f2593m = typedArrayObtainStyledAttributes.getBoolean(0, true);
        try {
            this.f2589h.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(3, R.style.TextAppearance_Small_EmptyView_Summary));
            this.f2588g.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(7, R.style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iJ = t1.e.j(R.attr.colorPrimary, getContext());
        this.f2592l = getContext().getColor(R.color.fd_sys_color_primary_blue);
        if (iJ != 0) {
            this.f2592l = getContext().getColor(iJ);
        }
        setTitle(this.f2597q);
        setSummary(this.f2598r);
        if (string == null) {
            setTextOfTips(this.f2596p);
        } else {
            setTextOfTips(string);
        }
        TextView textView = this.f2588g;
        if (!TextUtils.isEmpty(this.f2597q) && TextUtils.isEmpty(this.f2598r) && ((arrayList2 = this.f2596p) == null || arrayList2.size() == 0)) {
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.f2597q) || (arrayList = this.f2596p) == null || arrayList.size() <= 0) {
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
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (this.f2586c.getDrawable() != null) {
            return;
        }
        RelativeLayout relativeLayout = this.f2594n;
        this.f2595o = (int) (((RelativeLayout) relativeLayout.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.f2595o;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i) {
        this.f2587f.setMaxWidth(i);
    }

    public void setEmptyMarginBottom(int i) {
        RelativeLayout relativeLayout = this.f2594n;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i) {
        RelativeLayout relativeLayout = this.f2594n;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i;
        relativeLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2587f.getLayoutParams();
        if (z10) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.f2591k.getResources().getDimensionPixelSize(R.dimen.mc_keyboard_approximate_height);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.f2586c;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i) {
        ImageView imageView = this.f2586c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setIsShowDot(boolean z10) throws Resources.NotFoundException {
        if (this.f2593m != z10) {
            this.f2593m = z10;
            setTextOfTips(this.f2596p);
        }
    }

    public void setSummary(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f2589h;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f2598r = charSequence;
        textView.setText(charSequence);
        textView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            aa.l lVar = new aa.l(2);
            lVar.f332f = this;
            VarHandle.storeStoreFence();
            viewTreeObserver.addOnPreDrawListener(lVar);
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setLinkTextColor(this.f2592l);
        textView.setVisibility(0);
        ArrayList arrayList = this.f2596p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f2590j.setVisibility(0);
    }

    public void setSummaryColor(int i) {
        this.f2589h.setTextColor(i);
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        ArrayList<String> arrayList2 = arrayList;
        this.f2596p = arrayList2 == null ? new ArrayList<>() : arrayList2;
        LinearLayout linearLayout = this.i;
        linearLayout.removeAllViews();
        ArrayList arrayList3 = this.f2596p;
        View view = this.f2590j;
        if (arrayList3 == null || arrayList3.size() == 0) {
            view.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        Context context = this.f2591k;
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_margin_Bottom);
        layoutParams2.topMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_top);
        layoutParams2.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_dot_margin_right);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mc_empty_tip_line_space);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.mc_default_word_point);
        int size = arrayList2.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            String str = arrayList2.get(i3);
            i3++;
            String str2 = str;
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(i);
            linearLayout2.setGravity(48);
            if (this.f2593m) {
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
            i = 0;
        }
        if (TextUtils.isEmpty(this.f2597q) && TextUtils.isEmpty(this.f2598r)) {
            return;
        }
        view.setVisibility(0);
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        TextView textView = this.f2588g;
        if (zIsEmpty) {
            textView.setVisibility(8);
            return;
        }
        this.f2597q = charSequence;
        textView.setText(charSequence);
        textView.setVisibility(0);
        ArrayList arrayList = this.f2596p;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f2590j.setVisibility(0);
    }

    public void setTitleColor(int i) {
        this.f2588g.setTextColor(i);
    }

    public void setTitleTextSize(float f5) {
        this.f2588g.setTextSize(f5);
    }

    public void setTextOfTips(String str) throws Resources.NotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        setTextOfTips(arrayList);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyView(Context context) {
        this(context, null);
    }
}
