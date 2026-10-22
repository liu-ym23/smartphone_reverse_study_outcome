package com.stepos.common.widget;

import O6.s;
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
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$drawable;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$style;
import com.stepos.common.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class EmptyView extends FrameLayout {
    private boolean ignoreSoftInput;
    private LimitedWHLinearLayout mContentPanel;
    private Context mContext;
    private View mDividerView;
    private ImageView mImageView;
    private boolean mIsShowDot;
    private CharSequence mSummary;
    private int mSummaryTextColor;
    private TextView mSummaryView;
    private int mThemeColor;
    private ArrayList<String> mTips;
    private LinearLayout mTipsPanle;
    private CharSequence mTitle;
    private RelativeLayout mTitleLayout;
    private int mTitleLayoutHeight;
    private TextView mTitleView;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: com.stepos.common.widget.EmptyView$a$a, reason: collision with other inner class name */
        public class RunnableC0350a implements Runnable {
            public RunnableC0350a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.mSummaryView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            EmptyView.this.mSummaryView.getViewTreeObserver().removeOnPreDrawListener(this);
            EmptyView.this.mSummaryView.post(new RunnableC0350a());
            return true;
        }
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        if (!TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSummary) && ((arrayList2 = this.mTips) == null || arrayList2.size() == 0)) {
            TextView textView = this.mTitleView;
            textView.setPadding(textView.getPaddingLeft(), getResources().getDimensionPixelSize(R$dimen.mc_empty_tip_line_space), this.mTitleView.getPaddingRight(), this.mTitleView.getPaddingBottom());
        } else {
            if (TextUtils.isEmpty(this.mTitle) || (arrayList = this.mTips) == null || arrayList.size() <= 0) {
                return;
            }
            ((LinearLayout.LayoutParams) this.mTitleView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R$dimen.mc_empty_title_margin_top);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EmptyView.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mImageView.getDrawable() != null) {
            return;
        }
        this.mTitleLayoutHeight = (int) (((RelativeLayout) this.mTitleLayout.getParent()).getMeasuredHeight() * 0.48d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = this.mTitleLayoutHeight;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setContentPanelMaxWidth(int i10) {
        this.mContentPanel.setMaxWidth(i10);
    }

    public void setEmptyMarginBottom(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i10;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setEmptyMarginTop(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.topMargin = i10;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setIgnoreSoftInput(boolean z10) {
        this.ignoreSoftInput = z10;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentPanel.getLayoutParams();
        if (z10) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_keyboard_approximate_height);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i10) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setIsShowDot(boolean z10) throws Resources.NotFoundException {
        if (this.mIsShowDot != z10) {
            this.mIsShowDot = z10;
            setTextOfTips(this.mTips);
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mSummaryView.setVisibility(8);
            return;
        }
        this.mSummary = charSequence;
        this.mSummaryView.setText(charSequence);
        this.mSummaryView.setAutoLinkMask(15);
        ViewTreeObserver viewTreeObserver = this.mSummaryView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new a());
        } else {
            this.mSummaryView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.mSummaryView.setLinkTextColor(this.mThemeColor);
        this.mSummaryView.setVisibility(0);
        ArrayList<String> arrayList = this.mTips;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.mDividerView.setVisibility(0);
    }

    public void setSummaryColor(int i10) {
        this.mSummaryView.setTextColor(i10);
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
            this.mTitleView.setVisibility(8);
            return;
        }
        this.mTitle = charSequence;
        this.mTitleView.setText(charSequence);
        this.mTitleView.setVisibility(0);
        ArrayList<String> arrayList = this.mTips;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.mDividerView.setVisibility(0);
    }

    public void setTitleColor(int i10) {
        this.mTitleView.setTextColor(i10);
    }

    public void setTitleTextSize(float f10) {
        this.mTitleView.setTextSize(f10);
    }

    public EmptyView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.mc_empty_view, (ViewGroup) null);
        this.mImageView = (ImageView) viewInflate.findViewById(R$id.empty_image);
        this.mTitleView = (TextView) viewInflate.findViewById(R$id.empty_title);
        this.mSummaryView = (TextView) viewInflate.findViewById(R$id.empty_summary);
        this.mTipsPanle = (LinearLayout) viewInflate.findViewById(R$id.empty_tips_panel);
        this.mDividerView = viewInflate.findViewById(R$id.titleDivider);
        this.mContentPanel = (LimitedWHLinearLayout) viewInflate.findViewById(R$id.content_panel);
        this.mTitleLayout = (RelativeLayout) viewInflate.findViewById(R$id.layout);
        addView(viewInflate);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mImageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentPanel.getLayoutParams();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmptyView, R$attr.StepOSCommon_EmptyViewStyle, 0);
        layoutParams.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.EmptyView_mcTopMarginOfImage, 0);
        layoutParams2.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.EmptyView_mcTopMarginOfTips, 0);
        this.mContentPanel.setMaxWidth(this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_empty_content_panel_max_width));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.EmptyView_mcSrcOfImage);
        if (drawable != null) {
            this.mImageView.setImageDrawable(drawable);
        }
        this.mTitle = typedArrayObtainStyledAttributes.getString(R$styleable.EmptyView_mcTitle);
        this.mSummary = typedArrayObtainStyledAttributes.getString(R$styleable.EmptyView_mcSummary);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.EmptyView_mcTextOfTips);
        this.mTips = s.e(getContext(), typedArrayObtainStyledAttributes, R$styleable.EmptyView_mcTips);
        this.mIsShowDot = typedArrayObtainStyledAttributes.getBoolean(R$styleable.EmptyView_mcIsShowDot, true);
        try {
            this.mSummaryView.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(R$styleable.EmptyView_mcSummaryTextAppearance, R$style.TextAppearance_Small_EmptyView_Summary));
            this.mTitleView.setTextAppearance(getContext(), typedArrayObtainStyledAttributes.getResourceId(R$styleable.EmptyView_mcTitleTextAppearance, R$style.TextAppearance_Small_EmptyView_Title));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        typedArrayObtainStyledAttributes.recycle();
        int iC = s.c(R$attr.colorPrimary, getContext());
        this.mThemeColor = androidx.core.content.a.c(getContext(), R$color.fd_sys_color_primary_blue);
        if (iC != 0) {
            this.mThemeColor = androidx.core.content.a.c(getContext(), iC);
        }
        setTitle(this.mTitle);
        setSummary(this.mSummary);
        if (string == null) {
            setTextOfTips(this.mTips);
        } else {
            setTextOfTips(string);
        }
        b();
    }

    public void setTextOfTips(ArrayList<String> arrayList) throws Resources.NotFoundException {
        this.mTips = arrayList == null ? new ArrayList<>() : arrayList;
        this.mTipsPanle.removeAllViews();
        ArrayList<String> arrayList2 = this.mTips;
        if (arrayList2 != null && arrayList2.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_empty_tip_margin_Bottom);
            layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_empty_dot_margin_top);
            layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_empty_dot_margin_right);
            float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_empty_tip_line_space);
            Drawable drawable = getContext().getResources().getDrawable(R$drawable.mc_default_word_point);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(48);
                if (this.mIsShowDot) {
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setLayoutParams(layoutParams2);
                    imageView.setImageDrawable(drawable);
                    linearLayout.addView(imageView);
                }
                TextView textView = new TextView(this.mContext);
                textView.setLayoutParams(layoutParams3);
                textView.setTextAppearance(getContext(), R$style.TextAppearance_Small_EmptyView);
                textView.setText(next);
                textView.setLineSpacing(dimensionPixelSize, 1.0f);
                linearLayout.addView(textView);
                this.mTipsPanle.addView(linearLayout);
            }
            if (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSummary)) {
                return;
            }
            this.mDividerView.setVisibility(0);
            return;
        }
        this.mDividerView.setVisibility(8);
    }
}
